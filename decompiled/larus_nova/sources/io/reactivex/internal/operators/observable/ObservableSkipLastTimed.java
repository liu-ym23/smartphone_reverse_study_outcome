package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes41.dex */
public final class ObservableSkipLastTimed<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f494171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f494172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Scheduler f494173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f494174e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f494175f;

    public static final class SkipLastTimedObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long serialVersionUID = -5677354903406201275L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        final Observer<? super T> downstream;
        Throwable error;
        final io.reactivex.internal.queue.a<Object> queue;
        final Scheduler scheduler;
        final long time;
        final TimeUnit unit;
        Disposable upstream;

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.done = true;
            drain();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled == true) goto L8;
            this.cancelled = true;
            this.upstream.dispose();
            if (getAndIncrement() != 0) goto L9;
            this.queue.clear();
            return;
        L9:
            return;
        }

        public void drain() {
            if (getAndIncrement() == 0) goto L5;
            return;
        L5:
            Observer<? super T> r100 = this.downstream;
            io.reactivex.internal.queue.a<Object> r101 = this.queue;
            boolean r102 = this.delayError;
            TimeUnit r103 = this.unit;
            Scheduler r104 = this.scheduler;
            long r105 = this.time;
            int r106 = 1;
        L7:
            if (this.cancelled == true) goto L8;
            boolean r110 = this.done;
            Long r111 = (Long) r101.peek();
            if (r111 != null) goto L13;
            boolean r112 = true;
        L14:
            long r113 = r104.now(r103);
            if (r112 == false) goto L17;
        L19:
            if (r110 == false) goto L34;
            if (r102 == false) goto L27;
            if (r112 == false) goto L34;
            Throwable r107 = this.error;
            if (r107 == null) goto L25;
            r100.onError(r107);
            return;
        L25:
            r100.onComplete();
            return;
        L27:
            Throwable r114 = this.error;
            if (r114 != null) goto L29;
            if (r112 == false) goto L34;
            r100.onComplete();
            return;
        L29:
            this.queue.clear();
            r100.onError(r114);
            return;
        L34:
            if (r112 == true) goto L35;
            r101.poll();
            r100.onNext(r101.poll());
            goto L7
        L35:
            r106 = addAndGet(-r106);
            if (r106 != 0) goto L7;
            return;
        L17:
            if (r111.longValue() <= (r113 - r105)) goto L19;
            r112 = true;
            goto L19
        L13:
            r112 = false;
            goto L14
        L8:
            this.queue.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r100) {
            this.error = r100;
            this.done = true;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onNext(T r100) {
            this.queue.a(Long.valueOf(this.scheduler.now(this.unit)), r100);
            drain();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.upstream, r100) == false) goto L6;
            this.upstream = r100;
            this.downstream.onSubscribe(this);
            return;
        }

        public SkipLastTimedObserver(Observer<? super T> r100, long r101, TimeUnit r102, Scheduler r103, int r104, boolean r105) {
            this.downstream = r100;
            this.time = r101;
            this.unit = r102;
            this.scheduler = r103;
            this.queue = new io.reactivex.internal.queue.a(r104);
            this.delayError = r105;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r110) {
        this.f494245a.subscribe(new SkipLastTimedObserver(r110, this.f494171b, this.f494172c, this.f494173d, this.f494174e, this.f494175f));
    }

    public ObservableSkipLastTimed(ObservableSource<T> r100, long r101, TimeUnit r102, Scheduler r103, int r104, boolean r105) {
        super(r100);
        this.f494171b = r101;
        this.f494172c = r102;
        this.f494173d = r103;
        this.f494174e = r104;
        this.f494175f = r105;
    }
}
