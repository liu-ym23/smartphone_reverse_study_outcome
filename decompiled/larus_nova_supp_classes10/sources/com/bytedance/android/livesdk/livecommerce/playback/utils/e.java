package com.bytedance.android.livesdk.livecommerce.playback.utils;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View a;

    public e(View r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r2) {
        if ((this.a.getLayoutParams() instanceof FrameLayout.LayoutParams) == false) goto L14;
        ViewGroup.LayoutParams r0 = this.a.getLayoutParams();
        if (r0 == null) goto L13;
        FrameLayout.LayoutParams r1 = (FrameLayout.LayoutParams) r0;
        r1.height = CastIntegerProtector.parseInt(r2.getAnimatedValue().toString());     // Catch: NumberFormatException -> L9
    L11:
        this.a.setLayoutParams(r1);
        return;
    L9:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L11
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }
}
