package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes41.dex */
public final class f2<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    public static final class a<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super T> f494352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Disposable f494353b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public T f494354c;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f494354c = null;
            this.f494353b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494353b.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            T r100 = this.f494354c;
            if (r100 == null) goto L5;
            this.f494354c = null;
            this.f494352a.onNext(r100);
        L5:
            this.f494352a.onComplete();
        }

        public a(Observer<? super T> r100) {
            this.f494352a = r100;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            this.f494354c = null;
            this.f494352a.onError(r100);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            this.f494354c = r100;
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494353b, r100) == false) goto L6;
            this.f494353b = r100;
            this.f494352a.onSubscribe(this);
            return;
        }
    }

    public f2(ObservableSource<T> r100) {
        super(r100);
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        this.f494245a.subscribe(new a(r100));
    }
}
