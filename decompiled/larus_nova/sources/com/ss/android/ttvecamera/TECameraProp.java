package com.ss.android.ttvecamera;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.vesdk.VEConfigCenter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes38.dex */
public class TECameraProp {
    public static final String CAMERA_1_PARAMETERS = "CAMERA_1_PARAMETERS";
    public static final String CAMERA_2_CHARACTERISTICS = "CAMERA_2_CHARACTERISTICS";
    public static final String CAMERA_2_LIST = "CAMERA_2_LIST";
    public static final String CAMERA_2_STREAM_CONFIGURATION_MAP = "CAMERA_2_STREAM_CONFIGURATION_MAP";
    public static final String CAMERA_2_WIDE_ID = "CAMERA_2_WIDE_ID";
    private static final String TAG = "TECameraProb";
    public static final String VENDOR_CAMERA_KEY = "vendor_camera_";
    public static CameraManager cachedCameraManager;
    public static boolean sIsPreloadCamera1;
    public static boolean sIsPreloadCamera2;
    public static boolean sIsPreloadCameraVendor;
    public static final Map<String, Object> sPropMap = null;

    public TECameraProp() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        sPropMap = new HashMap();
        sIsPreloadCamera2 = false;
        sIsPreloadCamera1 = false;
        sIsPreloadCameraVendor = false;
        cachedCameraManager = null;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_ttvecamera_TECameraProp_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
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

    public static synchronized String[] getCameraIdList(CameraManager r100) throws CameraAccessException {
        monitor-enter(TECameraProp.class);
        Map<String, Object> r101 = sPropMap;     // Catch: Throwable -> L12
        if (r101.containsKey(CAMERA_2_LIST) == false) goto L7;
        String[] r102 = (String[]) r101.get(CAMERA_2_LIST);     // Catch: Throwable -> L12
    L10:
        monitor-exit(TECameraProp.class);
        return r102;
    L7:
        r102 = r100.getCameraIdList();     // Catch: Throwable -> L12
        if (r102 == null) goto L10;
        r101.put(CAMERA_2_LIST, r102);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    private static String getWideAngleIDInternal(Context r100) {
        CameraManager r101 = (CameraManager) r100.getSystemService("camera");     // Catch: Throwable -> L4
        return getWideAngleIDInternal(getCameraIdList(r101), r101);
    L4:
        th = move-exception;
        TELogUtils.e(TAG, "exception occurs when getWideAngleID", th);
        return "0";
    }

    public static synchronized boolean isSupportWideAngle(Context r100) {
        monitor-enter(TECameraProp.class);
        Map<String, Object> r101 = sPropMap;     // Catch: Throwable -> L12
        if (r101.containsKey(CAMERA_2_WIDE_ID) == false) goto L7;
        String r102 = (String) r101.get(CAMERA_2_WIDE_ID);     // Catch: Throwable -> L12
    L8:
        boolean r103 = !"0".equals(r102);
        monitor-exit(TECameraProp.class);
        return r103;
    L7:
        r102 = getWideAngleIDInternal(r100);     // Catch: Throwable -> L12
        r101.put(CAMERA_2_WIDE_ID, r102);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public static synchronized void preloadCamera1(Context r100) {
        monitor-enter(TECameraProp.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sIsPreloadCamera1 == true) goto L11;
        if (r100 == null) goto L11;
        sIsPreloadCamera1 = true;     // Catch: Throwable -> L13
        monitor-exit(TECameraProp.class);
        return;
    L11:
        monitor-exit(TECameraProp.class);
    }

    public static synchronized void preloadCamera2(Context r100) {
        monitor-enter(TECameraProp.class);
    L28:
        th = move-exception;
        throw th;
    L5:
        if (sIsPreloadCamera2 == true) goto L26;
        if (r100 == null) goto L26;
        int r101 = 0;
        if (VEConfigCenter.getInstance().getValue("veabtest_cache_camera_manager", false).booleanValue() == true) goto L10;
        CameraManager r102 = (CameraManager) r100.getSystemService("camera");     // Catch: Exception -> L22 Throwable -> L28
    L14:
        String[] r103 = getCameraIdList(r102);     // Catch: Exception -> L22 Throwable -> L28
        if (r103 == null) goto L20;
        int r104 = r103.length;     // Catch: Exception -> L22 Throwable -> L28
    L17:
        if (r101 >= r104) goto L19;
        String r105 = r103[r101];     // Catch: Exception -> L22 Throwable -> L28
        getStreamConfigurationMap(getCameraCharacteristics(r102, r105), r105);     // Catch: Exception -> L22 Throwable -> L28
        r101 = r101 + 1;     // Catch: Exception -> L22 Throwable -> L28
        goto L17
    L19:
        getWideAngleID(r103, r102);     // Catch: Exception -> L22 Throwable -> L28
    L20:
        sIsPreloadCamera2 = true;     // Catch: Exception -> L22 Throwable -> L28
    L24:
        monitor-exit(TECameraProp.class);
        return;
    L10:
        if (cachedCameraManager != null) goto L12;
        cachedCameraManager = (CameraManager) r100.getSystemService("camera");     // Catch: Exception -> L22 Throwable -> L28
    L12:
        r102 = cachedCameraManager;     // Catch: Exception -> L22 Throwable -> L28
    L22:
        e = move-exception;
        TELogUtils.e(TAG, "preloadCamera2 failed.", e);     // Catch: Throwable -> L28
    L26:
        monitor-exit(TECameraProp.class);
    }

    private static String genKeyWithCameraId(String r100, String r101) {
        return r100 + r101;
    }

    public static synchronized CameraCharacteristics getCameraCharacteristics(CameraManager r100, String r101) throws CameraAccessException {
        monitor-enter(TECameraProp.class);
        String r102 = genKeyWithCameraId(CAMERA_2_CHARACTERISTICS, r101);     // Catch: Throwable -> L10
        Map<String, Object> r103 = sPropMap;     // Catch: Throwable -> L10
        if (r103.containsKey(r102) == false) goto L7;
        CameraCharacteristics r104 = (CameraCharacteristics) r103.get(r102);     // Catch: Throwable -> L10
    L8:
        monitor-exit(TECameraProp.class);
        return r104;
    L7:
        r104 = r100.getCameraCharacteristics(r101);     // Catch: Throwable -> L10
        r103.put(r102, r104);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public static Camera.Parameters getParameters(Camera r100, int r101) {
        String r102 = genKeyWithCameraId(CAMERA_1_PARAMETERS, String.valueOf(r101));
        Map<String, Object> r103 = sPropMap;
        if (r103.containsKey(r102) == true) goto L7;
        Camera.Parameters r104 = r100.getParameters();
        r103.put(r102, r104);
        return r104;
    L7:
        return (Camera.Parameters) r103.get(r102);
    }

    public static synchronized StreamConfigurationMap getStreamConfigurationMap(CameraCharacteristics r100, String r101) throws CameraAccessException {
        monitor-enter(TECameraProp.class);
        String r102 = genKeyWithCameraId(CAMERA_2_STREAM_CONFIGURATION_MAP, r101);     // Catch: Throwable -> L19
        Map<String, Object> r103 = sPropMap;     // Catch: Throwable -> L19
        if (r103.containsKey(r102) == false) goto L25;
        StreamConfigurationMap r104 = (StreamConfigurationMap) r103.get(r102);     // Catch: Throwable -> L19
    L17:
        monitor-exit(TECameraProp.class);
        return r104;
    L25:
        r104 = (StreamConfigurationMap) r100.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);     // Catch: Throwable -> L14
        r103.put(r102, r104);     // Catch: Throwable -> L12
    L12:
        th = th;
    L16:
        TELogUtils.e(TAG, "getStreamConfigurationMap wrror: ", th);     // Catch: Throwable -> L19
    L14:
        th = th;
        r104 = null;
    L19:
        th = move-exception;
        throw th;
    }

    public static synchronized Object getVendorCameraInstance(Context r110, int r111) {
        monitor-enter(TECameraProp.class);
        Map<String, Object> r100 = sPropMap;     // Catch: Throwable -> L20
        if (r100.get(VENDOR_CAMERA_KEY + r111) == null) goto L23;
    L17:
        Object r112 = r100.get(VENDOR_CAMERA_KEY + r111);     // Catch: Throwable -> L20
        monitor-exit(TECameraProp.class);
        return r112;
    L23:
        Object r113 = INVOKESTATIC_com_ss_android_ttvecamera_TECameraProp_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.android.ttvecamera.TEVendorCamera").getMethod("initialize", new Class[]{Context.class, Integer.TYPE}).invoke(null, new Object[]{r110, Integer.valueOf(r111)});     // Catch: Exception -> L13 Throwable -> L20
        if (r113 == null) goto L11;
        r100.put(VENDOR_CAMERA_KEY + r111, r113);     // Catch: Exception -> L13 Throwable -> L20
    L11:
        monitor-exit(TECameraProp.class);
        return null;
    L13:
        e = move-exception;
        TELogUtils.w(TAG, "preloadVendorCamera failed.", e);     // Catch: Throwable -> L20
        return null;
    L20:
        th = move-exception;
        throw th;
    }

    public static synchronized String getWideAngleID(String[] r100, CameraManager r101) {
        monitor-enter(TECameraProp.class);
        Map<String, Object> r102 = sPropMap;     // Catch: Throwable -> L10
        if (r102.containsKey(CAMERA_2_WIDE_ID) == false) goto L7;
        String r103 = (String) r102.get(CAMERA_2_WIDE_ID);     // Catch: Throwable -> L10
    L8:
        monitor-exit(TECameraProp.class);
        return r103;
    L7:
        r103 = getWideAngleIDInternal(r100, r101);     // Catch: Throwable -> L10
        r102.put(CAMERA_2_WIDE_ID, r103);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    private static String getWideAngleIDInternal(String[] r100, CameraManager r110) {
        String r101 = "0";
        int r102 = r100.length;     // Catch: Throwable -> L24
        float r103 = Float.MAX_VALUE;
        int r104 = 0;
    L4:
        if (r104 >= r102) goto L23;
        String r105 = r100[r104];     // Catch: Throwable -> L24
        CameraCharacteristics r106 = getCameraCharacteristics(r110, r105);     // Catch: Throwable -> L24
        Integer r107 = (Integer) r106.get(CameraCharacteristics.LENS_FACING);     // Catch: Throwable -> L24
        if (r107 != null) goto L8;
    L10:
        float[] r108 = (float[]) r106.get(CameraCharacteristics.LENS_INFO_AVAILABLE_FOCAL_LENGTHS);     // Catch: Throwable -> L24
        if (r108 != null) goto L13;
    L16:
        float r109 = -1.0f;
    L18:
        if (r109 == (-1.0f)) goto L22;
        if (r109 > r103) goto L22;
        r101 = r105;
        r103 = r109;
    L22:
        r104 = r104 + 1;
        goto L4
    L13:
        if (r108.length <= 0) goto L16;
        r109 = r108[0];     // Catch: Throwable -> L24
        goto L18
    L8:
        if (r107.intValue() != 0) goto L10;
    L23:
        return r101;
    L24:
        th = move-exception;
        TELogUtils.e(TAG, "exception occurs when getWideAngleID: ", th);
        return r101;
    }

    public static synchronized void preload(Context r100, int r101) {
        monitor-enter(TECameraProp.class);
        if (r101 != 2) goto L10;
        preloadCamera2(r100);     // Catch: Throwable -> L7
    L20:
    L18:
        monitor-exit(TECameraProp.class);
        return;
    L10:
        if (r101 != 1) goto L13;
        preloadCamera1(r100);     // Catch: Throwable -> L7
        goto L20
    L13:
        if (r101 != 8) goto L18;
        preloadVendorCamera(r100, r101);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void preloadVendorCamera(Context r100, int r101) {
        monitor-enter(TECameraProp.class);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (sIsPreloadCameraVendor == true) goto L20;
        if (r100 == null) goto L20;
        TELogUtils.i(TAG, "preloadVendorCamera, cameraType = " + r101);     // Catch: Throwable -> L22
        if (r101 == 8) goto L12;
    L17:
        sIsPreloadCameraVendor = true;     // Catch: Throwable -> L22
        monitor-exit(TECameraProp.class);
        return;
    L12:
        if (Build.VERSION.SDK_INT < 28) goto L17;
        INVOKESTATIC_com_ss_android_ttvecamera_TECameraProp_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.ss.android.ttvecamera.xmv2.MiSDKSingleton").getMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{r100});     // Catch: Exception -> L15 Throwable -> L22
    L15:
        e = move-exception;
        TELogUtils.w(TAG, "preloadXiaomiCamera failed.", e);     // Catch: Throwable -> L22
    L20:
        monitor-exit(TECameraProp.class);
    }

    public static synchronized StreamConfigurationMap getStreamConfigurationMap(CameraManager r100, String r101) throws CameraAccessException {
        monitor-enter(TECameraProp.class);
        String r102 = genKeyWithCameraId(CAMERA_2_STREAM_CONFIGURATION_MAP, r101);     // Catch: Throwable -> L10
        Map<String, Object> r103 = sPropMap;     // Catch: Throwable -> L10
        if (r103.containsKey(r102) == false) goto L7;
        StreamConfigurationMap r104 = (StreamConfigurationMap) r103.get(r102);     // Catch: Throwable -> L10
    L8:
        monitor-exit(TECameraProp.class);
        return r104;
    L7:
        r104 = (StreamConfigurationMap) getCameraCharacteristics(r100, r101).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);     // Catch: Throwable -> L10
        r103.put(r102, r104);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }
}
