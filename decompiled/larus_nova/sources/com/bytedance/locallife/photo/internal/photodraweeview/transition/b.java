package com.bytedance.locallife.photo.internal.photodraweeview.transition;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f262064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TransitionPhotoDraweeView f262065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f262066c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float f262067d;

    public b(Ref.FloatRef r100, TransitionPhotoDraweeView r101, float r102, float r103) {
        this.f262064a = r100;
        this.f262065b = r101;
        this.f262066c = r102;
        this.f262067d = r103;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "anim");
        Object r101 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Float");
        float r102 = ((Float) r101).floatValue();
        float r103 = r102 / this.f262064a.element;
        this.f262065b.f262048g.postScale(r103, r103, this.f262066c, this.f262067d);
        this.f262064a.element = r102;
        this.f262065b.j();
        this.f262065b.invalidate();
    }
}
