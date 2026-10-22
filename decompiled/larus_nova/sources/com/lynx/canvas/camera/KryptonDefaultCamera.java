package com.lynx.canvas.camera;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.lynx.canvas.KryptonCamera;
import com.lynx.canvas.KryptonLLog;
import f06.b;
import f06.c;
import f06.d;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public class KryptonDefaultCamera implements KryptonCamera {
    private static final int CAMERA_RETRY_TIMES = 3;
    private static final String TAG = "Camera default";
    private Camera mCamera;
    private int mCameraId;
    private Camera.CameraInfo mCameraInfo;
    private final Context mContext;
    private int mFacing;
    private int mHeight;
    private final Invoker mInvoker;
    private int mWidth;

    public interface Invoker {
        Camera openCamera(int r100) throws RuntimeException;

        void releaseCamera(Camera r100);
    }

    @Override // com.lynx.canvas.KryptonCamera
    public void focus() {
        Camera r100 = this.mCamera;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.autoFocus(null);
    }

    @Override // com.lynx.canvas.KryptonCamera
    public void pause() {
        Camera r100 = this.mCamera;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.stopPreview();
        this.mCamera.lock();
    }

    @Override // com.lynx.canvas.KryptonCamera
    public void play() {
        Camera r100 = this.mCamera;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.startPreview();
    }

    @Override // com.lynx.canvas.KryptonCamera
    public void release() {
        Camera r100 = this.mCamera;
        if (r100 != null) goto L5;
        return;
    L5:
        Invoker r101 = this.mInvoker;
        if (r101 == null) goto L8;
        r101.releaseCamera(r100);
    L9:
        this.mCamera = null;
        return;
    L8:
        com_lynx_canvas_camera_KryptonDefaultCamera_android_hardware_Camera_release(r100);
        goto L9
    }

    @Override // com.lynx.canvas.KryptonCamera
    public int getHeight() {
        return this.mHeight;
    }

    @Override // com.lynx.canvas.KryptonCamera
    public int getWidth() {
        return this.mWidth;
    }

    private boolean checkNoDefault(KryptonCamera.Config r100) {
        if (r100 != null) goto L5;
    L11:
        return false;
    L5:
        if (r100.extraJson == null) goto L11;
        return new JSONObject(r100.extraJson).optBoolean("noDefault");
    L9:
        e = move-exception;
        KryptonLLog.w(TAG, "parse extraJson failed " + e.toString());
        goto L11
    }

    private static Camera com_lynx_canvas_camera_KryptonDefaultCamera_android_hardware_Camera_open(int r110) {
        c r100 = new c();
        Object[] r101 = {Integer.valueOf(r110)};
        b r111 = new b();
        d r112 = r100.b(100100, "android/hardware/Camera", "open", Camera.class, r101, "android.hardware.Camera", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(100100, "android/hardware/Camera", "open", Camera.class, r101, null, r111, false);
        return (Camera) r112.f474983b;
    L6:
        Camera r113 = Camera.open(r110);
        r100.a(100100, "android/hardware/Camera", "open", Camera.class, r101, r113, r111, true);
        return r113;
    }

    private static void com_lynx_canvas_camera_KryptonDefaultCamera_android_hardware_Camera_release(Camera r110) {
        c r100 = new c();
        Object[] r101 = new Object[0];
        b r111 = new b();
        if (r100.b(100101, "android/hardware/Camera", "release", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100101, "android/hardware/Camera", "release", r110, r101, null, r111, false);
        return;
    L6:
        r110.release();
        r100.a(100101, "android/hardware/Camera", "release", r110, r101, null, r111, true);
    }

    private int getCameraDisplayOrientation(Camera.CameraInfo r100) {
        int r101 = ((WindowManager) this.mContext.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay().getRotation();
        int r102 = 0;
        if (r101 == 0) goto L14;
        if (r101 != 1) goto L6;
        r102 = 90;
        goto L14
    L6:
        if (r101 != 2) goto L8;
        r102 = 180;
        goto L14
    L8:
        if (r101 != 3) goto L14;
        r102 = 270;
    L14:
        if (r100.facing != 1) goto L17;
        return (360 - ((r100.orientation + r102) % 360)) % 360;
    L17:
        return ((r100.orientation - r102) + 360) % 360;
    }

    private Camera openCamera(int r100) {
        if (r100 >= 0) goto L5;
        return null;
    L5:
        int r101 = 0;
    L7:
        if (r101 >= 3) goto L21;
        Invoker r102 = this.mInvoker;     // Catch: Exception -> L14
        if (r102 == null) goto L13;
        return r102.openCamera(r100);
    L13:
        return com_lynx_canvas_camera_KryptonDefaultCamera_android_hardware_Camera_open(r100);
    L14:
        e = move-exception;
        KryptonLLog.e(TAG, "open exception:" + e.toString());
        Thread.sleep(r101 * 100);     // Catch: InterruptedException -> L18
    L20:
        r101 = r101 + 1;
    L18:
        e = move-exception;
        KryptonLLog.e(TAG, "thread sleep exception:" + e.toString());
        goto L20
    L21:
        return null;
    }

    @Override // com.lynx.canvas.KryptonCamera
    public boolean requestWithConfig(KryptonCamera.Config r100) {
        if (checkNoDefault(r100) == false) goto L7;
        KryptonLLog.e(TAG, "the use of default camera is not allowed when noDefault is set to true");
        return false;
    L7:
        if (r100 != null) goto L9;
    L11:
        this.mFacing = 1;
    L12:
        int r101 = 0;
    L14:
        if (r101 >= Camera.getNumberOfCameras()) goto L19;
        Camera.CameraInfo r102 = new Camera.CameraInfo();
        Camera.getCameraInfo(r101, r102);
        if (r102.facing == this.mFacing) goto L17;
        r101 = r101 + 1;
        goto L14
    L17:
        this.mCameraId = r101;
        this.mCameraInfo = r102;
    L19:
        Camera r103 = openCamera(this.mCameraId);
        this.mCamera = r103;
        if (r103 != null) goto L23;
        KryptonLLog.e(TAG, "open failed");
        return false;
    L23:
        r103.setDisplayOrientation(getCameraDisplayOrientation(this.mCameraInfo));
        Camera.Parameters r104 = this.mCamera.getParameters();
        if (r100 == null) goto L26;
        KryptonCamera.CustomSize r105 = r100.size;
    L28:
        if (r105 != null) goto L30;
    L38:
        if (r100 != null) goto L40;
    L46:
        if (r100 != null) goto L48;
    L50:
        KryptonLLog.i(TAG, "default");
        this.mWidth = 480;
        this.mHeight = 640;
    L51:
        KryptonLLog.i(TAG, "use camera with landscape preview size (" + this.mHeight + "," + this.mWidth + ")");
        r104.setPreviewSize(this.mHeight, this.mWidth);
        r104.setPreviewFormat(17);
        if (r100.autoFocus == true) goto L54;
    L61:
        this.mCamera.setParameters(r104);     // Catch: Exception -> L58
        return true;
    L58:
        e = move-exception;
        KryptonLLog.e(TAG, "setParameters failed " + e.getMessage());
        return false;
    L54:
        if (r104.getSupportedFocusModes().contains("continuous-picture") == false) goto L61;
        r104.setFocusMode("continuous-picture");
        goto L61
    L48:
        if ("low".equals(r100.resolution) == false) goto L50;
        KryptonLLog.i(TAG, "low");
        this.mWidth = 288;
        this.mHeight = 352;
        goto L51
    L40:
        if ("high".equals(r100.resolution) == false) goto L46;
        KryptonCamera.CustomSize r106 = getOptimalPreviewSize(r104.getSupportedPreviewSizes(), 720.0f, 1280.0f);
        if (r106 != null) goto L45;
        KryptonLLog.e(TAG, "Get preview size failed with high resolution");
        return false;
    L45:
        this.mWidth = r106.width;
        this.mHeight = r106.height;
        goto L51
    L30:
        if (r105.width <= 0) goto L38;
        if (r105.height <= 0) goto L38;
        KryptonCamera.CustomSize r107 = getOptimalPreviewSize(r104.getSupportedPreviewSizes(), r105.width, r105.height);
        if (r107 != null) goto L37;
        KryptonLLog.e(TAG, "Get preview size failed with high resolution");
        return false;
    L37:
        this.mWidth = r107.width;
        this.mHeight = r107.height;
        goto L51
    L26:
        r105 = null;
        goto L28
    L9:
        if ("back".equals(r100.faceMode) == false) goto L11;
        this.mFacing = 0;
        goto L12
    }

    @Override // com.lynx.canvas.KryptonCamera
    public void setupPreviewTexture(SurfaceTexture r100) {
        Camera r101 = this.mCamera;
        if (r101 != null) goto L10;
        return;
    L10:
        r101.setPreviewTexture(r100);     // Catch: IOException -> L7
        return;
    L7:
        e = move-exception;
        KryptonLLog.e(TAG, "setPreviewTexture exception:" + e.toString());
    }

    public KryptonDefaultCamera(Context r100, Invoker r101) {
        this.mCameraId = -1;
        this.mFacing = 0;
        this.mContext = r100;
        this.mInvoker = r101;
    }

    private KryptonCamera.CustomSize getOptimalPreviewSize(List<Camera.Size> r100, float r101, float r102) {
        Iterator<Camera.Size> r103 = r100.iterator();
        Camera.Size r104 = null;
    L4:
        if (r103.hasNext() == false) goto L12;
        Camera.Size r105 = r103.next();
        int r106 = r105.height;
        if (r106 > r101) goto L4;
        if (r104 == null) goto L11;
        if (r106 <= r104.height) goto L4;
    L11:
        KryptonLLog.i(TAG, "update max supported size to (" + r105.width + "," + r105.height + ")");
        r104 = r105;
        goto L4
    L12:
        if (r104 != null) goto L16;
        KryptonLLog.e(TAG, "find max supported preview size error");
        return null;
    L16:
        return new KryptonCamera.CustomSize(r104.height, r104.width);
    }
}
