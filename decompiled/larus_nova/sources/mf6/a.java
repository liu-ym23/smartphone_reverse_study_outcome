package mf6;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f513638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f513639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f513640c;

    public void c() {
    }

    public void e() {
        this.f513638a = true;
    }

    public boolean b() {
        return this.f513638a;
    }

    public a(long r100) {
        this.f513640c = r100;
    }

    public void a(float r100) {
        if (this.f513640c != 0) goto L5;
        return;
    L5:
        if (b() == true) goto L13;
        float r101 = this.f513639b + Math.min(r100, this.f513640c - this.f513639b);
        this.f513639b = r101;
        d(r101 / this.f513640c);
        if (this.f513639b < this.f513640c) goto L12;
        e();
        c();
        return;
    L12:
        return;
    }

    public void d(float r100) {
        b();
    }
}
