package n4a;

/* JADX INFO: loaded from: classes32.dex */
public abstract class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h1 f517339a;

    public h1() {
    }

    public h1(h1 r100) {
        this.f517339a = r100;
    }

    public void a() {
        h1 r100 = this.f517339a;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    public void b(int r100) {
        h1 r101 = this.f517339a;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    public abstract boolean c();

    public int d() {
        h1 r100 = this.f517339a;
        if (r100 == null) goto L5;
        int r101 = r100.d();
    L7:
        return Math.min(Integer.MAX_VALUE, r101);
    L5:
        r101 = Integer.MAX_VALUE;
        goto L7
    }

    public final boolean e() {
        h1 r100 = this.f517339a;
        if (r100 == null) goto L5;
        boolean r101 = r100.e();
    L6:
        if (r101 == true) goto L10;
        return false;
    L10:
        return c();
    L5:
        r101 = true;
        goto L6
    }
}
