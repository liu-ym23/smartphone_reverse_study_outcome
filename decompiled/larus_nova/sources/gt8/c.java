package gt8;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes26.dex */
public final class c implements b0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f482595a;

    @Override // gt8.b0.b
    public final void b() {
    }

    @Override // gt8.b0.b
    public final void c() {
    }

    @Override // gt8.b0.b
    public final void d() {
    }

    @Override // gt8.b0.b
    public final void f() {
    }

    @Override // gt8.b0.b
    public final void g() {
    }

    @Override // gt8.b0.b
    public final void onTransformStart() {
    }

    @Override // gt8.b0.b
    public final void a() {
        d r100 = this.f482595a;
        if (r100.f482604i.a(r100.f482597b.a(), this.f482595a.f482598c) == true) goto L6;
        this.f482595a.f482599d.b();
        return;
    }

    public c(d r100) {
        this.f482595a = r100;
    }

    @Override // gt8.b0.b
    public final void e(PointF r100, float r101, float r102, float r103) {
        if (r100 == null) goto L10;
        int r104 = ht8.d.f487149a;
        d r105 = this.f482595a;
        float r106 = r105.f482608m;
        float r107 = r105.f482607l;
        float r108 = r105.f482597b.e();
        float r109 = r108 * r101;
        Math.abs(r109 - r108);
        if (r109 <= r106) goto L7;
        r101 = r106 / r108;
    L9:
        this.f482595a.f482597b.c(r101, r101, r100.x, r100.y);
        goto L10
    L7:
        if (r109 >= r107) goto L9;
        r101 = r107 / r108;
    L10:
        this.f482595a.f482597b.f482678c.offset(r102, r103);
        d r110 = this.f482595a;
        r110.f482599d.d(r110.f482597b);
    }
}
