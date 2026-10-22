package tib;

/* JADX INFO: loaded from: classes36.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f546357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f546358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f546359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f546360d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f546361e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f546362f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f546357a == r101.f546357a) goto L12;
        return false;
    L12:
        if (this.f546358b == r101.f546358b) goto L15;
        return false;
    L15:
        if (this.f546359c == r101.f546359c) goto L18;
        return false;
    L18:
        if (this.f546360d == r101.f546360d) goto L21;
        return false;
    L21:
        if (this.f546361e == r101.f546361e) goto L24;
        return false;
    L24:
        if (this.f546362f == r101.f546362f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f546357a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f546358b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f546359c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f546360d == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f546361e == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.f546362f == true) goto L27;
        r100 = 1237;
    L27:
        return r110 + r100;
    L21:
        r109 = 1237;
        goto L22
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
        return "ForwardSearchPickerParams(excludeOuterUser=" + this.f546357a + ", includeOutGroupChat=" + this.f546358b + ", needSearchOuterTenant=" + this.f546359c + ", includeBot=" + this.f546360d + ", includeThread=" + this.f546361e + ", includeAI=" + this.f546362f + ')';
    }

    public d(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105) {
        this.f546357a = r100;
        this.f546358b = r101;
        this.f546359c = r102;
        this.f546360d = r103;
        this.f546361e = r104;
        this.f546362f = r105;
    }
}
