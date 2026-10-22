package com.obric.oui.indicator;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes34.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f401259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f401260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IntRange f401261c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f401259a == r101.f401259a) goto L12;
        return false;
    L12:
        if (this.f401260b == r101.f401260b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f401261c, r101.f401261c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f401259a * 31) + this.f401260b) * 31) + this.f401261c.hashCode();
    }

    public final String toString() {
        return "IndicatorViewportState(totalCount=" + this.f401259a + ", selectedIndex=" + this.f401260b + ", visibleRange=" + this.f401261c + ')';
    }

    public final boolean a(int r100) {
        IntRange r101 = this.f401261c;
        int r102 = r101.getFirst();
        if (r100 > r101.getLast()) goto L7;
        if (r102 > r100) goto L8;
        return true;
    L8:
        return false;
    L7:
        return false;
    }

    public f(int r100, int r101, IntRange r102) {
        Intrinsics.checkNotNullParameter(r102, "visibleRange");
        this.f401259a = r100;
        this.f401260b = r101;
        this.f401261c = r102;
    }
}
