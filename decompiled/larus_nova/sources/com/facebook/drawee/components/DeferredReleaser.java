package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.common.internal.Preconditions;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/* JADX INFO: loaded from: classes23.dex */
public class DeferredReleaser {
    public static boolean opt;
    private static int releasedCount;
    private static DeferredReleaser sInstance;
    private static final boolean shouldCheck = false;
    private final Set<Releasable> mPendingReleasables;
    private final Handler mUiHandler;
    private final Runnable releaseRunnable;

    public interface Releasable {
        void release();
    }

    static {
        if (new Random().nextFloat() >= 0.005f) goto L5;
        boolean r100 = true;
    L6:
        shouldCheck = r100;
        return;
    L5:
        r100 = false;
        goto L6
    }

    public static /* synthetic */ int access$210() {
        int r100 = releasedCount;
        releasedCount = r100 - 1;
        return r100;
    }

    public static synchronized DeferredReleaser getInstance() {
        monitor-enter(DeferredReleaser.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new DeferredReleaser();     // Catch: Throwable -> L10
    L7:
        DeferredReleaser r100 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(DeferredReleaser.class);
        return r100;
    }

    public DeferredReleaser() {
        this.releaseRunnable = new AnonymousClass1(this);
        this.mPendingReleasables = new HashSet();
        this.mUiHandler = new Handler(Looper.getMainLooper());
    }

    private static void ensureOnUiThread() {
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L5;
        boolean r100 = true;
    L6:
        Preconditions.checkState(r100);
        return;
    L5:
        r100 = false;
        goto L6
    }

    public static /* synthetic */ void access$000() {
        ensureOnUiThread();
    }

    public static /* synthetic */ int access$200() {
        return releasedCount;
    }

    public static /* synthetic */ Set access$100(DeferredReleaser r100) {
        return r100.mPendingReleasables;
    }

    public static /* synthetic */ int access$202(int r100) {
        releasedCount = r100;
        return r100;
    }

    public void cancelDeferredRelease(Releasable r100) {
        if (opt == true) goto L5;
    L6:
        ensureOnUiThread();
    L7:
        this.mPendingReleasables.remove(r100);
        return;
    L5:
        if (shouldCheck == false) goto L7;
        goto L6
    }

    public void scheduleDeferredRelease(Releasable r100) {
        if (opt == true) goto L5;
    L6:
        ensureOnUiThread();
    L8:
        if (this.mPendingReleasables.add(r100) == true) goto L11;
        return;
    L11:
        if (this.mPendingReleasables.size() == 1) goto L13;
        return;
    L13:
        if (opt == false) goto L18;
        int r101 = releasedCount;
        if (r101 <= 0) goto L17;
        return;
    L17:
        releasedCount = r101 + 1;
    L18:
        this.mUiHandler.post(this.releaseRunnable);
        return;
    L5:
        if (shouldCheck == false) goto L8;
        goto L6
    }
}
