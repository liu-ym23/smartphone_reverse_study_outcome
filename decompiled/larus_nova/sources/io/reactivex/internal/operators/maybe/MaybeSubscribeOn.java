package io.reactivex.internal.operators.maybe;

import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.MaybeSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class MaybeSubscribeOn<T> extends io.reactivex.internal.operators.maybe.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Scheduler f493786b;

    public static final class SubscribeOnMaybeObserver<T> extends AtomicReference<Disposable> implements io.reactivex.k<T>, Disposable {
        private static final long serialVersionUID = 8571289934935992137L;
        final io.reactivex.k<? super T> downstream;
        final SequentialDisposable task;

        @Override // io.reactivex.k
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
            this.task.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        public SubscribeOnMaybeObserver(io.reactivex.k<? super T> r100) {
            this.downstream = r100;
            this.task = new SequentialDisposable();
        }

        @Override // io.reactivex.k
        public void onError(Throwable r100) {
            this.downstream.onError(r100);
        }

        @Override // io.reactivex.k
        public void onSubscribe(Disposable r100) {
            DisposableHelper.setOnce(this, r100);
        }

        @Override // io.reactivex.k
        public void onSuccess(T r100) {
            this.downstream.onSuccess(r100);
        }
    }

    public static final class a<T> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final io.reactivex.k<? super T> f493787a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MaybeSource<T> f493788b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f493788b.subscribe(this.f493787a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(io.reactivex.k<? super T> r100, MaybeSource<T> r101) {
            this.f493787a = r100;
            this.f493788b = r101;
        }
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(io.reactivex.k<? super T> r100) {
        SubscribeOnMaybeObserver r101 = new SubscribeOnMaybeObserver(r100);
        r100.onSubscribe(r101);
        r101.task.replace(this.f493786b.scheduleDirect(new a(r101, this.f493817a)));
    }

    public MaybeSubscribeOn(MaybeSource<T> r100, Scheduler r101) {
        super(r100);
        this.f493786b = r101;
    }
}
