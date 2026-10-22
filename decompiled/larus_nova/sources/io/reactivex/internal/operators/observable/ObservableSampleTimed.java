package io.reactivex.internal.operators.observable;

import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public final class ObservableSampleTimed<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f494139b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f494140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Scheduler f494141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f494142e;

    public static final class SampleTimedEmitLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;
        final AtomicInteger wip;

        @Override // java.lang.Runnable
        public void run() {
            io_reactivex_internal_operators_observable_ObservableSampleTimed$SampleTimedEmitLast_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void io_reactivex_internal_operators_observable_ObservableSampleTimed$SampleTimedEmitLast__run$___twin___() {
            if (this.wip.incrementAndGet() != 2) goto L8;
            emit();
            if (this.wip.decrementAndGet() != 0) goto L9;
            this.downstream.onComplete();
            return;
        L9:
            return;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver
        public void complete() {
            emit();
            if (this.wip.decrementAndGet() != 0) goto L6;
            this.downstream.onComplete();
            return;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void io_reactivex_internal_operators_observable_ObservableSampleTimed$SampleTimedEmitLast_com_larus_apm_impl_protector_RunnableLancet_run(SampleTimedEmitLast r100) {
            r100.io_reactivex_internal_operators_observable_ObservableSampleTimed$SampleTimedEmitLast__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public SampleTimedEmitLast(Observer<? super T> r100, long r101, TimeUnit r102, Scheduler r103) {
            super(r100, r101, r102, r103);
            this.wip = new AtomicInteger(1);
        }
    }

    public static final class SampleTimedNoLast<T> extends SampleTimedObserver<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        @Override // java.lang.Runnable
        public void run() {
            io_reactivex_internal_operators_observable_ObservableSampleTimed$SampleTimedNoLast_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleTimed.SampleTimedObserver
        public void complete() {
            this.downstream.onComplete();
        }

        public void io_reactivex_internal_operators_observable_ObservableSampleTimed$SampleTimedNoLast__run$___twin___() {
            emit();
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void io_reactivex_internal_operators_observable_ObservableSampleTimed$SampleTimedNoLast_com_larus_apm_impl_protector_RunnableLancet_run(SampleTimedNoLast r100) {
            r100.io_reactivex_internal_operators_observable_ObservableSampleTimed$SampleTimedNoLast__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public SampleTimedNoLast(Observer<? super T> r100, long r101, TimeUnit r102, Scheduler r103) {
            super(r100, r101, r102, r103);
        }
    }

    public static abstract class SampleTimedObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;
        final Observer<? super T> downstream;
        final long period;
        final Scheduler scheduler;
        final AtomicReference<Disposable> timer;
        final TimeUnit unit;
        Disposable upstream;

        public abstract void complete();

        public void emit() {
            T r100 = getAndSet(null);
            if (r100 == null) goto L6;
            this.downstream.onNext(r100);
            return;
        }

        public void cancelTimer() {
            DisposableHelper.dispose(this.timer);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            cancelTimer();
            this.upstream.dispose();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            cancelTimer();
            complete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r100) {
            cancelTimer();
            this.downstream.onError(r100);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r100) {
            lazySet(r100);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.upstream, r100) == false) goto L6;
            this.upstream = r100;
            this.downstream.onSubscribe(this);
            Scheduler r101 = this.scheduler;
            long r102 = this.period;
            Disposable r103 = r101.schedulePeriodicallyDirect(this, r102, r102, this.unit);
            DisposableHelper.replace(this.timer, r103);
            return;
        }

        public SampleTimedObserver(Observer<? super T> r100, long r101, TimeUnit r102, Scheduler r103) {
            this.timer = new AtomicReference();
            this.downstream = r100;
            this.period = r101;
            this.unit = r102;
            this.scheduler = r103;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        io.reactivex.observers.f r101 = new io.reactivex.observers.f(r100);
        if (this.f494142e == false) goto L5;
        this.f494245a.subscribe(new SampleTimedEmitLast(r101, this.f494139b, this.f494140c, this.f494141d));
        return;
    L5:
        this.f494245a.subscribe(new SampleTimedNoLast(r101, this.f494139b, this.f494140c, this.f494141d));
    }

    public ObservableSampleTimed(ObservableSource<T> r100, long r101, TimeUnit r102, Scheduler r103, boolean r104) {
        super(r100);
        this.f494139b = r101;
        this.f494140c = r102;
        this.f494141d = r103;
        this.f494142e = r104;
    }
}
