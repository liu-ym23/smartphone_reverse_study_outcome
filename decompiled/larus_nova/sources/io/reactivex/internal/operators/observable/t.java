package io.reactivex.internal.operators.observable;

import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes41.dex */
public final class t<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f494646b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f494647c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Scheduler f494648d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f494649e;

    public static final class a<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super T> f494650a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f494651b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TimeUnit f494652c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Scheduler.Worker f494653d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f494654e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Disposable f494655f;

        /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.t$a$a, reason: collision with other inner class name */
        public final class RunnableC6328a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f494656a;

            @Override // java.lang.Runnable
            public final void run() {
                this.f494656a.f494650a.onComplete();     // Catch: Throwable -> L4
                this.f494656a.f494653d.dispose();     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L14;
                throw th;
            L14:
                return;
            L4:
                th = move-exception;
                this.f494656a.f494653d.dispose();     // Catch: Throwable -> L7
                throw th;     // Catch: Throwable -> L7
            }

            public RunnableC6328a(a r100) {
                this.f494656a = r100;
            }
        }

        public final class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Throwable f494657a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f494658b;

            @Override // java.lang.Runnable
            public final void run() {
                this.f494658b.f494650a.onError(this.f494657a);     // Catch: Throwable -> L4
                this.f494658b.f494653d.dispose();     // Catch: Throwable -> L7
                return;
            L4:
                th = move-exception;
                this.f494658b.f494653d.dispose();     // Catch: Throwable -> L7
                throw th;     // Catch: Throwable -> L7
            L7:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L14;
                throw th;
            }

            public b(a r100, Throwable r101) {
                this.f494658b = r100;
                this.f494657a = r101;
            }
        }

        public final class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final T f494659a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f494660b;

            @Override // java.lang.Runnable
            public final void run() {
                this.f494660b.f494650a.onNext(this.f494659a);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public c(a r100, T r101) {
                this.f494660b = r100;
                this.f494659a = r101;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f494655f.dispose();
            this.f494653d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494653d.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.f494653d.schedule(new RunnableC6328a(this), this.f494651b, this.f494652c);
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            Scheduler.Worker r101 = this.f494653d;
            b r102 = new b(this, r100);
            if (this.f494654e == false) goto L5;
            long r103 = this.f494651b;
        L6:
            r101.schedule(r102, r103, this.f494652c);
            return;
        L5:
            r103 = 0;
            goto L6
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            this.f494653d.schedule(new c(this, r100), this.f494651b, this.f494652c);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494655f, r100) == false) goto L6;
            this.f494655f = r100;
            this.f494650a.onSubscribe(this);
            return;
        }

        public a(Observer<? super T> r100, long r101, TimeUnit r102, Scheduler.Worker r103, boolean r104) {
            this.f494650a = r100;
            this.f494651b = r101;
            this.f494652c = r102;
            this.f494653d = r103;
            this.f494654e = r104;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        if (this.f494649e == false) goto L5;
        Observer<? super T> r101 = r100;
    L6:
        Scheduler.Worker r102 = this.f494648d.createWorker();
        this.f494245a.subscribe(new a(r101, this.f494646b, this.f494647c, r102, this.f494649e));
        return;
    L5:
        r101 = new io.reactivex.observers.f(r100);
        goto L6
    }

    public t(ObservableSource<T> r100, long r101, TimeUnit r102, Scheduler r103, boolean r104) {
        super(r100);
        this.f494646b = r101;
        this.f494647c = r102;
        this.f494648d = r103;
        this.f494649e = r104;
    }
}
