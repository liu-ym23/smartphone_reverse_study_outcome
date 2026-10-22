package com.github.alexzhirkevich.customqrgenerator.vector.style;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f274284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f274285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f274286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f274287d;

    public g() {
        this(0);
    }

    public final int hashCode() {
        return (((((this.f274284a.hashCode() * 31) + this.f274285b.hashCode()) * 31) + this.f274286c.hashCode()) * 31) + this.f274287d.hashCode();
    }

    public final String toString() {
        return "QrVectorColors(dark=" + this.f274284a + ", light=" + this.f274285b + ", ball=" + this.f274286c + ", frame=" + this.f274287d + ')';
    }

    public g(int r100) {
        e.a r101 = new e.a(com.github.alexzhirkevich.customqrgenerator.style.g.a(4278190080L));
        e.c r102 = e.c.f274282b;
        this(r101, r102, r102, r102);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f274284a, r101.f274284a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f274285b, r101.f274285b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f274286c, r101.f274286c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f274287d, r101.f274287d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public g(e r100, e r101, e r102, e r103) {
        Intrinsics.checkNotNullParameter(r100, "dark");
        Intrinsics.checkNotNullParameter(r101, "light");
        Intrinsics.checkNotNullParameter(r102, "ball");
        Intrinsics.checkNotNullParameter(r103, "frame");
        this.f274284a = r100;
        this.f274285b = r101;
        this.f274286c = r102;
        this.f274287d = r103;
    }
}
