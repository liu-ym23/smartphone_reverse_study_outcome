package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.Exceptions;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.g;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLongArray;
import org.reactivestreams.Publisher;
import vtc.j;
import wtc.a;
import wwc.b;
import wwc.c;

/* JADX INFO: loaded from: classes41.dex */
public final class ParallelFromPublisher<T> extends a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Publisher<? extends T> f494736a;

    public static final class ParallelDispatcher<T> extends AtomicInteger implements g<T> {
        private static final long serialVersionUID = -4470634016609963609L;
        volatile boolean cancelled;
        volatile boolean done;
        final long[] emissions;
        Throwable error;
        int index;
        final int limit;
        final int prefetch;
        int produced;
        j<T> queue;
        final AtomicLongArray requests;
        int sourceMode;
        final AtomicInteger subscriberCount;
        final b<? super T>[] subscribers;
        c upstream;

        public final class a implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f494737a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f494738b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ ParallelDispatcher f494739c;

            @Override // wwc.c
            public final void cancel() {
                AtomicLongArray r100 = this.f494739c.requests;
                int r101 = this.f494738b;
                if (r100.compareAndSet(this.f494737a + r101, 0, 1) == false) goto L6;
                ParallelDispatcher r102 = this.f494739c;
                int r103 = this.f494738b;
                r102.cancel(r103 + r103);
                return;
            }

            @Override // wwc.c
            public final void request(long r100) {
                if (SubscriptionHelper.validate(r100) == false) goto L17;
                AtomicLongArray r101 = this.f494739c.requests;
            L5:
                long r102 = r101.get(this.f494737a);
                if (r102 == Long.MAX_VALUE) goto L7;
                long r103 = io.reactivex.internal.util.b.c(r102, r100);
                if (r101.compareAndSet(this.f494737a, r102, r103) == false) goto L5;
                if (this.f494739c.subscriberCount.get() != this.f494738b) goto L18;
                this.f494739c.drain();
                return;
            L18:
                return;
            L7:
                return;
            }

            public a(ParallelDispatcher r100, int r101, int r102) {
                this.f494739c = r100;
                this.f494737a = r101;
                this.f494738b = r102;
            }
        }

        @Override // wwc.b
        public void onComplete() {
            this.done = true;
            drain();
        }

        public void drainAsync() {
            j<T> r100 = this.queue;
            b<? super T>[] r101 = this.subscribers;
            AtomicLongArray r102 = this.requests;
            long[] r103 = this.emissions;
            int r104 = r103.length;
            int r105 = this.index;
            int r106 = this.produced;
            int r107 = 1;
        L3:
            int r110 = 0;
            int r111 = 0;
        L5:
            if (this.cancelled == true) goto L6;
            boolean r112 = this.done;
            if (r112 == false) goto L16;
            Throwable r113 = this.error;
            if (r113 == null) goto L16;
            r100.clear();
            int r108 = r101.length;
        L13:
            if (r110 >= r108) goto L15;
            r101[r110].onError(r113);
            r110 = r110 + 1;
            goto L13
        L15:
            return;
        L16:
            boolean r114 = r100.isEmpty();
            if (r112 == false) goto L23;
            if (r114 == false) goto L23;
            int r109 = r101.length;
        L20:
            if (r110 >= r109) goto L22;
            r101[r110].onComplete();
            r110 = r110 + 1;
            goto L20
        L22:
            return;
        L23:
            if (r114 == true) goto L46;
            long r115 = r102.get(r105);
            long r116 = r103[r105];
            if (r115 != r116) goto L28;
        L41:
            r111 = r111 + 1;
        L42:
            r105 = r105 + 1;
            if (r105 != r104) goto L45;
            r105 = 0;
        L45:
            if (r111 != r104) goto L5;
        L28:
            if (r102.get(r104 + r105) != 0) goto L41;
            T r117 = r100.poll();     // Catch: Throwable -> L36
            if (r117 == null) goto L46;
            r101[r105].onNext(r117);
            r103[r105] = r116 + 1;
            r106 = r106 + 1;
            if (r106 != this.limit) goto L35;
            this.upstream.request(r106);
            r106 = 0;
        L35:
            r111 = 0;
        L36:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.cancel();
            int r118 = r101.length;
        L38:
            if (r110 >= r118) goto L40;
            r101[r110].onError(th);
            r110 = r110 + 1;
            goto L38
        L40:
            return;
        L46:
            int r119 = get();
            if (r119 == r107) goto L48;
            r107 = r119;
            goto L3
        L48:
            this.index = r105;
            this.produced = r106;
            r107 = addAndGet(-r107);
            if (r107 != 0) goto L3;
            return;
        L6:
            r100.clear();
        }

        public void drainSync() {
            j<T> r100 = this.queue;
            b<? super T>[] r101 = this.subscribers;
            AtomicLongArray r102 = this.requests;
            long[] r103 = this.emissions;
            int r104 = r103.length;
            int r105 = this.index;
            int r106 = 1;
        L3:
            int r107 = 0;
            int r110 = 0;
        L5:
            if (this.cancelled == true) goto L6;
            if (r100.isEmpty() == true) goto L10;
            long r111 = r102.get(r105);
            long r112 = r103[r105];
            if (r111 != r112) goto L17;
        L30:
            r110 = r110 + 1;
        L31:
            r105 = r105 + 1;
            if (r105 != r104) goto L34;
            r105 = 0;
        L34:
            if (r110 != r104) goto L5;
            int r108 = get();
            if (r108 == r106) goto L37;
            r106 = r108;
            goto L3
        L37:
            this.index = r105;
            r106 = addAndGet(-r106);
            if (r106 != 0) goto L3;
            return;
        L17:
            if (r102.get(r104 + r105) != 0) goto L30;
            T r113 = r100.poll();     // Catch: Throwable -> L25
            if (r113 == null) goto L20;
            r101[r105].onNext(r113);
            r103[r105] = r112 + 1;
            r110 = 0;
            goto L31
        L20:
            int r109 = r101.length;
        L21:
            if (r107 >= r109) goto L23;
            r101[r107].onComplete();
            r107 = r107 + 1;
            goto L21
        L23:
            return;
        L25:
            th = move-exception;
            Exceptions.throwIfFatal(th);
            this.upstream.cancel();
            int r114 = r101.length;
        L27:
            if (r107 >= r114) goto L29;
            r101[r107].onError(th);
            r107 = r107 + 1;
            goto L27
        L29:
            return;
        L10:
            int r115 = r101.length;
        L11:
            if (r107 >= r115) goto L13;
            r101[r107].onComplete();
            r107 = r107 + 1;
            goto L11
        L13:
            return;
        L6:
            r100.clear();
        }

        public void setupSubscribers() {
            b<? super T>[] r100 = this.subscribers;
            int r101 = r100.length;
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L8;
            if (this.cancelled == true) goto L6;
            int r103 = r102 + 1;
            this.subscriberCount.lazySet(r103);
            r100[r102].onSubscribe(new a(this, r102, r101));
            r102 = r103;
            goto L3
        L6:
            return;
        }

        public void drain() {
            if (getAndIncrement() == 0) goto L6;
            return;
        L6:
            if (this.sourceMode != 1) goto L8;
            drainSync();
            return;
        L8:
            drainAsync();
        }

        public void cancel(int r100) {
            if (this.requests.decrementAndGet(r100) != 0) goto L8;
            this.cancelled = true;
            this.upstream.cancel();
            if (getAndIncrement() != 0) goto L9;
            this.queue.clear();
            return;
        L9:
            return;
        }

        @Override // wwc.b
        public void onError(Throwable r100) {
            this.error = r100;
            this.done = true;
            drain();
        }

        @Override // wwc.b
        public void onNext(T r100) {
            if (this.sourceMode == 0) goto L5;
        L8:
            drain();
            return;
        L5:
            if (this.queue.offer(r100) == true) goto L8;
            this.upstream.cancel();
            onError(new MissingBackpressureException("Queue is full?"));
        }

        @Override // io.reactivex.g, wwc.b
        public void onSubscribe(c r100) {
            if (SubscriptionHelper.validate(this.upstream, r100) == false) goto L16;
            this.upstream = r100;
            if ((r100 instanceof vtc.g) == false) goto L14;
            vtc.g r101 = (vtc.g) r100;
            int r102 = r101.requestFusion(7);
            if (r102 != 1) goto L11;
            this.sourceMode = r102;
            this.queue = r101;
            this.done = true;
            setupSubscribers();
            drain();
            return;
        L11:
            if (r102 != 2) goto L14;
            this.sourceMode = r102;
            this.queue = r101;
            setupSubscribers();
            r100.request(this.prefetch);
            return;
        L14:
            this.queue = new SpscArrayQueue(this.prefetch);
            setupSubscribers();
            r100.request(this.prefetch);
            return;
        }

        public ParallelDispatcher(b<? super T>[] r100, int r101) {
            this.subscriberCount = new AtomicInteger();
            this.subscribers = r100;
            this.prefetch = r101;
            this.limit = r101 - (r101 >> 2);
            int r102 = r100.length;
            int r103 = r102 + r102;
            AtomicLongArray r104 = new AtomicLongArray(r103 + 1);
            this.requests = r104;
            r104.lazySet(r103, r102);
            this.emissions = new long[r102];
        }
    }

    public ParallelFromPublisher(Publisher r100) {
        this.f494736a = r100;
    }
}
