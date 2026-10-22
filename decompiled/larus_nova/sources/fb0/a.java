package fb0;

import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a implements j {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final WeakHashMap<a, Object> f476199h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ThreadLocal f476200i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f476201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f476202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f476203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f476204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f476205e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f476206f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f476207g;

    public a() {
        this(0);
    }

    public abstract int b();

    public abstract boolean d(e r100);

    static {
        f476199h = new WeakHashMap();
        f476200i = new ThreadLocal();
    }

    public void e() {
        c r100 = this.f476207g;
        if (r100 != null) goto L5;
    L23:
        this.f476202b = 0;
        this.f476207g = null;
        return;
    L5:
        if (this.f476201a == (-1)) goto L23;
        e r101 = (e) r100;
        boolean r102 = true;
        if (this.f476202b == 1) goto L10;
        r102 = false;
    L10:
        if (r102 == false) goto L22;
        h r103 = r101.f476229s;
        monitor-enter(r103);
        h r104 = r101.f476229s;     // Catch: Throwable -> L19
        int r105 = this.f476201a;     // Catch: Throwable -> L19
        int[] r106 = r104.f476239a;     // Catch: Throwable -> L19
        int r107 = r106.length;     // Catch: Throwable -> L19
        int r108 = r104.f476240b;     // Catch: Throwable -> L19
        if (r107 != r108) goto L16;
        int[] r109 = new int[r108 + r108];     // Catch: Throwable -> L19
        System.arraycopy(r106, 0, r109, 0, r108);     // Catch: Throwable -> L19
        r104.f476239a = r109;     // Catch: Throwable -> L19
    L16:
        int[] r110 = r104.f476239a;     // Catch: Throwable -> L19
        int r111 = r104.f476240b;     // Catch: Throwable -> L19
        r104.f476240b = r111 + 1;     // Catch: Throwable -> L19
        r110[r111] = r105;     // Catch: Throwable -> L19
        monitor-exit(r103);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    L22:
        this.f476201a = -1;
        goto L23
    }

    public final void finalize() {
        ThreadLocal r100 = f476200i;
        r100.set(a.class);
        e();
        r100.set(null);
    }

    public int a() {
        return this.f476204d;
    }

    public int c() {
        return this.f476203c;
    }

    public a(int r100) {
        this.f476203c = -1;
        this.f476204d = -1;
        this.f476207g = null;
        this.f476201a = 0;
        this.f476202b = 0;
        WeakHashMap<a, Object> r101 = f476199h;
        monitor-enter(r101);
        r101.put(this, null);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void f(int r100, int r101) {
        this.f476203c = r100;
        this.f476204d = r101;
        if (r100 <= 0) goto L5;
        int r102 = d.a(r100);
    L6:
        this.f476205e = r102;
        if (r101 <= 0) goto L9;
        int r103 = d.a(r101);
    L10:
        this.f476206f = r103;
        int r104 = this.f476205e;
        if (r104 > 4096) goto L13;
        if (r103 > 4096) goto L13;
        return;
    L13:
        String.format("secondBitmap is too large: %d x %d", new Object[]{Integer.valueOf(r104), Integer.valueOf(this.f476206f)});
        new Exception();
        return;
    L9:
        r103 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }
}
