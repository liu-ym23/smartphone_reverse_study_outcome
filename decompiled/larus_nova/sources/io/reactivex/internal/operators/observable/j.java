package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.BlockingObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes41.dex */
public final class j {
    public static <T> void a(ObservableSource<? extends T> r100, Observer<? super T> r101) {
        LinkedBlockingQueue r102 = new LinkedBlockingQueue();
        BlockingObserver r103 = new BlockingObserver(r102);
        r101.onSubscribe(r103);
        r100.subscribe(r103);
    L4:
        if (r103.isDisposed() == true) goto L28;
        Object r104 = r102.poll();
        if (r104 != null) goto L14;
        r104 = r102.take();     // Catch: InterruptedException -> L10
    L10:
        e = move-exception;
        r103.dispose();
        r101.onError(e);
        return;
    L14:
        if (r103.isDisposed() == true) goto L29;
        if (r100 == BlockingObserver.TERMINATED) goto L19;
        if (NotificationLite.acceptFull(r104, r101) == false) goto L4;
        return;
    L19:
        return;
    L29:
        return;
    }

    public static <T> void b(ObservableSource<? extends T> r100, Consumer<? super T> r101, Consumer<? super Throwable> r102, Action r103) {
        ObjectHelper.requireNonNull(r101, "onNext is null");
        ObjectHelper.requireNonNull(r102, "onError is null");
        ObjectHelper.requireNonNull(r103, "onComplete is null");
        a(r100, new LambdaObserver(r101, r102, r103, Functions.emptyConsumer()));
    }
}
