package m20;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f511632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f511633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f511634c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f511635d;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (this.f511632a == r101.f511632a) goto L8;
        return false;
    L8:
        if (this.f511633b == r101.f511633b) goto L10;
        return false;
    L10:
        if (this.f511634c == r101.f511634c) goto L12;
        return false;
    L12:
        if (this.f511635d == r101.f511635d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.f511632a * 31) + this.f511633b) * 31) + this.f511634c) * 31) + this.f511635d;
    }

    public final String toString() {
        return "XplayPerfData(width=" + this.f511632a + ", height=" + this.f511633b + ", fps=" + this.f511634c + ", bitrate=" + this.f511635d + ")";
    }

    public a(int r100) {
        this.f511632a = 0;
        this.f511633b = 0;
        this.f511634c = 0;
        this.f511635d = 0;
    }
}
