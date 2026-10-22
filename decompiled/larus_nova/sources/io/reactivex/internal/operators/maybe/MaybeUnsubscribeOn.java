package io.reactivex.internal.operators.maybe;

import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.MaybeSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public final class MaybeUnsubscribeOn<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Scheduler f493808b;

    public static final class UnsubscribeOnMaybeObserver<T> extends AtomicReference<Disposable> implements io.reactivex.k<T>, Disposable, Runnable {
        private static final long serialVersionUID = 3256698449646456986L;
        final io.reactivex.k<? super T> downstream;

        /* JADX INFO: renamed from: ds, reason: collision with root package name */
        Disposable f493809ds;
        final Scheduler scheduler;

        @Override // java.lang.Runnable
        public void run() {
            io_reactivex_internal_operators_maybe_MaybeUnsubscribeOn$UnsubscribeOnMaybeObserver_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper r100 = DisposableHelper.DISPOSED;
            Disposable r101 = getAndSet(r100);
            if (r101 == r100) goto L6;
            this.f493809ds = r101;
            this.scheduler.scheduleDirect(this);
            return;
        }

        public void io_reactivex_internal_operators_maybe_MaybeUnsubscribeOn$UnsubscribeOnMaybeObserver__run$___twin___() {
            this.f493809ds.dispose();
        }

        @Override // io.reactivex.k
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void io_reactivex_internal_operators_maybe_MaybeUnsubscribeOn$UnsubscribeOnMaybeObserver_com_larus_apm_impl_protector_RunnableLancet_run(UnsubscribeOnMaybeObserver r100) {
            r100.io_reactivex_internal_operators_maybe_MaybeUnsubscribeOn$UnsubscribeOnMaybeObserver__run$___twin___();     // Catch: Throwable -> L4
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
            this.downstream.onError(r100);
        }

        @Override // io.reactivex.k
        public void onSubscribe(Disposable r100) {
            if (DisposableHelper.setOnce(this, r100) == false) goto L6;
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.k
        public void onSuccess(T r100) {
            this.downstream.onSuccess(r100);
        }

        public UnsubscribeOnMaybeObserver(io.reactivex.k<? super T> r100, Scheduler r101) {
            this.downstream = r100;
            this.scheduler = r101;
        }
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(io.reactivex.k<? super T> r100) {
        this.f493817a.subscribe(new UnsubscribeOnMaybeObserver(r100, this.f493808b));
    }

    public MaybeUnsubscribeOn(MaybeSource<T> r100, Scheduler r101) {
        super(r100);
        this.f493808b = r101;
    }
}
