package io.reactivex.internal.schedulers;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class d implements Callable<Void>, Disposable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final FutureTask<Void> f494959f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f494960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<Future<?>> f494961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<Future<?>> f494962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ExecutorService f494963d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Thread f494964e;

    static {
        f494959f = new FutureTask(Functions.EMPTY_RUNNABLE, null);
    }

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        AtomicReference<Future<?>> r100 = this.f494962c;
        FutureTask<Void> r101 = f494959f;
        Future<?> r102 = r100.getAndSet(r101);
        boolean r103 = true;
        if (r102 == null) goto L10;
        if (r102 == r101) goto L10;
        if (this.f494964e == ThreadMethodProxy.currentThread()) goto L8;
        boolean r104 = true;
    L9:
        r102.cancel(r104);
        goto L10
    L8:
        r104 = false;
    L10:
        Future<?> r105 = this.f494961b.getAndSet(r101);
        if (r105 == null) goto L19;
        if (r105 != r101) goto L14;
        return;
    L14:
        if (this.f494964e != ThreadMethodProxy.currentThread()) goto L17;
        r103 = false;
    L17:
        r105.cancel(r103);
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        if (this.f494962c.get() != f494959f) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public Void call2() throws Exception {
        this.f494964e = ThreadMethodProxy.currentThread();
        this.f494960a.run();     // Catch: Throwable -> L21
        Future<?> r100 = this.f494963d.submit(this);     // Catch: Throwable -> L21
    L4:
        Future<?> r101 = this.f494961b.get();     // Catch: Throwable -> L21
        boolean r102 = true;
        if (r101 == f494959f) goto L7;
        AtomicReference<Future<?>> r103 = this.f494961b;     // Catch: Throwable -> L21
    L13:
        if (r103.compareAndSet(r101, r100) == true) goto L18;
        if (r103.get() == r101) goto L13;
        r102 = false;
    L18:
        if (r102 == false) goto L4;
    L19:
        this.f494964e = null;     // Catch: Throwable -> L21
    L23:
        return null;
    L7:
        if (this.f494964e != ThreadMethodProxy.currentThread()) goto L10;
        r102 = false;
    L10:
        r100.cancel(r102);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        this.f494964e = null;
        RxJavaPlugins.onError(th);
        goto L23
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Void call() throws Exception {
        return call2();
    }

    public final void b(Future<?> r100) {
    L2:
        Future<?> r101 = this.f494962c.get();
        boolean r102 = false;
        if (r101 == f494959f) goto L5;
        AtomicReference<Future<?>> r103 = this.f494962c;
    L11:
        if (r103.compareAndSet(r101, r100) == true) goto L12;
        if (r103.get() == r101) goto L11;
    L15:
        if (r102 == false) goto L2;
        return;
    L12:
        r102 = true;
        goto L15
    L5:
        if (this.f494964e == ThreadMethodProxy.currentThread()) goto L7;
        r102 = true;
    L7:
        r100.cancel(r102);
    }

    public d(Runnable r100, ExecutorService r101) {
        this.f494960a = r100;
        this.f494962c = new AtomicReference();
        this.f494961b = new AtomicReference();
        this.f494963d = r101;
    }
}
