package com.bytedance.android.shopping.feed.utils;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class w implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ECDraweeView a;

    public w(ECDraweeView r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        Object r4 = r3.getAnimatedValue();     // Catch: Throwable -> L7
        if (r4 == null) goto L6;
        PointF r5 = (PointF) r4;     // Catch: Throwable -> L7
        this.a.setScaleX(r5.x);     // Catch: Throwable -> L7
        this.a.setScaleY(r5.x);     // Catch: Throwable -> L7
        this.a.setAlpha(r5.y);     // Catch: Throwable -> L7
        return;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.PointF");     // Catch: Throwable -> L7
    L7:
        this.a.setVisibility(4);
    }
}
