package pr2;

import fr2.j1;
import fr2.p;
import uf2.d0;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ wv0.a f530356a;

    @Override // pr2.a
    public final void release() {
        this.f530356a.release();
    }

    public c(wv0.a r100) {
        this.f530356a = r100;
    }

    @Override // pr2.a
    public final void a(p r100) {
        wv0.a r101 = this.f530356a;
        d0 r102 = null;
        if ((r100 instanceof j1) == true) goto L5;
        r100 = null;
    L5:
        j1 r103 = (j1) r100;
        if (r103 == null) goto L8;
        r102 = r103.f478509a;
    L8:
        r101.a(r102);
    }
}
