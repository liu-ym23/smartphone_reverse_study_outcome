package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ValueAnimator a;
    public final /* synthetic */ HeadMultiPreview b;
    public final /* synthetic */ int c;
    public final /* synthetic */ float d;
    public final /* synthetic */ int e;
    public final /* synthetic */ float f;
    public final /* synthetic */ int g;
    public final /* synthetic */ int h;
    public final /* synthetic */ int i;
    public final /* synthetic */ int j;
    public final /* synthetic */ int k;
    public final /* synthetic */ int l;
    public final /* synthetic */ View m;
    public final /* synthetic */ Function0 n;

    public c(ValueAnimator r1, HeadMultiPreview r2, int r3, float r4, int r5, float r6, int r7, int r8, int r9, int r10, int r11, int r12, View r13, Function0 r14) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
        this.l = r12;
        this.m = r13;
        this.n = r14;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r7) {
        float r8 = this.a.getAnimatedFraction();
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b r0 = this.b.i;
        int r1 = com.bytedance.android.shopping.utils.x.a;
        float r2 = this.c;
        r0.c = Integer.valueOf((int) (r2 + ((this.d - r2) * r8)));
        LinearLayout r3 = this.b.a;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r4 = null;
    L5:
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        if (r5 != null) goto L8;
        r5 = new ViewGroup.MarginLayoutParams(-2, -2);
    L8:
        float r6 = this.e;
        r5.height = (int) (r6 + ((this.f - r6) * r8));
        float r9 = this.g;
        r5.width = (int) (r9 + ((this.h - r9) * r8));
        Unit r10 = Unit.INSTANCE;
        r3.setLayoutParams(r5);
        HeadMultiPreview r11 = this.b;
        r11.g = true;
        float r12 = this.i;
        float r13 = this.j;
        float r14 = this.k;
        float r15 = this.l;
        r11.setPadding((int) (r12 + ((0.0f - r12) * r8)), (int) (r13 + ((0.0f - r13) * r8)), (int) (r14 + ((0.0f - r14) * r8)), (int) (r15 + ((0.0f - r15) * r8)));
    }
}
