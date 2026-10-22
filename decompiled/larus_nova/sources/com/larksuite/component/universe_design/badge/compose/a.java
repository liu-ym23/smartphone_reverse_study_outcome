package com.larksuite.component.universe_design.badge.compose;

import androidx.compose.ui.unit.Dp;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f284547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f284548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f284549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f284550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f284551e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Dp.m7549equalsimpl0(this.f284547a, r101.f284547a) == true) goto L12;
        return false;
    L12:
        if (Dp.m7549equalsimpl0(this.f284548b, r101.f284548b) == true) goto L15;
        return false;
    L15:
        if (Float.compare(this.f284549c, r101.f284549c) == 0) goto L18;
        return false;
    L18:
        if (Dp.m7549equalsimpl0(this.f284550d, r101.f284550d) == true) goto L21;
        return false;
    L21:
        if (Dp.m7549equalsimpl0(this.f284551e, r101.f284551e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((Dp.m7550hashCodeimpl(this.f284547a) * 31) + Dp.m7550hashCodeimpl(this.f284548b)) * 31) + Float.floatToIntBits(this.f284549c)) * 31) + Dp.m7550hashCodeimpl(this.f284550d)) * 31) + Dp.m7550hashCodeimpl(this.f284551e);
    }

    public final String toString() {
        return "BadgeMetrics(width=" + Dp.m7555toStringimpl(this.f284547a) + ", height=" + Dp.m7555toStringimpl(this.f284548b) + ", textWidth=" + this.f284549c + ", iconWidth=" + Dp.m7555toStringimpl(this.f284550d) + ", iconHeight=" + Dp.m7555toStringimpl(this.f284551e) + ')';
    }

    public a(float r100, float r101, float r102, float r103, float r104) {
        this.f284547a = r100;
        this.f284548b = r101;
        this.f284549c = r102;
        this.f284550d = r103;
        this.f284551e = r104;
    }
}
