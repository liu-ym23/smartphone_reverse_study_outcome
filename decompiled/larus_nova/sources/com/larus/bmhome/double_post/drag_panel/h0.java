package com.larus.bmhome.double_post.drag_panel;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class h0 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f311513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ChatAwemeFeedContainer f311514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f311515c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        this.f311515c.removeAllListeners();
        ChatAwemeFeedContainer r101 = this.f311514b;
        int r102 = ChatAwemeFeedContainer.f311462l;
        r101.getClass();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        if (this.f311513a == false) goto L6;
        ChatAwemeFeedContainer r101 = this.f311514b;
        int r102 = ChatAwemeFeedContainer.f311462l;
        r101.getClass();
        return;
    }

    public h0(boolean r100, ChatAwemeFeedContainer r101, ValueAnimator r102) {
        this.f311513a = r100;
        this.f311514b = r101;
        this.f311515c = r102;
    }
}
