package com.obric.oui.constraintlayout.core.widgets;

import com.obric.oui.constraintlayout.core.SolverVariable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes34.dex */
public final class a extends ula.b {
    public boolean A0;
    public int B0;
    public boolean C0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public int f399753z0;

    public final boolean U() {
        int r100 = 0;
        int r101 = 0;
        boolean r102 = true;
    L3:
        int r103 = this.f550643y0;
        if (r101 >= r103) goto L23;
        ConstraintWidget r104 = this.f550642x0[r101];
        if (this.A0 == false) goto L8;
    L10:
        int r105 = this.f399753z0;
        if (r105 == 0) goto L14;
        if (r105 == 1) goto L14;
    L16:
        int r106 = this.f399753z0;
        if (r106 == 2) goto L20;
        if (r106 == 3) goto L20;
    L22:
        r101 = r101 + 1;
    L20:
        if (r104.E() == true) goto L22;
    L15:
        r102 = false;
    L14:
        if (r104.D() == true) goto L16;
    L8:
        if (r104.e() == true) goto L10;
    L23:
        if (r102 == false) goto L62;
        if (r103 <= 0) goto L62;
        int r107 = 0;
        boolean r108 = false;
    L27:
        if (r100 >= this.f550643y0) goto L54;
        ConstraintWidget r109 = this.f550642x0[r100];
        if (this.A0 == false) goto L31;
    L33:
        if (r108 == true) goto L44;
        int r110 = this.f399753z0;
        if (r110 != 0) goto L37;
        r107 = r109.l(ConstraintAnchor.Type.LEFT).d();
    L43:
        r108 = true;
        goto L44
    L37:
        if (r110 != 1) goto L39;
        r107 = r109.l(ConstraintAnchor.Type.RIGHT).d();
        goto L43
    L39:
        if (r110 != 2) goto L41;
        r107 = r109.l(ConstraintAnchor.Type.TOP).d();
        goto L43
    L41:
        if (r110 != 3) goto L43;
        r107 = r109.l(ConstraintAnchor.Type.BOTTOM).d();
    L44:
        int r111 = this.f399753z0;
        if (r111 != 0) goto L47;
        r107 = Math.min(r107, r109.l(ConstraintAnchor.Type.LEFT).d());
    L53:
        r100 = r100 + 1;
        goto L27
    L47:
        if (r111 != 1) goto L49;
        r107 = Math.max(r107, r109.l(ConstraintAnchor.Type.RIGHT).d());
        goto L53
    L49:
        if (r111 != 2) goto L51;
        r107 = Math.min(r107, r109.l(ConstraintAnchor.Type.TOP).d());
        goto L53
    L51:
        if (r111 != 3) goto L53;
        r107 = Math.max(r107, r109.l(ConstraintAnchor.Type.BOTTOM).d());
        goto L53
    L31:
        if (r109.e() == true) goto L33;
    L54:
        int r112 = r107 + this.B0;
        int r113 = this.f399753z0;
        if (r113 == 0) goto L59;
        if (r113 == 1) goto L59;
        M(r112, r112);
    L60:
        this.C0 = true;
        return true;
    L59:
        L(r112, r112);
    L62:
        return false;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public final boolean e() {
        return true;
    }

    public final int V() {
        int r100 = this.f399753z0;
        if (r100 != 0) goto L5;
        return 0;
    L5:
        if (r100 != 1) goto L7;
        return 0;
    L7:
        if (r100 != 2) goto L9;
    L12:
        return 1;
    L9:
        if (r100 == 3) goto L12;
        return -1;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public final String toString() {
        String r100 = "[Barrier] " + this.f399726m0 + " {";
        int r101 = 0;
    L4:
        if (r101 >= this.f550643y0) goto L10;
        ConstraintWidget r102 = this.f550642x0[r101];
        if (r101 <= 0) goto L8;
        r100 = r100 + ", ";
    L8:
        r100 = r100 + r102.f399726m0;
        r101 = r101 + 1;
        goto L4
    L10:
        return r100 + com.alipay.sdk.m.u.i.f25855d;
    }

    public a() {
        this.f399753z0 = 0;
        this.A0 = true;
        this.B0 = 0;
        this.C0 = false;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public final boolean D() {
        return this.C0;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public final boolean E() {
        return this.C0;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public final void d(com.obric.oui.constraintlayout.core.c r110, boolean r111) {
        ConstraintAnchor[] r112 = this.T;
        r112[0] = this.L;
        r112[2] = this.M;
        r112[1] = this.N;
        r112[3] = this.O;
        int r113 = 0;
    L3:
        ConstraintAnchor[] r100 = this.T;
        if (r113 >= r100.length) goto L6;
        ConstraintAnchor r101 = r100[r113];
        r101.f399697i = r110.k(r101);
        r113 = r113 + 1;
        goto L3
    L6:
        int r114 = this.f399753z0;
        if (r114 >= 0) goto L9;
        return;
    L9:
        if (r114 >= 4) goto L128;
        ConstraintAnchor r115 = r100[r114];
        if (this.C0 == true) goto L14;
        U();
    L14:
        if (this.C0 == false) goto L24;
        this.C0 = false;
        int r116 = this.f399753z0;
        if (r116 == 0) goto L22;
        if (r116 == 1) goto L22;
        if (r116 == 2) goto L21;
        if (r116 == 3) goto L21;
        return;
    L21:
        r110.d(this.M.f399697i, this.f399708d0);
        r110.d(this.O.f399697i, this.f399708d0);
        return;
    L22:
        r110.d(this.L.f399697i, this.f399706c0);
        r110.d(this.N.f399697i, this.f399706c0);
        return;
    L24:
        int r102 = 0;
    L26:
        if (r102 >= this.f550643y0) goto L52;
        ConstraintWidget r103 = this.f550642x0[r102];
        if (this.A0 == false) goto L30;
    L32:
        int r104 = this.f399753z0;
        if (r104 == 0) goto L36;
        if (r104 == 1) goto L36;
    L42:
        if (r104 == 2) goto L45;
        if (r104 == 3) goto L45;
    L51:
        r102 = r102 + 1;
    L45:
        if (r103.W[1] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L51;
        if (r103.M.f399694f == null) goto L51;
        if (r103.O.f399694f == null) goto L51;
    L50:
        boolean r105 = true;
    L54:
        if (this.L.g() == false) goto L56;
    L59:
        boolean r106 = true;
    L61:
        if (this.M.g() == false) goto L63;
    L66:
        boolean r107 = true;
    L67:
        if (r105 == true) goto L78;
        int r108 = this.f399753z0;
        if (r108 != 0) goto L71;
        if (r106 == false) goto L71;
    L77:
        boolean r109 = true;
    L79:
        if (r109 == true) goto L81;
        int r117 = 4;
    L82:
        int r118 = 0;
    L84:
        if (r118 >= this.f550643y0) goto L103;
        ConstraintWidget r119 = this.f550642x0[r118];
        if (this.A0 == false) goto L88;
    L90:
        SolverVariable r120 = r110.k(r119.T[this.f399753z0]);
        ConstraintAnchor[] r121 = r119.T;
        int r122 = this.f399753z0;
        ConstraintAnchor r123 = r121[r122];
        r123.f399697i = r120;
        ConstraintAnchor r124 = r123.f399694f;
        if (r124 != null) goto L93;
    L95:
        int r125 = 0;
    L96:
        if (r122 == 0) goto L100;
        if (r122 == 2) goto L100;
        SolverVariable r126 = r115.f399697i;
        int r127 = this.B0 + r125;
        com.obric.oui.constraintlayout.core.b r128 = r110.l();
        SolverVariable r129 = r110.m();
        r129.f399609d = 0;
        r128.c(r126, r120, r129, r127);
        r110.c(r128);
    L101:
        r110.e(r115.f399697i, r120, this.B0 + r125, r117);
    L102:
        r118 = r118 + 1;
    L100:
        SolverVariable r130 = r115.f399697i;
        int r131 = this.B0 - r125;
        com.obric.oui.constraintlayout.core.b r132 = r110.l();
        SolverVariable r133 = r110.m();
        r133.f399609d = 0;
        r132.d(r130, r120, r133, r131);
        r110.c(r132);
        goto L101
    L93:
        if (r124.f399692d != this) goto L95;
        r125 = r123.f399695g + 0;
        goto L96
    L88:
        if (r119.e() == true) goto L90;
    L103:
        int r134 = this.f399753z0;
        if (r134 != 0) goto L106;
        r110.e(this.N.f399697i, this.L.f399697i, 0, 8);
        r110.e(this.L.f399697i, this.X.N.f399697i, 0, 4);
        r110.e(this.L.f399697i, this.X.L.f399697i, 0, 0);
        return;
    L106:
        if (r134 != 1) goto L108;
        r110.e(this.L.f399697i, this.N.f399697i, 0, 8);
        r110.e(this.L.f399697i, this.X.L.f399697i, 0, 4);
        r110.e(this.L.f399697i, this.X.N.f399697i, 0, 0);
        return;
    L108:
        if (r134 != 2) goto L110;
        r110.e(this.O.f399697i, this.M.f399697i, 0, 8);
        r110.e(this.M.f399697i, this.X.O.f399697i, 0, 4);
        r110.e(this.M.f399697i, this.X.M.f399697i, 0, 0);
        return;
    L110:
        if (r134 != 3) goto L132;
        r110.e(this.M.f399697i, this.O.f399697i, 0, 8);
        r110.e(this.M.f399697i, this.X.M.f399697i, 0, 4);
        r110.e(this.M.f399697i, this.X.O.f399697i, 0, 0);
        return;
    L132:
        return;
    L81:
        r117 = 5;
    L71:
        if (r108 != 2) goto L73;
        if (r107 == true) goto L77;
    L73:
        if (r108 != 1) goto L75;
        if (r106 == true) goto L77;
    L75:
        if (r108 != 3) goto L78;
        if (r107 == true) goto L77;
    L78:
        r109 = false;
        goto L79
    L63:
        if (this.O.g() == true) goto L66;
        r107 = false;
        goto L67
    L56:
        if (this.N.g() == true) goto L59;
        r106 = false;
    L36:
        if (r103.W[0] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L42;
        if (r103.L.f399694f == null) goto L42;
        if (r103.N.f399694f == null) goto L42;
    L30:
        if (r103.e() == true) goto L32;
    L52:
        r105 = false;
        goto L54
    }

    @Override // ula.b, com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public final void i(ConstraintWidget r100, HashMap<ConstraintWidget, ConstraintWidget> r101) {
        super.i(r100, r101);
        a r102 = (a) r100;
        this.f399753z0 = r102.f399753z0;
        this.A0 = r102.A0;
        this.B0 = r102.B0;
    }
}
