package gg3;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f481107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f481108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f481109c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f481110d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (this.f481107a == r101.f481107a) goto L8;
        return false;
    L8:
        if (this.f481108b == r101.f481108b) goto L10;
        return false;
    L10:
        if (this.f481109c == r101.f481109c) goto L12;
        return false;
    L12:
        if (this.f481110d == r101.f481110d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.f481107a * 31) + this.f481108b) * 31) + this.f481109c) * 31) + this.f481110d;
    }

    public final String toString() {
        return "MallBannerShowConfig(notClickTimesForShield=" + this.f481107a + ", shieldNumOfDays=" + this.f481108b + ", topResidenceSize=" + this.f481109c + ", topResidenceTime=" + this.f481110d + ")";
    }

    public b(int r100, int r101, int r102, int r103) {
        this.f481107a = r100;
        this.f481108b = r101;
        this.f481109c = r102;
        this.f481110d = r103;
    }
}
