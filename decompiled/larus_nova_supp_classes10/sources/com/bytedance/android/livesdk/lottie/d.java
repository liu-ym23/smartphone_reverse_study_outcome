package com.bytedance.android.livesdk.lottie;

import android.graphics.Bitmap;
import vl2.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class d extends rg2.e {
    public final /* synthetic */ m a;

    public d(m r1) {
        this.a = r1;
    }

    public final Bitmap q(com.airbnb.lottie.h r2) {
        Bitmap r3 = this.a.d.get(r2.d);
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r3.isRecycled() == true) goto L9;
        return r3;
    L9:
        return null;
    }
}
