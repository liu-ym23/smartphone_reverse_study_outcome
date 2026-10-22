package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes41.dex */
public final class x<T, K> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function<? super T, K> f494708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Callable<? extends Collection<? super K>> f494709c;

    public static final class a<T, K> extends io.reactivex.internal.observers.a<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Collection<? super K> f494710f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Function<? super T, K> f494711g;

        @Override // io.reactivex.internal.observers.a, vtc.j
        public final void clear() {
            this.f494710f.clear();
            super.clear();
        }

        @Override // io.reactivex.internal.observers.a, io.reactivex.Observer
        public final void onComplete() {
            if (this.f492870d == true) goto L6;
            this.f492870d = true;
            this.f494710f.clear();
            this.f492867a.onComplete();
            return;
        }

        @Override // vtc.j
        public final T poll() throws Exception {
        L2:
            T r100 = this.f492869c.poll();
            if (r100 == null) goto L6;
            if (this.f494710f.add((Object) ObjectHelper.requireNonNull(this.f494711g.apply(r100), "The keySelector returned a null key")) == false) goto L2;
        L6:
            return r100;
        }

        @Override // io.reactivex.internal.observers.a, io.reactivex.Observer
        public final void onError(Throwable r100) {
            if (this.f492870d == false) goto L5;
            RxJavaPlugins.onError(r100);
            return;
        L5:
            this.f492870d = true;
            this.f494710f.clear();
            this.f492867a.onError(r100);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            if (this.f492870d == false) goto L6;
            return;
        L6:
            if (this.f492871e == 0) goto L15;
            this.f492867a.onNext(null);
            return;
        L15:
            Object r101 = ObjectHelper.requireNonNull(this.f494711g.apply(r100), "The keySelector returned a null key");     // Catch: Throwable -> L10
            if (this.f494710f.add(r101) == false) goto L17;
            this.f492867a.onNext((Object) r100);
            return;
        L17:
            return;
        L10:
            th = move-exception;
            b(th);
        }

        @Override // vtc.f
        public final int requestFusion(int r100) {
            return d(r100);
        }

        public a(Observer<? super T> r100, Function<? super T, K> r101, Collection<? super K> r102) {
            super(r100);
            this.f494711g = r101;
            this.f494710f = r102;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        Collection r101 = (Collection) ObjectHelper.requireNonNull(this.f494709c.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");     // Catch: Throwable -> L5
        this.f494245a.subscribe(new a(r100, this.f494708b, r101));
        return;
    L5:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r100);
    }

    public x(ObservableSource<T> r100, Function<? super T, K> r101, Callable<? extends Collection<? super K>> r102) {
        super(r100);
        this.f494708b = r101;
        this.f494709c = r102;
    }
}
