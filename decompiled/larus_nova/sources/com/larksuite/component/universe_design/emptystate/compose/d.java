package com.larksuite.component.universe_design.emptystate.compose;

import androidx.compose.ui.unit.Dp;

/* JADX INFO: loaded from: classes24.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f285009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f285010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f285011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f285012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f285013e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f285014f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Dp.m7549equalsimpl0(this.f285009a, r101.f285009a) == true) goto L12;
        return false;
    L12:
        if (Dp.m7549equalsimpl0(this.f285010b, r101.f285010b) == true) goto L15;
        return false;
    L15:
        if (Dp.m7549equalsimpl0(this.f285011c, r101.f285011c) == true) goto L18;
        return false;
    L18:
        if (Dp.m7549equalsimpl0(this.f285012d, r101.f285012d) == true) goto L21;
        return false;
    L21:
        if (Dp.m7549equalsimpl0(this.f285013e, r101.f285013e) == true) goto L24;
        return false;
    L24:
        if (Dp.m7549equalsimpl0(this.f285014f, r101.f285014f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((Dp.m7550hashCodeimpl(this.f285009a) * 31) + Dp.m7550hashCodeimpl(this.f285010b)) * 31) + Dp.m7550hashCodeimpl(this.f285011c)) * 31) + Dp.m7550hashCodeimpl(this.f285012d)) * 31) + Dp.m7550hashCodeimpl(this.f285013e)) * 31) + Dp.m7550hashCodeimpl(this.f285014f);
    }

    public final String toString() {
        return "UDEmptyStateDimensions(horizontalPadding=" + Dp.m7555toStringimpl(this.f285009a) + ", imageBottomMargin=" + Dp.m7555toStringimpl(this.f285010b) + ", titleBottomMargin=" + Dp.m7555toStringimpl(this.f285011c) + ", primaryActionTopMargin=" + Dp.m7555toStringimpl(this.f285012d) + ", secondaryActionTopMargin=" + Dp.m7555toStringimpl(this.f285013e) + ", linkActionTopMargin=" + Dp.m7555toStringimpl(this.f285014f) + ')';
    }

    public d(float r100, float r101, float r102, float r103, float r104, float r105) {
        this.f285009a = r100;
        this.f285010b = r101;
        this.f285011c = r102;
        this.f285012d = r103;
        this.f285013e = r104;
        this.f285014f = r105;
    }
}
