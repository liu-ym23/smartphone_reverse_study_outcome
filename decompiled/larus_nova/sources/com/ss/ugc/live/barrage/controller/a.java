package com.ss.ugc.live.barrage.controller;

import android.animation.ValueAnimator;
import android.view.View;
import com.ss.ugc.live.barrage.view.SurfaceBarrageLayout;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes36.dex */
public final class a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbsBarrageController f458132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f458133b;

    public a(AbsBarrageController r100, Ref.IntRef r101) {
        this.f458132a = r100;
        this.f458133b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        float r101 = this.f458132a.f458098e;
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L21;
        float r103 = ((Float) r102).floatValue();
        AbsBarrageController r104 = this.f458132a;
        r104.f458098e = r103;
        float r105 = r103 - r101;
        if (r103 >= r101) goto L7;
        r105 = (1000 - r101) + r103;
    L7:
        r104.j(r104.f458094a, r105);
        if (this.f458132a.f458095b.isEmpty() == true) goto L10;
    L14:
        View r106 = this.f458132a.f458104k;
        if ((r106 instanceof SurfaceBarrageLayout) == false) goto L17;
        ((SurfaceBarrageLayout) r106).c();
    L18:
        this.f458133b.element++;
        return;
    L17:
        r106.invalidate();
        goto L18
    L10:
        if (this.f458132a.f458096c.isEmpty() == false) goto L14;
        if (this.f458132a.f458094a.isEmpty() == false) goto L14;
        this.f458132a.p();
        goto L14
    L21:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Float");
    }
}
