package com.bytedance.lottie;

import android.os.Handler;
import android.os.Looper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes21.dex */
public final class q<T> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final com.bytedance.platform.thread.c f264581g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f264582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<l<T>> f264583b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<l<Throwable>> f264584c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f264585d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FutureTask<o<T>> f264586e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile o<T> f264587f;

    public class a extends PthreadThreadV2 {

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public boolean f264588v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final /* synthetic */ q f264589w;

        public final void l() {
        L3:
            if (isInterrupted() == true) goto L16;
            if (this.f264588v == true) goto L24;
            if (this.f264589w.f264586e.isDone() == false) goto L3;
            q r100 = this.f264589w;     // Catch: ExecutionException -> L11 Throwable -> L13
            q.a(r100, r100.f264586e.get());     // Catch: ExecutionException -> L11 Throwable -> L13
        L15:
            this.f264588v = true;
            this.f264589w.f();
        L13:
            e = move-exception;
            q.a(this.f264589w, new o(e));
            goto L15
        L24:
            return;
        }

        @Override // com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2, java.lang.Thread, java.lang.Runnable
        public final void run() {
            l();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(q r100) {
            this.f264589w = r100;
            super("LottieTaskObserver");
            this.f264588v = false;
        }
    }

    public q() {
        throw null;
    }

    public final synchronized void e() {
        monitor-enter(this);
        a r100 = this.f264582a;     // Catch: Throwable -> L16
        if (r100 != null) goto L6;
    L8:
        boolean r101 = false;
    L9:
        if (r101 == false) goto L11;
    L18:
        monitor-exit(this);
        return;
    L11:
        if (this.f264587f != null) goto L18;
        a r102 = new a(this);     // Catch: Throwable -> L16
        this.f264582a = r102;     // Catch: Throwable -> L16
        ThreadMethodProxy.start(r102);     // Catch: Throwable -> L16
        Set<String> r103 = c.f264422a;     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L6:
        if (ThreadMethodProxy.isAlive(r100) == false) goto L8;
        r101 = true;
    L16:
        th = move-exception;
        throw th;
    }

    public final synchronized void f() {
        monitor-enter(this);
        a r100 = this.f264582a;     // Catch: Throwable -> L19
        if (r100 != null) goto L6;
    L8:
        boolean r101 = false;
    L9:
        if (r101 == true) goto L13;
        monitor-exit(this);
        return;
    L13:
        if (this.f264583b.isEmpty() == false) goto L15;
    L16:
        this.f264582a.interrupt();     // Catch: Throwable -> L19
        this.f264582a = null;     // Catch: Throwable -> L19
        Set<String> r102 = c.f264422a;     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);
        return;
    L15:
        if (this.f264587f == null) goto L17;
    L6:
        if (ThreadMethodProxy.isAlive(r100) == false) goto L8;
        r101 = true;
    L19:
        th = move-exception;
        throw th;
    }

    static {
        if (com.bytedance.platform.thread.d.f266634c == null) goto L5;
    L14:
        f264581g = com.bytedance.platform.thread.d.f266634c;
        return;
    L5:
        monitor-enter(com.bytedance.platform.thread.d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (com.bytedance.platform.thread.d.f266634c != null) goto L9;
        com.bytedance.platform.thread.d.f266634c = new com.bytedance.platform.thread.c(TimeUnit.SECONDS, new SynchronousQueue(), new com.bytedance.platform.thread.a(com.bytedance.platform.thread.d.f266633b), com.bytedance.platform.thread.d.f266632a);     // Catch: Throwable -> L11
    L9:
        monitor-exit(com.bytedance.platform.thread.d.class);     // Catch: Throwable -> L11
        goto L14
    }

    public q(Callable<o<T>> r100) {
        this.f264583b = new LinkedHashSet(1);
        this.f264584c = new LinkedHashSet(1);
        this.f264585d = new Handler(Looper.getMainLooper());
        this.f264587f = null;
        FutureTask<o<T>> r101 = new FutureTask(r100);
        this.f264586e = r101;
        f264581g.execute(r101);
        e();
    }

    private void setResult(o<T> r100) {
        if (this.f264587f != null) goto L7;
        this.f264587f = r100;
        this.f264585d.post(new p(this));
        return;
    L7:
        throw new IllegalStateException("A task may only be set once.");
    }

    public final synchronized void b(l r100) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f264587f != null) goto L6;
    L8:
        this.f264584c.add(r100);     // Catch: Throwable -> L11
        e();     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L6:
        if (this.f264587f.f264579b == null) goto L8;
        r100.onResult(this.f264587f.f264579b);     // Catch: Throwable -> L11
        goto L8
    }

    public final synchronized void c(l r100) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f264587f != null) goto L6;
    L8:
        this.f264583b.add(r100);     // Catch: Throwable -> L11
        e();     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L6:
        if (this.f264587f.f264578a == null) goto L8;
        r100.onResult(this.f264587f.f264578a);     // Catch: Throwable -> L11
        goto L8
    }

    public final synchronized void d(l r100) {
        monitor-enter(this);
        this.f264584c.remove(r100);     // Catch: Throwable -> L6
        f();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void a(q r100, o r101) {
        r100.setResult(r101);
    }
}
