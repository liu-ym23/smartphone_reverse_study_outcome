package ynb;

import android.animation.ValueAnimator;
import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f568596a;

    public b(ImageView r100) {
        this.f568596a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "animator");
        float r101 = r100.getAnimatedFraction();
        ImageView r102 = this.f568596a;
        int r103 = 0;
        if (r101 >= 0.5f) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L9;
        r103 = 8;
    L9:
        r102.setVisibility(r103);
        return;
    L5:
        r104 = false;
        goto L6
    }
}
