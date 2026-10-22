package ih9;

/* JADX INFO: loaded from: classes30.dex */
public final class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f489916g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f489917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f489918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f489919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f489920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f489921e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f489922f;

    public static final class a {
        public static final boolean a(boolean r100, c r101, String r102) {
            if (r100 == true) goto L4;
        L6:
            return false;
        L4:
            if (((Boolean) r101.invoke(r102, Boolean.TRUE)).booleanValue() == false) goto L6;
            return true;
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f489917a == r101.f489917a) goto L12;
        return false;
    L12:
        if (this.f489918b == r101.f489918b) goto L15;
        return false;
    L15:
        if (this.f489919c == r101.f489919c) goto L18;
        return false;
    L18:
        if (this.f489920d == r101.f489920d) goto L21;
        return false;
    L21:
        if (this.f489921e == r101.f489921e) goto L24;
        return false;
    L24:
        if (this.f489922f == r101.f489922f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f489917a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f489918b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f489919c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f489920d == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f489921e == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.f489922f == true) goto L27;
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
        return "VoiceSettingPerformanceFlags(enabled=" + this.f489917a + ", recomposition=" + this.f489918b + ", imageReuse=" + this.f489919c + ", previewRefresh=" + this.f489920d + ", recommendationDedup=" + this.f489921e + ", previewCallbackGuard=" + this.f489922f + ')';
    }

    public d(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105) {
        this.f489917a = r100;
        this.f489918b = r101;
        this.f489919c = r102;
        this.f489920d = r103;
        this.f489921e = r104;
        this.f489922f = r105;
    }
}
