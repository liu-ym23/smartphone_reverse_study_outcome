package com.ss.android.lark.base.embedded;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sysoptimizer.SmEditTextLeakOpt;
import com.huawei.hms.android.SystemUtils;
import com.larksuite.framework.utils.DeviceUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.utils.i0;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f409746a;

    public static boolean e() {
        Class r100 = a("com.oplus.content.OplusFeatureConfigManager");     // Catch: IllegalAccessException -> L7 InvocationTargetException -> L9 Throwable -> L11 ClassNotFoundException -> L13
        Object r101 = r100.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: IllegalAccessException -> L7 InvocationTargetException -> L9 Throwable -> L11 ClassNotFoundException -> L13
        Object r102 = r100.getDeclaredMethod("hasFeature", new Class[]{String.class}).invoke(r101, new Object[]{"oplus.hardware.type.fold"});     // Catch: IllegalAccessException -> L7 InvocationTargetException -> L9 Throwable -> L11 ClassNotFoundException -> L13
        if ((r102 instanceof Boolean) == false) goto L18;
        return ((Boolean) r102).booleanValue();
    L18:
        return false;
    L11:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static boolean f() {
        String r100 = Build.BRAND;
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (r100.toLowerCase().contains(SmEditTextLeakOpt.SAMSUNG) == false) goto L18;
        String r101 = Build.MODEL;
        if (r101.contains("SM-F9") == false) goto L9;
        return true;
    L9:
        if (r101.contains("SM-W202") == false) goto L11;
        return true;
    L11:
        if (r101.contains("SM-W90") == false) goto L19;
        return true;
    L19:
        return false;
    L18:
        return false;
    }

    public static boolean g() {
        if (i() == false) goto L5;
        return true;
    L5:
        if (f() == false) goto L7;
        return true;
    L7:
        if (e() == false) goto L27;
        return true;
    L27:
        Class r100 = a("android.util.FtDeviceInfo");     // Catch: Exception -> L11
        boolean r101 = "foldable".equals(r100.getMethod("getDeviceType", new Class[0]).invoke(r100, new Object[0]));     // Catch: Exception -> L11
    L13:
        if (r101 == false) goto L15;
        return true;
    L15:
        if (f409746a != null) goto L18;
    L22:
        boolean r102 = false;
    L23:
        if (r102 == true) goto L33;
        return false;
    L33:
        return true;
    L18:
        if (Build.MANUFACTURER.equalsIgnoreCase(SystemUtils.PRODUCT_HONOR) == false) goto L22;
        if (f409746a.getPackageManager().hasSystemFeature("com.hihonor.hardware.sensor.posture") == false) goto L22;
        r102 = true;
    L11:
        e = move-exception;
        e.printStackTrace();
        r101 = false;
        goto L13
    }

    public static boolean h() {
        Class r100 = a("android.os.SystemProperties");     // Catch: Exception -> L5
        boolean r101 = String.valueOf(r100.getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r100, new Object[]{DeviceUtils.PROPERTIES_KEY_CHARACTERISTICS})).contains("tablet");     // Catch: Exception -> L5
    L7:
        if (r101 == true) goto L36;
        Class r102 = a("android.util.FtDeviceInfo");     // Catch: Exception -> L10
        boolean r103 = "tablet".equals(r102.getMethod("getDeviceType", new Class[0]).invoke(r102, new Object[0]));     // Catch: Exception -> L10
    L12:
        if (r103 == true) goto L37;
        Class r104 = a("com.oplus.content.OplusFeatureConfigManager");     // Catch: IllegalAccessException -> L17 InvocationTargetException -> L19 Throwable -> L21 ClassNotFoundException -> L23
        Object r105 = r104.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: IllegalAccessException -> L17 InvocationTargetException -> L19 Throwable -> L21 ClassNotFoundException -> L23
        Object r106 = r104.getDeclaredMethod("hasFeature", new Class[]{String.class}).invoke(r105, new Object[]{"oplus.hardware.type.tablet"});     // Catch: IllegalAccessException -> L17 InvocationTargetException -> L19 Throwable -> L21 ClassNotFoundException -> L23
        if ((r106 instanceof Boolean) == false) goto L25;
        boolean r107 = ((Boolean) r106).booleanValue();     // Catch: IllegalAccessException -> L17 InvocationTargetException -> L19 Throwable -> L21 ClassNotFoundException -> L23
    L26:
        if (r107 == true) goto L38;
        return false;
    L38:
        return true;
    L25:
        r107 = false;
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L25
    L37:
        return true;
    L10:
        e = move-exception;
        e.printStackTrace();
        r103 = false;
        goto L12
    L36:
        return true;
    L5:
        e = move-exception;
        e.printStackTrace();
        r101 = false;
        goto L7
    }

    public static boolean i() {
        int r100 = ((Integer) h.a().getMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(null, new Object[]{"persist.sys.muiltdisplay_type", 0})).intValue();     // Catch: Exception -> L5
    L6:
        if (r100 == 2) goto L12;
        return false;
    L12:
        return true;
    L5:
        r100 = 0;
        goto L6
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

    public static boolean b(Activity r100) {
        boolean r101 = i0.a(r100);
        hac.b r102 = hac.b.f484427a;
        r102.a("EmbeddedActivityUtils", "isMagicWindow: " + r101);
        boolean r103 = LKSplitController.b().e();
        r102.a("EmbeddedActivityUtils", "isSplitSupported: " + r103);
        boolean r104 = c(r100);
        if (r101 == false) goto L6;
        r102.a("EmbeddedActivityUtils", "return isAE: true, isMagicWindow is true");
        return true;
    L6:
        if (r103 == false) goto L9;
        r102.a("EmbeddedActivityUtils", "return isAE: " + r104);
        return r104;
    L9:
        r102.a("EmbeddedActivityUtils", "return isAE: false, isSplitSupported is false");
        return false;
    }

    public static boolean c(Activity r100) {
        boolean r101 = LKSplitController.b().d(r100);     // Catch: NoSuchMethodError -> L5
        hac.b.f484427a.a("EmbeddedActivityUtils", "isActivityEmbeddedCompat: " + r101);     // Catch: NoSuchMethodError -> L5
        return r101;
    L5:
        hac.b.f484427a.a("EmbeddedActivityUtils", "isActivityEmbeddedCompat: false, no such method error");
        return false;
    }

    public static boolean d(Activity r100) {
        LKSplitController r101 = LKSplitController.b();     // Catch: Throwable -> L11
        boolean r102 = r101.d(r100);     // Catch: Throwable -> L11
        boolean r103 = r101.e();     // Catch: Throwable -> L11
        boolean r104 = i0.a(r100);     // Catch: Throwable -> L11
        if (r102 == true) goto L8;
        if (r103 == true) goto L8;
        if (r104 == false) goto L8;
        boolean r105 = true;
    L9:
        hac.b r106 = hac.b.f484427a;     // Catch: Throwable -> L11
        r106.a("EmbeddedActivityUtils", "isActivityEmbedded: " + r102 + ", isSplitSupported: " + r103 + ", isMagicWindoow: " + r104);     // Catch: Throwable -> L11
        StringBuilder r107 = new StringBuilder("return isEasygo: ");     // Catch: Throwable -> L11
        r107.append(r105);     // Catch: Throwable -> L11
        r106.a("EmbeddedActivityUtils", r107.toString());     // Catch: Throwable -> L11
        return r105;
    L8:
        r105 = false;
    L11:
        th = move-exception;
        hac.b r108 = hac.b.f484427a;
        r108.c("EmbeddedActivityUtils", "isEasygoing fail", th);
        r108.a("EmbeddedActivityUtils", "return isEasygo: false, throwable error");
        return false;
    }
}
