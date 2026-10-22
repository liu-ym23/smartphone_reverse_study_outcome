package com.obric.oui.indicator;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f401250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f401251b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f401250a == r101.f401250a) goto L12;
        return false;
    L12:
        if (this.f401251b == r101.f401251b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f401250a * 31) + this.f401251b;
    }

    public final String toString() {
        return "DotSpacingSpec(startMargin=" + this.f401250a + ", endMargin=" + this.f401251b + ')';
    }

    public a(int r100, int r101) {
        this.f401250a = r100;
        this.f401251b = r101;
    }
}
