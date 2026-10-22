package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes41.dex */
public final class p<T> extends io.reactivex.internal.operators.observable.a<T, Long> {

    public static final class a implements Observer<Object>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super Long> f494589a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Disposable f494590b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f494591c;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f494590b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494590b.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.f494589a.onNext(Long.valueOf(this.f494591c));
            this.f494589a.onComplete();
        }

        public a(Observer<? super Long> r100) {
            this.f494589a = r100;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            this.f494589a.onError(r100);
        }

        @Override // io.reactivex.Observer
        public final void onNext(Object r100) {
            this.f494591c++;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494590b, r100) == false) goto L6;
            this.f494590b = r100;
            this.f494589a.onSubscribe(this);
            return;
        }
    }

    public p(ObservableSource<T> r100) {
        super(r100);
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super Long> r100) {
        this.f494245a.subscribe(new a(r100));
    }
}
