package l19;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f507026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f507027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f507028c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f507026a == r101.f507026a) goto L12;
        return false;
    L12:
        if (this.f507027b == r101.f507027b) goto L15;
        return false;
    L15:
        if (this.f507028c == r101.f507028c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f507026a * 31) + this.f507027b) * 31) + this.f507028c;
    }

    public final String toString() {
        return "TransitionEndViewInfo(width=" + this.f507026a + ", height=" + this.f507027b + ", gravity=" + this.f507028c + ')';
    }

    public b(int r100, int r101, int r102) {
        this.f507026a = r100;
        this.f507027b = r101;
        this.f507028c = r102;
    }
}
