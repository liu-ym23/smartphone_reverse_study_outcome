package com.bytedance.android.livesdk.livecommerce.playback.card.widget;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ExplainProductCardWithBuyButtonView a;

    public b(ExplainProductCardWithBuyButtonView r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        ViewGroup.LayoutParams r0 = this.a.g.getLayoutParams();     // Catch: NumberFormatException -> L11
        int r4 = CastIntegerProtector.valueOf(r3.getAnimatedValue().toString()).intValue();     // Catch: NumberFormatException -> L11
        if ((r0 instanceof RelativeLayout.LayoutParams) == true) goto L5;
        ViewGroup.LayoutParams r1 = null;
    L6:
        RelativeLayout.LayoutParams r2 = (RelativeLayout.LayoutParams) r1;     // Catch: NumberFormatException -> L11
        if (r2 == null) goto L9;
        r2.width = r4;     // Catch: NumberFormatException -> L11
    L9:
        this.a.g.setLayoutParams(r0);     // Catch: NumberFormatException -> L11
        return;
    L5:
        r1 = r0;
    L11:
        e = move-exception;
        String r5 = e.getMessage();
        if (r5 != null) goto L15;
        r5 = "";
    L15:
        ECExceptionMonitor.c(r5);
    }
}
