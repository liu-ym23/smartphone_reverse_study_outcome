package pfc;

import android.graphics.PointF;
import android.graphics.RectF;

/* JADX INFO: loaded from: classes38.dex */
public final class h extends w.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f529080a;

    @Override // pfc.w.a
    public final void a() {
        g r100 = this.f529080a;
        if (r100.f529070f.a(r100.f529065a, r100.f529066b) == true) goto L5;
        g.d r101 = this.f529080a.f529074j;
        new RectF(this.f529080a.f529065a);
        r101.b();
    L5:
        this.f529080a.f529069e = null;
    }

    @Override // pfc.w.a
    public final void c() {
        g r100 = this.f529080a;
        r100.f529074j.c(r100.f529065a);
    }

    public h(g r100) {
        this.f529080a = r100;
    }

    @Override // pfc.w.a
    public final void b(PointF r100, float r101, float r102, float r103) {
        g r104 = this.f529080a;
        float r105 = r104.f529072h;
        float r106 = r104.f529073i;
        float r107 = r104.f529065a.width();
        float r108 = r107 * r101;
        Math.abs(r108 - r107);
        if (r108 <= r105) goto L6;
        r101 = r105 / r107;
    L8:
        if (r100 == null) goto L10;
        com.ss.android.photoeditor.util.b.f(this.f529080a.f529065a, r100.x, r100.y, r101, r101);
    L10:
        this.f529080a.f529065a.offset(r102, r103);
        g r109 = this.f529080a;
        r109.f529074j.a(r109.f529065a);
        return;
    L6:
        if (r108 >= r106) goto L8;
        r101 = r106 / r107;
        goto L8
    }
}
