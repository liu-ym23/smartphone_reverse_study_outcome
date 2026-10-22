package com.bytedance.locallife.poi.poidetail.container.component.view.dcd;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class f implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScrollToOpenLayout f263828a;

    public f(ScrollToOpenLayout r100) {
        this.f263828a = r100;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        ScrollToOpenLayout r101 = this.f263828a;
        Object r102 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type kotlin.Int");
        r101.scrollTo(((Integer) r102).intValue(), 0);
    }
}
