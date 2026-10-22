package com.obric.miniapp.lynx;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f398048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f398049b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f398050c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f398051d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f398048a == r101.f398048a) goto L12;
        return false;
    L12:
        if (this.f398049b == r101.f398049b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f398050c, r101.f398050c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f398051d, r101.f398051d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f398048a * 31) + this.f398049b) * 31;
        Integer r101 = this.f398050c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.f398051d;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "DatePickerCalendarMetrics(tileWidthPx=" + this.f398048a + ", tileHSpacingPx=" + this.f398049b + ", tileHeightPx=" + this.f398050c + ", tileVSpacingPx=" + this.f398051d + ')';
    }

    public c(int r100, int r101, Integer r102, Integer r103) {
        this.f398048a = r100;
        this.f398049b = r101;
        this.f398050c = r102;
        this.f398051d = r103;
    }
}
