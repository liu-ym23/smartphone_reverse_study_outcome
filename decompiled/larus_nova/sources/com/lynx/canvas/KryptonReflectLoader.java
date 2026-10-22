package com.lynx.canvas;

import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes32.dex */
public class KryptonReflectLoader {
    public static final String TAG = "KryptonReflectLoader";
    private static volatile KryptonReflectLoader sInstance;
    private Class<KryptonAudioModule> mAudioModuleClass;
    private KryptonRTCModule mDefaultRTCModuleInstance;
    private KryptonVECameraModule mDefaultVECameraModuleInstance;
    private Class<KryptonEffectConfigService> mEffectConfigServiceClass;
    private Class<KryptonLiveModule> mKryptonDefaultLiveModuleClass;
    private boolean mNoAudioModule;
    private boolean mNoEffectConfig;
    private boolean mNoLiveModule;
    private boolean mNoRTCModule;
    private boolean mNoVECameraModule;
    private boolean mNoVideoPlayerService;
    private boolean mUseAurumAudioEngine;
    private KryptonVideoPlayerService mVideoPlayerServiceInstance;

    private KryptonReflectLoader() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static KryptonReflectLoader inst() {
        if (sInstance != null) goto L15;
        monitor-enter(KryptonReflectLoader.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new KryptonReflectLoader();     // Catch: Throwable -> L11
    L9:
        monitor-exit(KryptonReflectLoader.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void loadAudioModuleClass() {
        if (this.mUseAurumAudioEngine == false) goto L5;
        String r100 = "KryptonAurumAudioModule";
    L6:
        String r101 = "com.lynx.canvas.audio.".concat(r100);
        Class<KryptonAudioModule> r102 = INVOKESTATIC_com_lynx_canvas_KryptonReflectLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r101);     // Catch: ClassCastException -> L12 ClassNotFoundException -> L14
        if (KryptonAudioModule.class.isAssignableFrom(r102) == false) goto L10;
        this.mAudioModuleClass = r102;     // Catch: ClassCastException -> L12 ClassNotFoundException -> L14
    L16:
        return;
    L10:
        KryptonLLog.e(TAG, "reflect find " + r101 + " instance type error");     // Catch: ClassCastException -> L12 ClassNotFoundException -> L14
    L12:
        e = move-exception;
        KryptonLLog.e(TAG, "can not cast to KryptonAudioModule: " + r101 + e.getMessage());
        return;
    L14:
        KryptonLLog.w(TAG, "find module class not found: " + r101 + ", maybe audio module is not used.");
        return;
    L5:
        r100 = "KryptonAudioModuleImpl";
        goto L6
    }

    private void loadDefaultLiveModule() {
        Class<KryptonLiveModule> r100 = INVOKESTATIC_com_lynx_canvas_KryptonReflectLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.lynx.canvas.live.KryptonDefaultLiveModule");     // Catch: ClassCastException -> L8 ClassNotFoundException -> L10
        if (KryptonLiveModule.class.isAssignableFrom(r100) == false) goto L6;
        this.mKryptonDefaultLiveModuleClass = r100;     // Catch: ClassCastException -> L8 ClassNotFoundException -> L10
    L12:
        return;
    L6:
        KryptonLLog.e(TAG, "reflect find default KryptonLiveModule instance type error");     // Catch: ClassCastException -> L8 ClassNotFoundException -> L10
    L8:
        e = move-exception;
        KryptonLLog.e(TAG, "can not cast to KryptonLiveModule: com.lynx.canvas.live.KryptonDefaultLiveModule" + e.getMessage());
        return;
    L10:
        KryptonLLog.w(TAG, "find module class not found: com.lynx.canvas.live.KryptonDefaultLiveModule, maybe Krypton/Live is not used.");
    }

    private void loadDefaultRTCModule() {
        Object r100 = INVOKESTATIC_com_lynx_canvas_KryptonReflectLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.lynx.canvas.rtc.KryptonDefaultRTCModule").getMethod("inst", new Class[0]).invoke(null, new Object[0]);     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 ClassNotFoundException -> L14
        if (KryptonRTCModule.class.isInstance(r100) == false) goto L6;
        this.mDefaultRTCModuleInstance = (KryptonRTCModule) r100;     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 ClassNotFoundException -> L14
    L16:
        return;
    L6:
        KryptonLLog.e(TAG, "reflect find module for com.lynx.canvas.rtc.KryptonDefaultRTCModule instance type error");     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 ClassNotFoundException -> L14
    L14:
        KryptonLLog.w(TAG, "find module class not found: com.lynx.canvas.rtc.KryptonDefaultRTCModule, maybe Krypton/RTC is not used.");
        return;
    L10:
        e = e;
    L11:
        KryptonLLog.e(TAG, "invoke method inst in class: com.lynx.canvas.rtc.KryptonDefaultRTCModule failed " + e.getMessage());
        return;
    L12:
        e = move-exception;
        KryptonLLog.e(TAG, "find module inst method not found in class: com.lynx.canvas.rtc.KryptonDefaultRTCModule" + e.getMessage());
        return;
    L8:
        e = e;
        goto L11
    }

    private void loadDefaultVECameraModule() {
        Object r100 = INVOKESTATIC_com_lynx_canvas_KryptonReflectLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.lynx.canvas.vecamera.KryptonDefaultVECameraModule").getMethod("inst", new Class[0]).invoke(null, new Object[0]);     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 ClassNotFoundException -> L14
        if (KryptonVECameraModule.class.isInstance(r100) == false) goto L6;
        this.mDefaultVECameraModuleInstance = (KryptonVECameraModule) r100;     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 ClassNotFoundException -> L14
    L16:
        return;
    L6:
        KryptonLLog.w(TAG, "reflect find module for com.lynx.canvas.vecamera.KryptonDefaultVECameraModule instance type error");     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 ClassNotFoundException -> L14
    L14:
        KryptonLLog.w(TAG, "find module class not found: com.lynx.canvas.vecamera.KryptonDefaultVECameraModule, maybe Krypton/VECamera is not used.");
        return;
    L10:
        e = e;
    L11:
        KryptonLLog.w(TAG, "invoke method inst in class: com.lynx.canvas.vecamera.KryptonDefaultVECameraModule failed " + e.getMessage());
        return;
    L12:
        e = move-exception;
        KryptonLLog.w(TAG, "find module inst method not found in class: com.lynx.canvas.vecamera.KryptonDefaultVECameraModule" + e.getMessage());
        return;
    L8:
        e = e;
        goto L11
    }

    private boolean loadEffectConfigService() {
        if (loadEffectConfigService("com.bytedance.ies.bullet.lynx.element.LynxCanvasEffectHandler") == false) goto L5;
    L8:
        return true;
    L5:
        if (loadEffectConfigService("com.bytedance.lynx.hybrid.hybrid_canvas.LynxCanvasEffectHandler") == true) goto L8;
        return false;
    }

    private boolean loadVideoPlayerService() {
        if (loadVideoPlayerService("com.bytedance.ies.bullet.lynx.element.LynxCanvasTTPlayer") == false) goto L5;
    L8:
        return true;
    L5:
        if (loadVideoPlayerService("com.bytedance.lynx.hybrid.hybrid_canvas.LynxCanvasTTPlayer") == true) goto L8;
        return false;
    }

    private KryptonAudioModule newAudioModuleInstance() {
        Class<KryptonAudioModule> r100 = this.mAudioModuleClass;
        if (r100 != null) goto L19;
        return null;
    L19:
        return r100.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L8:
        e = move-exception;
        KryptonLLog.w(TAG, "create mAudioModuleClass instance error " + e.getMessage());
        return null;
    }

    private KryptonLiveModule newKryptonDefaultLiveModuleInstance() {
        Class<KryptonLiveModule> r100 = this.mKryptonDefaultLiveModuleClass;
        if (r100 != null) goto L19;
        return null;
    L19:
        return r100.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L8:
        e = move-exception;
        KryptonLLog.w(TAG, "create mKryptonDefaultLiveModuleClass instance error" + e.getMessage());
        return null;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_lynx_canvas_KryptonReflectLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    private boolean loadEffectConfigService(String r100) {
        Class<KryptonEffectConfigService> r101 = INVOKESTATIC_com_lynx_canvas_KryptonReflectLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);     // Catch: ClassCastException -> L9 ClassNotFoundException -> L11
        if (KryptonEffectConfigService.class.isAssignableFrom(r101) == false) goto L7;
        this.mEffectConfigServiceClass = r101;     // Catch: ClassCastException -> L9 ClassNotFoundException -> L11
        KryptonLLog.i(TAG, "found effect config service class: " + r100);     // Catch: ClassCastException -> L9 ClassNotFoundException -> L11
        return true;
    L7:
        KryptonLLog.e(TAG, "reflect find service for LynxCanvasEffectHandler instance type error");     // Catch: ClassCastException -> L9 ClassNotFoundException -> L11
        return false;
    L9:
        e = move-exception;
        KryptonLLog.e(TAG, "service class can not cast to KryptonEffectConfigService: " + r100 + e.getMessage());
        return false;
    L11:
        KryptonLLog.w(TAG, "find service class not found: " + r100);
        return false;
    }

    private boolean loadVideoPlayerService(String r100) {
        Class r101 = INVOKESTATIC_com_lynx_canvas_KryptonReflectLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);     // Catch: SecurityException -> L10 NoSuchMethodException -> L12 ClassNotFoundException -> L14
        final Constructor r102 = r101.getConstructor(new Class[]{Context.class, Map.class});     // Catch: SecurityException -> L10 NoSuchMethodException -> L12 ClassNotFoundException -> L14
        if (KryptonVideoPlayer.class.isAssignableFrom(r101) == false) goto L8;
        if (r102 == null) goto L8;
        this.mVideoPlayerServiceInstance = new AnonymousClass1(this, r102);     // Catch: SecurityException -> L10 NoSuchMethodException -> L12 ClassNotFoundException -> L14
        KryptonLLog.i(TAG, "found video player service class: " + r100);     // Catch: SecurityException -> L10 NoSuchMethodException -> L12 ClassNotFoundException -> L14
        return true;
    L8:
        KryptonLLog.e(TAG, "reflect find service for LynxCanvasTTPlayer instance type error");     // Catch: SecurityException -> L10 NoSuchMethodException -> L12 ClassNotFoundException -> L14
    L15:
        return false;
    L14:
        KryptonLLog.w(TAG, "find service class not found: " + r100);
    L12:
        e = move-exception;
        KryptonLLog.e(TAG, "not find construct method for " + r100 + e.getMessage());
    L10:
        e = move-exception;
        KryptonLLog.e(TAG, "security exception for " + r100 + e.getMessage());
        goto L15
    }

    public <T extends KryptonService> T getHybridServiceInstance(Class<T> r100) {
        boolean r101 = true;
        if (KryptonVideoPlayerService.class.isAssignableFrom(r100) == false) goto L16;
        if (this.mVideoPlayerServiceInstance != null) goto L14;
        if (this.mNoVideoPlayerService == true) goto L14;
        loadVideoPlayerService();
        if (this.mVideoPlayerServiceInstance == null) goto L12;
        r101 = false;
    L12:
        this.mNoVideoPlayerService = r101;
    L14:
        return this.mVideoPlayerServiceInstance;
    L16:
        if (KryptonEffectConfigService.class.isAssignableFrom(r100) == true) goto L18;
    L38:
        return null;
    L18:
        if (this.mEffectConfigServiceClass == null) goto L20;
    L26:
        Class<KryptonEffectConfigService> r102 = this.mEffectConfigServiceClass;
        if (r102 == null) goto L38;
        return r102.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L34:
        e = move-exception;
        KryptonLLog.w(TAG, "create HybridCanvasEffectConfigServiceClass instance error " + e.getMessage());
        goto L38
    L20:
        if (this.mNoEffectConfig == true) goto L26;
        loadEffectConfigService();
        if (this.mEffectConfigServiceClass == null) goto L25;
        r101 = false;
    L25:
        this.mNoEffectConfig = r101;
        goto L26
    }

    public <T extends KryptonModule> T getModuleDefaultInstance(Class<T> r100, KryptonApp r101) {
        boolean r102 = true;
        if (KryptonAudioModule.class.isAssignableFrom(r100) == false) goto L16;
        this.mUseAurumAudioEngine = r101.getFeatureFlag().getUseAurumAudioEngine();
        if (this.mAudioModuleClass != null) goto L14;
        if (this.mNoAudioModule == true) goto L14;
        loadAudioModuleClass();
        if (this.mAudioModuleClass == null) goto L12;
        r102 = false;
    L12:
        this.mNoAudioModule = r102;
    L14:
        return newAudioModuleInstance();
    L16:
        if (KryptonRTCModule.class.isAssignableFrom(r100) == false) goto L29;
        if (this.mDefaultRTCModuleInstance != null) goto L27;
        if (this.mNoRTCModule == true) goto L27;
        loadDefaultRTCModule();
        if (this.mDefaultRTCModuleInstance == null) goto L25;
        r102 = false;
    L25:
        this.mNoRTCModule = r102;
    L27:
        return this.mDefaultRTCModuleInstance;
    L29:
        if (KryptonLiveModule.class.isAssignableFrom(r100) == false) goto L42;
        if (this.mKryptonDefaultLiveModuleClass != null) goto L40;
        if (this.mNoLiveModule == true) goto L40;
        loadDefaultLiveModule();
        if (this.mKryptonDefaultLiveModuleClass == null) goto L38;
        r102 = false;
    L38:
        this.mNoLiveModule = r102;
    L40:
        return newKryptonDefaultLiveModuleInstance();
    L42:
        if (KryptonVECameraModule.class.isAssignableFrom(r100) == true) goto L44;
        return null;
    L44:
        if (this.mDefaultVECameraModuleInstance != null) goto L53;
        if (this.mNoVECameraModule == true) goto L53;
        loadDefaultVECameraModule();
        if (this.mDefaultVECameraModuleInstance == null) goto L51;
        r102 = false;
    L51:
        this.mNoVECameraModule = r102;
    L53:
        return this.mDefaultVECameraModuleInstance;
    }
}
