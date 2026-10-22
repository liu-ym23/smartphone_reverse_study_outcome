package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes41.dex */
public final class CompletableConcatArray extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompletableSource[] f492912a;

    public static final class ConcatInnerObserver extends AtomicInteger implements io.reactivex.b {
        private static final long serialVersionUID = -7965400327305809232L;
        final io.reactivex.b downstream;
        int index;

        /* JADX INFO: renamed from: sd, reason: collision with root package name */
        final SequentialDisposable f492913sd;
        final CompletableSource[] sources;

        public void next() {
            if (this.f492913sd.isDisposed() == false) goto L6;
            return;
        L6:
            if (getAndIncrement() == 0) goto L8;
            return;
        L8:
            CompletableSource[] r100 = this.sources;
        L10:
            if (this.f492913sd.isDisposed() == true) goto L11;
            int r101 = this.index;
            this.index = r101 + 1;
            if (r101 == r100.length) goto L14;
            r100[r101].subscribe(this);
            if (decrementAndGet() != 0) goto L10;
            return;
        L14:
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.b
        public void onComplete() {
            next();
        }

        @Override // io.reactivex.b
        public void onError(Throwable r100) {
            this.downstream.onError(r100);
        }

        @Override // io.reactivex.b
        public void onSubscribe(Disposable r100) {
            this.f492913sd.replace(r100);
        }

        public ConcatInnerObserver(io.reactivex.b r100, CompletableSource[] r101) {
            this.downstream = r100;
            this.sources = r101;
            this.f492913sd = new SequentialDisposable();
        }
    }

    public CompletableConcatArray(CompletableSource[] r100) {
        this.f492912a = r100;
    }

    @Override // io.reactivex.Completable
    public final void subscribeActual(io.reactivex.b r100) {
        ConcatInnerObserver r101 = new ConcatInnerObserver(r100, this.f492912a);
        r100.onSubscribe(r101.f492913sd);
        r101.next();
    }
}
