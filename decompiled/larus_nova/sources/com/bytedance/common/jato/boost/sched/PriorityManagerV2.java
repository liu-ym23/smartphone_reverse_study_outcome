package com.bytedance.common.jato.boost.sched;

import android.app.Application;
import android.os.Process;
import com.bytedance.common.jato.JatoNativeLoader;

/* JADX INFO: loaded from: classes15.dex */
public class PriorityManagerV2 {
    private static volatile Application.ActivityLifecycleCallbacks gActivityCallback;
    private static volatile int renderThreadTid;

    public PriorityManagerV2() {
    }

    private static native void fetchRenderThreadTid();

    private static native int getRenderThreadTid();

    private static native int nativeInit(boolean r100);

    private static native int nativeResetPriority(int r100);

    private static native int nativeSetPriority(int r100, int r101);

    public static synchronized void resetRenderThread() {
        monitor-enter(PriorityManagerV2.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (renderThreadTid <= 0) goto L7;
        resetPriority(renderThreadTid);     // Catch: Throwable -> L9
    L7:
        monitor-exit(PriorityManagerV2.class);
    }

    static {
        JatoNativeLoader.loadLibrary();
        renderThreadTid = -1;
        gActivityCallback = null;
    }

    public static /* synthetic */ int access$100() {
        return getRenderThreadTid();
    }

    public static void resetPriority() {
        resetPriority(Process.myTid());
    }

    public static /* synthetic */ int access$000() {
        return renderThreadTid;
    }

    public static /* synthetic */ int access$002(int r100) {
        renderThreadTid = r100;
        return r100;
    }

    public static void resetPriority(int r100) {
        nativeResetPriority(r100);
    }

    public static void setPriority(int r100) {
        setPriority(Process.myTid(), r100);
    }

    public static void init(boolean r100, boolean r101) {
        nativeInit(r100);
        fetchRenderThreadTid();
        if (r101 == false) goto L6;
        ThreadPrioProtector.nativeInit();
        return;
    }

    public static synchronized void promoteRenderThread(final Application r100, final int r101) {
        monitor-enter(PriorityManagerV2.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (renderThreadTid >= 0) goto L8;
        renderThreadTid = getRenderThreadTid();     // Catch: Throwable -> L15
    L8:
        if (renderThreadTid <= 0) goto L11;
        setPriority(renderThreadTid, r101);     // Catch: Throwable -> L15
    L13:
        monitor-exit(PriorityManagerV2.class);
        return;
    L11:
        if (gActivityCallback != null) goto L13;
        gActivityCallback = new AnonymousClass1(r101, r100);     // Catch: Throwable -> L15
        r100.registerActivityLifecycleCallbacks(gActivityCallback);     // Catch: Throwable -> L15
        goto L13
    }

    public static void setPriority(int r100, int r101) {
        nativeSetPriority(r100, r101);
    }
}
