package com.ss.android.token;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile String f449749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f449750b;

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
        if (TextUtils.isEmpty(f449749a) == false) goto L5;
        String r101 = null;
        if (Build.VERSION.SDK_INT >= 28) goto L83;
    L12:
        String r102 = null;
    L13:
        f449749a = r102;
        tb7.a.a("Process", "getCurProcessName: " + f449749a);
        if (TextUtils.isEmpty(f449749a) == false) goto L16;
        Method r103 = a(Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L21
        r103.setAccessible(true);     // Catch: Throwable -> L21
        Object r104 = r103.invoke(null, new Object[0]);     // Catch: Throwable -> L21
        if ((r104 instanceof String) == false) goto L23;
        String r105 = (String) r104;     // Catch: Throwable -> L21
    L24:
        f449749a = r105;
        tb7.a.a("Process", "getCurrentProcessNameByActivityThread: " + f449749a);
        if (TextUtils.isEmpty(f449749a) == true) goto L81;
        return f449749a;
    L81:
        BufferedReader r106 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L41
        StringBuilder r107 = new StringBuilder();     // Catch: Throwable -> L39
    L31:
        int r108 = r106.read();     // Catch: Throwable -> L39
        if (r108 <= 0) goto L34;
        r107.append((char) r108);     // Catch: Throwable -> L39
        goto L31
    L34:
        tb7.a.a("Process", "get processName = " + r107.toString());     // Catch: Throwable -> L39
        String r109 = r107.toString();     // Catch: Throwable -> L39
        r106.close();     // Catch: Exception -> L37
    L50:
        f449749a = r109;
        tb7.a.a("Process", "getCurProcessNameFromProc: " + f449749a);
        if (TextUtils.isEmpty(f449749a) == false) goto L53;
        if (r100 == null) goto L66;
        int r110 = Process.myPid();
        ActivityManager r111 = (ActivityManager) r100.getSystemService("activity");
        if (r111 == null) goto L66;
        List<ActivityManager.RunningAppProcessInfo> r112 = r111.getRunningAppProcesses();
        if (r112 == null) goto L66;
        Iterator<ActivityManager.RunningAppProcessInfo> r113 = r112.iterator();
    L62:
        if (r113.hasNext() == false) goto L66;
        ActivityManager.RunningAppProcessInfo r114 = r113.next();
        if (r114.pid != r110) goto L62;
        r101 = r114.processName;
    L66:
        f449749a = r101;
        tb7.a.a("Process", "getCurrentProcessNameByActivityManager: " + f449749a);
        return f449749a;
    L53:
        return f449749a;
    L37:
        e = move-exception;
        TTTokenMonitor.d(e);
    L39:
        th = th;
    L85:
        TTTokenMonitor.d(th);     // Catch: Throwable -> L68
        if (r106 != null) goto L89;
    L49:
        r109 = null;
        goto L50
    L89:
        r106.close();     // Catch: Exception -> L47
    L47:
        e = move-exception;
        TTTokenMonitor.d(e);
    L68:
        th = move-exception;
        if (r106 != null) goto L87;
    L74:
        throw th;
    L87:
        r106.close();     // Catch: Exception -> L72
    L72:
        e = move-exception;
        TTTokenMonitor.d(e);
    L41:
        th = th;
        r106 = null;
    L23:
        r105 = null;
    L21:
        th = move-exception;
        th.printStackTrace();
        goto L23
    L16:
        return f449749a;
    L83:
        r102 = Application.getProcessName();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    L5:
        return f449749a;
    }

    public static boolean d(Context r100) {
        String r101 = b(r100);
        if (TextUtils.isEmpty(r101) == false) goto L14;
        return false;
    L14:
        return r101.equals(r100.getPackageManager().getApplicationInfo(r100.getPackageName(), 128).processName);
    L7:
        th = move-exception;
        tb7.a.a("Process", "isMainProcess exception" + Log.getStackTraceString(th));
        if (r101.contains(":") == false) goto L11;
        return false;
    L11:
        if (r101.equals(r100.getPackageName()) == false) goto L17;
        return true;
    L17:
        return false;
    }

    public static boolean c(String r100, Set<String> r101) {
        Iterator<String> r102 = r101.iterator();
    L4:
        if (r102.hasNext() == false) goto L17;
        String r103 = r102.next();
        if (TextUtils.isEmpty(r103) == true) goto L4;
        if (r100.equals(r103) == true) goto L10;
        if (r103.startsWith(".") == true) goto L15;
        r103 = ".".concat(r103);
    L15:
        if (r100.endsWith(r103) == false) goto L4;
        return true;
    L10:
        return true;
    L17:
        return false;
    }
}
