package com.larksuite.common_selection;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f282910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f282911b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f282910a, r101.f282910a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f282911b, r101.f282911b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f282910a.hashCode() * 31) + this.f282911b.hashCode();
    }

    public p() {
        int r100 = 0;
        this(new o(r100), new o(r100));
    }

    public final String toString() {
        return "SelectionRange(start=" + this.f282910a + ", end=" + this.f282911b + ')';
    }

    public static p a(p r100) {
        o r101 = r100.f282910a;
        o r102 = r100.f282911b;
        Intrinsics.checkNotNullParameter(r101, "start");
        Intrinsics.checkNotNullParameter(r102, "end");
        return new p(r101, r102);
    }

    public p(o r100, o r101) {
        Intrinsics.checkNotNullParameter(r100, "start");
        Intrinsics.checkNotNullParameter(r101, "end");
        this.f282910a = r100;
        this.f282911b = r101;
    }
}
