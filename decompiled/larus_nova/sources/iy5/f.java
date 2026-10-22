package iy5;

/* JADX INFO: loaded from: classes19.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f496538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f496539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f496540c;

    public final boolean d() {
        if (this.f496538a == true) goto L5;
    L7:
        return false;
    L5:
        if (this.f496539b == null) goto L7;
        return true;
    }

    public f() {
        this.f496539b = null;
        this.f496540c = 2;
    }

    public final void c(String r100) {
        if (d() == true) goto L5;
        return;
    L5:
        if (this.f496540c > 1) goto L9;
        this.f496539b.i(r100);
        return;
    }

    public final void a(String r100, String r101) {
        if (d() == true) goto L5;
        return;
    L5:
        if (this.f496540c > 2) goto L9;
        this.f496539b.d(r100, r101);
        return;
    }

    public final void b(String r100, String r101) {
        if (d() == true) goto L5;
        return;
    L5:
        if (this.f496540c > 4) goto L9;
        this.f496539b.e(r100, r101);
        return;
    }

    public final void e(String r100, String r101) {
        if (d() == true) goto L5;
        return;
    L5:
        if (this.f496540c > 3) goto L9;
        this.f496539b.w(r100, r101);
        return;
    }
}
