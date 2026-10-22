package com.bytedance.android.shopping.utils;

import android.animation.TypeEvaluator;
import android.graphics.Point;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d implements TypeEvaluator<Point> {
    public final Point a;

    public d(Point r2) {
        Intrinsics.checkNotNullParameter(r2, "controlPoint");
        this.a = r2;
    }

    @Override // android.animation.TypeEvaluator
    public final Point evaluate(float r6, Point r7, Point r8) {
        Point r9 = r7;
        Point r10 = r8;
        if (r9 == null) goto L8;
        if (r10 == null) goto L8;
        float r0 = 1 - r6;
        float r1 = r0 * r0;
        float r2 = r9.x * r1;
        float r3 = (2 * r6) * r0;
        Point r4 = this.a;
        float r11 = r6 * r6;
        return new Point((int) ((r2 + (r4.x * r3)) + (r10.x * r11)), (int) (((r1 * r9.y) + (r3 * r4.y)) + (r11 * r10.y)));
    L8:
        return new Point(0, 0);
    }
}
