package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import io.reactivex.internal.functions.ObjectHelper;

/* JADX INFO: loaded from: classes41.dex */
public final class m1<T, U> extends io.reactivex.internal.operators.observable.a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function<? super T, ? extends U> f494507b;

    public static final class a<T, U> extends io.reactivex.internal.observers.a<T, U> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Function<? super T, ? extends U> f494508f;

        @Override // vtc.j
        public final U poll() throws Exception {
            T r100 = this.f492869c.poll();
            if (r100 != null) goto L7;
            return null;
        L7:
            return (U) ObjectHelper.requireNonNull(this.f494508f.apply(r100), "The mapper function returned a null value.");
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
            Object r101 = ObjectHelper.requireNonNull(this.f494508f.apply(r100), "The mapper function returned a null value.");     // Catch: Throwable -> L12
            this.f492867a.onNext((Object) r101);
            return;
        L12:
            th = move-exception;
            b(th);
        }

        @Override // vtc.f
        public final int requestFusion(int r100) {
            return d(r100);
        }

        public a(Observer<? super U> r100, Function<? super T, ? extends U> r101) {
            super(r100);
            this.f494508f = r101;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super U> r100) {
        this.f494245a.subscribe(new a(r100, this.f494507b));
    }

    public m1(ObservableSource<T> r100, Function<? super T, ? extends U> r101) {
        super(r100);
        this.f494507b = r101;
    }
}
