package io.reactivex.internal.operators.maybe;

import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.MaybeSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public final class MaybeObserveOn<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Scheduler f493781b;

    public static final class ObserveOnMaybeObserver<T> extends AtomicReference<Disposable> implements io.reactivex.k<T>, Disposable, Runnable {
        private static final long serialVersionUID = 8571289934935992137L;
        final io.reactivex.k<? super T> downstream;
        Throwable error;
        final Scheduler scheduler;
        T value;

        @Override // java.lang.Runnable
        public void run() {
            io_reactivex_internal_operators_maybe_MaybeObserveOn$ObserveOnMaybeObserver_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void io_reactivex_internal_operators_maybe_MaybeObserveOn$ObserveOnMaybeObserver__run$___twin___() {
            Throwable r100 = this.error;
            if (r100 == null) goto L5;
            this.error = null;
            this.downstream.onError(r100);
            return;
        L5:
            T r101 = this.value;
            if (r101 == null) goto L8;
            this.value = null;
            this.downstream.onSuccess(r101);
            return;
        L8:
            this.downstream.onComplete();
        }

        @Override // io.reactivex.k
        public void onComplete() {
            DisposableHelper.replace(this, this.scheduler.scheduleDirect(this));
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void io_reactivex_internal_operators_maybe_MaybeObserveOn$ObserveOnMaybeObserver_com_larus_apm_impl_protector_RunnableLancet_run(ObserveOnMaybeObserver r100) {
            r100.io_reactivex_internal_operators_maybe_MaybeObserveOn$ObserveOnMaybeObserver__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        @Override // io.reactivex.k
        public void onError(Throwable r100) {
            this.error = r100;
            DisposableHelper.replace(this, this.scheduler.scheduleDirect(this));
        }

        @Override // io.reactivex.k
        public void onSubscribe(Disposable r100) {
            if (DisposableHelper.setOnce(this, r100) == false) goto L6;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.k
        public void onSuccess(T r100) {
            this.value = r100;
            DisposableHelper.replace(this, this.scheduler.scheduleDirect(this));
        }

        public ObserveOnMaybeObserver(io.reactivex.k<? super T> r100, Scheduler r101) {
            this.downstream = r100;
            this.scheduler = r101;
        }
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(io.reactivex.k<? super T> r100) {
        this.f493817a.subscribe(new ObserveOnMaybeObserver(r100, this.f493781b));
    }

    public MaybeObserveOn(MaybeSource<T> r100, Scheduler r101) {
        super(r100);
        this.f493781b = r101;
    }
}
