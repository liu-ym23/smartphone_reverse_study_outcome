package defpackage;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final /* synthetic */ class y implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f565554a;

    public /* synthetic */ y(View r100) {
        this.f565554a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        View r101 = this.f565554a;
        Object r102 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Int");
        int r103 = ((Integer) r102).intValue();
        ViewGroup.LayoutParams r104 = r101.getLayoutParams();
        r104.height = r103;
        r101.setLayoutParams(r104);
    }
}
