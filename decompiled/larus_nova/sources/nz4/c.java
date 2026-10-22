package nz4;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f521383a;

    public c(View r100) {
        this.f521383a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "valueAnimator");
        ViewGroup.LayoutParams r101 = this.f521383a.getLayoutParams();
        if (r101 != null) goto L5;
        return;
    L5:
        Object r102 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Int");
        r101.width = ((Integer) r102).intValue();
        this.f521383a.setLayoutParams(r101);
    }
}
