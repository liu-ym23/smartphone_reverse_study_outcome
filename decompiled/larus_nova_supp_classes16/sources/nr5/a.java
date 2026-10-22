package nr5;

import com.bytedance.ee.bear.document.loading.SmallLoadingPlugin;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import cvc.c;
import cvc.d;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public int a;
    public int b;
    public Runnable c;
    public ExecutorService d;
    public final Deque<b.C0263b> e;
    public final Deque<b.C0263b> f;
    public final Deque<b> g;

    public final synchronized ExecutorService c() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.d != null) goto L6;
        TimeUnit r6 = TimeUnit.SECONDS;     // Catch: Throwable -> L9
        SynchronousQueue r7 = new SynchronousQueue();     // Catch: Throwable -> L9
        byte[] r8 = c.a;     // Catch: Throwable -> L9
        this.d = new PThreadPoolExecutor(0, SmallLoadingPlugin.DURATION_MAX, 60, r6, r7, new d("eenet__RustNet Dispatcher", false));     // Catch: Throwable -> L9
    L6:
        ExecutorService r0 = this.d;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public final synchronized int g() {
        monitor-enter(this);
        int r0 = ((ArrayDeque) this.f).size() + ((ArrayDeque) this.g).size();
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, java.lang.Runnable, nr5.b$b] */
    public final void f() {
        if (((ArrayDeque) this.f).size() < this.a) goto L6;
        return;
    L6:
        if (((ArrayDeque) this.e).isEmpty() == false) goto L8;
        return;
    L8:
        Iterator r0 = ((ArrayDeque) this.e).iterator();
    L10:
        if (r0.hasNext() == false) goto L16;
        ?? r1 = (b.C0263b) r0.next();
        if (h(r1) >= this.b) goto L15;
        r0.remove();
        ((ArrayDeque) this.f).add(r1);
        c().execute(r1);
    L15:
        if (((ArrayDeque) this.f).size() < this.a) goto L10;
        return;
    }

    public a(ExecutorService r2) {
        this.a = 64;
        this.b = 5;
        this.e = new ArrayDeque();
        this.f = new ArrayDeque();
        this.g = new ArrayDeque();
        this.d = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized void a(b.C0263b r3) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (((ArrayDeque) this.f).size() < this.a) goto L6;
    L8:
        ((ArrayDeque) this.e).add(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return;
    L6:
        if (h(r3) >= this.b) goto L8;
        ((ArrayDeque) this.f).add(r3);     // Catch: Throwable -> L11
        c().execute(r3);     // Catch: Throwable -> L11
        goto L9
    }

    public final synchronized void b(b r2) {
        monitor-enter(this);
        ((ArrayDeque) this.g).add(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void e(b.C0263b r3) {
        d(this.f, r3, true);
    }

    public final int h(b.C0263b r5) {
        Iterator r0 = ((ArrayDeque) this.f).iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L11;
        b r2 = ((b.C0263b) r0.next()).c;
        if (r2.h == true) goto L4;
        if (r2.g.url().host().equals(r5.c.g.url().host()) == false) goto L4;
        r1 = r1 + 1;
        goto L4
    L11:
        return r1;
    }

    public final synchronized void i(Runnable r1) {
        monitor-enter(this);
        this.c = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void j(int r4) {
        monitor-enter(this);
        if (r4 < 1) goto L12;
        this.b = r4;     // Catch: Throwable -> L9
        f();     // Catch: Throwable -> L9
        monitor-exit(this);
        return;
    L12:
        throw new IllegalArgumentException("max < 1: " + r4);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public final <T> void d(Deque<T> r1, T r2, boolean r3) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (((ArrayDeque) r1).remove(r2) == false) goto L14;
        if (r3 == false) goto L7;
        f();     // Catch: Throwable -> L17
    L7:
        int r4 = g();     // Catch: Throwable -> L17
        Runnable r5 = this.c;     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        if (r4 != 0) goto L20;
        if (r5 == null) goto L21;
        r5.run();
        return;
    L21:
        return;
    L20:
        return;
    L14:
        throw new AssertionError("Call wasn't in-flight!");     // Catch: Throwable -> L17
    }
}
