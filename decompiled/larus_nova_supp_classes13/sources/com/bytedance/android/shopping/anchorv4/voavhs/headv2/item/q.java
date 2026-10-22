package com.bytedance.android.shopping.anchorv4.voavhs.headv2.item;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import com.bytedance.android.ec.core.widget.RoundedFrameLayout;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ValueAnimator a;
    public final /* synthetic */ w b;
    public final /* synthetic */ int c;
    public final /* synthetic */ float d;
    public final /* synthetic */ int e;
    public final /* synthetic */ float f;
    public final /* synthetic */ int g;
    public final /* synthetic */ int h;
    public final /* synthetic */ int i;
    public final /* synthetic */ int j;
    public final /* synthetic */ int k;
    public final /* synthetic */ Function0 l;

    public q(ValueAnimator r1, w r2, int r3, float r4, int r5, float r6, int r7, int r8, int r9, int r10, int r11, Function0 r12) {
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
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r6) {
        float r7 = this.a.getAnimatedFraction();
        com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.b r0 = this.b.n;
        int r1 = com.bytedance.android.shopping.utils.x.a;
        float r2 = this.c;
        r0.c = Integer.valueOf((int) (r2 + ((this.d - r2) * r7)));
        RoundedFrameLayout r3 = this.b;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        if ((r4 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r4 = null;
    L5:
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r4;
        if (r5 != null) goto L8;
        r5 = new ViewGroup.MarginLayoutParams(-2, -2);
    L8:
        float r8 = this.e;
        r5.height = (int) (r8 + ((this.f - r8) * r7));
        float r9 = this.g;
        r5.width = (int) (r9 + ((this.h - r9) * r7));
        float r10 = this.i;
        float r11 = 0;
        r5.leftMargin = (int) (r10 + ((r11 - r10) * r7));
        float r12 = this.j;
        r5.topMargin = (int) (r12 + ((r11 - r12) * r7));
        float r13 = this.k;
        r5.bottomMargin = (int) (r13 + ((r11 - r13) * r7));
        Unit r14 = Unit.INSTANCE;
        r3.setLayoutParams(r5);
    }
}
