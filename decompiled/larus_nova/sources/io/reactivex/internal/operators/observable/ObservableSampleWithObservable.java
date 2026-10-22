package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class ObservableSampleWithObservable<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ObservableSource<?> f494143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f494144c;

    public static final class SampleMainEmitLast<T> extends SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;
        volatile boolean done;
        final AtomicInteger wip;

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        public void completeMain() {
            this.done = true;
            if (this.wip.getAndIncrement() != 0) goto L6;
            emit();
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        public void completeOther() {
            this.done = true;
            if (this.wip.getAndIncrement() != 0) goto L6;
            emit();
            this.downstream.onComplete();
            return;
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        public void run() {
            if (this.wip.getAndIncrement() != 0) goto L10;
        L4:
            boolean r100 = this.done;
            emit();
            if (r100 == true) goto L6;
            if (this.wip.decrementAndGet() != 0) goto L4;
            return;
        L6:
            this.downstream.onComplete();
            return;
        }

        public SampleMainEmitLast(Observer<? super T> r100, ObservableSource<?> r101) {
            super(r100, r101);
            this.wip = new AtomicInteger();
        }
    }

    public static final class SampleMainNoLast<T> extends SampleMainObserver<T> {
        private static final long serialVersionUID = -3029755663834015785L;

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        public void completeMain() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        public void completeOther() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.internal.operators.observable.ObservableSampleWithObservable.SampleMainObserver
        public void run() {
            emit();
        }

        public SampleMainNoLast(Observer<? super T> r100, ObservableSource<?> r101) {
            super(r100, r101);
        }
    }

    public static abstract class SampleMainObserver<T> extends AtomicReference<T> implements Observer<T>, Disposable {
        private static final long serialVersionUID = -3517602651313910099L;
        final Observer<? super T> downstream;
        final AtomicReference<Disposable> other;
        final ObservableSource<?> sampler;
        Disposable upstream;

        public abstract void completeMain();

        public abstract void completeOther();

        public void emit() {
            T r100 = getAndSet(null);
            if (r100 == null) goto L6;
            this.downstream.onNext(r100);
            return;
        }

        public abstract void run();

        public void complete() {
            this.upstream.dispose();
            completeOther();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            DisposableHelper.dispose(this.other);
            this.upstream.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            if (this.other.get() != DisposableHelper.DISPOSED) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            DisposableHelper.dispose(this.other);
            completeMain();
        }

        public void error(Throwable r100) {
            this.upstream.dispose();
            this.downstream.onError(r100);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r100) {
            DisposableHelper.dispose(this.other);
            this.downstream.onError(r100);
        }

        @Override // io.reactivex.Observer
        public void onNext(T r100) {
            lazySet(r100);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.upstream, r100) == false) goto L8;
            this.upstream = r100;
            this.downstream.onSubscribe(this);
            if (this.other.get() != null) goto L9;
            this.sampler.subscribe(new a(this));
            return;
        L9:
            return;
        }

        public boolean setOther(Disposable r100) {
            return DisposableHelper.setOnce(this.other, r100);
        }

        public SampleMainObserver(Observer<? super T> r100, ObservableSource<?> r101) {
            this.other = new AtomicReference();
            this.downstream = r100;
            this.sampler = r101;
        }
    }

    public static final class a<T> implements Observer<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SampleMainObserver<T> f494145a;

        @Override // io.reactivex.Observer
        public final void onComplete() {
            this.f494145a.complete();
        }

        public a(SampleMainObserver<T> r100) {
            this.f494145a = r100;
        }

        @Override // io.reactivex.Observer
        public final void onError(Throwable r100) {
            this.f494145a.error(r100);
        }

        @Override // io.reactivex.Observer
        public final void onNext(Object r100) {
            this.f494145a.run();
        }

        @Override // io.reactivex.Observer
        public final void onSubscribe(Disposable r100) {
            this.f494145a.setOther(r100);
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r100) {
        io.reactivex.observers.f r101 = new io.reactivex.observers.f(r100);
        if (this.f494144c == false) goto L5;
        this.f494245a.subscribe(new SampleMainEmitLast(r101, this.f494143b));
        return;
    L5:
        this.f494245a.subscribe(new SampleMainNoLast(r101, this.f494143b));
    }

    public ObservableSampleWithObservable(ObservableSource<T> r100, ObservableSource<?> r101, boolean r102) {
        super(r100);
        this.f494143b = r101;
        this.f494144c = r102;
    }
}
