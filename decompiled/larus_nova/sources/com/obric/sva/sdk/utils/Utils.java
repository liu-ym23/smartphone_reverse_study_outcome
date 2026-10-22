package com.obric.sva.sdk.utils;

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.sva.sdk.controller.ManufactureFeatures;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
public class Utils {
    public static boolean SUPPORT_VIP_PROCESS;
    private static final String TAG = null;
    public static String mLock;

    public Utils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static void forceStartVoiceInteractionService(Context r100) {
    }

    static {
        TAG = "Utils";
        SUPPORT_VIP_PROCESS = ManufactureFeatures.isFeatureVipPidEnable();
        mLock = new String("vip-process-lock");
    }

    public static boolean isAtLeastN() {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        return true;
    L5:
        return false;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_obric_sva_sdk_utils_Utils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static DisplayMetrics INVOKEVIRTUAL_com_obric_sva_sdk_utils_Utils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static String byteToUtf8(byte[] r100) {
        return new String(r100, StandardCharsets.UTF_8);
    }

    public static void enableProcessVIP(int r100) {
        LogUtils.d(TAG, "enableProcessVIP to " + r100, new Object[0]);
        com.obric.assistant.common.utils.g.f387877a.getClass();
        com.obric.assistant.common.utils.g.b(r100, 0, 70, false);
    }

    public static boolean isNetworkAvailable(Context r100) {
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");     // Catch: Exception -> L19
        NetworkInfo r102 = r101.getActiveNetworkInfo();     // Catch: Exception -> L19
        if (Build.VERSION.SDK_INT < 23) goto L12;
        Network r103 = r101.getActiveNetwork();     // Catch: Exception -> L19
        if (r103 != null) goto L8;
        return false;
    L8:
        NetworkCapabilities r104 = r101.getNetworkCapabilities(r103);     // Catch: Exception -> L19
        if (r104 != null) goto L11;
        return false;
    L11:
        boolean r105 = r104.hasCapability(16);     // Catch: Exception -> L19
    L13:
        if (r102 == null) goto L22;
        if (r102.isConnected() == false) goto L23;
        if (r105 == false) goto L24;
        return true;
    L24:
        return false;
    L23:
        return false;
    L22:
        return false;
    L12:
        r105 = true;
    L25:
        return false;
    }

    public static File rootFilePath(Context r100) {
        File r101 = r100.getExternalFilesDir(null);
        if (r101 != null) goto L6;
        String r102 = r100.getPackageName();
        return new PolarisFileWrapper(Environment.getExternalStorageDirectory(), "Android/data/" + r102 + "/files");
    L6:
        return r101;
    }

    public static byte[] toByte(InputStream r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        byte[] r102 = new byte[16384];
    L3:
        int r103 = r100.read(r102, 0, 16384);
        if (r103 == (-1)) goto L7;
        r101.write(r102, 0, r103);
        goto L3
    L7:
        return r101.toByteArray();
    }

    public static float dp2Px(Context r100, float r101) {
        return TypedValue.applyDimension(1, r101, INVOKEVIRTUAL_com_obric_sva_sdk_utils_Utils_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()));
    }

    public static void setVipThread(long r100, boolean r101) {
        LogUtils.d(TAG, "LookAheadBufferTask-setVipThread: tid :" + r100 + " enable:" + r101, new Object[0]);
        Class r102 = INVOKESTATIC_com_obric_sva_sdk_utils_Utils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.Process");     // Catch: IllegalAccessException -> L9 InvocationTargetException -> L12 NoSuchMethodException -> L15 ClassNotFoundException -> L18
        Class<?> r103 = Integer.TYPE;     // Catch: IllegalAccessException -> L9 InvocationTargetException -> L12 NoSuchMethodException -> L15 ClassNotFoundException -> L18
        Method r104 = r102.getMethod("setUIFirstSched", new Class[]{r103, r103});     // Catch: IllegalAccessException -> L9 InvocationTargetException -> L12 NoSuchMethodException -> L15 ClassNotFoundException -> L18
        Object[] r105 = new Object[2];     // Catch: IllegalAccessException -> L9 InvocationTargetException -> L12 NoSuchMethodException -> L15 ClassNotFoundException -> L18
        r105[0] = Integer.valueOf((int) r100);     // Catch: IllegalAccessException -> L9 InvocationTargetException -> L12 NoSuchMethodException -> L15 ClassNotFoundException -> L18
        if (r101 == false) goto L6;
        int r106 = 1;
    L7:
        r105[1] = Integer.valueOf(r106);     // Catch: IllegalAccessException -> L9 InvocationTargetException -> L12 NoSuchMethodException -> L15 ClassNotFoundException -> L18
        r104.invoke(null, r105);     // Catch: IllegalAccessException -> L9 InvocationTargetException -> L12 NoSuchMethodException -> L15 ClassNotFoundException -> L18
        return;
    L6:
        r106 = -1;
    L18:
        e = move-exception;
        throw new RuntimeException(e);
    L9:
        e = move-exception;
        throw new RuntimeException(e);
    L15:
        e = move-exception;
        throw new RuntimeException(e);
    L12:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static <T> T acquire(Map<String, ?> r100, String r101, Class<T> r102) {
        T r103 = (T) r100.get(r101);
        if (r102.isInstance(r103) == false) goto L6;
        return r103;
    L6:
        throw new RuntimeException("given bad class type , check it key ?" + r101);
    }
}
