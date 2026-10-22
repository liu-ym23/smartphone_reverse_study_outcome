package mr9;

/* JADX INFO: loaded from: classes31.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f514991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f514992b;

    public d() {
        this(0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f514991a == r101.f514991a) goto L12;
        return false;
    L12:
        if (this.f514992b == r101.f514992b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f514991a * 31) + this.f514992b;
    }

    public final String toString() {
        return "ImageUploadResult(height=" + this.f514991a + ", width=" + this.f514992b + ')';
    }

    public d(int r100, int r101) {
        this.f514991a = r100;
        this.f514992b = r101;
    }
}
