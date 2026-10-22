package com.bytedance.android.livesdk.livecommerce.playback.utils;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View a;

    public c(View r1) {
        this.a = r1;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r3) {
        ViewGroup.LayoutParams r0 = this.a.getLayoutParams();
        r0.height = CastIntegerProtector.parseInt(r3.getAnimatedValue().toString());
        ViewGroup.LayoutParams r1 = this.a.getLayoutParams();
        r1.width = CastIntegerProtector.parseInt(r3.getAnimatedValue().toString()) + UtilityKotlinExtentionsKt.d(20);
    }
}
