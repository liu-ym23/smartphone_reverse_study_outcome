package com.bytedance.awemeopen.apps.framework.feed.ui.information.desc;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.text.SpannableStringBuilder;
import android.view.ViewGroup;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.awemeopen.apps.framework.feed.desc.ScrollMentionTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class r extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f196114a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f196115b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SpannableStringBuilder f196116c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        if (this.f196115b == true) goto L5;
        this.f196114a.h(this.f196116c);
    L5:
        ViewGroup r101 = this.f196114a.f196097h;
        ScrollMentionTextView r102 = null;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mDescToggleContainer");
        r101 = null;
    L8:
        r101.setClickable(true);
        ScrollMentionTextView r103 = this.f196114a.f196096g;
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mDescView");
    L12:
        r102.setClickable(true);
        r100.removeListener(this);
        return;
    L11:
        r102 = r103;
        goto L12
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        ViewGroup r101 = this.f196114a.f196097h;
        ScrollMentionTextView r102 = null;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mDescToggleContainer");
        r101 = null;
    L5:
        r101.setClickable(false);
        ScrollMentionTextView r103 = this.f196114a.f196096g;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mDescView");
    L9:
        r102.setClickable(false);
        return;
    L8:
        r102 = r103;
        goto L9
    }

    public r(q r100, boolean r101, SpannableStringBuilder r102) {
        this.f196114a = r100;
        this.f196115b = r101;
        this.f196116c = r102;
    }
}
