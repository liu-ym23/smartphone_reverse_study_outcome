package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class MaybeOnErrorNext<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function<? super Throwable, ? extends MaybeSource<? extends T>> f493782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f493783c;

    public static final class OnErrorNextMaybeObserver<T> extends AtomicReference<Disposable> implements io.reactivex.k<T>, Disposable {
        private static final long serialVersionUID = 2026620218879969836L;
        final boolean allowFatal;
        final io.reactivex.k<? super T> downstream;
        final Function<? super Throwable, ? extends MaybeSource<? extends T>> resumeFunction;

        public static final class a<T> implements io.reactivex.k<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final io.reactivex.k<? super T> f493784a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final AtomicReference<Disposable> f493785b;

            @Override // io.reactivex.k
            public final void onComplete() {
                this.f493784a.onComplete();
            }

            @Override // io.reactivex.k
            public final void onError(Throwable r100) {
                this.f493784a.onError(r100);
            }

            @Override // io.reactivex.k
            public final void onSubscribe(Disposable r100) {
                DisposableHelper.setOnce(this.f493785b, r100);
            }

            @Override // io.reactivex.k
            public final void onSuccess(T r100) {
                this.f493784a.onSuccess(r100);
            }

            public a(io.reactivex.k<? super T> r100, AtomicReference<Disposable> r101) {
                this.f493784a = r100;
                this.f493785b = r101;
            }
        }

        @Override // io.reactivex.k
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.k
        public void onError(Throwable r100) {
            if (this.allowFatal == false) goto L5;
        L14:
            MaybeSource r101 = (MaybeSource) ObjectHelper.requireNonNull(this.resumeFunction.apply(r100), "The resumeFunction returned a null MaybeSource");     // Catch: Throwable -> L11
            DisposableHelper.replace(this, null);
            r101.subscribe(new a(this.downstream, this));
            return;
        L11:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(new CompositeException(new Throwable[]{r100, th}));
            return;
        L5:
            if ((r100 instanceof Exception) == true) goto L14;
            this.downstream.onError(r100);
        }

        @Override // io.reactivex.k
        public void onSubscribe(Disposable r100) {
            if (DisposableHelper.setOnce(this, r100) == false) goto L6;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.k
        public void onSuccess(T r100) {
            this.downstream.onSuccess(r100);
        }

        public OnErrorNextMaybeObserver(io.reactivex.k<? super T> r100, Function<? super Throwable, ? extends MaybeSource<? extends T>> r101, boolean r102) {
            this.downstream = r100;
            this.resumeFunction = r101;
            this.allowFatal = r102;
        }
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(io.reactivex.k<? super T> r100) {
        this.f493817a.subscribe(new OnErrorNextMaybeObserver(r100, this.f493782b, this.f493783c));
    }

    public MaybeOnErrorNext(MaybeSource<T> r100, Function<? super Throwable, ? extends MaybeSource<? extends T>> r101, boolean r102) {
        super(r100);
        this.f493782b = r101;
        this.f493783c = r102;
    }
}
