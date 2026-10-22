package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes41.dex */
public final class ObservableTakeLastTimed<T> extends a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f494183b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f494184c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TimeUnit f494185d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Scheduler f494186e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f494187f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f494188g;

    public static final class TakeLastTimedObserver<T> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -5677354903406201275L;
        volatile boolean cancelled;
        final long count;
        final boolean delayError;
        final Observer<? super T> downstream;
        Throwable error;
        final io.reactivex.internal.queue.a<Object> queue;
        final Scheduler scheduler;
        final long time;
        final TimeUnit unit;
        Disposable upstream;

        public void drain() {
            if (compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            Observer<? super T> r100 = this.downstream;
            io.reactivex.internal.queue.a<Object> r101 = this.queue;
            boolean r102 = this.delayError;
        L7:
            if (this.cancelled == true) goto L8;
            if (r102 == true) goto L15;
            Throwable r103 = this.error;
            if (r103 == null) goto L15;
            r101.clear();
            r100.onError(r103);
            return;
        L15:
            Object r104 = r101.poll();
            if (r104 != null) goto L18;
            boolean r105 = true;
        L19:
            if (r105 == true) goto L20;
            Object r106 = r101.poll();
            if (((Long) r104).longValue() < (this.scheduler.now(this.unit) - this.time)) goto L7;
            r100.onNext(r106);
            goto L7
        L20:
            Throwable r107 = this.error;
            if (r107 == null) goto L23;
            r100.onError(r107);
            return;
        L23:
            r100.onComplete();
            return;
        L18:
            r105 = false;
            goto L19
        L8:
            r101.clear();
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            if (this.cancelled == true) goto L8;
            this.cancelled = true;
            this.upstream.dispose();
            if (compareAndSet(false, true) == false) goto L9;
            this.queue.clear();
            return;
        L9:
            return;
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            drain();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable r100) {
            this.error = r100;
            drain();
        }

        @Override // io.reactivex.Observer
        public void onNext(T r110) {
            io.reactivex.internal.queue.a<Object> r100 = this.queue;
            long r101 = this.scheduler.now(this.unit);
            long r102 = this.time;
            long r103 = this.count;
            if (r103 != Long.MAX_VALUE) goto L5;
            boolean r104 = true;
        L6:
            r100.a(Long.valueOf(r101), r110);
        L8:
            if (r100.isEmpty() == true) goto L27;
            if (((Long) r100.peek()).longValue() <= (r101 - r102)) goto L19;
            if (r104 == true) goto L28;
            long r111 = r100.f494913h.get();
        L13:
            long r112 = r100.f494906a.get();
            long r113 = r100.f494913h.get();
            if (r111 == r113) goto L16;
            r111 = r113;
            goto L13
        L16:
            if ((((int) (r112 - r113)) >> 1) > r103) goto L19;
            return;
        L28:
            return;
        L19:
            r100.poll();
            r100.poll();
            goto L8
        L27:
            return;
        L5:
            r104 = false;
            goto L6
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable r100) {
            if (DisposableHelper.validate(this.upstream, r100) == false) goto L6;
            this.upstream = r100;
            this.downstream.onSubscribe(this);
            return;
        }

        public TakeLastTimedObserver(Observer<? super T> r100, long r101, long r102, TimeUnit r103, Scheduler r104, int r105, boolean r106) {
            this.downstream = r100;
            this.count = r101;
            this.time = r102;
            this.unit = r103;
            this.scheduler = r104;
            this.queue = new io.reactivex.internal.queue.a(r105);
            this.delayError = r106;
        }
    }

    @Override // io.reactivex.Observable
    public final void subscribeActual(Observer<? super T> r110) {
        this.f494245a.subscribe(new TakeLastTimedObserver(r110, this.f494183b, this.f494184c, this.f494185d, this.f494186e, this.f494187f, this.f494188g));
    }

    public ObservableTakeLastTimed(ObservableSource<T> r100, long r101, long r102, TimeUnit r103, Scheduler r104, int r105, boolean r106) {
        super(r100);
        this.f494183b = r101;
        this.f494184c = r102;
        this.f494185d = r103;
        this.f494186e = r104;
        this.f494187f = r105;
        this.f494188g = r106;
    }
}
