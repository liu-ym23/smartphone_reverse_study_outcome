package ir5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f {
    public final int a;
    public final int b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L8;
        return false;
    L8:
        f r6 = (f) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a * 31) + this.b;
    }

    public final String toString() {
        return "OfficeDrivePreviewPageRange(pageStart=" + this.a + ", pageEnd=" + this.b + ')';
    }

    public f(int r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
