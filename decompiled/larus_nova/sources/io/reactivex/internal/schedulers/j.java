package io.reactivex.internal.schedulers;

import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class j extends Scheduler {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final RxThreadFactory f494992c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ScheduledExecutorService f494993d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadFactory f494994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<ScheduledExecutorService> f494995b;

    public static final class a extends Scheduler.Worker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ScheduledExecutorService f494996a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CompositeDisposable f494997b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f494998c;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.f494998c == true) goto L6;
            this.f494998c = true;
            this.f494997b.dispose();
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494998c;
        }

        public a(ScheduledExecutorService r100) {
            this.f494996a = r100;
            this.f494997b = new CompositeDisposable();
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable r100, long r101, TimeUnit r102) {
            if (this.f494998c == true) goto L5;
            ScheduledRunnable r103 = new ScheduledRunnable(RxJavaPlugins.onSchedule(r100), this.f494997b);
            this.f494997b.add(r103);
            if (r101 > 0) goto L9;
            Future<?> r104 = this.f494996a.submit(r103);     // Catch: RejectedExecutionException -> L12
        L10:
            r103.setFuture(r104);     // Catch: RejectedExecutionException -> L12
            return r103;
        L9:
            r104 = this.f494996a.schedule(r103, r101, r102);     // Catch: RejectedExecutionException -> L12
        L12:
            e = move-exception;
            dispose();
            RxJavaPlugins.onError(e);
            return EmptyDisposable.INSTANCE;
        L5:
            return EmptyDisposable.INSTANCE;
        }
    }

    @Override // io.reactivex.Scheduler
    public final void start() {
        ScheduledExecutorService r100 = null;
    L3:
        ScheduledExecutorService r101 = this.f494995b.get();
        if (r101 != f494993d) goto L5;
        if (r100 != null) goto L10;
        r100 = i.a(this.f494994a);
    L10:
        AtomicReference<ScheduledExecutorService> r102 = this.f494995b;
    L12:
        if (r102.compareAndSet(r101, r100) == true) goto L13;
        if (r102.get() == r101) goto L12;
        boolean r103 = false;
    L17:
        if (r103 == false) goto L3;
        return;
    L13:
        r103 = true;
        goto L17
    L5:
        if (r100 == null) goto L27;
        r100.shutdown();
        return;
    }

    static {
        ScheduledExecutorService r100 = PThreadExecutorsUtils.newScheduledThreadPool(0, new DefaultThreadFactory("SingleScheduler"));
        f494993d = r100;
        r100.shutdown();
        f494992c = new RxThreadFactory("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public j() {
        this(f494992c);
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return new a(this.f494995b.get());
    }

    @Override // io.reactivex.Scheduler
    public final void shutdown() {
        ScheduledExecutorService r100 = this.f494995b.get();
        ScheduledExecutorService r101 = f494993d;
        if (r100 == r101) goto L8;
        ScheduledExecutorService r102 = this.f494995b.getAndSet(r101);
        if (r102 == r101) goto L9;
        r102.shutdownNow();
        return;
    L9:
        return;
    }

    public j(ThreadFactory r100) {
        AtomicReference<ScheduledExecutorService> r101 = new AtomicReference();
        this.f494995b = r101;
        this.f494994a = r100;
        r101.lazySet(i.a(r100));
    }

    @Override // io.reactivex.Scheduler
    public final Disposable scheduleDirect(Runnable r100, long r101, TimeUnit r102) {
        ScheduledDirectTask r103 = new ScheduledDirectTask(RxJavaPlugins.onSchedule(r100));
        if (r101 > 0) goto L5;
        Future<?> r104 = this.f494995b.get().submit(r103);     // Catch: RejectedExecutionException -> L8
    L6:
        r103.setFuture(r104);     // Catch: RejectedExecutionException -> L8
        return r103;
    L5:
        r104 = this.f494995b.get().schedule(r103, r101, r102);     // Catch: RejectedExecutionException -> L8
    L8:
        e = move-exception;
        RxJavaPlugins.onError(e);
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.Scheduler
    public final Disposable schedulePeriodicallyDirect(Runnable r100, long r110, long r111, TimeUnit r112) {
        Runnable r101 = RxJavaPlugins.onSchedule(r100);
        if (r111 > 0) goto L13;
        ScheduledExecutorService r113 = this.f494995b.get();
        d r114 = new d(r101, r113);
        if (r110 > 0) goto L7;
        Future<?> r102 = r113.submit(r114);     // Catch: RejectedExecutionException -> L10
    L8:
        r114.b(r102);     // Catch: RejectedExecutionException -> L10
        return r114;
    L7:
        r102 = r113.schedule(r114, r110, r112);     // Catch: RejectedExecutionException -> L10
    L10:
        e = move-exception;
        RxJavaPlugins.onError(e);
        return EmptyDisposable.INSTANCE;
    L13:
        ScheduledDirectPeriodicTask r103 = new ScheduledDirectPeriodicTask(r101);
        r103.setFuture(this.f494995b.get().scheduleAtFixedRate(r103, r110, r111, r112));     // Catch: RejectedExecutionException -> L16
        return r103;
    L16:
        e = move-exception;
        RxJavaPlugins.onError(e);
        return EmptyDisposable.INSTANCE;
    }
}
