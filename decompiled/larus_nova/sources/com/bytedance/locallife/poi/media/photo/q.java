package com.bytedance.locallife.poi.media.photo;

import android.animation.ValueAnimator;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes21.dex */
public final class q implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f262795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewPager2 f262796b;

    public q(Ref.IntRef r100, ViewPager2 r101) {
        this.f262795a = r100;
        this.f262796b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "valueAnimator");
        Object r101 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Int");
        int r102 = ((Integer) r101).intValue();
        this.f262796b.fakeDragBy(-(r102 - this.f262795a.element));
        this.f262795a.element = r102;
    }
}
