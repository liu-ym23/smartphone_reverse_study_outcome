package com.bytedance.android.shopping.utils;

import android.animation.TypeEvaluator;
import android.graphics.PointF;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class v implements TypeEvaluator<PointF> {
    public v() {
    }

    @Override // android.animation.TypeEvaluator
    public final PointF evaluate(float r3, PointF r4, PointF r5) {
        PointF r6 = r4;
        PointF r7 = r5;
        if (r6 == null) goto L8;
        if (r7 == null) goto L8;
        float r0 = r6.x;
        float r1 = r0 + ((r7.x - r0) * r3);
        float r8 = r6.y;
        return new PointF(r1, r8 + ((r7.y - r8) * r3));
    L8:
        return new PointF(0.0f, 0.0f);
    }
}
