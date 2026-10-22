package com.lynx.tasm.behavior;

import android.view.PixelCopy;

/* JADX INFO: loaded from: classes32.dex */
public final class k0 implements PixelCopy.OnPixelCopyFinishedListener {
    public k0() {
    }

    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public final void onPixelCopyFinished(int r100) {
        Object r101 = LynxUIRenderer.f381914p;
        monitor-enter(r101);
        r101.notify();     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
