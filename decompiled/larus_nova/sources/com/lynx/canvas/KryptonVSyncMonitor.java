package com.lynx.canvas;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes32.dex */
public class KryptonVSyncMonitor {
    private WeakReference<KryptonApp> mApp;

    private static native void nativeOnBeforeVSyncEndTrigger(long r100, long r101);

    private static native void nativeOnVSyncTrigger(long r100, long r101);

    public KryptonVSyncMonitor(KryptonApp r100) {
        this.mApp = new WeakReference(r100);
    }

    public void registerBeforeAnimationEnd(final long r100) {
        KryptonApp r101 = this.mApp.get();
        if (r101 != null) goto L5;
        return;
    L5:
        KryptonFrameService r102 = (KryptonFrameService) r101.getService(KryptonFrameService.class);
        if (r102 != null) goto L8;
        return;
    L8:
        r102.registerBeforeVSyncEndListener(new AnonymousClass2(this, r100));
    }

    public void requestVSync(final long r100) {
        KryptonApp r101 = this.mApp.get();
        if (r101 != null) goto L5;
        return;
    L5:
        KryptonFrameService r102 = (KryptonFrameService) r101.getService(KryptonFrameService.class);
        if (r102 != null) goto L8;
        return;
    L8:
        r102.requestVSync(new AnonymousClass1(this, r100));
    }

    public static /* synthetic */ void access$000(long r100, long r101) {
        nativeOnVSyncTrigger(r100, r101);
    }

    public static /* synthetic */ void access$100(long r100, long r101) {
        nativeOnBeforeVSyncEndTrigger(r100, r101);
    }
}
