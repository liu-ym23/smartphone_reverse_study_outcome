package lq9;

/* JADX INFO: loaded from: classes31.dex */
public final class h0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h0 f510334e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f510335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f510336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f510337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f510338d;

    public static final class a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h0) == true) goto L8;
        return false;
    L8:
        h0 r101 = (h0) r100;
        if (this.f510335a == r101.f510335a) goto L12;
        return false;
    L12:
        if (this.f510336b == r101.f510336b) goto L15;
        return false;
    L15:
        if (this.f510337c == r101.f510337c) goto L18;
        return false;
    L18:
        if (this.f510338d == r101.f510338d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f510335a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f510336b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f510337c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f510338d == true) goto L19;
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
        return "SpeechEntranceConfig(showOnInputASR=" + this.f510335a + ", showOnActionbar=" + this.f510336b + ", showOnSpeakText=" + this.f510337c + ", showOnSpeakIcon=" + this.f510338d + ')';
    }

    static {
        f510334e = new h0(false, false, false, false);
    }

    public h0(boolean r100, boolean r101, boolean r102, boolean r103) {
        this.f510335a = r100;
        this.f510336b = r101;
        this.f510337c = r102;
        this.f510338d = r103;
    }
}
