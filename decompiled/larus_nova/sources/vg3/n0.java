package vg3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f554689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f554690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f554691c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n0) == false) goto L12;
        n0 r101 = (n0) r100;
        if (this.f554689a == r101.f554689a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f554690b, r101.f554690b) == true) goto L10;
        return false;
    L10:
        if (this.f554691c == r101.f554691c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        int r100 = this.f554689a * 31;
        String r101 = this.f554690b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L6:
        int r103 = (r100 + r102) * 31;
        boolean r104 = this.f554691c;
        ?? r105 = r104;
        if (r104 == false) goto L10;
        r105 = 1;
    L10:
        return r103 + r105;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TabSelectInfo(targetIndex=" + this.f554689a + ", targetGroupId=" + this.f554690b + ", fromUserClick=" + this.f554691c + ")";
    }

    public n0(int r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "targetGroupId");
        this.f554689a = r100;
        this.f554690b = r101;
        this.f554691c = r102;
    }
}
