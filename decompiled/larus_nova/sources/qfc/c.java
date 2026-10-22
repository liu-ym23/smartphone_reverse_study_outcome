package qfc;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes38.dex */
public final class c extends pfc.w.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f532780a;

    @Override // pfc.w.a
    public final void a() {
        a r100 = this.f532780a;
        if (r100.f532767i.a(r100.f532762d.a(), this.f532780a.f532761c) == true) goto L6;
        ((x.a) this.f532780a.f532763e).f532846a.f532845b.f449172a = false;
        return;
    }

    public c(a r100) {
        this.f532780a = r100;
    }

    @Override // pfc.w.a
    public final void b(PointF r100, float r101, float r102, float r103) {
        if (r100 == null) goto L10;
        a r104 = this.f532780a;
        float r105 = r104.f532771m;
        float r106 = r104.f532770l;
        float r107 = r104.f532762d.e();
        float r108 = r107 * r101;
        Math.abs(r108 - r107);
        if (r108 <= r105) goto L7;
        r101 = r105 / r107;
    L9:
        this.f532780a.f532762d.c(r101, r101, r100.x, r100.y);
        goto L10
    L7:
        if (r108 >= r106) goto L9;
        r101 = r106 / r107;
    L10:
        this.f532780a.f532762d.f532856c.offset(r102, r103);
        a r109 = this.f532780a;
        a.e r110 = r109.f532763e;
        x.a r111 = (x.a) r110;
        r111.a(r109.f532762d);
    }
}
