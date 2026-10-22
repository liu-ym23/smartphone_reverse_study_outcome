package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Predicate;

/* JADX INFO: loaded from: classes41.dex */
public final class v extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompletableSource f492995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Predicate<? super Throwable> f492996b;

    public final class a implements io.reactivex.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final io.reactivex.b f492997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v f492998b;

        @Override // io.reactivex.b
        public final void onComplete() {
            this.f492997a.onComplete();
        }

        @Override // io.reactivex.b
        public final void onError(Throwable r100) {
            if (this.f492998b.f492996b.test(r100) == false) goto L5;
            this.f492997a.onComplete();
            return;
        L5:
            this.f492997a.onError(r100);
            return;
        L7:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.f492997a.onError(new CompositeException(new Throwable[]{r100, th}));
        }

        @Override // io.reactivex.b
        public final void onSubscribe(Disposable r100) {
            this.f492997a.onSubscribe(r100);
        }

        public a(v r100, io.reactivex.b r101) {
            this.f492998b = r100;
            this.f492997a = r101;
        }
    }

    @Override // io.reactivex.Completable
    public final void subscribeActual(io.reactivex.b r100) {
        this.f492995a.subscribe(new a(this, r100));
    }

    public v(CompletableSource r100, Predicate<? super Throwable> r101) {
        this.f492995a = r100;
        this.f492996b = r101;
    }
}
