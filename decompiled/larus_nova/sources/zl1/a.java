package zl1;

import android.animation.ValueAnimator;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f572781a;

    public a(TextView r100) {
        this.f572781a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
        TextView r101 = this.f572781a;
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L7;
        r101.setAlpha(((Float) r102).floatValue());
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
    }
}
