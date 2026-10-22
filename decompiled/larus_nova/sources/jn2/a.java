package jn2;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f499722a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f499723b = -1;

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

    public static boolean b(Context r100) {
        if (f499722a != (-1)) goto L77;
        String r101 = null;
        String r102 = Build.MODEL;     // Catch: Exception -> L7
    L8:
        if (r102 != null) goto L10;
        r102 = "";
    L10:
        String r103 = Build.BRAND;
        if (TextUtils.isEmpty(r103) == true) goto L13;
        r103 = r103.toLowerCase();
    L13:
        if (r100 != null) goto L15;
    L19:
        boolean r104 = false;
    L20:
        if (r104 == false) goto L85;
    L74:
        int r105 = 1;
    L75:
        f499722a = r105;
        goto L77
    L85:
        Class r106 = a("android.util.FtFeature");     // Catch: Throwable -> L82
        if (r106 == null) goto L29;
        Method r107 = r106.getDeclaredMethod("isFeatureSupport", new Class[]{Integer.TYPE});     // Catch: Throwable -> L82
        if (r107 == null) goto L29;
        Boolean r108 = (Boolean) r107.invoke(r106, new Object[]{32});     // Catch: Throwable -> L82
        if (r108 == null) goto L29;
        boolean r109 = r108.booleanValue();     // Catch: Throwable -> L82
    L30:
        if (r109 == true) goto L74;
        Class r110 = a("com.huawei.android.util.HwNotchSizeUtil");     // Catch: Throwable -> L81
        if (r110 == null) goto L39;
        Method r111 = r110.getMethod("hasNotchInScreen", new Class[0]);     // Catch: Throwable -> L81
        if (r111 == null) goto L39;
        Boolean r112 = (Boolean) r111.invoke(r110, new Object[0]);     // Catch: Throwable -> L81
        if (r112 == null) goto L39;
        boolean r113 = r112.booleanValue();     // Catch: Throwable -> L81
    L40:
        if (r113 == true) goto L74;
        if ("ONEPLUS A6000".equalsIgnoreCase(r102) == true) goto L74;
        Class r114 = a("android.os.SystemProperties");     // Catch: Throwable -> L80
        if (r114 == null) goto L52;
        Method r115 = r114.getDeclaredMethod("getInt", new Class[]{String.class, Integer.TYPE});     // Catch: Throwable -> L80
        if (r115 == null) goto L52;
        Integer r116 = (Integer) r115.invoke(r114, new Object[]{"ro.miui.notch", 0});     // Catch: Throwable -> L80
        if (r116 == null) goto L52;
        if (r116.intValue() != 1) goto L52;
        boolean r117 = true;
    L53:
        if (r117 == true) goto L74;
        if (f499723b != (-1)) goto L68;
        Resources r118 = r100.getResources();     // Catch: Throwable -> L63
        int r119 = r118.getIdentifier("config_mainBuiltInDisplayCutout", "string", "android");     // Catch: Throwable -> L63
        if (r119 <= 0) goto L59;
        r101 = r118.getString(r119);     // Catch: Throwable -> L63
    L59:
        if (r101 == null) goto L65;
        if (TextUtils.isEmpty(r101) == true) goto L65;
        int r120 = 1;
    L66:
        f499723b = r120;
    L65:
        r120 = 0;
    L63:
        th = move-exception;
        th.toString();
    L68:
        if (f499723b < 1) goto L70;
        boolean r121 = true;
    L71:
        if (r121 == true) goto L74;
        r105 = 0;
        goto L75
    L70:
        r121 = false;
    L52:
        r117 = false;
    L39:
        r113 = false;
    L29:
        r109 = false;
        goto L30
    L15:
        if (TextUtils.equals(AppConstants.CHANNEL_OPPO, r103) == false) goto L19;
        PackageManager r122 = r100.getPackageManager();
        if (r122 == null) goto L19;
        r104 = r122.hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    L7:
        r102 = null;
    L77:
        if (f499722a != 1) goto L93;
        return true;
    L93:
        return false;
    }
}
