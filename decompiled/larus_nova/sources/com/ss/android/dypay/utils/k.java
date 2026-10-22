package com.ss.android.dypay.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.TypeCastException;
import kotlin.text.StringsKt;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f408504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f408505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f408506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f408507d;

    static {
    }

    public static String d(String r100) {
        Class r101 = a();     // Catch: Exception -> L9
        Object r102 = r101.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(r101, new Object[]{r100});     // Catch: Exception -> L9
        if (r102 == null) goto L8;
        return (String) r102;
    L8:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");     // Catch: Exception -> L9
    L9:
        return null;
    }

    public static boolean e(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L12;
        String r101 = Build.MANUFACTURER;
        if (r101 == null) goto L13;
        String r102 = r101.toLowerCase(Locale.ROOT);
        if (r102 != null) goto L9;
        return false;
    L9:
        if (StringsKt.startsWith$default(r102, r100, false, 2, null) != true) goto L15;
        return true;
    L15:
        return false;
    L13:
        return false;
    L12:
        return false;
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
        if (c(RomUtils.BRAND_HONOR) == true) goto L6;
        return false;
    L6:
        String r100 = d("ro.build.version.magic");
        if (r100 != null) goto L10;
        r100 = "";
    L10:
        f408506c = r100;
        return !TextUtils.isEmpty(r100);
    }

    public static Point b(Context r100) {
        if (r100 == null) goto L9;
        if (r100.getResources() == null) goto L9;
        Resources r101 = r100.getResources();
        DisplayMetrics r102 = WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics());
        return new Point(r102.widthPixels, r102.heightPixels);
    L9:
        return new Point(0, 0);
    }

    public static boolean c(String r100) {
        String r101 = Build.BRAND;
        if (r101 == null) goto L5;
        String r102 = r101.toLowerCase(Locale.ROOT);
    L7:
        return TextUtils.equals(r100, r102);
    L5:
        r102 = null;
        goto L7
    }
}
