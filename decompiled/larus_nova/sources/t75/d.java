package t75;

/* JADX INFO: loaded from: classes16.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f544885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f544886b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f544885a == r101.f544885a) goto L12;
        return false;
    L12:
        if (this.f544886b == r101.f544886b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f544885a * 31) + this.f544886b;
    }

    public final String toString() {
        return "DrivePreviewAiPageRange(pageStart=" + this.f544885a + ", pageEnd=" + this.f544886b + ')';
    }

    public d(int r100, int r101) {
        this.f544885a = r100;
        this.f544886b = r101;
    }
}
