package pj5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f529497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f529498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f529499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f529500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f529501e;

    public o() {
        this(-1, "", false, -1, -1);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (this.f529497a == r101.f529497a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f529498b, r101.f529498b) == true) goto L15;
        return false;
    L15:
        if (this.f529499c == r101.f529499c) goto L18;
        return false;
    L18:
        if (this.f529500d == r101.f529500d) goto L21;
        return false;
    L21:
        if (this.f529501e == r101.f529501e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f529497a * 31) + this.f529498b.hashCode()) * 31;
        if (this.f529499c == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        long r103 = this.f529500d;
        return ((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f529501e;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "FreshnessParam(objType=" + this.f529497a + ", objToken=" + this.f529498b + ", isCustomer=" + this.f529499c + ", deadlineTime=" + this.f529500d + ", freshStatus=" + this.f529501e + ')';
    }

    public o(int r100, String r101, boolean r102, long r103, int r104) {
        Intrinsics.checkNotNullParameter(r101, "objToken");
        this.f529497a = r100;
        this.f529498b = r101;
        this.f529499c = r102;
        this.f529500d = r103;
        this.f529501e = r104;
    }
}
