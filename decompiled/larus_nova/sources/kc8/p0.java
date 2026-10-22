package kc8;

/* JADX INFO: loaded from: classes25.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f502541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f502542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f502543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f502544d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f502545e;

    public p0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p0) == true) goto L8;
        return false;
    L8:
        p0 r101 = (p0) r100;
        if (this.f502541a == r101.f502541a) goto L12;
        return false;
    L12:
        if (this.f502542b == r101.f502542b) goto L15;
        return false;
    L15:
        if (this.f502543c == r101.f502543c) goto L18;
        return false;
    L18:
        if (this.f502544d == r101.f502544d) goto L21;
        return false;
    L21:
        if (this.f502545e == r101.f502545e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f502541a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f502542b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f502543c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f502544d == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f502545e == true) goto L23;
        r100 = 1237;
    L23:
        return r108 + r100;
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "RichMediaCreationImageButtonCapability(showDownload=" + this.f502541a + ", showShare=" + this.f502542b + ", showImageEdit=" + this.f502543c + ", showVideoEdit=" + this.f502544d + ", showCite=" + this.f502545e + ')';
    }

    public /* synthetic */ p0(int r100) {
        this(false, false, false, false, false);
    }

    public p0(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104) {
        this.f502541a = r100;
        this.f502542b = r101;
        this.f502543c = r102;
        this.f502544d = r103;
        this.f502545e = r104;
    }
}
