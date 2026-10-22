package io.reactivex.processors;

import io.reactivex.annotations.BackpressureKind;
import io.reactivex.annotations.BackpressureSupport;
import io.reactivex.annotations.SchedulerSupport;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import wwc.c;

/* JADX INFO: loaded from: classes41.dex */
@SchedulerSupport("none")
@BackpressureSupport(BackpressureKind.FULL)
public final class MulticastProcessor<T> extends a<T> {

    public static final class MulticastSubscription<T> extends AtomicLong implements c {
        private static final long serialVersionUID = -363282618957264509L;
        final wwc.b<? super T> downstream;
        long emitted;
        final MulticastProcessor<T> parent;

        @Override // wwc.c
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) goto L6;
            return;
        L6:
            throw null;
        }

        public void onComplete() {
            if (get() == Long.MIN_VALUE) goto L6;
            this.downstream.onComplete();
            return;
        }

        public void onError(Throwable r100) {
            if (get() == Long.MIN_VALUE) goto L6;
            this.downstream.onError(r100);
            return;
        }

        public void onNext(T r100) {
            if (get() == Long.MIN_VALUE) goto L6;
            this.emitted++;
            this.downstream.onNext(r100);
            return;
        }

        @Override // wwc.c
        public void request(long r110) {
            if (SubscriptionHelper.validate(r110) == false) goto L18;
        L4:
            long r100 = get();
            if (r100 == Long.MIN_VALUE) goto L23;
            long r101 = Long.MAX_VALUE;
            if (r100 == Long.MAX_VALUE) goto L24;
            long r102 = r100 + r110;
            if (r102 < 0) goto L14;
            r101 = r102;
        L14:
            if (compareAndSet(r100, r101) == false) goto L4;
            throw null;
        L24:
            return;
        L23:
            return;
        }

        public MulticastSubscription(wwc.b<? super T> r100, MulticastProcessor<T> r101) {
            this.downstream = r100;
        }
    }
}
