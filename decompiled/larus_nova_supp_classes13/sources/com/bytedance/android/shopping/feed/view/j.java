package com.bytedance.android.shopping.feed.view;

import android.animation.ValueAnimator;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ InnerFeedPageHeadWidget a;

    public j(InnerFeedPageHeadWidget r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        Object r3 = r2.getAnimatedValue();
        if ((r3 instanceof Float) == true) goto L5;
        r3 = null;
    L5:
        Float r4 = (Float) r3;
        if (r4 == null) goto L8;
        float r5 = r4.floatValue();
    L9:
        TextView r0 = this.a.g;
        if (r0 == null) goto L13;
        r0.setScaleX(r5);
        r0.setScaleY(r5);
        return;
    L13:
        return;
    L8:
        r5 = 1.0f;
        goto L9
    }
}
