package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes41.dex */
public final class e extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompletableSource f492965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Consumer<? super Throwable> f492966b;

    public final class a implements io.reactivex.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final io.reactivex.b f492967a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f492968b;

        @Override // io.reactivex.b
        public final void onComplete() {
            this.f492968b.f492966b.accept(null);     // Catch: Throwable -> L5
            this.f492967a.onComplete();
            return;
        L5:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f492967a.onError(th);
        }

        @Override // io.reactivex.b
        public final void onError(Throwable r100) {
            this.f492968b.f492966b.accept(r100);     // Catch: Throwable -> L4
        L6:
            this.f492967a.onError(r100);
            return;
        L4:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            r100 = new CompositeException(new Throwable[]{r100, th});
            goto L6
        }

        @Override // io.reactivex.b
        public final void onSubscribe(Disposable r100) {
            this.f492967a.onSubscribe(r100);
        }

        public a(e r100, io.reactivex.b r101) {
            this.f492968b = r100;
            this.f492967a = r101;
        }
    }

    @Override // io.reactivex.Completable
    public final void subscribeActual(io.reactivex.b r100) {
        this.f492965a.subscribe(new a(this, r100));
    }

    public e(CompletableSource r100, Consumer<? super Throwable> r101) {
        this.f492965a = r100;
        this.f492966b = r101;
    }
}
