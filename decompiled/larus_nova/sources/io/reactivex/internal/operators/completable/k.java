package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes41.dex */
public final class k<T> extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObservableSource<T> f492974a;

    public static final class a<T> implements Observer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final io.reactivex.b f492975a;

        @Override // io.reactivex.Observer
        public final void onNext(T r100) {
        }

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.f492975a.onComplete();
        }

        public a(io.reactivex.b r100) {
            this.f492975a = r100;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            this.f492975a.onError(r100);
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            this.f492975a.onSubscribe(r100);
        }
    }

    public k(ObservableSource<T> r100) {
        this.f492974a = r100;
    }

    @Override // io.reactivex.Completable
    public final void subscribeActual(io.reactivex.b r100) {
        this.f492974a.subscribe(new a(r100));
    }
}
