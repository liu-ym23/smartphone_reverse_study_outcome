package com.bytedance.android.shopping.buynow.yata.abilities;

import android.view.Choreographer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j implements Choreographer.FrameCallback {
    public final /* synthetic */ k a;
    public final /* synthetic */ b b;

    public j(k r1, b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r3) {
        b r4 = this.b;
        int r5 = r4.a + 1;
        r4.a = r5;
        if (r5 < r4.b) goto L5;
        r4.c.run();
        return;
    L5:
        k r6 = this.a;
        r6.getClass();
        Choreographer.getInstance().postFrameCallback(new j(r6, r4));
    }
}
