package com.bytedance.push.utils;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.miui.easygo.constant.EasyGoConstant;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f267079a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f267080b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f267081c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f267082d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f267083e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f267084f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final JSONObject f267085g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Boolean f267086h;

    public j() {
    }

    public static boolean h() {
        Boolean r100 = f267086h;     // Catch: Throwable -> L9
        if (r100 != null) goto L6;
        Class r101 = a();     // Catch: Throwable -> L9
        Boolean r102 = Boolean.valueOf(RomUtils.OS_HARMONY.equals(r101.getMethod("getOsBrand", new Class[0]).invoke(r101, new Object[0])));     // Catch: Throwable -> L9
        f267086h = r102;     // Catch: Throwable -> L9
        return r102.booleanValue();
    L6:
        return r100.booleanValue();
    L9:
        f.h("", "isn't harmony");
        return false;
    }

    static {
        String r100 = String.valueOf(Build.VERSION.SDK);
        f267079a = r100;
        f267080b = new l();
        f267081c = r100;
        String r101 = d();     // Catch: Throwable -> L5
    L8:
        if (StringUtils.isEmpty(r101) == false) goto L10;
        r101 = f267079a;
    L10:
        f267081c = r101;
        f267085g = new JSONObject();
        f267086h = null;
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        r101 = null;
        goto L8
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
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

    public static String b() {
        JSONObject r100 = f267085g;
        monitor-enter(r100);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (f267084f == true) goto L8;
        f();     // Catch: Throwable -> L15
    L8:
        if (r100.keys().hasNext() == false) goto L12;
        String r101 = r100.toString();     // Catch: Throwable -> L15
        monitor-exit(r100);     // Catch: Throwable -> L15
        return r101;
    L12:
        monitor-exit(r100);     // Catch: Throwable -> L15
        return "";
    }

    public static String c() {
        if (StringUtils.isEmpty(f267083e) == false) goto L6;
        f267083e = e(com.alipay.sdk.m.c.a.f25238a);
    L6:
        if (StringUtils.isEmpty(f267083e) == false) goto L9;
        f267083e = e("ro.build.version.magic");
    L9:
        if (StringUtils.isEmpty(f267083e) == true) goto L15;
        String r100 = (f267083e + "_" + Build.DISPLAY).toLowerCase();
        if (StringUtils.isEmpty(r100) == true) goto L15;
        return r100.toLowerCase();
    L15:
        return f267079a;
    }

    public static void f() {
        if (f267084f == false) goto L13;
        return;
    L13:
    L9:
        th = move-exception;
        th.printStackTrace();
    L11:
        f267084f = true;
        return;
    L6:
        if (h() == false) goto L11;
        String r100 = e("hw_sc.build.os.apiversion");     // Catch: Throwable -> L9
        String r101 = e("hw_sc.build.os.releasetype");     // Catch: Throwable -> L9
        String r102 = e("hw_sc.build.platform.version");     // Catch: Throwable -> L9
        JSONObject r103 = f267085g;     // Catch: Throwable -> L9
        r103.put("api_version", r100);     // Catch: Throwable -> L9
        r103.put("release_type", r101);     // Catch: Throwable -> L9
        r103.put("version", r102);     // Catch: Throwable -> L9
        goto L11
    }

    public static String d() {
        boolean r100 = false;
        boolean r101 = true;
        String r102 = e(com.alipay.sdk.m.c.a.f25238a);     // Catch: Exception -> L10
        f267082d = r102;     // Catch: Exception -> L10
        boolean r103 = StringUtils.isEmpty(r102);     // Catch: Exception -> L10
        if (r103 == false) goto L6;
    L9:
        boolean r104 = !r103;
    L14:
        if (r104 == true) goto L16;
        boolean r105 = !TextUtils.equals(c(), f267079a);
    L27:
        if (r105 == true) goto L29;
        String r106 = e("ro.vivo.os.build.display.id");
        if (StringUtils.isEmpty(r106) == false) goto L33;
    L35:
        boolean r107 = false;
    L37:
        if (r107 == true) goto L39;
        String r108 = e("ro.vivo.os.build.display.id");
        if (StringUtils.isEmpty(r108) == false) goto L43;
    L45:
        r101 = false;
    L46:
        if (r101 == true) goto L48;
        String r109 = Build.MANUFACTURER;
        if (StringUtils.isEmpty(r109) == true) goto L52;
        boolean r110 = r109.toLowerCase().contains(AppConstants.CHANNEL_OPPO);
    L53:
        if (r110 == false) goto L65;
        if (StringUtils.isEmpty(r109) == true) goto L57;
        r100 = r109.toLowerCase().contains(AppConstants.CHANNEL_OPPO);
    L57:
        if (r100 == false) goto L63;
        String r111 = e("ro.build.version.opporom");
        if (TextUtils.isEmpty(r111) == false) goto L74;
        r111 = e("ro.build.version.oplusrom");
    L74:
        return ("coloros_" + r111 + "_" + Build.DISPLAY).toLowerCase();
    L63:
        return f267079a;
    L65:
        if (ita.k.j() == false) goto L69;
        return ("miui_" + e("ro.miui.ui.version.name") + "_" + Build.VERSION.INCREMENTAL).toLowerCase();
    L69:
        return f267079a;
    L52:
        r110 = false;
        goto L53
    L48:
        return (e("ro.vivo.os.build.display.id") + "_" + e("ro.vivo.product.version")).toLowerCase();
    L43:
        if (r108.toLowerCase().contains(PlayerResolution.SDKKEY.ORIGIN) == false) goto L45;
    L39:
        return (e("ro.vivo.os.build.display.id") + "_" + e("ro.vivo.product.version")).toLowerCase();
    L33:
        if (r106.toLowerCase().contains("funtouch") == false) goto L35;
        r107 = true;
        goto L37
    L29:
        return c();
    L25:
        e = move-exception;
        f.d(e.getMessage());
        r105 = false;
        goto L27
    L16:
        if (StringUtils.isEmpty(f267082d) == false) goto L18;
        f267082d = e(com.alipay.sdk.m.c.a.f25238a);
    L18:
        String r112 = (f267082d + "_" + Build.DISPLAY).toLowerCase();
        if (StringUtils.isEmpty(r112) == true) goto L22;
        return r112.toLowerCase();
    L22:
        return f267079a;
    L6:
        if (f267082d.toLowerCase().startsWith("magic") == false) goto L8;
        f267083e = f267082d.toLowerCase();     // Catch: Exception -> L10
    L12:
        r104 = false;
        goto L14
    L8:
        f267082d = f267082d.toLowerCase();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        f.d(e.getMessage());
        goto L12
    }

    public static boolean g() {
        b();
        String r100 = f267085g.optString("version", "");     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (CastIntegerProtector.parseInt(r100.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN)[0]) < 4) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    }

    public static boolean i() {
        if (ita.k.j() == true) goto L12;
        return false;
    L12:
        if (CastIntegerProtector.parseInt(e("ro.miui.ui.version.name").substring(1)) < 12) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    }

    public static String e(String r100) {
        return f267080b.b(r100);
    }
}
