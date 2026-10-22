package com.ttnet.org.chromium.net.impl;

import android.os.Build;
import android.os.ConditionVariable;
import android.os.Process;
import android.util.Pair;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.ObserverList;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.net.BidirectionalStream;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.ExperimentalBidirectionalStream;
import com.ttnet.org.chromium.net.NetworkQualityRttListener;
import com.ttnet.org.chromium.net.NetworkQualityThroughputListener;
import com.ttnet.org.chromium.net.RequestFinishedInfo;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTEventListener;
import com.ttnet.org.chromium.net.TTMonitorProvider;
import com.ttnet.org.chromium.net.TTMpaService;
import com.ttnet.org.chromium.net.TTNetDiagnosisRequest;
import com.ttnet.org.chromium.net.TTSamplingSettingProvider;
import com.ttnet.org.chromium.net.TTThreadConfigInfoProvider;
import com.ttnet.org.chromium.net.TTWebsocketConnection;
import com.ttnet.org.chromium.net.UrlRequest;
import com.ttnet.org.chromium.net.urlconnection.CronetHttpURLConnection;
import com.ttnet.org.chromium.net.urlconnection.CronetURLStreamHandlerFactory;
import java.io.File;
import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandlerFactory;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@JNINamespace("cronet")
public class CronetUrlRequestContext extends CronetEngineBase {
    private static final int LOG_DEBUG = -1;
    private static final int LOG_NONE = 3;
    static final String LOG_TAG = null;
    private static final int LOG_VERBOSE = -2;
    private static final HashSet<String> sInUseStoragePaths = null;
    private final AtomicInteger mActiveRequestCount;
    private TTAppInfoProvider mAppInfoProvider;
    private TTMonitorProvider mAppMonitorProvider;
    private final int mCronetEngineId;
    private double[] mDownstreamPacketLossRate;
    private double[] mDownstreamPacketLossRateVariance;
    private int mDownstreamThroughputKbps;
    private int mEffectiveConnectionType;
    private int mEffectiveHrttMs;
    private int mEffectiveRxThroughputKbps;
    private int mEffectiveTrttMs;
    private TTEventListener mEventListener;
    private final Object mFinishedListenerLock;
    private final Map<RequestFinishedInfo.Listener, VersionSafeCallbacks.RequestFinishedInfoListener> mFinishedListenerMap;
    private int[] mGroupHttpRttMs;
    private int[] mGroupTransportRttMs;
    private int mHttpRttMs;
    private final String mInUseStoragePath;
    private final ConditionVariable mInitCompleted;
    private boolean mIsLogging;
    private boolean mIsStoppingNetLog;
    private boolean mListenAppStateIndependently;
    private final Object mLock;
    private final CronetLogger mLogger;
    private long mNetworkHandle;
    private final boolean mNetworkQualityEstimatorEnabled;
    private final Object mNetworkQualityLevelLock;
    private final Object mNetworkQualityLock;
    private Thread mNetworkThread;
    private int mNql;
    private final ObserverList<VersionSafeCallbacks.NetworkQualityRttListenerWrapper> mRttListenerList;
    private final boolean mSkipLogging;
    private final ConditionVariable mStopNetLogCompleted;
    private TTThreadConfigInfoProvider.Callback mThreadConfigCallback;
    private Map<TTThreadConfigInfoProvider.ThreadType, TTThreadConfigInfoProvider.BindCore> mThreadTypeBindCoreMap;
    private final Object mThreadTypeIdLock;
    private Map<TTThreadConfigInfoProvider.ThreadType, Integer> mThreadTypeIdMap;
    private final ObserverList<VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper> mThroughputListenerList;
    private int mTransportRttMs;
    private double[] mUpstreamPacketLossRate;
    private double[] mUpstreamPacketLossRateVariance;
    private long mUrlRequestContextAdapter;
    private String[] mWatchingGroups;

    static {
        LOG_TAG = "CronetUrlRequestContext";
        sInUseStoragePaths = new HashSet();
    }

    public static CronetLogger.CronetSource getCronetSource() {
        if (CronetEngine.class.getClassLoader().equals(CronetUrlRequest.class.getClassLoader()) == false) goto L6;
        return CronetLogger.CronetSource.CRONET_SOURCE_STATICALLY_LINKED;
    L6:
        return CronetLogger.CronetSource.CRONET_SOURCE_PLAY_SERVICES;
    }

    private int getLoggingLevel() {
        String r0 = LOG_TAG;
        if (Log.isLoggable(r0, 2) == false) goto L6;
        return LOG_VERBOSE;
    L6:
        if (Log.isLoggable(r0, 3) == false) goto L8;
        return -1;
    L8:
        return 3;
    }

    private boolean haveRequestContextAdapter() {
        if (this.mUrlRequestContextAdapter == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void onColdStartFinish() {
        TTEventListener r0 = this.mEventListener;
        if (r0 == null) goto L6;
        r0.onColdStartFinish();
        return;
    }

    private TTAppInfoProvider.AppInfo onGetAppInfo() {
        TTAppInfoProvider r0 = this.mAppInfoProvider;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getAppInfo();
    }

    private void onTLBDecompressFail() {
        TTEventListener r0 = this.mEventListener;
        if (r0 == null) goto L6;
        r0.onTLBDecompressFail();
        return;
    }

    public void clearClientOpaqueData() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CronetUrlRequestContextJni.get().clearClientOpaqueData(this.mUrlRequestContextAdapter, this);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public TTMpaService createTTMpaService() {
        return new TTCronetMpaService(this);
    }

    public URLStreamHandlerFactory createURLStreamHandlerFactory() {
        return new CronetURLStreamHandlerFactory(this);
    }

    public int getDownstreamThroughputKbps() {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L16;
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
        int r1 = this.mDownstreamThroughputKbps;     // Catch: Throwable -> L12
        if (r1 != (-1)) goto L10;
        r1 = -1;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    public int getEffectiveConnectionType() {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L13;
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
        int r1 = this.mEffectiveConnectionType;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    public int getEffectiveHttpRtt() {
        Object r0 = this.mNetworkQualityLevelLock;
        monitor-enter(r0);
        int r1 = this.mEffectiveHrttMs;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int getEffectiveRxThroughput() {
        Object r0 = this.mNetworkQualityLevelLock;
        monitor-enter(r0);
        int r1 = this.mEffectiveRxThroughputKbps;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public int getEffectiveTransportRtt() {
        Object r0 = this.mNetworkQualityLevelLock;
        monitor-enter(r0);
        int r1 = this.mEffectiveTrttMs;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public Map<String, int[]> getGroupRttEstimates() {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L20;
        HashMap r0 = new HashMap();
        Object r1 = this.mNetworkQualityLock;
        monitor-enter(r1);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (this.mWatchingGroups != null) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L16
        return r0;
    L10:
        int r3 = 0;
    L11:
        String[] r4 = this.mWatchingGroups;     // Catch: Throwable -> L16
        if (r3 >= r4.length) goto L14;
        r0.put(r4[r3], new int[]{this.mGroupTransportRttMs[r3], this.mGroupHttpRttMs[r3]});     // Catch: Throwable -> L16
        r3 = r3 + 1;     // Catch: Throwable -> L16
        goto L11
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L16
        return r0;
    L20:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    public int getHttpRttMs() {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L16;
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
        int r1 = this.mHttpRttMs;     // Catch: Throwable -> L12
        if (r1 != (-1)) goto L10;
        r1 = -1;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    public int getNetworkQualityLevel() {
        Object r0 = this.mNetworkQualityLevelLock;
        monitor-enter(r0);
        int r1 = this.mNql;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public List<Long> getOpaqueFuncAddress() {
        ArrayList r0 = new ArrayList();
        Object r1 = this.mLock;
        monitor-enter(r1);
        long[] r2 = CronetUrlRequestContextJni.get().getOpaqueFuncAddress();     // Catch: Throwable -> L9
        int r3 = r2.length;     // Catch: Throwable -> L9
        int r4 = 0;
    L5:
        if (r4 >= r3) goto L7;
        r0.add(Long.valueOf(r2[r4]));     // Catch: Throwable -> L9
        r4 = r4 + 1;     // Catch: Throwable -> L9
        goto L5
    L7:
        monitor-exit(r1);     // Catch: Throwable -> L9
        return r0;
    L9:
        th = move-exception;
        throw th;
    }

    public int getTransportRttMs() {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L16;
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
        int r1 = this.mTransportRttMs;     // Catch: Throwable -> L12
        if (r1 != (-1)) goto L10;
        r1 = -1;
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return r1;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    public long getUrlRequestContextAdapter() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkHaveAdapter();     // Catch: Throwable -> L7
        long r1 = this.mUrlRequestContextAdapter;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public String getVersionString() {
        return "Cronet/" + ImplVersion.getCronetVersionWithLastChange();
    }

    public boolean hasRequestFinishedListener() {
        Object r0 = this.mFinishedListenerLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mFinishedListenerMap.isEmpty() == true) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public void onRequestDestroyed() {
        this.mActiveRequestCount.decrementAndGet();
    }

    public void onRequestStarted() {
        this.mActiveRequestCount.incrementAndGet();
    }

    public void setCookieInitCompleted() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CronetUrlRequestContextJni.get().setCookieInitCompleted(this.mUrlRequestContextAdapter, this);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void shutdown() {
        if (this.mInUseStoragePath == null) goto L12;
        HashSet<String> r0 = sInUseStoragePaths;
        monitor-enter(r0);
        r0.remove(this.mInUseStoragePath);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L12:
        Object r1 = this.mLock;
        monitor-enter(r1);
        checkHaveAdapter();     // Catch: Throwable -> L35
        if (this.mActiveRequestCount.get() != 0) goto L34;
        if (ThreadMethodProxy.currentThread() == this.mNetworkThread) goto L32;
        monitor-exit(r1);     // Catch: Throwable -> L35
        this.mInitCompleted.block();
        stopNetLog();
        Object r2 = this.mLock;
        monitor-enter(r2);
    L28:
        th = move-exception;
        throw th;
    L22:
        if (haveRequestContextAdapter() == true) goto L25;
        monitor-exit(r2);     // Catch: Throwable -> L28
        return;
    L25:
        CronetUrlRequestContextJni.get().destroy(this.mUrlRequestContextAdapter, this);     // Catch: Throwable -> L28
        this.mUrlRequestContextAdapter = 0;     // Catch: Throwable -> L28
        monitor-exit(r2);     // Catch: Throwable -> L28
        return;
    L32:
        throw new IllegalThreadStateException("Cannot shutdown from network thread.");     // Catch: Throwable -> L35
    L34:
        throw new IllegalStateException("Cannot shutdown with active requests.");     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;
    }

    public void stopNetLog() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkHaveAdapter();     // Catch: Throwable -> L22
        if (this.mIsLogging == true) goto L7;
    L20:
        monitor-exit(r0);     // Catch: Throwable -> L22
        return;
    L7:
        if (this.mIsStoppingNetLog == true) goto L20;
        CronetUrlRequestContextJni.get().stopNetLog(this.mUrlRequestContextAdapter, this);     // Catch: Throwable -> L22
        this.mIsStoppingNetLog = true;     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
        this.mStopNetLogCompleted.block();
        this.mStopNetLogCompleted.close();
        Object r1 = this.mLock;
        monitor-enter(r1);
        this.mIsStoppingNetLog = false;     // Catch: Throwable -> L17
        this.mIsLogging = false;     // Catch: Throwable -> L17
        monitor-exit(r1);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        throw th;
    L22:
        th = move-exception;
        throw th;
    }

    public void stopNetLogCompleted() {
        this.mStopNetLogCompleted.open();
    }

    private CronetLogger.CronetVersion buildCronetVersion() {
        return new CronetLogger.CronetVersion(getVersionString().split("/")[1].split("@")[0]);
    }

    private void checkHaveAdapter() throws IllegalStateException {
        if (haveRequestContextAdapter() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Engine is shut down.");
    }

    private void initNetworkThread() {
        this.mNetworkThread = ThreadMethodProxy.currentThread();
        this.mInitCompleted.open();
        ThreadMethodProxy.setName(ThreadMethodProxy.currentThread(), "ChromiumNet" + Process.getThreadPriority(0));
        TTEventListener r0 = this.mEventListener;
        if (r0 == null) goto L6;
        r0.onCronetBootSucceed();
        return;
    }

    public byte[] getGlobalMetricsDeltas() {
        return CronetUrlRequestContextJni.get().getHistogramDeltas();
    }

    public int getCronetEngineId() {
        return this.mCronetEngineId;
    }

    public CronetLogger getCronetLogger() {
        return this.mLogger;
    }

    public CronetUrlRequestContext(CronetEngineBuilderImpl r10) {
        Object r0 = new Object();
        this.mLock = r0;
        this.mInitCompleted = new ConditionVariable(false);
        this.mActiveRequestCount = new AtomicInteger(0);
        this.mNetworkQualityLock = new Object();
        this.mFinishedListenerLock = new Object();
        this.mEffectiveConnectionType = 0;
        this.mHttpRttMs = -1;
        this.mTransportRttMs = -1;
        this.mDownstreamThroughputKbps = -1;
        ObserverList<VersionSafeCallbacks.NetworkQualityRttListenerWrapper> r3 = new ObserverList();
        this.mRttListenerList = r3;
        ObserverList<VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper> r4 = new ObserverList();
        this.mThroughputListenerList = r4;
        this.mFinishedListenerMap = new HashMap();
        this.mNetworkQualityLevelLock = new Object();
        this.mEffectiveHrttMs = -1;
        this.mEffectiveTrttMs = -1;
        this.mEffectiveRxThroughputKbps = -1;
        this.mUpstreamPacketLossRate = new double[]{-1.0d, -1.0d};
        this.mUpstreamPacketLossRateVariance = new double[]{-1.0d, -1.0d};
        this.mDownstreamPacketLossRate = new double[]{-1.0d, -1.0d};
        this.mDownstreamPacketLossRateVariance = new double[]{-1.0d, -1.0d};
        Object r1 = new Object();
        this.mThreadTypeIdLock = r1;
        this.mThreadTypeIdMap = new HashMap();
        this.mThreadTypeBindCoreMap = new HashMap();
        this.mStopNetLogCompleted = new ConditionVariable();
        this.mNetworkHandle = -1;
        this.mCronetEngineId = hashCode();
        r3.disableThreadAsserts();
        r4.disableThreadAsserts();
        this.mNetworkQualityEstimatorEnabled = r10.networkQualityEstimatorEnabled();
        CronetLibraryLoader.ensureInitialized(r10.getContext(), r10);
        CronetUrlRequestContextJni.get().setMinLogLevel(getLoggingLevel());
        if (r10.httpCacheMode() != 1) goto L16;
        String r5 = r10.storagePath();
        this.mInUseStoragePath = r5;
        HashSet<String> r6 = sInUseStoragePaths;
        monitor-enter(r6);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (r6.add(r5) == false) goto L11;
        monitor-exit(r6);     // Catch: Throwable -> L14
    L17:
        this.mAppInfoProvider = r10.getAppInfoProvider();
        this.mAppMonitorProvider = r10.getAppMonitorProvider();
        this.mEventListener = r10.getEventListener();
        this.mListenAppStateIndependently = r10.getListenAppStateIndependently();
        monitor-enter(r1);
        this.mThreadConfigCallback = r10.threadConfigCallbackImpl();     // Catch: Throwable -> L40
        monitor-exit(r1);     // Catch: Throwable -> L40
        monitor-enter(r0);
        long r7 = CronetUrlRequestContextJni.get().createRequestContextAdapter(createNativeUrlRequestContextConfig(r10));     // Catch: Throwable -> L37
        this.mUrlRequestContextAdapter = r7;     // Catch: Throwable -> L37
        if (r7 == 0) goto L36;
        boolean r2 = CronetUrlRequestContextJni.get().skipLogging(this.mUrlRequestContextAdapter, this);     // Catch: Throwable -> L37
        this.mSkipLogging = r2;     // Catch: Throwable -> L37
        monitor-exit(r0);     // Catch: Throwable -> L37
        if (r2 == false) goto L28;
        this.mLogger = CronetLoggerFactory.createNoOpLogger();
    L47:
        this.mLogger.logCronetEngineCreation(getCronetEngineId(), new CronetLogger.CronetEngineBuilderInfo(r10), buildCronetVersion(), getCronetSource());     // Catch: RuntimeException -> L31
    L33:
        CronetLibraryLoader.postToInitThread(new AnonymousClass1(this));
        return;
    L31:
        e = move-exception;
        Log.e(LOG_TAG, "Error while trying to log CronetEngine creation: ", new Object[]{e});
        goto L33
    L28:
        this.mLogger = CronetLoggerFactory.createLogger(r10.getContext(), getCronetSource());
        goto L47
    L36:
        throw new NullPointerException("Context Adapter creation failed.");     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        throw th;
    L40:
        th = move-exception;
        throw th;
    L11:
        throw new IllegalStateException("Disk cache storage path already in use");     // Catch: Throwable -> L14
    L16:
        this.mInUseStoragePath = null;
        goto L17
    }

    public static /* synthetic */ boolean access$000(CronetUrlRequestContext r0) {
        return r0.mListenAppStateIndependently;
    }

    public static /* synthetic */ Object access$100(CronetUrlRequestContext r0) {
        return r0.mLock;
    }

    public static /* synthetic */ long access$200(CronetUrlRequestContext r2) {
        return r2.mUrlRequestContextAdapter;
    }

    private String constructControlHeaders(Map<String, String> r5) {
        String r0 = XmlPullParser.NO_NAMESPACE;
        if (r5 == null) goto L12;
        Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L12;
        Map.Entry<String, String> r1 = r6.next();
        String r2 = r1.getKey();
        String r3 = r1.getValue();
        if (r2.isEmpty() == true) goto L6;
        if (r3.isEmpty() == true) goto L6;
        r0 = r2 + ":" + r3 + "\r\n" + r0;
    L12:
        return r0;
    }

    private static int convertConnectionTypeToApiValue(int r3) {
        if (r3 == 0) goto L17;
        int r0 = 1;
        if (r3 == 1) goto L16;
        r0 = 2;
        if (r3 == 2) goto L16;
        r0 = 3;
        if (r3 == 3) goto L16;
        r0 = 4;
        if (r3 == 4) goto L16;
        if (r3 != 5) goto L15;
        return 5;
    L15:
        throw new RuntimeException("Internal Error: Illegal EffectiveConnectionType value " + r3);
    L16:
        return r0;
    L17:
        return 0;
    }

    public static long createNativeUrlRequestContextConfig(CronetEngineBuilderImpl r35) {
        String r0 = XmlPullParser.NO_NAMESPACE;
        File r1 = r35.getContext().getFilesDir();     // Catch: Throwable -> L7
        if (r1 == null) goto L8;
        r0 = r1.getAbsolutePath();     // Catch: Throwable -> L7
    L8:
        String r7 = r0;
        long r33 = CronetUrlRequestContextJni.get().createRequestContextConfig(r35.getUserAgent(), r35.storagePath(), r35.quicEnabled(), r35.getDefaultQuicUserAgentId(), r35.http2Enabled(), r35.brotliEnabled(), r35.cacheDisabled(), r35.httpCacheMode(), r35.httpCacheMaxSize(), r35.experimentalOptions(), r35.mockCertVerifier(), r35.networkQualityEstimatorEnabled(), r35.publicKeyPinningBypassForLocalTrustAnchorsEnabled(), r35.threadPriority(0));
        if (r33 == 0) goto L41;
        Iterator<CronetEngineBuilderImpl.QuicHint> r2 = r35.quicHints().iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        CronetEngineBuilderImpl.QuicHint r3 = r2.next();
        CronetUrlRequestContextJni.get().addQuicHint(r33, r3.mHost, r3.mPort, r3.mAlternatePort);
        goto L12
    L14:
        Iterator<CronetEngineBuilderImpl.Pkp> r4 = r35.publicKeyPins().iterator();
    L16:
        if (r4.hasNext() == false) goto L18;
        CronetEngineBuilderImpl.Pkp r5 = r4.next();
        CronetUrlRequestContextJni.get().addPkp(r33, r5.mHost, r5.mHashes, r5.mIncludeSubdomains, r5.mExpirationDate.getTime());
        goto L16
    L18:
        ArrayList<byte[]> r6 = r35.getOpaqueData();
        if (r6 != null) goto L21;
    L23:
        byte[][] r13 = null;
    L24:
        ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r8 = r35.threadConfigInfoList();
        if (r8 != null) goto L27;
    L29:
        TTThreadConfigInfoProvider.ThreadConfigInfo[] r14 = null;
    L30:
        CronetUrlRequestContextJni.get().setTTNetInitConfig(r33, r35.getAppSecurityLevel(), r35.httpDnsEnabled(), r35.verboseLogEnabled(), r7, r35.getProxyConfig(), r35.getGetDomainDefaultJSON(), r35.boeProxyEnabled(), r35.getBypassBOEJSON(), r35.getStoreIdcRuleJSON(), r13, r14, r35.tncSecureModeEnabled(), r35.isMainProcess(), r35.lazyInitIPC(), r35.processName(), r35.TTAppInfoSubset(), r35.ttnetInitStart(), r35.optInit(), r35.optNqeDefault(), r35.optNqePersist(), r35.samplingSetting(), r35.optStack(), r35.threadStackInitReason(), r35.getTelemetryOptionFlags());
        Map<String[], Pair<byte[], byte[]>> r9 = r35.getClientOpaqueData();
        if (r9 != null) goto L33;
    L38:
        CronetUrlRequestContextJni.get().initALogFuncAddr(r35.aLogFuncAddr());
        return r33;
    L33:
        if (r9.isEmpty() == true) goto L38;
        Iterator<Map.Entry<String[], Pair<byte[], byte[]>>> r10 = r9.entrySet().iterator();
    L36:
        if (r10.hasNext() == false) goto L38;
        Map.Entry<String[], Pair<byte[], byte[]>> r11 = r10.next();
        CronetUrlRequestContextJni.get().setClientOpaqueData(r33, r11.getKey(), (byte[]) r11.getValue().first, (byte[]) r11.getValue().second);
        goto L36
    L27:
        if (r8.isEmpty() == true) goto L29;
        r14 = (TTThreadConfigInfoProvider.ThreadConfigInfo[]) r8.toArray(new TTThreadConfigInfoProvider.ThreadConfigInfo[r8.size()]);
        goto L30
    L21:
        if (r6.isEmpty() == true) goto L23;
        r13 = (byte[][]) r6.toArray(new byte[r6.size()][]);
        goto L24
    L41:
        throw new IllegalArgumentException("Experimental options parsing failed.");
    }

    private void handleProtocolException(int r4) {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L12;
        if (r4 != 0) goto L6;
        return;
    L6:
        if (r4 != 1) goto L9;
        return;
    L9:
        throw new IllegalStateException("Error protocol: " + r4);
    L12:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    private void onClientIPChanged(String r2) {
        TTEventListener r0 = this.mEventListener;
        if (r0 == null) goto L6;
        r0.onClientIPChanged(r2);
        return;
    }

    private void onEffectiveConnectionTypeChanged(int r3) {
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
        this.mEffectiveConnectionType = r3;     // Catch: Throwable -> L9
        TTEventListener r1 = this.mEventListener;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.onEffectiveConnectionTypeChanged(r3);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void onNQLChanged(int r3) {
        Object r0 = this.mNetworkQualityLevelLock;
        monitor-enter(r0);
        this.mNql = r3;     // Catch: Throwable -> L9
        TTEventListener r1 = this.mEventListener;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.onNetworkQualityLevelChanged(r3);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void onNetworkQualityTypeChangedV3(int r2) {
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
        this.mEffectiveConnectionType = r2;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        TTEventListener r1 = this.mEventListener;
        if (r1 == null) goto L15;
        r1.onNetworkQualityTypeChangedV3(r2);
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void onTTNetDetectInfoChanged(String r2) {
        TTEventListener r0 = this.mEventListener;
        if (r0 == null) goto L6;
        r0.onTTNetDetectInfoChanged(r2);
        return;
    }

    private void onThreadIdChanged(int[] r8) {
        Object r0 = this.mThreadTypeIdLock;
        monitor-enter(r0);
        int r1 = 0;
    L29:
    L26:
        th = move-exception;
        throw th;
    L6:
        if (r1 >= (r8.length - 1)) goto L24;
        TTThreadConfigInfoProvider.ThreadType r2 = TTThreadConfigInfoProvider.ThreadType.values()[r8[r1]];     // Catch: Throwable -> L26
        int r4 = r8[r1 + 1];     // Catch: Throwable -> L26
        this.mThreadTypeIdMap.put(r2, Integer.valueOf(r4));     // Catch: Throwable -> L26
        if (this.mThreadTypeBindCoreMap.containsKey(r2) == true) goto L11;
    L23:
        r1 = r1 + 2;     // Catch: Throwable -> L26
        goto L29
    L11:
        if (this.mThreadConfigCallback == null) goto L23;
        int r3 = 6.$SwitchMap$com$ttnet$org$chromium$net$TTThreadConfigInfoProvider$BindCore[this.mThreadTypeBindCoreMap.get(r2).ordinal()];     // Catch: Throwable -> L26
        if (r3 != 1) goto L16;
        this.mThreadConfigCallback.bindBigCore(r4);     // Catch: Throwable -> L26
        goto L23
    L16:
        if (r3 != 2) goto L18;
        this.mThreadConfigCallback.bindLittleCore(r4);     // Catch: Throwable -> L26
        goto L23
    L18:
        if (r3 != 3) goto L23;
        this.mThreadConfigCallback.resetCoreBind(r4);     // Catch: Throwable -> L26
        goto L23
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L26
    }

    private void onUserSpecifiedNetworkEnabled(boolean r2) {
        TTEventListener r0 = this.mEventListener;
        if (r0 == null) goto L6;
        r0.onUserSpecifiedNetworkEnabled(r2);
        return;
    }

    public void addRequestFinishedListener(RequestFinishedInfo.Listener r4) {
        Object r0 = this.mFinishedListenerLock;
        monitor-enter(r0);
        this.mFinishedListenerMap.put(r4, new VersionSafeCallbacks.RequestFinishedInfoListener(r4));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addRttListener(NetworkQualityRttListener r7) {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L23;
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L7:
        if (this.mRttListenerList.isEmpty() == false) goto L16;
        Object r1 = this.mLock;     // Catch: Throwable -> L19
        monitor-enter(r1);     // Catch: Throwable -> L19
        checkHaveAdapter();     // Catch: Throwable -> L13
        CronetUrlRequestContextJni.get().provideRTTObservations(this.mUrlRequestContextAdapter, this, true);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L16:
        this.mRttListenerList.addObserver(new VersionSafeCallbacks.NetworkQualityRttListenerWrapper(r7));     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L23:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    public void addSamplingSetting(TTSamplingSettingProvider.TTSlaSamplingSetting r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkHaveAdapter();     // Catch: Throwable -> L7
        CronetUrlRequestContextJni.get().addSamplingSetting(this.mUrlRequestContextAdapter, this, r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addThroughputListener(NetworkQualityThroughputListener r7) {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L23;
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L7:
        if (this.mThroughputListenerList.isEmpty() == false) goto L16;
        Object r1 = this.mLock;     // Catch: Throwable -> L19
        monitor-enter(r1);     // Catch: Throwable -> L19
        checkHaveAdapter();     // Catch: Throwable -> L13
        CronetUrlRequestContextJni.get().provideThroughputObservations(this.mUrlRequestContextAdapter, this, true);     // Catch: Throwable -> L13
        monitor-exit(r1);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L16:
        this.mThroughputListenerList.addObserver(new VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper(r7));     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L23:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    public void bindBigCore(int r4) {
        Object r0 = this.mThreadTypeIdLock;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mThreadConfigCallback != null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L8:
        TTThreadConfigInfoProvider.ThreadType r5 = TTThreadConfigInfoProvider.ThreadType.values()[r4];     // Catch: Throwable -> L16
        if (this.mThreadTypeIdMap.containsKey(r5) == false) goto L13;
        this.mThreadConfigCallback.bindBigCore(this.mThreadTypeIdMap.get(r5).intValue());     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L13:
        this.mThreadTypeBindCoreMap.put(r5, TTThreadConfigInfoProvider.BindCore.BIG_CORE);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
    }

    public void bindLittleCore(int r4) {
        Object r0 = this.mThreadTypeIdLock;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mThreadConfigCallback != null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L8:
        TTThreadConfigInfoProvider.ThreadType r5 = TTThreadConfigInfoProvider.ThreadType.values()[r4];     // Catch: Throwable -> L16
        if (this.mThreadTypeIdMap.containsKey(r5) == false) goto L13;
        this.mThreadConfigCallback.bindLittleCore(this.mThreadTypeIdMap.get(r5).intValue());     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L13:
        this.mThreadTypeBindCoreMap.put(r5, TTThreadConfigInfoProvider.BindCore.LITTLE_CORE);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
    }

    public void bindToNetwork(long r3) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        this.mNetworkHandle = r3;
        return;
    L7:
        throw new UnsupportedOperationException("The multi-network API is available starting from Android Marshmallow");
    }

    public double getDownstreamPacketLossRate(int r5) {
        handleProtocolException(r5);
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
        double r2 = this.mDownstreamPacketLossRate[r5];     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public double getDownstreamPacketLossRateVariance(int r5) {
        handleProtocolException(r5);
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
        double r2 = this.mDownstreamPacketLossRateVariance[r5];     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public double getUpstreamPacketLossRate(int r5) {
        handleProtocolException(r5);
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
        double r2 = this.mUpstreamPacketLossRate[r5];     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public double getUpstreamPacketLossRateVariance(int r5) {
        handleProtocolException(r5);
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
        double r2 = this.mUpstreamPacketLossRateVariance[r5];     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isNetworkThread(Thread r2) {
        if (r2 != this.mNetworkThread) goto L5;
        return true;
    L5:
        return false;
    }

    public URLConnection openConnection(URL r2) {
        return openConnection(r2, Proxy.NO_PROXY);
    }

    public void registerAppInfoProvider(TTAppInfoProvider r1) {
        this.mAppInfoProvider = r1;
    }

    public void registerAppMonitorProvider(TTMonitorProvider r1) {
        this.mAppMonitorProvider = r1;
    }

    public void registerEventListener(TTEventListener r1) {
        this.mEventListener = r1;
    }

    public void removeClientOpaqueData(String r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CronetUrlRequestContextJni.get().removeClientOpaqueData(this.mUrlRequestContextAdapter, this, r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeRequestFinishedListener(RequestFinishedInfo.Listener r3) {
        Object r0 = this.mFinishedListenerLock;
        monitor-enter(r0);
        this.mFinishedListenerMap.remove(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void removeRttListener(NetworkQualityRttListener r6) {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L24;
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (this.mRttListenerList.removeObserver(new VersionSafeCallbacks.NetworkQualityRttListenerWrapper(r6)) == true) goto L9;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L9:
        if (this.mRttListenerList.isEmpty() == false) goto L18;
        Object r7 = this.mLock;     // Catch: Throwable -> L20
        monitor-enter(r7);     // Catch: Throwable -> L20
        checkHaveAdapter();     // Catch: Throwable -> L15
        CronetUrlRequestContextJni.get().provideRTTObservations(this.mUrlRequestContextAdapter, this, false);     // Catch: Throwable -> L15
        monitor-exit(r7);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L24:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    public void removeThroughputListener(NetworkQualityThroughputListener r6) {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L24;
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (this.mThroughputListenerList.removeObserver(new VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper(r6)) == true) goto L9;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L20
        return;
    L9:
        if (this.mThroughputListenerList.isEmpty() == false) goto L18;
        Object r7 = this.mLock;     // Catch: Throwable -> L20
        monitor-enter(r7);     // Catch: Throwable -> L20
        checkHaveAdapter();     // Catch: Throwable -> L15
        CronetUrlRequestContextJni.get().provideThroughputObservations(this.mUrlRequestContextAdapter, this, false);     // Catch: Throwable -> L15
        monitor-exit(r7);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L24:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    public void reportNetDiagnosisUserLog(String r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CronetUrlRequestContextJni.get().reportNetDiagnosisUserLog(this.mUrlRequestContextAdapter, this, r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void reportRequestFinished(RequestFinishedInfo r4) {
        Object r0 = this.mFinishedListenerLock;
        monitor-enter(r0);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mFinishedListenerMap.isEmpty() == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L8:
        ArrayList r1 = new ArrayList(this.mFinishedListenerMap.values());     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        Iterator r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L14;
        VersionSafeCallbacks.RequestFinishedInfoListener r3 = (VersionSafeCallbacks.RequestFinishedInfoListener) r2.next();
        5 r5 = new 5(this, r3, r4);
        postObservationTaskToExecutor(r3.getExecutor(), r5);
        goto L12
    }

    public void resetCoreBind(int r4) {
        Object r0 = this.mThreadTypeIdLock;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mThreadConfigCallback != null) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L8:
        TTThreadConfigInfoProvider.ThreadType r5 = TTThreadConfigInfoProvider.ThreadType.values()[r4];     // Catch: Throwable -> L16
        if (this.mThreadTypeIdMap.containsKey(r5) == false) goto L13;
        this.mThreadConfigCallback.resetCoreBind(this.mThreadTypeIdMap.get(r5).intValue());     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L13:
        this.mThreadTypeBindCoreMap.put(r5, TTThreadConfigInfoProvider.BindCore.CANCEL_BIND);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
    }

    public void runInBackGround(boolean r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CronetUrlRequestContextJni.get().runInBackGround(this.mUrlRequestContextAdapter, this, r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setAlogFuncAddr(long r11) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        checkHaveAdapter();     // Catch: Throwable -> L7
        Log.e(LOG_TAG, "Set alog func addr: " + r11, new Object[0]);     // Catch: Throwable -> L7
        CronetUrlRequestContextJni.get().setAlogFuncAddr(this.mUrlRequestContextAdapter, this, r11);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setAppStartUpState(int r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CronetUrlRequestContextJni.get().setAppStartUpState(this.mUrlRequestContextAdapter, this, r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setHostResolverRules(String r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkHaveAdapter();     // Catch: Throwable -> L7
        CronetUrlRequestContextJni.get().setHostResolverRules(this.mUrlRequestContextAdapter, this, r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setProxy(String r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CronetUrlRequestContextJni.get().setProxy(this.mUrlRequestContextAdapter, this, r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void triggerGetDomain(boolean r5) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CronetUrlRequestContextJni.get().triggerTNCRequestByUser(this.mUrlRequestContextAdapter, this, r5);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private String[] addSecurityFactor(String r6, String[] r7) {
        HashMap r0 = new HashMap();
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r2 >= r7.length) goto L6;
        r0.put(r7[r2].toLowerCase(Locale.US), r7[r2 + 1]);
        r2 = r2 + 2;
        goto L4
    L6:
        Map<String, String> r8 = onCallToAddSecurityFactor(r6, r0);
        if (r8 != null) goto L10;
        return null;
    L10:
        String[] r9 = new String[r8.size() * 2];
        Iterator<Map.Entry<String, String>> r10 = r8.entrySet().iterator();
    L12:
        if (r10.hasNext() == false) goto L14;
        Map.Entry<String, String> r3 = r10.next();
        r9[r1] = r3.getKey();
        r9[r1 + 1] = r3.getValue();
        r1 = r1 + 2;
        goto L12
    L14:
        return r9;
    }

    private boolean handleApiSample(String r2, String r3) {
        TTMonitorProvider r0 = this.mAppMonitorProvider;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.handleApiSample(r2, r3);
    }

    private void onDropReasonChanged(boolean r2, int[] r3) {
        if (this.mEventListener == null) goto L9;
        List r0 = new ArrayList();
        if (r3 == null) goto L7;
        r0 = (List) Arrays.stream(r3).boxed().collect(Collectors.toList());
    L7:
        this.mEventListener.onDropReasonChanged(r2, r0);
        return;
    }

    private void onMultiNetworkStateChanged(int r2, int r3) {
        TTEventListener r0 = this.mEventListener;
        if (r0 == null) goto L6;
        r0.onMultiNetworkStateChanged(r2, r3);
        return;
    }

    private void onPublicIPsChanged(String[] r4, String[] r5) {
        if (this.mEventListener == null) goto L6;
        ArrayList r0 = new ArrayList(r4.length);
        ArrayList r1 = new ArrayList(r5.length);
        Collections.addAll(r0, r4);
        Collections.addAll(r1, r5);
        this.mEventListener.onPublicIPsChanged(r0, r1);
        return;
    }

    private void onSendAppMonitorEvent(String r2, String r3) {
        TTMonitorProvider r0 = this.mAppMonitorProvider;
        if (r0 == null) goto L6;
        r0.sendAppMonitorEvent(r2, r3);
        return;
    }

    private void onTNCUpdateFailed(String[] r2, String r3) {
        TTEventListener r0 = this.mEventListener;
        if (r0 == null) goto L6;
        r0.onTNCUpdateFailed(r2, r3);
        return;
    }

    private void onWiFiToCellStateChanged(int r2, int r3) {
        TTEventListener r0 = this.mEventListener;
        if (r0 == null) goto L6;
        r0.onWiFiToCellStateChanged(r2, r3);
        return;
    }

    private static void postObservationTaskToExecutor(Executor r2, Runnable r3) {
        r2.execute(r3);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(LOG_TAG, "Exception posting task to executor", new Object[]{e});
    }

    public Map<String, String> onCallToAddSecurityFactor(String r2, Map<String, String> r3) {
        TTEventListener r0 = this.mEventListener;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.onCallToAddSecurityFactor(r2, r3);
    }

    public String onRequestInterceptorJava(String r6, String[] r7) {
        if (this.mEventListener != null) goto L6;
        return null;
    L6:
        HashMap r0 = new HashMap();
        if (r7 == null) goto L13;
        int r1 = 0;
    L9:
        int r2 = r1 + 1;
        if (r2 >= r7.length) goto L13;
        r0.put(r7[r1].toLowerCase(Locale.US), r7[r2]);
        r1 = r1 + 2;
    L13:
        return this.mEventListener.onRequestInterceptorJava(r6, r0);
    }

    public URLConnection openConnection(URL r2, Proxy r3) {
        return openConnection(r2, r3, false);
    }

    public void setRouteSelectionBestHost(String r8, String r9) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CronetUrlRequestContextJni.get().setRouteSelectionBestHost(this.mUrlRequestContextAdapter, this, r8, r9);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void startNetLogToFile(String r8, boolean r9) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkHaveAdapter();     // Catch: Throwable -> L15
        if (this.mIsLogging == false) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L9:
        if (CronetUrlRequestContextJni.get().startNetLogToFile(this.mUrlRequestContextAdapter, this, r8, r9) == false) goto L14;
        this.mIsLogging = true;     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L14:
        throw new RuntimeException("Unable to start NetLog");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public void stopThrottle(String[] r8, int r9) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkHaveAdapter();     // Catch: Throwable -> L7
        CronetUrlRequestContextJni.get().stopThrottle(this.mUrlRequestContextAdapter, this, r8, r9);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onGroupRTTOrThroughputEstimatesComputed(String[] r2, int[] r3, int[] r4) {
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
        this.mWatchingGroups = r2;     // Catch: Throwable -> L7
        this.mGroupTransportRttMs = r3;     // Catch: Throwable -> L7
        this.mGroupHttpRttMs = r4;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onNetworkQualityRttAndThroughputNotified(int r3, int r4, int r5) {
        Object r0 = this.mNetworkQualityLevelLock;
        monitor-enter(r0);
        this.mEffectiveHrttMs = r3;     // Catch: Throwable -> L9
        this.mEffectiveTrttMs = r4;     // Catch: Throwable -> L9
        this.mEffectiveRxThroughputKbps = r5;     // Catch: Throwable -> L9
        TTEventListener r1 = this.mEventListener;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.onNetworkQualityRttAndThroughputNotified(r3, r4, r5);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void onRTTOrThroughputEstimatesComputed(int r3, int r4, int r5) {
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
        this.mHttpRttMs = r3;     // Catch: Throwable -> L9
        this.mTransportRttMs = r4;     // Catch: Throwable -> L9
        this.mDownstreamThroughputKbps = r5;     // Catch: Throwable -> L9
        TTEventListener r1 = this.mEventListener;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.onRTTOrThroughputEstimatesComputed(r3, r4, r5);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void onRttObservation(int r12, long r13, int r15) {
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
        Iterator r1 = this.mRttListenerList.iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L8;
        VersionSafeCallbacks.NetworkQualityRttListenerWrapper r2 = (VersionSafeCallbacks.NetworkQualityRttListenerWrapper) r1.next();     // Catch: Throwable -> L10
        3 r10 = new 3(this, r2, r12, r13, r15);     // Catch: Throwable -> L10
        postObservationTaskToExecutor(r2.getExecutor(), r10);     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void onTNCConfigChanged(String r2, String r3, String r4) {
        TTEventListener r0 = this.mEventListener;
        if (r0 == null) goto L6;
        r0.onServerConfigUpdated(r2, r3, r4);
        return;
    }

    private void onTNCRequestSucceeded(boolean r2, boolean r3, int r4) {
        TTEventListener r0 = this.mEventListener;
        if (r0 == null) goto L6;
        r0.onTncRequestSucceeded(r2, r3, r4);
        return;
    }

    private void onThroughputObservation(int r12, long r13, int r15) {
        Object r0 = this.mNetworkQualityLock;
        monitor-enter(r0);
        Iterator r1 = this.mThroughputListenerList.iterator();     // Catch: Throwable -> L10
    L6:
        if (r1.hasNext() == false) goto L8;
        VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper r2 = (VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper) r1.next();     // Catch: Throwable -> L10
        4 r10 = new 4(this, r2, r12, r13, r15);     // Catch: Throwable -> L10
        postObservationTaskToExecutor(r2.getExecutor(), r10);     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void configureNetworkQualityEstimatorForTesting(boolean r9, boolean r10, boolean r11) {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L13;
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkHaveAdapter();     // Catch: Throwable -> L9
        CronetUrlRequestContextJni.get().configureNetworkQualityEstimatorForTesting(this.mUrlRequestContextAdapter, this, r9, r10, r11);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    public ExperimentalBidirectionalStream.Builder newBidirectionalStreamBuilder(String r2, BidirectionalStream.Callback r3, Executor r4) {
        return new BidirectionalStreamBuilderImpl(r2, r3, r4, this);
    }

    public /* bridge */ /* synthetic */ UrlRequest.Builder newUrlRequestBuilder(String r1, UrlRequest.Callback r2, Executor r3) {
        return super.newUrlRequestBuilder(r1, r2, r3);
    }

    public String onRequestInterceptorToStart(String r6, String[] r7, String[] r8) {
        if (this.mEventListener != null) goto L6;
        return null;
    L6:
        HashMap r0 = new HashMap();
        int r1 = 0;
        int r2 = 0;
    L8:
        if (r2 >= r7.length) goto L10;
        r0.put(r7[r2].toLowerCase(Locale.US), r7[r2 + 1]);
        r2 = r2 + 2;
        goto L8
    L10:
        ArrayList r9 = new ArrayList();
    L12:
        if (r1 >= r8.length) goto L15;
        r9.add(r8[r1]);
        r1 = r1 + 1;
        goto L12
    L15:
        return this.mEventListener.onRequestInterceptorToStart(r6, r0, r9);
    }

    public String onResponseInterceptorToStart(String r6, String[] r7, int r8) {
        if (this.mEventListener != null) goto L6;
        return null;
    L6:
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L8:
        if (r1 >= r7.length) goto L10;
        r0.add(new AbstractMap.SimpleImmutableEntry(r7[r1].toLowerCase(Locale.US), r7[r1 + 1]));
        r1 = r1 + 2;
        goto L8
    L10:
        TreeMap r9 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Iterator r2 = r0.iterator();
    L12:
        if (r2.hasNext() == false) goto L18;
        Map.Entry r3 = (Map.Entry) r2.next();
        ArrayList r4 = new ArrayList();
        if (r9.containsKey(r3.getKey()) == false) goto L16;
        r4.addAll((Collection) r9.get(r3.getKey()));
    L16:
        r4.add((String) r3.getValue());
        r9.put((String) r3.getKey(), Collections.unmodifiableList(r4));
        goto L12
    L18:
        return this.mEventListener.onResponseInterceptorToStart(r6, r9, r8);
    }

    public URLConnection openConnection(URL r2, Proxy r3, boolean r4) {
        if (r3.type() != Proxy.Type.DIRECT) goto L14;
        String r5 = r2.getProtocol();
        if ("http".equals(r5) == true) goto L12;
        if ("https".equals(r5) == true) goto L12;
        throw new UnsupportedOperationException("Unexpected protocol:" + r5);
    L12:
        return new CronetHttpURLConnection(r2, this, r4);
    L14:
        throw new UnsupportedOperationException();
    }

    public void preconnectUrl(String r9, int r10, Map<String, String> r11) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkHaveAdapter();     // Catch: Throwable -> L7
        CronetUrlRequestContextJni.get().preconnectUrl(this.mUrlRequestContextAdapter, this, r9, r10, constructControlHeaders(r11));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setHttpDnsForTesting(boolean r9, boolean r10, boolean r11) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CronetUrlRequestContextJni.get().controlHttpDNSConfig(this.mUrlRequestContextAdapter, this, r9, r10, r11);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void startNetLogToDisk(String r9, boolean r10, int r11) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkHaveAdapter();     // Catch: Throwable -> L11
        if (this.mIsLogging == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        CronetUrlRequestContextJni.get().startNetLogToDisk(this.mUrlRequestContextAdapter, this, r9, r10, r11);     // Catch: Throwable -> L11
        this.mIsLogging = true;     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void startThrottle(String[] r10, int r11, long r12) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        checkHaveAdapter();     // Catch: Throwable -> L7
        CronetUrlRequestContextJni.get().startThrottle(this.mUrlRequestContextAdapter, this, r10, r11, r12);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void tryStartNetDetect(String[] r9, int r10, int r11) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CronetUrlRequestContextJni.get().tryStartNetDetect(this.mUrlRequestContextAdapter, this, r9, r10, r11);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public Map<String, String> ttUrlDispatch(String r10, int r11, boolean r12) throws IOException {
        URLDispatch r7 = new URLDispatch(r10);
        Object r8 = this.mLock;
        monitor-enter(r8);
        checkHaveAdapter();     // Catch: Throwable -> L8
        CronetUrlRequestContextJni.get().ttUrlDispatch(this.mUrlRequestContextAdapter, this, r7, r10, r12);     // Catch: Throwable -> L8
        monitor-exit(r8);     // Catch: Throwable -> L8
        r7.waitResult(r11);
        HashMap r13 = new HashMap();
        r13.put("final_url", r7.getFinalUrl());
        r13.put("epoch", r7.getEpoch());
        r13.put("etag", r7.getEtag());
        r13.put("ttnet_origin_host", r7.getTTNetOriginHost());
        return r13;
    L8:
        th = move-exception;
        throw th;
    }

    public void ttDnsResolve(String r10, int r11, String r12, Map<String, String> r13) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CronetUrlRequestContextJni.get().ttDnsResolve(this.mUrlRequestContextAdapter, this, r10, r11, r12, constructControlHeaders(r13));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onPacketLossComputed(int r14, double r15, double r17, double r19, double r21) {
        Object r12 = this.mNetworkQualityLock;
        monitor-enter(r12);
        if (r14 != 0) goto L6;
    L10:
        this.mUpstreamPacketLossRate[r14] = r15;     // Catch: Throwable -> L15
        this.mUpstreamPacketLossRateVariance[r14] = r17;     // Catch: Throwable -> L15
        this.mDownstreamPacketLossRate[r14] = r19;     // Catch: Throwable -> L15
        this.mDownstreamPacketLossRateVariance[r14] = r21;     // Catch: Throwable -> L15
        TTEventListener r2 = this.mEventListener;     // Catch: Throwable -> L15
        if (r2 == null) goto L13;
        r2.onPacketLossComputed(r14, r15, r17, r19, r21);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r12);     // Catch: Throwable -> L15
        return;
    L6:
        if (r14 == 1) goto L10;
        Log.e(LOG_TAG, "Error protocol from native. Protocol: " + r14, new Object[0]);     // Catch: Throwable -> L15
        monitor-exit(r12);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private void onUrlDispatchComplete(URLDispatch r1, String r2, String r3, String r4, String r5) {
        r1.setResult(r2, r3, r4, r5);
        r1.resume(new 2(this, r1));
    }

    public void addClientOpaqueData(String[] r15, byte[] r16, byte[] r17, long r18, long r20) {
        Object r13 = this.mLock;
        monitor-enter(r13);
        CronetUrlRequestContextJni.get().addClientOpaqueData(this.mUrlRequestContextAdapter, this, r15, r16, r17, r18, r20);     // Catch: Throwable -> L7
        monitor-exit(r13);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onStoreIdcChanged(String r8, String r9, String r10, String r11, String r12, String r13) {
        TTEventListener r0 = this.mEventListener;
        if (r0 == null) goto L6;
        r0.onStoreIdcChanged(r8, r9, r10, r11, r12, r13);
        return;
    }

    public TTWebsocketConnection createWebsocketConnection(TTWebsocketConnection.Callback r10, Executor r11, List<String> r12, Map<String, String> r13, Map<String, String> r14, boolean r15) {
        return new CronetWebsocketConnection(this, r10, r11, r12, r13, r14, r15);
    }

    public void enableTTBizHttpDns(boolean r14, String r15, String r16, String r17, boolean r18, String r19) {
        Object r12 = this.mLock;
        monitor-enter(r12);
        CronetUrlRequestContextJni.get().enableTTBizHttpDns(this.mUrlRequestContextAdapter, this, r14, r15, r16, r17, r18, r19);     // Catch: Throwable -> L7
        monitor-exit(r12);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void notifyTNCConfigUpdated(String r14, String r15, String r16, String r17, String r18, String r19) {
        Object r12 = this.mLock;
        monitor-enter(r12);
        CronetUrlRequestContextJni.get().parseTNCConfigFromSystemHTTPRequest(this.mUrlRequestContextAdapter, this, r14, r15, r16, r17, r18, r19);     // Catch: Throwable -> L7
        monitor-exit(r12);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onTTDnsResolveResult(String r13, String r14, int r15, int r16, int r17, String[] r18, String r19) {
        Log.d(LOG_TAG, " onTTDnsResolveResult, uuid: " + r13 + " host: " + r14 + " ret: " + r15 + " ips: " + r18.length, new Object[0]);
        ArrayList r10 = new ArrayList(r18.length);
        Collections.addAll(r10, r18);
        TTEventListener r4 = this.mEventListener;
        if (r4 == null) goto L6;
        r4.onTTDnsResolveResult(r13, r14, r15, r16, r17, r10, r19);
        return;
    }

    public TTNetDiagnosisRequest createNetDiagnosisRequest(TTNetDiagnosisRequest.Callback r11, Executor r12, int r13, List<String> r14, int r15, int r16, int r17) {
        return new TTCronetNetExpRequest(this, r11, r12, r13, r14, r15, r16, r17);
    }

    public void setZstdFuncAddr(long r23, long r25, long r28, long r29, long r31, long r33, long r35, long r37) {
        Object r13 = this.mLock;
        monitor-enter(r13);
        checkHaveAdapter();     // Catch: Throwable -> L9
        CronetUrlRequestContextJni.get().setZstdFuncAddr(this.mUrlRequestContextAdapter, this, r23, r25, r28, r29, r31, r33, r35, r37);     // Catch: Throwable -> L13
        monitor-exit(r13);     // Catch: Throwable -> L13
        return;
    L9:
        th = th;
    L11:
        monitor-exit(r13);     // Catch: Throwable -> L13
        throw th;
    L13:
        th = th;
        goto L11
    }

    public void updateStoreRegionFromServer(String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r28, String r29) {
        Object r14 = this.mLock;
        monitor-enter(r14);
        CronetUrlRequestContextJni.get().updateStoreRegionFromServer(this.mUrlRequestContextAdapter, this, r18, r19, r20, r21, r22, r23, r24, r25, r26, r28, r29);     // Catch: Throwable -> L13
        monitor-exit(r14);     // Catch: Throwable -> L13
        return;
    L9:
        th = th;
    L11:
        monitor-exit(r14);     // Catch: Throwable -> L13
        throw th;
    L13:
        th = th;
        goto L11
    }

    public ExperimentalBidirectionalStream createBidirectionalStream(String r20, BidirectionalStream.Callback r21, Executor r22, String r23, List<Map.Entry<String, String>> r24, int r25, boolean r26, Collection<Object> r28, boolean r29, int r210, boolean r30, int r31, long r32) {
        if (r32 != (-1)) goto L5;
        long r16 = this.mNetworkHandle;
    L6:
        Object r14 = this.mLock;
        monitor-enter(r14);
        checkHaveAdapter();     // Catch: Throwable -> L13
        CronetBidirectionalStream r0 = new CronetBidirectionalStream(this, r20, r25, r21, r22, r23, r24, r26, r28, r29, r210, r30, r31, r16);     // Catch: Throwable -> L17
        monitor-exit(r14);     // Catch: Throwable -> L17
        return r0;
    L17:
        th = th;
    L15:
        monitor-exit(r14);     // Catch: Throwable -> L17
        throw th;
    L13:
        th = th;
        goto L15
    L5:
        r16 = r32;
        goto L6
    }

    public TTWebsocketConnection createWebsocketConnection(TTWebsocketConnection.Callback r20, Executor r21, List<String> r22, int r23, String r24, long r25, int r28, long r29, String r30, int r31, String r32, Map<String, String> r33, Map<String, String> r34, boolean r35) {
        return new CronetWebsocketConnection(this, r20, r21, r22, r23, r24, r25, r28, r29, r30, r31, r32, r33, r34, r35);
    }

    public UrlRequestBase createRequest(String r21, UrlRequest.Callback r22, Executor r23, int r24, Collection<Object> r25, boolean r26, boolean r28, boolean r29, boolean r210, int r30, boolean r31, int r32, RequestFinishedInfo.Listener r33, int r34, long r35) {
        if (r35 != (-1)) goto L5;
        long r17 = this.mNetworkHandle;
    L6:
        Object r14 = this.mLock;
        monitor-enter(r14);
        checkHaveAdapter();     // Catch: Throwable -> L13
        CronetUrlRequest r0 = new CronetUrlRequest(this, r21, r24, r22, r23, r25, r26, r28, r29, r210, r30, r31, r32, r33, r34, r17);     // Catch: Throwable -> L17
        monitor-exit(r14);     // Catch: Throwable -> L17
        return r0;
    L17:
        th = th;
    L15:
        monitor-exit(r14);     // Catch: Throwable -> L17
        throw th;
    L13:
        th = th;
        goto L15
    L5:
        r17 = r35;
        goto L6
    }

    private void onContextInitCompleted(long r36, long r38, long r40, long r42, long r44, long r46, long r48, long r50, long r52, long r54, long r56, long r58, long r60, long r62, long r64, long r66, String r68, String r69) {
        TTCronetInitTimingInfo.sNativeInitTimingJson = r68;
        TTCronetInitTimingInfo.sABTest = r69;
        this.mInitCompleted.open();
        TTEventListener r2 = this.mEventListener;
        if (r2 == null) goto L6;
        r2.onContextInitCompleted(r36, r38, r40, r42, r44, r46, r48, r50, r52, r54, r56, r58, r60, r62, r64, r66);
        return;
    }

    private void handleApiResult(boolean r41, String r42, String r43, String r44, long r45, long r47, long r49, long r51, long r53, long r55, long r57, long r59, long r61, long r63, boolean r65, long r66, long r68, long r70, String r72, String r73, String r74, int r75, int r76, String r77, String r78) {
        TTMonitorProvider r1 = this.mAppMonitorProvider;
        if (r1 == null) goto L6;
        r1.handleApiResult(r41, r42, r43, r44, r45, r47, r49, r51, r53, r55, r57, r59, r61, r63, r65, r66, r68, r70, r72, r73, r74, r75, r76, r77, r78);
        return;
    }
}
