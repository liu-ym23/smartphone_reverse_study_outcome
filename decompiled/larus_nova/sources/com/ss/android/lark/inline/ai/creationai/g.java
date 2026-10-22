package com.ss.android.lark.inline.ai.creationai;

import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f427106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f427107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CreationAIDragView f427108c;

    public g(float r100, View r101, CreationAIDragView r102) {
        this.f427106a = r100;
        this.f427107b = r101;
        this.f427108c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, LiveDegradeFpsAnimator.TRANSLATION_Y);
        Object r101 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Float");
        float r102 = ((Float) r101).floatValue();
        float r103 = this.f427106a;
        float r104 = 0.0f;
        if (r103 <= 0.0f) goto L6;
        r104 = 1 - (r102 / r103);
    L6:
        this.f427107b.setAlpha(r104);
        Log.i("CreationAIDragView", "show, syncStatusBarColor = " + this.f427108c.Y);
        CreationAIDragView r105 = this.f427108c;
        if (r105.Y == false) goto L10;
        r105.q(r104);
        return;
    }
}
