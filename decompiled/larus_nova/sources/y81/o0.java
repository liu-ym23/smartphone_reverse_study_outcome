package y81;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class o0 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f566816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d0 f566817b;

    public o0(ValueAnimator r100, d0 r101) {
        this.f566816a = r100;
        this.f566817b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Object r101 = this.f566816a.getAnimatedValue();
        if (r101 == null) goto L7;
        float r102 = ((Float) r101).floatValue();
        d0.v(this.f566817b.f566718m, r102);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
