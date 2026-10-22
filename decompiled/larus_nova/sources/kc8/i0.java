package kc8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f502496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f502497b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i0) == true) goto L8;
        return false;
    L8:
        i0 r101 = (i0) r100;
        if (Intrinsics.areEqual(this.f502496a, r101.f502496a) == true) goto L12;
        return false;
    L12:
        if (this.f502497b == r101.f502497b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f502496a.hashCode() * 31) + this.f502497b;
    }

    public final String toString() {
        return "PromotedBlockSourceContext(sourceParentBlockId=" + this.f502496a + ", sourceParentBlockType=" + this.f502497b + ')';
    }

    public i0(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "sourceParentBlockId");
        this.f502496a = r100;
        this.f502497b = r101;
    }
}
