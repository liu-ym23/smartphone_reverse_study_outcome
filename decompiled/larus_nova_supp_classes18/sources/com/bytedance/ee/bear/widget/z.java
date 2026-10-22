package com.bytedance.ee.bear.widget;

import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class z extends kn4.a {
    public void update() {
    }

    public final boolean isShowing() {
        if (((kn4.a) this).c.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final void j() {
        tt5.a.b("AtWindowImp", "close: ");
        kn4.g.b r0 = ((kn4.a) this).a;
        if (r0 == null) goto L5;
        r0.b(false);
    L5:
        ((kn4.a) this).b.a();
        ((kn4.a) this).c.setVisibility(4);
    }

    public final void show() {
        tt5.a.b("AtWindowImp", "show: ");
        kn4.g.b r0 = ((kn4.a) this).a;
        if (r0 == null) goto L5;
        r0.b(true);
    L5:
        ((kn4.a) this).b.c(true);
        ((kn4.a) this).c.setVisibility(0);
    }

    public final void close() {
        j();
    }

    public final void f(kn4.g.a r4) {
        tt5.a.b("AtWindowImp", "setSelectedCallback: ");
        com.bytedance.ee.bear.atfinder.c r0 = ((kn4.a) this).b;
        r0.d = new q(r0, r4, new y(this));
    }

    public final void x0(String r3) {
        tt5.a.b("AtWindowImp", "search: ");
        ((kn4.a) this).b.b(r3);
    }

    public z(FragmentActivity r10, kn4.h r11) {
        ((kn4.a) this).c = r11.l;
        k(r11);
        ((kn4.a) this).b = ((kn4.a) this).c.d(r10, r11.a(), new bo4.d(r11.b, r11.a, r11.c, r11.d, ""));
        j();
    }
}
