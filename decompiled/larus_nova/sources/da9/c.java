package da9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f467721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f467722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f467723c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f467721a, r101.f467721a) == true) goto L12;
        return false;
    L12:
        if (this.f467722b == r101.f467722b) goto L15;
        return false;
    L15:
        if (this.f467723c == r101.f467723c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f467721a.hashCode() * 31) + this.f467722b) * 31) + this.f467723c;
    }

    public final String toString() {
        return "ResolutionProfile(name=" + this.f467721a + ", width=" + this.f467722b + ", height=" + this.f467723c + ')';
    }

    public c(String r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f467721a = r100;
        this.f467722b = r101;
        this.f467723c = r102;
    }
}
