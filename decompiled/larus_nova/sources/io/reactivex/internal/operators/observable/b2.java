package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes41.dex */
public final class b2<T, U> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ObservableSource<U> f494269b;

    public final class a implements Observer<U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayCompositeDisposable f494270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b<T> f494271b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final io.reactivex.observers.f<T> f494272c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Disposable f494273d;

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.f494271b.f494277d = true;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            this.f494270a.dispose();
            this.f494272c.onError(r100);
        }

        @Override // io.reactivex.Observer
        public final void onNext(U r100) {
            this.f494273d.dispose();
            this.f494271b.f494277d = true;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494273d, r100) == false) goto L6;
            this.f494273d = r100;
            this.f494270a.setResource(1, r100);
            return;
        }

        public a(ArrayCompositeDisposable r100, b r101, io.reactivex.observers.f r102) {
            this.f494270a = r100;
            this.f494271b = r101;
            this.f494272c = r102;
        }
    }

    public static final class b<T> implements Observer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super T> f494274a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayCompositeDisposable f494275b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Disposable f494276c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile boolean f494277d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f494278e;

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.f494275b.dispose();
            this.f494274a.onComplete();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            this.f494275b.dispose();
            this.f494274a.onError(r100);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            if (this.f494278e == false) goto L6;
            this.f494274a.onNext(r100);
            return;
        L6:
            if (this.f494277d == false) goto L10;
            this.f494278e = true;
            this.f494274a.onNext(r100);
            return;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494276c, r100) == false) goto L6;
            this.f494276c = r100;
            this.f494275b.setResource(0, r100);
            return;
        }

        public b(io.reactivex.observers.f r100, ArrayCompositeDisposable r101) {
            this.f494274a = r100;
            this.f494275b = r101;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        io.reactivex.observers.f r101 = new io.reactivex.observers.f(r100);
        ArrayCompositeDisposable r102 = new ArrayCompositeDisposable(2);
        r101.onSubscribe(r102);
        b r103 = new b(r101, r102);
        this.f494269b.subscribe(new a(r102, r103, r101));
        this.f494245a.subscribe(r103);
    }

    public b2(ObservableSource<T> r100, ObservableSource<U> r101) {
        super(r100);
        this.f494269b = r101;
    }
}
