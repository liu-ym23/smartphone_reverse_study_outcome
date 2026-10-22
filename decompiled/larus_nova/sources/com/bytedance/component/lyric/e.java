package com.bytedance.component.lyric;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes15.dex */
public final class e implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewPainter f202999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f203000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f203001c;

    public e(ViewPainter r100, Ref.IntRef r101, Ref.IntRef r102) {
        this.f202999a = r100;
        this.f203000b = r101;
        this.f203001c = r102;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        this.f202999a.setInScroll(true);
        Ref.IntRef r101 = this.f203000b;
        Object r102 = r100.getAnimatedValue();
        if (r102 == null) goto L10;
        r101.element = ((Integer) r102).intValue();
        Ref.IntRef r103 = this.f203001c;
        int r104 = r103.element;
        Ref.IntRef r105 = this.f203000b;
        int r106 = r105.element;
        if (r104 != r106) goto L7;
        return;
    L7:
        r103.element = r106;
        this.f202999a.setAnimationY(r105.element);
        this.f202999a.invalidate();
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
