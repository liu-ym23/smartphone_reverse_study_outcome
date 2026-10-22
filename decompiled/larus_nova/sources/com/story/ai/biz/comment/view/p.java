package com.story.ai.biz.comment.view;

import android.view.animation.Animation;
import com.larus.comments.impl.databinding.LarusCommentInputDialogBinding;

/* JADX INFO: loaded from: classes38.dex */
public final class p implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LarusCommentInputDialogBinding f460004a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
    }

    public p(LarusCommentInputDialogBinding r100) {
        this.f460004a = r100;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
        this.f460004a.f325651c.setVisibility(0);
    }
}
