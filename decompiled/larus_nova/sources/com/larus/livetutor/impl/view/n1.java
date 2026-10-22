package com.larus.livetutor.impl.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.larus.common_ui.venus.ShapeLinearLayout;
import v19.l5;

/* JADX INFO: loaded from: classes30.dex */
public final class n1 implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveTutorTeachView f356875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f356876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f356877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float f356878d;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        ImageView r101 = this.f356875a.f356738b.f355993d;
        r101.setSelected(!r101.isSelected());
        View r102 = this.f356876b;
        Property r103 = ViewGroup.SCALE_X;
        float r104 = this.f356877c;
        float r105 = this.f356878d;
        ObjectAnimator r106 = ObjectAnimator.ofFloat(r102, r103, new float[]{r104 / r105, r105 / r105});
        View r107 = this.f356876b;
        Property r108 = ViewGroup.SCALE_Y;
        float r109 = this.f356877c;
        float r110 = this.f356878d;
        ObjectAnimator r111 = ObjectAnimator.ofFloat(r107, r108, new float[]{r109 / r110, r110 / r110});
        ObjectAnimator r112 = ObjectAnimator.ofFloat(this.f356876b, ViewGroup.ALPHA, new float[]{0.0f, 1.0f});
        AnimatorSet r113 = new AnimatorSet();
        r113.playTogether(new Animator[]{r106, r111, r112});
        r113.setDuration(150);
        r113.setInterpolator(new l5());
        r113.start();
    }

    public n1(LiveTutorTeachView r100, ShapeLinearLayout r101, float r102, float r103) {
        this.f356875a = r100;
        this.f356876b = r101;
        this.f356877c = r102;
        this.f356878d = r103;
    }
}
