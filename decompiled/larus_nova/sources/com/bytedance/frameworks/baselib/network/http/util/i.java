package com.bytedance.frameworks.baselib.network.http.util;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f244792a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile String f244793b;

    static {
        f244792a = new AtomicInteger(0);
        f244793b = null;
    }

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

    public static String b(Context r100) {
        if (StringUtils.isEmpty(f244793b) == false) goto L5;
        String r101 = null;
        if (Build.VERSION.SDK_INT >= 28) goto L76;
    L12:
        String r102 = null;
    L13:
        f244793b = r102;
        if (StringUtils.isEmpty(f244793b) == false) goto L16;
        Method r103 = a(Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L21
        r103.setAccessible(true);     // Catch: Throwable -> L21
        Object r104 = r103.invoke(null, new Object[0]);     // Catch: Throwable -> L21
        if ((r104 instanceof String) == false) goto L23;
        String r105 = (String) r104;     // Catch: Throwable -> L21
    L24:
        f244793b = r105;
        if (StringUtils.isEmpty(f244793b) == true) goto L72;
        return f244793b;
    L72:
        BufferedReader r106 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L42
        StringBuilder r107 = new StringBuilder();     // Catch: Throwable -> L41
    L31:
        int r108 = r106.read();     // Catch: Throwable -> L41
        if (r108 <= 0) goto L35;
        r107.append((char) r108);     // Catch: Throwable -> L41
        goto L31
    L35:
        if (Logger.debug() == false) goto L37;
        Logger.d("Process", "get processName = " + r107.toString());     // Catch: Throwable -> L41
    L37:
        String r109 = r107.toString();     // Catch: Throwable -> L41
        r106.close();     // Catch: Exception -> L40
    L48:
        f244793b = r109;
        if (StringUtils.isEmpty(f244793b) == false) goto L51;
        if (r100 != null) goto L78;
    L66:
        f244793b = r101;
        return f244793b;
    L78:
        int r110 = Process.myPid();     // Catch: Exception -> L64
        Iterator<ActivityManager.RunningAppProcessInfo> r111 = ((ActivityManager) r100.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L64
    L55:
        if (r111.hasNext() == false) goto L66;
        ActivityManager.RunningAppProcessInfo r112 = r111.next();     // Catch: Exception -> L64
        if (r112.pid != r110) goto L55;
        if (Logger.debug() == false) goto L62;
        Logger.d("Process", "processName = " + r112.processName);     // Catch: Exception -> L64
    L62:
        r101 = r112.processName;     // Catch: Exception -> L64
    L64:
        e = move-exception;
        e.printStackTrace();
        goto L66
    L51:
        return f244793b;
    L43:
        if (r106 != null) goto L74;
    L47:
        r109 = null;
        goto L48
    L74:
        r106.close();     // Catch: Exception -> L46
    L42:
        r106 = null;
    L23:
        r105 = null;
    L21:
        th = move-exception;
        th.printStackTrace();
        goto L23
    L16:
        return f244793b;
    L76:
        r102 = Application.getProcessName();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    L5:
        return f244793b;
    }

    public static boolean c(Context r100) {
        String r101 = b(r100);
        if (r101 != null) goto L5;
    L7:
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.equals(r100.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r101.contains(":") == false) goto L7;
        return false;
    }

    public static boolean d(Context r100) {
        if (Logger.debug() == false) goto L5;
        Logger.d("ProcessUtils", "TTNet ProcessFlag: " + f244792a);
    L5:
        int r101 = f244792a.get();
        if (r101 != 1) goto L8;
        return true;
    L8:
        if (r101 != 2) goto L10;
        return false;
    L10:
        return c(r100);
    }
}
