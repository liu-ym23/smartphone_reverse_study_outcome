package d27;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class f466531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Field f466532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Object f466533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Object f466534d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set<Integer> f466535e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Class f466536f;

    /* JADX INFO: renamed from: d27.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes21.dex */
    public static class RunnableC5619a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f466537a;

        public final void a() {
            a.f466533c = f.d(a.f466536f, new Object[0]);     // Catch: Throwable -> L11 Exception -> L20
            Object r100 = this.f466537a;
            monitor-enter(r100);
            this.f466537a.notify();     // Catch: Throwable -> L8
            monitor-exit(r100);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        L11:
            th = move-exception;
            monitor-enter(this.f466537a);
            this.f466537a.notify();     // Catch: Throwable -> L17
            throw th;
        L17:
            th = move-exception;
            throw th;
        L21:
            monitor-enter(this.f466537a);
            this.f466537a.notify();     // Catch: Throwable -> L25
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

        public RunnableC5619a(Object r100) {
            this.f466537a = r100;
        }
    }

    public a() {
    }

    static {
        HashSet r100 = new HashSet();
        f466535e = r100;
        r100.add(113);
        r100.add(114);
        r100.add(115);
        r100.add(116);
        r100.add(121);
        r100.add(122);
        r100.add(100);
        r100.add(159);
        r100.add(123);
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
        if (f466533c != null) goto L36;
        monitor-enter(a.class);     // Catch: Exception -> L33
    L30:
        th = move-exception;
        throw th;     // Catch: Exception -> L33
    L7:
        if (f466533c != null) goto L13;
        if (f466536f != null) goto L11;
        f466536f = a();     // Catch: Throwable -> L30
    L11:
        f466533c = f.d(f466536f, new Object[0]);     // Catch: Throwable -> L30
    L13:
        if (f466533c == null) goto L15;
    L28:
        monitor-exit(a.class);     // Catch: Throwable -> L30
        goto L36
    L15:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L28;
        Object r100 = new Object();     // Catch: Throwable -> L30
        new Handler(Looper.getMainLooper()).post(new RunnableC5619a(r100));     // Catch: Throwable -> L30
        if (f466533c != null) goto L28;
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
        return f466533c;
    }

    public static synchronized Class c() {
        monitor-enter(a.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f466531a == null) goto L18;
    L10:
        Class r100 = f466531a;     // Catch: Throwable -> L13
        monitor-exit(a.class);
        return r100;
    L18:
        f466531a = a();     // Catch: ClassNotFoundException -> L8 Throwable -> L13
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13
        goto L10
    }

    public static synchronized Field d() {
        monitor-enter(a.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f466532b != null) goto L7;
        f466532b = b.a(c(), "mH");     // Catch: Throwable -> L10
    L7:
        Field r100 = f466532b;     // Catch: Throwable -> L10
        monitor-exit(a.class);
        return r100;
    }

    public static synchronized Object e() {
        monitor-enter(a.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (f466534d == null) goto L16;
    L10:
        Object r100 = f466534d;     // Catch: Throwable -> L13
        monitor-exit(a.class);
        return r100;
    L16:
        f466534d = d().get(f());     // Catch: IllegalAccessException -> L8 Throwable -> L13
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L13
        goto L10
    }

    public static synchronized Object f() {
        monitor-enter(a.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f466533c != null) goto L7;
        f466533c = f.d(c(), new Object[0]);     // Catch: Throwable -> L10 Throwable -> L13
    L7:
        Object r100 = f466533c;     // Catch: Throwable -> L10 Throwable -> L13
        monitor-exit(a.class);
        return r100;
    L14:
        return null;
    }
}
