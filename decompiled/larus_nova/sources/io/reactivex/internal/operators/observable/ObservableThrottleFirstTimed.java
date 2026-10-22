package io.reactivex.internal.operators.observable;

import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public final class ObservableThrottleFirstTimed<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f494190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f494191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Scheduler f494192d;

    public static final class DebounceTimedObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable, Runnable {
        private static final long serialVersionUID = 786994795061867455L;
        boolean done;
        final Observer<? super T> downstream;
        volatile boolean gate;
        final long timeout;
        final TimeUnit unit;
        Disposable upstream;
        final Scheduler.Worker worker;

        public void io_reactivex_internal_operators_observable_ObservableThrottleFirstTimed$DebounceTimedObserver__run$___twin___() {
            this.gate = false;
        }

        @Override // java.lang.Runnable
        public void run() {
            io_reactivex_internal_operators_observable_ObservableThrottleFirstTimed$DebounceTimedObserver_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.upstream.dispose();
            this.worker.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.worker.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done == true) goto L6;
            this.done = true;
            this.downstream.onComplete();
            this.worker.dispose();
            return;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void io_reactivex_internal_operators_observable_ObservableThrottleFirstTimed$DebounceTimedObserver_com_larus_apm_impl_protector_RunnableLancet_run(DebounceTimedObserver r100) {
            r100.io_reactivex_internal_operators_observable_ObservableThrottleFirstTimed$DebounceTimedObserver__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r100) {
            if (this.done == false) goto L5;
            RxJavaPlugins.onError(r100);
            return;
        L5:
            this.done = true;
            this.downstream.onError(r100);
            this.worker.dispose();
        }

        @Override // io.reactivex.Observer
        public void onNext(T r100) {
            if (this.gate == false) goto L5;
            return;
        L5:
            if (this.done == true) goto L12;
            this.gate = true;
            this.downstream.onNext(r100);
            Disposable r101 = get();
            if (r101 == null) goto L9;
            r101.dispose();
        L9:
            DisposableHelper.replace(this, this.worker.schedule(this, this.timeout, this.unit));
            return;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.upstream, r100) == false) goto L6;
            this.upstream = r100;
            this.downstream.onSubscribe(this);
            return;
        }

        public DebounceTimedObserver(Observer<? super T> r100, long r101, TimeUnit r102, Scheduler.Worker r103) {
            this.downstream = r100;
            this.timeout = r101;
            this.unit = r102;
            this.worker = r103;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        this.f494245a.subscribe(new DebounceTimedObserver(new io.reactivex.observers.f(r100), this.f494190b, this.f494191c, this.f494192d.createWorker()));
    }

    public ObservableThrottleFirstTimed(ObservableSource<T> r100, long r101, TimeUnit r102, Scheduler r103) {
        super(r100);
        this.f494190b = r101;
        this.f494191c = r102;
        this.f494192d = r103;
    }
}
