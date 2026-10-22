package com.bytedance.ee.bear.profile;

import android.animation.Animator;
import com.bytedance.ee.bear.lark.databinding.ActivityHalfProfileBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements Animator.AnimatorListener {
    public final /* synthetic */ HalfProfileActivity a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    public h(HalfProfileActivity r1) {
        this.a = r1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        HalfProfileActivity r4 = this.a;
        j r0 = r4.j;
        if (r0 == null) goto L5;
        ((com.bytedance.ee.bear.facade.common.widget.d) r0).k = true;
    L5:
        if (r0 == null) goto L11;
        ActivityHalfProfileBinding r5 = r4.i;
        if (r5 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L9:
        r0.i(r5.e);
        return;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        HalfProfileActivity r4 = this.a;
        j r0 = r4.j;
        if (r0 == null) goto L5;
        ((com.bytedance.ee.bear.facade.common.widget.d) r0).k = true;
    L5:
        if (r0 == null) goto L11;
        ActivityHalfProfileBinding r5 = r4.i;
        if (r5 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L9:
        r0.i(r5.e);
        return;
    }
}
