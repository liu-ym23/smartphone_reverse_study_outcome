package e97;

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
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f471519a;

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
        if (TextUtils.isEmpty(f471519a) == false) goto L5;
        String r101 = null;
        if (Build.VERSION.SDK_INT < 28) goto L9;
        String r102 = Application.getProcessName();
    L10:
        f471519a = r102;
        if (TextUtils.isEmpty(r102) == false) goto L13;
        Method r103 = a(Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L18
        r103.setAccessible(true);     // Catch: Throwable -> L18
        Object r104 = r103.invoke(null, new Object[0]);     // Catch: Throwable -> L18
        if ((r104 instanceof String) == false) goto L20;
        String r105 = (String) r104;     // Catch: Throwable -> L18
    L21:
        f471519a = r105;
        if (TextUtils.isEmpty(r105) == true) goto L68;
        return f471519a;
    L68:
        BufferedReader r106 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L36
        StringBuilder r107 = new StringBuilder();     // Catch: Throwable -> L35
    L28:
        int r108 = r106.read();     // Catch: Throwable -> L35
        if (r108 <= 0) goto L31;
        r107.append((char) r108);     // Catch: Throwable -> L35
        goto L28
    L31:
        String r109 = r107.toString();     // Catch: Throwable -> L35
        r106.close();     // Catch: IOException -> L34
    L42:
        f471519a = r109;
        if (TextUtils.isEmpty(r109) == false) goto L45;
        if (r100 == null) goto L58;
        int r110 = Process.myPid();
        ActivityManager r111 = (ActivityManager) r100.getSystemService("activity");
        if (r111 == null) goto L58;
        List<ActivityManager.RunningAppProcessInfo> r112 = r111.getRunningAppProcesses();
        if (r112 == null) goto L58;
        Iterator<ActivityManager.RunningAppProcessInfo> r113 = r112.iterator();
    L54:
        if (r113.hasNext() == false) goto L58;
        ActivityManager.RunningAppProcessInfo r114 = r113.next();
        if (r114.pid != r110) goto L54;
        r101 = r114.processName;
    L58:
        f471519a = r101;
        return r101;
    L45:
        return f471519a;
    L37:
        if (r106 != null) goto L62;
    L41:
        r109 = null;
        goto L42
    L62:
        r106.close();     // Catch: IOException -> L40
    L36:
        r106 = null;
    L20:
        r105 = null;
    L18:
        th = move-exception;
        th.printStackTrace();
        goto L20
    L13:
        return f471519a;
    L9:
        r102 = null;
        goto L10
    L5:
        return f471519a;
    }
}
