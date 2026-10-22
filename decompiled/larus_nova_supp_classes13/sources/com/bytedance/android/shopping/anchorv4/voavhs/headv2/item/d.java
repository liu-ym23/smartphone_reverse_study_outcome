package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends AnimatorListenerAdapter {
    public final /* synthetic */ HeadMultiPreview a;
    public final /* synthetic */ View b;
    public final /* synthetic */ Function0 c;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        HeadMultiPreview r3 = this.a;
        r3.g = false;
        r3.requestLayout();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        this.a.h.tB(Boolean.TRUE);
        int r4 = k83.b.a;
        k83.b.c(this.a.h.getRecyclerView());
        this.a.o(this.b);
        Function0 r5 = this.c;
        if (r5 == null) goto L5;
        Unit r6 = (Unit) r5.invoke();
    L5:
        LinearLayout r7 = this.a.a;
        ViewGroup.LayoutParams r0 = r7.getLayoutParams();
        r0.width = -1;
        r0.height = -1;
        Unit r1 = Unit.INSTANCE;
        r7.setLayoutParams(r0);
        HeadMultiPreview r8 = this.a;
        r8.g = false;
        r8.r();
    }

    public d(HeadMultiPreview r1, View r2, Function0 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
