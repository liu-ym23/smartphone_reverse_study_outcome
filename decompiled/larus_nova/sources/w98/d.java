package w98;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes25.dex */
public final class d {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f558768p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f558769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f558770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f558771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f558772d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f558773e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f558774f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f558775g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f558776h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f558777i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f558778j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f558779k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f558780l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f558781m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LinkedHashMap<Long, b> f558782n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f558783o;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f558784a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f558785b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f558786c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f558787d;

        public b(long r100) {
            this.f558784a = r100;
            this.f558785b = false;
            this.f558786c = false;
            this.f558787d = false;
        }
    }

    static {
    }

    public final int a() {
        Object r100 = this.f558772d;
        monitor-enter(r100);
        int r101 = this.f558779k;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public final int b() {
        Object r100 = this.f558772d;
        monitor-enter(r100);
        long r101 = this.f558775g;     // Catch: Throwable -> L11
        int r102 = this.f558773e;     // Catch: Throwable -> L11
        if (r102 <= 0) goto L8;
        int r103 = (int) (r101 / ((long) r102));
    L9:
        monitor-exit(r100);
        return r103;
    L8:
        r103 = 0;
    L11:
        th = move-exception;
        throw th;
    }

    public final int c() {
        Object r100 = this.f558772d;
        monitor-enter(r100);
        long r101 = this.f558781m;     // Catch: Throwable -> L11
        int r102 = this.f558780l;     // Catch: Throwable -> L11
        if (r102 <= 0) goto L8;
        int r103 = (int) (r101 / ((long) r102));
    L9:
        monitor-exit(r100);
        return r103;
    L8:
        r103 = 0;
    L11:
        th = move-exception;
        throw th;
    }

    public final int d() {
        Object r100 = this.f558772d;
        monitor-enter(r100);
        long r101 = this.f558776h;     // Catch: Throwable -> L11
        int r102 = this.f558773e;     // Catch: Throwable -> L11
        if (r102 <= 0) goto L8;
        int r103 = (int) (r101 / ((long) r102));
    L9:
        monitor-exit(r100);
        return r103;
    L8:
        r103 = 0;
    L11:
        th = move-exception;
        throw th;
    }

    public final int e() {
        Object r100 = this.f558772d;
        monitor-enter(r100);
        long r101 = this.f558778j;     // Catch: Throwable -> L11
        int r102 = this.f558779k;     // Catch: Throwable -> L11
        if (r102 <= 0) goto L8;
        int r103 = (int) (r101 / ((long) r102));
    L9:
        monitor-exit(r100);
        return r103;
    L8:
        r103 = 0;
    L11:
        th = move-exception;
        throw th;
    }

    public final int f() {
        Object r100 = this.f558772d;
        monitor-enter(r100);
        int r101 = this.f558780l;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public final int g() {
        Object r100 = this.f558772d;
        monitor-enter(r100);
        int r101 = this.f558773e;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public final int h() {
        Object r100 = this.f558772d;
        monitor-enter(r100);
        int r101 = this.f558777i;     // Catch: Throwable -> L7
        monitor-exit(r100);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public d(long r100, int r101) {
        this.f558769a = r100;
        this.f558770b = r101;
        this.f558771c = 100;
        this.f558772d = new Object();
        this.f558782n = new LinkedHashMap();
    }
}
