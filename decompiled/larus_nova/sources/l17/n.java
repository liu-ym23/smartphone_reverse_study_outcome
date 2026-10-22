package l17;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.lynx.webview.internal.TTWebContext;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f507010a;

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
        if (TextUtils.isEmpty(f507010a) == true) goto L7;
        return f507010a;
    L7:
        if (Build.VERSION.SDK_INT >= 28) goto L68;
    L12:
        String r101 = "";
    L13:
        f507010a = r101;
        if (TextUtils.isEmpty(r101) == false) goto L16;
        String r102 = null;
        Method r103 = a(Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);     // Catch: Throwable -> L22
        r103.setAccessible(true);     // Catch: Throwable -> L22
        Object r104 = r103.invoke(null, new Object[0]);     // Catch: Throwable -> L22
        if ((r104 instanceof String) == false) goto L24;
        String r105 = (String) r104;     // Catch: Throwable -> L22
    L25:
        f507010a = r105;
        if (TextUtils.isEmpty(r105) == true) goto L62;
        return f507010a;
    L62:
        BufferedReader r106 = new BufferedReader(new InputStreamReader(new PolarisFileInputStreamWrapper("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L40
        StringBuilder r107 = new StringBuilder();     // Catch: Throwable -> L39
    L32:
        int r108 = r106.read();     // Catch: Throwable -> L39
        if (r108 <= 0) goto L35;
        r107.append((char) r108);     // Catch: Throwable -> L39
        goto L32
    L35:
        String r109 = r107.toString();     // Catch: Throwable -> L39
        r106.close();     // Catch: Exception -> L38
    L46:
        f507010a = r109;
        if (TextUtils.isEmpty(r109) == false) goto L49;
        if (r100 == null) goto L60;
        int r110 = Process.myPid();
        ActivityManager r111 = (ActivityManager) r100.getSystemService("activity");
        if (r111 == null) goto L60;
        Iterator<ActivityManager.RunningAppProcessInfo> r112 = c(r100, r111).iterator();
    L56:
        if (r112.hasNext() == false) goto L60;
        ActivityManager.RunningAppProcessInfo r113 = r112.next();
        if (r113.pid != r110) goto L56;
        r102 = r113.processName;
    L60:
        f507010a = r102;
        return r102;
    L49:
        return f507010a;
    L41:
        if (r106 != null) goto L66;
    L45:
        r109 = null;
        goto L46
    L66:
        r106.close();     // Catch: Exception -> L44
    L40:
        r106 = null;
    L24:
        r105 = null;
    L22:
        th = move-exception;
        th.printStackTrace();
        goto L24
    L16:
        return f507010a;
    L68:
        r101 = Application.getProcessName();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public static boolean d(Context r100) {
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

    public static boolean e(Context r100) {
        String r101 = b(r100);
        if (r101 != null) goto L5;
        return false;
    L5:
        if (r101.toLowerCase().contains("miniapp") == false) goto L10;
        return true;
    L10:
        return false;
    }

    public static List<ActivityManager.RunningAppProcessInfo> c(Context r100, ActivityManager r101) {
        if (r100 == null) goto L15;
        AtomicInteger r102 = TTWebContext.f265202n;
        monitor-enter(TTWebContext.class);
        monitor-exit(TTWebContext.class);     // Catch: Throwable -> L11
        List<ActivityManager.RunningAppProcessInfo> r103 = r101.getRunningAppProcesses();
        if (r103 == null) goto L10;
        return r103;
    L10:
        return Collections.emptyList();
    L11:
        th = move-exception;
        throw th;
    L15:
        return Collections.emptyList();
    }
}
