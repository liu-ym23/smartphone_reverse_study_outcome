package com.obric.oui.orecyclerview.widget;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;

/* JADX INFO: loaded from: classes34.dex */
public final class e0 implements a.InterfaceC4675a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f401809a;

    public e0(RecyclerView r100) {
        this.f401809a = r100;
    }

    public final void a(a.b r100) {
        int r101 = r100.f401778a;
        if (r101 != 1) goto L5;
        this.f401809a.f401621m.S();
        return;
    L5:
        if (r101 != 2) goto L7;
        this.f401809a.f401621m.V();
        return;
    L7:
        if (r101 != 4) goto L9;
        this.f401809a.f401621m.W();
        return;
    L9:
        if (r101 != 8) goto L19;
        this.f401809a.f401621m.U();
        return;
    }

    public final RecyclerView.y b(int r100) {
        RecyclerView r101 = this.f401809a;
        int r102 = r101.f401608e.h();
        int r103 = 0;
        RecyclerView.y r104 = null;
    L3:
        if (r103 >= r102) goto L16;
        RecyclerView.y r105 = RecyclerView.E(r101.f401608e.g(r103));
        if (r105 == null) goto L15;
        if (r105.i() == true) goto L15;
        if (r105.f401730c != r100) goto L15;
        if (r101.f401608e.k(r105.f401728a) == false) goto L14;
        r104 = r105;
        goto L15
    L14:
        r104 = r105;
    L15:
        r103 = r103 + 1;
    L16:
        if (r104 != null) goto L19;
        return null;
    L19:
        if (this.f401809a.f401608e.k(r104.f401728a) == false) goto L22;
        boolean r106 = RecyclerView.f401596h2;
        return null;
    L22:
        return r104;
    }

    public final void d(int r100, int r110) {
        RecyclerView r101 = this.f401809a;
        int r102 = r101.f401608e.h();
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L16;
        RecyclerView.y r104 = RecyclerView.E(r101.f401608e.g(r103));
        if (r104 == null) goto L15;
        if (r104.o() == true) goto L15;
        if (r104.f401730c < r100) goto L15;
        if (RecyclerView.f401597p2 == false) goto L14;
        r104.toString();
    L14:
        r104.l(r110, false);
        r101.L0.f401711f = true;
    L15:
        r103 = r103 + 1;
        goto L4
    L16:
        RecyclerView.q r105 = r101.f401603b;
        int r106 = r105.f401685c.size();
        int r107 = 0;
    L17:
        if (r107 >= r106) goto L27;
        RecyclerView.y r108 = (RecyclerView.y) ListProtector.get(r105.f401685c, r107);
        if (r108 == null) goto L26;
        if (r108.f401730c < r100) goto L26;
        if (RecyclerView.f401597p2 == false) goto L25;
        r108.toString();
    L25:
        r108.l(r110, false);
    L26:
        r107 = r107 + 1;
        goto L17
    L27:
        r101.requestLayout();
        this.f401809a.f401604b1 = true;
    }

    public final void e(int r110, int r111) {
        RecyclerView r100 = this.f401809a;
        int r101 = r100.f401608e.h();
        int r102 = -1;
        if (r110 >= r111) goto L5;
        int r103 = r110;
        int r104 = r111;
        int r105 = -1;
    L6:
        int r106 = 0;
    L7:
        if (r106 >= r101) goto L23;
        RecyclerView.y r107 = RecyclerView.E(r100.f401608e.g(r106));
        if (r107 == null) goto L22;
        int r112 = r107.f401730c;
        if (r112 < r103) goto L22;
        if (r112 > r104) goto L22;
        if (RecyclerView.f401597p2 == false) goto L18;
        r107.toString();
    L18:
        if (r107.f401730c != r110) goto L20;
        r107.l(r111 - r110, false);
    L21:
        r100.L0.f401711f = true;
        goto L22
    L20:
        r107.l(r105, false);
    L22:
        r106 = r106 + 1;
        goto L7
    L23:
        RecyclerView.q r108 = r100.f401603b;
        r108.getClass();
        if (r110 >= r111) goto L26;
        int r109 = r110;
        int r113 = r111;
    L27:
        int r114 = r108.f401685c.size();
        int r115 = 0;
    L28:
        if (r115 >= r114) goto L42;
        RecyclerView.y r116 = (RecyclerView.y) ListProtector.get(r108.f401685c, r115);
        if (r116 == null) goto L41;
        int r117 = r116.f401730c;
        if (r117 < r109) goto L41;
        if (r117 > r113) goto L41;
        if (r117 != r110) goto L37;
        r116.l(r111 - r110, false);
    L39:
        if (RecyclerView.f401597p2 == false) goto L41;
        r116.toString();
        goto L41
    L37:
        r116.l(r102, false);
    L41:
        r115 = r115 + 1;
        goto L28
    L42:
        r100.requestLayout();
        this.f401809a.f401604b1 = true;
        return;
    L26:
        r113 = r110;
        r109 = r111;
        r102 = 1;
        goto L27
    L5:
        r104 = r110;
        r103 = r111;
        r105 = 1;
        goto L6
    }

    public final void c(int r100, int r110, Object r111) {
        RecyclerView r101 = this.f401809a;
        int r102 = r101.f401608e.h();
        int r112 = r110 + r100;
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L15;
        View r104 = r101.f401608e.g(r103);
        RecyclerView.y r105 = RecyclerView.E(r104);
        if (r105 == null) goto L14;
        if (r105.o() == true) goto L14;
        int r106 = r105.f401730c;
        if (r106 < r100) goto L14;
        if (r106 >= r112) goto L14;
        r105.b(2);
        r105.a(r111);
        ((RecyclerView.LayoutParams) r104.getLayoutParams()).f401653c = true;
    L14:
        r103 = r103 + 1;
        goto L4
    L15:
        RecyclerView.q r113 = r101.f401603b;
        int r107 = r113.f401685c.size();
    L16:
        r107 = r107 - 1;
        if (r107 < 0) goto L25;
        RecyclerView.y r108 = (RecyclerView.y) ListProtector.get(r113.f401685c, r107);
        if (r108 == null) goto L16;
        int r109 = r108.f401730c;
        if (r109 < r100) goto L16;
        if (r109 >= r112) goto L16;
        r108.b(2);
        r113.g(r107);
        goto L16
    L25:
        this.f401809a.f401611g1 = true;
    }
}
