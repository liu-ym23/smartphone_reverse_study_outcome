package io.reactivex.internal.operators.observable;

import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes41.dex */
public final class ObservableObserveOn<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Scheduler f494091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f494092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f494093d;

    public static final class ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements Observer<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;
        final int bufferSize;
        final boolean delayError;
        volatile boolean disposed;
        volatile boolean done;
        final Observer<? super T> downstream;
        Throwable error;
        boolean outputFused;
        vtc.j<T> queue;
        int sourceMode;
        Disposable upstream;
        final Scheduler.Worker worker;

        public void drainFused() {
            int r100 = 1;
        L4:
            if (this.disposed == true) goto L5;
            boolean r101 = this.done;
            Throwable r102 = this.error;
            if (this.delayError == true) goto L12;
            if (r101 == false) goto L12;
            if (r102 == null) goto L12;
            this.disposed = true;
            this.downstream.onError(this.error);
            this.worker.dispose();
            return;
        L12:
            this.downstream.onNext(null);
            if (r101 == true) goto L14;
            r100 = addAndGet(-r100);
            if (r100 != 0) goto L4;
            return;
        L14:
            this.disposed = true;
            Throwable r103 = this.error;
            if (r103 == null) goto L17;
            this.downstream.onError(r103);
        L18:
            this.worker.dispose();
            return;
        L17:
            this.downstream.onComplete();
            goto L18
        }

        @Override // java.lang.Runnable
        public void run() {
            io_reactivex_internal_operators_observable_ObservableObserveOn$ObserveOnObserver_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, vtc.j
        public void clear() {
            this.queue.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.disposed == true) goto L8;
            this.disposed = true;
            this.upstream.dispose();
            this.worker.dispose();
            if (getAndIncrement() != 0) goto L9;
            this.queue.clear();
            return;
        L9:
            return;
        }

        public void drainNormal() {
            vtc.j<T> r100 = this.queue;
            Observer<? super T> r101 = this.downstream;
            int r102 = 1;
        L4:
            if (checkTerminated(this.done, r100.isEmpty(), r101) == true) goto L5;
        L6:
            boolean r103 = this.done;
            T r104 = r100.poll();     // Catch: Throwable -> L19
            if (r104 != null) goto L10;
            boolean r105 = true;
        L12:
            if (checkTerminated(r103, r105, r101) == true) goto L13;
            if (r105 == true) goto L15;
            r101.onNext(r104);
            goto L6
        L15:
            r102 = addAndGet(-r102);
            if (r102 != 0) goto L4;
            return;
        L13:
            return;
        L10:
            r105 = false;
        L19:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.disposed = true;
            this.upstream.dispose();
            r100.clear();
            r101.onError(th);
            this.worker.dispose();
            return;
        }

        public void io_reactivex_internal_operators_observable_ObservableObserveOn$ObserveOnObserver__run$___twin___() {
            if (this.outputFused == false) goto L5;
            drainFused();
            return;
        L5:
            drainNormal();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, vtc.j
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done == false) goto L5;
            return;
        L5:
            this.done = true;
            schedule();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, vtc.j
        public T poll() throws Exception {
            return this.queue.poll();
        }

        public void schedule() {
            if (getAndIncrement() != 0) goto L6;
            this.worker.schedule(this);
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.disposed;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void io_reactivex_internal_operators_observable_ObservableObserveOn$ObserveOnObserver_com_larus_apm_impl_protector_RunnableLancet_run(ObserveOnObserver r100) {
            r100.io_reactivex_internal_operators_observable_ObservableObserveOn$ObserveOnObserver__run$___twin___();     // Catch: Throwable -> L4
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
            if (this.done == false) goto L6;
            RxJavaPlugins.onError(r100);
            return;
        L6:
            this.error = r100;
            this.done = true;
            schedule();
        }

        @Override // io.reactivex.Observer
        public void onNext(T r100) {
            if (this.done == false) goto L6;
            return;
        L6:
            if (this.sourceMode == 2) goto L8;
            this.queue.offer(r100);
        L8:
            schedule();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.upstream, r100) == false) goto L16;
            this.upstream = r100;
            if ((r100 instanceof vtc.e) == false) goto L14;
            vtc.e r101 = (vtc.e) r100;
            int r102 = r101.requestFusion(7);
            if (r102 != 1) goto L11;
            this.sourceMode = r102;
            this.queue = r101;
            this.done = true;
            this.downstream.onSubscribe(this);
            schedule();
            return;
        L11:
            if (r102 != 2) goto L14;
            this.sourceMode = r102;
            this.queue = r101;
            this.downstream.onSubscribe(this);
            return;
        L14:
            this.queue = new io.reactivex.internal.queue.a(this.bufferSize);
            this.downstream.onSubscribe(this);
            return;
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, vtc.f
        public int requestFusion(int r100) {
            if ((r100 & 2) == 0) goto L6;
            this.outputFused = true;
            return 2;
        L6:
            return 0;
        }

        public boolean checkTerminated(boolean r100, boolean r101, Observer<? super T> r102) {
            if (this.disposed == false) goto L6;
            this.queue.clear();
            return true;
        L6:
            if (r100 == false) goto L22;
            Throwable r103 = this.error;
            if (this.delayError == false) goto L16;
            if (r101 == false) goto L24;
            this.disposed = true;
            if (r103 == null) goto L13;
            r102.onError(r103);
        L14:
            this.worker.dispose();
            return true;
        L13:
            r102.onComplete();
            goto L14
        L24:
            return false;
        L16:
            if (r103 == null) goto L19;
            this.disposed = true;
            this.queue.clear();
            r102.onError(r103);
            this.worker.dispose();
            return true;
        L19:
            if (r101 == false) goto L25;
            this.disposed = true;
            r102.onComplete();
            this.worker.dispose();
            return true;
        L25:
            return false;
        L22:
            return false;
        }

        public ObserveOnObserver(Observer<? super T> r100, Scheduler.Worker r101, boolean r102, int r103) {
            this.downstream = r100;
            this.worker = r101;
            this.delayError = r102;
            this.bufferSize = r103;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        Scheduler r101 = this.f494091b;
        if ((r101 instanceof io.reactivex.internal.schedulers.k) == false) goto L5;
        this.f494245a.subscribe(r100);
        return;
    L5:
        Scheduler.Worker r102 = r101.createWorker();
        this.f494245a.subscribe(new ObserveOnObserver(r100, r102, this.f494092c, this.f494093d));
    }

    public ObservableObserveOn(ObservableSource<T> r100, Scheduler r101, boolean r102, int r103) {
        super(r100);
        this.f494091b = r101;
        this.f494092c = r102;
        this.f494093d = r103;
    }
}
