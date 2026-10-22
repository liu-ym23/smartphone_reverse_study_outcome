package com.bytedance.bdp.bdpbase.util;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes11.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Boolean f201339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Boolean f201340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f201341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f201342d;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class a(ClassLoader r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == false) goto L34;
        Class<?> r103 = Class.forName("android.app.ActivityThread", false, r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.app.ActivityThread");
    L34:
        Class<?> r104 = Class.forName("android.app.ActivityThread", false, r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L8
    L7:
        return r104;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L12:
        throw th;
    }

    public static String c(Context r100) {
        if (TextUtils.isEmpty(f201341c) == false) goto L5;
        String r101 = null;
        if (Build.VERSION.SDK_INT >= 28) goto L71;
    L12:
        String r102 = null;
    L13:
        f201341c = r102;
        if (TextUtils.isEmpty(r102) == false) goto L16;
        Method r103 = a(Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L21
        r103.setAccessible(true);     // Catch: Throwable -> L21
        Object r104 = r103.invoke(null, new Object[0]);     // Catch: Throwable -> L21
        if ((r104 instanceof String) == false) goto L23;
        String r105 = (String) r104;     // Catch: Throwable -> L21
    L24:
        f201341c = r105;
        if (TextUtils.isEmpty(r105) == true) goto L77;
        return f201341c;
    L77:
        BufferedReader r106 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L39
        StringBuilder r107 = new StringBuilder();     // Catch: Throwable -> L38
    L31:
        int r108 = r106.read();     // Catch: Throwable -> L38
        if (r108 <= 0) goto L34;
        r107.append((char) r108);     // Catch: Throwable -> L38
        goto L31
    L34:
        String r109 = r107.toString();     // Catch: Throwable -> L38
        r106.close();     // Catch: Exception -> L37
    L45:
        f201341c = r109;
        if (TextUtils.isEmpty(r109) == false) goto L48;
        if (r100 == null) goto L61;
        int r110 = Process.myPid();
        ActivityManager r111 = (ActivityManager) r100.getSystemService("activity");
        if (r111 == null) goto L61;
        List<ActivityManager.RunningAppProcessInfo> r112 = r111.getRunningAppProcesses();
        if (r112 == null) goto L61;
        Iterator<ActivityManager.RunningAppProcessInfo> r113 = r112.iterator();
    L57:
        if (r113.hasNext() == false) goto L61;
        ActivityManager.RunningAppProcessInfo r114 = r113.next();
        if (r114.pid != r110) goto L57;
        r101 = r114.processName;
    L61:
        f201341c = r101;
        if (TextUtils.isEmpty(r101) == true) goto L66;
        return f201341c;
    L66:
        return f201341c;
    L48:
        return f201341c;
    L40:
        if (r106 != null) goto L69;
    L44:
        r109 = null;
        goto L45
    L69:
        r106.close();     // Catch: Exception -> L43
    L39:
        r106 = null;
    L23:
        r105 = null;
    L21:
        th = move-exception;
        th.printStackTrace();
        goto L23
    L16:
        return f201341c;
    L71:
        r102 = Application.getProcessName();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    L5:
        return f201341c;
    }

    public static boolean d(Context r100) {
        Boolean r101 = f201339a;
        if (r101 == null) goto L7;
        return r101.booleanValue();
    L7:
        if (r100 != null) goto L9;
        return false;
    L9:
        String r102 = c(r100);
        if (r102 == null) goto L15;
        Boolean r103 = Boolean.valueOf(r102.equals(r100.getPackageName()));
        f201339a = r103;
        if (r103.booleanValue() == false) goto L16;
        return true;
    L16:
        return false;
    L15:
        return false;
    }

    public static boolean e(Context r100) {
        Boolean r101 = f201340b;
        if (r101 != null) goto L5;
        boolean r102 = false;
        if (r100 != null) goto L9;
        return false;
    L9:
        String r103 = c(r100);
        if (r103 != null) goto L12;
    L14:
        Boolean r104 = Boolean.valueOf(r102);
        f201340b = r104;
        return r104.booleanValue();
    L12:
        if (r103.contains(":minigame") == false) goto L14;
        r102 = true;
        goto L14
    L5:
        return r101.booleanValue();
    }

    public static boolean b(Context r100, String r101) {
        Iterator<ActivityManager.RunningAppProcessInfo> r102 = ((ActivityManager) r100.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L11
    L4:
        if (r102.hasNext() == false) goto L17;
        if (TextUtils.equals(r102.next().processName, r101) == false) goto L4;
        return true;
    L17:
        return false;
    L9:
        return false;
    }
}
