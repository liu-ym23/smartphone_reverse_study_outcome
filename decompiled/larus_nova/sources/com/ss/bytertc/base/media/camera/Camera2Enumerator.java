package com.ss.bytertc.base.media.camera;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import android.os.SystemClock;
import android.util.AndroidException;
import android.util.Range;
import com.bytedance.realx.base.RXLogging;
import com.ss.bytertc.base.media.Size;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public class Camera2Enumerator implements CameraEnumerator {
    private static final double NANO_SECONDS_PER_SECOND = 1.0E9d;
    private static final String TAG = "Camera2Enumerator";
    private static final Map<String, List<CameraEnumerationAndroid.CaptureFormat>> cachedSupportedFormats = null;
    final CameraManager cameraManager;
    final Context context;

    static {
        cachedSupportedFormats = new HashMap();
    }

    @Override // com.ss.bytertc.base.media.camera.CameraEnumerator
    public String[] getDeviceNames() {
        CameraManager r100 = this.cameraManager;     // Catch: AndroidException -> L6
        if (r100 == null) goto L9;
        return r100.getCameraIdList();
    L9:
        return new String[0];
    L6:
        e = move-exception;
        RXLogging.e(TAG, "Camera access exception: " + e);
        goto L9
    }

    public Camera2Enumerator(Context r100) {
        this.context = r100;
        this.cameraManager = (CameraManager) r100.getSystemService("camera");
    }

    private static List<Size> convertSizes(android.util.Size[] r100) {
        ArrayList r101 = new ArrayList();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        android.util.Size r104 = r100[r103];
        r101.add(new Size(r104.getWidth(), r104.getHeight()));
        r103 = r103 + 1;
        goto L3
    L5:
        return r101;
    }

    private CameraCharacteristics getCameraCharacteristics(String r100) {
        CameraManager r101 = this.cameraManager;     // Catch: AndroidException -> L6
        if (r101 == null) goto L12;
        return r101.getCameraCharacteristics(r100);
    L12:
        return null;
    L6:
        e = move-exception;
        RXLogging.e(TAG, "Camera access exception: " + e);
        return null;
    }

    public static int getFpsUnitFactor(Range<Integer>[] r100) {
        if (r100.length != 0) goto L6;
        return 1000;
    L6:
        if (((Integer) r100[0].getUpper()).intValue() < 1000) goto L10;
        return 1;
    L10:
        return 1000;
    }

    public static List<Size> getSupportedSizes(CameraCharacteristics r100) {
        StreamConfigurationMap r101 = (StreamConfigurationMap) r100.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        int r102 = ((Integer) r100.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue();
        android.util.Size[] r103 = r101.getOutputSizes(SurfaceTexture.class);
        if (r103 != null) goto L6;
        return null;
    L6:
        List<Size> r104 = convertSizes(r103);
        if (Build.VERSION.SDK_INT < 22) goto L9;
    L17:
        return r104;
    L9:
        if (r102 != 2) goto L17;
        Rect r105 = (Rect) r100.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        ArrayList r106 = new ArrayList();
        Iterator<Size> r107 = r104.iterator();
    L12:
        if (r107.hasNext() == false) goto L16;
        Size r108 = r107.next();
        if ((r105.width() * r108.height) != (r105.height() * r108.width)) goto L12;
        r106.add(r108);
        goto L12
    L16:
        return r106;
    }

    public static boolean isSupported(Context r100) {
        CameraManager r101 = (CameraManager) r100.getSystemService("camera");
        String[] r102 = r101.getCameraIdList();     // Catch: AndroidException -> L12
        int r103 = r102.length;     // Catch: AndroidException -> L12
        int r104 = 0;
    L4:
        if (r104 >= r103) goto L10;
        if (((Integer) r101.getCameraCharacteristics(r102[r104]).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue() == 2) goto L8;
        r104 = r104 + 1;
        goto L4
    L8:
        return false;
    L10:
        return true;
    L12:
        e = move-exception;
        RXLogging.e(TAG, "Camera access exception: " + e);
        return false;
    }

    @Override // com.ss.bytertc.base.media.camera.CameraEnumerator
    public int getDeviceOrientation(String r100) {
        return ((Integer) getCameraCharacteristics(r100).get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
    }

    @Override // com.ss.bytertc.base.media.camera.CameraEnumerator
    public List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(String r100) {
        return getSupportedFormats(this.context, r100);
    }

    @Override // com.ss.bytertc.base.media.camera.CameraEnumerator
    public boolean isBackFacing(String r100) {
        CameraCharacteristics r101 = getCameraCharacteristics(r100);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (((Integer) r101.get(CameraCharacteristics.LENS_FACING)).intValue() != 1) goto L7;
        return true;
    }

    @Override // com.ss.bytertc.base.media.camera.CameraEnumerator
    public boolean isFrontFacing(String r100) {
        CameraCharacteristics r101 = getCameraCharacteristics(r100);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (((Integer) r101.get(CameraCharacteristics.LENS_FACING)).intValue() != 0) goto L7;
        return true;
    }

    public static List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> convertFramerates(Range<Integer>[] r100, int r101) {
        ArrayList r102 = new ArrayList();
        int r103 = r100.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        Range<Integer> r105 = r100[r104];
        r102.add(new CameraEnumerationAndroid.CaptureFormat.FramerateRange(((Integer) r105.getLower()).intValue() * r101, ((Integer) r105.getUpper()).intValue() * r101));
        r104 = r104 + 1;
        goto L3
    L5:
        return r102;
    }

    public static List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(CameraManager r110, String r111) {
        Map<String, List<CameraEnumerationAndroid.CaptureFormat>> r100 = cachedSupportedFormats;
        monitor-enter(r100);
    L36:
        th = move-exception;
        throw th;
    L5:
        if (r100.containsKey(r111) == false) goto L9;
        List<CameraEnumerationAndroid.CaptureFormat> r112 = r100.get(r111);     // Catch: Throwable -> L36
        monitor-exit(r100);     // Catch: Throwable -> L36
        return r112;
    L9:
        RXLogging.i(TAG, "Get supported formats for camera index " + r111 + ".");     // Catch: Throwable -> L36
        long r101 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L36
        CameraCharacteristics r113 = r110.getCameraCharacteristics(r111);     // Catch: Exception -> L32 Throwable -> L36
        StreamConfigurationMap r102 = (StreamConfigurationMap) r113.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);     // Catch: Throwable -> L36
        Range[] r103 = (Range[]) r113.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);     // Catch: Throwable -> L36
        List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> r104 = convertFramerates(r103, getFpsUnitFactor(r103));     // Catch: Throwable -> L36
        List<Size> r114 = getSupportedSizes(r113);     // Catch: Throwable -> L36
        Iterator<CameraEnumerationAndroid.CaptureFormat.FramerateRange> r105 = r104.iterator();     // Catch: Throwable -> L36
        int r106 = 0;
    L13:
        if (r105.hasNext() == false) goto L15;
        r106 = Math.max(r106, r105.next().max);     // Catch: Throwable -> L36
        goto L13
    L15:
        ArrayList r107 = new ArrayList();     // Catch: Throwable -> L36
        Iterator<Size> r115 = r114.iterator();     // Catch: Throwable -> L36
    L17:
        if (r115.hasNext() == false) goto L29;
        Size r108 = r115.next();     // Catch: Throwable -> L36
        long r116 = r102.getOutputMinFrameDuration(SurfaceTexture.class, new android.util.Size(r108.width, r108.height));     // Catch: Exception -> L22 Throwable -> L36
    L24:
        if (r116 != 0) goto L27;
        int r109 = r106;
    L28:
        r107.add(new CameraEnumerationAndroid.CaptureFormat(r108.width, r108.height, 0, r109));     // Catch: Throwable -> L36
        RXLogging.i(TAG, "Format: " + r108.width + "x" + r108.height + "@" + r109);     // Catch: Throwable -> L36
        goto L17
    L27:
        r109 = ((int) Math.round(NANO_SECONDS_PER_SECOND / r116)) * 1000;     // Catch: Throwable -> L36
    L22:
        r116 = 0;
        goto L24
    L29:
        cachedSupportedFormats.put(r111, r107);     // Catch: Throwable -> L36
        RXLogging.i(TAG, "Get supported formats for camera index " + r111 + " done. Time spent: " + (SystemClock.elapsedRealtime() - r101) + " ms.");     // Catch: Throwable -> L36
        monitor-exit(r100);     // Catch: Throwable -> L36
        return r107;
    L32:
        e = move-exception;
        RXLogging.e(TAG, "getCameraCharacteristics(): " + e);     // Catch: Throwable -> L36
        return new ArrayList();
    }

    @Override // com.ss.bytertc.base.media.camera.CameraEnumerator
    public CameraVideoCapturer createCapturer(String r100, CameraVideoCapturer.CameraEventsHandler r101) {
        return new Camera2Capturer(this.context, r100, r101);
    }

    public static List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(Context r100, String r101) {
        return getSupportedFormats((CameraManager) r100.getSystemService("camera"), r101);
    }
}
