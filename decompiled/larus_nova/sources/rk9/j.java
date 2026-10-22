package rk9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f538418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f538419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f538420c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f538418a, r101.f538418a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f538419b, r101.f538419b) == true) goto L15;
        return false;
    L15:
        if (this.f538420c == r101.f538420c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f538418a.hashCode() * 31;
        k r101 = this.f538419b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f538420c == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "RouteOperation(decision=" + this.f538418a + ", snapshot=" + this.f538419b + ", applied=" + this.f538420c + ')';
    }

    public j(String r100, k r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "decision");
        this.f538418a = r100;
        this.f538419b = r101;
        this.f538420c = r102;
    }
}
