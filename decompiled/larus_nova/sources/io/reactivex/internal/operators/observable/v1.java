package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;

/* JADX INFO: loaded from: classes41.dex */
public final class v1<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BiFunction<T, T, T> f494691b;

    public static final class a<T> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super T> f494692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BiFunction<T, T, T> f494693b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Disposable f494694c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public T f494695d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f494696e;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f494694c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494694c.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            if (this.f494696e == false) goto L5;
            return;
        L5:
            this.f494696e = true;
            this.f494692a.onComplete();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            if (this.f494696e == false) goto L6;
            RxJavaPlugins.onError(r100);
            return;
        L6:
            this.f494696e = true;
            this.f494692a.onError(r100);
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.Object] */
        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            if (this.f494696e == false) goto L5;
            return;
        L5:
            Observer<? super T> r101 = this.f494692a;
            T r102 = this.f494695d;
            if (r102 != null) goto L14;
            this.f494695d = r100;
            r101.onNext(r100);
            return;
        L14:
            ?? r103 = (T) ObjectHelper.requireNonNull(this.f494693b.apply(r102, r100), "The value returned by the accumulator is null");
            this.f494695d = r103;
            r101.onNext(r103);
            return;
        L11:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f494694c.dispose();
            onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494694c, r100) == false) goto L6;
            this.f494694c = r100;
            this.f494692a.onSubscribe(this);
            return;
        }

        public a(Observer<? super T> r100, BiFunction<T, T, T> r101) {
            this.f494692a = r100;
            this.f494693b = r101;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        this.f494245a.subscribe(new a(r100, this.f494691b));
    }

    public v1(ObservableSource<T> r100, BiFunction<T, T, T> r101) {
        super(r100);
        this.f494691b = r101;
    }
}
