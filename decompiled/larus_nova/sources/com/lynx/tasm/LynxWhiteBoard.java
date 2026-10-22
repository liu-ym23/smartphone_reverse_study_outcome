package com.lynx.tasm;

import com.lynx.tasm.base.LLog;

/* JADX INFO: loaded from: classes32.dex */
final class LynxWhiteBoard {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f381741a;

    private native long nativeCreate();

    private native void nativeDestroy(long r100);

    public final void a() {
        long r100 = this.f381741a;
        if (r100 == 0) goto L6;
        nativeDestroy(r100);
        this.f381741a = 0;
        return;
    }

    public LynxWhiteBoard() {
        this.f381741a = 0;
        if (LynxEnv.inst().isNativeLibraryLoaded() == false) goto L5;
        this.f381741a = nativeCreate();
        return;
    L5:
        LLog.e("LynxWhiteBoard", "LynxWhiteBoard create failed, since LynxEnv init failed.");
    }
}
