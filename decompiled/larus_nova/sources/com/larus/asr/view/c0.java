package com.larus.asr.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.common_ui.blur.BlurCircleWithAmplitude;
import com.larus.common_ui.blur.BlurView;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class c0 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BlurView f288146a;

    public c0(BlurCircleWithAmplitude r100) {
        this.f288146a = r100;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationCancel(r100);
        FLogger.f375446a.i("ChatSpeaker", "[playShowBlurAnim] onAnimationCancel");
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        BlurView r101 = this.f288146a;
        if ((r101 instanceof BlurCircleWithAmplitude) == false) goto L5;
        BlurCircleWithAmplitude r102 = (BlurCircleWithAmplitude) r101;
    L6:
        if (r102 == null) goto L8;
        r102.e();
    L8:
        FLogger.f375446a.i("ChatSpeaker", "[playShowBlurAnim] onAnimationEnd");
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationStart(r100);
        FLogger.f375446a.i("ChatSpeaker", "[playShowBlurAnim] onAnimationStart");
    }
}
