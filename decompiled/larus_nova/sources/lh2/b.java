package lh2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f509230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f509231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient ql.a f509232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f509233d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f509230a, r101.f509230a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f509231b, r101.f509231b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f509232c, r101.f509232c) == true) goto L12;
        return false;
    L12:
        if (this.f509233d == r101.f509233d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f509230a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f509231b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ql.a r107 = this.f509232c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return ((r106 + r101) * 31) + this.f509233d;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ProductClickParamModel(roomId=" + this.f509230a + ", roomUniqueKey=" + this.f509231b + ", promotion=" + this.f509232c + ", productClickType=" + this.f509233d + ")";
    }

    public b(String r100, String r101, ql.a r102, int r103) {
        Intrinsics.checkNotNullParameter(r102, "promotion");
        this.f509230a = r100;
        this.f509231b = r101;
        this.f509232c = r102;
        this.f509233d = r103;
    }
}
