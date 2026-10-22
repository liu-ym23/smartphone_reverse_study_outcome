package com.ss.android.dypay.utils;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public final class j {
    static {
    }

    public static String c(String r100) {
        Class r101 = a("android.os.SystemProperties");     // Catch: Exception -> L9
        Object r102 = r101.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r101, new Object[]{r100});     // Catch: Exception -> L9
        if (r102 == null) goto L8;
        return (String) r102;
    L8:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L9
    L9:
        return null;
    }

    public static String d(String r100, String r101) {
        return r100 + '_' + r101;
    }

    public static boolean e() {
        String r100 = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(r100) == true) goto L13;
        Locale r101 = Locale.ROOT;
        if (r100 == null) goto L12;
        if (StringsKt.contains$default(r100.toLowerCase(r101), AppConstants.CHANNEL_360, false, 2, null) == false) goto L9;
    L10:
        return true;
    L9:
        if (StringsKt.contains$default(r100.toLowerCase(r101), "qiku", false, 2, null) == true) goto L10;
        return false;
    L12:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L13:
        return false;
    }

    public static boolean f() {
        String r100 = c(com.alipay.sdk.m.c.a.f25238a);
        if (TextUtils.isEmpty(r100) == true) goto L15;
        if (r100 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        Locale r101 = Locale.ROOT;
        if (r100 == null) goto L14;
        if (StringsKt.contains$default(r100.toLowerCase(r101), "emui", false, 2, null) == false) goto L11;
    L12:
        return true;
    L11:
        if (StringsKt.contains$default(r100.toLowerCase(r101), "magicui", false, 2, null) == true) goto L12;
        return false;
    L14:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L15:
        return false;
    }

    public static boolean g() {
        String r100 = c("ro.vivo.os.build.display.id");
        if (TextUtils.isEmpty(r100) == true) goto L15;
        if (r100 != null) goto L6;
        Intrinsics.throwNpe();
    L6:
        Locale r101 = Locale.ROOT;
        if (r100 == null) goto L14;
        if (StringsKt.contains$default(r100.toLowerCase(r101), "originos", false, 2, null) == false) goto L11;
    L12:
        return true;
    L11:
        if (StringsKt.contains$default(r100.toLowerCase(r101), "funtouch", false, 2, null) == true) goto L12;
        return false;
    L14:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L15:
        return false;
    }

    public static String b() {
        boolean r100 = false;
        if (a("miui.os.Build").getName().length() <= 0) goto L7;
        boolean r101 = true;
    L60:
        if (r101 == true) goto L11;
        String r102 = Build.MANUFACTURER;     // Catch: Exception -> L54
        if (TextUtils.isEmpty(r102) == true) goto L22;
        Locale r103 = Locale.ROOT;     // Catch: Exception -> L54
        if (r102 == null) goto L21;
        if (StringsKt.contains$default(r102.toLowerCase(r103), AppConstants.CHANNEL_OPPO, false, 2, null) == false) goto L22;
        boolean r104 = true;
    L23:
        if (r104 == false) goto L27;
        return d("coloros".toUpperCase(Locale.ROOT), c("ro.build.version.opporom") + '_' + Build.DISPLAY);
    L27:
        if (g() == false) goto L31;
        return d(String.valueOf(c("ro.vivo.os.build.display.id")), String.valueOf(c("ro.vivo.product.version")));
    L31:
        if (f() == true) goto L33;
        String r105 = Build.DISPLAY;     // Catch: Exception -> L54
        if (TextUtils.isEmpty(r105) == true) goto L43;
        Locale r106 = Locale.ROOT;     // Catch: Exception -> L54
        if (r105 == null) goto L42;
        if (StringsKt.contains$default(r105.toLowerCase(r106), "amigo", false, 2, null) == false) goto L43;
        r100 = true;
        goto L43
    L42:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L54
    L43:
        if (r100 == false) goto L47;
        return d(String.valueOf(r105), String.valueOf(c("ro.gn.sv.version")));
    L47:
        if (e() == false) goto L51;
        return d(AppConstants.CHANNEL_360.toUpperCase(Locale.ROOT), c("ro.build.uiversion") + '_' + r105);
    L51:
        if ((!TextUtils.isEmpty(c("ro.letv.release.version"))) == false) goto L55;
        return d("eui".toUpperCase(Locale.ROOT), c("ro.letv.release.version") + '_' + r105);
    L33:
        return d(String.valueOf(c(com.alipay.sdk.m.c.a.f25238a)), Build.DISPLAY);
    L21:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");     // Catch: Exception -> L54
    L22:
        r104 = false;
        goto L23
    L11:
        return d("miui".toUpperCase(Locale.ROOT), c("ro.miui.ui.version.name") + '_' + Build.VERSION.INCREMENTAL);
    L55:
        String r107 = Build.DISPLAY;
        if (r107 != null) goto L63;
        return "";
    L63:
        return r107;
    L7:
        r101 = false;
        goto L60
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
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
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
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
}
