package dagger.hilt.android.internal;

import android.os.Looper;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes41.dex */
public final class ThreadUtil {
    private static Thread mainThread;

    private ThreadUtil() {
    }

    public static boolean isMainThread() {
        if (mainThread != null) goto L6;
        mainThread = ThreadMethodProxy.getLooperThread(Looper.getMainLooper());
    L6:
        if (ThreadMethodProxy.currentThread() != mainThread) goto L8;
        return true;
    L8:
        return false;
    }

    public static void ensureMainThread() {
        if (isMainThread() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Must be called on the Main thread.");
    }
}
