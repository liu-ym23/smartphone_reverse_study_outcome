package hq9;

/* JADX INFO: loaded from: classes4.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f486662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f486663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f486664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f486665d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f486666e;

    public m() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof m) == true) goto L8;
        return false;
    L8:
        m r101 = (m) r100;
        if (this.f486662a == r101.f486662a) goto L12;
        return false;
    L12:
        if (this.f486663b == r101.f486663b) goto L15;
        return false;
    L15:
        if (this.f486664c == r101.f486664c) goto L18;
        return false;
    L18:
        if (this.f486665d == r101.f486665d) goto L21;
        return false;
    L21:
        if (this.f486666e == r101.f486666e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f486662a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f486663b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f486664c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f486665d == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f486666e == true) goto L23;
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
        return "AppsFrameworkConfig(appsFrameworkEnable=" + this.f486662a + ", appsPermissionEnable=" + this.f486663b + ", appsMultiworkPopupEnable=" + this.f486664c + ", appsMultiworkEntranceEnable=" + this.f486665d + ", appsMusicEnable=" + this.f486666e + ')';
    }

    public /* synthetic */ m(int r100) {
        this(true, true, true, false, false);
    }

    public m(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104) {
        this.f486662a = r100;
        this.f486663b = r101;
        this.f486664c = r102;
        this.f486665d = r103;
        this.f486666e = r104;
    }
}
