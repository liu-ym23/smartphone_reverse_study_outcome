package com.bytedance.bmmt.base;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes8.dex */
public class ThreadUtils {

    /* JADX INFO: renamed from: com.bytedance.bmmt.base.ThreadUtils$1CaughtException, reason: invalid class name */
    public class C1CaughtException {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Exception f202125e;

        public C1CaughtException() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bmmt.base.ThreadUtils$1Result, reason: invalid class name */
    public class C1Result {
        public V value;

        public C1Result() {
        }
    }

    public interface BlockingOperation {
        void run() throws InterruptedException;
    }

    public static class ThreadChecker {
        private Thread thread;

        public void detachThread() {
            this.thread = null;
        }

        public void checkIsOnValidThread() {
            if (this.thread != null) goto L6;
            this.thread = ThreadMethodProxy.currentThread();
        L6:
            if (ThreadMethodProxy.currentThread() != this.thread) goto L9;
            return;
        L9:
            throw new IllegalStateException("Wrong thread");
        }

        public ThreadChecker() {
            this.thread = ThreadMethodProxy.currentThread();
        }
    }

    public ThreadUtils() {
    }

    public static void checkIsOnMainThread() {
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L6;
        return;
    L6:
        throw new IllegalStateException("Not on main thread!");
    }

    public static void awaitUninterruptibly(final CountDownLatch r100) {
        executeUninterruptibly(new AnonymousClass2(r100));
    }

    public static void executeUninterruptibly(BlockingOperation r100) {
        boolean r101 = false;
    L8:
        r100.run();     // Catch: InterruptedException -> L7
        if (r101 == false) goto L11;
        ThreadMethodProxy.currentThread().interrupt();
        return;
    L11:
        return;
    L7:
        r101 = true;
        goto L8
    }

    public static void joinUninterruptibly(final Thread r100) {
        executeUninterruptibly(new AnonymousClass1(r100));
    }

    public static boolean awaitUninterruptibly(CountDownLatch r100, long r110) {
        long r101 = SystemClock.elapsedRealtime();
        boolean r102 = false;
        long r103 = r110;
        boolean r104 = false;
    L10:
        r102 = r100.await(r103, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L5
    L7:
        if (r104 == false) goto L9;
        ThreadMethodProxy.currentThread().interrupt();
    L9:
        return r102;
    L5:
        r103 = r110 - (SystemClock.elapsedRealtime() - r101);
        r104 = true;
        if (r103 > 0) goto L10;
        goto L7
    }

    public static StackTraceElement[] concatStackTraces(StackTraceElement[] r100, StackTraceElement[] r101) {
        StackTraceElement[] r102 = new StackTraceElement[r100.length + r101.length];
        System.arraycopy(r100, 0, r102, 0, r100.length);
        System.arraycopy(r101, 0, r102, r100.length, r101.length);
        return r102;
    }

    public static <V> V invokeAtFrontUninterruptibly(Handler r100, final Callable<V> r101) {
        if (ThreadMethodProxy.getLooperThread(r100.getLooper()) == ThreadMethodProxy.currentThread()) goto L19;
        final C1Result r102 = new C1Result();
        final C1CaughtException r103 = new C1CaughtException();
        final CountDownLatch r104 = new CountDownLatch(1);
        if (r100.post(new AnonymousClass3(r102, r101, r103, r104)) == true) goto L13;
        return null;
    L13:
        awaitUninterruptibly(r104);
        if (r103.f202125e == null) goto L16;
        RuntimeException r105 = new RuntimeException(r103.f202125e);
        r105.setStackTrace(concatStackTraces(r103.f202125e.getStackTrace(), r105.getStackTrace()));
        throw r105;
    L16:
        return r102.value;
    L19:
        return r101.call();
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static boolean joinUninterruptibly(Thread r100, long r110) {
        long r101 = SystemClock.elapsedRealtime();
        boolean r102 = false;
        long r103 = r110;
    L4:
        if (r103 <= 0) goto L8;
        ThreadMethodProxy.join(r100, r103);     // Catch: InterruptedException -> L7
    L7:
        r103 = r110 - (SystemClock.elapsedRealtime() - r101);
        r102 = true;
    L8:
        if (r102 == false) goto L11;
        ThreadMethodProxy.currentThread().interrupt();
    L11:
        return !ThreadMethodProxy.isAlive(r100);
    }

    public static void invokeAtFrontUninterruptibly(Handler r100, final Runnable r101) {
        invokeAtFrontUninterruptibly(r100, new AnonymousClass4(r101));
    }
}
