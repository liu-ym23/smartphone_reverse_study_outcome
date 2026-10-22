package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes41.dex */
public final class q0<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    public static final class a<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super T> f494607a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Disposable f494608b;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f494608b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494608b.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.f494607a.onComplete();
        }

        public a(Observer<? super T> r100) {
            this.f494607a = r100;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            this.f494607a.onError(r100);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            this.f494607a.onNext(r100);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494608b, r100) == false) goto L6;
            this.f494608b = r100;
            this.f494607a.onSubscribe(this);
            return;
        }
    }

    public q0(ObservableSource<T> r100) {
        super(r100);
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        this.f494245a.subscribe(new a(r100));
    }
}
