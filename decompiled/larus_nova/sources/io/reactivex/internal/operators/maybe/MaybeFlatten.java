package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class MaybeFlatten<T, R> extends a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function<? super T, ? extends MaybeSource<? extends R>> f493778b;

    public static final class FlatMapMaybeObserver<T, R> extends AtomicReference<Disposable> implements io.reactivex.k<T>, Disposable {
        private static final long serialVersionUID = 4375739915521278546L;
        final io.reactivex.k<? super R> downstream;
        final Function<? super T, ? extends MaybeSource<? extends R>> mapper;
        Disposable upstream;

        public final class a implements io.reactivex.k<R> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ FlatMapMaybeObserver f493779a;

            @Override // io.reactivex.k
            public final void onComplete() {
                this.f493779a.downstream.onComplete();
            }

            public a(FlatMapMaybeObserver r100) {
                this.f493779a = r100;
            }

            @Override // io.reactivex.k
            public final void onError(Throwable r100) {
                this.f493779a.downstream.onError(r100);
            }

            @Override // io.reactivex.k
            public final void onSubscribe(Disposable r100) {
                DisposableHelper.setOnce(this.f493779a, r100);
            }

            @Override // io.reactivex.k
            public final void onSuccess(R r100) {
                this.f493779a.downstream.onSuccess(r100);
            }
        }

        @Override // io.reactivex.k
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.k
        public void onError(Throwable r100) {
            this.downstream.onError(r100);
        }

        @Override // io.reactivex.k
        public void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.upstream, r100) == false) goto L6;
            this.upstream = r100;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.k
        public void onSuccess(T r100) {
            MaybeSource r101 = (MaybeSource) ObjectHelper.requireNonNull(this.mapper.apply(r100), "The mapper returned a null MaybeSource");     // Catch: Exception -> L7
            if (isDisposed() == true) goto L12;
            r101.subscribe(new a(this));
            return;
        L12:
            return;
        L7:
            e = move-exception;
            Exceptions.throwIfFatal(e);
            this.downstream.onError(e);
        }

        public FlatMapMaybeObserver(io.reactivex.k<? super R> r100, Function<? super T, ? extends MaybeSource<? extends R>> r101) {
            this.downstream = r100;
            this.mapper = r101;
        }
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(io.reactivex.k<? super R> r100) {
        this.f493817a.subscribe(new FlatMapMaybeObserver(r100, this.f493778b));
    }

    public MaybeFlatten(MaybeSource<T> r100, Function<? super T, ? extends MaybeSource<? extends R>> r101) {
        super(r100);
        this.f493778b = r101;
    }
}
