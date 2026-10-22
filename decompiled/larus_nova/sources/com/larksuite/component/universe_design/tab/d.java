package com.larksuite.component.universe_design.tab;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class d implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UDTabLayout.c f285298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f285299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f285300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ValueAnimator f285301d;

    public d(UDTabLayout.c r100, int r101, int r102, ValueAnimator r103) {
        this.f285298a = r100;
        this.f285299b = r101;
        this.f285300c = r102;
        this.f285301d = r103;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        UDTabLayout.c r101 = this.f285298a;
        int r102 = this.f285299b;
        int r103 = this.f285300c;
        float r104 = this.f285301d.getAnimatedFraction();
        Drawable r105 = r101.f285262a;
        if (r105 == null) goto L5;
        UDTabLayout r106 = r101.f285271j;
        c r107 = r101.f285267f;
        View r108 = r101.getChildAt(r102);
        View r109 = r101.getChildAt(r103);
        r107.getClass();
        c.c(r106, r108, r109, r104, r105);
        r101.postInvalidateOnAnimation();
    L5:
        UDTabLayout.c r110 = this.f285298a;
        r110.f285266e = this.f285301d.getAnimatedFraction();
    }
}
