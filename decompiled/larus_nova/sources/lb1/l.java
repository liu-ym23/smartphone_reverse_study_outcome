package lb1;

/* JADX INFO: loaded from: classes7.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f508343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f508344b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L10;
        l r101 = (l) r100;
        if (this.f508343a == r101.f508343a) goto L8;
        return false;
    L8:
        if (this.f508344b == r101.f508344b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.f508343a * 31) + this.f508344b;
    }

    public final String toString() {
        return "Size(width=" + this.f508343a + ", height=" + this.f508344b + ")";
    }

    public l(int r100, int r101) {
        this.f508343a = r100;
        this.f508344b = r101;
    }
}
