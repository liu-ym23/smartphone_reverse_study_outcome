package ns8;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f520351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f520352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f520353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f520354d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f520355e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f520356f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f520357g;

    public b() {
        this(false, false, false, false, false, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f520351a == r101.f520351a) goto L12;
        return false;
    L12:
        if (this.f520352b == r101.f520352b) goto L15;
        return false;
    L15:
        if (this.f520353c == r101.f520353c) goto L18;
        return false;
    L18:
        if (this.f520354d == r101.f520354d) goto L21;
        return false;
    L21:
        if (this.f520355e == r101.f520355e) goto L24;
        return false;
    L24:
        if (this.f520356f == r101.f520356f) goto L27;
        return false;
    L27:
        if (this.f520357g == r101.f520357g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f520351a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f520352b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f520353c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f520354d == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f520355e == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.f520356f == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (r110 + r111) * 31;
        if (this.f520357g == true) goto L31;
        r100 = 1237;
    L31:
        return r112 + r100;
    L25:
        r111 = 1237;
        goto L26
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
        return "ProcessConfig(skipCompress=" + this.f520351a + ", cacheKeepName=" + this.f520352b + ", skipUpload=" + this.f520353c + ", allowGif=" + this.f520354d + ", skipClone=" + this.f520355e + ", skipMd5=" + this.f520356f + ", skipDownscale=" + this.f520357g + ')';
    }

    public static b a(b r100, boolean r101, boolean r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        r101 = r100.f520351a;
    L5:
        boolean r102 = r101;
        if ((r111 & 2) == 0) goto L8;
        boolean r103 = r100.f520352b;
    L10:
        if ((r111 & 4) == 0) goto L12;
        boolean r104 = r100.f520353c;
    L14:
        if ((r111 & 8) == 0) goto L16;
        boolean r105 = r100.f520354d;
    L18:
        if ((r111 & 16) == 0) goto L20;
        boolean r106 = r100.f520355e;
    L22:
        if ((r111 & 32) == 0) goto L24;
        boolean r107 = r100.f520356f;
    L26:
        if ((r111 & 64) == 0) goto L28;
        r110 = r100.f520357g;
    L28:
        r100.getClass();
        return new b(r102, r103, r104, r105, r106, r107, r110);
    L24:
        r107 = false;
        goto L26
    L20:
        r106 = false;
        goto L22
    L16:
        r105 = false;
        goto L18
    L12:
        r104 = false;
        goto L14
    L8:
        r103 = false;
        goto L10
    }

    public /* synthetic */ b(boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, int r115) {
        if ((r115 & 1) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r115 & 4) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r115 & 8) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r115 & 16) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r115 & 32) == 0) goto L21;
        boolean r104 = false;
    L22:
        this(r100, false, r101, r102, r103, r104, false);
        return;
    L21:
        r104 = r114;
        goto L22
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public b(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106) {
        this.f520351a = r100;
        this.f520352b = r101;
        this.f520353c = r102;
        this.f520354d = r103;
        this.f520355e = r104;
        this.f520356f = r105;
        this.f520357g = r106;
    }
}
