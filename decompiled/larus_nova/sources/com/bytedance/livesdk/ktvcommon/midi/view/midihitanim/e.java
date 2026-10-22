package com.bytedance.livesdk.ktvcommon.midi.view.midihitanim;

import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f256130a;

    public e(View r100) {
        this.f256130a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "anim");
        Object r101 = r100.getAnimatedValue();
        if (r101 == null) goto L7;
        PointF r102 = (PointF) r101;
        this.f256130a.setX(r102.x);
        this.f256130a.setY(r102.y);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.graphics.PointF");
    }
}
