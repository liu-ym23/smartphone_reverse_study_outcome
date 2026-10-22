package io.reactivex.internal.subscribers;

import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes41.dex */
public final class BlockingSubscriber<T> extends AtomicReference<wwc.c> implements io.reactivex.g<T>, wwc.c {
    public static final Object TERMINATED = null;
    private static final long serialVersionUID = -4875965440900746268L;
    final Queue<Object> queue;

    static {
        TERMINATED = new Object();
    }

    @Override // wwc.b
    public void onComplete() {
        this.queue.offer(NotificationLite.complete());
    }

    @Override // wwc.c
    public void cancel() {
        if (SubscriptionHelper.cancel(this) == false) goto L6;
        this.queue.offer(TERMINATED);
        return;
    }

    public boolean isCancelled() {
        if (get() != SubscriptionHelper.CANCELLED) goto L5;
        return true;
    L5:
        return false;
    }

    public BlockingSubscriber(Queue<Object> r100) {
        this.queue = r100;
    }

    @Override // wwc.b
    public void onError(Throwable r100) {
        this.queue.offer(NotificationLite.error(r100));
    }

    @Override // wwc.b
    public void onNext(T r100) {
        this.queue.offer(NotificationLite.next(r100));
    }

    @Override // io.reactivex.g, wwc.b
    public void onSubscribe(wwc.c r100) {
        if (SubscriptionHelper.setOnce(this, r100) == false) goto L6;
        this.queue.offer(NotificationLite.subscription(this));
        return;
    }

    @Override // wwc.c
    public void request(long r100) {
        get().request(r100);
    }
}
