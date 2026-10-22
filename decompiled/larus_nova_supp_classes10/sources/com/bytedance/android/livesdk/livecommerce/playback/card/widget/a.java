package com.bytedance.android.livesdk.livecommerce.playback.card.widget;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ExplainProductCardWithBuyButtonView a;

    public a(ExplainProductCardWithBuyButtonView r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r4) {
        ViewGroup.LayoutParams r0 = this.a.a.getLayoutParams();     // Catch: NumberFormatException -> L18
        int r5 = CastIntegerProtector.valueOf(r4.getAnimatedValue().toString()).intValue();     // Catch: NumberFormatException -> L18
        ViewGroup.LayoutParams r2 = null;
        if ((r0 instanceof RelativeLayout.LayoutParams) == true) goto L5;
        ViewGroup.LayoutParams r1 = null;
    L6:
        RelativeLayout.LayoutParams r3 = (RelativeLayout.LayoutParams) r1;     // Catch: NumberFormatException -> L18
        if (r3 == null) goto L10;
        r3.width = r5;     // Catch: NumberFormatException -> L18
    L10:
        if ((r0 instanceof RelativeLayout.LayoutParams) == false) goto L13;
        r2 = r0;
    L13:
        RelativeLayout.LayoutParams r6 = (RelativeLayout.LayoutParams) r2;     // Catch: NumberFormatException -> L18
        if (r6 == null) goto L16;
        r6.height = r5;     // Catch: NumberFormatException -> L18
    L16:
        this.a.a.setLayoutParams(r0);     // Catch: NumberFormatException -> L18
        return;
    L5:
        r1 = r0;
    L18:
        e = move-exception;
        String r7 = e.getMessage();
        if (r7 != null) goto L22;
        r7 = "";
    L22:
        ECExceptionMonitor.c(r7);
    }
}
