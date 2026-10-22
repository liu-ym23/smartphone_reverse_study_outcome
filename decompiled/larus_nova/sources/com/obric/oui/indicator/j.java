package com.obric.oui.indicator;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class j extends l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OCarouselIndicator f401266b;

    @Override // com.obric.oui.indicator.l
    public final int a() {
        return this.f401266b.g();
    }

    public j(OCarouselIndicator r100) {
        this.f401266b = r100;
    }

    @Override // com.obric.oui.indicator.l
    public final void c(int r110, int r111, float r112) {
        OCarouselIndicator r100 = this.f401266b;
        int r101 = OCarouselIndicator.f401235J;
        int r102 = r100.g();
        f r103 = r100.x(r102, r110);
        f r104 = r100.x(r102, r111);
        boolean r105 = false;
        IndicatorAnimator r106 = null;
        if (Intrinsics.areEqual(r103.f401261c, r104.f401261c) == true) goto L46;
        IndicatorAnimator r107 = r100.f401238y;
        if (r107 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("indicatorAnimator");
        r107 = null;
    L7:
        float r108 = r107.f401148h;
        if (r112 <= r108) goto L11;
        IndicatorAnimator.ScrollDirection r109 = IndicatorAnimator.ScrollDirection.FORWARD;
    L15:
        if (r109 != null) goto L17;
        int r113 = -1;
    L19:
        if (r113 == (-1)) goto L30;
        if (r113 == 1) goto L27;
        if (r113 == 2) goto L30;
        throw new NoWhenBranchMatchedException();
    L27:
        if (r112 > 0.5f) goto L31;
    L32:
        boolean r114 = false;
    L33:
        if (r114 == false) goto L35;
        int r115 = r111;
    L37:
        if (r112 != 0.0f) goto L39;
        boolean r116 = true;
    L40:
        if (r116 == true) goto L42;
        r107.f401148h = r112;
    L42:
        IndicatorAnimator.RenderReason r117 = IndicatorAnimator.RenderReason.SCROLL;
        f r118 = r100.x(r100.g(), r115);
        IndicatorAnimator r119 = r100.f401238y;
        if (r119 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("indicatorAnimator");
        r119 = null;
    L45:
        r119.a(r117, r118);
    L50:
        IndicatorAnimator r120 = r100.f401238y;
        if (r120 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("indicatorAnimator");
    L54:
        f r121 = r106.f401145e;
        if (r121 != null) goto L58;
    L79:
        r100.invalidate();
        return;
    L58:
        if (r121.a(r110) == false) goto L79;
        if (r121.a(r111) == false) goto L79;
        Object r122 = r100.I.evaluate(r112, Integer.valueOf(r100.H), Integer.valueOf(r100.getDotsColor()));
        if (r122 == null) goto L78;
        int r123 = ((Integer) r122).intValue();
        Object r124 = r100.I.evaluate(r112, Integer.valueOf(r100.getDotsColor()), Integer.valueOf(r100.H));
        if (r124 == null) goto L76;
        r100.m(r111, ((Integer) r124).intValue(), r121);
        OBaseIndicator.c r125 = r100.getPager();
        if (r125 != null) goto L70;
    L72:
        if (r105 == false) goto L74;
        r123 = r100.H;
    L74:
        r100.m(r110, r123, r121);
        goto L79
    L70:
        if (r110 != r125.getCurrentItem()) goto L72;
        r105 = true;
        goto L72
    L76:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L78:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L53:
        r106 = r120;
        goto L54
    L39:
        r116 = false;
        goto L40
    L35:
        r115 = r110;
    L31:
        r114 = true;
    L30:
        if (r112 < 0.5f) goto L32;
    L17:
        r113 = IndicatorAnimator.d.f401156a[r109.ordinal()];
        goto L19
    L11:
        if (r112 >= r108) goto L13;
        r109 = IndicatorAnimator.ScrollDirection.BACKWARD;
        goto L15
    L13:
        r109 = null;
        goto L15
    L46:
        IndicatorAnimator r126 = r100.f401238y;
        if (r126 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("indicatorAnimator");
        r126 = null;
    L49:
        r126.a(IndicatorAnimator.RenderReason.REFRESH_DOTS, r103);
        r100.q(r103, r104, r112);
        goto L50
    }
}
