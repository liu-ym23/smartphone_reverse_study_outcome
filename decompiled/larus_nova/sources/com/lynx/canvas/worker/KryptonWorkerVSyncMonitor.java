package com.lynx.canvas.worker;

import android.view.Choreographer;

/* JADX INFO: loaded from: classes32.dex */
public class KryptonWorkerVSyncMonitor {
    public KryptonWorkerVSyncMonitor() {
    }

    private static native void nativeOnWorkerVSync(long r100, long r101);

    private static void requestWorkerVSync(final long r100) {
        Choreographer.getInstance().postFrameCallback(new AnonymousClass1(r100));
    }

    public static /* synthetic */ void access$000(long r100, long r101) {
        nativeOnWorkerVSync(r100, r101);
    }
}
