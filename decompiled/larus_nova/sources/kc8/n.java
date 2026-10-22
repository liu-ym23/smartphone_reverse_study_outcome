package kc8;

/* JADX INFO: loaded from: classes25.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f502530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f502531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f502532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f502533d;

    public n() {
        this(0, 0, 0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (this.f502530a == r101.f502530a) goto L12;
        return false;
    L12:
        if (this.f502531b == r101.f502531b) goto L15;
        return false;
    L15:
        if (this.f502532c == r101.f502532c) goto L18;
        return false;
    L18:
        if (this.f502533d == r101.f502533d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f502530a * 31) + this.f502531b) * 31) + this.f502532c) * 31) + this.f502533d;
    }

    public final String toString() {
        return "ContainerPadding(left=" + this.f502530a + ", top=" + this.f502531b + ", right=" + this.f502532c + ", bottom=" + this.f502533d + ')';
    }

    public n(int r100, int r101, int r102, int r103) {
        this.f502530a = r100;
        this.f502531b = r101;
        this.f502532c = r102;
        this.f502533d = r103;
    }
}
