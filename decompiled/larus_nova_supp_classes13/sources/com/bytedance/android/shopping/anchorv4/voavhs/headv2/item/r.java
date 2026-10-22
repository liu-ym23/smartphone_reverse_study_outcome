package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.widget.RoundedFrameLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class r extends AnimatorListenerAdapter {
    public final /* synthetic */ w a;
    public final /* synthetic */ Function0 b;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        this.a.getHeadAbility().tB(Boolean.TRUE);
        int r5 = k83.b.a;
        k83.b.c(this.a.getHeadAbility().getRecyclerView());
        RoundedFrameLayout r6 = this.a;
        ViewGroup.LayoutParams r0 = r6.getLayoutParams();
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        if (r1 != null) goto L8;
        r1 = new ViewGroup.MarginLayoutParams(-2, -2);
    L8:
        r1.width = -1;
        r1.height = -1;
        r1.topMargin = 0;
        r1.leftMargin = 0;
        r1.bottomMargin = 0;
        Unit r2 = Unit.INSTANCE;
        r6.setLayoutParams(r1);
        this.b.invoke();
        this.a.setRadius(0);
    }

    public r(w r1, Function0 r2) {
        this.a = r1;
        this.b = r2;
    }
}
