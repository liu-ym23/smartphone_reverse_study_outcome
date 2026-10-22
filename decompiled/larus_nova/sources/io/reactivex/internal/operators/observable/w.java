package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EmptyComponent;

/* JADX INFO: loaded from: classes41.dex */
public final class w<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    public static final class a<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Observer<? super T> f494697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Disposable f494698b;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            Disposable r100 = this.f494698b;
            this.f494698b = EmptyComponent.INSTANCE;
            this.f494697a = EmptyComponent.asObserver();
            r100.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494698b.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            Observer<? super T> r100 = this.f494697a;
            this.f494698b = EmptyComponent.INSTANCE;
            this.f494697a = EmptyComponent.asObserver();
            r100.onComplete();
        }

        public a(Observer<? super T> r100) {
            this.f494697a = r100;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            Observer<? super T> r101 = this.f494697a;
            this.f494698b = EmptyComponent.INSTANCE;
            this.f494697a = EmptyComponent.asObserver();
            r101.onError(r100);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            this.f494697a.onNext(r100);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494698b, r100) == false) goto L6;
            this.f494698b = r100;
            this.f494697a.onSubscribe(this);
            return;
        }
    }

    public w(ObservableSource<T> r100) {
        super(r100);
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        this.f494245a.subscribe(new a(r100));
    }
}
