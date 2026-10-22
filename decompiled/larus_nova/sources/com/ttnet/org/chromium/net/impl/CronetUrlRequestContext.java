package com.ttnet.org.chromium.net.impl;

import android.os.Build;
import android.os.ConditionVariable;
import android.os.Process;
import android.util.Pair;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.ObserverList;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
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

/* JADX INFO: loaded from: classes.dex */
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

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.impl.CronetUrlRequestContext$6, reason: invalid class name */
    /* JADX INFO: loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$ttnet$org$chromium$net$TTThreadConfigInfoProvider$BindCore = null;

        static {
            int[] r100 = new int[TTThreadConfigInfoProvider.BindCore.values().length];
            $SwitchMap$com$ttnet$org$chromium$net$TTThreadConfigInfoProvider$BindCore = r100;
            r100[TTThreadConfigInfoProvider.BindCore.BIG_CORE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$ttnet$org$chromium$net$TTThreadConfigInfoProvider$BindCore[TTThreadConfigInfoProvider.BindCore.LITTLE_CORE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ttnet$org$chromium$net$TTThreadConfigInfoProvider$BindCore[TTThreadConfigInfoProvider.BindCore.CANCEL_BIND.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public interface Natives {
        @NativeClassQualifiedName("CronetContextAdapter")
        void addClientOpaqueData(long r100, CronetUrlRequestContext r101, String[] r102, byte[] r103, byte[] r104, long r105, long r106);

        void addPkp(long r100, String r101, byte[][] r102, boolean r103, long r104);

        void addQuicHint(long r100, String r101, int r102, int r103);

        @NativeClassQualifiedName("CronetContextAdapter")
        void addSamplingSetting(long r100, CronetUrlRequestContext r101, TTSamplingSettingProvider.TTSlaSamplingSetting r102);

        @NativeClassQualifiedName("CronetContextAdapter")
        void clearClientOpaqueData(long r100, CronetUrlRequestContext r101);

        @NativeClassQualifiedName("CronetContextAdapter")
        void configureNetworkQualityEstimatorForTesting(long r100, CronetUrlRequestContext r101, boolean r102, boolean r103, boolean r104);

        @NativeClassQualifiedName("CronetContextAdapter")
        void controlHttpDNSConfig(long r100, CronetUrlRequestContext r101, boolean r102, boolean r103, boolean r104);

        long createRequestContextAdapter(long r100);

        long createRequestContextConfig(String r100, String r101, boolean r102, String r103, boolean r104, boolean r105, boolean r106, int r107, long r108, String r110, long r111, boolean r112, boolean r113, int r114);

        @NativeClassQualifiedName("CronetContextAdapter")
        void destroy(long r100, CronetUrlRequestContext r101);

        @NativeClassQualifiedName("CronetContextAdapter")
        void enableTTBizHttpDns(long r100, CronetUrlRequestContext r101, boolean r102, String r103, String r104, String r105, boolean r106, String r107);

        byte[] getHistogramDeltas();

        long[] getOpaqueFuncAddress();

        void initALogFuncAddr(long r100);

        @NativeClassQualifiedName("CronetContextAdapter")
        void initRequestContextOnInitThread(long r100, CronetUrlRequestContext r101);

        @NativeClassQualifiedName("CronetContextAdapter")
        void parseTNCConfigFromSystemHTTPRequest(long r100, CronetUrlRequestContext r101, String r102, String r103, String r104, String r105, String r106, String r107);

        @NativeClassQualifiedName("CronetContextAdapter")
        void preconnectUrl(long r100, CronetUrlRequestContext r101, String r102, int r103, String r104);

        @NativeClassQualifiedName("CronetContextAdapter")
        void provideRTTObservations(long r100, CronetUrlRequestContext r101, boolean r102);

        @NativeClassQualifiedName("CronetContextAdapter")
        void provideThroughputObservations(long r100, CronetUrlRequestContext r101, boolean r102);

        @NativeClassQualifiedName("CronetContextAdapter")
        void removeClientOpaqueData(long r100, CronetUrlRequestContext r101, String r102);

        @NativeClassQualifiedName("CronetContextAdapter")
        void reportNetDiagnosisUserLog(long r100, CronetUrlRequestContext r101, String r102);

        @NativeClassQualifiedName("CronetContextAdapter")
        void runInBackGround(long r100, CronetUrlRequestContext r101, boolean r102);

        @NativeClassQualifiedName("CronetContextAdapter")
        void setAlogFuncAddr(long r100, CronetUrlRequestContext r101, long r102);

        @NativeClassQualifiedName("CronetContextAdapter")
        void setAppStartUpState(long r100, CronetUrlRequestContext r101, int r102);

        void setClientOpaqueData(long r100, String[] r101, byte[] r102, byte[] r103);

        @NativeClassQualifiedName("CronetContextAdapter")
        void setCookieInitCompleted(long r100, CronetUrlRequestContext r101);

        @NativeClassQualifiedName("CronetContextAdapter")
        void setHostResolverRules(long r100, CronetUrlRequestContext r101, String r102);

        int setMinLogLevel(int r100);

        @NativeClassQualifiedName("CronetContextAdapter")
        void setProxy(long r100, CronetUrlRequestContext r101, String r102);

        @NativeClassQualifiedName("CronetContextAdapter")
        void setRouteSelectionBestHost(long r100, CronetUrlRequestContext r101, String r102, String r103);

        void setTTNetInitConfig(long r100, int r101, boolean r102, boolean r103, String r104, String r105, String r106, boolean r107, String r110, String r111, byte[][] r112, TTThreadConfigInfoProvider.ThreadConfigInfo[] r113, boolean r114, boolean r115, boolean r116, String r117, TTAppInfoProvider.AppInfo r118, long r119, boolean r210, boolean r211, boolean r212, TTSamplingSettingProvider.TTSlaSamplingSetting r213, boolean r214, String r215, int r216);

        @NativeClassQualifiedName("CronetContextAdapter")
        void setZstdFuncAddr(long r100, CronetUrlRequestContext r101, long r102, long r103, long r104, long r110, long r111, long r112, long r113, long r114);

        @NativeClassQualifiedName("CronetContextAdapter")
        boolean skipLogging(long r100, CronetUrlRequestContext r101);

        @NativeClassQualifiedName("CronetContextAdapter")
        void startNetLogToDisk(long r100, CronetUrlRequestContext r101, String r102, boolean r103, int r104);

        @NativeClassQualifiedName("CronetContextAdapter")
        boolean startNetLogToFile(long r100, CronetUrlRequestContext r101, String r102, boolean r103);

        @NativeClassQualifiedName("CronetContextAdapter")
        void startThrottle(long r100, CronetUrlRequestContext r101, String[] r102, int r103, long r104);

        @NativeClassQualifiedName("CronetContextAdapter")
        void stopNetLog(long r100, CronetUrlRequestContext r101);

        @NativeClassQualifiedName("CronetContextAdapter")
        void stopThrottle(long r100, CronetUrlRequestContext r101, String[] r102, int r103);

        @NativeClassQualifiedName("CronetContextAdapter")
        void triggerTNCRequestByUser(long r100, CronetUrlRequestContext r101, boolean r102);

        @NativeClassQualifiedName("CronetContextAdapter")
        void tryStartNetDetect(long r100, CronetUrlRequestContext r101, String[] r102, int r103, int r104);

        @NativeClassQualifiedName("CronetContextAdapter")
        void ttDnsResolve(long r100, CronetUrlRequestContext r101, String r102, int r103, String r104, String r105);

        @NativeClassQualifiedName("CronetContextAdapter")
        void ttUrlDispatch(long r100, CronetUrlRequestContext r101, URLDispatch r102, String r103, boolean r104);

        @NativeClassQualifiedName("CronetContextAdapter")
        void updateStoreRegionFromServer(long r100, CronetUrlRequestContext r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, String r111, String r112, String r113, String r114);
    }

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
        String r100 = LOG_TAG;
        if (Log.isLoggable(r100, 2) == false) goto L6;
        return -2;
    L6:
        if (Log.isLoggable(r100, 3) == false) goto L8;
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
        TTEventListener r100 = this.mEventListener;
        if (r100 == null) goto L6;
        r100.onColdStartFinish();
        return;
    }

    private TTAppInfoProvider.AppInfo onGetAppInfo() {
        TTAppInfoProvider r100 = this.mAppInfoProvider;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getAppInfo();
    }

    private void onTLBDecompressFail() {
        TTEventListener r100 = this.mEventListener;
        if (r100 == null) goto L6;
        r100.onTLBDecompressFail();
        return;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void clearClientOpaqueData() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        CronetUrlRequestContextJni.get().clearClientOpaqueData(this.mUrlRequestContextAdapter, this);     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public TTMpaService createTTMpaService() {
        return new TTCronetMpaService(this);
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public URLStreamHandlerFactory createURLStreamHandlerFactory() {
        return new CronetURLStreamHandlerFactory(this);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getDownstreamThroughputKbps() {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L16;
        Object r100 = this.mNetworkQualityLock;
        monitor-enter(r100);
        int r101 = this.mDownstreamThroughputKbps;     // Catch: Throwable -> L12
        if (r101 != (-1)) goto L10;
        r101 = -1;
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L12
        return r101;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getEffectiveConnectionType() {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L13;
        Object r100 = this.mNetworkQualityLock;
        monitor-enter(r100);
        int r101 = this.mEffectiveConnectionType;     // Catch: Throwable -> L9
        monitor-exit(r100);     // Catch: Throwable -> L9
        return r101;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getEffectiveHttpRtt() {
        Object r100 = this.mNetworkQualityLevelLock;
        monitor-enter(r100);
        int r101 = this.mEffectiveHrttMs;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getEffectiveRxThroughput() {
        Object r100 = this.mNetworkQualityLevelLock;
        monitor-enter(r100);
        int r101 = this.mEffectiveRxThroughputKbps;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getEffectiveTransportRtt() {
        Object r100 = this.mNetworkQualityLevelLock;
        monitor-enter(r100);
        int r101 = this.mEffectiveTrttMs;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public Map<String, int[]> getGroupRttEstimates() {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L20;
        HashMap r100 = new HashMap();
        Object r101 = this.mNetworkQualityLock;
        monitor-enter(r101);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (this.mWatchingGroups != null) goto L10;
        monitor-exit(r101);     // Catch: Throwable -> L16
        return r100;
    L10:
        int r102 = 0;
    L11:
        String[] r103 = this.mWatchingGroups;     // Catch: Throwable -> L16
        if (r102 >= r103.length) goto L14;
        r100.put(r103[r102], new int[]{this.mGroupTransportRttMs[r102], this.mGroupHttpRttMs[r102]});     // Catch: Throwable -> L16
        r102 = r102 + 1;     // Catch: Throwable -> L16
        goto L11
    L14:
        monitor-exit(r101);     // Catch: Throwable -> L16
        return r100;
    L20:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getHttpRttMs() {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L16;
        Object r100 = this.mNetworkQualityLock;
        monitor-enter(r100);
        int r101 = this.mHttpRttMs;     // Catch: Throwable -> L12
        if (r101 != (-1)) goto L10;
        r101 = -1;
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L12
        return r101;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getNetworkQualityLevel() {
        Object r100 = this.mNetworkQualityLevelLock;
        monitor-enter(r100);
        int r101 = this.mNql;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public List<Long> getOpaqueFuncAddress() {
        ArrayList r100 = new ArrayList();
        Object r101 = this.mLock;
        monitor-enter(r101);
        long[] r102 = CronetUrlRequestContextJni.get().getOpaqueFuncAddress();     // Catch: Throwable -> L9
        int r103 = r102.length;     // Catch: Throwable -> L9
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L7;
        r100.add(Long.valueOf(r102[r104]));     // Catch: Throwable -> L9
        r104 = r104 + 1;     // Catch: Throwable -> L9
        goto L5
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
        return r100;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public int getTransportRttMs() {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L16;
        Object r100 = this.mNetworkQualityLock;
        monitor-enter(r100);
        int r101 = this.mTransportRttMs;     // Catch: Throwable -> L12
        if (r101 != (-1)) goto L10;
        r101 = -1;
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L12
        return r101;
    L12:
        th = move-exception;
        throw th;
    L16:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    public long getUrlRequestContextAdapter() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        checkHaveAdapter();     // Catch: Throwable -> L7
        long r101 = this.mUrlRequestContextAdapter;     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public String getVersionString() {
        return "Cronet/" + ImplVersion.getCronetVersionWithLastChange();
    }

    public boolean hasRequestFinishedListener() {
        Object r100 = this.mFinishedListenerLock;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mFinishedListenerMap.isEmpty() == true) goto L7;
        boolean r101 = true;
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r101;
    L7:
        r101 = false;
        goto L8
    }

    public void onRequestDestroyed() {
        this.mActiveRequestCount.decrementAndGet();
    }

    public void onRequestStarted() {
        this.mActiveRequestCount.incrementAndGet();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public void setCookieInitCompleted() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        CronetUrlRequestContextJni.get().setCookieInitCompleted(this.mUrlRequestContextAdapter, this);     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void shutdown() {
        if (this.mInUseStoragePath == null) goto L12;
        HashSet<String> r100 = sInUseStoragePaths;
        monitor-enter(r100);
        r100.remove(this.mInUseStoragePath);     // Catch: Throwable -> L9
        monitor-exit(r100);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L12:
        Object r101 = this.mLock;
        monitor-enter(r101);
        checkHaveAdapter();     // Catch: Throwable -> L35
        if (this.mActiveRequestCount.get() != 0) goto L34;
        if (ThreadMethodProxy.currentThread() == this.mNetworkThread) goto L32;
        monitor-exit(r101);     // Catch: Throwable -> L35
        this.mInitCompleted.block();
        stopNetLog();
        Object r102 = this.mLock;
        monitor-enter(r102);
    L28:
        th = move-exception;
        throw th;
    L22:
        if (haveRequestContextAdapter() == true) goto L25;
        monitor-exit(r102);     // Catch: Throwable -> L28
        return;
    L25:
        CronetUrlRequestContextJni.get().destroy(this.mUrlRequestContextAdapter, this);     // Catch: Throwable -> L28
        this.mUrlRequestContextAdapter = 0;     // Catch: Throwable -> L28
        monitor-exit(r102);     // Catch: Throwable -> L28
        return;
    L32:
        throw new IllegalThreadStateException("Cannot shutdown from network thread.");     // Catch: Throwable -> L35
    L34:
        throw new IllegalStateException("Cannot shutdown with active requests.");     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void stopNetLog() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        checkHaveAdapter();     // Catch: Throwable -> L22
        if (this.mIsLogging == true) goto L7;
    L20:
        monitor-exit(r100);     // Catch: Throwable -> L22
        return;
    L7:
        if (this.mIsStoppingNetLog == true) goto L20;
        CronetUrlRequestContextJni.get().stopNetLog(this.mUrlRequestContextAdapter, this);     // Catch: Throwable -> L22
        this.mIsStoppingNetLog = true;     // Catch: Throwable -> L22
        monitor-exit(r100);     // Catch: Throwable -> L22
        this.mStopNetLogCompleted.block();
        this.mStopNetLogCompleted.close();
        Object r101 = this.mLock;
        monitor-enter(r101);
        this.mIsStoppingNetLog = false;     // Catch: Throwable -> L17
        this.mIsLogging = false;     // Catch: Throwable -> L17
        monitor-exit(r101);     // Catch: Throwable -> L17
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
        return new CronetLogger.CronetVersion(getVersionString().split(HTTP.URL_DEFAULT)[1].split("@")[0]);
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
        TTEventListener r100 = this.mEventListener;
        if (r100 == null) goto L6;
        r100.onCronetBootSucceed();
        return;
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public byte[] getGlobalMetricsDeltas() {
        return CronetUrlRequestContextJni.get().getHistogramDeltas();
    }

    public int getCronetEngineId() {
        return this.mCronetEngineId;
    }

    public CronetLogger getCronetLogger() {
        return this.mLogger;
    }

    public CronetUrlRequestContext(CronetEngineBuilderImpl r110) {
        Object r100 = new Object();
        this.mLock = r100;
        this.mInitCompleted = new ConditionVariable(false);
        this.mActiveRequestCount = new AtomicInteger(0);
        this.mNetworkQualityLock = new Object();
        this.mFinishedListenerLock = new Object();
        this.mEffectiveConnectionType = 0;
        this.mHttpRttMs = -1;
        this.mTransportRttMs = -1;
        this.mDownstreamThroughputKbps = -1;
        ObserverList<VersionSafeCallbacks.NetworkQualityRttListenerWrapper> r101 = new ObserverList();
        this.mRttListenerList = r101;
        ObserverList<VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper> r102 = new ObserverList();
        this.mThroughputListenerList = r102;
        this.mFinishedListenerMap = new HashMap();
        this.mNetworkQualityLevelLock = new Object();
        this.mEffectiveHrttMs = -1;
        this.mEffectiveTrttMs = -1;
        this.mEffectiveRxThroughputKbps = -1;
        this.mUpstreamPacketLossRate = new double[]{-1.0d, -1.0d};
        this.mUpstreamPacketLossRateVariance = new double[]{-1.0d, -1.0d};
        this.mDownstreamPacketLossRate = new double[]{-1.0d, -1.0d};
        this.mDownstreamPacketLossRateVariance = new double[]{-1.0d, -1.0d};
        Object r103 = new Object();
        this.mThreadTypeIdLock = r103;
        this.mThreadTypeIdMap = new HashMap();
        this.mThreadTypeBindCoreMap = new HashMap();
        this.mStopNetLogCompleted = new ConditionVariable();
        this.mNetworkHandle = -1;
        this.mCronetEngineId = hashCode();
        r101.disableThreadAsserts();
        r102.disableThreadAsserts();
        this.mNetworkQualityEstimatorEnabled = r110.networkQualityEstimatorEnabled();
        CronetLibraryLoader.ensureInitialized(r110.getContext(), r110);
        CronetUrlRequestContextJni.get().setMinLogLevel(getLoggingLevel());
        if (r110.httpCacheMode() != 1) goto L16;
        String r104 = r110.storagePath();
        this.mInUseStoragePath = r104;
        HashSet<String> r105 = sInUseStoragePaths;
        monitor-enter(r105);
    L14:
        th = move-exception;
        throw th;
    L7:
        if (r105.add(r104) == false) goto L11;
        monitor-exit(r105);     // Catch: Throwable -> L14
    L17:
        this.mAppInfoProvider = r110.getAppInfoProvider();
        this.mAppMonitorProvider = r110.getAppMonitorProvider();
        this.mEventListener = r110.getEventListener();
        this.mListenAppStateIndependently = r110.getListenAppStateIndependently();
        monitor-enter(r103);
        this.mThreadConfigCallback = r110.threadConfigCallbackImpl();     // Catch: Throwable -> L40
        monitor-exit(r103);     // Catch: Throwable -> L40
        monitor-enter(r100);
        long r106 = CronetUrlRequestContextJni.get().createRequestContextAdapter(createNativeUrlRequestContextConfig(r110));     // Catch: Throwable -> L37
        this.mUrlRequestContextAdapter = r106;     // Catch: Throwable -> L37
        if (r106 == 0) goto L36;
        boolean r107 = CronetUrlRequestContextJni.get().skipLogging(this.mUrlRequestContextAdapter, this);     // Catch: Throwable -> L37
        this.mSkipLogging = r107;     // Catch: Throwable -> L37
        monitor-exit(r100);     // Catch: Throwable -> L37
        if (r107 == false) goto L28;
        this.mLogger = CronetLoggerFactory.createNoOpLogger();
    L47:
        this.mLogger.logCronetEngineCreation(getCronetEngineId(), new CronetLogger.CronetEngineBuilderInfo(r110), buildCronetVersion(), getCronetSource());     // Catch: RuntimeException -> L31
    L33:
        CronetLibraryLoader.postToInitThread(new AnonymousClass1(this));
        return;
    L31:
        e = move-exception;
        Log.e(LOG_TAG, "Error while trying to log CronetEngine creation: ", new Object[]{e});
        goto L33
    L28:
        this.mLogger = CronetLoggerFactory.createLogger(r110.getContext(), getCronetSource());
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

    public static /* synthetic */ boolean access$000(CronetUrlRequestContext r100) {
        return r100.mListenAppStateIndependently;
    }

    public static /* synthetic */ Object access$100(CronetUrlRequestContext r100) {
        return r100.mLock;
    }

    public static /* synthetic */ long access$200(CronetUrlRequestContext r100) {
        return r100.mUrlRequestContextAdapter;
    }

    private String constructControlHeaders(Map<String, String> r100) {
        String r101 = "";
        if (r100 == null) goto L12;
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L12;
        Map.Entry<String, String> r103 = r102.next();
        String r104 = r103.getKey();
        String r105 = r103.getValue();
        if (r104.isEmpty() == true) goto L6;
        if (r105.isEmpty() == true) goto L6;
        r101 = r104 + ":" + r105 + "\r\n" + r101;
    L12:
        return r101;
    }

    private static int convertConnectionTypeToApiValue(int r100) {
        if (r100 == 0) goto L17;
        int r101 = 1;
        if (r100 == 1) goto L16;
        r101 = 2;
        if (r100 == 2) goto L16;
        r101 = 3;
        if (r100 == 3) goto L16;
        r101 = 4;
        if (r100 == 4) goto L16;
        if (r100 != 5) goto L15;
        return 5;
    L15:
        throw new RuntimeException("Internal Error: Illegal EffectiveConnectionType value " + r100);
    L16:
        return r101;
    L17:
        return 0;
    }

    public static long createNativeUrlRequestContextConfig(CronetEngineBuilderImpl r310) {
        String r100 = "";
        File r101 = r310.getContext().getFilesDir();     // Catch: Throwable -> L7
        if (r101 == null) goto L8;
        r100 = r101.getAbsolutePath();     // Catch: Throwable -> L7
    L8:
        String r102 = r100;
        long r311 = CronetUrlRequestContextJni.get().createRequestContextConfig(r310.getUserAgent(), r310.storagePath(), r310.quicEnabled(), r310.getDefaultQuicUserAgentId(), r310.http2Enabled(), r310.brotliEnabled(), r310.cacheDisabled(), r310.httpCacheMode(), r310.httpCacheMaxSize(), r310.experimentalOptions(), r310.mockCertVerifier(), r310.networkQualityEstimatorEnabled(), r310.publicKeyPinningBypassForLocalTrustAnchorsEnabled(), r310.threadPriority(0));
        if (r311 == 0) goto L41;
        Iterator<CronetEngineBuilderImpl.QuicHint> r103 = r310.quicHints().iterator();
    L12:
        if (r103.hasNext() == false) goto L14;
        CronetEngineBuilderImpl.QuicHint r104 = r103.next();
        CronetUrlRequestContextJni.get().addQuicHint(r311, r104.mHost, r104.mPort, r104.mAlternatePort);
        goto L12
    L14:
        Iterator<CronetEngineBuilderImpl.Pkp> r105 = r310.publicKeyPins().iterator();
    L16:
        if (r105.hasNext() == false) goto L18;
        CronetEngineBuilderImpl.Pkp r106 = r105.next();
        CronetUrlRequestContextJni.get().addPkp(r311, r106.mHost, r106.mHashes, r106.mIncludeSubdomains, r106.mExpirationDate.getTime());
        goto L16
    L18:
        ArrayList<byte[]> r107 = r310.getOpaqueData();
        if (r107 != null) goto L21;
    L23:
        byte[][] r110 = null;
    L24:
        ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r108 = r310.threadConfigInfoList();
        if (r108 != null) goto L27;
    L29:
        TTThreadConfigInfoProvider.ThreadConfigInfo[] r111 = null;
    L30:
        CronetUrlRequestContextJni.get().setTTNetInitConfig(r311, r310.getAppSecurityLevel(), r310.httpDnsEnabled(), r310.verboseLogEnabled(), r102, r310.getProxyConfig(), r310.getGetDomainDefaultJSON(), r310.boeProxyEnabled(), r310.getBypassBOEJSON(), r310.getStoreIdcRuleJSON(), r110, r111, r310.tncSecureModeEnabled(), r310.isMainProcess(), r310.lazyInitIPC(), r310.processName(), r310.TTAppInfoSubset(), r310.ttnetInitStart(), r310.optInit(), r310.optNqeDefault(), r310.optNqePersist(), r310.samplingSetting(), r310.optStack(), r310.threadStackInitReason(), r310.getTelemetryOptionFlags());
        Map<String[], Pair<byte[], byte[]>> r109 = r310.getClientOpaqueData();
        if (r109 != null) goto L33;
    L38:
        CronetUrlRequestContextJni.get().initALogFuncAddr(r310.aLogFuncAddr());
        return r311;
    L33:
        if (r109.isEmpty() == true) goto L38;
        Iterator<Map.Entry<String[], Pair<byte[], byte[]>>> r112 = r109.entrySet().iterator();
    L36:
        if (r112.hasNext() == false) goto L38;
        Map.Entry<String[], Pair<byte[], byte[]>> r113 = r112.next();
        CronetUrlRequestContextJni.get().setClientOpaqueData(r311, r113.getKey(), (byte[]) r113.getValue().first, (byte[]) r113.getValue().second);
        goto L36
    L27:
        if (r108.isEmpty() == true) goto L29;
        r111 = (TTThreadConfigInfoProvider.ThreadConfigInfo[]) r108.toArray(new TTThreadConfigInfoProvider.ThreadConfigInfo[r108.size()]);
        goto L30
    L21:
        if (r107.isEmpty() == true) goto L23;
        r110 = (byte[][]) r107.toArray(new byte[r107.size()][]);
        goto L24
    L41:
        throw new IllegalArgumentException("Experimental options parsing failed.");
    }

    private void handleProtocolException(int r100) {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L12;
        if (r100 != 0) goto L6;
        return;
    L6:
        if (r100 != 1) goto L9;
        return;
    L9:
        throw new IllegalStateException("Error protocol: " + r100);
    L12:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    private void onClientIPChanged(String r100) {
        TTEventListener r101 = this.mEventListener;
        if (r101 == null) goto L6;
        r101.onClientIPChanged(r100);
        return;
    }

    private void onEffectiveConnectionTypeChanged(int r100) {
        Object r101 = this.mNetworkQualityLock;
        monitor-enter(r101);
        this.mEffectiveConnectionType = r100;     // Catch: Throwable -> L9
        TTEventListener r102 = this.mEventListener;     // Catch: Throwable -> L9
        if (r102 == null) goto L7;
        r102.onEffectiveConnectionTypeChanged(r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void onNQLChanged(int r100) {
        Object r101 = this.mNetworkQualityLevelLock;
        monitor-enter(r101);
        this.mNql = r100;     // Catch: Throwable -> L9
        TTEventListener r102 = this.mEventListener;     // Catch: Throwable -> L9
        if (r102 == null) goto L7;
        r102.onNetworkQualityLevelChanged(r100);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void onNetworkQualityTypeChangedV3(int r100) {
        Object r101 = this.mNetworkQualityLock;
        monitor-enter(r101);
        this.mEffectiveConnectionType = r100;     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
        TTEventListener r102 = this.mEventListener;
        if (r102 == null) goto L15;
        r102.onNetworkQualityTypeChangedV3(r100);
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void onTTNetDetectInfoChanged(String r100) {
        TTEventListener r101 = this.mEventListener;
        if (r101 == null) goto L6;
        r101.onTTNetDetectInfoChanged(r100);
        return;
    }

    private void onThreadIdChanged(int[] r100) {
        Object r101 = this.mThreadTypeIdLock;
        monitor-enter(r101);
        int r102 = 0;
    L29:
    L26:
        th = move-exception;
        throw th;
    L6:
        if (r102 >= (r100.length - 1)) goto L24;
        TTThreadConfigInfoProvider.ThreadType r103 = TTThreadConfigInfoProvider.ThreadType.values()[r100[r102]];     // Catch: Throwable -> L26
        int r104 = r100[r102 + 1];     // Catch: Throwable -> L26
        this.mThreadTypeIdMap.put(r103, Integer.valueOf(r104));     // Catch: Throwable -> L26
        if (this.mThreadTypeBindCoreMap.containsKey(r103) == true) goto L11;
    L23:
        r102 = r102 + 2;     // Catch: Throwable -> L26
        goto L29
    L11:
        if (this.mThreadConfigCallback == null) goto L23;
        int r105 = AnonymousClass6.$SwitchMap$com$ttnet$org$chromium$net$TTThreadConfigInfoProvider$BindCore[this.mThreadTypeBindCoreMap.get(r103).ordinal()];     // Catch: Throwable -> L26
        if (r105 != 1) goto L16;
        this.mThreadConfigCallback.bindBigCore(r104);     // Catch: Throwable -> L26
        goto L23
    L16:
        if (r105 != 2) goto L18;
        this.mThreadConfigCallback.bindLittleCore(r104);     // Catch: Throwable -> L26
        goto L23
    L18:
        if (r105 != 3) goto L23;
        this.mThreadConfigCallback.resetCoreBind(r104);     // Catch: Throwable -> L26
        goto L23
    L24:
        monitor-exit(r101);     // Catch: Throwable -> L26
    }

    private void onUserSpecifiedNetworkEnabled(boolean r100) {
        TTEventListener r101 = this.mEventListener;
        if (r101 == null) goto L6;
        r101.onUserSpecifiedNetworkEnabled(r100);
        return;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void addRequestFinishedListener(RequestFinishedInfo.Listener r100) {
        Object r101 = this.mFinishedListenerLock;
        monitor-enter(r101);
        this.mFinishedListenerMap.put(r100, new VersionSafeCallbacks.RequestFinishedInfoListener(r100));     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void addRttListener(NetworkQualityRttListener r100) {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L23;
        Object r101 = this.mNetworkQualityLock;
        monitor-enter(r101);
    L19:
        th = move-exception;
        throw th;
    L7:
        if (this.mRttListenerList.isEmpty() == false) goto L16;
        Object r102 = this.mLock;     // Catch: Throwable -> L19
        monitor-enter(r102);     // Catch: Throwable -> L19
        checkHaveAdapter();     // Catch: Throwable -> L13
        CronetUrlRequestContextJni.get().provideRTTObservations(this.mUrlRequestContextAdapter, this, true);     // Catch: Throwable -> L13
        monitor-exit(r102);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L16:
        this.mRttListenerList.addObserver(new VersionSafeCallbacks.NetworkQualityRttListenerWrapper(r100));     // Catch: Throwable -> L19
        monitor-exit(r101);     // Catch: Throwable -> L19
        return;
    L23:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void addSamplingSetting(TTSamplingSettingProvider.TTSlaSamplingSetting r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        checkHaveAdapter();     // Catch: Throwable -> L7
        CronetUrlRequestContextJni.get().addSamplingSetting(this.mUrlRequestContextAdapter, this, r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void addThroughputListener(NetworkQualityThroughputListener r100) {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L23;
        Object r101 = this.mNetworkQualityLock;
        monitor-enter(r101);
    L19:
        th = move-exception;
        throw th;
    L7:
        if (this.mThroughputListenerList.isEmpty() == false) goto L16;
        Object r102 = this.mLock;     // Catch: Throwable -> L19
        monitor-enter(r102);     // Catch: Throwable -> L19
        checkHaveAdapter();     // Catch: Throwable -> L13
        CronetUrlRequestContextJni.get().provideThroughputObservations(this.mUrlRequestContextAdapter, this, true);     // Catch: Throwable -> L13
        monitor-exit(r102);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L16:
        this.mThroughputListenerList.addObserver(new VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper(r100));     // Catch: Throwable -> L19
        monitor-exit(r101);     // Catch: Throwable -> L19
        return;
    L23:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void bindBigCore(int r100) {
        Object r101 = this.mThreadTypeIdLock;
        monitor-enter(r101);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mThreadConfigCallback != null) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L16
        return;
    L8:
        TTThreadConfigInfoProvider.ThreadType r102 = TTThreadConfigInfoProvider.ThreadType.values()[r100];     // Catch: Throwable -> L16
        if (this.mThreadTypeIdMap.containsKey(r102) == false) goto L13;
        this.mThreadConfigCallback.bindBigCore(this.mThreadTypeIdMap.get(r102).intValue());     // Catch: Throwable -> L16
        monitor-exit(r101);     // Catch: Throwable -> L16
        return;
    L13:
        this.mThreadTypeBindCoreMap.put(r102, TTThreadConfigInfoProvider.BindCore.BIG_CORE);     // Catch: Throwable -> L16
        monitor-exit(r101);     // Catch: Throwable -> L16
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void bindLittleCore(int r100) {
        Object r101 = this.mThreadTypeIdLock;
        monitor-enter(r101);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mThreadConfigCallback != null) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L16
        return;
    L8:
        TTThreadConfigInfoProvider.ThreadType r102 = TTThreadConfigInfoProvider.ThreadType.values()[r100];     // Catch: Throwable -> L16
        if (this.mThreadTypeIdMap.containsKey(r102) == false) goto L13;
        this.mThreadConfigCallback.bindLittleCore(this.mThreadTypeIdMap.get(r102).intValue());     // Catch: Throwable -> L16
        monitor-exit(r101);     // Catch: Throwable -> L16
        return;
    L13:
        this.mThreadTypeBindCoreMap.put(r102, TTThreadConfigInfoProvider.BindCore.LITTLE_CORE);     // Catch: Throwable -> L16
        monitor-exit(r101);     // Catch: Throwable -> L16
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void bindToNetwork(long r100) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        this.mNetworkHandle = r100;
        return;
    L7:
        throw new UnsupportedOperationException("The multi-network API is available starting from Android Marshmallow");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public double getDownstreamPacketLossRate(int r100) {
        handleProtocolException(r100);
        Object r101 = this.mNetworkQualityLock;
        monitor-enter(r101);
        double r102 = this.mDownstreamPacketLossRate[r100];     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public double getDownstreamPacketLossRateVariance(int r100) {
        handleProtocolException(r100);
        Object r101 = this.mNetworkQualityLock;
        monitor-enter(r101);
        double r102 = this.mDownstreamPacketLossRateVariance[r100];     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public double getUpstreamPacketLossRate(int r100) {
        handleProtocolException(r100);
        Object r101 = this.mNetworkQualityLock;
        monitor-enter(r101);
        double r102 = this.mUpstreamPacketLossRate[r100];     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public double getUpstreamPacketLossRateVariance(int r100) {
        handleProtocolException(r100);
        Object r101 = this.mNetworkQualityLock;
        monitor-enter(r101);
        double r102 = this.mUpstreamPacketLossRateVariance[r100];     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean isNetworkThread(Thread r100) {
        if (r100 != this.mNetworkThread) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public URLConnection openConnection(URL r100) {
        return openConnection(r100, Proxy.NO_PROXY);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void registerAppInfoProvider(TTAppInfoProvider r100) {
        this.mAppInfoProvider = r100;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void registerAppMonitorProvider(TTMonitorProvider r100) {
        this.mAppMonitorProvider = r100;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void registerEventListener(TTEventListener r100) {
        this.mEventListener = r100;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void removeClientOpaqueData(String r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        CronetUrlRequestContextJni.get().removeClientOpaqueData(this.mUrlRequestContextAdapter, this, r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void removeRequestFinishedListener(RequestFinishedInfo.Listener r100) {
        Object r101 = this.mFinishedListenerLock;
        monitor-enter(r101);
        this.mFinishedListenerMap.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void removeRttListener(NetworkQualityRttListener r100) {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L24;
        Object r101 = this.mNetworkQualityLock;
        monitor-enter(r101);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (this.mRttListenerList.removeObserver(new VersionSafeCallbacks.NetworkQualityRttListenerWrapper(r100)) == true) goto L9;
    L18:
        monitor-exit(r101);     // Catch: Throwable -> L20
        return;
    L9:
        if (this.mRttListenerList.isEmpty() == false) goto L18;
        Object r102 = this.mLock;     // Catch: Throwable -> L20
        monitor-enter(r102);     // Catch: Throwable -> L20
        checkHaveAdapter();     // Catch: Throwable -> L15
        CronetUrlRequestContextJni.get().provideRTTObservations(this.mUrlRequestContextAdapter, this, false);     // Catch: Throwable -> L15
        monitor-exit(r102);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L24:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void removeThroughputListener(NetworkQualityThroughputListener r100) {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L24;
        Object r101 = this.mNetworkQualityLock;
        monitor-enter(r101);
    L20:
        th = move-exception;
        throw th;
    L7:
        if (this.mThroughputListenerList.removeObserver(new VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper(r100)) == true) goto L9;
    L18:
        monitor-exit(r101);     // Catch: Throwable -> L20
        return;
    L9:
        if (this.mThroughputListenerList.isEmpty() == false) goto L18;
        Object r102 = this.mLock;     // Catch: Throwable -> L20
        monitor-enter(r102);     // Catch: Throwable -> L20
        checkHaveAdapter();     // Catch: Throwable -> L15
        CronetUrlRequestContextJni.get().provideThroughputObservations(this.mUrlRequestContextAdapter, this, false);     // Catch: Throwable -> L15
        monitor-exit(r102);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L24:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void reportNetDiagnosisUserLog(String r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        CronetUrlRequestContextJni.get().reportNetDiagnosisUserLog(this.mUrlRequestContextAdapter, this, r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void reportRequestFinished(final RequestFinishedInfo r100) {
        Object r101 = this.mFinishedListenerLock;
        monitor-enter(r101);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mFinishedListenerMap.isEmpty() == false) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L15
        return;
    L8:
        ArrayList r102 = new ArrayList(this.mFinishedListenerMap.values());     // Catch: Throwable -> L15
        monitor-exit(r101);     // Catch: Throwable -> L15
        Iterator r103 = r102.iterator();
    L12:
        if (r103.hasNext() == false) goto L14;
        final VersionSafeCallbacks.RequestFinishedInfoListener r104 = (VersionSafeCallbacks.RequestFinishedInfoListener) r103.next();
        Runnable r105 = new AnonymousClass5(this, r104, r100);
        postObservationTaskToExecutor(r104.getExecutor(), r105);
        goto L12
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void resetCoreBind(int r100) {
        Object r101 = this.mThreadTypeIdLock;
        monitor-enter(r101);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.mThreadConfigCallback != null) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L16
        return;
    L8:
        TTThreadConfigInfoProvider.ThreadType r102 = TTThreadConfigInfoProvider.ThreadType.values()[r100];     // Catch: Throwable -> L16
        if (this.mThreadTypeIdMap.containsKey(r102) == false) goto L13;
        this.mThreadConfigCallback.resetCoreBind(this.mThreadTypeIdMap.get(r102).intValue());     // Catch: Throwable -> L16
        monitor-exit(r101);     // Catch: Throwable -> L16
        return;
    L13:
        this.mThreadTypeBindCoreMap.put(r102, TTThreadConfigInfoProvider.BindCore.CANCEL_BIND);     // Catch: Throwable -> L16
        monitor-exit(r101);     // Catch: Throwable -> L16
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void runInBackGround(boolean r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        CronetUrlRequestContextJni.get().runInBackGround(this.mUrlRequestContextAdapter, this, r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public void setAlogFuncAddr(long r110) {
        Object r100 = this.mLock;
        monitor-enter(r100);
        checkHaveAdapter();     // Catch: Throwable -> L7
        Log.e(LOG_TAG, "Set alog func addr: " + r110, new Object[0]);     // Catch: Throwable -> L7
        CronetUrlRequestContextJni.get().setAlogFuncAddr(this.mUrlRequestContextAdapter, this, r110);     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public void setAppStartUpState(int r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        CronetUrlRequestContextJni.get().setAppStartUpState(this.mUrlRequestContextAdapter, this, r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public void setHostResolverRules(String r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        checkHaveAdapter();     // Catch: Throwable -> L7
        CronetUrlRequestContextJni.get().setHostResolverRules(this.mUrlRequestContextAdapter, this, r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void setProxy(String r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        CronetUrlRequestContextJni.get().setProxy(this.mUrlRequestContextAdapter, this, r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void triggerGetDomain(boolean r100) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        CronetUrlRequestContextJni.get().triggerTNCRequestByUser(this.mUrlRequestContextAdapter, this, r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private String[] addSecurityFactor(String r100, String[] r101) {
        HashMap r102 = new HashMap();
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r104 >= r101.length) goto L6;
        r102.put(r101[r104].toLowerCase(Locale.US), r101[r104 + 1]);
        r104 = r104 + 2;
        goto L4
    L6:
        Map<String, String> r105 = onCallToAddSecurityFactor(r100, r102);
        if (r105 != null) goto L10;
        return null;
    L10:
        String[] r106 = new String[r105.size() * 2];
        Iterator<Map.Entry<String, String>> r107 = r105.entrySet().iterator();
    L12:
        if (r107.hasNext() == false) goto L14;
        Map.Entry<String, String> r108 = r107.next();
        r106[r103] = r108.getKey();
        r106[r103 + 1] = r108.getValue();
        r103 = r103 + 2;
        goto L12
    L14:
        return r106;
    }

    private boolean handleApiSample(String r100, String r101) {
        TTMonitorProvider r102 = this.mAppMonitorProvider;
        if (r102 != null) goto L5;
        return false;
    L5:
        return r102.handleApiSample(r100, r101);
    }

    private void onDropReasonChanged(boolean r100, int[] r101) {
        if (this.mEventListener == null) goto L9;
        List<Integer> r102 = new ArrayList();
        if (r101 == null) goto L7;
        r102 = (List) Arrays.stream(r101).boxed().collect(Collectors.toList());
    L7:
        this.mEventListener.onDropReasonChanged(r100, r102);
        return;
    }

    private void onMultiNetworkStateChanged(int r100, int r101) {
        TTEventListener r102 = this.mEventListener;
        if (r102 == null) goto L6;
        r102.onMultiNetworkStateChanged(r100, r101);
        return;
    }

    private void onPublicIPsChanged(String[] r100, String[] r101) {
        if (this.mEventListener == null) goto L6;
        ArrayList r102 = new ArrayList(r100.length);
        ArrayList r103 = new ArrayList(r101.length);
        Collections.addAll(r102, r100);
        Collections.addAll(r103, r101);
        this.mEventListener.onPublicIPsChanged(r102, r103);
        return;
    }

    private void onSendAppMonitorEvent(String r100, String r101) {
        TTMonitorProvider r102 = this.mAppMonitorProvider;
        if (r102 == null) goto L6;
        r102.sendAppMonitorEvent(r100, r101);
        return;
    }

    private void onTNCUpdateFailed(String[] r100, String r101) {
        TTEventListener r102 = this.mEventListener;
        if (r102 == null) goto L6;
        r102.onTNCUpdateFailed(r100, r101);
        return;
    }

    private void onWiFiToCellStateChanged(int r100, int r101) {
        TTEventListener r102 = this.mEventListener;
        if (r102 == null) goto L6;
        r102.onWiFiToCellStateChanged(r100, r101);
        return;
    }

    private static void postObservationTaskToExecutor(Executor r100, Runnable r101) {
        r100.execute(r101);     // Catch: RejectedExecutionException -> L4
        return;
    L4:
        e = move-exception;
        Log.e(LOG_TAG, "Exception posting task to executor", new Object[]{e});
    }

    public Map<String, String> onCallToAddSecurityFactor(String r100, Map<String, String> r101) {
        TTEventListener r102 = this.mEventListener;
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.onCallToAddSecurityFactor(r100, r101);
    }

    public String onRequestInterceptorJava(String r100, String[] r101) {
        if (this.mEventListener != null) goto L6;
        return null;
    L6:
        HashMap r102 = new HashMap();
        if (r101 == null) goto L13;
        int r103 = 0;
    L9:
        int r104 = r103 + 1;
        if (r104 >= r101.length) goto L13;
        r102.put(r101[r103].toLowerCase(Locale.US), r101[r104]);
        r103 = r103 + 2;
    L13:
        return this.mEventListener.onRequestInterceptorJava(r100, r102);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public URLConnection openConnection(URL r100, Proxy r101) {
        return openConnection(r100, r101, false);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void setRouteSelectionBestHost(String r100, String r101) {
        Object r102 = this.mLock;
        monitor-enter(r102);
        CronetUrlRequestContextJni.get().setRouteSelectionBestHost(this.mUrlRequestContextAdapter, this, r100, r101);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public void startNetLogToFile(String r100, boolean r101) {
        Object r102 = this.mLock;
        monitor-enter(r102);
        checkHaveAdapter();     // Catch: Throwable -> L15
        if (this.mIsLogging == false) goto L9;
        monitor-exit(r102);     // Catch: Throwable -> L15
        return;
    L9:
        if (CronetUrlRequestContextJni.get().startNetLogToFile(this.mUrlRequestContextAdapter, this, r100, r101) == false) goto L14;
        this.mIsLogging = true;     // Catch: Throwable -> L15
        monitor-exit(r102);     // Catch: Throwable -> L15
        return;
    L14:
        throw new RuntimeException("Unable to start NetLog");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void stopThrottle(String[] r100, int r101) {
        Object r102 = this.mLock;
        monitor-enter(r102);
        checkHaveAdapter();     // Catch: Throwable -> L7
        CronetUrlRequestContextJni.get().stopThrottle(this.mUrlRequestContextAdapter, this, r100, r101);     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onGroupRTTOrThroughputEstimatesComputed(String[] r100, int[] r101, int[] r102) {
        Object r103 = this.mNetworkQualityLock;
        monitor-enter(r103);
        this.mWatchingGroups = r100;     // Catch: Throwable -> L7
        this.mGroupTransportRttMs = r101;     // Catch: Throwable -> L7
        this.mGroupHttpRttMs = r102;     // Catch: Throwable -> L7
        monitor-exit(r103);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onNetworkQualityRttAndThroughputNotified(int r100, int r101, int r102) {
        Object r103 = this.mNetworkQualityLevelLock;
        monitor-enter(r103);
        this.mEffectiveHrttMs = r100;     // Catch: Throwable -> L9
        this.mEffectiveTrttMs = r101;     // Catch: Throwable -> L9
        this.mEffectiveRxThroughputKbps = r102;     // Catch: Throwable -> L9
        TTEventListener r104 = this.mEventListener;     // Catch: Throwable -> L9
        if (r104 == null) goto L7;
        r104.onNetworkQualityRttAndThroughputNotified(r100, r101, r102);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r103);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void onRTTOrThroughputEstimatesComputed(int r100, int r101, int r102) {
        Object r103 = this.mNetworkQualityLock;
        monitor-enter(r103);
        this.mHttpRttMs = r100;     // Catch: Throwable -> L9
        this.mTransportRttMs = r101;     // Catch: Throwable -> L9
        this.mDownstreamThroughputKbps = r102;     // Catch: Throwable -> L9
        TTEventListener r104 = this.mEventListener;     // Catch: Throwable -> L9
        if (r104 == null) goto L7;
        r104.onRTTOrThroughputEstimatesComputed(r100, r101, r102);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r103);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void onRttObservation(final int r110, final long r111, final int r112) {
        Object r100 = this.mNetworkQualityLock;
        monitor-enter(r100);
        Iterator<VersionSafeCallbacks.NetworkQualityRttListenerWrapper> r101 = this.mRttListenerList.iterator();     // Catch: Throwable -> L10
    L6:
        if (r101.hasNext() == false) goto L8;
        final VersionSafeCallbacks.NetworkQualityRttListenerWrapper r102 = r101.next();     // Catch: Throwable -> L10
        Runnable r113 = new AnonymousClass3(this, r102, r110, r111, r112);     // Catch: Throwable -> L10
        postObservationTaskToExecutor(r102.getExecutor(), r113);     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void onTNCConfigChanged(String r100, String r101, String r102) {
        TTEventListener r103 = this.mEventListener;
        if (r103 == null) goto L6;
        r103.onServerConfigUpdated(r100, r101, r102);
        return;
    }

    private void onTNCRequestSucceeded(boolean r100, boolean r101, int r102) {
        TTEventListener r103 = this.mEventListener;
        if (r103 == null) goto L6;
        r103.onTncRequestSucceeded(r100, r101, r102);
        return;
    }

    private void onThroughputObservation(final int r110, final long r111, final int r112) {
        Object r100 = this.mNetworkQualityLock;
        monitor-enter(r100);
        Iterator<VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper> r101 = this.mThroughputListenerList.iterator();     // Catch: Throwable -> L10
    L6:
        if (r101.hasNext() == false) goto L8;
        final VersionSafeCallbacks.NetworkQualityThroughputListenerWrapper r102 = r101.next();     // Catch: Throwable -> L10
        Runnable r113 = new AnonymousClass4(this, r102, r110, r111, r112);     // Catch: Throwable -> L10
        postObservationTaskToExecutor(r102.getExecutor(), r113);     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void configureNetworkQualityEstimatorForTesting(boolean r100, boolean r110, boolean r111) {
        if (this.mNetworkQualityEstimatorEnabled == false) goto L13;
        Object r101 = this.mLock;
        monitor-enter(r101);
        checkHaveAdapter();     // Catch: Throwable -> L9
        CronetUrlRequestContextJni.get().configureNetworkQualityEstimatorForTesting(this.mUrlRequestContextAdapter, this, r100, r110, r111);     // Catch: Throwable -> L9
        monitor-exit(r101);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new IllegalStateException("Network quality estimator must be enabled");
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public ExperimentalBidirectionalStream.Builder newBidirectionalStreamBuilder(String r100, BidirectionalStream.Callback r101, Executor r102) {
        return new BidirectionalStreamBuilderImpl(r100, r101, r102, this);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase, com.ttnet.org.chromium.net.ExperimentalCronetEngine, com.ttnet.org.chromium.net.CronetEngine
    public /* bridge */ /* synthetic */ UrlRequest.Builder newUrlRequestBuilder(String r100, UrlRequest.Callback r101, Executor r102) {
        return super.newUrlRequestBuilder(r100, r101, r102);
    }

    public String onRequestInterceptorToStart(String r100, String[] r101, String[] r102) {
        if (this.mEventListener != null) goto L6;
        return null;
    L6:
        HashMap r103 = new HashMap();
        int r104 = 0;
        int r105 = 0;
    L8:
        if (r105 >= r101.length) goto L10;
        r103.put(r101[r105].toLowerCase(Locale.US), r101[r105 + 1]);
        r105 = r105 + 2;
        goto L8
    L10:
        ArrayList r106 = new ArrayList();
    L12:
        if (r104 >= r102.length) goto L15;
        r106.add(r102[r104]);
        r104 = r104 + 1;
        goto L12
    L15:
        return this.mEventListener.onRequestInterceptorToStart(r100, r103, r106);
    }

    public String onResponseInterceptorToStart(String r100, String[] r101, int r102) {
        if (this.mEventListener != null) goto L6;
        return null;
    L6:
        ArrayList r103 = new ArrayList();
        int r104 = 0;
    L8:
        if (r104 >= r101.length) goto L10;
        r103.add(new AbstractMap.SimpleImmutableEntry(r101[r104].toLowerCase(Locale.US), r101[r104 + 1]));
        r104 = r104 + 2;
        goto L8
    L10:
        TreeMap r105 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Iterator r106 = r103.iterator();
    L12:
        if (r106.hasNext() == false) goto L18;
        Map.Entry r107 = (Map.Entry) r106.next();
        ArrayList r108 = new ArrayList();
        if (r105.containsKey(r107.getKey()) == false) goto L16;
        r108.addAll((Collection) r105.get(r107.getKey()));
    L16:
        r108.add((String) r107.getValue());
        r105.put((String) r107.getKey(), Collections.unmodifiableList(r108));
        goto L12
    L18:
        return this.mEventListener.onResponseInterceptorToStart(r100, r105, r102);
    }

    @Override // com.ttnet.org.chromium.net.CronetEngine
    public URLConnection openConnection(URL r100, Proxy r101, boolean r102) {
        if (r101.type() != Proxy.Type.DIRECT) goto L14;
        String r103 = r100.getProtocol();
        if ("http".equals(r103) == true) goto L12;
        if ("https".equals(r103) == true) goto L12;
        throw new UnsupportedOperationException("Unexpected protocol:" + r103);
    L12:
        return new CronetHttpURLConnection(r100, this, r102);
    L14:
        throw new UnsupportedOperationException();
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void preconnectUrl(String r100, int r110, Map<String, String> r111) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        checkHaveAdapter();     // Catch: Throwable -> L7
        CronetUrlRequestContextJni.get().preconnectUrl(this.mUrlRequestContextAdapter, this, r100, r110, constructControlHeaders(r111));     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void setHttpDnsForTesting(boolean r100, boolean r110, boolean r111) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        CronetUrlRequestContextJni.get().controlHttpDNSConfig(this.mUrlRequestContextAdapter, this, r100, r110, r111);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void startNetLogToDisk(String r100, boolean r110, int r111) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        checkHaveAdapter();     // Catch: Throwable -> L11
        if (this.mIsLogging == false) goto L8;
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L8:
        CronetUrlRequestContextJni.get().startNetLogToDisk(this.mUrlRequestContextAdapter, this, r100, r110, r111);     // Catch: Throwable -> L11
        this.mIsLogging = true;     // Catch: Throwable -> L11
        monitor-exit(r101);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void startThrottle(String[] r110, int r111, long r112) {
        Object r100 = this.mLock;
        monitor-enter(r100);
        checkHaveAdapter();     // Catch: Throwable -> L7
        CronetUrlRequestContextJni.get().startThrottle(this.mUrlRequestContextAdapter, this, r110, r111, r112);     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void tryStartNetDetect(String[] r100, int r110, int r111) {
        Object r101 = this.mLock;
        monitor-enter(r101);
        CronetUrlRequestContextJni.get().tryStartNetDetect(this.mUrlRequestContextAdapter, this, r100, r110, r111);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public Map<String, String> ttUrlDispatch(String r110, int r111, boolean r112) throws IOException {
        URLDispatch r100 = new URLDispatch(r110);
        Object r101 = this.mLock;
        monitor-enter(r101);
        checkHaveAdapter();     // Catch: Throwable -> L8
        CronetUrlRequestContextJni.get().ttUrlDispatch(this.mUrlRequestContextAdapter, this, r100, r110, r112);     // Catch: Throwable -> L8
        monitor-exit(r101);     // Catch: Throwable -> L8
        r100.waitResult(r111);
        HashMap r113 = new HashMap();
        r113.put(URLDispatch.KEY_FINAL_URL, r100.getFinalUrl());
        r113.put(URLDispatch.KEY_EPOCH, r100.getEpoch());
        r113.put(URLDispatch.KEY_ETAG, r100.getEtag());
        r113.put(URLDispatch.KEY_TTNET_ORIGIN_HOST, r100.getTTNetOriginHost());
        return r113;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void ttDnsResolve(String r110, int r111, String r112, Map<String, String> r113) {
        Object r100 = this.mLock;
        monitor-enter(r100);
        CronetUrlRequestContextJni.get().ttDnsResolve(this.mUrlRequestContextAdapter, this, r110, r111, r112, constructControlHeaders(r113));     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onPacketLossComputed(int r110, double r111, double r112, double r113, double r210) {
        Object r114 = this.mNetworkQualityLock;
        monitor-enter(r114);
        if (r110 != 0) goto L6;
    L10:
        this.mUpstreamPacketLossRate[r110] = r111;     // Catch: Throwable -> L15
        this.mUpstreamPacketLossRateVariance[r110] = r112;     // Catch: Throwable -> L15
        this.mDownstreamPacketLossRate[r110] = r113;     // Catch: Throwable -> L15
        this.mDownstreamPacketLossRateVariance[r110] = r210;     // Catch: Throwable -> L15
        TTEventListener r100 = this.mEventListener;     // Catch: Throwable -> L15
        if (r100 == null) goto L13;
        r100.onPacketLossComputed(r110, r111, r112, r113, r210);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r114);     // Catch: Throwable -> L15
        return;
    L6:
        if (r110 == 1) goto L10;
        Log.e(LOG_TAG, "Error protocol from native. Protocol: " + r110, new Object[0]);     // Catch: Throwable -> L15
        monitor-exit(r114);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    private void onUrlDispatchComplete(final URLDispatch r100, String r101, String r102, String r103, String r104) {
        r100.setResult(r101, r102, r103, r104);
        r100.resume(new AnonymousClass2(this, r100));
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void addClientOpaqueData(String[] r110, byte[] r111, byte[] r112, long r113, long r210) {
        Object r114 = this.mLock;
        monitor-enter(r114);
        CronetUrlRequestContextJni.get().addClientOpaqueData(this.mUrlRequestContextAdapter, this, r110, r111, r112, r113, r210);     // Catch: Throwable -> L7
        monitor-exit(r114);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onStoreIdcChanged(String r100, String r101, String r110, String r111, String r112, String r113) {
        TTEventListener r102 = this.mEventListener;
        if (r102 == null) goto L6;
        r102.onStoreIdcChanged(r100, r101, r110, r111, r112, r113);
        return;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public TTWebsocketConnection createWebsocketConnection(TTWebsocketConnection.Callback r110, Executor r111, List<String> r112, Map<String, String> r113, Map<String, String> r114, boolean r115) {
        return new CronetWebsocketConnection(this, r110, r111, r112, r113, r114, r115);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void enableTTBizHttpDns(boolean r110, String r111, String r112, String r113, boolean r114, String r115) {
        Object r116 = this.mLock;
        monitor-enter(r116);
        CronetUrlRequestContextJni.get().enableTTBizHttpDns(this.mUrlRequestContextAdapter, this, r110, r111, r112, r113, r114, r115);     // Catch: Throwable -> L7
        monitor-exit(r116);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void notifyTNCConfigUpdated(String r110, String r111, String r112, String r113, String r114, String r115) {
        Object r116 = this.mLock;
        monitor-enter(r116);
        CronetUrlRequestContextJni.get().parseTNCConfigFromSystemHTTPRequest(this.mUrlRequestContextAdapter, this, r110, r111, r112, r113, r114, r115);     // Catch: Throwable -> L7
        monitor-exit(r116);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void onTTDnsResolveResult(String r110, String r111, int r112, int r113, int r114, String[] r115, String r116) {
        Log.d(LOG_TAG, " onTTDnsResolveResult, uuid: " + r110 + " host: " + r111 + " ret: " + r112 + " ips: " + r115.length, new Object[0]);
        ArrayList r117 = new ArrayList(r115.length);
        Collections.addAll(r117, r115);
        TTEventListener r100 = this.mEventListener;
        if (r100 == null) goto L6;
        r100.onTTDnsResolveResult(r110, r111, r112, r113, r114, r117, r116);
        return;
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public TTNetDiagnosisRequest createNetDiagnosisRequest(TTNetDiagnosisRequest.Callback r110, Executor r111, int r112, List<String> r113, int r114, int r115, int r116) {
        return new TTCronetNetExpRequest(this, r110, r111, r112, r113, r114, r115, r116);
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void setZstdFuncAddr(long r210, long r211, long r212, long r213, long r310, long r311, long r312, long r313) {
        Object r110 = this.mLock;
        monitor-enter(r110);
        checkHaveAdapter();     // Catch: Throwable -> L9
        CronetUrlRequestContextJni.get().setZstdFuncAddr(this.mUrlRequestContextAdapter, this, r210, r211, r212, r213, r310, r311, r312, r313);     // Catch: Throwable -> L13
        monitor-exit(r110);     // Catch: Throwable -> L13
        return;
    L9:
        th = th;
    L11:
        monitor-exit(r110);     // Catch: Throwable -> L13
        throw th;
    L13:
        th = th;
        goto L11
    }

    @Override // com.ttnet.org.chromium.net.ExperimentalCronetEngine
    public void updateStoreRegionFromServer(String r110, String r111, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218) {
        Object r112 = this.mLock;
        monitor-enter(r112);
        CronetUrlRequestContextJni.get().updateStoreRegionFromServer(this.mUrlRequestContextAdapter, this, r110, r111, r210, r211, r212, r213, r214, r215, r216, r217, r218);     // Catch: Throwable -> L13
        monitor-exit(r112);     // Catch: Throwable -> L13
        return;
    L9:
        th = th;
    L11:
        monitor-exit(r112);     // Catch: Throwable -> L13
        throw th;
    L13:
        th = th;
        goto L11
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public ExperimentalBidirectionalStream createBidirectionalStream(String r210, BidirectionalStream.Callback r211, Executor r212, String r213, List<Map.Entry<String, String>> r214, int r215, boolean r216, Collection<Object> r217, boolean r218, int r219, boolean r310, int r311, long r312) {
        if (r312 != (-1)) goto L5;
        long r110 = this.mNetworkHandle;
    L6:
        Object r111 = this.mLock;
        monitor-enter(r111);
        checkHaveAdapter();     // Catch: Throwable -> L13
        CronetBidirectionalStream r100 = new CronetBidirectionalStream(this, r210, r215, r211, r212, r213, r214, r216, r217, r218, r219, r310, r311, r110);     // Catch: Throwable -> L17
        monitor-exit(r111);     // Catch: Throwable -> L17
        return r100;
    L17:
        th = th;
    L15:
        monitor-exit(r111);     // Catch: Throwable -> L17
        throw th;
    L13:
        th = th;
        goto L15
    L5:
        r110 = r312;
        goto L6
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public TTWebsocketConnection createWebsocketConnection(TTWebsocketConnection.Callback r210, Executor r211, List<String> r212, int r213, String r214, long r215, int r216, long r217, String r310, int r311, String r312, Map<String, String> r313, Map<String, String> r314, boolean r315) {
        return new CronetWebsocketConnection(this, r210, r211, r212, r213, r214, r215, r216, r217, r310, r311, r312, r313, r314, r315);
    }

    @Override // com.ttnet.org.chromium.net.impl.CronetEngineBase
    public UrlRequestBase createRequest(String r210, UrlRequest.Callback r211, Executor r212, int r213, Collection<Object> r214, boolean r215, boolean r216, boolean r217, boolean r218, int r310, boolean r311, int r312, RequestFinishedInfo.Listener r313, int r314, long r315) {
        if (r315 != (-1)) goto L5;
        long r110 = this.mNetworkHandle;
    L6:
        Object r111 = this.mLock;
        monitor-enter(r111);
        checkHaveAdapter();     // Catch: Throwable -> L13
        CronetUrlRequest r100 = new CronetUrlRequest(this, r210, r213, r211, r212, r214, r215, r216, r217, r218, r310, r311, r312, r313, r314, r110);     // Catch: Throwable -> L17
        monitor-exit(r111);     // Catch: Throwable -> L17
        return r100;
    L17:
        th = th;
    L15:
        monitor-exit(r111);     // Catch: Throwable -> L17
        throw th;
    L13:
        th = th;
        goto L15
    L5:
        r110 = r315;
        goto L6
    }

    private void onContextInitCompleted(long r310, long r311, long r410, long r411, long r412, long r413, long r414, long r510, long r511, long r512, long r513, long r514, long r610, long r611, long r612, long r613, String r614, String r615) {
        TTCronetInitTimingInfo.sNativeInitTimingJson = r614;
        TTCronetInitTimingInfo.sABTest = r615;
        this.mInitCompleted.open();
        TTEventListener r100 = this.mEventListener;
        if (r100 == null) goto L6;
        r100.onContextInitCompleted(r310, r311, r410, r411, r412, r413, r414, r510, r511, r512, r513, r514, r610, r611, r612, r613);
        return;
    }

    private void handleApiResult(boolean r410, String r411, String r412, String r413, long r414, long r415, long r416, long r510, long r511, long r512, long r513, long r514, long r610, long r611, boolean r612, long r613, long r614, long r710, String r711, String r712, String r713, int r714, int r715, String r716, String r717) {
        TTMonitorProvider r100 = this.mAppMonitorProvider;
        if (r100 == null) goto L6;
        r100.handleApiResult(r410, r411, r412, r413, r414, r415, r416, r510, r511, r512, r513, r514, r610, r611, r612, r613, r614, r710, r711, r712, r713, r714, r715, r716, r717);
        return;
    }
}
