package com.ss.android.ugc.effectmanager;

import android.content.Context;
import android.content.res.AssetManager;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.dora.api.model.FlowDoraWifiScene;
import com.ss.android.ugc.effectmanager.common.listener.IEffectNetWorker;
import com.ss.android.ugc.effectmanager.common.listener.IJsonConverter;
import com.ss.android.ugc.effectmanager.common.listener.IMonitorService;
import com.ss.android.ugc.effectmanager.knadapt.KNExecutor;
import com.ss.android.ugc.effectmanager.knadapt.KNJsonConverter;
import com.ss.android.ugc.effectmanager.knadapt.KNMonitorService;
import com.ss.android.ugc.effectmanager.knadapt.KNNetworkClient;
import com.ss.android.ugc.effectmanager.knadapt.ModelConverterExtKt;
import com.ss.android.ugc.effectmanager.knadapt.ModelListenerAdaptKt;
import com.ss.android.ugc.effectmanager.link.model.host.Host;
import com.ss.ugc.effectplatform.EffectConfig;
import dlc.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes5.dex */
public final class DownloadableModelConfig {
    private final String mAccessKey;
    private final String mAppId;
    private final AssetManager mAssetManager;
    private final Context mContext;
    private final String mDeviceType;
    private final EffectConfiguration mEffectConfiguration;
    private final IEffectNetWorker mEffectNetWorker;
    private final ModelEventListener mEventListener;
    private final Pattern mExclusionPattern;
    private final Executor mExecutor;
    private final FetchModelType mFetchModelType;
    private final List<Host> mHosts;
    private final IJsonConverter mJsonConverter;
    private EffectConfig mKNEffectConfig;
    private final ModelFileEnv mModelFileEnv;
    private final IMonitorService mMonitorService;
    private final String mSdkVersion;
    private final int mThreadCoreSize;
    private final String mWorkspace;

    /* JADX INFO: renamed from: com.ss.android.ugc.effectmanager.DownloadableModelConfig$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes40.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        String mAccessKey;
        String mAppId;
        AssetManager mAssetManager;
        String mBid;
        Context mContext;
        String mDeviceType;
        EffectConfiguration mEffectConfiguration;
        IEffectNetWorker mEffectNetWorker;
        ModelEventListener mEventListener;
        Pattern mExclusionPattern;
        Executor mExecutor;
        FetchModelType mFetchModelType;
        List<Host> mHosts;
        IJsonConverter mJsonConverter;
        private EffectConfig.Builder mKNEffectConfigBuilder;
        ModelFileEnv mModelFileEnv;
        IMonitorService mMonitorService;
        String mSdkVersion;
        int mThreadCoreSize;
        String mWorkspace;

        private EffectConfig buildKNConfig() {
            EffectConfig.Builder r100 = this.mKNEffectConfigBuilder;
            r100.getClass();
            return new EffectConfig(r100);
        }

        public DownloadableModelConfig build() {
            return new DownloadableModelConfig(this, null);
        }

        public Builder() {
            this.mHosts = new ArrayList();
            this.mKNEffectConfigBuilder = new EffectConfig.Builder();
        }

        public static /* synthetic */ EffectConfig access$000(Builder r100) {
            return r100.buildKNConfig();
        }

        public Builder businessBoard(boolean r100) {
            this.mKNEffectConfigBuilder.P = r100;
            return this;
        }

        public Builder enableAsyncMarkUse(boolean r100) {
            this.mKNEffectConfigBuilder.Q = r100;
            return this;
        }

        public Builder enableCKCache(boolean r100) {
            this.mKNEffectConfigBuilder.V = r100;
            return this;
        }

        public Builder enableEpReadDavCache(boolean r100) {
            this.mKNEffectConfigBuilder.enableEpReadDavCache(r100);
            return this;
        }

        public Builder enablePredictCacheClear(boolean r100) {
            this.mKNEffectConfigBuilder.S = r100;
            return this;
        }

        public Builder extraParams(EffectConfig.b r100) {
            this.mKNEffectConfigBuilder.getClass();
            return this;
        }

        public Builder ignoreBuiltInModel(boolean r100) {
            this.mKNEffectConfigBuilder.W = r100;
            return this;
        }

        public Builder ignoreCacheModifiedTime(boolean r100) {
            this.mKNEffectConfigBuilder.R = r100;
            return this;
        }

        public Builder ignoreModelLruVersion(boolean r100) {
            this.mKNEffectConfigBuilder.T = r100;
            return this;
        }

        public Builder lruCacheVersion(String r100) {
            this.mKNEffectConfigBuilder.I = r100;
            return this;
        }

        public Builder modelMapping(boolean r100) {
            this.mKNEffectConfigBuilder.O = r100;
            return this;
        }

        public Builder networkType(EffectConfig.c r100) {
            this.mKNEffectConfigBuilder.getClass();
            return this;
        }

        public Builder preloadReadEnable(boolean r100) {
            this.mKNEffectConfigBuilder.M = r100;
            return this;
        }

        public Builder setAccessKey(String r100) {
            this.mAccessKey = r100;
            this.mKNEffectConfigBuilder.f457182a = r100;
            return this;
        }

        public Builder setAppId(String r100) {
            this.mAppId = r100;
            this.mKNEffectConfigBuilder.f457187f = r100;
            return this;
        }

        public Builder setAssetManager(AssetManager r100) {
            this.mAssetManager = r100;
            return this;
        }

        public Builder setBid(String r100) {
            this.mBid = r100;
            return this;
        }

        public Builder setContext(Context r100) {
            Context r101 = r100.getApplicationContext();
            this.mContext = r101;
            this.mKNEffectConfigBuilder.B = r101;
            return this;
        }

        public Builder setDeviceType(String r100) {
            this.mDeviceType = r100;
            this.mKNEffectConfigBuilder.f457192k = r100;
            return this;
        }

        public Builder setEffectConfiguration(EffectConfiguration r100) {
            this.mEffectConfiguration = r100;
            if (r100.getContext() == null) goto L8;
            if (this.mContext != null) goto L8;
            setContext(r100.getContext());
        L8:
            if (r100.getAppVersion() == null) goto L11;
            EffectConfig.Builder r101 = this.mKNEffectConfigBuilder;
            r101.f457184c = r100.getAppVersion();
        L11:
            if (r100.getChannel() == null) goto L14;
            EffectConfig.Builder r102 = this.mKNEffectConfigBuilder;
            r102.f457190i = r100.getChannel();
        L14:
            if (r100.getDeviceId() == null) goto L17;
            EffectConfig.Builder r103 = this.mKNEffectConfigBuilder;
            r103.f457185d = r100.getDeviceId();
        L17:
            if (r100.getPlatform() == null) goto L20;
            EffectConfig.Builder r104 = this.mKNEffectConfigBuilder;
            r104.f457191j = r100.getPlatform();
        L20:
            if (r100.getRegion() == null) goto L23;
            EffectConfig.Builder r105 = this.mKNEffectConfigBuilder;
            r105.f457186e = r100.getRegion();
        L23:
            if (r100.getAppLanguage() == null) goto L26;
            EffectConfig.Builder r106 = this.mKNEffectConfigBuilder;
            r106.f457198q = r100.getAppLanguage();
        L26:
            if (r100.getGpuVersion() == null) goto L29;
            EffectConfig.Builder r107 = this.mKNEffectConfigBuilder;
            r107.f457203v = r100.getGpuVersion();
        L29:
            if (r100.getTestStatus() == null) goto L31;
            EffectConfig.Builder r108 = this.mKNEffectConfigBuilder;
            r108.f457202u = r100.getTestStatus();
        L31:
            EffectConfig.Builder r109 = this.mKNEffectConfigBuilder;
            r109.F = Integer.valueOf(r100.getFilterType());
            EffectConfig.Builder r110 = this.mKNEffectConfigBuilder;
            r110.f457207z = r100.isUnzipNewSolutionEnabled();
            EffectConfig.Builder r111 = this.mKNEffectConfigBuilder;
            r111.f457194m = r100.getEffectDir().getAbsolutePath();
            EffectConfig.Builder r112 = this.mKNEffectConfigBuilder;
            r112.f457196o = r100.getRetryCount();
            return this;
        }

        public Builder setEffectNetWorker(IEffectNetWorker r100) {
            this.mEffectNetWorker = r100;
            EffectConfig.Builder r101 = this.mKNEffectConfigBuilder;
            r101.f457188g = new KNNetworkClient(r100);
            return this;
        }

        public Builder setEventListener(ModelEventListener r100) {
            this.mEventListener = r100;
            EffectConfig.Builder r101 = this.mKNEffectConfigBuilder;
            ModelListenerAdaptKt.toKNListener(r100);
            r101.getClass();
            return this;
        }

        public Builder setExclusionPattern(String r100) {
            if (r100 != null) goto L4;
            this.mExclusionPattern = null;
        L5:
            return this;
        L4:
            this.mExclusionPattern = PatternProtector.compile(r100);
            this.mKNEffectConfigBuilder.D = r100;
            goto L5
        }

        public Builder setExecutor(Executor r100) {
            if (this.mExecutor != null) goto L7;
            this.mExecutor = r100;
            EffectConfig.Builder r101 = this.mKNEffectConfigBuilder;
            KNExecutor r102 = new KNExecutor(r100);
            if (r101.f457199r != null) goto L7;
            r101.f457199r = r102;
        L7:
            return this;
        }

        public Builder setHosts(List<Host> r100) {
            this.mHosts.addAll(r100);
            if (r100.isEmpty() == true) goto L5;
            EffectConfig.Builder r101 = this.mKNEffectConfigBuilder;
            r101.f457206y = ((Host) ListProtector.get(r100, 0)).getItemName();
        L5:
            return this;
        }

        public Builder setJsonConverter(IJsonConverter r100) {
            this.mJsonConverter = r100;
            EffectConfig.Builder r101 = this.mKNEffectConfigBuilder;
            r101.f457189h = new a(new KNJsonConverter(r100));
            return this;
        }

        public Builder setModelApiMaxTryCount(int r100) {
            this.mKNEffectConfigBuilder.f457197p = r100;
            return this;
        }

        public Builder setModelFileEnv(ModelFileEnv r100) {
            this.mModelFileEnv = r100;
            EffectConfig.Builder r101 = this.mKNEffectConfigBuilder;
            r101.E = ModelConverterExtKt.toKNModel(r100);
            return this;
        }

        public Builder setModelType(FetchModelType r100) {
            this.mFetchModelType = r100;
            EffectConfig.Builder r101 = this.mKNEffectConfigBuilder;
            r101.C = ModelConverterExtKt.toKNFetchModelType(r100);
            return this;
        }

        public Builder setMonitorService(IMonitorService r100) {
            this.mMonitorService = r100;
            EffectConfig.Builder r101 = this.mKNEffectConfigBuilder;
            r101.f457201t = new KNMonitorService(r100);
            return this;
        }

        public Builder setSdkVersion(String r100) {
            this.mSdkVersion = r100;
            this.mKNEffectConfigBuilder.f457183b = r100;
            return this;
        }

        public Builder setThreadCoreSize(int r100) {
            this.mExecutor = glc.a.a(r100, 30000);
            this.mThreadCoreSize = r100;
            EffectConfig.Builder r101 = this.mKNEffectConfigBuilder;
            r101.getClass();
            r101.f457199r = glc.a.a(r100, 30000);
            r101.f457181J = r100;
            return this;
        }

        public Builder setWorkspace(String r100) {
            this.mWorkspace = r100;
            this.mKNEffectConfigBuilder.f457195n = r100;
            return this;
        }
    }

    public static final enum ModelFileEnv extends Enum<ModelFileEnv> {
        private static final /* synthetic */ ModelFileEnv[] $VALUES = null;
        public static final ModelFileEnv ONLINE = null;
        public static final ModelFileEnv TEST = null;

        static {
            ModelFileEnv r100 = new ModelFileEnv(FlowDoraWifiScene.TEST, 0);
            TEST = r100;
            ModelFileEnv r101 = new ModelFileEnv("ONLINE", 1);
            ONLINE = r101;
            $VALUES = new ModelFileEnv[]{r100, r101};
        }

        public static ModelFileEnv[] values() {
            return (ModelFileEnv[]) $VALUES.clone();
        }

        public static ModelFileEnv valueOf(String r100) {
            return (ModelFileEnv) r27.a.a(ModelFileEnv.class, r100);
        }

        private ModelFileEnv(String r100, int r101) {
            super(r100, r101);
        }
    }

    public String getAccessKey() {
        return this.mAccessKey;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public AssetManager getAssetManager() {
        return this.mAssetManager;
    }

    public Context getContext() {
        return this.mContext;
    }

    public String getDeviceType() {
        return this.mDeviceType;
    }

    public EffectConfiguration getEffectConfiguration() {
        return this.mEffectConfiguration;
    }

    public IEffectNetWorker getEffectNetWorker() {
        return this.mEffectNetWorker;
    }

    public ModelEventListener getEventListener() {
        return this.mEventListener;
    }

    public Pattern getExclusionPattern() {
        return this.mExclusionPattern;
    }

    public Executor getExecutor() {
        return this.mExecutor;
    }

    public List<Host> getHosts() {
        return this.mHosts;
    }

    public IJsonConverter getJsonConverter() {
        return this.mJsonConverter;
    }

    public EffectConfig getKNEffectConfig() {
        return this.mKNEffectConfig;
    }

    public ModelFileEnv getModelFileEnv() {
        return this.mModelFileEnv;
    }

    public FetchModelType getModelType() {
        return this.mFetchModelType;
    }

    public IMonitorService getMonitorService() {
        return this.mMonitorService;
    }

    public String getSdkVersion() {
        return this.mSdkVersion;
    }

    public int getThreadCoreSize() {
        return this.mThreadCoreSize;
    }

    public String getWorkspace() {
        return this.mWorkspace;
    }

    private DownloadableModelConfig(Builder r100) {
        this.mAssetManager = (AssetManager) checkNotNull(r100.mAssetManager);
        this.mWorkspace = (String) checkNotNull(r100.mWorkspace);
        this.mEffectNetWorker = (IEffectNetWorker) checkNotNull(r100.mEffectNetWorker);
        this.mHosts = Collections.unmodifiableList(r100.mHosts);
        this.mJsonConverter = (IJsonConverter) checkNotNull(r100.mJsonConverter);
        this.mExecutor = r100.mExecutor;
        this.mThreadCoreSize = r100.mThreadCoreSize;
        this.mDeviceType = (String) checkNotNull(r100.mDeviceType);
        this.mSdkVersion = (String) checkNotNull(r100.mSdkVersion);
        this.mAppId = (String) checkNotNull(r100.mAppId);
        this.mAccessKey = (String) checkNotNull(r100.mAccessKey);
        this.mMonitorService = r100.mMonitorService;
        this.mExclusionPattern = r100.mExclusionPattern;
        this.mEventListener = r100.mEventListener;
        ModelFileEnv r101 = r100.mModelFileEnv;
        if (r101 != null) goto L5;
        r101 = ModelFileEnv.ONLINE;
    L5:
        this.mModelFileEnv = r101;
        FetchModelType r102 = r100.mFetchModelType;
        if (r102 != null) goto L8;
        r102 = FetchModelType.ORIGIN;
    L8:
        this.mFetchModelType = r102;
        this.mEffectConfiguration = r100.mEffectConfiguration;
        this.mContext = r100.mContext;
        this.mKNEffectConfig = Builder.access$000(r100);
    }

    private <T> T checkNotNull(T r100) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw null;
    }

    public /* synthetic */ DownloadableModelConfig(Builder r100, AnonymousClass1 r101) {
        this(r100);
    }
}
