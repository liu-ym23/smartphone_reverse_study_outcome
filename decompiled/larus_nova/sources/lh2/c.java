package lh2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f509234a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f509235b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient ql.a f509236c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f509237d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L14;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f509234a, r101.f509234a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f509235b, r101.f509235b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f509236c, r101.f509236c) == true) goto L12;
        return false;
    L12:
        if (this.f509237d == r101.f509237d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f509234a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f509235b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ql.a r107 = this.f509236c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return ((r106 + r101) * 31) + this.f509237d;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ProductShowParamModel(roomId=" + this.f509234a + ", roomUniqueKey=" + this.f509235b + ", promotion=" + this.f509236c + ", showArea=" + this.f509237d + ")";
    }

    public c(String r100, String r101, ql.a r102, int r103) {
        Intrinsics.checkNotNullParameter(r102, "promotion");
        this.f509234a = r100;
        this.f509235b = r101;
        this.f509236c = r102;
        this.f509237d = r103;
    }
}
