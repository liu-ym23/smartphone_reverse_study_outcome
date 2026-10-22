package wd;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f559265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f559266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f559267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f559268d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L14;
        c r101 = (c) r100;
        if (this.f559265a == r101.f559265a) goto L8;
        return false;
    L8:
        if (this.f559266b == r101.f559266b) goto L10;
        return false;
    L10:
        if (this.f559267c == r101.f559267c) goto L12;
        return false;
    L12:
        if (this.f559268d == r101.f559268d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.f559265a * 31) + this.f559266b) * 31) + this.f559267c) * 31) + this.f559268d;
    }

    public final String toString() {
        return "ECRect(left=" + this.f559265a + ", top=" + this.f559266b + ", width=" + this.f559267c + ", height=" + this.f559268d + ")";
    }

    public c(int r100, int r101, int r102, int r103) {
        this.f559265a = r100;
        this.f559266b = r101;
        this.f559267c = r102;
        this.f559268d = r103;
    }
}
