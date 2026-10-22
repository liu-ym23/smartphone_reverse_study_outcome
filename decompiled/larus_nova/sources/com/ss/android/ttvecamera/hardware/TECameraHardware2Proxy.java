package com.ss.android.ttvecamera.hardware;

import android.content.Context;
import android.graphics.Rect;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.os.Build;
import android.util.Range;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.ss.android.ttvecamera.TECameraMonitor;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.android.ttvecamera.TEFrameRateRange;
import com.ss.android.ttvecamera.TELogUtils;
import com.ss.android.vesdk.VEConfigCenter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes38.dex */
public class TECameraHardware2Proxy {
    private static final String TAG = "TECameraHardware2Proxy";
    public static int mCameraType = 1;
    protected Context mContext;

    public boolean isARCoreSupported() {
        return false;
    }

    public boolean isSupportAntiShake(int r100) {
        return false;
    }

    public boolean isSupportHDR(CameraCharacteristics r100, int r101) {
        return false;
    }

    public boolean isSupportHighFPS(CameraCharacteristics r100) {
        return false;
    }

    public boolean isSupportTelephoto(CameraCharacteristics r100) {
        return false;
    }

    public boolean isSupportWideAngle(CameraCharacteristics r100) {
        return false;
    }

    public String getTelephotoID() {
        CameraManager r100 = (CameraManager) this.mContext.getSystemService("camera");
        return getTelephotoID(r100.getCameraIdList(), r100);
    L5:
        e = move-exception;
        e.printStackTrace();
        return "0";
    }

    public String getWideAngleID() {
        long r100 = System.currentTimeMillis();
        CameraManager r101 = (CameraManager) this.mContext.getSystemService("camera");
        String r102 = getWideAngleID(r101.getCameraIdList(), r101);     // Catch: Throwable -> L5
        TELogUtils.i(TAG, "getWideAngleID, wideAngleId = " + r102 + ", cost time = " + (System.currentTimeMillis() - r100));     // Catch: Throwable -> L5
        return r102;
    L5:
        th = move-exception;
        TELogUtils.e(TAG, "exception occurs when getWideAngleID", th);
        return "0";
    }

    public boolean isSupportTelephoto() {
        return !getTelephotoID().equals("0");
    }

    public boolean isSupportWideAngle() {
        return !getWideAngleID().equals("0");
    }

    public TECameraHardware2Proxy(Context r100) {
        this.mContext = r100;
    }

    public float getShaderZoomStep(CameraCharacteristics r100) {
        float r101 = ((Float) r100.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue();
        Rect r102 = (Rect) r100.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        return CastFloatProtector.valueOf(new DecimalFormat("0.00").format(((r102.width() - ((int) (r102.width() / r101))) / r101) / r102.width()).trim()).floatValue();
    L5:
        e = move-exception;
        e.printStackTrace();
        return 0.01f;
    }

    public Range<Float> getZoomValueRange(CameraCharacteristics r100) {
    L7:
        e = move-exception;
        TELogUtils.w(TAG, "getZoomValueRange catch exception: ", e);
    L9:
        Float r101 = (Float) r100.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        return new Range(Float.valueOf(0.0f), r101);
    L3:
        if (Build.VERSION.SDK_INT < 30) goto L9;
        Range<Float> r102 = (Range) r100.get(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE);     // Catch: Exception -> L7
        if (r102 == null) goto L9;
        return r102;
    }

    public boolean isDualCameraModeSupport(int r110) {
        CameraManager r100 = (CameraManager) this.mContext.getSystemService("camera");
        if (Build.VERSION.SDK_INT >= 30) goto L33;
    L32:
        return false;
    L33:
        Set<Set<String>> r101 = r100.getConcurrentCameraIds();     // Catch: CameraAccessException -> L30
        if (r101 == null) goto L32;
        Iterator<Set<String>> r102 = r101.iterator();     // Catch: CameraAccessException -> L30
    L7:
        if (r102.hasNext() == false) goto L32;
        Iterator<String> r103 = r102.next().iterator();     // Catch: CameraAccessException -> L30
        boolean r104 = false;
        boolean r105 = false;
    L11:
        if (r103.hasNext() == false) goto L26;
        String r106 = r103.next();     // Catch: CameraAccessException -> L30
        CameraCharacteristics r107 = r100.getCameraCharacteristics(r106);     // Catch: CameraAccessException -> L30
        if (r107 == null) goto L11;
        if (((Integer) r107.get(CameraCharacteristics.LENS_FACING)).intValue() != 1) goto L21;
        if (r106.equals("0") == false) goto L21;
        r104 = true;
    L21:
        if (((Integer) r107.get(CameraCharacteristics.LENS_FACING)).intValue() != 0) goto L11;
        if (r106.equals("1") == false) goto L11;
        r105 = true;
        goto L11
    L26:
        if (r110 != 7) goto L7;
        if (r104 == false) goto L7;
        if (r105 == false) goto L7;
        return true;
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L32
    }

    public boolean isEISSupported(CameraCharacteristics r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int[] r101 = (int[]) r100.get(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES);
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r101.length <= 0) goto L12;
        return true;
    L12:
        return false;
    }

    public boolean isFocusSupported(CameraCharacteristics r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (((Integer) r100.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue() < 1) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean isHDR10BitSupported(CameraCharacteristics r100) {
        if (r100 != null) goto L5;
    L14:
        return false;
    L5:
        if (Build.VERSION.SDK_INT < 33) goto L14;
        int[] r101 = (int[]) r100.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        int r102 = r101.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L14;
        if (r101[r103] == 18) goto L11;
        r103 = r103 + 1;
        goto L8
    L11:
        return true;
    }

    public boolean isLogicalMultiCamSupported(CameraCharacteristics r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int[] r101 = (int[]) r100.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
        int r102 = r101.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L12;
        if (r101[r103] == 11) goto L9;
        r103 = r103 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public boolean isMeteringSupported(CameraCharacteristics r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (((Integer) r100.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE)).intValue() < 1) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean isOISSupported(CameraCharacteristics r100) {
        int[] r101 = (int[]) r100.get(CameraCharacteristics.LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION);
        if (r101 == null) goto L10;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L10;
        if (r101[r103] == 1) goto L8;
        r103 = r103 + 1;
        goto L5
    L8:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public boolean isStabilizationSupported(CameraCharacteristics r100) {
        boolean r101 = isEISSupported(r100);
        ?? r102 = r101;
        if (isOISSupported(r100) == false) goto L5;
        r102 = (r101 ? 1 : 0) | 2;
    L5:
        TELogUtils.i(TAG, "Stabilization type: " + Integer.toBinaryString(r102));
        TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_STABILIZATION, (long) r102);
        if (r102 <= 0) goto L8;
        return true;
    L8:
        return false;
    }

    public boolean isTorchSupported(CameraCharacteristics r100) {
        return ((Boolean) r100.get(CameraCharacteristics.FLASH_INFO_AVAILABLE)).booleanValue();
    }

    public static TECameraHardware2Proxy getDeviceProxy(Context r100, int r101) {
        TELogUtils.i(TAG, "getDeviceProxy, cameraType: " + r101);
        mCameraType = r101;
        if (TECameraHardware2.isSSPlatform() == false) goto L6;
        return new TECameraSSProxy(r100);
    L6:
        if (TECameraHardware2.isQCOMPlatform() == false) goto L9;
        return new TECameraQcomProxy(r100);
    L9:
        if (TECameraHardware2.isMTKPlatform() == false) goto L12;
        return new TECameraMTKProxy(r100);
    L12:
        if (TECameraHardware2.isHWPlatform() == true) goto L19;
        TELogUtils.e(TAG, "Unknown platform");
        return new TECameraHardware2Proxy(r100);
    L19:
        return new TECameraHWProxy(r100);
    }

    public String getTelephotoID(String[] r100, CameraManager r110) {
        String r101 = "0";
        int r102 = r100.length;     // Catch: IllegalArgumentException -> L20 Throwable -> L22
        float r103 = Float.MIN_VALUE;
        int r104 = 0;
    L4:
        if (r104 >= r102) goto L24;
        String r105 = r100[r104];     // Catch: IllegalArgumentException -> L20 Throwable -> L22
        CameraCharacteristics r106 = r110.getCameraCharacteristics(r105);     // Catch: IllegalArgumentException -> L20 Throwable -> L22
        Integer r107 = (Integer) r106.get(CameraCharacteristics.LENS_FACING);     // Catch: IllegalArgumentException -> L20 Throwable -> L22
        if (r107 != null) goto L8;
    L10:
        float[] r108 = (float[]) r106.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);     // Catch: IllegalArgumentException -> L20 Throwable -> L22
        if (r108 != null) goto L13;
    L14:
        r108 = new float[]{0.0f};     // Catch: IllegalArgumentException -> L20 Throwable -> L22
    L15:
        float r109 = r108[0];     // Catch: IllegalArgumentException -> L20 Throwable -> L22
        if (r109 <= r103) goto L19;
        r101 = r105;
        r103 = r109;
    L19:
        r104 = r104 + 1;
        goto L4
    L13:
        if (r108.length != 0) goto L15;
    L8:
        if (r107.intValue() != 0) goto L10;
    L24:
        return r101;
    L22:
        e = move-exception;
        e.printStackTrace();
        goto L24
    }

    public String getWideAngleID(String[] r110, CameraManager r111) {
        String r100 = "0";
        int r101 = r110.length;     // Catch: Throwable -> L24
        float r102 = Float.MAX_VALUE;
        int r103 = 0;
    L4:
        if (r103 >= r101) goto L23;
        String r104 = r110[r103];     // Catch: Throwable -> L24
        CameraCharacteristics r105 = r111.getCameraCharacteristics(r104);     // Catch: Throwable -> L24
        Integer r106 = (Integer) r105.get(CameraCharacteristics.LENS_FACING);     // Catch: Throwable -> L24
        if (r106 != null) goto L8;
    L10:
        float[] r107 = (float[]) r105.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);     // Catch: Throwable -> L24
        if (r107 != null) goto L13;
    L16:
        float r108 = -1.0f;
    L18:
        if (r108 == (-1.0f)) goto L22;
        if (r108 > r102) goto L22;
        r100 = r104;
        r102 = r108;
    L22:
        r103 = r103 + 1;
        goto L4
    L13:
        if (r107.length <= 0) goto L16;
        r108 = r107[0];     // Catch: Throwable -> L24
        goto L18
    L8:
        if (r106.intValue() != 0) goto L10;
    L23:
        return r100;
    L24:
        th = move-exception;
        TELogUtils.e(TAG, "exception occurs when getWideAngleID: ", th);
        return r100;
    }

    public boolean isHardwareLevelSupported(CameraCharacteristics r100, int r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        Integer r102 = (Integer) r100.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        if (r102 == null) goto L8;
        int r103 = r102.intValue();
    L10:
        if (r103 >= 0) goto L12;
    L25:
        TELogUtils.e(TAG, "Invalid hardware level = " + r103);
        return false;
    L12:
        if (r103 > 4) goto L25;
        int r104 = TECameraHardware2.CameraHWLevelAndroid2VE[r103];
        TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_HARDWARE_LEVEL, r104);
        if (Build.VERSION.SDK_INT >= 22) goto L20;
        if (r103 != 2) goto L20;
        return false;
    L20:
        if (r104 < r101) goto L23;
        TELogUtils.i(TAG, "Camera hardware level supported, deviceLevel = " + r104 + ", require = " + r101);
        return true;
    L23:
        TELogUtils.e(TAG, "Camera hardware level not supported, deviceLevel = " + r104 + ", require = " + r101);
        return false;
    L8:
        r103 = -1;
        goto L10
    }

    public float getMaxZoomValue(CameraCharacteristics r100, int r101, float r102) {
        Float r103 = (Float) r100.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        if (r103 != null) goto L6;
        return 0.0f;
    L6:
        float r104 = r103.floatValue();
        if (r102 != (-1.0f)) goto L12;
        if (Build.VERSION.SDK_INT < 30) goto L14;
        return r104;
    L14:
        return r104 / 2.0f;
    L12:
        return r104 * r102;
    }

    public int configStabilization(CameraCharacteristics r110, CaptureRequest.Builder r111, boolean r112, int r210) {
        if (r110 == null) goto L66;
        if (r111 == null) goto L86;
        TELogUtils.i(TAG, "toggle is " + r112 + " , mode is " + r210);
        if (r112 == true) goto L10;
        TELogUtils.i(TAG, "configStabilization not toggle");
        r111.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, 0);
        r111.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 0);
        return 0;
    L10:
        int r113 = 1;
        if (r210 == 0) goto L40;
        if (r210 != 1) goto L14;
        int[] r100 = (int[]) r110.get(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES);
        if (r100 == null) goto L39;
        int r101 = r100.length;
        int r102 = 0;
    L32:
        if (r102 >= r101) goto L84;
        int r103 = r100[r102];
        TELogUtils.i(TAG, "EIS mode: " + r103);
        if (r103 != 1) goto L38;
        r111.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 1);
        r111.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, 0);
        TELogUtils.i(TAG, "Enable EIS");
        if (VEConfigCenter.getInstance().getValue("ve_enable_eis_ois_hw", false).booleanValue() == true) goto L38;
        return 0;
    L38:
        r102 = r102 + 1;
        goto L32
    L84:
        return -200;
    L39:
        TELogUtils.i(TAG, "Don't supported EIS");
        return -200;
    L14:
        if (r210 != 2) goto L82;
        int[] r104 = (int[]) r110.get(CameraCharacteristics.LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION);
        if (r104 == null) goto L28;
        int r105 = r104.length;
        int r106 = 0;
    L19:
        if (r106 >= r105) goto L83;
        int r107 = r104[r106];
        TELogUtils.i(TAG, "OIS mode: " + r107);
        if (r107 == 1) goto L22;
        r106 = r106 + 1;
        goto L19
    L22:
        r111.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, 1);
        if (VEConfigCenter.getInstance().getValue("ve_enable_eis_ois_hw", false).booleanValue() == true) goto L25;
        r111.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 0);
        TELogUtils.i(TAG, "Enable OIS,Disable EIS");
    L26:
        return 0;
    L25:
        TELogUtils.i(TAG, "Enable OIS");
        goto L26
    L83:
        return -200;
    L28:
        TELogUtils.i(TAG, "Don't supported OIS");
        return -200;
    L82:
        return -200;
    L40:
        int[] r108 = (int[]) r110.get(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES);
        if (r108 == null) goto L50;
        int r114 = r108.length;
        int r115 = 0;
    L43:
        if (r115 >= r114) goto L51;
        int r116 = r108[r115];
        TELogUtils.i(TAG, "EIS mode: " + r116);
        if (r116 != r113) goto L49;
        r111.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, Integer.valueOf(r113));
        r111.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, 0);
        TELogUtils.i(TAG, "Enable EIS");
        if (VEConfigCenter.getInstance().getValue("ve_enable_eis_ois_hw", false).booleanValue() == true) goto L49;
        return 0;
    L49:
        r115 = r115 + 1;
        r113 = 1;
    L51:
        int[] r109 = (int[]) r110.get(CameraCharacteristics.LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION);
        if (r109 == null) goto L63;
        int r117 = r109.length;
        int r118 = 0;
    L54:
        if (r118 >= r117) goto L85;
        int r119 = r109[r118];
        TELogUtils.i(TAG, "OIS mode: " + r119);
        if (r119 == 1) goto L57;
        r118 = r118 + 1;
        goto L54
    L57:
        r111.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, 1);
        if (VEConfigCenter.getInstance().getValue("ve_enable_eis_ois_hw", false).booleanValue() == true) goto L60;
        r111.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, 0);
        TELogUtils.i(TAG, "Enable OIS,Disable EIS");
    L61:
        return 0;
    L60:
        TELogUtils.i(TAG, "Enable OIS");
        goto L61
    L85:
        return -200;
    L63:
        TELogUtils.i(TAG, "Don't supported OIS");
        return -200;
    L50:
        TELogUtils.i(TAG, "Don't supported EIS");
        goto L51
    L86:
        return -100;
    L66:
        return -100;
    }

    public TEFrameRateRange getFPSRange(CameraCharacteristics r110, int r111, int r112, int r113, int r114) {
        TEFrameRateRange r100 = new TEFrameRateRange(r111, r112);
        if (r110 != null) goto L5;
        return r100;
    L5:
        Range[] r115 = (Range[]) r110.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        if (r115 != null) goto L8;
        return r100;
    L8:
        ArrayList r116 = new ArrayList(r115.length);
        int r117 = r100.fpsUnitFactor;
        int r101 = r115.length;
        int r102 = 0;
        int r103 = 0;
    L10:
        if (r102 >= r101) goto L15;
        Range r104 = r115[r102];
        int[] r105 = {((Integer) r104.getLower()).intValue() * r117, ((Integer) r104.getUpper()).intValue() * r117};
        r116.add(r105);
        int r106 = r105[1];
        if (r103 >= r106) goto L14;
        r103 = r106;
    L14:
        r102 = r102 + 1;
        goto L10
    L15:
        TECameraMonitor.perfLong(TECameraMonitor.TE_RECORD_CAMERA_MAX_FPS, r103);
        int[] r118 = TECameraUtils.getFpsRange(r113, r114, r100.getRealFpsRange(), r116);
        r100.min = r118[0];
        r100.max = r118[1];
        return r100;
    }
}
