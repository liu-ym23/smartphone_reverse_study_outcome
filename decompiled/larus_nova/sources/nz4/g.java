package nz4;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class g implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f521393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f521394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f521395c;

    public g(View r100, int r101, float r102) {
        this.f521393a = r100;
        this.f521394b = r101;
        this.f521395c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "valueAnimator");
        Object r101 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Int");
        int r102 = ((Integer) r101).intValue();
        ViewGroup.LayoutParams r103 = this.f521393a.getLayoutParams();
        r103.width = r102;
        this.f521393a.setLayoutParams(r103);
        this.f521393a.setX(this.f521395c + (r100.getAnimatedFraction() * this.f521394b));
    }
}
