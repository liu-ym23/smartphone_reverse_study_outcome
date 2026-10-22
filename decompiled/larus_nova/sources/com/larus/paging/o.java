package com.larus.paging;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f363901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f1 f363902b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (this.f363901a == r101.f363901a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f363902b, r101.f363902b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f363901a * 31) + this.f363902b.hashCode();
    }

    public final String toString() {
        return "GenerationalViewportHint(generationId=" + this.f363901a + ", hint=" + this.f363902b + ')';
    }

    public o(int r100, f1 r101) {
        Intrinsics.checkNotNullParameter(r101, "hint");
        this.f363901a = r100;
        this.f363902b = r101;
    }
}
