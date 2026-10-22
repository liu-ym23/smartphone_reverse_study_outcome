package itb;

/* JADX INFO: loaded from: classes37.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f495756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f495757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f495758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f495759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f495760e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f495761f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f495762g;

    public g() {
        this(0, false, false, false, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f495756a == r101.f495756a) goto L12;
        return false;
    L12:
        if (this.f495757b == r101.f495757b) goto L15;
        return false;
    L15:
        if (this.f495758c == r101.f495758c) goto L18;
        return false;
    L18:
        if (this.f495759d == r101.f495759d) goto L21;
        return false;
    L21:
        if (this.f495760e == r101.f495760e) goto L24;
        return false;
    L24:
        if (this.f495761f == r101.f495761f) goto L27;
        return false;
    L27:
        if (this.f495762g == r101.f495762g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f495756a * 31;
        int r101 = 1231;
        if (this.f495757b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f495758c == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (((r103 + r104) * 31) + this.f495759d) * 31;
        if (this.f495760e == false) goto L13;
        int r106 = 1231;
    L14:
        int r107 = (r105 + r106) * 31;
        if (this.f495761f == false) goto L17;
        int r108 = 1231;
    L18:
        int r109 = (r107 + r108) * 31;
        if (this.f495762g == true) goto L23;
        r101 = 1237;
    L23:
        return r109 + r101;
    L17:
        r108 = 1237;
        goto L18
    L13:
        r106 = 1237;
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "MediaPickConfig(maxSelectCount=" + this.f495756a + ", supportImage=" + this.f495757b + ", supportVideo=" + this.f495758c + ", maxDurationMs=" + this.f495759d + ", saveToAlbum=" + this.f495760e + ", keepOriginal=" + this.f495761f + ", useFrontCamera=" + this.f495762g + ')';
    }

    public /* synthetic */ g(int r100, boolean r110, boolean r111, boolean r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        int r101 = 9;
    L7:
        if ((r113 & 2) == 0) goto L9;
        boolean r102 = true;
    L11:
        if ((r113 & 4) == 0) goto L13;
        boolean r103 = false;
    L15:
        if ((r113 & 8) == 0) goto L17;
        int r104 = 60000;
    L19:
        if ((r113 & 32) == 0) goto L21;
        boolean r105 = false;
    L22:
        this(r101, r102, r103, r104, false, r105, false);
        return;
    L21:
        r105 = r112;
        goto L22
    L17:
        r104 = 0;
        goto L19
    L13:
        r103 = r111;
        goto L15
    L9:
        r102 = r110;
        goto L11
    L5:
        r101 = r100;
        goto L7
    }

    public g(int r100, boolean r101, boolean r102, int r103, boolean r104, boolean r105, boolean r106) {
        this.f495756a = r100;
        this.f495757b = r101;
        this.f495758c = r102;
        this.f495759d = r103;
        this.f495760e = r104;
        this.f495761f = r105;
        this.f495762g = r106;
    }
}
