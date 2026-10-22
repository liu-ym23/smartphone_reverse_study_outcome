package com.lynx.canvas;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes32.dex */
public class PluginLoaderWrapper {
    private static final String TAG = "PluginLoaderWrapper";

    public PluginLoaderWrapper() {
    }

    private static native void nativeOnFinishCallback(long r100, String r101, boolean r102, String r103, String r104);

    public static boolean loadModuleService(KryptonApp r100, String r101) {
        if (KryptonAudioModule.moduleName().equals(r101) == false) goto L10;
        KryptonAudioModule r102 = (KryptonAudioModule) r100.getModule(KryptonAudioModule.class);
        if (r102 != null) goto L7;
        KryptonLLog.w(TAG, "no audio module found for " + r101);
        return false;
    L7:
        return r102.loadAudioModule();
    L10:
        if (KryptonRTCModule.moduleName().equals(r101) == false) goto L17;
        KryptonRTCModule r103 = (KryptonRTCModule) r100.getModule(KryptonRTCModule.class);
        if (r103 != null) goto L14;
        KryptonLLog.w(TAG, "no rtc module found for " + r101);
        return false;
    L14:
        return r103.load(null);
    L17:
        if (KryptonVECameraModule.moduleName().equals(r101) == false) goto L23;
        KryptonVECameraModule r104 = (KryptonVECameraModule) r100.getModule(KryptonVECameraModule.class);
        if (r104 != null) goto L21;
        KryptonLLog.w(TAG, "no ve-camera module found for " + r101);
        return false;
    L21:
        return r104.load(null);
    L23:
        KryptonLLog.w(TAG, "no module for " + r101);
        return false;
    }

    public static boolean preloadPluginSync(KryptonApp r100, String r101) {
        KryptonPluginLoaderService r102 = (KryptonPluginLoaderService) r100.getService(KryptonPluginLoaderService.class);
        if (r102 != null) goto L7;
        KryptonLLog.e(TAG, "plugin loader service not exits, default return true on sync load");
        return true;
    L7:
        if (r102.loadPluginSync(r101) == false) goto L10;
        KryptonLLog.i(TAG, "plugin " + r101 + " load sync success ");
        return true;
    L10:
        return false;
    }

    public static /* synthetic */ boolean access$000(KryptonApp r100, String r101, String r102) {
        return postLoadPluginSuccess(r100, r101, r102);
    }

    private static boolean postLoadPluginSuccess(KryptonApp r100, String r101, String r102) {
        if (KryptonRTCModule.moduleName().equals(r101) == false) goto L9;
        KryptonRTCModule r103 = (KryptonRTCModule) r100.getModule(KryptonRTCModule.class);
        if (r103 != null) goto L7;
        return true;
    L7:
        return r103.load(r102);
    L9:
        if (KryptonAudioModule.moduleName().equals(r101) == false) goto L20;
        KryptonAudioModule r104 = (KryptonAudioModule) r100.getModule(KryptonAudioModule.class);
        if (r104 != null) goto L13;
        return true;
    L13:
        if (r104.loadAudioModule() == true) goto L15;
    L17:
        return false;
    L15:
        if (r104.loadAudioEffectModule(r102) == false) goto L17;
        return true;
    L20:
        return true;
    }

    public static void preloadPlugin(KryptonApp r100, final long r101, final String r110) {
        final KryptonPluginLoaderService r102 = (KryptonPluginLoaderService) r100.getService(KryptonPluginLoaderService.class);
        if (r102 != null) goto L10;
        boolean r103 = postLoadPluginSuccess(r100, r110, null);
        if (r103 == false) goto L7;
        String r104 = "plugin loader service not exits, default return success";
    L8:
        String r105 = r104;
        KryptonLLog.w(TAG, r105);
        nativeOnFinishCallback(r101, r110, r103, r105, "");
        return;
    L7:
        r104 = "post load plugin failed";
        goto L8
    L10:
        KryptonLLog.i(TAG, "loading plugin " + r110 + " async ...");
        final WeakReference r106 = new WeakReference(r100);
        r102.loadPluginAsync(r110, new AnonymousClass1(r101, r110, r106, r102));
    }

    public static /* synthetic */ void access$100(long r100, String r101, boolean r102, String r103, String r104) {
        nativeOnFinishCallback(r100, r101, r102, r103, r104);
    }
}
