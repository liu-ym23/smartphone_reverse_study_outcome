package qg6;

/* JADX INFO: loaded from: classes19.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f532869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f532870b;

    public j() {
        this(0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L10;
        j r101 = (j) r100;
        if (this.f532869a == r101.f532869a) goto L8;
        return false;
    L8:
        if (this.f532870b == r101.f532870b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.f532869a * 31) + this.f532870b;
    }

    public final String toString() {
        return "ResolutionParams(width=" + this.f532869a + ", height=" + this.f532870b + ")";
    }

    public j(int r100, int r101) {
        this.f532869a = r100;
        this.f532870b = r101;
    }
}
