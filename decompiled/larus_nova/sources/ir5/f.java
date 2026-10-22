package ir5;

/* JADX INFO: loaded from: classes16.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f495475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f495476b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f495475a == r101.f495475a) goto L12;
        return false;
    L12:
        if (this.f495476b == r101.f495476b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f495475a * 31) + this.f495476b;
    }

    public final String toString() {
        return "OfficeDrivePreviewPageRange(pageStart=" + this.f495475a + ", pageEnd=" + this.f495476b + ')';
    }

    public f(int r100, int r101) {
        this.f495475a = r100;
        this.f495476b = r101;
    }
}
