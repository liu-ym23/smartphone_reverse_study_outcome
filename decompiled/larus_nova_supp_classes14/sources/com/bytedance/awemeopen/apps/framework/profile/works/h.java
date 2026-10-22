package com.bytedance.awemeopen.apps.framework.profile.works;

import android.animation.Animator;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.bytedance.awemeopen.apps.framework.base.view.FixRatioRoundFrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h implements Animator.AnimatorListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ g b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r5) {
        Intrinsics.checkNotNullParameter(r5, "animation");
        this.a.setScaleX(1.0f);
        this.a.setScaleY(1.0f);
        View r6 = this.a;
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type com.bytedance.awemeopen.apps.framework.base.view.FixRatioRoundFrameLayout");
        ((FixRatioRoundFrameLayout) r6).setRadius(0.0f);
        ViewCompat.setElevation(this.a, 0.0f);
        g r7 = this.b;
    L4:
        if (r7.a.isEmpty() == true) goto L6;
        Pair<ViewGroup, boolean[]> r0 = r7.a.pop();
        ((ViewGroup) r0.first).setClipChildren(((boolean[]) r0.second)[0]);
        ((ViewGroup) r0.first).setClipToPadding(((boolean[]) r0.second)[1]);
        goto L4
    }

    public h(View r1, g r2) {
        this.a = r1;
        this.b = r2;
    }
}
