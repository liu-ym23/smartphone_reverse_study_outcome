package com.lynx.canvas.camera;

import com.lynx.canvas.KryptonApp;
import com.lynx.canvas.KryptonCamera;
import com.lynx.canvas.KryptonCameraService;
import com.lynx.canvas.KryptonLLog;
import com.lynx.canvas.SurfaceTextureWrapper;

/* JADX INFO: loaded from: classes32.dex */
public class CameraContext {
    private static final String TAG = "CameraContext";
    private KryptonCamera mCamera;

    public static native void nativeOnCameraCallback(long r100, CameraContext r101, int r102, int r103);

    public static native void nativeOnCameraErrorCallback(long r100, String r101);

    public void pause() {
        this.mCamera.pause();
    }

    public void play() {
        this.mCamera.play();
    }

    public void release() {
        KryptonLLog.i(TAG, "CameraContext release");
        this.mCamera.release();
        this.mCamera = null;
    }

    public CameraContext(KryptonCamera r100) {
        this.mCamera = r100;
    }

    public void setupPreviewTexture(SurfaceTextureWrapper r100) {
        this.mCamera.setupPreviewTexture(r100.getSurfaceTexture());
    }

    public static void errorCallback(long r100, String r101) {
        KryptonLLog.e(TAG, r101);
        nativeOnCameraErrorCallback(r100, r101);
    }

    public static void requestCamera(KryptonApp r100, long r110, String r111, String r112, String r113, boolean r114) {
        requestCameraWithCustomSize(r100, r110, r111, r112, r113, r114, 0, 0);
    }

    public static void requestCameraWithCustomSize(KryptonApp r100, long r101, String r102, String r103, String r104, boolean r105, int r110, int r111) {
        KryptonCamera.Config r106 = new KryptonCamera.Config();
        r106.faceMode = r102;
        r106.resolution = r103;
        r106.extraJson = r104;
        r106.size = new KryptonCamera.CustomSize(r110, r111);
        r106.autoFocus = r105;
        KryptonCameraService r107 = (KryptonCameraService) r100.getService(KryptonCameraService.class);
        if (r107 != null) goto L6;
        errorCallback(r101, "camera service not found");
        return;
    L6:
        KryptonCamera r108 = r107.createCamera();
        if (r108 != null) goto L11;
        errorCallback(r101, "service create camera return null");
        return;
    L11:
        if (r108.requestWithConfig(r106) == true) goto L14;
        errorCallback(r101, "camera request error with config: " + r102 + " " + r103 + " " + r104);
        return;
    L14:
        CameraContext r109 = new CameraContext(r108);
        int r112 = r108.getWidth();
        int r113 = r108.getHeight();
        if (r112 == 0) goto L17;
        if (r113 == 0) goto L17;
    L26:
        nativeOnCameraCallback(r101, r109, r112, r113);
        KryptonLLog.i(TAG, "request camera success with config: " + r102 + " " + r103 + " " + r104);
        return;
    L17:
        KryptonLLog.i(TAG, "downgrade size origin w: " + r112 + " h: " + r113 + " resolution: " + r103);
        if (r103.equals("low") == false) goto L21;
        r112 = 288;
        r113 = 352;
        goto L26
    L21:
        if (r103.equals(KryptonCamera.Config.RESOLUTION_MEDIUM) == false) goto L24;
    L22:
        r113 = 640;
        r112 = 480;
        goto L26
    L24:
        if (r103.equals("high") == false) goto L22;
        r112 = 720;
        r113 = 1280;
        goto L26
    }
}
