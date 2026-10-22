package com.bytedance.awemeopen.infra.util;

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

/* JADX INFO: loaded from: classes46.dex */
public final class m {
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

    public static boolean b(Context r100) {
        String r101 = null;
        if (Build.VERSION.SDK_INT >= 28) goto L59;
    L8:
        String r102 = null;
    L10:
        if (TextUtils.isEmpty(r102) == false) goto L58;
        Method r103 = a(Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L16
        r103.setAccessible(true);     // Catch: Throwable -> L16
        Object r104 = r103.invoke(null, new Object[0]);     // Catch: Throwable -> L16
        if ((r104 instanceof String) == false) goto L18;
        r102 = (String) r104;     // Catch: Throwable -> L16
    L20:
        if (TextUtils.isEmpty(r102) == false) goto L58;
        BufferedReader r105 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L33
        StringBuilder r106 = new StringBuilder();     // Catch: Throwable -> L32
    L25:
        int r107 = r105.read();     // Catch: Throwable -> L32
        if (r107 <= 0) goto L28;
        r106.append((char) r107);     // Catch: Throwable -> L32
        goto L25
    L28:
        String r108 = r106.toString();     // Catch: Throwable -> L32
        r105.close();     // Catch: Exception -> L31
    L40:
        if (TextUtils.isEmpty(r108) == true) goto L42;
        r102 = r108;
        goto L58
    L42:
        if (r100 == null) goto L55;
        int r109 = Process.myPid();
        ActivityManager r110 = (ActivityManager) r100.getSystemService("activity");
        if (r110 == null) goto L55;
        List<ActivityManager.RunningAppProcessInfo> r111 = r110.getRunningAppProcesses();
        if (r111 == null) goto L55;
        Iterator<ActivityManager.RunningAppProcessInfo> r112 = r111.iterator();
    L50:
        if (r112.hasNext() == false) goto L55;
        ActivityManager.RunningAppProcessInfo r113 = r112.next();
        if (r113.pid != r109) goto L50;
        r101 = r113.processName;
    L55:
        if (TextUtils.isEmpty(r101) == true) goto L58;
        r102 = r101;
    L34:
        if (r105 != null) goto L63;
    L38:
        r108 = null;
        goto L40
    L63:
        r105.close();     // Catch: Exception -> L37
    L33:
        r105 = null;
    L18:
        r102 = null;
    L16:
        th = move-exception;
        th.printStackTrace();
    L58:
        return r102.equals(r100.getPackageName());
    L59:
        r102 = Application.getProcessName();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }
}
