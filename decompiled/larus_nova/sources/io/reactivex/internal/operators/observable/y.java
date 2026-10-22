package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.BiPredicate;
import io.reactivex.functions.Function;

/* JADX INFO: loaded from: classes41.dex */
public final class y<T, K> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function<? super T, K> f494714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BiPredicate<? super K, ? super K> f494715c;

    public static final class a<T, K> extends io.reactivex.internal.observers.a<T, T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Function<? super T, K> f494716f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final BiPredicate<? super K, ? super K> f494717g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public K f494718h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f494719i;

        @Override // vtc.j
        public final T poll() throws Exception {
        L2:
            T r100 = this.f492869c.poll();
            if (r100 == null) goto L4;
            K r101 = this.f494716f.apply(r100);
            if (this.f494719i == false) goto L8;
            if (this.f494717g.test(this.f494718h, r101) == false) goto L12;
            this.f494718h = r101;
            goto L2
        L12:
            this.f494718h = r101;
            return r100;
        L8:
            this.f494719i = true;
            this.f494718h = r101;
            return r100;
        L4:
            return null;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
            if (this.f492870d == false) goto L6;
            return;
        L6:
            if (this.f492871e == 0) goto L20;
            this.f492867a.onNext((Object) r100);
            return;
        L20:
            K r101 = this.f494716f.apply(r100);     // Catch: Throwable -> L17
            if (this.f494719i == false) goto L14;
            boolean r102 = this.f494717g.test(this.f494718h, r101);     // Catch: Throwable -> L17
            this.f494718h = r101;     // Catch: Throwable -> L17
            if (r102 == false) goto L15;
            return;
        L15:
            this.f492867a.onNext((Object) r100);
            return;
        L14:
            this.f494719i = true;     // Catch: Throwable -> L17
            this.f494718h = r101;     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            b(th);
        }

        @Override // vtc.f
        public final int requestFusion(int r100) {
            return d(r100);
        }

        public a(Observer<? super T> r100, Function<? super T, K> r101, BiPredicate<? super K, ? super K> r102) {
            super(r100);
            this.f494716f = r101;
            this.f494717g = r102;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        this.f494245a.subscribe(new a(r100, this.f494714b, this.f494715c));
    }

    public y(ObservableSource<T> r100, Function<? super T, K> r101, BiPredicate<? super K, ? super K> r102) {
        super(r100);
        this.f494714b = r101;
        this.f494715c = r102;
    }
}
