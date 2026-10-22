package wh4;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.crash.util.p;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends PthreadHandlerThreadV2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile b f559649f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Queue<a> f559650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Handler f559651d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f559652e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f559653a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f559654b;

        public a(Runnable r100, long r101) {
            this.f559653a = r100;
            this.f559654b = r101;
        }
    }

    public static b d() {
        if (f559649f != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f559649f != null) goto L9;
        f559649f = new b();     // Catch: Throwable -> L11
        ThreadMethodProxy.start(f559649f);     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return f559649f;
    }

    public b() {
        super("npth-worker");
        this.f559650c = new ConcurrentLinkedQueue();
    }

    /* JADX INFO: Infinite loop detected, blocks: 19, insns: 0 */
    @Override // android.os.HandlerThread
    public final void onLooperPrepared() {
        super.onLooperPrepared();
        this.f559651d = new Handler(Looper.myLooper());
        Queue<a> r100 = this.f559650c;
        monitor-enter(r100);
    L30:
    L23:
        th = move-exception;
        throw th;
    L5:
        if (((ConcurrentLinkedQueue) this.f559650c).isEmpty() == true) goto L10;
        a r101 = (a) ((ConcurrentLinkedQueue) this.f559650c).poll();     // Catch: Throwable -> L23
        if (r101 == null) goto L30;
        this.f559651d.sendMessageAtTime(Message.obtain(this.f559651d, r101.f559653a), r101.f559654b);     // Catch: Throwable -> L26
        goto L30
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L23
    L34:
        Looper.loop();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        p.d(th);
        int r102 = this.f559652e;     // Catch: Throwable -> L27
        if (r102 > 5) goto L21;
        if (r102 != 5) goto L19;
        String r103 = "NPTH_ERR_MAX";
    L20:
        ch4.c.b(r103, th);     // Catch: Throwable -> L27
        goto L21
    L19:
        r103 = "NPTH_CATCH";
    L21:
        this.f559652e++;     // Catch: Throwable -> L27
        goto L34
    }

    public static void f(Runnable r100) {
        b r101 = d();
        Queue<a> r102 = r101.f559650c;
        monitor-enter(r102);
        Iterator r103 = ((ConcurrentLinkedQueue) r101.f559650c).iterator();     // Catch: Throwable -> L15
    L6:
        if (r103.hasNext() == false) goto L10;
        if (((a) r103.next()).f559653a.equals(r100) == false) goto L6;
        r103.remove();     // Catch: Throwable -> L15
        goto L6
    L10:
        monitor-exit(r102);     // Catch: Throwable -> L15
        Handler r104 = r101.f559651d;
        if (r104 == null) goto L25;
        r104.removeCallbacks(r100);
        return;
    L25:
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public static void post(Runnable r100) {
        b r101 = d();
        r101.getClass();
        r101.e(r100, SystemClock.uptimeMillis() + 0);
    }

    public static void postDelayed(Runnable r100, long r101) {
        b r102 = d();
        r102.getClass();
        if (r101 >= 0) goto L5;
        r101 = 0;
    L5:
        r102.e(r100, SystemClock.uptimeMillis() + r101);
    }

    public final void e(Runnable r100, long r101) {
        if (this.f559651d != null) goto L16;
        Queue<a> r102 = this.f559650c;
        monitor-enter(r102);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.f559651d != null) goto L11;
        Queue<a> r103 = this.f559650c;     // Catch: Throwable -> L13
        ConcurrentLinkedQueue r104 = (ConcurrentLinkedQueue) r103;     // Catch: Throwable -> L13
        r104.add(new a(r100, r101));     // Catch: Throwable -> L13
        monitor-exit(r102);     // Catch: Throwable -> L13
        return;
    L11:
        monitor-exit(r102);     // Catch: Throwable -> L13
    L16:
        Message r105 = Message.obtain(this.f559651d, r100);
        this.f559651d.sendMessageAtTime(r105, r101);
    }
}
