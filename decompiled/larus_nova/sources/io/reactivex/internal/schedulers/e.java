package io.reactivex.internal.schedulers;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class e extends Scheduler {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final RxThreadFactory f494965c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final RxThreadFactory f494966d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f494967e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final TimeUnit f494968f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f494969g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f494970h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadFactory f494971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicReference<a> f494972b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f494973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ConcurrentLinkedQueue<c> f494974b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final CompositeDisposable f494975c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ScheduledExecutorService f494976d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Future<?> f494977e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ThreadFactory f494978f;

        public final void a() {
            this.f494975c.dispose();
            Future<?> r100 = this.f494977e;
            if (r100 == null) goto L5;
            r100.cancel(true);
        L5:
            ScheduledExecutorService r101 = this.f494976d;
            if (r101 == null) goto L9;
            r101.shutdownNow();
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
        L13:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L26;
            throw th;
        L26:
            return;
        L3:
            if (this.f494974b.isEmpty() == true) goto L16;
            long r100 = System.nanoTime();     // Catch: Throwable -> L13
            Iterator<c> r101 = this.f494974b.iterator();     // Catch: Throwable -> L13
        L6:
            if (r101.hasNext() == false) goto L27;
            c r102 = r101.next();     // Catch: Throwable -> L13
            if (r102.f494983c > r100) goto L28;
            if (this.f494974b.remove(r102) == false) goto L6;
            this.f494975c.remove(r102);     // Catch: Throwable -> L13
            goto L6
        L28:
            return;
        L27:
            return;
        }

        public a(long r100, TimeUnit r110, ThreadFactory r111) {
            if (r110 == null) goto L5;
            long r101 = r110.toNanos(r100);
        L6:
            long r102 = r101;
            this.f494973a = r102;
            this.f494974b = new ConcurrentLinkedQueue();
            this.f494975c = new CompositeDisposable();
            this.f494978f = r111;
            if (r110 == null) goto L9;
            ScheduledExecutorService r103 = PThreadExecutorsUtils.newScheduledThreadPool(1, e.f494966d);
            ScheduledFuture<?> r104 = r103.scheduleWithFixedDelay(this, r102, r102, TimeUnit.NANOSECONDS);
        L10:
            this.f494976d = r103;
            this.f494977e = r104;
            return;
        L9:
            r103 = null;
            r104 = null;
            goto L10
        L5:
            r101 = 0;
            goto L6
        }
    }

    public static final class b extends Scheduler.Worker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CompositeDisposable f494979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f494980b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f494981c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicBoolean f494982d;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.f494982d.compareAndSet(false, true) == false) goto L6;
            this.f494979a.dispose();
            a r100 = this.f494980b;
            c r101 = this.f494981c;
            r100.getClass();
            r101.f494983c = System.nanoTime() + r100.f494973a;
            r100.f494974b.offer(r101);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494982d.get();
        }

        public b(a r100) {
            this.f494982d = new AtomicBoolean();
            this.f494980b = r100;
            this.f494979a = new CompositeDisposable();
            if (r100.f494975c.isDisposed() == false) goto L6;
            c r101 = e.f494969g;
        L12:
            this.f494981c = r101;
            return;
        L6:
            if (r100.f494974b.isEmpty() == true) goto L10;
            c r102 = r100.f494974b.poll();
            if (r102 == null) goto L6;
        L11:
            r101 = r102;
            goto L12
        L10:
            r102 = new c(r100.f494978f);
            r100.f494975c.add(r102);
            goto L11
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable r100, long r101, TimeUnit r110) {
            if (this.f494979a.isDisposed() == false) goto L7;
            return EmptyDisposable.INSTANCE;
        L7:
            return this.f494981c.b(r100, r101, r110, this.f494979a);
        }
    }

    public static final class c extends g {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f494983c;

        public c(ThreadFactory r100) {
            super(r100);
            this.f494983c = 0;
        }
    }

    static {
        f494968f = TimeUnit.SECONDS;
        f494967e = Long.getLong("rx2.io-keep-alive-time", 60).longValue();
        c r100 = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        f494969g = r100;
        r100.dispose();
        int r101 = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        RxThreadFactory r102 = new RxThreadFactory("RxCachedThreadScheduler", r101);
        f494965c = r102;
        f494966d = new RxThreadFactory("RxCachedWorkerPoolEvictor", r101);
        a r103 = new a(0, null, r102);
        f494970h = r103;
        r103.a();
    }

    public e() {
        this(f494965c);
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return new b(this.f494972b.get());
    }

    @Override // io.reactivex.Scheduler
    public final void shutdown() {
    L2:
        a r100 = this.f494972b.get();
        a r101 = f494970h;
        if (r100 == r101) goto L4;
        AtomicReference<a> r102 = this.f494972b;
    L7:
        if (r102.compareAndSet(r100, r101) == true) goto L8;
        if (r102.get() == r100) goto L7;
        boolean r103 = false;
    L12:
        if (r103 == false) goto L2;
        r100.a();
        return;
    L8:
        r103 = true;
        goto L12
    }

    @Override // io.reactivex.Scheduler
    public final void start() {
        a r100 = new a(f494967e, f494968f, this.f494971a);
        AtomicReference<a> r101 = this.f494972b;
        a r102 = f494970h;
    L4:
        if (r101.compareAndSet(r102, r100) == true) goto L5;
        if (r101.get() == r102) goto L4;
        boolean r103 = false;
    L9:
        if (r103 == true) goto L15;
        r100.a();
        return;
    L15:
        return;
    L5:
        r103 = true;
        goto L9
    }

    public e(ThreadFactory r100) {
        this.f494971a = r100;
        this.f494972b = new AtomicReference(f494970h);
        start();
    }
}
