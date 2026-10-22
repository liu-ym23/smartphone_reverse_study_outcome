package kc8;

/* JADX INFO: loaded from: classes25.dex */
public final class q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f502559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f502560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f502561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f502562d;

    public q0() {
        this(false, false, false, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q0) == true) goto L8;
        return false;
    L8:
        q0 r101 = (q0) r100;
        if (this.f502559a == r101.f502559a) goto L12;
        return false;
    L12:
        if (this.f502560b == r101.f502560b) goto L15;
        return false;
    L15:
        if (this.f502561c == r101.f502561c) goto L18;
        return false;
    L18:
        if (this.f502562d == r101.f502562d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f502559a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f502560b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f502561c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f502562d == true) goto L19;
        r100 = 1237;
    L19:
        return r106 + r100;
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
        return "RichMediaCreationVideoCapability(canPlayInline=" + this.f502559a + ", showDownload=" + this.f502560b + ", showCite=" + this.f502561c + ", showExtend=" + this.f502562d + ')';
    }

    public q0(boolean r100, boolean r101, boolean r102, boolean r103) {
        this.f502559a = r100;
        this.f502560b = r101;
        this.f502561c = r102;
        this.f502562d = r103;
    }
}
