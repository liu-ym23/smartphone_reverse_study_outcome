package j59;

/* JADX INFO: loaded from: classes27.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f497469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f497470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f497471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f497472d;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f497469a == r101.f497469a) goto L12;
        return false;
    L12:
        if (this.f497470b == r101.f497470b) goto L15;
        return false;
    L15:
        if (this.f497471c == r101.f497471c) goto L18;
        return false;
    L18:
        if (this.f497472d == r101.f497472d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f497469a;
        return (((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f497470b) * 31) + this.f497471c) * 31) + this.f497472d;
    }

    public final String toString() {
        return "DoraGuideState(lastShowTime=" + this.f497469a + ", showTimes=" + this.f497470b + ", closeTimes=" + this.f497471c + ", clickTimes=" + this.f497472d + ')';
    }

    public /* synthetic */ a(int r100) {
        this(0, 0, 0, 0);
    }

    public a(long r100, int r101, int r102, int r103) {
        this.f497469a = r100;
        this.f497470b = r101;
        this.f497471c = r102;
        this.f497472d = r103;
    }

    public static a a(a r100, long r101, int r102, int r110, int r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        r101 = r100.f497469a;
    L5:
        long r103 = r101;
        if ((r112 & 2) == 0) goto L8;
        r102 = r100.f497470b;
    L8:
        int r104 = r102;
        if ((r112 & 4) == 0) goto L11;
        r110 = r100.f497471c;
    L11:
        int r105 = r110;
        if ((r112 & 8) == 0) goto L14;
        r111 = r100.f497472d;
    L14:
        r100.getClass();
        return new a(r103, r104, r105, r111);
    }
}
