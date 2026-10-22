package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes41.dex */
public final class n1<T, R> extends io.reactivex.internal.operators.observable.a<T, ObservableSource<? extends R>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function<? super T, ? extends ObservableSource<? extends R>> f494562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function<? super Throwable, ? extends ObservableSource<? extends R>> f494563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Callable<? extends ObservableSource<? extends R>> f494564d;

    public static final class a<T, R> implements Observer<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Observer<? super ObservableSource<? extends R>> f494565a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function<? super T, ? extends ObservableSource<? extends R>> f494566b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function<? super Throwable, ? extends ObservableSource<? extends R>> f494567c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Callable<? extends ObservableSource<? extends R>> f494568d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Disposable f494569e;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f494569e.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f494569e.isDisposed();
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            ObservableSource r100 = (ObservableSource) ObjectHelper.requireNonNull(this.f494568d.call(), "The onComplete ObservableSource returned is null");     // Catch: Throwable -> L5
            this.f494565a.onNext(r100);
            this.f494565a.onComplete();
            return;
        L5:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f494565a.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            this.f494565a.onNext((ObservableSource) ObjectHelper.requireNonNull(this.f494567c.apply(r100), "The onError ObservableSource returned is null"));
            this.f494565a.onComplete();
            return;
        L5:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f494565a.onError(new CompositeException(new Throwable[]{r100, th}));
        }

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            ObservableSource r101 = (ObservableSource) ObjectHelper.requireNonNull(this.f494566b.apply(r100), "The onNext ObservableSource returned is null");     // Catch: Throwable -> L5
            this.f494565a.onNext(r101);
            return;
        L5:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f494565a.onError(th);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f494569e, r100) == false) goto L6;
            this.f494569e = r100;
            this.f494565a.onSubscribe(this);
            return;
        }

        public a(Observer<? super ObservableSource<? extends R>> r100, Function<? super T, ? extends ObservableSource<? extends R>> r101, Function<? super Throwable, ? extends ObservableSource<? extends R>> r102, Callable<? extends ObservableSource<? extends R>> r103) {
            this.f494565a = r100;
            this.f494566b = r101;
            this.f494567c = r102;
            this.f494568d = r103;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super ObservableSource<? extends R>> r100) {
        this.f494245a.subscribe(new a(r100, this.f494562b, this.f494563c, this.f494564d));
    }

    public n1(ObservableSource<T> r100, Function<? super T, ? extends ObservableSource<? extends R>> r101, Function<? super Throwable, ? extends ObservableSource<? extends R>> r102, Callable<? extends ObservableSource<? extends R>> r103) {
        super(r100);
        this.f494562b = r101;
        this.f494563c = r102;
        this.f494564d = r103;
    }
}
