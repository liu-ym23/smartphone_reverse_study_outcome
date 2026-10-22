package com.google.common.util.concurrent;

import com.google.common.base.VerifyException;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class Uninterruptibles {
    private Uninterruptibles() {
    }

    public static void awaitTerminationUninterruptibly(ExecutorService r100) {
        if (awaitTerminationUninterruptibly(r100, Long.MAX_VALUE, TimeUnit.NANOSECONDS) == false) goto L6;
        return;
    L6:
        throw new VerifyException();
    }

    public static void awaitUninterruptibly(CountDownLatch r100) {
        boolean r101 = false;
    L12:
        r100.await();     // Catch: Throwable -> L7 InterruptedException -> L11
    L4:
        if (r101 == false) goto L15;
        ThreadMethodProxy.currentThread().interrupt();
        return;
    L15:
        return;
    L11:
        r101 = true;
    L7:
        th = move-exception;
        if (r101 == false) goto L10;
        ThreadMethodProxy.currentThread().interrupt();
    L10:
        throw th;
    }

    @ParametricNullness
    public static <V> V getUninterruptibly(Future<V> r100) throws ExecutionException {
        boolean r101 = false;
    L12:
        V r102 = r100.get();     // Catch: Throwable -> L7 InterruptedException -> L11
    L4:
        if (r101 == false) goto L6;
        ThreadMethodProxy.currentThread().interrupt();
    L6:
        return r102;
    L11:
        r101 = true;
    L7:
        th = move-exception;
        if (r101 == false) goto L10;
        ThreadMethodProxy.currentThread().interrupt();
    L10:
        throw th;
    }

    public static void joinUninterruptibly(Thread r100) {
        boolean r101 = false;
    L12:
        ThreadMethodProxy.join(r100);     // Catch: Throwable -> L7 InterruptedException -> L11
    L4:
        if (r101 == false) goto L15;
        ThreadMethodProxy.currentThread().interrupt();
        return;
    L15:
        return;
    L11:
        r101 = true;
    L7:
        th = move-exception;
        if (r101 == false) goto L10;
        ThreadMethodProxy.currentThread().interrupt();
    L10:
        throw th;
    }

    public static <E> E takeUninterruptibly(BlockingQueue<E> r100) {
        boolean r101 = false;
    L12:
        E r102 = r100.take();     // Catch: Throwable -> L7 InterruptedException -> L11
    L4:
        if (r101 == false) goto L6;
        ThreadMethodProxy.currentThread().interrupt();
    L6:
        return r102;
    L11:
        r101 = true;
    L7:
        th = move-exception;
        if (r101 == false) goto L10;
        ThreadMethodProxy.currentThread().interrupt();
    L10:
        throw th;
    }

    public static <E> void putUninterruptibly(BlockingQueue<E> r100, E r101) {
        boolean r102 = false;
    L12:
        r100.put(r101);     // Catch: Throwable -> L7 InterruptedException -> L11
    L4:
        if (r102 == false) goto L15;
        ThreadMethodProxy.currentThread().interrupt();
        return;
    L15:
        return;
    L11:
        r102 = true;
    L7:
        th = move-exception;
        if (r102 == false) goto L10;
        ThreadMethodProxy.currentThread().interrupt();
    L10:
        throw th;
    }

    public static void sleepUninterruptibly(long r100, TimeUnit r101) {
        boolean r102 = false;
        long r103 = r101.toNanos(r100);     // Catch: Throwable -> L12
        long r104 = System.nanoTime() + r103;
    L18:
        TimeUnit.NANOSECONDS.sleep(r103);     // Catch: InterruptedException -> L9 Throwable -> L12
    L6:
        if (r102 == false) goto L21;
        ThreadMethodProxy.currentThread().interrupt();
        return;
    L21:
        return;
    L9:
        r102 = true;
        r103 = r104 - System.nanoTime();
    L12:
        th = move-exception;
        if (r102 == false) goto L15;
        ThreadMethodProxy.currentThread().interrupt();
    L15:
        throw th;
    }

    public static boolean awaitTerminationUninterruptibly(ExecutorService r100, long r101, TimeUnit r102) {
        boolean r103 = false;
        long r104 = r102.toNanos(r101);     // Catch: Throwable -> L12
        long r105 = System.nanoTime() + r104;
    L18:
        boolean r106 = r100.awaitTermination(r104, TimeUnit.NANOSECONDS);     // Catch: InterruptedException -> L9 Throwable -> L12
    L6:
        if (r103 == false) goto L8;
        ThreadMethodProxy.currentThread().interrupt();
    L8:
        return r106;
    L9:
        r103 = true;
        r104 = r105 - System.nanoTime();
    L12:
        th = move-exception;
        if (r103 == false) goto L15;
        ThreadMethodProxy.currentThread().interrupt();
    L15:
        throw th;
    }

    public static boolean awaitUninterruptibly(CountDownLatch r100, long r101, TimeUnit r102) {
        boolean r103 = false;
        long r104 = r102.toNanos(r101);     // Catch: Throwable -> L12
        long r105 = System.nanoTime() + r104;
    L18:
        boolean r106 = r100.await(r104, TimeUnit.NANOSECONDS);     // Catch: InterruptedException -> L9 Throwable -> L12
    L6:
        if (r103 == false) goto L8;
        ThreadMethodProxy.currentThread().interrupt();
    L8:
        return r106;
    L9:
        r103 = true;
        r104 = r105 - System.nanoTime();
    L12:
        th = move-exception;
        if (r103 == false) goto L15;
        ThreadMethodProxy.currentThread().interrupt();
    L15:
        throw th;
    }

    @ParametricNullness
    public static <V> V getUninterruptibly(Future<V> r100, long r101, TimeUnit r102) throws ExecutionException, TimeoutException {
        boolean r103 = false;
        long r104 = r102.toNanos(r101);     // Catch: Throwable -> L12
        long r105 = System.nanoTime() + r104;
    L18:
        V r106 = r100.get(r104, TimeUnit.NANOSECONDS);     // Catch: InterruptedException -> L9 Throwable -> L12
    L6:
        if (r103 == false) goto L8;
        ThreadMethodProxy.currentThread().interrupt();
    L8:
        return r106;
    L9:
        r103 = true;
        r104 = r105 - System.nanoTime();
    L12:
        th = move-exception;
        if (r103 == false) goto L15;
        ThreadMethodProxy.currentThread().interrupt();
    L15:
        throw th;
    }

    public static void joinUninterruptibly(Thread r100, long r101, TimeUnit r102) {
        r100.getClass();
        boolean r103 = false;
        long r104 = r102.toNanos(r101);     // Catch: Throwable -> L12
        long r105 = System.nanoTime() + r104;
    L18:
        ThreadMethodProxy.timedJoin(TimeUnit.NANOSECONDS, r100, r104);     // Catch: InterruptedException -> L9 Throwable -> L12
    L6:
        if (r103 == false) goto L21;
        ThreadMethodProxy.currentThread().interrupt();
        return;
    L21:
        return;
    L9:
        r103 = true;
        r104 = r105 - System.nanoTime();
    L12:
        th = move-exception;
        if (r103 == false) goto L15;
        ThreadMethodProxy.currentThread().interrupt();
    L15:
        throw th;
    }

    public static boolean tryAcquireUninterruptibly(Semaphore r100, long r101, TimeUnit r102) {
        return tryAcquireUninterruptibly(r100, 1, r101, r102);
    }

    public static boolean tryLockUninterruptibly(Lock r100, long r101, TimeUnit r102) {
        boolean r103 = false;
        long r104 = r102.toNanos(r101);     // Catch: Throwable -> L12
        long r105 = System.nanoTime() + r104;
    L18:
        boolean r106 = r100.tryLock(r104, TimeUnit.NANOSECONDS);     // Catch: InterruptedException -> L9 Throwable -> L12
    L6:
        if (r103 == false) goto L8;
        ThreadMethodProxy.currentThread().interrupt();
    L8:
        return r106;
    L9:
        r103 = true;
        r104 = r105 - System.nanoTime();
    L12:
        th = move-exception;
        if (r103 == false) goto L15;
        ThreadMethodProxy.currentThread().interrupt();
    L15:
        throw th;
    }

    public static boolean awaitUninterruptibly(Condition r100, long r101, TimeUnit r102) {
        boolean r103 = false;
        long r104 = r102.toNanos(r101);     // Catch: Throwable -> L12
        long r105 = System.nanoTime() + r104;
    L18:
        boolean r106 = r100.await(r104, TimeUnit.NANOSECONDS);     // Catch: InterruptedException -> L9 Throwable -> L12
    L6:
        if (r103 == false) goto L8;
        ThreadMethodProxy.currentThread().interrupt();
    L8:
        return r106;
    L9:
        r103 = true;
        r104 = r105 - System.nanoTime();
    L12:
        th = move-exception;
        if (r103 == false) goto L15;
        ThreadMethodProxy.currentThread().interrupt();
    L15:
        throw th;
    }

    public static boolean tryAcquireUninterruptibly(Semaphore r100, int r101, long r102, TimeUnit r103) {
        boolean r104 = false;
        long r105 = r103.toNanos(r102);     // Catch: Throwable -> L12
        long r106 = System.nanoTime() + r105;
    L18:
        boolean r107 = r100.tryAcquire(r101, r105, TimeUnit.NANOSECONDS);     // Catch: InterruptedException -> L9 Throwable -> L12
    L6:
        if (r104 == false) goto L8;
        ThreadMethodProxy.currentThread().interrupt();
    L8:
        return r107;
    L9:
        r104 = true;
        r105 = r106 - System.nanoTime();
    L12:
        th = move-exception;
        if (r104 == false) goto L15;
        ThreadMethodProxy.currentThread().interrupt();
    L15:
        throw th;
    }
}
