package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;

/* JADX INFO: loaded from: classes41.dex */
public final class d2<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ObservableSource<? extends T> f494319b;

    public static final class a<T> implements Observer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super T> f494320a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ObservableSource<? extends T> f494321b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SequentialDisposable f494322c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f494323d;

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.f494323d == false) goto L5;
            this.f494323d = false;
            this.f494321b.subscribe(this);
            return;
        L5:
            this.f494320a.onComplete();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            this.f494320a.onError(r100);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            if (this.f494323d == false) goto L5;
            this.f494323d = false;
        L5:
            this.f494320a.onNext(r100);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            this.f494322c.update(r100);
        }

        public a(Observer<? super T> r100, ObservableSource<? extends T> r101) {
            this.f494320a = r100;
            this.f494321b = r101;
            this.f494323d = true;
            this.f494322c = new SequentialDisposable();
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        a r101 = new a(r100, this.f494319b);
        r100.onSubscribe(r101.f494322c);
        this.f494245a.subscribe(r101);
    }

    public d2(ObservableSource<T> r100, ObservableSource<? extends T> r101) {
        super(r100);
        this.f494319b = r101;
    }
}
