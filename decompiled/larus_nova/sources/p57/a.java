package p57;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class f527785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Object f527786b;

    /* JADX INFO: renamed from: p57.a$a, reason: collision with other inner class name */
    public static class RunnableC7152a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f527787a;

        public final void a() {
            a.f527786b = u57.d.b(a.f527785a, new Object[0]);     // Catch: Throwable -> L11 Exception -> L20
            Object r100 = this.f527787a;
            monitor-enter(r100);
            this.f527787a.notify();     // Catch: Throwable -> L8
            monitor-exit(r100);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        L11:
            th = move-exception;
            monitor-enter(this.f527787a);
            this.f527787a.notify();     // Catch: Throwable -> L17
            throw th;
        L17:
            th = move-exception;
            throw th;
        L21:
            monitor-enter(this.f527787a);
            this.f527787a.notify();     // Catch: Throwable -> L25
            return;
        L25:
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

        public RunnableC7152a(Object r100) {
            this.f527787a = r100;
        }
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

    public static Object b() {
        if (f527786b != null) goto L36;
        monitor-enter(a.class);     // Catch: Exception -> L33
    L30:
        th = move-exception;
        throw th;     // Catch: Exception -> L33
    L7:
        if (f527786b != null) goto L13;
        if (f527785a != null) goto L11;
        f527785a = a();     // Catch: Throwable -> L30
    L11:
        f527786b = u57.d.b(f527785a, new Object[0]);     // Catch: Throwable -> L30
    L13:
        if (f527786b == null) goto L15;
    L28:
        monitor-exit(a.class);     // Catch: Throwable -> L30
        goto L36
    L15:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L28;
        Object r100 = new Object();     // Catch: Throwable -> L30
        new Handler(Looper.getMainLooper()).post(new RunnableC7152a(r100));     // Catch: Throwable -> L30
        if (f527786b != null) goto L28;
        monitor-enter(r100);     // Catch: Throwable -> L30
        r100.wait(5000);     // Catch: Throwable -> L22 InterruptedException -> L37
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L30
    L24:
        monitor-exit(r100);     // Catch: Throwable -> L22
    L33:
        e = move-exception;
        e.printStackTrace();
    L36:
        return f527786b;
    }

    public a() {
    }
}
