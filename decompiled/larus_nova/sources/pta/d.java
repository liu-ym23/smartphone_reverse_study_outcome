package pta;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.huawei.hms.android.SystemUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import i84.u;
import ita.j;
import ita.k;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f530685a = null;

    public static class a extends e<Boolean> {
        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class c() throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r102 = Class.forName("com.huawei.system.BuildEx");     // Catch: Throwable -> L8
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a("com.huawei.system.BuildEx");     // Catch: Throwable -> L8
        L7:
            return r102;
        L8:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("com.huawei.system.BuildEx");
        L12:
            throw th;
        L34:
            Class<?> r103 = Class.forName("com.huawei.system.BuildEx");     // Catch: Throwable -> L17
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a("com.huawei.system.BuildEx");     // Catch: Throwable -> L17
        L16:
            return r103;
        L17:
            th = move-exception;
            if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b("com.huawei.system.BuildEx");
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName("com.huawei.system.BuildEx");
        }

        public a() {
        }

        @Override // pta.e
        public final Boolean a(Object[] r100) {
            Class r101 = c();     // Catch: Throwable -> L4
            return Boolean.valueOf(RomUtils.OS_HARMONY.equals(r101.getMethod("getOsBrand", new Class[0]).invoke(r101, new Object[0])));
        L5:
            return Boolean.FALSE;
        }
    }

    static {
        f530685a = new a();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.os.SystemProperties");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.os.SystemProperties");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.os.SystemProperties");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.os.SystemProperties");
    }

    public static boolean f() {
        Class r100 = a();     // Catch: Exception -> L7
        String r101 = (String) r100.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r100, new Object[]{com.alipay.sdk.m.c.a.f25238a});     // Catch: Exception -> L7
        if (TextUtils.isEmpty(r101) == true) goto L9;
        j.b("Honor# oldHonor device, version is" + r101, null);     // Catch: Exception -> L7
        return true;
    L9:
        return false;
    L7:
        e = move-exception;
        j.c("Honor# " + e.getMessage(), e);
        goto L9
    }

    public static boolean g() {
        String r100 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        return r100.toLowerCase().contains(AppConstants.CHANNEL_OPPO);
    }

    public static boolean h() {
        return f530685a.b(new Object[0]).booleanValue();
    }

    public static boolean i() {
        String r100 = Build.BRAND;
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L6:
        String r101 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r101) == true) goto L11;
        if (r101.toLowerCase().startsWith(RomUtils.BRAND_HONOR) == false) goto L11;
    L12:
        return true;
    L11:
        if (SystemUtils.PRODUCT_HONOR.equalsIgnoreCase(r101) == true) goto L12;
        return false;
    L5:
        if (r100.toLowerCase().startsWith(RomUtils.BRAND_HONOR) == true) goto L12;
        goto L6
    }

    public static boolean j() {
        String r100 = Build.BRAND;
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L6:
        String r101 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(r101) == false) goto L9;
    L11:
        return false;
    L9:
        if (r101.toLowerCase().startsWith(RomUtils.BRAND_HUAWEI) == false) goto L11;
    L10:
        return true;
    L5:
        if (r100.toLowerCase().startsWith(RomUtils.BRAND_HUAWEI) == true) goto L10;
        goto L6
    }

    public static String c() {
        String r100 = k.d();
        if (r100 != null) goto L5;
        return "";
    L5:
        if (r100.toLowerCase().contains("emotionui") == true) goto L9;
        if (r100.toLowerCase().contains("magicui") == true) goto L9;
        return "";
    L9:
        return r100 + "_" + Build.DISPLAY;
    }

    public static String d() {
    L60:
        th = move-exception;
        th.printStackTrace();
    L63:
        return Build.DISPLAY;
    L4:
        String r100 = "";
        if (k.j() == false) goto L11;
        if (k.j() == true) goto L9;
        return "";
    L9:
        return "miui_" + e("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL;
    L11:
        if (k.f() == false) goto L19;
        String r101 = Build.DISPLAY;     // Catch: Throwable -> L60
        if (r101 != null) goto L15;
        return "";
    L15:
        if (r101.toLowerCase().contains("flyme") == true) goto L17;
        return "";
    L17:
        return r101;
    L19:
        if (g() == true) goto L21;
        String r102 = c();     // Catch: Throwable -> L60
        if (TextUtils.isEmpty(r102) == true) goto L27;
        return r102;
    L27:
        boolean r103 = false;
        boolean r104 = !TextUtils.isEmpty((String) u.a("ro.vivo.os.build.display.id"));
    L31:
        if (r104 == true) goto L33;
        String r105 = Build.DISPLAY;     // Catch: Throwable -> L60
        if (StringUtils.isEmpty(r105) == false) goto L37;
    L39:
        boolean r106 = false;
    L40:
        if (r106 == true) goto L42;
        String r107 = Build.MANUFACTURER + Build.BRAND;     // Catch: Throwable -> L60
        if (TextUtils.isEmpty(r107) == true) goto L51;
        String r108 = r107.toLowerCase();     // Catch: Throwable -> L60
        if (r108.contains(AppConstants.CHANNEL_360) == false) goto L49;
    L50:
        r103 = true;
        goto L51
    L49:
        if (r108.contains("qiku") == true) goto L50;
    L51:
        if (r103 == false) goto L55;
        return e("ro.build.uiversion") + "_" + r105;
    L55:
        if ((true ^ StringUtils.isEmpty(e("ro.letv.release.version"))) == false) goto L58;
        r100 = "eui_" + e("ro.letv.release.version") + "_" + r105;     // Catch: Throwable -> L60
    L58:
        if (TextUtils.isEmpty(r100) == true) goto L63;
        return r100;
    L42:
        return r105 + "_" + e("ro.gn.sv.version");
    L37:
        if (r105.toLowerCase().contains("amigo") == false) goto L39;
        r106 = true;
        goto L40
    L33:
        return u.a("ro.vivo.os.build.display.id") + "_" + u.a("ro.vivo.product.version");
    L30:
        r104 = false;
        goto L31
    L21:
        if (g() == true) goto L23;
        return "";
    L23:
        return "coloros_" + e("ro.build.version.opporom") + "_" + Build.DISPLAY;
    }

    public static String e(String r100) {
        String r101 = "";
        Process r102 = b(Runtime.getRuntime(), "getprop ".concat(r100));     // Catch: Throwable -> L12
        BufferedReader r103 = new BufferedReader(new InputStreamReader(r102.getInputStream()), 1024);     // Catch: Throwable -> L12
        r101 = r103.readLine();     // Catch: Throwable -> L10
        r102.destroy();     // Catch: Throwable -> L10
        r103.close();     // Catch: IOException -> L7
    L9:
        return r101;
    L7:
        e = move-exception;
        j.c("Exception while closing InputStream", e);
    L10:
        th = th;
    L38:
        j.c("Unable to read sysprop ".concat(r100), th);     // Catch: Throwable -> L21
        if (r103 != null) goto L28;
    L20:
        return r101;
    L28:
        r103.close();     // Catch: IOException -> L18
    L18:
        e = move-exception;
        j.c("Exception while closing InputStream", e);
    L21:
        th = move-exception;
        if (r103 != null) goto L30;
    L27:
        throw th;
    L30:
        r103.close();     // Catch: IOException -> L25
    L25:
        e = move-exception;
        j.c("Exception while closing InputStream", e);
    L12:
        th = th;
        r103 = null;
        goto L38
    }

    public static Process b(Runtime r110, String r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(102900, "java/lang/Runtime", "exec", r110, r101, "java.lang.Process", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, null, r112, false);
        return (Process) r113.f474983b;
    L6:
        Process r114 = r110.exec(r111);
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, r114, r112, true);
        return r114;
    }
}
