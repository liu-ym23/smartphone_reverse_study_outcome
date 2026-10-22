package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class CompletableResumeNext extends Completable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompletableSource f492931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function<? super Throwable, ? extends CompletableSource> f492932b;

    public static final class ResumeNextObserver extends AtomicReference<Disposable> implements io.reactivex.b, Disposable {
        private static final long serialVersionUID = 5018523762564524046L;
        final io.reactivex.b downstream;
        final Function<? super Throwable, ? extends CompletableSource> errorMapper;
        boolean once;

        @Override // io.reactivex.b
        public void onComplete() {
            this.downstream.onComplete();
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
            if (this.once == false) goto L6;
            this.downstream.onError(r100);
            return;
        L6:
            this.once = true;
            ((CompletableSource) ObjectHelper.requireNonNull(this.errorMapper.apply(r100), "The errorMapper returned a null CompletableSource")).subscribe(this);
            return;
        L10:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.downstream.onError(new CompositeException(new Throwable[]{r100, th}));
        }

        @Override // io.reactivex.b
        public void onSubscribe(Disposable r100) {
            DisposableHelper.replace(this, r100);
        }

        public ResumeNextObserver(io.reactivex.b r100, Function<? super Throwable, ? extends CompletableSource> r101) {
            this.downstream = r100;
            this.errorMapper = r101;
        }
    }

    @Override // io.reactivex.Completable
    public final void subscribeActual(io.reactivex.b r100) {
        ResumeNextObserver r101 = new ResumeNextObserver(r100, this.f492932b);
        r100.onSubscribe(r101);
        this.f492931a.subscribe(r101);
    }

    public CompletableResumeNext(CompletableSource r100, Function<? super Throwable, ? extends CompletableSource> r101) {
        this.f492931a = r100;
        this.f492932b = r101;
    }
}
