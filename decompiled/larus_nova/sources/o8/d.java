package o8;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f522324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f522325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f522326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f522327d;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f522324a == r101.f522324a) goto L12;
        return false;
    L12:
        if (this.f522325b == r101.f522325b) goto L15;
        return false;
    L15:
        if (this.f522326c == r101.f522326c) goto L18;
        return false;
    L18:
        if (this.f522327d == r101.f522327d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f522324a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f522325b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f522326c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f522327d == true) goto L19;
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
        return "FlavorConfig(isDouyin=" + this.f522324a + ", isXT=" + this.f522325b + ", isDylite=" + this.f522326c + ", isHotsoon=" + this.f522327d + ')';
    }

    public d(int r100) {
        this.f522324a = false;
        this.f522325b = false;
        this.f522326c = false;
        this.f522327d = false;
    }
}
