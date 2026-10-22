package com.lynx.animax;

import android.view.Choreographer;

/* JADX INFO: loaded from: classes32.dex */
public final class c0 implements Choreographer.FrameCallback {
    public c0() {
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r100) {
        VSyncMonitor.a(r100);
    }
}
