package n6a;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f518175c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f518176d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f518177e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f518178f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f518179g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a[] f518180h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f518181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f518182b;

    static {
        a r100 = new a(0, false);
        f518175c = r100;
        a r101 = new a(1, true);
        a r102 = new a(2, false);
        f518176d = r102;
        a r103 = new a(3, true);
        a r104 = new a(4, false);
        f518177e = r104;
        a r110 = new a(5, true);
        a r111 = new a(6, false);
        f518178f = r111;
        a r112 = new a(7, true);
        a r113 = new a(8, false);
        a r114 = new a(9, true);
        f518179g = r114;
        f518180h = new a[]{r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, new a(10, false), new a(10, true)};
    }

    public final a b() {
        if (this.f518182b == false) goto L9;
        a r100 = f518180h[this.f518181a - 1];
        if (r100.f518182b == true) goto L8;
        return r100;
    L8:
        return f518175c;
    L9:
        return this;
    }

    public final boolean a(a r100) {
        int r101 = this.f518181a;
        int r102 = r100.f518181a;
        if (r101 >= r102) goto L5;
    L11:
        return true;
    L5:
        if (this.f518182b == true) goto L7;
    L8:
        if (r101 == r102) goto L11;
    L10:
        return false;
    L7:
        if (f518179g != this) goto L10;
        goto L8
    }

    public a(int r100, boolean r101) {
        this.f518181a = r100;
        this.f518182b = r101;
    }
}
