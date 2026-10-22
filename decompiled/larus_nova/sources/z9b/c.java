package z9b;

/* JADX INFO: loaded from: classes35.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f571080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f571081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f571082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f571083d;

    public c() {
        int r100 = 0;
        this(r100, r100, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f571080a == r101.f571080a) goto L12;
        return false;
    L12:
        if (this.f571081b == r101.f571081b) goto L15;
        return false;
    L15:
        if (this.f571082c == r101.f571082c) goto L18;
        return false;
    L18:
        if (this.f571083d == r101.f571083d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f571080a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((((r101 * 31) + this.f571081b) * 31) + this.f571082c) * 31;
        if (this.f571083d == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "UnifyAtStyleConfig(enable=" + this.f571080a + ", atTextColorResFromMe=" + this.f571081b + ", atTextColorResFromOther=" + this.f571082c + ", enableBold=" + this.f571083d + ')';
    }

    public /* synthetic */ c(int r100, int r101, int r102) {
        if ((r102 & 2) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 4) == 0) goto L8;
        r101 = 0;
    L8:
        this(false, r100, r101, false);
    }

    public c(boolean r100, int r101, int r102, boolean r103) {
        this.f571080a = r100;
        this.f571081b = r101;
        this.f571082c = r102;
        this.f571083d = r103;
    }
}
