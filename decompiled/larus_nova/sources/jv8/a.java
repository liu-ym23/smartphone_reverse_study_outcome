package jv8;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f500583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f500584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f500585c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f500583a == r101.f500583a) goto L12;
        return false;
    L12:
        if (this.f500584b == r101.f500584b) goto L15;
        return false;
    L15:
        if (this.f500585c == r101.f500585c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f500583a * 31) + this.f500584b) * 31) + this.f500585c;
    }

    public final String toString() {
        return "BrowserScreencastParameters(maxWidth=" + this.f500583a + ", maxHeight=" + this.f500584b + ", quality=" + this.f500585c + ')';
    }

    public a(int r100, int r101, int r102) {
        this.f500583a = r100;
        this.f500584b = r101;
        this.f500585c = r102;
    }
}
