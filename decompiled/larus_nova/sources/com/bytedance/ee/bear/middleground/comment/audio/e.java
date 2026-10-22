package com.bytedance.ee.bear.middleground.comment.audio;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f230336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecordPanelView f230337b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationEnd(r100);
        RecordPanelView.b(this.f230337b, this.f230336a);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        super.onAnimationStart(r100);
        ImageView r101 = null;
        if (this.f230336a == false) goto L9;
        ImageView r102 = this.f230337b.f230303d;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("pause");
    L8:
        r101.setVisibility(0);
        return;
    L7:
        r101 = r102;
        goto L8
    L9:
        ImageView r103 = this.f230337b.f230302c;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("play");
    L13:
        r101.setVisibility(0);
        return;
    L12:
        r101 = r103;
        goto L13
    }

    public e(boolean r100, RecordPanelView r101) {
        this.f230336a = r100;
        this.f230337b = r101;
    }
}
