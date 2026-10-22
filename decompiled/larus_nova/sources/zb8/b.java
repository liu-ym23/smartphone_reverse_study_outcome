package zb8;

/* JADX INFO: loaded from: classes25.dex */
public final class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f571157f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f571158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f571159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f571160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f571161d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f571162e;

    public static final class a {
    }

    public b() {
        this(31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f571158a == r101.f571158a) goto L12;
        return false;
    L12:
        if (this.f571159b == r101.f571159b) goto L15;
        return false;
    L15:
        if (this.f571160c == r101.f571160c) goto L18;
        return false;
    L18:
        if (this.f571161d == r101.f571161d) goto L21;
        return false;
    L21:
        if (this.f571162e == r101.f571162e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f571158a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f571159b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f571160c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f571161d == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f571162e == true) goto L23;
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
        return "ChatCameraUiAbilityConfig(enableCaptureTitle=" + this.f571158a + ", enableCaptureTips=" + this.f571159b + ", enableResultSuggestedAction=" + this.f571160c + ", enableResultMarkedTips=" + this.f571161d + ", enableResultVlmEduIntent=" + this.f571162e + ')';
    }

    static {
        f571157f = new b(false, false, false, true, true);
    }

    public /* synthetic */ b(int r110) {
        if ((r110 & 1) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r110 & 2) == 0) goto L9;
        boolean r101 = true;
    L11:
        if ((r110 & 4) == 0) goto L13;
        boolean r102 = true;
    L15:
        if ((r110 & 8) == 0) goto L17;
        boolean r103 = true;
    L19:
        if ((r110 & 16) == 0) goto L21;
        boolean r104 = true;
    L22:
        this(r100, r101, r102, r103, r104);
        return;
    L21:
        r104 = false;
        goto L22
    L17:
        r103 = false;
        goto L19
    L13:
        r102 = false;
        goto L15
    L9:
        r101 = false;
        goto L11
    L5:
        r100 = false;
        goto L7
    }

    public b(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104) {
        this.f571158a = r100;
        this.f571159b = r101;
        this.f571160c = r102;
        this.f571161d = r103;
        this.f571162e = r104;
    }
}
