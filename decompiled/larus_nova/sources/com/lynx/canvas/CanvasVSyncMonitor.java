package com.lynx.canvas;

/* JADX INFO: loaded from: classes32.dex */
public class CanvasVSyncMonitor {
    private KryptonFrameService mFrameService;

    public CanvasVSyncMonitor() {
    }

    private static native void nativeOnVSync(long r100, long r101);

    public void requestVSync(final long r100) {
        KryptonFrameService r101 = this.mFrameService;
        if (r101 == null) goto L6;
        r101.requestVSync(new AnonymousClass1(this, r100));
        return;
    }

    public void setFrameService(KryptonFrameService r100) {
        this.mFrameService = r100;
    }

    public static /* synthetic */ void access$000(long r100, long r101) {
        doFrame(r100, r101);
    }

    private static void doFrame(long r100, long r101) {
        nativeOnVSync(r100, r101);
    }
}
