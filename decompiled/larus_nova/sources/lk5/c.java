package lk5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f509571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f509572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f509573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f509574d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f509571a, r101.f509571a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f509572b, r101.f509572b) == true) goto L15;
        return false;
    L15:
        if (this.f509573c == r101.f509573c) goto L18;
        return false;
    L18:
        if (this.f509574d == r101.f509574d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f509571a.hashCode() * 31) + this.f509572b.hashCode()) * 31) + this.f509573c) * 31;
        if (this.f509574d == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "OfficeAnchoredMenuItem(id=" + this.f509571a + ", title=" + this.f509572b + ", iconRes=" + this.f509573c + ", enabled=" + this.f509574d + ')';
    }

    public c(String r100, String r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "title");
        this.f509571a = r100;
        this.f509572b = r101;
        this.f509573c = r102;
        this.f509574d = r103;
    }
}
