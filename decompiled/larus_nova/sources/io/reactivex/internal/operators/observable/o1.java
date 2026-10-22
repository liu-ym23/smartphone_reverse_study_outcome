package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;

/* JADX INFO: loaded from: classes41.dex */
public final class o1<T> extends io.reactivex.internal.operators.observable.a<T, io.reactivex.o<T>> {

    public static final class a<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super io.reactivex.o<T>> f494587a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Disposable f494588b;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f494588b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494588b.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            io.reactivex.o<Object> r100 = io.reactivex.o.f495051b;
            this.f494587a.onNext(r100);
            this.f494587a.onComplete();
        }

        public a(Observer<? super io.reactivex.o<T>> r100) {
            this.f494587a = r100;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            io.reactivex.o r101 = io.reactivex.o.a(r100);
            this.f494587a.onNext(r101);
            this.f494587a.onComplete();
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            Observer<? super io.reactivex.o<T>> r101 = this.f494587a;
            io.reactivex.o<Object> r102 = io.reactivex.o.f495051b;
            ObjectHelper.requireNonNull(r100, "value is null");
            r101.onNext(new io.reactivex.o(r100));
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494588b, r100) == false) goto L6;
            this.f494588b = r100;
            this.f494587a.onSubscribe(this);
            return;
        }
    }

    public o1(ObservableSource<T> r100) {
        super(r100);
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super io.reactivex.o<T>> r100) {
        this.f494245a.subscribe(new a(r100));
    }
}
