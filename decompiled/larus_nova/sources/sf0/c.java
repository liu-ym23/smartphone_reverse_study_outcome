package sf0;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f541705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f541706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f541707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f541708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f541709e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L14;
        c r101 = (c) r100;
        if (this.f541706b == r101.f541706b) goto L8;
        return false;
    L8:
        if (this.f541707c == r101.f541707c) goto L10;
        return false;
    L10:
        if (this.f541708d == r101.f541708d) goto L12;
        return false;
    L12:
        if (this.f541709e == r101.f541709e) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.f541706b * 31) + this.f541707c) * 31) + this.f541708d) * 31) + this.f541709e;
    }

    public final String toString() {
        return "DynamicSeatAreaFrameInfo(x=" + this.f541706b + ", y=" + this.f541707c + ", width=" + this.f541708d + ", height=" + this.f541709e + ")";
    }

    public c(int r100, int r101, int r102, int r103) {
        this.f541706b = r100;
        this.f541707c = r101;
        this.f541708d = r102;
        this.f541709e = r103;
    }
}
