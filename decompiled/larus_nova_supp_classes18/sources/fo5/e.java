package fo5;

import com.larksuite.framework.thread.n;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.schedulers.ScheduledDirectPeriodicTask;
import io.reactivex.internal.schedulers.ScheduledDirectTask;
import io.reactivex.internal.schedulers.ScheduledRunnable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e extends Scheduler {
    public static final n c = null;
    public static final ScheduledExecutorService d = null;
    public final ThreadFactory a;
    public final AtomicReference<ScheduledExecutorService> b;

    public static class a implements Callable<Void>, Disposable {
        public static final FutureTask<Void> f = null;
        public final Runnable a;
        public final AtomicReference<Future<?>> b;
        public final AtomicReference<Future<?>> c;
        public final ExecutorService d;
        public Thread e;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public Void call2() throws Exception {
            this.e = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L25
            this.a.run();     // Catch: Throwable -> L21
            Future<?> r1 = this.d.submit(this);     // Catch: Throwable -> L21
        L5:
            Future<?> r2 = this.b.get();     // Catch: Throwable -> L21
            boolean r4 = true;
            if (r2 == f) goto L8;
        L12:
            AtomicReference<Future<?>> r3 = this.b;     // Catch: Throwable -> L21
        L14:
            if (r3.compareAndSet(r2, r1) == true) goto L19;
            if (r3.get() == r2) goto L14;
            r4 = false;
        L19:
            if (r4 == false) goto L5;
        L23:
            this.e = null;
            return null;
        L8:
            if (this.e == ThreadMethodProxy.currentThread()) goto L10;
            boolean r5 = true;
        L11:
            r1.cancel(r5);     // Catch: Throwable -> L21
            goto L12
        L10:
            r5 = false;
            goto L11
        L21:
            th = move-exception;
            RxJavaPlugins.onError(th);     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            this.e = null;
            throw th;
        }

        static {
            f = new FutureTask(Functions.EMPTY_RUNNABLE, null);
        }

        public final void dispose() {
            AtomicReference<Future<?>> r0 = this.c;
            FutureTask<Void> r1 = f;
            Future<?> r2 = r0.getAndSet(r1);
            boolean r3 = true;
            if (r2 == null) goto L10;
            if (r2 == r1) goto L10;
            if (this.e == ThreadMethodProxy.currentThread()) goto L8;
            boolean r4 = true;
        L9:
            r2.cancel(r4);
            goto L10
        L8:
            r4 = false;
        L10:
            Future<?> r5 = this.b.getAndSet(r1);
            if (r5 == null) goto L19;
            if (r5 != r1) goto L14;
            return;
        L14:
            if (this.e != ThreadMethodProxy.currentThread()) goto L17;
            r3 = false;
        L17:
            r5.cancel(r3);
            return;
        }

        public final boolean isDisposed() {
            if (this.c.get() != f) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Void call() throws Exception {
            return call2();
        }

        public a(Runnable r1, ExecutorService r2) {
            this.a = r1;
            this.c = new AtomicReference();
            this.b = new AtomicReference();
            this.d = r2;
        }
    }

    public static final class b extends Scheduler.Worker {
        public final ScheduledExecutorService a;
        public final CompositeDisposable b;
        public volatile boolean c;

        public final void dispose() {
            if (this.c == true) goto L6;
            this.c = true;
            this.b.dispose();
            return;
        }

        public final boolean isDisposed() {
            return this.c;
        }

        public b(ScheduledExecutorService r1) {
            this.a = r1;
            this.b = new CompositeDisposable();
        }

        public final Disposable schedule(Runnable r4, long r5, TimeUnit r7) {
            if (this.c == true) goto L5;
            ScheduledRunnable r0 = new ScheduledRunnable(RxJavaPlugins.onSchedule(r4), this.b);
            this.b.add(r0);
            if (r5 > 0) goto L9;
            Future r6 = this.a.submit(r0);     // Catch: RejectedExecutionException -> L12
        L10:
            r0.setFuture(r6);     // Catch: RejectedExecutionException -> L12
            return r0;
        L9:
            r6 = this.a.schedule(r0, r5, r7);     // Catch: RejectedExecutionException -> L12
        L12:
            e = move-exception;
            dispose();
            RxJavaPlugins.onError(e);
            return EmptyDisposable.INSTANCE;
        L5:
            return EmptyDisposable.INSTANCE;
        }
    }

    public final void start() {
        ScheduledExecutorService r0 = null;
    L3:
        ScheduledExecutorService r1 = this.b.get();
        if (r1 != d) goto L5;
        boolean r2 = true;
        if (r0 != null) goto L11;
        r0 = PThreadExecutorsUtils.newScheduledThreadPool(1, this.a);
    L11:
        AtomicReference<ScheduledExecutorService> r3 = this.b;
    L13:
        if (r3.compareAndSet(r1, r0) == true) goto L18;
        if (r3.get() == r1) goto L13;
        r2 = false;
    L18:
        if (r2 == false) goto L3;
        return;
    L5:
        if (r0 == null) goto L27;
        r0.shutdown();
        return;
    }

    static {
        ScheduledExecutorService r0 = PThreadExecutorsUtils.newScheduledThreadPool(0, new DefaultThreadFactory("RxSingleTaskScheduler"));
        d = r0;
        r0.shutdown();
        c = new n("lark-rxjava-single");
    }

    public e() {
        n r0 = c;
        AtomicReference<ScheduledExecutorService> r1 = new AtomicReference();
        this.b = r1;
        this.a = r0;
        r1.lazySet(PThreadExecutorsUtils.newScheduledThreadPool(1, r0));
    }

    public final Scheduler.Worker createWorker() {
        return new b(this.b.get());
    }

    public final void shutdown() {
        ScheduledExecutorService r0 = this.b.get();
        ScheduledExecutorService r1 = d;
        if (r0 == r1) goto L8;
        ScheduledExecutorService r2 = this.b.getAndSet(r1);
        if (r2 == r1) goto L9;
        r2.shutdownNow();
        return;
    L9:
        return;
    }

    public final Disposable scheduleDirect(Runnable r4, long r5, TimeUnit r7) {
        ScheduledDirectTask r0 = new ScheduledDirectTask(RxJavaPlugins.onSchedule(r4));
        if (r5 > 0) goto L5;
        Future r6 = this.b.get().submit(r0);     // Catch: RejectedExecutionException -> L8
    L6:
        r0.setFuture(r6);     // Catch: RejectedExecutionException -> L8
        return r0;
    L5:
        r6 = this.b.get().schedule(r0, r5, r7);     // Catch: RejectedExecutionException -> L8
    L8:
        e = move-exception;
        RxJavaPlugins.onError(e);
        return EmptyDisposable.INSTANCE;
    }

    public final Disposable schedulePeriodicallyDirect(Runnable r9, long r10, long r12, TimeUnit r14) {
        Runnable r11 = RxJavaPlugins.onSchedule(r9);
        if (r12 > 0) goto L27;
        ScheduledExecutorService r13 = this.b.get();
        a r15 = new a(r11, r13);
        if (r10 > 0) goto L7;
        Future<?> r16 = r13.submit(r15);     // Catch: RejectedExecutionException -> L24
    L8:
        Future<?> r17 = r15.c.get();     // Catch: RejectedExecutionException -> L24
        boolean r18 = true;
        if (r17 == a.f) goto L11;
    L15:
        AtomicReference<Future<?>> r19 = r15.c;     // Catch: RejectedExecutionException -> L24
    L17:
        if (r19.compareAndSet(r17, r16) == true) goto L22;
        if (r19.get() == r17) goto L17;
        r18 = false;
    L22:
        if (r18 == false) goto L8;
        return r15;
    L11:
        if (r15.e == ThreadMethodProxy.currentThread()) goto L13;
        boolean r110 = true;
    L14:
        r16.cancel(r110);     // Catch: RejectedExecutionException -> L24
        goto L15
    L13:
        r110 = false;
        goto L14
    L7:
        r16 = r13.schedule(r15, r10, r14);     // Catch: RejectedExecutionException -> L24
    L24:
        e = move-exception;
        RxJavaPlugins.onError(e);
        return EmptyDisposable.INSTANCE;
    L27:
        Runnable r7 = new ScheduledDirectPeriodicTask(r11);
        r7.setFuture(this.b.get().scheduleAtFixedRate(r7, r10, r12, r14));     // Catch: RejectedExecutionException -> L30
        return r7;
    L30:
        e = move-exception;
        RxJavaPlugins.onError(e);
        return EmptyDisposable.INSTANCE;
    }
}
