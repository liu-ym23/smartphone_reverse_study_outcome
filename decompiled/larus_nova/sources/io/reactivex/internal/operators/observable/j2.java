package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes41.dex */
public final class j2<T, U extends Collection<? super T>> extends io.reactivex.internal.operators.observable.a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Callable<U> f494410b;

    public static final class a<T, U extends Collection<? super T>> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super U> f494411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Disposable f494412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public U f494413c;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f494412b.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494412b.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            U r100 = this.f494413c;
            this.f494413c = null;
            this.f494411a.onNext(r100);
            this.f494411a.onComplete();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            this.f494413c = null;
            this.f494411a.onError(r100);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            this.f494413c.add(r100);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494412b, r100) == false) goto L6;
            this.f494412b = r100;
            this.f494411a.onSubscribe(this);
            return;
        }

        public a(Observer<? super U> r100, U r101) {
            this.f494411a = r100;
            this.f494413c = r101;
        }
    }

    public j2(ObservableSource r100) {
        super(r100);
        this.f494410b = Functions.createArrayList(16);
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super U> r100) {
        Collection r101 = (Collection) ObjectHelper.requireNonNull(this.f494410b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");     // Catch: Throwable -> L5
        this.f494245a.subscribe(new a(r100, r101));
        return;
    L5:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r100);
    }

    public j2(ObservableSource<T> r100, Callable<U> r101) {
        super(r100);
        this.f494410b = r101;
    }
}
