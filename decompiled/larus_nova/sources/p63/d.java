package p63;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f527887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f527888b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f527887a, r101.f527887a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f527888b, r101.f527888b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f527887a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f527888b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "InstructBoardVO(schema=" + this.f527887a + ", text=" + this.f527888b + ")";
    }

    public d(String r100, String r101) {
        this.f527887a = r100;
        this.f527888b = r101;
    }
}
