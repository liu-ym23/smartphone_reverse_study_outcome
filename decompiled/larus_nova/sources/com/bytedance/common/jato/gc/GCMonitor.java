package com.bytedance.common.jato.gc;

import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.common.jato.JatoNativeLoader;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes15.dex */
public class GCMonitor {
    private static AsyncCallbackThreadProvider asyncCallbackThreadProvider = null;
    private static int monitorFlags = 7;
    private final AtomicInteger asyncAllThreadWaitCount;
    private HandlerThread asyncCallbackThread;
    private final AtomicInteger asyncListenerCount;
    private GCListener[] asyncListeners;
    private final boolean inited;
    private final AtomicInteger syncAllThreadWaitCount;
    private final AtomicInteger syncListenerCount;
    private GCListener[] syncListeners;

    public interface AsyncCallbackThreadProvider {
        HandlerThread getHandlerThread();
    }

    public static class DefaultAsyncCallbackThreadProvider implements AsyncCallbackThreadProvider {
        private HandlerThread handlerThread;

        public DefaultAsyncCallbackThreadProvider() {
        }

        @Override // com.bytedance.common.jato.gc.GCMonitor.AsyncCallbackThreadProvider
        public HandlerThread getHandlerThread() {
            if (this.handlerThread != null) goto L6;
            PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("gc_notification");
            this.handlerThread = r100;
            ThreadMethodProxy.start(r100);
        L6:
            return this.handlerThread;
        }
    }

    public static final class InstanceHolder {
        static final GCMonitor sInstance = null;

        static {
            sInstance = new GCMonitor(null);
        }
    }

    private native boolean init(int r100);

    private native void initNotificationInWorkingThread();

    private native void notifyJavaCallbackCountChange(int r100, int r101, int r102, int r103);

    private native boolean registerCallbackPtr(long r100, long r101, long r102, boolean r103);

    private native void setForceClearSoft(boolean r100);

    private native boolean unregisterCallbackPtr(long r100, long r101, long r102, boolean r103);

    private void ensureAsyncThreadInited() {
        if (this.asyncCallbackThread != null) goto L6;
        HandlerThread r100 = asyncCallbackThreadProvider.getHandlerThread();
        new Handler(r100.getLooper()).post(new AnonymousClass1(this));
        this.asyncCallbackThread = r100;
        return;
    }

    private GCMonitor() {
        boolean r100 = true;
        this.syncListeners = new GCListener[1];
        this.syncListenerCount = new AtomicInteger(0);
        this.syncAllThreadWaitCount = new AtomicInteger(0);
        this.asyncListeners = new GCListener[1];
        this.asyncListenerCount = new AtomicInteger(0);
        this.asyncAllThreadWaitCount = new AtomicInteger(0);
        if (asyncCallbackThreadProvider != null) goto L6;
        asyncCallbackThreadProvider = new DefaultAsyncCallbackThreadProvider();
    L6:
        if (JatoNativeLoader.loadLibrary() == true) goto L8;
    L10:
        r100 = false;
    L11:
        this.inited = r100;
        return;
    L8:
        if (init(monitorFlags) == false) goto L10;
        goto L10
    }

    public static GCMonitor getInstance() {
        return InstanceHolder.sInstance;
    }

    public /* synthetic */ GCMonitor(AnonymousClass1 r100) {
        this();
    }

    public static /* synthetic */ void access$100(GCMonitor r100) {
        r100.initNotificationInWorkingThread();
    }

    public synchronized boolean addListener(GCListener r100, boolean r101) {
        monitor-enter(this);
        boolean r102 = false;
        if (r100 != null) goto L31;
    L29:
        monitor-exit(this);
        return false;
    L31:
    L26:
        th = move-exception;
        throw th;
    L6:
        if (this.inited == false) goto L29;
        if (r101 == false) goto L16;
        GCListener[] r103 = registerInArray(r100, this.asyncListeners, this.asyncListenerCount, this.asyncAllThreadWaitCount);     // Catch: Throwable -> L26
        if (r103 != null) goto L13;
    L22:
        if (r102 == false) goto L24;
        notifyJavaCallbackCountChange(this.syncListenerCount.get(), this.asyncListenerCount.get(), this.syncAllThreadWaitCount.get(), this.asyncAllThreadWaitCount.get());     // Catch: Throwable -> L26
    L24:
        monitor-exit(this);
        return r102;
    L13:
        if (r103 == this.asyncListeners) goto L15;
        this.asyncListeners = r103;     // Catch: Throwable -> L26
    L15:
        ensureAsyncThreadInited();     // Catch: Throwable -> L26
    L21:
        r102 = true;
        goto L22
    L16:
        GCListener[] r104 = registerInArray(r100, this.syncListeners, this.syncListenerCount, this.syncAllThreadWaitCount);     // Catch: Throwable -> L26
        if (r104 == null) goto L22;
        if (r104 == this.syncListeners) goto L21;
        this.syncListeners = r104;     // Catch: Throwable -> L26
        goto L21
    }

    public synchronized boolean removeListener(GCListener r100, boolean r101) {
        monitor-enter(this);
        if (r100 != null) goto L22;
    L19:
        monitor-exit(this);
        return false;
    L22:
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.inited == false) goto L19;
        if (r101 == false) goto L11;
        boolean r102 = unregisterInArray(r100, this.asyncListeners, this.asyncListenerCount, this.asyncAllThreadWaitCount);     // Catch: Throwable -> L16
        if (r102 == false) goto L12;
        ensureAsyncThreadInited();     // Catch: Throwable -> L16
    L12:
        if (r102 == false) goto L14;
        notifyJavaCallbackCountChange(this.syncListenerCount.get(), this.asyncListenerCount.get(), this.syncAllThreadWaitCount.get(), this.asyncAllThreadWaitCount.get());     // Catch: Throwable -> L16
    L14:
        monitor-exit(this);
        return r102;
    L11:
        r102 = unregisterInArray(r100, this.syncListeners, this.syncListenerCount, this.syncAllThreadWaitCount);     // Catch: Throwable -> L16
        goto L12
    }

    private synchronized void dispatchGCStart(boolean r100, int r101, int r102, int r103) {
        monitor-enter(this);
        if (r100 == false) goto L5;
        GCListener[] r104 = this.asyncListeners;     // Catch: Throwable -> L18
    L6:
        if (r100 == false) goto L9;
        AtomicInteger r105 = this.asyncListenerCount;     // Catch: Throwable -> L18
    L8:
        int r106 = r105.get();     // Catch: Throwable -> L18
        int r107 = 0;
    L11:
        if (r107 >= r106) goto L16;
        GCListener r108 = r104[r107];     // Catch: Throwable -> L18
        if (r108 == null) goto L15;
        r108.onGCStart(r101, r102, r103);     // Catch: Throwable -> L18
    L15:
        r107 = r107 + 1;
        goto L11
    L16:
        monitor-exit(this);
        return;
    L9:
        r105 = this.syncListenerCount;     // Catch: Throwable -> L18
        goto L8
    L5:
        r104 = this.syncListeners;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    private GCListener[] registerInArray(GCListener r100, GCListener[] r101, AtomicInteger r102, AtomicInteger r103) {
        int r104 = r102.get();
        if (r104 != r101.length) goto L6;
        GCListener[] r105 = new GCListener[r104 * 2];
        System.arraycopy(r101, 0, r105, 0, r104);
        r101 = r105;
    L8:
        r101[r104] = r100;
        if (r102.compareAndSet(r104, r104 + 1) == true) goto L12;
        return null;
    L12:
        if (r100.callbackOnMainThreadWaitOnly() == true) goto L14;
        r103.incrementAndGet();
    L14:
        return r101;
    L6:
        if (r104 <= r101.length) goto L8;
        return null;
    }

    private boolean unregisterInArray(GCListener r100, GCListener[] r101, AtomicInteger r102, AtomicInteger r103) {
        int r104 = r102.get();
        if (r104 != 0) goto L5;
        return false;
    L5:
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L12;
        if (r101[r105] == r100) goto L13;
        r105 = r105 + 1;
    L13:
        if (r105 == (-1)) goto L24;
        int r106 = r104 - 1;
        if (r102.compareAndSet(r104, r106) == false) goto L24;
        if (r100.callbackOnMainThreadWaitOnly() == true) goto L20;
        r103.decrementAndGet();
    L20:
        if (r105 >= r106) goto L27;
        r101[r105] = r101[r106];
        return true;
    L27:
        return true;
    L24:
        return false;
    L12:
        r105 = -1;
        goto L13
    }

    private synchronized void dispatchWaitGC(boolean r100, boolean r101, int r102, int r103, int r104) {
        monitor-enter(this);
        if (r100 == false) goto L5;
        GCListener[] r105 = this.asyncListeners;     // Catch: Throwable -> L22
    L6:
        if (r100 == false) goto L9;
        AtomicInteger r106 = this.asyncListenerCount;     // Catch: Throwable -> L22
    L8:
        int r107 = r106.get();     // Catch: Throwable -> L22
        int r108 = 0;
    L11:
        if (r108 >= r107) goto L20;
        GCListener r109 = r105[r108];     // Catch: Throwable -> L22
        if (r109 == null) goto L19;
        if (r109.callbackOnMainThreadWaitOnly() == false) goto L18;
        if (r101 == false) goto L19;
    L18:
        r109.onWaitGc(r102, r103, r104);     // Catch: Throwable -> L22
    L19:
        r108 = r108 + 1;
        goto L11
    L20:
        monitor-exit(this);
        return;
    L9:
        r106 = this.syncListenerCount;     // Catch: Throwable -> L22
        goto L8
    L5:
        r105 = this.syncListeners;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    private synchronized void dispatchGCEnd(boolean r210, int r211, int r212, int r213, long r214, boolean r215, long r216, long r310, long r311, long r312, long r313) {
        monitor-enter(this);
        if (r210 == false) goto L6;
        GCListener[] r100 = this.asyncListeners;     // Catch: Throwable -> L19
    L7:
        if (r210 == false) goto L10;
        AtomicInteger r101 = this.asyncListenerCount;     // Catch: Throwable -> L19
    L9:
        int r102 = r101.get();     // Catch: Throwable -> L19
        int r103 = 0;
    L12:
        if (r103 >= r102) goto L17;
        GCListener r104 = r100[r103];     // Catch: Throwable -> L19
        if (r104 == null) goto L16;
        r104.onGCEnd(r211, r212, r213, r214, r215, r216, r310, r311, r312, r313);     // Catch: Throwable -> L19
    L16:
        r103 = r103 + 1;
        goto L12
    L17:
        monitor-exit(this);
        return;
    L10:
        r101 = this.syncListenerCount;     // Catch: Throwable -> L19
        goto L9
    L6:
        r100 = this.syncListeners;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }
}
