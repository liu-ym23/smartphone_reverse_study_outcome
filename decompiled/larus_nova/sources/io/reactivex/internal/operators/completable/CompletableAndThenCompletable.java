package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class CompletableAndThenCompletable extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompletableSource f492900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompletableSource f492901b;

    public static final class SourceObserver extends AtomicReference<Disposable> implements io.reactivex.b, Disposable {
        private static final long serialVersionUID = -4101678820158072998L;
        final io.reactivex.b actualObserver;
        final CompletableSource next;

        @Override // io.reactivex.b
        public void onComplete() {
            this.next.subscribe(new a(this, this.actualObserver));
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.b
        public void onError(Throwable r100) {
            this.actualObserver.onError(r100);
        }

        @Override // io.reactivex.b
        public void onSubscribe(Disposable r100) {
            if (DisposableHelper.setOnce(this, r100) == false) goto L6;
            this.actualObserver.onSubscribe(this);
            return;
        }

        public SourceObserver(io.reactivex.b r100, CompletableSource r101) {
            this.actualObserver = r100;
            this.next = r101;
        }
    }

    public static final class a implements io.reactivex.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReference<Disposable> f492902a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final io.reactivex.b f492903b;

        @Override // io.reactivex.b
        public final void onComplete() {
            this.f492903b.onComplete();
        }

        @Override // io.reactivex.b
        public final void onError(Throwable r100) {
            this.f492903b.onError(r100);
        }

        @Override // io.reactivex.b
        public final void onSubscribe(Disposable r100) {
            DisposableHelper.replace(this.f492902a, r100);
        }

        public a(AtomicReference<Disposable> r100, io.reactivex.b r101) {
            this.f492902a = r100;
            this.f492903b = r101;
        }
    }

    @Override // io.reactivex.Completable
    public final void subscribeActual(io.reactivex.b r100) {
        this.f492900a.subscribe(new SourceObserver(r100, this.f492901b));
    }

    public CompletableAndThenCompletable(CompletableSource r100, CompletableSource r101) {
        this.f492900a = r100;
        this.f492901b = r101;
    }
}
