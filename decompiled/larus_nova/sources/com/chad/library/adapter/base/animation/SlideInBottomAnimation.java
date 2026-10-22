package com.chad.library.adapter.base.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;

/* JADX INFO: loaded from: classes22.dex */
public class SlideInBottomAnimation implements BaseAnimation {
    public SlideInBottomAnimation() {
    }

    @Override // com.chad.library.adapter.base.animation.BaseAnimation
    public Animator[] getAnimators(View r100) {
        return new Animator[]{ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r100.getMeasuredHeight(), 0.0f})};
    }
}
