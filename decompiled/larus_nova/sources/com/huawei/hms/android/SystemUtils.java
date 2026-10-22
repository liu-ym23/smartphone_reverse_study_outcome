package com.huawei.hms.android;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.AndroidException;
import com.bytedance.crypto.platform.PlatformConst;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.huawei.hms.support.log.HMSLog;
import com.larksuite.framework.utils.DeviceUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tencent.qqmusic.third.api.contract.CommonCmd;
import el9.a;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class SystemUtils {
    public static final String PRODUCT_BRAND = "ro.product.brand";
    public static final String PRODUCT_HONOR = "HONOR";
    public static final String PRODUCT_HUAWEI = "HUAWEI";
    public static final String UNKNOWN = "unknown";

    public SystemUtils() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    private static String a() {
        return getSystemProperties("ro.product.locale", "");
    }

    private static String b() {
        return getSystemProperties("ro.product.locale.region", "");
    }

    public static String getAndoridVersion() {
        return getSystemProperties("ro.build.version.release", "unknown");
    }

    public static String getManufacturer() {
        return getSystemProperties(PlatformConst.PROP_MANUFACTURER, "unknown");
    }

    public static String getPhoneModel() {
        return getSystemProperties("ro.product.model", "unknown");
    }

    public static boolean isEMUI() {
        StringBuilder r100 = new StringBuilder("is Emui :");
        int r101 = HwBuildEx.VERSION.EMUI_SDK_INT;
        r100.append(r101);
        HMSLog.i("SystemUtils", r100.toString());
        if (r101 <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean isHuawei() {
        String r100 = getSystemProperties("ro.product.brand", "unknown");
        if (PRODUCT_HUAWEI.equalsIgnoreCase(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (PRODUCT_HONOR.equalsIgnoreCase(r100) == true) goto L8;
        return false;
    }

    public static boolean isTVDevice() {
        return getSystemProperties(DeviceUtils.PROPERTIES_KEY_CHARACTERISTICS, "default").equalsIgnoreCase(CommonCmd.AIDL_PLATFORM_TYPE_TV);
    }

    public static String getLocalCountry() {
        Locale r100 = Locale.getDefault();
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.getCountry();
    }

    public static boolean isChinaROM() {
        String r100 = b();
        if (TextUtils.isEmpty(r100) == false) goto L5;
        String r101 = a();
        if (TextUtils.isEmpty(r101) == false) goto L9;
        String r102 = getLocalCountry();
        if (TextUtils.isEmpty(r102) == false) goto L13;
        return false;
    L13:
        return "cn".equalsIgnoreCase(r102);
    L9:
        return r101.toLowerCase(Locale.US).contains("cn");
    L5:
        return "cn".equalsIgnoreCase(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_huawei_hms_android_SystemUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static long getMegabyte(double r100) {
        if (Build.VERSION.SDK_INT <= 25) goto L7;
        double r101 = 1000.0d;
    L6:
        return (long) ((r100 * r101) * r101);
    L7:
        r101 = 1024.0d;
        goto L6
    }

    public static String getNetType(Context r100) {
        if (r100 == null) goto L10;
        ConnectivityManager r101 = (ConnectivityManager) r100.getSystemService("connectivity");
        if (r101 == null) goto L10;
        NetworkInfo r102 = r101.getActiveNetworkInfo();
        if (r102 == null) goto L10;
        if (r102.isAvailable() == false) goto L10;
        return r102.getTypeName();
    L10:
        return "";
    }

    public static String getSystemProperties(String r100, String r101) {
        Class r102 = INVOKESTATIC_com_huawei_hms_android_SystemUtils_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Throwable -> L4
        return (String) r102.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(r102, new Object[]{r100, r101});
    L4:
        HMSLog.e("SystemUtils", "An exception occurred while reading: getSystemProperties:" + r100);
        return r101;
    }

    public static boolean isSystemApp(Context r100, String r101) {
        if (r100 != null) goto L18;
        HMSLog.w("SystemUtils", "isSystemApp context is null");
        return false;
    L18:
        PackageInfo r102 = r100.getPackageManager().getPackageInfo(r101, 16384);     // Catch: RuntimeException -> L8 AndroidException -> L10
    L13:
        if (r102 != null) goto L15;
        return false;
    L15:
        if ((r102.applicationInfo.flags & 1) <= 0) goto L21;
        return true;
    L21:
        return false;
    L10:
        e = move-exception;
        HMSLog.e("SystemUtils", "isSystemApp Exception: " + e);
    L12:
        r102 = null;
    L8:
        e = move-exception;
        HMSLog.e("SystemUtils", "isSystemApp RuntimeException:" + e);
        goto L12
    }
}
