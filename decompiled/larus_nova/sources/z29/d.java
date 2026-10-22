package z29;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f569816a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f569817b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f569818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f569819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f569820e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a f569821f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Double.compare(this.f569816a, r101.f569816a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.f569817b, r101.f569817b) == 0) goto L15;
        return false;
    L15:
        if (this.f569818c == r101.f569818c) goto L18;
        return false;
    L18:
        if (this.f569819d == r101.f569819d) goto L21;
        return false;
    L21:
        if (this.f569820e == r101.f569820e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f569821f, r101.f569821f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f569816a);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.f569817b);
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        int r104 = 1231;
        if (this.f569818c == false) goto L5;
        int r105 = 1231;
    L6:
        int r106 = (r103 + r105) * 31;
        if (this.f569819d == false) goto L9;
        int r107 = 1231;
    L10:
        int r108 = (r106 + r107) * 31;
        if (this.f569820e == true) goto L14;
        r104 = 1237;
    L14:
        int r109 = (r108 + r104) * 31;
        a r110 = this.f569821f;
        if (r110 != null) goto L17;
        int r111 = 0;
    L19:
        return r109 + r111;
    L17:
        r111 = r110.hashCode();
        goto L19
    L9:
        r107 = 1237;
        goto L10
    L5:
        r105 = 1237;
        goto L6
    }

    public final String toString() {
        return "NormalizedMembershipQuotaUsage(usedPercent=" + this.f569816a + ", barPercent=" + this.f569817b + ", lessThanOnePercent=" + this.f569818c + ", exhausted=" + this.f569819d + ", unlimited=" + this.f569820e + ", absoluteUsage=" + this.f569821f + ')';
    }

    public d(double r100, double r101, boolean r102, boolean r103, boolean r104, a r105) {
        this.f569816a = r100;
        this.f569817b = r101;
        this.f569818c = r102;
        this.f569819d = r103;
        this.f569820e = r104;
        this.f569821f = r105;
    }
}
