package io.reactivex.internal.schedulers;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public final class ExecutorScheduler extends Scheduler {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Scheduler f494914c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f494915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f494916b;

    public static final class DelayedRunnable extends AtomicReference<Runnable> implements Runnable, Disposable {
        private static final long serialVersionUID = -4101336210206799084L;
        final SequentialDisposable direct;
        final SequentialDisposable timed;

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (getAndSet(null) == null) goto L6;
            this.timed.dispose();
            this.direct.dispose();
            return;
        }

        @Override // java.lang.Runnable
        public void run() {
            io_reactivex_internal_schedulers_ExecutorScheduler$DelayedRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public Runnable getWrappedRunnable() {
            Runnable r100 = get();
            if (r100 == null) goto L6;
            return r100;
        L6:
            return Functions.EMPTY_RUNNABLE;
        }

        public void io_reactivex_internal_schedulers_ExecutorScheduler$DelayedRunnable__run$___twin___() {
            Runnable r100 = get();
            if (r100 != null) goto L11;
            return;
        L11:
            r100.run();     // Catch: Throwable -> L7
            lazySet(null);
            SequentialDisposable r101 = this.timed;
            DisposableHelper r102 = DisposableHelper.DISPOSED;
            r101.lazySet(r102);
            this.direct.lazySet(r102);
            return;
        L7:
            th = move-exception;
            lazySet(null);
            this.timed.lazySet(DisposableHelper.DISPOSED);
            this.direct.lazySet(DisposableHelper.DISPOSED);
            throw th;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (get() != null) goto L5;
            return true;
        L5:
            return false;
        }

        public DelayedRunnable(Runnable r100) {
            super(r100);
            this.timed = new SequentialDisposable();
            this.direct = new SequentialDisposable();
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void io_reactivex_internal_schedulers_ExecutorScheduler$DelayedRunnable_com_larus_apm_impl_protector_RunnableLancet_run(DelayedRunnable r100) {
            r100.io_reactivex_internal_schedulers_ExecutorScheduler$DelayedRunnable__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class ExecutorWorker extends Scheduler.Worker implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f494917a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f494918b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final MpscLinkedQueue<Runnable> f494919c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile boolean f494920d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicInteger f494921e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final CompositeDisposable f494922f;

        public static final class BooleanRunnable extends AtomicBoolean implements Runnable, Disposable {
            private static final long serialVersionUID = -2421395018820541164L;
            final Runnable actual;

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
                lazySet(true);
            }

            @Override // java.lang.Runnable
            public void run() {
                io_reactivex_internal_schedulers_ExecutorScheduler$ExecutorWorker$BooleanRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            public void io_reactivex_internal_schedulers_ExecutorScheduler$ExecutorWorker$BooleanRunnable__run$___twin___() {
                if (get() == false) goto L12;
                return;
            L12:
                this.actual.run();     // Catch: Throwable -> L9
                lazySet(true);
                return;
            L9:
                th = move-exception;
                lazySet(true);
                throw th;
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                return get();
            }

            public BooleanRunnable(Runnable r100) {
                this.actual = r100;
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void io_reactivex_internal_schedulers_ExecutorScheduler$ExecutorWorker$BooleanRunnable_com_larus_apm_impl_protector_RunnableLancet_run(BooleanRunnable r100) {
                r100.io_reactivex_internal_schedulers_ExecutorScheduler$ExecutorWorker$BooleanRunnable__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static final class InterruptibleRunnable extends AtomicInteger implements Runnable, Disposable {
            static final int FINISHED = 2;
            static final int INTERRUPTED = 4;
            static final int INTERRUPTING = 3;
            static final int READY = 0;
            static final int RUNNING = 1;
            private static final long serialVersionUID = -3603436687413320876L;
            final Runnable run;
            final utc.a tasks;
            volatile Thread thread;

            @Override // java.lang.Runnable
            public void run() {
                io_reactivex_internal_schedulers_ExecutorScheduler$ExecutorWorker$InterruptibleRunnable_com_larus_apm_impl_protector_RunnableLancet_run(this);
            }

            public void cleanup() {
                utc.a r100 = this.tasks;
                if (r100 == null) goto L6;
                r100.delete(this);
                return;
            }

            @Override // io.reactivex.disposables.Disposable
            public void dispose() {
            L2:
                int r100 = get();
                if (r100 >= 2) goto L26;
                if (r100 == 0) goto L8;
                if (compareAndSet(1, 3) == false) goto L2;
                Thread r101 = this.thread;
                if (r101 == null) goto L15;
                r101.interrupt();
                this.thread = null;
            L15:
                set(4);
                cleanup();
                return;
            L8:
                if (compareAndSet(0, 4) == false) goto L2;
                cleanup();
                return;
            }

            public void io_reactivex_internal_schedulers_ExecutorScheduler$ExecutorWorker$InterruptibleRunnable__run$___twin___() {
                if (get() != 0) goto L30;
                this.thread = ThreadMethodProxy.currentThread();
                if (compareAndSet(0, 1) == true) goto L26;
                this.thread = null;
                return;
            L26:
                this.run.run();     // Catch: Throwable -> L15
                this.thread = null;
                if (compareAndSet(1, 2) == false) goto L12;
                cleanup();
                return;
            L12:
                if (get() != 3) goto L14;
                Thread.yield();
                goto L12
            L14:
                Thread.interrupted();
                return;
            L15:
                th = move-exception;
                this.thread = null;
                if (compareAndSet(1, 2) == false) goto L19;
                cleanup();
            L23:
                throw th;
            L19:
                if (get() != 3) goto L21;
                Thread.yield();
                goto L19
            L21:
                Thread.interrupted();
                goto L23
            }

            @Override // io.reactivex.disposables.Disposable
            public boolean isDisposed() {
                if (get() < 2) goto L5;
                return true;
            L5:
                return false;
            }

            @Skip({"com.ss.android.ugc.bytex.pthread+"})
            public static void io_reactivex_internal_schedulers_ExecutorScheduler$ExecutorWorker$InterruptibleRunnable_com_larus_apm_impl_protector_RunnableLancet_run(InterruptibleRunnable r100) {
                r100.io_reactivex_internal_schedulers_ExecutorScheduler$ExecutorWorker$InterruptibleRunnable__run$___twin___();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public InterruptibleRunnable(Runnable r100, utc.a r101) {
                this.run = r100;
                this.tasks = r101;
            }
        }

        public final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final SequentialDisposable f494923a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Runnable f494924b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ExecutorWorker f494925c;

            @Override // java.lang.Runnable
            public final void run() {
                this.f494923a.replace(this.f494925c.schedule(this.f494924b));     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(ExecutorWorker r100, SequentialDisposable r101, Runnable r102) {
                this.f494925c = r100;
                this.f494923a = r101;
                this.f494924b = r102;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.f494920d == true) goto L8;
            this.f494920d = true;
            this.f494922f.dispose();
            if (this.f494921e.getAndIncrement() != 0) goto L9;
            this.f494919c.clear();
            return;
        L9:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MpscLinkedQueue<Runnable> r100 = this.f494919c;     // Catch: Throwable -> L18
            int r101 = 1;
        L4:
            if (this.f494920d == true) goto L5;
        L6:
            Runnable r102 = r100.poll();     // Catch: Throwable -> L18
            if (r102 == null) goto L9;
            r102.run();     // Catch: Throwable -> L18
            if (this.f494920d == false) goto L6;
            r100.clear();     // Catch: Throwable -> L18
        L23:
            return;
        L9:
            if (this.f494920d == true) goto L10;
            r101 = this.f494921e.addAndGet(-r101);     // Catch: Throwable -> L18
            if (r101 != 0) goto L4;
        L10:
            r100.clear();     // Catch: Throwable -> L18
            goto L23
        L5:
            r100.clear();     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L33;
            throw th;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494920d;
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable r100) {
            if (this.f494920d == true) goto L5;
            Runnable r101 = RxJavaPlugins.onSchedule(r100);
            if (this.f494917a == false) goto L9;
            Disposable r102 = new InterruptibleRunnable(r101, this.f494922f);
            this.f494922f.add(r102);
        L10:
            this.f494919c.offer(r102);
            if (this.f494921e.getAndIncrement() == 0) goto L18;
        L17:
            return r102;
        L18:
            this.f494918b.execute(this);     // Catch: RejectedExecutionException -> L14
        L14:
            e = move-exception;
            this.f494920d = true;
            this.f494919c.clear();
            RxJavaPlugins.onError(e);
            return EmptyDisposable.INSTANCE;
        L9:
            r102 = new BooleanRunnable(r101);
            goto L10
        L5:
            return EmptyDisposable.INSTANCE;
        }

        public ExecutorWorker(Executor r100, boolean r101) {
            this.f494921e = new AtomicInteger();
            this.f494922f = new CompositeDisposable();
            this.f494918b = r100;
            this.f494919c = new MpscLinkedQueue();
            this.f494917a = r101;
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable r100, long r101, TimeUnit r102) {
            if (r101 > 0) goto L7;
            return schedule(r100);
        L7:
            if (this.f494920d == true) goto L9;
            SequentialDisposable r103 = new SequentialDisposable();
            SequentialDisposable r104 = new SequentialDisposable(r103);
            ScheduledRunnable r105 = new ScheduledRunnable(new a(this, r104, RxJavaPlugins.onSchedule(r100)), this.f494922f);
            this.f494922f.add(r105);
            Executor r106 = this.f494918b;
            if ((r106 instanceof ScheduledExecutorService) == true) goto L20;
            r105.setFuture(new b(ExecutorScheduler.f494914c.scheduleDirect(r105, r101, r102)));
        L18:
            r103.replace(r105);
            return r104;
        L20:
            r105.setFuture(((ScheduledExecutorService) r106).schedule(r105, r101, r102));     // Catch: RejectedExecutionException -> L14
        L14:
            e = move-exception;
            this.f494920d = true;
            RxJavaPlugins.onError(e);
            return EmptyDisposable.INSTANCE;
        L9:
            return EmptyDisposable.INSTANCE;
        }
    }

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DelayedRunnable f494926a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ExecutorScheduler f494927b;

        @Override // java.lang.Runnable
        public final void run() {
            DelayedRunnable r100 = this.f494926a;     // Catch: Throwable -> L4
            r100.direct.replace(this.f494927b.scheduleDirect(r100));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(ExecutorScheduler r100, DelayedRunnable r101) {
            this.f494927b = r100;
            this.f494926a = r101;
        }
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return new ExecutorWorker(this.f494916b, this.f494915a);
    }

    static {
        f494914c = Schedulers.single();
    }

    @Override // io.reactivex.Scheduler
    public final Disposable scheduleDirect(Runnable r100) {
        Runnable r101 = RxJavaPlugins.onSchedule(r100);
    L13:
        e = move-exception;
        RxJavaPlugins.onError(e);
        return EmptyDisposable.INSTANCE;
    L4:
        if ((this.f494916b instanceof ExecutorService) == false) goto L8;
        ScheduledDirectTask r102 = new ScheduledDirectTask(r101);     // Catch: RejectedExecutionException -> L13
        r102.setFuture(((ExecutorService) this.f494916b).submit(r102));     // Catch: RejectedExecutionException -> L13
        return r102;
    L8:
        if (this.f494915a == false) goto L11;
        ExecutorWorker.InterruptibleRunnable r103 = new ExecutorWorker.InterruptibleRunnable(r101, null);     // Catch: RejectedExecutionException -> L13
        this.f494916b.execute(r103);     // Catch: RejectedExecutionException -> L13
        return r103;
    L11:
        ExecutorWorker.BooleanRunnable r104 = new ExecutorWorker.BooleanRunnable(r101);     // Catch: RejectedExecutionException -> L13
        this.f494916b.execute(r104);     // Catch: RejectedExecutionException -> L13
        return r104;
    }

    public ExecutorScheduler(Executor r100, boolean r101) {
        this.f494916b = r100;
        this.f494915a = r101;
    }

    @Override // io.reactivex.Scheduler
    public final Disposable scheduleDirect(Runnable r100, long r101, TimeUnit r102) {
        Runnable r103 = RxJavaPlugins.onSchedule(r100);
        if ((this.f494916b instanceof ScheduledExecutorService) == true) goto L11;
        DelayedRunnable r104 = new DelayedRunnable(r103);
        Disposable r105 = f494914c.scheduleDirect(new a(this, r104), r101, r102);
        r104.timed.replace(r105);
        return r104;
    L11:
        ScheduledDirectTask r106 = new ScheduledDirectTask(r103);     // Catch: RejectedExecutionException -> L6
        r106.setFuture(((ScheduledExecutorService) this.f494916b).schedule(r106, r101, r102));     // Catch: RejectedExecutionException -> L6
        return r106;
    L6:
        e = move-exception;
        RxJavaPlugins.onError(e);
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.Scheduler
    public final Disposable schedulePeriodicallyDirect(Runnable r100, long r110, long r111, TimeUnit r112) {
        if ((this.f494916b instanceof ScheduledExecutorService) == false) goto L11;
        ScheduledDirectPeriodicTask r101 = new ScheduledDirectPeriodicTask(RxJavaPlugins.onSchedule(r100));     // Catch: RejectedExecutionException -> L7
        r101.setFuture(((ScheduledExecutorService) this.f494916b).scheduleAtFixedRate(r101, r110, r111, r112));     // Catch: RejectedExecutionException -> L7
        return r101;
    L7:
        e = move-exception;
        RxJavaPlugins.onError(e);
        return EmptyDisposable.INSTANCE;
    L11:
        return super.schedulePeriodicallyDirect(r100, r110, r111, r112);
    }
}
