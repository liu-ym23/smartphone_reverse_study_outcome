package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class MaybeFlatMapBiSelector<T, U, R> extends a<T, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function<? super T, ? extends MaybeSource<? extends U>> f493758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BiFunction<? super T, ? super U, ? extends R> f493759c;

    public static final class FlatMapBiMainObserver<T, U, R> implements io.reactivex.k<T>, Disposable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function<? super T, ? extends MaybeSource<? extends U>> f493760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InnerObserver<T, U, R> f493761b;

        public static final class InnerObserver<T, U, R> extends AtomicReference<Disposable> implements io.reactivex.k<U> {
            private static final long serialVersionUID = -2897979525538174559L;
            final io.reactivex.k<? super R> downstream;
            final BiFunction<? super T, ? super U, ? extends R> resultSelector;
            T value;

            @Override // io.reactivex.k
            public void onComplete() {
                this.downstream.onComplete();
            }

            @Override // io.reactivex.k
            public void onError(Throwable r100) {
                this.downstream.onError(r100);
            }

            @Override // io.reactivex.k
            public void onSubscribe(Disposable r100) {
                DisposableHelper.setOnce(this, r100);
            }

            @Override // io.reactivex.k
            public void onSuccess(U r100) {
                T r101 = this.value;
                this.value = null;
                Object r102 = ObjectHelper.requireNonNull(this.resultSelector.apply(r101, r100), "The resultSelector returned a null value");     // Catch: Throwable -> L6
                this.downstream.onSuccess(r102);
                return;
            L6:
                th = move-exception;
                Exceptions.throwIfFatal(th);
                this.downstream.onError(th);
            }

            public InnerObserver(io.reactivex.k<? super R> r100, BiFunction<? super T, ? super U, ? extends R> r101) {
                this.downstream = r100;
                this.resultSelector = r101;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public final void dispose() {
            DisposableHelper.dispose(this.f493761b);
        }

        @Override // io.reactivex.disposables.Disposable
        public final boolean isDisposed() {
            return DisposableHelper.isDisposed(this.f493761b.get());
        }

        @Override // io.reactivex.k
        public final void onComplete() {
            this.f493761b.downstream.onComplete();
        }

        @Override // io.reactivex.k
        public final void onError(Throwable r100) {
            this.f493761b.downstream.onError(r100);
        }

        @Override // io.reactivex.k
        public final void onSubscribe(Disposable r100) {
            if (DisposableHelper.setOnce(this.f493761b, r100) == false) goto L6;
            this.f493761b.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.k
        public final void onSuccess(T r100) {
            MaybeSource r101 = (MaybeSource) ObjectHelper.requireNonNull(this.f493760a.apply(r100), "The mapper returned a null MaybeSource");     // Catch: Throwable -> L7
            if (DisposableHelper.replace(this.f493761b, null) == false) goto L12;
            InnerObserver<T, U, R> r102 = this.f493761b;
            r102.value = r100;
            r101.subscribe(r102);
            return;
        L12:
            return;
        L7:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f493761b.downstream.onError(th);
        }

        public FlatMapBiMainObserver(io.reactivex.k<? super R> r100, Function<? super T, ? extends MaybeSource<? extends U>> r101, BiFunction<? super T, ? super U, ? extends R> r102) {
            this.f493761b = new InnerObserver(r100, r102);
            this.f493760a = r101;
        }
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(io.reactivex.k<? super R> r100) {
        this.f493817a.subscribe(new FlatMapBiMainObserver(r100, this.f493758b, this.f493759c));
    }

    public MaybeFlatMapBiSelector(MaybeSource<T> r100, Function<? super T, ? extends MaybeSource<? extends U>> r101, BiFunction<? super T, ? super U, ? extends R> r102) {
        super(r100);
        this.f493758b = r101;
        this.f493759c = r102;
    }
}
