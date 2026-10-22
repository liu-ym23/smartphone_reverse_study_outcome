package io.reactivex;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.schedulers.SchedulerWhen;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes41.dex */
public abstract class Scheduler {
    static final long CLOCK_DRIFT_TOLERANCE_NANOSECONDS = 0;

    public static abstract class Worker implements Disposable {

        public final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Runnable f492817a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final SequentialDisposable f492818b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final long f492819c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public long f492820d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public long f492821e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public long f492822f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ Worker f492823g;

            public final void a() {
                this.f492817a.run();
                if (this.f492818b.isDisposed() == true) goto L13;
                Worker r100 = this.f492823g;
                TimeUnit r101 = TimeUnit.NANOSECONDS;
                long r102 = r100.now(r101);
                long r103 = Scheduler.CLOCK_DRIFT_TOLERANCE_NANOSECONDS;
                long r104 = r102 + r103;
                long r105 = this.f492821e;
                if (r104 < r105) goto L10;
                long r106 = this.f492819c;
                if (r102 >= ((r105 + r106) + r103)) goto L10;
                long r107 = this.f492822f;
                long r108 = this.f492820d + 1;
                this.f492820d = r108;
                long r109 = r107 + (r108 * r106);
            L11:
                this.f492821e = r102;
                long r110 = r109 - r102;
                this.f492818b.replace(this.f492823g.schedule(this, r110, r101));
                return;
            L10:
                long r111 = this.f492819c;
                long r112 = r102 + r111;
                long r113 = this.f492820d + 1;
                this.f492820d = r113;
                this.f492822f = r112 - (r111 * r113);
                r109 = r112;
                goto L11
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(Worker r100, long r101, Runnable r102, long r103, SequentialDisposable r104, long r105) {
                this.f492823g = r100;
                this.f492817a = r102;
                this.f492818b = r104;
                this.f492819c = r105;
                this.f492821e = r103;
                this.f492822f = r101;
            }
        }

        public Worker() {
        }

        public abstract Disposable schedule(Runnable r100, long r101, TimeUnit r102);

        public long now(TimeUnit r100) {
            return r100.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        public Disposable schedule(Runnable r100) {
            return schedule(r100, 0, TimeUnit.NANOSECONDS);
        }

        public Disposable schedulePeriodically(Runnable r110, long r111, long r210, TimeUnit r211) {
            SequentialDisposable r112 = new SequentialDisposable();
            SequentialDisposable r113 = new SequentialDisposable(r112);
            Runnable r100 = RxJavaPlugins.onSchedule(r110);
            long r101 = r211.toNanos(r210);
            long r102 = now(TimeUnit.NANOSECONDS);
            Disposable r103 = schedule(new a(this, r102 + r211.toNanos(r111), r100, r102, r113, r101), r111, r211);
            if (r103 != EmptyDisposable.INSTANCE) goto L5;
            return r103;
        L5:
            r112.replace(r103);
            return r113;
        }
    }

    public static final class a implements Disposable, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f492824a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Worker f492825b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Thread f492826c;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            if (this.f492826c != ThreadMethodProxy.currentThread()) goto L9;
            Worker r100 = this.f492825b;
            if ((r100 instanceof io.reactivex.internal.schedulers.g) == false) goto L9;
            io.reactivex.internal.schedulers.g r101 = (io.reactivex.internal.schedulers.g) r100;
            if (r101.f494987b == true) goto L11;
            r101.f494987b = true;
            r101.f494986a.shutdown();
            return;
        L11:
            return;
        L9:
            this.f492825b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f492825b.isDisposed();
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f492826c = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L9
            this.f492824a.run();     // Catch: Throwable -> L6
            dispose();     // Catch: Throwable -> L9
            this.f492826c = null;     // Catch: Throwable -> L9
            return;
        L6:
            th = move-exception;
            dispose();     // Catch: Throwable -> L9
            this.f492826c = null;     // Catch: Throwable -> L9
            throw th;     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }

        public a(Runnable r100, Worker r101) {
            this.f492824a = r100;
            this.f492825b = r101;
        }
    }

    public static final class b implements Disposable, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f492827a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Worker f492828b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f492829c;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f492829c = true;
            this.f492828b.dispose();
        }

        @Override // java.lang.Runnable
        public final void run() {
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        L17:
            return;
        L3:
            if (this.f492829c == false) goto L15;
            return;
        L15:
            this.f492827a.run();     // Catch: Throwable -> L6
        L18:
            return;
        L6:
            th = move-exception;
            Exceptions.throwIfFatal(th);     // Catch: Throwable -> L9
            this.f492828b.dispose();     // Catch: Throwable -> L9
            throw ExceptionHelper.d(th);     // Catch: Throwable -> L9
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f492829c;
        }

        public b(Runnable r100, Worker r101) {
            this.f492827a = r100;
            this.f492828b = r101;
        }
    }

    public Scheduler() {
    }

    public abstract Worker createWorker();

    public void shutdown() {
    }

    public void start() {
    }

    static {
        CLOCK_DRIFT_TOLERANCE_NANOSECONDS = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());
    }

    public static long clockDriftTolerance() {
        return CLOCK_DRIFT_TOLERANCE_NANOSECONDS;
    }

    public long now(TimeUnit r100) {
        return r100.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public Disposable scheduleDirect(Runnable r100) {
        return scheduleDirect(r100, 0, TimeUnit.NANOSECONDS);
    }

    public <S extends Scheduler & Disposable> S when(Function<Flowable<Flowable<Completable>>, Completable> r100) {
        return new SchedulerWhen(r100, this);
    }

    public Disposable scheduleDirect(Runnable r100, long r101, TimeUnit r102) {
        Worker r103 = createWorker();
        a r104 = new a(RxJavaPlugins.onSchedule(r100), r103);
        r103.schedule(r104, r101, r102);
        return r104;
    }

    public Disposable schedulePeriodicallyDirect(Runnable r100, long r110, long r111, TimeUnit r112) {
        Worker r101 = createWorker();
        b r102 = new b(RxJavaPlugins.onSchedule(r100), r101);
        Disposable r103 = r101.schedulePeriodically(r102, r110, r111, r112);
        if (r103 != EmptyDisposable.INSTANCE) goto L5;
        return r103;
    L5:
        return r102;
    }
}
