package com.bytedance.android.window.shop.home.presenter;

import kotlin.Pair;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class j extends AbsECWindowPresenter {
    @Override // com.bytedance.android.window.shop.home.presenter.AbsECWindowPresenter
    public final float E() {
        return 1.0f;
    }

    public j() {
    }

    @Override // com.bytedance.android.window.shop.home.presenter.AbsECWindowPresenter
    public final float Y(int r3) {
        if (r3 > 0) goto L5;
        return 0.0f;
    L5:
        Pair r1 = (Pair) O().getOffsetState().getValue();
        if (r1 == null) goto L16;
        int r0 = Math.abs(((Number) r1.getFirst()).intValue());
        if (O().isCroppedStyle() == false) goto L15;
        if (r0 <= W()) goto L13;
        r0 = r0 - W();
        goto L15
    L13:
        r0 = 0;
    L15:
        return RangesKt.coerceAtMost(r0 / r3, 1.0f);
    L16:
        return 0.0f;
    }

    public final float Z(int r2) {
        Pair r0 = (Pair) O().getOffsetState().getValue();
        if (r0 != null) goto L7;
        return 0.0f;
    L7:
        return RangesKt.coerceAtMost(Math.abs(((Number) r0.getFirst()).intValue()) / r2, 1.0f);
    }
}
