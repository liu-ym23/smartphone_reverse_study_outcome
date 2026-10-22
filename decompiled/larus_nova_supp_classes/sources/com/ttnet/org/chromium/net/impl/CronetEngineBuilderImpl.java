package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.ICronetEngineBuilder;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTEventListener;
import com.ttnet.org.chromium.net.TTMonitorProvider;
import com.ttnet.org.chromium.net.TTSamplingSettingProvider;
import com.ttnet.org.chromium.net.TTThreadConfigInfoProvider;
import java.net.IDN;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public abstract class CronetEngineBuilderImpl extends ICronetEngineBuilder {
    private static final Pattern INVALID_PKP_HOST_NAME = null;
    private static final int INVALID_THREAD_PRIORITY = 20;
    private static final String JAVA_CRONET_IMPL_CLASS = "com.ttnet.org.chromium.net.impl.JavaCronetEngine";
    private static final String NATIVE_CRONET_IMPL_CLASS = "com.ttnet.org.chromium.net.impl.CronetUrlRequestContext";
    private static String TAG;
    private long mALogFuncAddr;
    private TTAppInfoProvider mAppInfoProvider;
    private TTAppInfoProvider.AppInfo mAppInfoSubset;
    private TTMonitorProvider mAppMonitorProvider;
    private int mAppSecurityLevel;
    private final Context mApplicationContext;
    private String mBoeJson;
    private boolean mBoeProxyEnabled;
    private boolean mBrotiEnabled;
    private TTThreadConfigInfoProvider.Callback mCallback;
    private Map<String[], Pair<byte[], byte[]>> mClientOpaqueData;
    private String mCronetSoPath;
    private boolean mDisableCache;
    private TTEventListener mEventListener;
    private String mExperimentalOptions;
    private String mGetDomainDefaultJSON;
    private boolean mHttp2Enabled;
    private long mHttpCacheMaxSize;
    private HttpCacheMode mHttpCacheMode;
    private boolean mHttpDnsEnabled;
    private boolean mIsMainProcess;
    private boolean mLazyInitIPC;
    private boolean mListenAppStateIndependently;
    protected long mMockCertVerifier;
    private boolean mNetworkQualityEstimatorEnabled;
    private ArrayList<byte[]> mOpaqueData;
    private boolean mOptInit;
    private boolean mOptNqeDefault;
    private boolean mOptNqePersist;
    private boolean mOptStack;
    private final List<Pkp> mPkps;
    private String mProcessName;
    private String mProxyConfig;
    private boolean mPublicKeyPinningBypassForLocalTrustAnchorsEnabled;
    private boolean mQuicEnabled;
    private final List<QuicHint> mQuicHints;
    private TTSamplingSettingProvider.TTSlaSamplingSetting mSlaSamplingSetting;
    private String mStoragePath;
    private String mStoreIdcRuleJson;
    private long mTTNetInitStart;
    private int mTelemetryOptionFlags;
    private ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> mThreadConfigInfoList;
    private int mThreadPriority;
    private String mThreadStackInitReason;
    private boolean mTncSecureModeEnabled;
    private String mUserAgent;
    private boolean mVerboseLogEnabled;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.impl.CronetEngineBuilderImpl$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ttnet$org$chromium$net$impl$CronetEngineBuilderImpl$HttpCacheMode = null;

        static {
            int[] r0 = new int[HttpCacheMode.values().length];
            $SwitchMap$com$ttnet$org$chromium$net$impl$CronetEngineBuilderImpl$HttpCacheMode = r0;
            r0[HttpCacheMode.DISABLED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ttnet$org$chromium$net$impl$CronetEngineBuilderImpl$HttpCacheMode[HttpCacheMode.DISK_NO_HTTP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$ttnet$org$chromium$net$impl$CronetEngineBuilderImpl$HttpCacheMode[HttpCacheMode.DISK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$ttnet$org$chromium$net$impl$CronetEngineBuilderImpl$HttpCacheMode[HttpCacheMode.MEMORY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    /* JADX INFO: renamed from: enableSdch, reason: collision with other method in class */
    public CronetEngineBuilderImpl m16enableSdch(boolean r1) {
        return this;
    }

    public VersionSafeCallbacks.LibraryLoader libraryLoader() {
        return null;
    }

    /* JADX INFO: renamed from: setLibraryLoader, reason: collision with other method in class */
    public CronetEngineBuilderImpl m31setLibraryLoader(CronetEngine.Builder.LibraryLoader r1) {
        return this;
    }

    static {
        INVALID_PKP_HOST_NAME = PatternProtector.compile("^[0-9\\.]*$");
    }

    public boolean cacheDisabled() {
        return !this.mHttpCacheMode.isContentCacheEnabled();
    }

    public String getDefaultQuicUserAgentId() {
        if (this.mQuicEnabled == true) goto L7;
        return XmlPullParser.NO_NAMESPACE;
    L7:
        return UserAgent.getQuicUserAgentIdFrom(this.mApplicationContext);
    }

    public String getDefaultUserAgent() {
        return UserAgent.from(this.mApplicationContext);
    }

    public int httpCacheMode() {
        return this.mHttpCacheMode.getType();
    }

    public int publicBuilderHttpCacheMode() {
        return this.mHttpCacheMode.toPublicBuilderCacheMode();
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableVerboseLog() {
        return m18enableVerboseLog();
    }

    public TTAppInfoProvider.AppInfo TTAppInfoSubset() {
        return this.mAppInfoSubset;
    }

    public long aLogFuncAddr() {
        return this.mALogFuncAddr;
    }

    public boolean boeProxyEnabled() {
        return this.mBoeProxyEnabled;
    }

    public boolean brotliEnabled() {
        return this.mBrotiEnabled;
    }

    public String experimentalOptions() {
        return this.mExperimentalOptions;
    }

    public TTAppInfoProvider getAppInfoProvider() {
        return this.mAppInfoProvider;
    }

    public TTMonitorProvider getAppMonitorProvider() {
        return this.mAppMonitorProvider;
    }

    public int getAppSecurityLevel() {
        return this.mAppSecurityLevel;
    }

    public String getBypassBOEJSON() {
        return this.mBoeJson;
    }

    public Map<String[], Pair<byte[], byte[]>> getClientOpaqueData() {
        return this.mClientOpaqueData;
    }

    public Context getContext() {
        return this.mApplicationContext;
    }

    public String getCronetSoPath() {
        return this.mCronetSoPath;
    }

    public TTEventListener getEventListener() {
        return this.mEventListener;
    }

    public String getGetDomainDefaultJSON() {
        return this.mGetDomainDefaultJSON;
    }

    public boolean getListenAppStateIndependently() {
        return this.mListenAppStateIndependently;
    }

    public ArrayList<byte[]> getOpaqueData() {
        return this.mOpaqueData;
    }

    public String getProxyConfig() {
        return this.mProxyConfig;
    }

    public String getStoreIdcRuleJSON() {
        return this.mStoreIdcRuleJson;
    }

    public int getTelemetryOptionFlags() {
        return this.mTelemetryOptionFlags;
    }

    public String getUserAgent() {
        return this.mUserAgent;
    }

    public boolean http2Enabled() {
        return this.mHttp2Enabled;
    }

    public long httpCacheMaxSize() {
        return this.mHttpCacheMaxSize;
    }

    public boolean httpDnsEnabled() {
        return this.mHttpDnsEnabled;
    }

    public boolean isMainProcess() {
        return this.mIsMainProcess;
    }

    public boolean lazyInitIPC() {
        return this.mLazyInitIPC;
    }

    public long mockCertVerifier() {
        return this.mMockCertVerifier;
    }

    public boolean networkQualityEstimatorEnabled() {
        return this.mNetworkQualityEstimatorEnabled;
    }

    public boolean optInit() {
        return this.mOptInit;
    }

    public boolean optNqeDefault() {
        return this.mOptNqeDefault;
    }

    public boolean optNqePersist() {
        return this.mOptNqePersist;
    }

    public boolean optStack() {
        return this.mOptStack;
    }

    public String processName() {
        return this.mProcessName;
    }

    public boolean publicKeyPinningBypassForLocalTrustAnchorsEnabled() {
        return this.mPublicKeyPinningBypassForLocalTrustAnchorsEnabled;
    }

    public List<Pkp> publicKeyPins() {
        return this.mPkps;
    }

    public boolean quicEnabled() {
        return this.mQuicEnabled;
    }

    public List<QuicHint> quicHints() {
        return this.mQuicHints;
    }

    public TTSamplingSettingProvider.TTSlaSamplingSetting samplingSetting() {
        return this.mSlaSamplingSetting;
    }

    public String storagePath() {
        return this.mStoragePath;
    }

    public TTThreadConfigInfoProvider.Callback threadConfigCallbackImpl() {
        return this.mCallback;
    }

    public ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> threadConfigInfoList() {
        return this.mThreadConfigInfoList;
    }

    public String threadStackInitReason() {
        return this.mThreadStackInitReason;
    }

    public boolean tncSecureModeEnabled() {
        return this.mTncSecureModeEnabled;
    }

    public long ttnetInitStart() {
        return this.mTTNetInitStart;
    }

    public boolean verboseLogEnabled() {
        return this.mVerboseLogEnabled;
    }

    /* JADX INFO: renamed from: enableVerboseLog, reason: collision with other method in class */
    public CronetEngineBuilderImpl m18enableVerboseLog() {
        this.mVerboseLogEnabled = true;
        return this;
    }

    private static String validateHostNameForPinningAndConvert(String r3) throws IllegalArgumentException {
        boolean r0 = INVALID_PKP_HOST_NAME.matcher(r3).matches();     // Catch: IllegalArgumentException -> L4
    L6:
        if (r0 == true) goto L17;
        if (r3.length() > 255) goto L15;
        return IDN.toASCII(r3, 2);
    L13:
        throw new IllegalArgumentException("Hostname " + r3 + " is illegal. The name of the host does not comply with RFC 1122 and RFC 1123.");
    L15:
        throw new IllegalArgumentException("Hostname " + r3 + " is too long. The name of the host does not comply with RFC 1122 and RFC 1123.");
    L17:
        throw new IllegalArgumentException("Hostname " + r3 + " is illegal. A hostname should not consist of digits and/or dots only.");
    L4:
        r0 = false;
        goto L6
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableBoeProxy(boolean r1) {
        return m8enableBoeProxy(r1);
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableBrotli(boolean r1) {
        return m9enableBrotli(r1);
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableHttp2(boolean r1) {
        return m10enableHttp2(r1);
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableHttpDns(boolean r1) {
        return m12enableHttpDns(r1);
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableNetworkQualityEstimator(boolean r1) {
        return m13enableNetworkQualityEstimator(r1);
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean r1) {
        return m14enablePublicKeyPinningBypassForLocalTrustAnchors(r1);
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableQuic(boolean r1) {
        return m15enableQuic(r1);
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableSdch(boolean r1) {
        return m16enableSdch(r1);
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableTncSecureMode(boolean r1) {
        return m17enableTncSecureMode(r1);
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder listenAppStateIndependently(boolean r1) {
        return m19listenAppStateIndependently(r1);
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder setALogFuncAddr(long r1) {
        return m20setALogFuncAddr(r1);
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder setAppInfoProvider(TTAppInfoProvider r1) {
        return m21setAppInfoProvider(r1);
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder setAppMonitorProvider(TTMonitorProvider r1) {
        return m22setAppMonitorProvider(r1);
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder setAppSecurityLevel(int r1) {
        return m23setAppSecurityLevel(r1);
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder setBypassBOEJSON(String r1) {
        return m24setBypassBOEJSON(r1);
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder setClientOpaqueData(Map r1) {
        return m25setClientOpaqueData(r1);
    }

    public ICronetEngineBuilder setCronetSoPath(String r1) {
        this.mCronetSoPath = r1;
        return this;
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder setEventListener(TTEventListener r1) {
        return m26setEventListener(r1);
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder setExperimentalOptions(String r1) {
        return m27setExperimentalOptions(r1);
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder setGetDomainDefaultJSON(String r1) {
        return m28setGetDomainDefaultJSON(r1);
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder setIsMainProcess(boolean r1) {
        return m29setIsMainProcess(r1);
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder setLazyInitIPC(boolean r1) {
        return m30setLazyInitIPC(r1);
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder setLibraryLoader(CronetEngine.Builder.LibraryLoader r1) {
        return m31setLibraryLoader(r1);
    }

    public CronetEngineBuilderImpl setMockCertVerifierForTesting(long r1) {
        this.mMockCertVerifier = r1;
        return this;
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder setOpaqueData(ArrayList r1) {
        return m32setOpaqueData(r1);
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder setOptInit(boolean r1) {
        return m33setOptInit(r1);
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder setProcessName(String r1) {
        return m35setProcessName(r1);
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder setProxyConfig(String r1) {
        return m36setProxyConfig(r1);
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder setSlaSamplingSetting(TTSamplingSettingProvider.TTSlaSamplingSetting r1) {
        return m37setSlaSamplingSetting(r1);
    }

    /* JADX INFO: renamed from: setStoragePath, reason: collision with other method in class */
    public CronetEngineBuilderImpl m39setStoragePath(String r3) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r3);
        if (r0.exists() == true) goto L10;
        if (r0.mkdirs() == true) goto L10;
        throw new IllegalArgumentException("create Storage path failed");
    L10:
        if (r0.isDirectory() == false) goto L14;
        this.mStoragePath = r3;
        return this;
    L14:
        throw new IllegalArgumentException("Storage path must be set to existing directory");
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder setStoreIdcRuleJSON(String r1) {
        return m40setStoreIdcRuleJSON(r1);
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder setTTAppInfoColdStartSubset(TTAppInfoProvider.AppInfo r1) {
        return m41setTTAppInfoColdStartSubset(r1);
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder setTTNetInitStart(long r1) {
        return m42setTTNetInitStart(r1);
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder setTelemetryOptionFlags(int r1) {
        return m43setTelemetryOptionFlags(r1);
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder setThreadConfigCallbackImpl(TTThreadConfigInfoProvider.Callback r1) {
        return m44setThreadConfigCallbackImpl(r1);
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder setThreadConfigInfoList(ArrayList r1) {
        return m45setThreadConfigInfoList(r1);
    }

    /* JADX INFO: renamed from: setThreadPriority, reason: collision with other method in class */
    public CronetEngineBuilderImpl m46setThreadPriority(int r2) {
        if (r2 > 19) goto L9;
        if (r2 < (-20)) goto L9;
        this.mThreadPriority = r2;
        return this;
    L9:
        throw new IllegalArgumentException("Thread priority invalid");
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder setUserAgent(String r1) {
        return m47setUserAgent(r1);
    }

    public int threadPriority(int r3) {
        int r0 = this.mThreadPriority;
        if (r0 != INVALID_THREAD_PRIORITY) goto L6;
        return r3;
    L6:
        return r0;
    }

    /* JADX INFO: renamed from: enableBoeProxy, reason: collision with other method in class */
    public CronetEngineBuilderImpl m8enableBoeProxy(boolean r1) {
        this.mBoeProxyEnabled = r1;
        return this;
    }

    /* JADX INFO: renamed from: enableBrotli, reason: collision with other method in class */
    public CronetEngineBuilderImpl m9enableBrotli(boolean r1) {
        this.mBrotiEnabled = r1;
        return this;
    }

    /* JADX INFO: renamed from: enableHttp2, reason: collision with other method in class */
    public CronetEngineBuilderImpl m10enableHttp2(boolean r1) {
        this.mHttp2Enabled = r1;
        return this;
    }

    /* JADX INFO: renamed from: enableHttpDns, reason: collision with other method in class */
    public CronetEngineBuilderImpl m12enableHttpDns(boolean r1) {
        this.mHttpDnsEnabled = r1;
        return this;
    }

    /* JADX INFO: renamed from: enableNetworkQualityEstimator, reason: collision with other method in class */
    public CronetEngineBuilderImpl m13enableNetworkQualityEstimator(boolean r1) {
        this.mNetworkQualityEstimatorEnabled = r1;
        return this;
    }

    /* JADX INFO: renamed from: enablePublicKeyPinningBypassForLocalTrustAnchors, reason: collision with other method in class */
    public CronetEngineBuilderImpl m14enablePublicKeyPinningBypassForLocalTrustAnchors(boolean r1) {
        this.mPublicKeyPinningBypassForLocalTrustAnchorsEnabled = r1;
        return this;
    }

    /* JADX INFO: renamed from: enableQuic, reason: collision with other method in class */
    public CronetEngineBuilderImpl m15enableQuic(boolean r1) {
        this.mQuicEnabled = r1;
        return this;
    }

    /* JADX INFO: renamed from: enableTncSecureMode, reason: collision with other method in class */
    public CronetEngineBuilderImpl m17enableTncSecureMode(boolean r1) {
        this.mTncSecureModeEnabled = r1;
        return this;
    }

    /* JADX INFO: renamed from: listenAppStateIndependently, reason: collision with other method in class */
    public CronetEngineBuilderImpl m19listenAppStateIndependently(boolean r1) {
        this.mListenAppStateIndependently = r1;
        return this;
    }

    /* JADX INFO: renamed from: setALogFuncAddr, reason: collision with other method in class */
    public CronetEngineBuilderImpl m20setALogFuncAddr(long r1) {
        this.mALogFuncAddr = r1;
        return this;
    }

    /* JADX INFO: renamed from: setAppInfoProvider, reason: collision with other method in class */
    public CronetEngineBuilderImpl m21setAppInfoProvider(TTAppInfoProvider r1) {
        this.mAppInfoProvider = r1;
        return this;
    }

    /* JADX INFO: renamed from: setAppMonitorProvider, reason: collision with other method in class */
    public CronetEngineBuilderImpl m22setAppMonitorProvider(TTMonitorProvider r1) {
        this.mAppMonitorProvider = r1;
        return this;
    }

    /* JADX INFO: renamed from: setAppSecurityLevel, reason: collision with other method in class */
    public CronetEngineBuilderImpl m23setAppSecurityLevel(int r1) {
        this.mAppSecurityLevel = r1;
        return this;
    }

    /* JADX INFO: renamed from: setBypassBOEJSON, reason: collision with other method in class */
    public CronetEngineBuilderImpl m24setBypassBOEJSON(String r1) {
        this.mBoeJson = r1;
        return this;
    }

    /* JADX INFO: renamed from: setClientOpaqueData, reason: collision with other method in class */
    public CronetEngineBuilderImpl m25setClientOpaqueData(Map<String[], Pair<byte[], byte[]>> r1) {
        this.mClientOpaqueData = r1;
        return this;
    }

    /* JADX INFO: renamed from: setEventListener, reason: collision with other method in class */
    public CronetEngineBuilderImpl m26setEventListener(TTEventListener r1) {
        this.mEventListener = r1;
        return this;
    }

    /* JADX INFO: renamed from: setExperimentalOptions, reason: collision with other method in class */
    public CronetEngineBuilderImpl m27setExperimentalOptions(String r1) {
        this.mExperimentalOptions = r1;
        return this;
    }

    /* JADX INFO: renamed from: setGetDomainDefaultJSON, reason: collision with other method in class */
    public CronetEngineBuilderImpl m28setGetDomainDefaultJSON(String r1) {
        this.mGetDomainDefaultJSON = r1;
        return this;
    }

    /* JADX INFO: renamed from: setIsMainProcess, reason: collision with other method in class */
    public CronetEngineBuilderImpl m29setIsMainProcess(boolean r1) {
        this.mIsMainProcess = r1;
        return this;
    }

    /* JADX INFO: renamed from: setLazyInitIPC, reason: collision with other method in class */
    public CronetEngineBuilderImpl m30setLazyInitIPC(boolean r1) {
        this.mLazyInitIPC = r1;
        return this;
    }

    /* JADX INFO: renamed from: setOpaqueData, reason: collision with other method in class */
    public CronetEngineBuilderImpl m32setOpaqueData(ArrayList<byte[]> r1) {
        this.mOpaqueData = r1;
        return this;
    }

    /* JADX INFO: renamed from: setOptInit, reason: collision with other method in class */
    public CronetEngineBuilderImpl m33setOptInit(boolean r1) {
        this.mOptInit = r1;
        return this;
    }

    /* JADX INFO: renamed from: setProcessName, reason: collision with other method in class */
    public CronetEngineBuilderImpl m35setProcessName(String r1) {
        this.mProcessName = r1;
        return this;
    }

    /* JADX INFO: renamed from: setProxyConfig, reason: collision with other method in class */
    public CronetEngineBuilderImpl m36setProxyConfig(String r1) {
        this.mProxyConfig = r1;
        return this;
    }

    /* JADX INFO: renamed from: setSlaSamplingSetting, reason: collision with other method in class */
    public CronetEngineBuilderImpl m37setSlaSamplingSetting(TTSamplingSettingProvider.TTSlaSamplingSetting r1) {
        this.mSlaSamplingSetting = r1;
        return this;
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder setStoragePath(String r1) {
        return m39setStoragePath(r1);
    }

    /* JADX INFO: renamed from: setStoreIdcRuleJSON, reason: collision with other method in class */
    public CronetEngineBuilderImpl m40setStoreIdcRuleJSON(String r1) {
        this.mStoreIdcRuleJson = r1;
        return this;
    }

    /* JADX INFO: renamed from: setTTAppInfoColdStartSubset, reason: collision with other method in class */
    public CronetEngineBuilderImpl m41setTTAppInfoColdStartSubset(TTAppInfoProvider.AppInfo r1) {
        this.mAppInfoSubset = r1;
        return this;
    }

    /* JADX INFO: renamed from: setTTNetInitStart, reason: collision with other method in class */
    public CronetEngineBuilderImpl m42setTTNetInitStart(long r1) {
        this.mTTNetInitStart = r1;
        return this;
    }

    /* JADX INFO: renamed from: setTelemetryOptionFlags, reason: collision with other method in class */
    public CronetEngineBuilderImpl m43setTelemetryOptionFlags(int r1) {
        this.mTelemetryOptionFlags = r1;
        return this;
    }

    /* JADX INFO: renamed from: setThreadConfigCallbackImpl, reason: collision with other method in class */
    public CronetEngineBuilderImpl m44setThreadConfigCallbackImpl(TTThreadConfigInfoProvider.Callback r1) {
        this.mCallback = r1;
        return this;
    }

    /* JADX INFO: renamed from: setThreadConfigInfoList, reason: collision with other method in class */
    public CronetEngineBuilderImpl m45setThreadConfigInfoList(ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r1) {
        this.mThreadConfigInfoList = r1;
        return this;
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder setThreadPriority(int r1) {
        return m46setThreadPriority(r1);
    }

    /* JADX INFO: renamed from: setUserAgent, reason: collision with other method in class */
    public CronetEngineBuilderImpl m47setUserAgent(String r1) {
        this.mUserAgent = r1;
        return this;
    }

    public CronetEngineBuilderImpl(Context r4, boolean r5) {
        this.mQuicHints = new LinkedList();
        this.mPkps = new LinkedList();
        this.mThreadPriority = INVALID_THREAD_PRIORITY;
        this.mTelemetryOptionFlags = 0;
        this.mApplicationContext = r4.getApplicationContext();
        m15enableQuic(true);
        m10enableHttp2(true);
        m9enableBrotli(false);
        m11enableHttpCache(0, 0);
        m13enableNetworkQualityEstimator(false);
        m14enablePublicKeyPinningBypassForLocalTrustAnchors(true);
        m12enableHttpDns(false);
        m19listenAppStateIndependently(false);
        if (r5 == true) goto L5;
        TAG = "CronetEngineBuilderImpl";
        return;
    L5:
        TAG = "CronetEngineBuilderImpl";
    }

    /* JADX INFO: renamed from: enableHttpCache, reason: collision with other method in class */
    public CronetEngineBuilderImpl m11enableHttpCache(int r3, long r4) {
        HttpCacheMode r5 = HttpCacheMode.fromPublicBuilderCacheMode(r3);
        if (r5.getType() == 1) goto L5;
    L9:
        this.mHttpCacheMode = r5;
        this.mHttpCacheMaxSize = r4;
        return this;
    L5:
        if (storagePath() != null) goto L9;
        throw new IllegalArgumentException("Storage path must be set");
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder setOptNqeInit(boolean r1, boolean r2) {
        return m34setOptNqeInit(r1, r2);
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder setStackInfo(boolean r1, String r2) {
        return m38setStackInfo(r1, r2);
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableHttpCache(int r1, long r2) {
        return m11enableHttpCache(r1, r2);
    }

    /* JADX INFO: renamed from: setOptNqeInit, reason: collision with other method in class */
    public CronetEngineBuilderImpl m34setOptNqeInit(boolean r1, boolean r2) {
        this.mOptNqeDefault = r1;
        this.mOptNqePersist = r2;
        return this;
    }

    /* JADX INFO: renamed from: setStackInfo, reason: collision with other method in class */
    public CronetEngineBuilderImpl m38setStackInfo(boolean r1, String r2) {
        this.mOptStack = r1;
        this.mThreadStackInitReason = r2;
        return this;
    }

    /* JADX INFO: renamed from: addQuicHint, reason: collision with other method in class */
    public CronetEngineBuilderImpl m7addQuicHint(String r3, int r4, int r5) {
        if (r3.contains("/") == true) goto L7;
        this.mQuicHints.add(new QuicHint(r3, r4, r5));
        return this;
    L7:
        throw new IllegalArgumentException("Illegal QUIC Hint Host: ".concat(r3));
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder addQuicHint(String r1, int r2, int r3) {
        return m7addQuicHint(r1, r2, r3);
    }

    /* JADX INFO: renamed from: addPublicKeyPins, reason: collision with other method in class */
    public CronetEngineBuilderImpl m6addPublicKeyPins(String r5, Set<byte[]> r6, boolean r7, Date r8) {
        if (r5 == null) goto L22;
        if (r6 == null) goto L20;
        if (r8 == null) goto L18;
        String r9 = validateHostNameForPinningAndConvert(r5);
        HashMap r0 = new HashMap();
        Iterator<byte[]> r10 = r6.iterator();
    L7:
        if (r10.hasNext() == false) goto L15;
        byte[] r1 = r10.next();
        if (r1 == null) goto L14;
        if (r1.length != 32) goto L14;
        r0.put(Base64.encodeToString(r1, 0), r1);
    L14:
        throw new IllegalArgumentException("Public key pin is invalid");
    L15:
        this.mPkps.add(new Pkp(r9, (byte[][]) r0.values().toArray(new byte[r0.size()][]), r7, r8));
        return this;
    L18:
        throw new NullPointerException("The pin expiration date cannot be null");
    L20:
        throw new NullPointerException("The set of SHA256 pins cannot be null");
    L22:
        throw new NullPointerException("The hostname cannot be null");
    }

    public /* bridge */ /* synthetic */ ICronetEngineBuilder addPublicKeyPins(String r1, Set r2, boolean r3, Date r4) {
        return m6addPublicKeyPins(r1, r2, r3, r4);
    }
}
