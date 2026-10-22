package r1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes39.dex */
public final class q {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f535589f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final b f535590g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f535591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Queue<f> f535592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Queue<Message> f535593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile Handler f535594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f535595e;

    public static class a implements d<f, Runnable> {
        public a() {
        }

        @Override // r1.q.d
        public final boolean a(f r100, Runnable r101) {
            f r102 = r100;
            Runnable r103 = r101;
            if (r103 != null) goto L10;
            if (r102 == null) goto L9;
            Message r104 = r102.f535600a;
            if (r104 == null) goto L9;
            if (r104.getCallback() == null) goto L9;
            return false;
        L9:
            return true;
        L10:
            if (r102 == null) goto L18;
            Message r105 = r102.f535600a;
            if (r105 != null) goto L14;
            return false;
        L14:
            if (r103.equals(r105.getCallback()) == true) goto L9;
            return false;
        L18:
            return false;
        }
    }

    public static class b implements d<Message, Runnable> {
        public b() {
        }

        @Override // r1.q.d
        public final boolean a(Message r100, Runnable r101) {
            Message r102 = r100;
            Runnable r103 = r101;
            if (r103 != null) goto L8;
            if (r102 != null) goto L6;
        L7:
            return true;
        L6:
            if (r102.getCallback() == null) goto L7;
            return false;
        L8:
            if (r102 != null) goto L10;
            return false;
        L10:
            if (r103.equals(r102.getCallback()) == true) goto L7;
            return false;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ q f535596a;

        public c(q r100) {
            this.f535596a = r100;
        }

        public final void a() {
        L3:
            if (((ConcurrentLinkedQueue) this.f535596a.f535593c).isEmpty() == true) goto L10;
            if (this.f535596a.f535594d == null) goto L3;
            this.f535596a.f535594d.sendMessageAtFrontOfQueue((Message) ((ConcurrentLinkedQueue) this.f535596a.f535593c).poll());     // Catch: Throwable -> L8
        L10:
            if (((ConcurrentLinkedQueue) this.f535596a.f535592b).isEmpty() == true) goto L16;
            f r100 = (f) ((ConcurrentLinkedQueue) this.f535596a.f535592b).poll();
            if (this.f535596a.f535594d == null) goto L10;
            this.f535596a.f535594d.sendMessageAtTime(r100.f535600a, r100.f535601b);     // Catch: Throwable -> L15
            goto L10
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
    }

    public interface d<A, B> {
        boolean a(A r100, B r101);
    }

    public class e extends PthreadHandlerThreadV2 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile int f535597c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile boolean f535598d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ q f535599e;

        public e(q r100) {
            this.f535599e = r100;
            super("default_npth_thread");
            this.f535597c = 0;
            this.f535598d = false;
        }

        /* JADX INFO: Infinite loop detected, blocks: 24, insns: 0 */
        @Override // android.os.HandlerThread
        public final void onLooperPrepared() {
            super.onLooperPrepared();
            Object r100 = this.f535599e.f535595e;
            monitor-enter(r100);
            this.f535599e.f535594d = new Handler();     // Catch: Throwable -> L24
            monitor-exit(r100);     // Catch: Throwable -> L24
            this.f535599e.f535594d.post(new c(this.f535599e));
        L28:
            Looper.loop();     // Catch: Throwable -> L9
        L9:
            if (g1.e.f479565b == null) goto L17;
            if (g1.e.f479565b.f479566a == null) goto L17;
            g1.c r101 = g1.e.f479565b.f479566a.f479529a;     // Catch: Throwable -> L27
            if (r101 == null) goto L17;
            m.a().b(r101.f479560b, 5000);     // Catch: Throwable -> L27
        L17:
            if (this.f535597c >= 5) goto L20;
            com.apm.lite.c.a();     // Catch: Throwable -> L27
        L22:
            this.f535597c++;     // Catch: Throwable -> L27
            goto L28
        L20:
            if (this.f535598d == true) goto L22;
            this.f535598d = true;     // Catch: Throwable -> L27
            com.apm.lite.c.a();     // Catch: Throwable -> L27
            new RuntimeException();     // Catch: Throwable -> L27
        L24:
            th = move-exception;
            throw th;
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Message f535600a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f535601b;

        public f(Message r100, long r101) {
            this.f535600a = r100;
            this.f535601b = r101;
        }
    }

    static {
        f535589f = new a();
        f535590g = new b();
    }

    public q() {
        this.f535592b = new ConcurrentLinkedQueue();
        this.f535593c = new ConcurrentLinkedQueue();
        this.f535595e = new Object();
        this.f535591a = new e(this);
    }

    public static void c(Collection r100, Object r101, d r102) {
        if (r100 == null) goto L12;
        ConcurrentLinkedQueue r103 = (ConcurrentLinkedQueue) r100;
        if (r103.isEmpty() == true) goto L21;
        Iterator r104 = r103.iterator();     // Catch: Throwable -> L13
    L7:
        if (r104.hasNext() == false) goto L23;
        if (r102.a(r104.next(), r101) == false) goto L7;
        r104.remove();     // Catch: Throwable -> L13
    L23:
        return;
    L22:
        return;
    L21:
        return;
    }

    public final void e(Runnable r100) {
        if (((ConcurrentLinkedQueue) this.f535592b).isEmpty() == true) goto L5;
    L6:
        c(this.f535592b, r100, f535589f);
        c(this.f535593c, r100, f535590g);
    L8:
        if (this.f535594d == null) goto L11;
        this.f535594d.removeCallbacks(r100);
        return;
    L11:
        return;
    L5:
        if (((ConcurrentLinkedQueue) this.f535593c).isEmpty() == true) goto L8;
        goto L6
    }

    public final void a(Runnable r100) {
        d(Message.obtain(this.f535594d, r100), 0);
    }

    public final void b(Runnable r100, long r101) {
        d(Message.obtain(this.f535594d, r100), r101);
    }

    public final boolean d(Message r100, long r101) {
        if (r101 >= 0) goto L5;
        r101 = 0;
    L5:
        long r102 = SystemClock.uptimeMillis() + r101;
        if (this.f535594d != null) goto L22;
        Object r103 = this.f535595e;
        monitor-enter(r103);
    L16:
        th = move-exception;
        throw th;
    L10:
        if (this.f535594d != null) goto L14;
        ((ConcurrentLinkedQueue) this.f535592b).add(new f(r100, r102));     // Catch: Throwable -> L16
        monitor-exit(r103);     // Catch: Throwable -> L16
        return true;
    L14:
        monitor-exit(r103);     // Catch: Throwable -> L16
    L22:
        return this.f535594d.sendMessageAtTime(r100, r102);
    L26:
        return true;
    }
}
