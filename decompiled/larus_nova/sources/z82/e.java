package z82;

/* JADX INFO: loaded from: classes9.dex */
public final class e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f570902g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f570903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f570904b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f570905c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f570906d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f570907e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f570908f;

    public static final class a {
        public a() {
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L18;
        e r101 = (e) r100;
        if (this.f570903a == r101.f570903a) goto L8;
        return false;
    L8:
        if (this.f570904b == r101.f570904b) goto L10;
        return false;
    L10:
        if (this.f570905c == r101.f570905c) goto L12;
        return false;
    L12:
        if (this.f570906d == r101.f570906d) goto L14;
        return false;
    L14:
        if (this.f570907e == r101.f570907e) goto L16;
        return false;
    L16:
        if (this.f570908f == r101.f570908f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        return (((((((((this.f570903a * 31) + this.f570904b) * 31) + this.f570905c) * 31) + this.f570906d) * 31) + this.f570907e) * 31) + this.f570908f;
    }

    public final String toString() {
        return "PlayerLayoutDescriptor(playerWidth=" + this.f570903a + ", playerHeight=" + this.f570904b + ", coreLeftMargin=" + this.f570905c + ", coreTopMargin=" + this.f570906d + ", coreWidth=" + this.f570907e + ", coreHeight=" + this.f570908f + ")";
    }

    static {
        f570902g = new a();
    }

    public e(int r100, int r101, int r102, int r103, int r104, int r105) {
        this.f570903a = r100;
        this.f570904b = r101;
        this.f570905c = r102;
        this.f570906d = r103;
        this.f570907e = r104;
        this.f570908f = r105;
    }
}
