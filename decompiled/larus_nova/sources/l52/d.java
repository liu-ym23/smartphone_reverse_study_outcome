package l52;

/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f507496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f507497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f507498c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L12;
        d r101 = (d) r100;
        if (this.f507496a == r101.f507496a) goto L8;
        return false;
    L8:
        if (this.f507497b == r101.f507497b) goto L10;
        return false;
    L10:
        if (this.f507498c == r101.f507498c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return (((this.f507496a * 31) + this.f507497b) * 31) + this.f507498c;
    }

    public final String toString() {
        return "PSMessageUpdateInfo(size=" + this.f507496a + ", scrollSize=" + this.f507497b + ", foldSize=" + this.f507498c + ")";
    }

    public d(int r100) {
        this.f507496a = r100;
        this.f507497b = 0;
        this.f507498c = 0;
    }
}
