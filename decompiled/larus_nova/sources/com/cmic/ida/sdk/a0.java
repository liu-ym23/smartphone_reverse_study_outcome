package com.cmic.ida.sdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.huawei.hms.android.SystemUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public final class a0 {
    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static boolean a() {
        if (Build.MANUFACTURER.equalsIgnoreCase("ASUS") == false) goto L5;
    L8:
        return true;
    L5:
        if (Build.BRAND.equalsIgnoreCase("ASUS") == true) goto L8;
        return false;
    }

    public static boolean b() {
        if (Build.MANUFACTURER.equalsIgnoreCase("BLACKSHARK") == false) goto L5;
    L8:
        return true;
    L5:
        if (Build.BRAND.equalsIgnoreCase("BLACKSHARK") == true) goto L8;
        return false;
    }

    public static boolean e() {
        if (Build.MANUFACTURER.equalsIgnoreCase(SystemUtils.PRODUCT_HONOR) == false) goto L5;
    L8:
        return true;
    L5:
        if (Build.BRAND.equalsIgnoreCase(SystemUtils.PRODUCT_HONOR) == true) goto L8;
        return false;
    }

    public static boolean f() {
        if (Build.MANUFACTURER.equalsIgnoreCase(SystemUtils.PRODUCT_HUAWEI) == false) goto L5;
    L8:
        return true;
    L5:
        if (Build.BRAND.equalsIgnoreCase(SystemUtils.PRODUCT_HUAWEI) == true) goto L8;
        return false;
    }

    public static boolean g() {
        if (Build.MANUFACTURER.equalsIgnoreCase(RomUtils.ROM_LENOVO) == true) goto L10;
        String r100 = Build.BRAND;
        if (r100.equalsIgnoreCase(RomUtils.ROM_LENOVO) == true) goto L10;
        if (r100.equalsIgnoreCase("ZUK") == true) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean h() {
        if (Build.MANUFACTURER.equalsIgnoreCase("MEIZU") == false) goto L5;
    L10:
        return true;
    L5:
        if (Build.BRAND.equalsIgnoreCase("MEIZU") == true) goto L10;
        if (Build.DISPLAY.toUpperCase().contains("FLYME") == true) goto L10;
        return false;
    }

    public static boolean j() {
        if (Build.MANUFACTURER.equalsIgnoreCase("MOTOLORA") == false) goto L5;
    L8:
        return true;
    L5:
        if (Build.BRAND.equalsIgnoreCase("MOTOLORA") == true) goto L8;
        return false;
    }

    public static boolean k() {
        if (Build.MANUFACTURER.equalsIgnoreCase(RomUtils.ROM_NUBIA) == false) goto L5;
    L8:
        return true;
    L5:
        if (Build.BRAND.equalsIgnoreCase(RomUtils.ROM_NUBIA) == true) goto L8;
        return false;
    }

    public static boolean l() {
        if (Build.MANUFACTURER.equalsIgnoreCase(RomUtils.ROM_ONEPLUS) == false) goto L5;
    L8:
        return true;
    L5:
        if (Build.BRAND.equalsIgnoreCase(RomUtils.ROM_ONEPLUS) == true) goto L8;
        return false;
    }

    public static boolean m() {
        if (Build.MANUFACTURER.equalsIgnoreCase("OPPO") == true) goto L12;
        String r100 = Build.BRAND;
        if (r100.equalsIgnoreCase("OPPO") == true) goto L12;
        if (r100.equalsIgnoreCase("REALME") == true) goto L12;
        if (TextUtils.isEmpty(a("ro.build.version.opporom", "")) == false) goto L12;
        return false;
    L12:
        return true;
    }

    public static boolean n() {
        if (Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG") == false) goto L5;
    L8:
        return true;
    L5:
        if (Build.BRAND.equalsIgnoreCase("SAMSUNG") == true) goto L8;
        return false;
    }

    public static boolean o() {
        if (Build.MANUFACTURER.equalsIgnoreCase("VIVO") == false) goto L5;
    L10:
        return true;
    L5:
        if (Build.BRAND.equalsIgnoreCase("VIVO") == true) goto L10;
        if (TextUtils.isEmpty(a("ro.vivo.os.version", "")) == false) goto L10;
        return false;
    }

    public static boolean p() {
        if (Build.MANUFACTURER.equalsIgnoreCase("XIAOMI") == true) goto L10;
        String r100 = Build.BRAND;
        if (r100.equalsIgnoreCase("XIAOMI") == true) goto L10;
        if (r100.equalsIgnoreCase("REDMI") == true) goto L10;
        return false;
    L10:
        return true;
    }

    public static boolean q() {
        if (Build.MANUFACTURER.equalsIgnoreCase(RomUtils.ROM_ZTE) == false) goto L5;
    L8:
        return true;
    L5:
        if (Build.BRAND.equalsIgnoreCase(RomUtils.ROM_ZTE) == true) goto L8;
        return false;
    }

    public static boolean c() {
        return a("ro.odm.manufacturer", "").equalsIgnoreCase("PRIZE");
    }

    public static boolean d() {
        return !TextUtils.isEmpty(a(com.alipay.sdk.m.c.a.f25238a, ""));
    }

    public static boolean i() {
        return !TextUtils.isEmpty(a("ro.miui.ui.version.name", ""));
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_cmic_ida_sdk_a0_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static boolean a(Context r100) {
        r100.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0);     // Catch: Exception -> L6
        return true;
    L6:
        return false;
    }

    public static String a(String r100, String r101) {
        Class r102 = INVOKESTATIC_com_cmic_ida_sdk_a0_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("android.os.SystemProperties");     // Catch: Exception -> L4
        String r103 = (String) r102.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}).invoke(r102, new Object[]{r100, r101});     // Catch: Exception -> L4
    L6:
        if (r103 != null) goto L11;
        return "";
    L11:
        return r103;
    L4:
        e = move-exception;
        u.b("OAIDRom", "System property invoke error: " + e);
        r103 = null;
        goto L6
    }
}
