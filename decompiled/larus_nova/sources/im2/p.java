package im2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f490523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f490524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f490525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f490526d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final double f490527e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f490528f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L18;
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f490523a, r101.f490523a) == true) goto L8;
        return false;
    L8:
        if (this.f490524b == r101.f490524b) goto L10;
        return false;
    L10:
        if (Double.compare(this.f490525c, r101.f490525c) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.f490526d, r101.f490526d) == 0) goto L14;
        return false;
    L14:
        if (Double.compare(this.f490527e, r101.f490527e) == 0) goto L16;
        return false;
    L16:
        if (this.f490528f == r101.f490528f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f490523a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = ((r101 * 31) + this.f490524b) * 31;
        long r103 = Double.doubleToLongBits(this.f490525c);
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = Double.doubleToLongBits(this.f490526d);
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = Double.doubleToLongBits(this.f490527e);
        return ((r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31) + this.f490528f;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "WSPayloadDecompressInfo(name=" + this.f490523a + ", cnt=" + this.f490524b + ", equalRatio=" + this.f490525c + ", largerRatio=" + this.f490526d + ", smallerRatio=" + this.f490527e + ", avgSaveMem=" + this.f490528f + ")";
    }

    public p(String r100, int r101, double r102, double r103, double r104, int r110) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f490523a = r100;
        this.f490524b = r101;
        this.f490525c = r102;
        this.f490526d = r103;
        this.f490527e = r104;
        this.f490528f = r110;
    }
}
