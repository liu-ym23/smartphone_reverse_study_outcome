package hq9;

/* JADX INFO: loaded from: classes31.dex */
public final class s2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f486769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f486770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f486771c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s2) == true) goto L8;
        return false;
    L8:
        s2 r101 = (s2) r100;
        if (this.f486769a == r101.f486769a) goto L12;
        return false;
    L12:
        if (this.f486770b == r101.f486770b) goto L15;
        return false;
    L15:
        if (this.f486771c == r101.f486771c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f486769a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f486770b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f486771c == true) goto L15;
        r100 = 1237;
    L15:
        return r104 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "LarkSocialImInitializationDecision(enabledBySettings=" + this.f486769a + ", enabledByFg=" + this.f486770b + ", shouldInitialize=" + this.f486771c + ')';
    }

    public s2(boolean r100, boolean r101, boolean r102) {
        this.f486769a = r100;
        this.f486770b = r101;
        this.f486771c = r102;
    }
}
