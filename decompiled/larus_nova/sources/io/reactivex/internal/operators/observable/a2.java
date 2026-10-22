package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX INFO: loaded from: classes41.dex */
public final class a2<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f494258b;

    public static final class a<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super T> f494259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f494260b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Disposable f494261c;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f494261c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494261c.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.f494259a.onComplete();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            this.f494259a.onError(r100);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            long r101 = this.f494260b;
            if (r101 == 0) goto L5;
            this.f494260b = r101 - 1;
            return;
        L5:
            this.f494259a.onNext(r100);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494261c, r100) == false) goto L6;
            this.f494261c = r100;
            this.f494259a.onSubscribe(this);
            return;
        }

        public a(Observer<? super T> r100, long r101) {
            this.f494259a = r100;
            this.f494260b = r101;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        this.f494245a.subscribe(new a(r100, this.f494258b));
    }

    public a2(ObservableSource<T> r100, long r101) {
        super(r100);
        this.f494258b = r101;
    }
}
