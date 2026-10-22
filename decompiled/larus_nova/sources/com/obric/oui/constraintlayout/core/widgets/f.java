package com.obric.oui.constraintlayout.core.widgets;

import com.obric.oui.constraintlayout.core.SolverVariable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes34.dex */
public final class f extends ConstraintWidget {
    public ConstraintAnchor A0;
    public int B0;
    public boolean C0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public float f399863x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public int f399864y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public int f399865z0;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f399866a = null;

        static {
            int[] r100 = new int[ConstraintAnchor.Type.values().length];
            f399866a = r100;
            r100[ConstraintAnchor.Type.LEFT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            f399866a[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            f399866a[ConstraintAnchor.Type.TOP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            f399866a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            f399866a[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            f399866a[ConstraintAnchor.Type.CENTER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            f399866a[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            f399866a[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            f399866a[ConstraintAnchor.Type.NONE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public final boolean e() {
        return true;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public String getType() {
        return "Guideline";
    }

    public f() {
        this.f399863x0 = -1.0f;
        this.f399864y0 = -1;
        this.f399865z0 = -1;
        this.A0 = this.M;
        int r100 = 0;
        this.B0 = 0;
        this.U.clear();
        this.U.add(this.A0);
        int r101 = this.T.length;
    L3:
        if (r100 >= r101) goto L5;
        this.T[r100] = this.A0;
        r100 = r100 + 1;
        goto L3
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public final boolean D() {
        return this.C0;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public final boolean E() {
        return this.C0;
    }

    public final void T(int r100) {
        this.A0.l(r100);
        this.C0 = true;
    }

    public final void U(int r100) {
        if (this.B0 != r100) goto L5;
        return;
    L5:
        this.B0 = r100;
        this.U.clear();
        if (this.B0 != 1) goto L8;
        this.A0 = this.L;
    L9:
        this.U.add(this.A0);
        int r101 = this.T.length;
        int r102 = 0;
    L10:
        if (r102 >= r101) goto L12;
        this.T[r102] = this.A0;
        r102 = r102 + 1;
        goto L10
    L12:
        return;
    L8:
        this.A0 = this.M;
        goto L9
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public final ConstraintAnchor l(ConstraintAnchor.Type r100) {
        int r101 = a.f399866a[r100.ordinal()];
        if (r101 == 1) goto L16;
        if (r101 == 2) goto L16;
        if (r101 == 3) goto L12;
        if (r101 == 4) goto L12;
        return null;
    L12:
        if (this.B0 == 0) goto L14;
        return null;
    L14:
        return this.A0;
    L16:
        if (this.B0 == 1) goto L18;
        return null;
    L18:
        return this.A0;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public final void S(com.obric.oui.constraintlayout.core.c r100, boolean r101) {
        if (this.X != null) goto L5;
        return;
    L5:
        ConstraintAnchor r102 = this.A0;
        r100.getClass();
        int r103 = com.obric.oui.constraintlayout.core.c.n(r102);
        if (this.B0 != 1) goto L8;
        this.f399706c0 = r103;
        this.f399708d0 = 0;
        N(this.X.n());
        Q(0);
        return;
    L8:
        this.f399706c0 = 0;
        this.f399708d0 = r103;
        Q(this.X.t());
        N(0);
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public final void d(com.obric.oui.constraintlayout.core.c r100, boolean r101) {
        d r102 = (d) this.X;
        if (r102 != null) goto L5;
        return;
    L5:
        Object r103 = r102.l(ConstraintAnchor.Type.LEFT);
        Object r104 = r102.l(ConstraintAnchor.Type.RIGHT);
        ConstraintWidget r105 = this.X;
        boolean r106 = true;
        if (r105 != null) goto L8;
    L10:
        boolean r107 = false;
    L12:
        if (this.B0 != 0) goto L21;
        r103 = r102.l(ConstraintAnchor.Type.TOP);
        r104 = r102.l(ConstraintAnchor.Type.BOTTOM);
        ConstraintWidget r108 = this.X;
        if (r108 != null) goto L16;
    L18:
        r106 = false;
    L19:
        r107 = r106;
        goto L21
    L16:
        if (r108.W[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L18;
    L21:
        if (this.C0 == false) goto L35;
        ConstraintAnchor r109 = this.A0;
        if (r109.f399691c == false) goto L35;
        SolverVariable r110 = r100.k(r109);
        r100.d(r110, this.A0.d());
        if (this.f399864y0 == (-1)) goto L29;
        if (r107 == false) goto L32;
        r100.f(r100.k(r104), r110, 0, 5);
    L32:
        this.C0 = false;
        return;
    L29:
        if (this.f399865z0 == (-1)) goto L32;
        if (r107 == false) goto L32;
        SolverVariable r111 = r100.k(r104);
        r100.f(r110, r100.k(r103), 0, 5);
        r100.f(r111, r110, 0, 5);
    L35:
        if (this.f399864y0 == (-1)) goto L40;
        SolverVariable r112 = r100.k(this.A0);
        r100.e(r112, r100.k(r103), this.f399864y0, 8);
        if (r107 == false) goto L48;
        r100.f(r100.k(r104), r112, 0, 5);
        return;
    L48:
        return;
    L40:
        if (this.f399865z0 == (-1)) goto L45;
        SolverVariable r113 = r100.k(this.A0);
        SolverVariable r114 = r100.k(r104);
        r100.e(r113, r114, -this.f399865z0, 8);
        if (r107 == false) goto L50;
        r100.f(r113, r100.k(r103), 0, 5);
        r100.f(r114, r113, 0, 5);
        return;
    L50:
        return;
    L45:
        if (this.f399863x0 == (-1.0f)) goto L52;
        SolverVariable r115 = r100.k(this.A0);
        SolverVariable r116 = r100.k(r104);
        float r117 = this.f399863x0;
        com.obric.oui.constraintlayout.core.b r118 = r100.l();
        r118.f399632d.e(r115, -1.0f);
        r118.f399632d.e(r116, r117);
        r100.c(r118);
        return;
    L52:
        return;
    L8:
        if (r105.W[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L10;
        r107 = true;
        goto L12
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public final void i(ConstraintWidget r100, HashMap<ConstraintWidget, ConstraintWidget> r101) {
        super.i(r100, r101);
        f r102 = (f) r100;
        this.f399863x0 = r102.f399863x0;
        this.f399864y0 = r102.f399864y0;
        this.f399865z0 = r102.f399865z0;
        U(r102.B0);
    }
}
