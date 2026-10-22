package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes41.dex */
public final class CompletableConcatIterable extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterable<? extends CompletableSource> f492914a;

    public static final class ConcatInnerObserver extends AtomicInteger implements io.reactivex.b {
        private static final long serialVersionUID = -7965400327305809232L;
        final io.reactivex.b downstream;

        /* JADX INFO: renamed from: sd, reason: collision with root package name */
        final SequentialDisposable f492915sd;
        final Iterator<? extends CompletableSource> sources;

        public void next() {
            if (this.f492915sd.isDisposed() == false) goto L6;
            return;
        L6:
            if (getAndIncrement() == 0) goto L8;
            return;
        L8:
            Iterator<? extends CompletableSource> r100 = this.sources;
        L10:
            if (this.f492915sd.isDisposed() == true) goto L11;
            if (r100.hasNext() == false) goto L14;
            ((CompletableSource) ObjectHelper.requireNonNull(r100.next(), "The CompletableSource returned is null")).subscribe(this);
            if (decrementAndGet() != 0) goto L10;
            return;
        L20:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
            return;
        L14:
            this.downstream.onComplete();
            return;
        L23:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(th);
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
            this.f492915sd.replace(r100);
        }

        public ConcatInnerObserver(io.reactivex.b r100, Iterator<? extends CompletableSource> r101) {
            this.downstream = r100;
            this.sources = r101;
            this.f492915sd = new SequentialDisposable();
        }
    }

    public CompletableConcatIterable(Iterable<? extends CompletableSource> r100) {
        this.f492914a = r100;
    }

    @Override // io.reactivex.Completable
    public final void subscribeActual(io.reactivex.b r100) {
        ConcatInnerObserver r101 = new ConcatInnerObserver(r100, (Iterator) ObjectHelper.requireNonNull(this.f492914a.iterator(), "The iterator returned is null"));
        r100.onSubscribe(r101.f492915sd);
        r101.next();
        return;
    L5:
        th = move-exception;
        Exceptions.throwIfFatal(th);
        EmptyDisposable.error(th, r100);
    }
}
