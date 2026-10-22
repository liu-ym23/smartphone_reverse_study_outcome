package com.ss.android.vesdk.runtime;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.bef.effectsdk.AssetResourceFinder;
import com.bef.effectsdk.EffectApplicationInfo;
import com.bef.effectsdk.EffectSDKUtils;
import com.bef.effectsdk.FileResourceFinder;
import com.bef.effectsdk.ResourceFinder;
import com.bytedance.ies.common.IESAppLogger;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ttve.editorInfo.TEEditorInfoInvoker;
import com.ss.android.ttve.monitor.ApplogUtilsInvoker;
import com.ss.android.ttve.monitor.IMonitor;
import com.ss.android.ttve.monitor.RuntimeInfoUtils;
import com.ss.android.ttve.monitor.g;
import com.ss.android.ttve.monitor.h;
import com.ss.android.ttve.monitor.i;
import com.ss.android.ttve.nativePort.TENativeLibsLoader;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ss.android.vesdk.VEConfigCenter;
import com.ss.android.vesdk.VEListener;
import com.ss.android.vesdk.VELogUtil;
import com.ss.android.vesdk.VESize;
import com.ss.android.vesdk.VEVersionUtil;
import com.ss.android.vesdk.q;
import com.ss.android.vesdk.q0;
import com.ss.android.vesdk.runtime.persistence.VESP;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class VERuntime {
    private static final String TAG = "VERuntime";
    private q mAB;
    private com.ss.android.ttve.monitor.c.a mApplogListener;
    Context mContext;
    private boolean mEnableAudioCapture;
    private boolean mEnableGLES3;
    private boolean mEnableRefactorRecorder;
    private boolean mEnableTransitionKeyframe;
    private com.ss.android.vesdk.runtime.c mEnv;
    private h.a mExceptionMonitorListener;
    private boolean mIsInited;
    private VESize mMaxRenderSize;
    private IMonitor mMoniter;
    private com.ss.android.vesdk.runtime.d mResManager;
    private VESP mSP;
    private int mTransitionFrameCount;
    private int mTransitionKeyFrameMode;
    private int mTransitionKeyFrameVersion;
    private boolean mUseAssetManager;
    private boolean mUseResourceFinder;
    private WeakReference<VEListener.VEApplogListener> mVEApplogListener;
    private VEListener.VEExceptionMonitorListener mVEExceptionMonitorListener;
    private WeakReference<VEListener.VEMonitorListener> mVEMonitorListener;

    public static final enum VERuntimeSingleton extends Enum<VERuntimeSingleton> {
        public static final VERuntimeSingleton INSTANCE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VERuntimeSingleton[] f455885a = null;
        private VERuntime veRuntime;

        static {
            VERuntimeSingleton r100 = new VERuntimeSingleton();
            INSTANCE = r100;
            f455885a = new VERuntimeSingleton[]{r100};
        }

        public VERuntimeSingleton() {
            super("INSTANCE", 0);
            this.veRuntime = new VERuntime(null);
        }

        public static VERuntimeSingleton[] values() {
            return (VERuntimeSingleton[]) f455885a.clone();
        }

        public VERuntime getInstance() {
            return this.veRuntime;
        }

        public static VERuntimeSingleton valueOf(String r100) {
            return (VERuntimeSingleton) r27.a.a(VERuntimeSingleton.class, r100);
        }
    }

    public class a implements IMonitor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VERuntime f455886a;

        public a(VERuntime r100) {
            this.f455886a = r100;
        }

        @Override // com.ss.android.ttve.monitor.IMonitor
        public final void monitorLog(String r100, JSONObject r101) {
            if (VERuntime.access$000(this.f455886a) != null) goto L5;
            return;
        L5:
            if (VERuntime.access$000(this.f455886a).get() == null) goto L9;
            ((VEListener.VEMonitorListener) VERuntime.access$000(this.f455886a).get()).monitorLog(r100, r101);
            return;
        }
    }

    public class b implements com.ss.android.ttve.monitor.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VERuntime f455887a;

        public b(VERuntime r100) {
            this.f455887a = r100;
        }
    }

    public class c implements h.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VERuntime f455888a;

        public c(VERuntime r100) {
            this.f455888a = r100;
        }

        @Override // com.ss.android.ttve.monitor.h.a
        public final void onException(Throwable r100) {
            if (VERuntime.access$200(this.f455888a) == null) goto L6;
            VERuntime.access$200(this.f455888a).onException(r100);
            return;
        }
    }

    public class d extends PthreadThreadV2 {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final /* synthetic */ VERuntime f455889v;

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public final void run() {
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L15;
            throw th;
        L15:
            return;
        L4:
            if (((Boolean) VESP.b().a("sensor_reported", Boolean.FALSE)).booleanValue() == true) goto L10;
            g.c(this.f455889v.mContext);     // Catch: Throwable -> L7 Exception -> L12
            VESP.b().d("sensor_reported", Boolean.TRUE, false);     // Catch: Throwable -> L7 Exception -> L12
            goto L17
        L16:
            return;
        L10:
            return;
        }

        public d(VERuntime r100) {
            this.f455889v = r100;
            super("e/VERuntime$4");
        }
    }

    public class e extends PthreadThreadV2 {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final /* synthetic */ VERuntime f455890v;

        public final void l() {
            Context r100 = this.f455890v.mContext;     // Catch: Exception -> L16
            if (RuntimeInfoUtils.f449915a == true) goto L14;
            monitor-enter(RuntimeInfoUtils.class);     // Catch: Exception -> L16
        L11:
            th = move-exception;
            throw th;     // Catch: Exception -> L16
        L7:
            if (RuntimeInfoUtils.f449915a == true) goto L9;
            RuntimeInfoUtils.a(r100.getApplicationContext());     // Catch: Throwable -> L11
            RuntimeInfoUtils.f449915a = true;     // Catch: Throwable -> L11
        L9:
            monitor-exit(RuntimeInfoUtils.class);     // Catch: Throwable -> L11
        L14:
            fic.a r101 = new fic.a();
            r101.c("iesve_vesdk_init_finish_result", "success");
            r101.c("iesve_vesdk_init_finish_reason", "null");
            g.b(r101);
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public final void run() {
            l();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(VERuntime r100) {
            this.f455890v = r100;
            super("e/VERuntime$5");
        }
    }

    public static void enableAudioSDKApiV2(boolean r100) {
    }

    private static native void nativeClearAllFreeMemoryCache(int r100);

    private static native void nativeEnableAudioSDKApiV2(boolean r100);

    private static native void nativeEnableCrossPlatGLBaseFBO(boolean r100);

    private static native void nativeEnableEditorHdr2Sdr(boolean r100);

    private native void nativeEnableHDByteVC1HWDecoder(boolean r100, int r101);

    private native void nativeEnableHDH264HWDecoder(boolean r100, int r101);

    private native void nativeEnableHDMpeg24VP89HWDecoder(boolean r100);

    private native void nativeEnableHighFpsByteVC1HWDecoder(boolean r100, int r101, int r102);

    private native void nativeEnableHighFpsH264HWDecoder(boolean r100, int r101, int r102);

    private static native void nativeEnableImport10BitByteVC1Video(boolean r100);

    private static native void nativeEnableRenderLib(boolean r100);

    private static native void nativeEnableRenderLibFBOOpt(boolean r100);

    private native void nativeEnableTTByteVC1Decoder(boolean r100);

    private static native void nativeEnableTitanReleaseGPUResource(boolean r100);

    private static native void nativeEnableTransitionKeyFrame(boolean r100);

    private native long nativeGetNativeContext();

    private static native double nativeGetVirtualMemInfo();

    private static native boolean nativeIsArm64();

    private static native void nativeSetNativeLibraryDir(String r100);

    private static native void nativeSetPageModeByteVC1CodecConfig(int r100, int r101, int r102);

    private static native void nativeSetPageModeH264CodecConfig(int r100, int r101, int r102);

    private static native void nativeSetTransitionFrameCount(int r100);

    private static native void nativeSetTransitionKeyFrameMode(int r100);

    private static native void nativeSetTransitionKeyFrameVersion(int r100);

    public void enableNewRecorder(boolean r100) {
    }

    public boolean isEnableNewRecorder() {
        return true;
    }

    public static VERuntime getInstance() {
        return VERuntimeSingleton.INSTANCE.getInstance();
    }

    private void initConfig() {
        Context r100 = this.mContext;
        if (r100 == null) goto L5;
        nativeSetNativeLibraryDir(r100.getApplicationInfo().nativeLibraryDir);
    L5:
        ThreadMethodProxy.start(new e(this));
    }

    public q getAB() {
        if (this.mAB != null) goto L6;
        this.mAB = new q();
    L6:
        return this.mAB;
    }

    public AssetManager getAssetManager() {
        if (this.mUseAssetManager == true) goto L5;
        VELogUtil.e(TAG, "disable use AssetManager!");
    L5:
        Context r100 = this.mContext;
        if (r100 != null) goto L10;
        VELogUtil.e(TAG, "context is null!");
        return null;
    L10:
        return r100.getAssets();
    }

    public boolean isEnableAudioCapture() {
        if (this.mEnableAudioCapture == false) goto L5;
    L8:
        return true;
    L5:
        if (((Boolean) VEConfigCenter.getInstance().getValue("ve_enable_lv_audio_graph_refactor").getValue()).booleanValue() == true) goto L8;
        return false;
    }

    public int needUpdateEffectModelFiles() {
        com.ss.android.vesdk.runtime.c r100 = this.mEnv;
        if (r100 != null) goto L6;
        return -108;
    L6:
        if (TextUtils.isEmpty(r100.f455896a) == false) goto L9;
        return -108;
    L9:
        if (this.mUseResourceFinder == false) goto L13;
        VELogUtil.w(TAG, "Use resource finder. Do not need update effect model files!");
        return -1;
    L13:
        if (this.mUseAssetManager == false) goto L17;
        VELogUtil.w(TAG, "Enable assetManager. Do not need update effect model files!");
        return -1;
    L17:
        if (EffectSDKUtils.needUpdate(this.mContext, this.mEnv.a()) == false) goto L20;
        return 0;
    L20:
        VEEffectConfig.configEffect(this.mEnv.a(), "nexus");
        return -1;
    }

    public void sensorReport() {
        ThreadMethodProxy.start(new d(this));
    }

    public int updateEffectModelFiles() {
        com.ss.android.vesdk.runtime.c r100 = this.mEnv;
        if (r100 != null) goto L6;
        return -108;
    L6:
        if (TextUtils.isEmpty(r100.f455896a) == false) goto L8;
        return -108;
    L8:
        PolarisFileWrapper r101 = new PolarisFileWrapper(this.mEnv.f455896a, "models");
        if (r101.exists() == true) goto L15;
        r101.mkdirs();
    L15:
        String r102 = r101.getAbsolutePath();     // Catch: Throwable -> L13
        EffectSDKUtils.flushAlgorithmModelFiles(this.mContext, r102);     // Catch: Throwable -> L13
        com.ss.android.vesdk.runtime.c r103 = this.mEnv;     // Catch: Throwable -> L13
        r103.f455897b = r102;     // Catch: Throwable -> L13
        VESP.b().d("vesdk_models_dir_sp_key", r103.f455897b, true);     // Catch: Throwable -> L13
        setEffectResourceFinder(new FileResourceFinder(r102));     // Catch: Throwable -> L13
        return 0;
    L13:
        return -1;
    }

    private VERuntime() {
        this.mUseAssetManager = false;
        this.mUseResourceFinder = false;
        this.mEnableGLES3 = false;
        this.mEnableTransitionKeyframe = false;
        this.mTransitionKeyFrameVersion = -1;
        this.mTransitionKeyFrameMode = 0;
        this.mTransitionFrameCount = 1;
        this.mMaxRenderSize = new VESize(0, 0);
        this.mIsInited = false;
        this.mMoniter = new a(this);
        this.mApplogListener = new b(this);
        this.mExceptionMonitorListener = new c(this);
    }

    public static double getVirtualMemInfo() {
        return nativeGetVirtualMemInfo();
    }

    public static boolean isArm64() {
        return nativeIsArm64();
    }

    public long getNativeContext() {
        return nativeGetNativeContext();
    }

    public Context getContext() {
        return this.mContext;
    }

    public com.ss.android.vesdk.runtime.c getEnv() {
        return this.mEnv;
    }

    public VESize getMaxRenderSize() {
        return this.mMaxRenderSize;
    }

    public com.ss.android.vesdk.runtime.d getResManager() {
        return this.mResManager;
    }

    public int getTransitionFrameCount() {
        return this.mTransitionFrameCount;
    }

    public int getTransitionKeyFrameMode() {
        return this.mTransitionKeyFrameMode;
    }

    public int getTransitionKeyFrameVersion() {
        return this.mTransitionKeyFrameVersion;
    }

    public boolean isEnableRefactorRecorder() {
        return this.mEnableRefactorRecorder;
    }

    public boolean isGLES3Enabled() {
        return this.mEnableGLES3;
    }

    public boolean isTransitionKeyFrameEnable() {
        return this.mEnableTransitionKeyframe;
    }

    public boolean isUseAssetManager() {
        return this.mUseAssetManager;
    }

    public /* synthetic */ VERuntime(a r100) {
        this();
    }

    public static /* synthetic */ WeakReference access$000(VERuntime r100) {
        return r100.mVEMonitorListener;
    }

    public static /* synthetic */ WeakReference access$100(VERuntime r100) {
        return r100.mVEApplogListener;
    }

    public static /* synthetic */ VEListener.VEExceptionMonitorListener access$200(VERuntime r100) {
        return r100.mVEExceptionMonitorListener;
    }

    public static void clearAllFreeMemoryCache(int r100) {
        nativeClearAllFreeMemoryCache(r100);
    }

    public static void enableCrossPlatGLBaseFBO(boolean r100) {
        nativeEnableCrossPlatGLBaseFBO(r100);
    }

    public static void enableEffectAudioManagerCallback(boolean r100) {
        VEEffectConfig.enableEffectAudioManagerCallback(r100);
    }

    public static void enableMakeupSegmentation(boolean r100) {
        VEEffectConfig.enableMakeupSegmentation(r100);
    }

    public static void enableRenderLib(boolean r100) {
        nativeEnableRenderLib(r100);
    }

    public static void enableRenderLibFBOOpt(boolean r100) {
        nativeEnableRenderLibFBOOpt(r100);
    }

    private void setContextToEffect(Context r100) {
        EffectApplicationInfo.setAppContext(r100);
    }

    public void enableAudioCapture(boolean r100) {
        this.mEnableAudioCapture = r100;
    }

    public int enableByteVC1Decoder(boolean r100) {
        if (this.mIsInited == true) goto L6;
        VELogUtil.e(TAG, "runtime not init");
        return -108;
    L6:
        nativeEnableTTByteVC1Decoder(r100);
        return 0;
    }

    public int enableEditorHdr2Sdr(boolean r100) {
        if (this.mIsInited == true) goto L6;
        VELogUtil.e(TAG, "runtime not init");
        return -108;
    L6:
        nativeEnableEditorHdr2Sdr(r100);
        return 0;
    }

    public void enableEffectRT(boolean r100) {
        VEEffectConfig.enableEffectRT(r100);
    }

    public void enableGLES3(boolean r100) {
        this.mEnableGLES3 = r100;
    }

    public int enableHDMpeg24VP89HWDecoder(boolean r100) {
        if (this.mIsInited == true) goto L6;
        VELogUtil.e(TAG, "runtime not init");
        return -108;
    L6:
        nativeEnableHDMpeg24VP89HWDecoder(r100);
        return 0;
    }

    public int enableImport10BitByteVC1Video(boolean r100) {
        if (this.mIsInited == true) goto L6;
        VELogUtil.e(TAG, "runtime not init");
        return -108;
    L6:
        nativeEnableImport10BitByteVC1Video(r100);
        return 0;
    }

    public void enableRefactorRecorder(boolean r100) {
        this.mEnableRefactorRecorder = r100;
    }

    public int enableTransitionKeyframe(boolean r100) {
        if (this.mIsInited == true) goto L6;
        VELogUtil.e(TAG, "runtime not init");
        return -108;
    L6:
        nativeEnableTransitionKeyFrame(r100);
        this.mEnableTransitionKeyframe = r100;
        return 0;
    }

    public void registerApplog(VEListener.VEApplogListener r100) {
        this.mVEApplogListener = new WeakReference(r100);
        com.ss.android.ttve.monitor.c.a r101 = this.mApplogListener;
        monitor-enter(com.ss.android.ttve.monitor.c.class);
        IESAppLogger.sharedInstance().setAppLogCallback("", new com.ss.android.ttve.monitor.a(r101), false);     // Catch: Throwable -> L7
        monitor-exit(com.ss.android.ttve.monitor.c.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void registerExceptionMonitor(VEListener.VEExceptionMonitorListener r100) {
        this.mVEExceptionMonitorListener = r100;
        h.a r101 = this.mExceptionMonitorListener;
        if (r101 != null) goto L5;
        WeakReference<h.a> r102 = null;
    L6:
        h.f449940a = r102;
        return;
    L5:
        r102 = new WeakReference(r101);
        goto L6
    }

    public void registerMonitor(VEListener.VEMonitorListener r100) {
        this.mVEMonitorListener = new WeakReference(r100);
        IMonitor r101 = this.mMoniter;
        if (i.f449943c == true) goto L7;
        i.f449941a = new WeakReference(r101);
        return;
    }

    public void setAB(q r100) {
        this.mAB = r100;
    }

    public boolean setABbUseBuildinAmazing(boolean r100) {
        VEEffectConfig.setABbUseBuildinAmazing(r100);
        return true;
    }

    public boolean setAssetManagerEnable(boolean r100) {
        this.mUseAssetManager = r100;
        if (r100 == false) goto L9;
        Context r101 = this.mContext;
        if (r101 == null) goto L7;
        setEffectResourceFinder(new AssetResourceFinder(r101.getAssets(), ""));
        return true;
    L7:
        VELogUtil.d(TAG, "mContext is null!!! need init");
        return false;
    L9:
        return true;
    }

    public boolean setCommonResourceFinder(com.ss.android.vesdk.a r100) {
        VEEffectConfig.setCommonResourceFinder(r100);
        return true;
    }

    public boolean setEffectAmazingShareDir(String r100) {
        VEEffectConfig.setShareDir(r100);
        return true;
    }

    public int setEffectAsynAPI(boolean r100) {
        if (this.mEnv != null) goto L6;
        return -108;
    L6:
        VEEffectConfig.setEffectAsynAPI(r100);
        return 0;
    }

    public int setEffectForceDetectFace(boolean r100) {
        if (this.mEnv != null) goto L6;
        return -108;
    L6:
        VEEffectConfig.setEffectForceDetectFace(r100);
        return 0;
    }

    public boolean setEffectJsonConfig(String r100) {
        VEEffectConfig.setEffectJsonConfig(r100);
        return true;
    }

    public boolean setEffectLogLevel(int r100) {
        VEEffectConfig.setEffectLogLevel(r100);
        return true;
    }

    public boolean setEffectMaxMemoryCache(int r100) {
        VEEffectConfig.setEffectMaxMemoryCache(r100);
        return true;
    }

    public boolean setEffectResourceFinder(ResourceFinder r100) {
        VEEffectConfig.setResourceFinder(r100);
        this.mUseAssetManager = false;
        this.mUseResourceFinder = true;
        VEEffectConfig.configEffect("", "nexus");
        return true;
    }

    public int setEffectSyncTimeDomain(boolean r100) {
        if (this.mEnv != null) goto L6;
        return -108;
    L6:
        VEEffectConfig.setEffectSyncTimeDomain(r100);
        return 0;
    }

    public int setEnableStickerAmazing(boolean r100) {
        if (this.mEnv != null) goto L6;
        return -108;
    L6:
        VEEffectConfig.setEnableStickerAmazing(r100);
        return 0;
    }

    public int setEnableStickerReleaseTexture(boolean r100) {
        if (this.mEnv != null) goto L6;
        return -108;
    L6:
        VEEffectConfig.setEnableStickerReleaseTexture(r100);
        return 0;
    }

    public void setEnv(com.ss.android.vesdk.runtime.c r100) {
        this.mEnv = r100;
    }

    public int setTransitionFrameCount(int r100) {
        if (this.mIsInited == true) goto L6;
        VELogUtil.e(TAG, "runtime not init");
        return -108;
    L6:
        nativeSetTransitionFrameCount(r100);
        this.mTransitionFrameCount = r100;
        return 0;
    }

    public int setTransitionKeyFrameMode(int r100) {
        if (this.mIsInited == true) goto L6;
        VELogUtil.e(TAG, "runtime not init");
        return -108;
    L6:
        nativeSetTransitionKeyFrameMode(r100);
        this.mTransitionKeyFrameMode = r100;
        return 0;
    }

    public int setTransitionKeyFrameVersion(int r100) {
        if (this.mIsInited == true) goto L6;
        VELogUtil.e(TAG, "runtime not init");
        return -108;
    L6:
        nativeSetTransitionKeyFrameVersion(r100);
        this.mTransitionKeyFrameVersion = r100;
        return 0;
    }

    public void setUseNewEffectAlgorithmApi(boolean r100) {
        VEEffectConfig.setUseNewEffectAlgorithmApi(r100);
    }

    public void enableAlgoParamIsForce(boolean r100, boolean r101) {
        VEEffectConfig.enableAlgoParamIsForce(r100, r101);
    }

    public int enableHDByteVC1HWDecoder(boolean r100, int r101) {
        if (this.mIsInited == true) goto L7;
        VELogUtil.e(TAG, "runtime not init");
        return -108;
    L7:
        if (r101 > 720) goto L9;
        r101 = TTVideoEngineInterface.PLAYER_OPTION_DECODE_EXTERN_INFO;
    L9:
        nativeEnableHDByteVC1HWDecoder(r100, r101);
        return 0;
    }

    public int enableHDH264HWDecoder(boolean r100, int r101) {
        if (this.mIsInited == true) goto L7;
        VELogUtil.e(TAG, "runtime not init");
        return -108;
    L7:
        if (r101 > 320) goto L9;
        r101 = 330;
    L9:
        nativeEnableHDH264HWDecoder(r100, r101);
        return 0;
    }

    public void init(Context r100, String r101) {
        if (this.mIsInited == false) goto L5;
        return;
    L5:
        this.mIsInited = true;
        this.mContext = r100;
        VEEffectConfig.setCacheDir(r100.getCacheDir().getAbsolutePath());
        TENativeLibsLoader.setContext(r100);
        com.ss.android.vesdk.runtime.c r102 = new com.ss.android.vesdk.runtime.c();
        this.mEnv = r102;
        r102.f455896a = r101;
        this.mAB = new q();
        this.mResManager = new com.ss.android.vesdk.runtime.d(getInstance().getEnv().f455896a);
        VESP r103 = VESP.b();
        this.mSP = r103;
        r103.c(r100);
        i.b(this.mContext, (String) this.mSP.a("KEY_DEVICEID", ""));
        ApplogUtilsInvoker.nativeInit(VEVersionUtil.getVESDKVersion());
        String r104 = pgc.a.f529224a;
        TEEditorInfoInvoker.nativeInit();
        pgc.a.f529225b = new ConcurrentHashMap();
        initConfig();
        setContextToEffect(r100);
    }

    public void setMaxRenderSize(int r100, int r101) {
        VESize r102 = this.mMaxRenderSize;
        r102.width = r100;
        r102.height = r101;
    }

    public int setPageModeCodecConfig(q0 r100, q0 r101) {
        if (this.mIsInited == true) goto L6;
        VELogUtil.e(TAG, "runtime not init");
        return -108;
    L6:
        return 0;
    }

    public void init(Context r100, com.ss.android.vesdk.runtime.c r101) {
        if (this.mIsInited == false) goto L5;
        return;
    L5:
        this.mContext = r100;
        VEEffectConfig.setCacheDir(r100.getCacheDir().getAbsolutePath());
        this.mEnv = r101;
        this.mAB = new q();
        TENativeLibsLoader.setContext(r100);
        this.mResManager = new com.ss.android.vesdk.runtime.d(getInstance().getEnv().f455896a);
        VESP r102 = VESP.b();
        this.mSP = r102;
        r102.c(r100);
        i.b(this.mContext, (String) this.mSP.a("KEY_DEVICEID", ""));
        String r103 = pgc.a.f529224a;
        TEEditorInfoInvoker.nativeInit();
        pgc.a.f529225b = new ConcurrentHashMap();
        initConfig();
    }

    public int enableHighFpsByteVC1HWDecoder(boolean r100, int r101, int r102) {
        if (this.mIsInited == true) goto L6;
        VELogUtil.e(TAG, "runtime not init");
        return -108;
    L6:
        nativeEnableHighFpsByteVC1HWDecoder(r100, r101, r102);
        return 0;
    }

    public int enableHighFpsH264HWDecoder(boolean r100, int r101, int r102) {
        if (this.mIsInited == true) goto L6;
        VELogUtil.e(TAG, "runtime not init");
        return -108;
    L6:
        nativeEnableHighFpsH264HWDecoder(r100, r101, r102);
        return 0;
    }
}
