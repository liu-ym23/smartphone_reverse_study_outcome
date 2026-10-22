package com.ss.android.ttve.nativePort;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes38.dex */
public final class f extends d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ByteBuffer f449976c;

    public f(int r100) {
        super(new byte[1]);
        this.f449976c = ByteBuffer.allocateDirect(r100);
    }

    public final void h(int r100) {
        byte[] r101 = new byte[4];
        int r102 = 0;
    L3:
        if (r102 >= 4) goto L5;
        r101[r102] = (byte) ((r100 >> (r102 * 8)) & 255);
        r102 = r102 + 1;
        goto L3
    L5:
        this.f449976c.put(r101);
    }
}
