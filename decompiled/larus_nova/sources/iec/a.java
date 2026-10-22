package iec;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f489508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f489509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f489510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f489511d;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f489508a == r101.f489508a) goto L12;
        return false;
    L12:
        if (this.f489509b == r101.f489509b) goto L15;
        return false;
    L15:
        if (this.f489510c == r101.f489510c) goto L18;
        return false;
    L18:
        if (this.f489511d == r101.f489511d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f489508a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f489509b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f489510c == true) goto L15;
        r100 = 1237;
    L15:
        return ((r104 + r100) * 31) + this.f489511d;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "AnchorDigestParams(isShowDocName=" + this.f489508a + ", isShowDocTitle=" + this.f489509b + ", showContentWithQuota=" + this.f489510c + ", iconColor=" + this.f489511d + ')';
    }

    public a(int r100) {
        this.f489508a = false;
        this.f489509b = false;
        this.f489510c = false;
        this.f489511d = 0;
    }
}
