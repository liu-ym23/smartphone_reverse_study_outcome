package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class a extends Scheduler {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f494941c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final RxThreadFactory f494942d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f494943e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f494944f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadFactory f494945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<b> f494946b;

    /* JADX INFO: renamed from: io.reactivex.internal.schedulers.a$a, reason: collision with other inner class name */
    public static final class C6333a extends Scheduler.Worker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final utc.b f494947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CompositeDisposable f494948b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final utc.b f494949c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c f494950d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile boolean f494951e;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.f494951e == true) goto L6;
            this.f494951e = true;
            this.f494949c.dispose();
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494951e;
        }

        public C6333a(c r100) {
            this.f494950d = r100;
            utc.b r101 = new utc.b();
            this.f494947a = r101;
            CompositeDisposable r102 = new CompositeDisposable();
            this.f494948b = r102;
            utc.b r103 = new utc.b();
            this.f494949c = r103;
            r103.add(r101);
            r103.add(r102);
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable r100) {
            if (this.f494951e == false) goto L7;
            return EmptyDisposable.INSTANCE;
        L7:
            return this.f494950d.b(r100, 0, TimeUnit.MILLISECONDS, this.f494947a);
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable r100, long r101, TimeUnit r110) {
            if (this.f494951e == false) goto L7;
            return EmptyDisposable.INSTANCE;
        L7:
            return this.f494950d.b(r100, r101, r110, this.f494948b);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f494952a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c[] f494953b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f494954c;

        public final c a() {
            int r100 = this.f494952a;
            if (r100 == 0) goto L5;
            c[] r101 = this.f494953b;
            long r102 = this.f494954c;
            this.f494954c = 1 + r102;
            return r101[(int) (r102 % ((long) r100))];
        L5:
            return a.f494944f;
        }

        public b(int r100, ThreadFactory r101) {
            this.f494952a = r100;
            this.f494953b = new c[r100];
            int r102 = 0;
        L3:
            if (r102 >= r100) goto L5;
            this.f494953b[r102] = new c(r101);
            r102 = r102 + 1;
            goto L3
        }
    }

    public static final class c extends g {
        public c(ThreadFactory r100) {
            super(r100);
        }
    }

    public a() {
        this(f494942d);
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return new C6333a(this.f494946b.get().a());
    }

    @Override // io.reactivex.Scheduler
    public final void shutdown() {
    L2:
        b r100 = this.f494946b.get();
        b r101 = f494941c;
        if (r100 == r101) goto L4;
        AtomicReference<b> r102 = this.f494946b;
    L6:
        int r103 = 0;
        if (r102.compareAndSet(r100, r101) == true) goto L8;
        if (r102.get() == r100) goto L6;
        boolean r104 = false;
    L12:
        if (r104 == false) goto L2;
        c[] r105 = r100.f494953b;
        int r106 = r105.length;
    L14:
        if (r103 >= r106) goto L16;
        r105[r103].dispose();
        r103 = r103 + 1;
        goto L14
    L16:
        return;
    L8:
        r104 = true;
        goto L12
    }

    @Override // io.reactivex.Scheduler
    public final void start() {
        b r100 = new b(f494943e, this.f494945a);
        AtomicReference<b> r101 = this.f494946b;
        b r102 = f494941c;
    L3:
        int r103 = 0;
        if (r101.compareAndSet(r102, r100) == true) goto L5;
        if (r101.get() == r102) goto L3;
        boolean r104 = false;
    L9:
        if (r104 == true) goto L13;
        c[] r105 = r100.f494953b;
        int r106 = r105.length;
    L11:
        if (r103 >= r106) goto L18;
        r105[r103].dispose();
        r103 = r103 + 1;
        goto L11
    L18:
        return;
    L13:
        return;
    L5:
        r104 = true;
        goto L9
    }

    static {
        int r100 = Runtime.getRuntime().availableProcessors();
        int r101 = 0;
        int r102 = Integer.getInteger("rx2.computation-threads", 0).intValue();
        if (r102 <= 0) goto L7;
        if (r102 > r100) goto L7;
        r100 = r102;
    L7:
        f494943e = r100;
        c r103 = new c(new RxThreadFactory("RxComputationShutdown"));
        f494944f = r103;
        r103.dispose();
        RxThreadFactory r104 = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f494942d = r104;
        b r105 = new b(0, r104);
        f494941c = r105;
        c[] r106 = r105.f494953b;
        int r107 = r106.length;
    L8:
        if (r101 >= r107) goto L10;
        r106[r101].dispose();
        r101 = r101 + 1;
        goto L8
    }

    public a(ThreadFactory r100) {
        this.f494945a = r100;
        this.f494946b = new AtomicReference(f494941c);
        start();
    }

    @Override // io.reactivex.Scheduler
    public final Disposable scheduleDirect(Runnable r100, long r101, TimeUnit r102) {
        c r103 = this.f494946b.get().a();
        r103.getClass();
        ScheduledDirectTask r104 = new ScheduledDirectTask(RxJavaPlugins.onSchedule(r100));
        if (r101 > 0) goto L5;
        Future<?> r105 = r103.f494986a.submit(r104);     // Catch: RejectedExecutionException -> L8
    L6:
        r104.setFuture(r105);     // Catch: RejectedExecutionException -> L8
        return r104;
    L5:
        r105 = r103.f494986a.schedule(r104, r101, r102);     // Catch: RejectedExecutionException -> L8
    L8:
        e = move-exception;
        RxJavaPlugins.onError(e);
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.Scheduler
    public final Disposable schedulePeriodicallyDirect(Runnable r100, long r110, long r111, TimeUnit r112) {
        c r101 = this.f494946b.get().a();
        r101.getClass();
        Runnable r102 = RxJavaPlugins.onSchedule(r100);
        if (r111 > 0) goto L12;
        d r113 = new d(r102, r101.f494986a);
        if (r110 > 0) goto L7;
        Future<?> r103 = r101.f494986a.submit(r113);     // Catch: RejectedExecutionException -> L10
    L8:
        r113.b(r103);     // Catch: RejectedExecutionException -> L10
        return r113;
    L7:
        r103 = r101.f494986a.schedule(r113, r110, r112);     // Catch: RejectedExecutionException -> L10
    L10:
        e = move-exception;
        RxJavaPlugins.onError(e);
        return EmptyDisposable.INSTANCE;
    L12:
        ScheduledDirectPeriodicTask r104 = new ScheduledDirectPeriodicTask(r102);
        r104.setFuture(r101.f494986a.scheduleAtFixedRate(r104, r110, r111, r112));     // Catch: RejectedExecutionException -> L15
        return r104;
    L15:
        e = move-exception;
        RxJavaPlugins.onError(e);
        return EmptyDisposable.INSTANCE;
    }
}
