package wnb;

/* JADX INFO: loaded from: classes36.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f560495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f560496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f560497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f560498d;

    public e() {
        this(0, 0, 0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f560495a == r101.f560495a) goto L12;
        return false;
    L12:
        if (this.f560496b == r101.f560496b) goto L15;
        return false;
    L15:
        if (this.f560497c == r101.f560497c) goto L18;
        return false;
    L18:
        if (this.f560498d == r101.f560498d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f560495a * 31) + this.f560496b) * 31) + this.f560497c) * 31) + this.f560498d;
    }

    public final String toString() {
        return "Margins(left=" + this.f560495a + ", top=" + this.f560496b + ", right=" + this.f560497c + ", bottom=" + this.f560498d + ')';
    }

    public e(int r100, int r101, int r102, int r103) {
        this.f560495a = r100;
        this.f560496b = r101;
        this.f560497c = r102;
        this.f560498d = r103;
    }
}
