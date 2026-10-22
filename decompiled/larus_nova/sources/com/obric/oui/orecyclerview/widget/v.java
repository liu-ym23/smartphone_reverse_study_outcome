package com.obric.oui.orecyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes34.dex */
public class v extends h0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b0 f401964d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a0 f401965e;

    public v() {
    }

    @Override // com.obric.oui.orecyclerview.widget.h0
    public final View c(RecyclerView.k r100) {
        if (r100.d() == false) goto L7;
        return f(r100, h(r100));
    L7:
        if (r100.c() == true) goto L9;
        return null;
    L9:
        return f(r100, g(r100));
    }

    public final c0 g(RecyclerView.k r100) {
        a0 r101 = this.f401965e;
        if (r101 != null) goto L5;
    L6:
        this.f401965e = new a0(r100);
    L8:
        return this.f401965e;
    L5:
        if (r101.f401788a == r100) goto L8;
        goto L6
    }

    public final c0 h(RecyclerView.k r100) {
        b0 r101 = this.f401964d;
        if (r101 != null) goto L5;
    L6:
        this.f401964d = new b0(r100);
    L8:
        return this.f401964d;
    L5:
        if (r101.f401788a == r100) goto L8;
        goto L6
    }

    public static View f(RecyclerView.k r100, c0 r101) {
        int r102 = r100.u();
        View r103 = null;
        if (r102 != 0) goto L5;
        return null;
    L5:
        int r104 = r101.j() + (r101.k() / 2);
        int r105 = Integer.MAX_VALUE;
        int r106 = 0;
    L6:
        if (r106 >= r102) goto L11;
        View r107 = r100.t(r106);
        int r108 = Math.abs((r101.d(r107) + (r101.b(r107) / 2)) - r104);
        if (r108 >= r105) goto L10;
        r103 = r107;
        r105 = r108;
    L10:
        r106 = r106 + 1;
        goto L6
    L11:
        return r103;
    }

    @Override // com.obric.oui.orecyclerview.widget.h0
    public int[] b(RecyclerView.k r100, View r101) {
        int[] r102 = new int[2];
        if (r100.c() == false) goto L5;
        c0 r103 = g(r100);
        r102[0] = (r103.d(r101) + (r103.b(r101) / 2)) - (r103.j() + (r103.k() / 2));
    L7:
        if (r100.d() == false) goto L9;
        c0 r104 = h(r100);
        r102[1] = (r104.d(r101) + (r104.b(r101) / 2)) - (r104.j() + (r104.k() / 2));
    L10:
        return r102;
    L9:
        r102[1] = 0;
        goto L10
    L5:
        r102[0] = 0;
        goto L7
    }

    public final int e(RecyclerView.k r110, c0 r111, int r112, int r113) {
        this.f401826b.fling(0, 0, r112, r113, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        int[] r100 = {this.f401826b.getFinalX(), this.f401826b.getFinalY()};
        int r114 = r110.u();
        float r101 = 1.0f;
        if (r114 == 0) goto L23;
        View r102 = null;
        View r103 = null;
        int r104 = Integer.MAX_VALUE;
        int r105 = Integer.MIN_VALUE;
        int r106 = 0;
    L6:
        if (r106 >= r114) goto L15;
        View r107 = r110.t(r106);
        int r108 = RecyclerView.k.F(r107);
        if (r108 == (-1)) goto L14;
        if (r108 >= r104) goto L12;
        r102 = r107;
        r104 = r108;
    L12:
        if (r108 <= r105) goto L14;
        r103 = r107;
        r105 = r108;
    L14:
        r106 = r106 + 1;
        goto L6
    L15:
        if (r102 == null) goto L23;
        if (r103 == null) goto L23;
        int r115 = Math.max(r111.a(r102), r111.a(r103)) - Math.min(r111.d(r102), r111.d(r103));
        if (r115 == 0) goto L23;
        r101 = (r115 * 1.0f) / ((r105 - r104) + 1);
    L23:
        if (r101 > 0.0f) goto L26;
        return 0;
    L26:
        if (Math.abs(r100[0]) <= Math.abs(r100[1])) goto L28;
        int r116 = r100[0];
    L30:
        return Math.round(r116 / r101);
    L28:
        r116 = r100[1];
        goto L30
    }
}
