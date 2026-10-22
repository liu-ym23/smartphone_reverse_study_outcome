package com.obric.assistant.cocreationreview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class o5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l5 f387629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f387630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f387631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f387632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f387633e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o5) == true) goto L8;
        return false;
    L8:
        o5 r101 = (o5) r100;
        if (Intrinsics.areEqual(this.f387629a, r101.f387629a) == true) goto L12;
        return false;
    L12:
        if (this.f387630b == r101.f387630b) goto L15;
        return false;
    L15:
        if (this.f387631c == r101.f387631c) goto L18;
        return false;
    L18:
        if (this.f387632d == r101.f387632d) goto L21;
        return false;
    L21:
        if (this.f387633e == r101.f387633e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        return (((((((this.f387629a.hashCode() * 31) + this.f387630b) * 31) + this.f387631c) * 31) + this.f387632d) * 31) + this.f387633e;
    }

    public final String toString() {
        return "ModuleSummary(meta=" + this.f387629a + ", total=" + this.f387630b + ", completed=" + this.f387631c + ", up=" + this.f387632d + ", down=" + this.f387633e + ')';
    }

    public o5(l5 r100, int r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "meta");
        this.f387629a = r100;
        this.f387630b = r101;
        this.f387631c = r102;
        this.f387632d = r103;
        this.f387633e = r104;
    }
}
