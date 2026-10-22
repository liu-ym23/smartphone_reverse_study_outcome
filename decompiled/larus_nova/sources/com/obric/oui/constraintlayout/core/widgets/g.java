package com.obric.oui.constraintlayout.core.widgets;

/* JADX INFO: loaded from: classes34.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean[] f399867a = null;

    static {
        f399867a = new boolean[3];
    }

    public static final boolean b(int r100, int r101) {
        if ((r100 & r101) != r101) goto L5;
        return true;
    L5:
        return false;
    }

    public static void a(d r100, com.obric.oui.constraintlayout.core.c r101, ConstraintWidget r102) {
        r102.f399733q = -1;
        r102.f399735r = -1;
        ConstraintWidget.DimensionBehaviour r103 = r100.W[0];
        ConstraintWidget.DimensionBehaviour r104 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r103 == r104) goto L10;
        if (r102.W[0] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L10;
        int r105 = r102.L.f399695g;
        int r106 = r100.t() - r102.N.f399695g;
        ConstraintAnchor r107 = r102.L;
        r107.f399697i = r101.k(r107);
        ConstraintAnchor r108 = r102.N;
        r108.f399697i = r101.k(r108);
        r101.d(r102.L.f399697i, r105);
        r101.d(r102.N.f399697i, r106);
        r102.f399733q = 2;
        r102.f399706c0 = r105;
        int r109 = r106 - r105;
        r102.Y = r109;
        int r110 = r102.f399712f0;
        if (r109 >= r110) goto L10;
        r102.Y = r110;
    L10:
        if (r100.W[1] != r104) goto L12;
        return;
    L12:
        if (r102.W[1] != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L23;
        int r111 = r102.M.f399695g;
        int r112 = r100.n() - r102.O.f399695g;
        ConstraintAnchor r113 = r102.M;
        r113.f399697i = r101.k(r113);
        ConstraintAnchor r114 = r102.O;
        r114.f399697i = r101.k(r114);
        r101.d(r102.M.f399697i, r111);
        r101.d(r102.O.f399697i, r112);
        if (r102.f399710e0 <= 0) goto L16;
    L17:
        ConstraintAnchor r115 = r102.P;
        r115.f399697i = r101.k(r115);
        r101.d(r102.P.f399697i, r102.f399710e0 + r111);
    L18:
        r102.f399735r = 2;
        r102.f399708d0 = r111;
        int r116 = r112 - r111;
        r102.Z = r116;
        int r117 = r102.f399714g0;
        if (r116 >= r117) goto L24;
        r102.Z = r117;
        return;
    L24:
        return;
    L16:
        if (r102.f399722k0 != 8) goto L18;
    }
}
