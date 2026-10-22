package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes41.dex */
public final class z<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Consumer<? super T> f494726b;

    public static final class a<T> extends io.reactivex.internal.observers.a<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Consumer<? super T> f494727f;

        @Override // vtc.j
        public final T poll() throws Exception {
            T r100 = this.f492869c.poll();
            if (r100 == null) goto L5;
            this.f494727f.accept(r100);
        L5:
            return r100;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            this.f492867a.onNext((Object) r100);
            if (this.f492871e != 0) goto L11;
            this.f494727f.accept(r100);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            b(th);
            return;
        }

        @Override // vtc.f
        public final int requestFusion(int r100) {
            return d(r100);
        }

        public a(Observer<? super T> r100, Consumer<? super T> r101) {
            super(r100);
            this.f494727f = r101;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        this.f494245a.subscribe(new a(r100, this.f494726b));
    }

    public z(ObservableSource<T> r100, Consumer<? super T> r101) {
        super(r100);
        this.f494726b = r101;
    }
}
