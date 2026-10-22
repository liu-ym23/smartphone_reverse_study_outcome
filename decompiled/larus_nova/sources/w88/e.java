package w88;

/* JADX INFO: loaded from: classes23.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f558662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f558663b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f558662a == r101.f558662a) goto L12;
        return false;
    L12:
        if (this.f558663b == r101.f558663b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f558662a * 31) + this.f558663b;
    }

    public final String toString() {
        return "DoraOAlbumCount(photoCount=" + this.f558662a + ", videoCount=" + this.f558663b + ')';
    }

    public e(int r100, int r101) {
        this.f558662a = r100;
        this.f558663b = r101;
    }
}
