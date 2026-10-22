package wpa;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f560634c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f560635d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f560636e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f560637f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f560638g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a[] f560639h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f560640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f560641b;

    static {
        a r100 = new a(0, false);
        f560634c = r100;
        a r101 = new a(1, true);
        a r102 = new a(2, false);
        f560635d = r102;
        a r103 = new a(3, true);
        a r104 = new a(4, false);
        f560636e = r104;
        a r110 = new a(5, true);
        a r111 = new a(6, false);
        f560637f = r111;
        a r112 = new a(7, true);
        a r113 = new a(8, false);
        a r114 = new a(9, true);
        f560638g = r114;
        f560639h = new a[]{r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, new a(10, false), new a(10, true)};
    }

    public final boolean a(a r100) {
        int r101 = this.f560640a;
        int r102 = r100.f560640a;
        if (r101 >= r102) goto L5;
    L11:
        return true;
    L5:
        if (this.f560641b == true) goto L7;
    L8:
        if (r101 == r102) goto L11;
    L10:
        return false;
    L7:
        if (f560638g != this) goto L10;
        goto L8
    }

    public a(int r100, boolean r101) {
        this.f560640a = r100;
        this.f560641b = r101;
    }
}
