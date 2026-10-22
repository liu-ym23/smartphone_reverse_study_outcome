package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes41.dex */
public class g extends Scheduler.Worker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f494986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f494987b;

    @Override // io.reactivex.disposables.Disposable
    public final void dispose() {
        if (this.f494987b == true) goto L6;
        this.f494987b = true;
        this.f494986a.shutdownNow();
        return;
    }

    @Override // io.reactivex.disposables.Disposable
    public final boolean isDisposed() {
        return this.f494987b;
    }

    public g(ThreadFactory r100) {
        this.f494986a = i.a(r100);
    }

    @Override // io.reactivex.Scheduler.Worker
    public final Disposable schedule(Runnable r100) {
        return schedule(r100, 0, null);
    }

    @Override // io.reactivex.Scheduler.Worker
    public final Disposable schedule(Runnable r100, long r101, TimeUnit r110) {
        if (this.f494987b == false) goto L7;
        return EmptyDisposable.INSTANCE;
    L7:
        return b(r100, r101, r110, null);
    }

    public final ScheduledRunnable b(Runnable r100, long r101, TimeUnit r102, utc.a r103) {
        ScheduledRunnable r104 = new ScheduledRunnable(RxJavaPlugins.onSchedule(r100), r103);
        if (r103 == null) goto L18;
        if (r103.add(r104) == true) goto L18;
        return r104;
    L18:
        if (r101 > 0) goto L10;
        Future<?> r105 = this.f494986a.submit(r104);     // Catch: RejectedExecutionException -> L13
    L11:
        r104.setFuture(r105);     // Catch: RejectedExecutionException -> L13
    L17:
        return r104;
    L10:
        r105 = this.f494986a.schedule(r104, r101, r102);     // Catch: RejectedExecutionException -> L13
    L13:
        e = move-exception;
        if (r103 == null) goto L16;
        r103.remove(r104);
    L16:
        RxJavaPlugins.onError(e);
        goto L17
    }
}
