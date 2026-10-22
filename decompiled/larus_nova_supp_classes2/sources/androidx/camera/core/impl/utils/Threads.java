package androidx.camera.core.impl.utils;

import android.os.Handler;
import android.os.Looper;
import androidx.core.util.Preconditions;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class Threads {
    private static final long TIMEOUT_RUN_ON_MAIN_MS = 30000;

    public static /* synthetic */ void a(Runnable r0, CountDownLatch r1) {
        lambda$runOnMainSync$0(r0, r1);
    }

    private static Handler getMainHandler() {
        return new Handler(Looper.getMainLooper());
    }

    public static void checkBackgroundThread() {
        Preconditions.checkState(isBackgroundThread(), "In application's main thread");
    }

    public static void checkMainThread() {
        Preconditions.checkState(isMainThread(), "Not in application's main thread");
    }

    public static boolean isBackgroundThread() {
        return !isMainThread();
    }

    public static boolean isMainThread() {
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        return true;
    L5:
        return false;
    }

    private Threads() {
    }

    public static void runOnMain(Runnable r1) {
        if (isMainThread() == false) goto L6;
        r1.run();
        return;
    L6:
        Preconditions.checkState(getMainHandler().post(r1), "Unable to post to main thread");
    }

    public static void runOnMainSync(final Runnable r3) {
        if (isMainThread() == false) goto L6;
        r3.run();
        return;
    L6:
        final CountDownLatch r0 = new CountDownLatch(1);
        Preconditions.checkState(getMainHandler().post(new a(r3, r0)), "Unable to post to main thread");
    L12:
        e = move-exception;
        throw new InterruptedRuntimeException(e);
    L8:
        if (r0.await(TIMEOUT_RUN_ON_MAIN_MS, TimeUnit.MILLISECONDS) == false) goto L11;
        return;
    L11:
        throw new IllegalStateException("Timeout to wait main thread execution");     // Catch: InterruptedException -> L12
    }

    private static /* synthetic */ void lambda$runOnMainSync$0(Runnable r0, CountDownLatch r1) {
        r0.run();     // Catch: Throwable -> L5
        r1.countDown();
        return;
    L5:
        th = move-exception;
        r1.countDown();
        throw th;
    }
}
