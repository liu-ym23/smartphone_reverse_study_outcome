package es3;

/* JADX INFO: loaded from: classes14.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f473762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f473763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f473764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f473765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f473766e;

    public final String toString() {
        return this.f473765d + "," + this.f473762a + "," + this.f473766e + "," + this.f473763b + "," + this.f473764c;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof m) == false) goto L10;
        m r101 = (m) r100;
        if (r101.f473762a == this.f473762a) goto L7;
        return false;
    L7:
        if (r101.f473765d != this.f473765d) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    public m(int r100, int r101, long r102, int r103) {
        this.f473766e = 1;
        this.f473762a = r100;
        this.f473763b = r101;
        this.f473765d = r103;
        this.f473764c = r102;
    }
}
