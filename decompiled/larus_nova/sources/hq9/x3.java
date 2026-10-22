package hq9;

/* JADX INFO: loaded from: classes31.dex */
public final class x3 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final x3 f486812e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f486813a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f486814b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f486815c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f486816d;

    public static final class a {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof x3) == true) goto L8;
        return false;
    L8:
        x3 r101 = (x3) r100;
        if (this.f486813a == r101.f486813a) goto L12;
        return false;
    L12:
        if (this.f486814b == r101.f486814b) goto L15;
        return false;
    L15:
        if (this.f486815c == r101.f486815c) goto L18;
        return false;
    L18:
        if (this.f486816d == r101.f486816d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f486813a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f486814b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f486815c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f486816d == true) goto L19;
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
        return "RealCallSoundConfig(soundInterruptEnable=" + this.f486813a + ", enableConnectedSound=" + this.f486814b + ", enableComfortSound=" + this.f486815c + ", enableEndSound=" + this.f486816d + ')';
    }

    static {
        f486812e = new x3(false, false, false, false);
    }

    public x3(boolean r100, boolean r101, boolean r102, boolean r103) {
        this.f486813a = r100;
        this.f486814b = r101;
        this.f486815c = r102;
        this.f486816d = r103;
    }
}
