package com.ttnet.org.chromium.net.impl;

import android.content.Context;
import android.util.Base64;
import android.util.Pair;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.ICronetEngineBuilder;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import com.ttnet.org.chromium.net.TTEventListener;
import com.ttnet.org.chromium.net.TTMonitorProvider;
import com.ttnet.org.chromium.net.TTSamplingSettingProvider;
import com.ttnet.org.chromium.net.TTThreadConfigInfoProvider;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
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
import r27.a;

/* JADX INFO: loaded from: classes.dex */
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
            int[] r100 = new int[HttpCacheMode.values().length];
            $SwitchMap$com$ttnet$org$chromium$net$impl$CronetEngineBuilderImpl$HttpCacheMode = r100;
            r100[HttpCacheMode.DISABLED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$ttnet$org$chromium$net$impl$CronetEngineBuilderImpl$HttpCacheMode[HttpCacheMode.DISK_NO_HTTP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$ttnet$org$chromium$net$impl$CronetEngineBuilderImpl$HttpCacheMode[HttpCacheMode.DISK.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$ttnet$org$chromium$net$impl$CronetEngineBuilderImpl$HttpCacheMode[HttpCacheMode.MEMORY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final enum HttpCacheMode extends Enum<HttpCacheMode> {
        private static final /* synthetic */ HttpCacheMode[] $VALUES = null;
        public static final HttpCacheMode DISABLED = null;
        public static final HttpCacheMode DISK = null;
        public static final HttpCacheMode DISK_NO_HTTP = null;
        public static final HttpCacheMode MEMORY = null;
        private final boolean mContentCacheEnabled;
        private final int mType;

        static {
            HttpCacheMode r100 = new HttpCacheMode("DISABLED", 0, 0, false);
            DISABLED = r100;
            HttpCacheMode r101 = new HttpCacheMode("DISK", 1, 1, true);
            DISK = r101;
            HttpCacheMode r102 = new HttpCacheMode("DISK_NO_HTTP", 2, 1, false);
            DISK_NO_HTTP = r102;
            HttpCacheMode r103 = new HttpCacheMode("MEMORY", 3, 2, true);
            MEMORY = r103;
            $VALUES = new HttpCacheMode[]{r100, r101, r102, r103};
        }

        public static HttpCacheMode[] values() {
            return (HttpCacheMode[]) $VALUES.clone();
        }

        public int toPublicBuilderCacheMode() {
            int r100 = AnonymousClass1.$SwitchMap$com$ttnet$org$chromium$net$impl$CronetEngineBuilderImpl$HttpCacheMode[ordinal()];
            if (r100 == 1) goto L14;
            int r101 = 2;
            if (r100 == 2) goto L13;
            r101 = 3;
            if (r100 == 3) goto L13;
            if (r100 != 4) goto L12;
            return 1;
        L12:
            throw new IllegalArgumentException("Unknown internal builder cache mode");
        L13:
            return r101;
        L14:
            return 0;
        }

        public int getType() {
            return this.mType;
        }

        public boolean isContentCacheEnabled() {
            return this.mContentCacheEnabled;
        }

        public static HttpCacheMode fromPublicBuilderCacheMode(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 != 3) goto L12;
            return DISK;
        L12:
            throw new IllegalArgumentException("Unknown public builder cache mode");
        L14:
            return DISK_NO_HTTP;
        L16:
            return MEMORY;
        L18:
            return DISABLED;
        }

        public static HttpCacheMode valueOf(String r100) {
            return (HttpCacheMode) a.a(HttpCacheMode.class, r100);
        }

        private HttpCacheMode(String r100, int r101, int r102, boolean r103) {
            super(r100, r101);
            this.mContentCacheEnabled = r103;
            this.mType = r102;
        }
    }

    /* JADX INFO: loaded from: classes41.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface HttpCacheSetting {
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class Pkp {
        final Date mExpirationDate;
        final byte[][] mHashes;
        final String mHost;
        final boolean mIncludeSubdomains;

        public Pkp(String r100, byte[][] r101, boolean r102, Date r103) {
            this.mHost = r100;
            this.mHashes = r101;
            this.mIncludeSubdomains = r102;
            this.mExpirationDate = r103;
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class QuicHint {
        final int mAlternatePort;
        final String mHost;
        final int mPort;

        public QuicHint(String r100, int r101, int r102) {
            this.mHost = r100;
            this.mPort = r101;
            this.mAlternatePort = r102;
        }
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableSdch(boolean r100) {
        return this;
    }

    public VersionSafeCallbacks.LibraryLoader libraryLoader() {
        return null;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setLibraryLoader(CronetEngine.Builder.LibraryLoader r100) {
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
        return "";
    L7:
        return UserAgent.getQuicUserAgentIdFrom(this.mApplicationContext);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public String getDefaultUserAgent() {
        return UserAgent.from(this.mApplicationContext);
    }

    public int httpCacheMode() {
        return this.mHttpCacheMode.getType();
    }

    public int publicBuilderHttpCacheMode() {
        return this.mHttpCacheMode.toPublicBuilderCacheMode();
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableVerboseLog() {
        return enableVerboseLog();
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

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableVerboseLog() {
        this.mVerboseLogEnabled = true;
        return this;
    }

    private static String validateHostNameForPinningAndConvert(String r100) throws IllegalArgumentException {
        boolean r101 = INVALID_PKP_HOST_NAME.matcher(r100).matches();     // Catch: IllegalArgumentException -> L4
    L6:
        if (r101 == true) goto L17;
        if (r100.length() > 255) goto L15;
        return IDN.toASCII(r100, 2);
    L13:
        throw new IllegalArgumentException("Hostname " + r100 + " is illegal. The name of the host does not comply with RFC 1122 and RFC 1123.");
    L15:
        throw new IllegalArgumentException("Hostname " + r100 + " is too long. The name of the host does not comply with RFC 1122 and RFC 1123.");
    L17:
        throw new IllegalArgumentException("Hostname " + r100 + " is illegal. A hostname should not consist of digits and/or dots only.");
    L4:
        r101 = false;
        goto L6
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableBoeProxy(boolean r100) {
        return enableBoeProxy(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableBrotli(boolean r100) {
        return enableBrotli(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableHttp2(boolean r100) {
        return enableHttp2(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableHttpDns(boolean r100) {
        return enableHttpDns(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableNetworkQualityEstimator(boolean r100) {
        return enableNetworkQualityEstimator(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean r100) {
        return enablePublicKeyPinningBypassForLocalTrustAnchors(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableQuic(boolean r100) {
        return enableQuic(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableSdch(boolean r100) {
        return enableSdch(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableTncSecureMode(boolean r100) {
        return enableTncSecureMode(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder listenAppStateIndependently(boolean r100) {
        return listenAppStateIndependently(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setALogFuncAddr(long r100) {
        return setALogFuncAddr(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setAppInfoProvider(TTAppInfoProvider r100) {
        return setAppInfoProvider(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setAppMonitorProvider(TTMonitorProvider r100) {
        return setAppMonitorProvider(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setAppSecurityLevel(int r100) {
        return setAppSecurityLevel(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setBypassBOEJSON(String r100) {
        return setBypassBOEJSON(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setClientOpaqueData(Map r100) {
        return setClientOpaqueData(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public ICronetEngineBuilder setCronetSoPath(String r100) {
        this.mCronetSoPath = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setEventListener(TTEventListener r100) {
        return setEventListener(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setExperimentalOptions(String r100) {
        return setExperimentalOptions(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setGetDomainDefaultJSON(String r100) {
        return setGetDomainDefaultJSON(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setIsMainProcess(boolean r100) {
        return setIsMainProcess(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setLazyInitIPC(boolean r100) {
        return setLazyInitIPC(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setLibraryLoader(CronetEngine.Builder.LibraryLoader r100) {
        return setLibraryLoader(r100);
    }

    public CronetEngineBuilderImpl setMockCertVerifierForTesting(long r100) {
        this.mMockCertVerifier = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setOpaqueData(ArrayList r100) {
        return setOpaqueData(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setOptInit(boolean r100) {
        return setOptInit(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setProcessName(String r100) {
        return setProcessName(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setProxyConfig(String r100) {
        return setProxyConfig(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setSlaSamplingSetting(TTSamplingSettingProvider.TTSlaSamplingSetting r100) {
        return setSlaSamplingSetting(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setStoragePath(String r100) {
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L10;
        if (r101.mkdirs() == true) goto L10;
        throw new IllegalArgumentException("create Storage path failed");
    L10:
        if (r101.isDirectory() == false) goto L14;
        this.mStoragePath = r100;
        return this;
    L14:
        throw new IllegalArgumentException("Storage path must be set to existing directory");
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setStoreIdcRuleJSON(String r100) {
        return setStoreIdcRuleJSON(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setTTAppInfoColdStartSubset(TTAppInfoProvider.AppInfo r100) {
        return setTTAppInfoColdStartSubset(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setTTNetInitStart(long r100) {
        return setTTNetInitStart(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setTelemetryOptionFlags(int r100) {
        return setTelemetryOptionFlags(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setThreadConfigCallbackImpl(TTThreadConfigInfoProvider.Callback r100) {
        return setThreadConfigCallbackImpl(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setThreadConfigInfoList(ArrayList r100) {
        return setThreadConfigInfoList(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setThreadPriority(int r100) {
        if (r100 > 19) goto L9;
        if (r100 < (-20)) goto L9;
        this.mThreadPriority = r100;
        return this;
    L9:
        throw new IllegalArgumentException("Thread priority invalid");
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setUserAgent(String r100) {
        return setUserAgent(r100);
    }

    public int threadPriority(int r100) {
        int r101 = this.mThreadPriority;
        if (r101 != 20) goto L6;
        return r100;
    L6:
        return r101;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableBoeProxy(boolean r100) {
        this.mBoeProxyEnabled = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableBrotli(boolean r100) {
        this.mBrotiEnabled = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableHttp2(boolean r100) {
        this.mHttp2Enabled = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableHttpDns(boolean r100) {
        this.mHttpDnsEnabled = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableNetworkQualityEstimator(boolean r100) {
        this.mNetworkQualityEstimatorEnabled = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enablePublicKeyPinningBypassForLocalTrustAnchors(boolean r100) {
        this.mPublicKeyPinningBypassForLocalTrustAnchorsEnabled = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableQuic(boolean r100) {
        this.mQuicEnabled = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableTncSecureMode(boolean r100) {
        this.mTncSecureModeEnabled = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl listenAppStateIndependently(boolean r100) {
        this.mListenAppStateIndependently = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setALogFuncAddr(long r100) {
        this.mALogFuncAddr = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setAppInfoProvider(TTAppInfoProvider r100) {
        this.mAppInfoProvider = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setAppMonitorProvider(TTMonitorProvider r100) {
        this.mAppMonitorProvider = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setAppSecurityLevel(int r100) {
        this.mAppSecurityLevel = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setBypassBOEJSON(String r100) {
        this.mBoeJson = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setClientOpaqueData(Map<String[], Pair<byte[], byte[]>> r100) {
        this.mClientOpaqueData = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setEventListener(TTEventListener r100) {
        this.mEventListener = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setExperimentalOptions(String r100) {
        this.mExperimentalOptions = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setGetDomainDefaultJSON(String r100) {
        this.mGetDomainDefaultJSON = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setIsMainProcess(boolean r100) {
        this.mIsMainProcess = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setLazyInitIPC(boolean r100) {
        this.mLazyInitIPC = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setOpaqueData(ArrayList<byte[]> r100) {
        this.mOpaqueData = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setOptInit(boolean r100) {
        this.mOptInit = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setProcessName(String r100) {
        this.mProcessName = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setProxyConfig(String r100) {
        this.mProxyConfig = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setSlaSamplingSetting(TTSamplingSettingProvider.TTSlaSamplingSetting r100) {
        this.mSlaSamplingSetting = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setStoragePath(String r100) {
        return setStoragePath(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setStoreIdcRuleJSON(String r100) {
        this.mStoreIdcRuleJson = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setTTAppInfoColdStartSubset(TTAppInfoProvider.AppInfo r100) {
        this.mAppInfoSubset = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setTTNetInitStart(long r100) {
        this.mTTNetInitStart = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setTelemetryOptionFlags(int r100) {
        this.mTelemetryOptionFlags = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setThreadConfigCallbackImpl(TTThreadConfigInfoProvider.Callback r100) {
        this.mCallback = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setThreadConfigInfoList(ArrayList<TTThreadConfigInfoProvider.ThreadConfigInfo> r100) {
        this.mThreadConfigInfoList = r100;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setThreadPriority(int r100) {
        return setThreadPriority(r100);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setUserAgent(String r100) {
        this.mUserAgent = r100;
        return this;
    }

    public CronetEngineBuilderImpl(Context r100, boolean r101) {
        this.mQuicHints = new LinkedList();
        this.mPkps = new LinkedList();
        this.mThreadPriority = 20;
        this.mTelemetryOptionFlags = 0;
        this.mApplicationContext = r100.getApplicationContext();
        enableQuic(true);
        enableHttp2(true);
        enableBrotli(false);
        enableHttpCache(0, 0);
        enableNetworkQualityEstimator(false);
        enablePublicKeyPinningBypassForLocalTrustAnchors(true);
        enableHttpDns(false);
        listenAppStateIndependently(false);
        if (r101 == true) goto L5;
        TAG = "CronetEngineBuilderImpl";
        return;
    L5:
        TAG = "CronetEngineBuilderImpl";
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl enableHttpCache(int r100, long r101) {
        HttpCacheMode r102 = HttpCacheMode.fromPublicBuilderCacheMode(r100);
        if (r102.getType() == 1) goto L5;
    L9:
        this.mHttpCacheMode = r102;
        this.mHttpCacheMaxSize = r101;
        return this;
    L5:
        if (storagePath() != null) goto L9;
        throw new IllegalArgumentException("Storage path must be set");
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setOptNqeInit(boolean r100, boolean r101) {
        return setOptNqeInit(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder setStackInfo(boolean r100, String r101) {
        return setStackInfo(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder enableHttpCache(int r100, long r101) {
        return enableHttpCache(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setOptNqeInit(boolean r100, boolean r101) {
        this.mOptNqeDefault = r100;
        this.mOptNqePersist = r101;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl setStackInfo(boolean r100, String r101) {
        this.mOptStack = r100;
        this.mThreadStackInitReason = r101;
        return this;
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl addQuicHint(String r100, int r101, int r102) {
        if (r100.contains(HTTP.URL_DEFAULT) == true) goto L7;
        this.mQuicHints.add(new QuicHint(r100, r101, r102));
        return this;
    L7:
        throw new IllegalArgumentException("Illegal QUIC Hint Host: ".concat(r100));
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder addQuicHint(String r100, int r101, int r102) {
        return addQuicHint(r100, r101, r102);
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public CronetEngineBuilderImpl addPublicKeyPins(String r100, Set<byte[]> r101, boolean r102, Date r103) {
        if (r100 == null) goto L22;
        if (r101 == null) goto L20;
        if (r103 == null) goto L18;
        String r104 = validateHostNameForPinningAndConvert(r100);
        HashMap r105 = new HashMap();
        Iterator<byte[]> r106 = r101.iterator();
    L7:
        if (r106.hasNext() == false) goto L15;
        byte[] r107 = r106.next();
        if (r107 == null) goto L14;
        if (r107.length != 32) goto L14;
        r105.put(Base64.encodeToString(r107, 0), r107);
    L14:
        throw new IllegalArgumentException("Public key pin is invalid");
    L15:
        this.mPkps.add(new Pkp(r104, (byte[][]) r105.values().toArray(new byte[r105.size()][]), r102, r103));
        return this;
    L18:
        throw new NullPointerException("The pin expiration date cannot be null");
    L20:
        throw new NullPointerException("The set of SHA256 pins cannot be null");
    L22:
        throw new NullPointerException("The hostname cannot be null");
    }

    @Override // com.ttnet.org.chromium.net.ICronetEngineBuilder
    public /* bridge */ /* synthetic */ ICronetEngineBuilder addPublicKeyPins(String r100, Set r101, boolean r102, Date r103) {
        return addPublicKeyPins(r100, r101, r102, r103);
    }
}
