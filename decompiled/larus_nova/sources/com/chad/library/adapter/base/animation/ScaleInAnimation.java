package com.chad.library.adapter.base.animation;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;

/* JADX INFO: loaded from: classes22.dex */
public class ScaleInAnimation implements BaseAnimation {
    private static final float DEFAULT_SCALE_FROM = 0.5f;
    private final float mFrom;

    public ScaleInAnimation() {
        this(0.5f);
    }

    public ScaleInAnimation(float r100) {
        this.mFrom = r100;
    }

    @Override // com.chad.library.adapter.base.animation.BaseAnimation
    public Animator[] getAnimators(View r100) {
        return new ObjectAnimator[]{ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.SCALE_X, new float[]{this.mFrom, 1.0f}), ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.SCALE_Y, new float[]{this.mFrom, 1.0f})};
    }
}
