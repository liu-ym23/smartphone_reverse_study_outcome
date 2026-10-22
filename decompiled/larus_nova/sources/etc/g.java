package etc;

import lsc.h;
import msc.s;

/* JADX INFO: loaded from: classes5.dex */
public final class g extends lsc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gtc.g f473966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f473967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f473968c;

    @Override // lsc.a, lsc.j
    public final void e(s.a r100) {
        this.f473967b.c();
        r100.f515579m = -587202560;
        r100.f515581o = this.f473967b.a();
    }

    @Override // lsc.a, lsc.j
    public final void g(h.a r100) {
        r100.f510598c = new b(this.f473966a, this.f473967b, this.f473968c);
    }

    public g(gtc.g r100, io.noties.markwon.syntax.a r101) {
        this.f473966a = r100;
        this.f473967b = r101;
        this.f473968c = "c";
    }
}
