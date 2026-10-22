package com.ss.android.ttve.nativePort;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes38.dex */
public final class e extends d {
    public e(byte[] r100) {
        super(r100);
    }

    public final PointF[] h(int r100) {
        PointF[] r101 = new PointF[r100];
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        r101[r102] = new PointF(b(), b());
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }
}
