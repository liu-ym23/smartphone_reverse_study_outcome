package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class r<T, U> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function<? super T, ? extends ObservableSource<U>> f494617b;

    public static final class a<T, U> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super T> f494618a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<U>> f494619b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Disposable f494620c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicReference<Disposable> f494621d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile long f494622e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f494623f;

        /* JADX INFO: renamed from: io.reactivex.internal.operators.observable.r$a$a, reason: collision with other inner class name */
        public static final class C6327a<T, U> extends io.reactivex.observers.c<U> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final a<T, U> f494624b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final long f494625c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final T f494626d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public boolean f494627e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final AtomicBoolean f494628f;

            public final void b() {
                if (this.f494628f.compareAndSet(false, true) == false) goto L8;
                a<T, U> r100 = this.f494624b;
                long r101 = this.f494625c;
                T r102 = this.f494626d;
                if (r101 != r100.f494622e) goto L9;
                r100.f494618a.onNext(r102);
                return;
            L9:
                return;
            }

            @Override // io.reactivex.Observer
            public final void onComplete() {
                if (this.f494627e == false) goto L5;
                return;
            L5:
                this.f494627e = true;
                b();
            }

            @Override // io.reactivex.Observer
            public final void onError(Throwable r100) {
                if (this.f494627e == false) goto L6;
                RxJavaPlugins.onError(r100);
                return;
            L6:
                this.f494627e = true;
                this.f494624b.onError(r100);
            }

            @Override // io.reactivex.Observer
            public final void onNext(U r100) {
                if (this.f494627e == false) goto L5;
                return;
            L5:
                this.f494627e = true;
                dispose();
                b();
            }

            public C6327a(a<T, U> r100, long r101, T r102) {
                this.f494628f = new AtomicBoolean();
                this.f494624b = r100;
                this.f494625c = r101;
                this.f494626d = r102;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f494620c.dispose();
            DisposableHelper.dispose(this.f494621d);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494620c.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.f494623f == false) goto L5;
            return;
        L5:
            this.f494623f = true;
            Disposable r100 = this.f494621d.get();
            if (r100 == DisposableHelper.DISPOSED) goto L9;
            ((C6327a) r100).b();
            DisposableHelper.dispose(this.f494621d);
            this.f494618a.onComplete();
            return;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            DisposableHelper.dispose(this.f494621d);
            this.f494618a.onError(r100);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            if (this.f494623f == false) goto L5;
            return;
        L5:
            long r101 = this.f494622e + 1;
            this.f494622e = r101;
            Disposable r102 = this.f494621d.get();
            if (r102 == null) goto L22;
            r102.dispose();
        L22:
            ObservableSource r103 = (ObservableSource) ObjectHelper.requireNonNull(this.f494619b.apply(r100), "The ObservableSource supplied is null");     // Catch: Throwable -> L19
            C6327a r104 = new C6327a(this, r101, r100);
            AtomicReference<Disposable> r105 = this.f494621d;
        L11:
            if (r105.compareAndSet(r102, r104) == true) goto L12;
            if (r105.get() == r102) goto L11;
            boolean r106 = false;
        L16:
            if (r106 == false) goto L27;
            r103.subscribe(r104);
            return;
        L27:
            return;
        L12:
            r106 = true;
        L19:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            dispose();
            this.f494618a.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494620c, r100) == false) goto L6;
            this.f494620c = r100;
            this.f494618a.onSubscribe(this);
            return;
        }

        public a(io.reactivex.observers.f r100, Function r101) {
            this.f494621d = new AtomicReference();
            this.f494618a = r100;
            this.f494619b = r101;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        this.f494245a.subscribe(new a(new io.reactivex.observers.f(r100), this.f494617b));
    }

    public r(ObservableSource<T> r100, Function<? super T, ? extends ObservableSource<U>> r101) {
        super(r100);
        this.f494617b = r101;
    }
}
