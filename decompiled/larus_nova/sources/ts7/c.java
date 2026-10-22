package ts7;

import android.os.Handler;
import android.os.HandlerThread;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Handler f547415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static HandlerThread f547416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ExecutorService f547417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ThreadPoolExecutor f547418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f547419e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f547420f = null;

    public static class a implements Runnable {
        public static void a() {
            ExecutorService r100 = c.f547417c;
            if (r100 == null) goto L7;
            List<Runnable> r101 = r100.shutdownNow();
            if (r101 == null) goto L7;
            r101.size();
        L7:
            c.f547417c = null;
            HandlerThread r102 = c.f547416b;
            Object r103 = b.f547409a;
            if (r102 == null) goto L21;
            String r104 = r102.getName();
            Object r105 = b.f547409a;
            monitor-enter(r105);
            b.a r106 = b.f547410b.get(r104);     // Catch: Throwable -> L28
            if (r106 != null) goto L16;
            monitor-exit(r105);     // Catch: Throwable -> L28
            goto L21
        L16:
            int r107 = r106.f547412b - 1;     // Catch: Throwable -> L28
            r106.f547412b = r107;     // Catch: Throwable -> L28
            if (r107 < 0) goto L27;
            if (r107 != 0) goto L20;
            r106.sendEmptyMessageDelayed(0, 0);     // Catch: Throwable -> L28
        L20:
            monitor-exit(r105);     // Catch: Throwable -> L28
            goto L21
        L27:
            throw new IllegalStateException("defRef called on dead thread");     // Catch: Throwable -> L28
        L28:
            th = move-exception;
            throw th;
        L21:
            c.f547416b = null;
            c.f547415a = null;
            ThreadPoolExecutor r108 = c.f547418d;
            if (r108 == null) goto L24;
            r108.shutdownNow();
        L24:
            c.f547418d = null;
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

        public a() {
        }
    }

    static {
        f547420f = new a();
    }

    public static ExecutorService a() {
        if (f547417c != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f547417c != null) goto L9;
        f547417c = Executors.newFixedThreadPool(3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f547417c;
    }

    public static Handler b() {
        if (f547415a != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f547415a != null) goto L9;
        f547416b = b.a();     // Catch: Throwable -> L11
        f547415a = new Handler(f547416b.getLooper());     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f547415a;
    }

    public static void e() {
        Handler r100 = b();
        if (r100 == null) goto L8;
        a r101 = f547420f;
        r100.removeCallbacks(r101);
        if (f547419e == true) goto L9;
        r100.postDelayed(r101, 600000);
        return;
    L9:
        return;
    }

    public c() {
    }

    public static void c(Runnable r110) {
        e();
        if ((r110 instanceof ts7.a) == true) goto L5;
    L21:
        ExecutorService r100 = a();
        if (r100 != null) goto L24;
    L26:
        d(r110);
        return;
    L24:
        if (r100.isShutdown() == true) goto L26;
        r100.execute(r110);
        return;
    L5:
        if (ts7.a.TYPE_LOG.equals(((ts7.a) r110).getRunnableType()) == false) goto L21;
        if (f547418d == null) goto L9;
    L18:
        ThreadPoolExecutor r101 = f547418d;
        if (r101.isShutdown() == true) goto L30;
        r101.execute(r110);
        return;
    L30:
        return;
    L9:
        monitor-enter(c.class);
    L15:
        th = move-exception;
        throw th;
    L11:
        if (f547418d != null) goto L13;
        ThreadPoolExecutor r102 = new ThreadPoolExecutor(0, 1, 10, TimeUnit.SECONDS, new ArrayBlockingQueue(30), new d(), new ThreadPoolExecutor.DiscardOldestPolicy());     // Catch: Throwable -> L15
        f547418d = r102;     // Catch: Throwable -> L15
        r102.setRejectedExecutionHandler(new e());     // Catch: Throwable -> L15
    L13:
        monitor-exit(c.class);     // Catch: Throwable -> L15
        goto L18
    }

    public static void d(Runnable r100) {
        e();
        Handler r101 = b();
        if (r101 == null) goto L5;
        r101.post(r100);
        return;
    L5:
        r100.run();
    }
}
