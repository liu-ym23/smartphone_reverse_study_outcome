package irb;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f495548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f495549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f495550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f495551d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f495552e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f495553f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f495554g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f495555h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f495556i;

    public final int hashCode() {
        String r100 = this.f495548a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f495549b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f495550c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((((r106 + r108) * 31) + (this.f495551d ? 1 : 0)) * 31) + (this.f495552e ? 1 : 0)) * 31;
        String r110 = this.f495553f;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f495554g;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return ((((r112 + r101) * 31) + this.f495555h) * 31) + this.f495556i;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public a() {
        this.f495551d = false;
        this.f495552e = false;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L61:
        return false;
    L8:
        if (a.class != r100.getClass()) goto L61;
        a r101 = (a) r100;
        if (this.f495551d == r101.f495551d) goto L14;
        return false;
    L14:
        if (this.f495552e == r101.f495552e) goto L17;
        return false;
    L17:
        if (this.f495555h == r101.f495555h) goto L20;
        return false;
    L20:
        if (this.f495556i == r101.f495556i) goto L22;
        return false;
    L22:
        String r102 = this.f495548a;
        if (r102 == null) goto L28;
        if (r102.equals(r101.f495548a) == false) goto L29;
    L30:
        String r103 = this.f495549b;
        if (r103 == null) goto L36;
        if (r103.equals(r101.f495549b) == false) goto L37;
    L38:
        String r104 = this.f495550c;
        if (r104 == null) goto L44;
        if (r104.equals(r101.f495550c) == false) goto L45;
    L46:
        String r105 = this.f495553f;
        if (r105 == null) goto L52;
        if (r105.equals(r101.f495553f) == false) goto L53;
    L54:
        String r106 = this.f495554g;
        String r107 = r101.f495554g;
        if (r106 != null) goto L62;
        if (r107 == null) goto L63;
        return false;
    L63:
        return true;
    L62:
        return r106.equals(r107);
    L53:
        return false;
    L52:
        if (r101.f495553f == null) goto L54;
    L45:
        return false;
    L44:
        if (r101.f495550c == null) goto L46;
    L37:
        return false;
    L36:
        if (r101.f495549b == null) goto L38;
    L29:
        return false;
    L28:
        if (r101.f495548a == null) goto L30;
        goto L29
    }
}
