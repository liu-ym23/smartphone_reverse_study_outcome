package com.bytedance.awemeopen.apps.framework.framework.bottomsheetdialog;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.awemeopen.apps.framework.framework.AosBaseFragment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o implements Animator.AnimatorListener {
    public final /* synthetic */ n a;
    public final /* synthetic */ ObjectAnimator b;
    public final /* synthetic */ FragmentActivity c;
    public final /* synthetic */ AosBaseFragment<?> d;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.h = false;
        this.b.removeListener(this);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        this.a.h = false;
        this.b.removeListener(this);
        n.a(this.a, this.c, this.d);
    }

    public o(n r1, ObjectAnimator r2, FragmentActivity r3, AosBaseFragment<?> r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
