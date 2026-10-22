package com.ss.android.lark.monitor.callback;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes36.dex */
public class MemoryCallbackManager {
    private static volatile MemoryCallbackManager mMemoryCallback;
    private final List<a> javaMemoryUsageCallbacks;
    private List<MemoryCallback> mMemoryCallbacks;

    public interface MemoryCallback {
        void onJavaMemoryReachTop();

        void onTrimMemory(int r100, int r101, int r102, int r103);
    }

    public interface a {
        void a();
    }

    public static MemoryCallbackManager getInstance() {
        if (mMemoryCallback != null) goto L15;
        monitor-enter(MemoryCallbackManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mMemoryCallback != null) goto L9;
        mMemoryCallback = new MemoryCallbackManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(MemoryCallbackManager.class);     // Catch: Throwable -> L11
    L15:
        return mMemoryCallback;
    }

    public void notifyMemoryReachTop() {
        Iterator<MemoryCallback> r100 = this.mMemoryCallbacks.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().onJavaMemoryReachTop();
        goto L4
    }

    private MemoryCallbackManager() {
        this.mMemoryCallbacks = new CopyOnWriteArrayList();
        this.javaMemoryUsageCallbacks = new CopyOnWriteArrayList();
    }

    public void notifyJavaMemoryUsedRate(float r100) {
        Iterator<a> r101 = this.javaMemoryUsageCallbacks.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().a();
        goto L4
    }

    public void registerJavaMemoryUsageCallback(a r100) {
        if (this.javaMemoryUsageCallbacks.contains(r100) == true) goto L6;
        this.javaMemoryUsageCallbacks.add(r100);
        return;
    }

    public void registerMemoryCallback(MemoryCallback r100) {
        if (this.mMemoryCallbacks.contains(r100) == true) goto L6;
        this.mMemoryCallbacks.add(r100);
        return;
    }

    public void unRegisterJavaMemoryUsageCallback(a r100) {
        this.javaMemoryUsageCallbacks.remove(r100);
    }

    public void unRegisterMemoryCallback(MemoryCallback r100) {
        if (this.mMemoryCallbacks.contains(r100) == false) goto L6;
        this.mMemoryCallbacks.remove(r100);
        return;
    }

    public void trimMemory(int r100, int r101, int r102, int r103) {
        Iterator<MemoryCallback> r104 = this.mMemoryCallbacks.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r104.next().onTrimMemory(r100, r101, r102, r103);
        goto L4
    }
}
