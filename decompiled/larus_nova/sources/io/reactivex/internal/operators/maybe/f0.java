package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;

/* JADX INFO: loaded from: classes41.dex */
public final class f0<T> extends io.reactivex.internal.operators.maybe.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function<? super Throwable, ? extends T> f493845b;

    public static final class a<T> implements io.reactivex.k<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final io.reactivex.k<? super T> f493846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function<? super Throwable, ? extends T> f493847b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Disposable f493848c;

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            this.f493848c.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return this.f493848c.isDisposed();
        }

        @Override // io.reactivex.k
        public final void onComplete() {
            this.f493846a.onComplete();
        }

        @Override // io.reactivex.k
        public final void onError(Throwable r100) {
            this.f493846a.onSuccess(ObjectHelper.requireNonNull(this.f493847b.apply(r100), "The valueSupplier returned a null value"));
            return;
        L5:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f493846a.onError(new CompositeException(new Throwable[]{r100, th}));
        }

        @Override // io.reactivex.k
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.f493848c, r100) == false) goto L6;
            this.f493848c = r100;
            this.f493846a.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.k
        public final void onSuccess(T r100) {
            this.f493846a.onSuccess(r100);
        }

        public a(io.reactivex.k<? super T> r100, Function<? super Throwable, ? extends T> r101) {
            this.f493846a = r100;
            this.f493847b = r101;
        }
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(io.reactivex.k<? super T> r100) {
        this.f493817a.subscribe(new a(r100, this.f493845b));
    }

    public f0(MaybeSource<T> r100, Function<? super Throwable, ? extends T> r101) {
        super(r100);
        this.f493845b = r101;
    }
}
