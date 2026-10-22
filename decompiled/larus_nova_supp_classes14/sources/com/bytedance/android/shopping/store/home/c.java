package com.bytedance.android.shopping.store.home;

import android.animation.Animator;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.appbar.AppBarLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class c implements Animator.AnimatorListener {
    public final /* synthetic */ ECShopAppBarSnapBehavior a;
    public final /* synthetic */ CoordinatorLayout b;
    public final /* synthetic */ AppBarLayout c;
    public final /* synthetic */ View d;
    public final /* synthetic */ int e;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r4) {
        Intrinsics.checkNotNullParameter(r4, "animation");
        this.a.snapTo(0, this.b, this.c);
        this.a.c = false;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.a.c = false;
        ViewCompat.stopNestedScroll(this.d, this.e);
    }

    public c(ECShopAppBarSnapBehavior r1, CoordinatorLayout r2, AppBarLayout r3, View r4, int r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
