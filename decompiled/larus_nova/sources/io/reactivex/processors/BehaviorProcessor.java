package io.reactivex.processors;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicLong;
import wwc.c;

/* JADX INFO: loaded from: classes41.dex */
public final class BehaviorProcessor<T> extends a<T> {

    public static final class BehaviorSubscription<T> extends AtomicLong implements c, io.reactivex.internal.util.a.InterfaceC6334a<Object> {
        private static final long serialVersionUID = 3293175281126227086L;
        volatile boolean cancelled;
        final wwc.b<? super T> downstream;
        boolean emitting;
        boolean fastPath;
        long index;
        boolean next;
        io.reactivex.internal.util.a<Object> queue;
        final BehaviorProcessor<T> state;

        @Override // wwc.c
        public void cancel() {
            if (this.cancelled == false) goto L5;
            return;
        L5:
            this.cancelled = true;
            throw null;
        }

        public void emitFirst() {
            if (this.cancelled == false) goto L5;
            return;
        L5:
            monitor-enter(this);
        L16:
            th = move-exception;
            throw th;
        L7:
            if (this.cancelled == false) goto L11;
            monitor-exit(this);     // Catch: Throwable -> L16
            return;
        L11:
            if (this.next == false) goto L15;
            monitor-exit(this);     // Catch: Throwable -> L16
            return;
        L15:
            throw null;     // Catch: Throwable -> L16
        }

        public void emitLoop() {
        L3:
            if (this.cancelled == true) goto L4;
            monitor-enter(this);
            io.reactivex.internal.util.a<Object> r100 = this.queue;     // Catch: Throwable -> L14
            if (r100 == null) goto L8;
            this.queue = null;     // Catch: Throwable -> L14
            monitor-exit(this);     // Catch: Throwable -> L14
            r100.c(this);
            goto L3
        L8:
            this.emitting = false;     // Catch: Throwable -> L14
            monitor-exit(this);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        }

        public boolean isFull() {
            if (get() != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // wwc.c
        public void request(long r100) {
            if (SubscriptionHelper.validate(r100) == false) goto L6;
            io.reactivex.internal.util.b.a(this, r100);
            return;
        }

        @Override // io.reactivex.internal.util.a.InterfaceC6334a, io.reactivex.functions.Predicate
        public boolean test(Object r100) {
            if (this.cancelled == false) goto L6;
            return true;
        L6:
            if (NotificationLite.isComplete(r100) == false) goto L10;
            this.downstream.onComplete();
            return true;
        L10:
            if (NotificationLite.isError(r100) == false) goto L13;
            this.downstream.onError(NotificationLite.getError(r100));
            return true;
        L13:
            long r101 = get();
            if (r101 == 0) goto L20;
            this.downstream.onNext((Object) NotificationLite.getValue(r100));
            if (r101 == Long.MAX_VALUE) goto L22;
            decrementAndGet();
            return false;
        L22:
            return false;
        L20:
            cancel();
            this.downstream.onError(new MissingBackpressureException("Could not deliver value due to lack of requests"));
            return true;
        }

        public BehaviorSubscription(wwc.b<? super T> r100, BehaviorProcessor<T> r101) {
            this.downstream = r100;
        }

        public void emitNext(Object r100, long r101) {
            if (this.cancelled == false) goto L6;
            return;
        L6:
            if (this.fastPath == true) goto L30;
            monitor-enter(this);
        L27:
            th = move-exception;
            throw th;
        L9:
            if (this.cancelled == false) goto L13;
            monitor-exit(this);     // Catch: Throwable -> L27
            return;
        L13:
            if (this.index != r101) goto L17;
            monitor-exit(this);     // Catch: Throwable -> L27
            return;
        L17:
            if (this.emitting == false) goto L24;
            io.reactivex.internal.util.a<Object> r102 = this.queue;     // Catch: Throwable -> L27
            if (r102 != null) goto L21;
            r102 = new io.reactivex.internal.util.a();     // Catch: Throwable -> L27
            this.queue = r102;     // Catch: Throwable -> L27
        L21:
            r102.b(r100);     // Catch: Throwable -> L27
            monitor-exit(this);     // Catch: Throwable -> L27
            return;
        L24:
            this.next = true;     // Catch: Throwable -> L27
            monitor-exit(this);     // Catch: Throwable -> L27
            this.fastPath = true;
        L30:
            test(r100);
        }
    }
}
