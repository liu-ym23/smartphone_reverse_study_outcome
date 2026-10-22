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
import java.io.BufferedReader;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public final class e {
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

    public static String b() {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        BufferedReader r100 = null;
        Method r101 = a().getMethod("currentProcessName", new Class[0]);     // Catch: Exception -> L9
        r101.setAccessible(true);     // Catch: Exception -> L9
        return (String) r101.invoke(null, new Object[0]);
    L9:
        BufferedReader r102 = new BufferedReader(new PolarisFileReaderWrapper("/proc/self/cmdline"));     // Catch: Throwable -> L19 Exception -> L23
        String r103 = r102.readLine();     // Catch: Throwable -> L16 Exception -> L18
        if (TextUtils.isEmpty(r103) == true) goto L30;
        String r104 = r103.trim();     // Catch: Throwable -> L16 Exception -> L18
        if (TextUtils.isEmpty(r104) == true) goto L30;
        r102.close();     // Catch: Exception -> L27
    L15:
        return r104;
    L30:
        r102.close();     // Catch: Exception -> L28
    L26:
        return null;
    L16:
        th = move-exception;
        th = th;
        r100 = r102;
    L20:
        if (r100 != null) goto L34;
    L22:
        throw th;
    L34:
        r100.close();     // Catch: Exception -> L29
    L24:
        if (r102 == null) goto L26;
    L23:
        r102 = null;
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
