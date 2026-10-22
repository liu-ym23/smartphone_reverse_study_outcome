package io.reactivex.internal.operators.maybe;

import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.MaybeSource;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public final class MaybeDelay<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f493739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f493740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Scheduler f493741d;

    public static final class DelayMaybeObserver<T> extends AtomicReference<Disposable> implements io.reactivex.k<T>, Disposable, Runnable {
        private static final long serialVersionUID = 5566860102500855068L;
        final long delay;
        final io.reactivex.k<? super T> downstream;
        Throwable error;
        final Scheduler scheduler;
        final TimeUnit unit;
        T value;

        @Override // java.lang.Runnable
        public void run() {
            io_reactivex_internal_operators_maybe_MaybeDelay$DelayMaybeObserver_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void io_reactivex_internal_operators_maybe_MaybeDelay$DelayMaybeObserver__run$___twin___() {
            Throwable r100 = this.error;
            if (r100 == null) goto L5;
            this.downstream.onError(r100);
            return;
        L5:
            T r101 = this.value;
            if (r101 == null) goto L8;
            this.downstream.onSuccess(r101);
            return;
        L8:
            this.downstream.onComplete();
        }

        public void schedule() {
            DisposableHelper.replace(this, this.scheduler.scheduleDirect(this, this.delay, this.unit));
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.k
        public void onComplete() {
            schedule();
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void io_reactivex_internal_operators_maybe_MaybeDelay$DelayMaybeObserver_com_larus_apm_impl_protector_RunnableLancet_run(DelayMaybeObserver r100) {
            r100.io_reactivex_internal_operators_maybe_MaybeDelay$DelayMaybeObserver__run$___twin___();     // Catch: Throwable -> L4
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
            schedule();
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
            schedule();
        }

        public DelayMaybeObserver(io.reactivex.k<? super T> r100, long r101, TimeUnit r102, Scheduler r103) {
            this.downstream = r100;
            this.delay = r101;
            this.unit = r102;
            this.scheduler = r103;
        }
    }

    @Override // io.reactivex.Maybe
    public final void subscribeActual(io.reactivex.k<? super T> r100) {
        this.f493817a.subscribe(new DelayMaybeObserver(r100, this.f493739b, this.f493740c, this.f493741d));
    }

    public MaybeDelay(MaybeSource<T> r100, long r101, TimeUnit r102, Scheduler r103) {
        super(r100);
        this.f493739b = r101;
        this.f493740c = r102;
        this.f493741d = r103;
    }
}
