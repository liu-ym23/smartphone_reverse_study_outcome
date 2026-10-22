package com.story.ai.biz.comment.adapter;

import android.view.animation.Animation;
import android.widget.LinearLayout;
import com.larus.utils.e1;

/* JADX INFO: loaded from: classes38.dex */
public final class r implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinearLayout f459834a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
    }

    public r(LinearLayout r100) {
        this.f459834a = r100;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
        e1.x(this.f459834a);
    }
}
