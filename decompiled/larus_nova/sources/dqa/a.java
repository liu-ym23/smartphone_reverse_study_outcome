package dqa;

/* JADX INFO: loaded from: classes34.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f469708c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f469709d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f469710e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f469711f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f469712g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f469713h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a[] f469714i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f469715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f469716b;

    static {
        a r100 = new a(0, false);
        f469708c = r100;
        a r101 = new a(1, true);
        a r102 = new a(2, false);
        f469709d = r102;
        a r103 = new a(3, true);
        a r104 = new a(4, false);
        f469710e = r104;
        a r110 = new a(5, true);
        a r111 = new a(6, false);
        f469711f = r111;
        a r112 = new a(7, true);
        a r113 = new a(8, false);
        f469712g = r113;
        a r114 = new a(9, true);
        f469713h = r114;
        f469714i = new a[]{r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, new a(10, false), new a(10, true)};
    }

    public final a b() {
        if (this.f469716b == false) goto L9;
        a r100 = f469714i[this.f469715a - 1];
        if (r100.f469716b == true) goto L8;
        return r100;
    L8:
        return f469708c;
    L9:
        return this;
    }

    public final boolean a(a r100) {
        int r101 = this.f469715a;
        int r102 = r100.f469715a;
        if (r101 >= r102) goto L5;
    L11:
        return true;
    L5:
        if (this.f469716b == true) goto L7;
    L8:
        if (r101 == r102) goto L11;
    L10:
        return false;
    L7:
        if (f469713h != this) goto L10;
        goto L8
    }

    public a(int r100, boolean r101) {
        this.f469715a = r100;
        this.f469716b = r101;
    }
}
