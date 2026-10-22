package io.reactivex.internal.operators.flowable;

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscribers.BlockingSubscriber;
import io.reactivex.internal.subscribers.BoundedSubscriber;
import io.reactivex.internal.subscribers.LambdaSubscriber;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.LinkedBlockingQueue;
import org.reactivestreams.Publisher;

/* JADX INFO: loaded from: classes41.dex */
public final class g {
    public static <T> void c(Publisher<? extends T> r100, wwc.b<? super T> r101) {
        LinkedBlockingQueue r102 = new LinkedBlockingQueue();
        BlockingSubscriber r103 = new BlockingSubscriber(r102);
        r100.subscribe(r103);
    L23:
        if (r103.isCancelled() == true) goto L31;
        Object r104 = r102.poll();     // Catch: InterruptedException -> L20
        if (r104 != null) goto L13;
        if (r103.isCancelled() == true) goto L32;
        io.reactivex.internal.util.c.b();     // Catch: InterruptedException -> L20
        r104 = r102.take();     // Catch: InterruptedException -> L20
        goto L13
    L32:
        return;
    L13:
        if (r103.isCancelled() == true) goto L33;
        if (r104 == BlockingSubscriber.TERMINATED) goto L34;
        if (NotificationLite.acceptFull(r104, r101) == false) goto L23;
        return;
    L34:
        return;
    L33:
        return;
    L31:
        return;
    L20:
        e = move-exception;
        r103.cancel();
        r101.onError(e);
    }

    public static <T> void a(Publisher<? extends T> r100, Consumer<? super T> r101, Consumer<? super Throwable> r102, Action r103) {
        ObjectHelper.requireNonNull(r101, "onNext is null");
        ObjectHelper.requireNonNull(r102, "onError is null");
        ObjectHelper.requireNonNull(r103, "onComplete is null");
        c(r100, new LambdaSubscriber(r101, r102, r103, Functions.REQUEST_MAX));
    }

    public static <T> void b(Publisher<? extends T> r100, Consumer<? super T> r101, Consumer<? super Throwable> r102, Action r110, int r111) {
        ObjectHelper.requireNonNull(r101, "onNext is null");
        ObjectHelper.requireNonNull(r102, "onError is null");
        ObjectHelper.requireNonNull(r110, "onComplete is null");
        ObjectHelper.verifyPositive(r111, "number > 0 required");
        c(r100, new BoundedSubscriber(r101, r102, r110, Functions.boundedConsumer(r111), r111));
    }
}
