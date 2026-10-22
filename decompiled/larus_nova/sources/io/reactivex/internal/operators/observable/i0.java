package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Iterator;

/* JADX INFO: loaded from: classes41.dex */
public final class i0<T, R> extends io.reactivex.internal.operators.observable.a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function<? super T, ? extends Iterable<? extends R>> f494388b;

    public static final class a<T, R> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super R> f494389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function<? super T, ? extends Iterable<? extends R>> f494390b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Disposable f494391c;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f494391c.dispose();
            this.f494391c = DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494391c.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            Disposable r100 = this.f494391c;
            DisposableHelper r101 = DisposableHelper.DISPOSED;
            if (r100 != r101) goto L5;
            return;
        L5:
            this.f494391c = r101;
            this.f494389a.onComplete();
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            Disposable r101 = this.f494391c;
            DisposableHelper r102 = DisposableHelper.DISPOSED;
            if (r101 != r102) goto L6;
            RxJavaPlugins.onError(r100);
            return;
        L6:
            this.f494391c = r102;
            this.f494389a.onError(r100);
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            if (this.f494391c != DisposableHelper.DISPOSED) goto L20;
            return;
        L20:
            Iterator<? extends R> r101 = this.f494390b.apply(r100).iterator();     // Catch: Throwable -> L17
            Observer<? super R> r102 = this.f494389a;
        L22:
            if (r101.hasNext() == false) goto L27;
            r102.onNext((Object) ObjectHelper.requireNonNull(r101.next(), "The iterator returned a null value"));
        L11:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f494391c.dispose();
            onError(th);
            return;
        L27:
            return;
        L14:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f494391c.dispose();
            onError(th);
            return;
        L17:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f494391c.dispose();
            onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494391c, r100) == false) goto L6;
            this.f494391c = r100;
            this.f494389a.onSubscribe(this);
            return;
        }

        public a(Observer<? super R> r100, Function<? super T, ? extends Iterable<? extends R>> r101) {
            this.f494389a = r100;
            this.f494390b = r101;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super R> r100) {
        this.f494245a.subscribe(new a(r100, this.f494388b));
    }

    public i0(ObservableSource<T> r100, Function<? super T, ? extends Iterable<? extends R>> r101) {
        super(r100);
        this.f494388b = r101;
    }
}
