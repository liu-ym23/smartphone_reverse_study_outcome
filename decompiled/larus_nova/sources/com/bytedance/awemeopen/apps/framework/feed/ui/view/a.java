package com.bytedance.awemeopen.apps.framework.feed.ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LongPressSpeedView f196826a;

    public a(LongPressSpeedView r100) {
        this.f196826a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        if (LongPressSpeedView.a(this.f196826a).getVisibility() != 8) goto L5;
        return;
    L5:
        LongPressSpeedView r101 = this.f196826a;
        r101.f196816i = ObjectAnimator.ofFloat(LongPressSpeedView.b(r101), "alpha", new float[]{0.2f, 0.5f, 1.0f});
        ObjectAnimator r102 = this.f196826a.f196816i;
        if (r102 == null) goto L9;
        r102.setDuration(800);
    L9:
        ObjectAnimator r103 = this.f196826a.f196816i;
        if (r103 == null) goto L13;
        r103.setRepeatCount(-1);
    L13:
        ObjectAnimator r104 = this.f196826a.f196816i;
        if (r104 == null) goto L17;
        r104.setRepeatMode(2);
    L17:
        ObjectAnimator r105 = this.f196826a.f196816i;
        if (r105 == null) goto L21;
        r105.start();
        return;
    }
}
