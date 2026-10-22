package q11;

/* JADX INFO: loaded from: classes47.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f531281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f531282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f531283c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (this.f531281a == r101.f531281a) goto L8;
        return false;
    L8:
        if (this.f531282b == r101.f531282b) goto L10;
        return false;
    L10:
        if (this.f531283c == r101.f531283c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return (((this.f531281a * 31) + this.f531282b) * 31) + this.f531283c;
    }

    public final String toString() {
        return "PkPlayModeInfo(playMode=" + this.f531281a + ", teamMode=" + this.f531282b + ", activityMode=" + this.f531283c + ")";
    }

    public d(int r100, int r101, int r102) {
        this.f531281a = r100;
        this.f531282b = r101;
        this.f531283c = r102;
    }
}
