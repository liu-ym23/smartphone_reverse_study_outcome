package com.larksuite.framework.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.log.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes24.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f286048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f286049b;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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
    }

    public static String b(Context r100) {
        if (TextUtils.isEmpty(f286048a) == false) goto L5;
        BufferedReader r101 = null;
        if (Build.VERSION.SDK_INT < 28) goto L83;
        f286048a = Application.getProcessName();
    L13:
        if (TextUtils.isEmpty(f286048a) == false) goto L15;
        Application r102 = (Application) r100.getApplicationContext();     // Catch: Exception -> L18
        Field r103 = r102.getClass().getField("mLoadedApk");     // Catch: Exception -> L18
        r103.setAccessible(true);     // Catch: Exception -> L18
        Object r104 = r103.get(r102);     // Catch: Exception -> L18
        Field r105 = r104.getClass().getDeclaredField("mActivityThread");     // Catch: Exception -> L18
        r105.setAccessible(true);     // Catch: Exception -> L18
        Object r106 = r105.get(r104);     // Catch: Exception -> L18
        String r107 = (String) r106.getClass().getDeclaredMethod("getProcessName", new Class[0]).invoke(r106, new Object[0]);     // Catch: Exception -> L18
    L20:
        f286048a = r107;
        if (TextUtils.isEmpty(r107) == false) goto L23;
        PolarisFileWrapper r108 = new PolarisFileWrapper("/proc/self/cmdline");
        String r109 = "";
        if (r108.exists() == true) goto L76;
    L58:
        String r110 = "";
    L59:
        f286048a = r110;
        if (TextUtils.isEmpty(r110) == false) goto L62;
        ActivityManager r111 = (ActivityManager) r100.getSystemService("activity");
        if (r111 == null) goto L73;
        List<ActivityManager.RunningAppProcessInfo> r112 = r111.getRunningAppProcesses();
        if (r112 == null) goto L73;
        Iterator<ActivityManager.RunningAppProcessInfo> r113 = r112.iterator();
    L69:
        if (r113.hasNext() == false) goto L73;
        ActivityManager.RunningAppProcessInfo r114 = r113.next();
        if (r114.pid != Process.myPid()) goto L69;
        r109 = r114.processName.trim();
    L73:
        f286048a = r109;
        return r109;
    L62:
        return f286048a;
    L42:
        th = th;
        BufferedReader r115 = r101;
    L52:
        if (r115 != null) goto L81;
    L57:
        throw th;
    L81:
        r115.close();     // Catch: Exception -> L55
    L55:
        e = move-exception;
        e.printStackTrace();
        goto L57
    L76:
        if (r108.isDirectory() == true) goto L58;
        r115 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper(r108)));     // Catch: Throwable -> L42 Exception -> L44
        String r116 = r115.readLine();     // Catch: Throwable -> L38 Exception -> L40
        if (TextUtils.isEmpty(r116) == true) goto L36;
        r110 = r116.trim();     // Catch: Throwable -> L38 Exception -> L40
        r115.close();     // Catch: Exception -> L34
    L34:
        e = move-exception;
        e.printStackTrace();
        goto L59
    L36:
        r115.close();     // Catch: Exception -> L49
    L75:
    L40:
        e = e;
        r101 = r115;
    L45:
        e.printStackTrace();     // Catch: Throwable -> L42
        if (r101 == null) goto L58;
        r101.close();     // Catch: Exception -> L49
    L38:
        th = th;
    L44:
        e = e;
    L49:
        e = move-exception;
        e.printStackTrace();
        goto L58
    L23:
        return f286048a;
    L18:
        e = move-exception;
        e.printStackTrace();
        r107 = null;
        goto L20
    L15:
        return f286048a;
    L83:
        Method r117 = a().getMethod("currentProcessName", new Class[0]);     // Catch: Exception -> L11
        r117.setAccessible(true);     // Catch: Exception -> L11
        f286048a = (String) r117.invoke(null, new Object[0]);     // Catch: Exception -> L11
        goto L13
    L5:
        return f286048a;
    }

    public static String c(Context r100) {
        if (e(r100) == false) goto L7;
        return "";
    L7:
        if (TextUtils.isEmpty(f286048a) == false) goto L9;
        return "unknown";
    L9:
        int r101 = f286048a.indexOf(":");
        if (r101 != (-1)) goto L12;
        return "unknown";
    L12:
        return f286048a.substring(r101 + 1);
    }

    public static boolean d(Context r100) {
        ActivityManager r101 = (ActivityManager) r100.getSystemService("activity");
        if (r101 != null) goto L6;
        Log.e("ProcessUtil", "getForegroundProcess: activityManager is null, so return");
        return false;
    L6:
        String r102 = r100.getPackageName();
        List<ActivityManager.RunningAppProcessInfo> r103 = r101.getRunningAppProcesses();
        if (r103 != null) goto L10;
        Log.e("ProcessUtil", "getForegroundProcess: get running process info  is null, so return");
        return false;
    L10:
        Iterator<ActivityManager.RunningAppProcessInfo> r104 = r103.iterator();
    L12:
        if (r104.hasNext() == false) goto L19;
        ActivityManager.RunningAppProcessInfo r105 = r104.next();
        if (r105.processName.contains(r102) == false) goto L12;
        Log.i("ProcessUtil", "process name is " + r105.processName + ", process import is  " + r105.importance);
        if (r105.importance != 100) goto L12;
        return true;
    L19:
        return false;
    }

    public static boolean e(Context r100) {
        boolean r101 = f286049b;
        if (r101 == false) goto L5;
        return r101;
    L5:
        String r102 = b(r100);
        f286048a = r102;
        if (TextUtils.isEmpty(r102) == true) goto L11;
        if (f286048a.indexOf(":") != (-1)) goto L11;
        f286049b = true;
    L11:
        return f286049b;
    }
}
