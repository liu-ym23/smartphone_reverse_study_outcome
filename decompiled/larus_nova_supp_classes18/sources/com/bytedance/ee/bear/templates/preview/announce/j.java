package com.bytedance.ee.bear.templates.preview.announce;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j extends AnimatorListenerAdapter {
    public final /* synthetic */ TemplateCardPanelFragment a;
    public final /* synthetic */ TemplateData b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        super.onAnimationEnd(r2);
        if (Intrinsics.areEqual(this.b.getVisible(), Boolean.FALSE) == false) goto L13;
        AnnounceTemplateViewModel r3 = this.a.k;
        if (r3 == null) goto L9;
        AnnounceTemplateViewModel.b r4 = r3.getPanelDelegate();
        if (r4 == null) goto L9;
        r4.c();
    L9:
        ConstraintLayout r5 = this.a.j;
        if (r5 == null) goto L14;
        r5.setVisibility(8);
        return;
    L14:
        return;
    }

    public j(TemplateCardPanelFragment r1, TemplateData r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        ConstraintLayout r0 = this.a.j;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        super.onAnimationStart(r3, r4);
        AnnounceTemplateViewModel r5 = this.a.k;
        if (r5 == null) goto L11;
        MutableLiveData<Boolean> r6 = r5.m569getPanelActive();
        if (r6 == null) goto L12;
        r6.setValue(this.b.getVisible());
        return;
    L12:
        return;
    }
}
