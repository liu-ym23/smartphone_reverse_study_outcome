package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.photo.ui.progress;

import android.animation.Animator;
import android.view.View;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class m implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f195367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f195368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ StoryListProgressBar f195369c;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        int r101 = this.f195367a - 1;
        if (this.f195368b > r101) goto L10;
    L4:
        View r102 = this.f195369c.getChildAt(r101);
        if (r102 == null) goto L8;
        this.f195369c.removeView(r102);
    L8:
        if (r101 == this.f195368b) goto L12;
        r101 = r101 - 1;
        goto L4
    L12:
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        int r101 = this.f195367a - 1;
        if (this.f195368b > r101) goto L10;
    L4:
        View r102 = this.f195369c.getChildAt(r101);
        if (r102 == null) goto L8;
        this.f195369c.removeView(r102);
    L8:
        if (r101 == this.f195368b) goto L12;
        r101 = r101 - 1;
        goto L4
    L12:
        return;
    }

    public m(int r100, int r101, StoryListProgressBar r102) {
        this.f195367a = r100;
        this.f195368b = r101;
        this.f195369c = r102;
    }
}
