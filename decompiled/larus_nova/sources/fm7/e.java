package fm7;

import android.app.Application;
import rk7.m;
import zm7.h;
import zm7.j;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements h, gk7.f {
    @Override // gk7.f
    public final void onAccountBindUpdate() {
    }

    @Override // zm7.h
    public final boolean b() {
        Application r100 = m.f538347a;
        return m.o();
    }

    public e() {
        rk7.h.a(this);
    }

    @Override // gk7.f
    public final void onAccountRefresh(boolean r100) {
        if (r100 == false) goto L7;
        j r101 = (j) wm7.g.a(j.class);
        if (r101 == null) goto L11;
        r101.c("login");
        return;
    L11:
        return;
    L7:
        j r102 = (j) wm7.g.a(j.class);
        if (r102 == null) goto L13;
        r102.e("login");
        return;
    }
}
