package com.huawei.hms.hatool;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public abstract class o {

    public static class a extends Exception {
        public a(String r100) {
            super(r100);
        }
    }

    private static Object a(Class r100, String r101, Class[] r102, Object[] r103) {
        if (r100 == null) goto L28;
        if (r102 != null) goto L9;
        if (r103 == null) goto L29;
        throw new a("paramsType is null, but params is not null");
    L29:
    L21:
        v.f("hmsSdk", "invokeStaticFun(): cls.getMethod(),No Such Method !");
    L22:
        return null;
    L30:
        return r100.getMethod(r101, r102).invoke(null, r103);
    L18:
        String r104 = "invokeStaticFun(): method invoke Exception!";
    L19:
        v.f("hmsSdk", r104);     // Catch: NoSuchMethodException -> L21
    L17:
        r104 = "invokeStaticFun(): Illegal Argument!";
    L16:
        r104 = "invokeStaticFun(): Invocation Target Exception!";
        goto L19
    L9:
        if (r103 == null) goto L26;
        if (r102.length == r103.length) goto L29;
        throw new a("paramsType len:" + r102.length + " should equal params.len:" + r103.length);
    L26:
        throw new a("paramsType or params should be same");
    L28:
        throw new a("class is null in invokeStaticFun");
    }

    private static Object a(String r100, String r101, Class[] r102, Object[] r103) {
        return a(INVOKESTATIC_com_huawei_hms_hatool_o_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100), r101, r102, r103);
    L5:
        String r104 = "invokeStaticFun(): Static function call Exception ";
    L7:
        v.f("hmsSdk", r104);
        return null;
    L6:
        r104 = "invokeStaticFun() Not found class!";
        goto L7
    }

    public static String a() {
        return a(com.alipay.sdk.m.c.a.f25238a, "");
    }

    public static String a(Context r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return com_huawei_hms_hatool_o_android_provider_Settings$Secure_getString(r100.getContentResolver(), "android_id");
    }

    public static String a(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r101;
    L5:
        String r102 = a("android.os.SystemProperties", r100, r101);
        if (TextUtils.isEmpty(r102) == true) goto L8;
        return r102;
    L8:
        return a("com.huawei.android.os.SystemPropertiesEx", r100, r101);
    }

    private static String a(String r100, String r101, String r102) {
        Object r103 = a(r100, MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class, String.class}, new Object[]{r101, r102});
        if (r103 != null) goto L5;
        return r102;
    L5:
        return (String) r103;
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static String b() {
        String r100 = a("com.huawei.android.os.SystemPropertiesEx", "ro.huawei.build.display.id", "");
        v.a("hmsSdk", "SystemPropertiesEx: get rom_ver: " + r100);
        if (TextUtils.isEmpty(r100) == false) goto L6;
        String r101 = Build.DISPLAY;
        v.c("hmsSdk", "SystemProperties: get rom_ver: " + r101);
        return r101;
    L6:
        return r100;
    }

    public static String b(Context r100) {
        ApplicationInfo r101 = r100.getPackageManager().getApplicationInfo(r100.getPackageName(), 128);     // Catch: PackageManager.NameNotFoundException -> L14
        if (r101 == null) goto L18;
        Bundle r102 = r101.metaData;     // Catch: PackageManager.NameNotFoundException -> L14
        if (r102 == null) goto L19;
        Object r103 = r102.get("CHANNEL");     // Catch: PackageManager.NameNotFoundException -> L14
        if (r103 == null) goto L20;
        String r104 = r103.toString();     // Catch: PackageManager.NameNotFoundException -> L14
        if (r104.length() <= 256) goto L21;
        return "Unknown";
    L21:
        return r104;
    L20:
        return "Unknown";
    L19:
        return "Unknown";
    L18:
        return "Unknown";
    L14:
        v.f("hmsSdk", "getChannel(): The packageName is not correct!");
        return "Unknown";
    }

    public static String c(Context r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100.getPackageName();
    }

    public static String d(Context r100) {
        if (r100 != null) goto L11;
        return "";
    L11:
        PackageInfo r101 = r100.getPackageManager().getPackageInfo(c(r100), 16384);     // Catch: PackageManager.NameNotFoundException -> L9
        if (r101 == null) goto L13;
        return r101.versionName;
    L13:
        return "";
    L9:
        v.f("hmsSdk", "getVersion(): The package name is not correct!");
        return "";
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_huawei_hms_hatool_o_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    private static String com_huawei_hms_hatool_o_android_provider_Settings$Secure_getString(ContentResolver r110, String r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r110, r111};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, "java.lang.String", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, null, r112, false);
        return (String) r113.f474983b;
    L6:
        String r114 = Settings.Secure.getString(r110, r111);
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, r114, r112, true);
        return r114;
    }
}
