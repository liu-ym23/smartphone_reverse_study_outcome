package hq9;

/* JADX INFO: loaded from: classes31.dex */
public final class w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f486799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f486800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f486801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f486802d;

    public w1() {
        this(0, 0, 0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w1) == true) goto L8;
        return false;
    L8:
        w1 r101 = (w1) r100;
        if (this.f486799a == r101.f486799a) goto L12;
        return false;
    L12:
        if (this.f486800b == r101.f486800b) goto L15;
        return false;
    L15:
        if (this.f486801c == r101.f486801c) goto L18;
        return false;
    L18:
        if (this.f486802d == r101.f486802d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f486799a * 31) + this.f486800b) * 31) + this.f486801c) * 31) + this.f486802d;
    }

    public final String toString() {
        return "ImageUploadOptConfig(albumResize=" + this.f486799a + ", albumQuality=" + this.f486800b + ", cameraResize=" + this.f486801c + ", cameraQuality=" + this.f486802d + ')';
    }

    public w1(int r100, int r101, int r102, int r103) {
        this.f486799a = r100;
        this.f486800b = r101;
        this.f486801c = r102;
        this.f486802d = r103;
    }
}
