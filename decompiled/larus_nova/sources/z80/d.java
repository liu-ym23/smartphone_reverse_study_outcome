package z80;

import com.bytedance.android.livehostapi.business.IHostRealNameAuthorization;
import gu2.g;
import jc1.k;
import v80.h;

/* JADX INFO: loaded from: classes45.dex */
public final class d implements x80.a {
    public d() {
    }

    @Override // x80.a
    public final void a(h r100) {
        if ((r100 instanceof v80.d) == true) goto L5;
        r100 = null;
    L5:
        v80.d r101 = (v80.d) r100;
        if (r101 != null) goto L8;
        return;
    L8:
        g r102 = g.f482754a;
        if (((IHostRealNameAuthorization) k.f(IHostRealNameAuthorization.class)) == null) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
        g.a(r101);
        return;
    L14:
        y30.b r104 = y30.a.b();
        if (r104 == null) goto L19;
        r104.b(r101);
        return;
    L19:
        return;
    L11:
        r103 = false;
        goto L12
    }
}
