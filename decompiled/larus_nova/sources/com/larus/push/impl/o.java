package com.larus.push.impl;

import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.bytedance.keva.Keva;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.common.apphost.AppHost;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes4.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Keva f367098a = null;

    static {
        f367098a = xg9.b.a();
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

    public static boolean b(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Build.VERSION.SDK_INT < 26) goto L7;
        Object r100 = r110.getSystemService("notification");     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.app.NotificationManager");     // Catch: Throwable -> L11
        NotificationManager r101 = (NotificationManager) r100;     // Catch: Throwable -> L11
        Method r102 = r101.getClass().getDeclaredMethod("getService", new Class[0]);     // Catch: Throwable -> L11
        r102.setAccessible(true);     // Catch: Throwable -> L11
        Object r103 = r102.invoke(r101, new Object[0]);     // Catch: Throwable -> L11
        ApplicationInfo r104 = r110.getApplicationInfo();     // Catch: Throwable -> L11
        String r111 = r110.getApplicationContext().getPackageName();     // Catch: Throwable -> L11
        int r105 = r104.uid;     // Catch: Throwable -> L11
        Method r106 = r103.getClass().getDeclaredMethod("areNotificationsEnabledForPackage", new Class[]{String.class, Integer.TYPE});     // Catch: Throwable -> L11
        r106.setAccessible(true);     // Catch: Throwable -> L11
        Object r112 = r106.invoke(r103, new Object[]{r111, Integer.valueOf(r105)});     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type kotlin.Boolean");     // Catch: Throwable -> L11
        return ((Boolean) r112).booleanValue();
    L7:
        Object r107 = r110.getSystemService("appops");     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type android.app.AppOpsManager");     // Catch: Throwable -> L11
        int r113 = r110.getApplicationInfo().uid;     // Catch: Throwable -> L11
        Class r108 = a(AppOpsManager.class.getName());     // Catch: Throwable -> L11
        Class<?> r109 = Integer.TYPE;     // Catch: Throwable -> L11
        Method r114 = r108.getMethod("checkOpNoThrow", new Class[]{r109, r109, String.class});     // Catch: Throwable -> L11
        Object r115 = r108.getDeclaredField("OP_POST_NOTIFICATION").get(r109);     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L11
        Object r116 = r114.invoke((AppOpsManager) r107, new Object[]{Integer.valueOf(((Integer) r115).intValue()), Integer.valueOf(r113), AppHost.f326268a.getApplication().getPackageName()});     // Catch: Throwable -> L11
        Intrinsics.checkNotNull(r116, "null cannot be cast to non-null type kotlin.Int");     // Catch: Throwable -> L11
        if (((Integer) r116).intValue() != 0) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public static void c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intent r101 = new Intent();
        if (Build.VERSION.SDK_INT < 26) goto L5;
        r101.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        r101.putExtra("android.provider.extra.APP_PACKAGE", r100.getPackageName());
        r101.addFlags(268435456);
    L18:
        r100.startActivity(r101);     // Catch: Exception -> L8
        return;
    L8:
        r101.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        ResolveInfo r102 = null;
        r101.setData(Uri.fromParts("package", r100.getPackageName(), null));
        PackageManager r103 = r100.getPackageManager();     // Catch: Exception -> L15
        if (r103 == null) goto L12;
        r102 = r103.resolveActivity(r101, 0);     // Catch: Exception -> L15
    L12:
        if (r102 == null) goto L20;
        r100.startActivity(r101);     // Catch: Exception -> L15
        return;
    L20:
        return;
    L22:
        return;
    L5:
        r101.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
        r101.putExtra("app_package", r100.getPackageName());
        r101.putExtra("app_uid", r100.getApplicationInfo().uid);
        r101.addFlags(268435456);
        goto L18
    }
}
