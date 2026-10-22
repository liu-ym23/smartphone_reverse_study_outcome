package com.ss.android.lark.chat.message.menu.v2;

import android.animation.ValueAnimator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes35.dex */
public final class e0 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f415724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b0 f415725b;

    public e0(Ref.IntRef r100, b0 r101) {
        this.f415724a = r100;
        this.f415725b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Object r101 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type kotlin.Int");
        int r102 = ((Integer) r101).intValue() - this.f415724a.element;
        b0 r103 = this.f415725b;
        float r104 = r102;
        r103.getClass();
        boolean r105 = true;
        if (r104 != 0.0f) goto L5;
        boolean r106 = true;
    L6:
        if (r106 == true) goto L37;
        if (r104 >= 0.0f) goto L22;
        int r107 = r103.f415696f;
        if (r107 > 0) goto L13;
        r105 = false;
    L13:
        r103.f415706p = r105;
        if (r107 <= Math.abs(r104)) goto L16;
        Number r108 = Float.valueOf(r104);
    L17:
        int r109 = r108.intValue();
        float r110 = r104 - r109;
        if (r103.f415697g > Math.abs(r110)) goto L21;
        r110 = -r103.f415697g;
    L21:
        r103.f415696f += r109;
        r103.f415697g += r110;
        r103.f415693c.scrollBy(0, r109);
        r103.f415693c.setTranslationY(r103.f415704n - r103.f415697g);
        goto L37
    L16:
        r108 = Integer.valueOf(-r103.f415696f);
        goto L17
    L22:
        int r111 = (int) r104;
        if (r103.f415706p == true) goto L26;
        r111 = 0;
    L31:
        r103.f415696f += r111;
        float r112 = r104 - r111;
        if (r112 == 0.0f) goto L35;
        r105 = false;
    L35:
        if (r105 == true) goto L37;
        float r113 = r103.f415697g + r112;
        r103.f415697g = r113;
        r103.f415693c.setTranslationY(r103.f415704n - r113);
        goto L37
    L26:
        if (r103.f415695e.a() == true) goto L28;
        r103.f415693c.scrollBy(0, r111);
        goto L31
    L28:
        r103.f415693c.scrollBy(0, r111);
        if (r103.f415693c.canScrollVertically(1) == true) goto L31;
        r103.f415706p = false;
        r103.f415691a.getLocationOnScreen(r103.f415703m);
        r111 = (((r103.f415707q + r103.f415698h) - r103.f415703m[1]) - r103.f415696f) - ((int) r103.f415697g);
    L37:
        Ref.IntRef r114 = this.f415724a;
        Object r115 = r100.getAnimatedValue();
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type kotlin.Int");
        r114.element = ((Integer) r115).intValue();
        return;
    L5:
        r106 = false;
        goto L6
    }
}
