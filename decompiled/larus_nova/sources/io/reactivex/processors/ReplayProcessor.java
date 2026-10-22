package io.reactivex.processors;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import wwc.c;

/* JADX INFO: loaded from: classes41.dex */
public final class ReplayProcessor<T> extends a<T> {

    public static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final T value;

        public Node(T r100) {
            this.value = r100;
        }
    }

    public static final class ReplaySubscription<T> extends AtomicInteger implements c {
        private static final long serialVersionUID = 466549804534799122L;
        volatile boolean cancelled;
        final wwc.b<? super T> downstream;
        long emitted;
        Object index;
        final AtomicLong requested;
        final ReplayProcessor<T> state;

        @Override // wwc.c
        public void cancel() {
            if (this.cancelled == false) goto L5;
            return;
        L5:
            this.cancelled = true;
            throw null;
        }

        @Override // wwc.c
        public void request(long r100) {
            if (SubscriptionHelper.validate(r100) == true) goto L5;
            return;
        L5:
            io.reactivex.internal.util.b.a(this.requested, r100);
            throw null;
        }

        public ReplaySubscription(wwc.b<? super T> r100, ReplayProcessor<T> r101) {
            this.downstream = r100;
            this.requested = new AtomicLong();
        }
    }

    public static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final long time;
        final T value;

        public TimedNode(T r100, long r101) {
            this.value = r100;
            this.time = r101;
        }
    }
}
