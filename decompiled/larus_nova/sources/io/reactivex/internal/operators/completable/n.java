package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes41.dex */
public final class n<T> extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SingleSource<T> f492980a;

    public static final class a<T> implements SingleObserver<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final io.reactivex.b f492981a;

        public a(io.reactivex.b r100) {
            this.f492981a = r100;
        }

        @Override // io.reactivex.SingleObserver
        public final void onError(Throwable r100) {
            this.f492981a.onError(r100);
        }

        @Override // io.reactivex.SingleObserver
        public final void onSubscribe(Disposable r100) {
            this.f492981a.onSubscribe(r100);
        }

        @Override // io.reactivex.SingleObserver
        public final void onSuccess(T r100) {
            this.f492981a.onComplete();
        }
    }

    public n(SingleSource<T> r100) {
        this.f492980a = r100;
    }

    @Override // io.reactivex.Completable
    public final void subscribeActual(io.reactivex.b r100) {
        this.f492980a.subscribe(new a(r100));
    }
}
