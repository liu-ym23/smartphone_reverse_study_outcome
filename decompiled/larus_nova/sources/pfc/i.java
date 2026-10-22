package pfc;

import android.graphics.RectF;

/* JADX INFO: loaded from: classes38.dex */
public final class i extends b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f529081a;

    @Override // pfc.b.c
    public final void a() {
        this.f529081a.f529071g = false;
    }

    @Override // pfc.b.c
    public final void b() {
        g r100 = this.f529081a;
        r100.f529071g = false;
        g.d r101 = r100.f529074j;
        new RectF(this.f529081a.f529065a);
        r101.b();
    }

    @Override // pfc.b.c
    public final void c() {
        this.f529081a.f529071g = true;
    }

    public i(g r100) {
        this.f529081a = r100;
    }

    @Override // pfc.b.c
    public final void d(RectF r100) {
        this.f529081a.f529065a.set(r100);
        g r101 = this.f529081a;
        r101.f529074j.a(r101.f529065a);
    }
}
