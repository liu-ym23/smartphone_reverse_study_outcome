package vq;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f556752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f556753b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (this.f556752a == r101.f556752a) goto L8;
        return false;
    L8:
        if (this.f556753b == r101.f556753b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.f556752a * 31) + this.f556753b;
    }

    public final String toString() {
        return "InnerGradientColor(color=" + this.f556752a + ", location=" + this.f556753b + ")";
    }

    public d(int r100, int r101) {
        this.f556752a = r100;
        this.f556753b = r101;
    }

    public static d a(d r100, int r101) {
        int r102 = r100.f556752a;
        r100.getClass();
        return new d(r102, r101);
    }
}
