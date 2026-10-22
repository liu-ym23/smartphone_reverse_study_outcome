package nh0;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f519103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f519104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f519105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f519106d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (this.f519103a == r101.f519103a) goto L8;
        return false;
    L8:
        if (this.f519104b == r101.f519104b) goto L10;
        return false;
    L10:
        if (this.f519105c == r101.f519105c) goto L12;
        return false;
    L12:
        if (this.f519106d == r101.f519106d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.f519103a * 31) + this.f519104b) * 31) + this.f519105c) * 31) + this.f519106d;
    }

    public final String toString() {
        return "AnimExtraFrame(x=" + this.f519103a + ", y=" + this.f519104b + ", w=" + this.f519105c + ", h=" + this.f519106d + ")";
    }

    public a(int r100, int r101, int r102, int r103) {
        this.f519103a = r100;
        this.f519104b = r101;
        this.f519105c = r102;
        this.f519106d = r103;
    }
}
