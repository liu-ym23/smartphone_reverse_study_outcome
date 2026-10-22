package e29;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f470837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f470838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f470839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f470840d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f470841e;

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
        if (this.f470837a == r101.f470837a) goto L12;
        return false;
    L12:
        if (this.f470838b == r101.f470838b) goto L15;
        return false;
    L15:
        if (this.f470839c == r101.f470839c) goto L18;
        return false;
    L18:
        if (this.f470840d == r101.f470840d) goto L21;
        return false;
    L21:
        if (this.f470841e == r101.f470841e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f470837a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f470838b == true) goto L11;
        r100 = 1237;
    L11:
        return ((((((r102 + r100) * 31) + this.f470839c) * 31) + this.f470840d) * 31) + this.f470841e;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "CommunityDetailChromePolicy(enabled=" + this.f470837a + ", isRootPage=" + this.f470838b + ", trailingActionReservedWidth=" + this.f470839c + ", backIconRes=" + this.f470840d + ", shareIconRes=" + this.f470841e + ')';
    }

    public /* synthetic */ a(int r100) {
        this(false, false, 0, 0, 0);
    }

    public a(boolean r100, boolean r101, int r102, int r103, int r104) {
        this.f470837a = r100;
        this.f470838b = r101;
        this.f470839c = r102;
        this.f470840d = r103;
        this.f470841e = r104;
    }
}
