package dqc;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.util.MethodUtils;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class a {
    public static Class a;
    public static Object b;

    public a() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
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

    public static final Object b() {
        if (b != null) goto L38;
        monitor-enter(a.class);     // Catch: Exception -> L35
    L32:
        th = move-exception;
        throw th;     // Catch: Exception -> L35
    L7:
        if (b != null) goto L13;
        if (a != null) goto L11;
        a = a();     // Catch: Throwable -> L32
    L11:
        b = MethodUtils.invokeStaticMethod(a, "currentActivityThread", new Object[0]);     // Catch: Throwable -> L32
    L13:
        if (b == null) goto L15;
    L30:
        monitor-exit(a.class);     // Catch: Throwable -> L32
        goto L38
    L15:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L30;
        Object r1 = new Object();     // Catch: Throwable -> L32
        new Handler(Looper.getMainLooper()).post(new a(r1));     // Catch: Throwable -> L32
        if (b != null) goto L30;
        monitor-enter(r1);     // Catch: Throwable -> L32
        r1.wait(5000);     // Catch: Throwable -> L22 InterruptedException -> L24
    L26:
        monitor-exit(r1);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L24:
        e = move-exception;
        ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread interruptedException failed.", e);     // Catch: Throwable -> L22
    L35:
        e = move-exception;
        ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread failed.", e);
    L38:
        return b;
    }
}
