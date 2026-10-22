package com.ss.android.ttvecamera;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.camera2.CameraManager;
import android.media.Image;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Range;
import android.util.Size;
import android.view.WindowManager;
import androidx.core.content.ContextCompat;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.sva.sdk.data.ISmModel;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes38.dex */
public class TECameraUtils {
    public static final int CAPTURE_HQ_2X = 2560;
    public static final int CAPTURE_HQ_3X = 3264;
    public static final int CAPTURE_NORMAL = 1920;
    static final ArrayList<TEFrameSizei> COMMON_RESOLUTIONS = null;
    private static final String TAG = "TECameraUtils";
    private static String[] abortCapturesBlockList = null;
    public static Map<Long, String> hdrProfilesMap = null;
    private static String[] highPerformanceCpuList = null;
    private static boolean isHighPerformanceCpu = false;
    private static boolean isInAbortCapturesBlockList = false;
    private static Class mCameraMNClass = null;
    private static Field mCameraMNField = null;
    private static Method mCameraMNFinalizeMethod = null;
    public static byte mOptionFlags = 0;
    private static String sHardware = null;
    private static int sTakePickMaxSide = 1920;

    public static abstract class ClosestComparator<T> implements Comparator<T> {
        private ClosestComparator() {
        }

        public abstract int diff(T r100);

        public /* synthetic */ ClosestComparator(AnonymousClass1 r100) {
            this();
        }

        @Override // java.util.Comparator
        public int compare(T r100, T r101) {
            return diff(r100) - diff(r101);
        }
    }

    public TECameraUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static int clamp(int r100, int r101, int r102) {
        if (r100 <= r102) goto L4;
        return r102;
    L4:
        if (r100 >= r101) goto L6;
        return r101;
    L6:
        return r100;
    }

    public static boolean isDualCameraModeSupport(Context r100, int r101, int r102) {
        if (r101 != 2) goto L6;
        return true;
    L6:
        if (r101 != 8) goto L8;
        return true;
    L8:
        return false;
    }

    static {
        highPerformanceCpuList = new String[]{"SDM632", "SDM636", "SDM638", "SDM660", "SDM670", "SDM710", "SDM720", "MSM8996", "MSM8998", "SDM845", "KIRIN980", "KIRIN970", "KIRIN710", "HI3660", "MT6771", "Exynos 9810", "Exynos 8895"};
        abortCapturesBlockList = new String[]{"BAC-AL00", "ANE-AL00", "HWI-AL00"};
        int r100 = 0;
        isInAbortCapturesBlockList = false;
        mCameraMNClass = null;
        mCameraMNField = null;
        mCameraMNFinalizeMethod = null;
        mOptionFlags = 0;
        HashMap r101 = new HashMap();
        hdrProfilesMap = r101;
        r101.put(1L, "STANDARD");
        hdrProfilesMap.put(2L, "HLG10");
        hdrProfilesMap.put(4L, "HDR10");
        hdrProfilesMap.put(8L, "HDR10_PLUS");
        hdrProfilesMap.put(16L, "DOLBY_VISION_10B_HDR_REF");
        hdrProfilesMap.put(32L, "DOLBY_VISION_10B_HDR_REF_PO");
        hdrProfilesMap.put(64L, "DOLBY_VISION_10B_HDR_OEM");
        hdrProfilesMap.put(128L, "DOLBY_VISION_10B_HDR_OEM_PO");
        hdrProfilesMap.put(256L, "DOLBY_VISION_8B_HDR_REF");
        hdrProfilesMap.put(512L, "DOLBY_VISION_8B_HDR_REF_PO");
        hdrProfilesMap.put(1024L, "DOLBY_VISION_8B_HDR_OEM");
        hdrProfilesMap.put(2048L, "DOLBY_VISION_8B_HDR_OEM_PO");
        hdrProfilesMap.put(4096L, "PUBLIC_MAX");
        COMMON_RESOLUTIONS = new ArrayList(Arrays.asList(new TEFrameSizei[]{new TEFrameSizei(160, 120), new TEFrameSizei(240, 160), new TEFrameSizei(320, 240), new TEFrameSizei(400, 240), new TEFrameSizei(480, 320), new TEFrameSizei(640, 360), new TEFrameSizei(640, 480), new TEFrameSizei(ISmModel.VERSION_0300, 480), new TEFrameSizei(854, 480), new TEFrameSizei(800, 600), new TEFrameSizei(960, 540), new TEFrameSizei(960, 640), new TEFrameSizei(1024, 576), new TEFrameSizei(1024, 600), new TEFrameSizei(1280, 720), new TEFrameSizei(1280, 1024), new TEFrameSizei(CAPTURE_NORMAL, 1080), new TEFrameSizei(CAPTURE_NORMAL, 1440), new TEFrameSizei(CAPTURE_HQ_2X, 1440), new TEFrameSizei(3840, 2160)}));
        String r102 = getCPUHardware();
        if (TextUtils.isEmpty(r102) == true) goto L10;
        r102 = r102.toUpperCase();
        String[] r103 = highPerformanceCpuList;
        int r104 = r103.length;
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L10;
        if (r102.contains(r103[r105]) == true) goto L8;
        r105 = r105 + 1;
        goto L5
    L8:
        isHighPerformanceCpu = true;
    L10:
        String r106 = Build.MODEL;
        if (TextUtils.isEmpty(r106) == true) goto L18;
        r106 = r106.toUpperCase();
        String[] r107 = abortCapturesBlockList;
        int r108 = r107.length;
    L13:
        if (r100 >= r108) goto L18;
        if (r107[r100].equals(r106) == true) goto L16;
        r100 = r100 + 1;
        goto L13
    L16:
        isInAbortCapturesBlockList = true;
    L18:
        TELogUtils.i(TAG, "cpuHardware: " + r102 + ", isHighPerformanceCpu: " + isHighPerformanceCpu + "model: " + r106 + ", isInAbortCapturesBlockList: " + isInAbortCapturesBlockList);
    }

    public static String getCPUHardware() {
        if (TextUtils.isEmpty(sHardware) == false) goto L5;
        BufferedReader r100 = null;
        BufferedReader r101 = new BufferedReader(new PolarisFileReaderWrapper("/proc/cpuinfo"));     // Catch: Throwable -> L27 Exception -> L29
    L54:
        String r102 = r101.readLine();     // Catch: Throwable -> L23 Exception -> L25
        if (r102 == null) goto L21;
        if (r102.startsWith("Hardware") == false) goto L54;
        String[] r103 = r102.split(":");     // Catch: Throwable -> L23 Exception -> L25
        if (r103.length <= 1) goto L54;
        String r104 = r103[1].trim();     // Catch: Throwable -> L23 Exception -> L25
        sHardware = r104;     // Catch: Throwable -> L23 Exception -> L25
        r101.close();     // Catch: IOException -> L18
    L20:
        return r104;
    L18:
        e = move-exception;
        e.printStackTrace();
        goto L20
    L21:
        r101.close();     // Catch: IOException -> L34
    L48:
    L36:
        String r105 = Build.HARDWARE;
        sHardware = r105;
        return r105;
    L25:
        e = e;
        r100 = r101;
    L30:
        e.printStackTrace();     // Catch: Throwable -> L27
        if (r100 == null) goto L36;
        r100.close();     // Catch: IOException -> L34
    L23:
        th = th;
        r100 = r101;
    L38:
        if (r100 != null) goto L44;
    L43:
        throw th;
    L44:
        r100.close();     // Catch: IOException -> L41
    L41:
        e = move-exception;
        e.printStackTrace();
    L29:
        e = e;
    L27:
        th = th;
    L34:
        e = move-exception;
        e.printStackTrace();
        goto L36
    L5:
        return sHardware;
    }

    public static boolean isSupportCameraV2AutoFocus() {
        String r100 = Build.MANUFACTURER;
        if (r100.equalsIgnoreCase(SmEditTextLeakOpt.SAMSUNG) == false) goto L5;
    L8:
        return true;
    L5:
        if (r100.equalsIgnoreCase(RomUtils.BRAND_HUAWEI) == true) goto L8;
        return false;
    }

    public static int getTakePickMaxSide() {
        return sTakePickMaxSide;
    }

    public static boolean isHighPerformanceCpu() {
        return isHighPerformanceCpu;
    }

    public static boolean isInAbortCapturesBlockList() {
        return isInAbortCapturesBlockList;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_ttvecamera_TECameraUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static void checkIsOnCameraThread(Handler r100) {
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(r100.getLooper())) goto L6;
        return;
    L6:
        throw new IllegalStateException("Wrong thread");
    }

    public static int clamp(int r100) {
        return clamp(r100, -1000, 1000);
    }

    public static List<TEFrameSizei> convertFromCameraSizes(List<Camera.Size> r100) {
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<Camera.Size> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Camera.Size r103 = r102.next();
        r101.add(new TEFrameSizei(r103.width, r103.height));
        goto L4
    L6:
        return r101;
    }

    public static List<TEFrameRateRange> convertRanges(Range<Integer>[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ArrayList r101 = new ArrayList(r100.length);
        int r102 = r100.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L8;
        Range<Integer> r104 = r100[r103];
        r101.add(new TEFrameRateRange(((Integer) r104.getLower()).intValue(), ((Integer) r104.getUpper()).intValue()));
        r103 = r103 + 1;
        goto L6
    L8:
        return r101;
    }

    public static List<TEFrameSizei> convertSizes(List<Size> r100) {
        if (r100 == null) goto L4;
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<Size> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        Size r103 = r102.next();
        r101.add(new TEFrameSizei(r103.getWidth(), r103.getHeight()));
        goto L7
    L9:
        return r101;
    L4:
        return new ArrayList();
    }

    public static boolean finalizeCameraResult(Object r100) {
    L17:
        TELogUtils.w(TAG, "CameraMetadataNative class not found");
    L18:
        return false;
    L14:
        TELogUtils.w(TAG, "illegal access");
    L15:
        TELogUtils.w(TAG, "mResults field not found");
    L16:
        TELogUtils.w(TAG, "finalize method not found");
    L13:
        TELogUtils.w(TAG, "method invoke error");
    L12:
        TELogUtils.w(TAG, IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        goto L18
    L4:
        if (mCameraMNClass != null) goto L6;
    L9:
        mCameraMNClass = INVOKESTATIC_com_ss_android_ttvecamera_TECameraUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.hardware.camera2.impl.CameraMetadataNative");     // Catch: Exception -> L12 InvocationTargetException -> L13 IllegalAccessException -> L14 NoSuchFieldException -> L15 NoSuchMethodException -> L16 ClassNotFoundException -> L17
        mCameraMNField = r100.getClass().getSuperclass().getDeclaredField("mResults");     // Catch: Exception -> L12 InvocationTargetException -> L13 IllegalAccessException -> L14 NoSuchFieldException -> L15 NoSuchMethodException -> L16 ClassNotFoundException -> L17
        Method r101 = mCameraMNClass.getDeclaredMethod("finalize", new Class[0]);     // Catch: Exception -> L12 InvocationTargetException -> L13 IllegalAccessException -> L14 NoSuchFieldException -> L15 NoSuchMethodException -> L16 ClassNotFoundException -> L17
        mCameraMNFinalizeMethod = r101;     // Catch: Exception -> L12 InvocationTargetException -> L13 IllegalAccessException -> L14 NoSuchFieldException -> L15 NoSuchMethodException -> L16 ClassNotFoundException -> L17
        r101.setAccessible(true);     // Catch: Exception -> L12 InvocationTargetException -> L13 IllegalAccessException -> L14 NoSuchFieldException -> L15 NoSuchMethodException -> L16 ClassNotFoundException -> L17
        mCameraMNField.setAccessible(true);     // Catch: Exception -> L12 InvocationTargetException -> L13 IllegalAccessException -> L14 NoSuchFieldException -> L15 NoSuchMethodException -> L16 ClassNotFoundException -> L17
    L10:
        Object r102 = mCameraMNField.get(r100);     // Catch: Exception -> L12 InvocationTargetException -> L13 IllegalAccessException -> L14 NoSuchFieldException -> L15 NoSuchMethodException -> L16 ClassNotFoundException -> L17
        mCameraMNFinalizeMethod.invoke(r102, new Object[0]);     // Catch: Exception -> L12 InvocationTargetException -> L13 IllegalAccessException -> L14 NoSuchFieldException -> L15 NoSuchMethodException -> L16 ClassNotFoundException -> L17
        return true;
    L6:
        if (mCameraMNField == null) goto L9;
        if (mCameraMNFinalizeMethod != null) goto L10;
        goto L9
    }

    public static int getDeviceOrientation(Context r100) {
        int r101 = ((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay().getRotation();
        if (r101 != 1) goto L5;
        return 90;
    L5:
        if (r101 != 2) goto L7;
        return 180;
    L7:
        if (r101 == 3) goto L9;
        return 0;
    L9:
        return 270;
    }

    public static String getHDRProfile(long r100) {
        return hdrProfilesMap.get(Long.valueOf(r100));
    }

    public static boolean isCameraPermissionGranted(Context r100) {
        boolean r101 = true;
        if (ContextCompat.checkSelfPermission(r100, "android.permission.CAMERA") == 0) goto L9;
        r101 = false;
    L9:
        TELogUtils.w(TAG, "isCameraPermissionGranted = " + r101);
        return r101;
    L7:
        e = move-exception;
        TELogUtils.e(TAG, "check camera permission failed!", e);
        goto L9
    }

    public static boolean isSupportsCamera2(Context r100) {
        int r101 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L14
        CameraManager r102 = (CameraManager) r100.getSystemService("camera");     // Catch: Throwable -> L14
        if (r101 < 28) goto L6;
    L12:
        Method r103 = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", new Class[]{String.class, Class[].class}).invoke(r102.getClass(), new Object[]{"supportsCamera2ApiLocked", String.class});     // Catch: Throwable -> L14
        r103.setAccessible(true);     // Catch: Throwable -> L14
        return ((Boolean) r103.invoke(r102, new Object[]{"0"})).booleanValue();
    L6:
        if (r101 == 27) goto L8;
    L10:
        Method r104 = r102.getClass().getDeclaredMethod("supportsCamera2ApiLocked", new Class[]{String.class});     // Catch: Throwable -> L14
        r104.setAccessible(true);     // Catch: Throwable -> L14
        return ((Boolean) r104.invoke(r102, new Object[]{"0"})).booleanValue();
    L8:
        if (Build.VERSION.PREVIEW_SDK_INT <= 0) goto L10;
    L14:
        th = move-exception;
        th.printStackTrace();
        return true;
    }

    public static boolean isValidRect(Rect r100) {
        if (r100 != null) goto L4;
    L14:
        return false;
    L4:
        if (r100.isEmpty() == true) goto L14;
        if (r100.left < 0) goto L14;
        if (r100.right < 0) goto L14;
        if (r100.top < 0) goto L14;
        if (r100.bottom < 0) goto L14;
        return true;
    }

    public static void setTakePickMaxSide(int r100) {
        sTakePickMaxSide = r100;
    }

    public static List<TEFrameSizei> convertSizes(Size[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ArrayList r101 = new ArrayList(r100.length);
        int r102 = r100.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L8;
        Size r104 = r100[r103];
        r101.add(new TEFrameSizei(r104.getWidth(), r104.getHeight()));
        r103 = r103 + 1;
        goto L6
    L8:
        return r101;
    }

    private static TEFrameSizei calcHighCpuPictureSize(List<TEFrameSizei> r100, TEFrameSizei r101) {
        Iterator<TEFrameSizei> r102 = r100.iterator();
        TEFrameSizei r103 = null;
    L4:
        if (r102.hasNext() == false) goto L14;
        TEFrameSizei r104 = r102.next();
        int r105 = r104.width;
        if (r105 <= r101.width) goto L4;
        if (r104.height <= r101.height) goto L4;
        if (r103 == null) goto L13;
        if (r105 >= r103.width) goto L4;
    L13:
        r103 = r104;
        goto L4
    L14:
        if (r103 != null) goto L16;
        return null;
    L16:
        return r103;
    }

    public static TEFrameSizei calcPreviewSizeByRadio(List<TEFrameSizei> r100, float r101) {
        if (r101 > 0.0f) goto L5;
        return null;
    L5:
        if (r100 != null) goto L7;
        return null;
    L7:
        if (r100.size() <= 0) goto L43;
        ArrayList r102 = new ArrayList();
        ArrayList r103 = new ArrayList();
        Iterator<TEFrameSizei> r104 = r100.iterator();
    L10:
        if (r104.hasNext() == false) goto L16;
        TEFrameSizei r105 = r104.next();
        if (Float.compare(r101, r105.width / r105.height) == 0) goto L13;
        r103.add(r105);
        goto L10
    L13:
        r102.add(r105);
        goto L10
    L16:
        if (r102.isEmpty() == true) goto L26;
        ArrayList<TEFrameSizei> r106 = COMMON_RESOLUTIONS;
        if (r102.contains(ListProtector.get(r106, 14)) == false) goto L22;
        return (TEFrameSizei) ListProtector.get(r106, 14);
    L22:
        if (r102.contains(ListProtector.get(r106, 16)) == true) goto L24;
        Collections.sort(r102, new AnonymousClass11());
        return (TEFrameSizei) ListProtector.get(r102, 0);
    L24:
        return (TEFrameSizei) ListProtector.get(r106, 16);
    L26:
        ArrayList<TEFrameSizei> r107 = COMMON_RESOLUTIONS;
        if (r103.contains(ListProtector.get(r107, 14)) == false) goto L31;
        return (TEFrameSizei) ListProtector.get(r107, 14);
    L31:
        if (r102.contains(ListProtector.get(r107, 16)) == true) goto L33;
        Collections.sort(r103, new AnonymousClass12());
        return (TEFrameSizei) ListProtector.get(r102, r102.size() / 2);
    L33:
        return (TEFrameSizei) ListProtector.get(r107, 16);
    L43:
        return null;
    }

    public static boolean contains(String[] r100, String r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r102 = r100.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L12;
        if (r100[r103].equals(r101) == true) goto L9;
        r103 = r103 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public static int[] getClosestFpsRange(int[] r100, List<int[]> r101) {
        if (r101 != null) goto L5;
    L31:
        TELogUtils.w(TAG, "getClosestFpsRange, supported fpsRange is null, use [7, 30]");
        return new int[]{7, 30};
    L5:
        if (r101.size() <= 0) goto L31;
        ArrayList r102 = new ArrayList();
        ArrayList r103 = new ArrayList();
        Iterator<int[]> r104 = r101.iterator();
    L8:
        if (r104.hasNext() == false) goto L20;
        int[] r105 = r104.next();
        if (r100[0] > 1000) goto L12;
        if (r105[1] == 30) goto L17;
        r103.add(r105);
        goto L8
    L17:
        r102.add(r105);
        goto L8
    L12:
        if (r105[1] == 30000) goto L13;
        r103.add(r105);
        goto L8
    L13:
        r102.add(r105);
        goto L8
    L20:
        if (r102.isEmpty() == true) goto L27;
        Collections.sort(r102, new AnonymousClass1());
        Iterator r106 = r102.iterator();
    L23:
        if (r106.hasNext() == false) goto L27;
        int[] r107 = (int[]) r106.next();
        if (r107[0] > r100[0]) goto L23;
    L28:
        if (r107 != null) goto L30;
        r107 = getClosestFpsRangeFromRest(r100, r101);
    L30:
        TELogUtils.i(TAG, "getClosestFpsRange, calculate fps range = [" + r107[0] + ", " + r107[1] + "]");
        return r107;
    L27:
        r107 = null;
        goto L28
    }

    public static int[] getClosestFpsRangeFromRest(final int[] r100, List<int[]> r101) {
        return (int[]) Collections.min(r101, new AnonymousClass2(r100));
    }

    public static Size getClosestSupportedSize(List<Size> r100, final Size r101) {
        return (Size) Collections.min(r100, new AnonymousClass5(r101));
    }

    public static int[] getFixedFpsRange(int[] r100, List<int[]> r101) {
        if (r101 != null) goto L5;
    L33:
        TELogUtils.w(TAG, "getFixedFpsRange, supported fpsRange is null, use [30, 30]");
        return new int[]{30, 30};
    L5:
        if (r101.size() <= 0) goto L33;
        ArrayList r102 = new ArrayList();
        ArrayList r103 = new ArrayList();
        Iterator<int[]> r104 = r101.iterator();
    L8:
        if (r104.hasNext() == false) goto L14;
        int[] r105 = r104.next();
        if (r105[1] == r105[0]) goto L11;
        r103.add(r105);
        goto L8
    L11:
        r102.add(r105);
        goto L8
    L14:
        if (r102.isEmpty() == true) goto L29;
        Collections.sort(r102, new AnonymousClass3());
        Iterator r106 = r102.iterator();
    L17:
        if (r106.hasNext() == false) goto L29;
        int[] r107 = (int[]) r106.next();
        int r108 = r107[0];
        if (r108 < 15) goto L23;
        if (r108 > 30) goto L23;
    L27:
        if (r100[1] != r107[1]) goto L17;
    L30:
        if (r107 != null) goto L32;
        r107 = getClosestFpsRangeFromRest(r100, r101);
    L32:
        TELogUtils.i(TAG, "getFixedFpsRange, calculate fps range = [" + r107[0] + ", " + r107[1] + "]");
        return r107;
    L23:
        if (r108 < 15000) goto L17;
        if (r107[1] > 30000) goto L17;
    L29:
        r107 = null;
        goto L30
    }

    public static TEFrameSizei getPictureSizeByRatio(List<TEFrameSizei> r100, float r101) {
        ArrayList r102 = new ArrayList(r100);
        Iterator r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L9;
        TEFrameSizei r104 = (TEFrameSizei) r103.next();
        if (Math.abs((r104.height / r104.width) - r101) <= 0.05d) goto L4;
        r103.remove();
        goto L4
    L9:
        if (r102.isEmpty() == false) goto L12;
        return null;
    L12:
        Collections.sort(r102, new AnonymousClass7());
        return (TEFrameSizei) ListProtector.get(r102, 0);
    }

    private static TEFrameSizei getPreviewSizeByNearPixels(List<TEFrameSizei> r100, TEFrameSizei r101) {
        int r102 = r101.width * r101.height;
        Iterator<TEFrameSizei> r103 = r100.iterator();
        TEFrameSizei r104 = null;
        int r105 = Integer.MAX_VALUE;
    L4:
        if (r103.hasNext() == false) goto L12;
        TEFrameSizei r106 = r103.next();
        if (r104 == null) goto L7;
        if (Math.abs((r106.width * r106.height) - r102) >= r105) goto L4;
        r105 = Math.abs((r106.width * r106.height) - r102);
    L8:
        r104 = r106;
        goto L4
    L7:
        r105 = Math.abs((r106.width * r106.height) - r102);
        goto L8
    L12:
        return r104;
    }

    private static TEFrameSizei getPreviewSizeByNearSize(List<TEFrameSizei> r100, TEFrameSizei r101) {
        int r102 = r101.width;
        int r103 = r101.height;
        Collections.sort(r100, new AnonymousClass10());
        Iterator<TEFrameSizei> r104 = r100.iterator();
        TEFrameSizei r105 = null;
    L4:
        if (r104.hasNext() == false) goto L16;
        TEFrameSizei r106 = r104.next();
        if (r105 == null) goto L7;
        int r107 = r106.width;
        if (r107 < r102) goto L13;
        if (r106.height >= r103) goto L7;
    L13:
        if (r107 >= r102) goto L4;
        if (r106.height >= r103) goto L4;
    L7:
        r105 = r106;
    L16:
        return r105;
    }

    private static TEFrameSizei getPreviewSizeByRatio(List<TEFrameSizei> r100, TEFrameSizei r101) {
        Collections.sort(r100, new AnonymousClass9());
        int r102 = r101.width;
        int r103 = r101.height;
        Iterator<TEFrameSizei> r104 = r100.iterator();
        TEFrameSizei r105 = null;
    L4:
        if (r104.hasNext() == false) goto L29;
        TEFrameSizei r106 = r104.next();
        if (r105 == null) goto L7;
        int r107 = r106.width;
        if (r107 == r102) goto L11;
    L13:
        if (r107 <= r102) goto L17;
        if (r107 < r105.width) goto L7;
    L17:
        if (r107 >= r102) goto L4;
        return r105;
    L11:
        if (r106.height != r103) goto L13;
        return r106;
    L7:
        r105 = r106;
        goto L4
    L29:
        return r105;
    }

    public static List<TEFrameSizei> getSameFrameSize(List<TEFrameSizei> r100, List<TEFrameSizei> r101) {
        r100.retainAll(r101);
        return r100;
    }

    private static TEFrameSizei getScaleSize(TEFrameSizei r100, TEFrameSizei r101) {
        if (((r101.width * 1.0f) / r100.width) <= ((r101.height * 1.0f) / r100.height)) goto L6;
        int r102 = r100.width;
        int r103 = r101.width;
        return new TEFrameSizei((r102 * r103) / r102, (r100.height * r103) / r102);
    L6:
        int r104 = r100.width;
        int r105 = r101.height;
        int r106 = r100.height;
        return new TEFrameSizei((r104 * r105) / r106, (r105 * r106) / r106);
    }

    public static boolean imageToNV21(Image r110, byte[] r111) {
        if (r110 != null) goto L7;
        TELogUtils.e(TAG, "image is null");
        return false;
    L7:
        if (r110.getFormat() == 35) goto L10;
        TELogUtils.e(TAG, "image format wrong: " + r110.getFormat());
        return false;
    L10:
        if (r111 != null) goto L13;
        TELogUtils.e(TAG, "output buffer is null");
        return false;
    L13:
        int r100 = r110.getWidth();
        int r101 = r110.getHeight();
        if (r111.length >= (((r100 * r101) * 3) / 2)) goto L17;
        TELogUtils.e(TAG, "output buffer size invalid...");
        return false;
    L17:
        Image.Plane[] r112 = r110.getPlanes();
        int r102 = 0;
        int r103 = 0;
    L18:
        int r104 = 1;
        if (r102 >= r112.length) goto L39;
        Image.Plane r105 = r112[r102];
        ByteBuffer r106 = r105.getBuffer();
        if (r106 == null) goto L22;
        int r107 = r105.getRowStride();
        if (r107 > 0) goto L26;
        TELogUtils.e(TAG, "imageToNV21, rowStride: " + r100);
        r107 = r100;
    L26:
        int r108 = r105.getPixelStride();
        if (r108 > 0) goto L29;
        TELogUtils.e(TAG, "imageToNV21, pixelStride: " + r108);
    L30:
        int r109 = r101 / r104;
        if (r107 != r100) goto L33;
        r106.get(r111, r103, r106.remaining());
        r103 = r103 + (r107 * r109);
    L38:
        r102 = r102 + 2;
        goto L18
    L33:
        int r113 = 0;
    L35:
        if (r113 >= (r109 - 1)) goto L37;
        r106.get(r111, r103, r107);
        r103 = r103 + r100;
        r113 = r113 + 1;
        goto L35
    L37:
        r106.get(r111, r103, Math.min(r100, r106.remaining()));
        r103 = r103 + r100;
        goto L38
    L29:
        r104 = r108;
        goto L30
    L22:
        return false;
    L39:
        return true;
    }

    public static TEFrameSizei makeSizeSupported(List<TEFrameSizei> r100, TEFrameSizei r101) {
        if (r101 != null) goto L4;
        return r101;
    L4:
        Iterator<TEFrameSizei> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L10;
        if (r102.next().equals(r101) == false) goto L6;
        boolean r103 = true;
    L11:
        if (r103 == false) goto L13;
        return r101;
    L13:
        return calcPreviewSize(r100, r101, TECameraSettings.TEPreviewSizeStrategy.DEFAULT);
    L10:
        r103 = false;
        goto L11
    }

    public static void saveJPEGToPath(byte[] r100, String r101) {
        if (r100 != null) goto L6;
        TELogUtils.e(TAG, "Input null data, failed to save jpeg!");
        return;
    L6:
        PolarisFileOutputStreamWrapper r102 = null;
        PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(r101);     // Catch: Throwable -> L18 IOException -> L20
        r103.write(r100, 0, r100.length);     // Catch: Throwable -> L14 IOException -> L16
        r103.close();     // Catch: IOException -> L11
        return;
    L11:
        e = move-exception;
        TELogUtils.e(TAG, "close FileOutputStream failed!");
        e.printStackTrace();
        return;
    L16:
        e = e;
        r102 = r103;
    L21:
        TELogUtils.e(TAG, "save jpeg failed！");     // Catch: Throwable -> L18
        e.printStackTrace();     // Catch: Throwable -> L18
        if (r102 == null) goto L46;
        r102.close();     // Catch: IOException -> L25
        return;
    L25:
        e = move-exception;
        TELogUtils.e(TAG, "close FileOutputStream failed!");
        e.printStackTrace();
        return;
    L46:
        return;
    L14:
        th = th;
        r102 = r103;
    L28:
        if (r102 != null) goto L34;
    L33:
        throw th;
    L34:
        r102.close();     // Catch: IOException -> L31
    L31:
        e = move-exception;
        TELogUtils.e(TAG, "close FileOutputStream failed!");
        e.printStackTrace();
    L18:
        th = th;
    L20:
        e = e;
        goto L21
    }

    public static boolean contains(int[] r100, int r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r102 = r100.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L12;
        if (r100[r103] == r101) goto L9;
        r103 = r103 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public static TEFrameSizei getClosestSupportedSize(List<TEFrameSizei> r100, final TEFrameSizei r101) {
        return (TEFrameSizei) Collections.min(r100, new AnonymousClass4(r101));
    }

    public static TEFrameSizei calcPreviewSize(List<TEFrameSizei> r100, TEFrameSizei r110, TECameraSettings.TEPreviewSizeStrategy r111) {
        TELogUtils.i(TAG, "calcPreviewSize, supportedSizes = " + r100 + ", requestedSize = " + r110 + ", strategy = " + r111);
        if (r100 != null) goto L5;
    L35:
        return null;
    L5:
        if (r100.size() <= 0) goto L35;
        int r101 = r110.width;
        int r102 = r110.height;
        float r103 = r101 / r102;
        ArrayList r104 = new ArrayList();
        ArrayList r105 = new ArrayList();
        Iterator<TEFrameSizei> r106 = r100.iterator();
    L8:
        if (r106.hasNext() == false) goto L14;
        TEFrameSizei r107 = r106.next();
        if (Float.compare(r103, r107.width / r107.height) == 0) goto L11;
        r105.add(r107);
        goto L8
    L11:
        r104.add(r107);
        goto L8
    L14:
        if (r111 != TECameraSettings.TEPreviewSizeStrategy.MATCH_BY_PIXELS) goto L32;
        TEFrameSizei r108 = getPreviewSizeByRatio(r104, r110);
        TEFrameSizei r112 = getPreviewSizeByNearPixels(r105, r110);
        if (r108 != null) goto L18;
        return r112;
    L18:
        if (r112 != null) goto L21;
        return r108;
    L21:
        if (r108.countOfPixels() > r112.countOfPixels()) goto L23;
    L29:
        TELogUtils.i(TAG, "calcPreviewSize, return size0 = " + r108);
        return r108;
    L23:
        if ((r108.width - r101) <= 512) goto L25;
    L27:
        TELogUtils.i(TAG, "calcPreviewSize, return size1 = " + r112);
        return r112;
    L25:
        if ((r108.height - r102) > 512) goto L27;
    L32:
        if (r104.isEmpty() == true) goto L34;
        TEFrameSizei r109 = getPreviewSizeByRatio(r104, r110);
        TELogUtils.i(TAG, "calcPreviewSize, size = getPreviewSizeByRatio = " + r109);
        return r109;
    L34:
        TEFrameSizei r113 = getPreviewSizeByNearSize(r105, r110);
        TELogUtils.i(TAG, "calcPreviewSize, size = getPreviewSizeByNearSize = " + r113);
        return r113;
    }

    public static Object generateCamera2Key(String r100, String r101, Class<?> r102) {
        Constructor r103 = INVOKESTATIC_com_ss_android_ttvecamera_TECameraUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100).getDeclaredConstructor(new Class[]{String.class, Class.class});     // Catch: Exception -> L7
        if (r103 == null) goto L11;
        r103.setAccessible(true);     // Catch: Exception -> L7
        return r103.newInstance(new Object[]{r101, r102});
    L11:
        return null;
    L8:
        return null;
    }

    public static TEFrameSizei getClosestSupportedSize(List<TEFrameSizei> r100, TEFrameSizei r101, TEFrameSizei r102) {
        ArrayList r103 = new ArrayList(r100);
        if (r101 != null) goto L5;
    L17:
        Collections.sort(r103, new AnonymousClass6());
        Iterator r104 = r103.iterator();
        TEFrameSizei r105 = null;
    L19:
        if (r104.hasNext() == false) goto L50;
        TEFrameSizei r106 = (TEFrameSizei) r104.next();
        if (r105 == null) goto L22;
        if (r106.width == r102.width) goto L26;
    L28:
        int r107 = r106.height;
        int r108 = r102.height;
        if (r107 <= r108) goto L33;
        if (r107 < r105.height) goto L22;
    L33:
        if (r107 >= r108) goto L19;
        return r105;
    L26:
        if (r106.height != r102.height) goto L28;
        return r106;
    L22:
        r105 = r106;
        goto L19
    L50:
        return r105;
    L5:
        if (r101.isValid() == false) goto L17;
        if (r101.equals(r102) == true) goto L9;
    L11:
        Iterator r109 = r103.iterator();
    L13:
        if (r109.hasNext() == false) goto L17;
        TEFrameSizei r110 = (TEFrameSizei) r109.next();
        if ((r110.width * r101.height) == (r110.height * r101.width)) goto L13;
        r109.remove();
        goto L13
    L9:
        if (r103.contains(r102) == false) goto L11;
        return r102;
    }

    public static void rotateRectForOrientation(int r100, Rect r101, Rect r102) {
        Matrix r103 = new Matrix();
        r103.setRotate(-r100);
        RectF r104 = new RectF(r101);
        RectF r105 = new RectF(r102);
        r103.mapRect(r104);
        r103.mapRect(r105);
        r103.reset();
        r103.setTranslate(-r104.left, -r104.top);
        r103.mapRect(r104);
        r103.mapRect(r105);
        r101.set((int) r104.left, (int) r104.top, (int) r104.right, (int) r104.bottom);
        r102.set((int) r105.left, (int) r105.top, (int) r105.right, (int) r105.bottom);
    }

    public static TEFrameSizei getClosestSupportedSize(List<TEFrameSizei> r100, TEFrameSizei r101, int r102, float r103) {
        ArrayList r104 = new ArrayList(r100);
        if (r101 != null) goto L5;
    L12:
        Collections.sort(r104, new AnonymousClass8());
        Iterator r105 = r104.iterator();
    L14:
        if (r105.hasNext() == false) goto L18;
        TEFrameSizei r106 = (TEFrameSizei) r105.next();
        if (r106.width > r102) goto L14;
    L20:
        if ((mOptionFlags & 8) == 0) goto L29;
        if (r106 != null) goto L23;
    L26:
        TEFrameSizei r107 = calcHighCpuPictureSize(r104, r101);
        if (r107 != null) goto L36;
    L37:
        if (r106 != null) goto L39;
        TELogUtils.e(TAG, "getClosestSupportedSize failed, maxWidth: " + r102 + ", accuracy: " + r103 + ", previewSize: " + r101);
    L39:
        return r106;
    L36:
        r106 = r107;
        goto L37
    L23:
        if (r106.width <= r101.width) goto L26;
        if (r106.height > r101.height) goto L37;
    L29:
        if (r106 != null) goto L31;
    L34:
        r107 = calcHighCpuPictureSize(r104, r101);
        if (r107 == null) goto L37;
    L31:
        if (r106.width < r101.width) goto L34;
        if (r106.height >= r101.height) goto L37;
    L18:
        r106 = null;
        goto L20
    L5:
        if (r101.isValid() == false) goto L12;
        Iterator r108 = r104.iterator();
        float r109 = (r101.width * 1.0f) / r101.height;
    L8:
        if (r108.hasNext() == false) goto L12;
        TEFrameSizei r110 = (TEFrameSizei) r108.next();
        if (Math.abs(r109 - ((r110.width * 1.0f) / r110.height)) <= r103) goto L8;
        r108.remove();
        goto L8
    }

    public static int[] getFpsRange(int r100, int r101, int[] r102, List<int[]> r103) {
        TELogUtils.d(TAG, "requiredFpsRange : [" + r102[0] + "," + r102[1] + "]");
        if (r100 != 1) goto L6;
        TELogUtils.d(TAG, "fixed framerate for all cameras");
        return getFixedFpsRange(r102, r103);
    L6:
        if (r100 != 2) goto L11;
        if (r101 != 0) goto L9;
        TELogUtils.d(TAG, "fixed framerate for rear camera");
        return getFixedFpsRange(r102, r103);
    L9:
        TELogUtils.d(TAG, "dynamic framerate for front camera");
        return getClosestFpsRange(r102, r103);
    L11:
        if (r100 != 3) goto L14;
        TELogUtils.d(TAG, "dynamic framerate without select");
        return getClosestFpsRangeFromRest(r102, r103);
    L14:
        if (r100 != 4) goto L26;
        TELogUtils.d(TAG, "framerate by user");
        Iterator<int[]> r104 = r103.iterator();
    L17:
        if (r104.hasNext() == false) goto L23;
        int[] r105 = r104.next();
        if (r105[0] != r102[0]) goto L17;
        if (r105[1] != r102[1]) goto L17;
        int[] r106 = r102;
    L24:
        if (r106 == null) goto L39;
        return r106;
    L39:
        return getClosestFpsRange(r102, r103);
    L23:
        r106 = null;
        goto L24
    L26:
        TELogUtils.d(TAG, "dynamic framerate");
        return getClosestFpsRange(r102, r103);
    }

    public static void saveYUVToPath(Image.Plane[] r100, int r101, int r102, String r103) {
        if (r100 != null) goto L6;
        TELogUtils.e(TAG, "Input null plane, failed to save yuv!");
        return;
    L6:
        int r104 = 0;
        if (r100[0] == null) goto L39;
        ByteBuffer r105 = ByteBuffer.allocate(16);
        r105.putInt(r101).putInt(r102).putInt(r100[0].getPixelStride()).putInt(r100[0].getRowStride());
        PolarisFileOutputStreamWrapper r106 = null;
        PolarisFileOutputStreamWrapper r107 = new PolarisFileOutputStreamWrapper(r103);     // Catch: Throwable -> L23 IOException -> L25
        r107.write(r105.array());     // Catch: Throwable -> L19 IOException -> L21
        int r108 = r100.length;     // Catch: Throwable -> L19 IOException -> L21
    L11:
        if (r104 >= r108) goto L45;
        ByteBuffer r109 = r100[r104].getBuffer();     // Catch: Throwable -> L19 IOException -> L21
        byte[] r110 = new byte[r109.remaining()];     // Catch: Throwable -> L19 IOException -> L21
        r109.get(r110);     // Catch: Throwable -> L19 IOException -> L21
        r107.write(r110);     // Catch: Throwable -> L19 IOException -> L21
        r109.rewind();     // Catch: Throwable -> L19 IOException -> L21
        r104 = r104 + 1;
        goto L11
    L45:
        r107.close();     // Catch: IOException -> L16
        return;
    L16:
        e = move-exception;
        TELogUtils.e(TAG, "close FileOutputStream failed!");
        e.printStackTrace();
        return;
    L21:
        e = e;
        r106 = r107;
    L26:
        TELogUtils.e(TAG, "save yuv failed!");     // Catch: Throwable -> L23
        e.printStackTrace();     // Catch: Throwable -> L23
        if (r106 == null) goto L53;
        r106.close();     // Catch: IOException -> L30
        return;
    L30:
        e = move-exception;
        TELogUtils.e(TAG, "close FileOutputStream failed!");
        e.printStackTrace();
        return;
    L53:
        return;
    L19:
        th = th;
        r106 = r107;
    L33:
        if (r106 != null) goto L48;
    L38:
        throw th;
    L48:
        r106.close();     // Catch: IOException -> L36
    L36:
        e = move-exception;
        TELogUtils.e(TAG, "close FileOutputStream failed!");
        e.printStackTrace();
    L23:
        th = th;
    L25:
        e = e;
        goto L26
    L39:
        TELogUtils.e(TAG, "save yuv failed, plane is null");
    }

    public static void saveYUVToPath(ByteBuffer r100, int r101, int r102, String r103) {
        if (r100 != null) goto L6;
        TELogUtils.e(TAG, "Input null buffer, failed to save yuv!");
        return;
    L6:
        PolarisFileOutputStreamWrapper r104 = null;
        PolarisFileOutputStreamWrapper r105 = new PolarisFileOutputStreamWrapper(r103);     // Catch: Throwable -> L18 IOException -> L20
        byte[] r106 = new byte[r100.remaining()];     // Catch: Throwable -> L14 IOException -> L16
        r100.get(r106);     // Catch: Throwable -> L14 IOException -> L16
        r105.write(r106);     // Catch: Throwable -> L14 IOException -> L16
        r100.rewind();     // Catch: Throwable -> L14 IOException -> L16
        r105.close();     // Catch: IOException -> L11
        return;
    L11:
        e = move-exception;
        TELogUtils.e(TAG, "close FileOutputStream failed!");
        e.printStackTrace();
        return;
    L16:
        e = e;
        r104 = r105;
    L21:
        TELogUtils.e(TAG, "save yuv failed!");     // Catch: Throwable -> L18
        e.printStackTrace();     // Catch: Throwable -> L18
        if (r104 == null) goto L46;
        r104.close();     // Catch: IOException -> L25
        return;
    L25:
        e = move-exception;
        TELogUtils.e(TAG, "close FileOutputStream failed!");
        e.printStackTrace();
        return;
    L46:
        return;
    L14:
        th = th;
        r104 = r105;
    L28:
        if (r104 != null) goto L41;
    L33:
        throw th;
    L41:
        r104.close();     // Catch: IOException -> L31
    L31:
        e = move-exception;
        TELogUtils.e(TAG, "close FileOutputStream failed!");
        e.printStackTrace();
    L18:
        th = th;
    L20:
        e = e;
        goto L21
    }

    public static void saveYUVToPath(byte[] r100, int r101, int r102, String r103) {
        if (r100 != null) goto L6;
        TELogUtils.e(TAG, "Input null byte data, failed to save yuv!");
        return;
    L6:
        PolarisFileOutputStreamWrapper r104 = null;
        PolarisFileOutputStreamWrapper r105 = new PolarisFileOutputStreamWrapper(r103);     // Catch: Throwable -> L18 IOException -> L20
        r105.write(r100);     // Catch: Throwable -> L14 IOException -> L16
        r105.close();     // Catch: IOException -> L11
        return;
    L11:
        e = move-exception;
        TELogUtils.e(TAG, "close FileOutputStream failed!");
        e.printStackTrace();
        return;
    L16:
        e = e;
        r104 = r105;
    L21:
        TELogUtils.e(TAG, "save yuv failed!");     // Catch: Throwable -> L18
        e.printStackTrace();     // Catch: Throwable -> L18
        if (r104 == null) goto L46;
        r104.close();     // Catch: IOException -> L25
        return;
    L25:
        e = move-exception;
        TELogUtils.e(TAG, "close FileOutputStream failed!");
        e.printStackTrace();
        return;
    L46:
        return;
    L14:
        th = th;
        r104 = r105;
    L28:
        if (r104 != null) goto L40;
    L33:
        throw th;
    L40:
        r104.close();     // Catch: IOException -> L31
    L31:
        e = move-exception;
        TELogUtils.e(TAG, "close FileOutputStream failed!");
        e.printStackTrace();
    L20:
        e = e;
    L18:
        th = th;
        goto L28
    }

    public static Object createCameraInstance(String r110, int r111, Context r112, TECameraBase.CameraEvents r113, Handler r210, TECameraBase.PictureSizeCallBack r211) {
        long r100 = System.currentTimeMillis();
        Object r101 = null;
        Method r102 = INVOKESTATIC_com_ss_android_ttvecamera_TECameraUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r110).getMethod("create", new Class[]{Integer.TYPE, Context.class, TECameraBase.CameraEvents.class, Handler.class, TECameraBase.PictureSizeCallBack.class});     // Catch: Exception -> L5
        r102.setAccessible(true);     // Catch: Exception -> L5
        r101 = r102.invoke(null, new Object[]{Integer.valueOf(r111), r112, r113, r210, r211});     // Catch: Exception -> L5
    L7:
        TELogUtils.i(TAG, "createCameraInstance for " + r110 + ", cost time = " + (System.currentTimeMillis() - r100) + "ms, cameraInstance = " + r101);
        return r101;
    L5:
        e = move-exception;
        TELogUtils.w(TAG, "createCameraInstance for " + r110 + ", exception occurred.", e);
        goto L7
    }
}
