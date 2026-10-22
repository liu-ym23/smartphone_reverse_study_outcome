package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Predicate;

/* JADX INFO: loaded from: classes41.dex */
public final class h0<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Predicate<? super T> f494376b;

    public static final class a<T> extends io.reactivex.internal.observers.a<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Predicate<? super T> f494377f;

        @Override // vtc.j
        public final T poll() throws Exception {
        L2:
            T r100 = this.f492869c.poll();
            if (r100 == null) goto L6;
            if (this.f494377f.test(r100) == false) goto L2;
        L6:
            return r100;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            if (this.f492871e == 0) goto L12;
            this.f492867a.onNext(null);
            return;
        L12:
            if (this.f494377f.test(r100) == false) goto L14;
            this.f492867a.onNext((Object) r100);
            return;
        L14:
            return;
        L7:
            th = move-exception;
            b(th);
        }

        @Override // vtc.f
        public final int requestFusion(int r100) {
            return d(r100);
        }

        public a(Observer<? super T> r100, Predicate<? super T> r101) {
            super(r100);
            this.f494377f = r101;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        this.f494245a.subscribe(new a(r100, this.f494376b));
    }

    public h0(ObservableSource<T> r100, Predicate<? super T> r101) {
        super(r100);
        this.f494376b = r101;
    }
}
