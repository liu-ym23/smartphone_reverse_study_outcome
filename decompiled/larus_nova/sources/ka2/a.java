package ka2;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f502178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f502179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f502180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f502181d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (this.f502179b == r101.f502179b) goto L8;
        return false;
    L8:
        if (this.f502180c == r101.f502180c) goto L10;
        return false;
    L10:
        if (this.f502181d == r101.f502181d) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return (((this.f502179b * 31) + this.f502180c) * 31) + this.f502181d;
    }

    public final String toString() {
        return "MessageUpdateInfo(size=" + this.f502179b + ", scrollSize=" + this.f502180c + ", foldSize=" + this.f502181d + ")";
    }

    public a(int r100, int r101, int r102) {
        this.f502179b = r100;
        this.f502180c = r101;
        this.f502181d = r102;
    }
}
