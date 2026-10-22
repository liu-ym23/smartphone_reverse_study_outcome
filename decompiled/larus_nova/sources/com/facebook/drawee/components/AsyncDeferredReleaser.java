package com.facebook.drawee.components;

import com.facebook.common.executors.FrescoHandlerThread;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes23.dex */
public class AsyncDeferredReleaser extends DeferredReleaser {
    private static final long RELEASE_DELAY_MS = 16;
    private static AsyncDeferredReleaser sInstance;
    private final ConcurrentHashMap<DeferredReleaser.Releasable, Runnable> pendingTasks;

    public static synchronized AsyncDeferredReleaser getInstance() {
        monitor-enter(AsyncDeferredReleaser.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new AsyncDeferredReleaser();     // Catch: Throwable -> L10
    L7:
        AsyncDeferredReleaser r100 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(AsyncDeferredReleaser.class);
        return r100;
    }

    public AsyncDeferredReleaser() {
        this.pendingTasks = new ConcurrentHashMap();
    }

    public static /* synthetic */ ConcurrentHashMap access$000(AsyncDeferredReleaser r100) {
        return r100.pendingTasks;
    }

    @Override // com.facebook.drawee.components.DeferredReleaser
    public void cancelDeferredRelease(DeferredReleaser.Releasable r100) {
        Runnable r101 = this.pendingTasks.remove(r100);
        if (r101 == null) goto L6;
        FrescoHandlerThread.removeAsync(r101);
        return;
    }

    @Override // com.facebook.drawee.components.DeferredReleaser
    public void scheduleDeferredRelease(final DeferredReleaser.Releasable r100) {
        Runnable r101 = new AnonymousClass1(this, r100);
        this.pendingTasks.put(r100, r101);
        FrescoHandlerThread.runAsyncDelayed(r101, 16);
    }
}
