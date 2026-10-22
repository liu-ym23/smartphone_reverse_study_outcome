package b28;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.toast.LKUIToast;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import java.io.InterruptedIOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a {
    public int a;
    public int b;
    public Runnable c;
    public ExecutorService d;
    public final Deque<b.C0005b> e;
    public final Deque<b.C0005b> f;
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
        byte[] r8 = cvc.c.a;     // Catch: Throwable -> L9
        this.d = new PThreadPoolExecutor(0, LKUIToast.DURATION_MAX, 60, r6, r7, new cvc.d("OkHttp Dispatcher", false));     // Catch: Throwable -> L9
    L6:
        ExecutorService r0 = this.d;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    }

    public final synchronized int g() {
        monitor-enter(this);
        int r0 = this.f.size() + this.g.size();
        monitor-exit(this);
        return r0;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [b28.b$b, java.lang.Object, java.lang.Runnable] */
    public final boolean f() {
        ArrayList r0 = new ArrayList();
        monitor-enter(this);
        Iterator r1 = ((ArrayDeque) this.e).iterator();     // Catch: Throwable -> L19
    L5:
        int r3 = 0;
        if (r1.hasNext() == false) goto L26;
        b.C0005b r2 = (b.C0005b) r1.next();     // Catch: Throwable -> L19
        if (((ArrayDeque) this.f).size() >= this.a) goto L26;
        Iterator r4 = ((ArrayDeque) this.f).iterator();     // Catch: Throwable -> L19
    L12:
        if (r4.hasNext() == false) goto L22;
        b r5 = ((b.C0005b) r4.next()).c;     // Catch: Throwable -> L19
        if (r5.d == true) goto L12;
        if (r5.e.url().host().equals(r2.c.e.url().host()) == false) goto L12;
        r3 = r3 + 1;     // Catch: Throwable -> L19
        goto L12
    L22:
        if (r3 >= this.b) goto L5;
        r1.remove();     // Catch: Throwable -> L19
        r0.add(r2);     // Catch: Throwable -> L19
        ((ArrayDeque) this.f).add(r2);     // Catch: Throwable -> L19
    L26:
        if (g() <= 0) goto L28;
        boolean r6 = true;
    L29:
        monitor-exit(this);     // Catch: Throwable -> L19
        int r7 = r0.size();
    L31:
        if (r3 >= r7) goto L43;
        ?? r8 = (b.C0005b) ListProtector.get(r0, r3);
        ExecutorService r9 = c();
        r8.getClass();
        r9.execute(r8);     // Catch: Throwable -> L35 RejectedExecutionException -> L37
    L40:
        r3 = r3 + 1;
    L37:
        e = move-exception;
        InterruptedIOException r10 = new InterruptedIOException("executor rejected");     // Catch: Throwable -> L35
        r10.initCause(e);     // Catch: Throwable -> L35
        r8.c.c.callFailed(r8.c, r10);     // Catch: Throwable -> L35
        r8.b.onFailure(r8.c, r10);     // Catch: Throwable -> L35
        r8.c.g.d().d(r8);
    L35:
        th = move-exception;
        r8.c.g.d().d(r8);
        throw th;
    L43:
        return r6;
    L28:
        r6 = false;
    L19:
        th = move-exception;
        throw th;
    }

    public a() {
        this.a = 64;
        this.b = 5;
        this.e = new ArrayDeque();
        this.f = new ArrayDeque();
        this.g = new ArrayDeque();
    }

    static {
    }

    public a(ExecutorService r2) {
        this.a = 64;
        this.b = 5;
        this.e = new ArrayDeque();
        this.f = new ArrayDeque();
        this.g = new ArrayDeque();
        this.d = r2;
    }

    public final void a(b.C0005b r2) {
        monitor-enter(this);
        ((ArrayDeque) this.e).add(r2);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        f();
        return;
    L7:
        th = move-exception;
        throw th;
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

    public final void d(b.C0005b r2) {
        e(this.f, r2);
    }

    public final synchronized void h(Runnable r1) {
        monitor-enter(this);
        this.c = r1;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void i(int r4) {
        if (r4 < 1) goto L13;
        monitor-enter(this);
        this.b = r4;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        f();
        return;
    L9:
        th = move-exception;
        throw th;
    L13:
        throw new IllegalArgumentException("max < 1: " + r4);
    }

    public final <T> void e(Deque<T> r1, T r2) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (r1.remove(r2) == false) goto L13;
        Runnable r3 = this.c;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        if (f() == true) goto L18;
        if (r3 == null) goto L19;
        r3.run();
        return;
    L19:
        return;
    L18:
        return;
    L13:
        throw new AssertionError("Call wasn't in-flight!");     // Catch: Throwable -> L14
    }
}
