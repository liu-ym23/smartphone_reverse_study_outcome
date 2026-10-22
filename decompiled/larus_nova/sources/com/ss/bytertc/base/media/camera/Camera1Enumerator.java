package com.ss.bytertc.base.media.camera;

import android.hardware.Camera;
import android.os.SystemClock;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.realx.base.RXLogging;
import com.ss.bytertc.base.media.Size;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public class Camera1Enumerator implements CameraEnumerator {
    private static final String TAG = "Camera1Enumerator";
    private static List<List<CameraEnumerationAndroid.CaptureFormat>> cachedSupportedFormats;
    private final boolean captureToTexture;
    private final boolean isDesktopMode;

    public Camera1Enumerator() {
        this(true, false);
    }

    @Override // com.ss.bytertc.base.media.camera.CameraEnumerator
    public String[] getDeviceNames() {
        ArrayList r100 = new ArrayList();
        int r101 = 0;
    L4:
        if (r101 >= Camera.getNumberOfCameras()) goto L11;
        String r102 = getDeviceName(r101);
        if (r102 == null) goto L8;
        r100.add(r102);
        RXLogging.w(TAG, "Index: " + r101 + ". " + r102);
    L9:
        r101 = r101 + 1;
        goto L4
    L8:
        RXLogging.e(TAG, "Index: " + r101 + ". Failed to query camera name.");
        goto L9
    L11:
        return (String[]) r100.toArray(new String[r100.size()]);
    }

    private static Camera com_ss_bytertc_base_media_camera_Camera1Enumerator_android_hardware_Camera_open(int r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = {Integer.valueOf(r110)};
        f06.b r111 = new f06.b();
        f06.d r112 = r100.b(100100, "android/hardware/Camera", "open", Camera.class, r101, "android.hardware.Camera", r111);
        if (r112.f474982a == false) goto L6;
        r100.a(100100, "android/hardware/Camera", "open", Camera.class, r101, null, r111, false);
        return (Camera) r112.f474983b;
    L6:
        Camera r113 = Camera.open(r110);
        r100.a(100100, "android/hardware/Camera", "open", Camera.class, r101, r113, r111, true);
        return r113;
    }

    private static void com_ss_bytertc_base_media_camera_Camera1Enumerator_android_hardware_Camera_release(Camera r110) {
        f06.c r100 = new f06.c();
        Object[] r101 = new Object[0];
        f06.b r111 = new f06.b();
        if (r100.b(100101, "android/hardware/Camera", "release", r110, r101, "void", r111).f474982a == false) goto L6;
        r100.a(100101, "android/hardware/Camera", "release", r110, r101, null, r111, false);
        return;
    L6:
        r110.release();
        r100.a(100101, "android/hardware/Camera", "release", r110, r101, null, r111, true);
    }

    public static List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> convertFramerates(List<int[]> r100) {
        ArrayList r101 = new ArrayList();
        Iterator<int[]> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        int[] r103 = r102.next();
        r101.add(new CameraEnumerationAndroid.CaptureFormat.FramerateRange(r103[0], r103[1]));
        goto L4
    L6:
        return r101;
    }

    public static List<Size> convertSizes(List<Camera.Size> r100) {
        ArrayList r101 = new ArrayList();
        Iterator<Camera.Size> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Camera.Size r103 = r102.next();
        r101.add(new Size(r103.width, r103.height));
        goto L4
    L6:
        return r101;
    }

    private static List<CameraEnumerationAndroid.CaptureFormat> enumerateFormats(int r110) {
        RXLogging.w(TAG, "Get supported formats for camera index " + r110 + ".");
        long r100 = SystemClock.elapsedRealtime();
        Camera r101 = null;
        RXLogging.w(TAG, "Opening camera with index " + r110);     // Catch: Throwable -> L19 RuntimeException -> L21
        r101 = com_ss_bytertc_base_media_camera_Camera1Enumerator_android_hardware_Camera_open(r110);     // Catch: Throwable -> L19 RuntimeException -> L21
        Camera.Parameters r102 = r101.getParameters();     // Catch: Throwable -> L19 RuntimeException -> L21
        com_ss_bytertc_base_media_camera_Camera1Enumerator_android_hardware_Camera_release(r101);
        ArrayList r103 = new ArrayList();
        if (r102 != null) goto L30;
    L17:
        RXLogging.w(TAG, "Get supported formats for camera index " + r110 + " done. Time spent: " + (SystemClock.elapsedRealtime() - r100) + " ms.");
        return r103;
    L30:
        List<int[]> r104 = r102.getSupportedPreviewFpsRange();     // Catch: Exception -> L15
        int r105 = 0;
        if (r104 == null) goto L9;
        int[] r106 = (int[]) ListProtector.get(r104, r104.size() - 1);     // Catch: Exception -> L15
        r105 = r106[0];     // Catch: Exception -> L15
        int r107 = r106[1];     // Catch: Exception -> L15
    L10:
        Iterator<Camera.Size> r108 = r102.getSupportedPreviewSizes().iterator();     // Catch: Exception -> L15
    L11:
        if (r108.hasNext() == false) goto L17;
        Camera.Size r109 = r108.next();     // Catch: Exception -> L15
        r103.add(new CameraEnumerationAndroid.CaptureFormat(r109.width, r109.height, r105, r107));     // Catch: Exception -> L15
        goto L11
    L9:
        r107 = 0;
    L15:
        e = move-exception;
        RXLogging.e(TAG, "getSupportedFormats() failed on camera index " + r110, e);
        goto L17
    L19:
        th = move-exception;
        if (r101 == null) goto L28;
        com_ss_bytertc_base_media_camera_Camera1Enumerator_android_hardware_Camera_release(r101);
    L28:
        throw th;
    L21:
        e = move-exception;
        RXLogging.e(TAG, "Open camera failed on camera index " + r110, e);     // Catch: Throwable -> L19
        ArrayList r111 = new ArrayList();     // Catch: Throwable -> L19
        if (r101 == null) goto L25;
        com_ss_bytertc_base_media_camera_Camera1Enumerator_android_hardware_Camera_release(r101);
    L25:
        return r111;
    }

    public static int getCameraIndex(String r100) {
        RXLogging.w(TAG, "getCameraIndex: " + r100);
        int r101 = 0;
    L4:
        if (r101 >= Camera.getNumberOfCameras()) goto L10;
        if (r100.equals(getDeviceName(r101)) == true) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return r101;
    L10:
        throw new IllegalArgumentException("No such camera: " + r100);
    }

    private static Camera.CameraInfo getCameraInfo(int r100) {
        Camera.CameraInfo r101 = new Camera.CameraInfo();
        Camera.getCameraInfo(r100, r101);     // Catch: Exception -> L5
        return r101;
    L5:
        e = move-exception;
        RXLogging.e(TAG, "getCameraInfo failed on index " + r100, e);
        return null;
    }

    public static String getDeviceName(int r100) {
        Camera.CameraInfo r101 = getCameraInfo(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        if (r101.facing != 1) goto L9;
        String r102 = NewBroadcastMonitor.CAPTURE.FRONT;
    L11:
        return "Camera " + r100 + ", Facing " + r102 + ", Orientation " + r101.orientation;
    L9:
        r102 = "back";
        goto L11
    }

    public static synchronized List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(int r100) {
        monitor-enter(Camera1Enumerator.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (cachedSupportedFormats != null) goto L10;
        cachedSupportedFormats = new ArrayList();     // Catch: Throwable -> L13
        int r101 = 0;
    L8:
        if (r101 >= Camera.getNumberOfCameras()) goto L10;
        cachedSupportedFormats.add(enumerateFormats(r101));     // Catch: Throwable -> L13
        r101 = r101 + 1;     // Catch: Throwable -> L13
    L10:
        List<CameraEnumerationAndroid.CaptureFormat> r102 = (List) ListProtector.get(cachedSupportedFormats, r100);     // Catch: Throwable -> L13
        monitor-exit(Camera1Enumerator.class);
        return r102;
    }

    @Override // com.ss.bytertc.base.media.camera.CameraEnumerator
    public int getDeviceOrientation(String r100) {
        return getCameraInfo(getCameraIndex(r100)).orientation;
    }

    @Override // com.ss.bytertc.base.media.camera.CameraEnumerator
    public boolean isBackFacing(String r100) {
        Camera.CameraInfo r101 = getCameraInfo(getCameraIndex(r100));
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.facing != 0) goto L7;
        return true;
    }

    @Override // com.ss.bytertc.base.media.camera.CameraEnumerator
    public boolean isFrontFacing(String r100) {
        Camera.CameraInfo r101 = getCameraInfo(getCameraIndex(r100));
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.facing != 1) goto L7;
        return true;
    }

    @Override // com.ss.bytertc.base.media.camera.CameraEnumerator
    public List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(String r100) {
        return getSupportedFormats(getCameraIndex(r100));
    }

    public Camera1Enumerator(boolean r100, boolean r101) {
        this.captureToTexture = r100;
        this.isDesktopMode = r101;
    }

    @Override // com.ss.bytertc.base.media.camera.CameraEnumerator
    public CameraVideoCapturer createCapturer(String r100, CameraVideoCapturer.CameraEventsHandler r101) {
        return new Camera1Capturer(r100, r101, this.captureToTexture, this.isDesktopMode);
    }
}
