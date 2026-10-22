package io.reactivex.internal.util;

import io.reactivex.Observer;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes41.dex */
public final class g {
    public static void a(Observer<?> r100, AtomicInteger r101, AtomicThrowable r102) {
        if (r101.getAndIncrement() != 0) goto L9;
        Throwable r103 = r102.terminate();
        if (r103 == null) goto L7;
        r100.onError(r103);
        return;
    L7:
        r100.onComplete();
        return;
    }

    public static void b(wwc.b<?> r100, AtomicInteger r101, AtomicThrowable r102) {
        if (r101.getAndIncrement() != 0) goto L9;
        Throwable r103 = r102.terminate();
        if (r103 == null) goto L7;
        r100.onError(r103);
        return;
    L7:
        r100.onComplete();
        return;
    }

    public static void c(Observer<?> r100, Throwable r101, AtomicInteger r102, AtomicThrowable r103) {
        if (r103.addThrowable(r101) == true) goto L5;
        RxJavaPlugins.onError(r101);
        return;
    L5:
        if (r102.getAndIncrement() != 0) goto L9;
        r100.onError(r103.terminate());
        return;
    }

    public static void d(wwc.b<?> r100, Throwable r101, AtomicInteger r102, AtomicThrowable r103) {
        if (r103.addThrowable(r101) == true) goto L5;
        RxJavaPlugins.onError(r101);
        return;
    L5:
        if (r102.getAndIncrement() != 0) goto L9;
        r100.onError(r103.terminate());
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void e(Observer<? super T> r100, T r101, AtomicInteger r102, AtomicThrowable r103) {
        if (r102.get() == 0) goto L5;
        return;
    L5:
        if (r102.compareAndSet(0, 1) == false) goto L14;
        r100.onNext(r101);
        if (r102.decrementAndGet() == 0) goto L15;
        Throwable r104 = r103.terminate();
        if (r104 == null) goto L11;
        r100.onError(r104);
        return;
    L11:
        r100.onComplete();
        return;
    L15:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void f(wwc.b<? super T> r100, T r101, AtomicInteger r102, AtomicThrowable r103) {
        if (r102.get() == 0) goto L5;
        return;
    L5:
        if (r102.compareAndSet(0, 1) == false) goto L14;
        r100.onNext(r101);
        if (r102.decrementAndGet() == 0) goto L15;
        Throwable r104 = r103.terminate();
        if (r104 == null) goto L11;
        r100.onError(r104);
        return;
    L11:
        r100.onComplete();
        return;
    L15:
        return;
    }
}
