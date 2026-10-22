package m93;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f512632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f512633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f512634c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o f512635d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof w) == false) goto L14;
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.f512632a, r101.f512632a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f512633b, r101.f512633b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f512634c, r101.f512634c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f512635d, r101.f512635d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Long r100 = this.f512632a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f512633b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        u r107 = this.f512634c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        o r110 = this.f512635d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PackDataV1(type=" + this.f512632a + ", id=" + this.f512633b + ", product=" + this.f512634c + ", extra=" + this.f512635d + ")";
    }

    public w() {
        this.f512632a = null;
        this.f512633b = null;
        this.f512634c = null;
        this.f512635d = null;
    }

    public final Long getType() {
        return this.f512632a;
    }
}
