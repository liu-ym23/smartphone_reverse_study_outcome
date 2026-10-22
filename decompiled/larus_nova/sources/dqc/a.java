package dqc;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.util.MethodUtils;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class f469725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Object f469726b;

    /* JADX INFO: renamed from: dqc.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes41.dex */
    public static class RunnableC5700a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f469727a;

        public final void a() {
            a.f469726b = MethodUtils.invokeStaticMethod(a.f469725a, "currentActivityThread", new Object[0]);     // Catch: Throwable -> L11 Exception -> L13
            Object r100 = this.f469727a;
            monitor-enter(r100);
            this.f469727a.notify();     // Catch: Throwable -> L8
            monitor-exit(r100);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        L13:
            e = move-exception;
            ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper main looper invoke currentActivityThread failed.", e);     // Catch: Throwable -> L11
            monitor-enter(this.f469727a);
            this.f469727a.notify();     // Catch: Throwable -> L20
            return;
        L20:
            th = move-exception;
            throw th;
        L11:
            th = move-exception;
            monitor-enter(this.f469727a);
            this.f469727a.notify();     // Catch: Throwable -> L28
            throw th;
        L28:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC5700a(Object r100) {
            this.f469727a = r100;
        }
    }

    public a() {
    }

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

    public static final Object b() {
        if (f469726b != null) goto L38;
        monitor-enter(a.class);     // Catch: Exception -> L35
    L32:
        th = move-exception;
        throw th;     // Catch: Exception -> L35
    L7:
        if (f469726b != null) goto L13;
        if (f469725a != null) goto L11;
        f469725a = a();     // Catch: Throwable -> L32
    L11:
        f469726b = MethodUtils.invokeStaticMethod(f469725a, "currentActivityThread", new Object[0]);     // Catch: Throwable -> L32
    L13:
        if (f469726b == null) goto L15;
    L30:
        monitor-exit(a.class);     // Catch: Throwable -> L32
        goto L38
    L15:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L30;
        Object r100 = new Object();     // Catch: Throwable -> L32
        new Handler(Looper.getMainLooper()).post(new RunnableC5700a(r100));     // Catch: Throwable -> L32
        if (f469726b != null) goto L30;
        monitor-enter(r100);     // Catch: Throwable -> L32
        r100.wait(5000);     // Catch: Throwable -> L22 InterruptedException -> L24
    L26:
        monitor-exit(r100);     // Catch: Throwable -> L22
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
        return f469726b;
    }
}
