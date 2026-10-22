package com.bytedance.locallife.poi.media.photo;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class h implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f262766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f262767b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ PoiSlidesPhotosProgressBar f262768c;

    public h(int r100, int r101, PoiSlidesPhotosProgressBar r102) {
        this.f262766a = r100;
        this.f262767b = r101;
        this.f262768c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Object r101 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Float");
        float r102 = ((Float) r101).floatValue();
        int r103 = this.f262766a;
    L4:
        if (r103 >= this.f262767b) goto L9;
        View r104 = this.f262768c.getChildAt(r103);
        if (r104 == null) goto L8;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        r105.height = (int) r102;
        r104.setLayoutParams(r105);
    L8:
        r103 = r103 + 1;
        goto L4
    }
}
