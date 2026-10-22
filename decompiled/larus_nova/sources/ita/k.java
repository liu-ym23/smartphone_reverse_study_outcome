package ita;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Process;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f495750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f495751b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f495752c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f495753d;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("miui.os.Build");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("miui.os.Build");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("miui.os.Build");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("miui.os.Build");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("miui.os.Build");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("miui.os.Build");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("miui.os.Build");
    }

    public static String d() {
        if (StringUtils.isEmpty(f495750a) == false) goto L43;
        String r100 = null;
        BufferedReader r101 = new BufferedReader(new InputStreamReader(b(Runtime.getRuntime(), "getprop ro.build.version.emui").getInputStream()), 1024);     // Catch: Throwable -> L14
        r100 = r101.readLine();     // Catch: Throwable -> L12
        r101.close();     // Catch: Throwable -> L12
        f495750a = r100;     // Catch: Throwable -> L12
        r101.close();     // Catch: IOException -> L10
    L23:
        return r100;
    L10:
        e = e;
    L21:
        Logger.e("ToolUtils", "Exception while closing InputStream", e);
    L12:
        th = th;
    L35:
        Logger.e("ToolUtils", "Unable to read sysprop ro.build.version.emui", th);     // Catch: Throwable -> L24
        if (r101 == null) goto L23;
        r101.close();     // Catch: IOException -> L20
    L20:
        e = e;
    L24:
        th = move-exception;
        if (r101 != null) goto L31;
    L30:
        throw th;
    L31:
        r101.close();     // Catch: IOException -> L28
    L28:
        e = move-exception;
        Logger.e("ToolUtils", "Exception while closing InputStream", e);
    L14:
        th = th;
        r101 = null;
        goto L35
    L43:
        return f495750a;
    }

    public static boolean f() {
        String r100 = Build.DISPLAY;
        if (StringUtils.isEmpty(r100) == true) goto L7;
        if (r100.indexOf("Flyme") < 0) goto L7;
        return true;
    L7:
        if (StringUtils.isEmpty(Build.USER) == false) goto L9;
        return false;
    L9:
        if (Build.USER.equals("flyme") == false) goto L15;
        return true;
    L15:
        return false;
    }

    public static boolean j() {
        if (f495752c == true) goto L11;
        if (a() == null) goto L9;
        f495751b = true;     // Catch: Exception -> L12
        f495752c = true;     // Catch: Exception -> L12
        return true;
    L9:
        f495752c = true;
    L11:
        return f495751b;
    }

    public static String c(Context r100) {
        String r101 = f495753d;
        if (StringUtils.isEmpty(r101) == true) goto L42;
        return r101;
    L42:
        int r102 = Process.myPid();     // Catch: Exception -> L15
        Iterator<ActivityManager.RunningAppProcessInfo> r103 = ((ActivityManager) r100.getSystemService("activity")).getRunningAppProcesses().iterator();     // Catch: Exception -> L15
    L7:
        if (r103.hasNext() == false) goto L17;
        ActivityManager.RunningAppProcessInfo r104 = r103.next();     // Catch: Exception -> L15
        if (r104.pid != r102) goto L7;
        if (Logger.debug() == false) goto L13;
        Logger.d("Process", "processName = " + r104.processName);     // Catch: Exception -> L15
    L13:
        String r105 = r104.processName;     // Catch: Exception -> L15
        f495753d = r105;     // Catch: Exception -> L15
        return r105;
    L17:
        String r106 = null;
        BufferedReader r107 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L30
        StringBuilder r108 = new StringBuilder();     // Catch: Throwable -> L29
    L20:
        int r109 = r107.read();     // Catch: Throwable -> L29
        if (r109 <= 0) goto L24;
        r108.append((char) r109);     // Catch: Throwable -> L29
        goto L20
    L24:
        if (Logger.debug() == false) goto L26;
        Logger.d("Process", "get processName = " + r108.toString());     // Catch: Throwable -> L29
    L26:
        r106 = r108.toString();     // Catch: Throwable -> L29
    L38:
        r107.close();     // Catch: Exception -> L35
    L33:
        f495753d = r106;
        return r106;
    L31:
        if (r107 == null) goto L33;
    L30:
        r107 = null;
    L15:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public static boolean i(Context r100) {
        String r101 = c(r100);
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

    public static Process b(Runtime r110, String r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        f06.d r113 = r100.b(102900, "java/lang/Runtime", "exec", r110, r101, "java.lang.Process", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, null, r112, false);
        return (Process) r113.f474983b;
    L6:
        Process r114 = r110.exec(r111);
        r100.a(102900, "java/lang/Runtime", "exec", r110, r101, r114, r112, true);
        return r114;
    }

    public static Intent e(Context r100, String r101) {
        Intent r102 = r100.getPackageManager().getLaunchIntentForPackage(r101);
        if (r102 != null) goto L6;
        return r102;
    L6:
        if (r102.hasCategory("android.intent.category.LAUNCHER") == true) goto L8;
        r102.addCategory("android.intent.category.LAUNCHER");
        Logger.d("ToolUtils", "add category LAUNCHER in launch intent");
    L8:
        r102.setPackage(null);
        r102.addFlags(2097152);
        r102.addFlags(268435456);
        return r102;
    }

    public static boolean g(Context r100, Intent r101) {
        List<ResolveInfo> r102 = r100.getPackageManager().queryIntentActivities(r101, 65536);
        if (r102 != null) goto L5;
        return false;
    L5:
        if (r102.size() <= 0) goto L10;
        return true;
    L10:
        return false;
    }

    public static boolean h(Context r100, String r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (StringUtils.isEmpty(r101) == false) goto L12;
        return false;
    L12:
        if (r100.getPackageManager().getPackageInfo(r101, 16777216) != null) goto L10;
        return false;
    L10:
        return true;
    L17:
        return false;
    }
}
