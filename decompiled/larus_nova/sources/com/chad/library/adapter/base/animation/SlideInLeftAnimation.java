package com.chad.library.adapter.base.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;

/* JADX INFO: loaded from: classes22.dex */
public class SlideInLeftAnimation implements BaseAnimation {
    public SlideInLeftAnimation() {
    }

    @Override // com.chad.library.adapter.base.animation.BaseAnimation
    public Animator[] getAnimators(View r100) {
        return new Animator[]{ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{-r100.getRootView().getWidth(), 0.0f})};
    }
}
