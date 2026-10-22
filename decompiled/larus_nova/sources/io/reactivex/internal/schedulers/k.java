package io.reactivex.internal.schedulers;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes41.dex */
public final class k extends Scheduler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f494999a = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f495000a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f495001b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f495002c;

        @Override // java.lang.Runnable
        public final void run() {
        L16:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L26;
            throw th;
        L26:
            return;
        L3:
            if (this.f495001b.f495010d == true) goto L19;
            long r100 = this.f495001b.now(TimeUnit.MILLISECONDS);     // Catch: Throwable -> L16
            long r101 = this.f495002c;     // Catch: Throwable -> L16
            if (r101 <= r100) goto L13;
            Thread.sleep(r101 - r100);     // Catch: InterruptedException -> L10 Throwable -> L16
        L10:
            e = move-exception;
            ThreadMethodProxy.currentThread().interrupt();     // Catch: Throwable -> L16
            RxJavaPlugins.onError(e);     // Catch: Throwable -> L16
            return;
        L13:
            if (this.f495001b.f495010d == true) goto L25;
            this.f495000a.run();     // Catch: Throwable -> L16
            return;
        L25:
            return;
        }

        public a(Runnable r100, c r101, long r102) {
            this.f495000a = r100;
            this.f495001b = r101;
            this.f495002c = r102;
        }
    }

    public static final class b implements Comparable<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f495003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f495004b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f495005c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile boolean f495006d;

        @Override // java.lang.Comparable
        public final int compareTo(b r100) {
            b r101 = r100;
            int r102 = ObjectHelper.compare(this.f495004b, r101.f495004b);
            if (r102 == 0) goto L5;
            return r102;
        L5:
            return ObjectHelper.compare(this.f495005c, r101.f495005c);
        }

        public b(Runnable r100, Long r101, int r102) {
            this.f495003a = r100;
            this.f495004b = r101.longValue();
            this.f495005c = r102;
        }
    }

    public static final class c extends Scheduler.Worker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PriorityBlockingQueue<b> f495007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicInteger f495008b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicInteger f495009c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile boolean f495010d;

        public final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final b f495011a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ c f495012b;

            @Override // java.lang.Runnable
            public final void run() {
                this.f495011a.f495006d = true;     // Catch: Throwable -> L4
                this.f495012b.f495007a.remove(this.f495011a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public a(c r100, b r101) {
                this.f495012b = r100;
                this.f495011a = r101;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f495010d = true;
        }

        public c() {
            this.f495007a = new PriorityBlockingQueue();
            this.f495008b = new AtomicInteger();
            this.f495009c = new AtomicInteger();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f495010d;
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable r100) {
            return b(r100, now(TimeUnit.MILLISECONDS));
        }

        public final Disposable b(Runnable r100, long r101) {
            if (this.f495010d == true) goto L5;
            b r102 = new b(r100, Long.valueOf(r101), this.f495009c.incrementAndGet());
            this.f495007a.add(r102);
            if (this.f495008b.getAndIncrement() != 0) goto L23;
            int r103 = 1;
        L10:
            if (this.f495010d == true) goto L11;
            b r104 = this.f495007a.poll();
            if (r104 == null) goto L15;
            if (r104.f495006d == true) goto L10;
            r104.f495003a.run();
            goto L10
        L15:
            r103 = this.f495008b.addAndGet(-r103);
            if (r103 != 0) goto L10;
            return EmptyDisposable.INSTANCE;
        L11:
            this.f495007a.clear();
            return EmptyDisposable.INSTANCE;
        L23:
            return Disposables.fromRunnable(new a(this, r102));
        L5:
            return EmptyDisposable.INSTANCE;
        }

        @Override // io.reactivex.Scheduler.Worker
        public final Disposable schedule(Runnable r100, long r101, TimeUnit r102) {
            long r103 = now(TimeUnit.MILLISECONDS) + r102.toMillis(r101);
            return b(new a(r100, this, r103), r103);
        }
    }

    static {
        f494999a = new k();
    }

    @Override // io.reactivex.Scheduler
    public final Scheduler.Worker createWorker() {
        return new c();
    }

    public k() {
    }

    @Override // io.reactivex.Scheduler
    public final Disposable scheduleDirect(Runnable r100) {
        RxJavaPlugins.onSchedule(r100).run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.Scheduler
    public final Disposable scheduleDirect(Runnable r100, long r101, TimeUnit r102) {
        r102.sleep(r101);     // Catch: InterruptedException -> L4
        RxJavaPlugins.onSchedule(r100).run();     // Catch: InterruptedException -> L4
    L7:
        return EmptyDisposable.INSTANCE;
    L4:
        e = move-exception;
        ThreadMethodProxy.currentThread().interrupt();
        RxJavaPlugins.onError(e);
        goto L7
    }
}
