package nra;

import android.app.Application;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import el9.a;
import java.io.BufferedReader;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class e {
    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class<?> r2 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L12:
        throw th;
    L34:
        Class<?> r3 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L17
    L16:
        return r3;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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

    public static String b() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        BufferedReader r0 = null;
        Method r1 = a().getMethod("currentProcessName", new Class[0]);     // Catch: Exception -> L9
        r1.setAccessible(true);     // Catch: Exception -> L9
        return (String) r1.invoke(null, new Object[0]);
    L9:
        BufferedReader r2 = new BufferedReader(new PolarisFileReaderWrapper("/proc/self/cmdline"));     // Catch: Throwable -> L19 Exception -> L23
        String r3 = r2.readLine();     // Catch: Throwable -> L16 Exception -> L18
        if (TextUtils.isEmpty(r3) == true) goto L30;
        String r4 = r3.trim();     // Catch: Throwable -> L16 Exception -> L18
        if (TextUtils.isEmpty(r4) == true) goto L30;
        r2.close();     // Catch: Exception -> L27
    L15:
        return r4;
    L30:
        r2.close();     // Catch: Exception -> L28
    L26:
        return null;
    L16:
        th = move-exception;
        th = th;
        r0 = r2;
    L20:
        if (r0 != null) goto L34;
    L22:
        throw th;
    L34:
        r0.close();     // Catch: Exception -> L29
    L24:
        if (r2 == null) goto L26;
    L23:
        r2 = null;
    L19:
        th = th;
        goto L20
    L5:
        return Application.getProcessName();
    }

    public static boolean c() {
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }
}
