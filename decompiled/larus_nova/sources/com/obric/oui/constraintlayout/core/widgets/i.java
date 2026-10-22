package com.obric.oui.constraintlayout.core.widgets;

import com.obric.oui.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: loaded from: classes34.dex */
public class i extends ula.b {
    public int A0;
    public int B0;
    public int C0;
    public int D0;
    public int E0;
    public boolean F0;
    public int G0;
    public int H0;
    public final com.obric.oui.constraintlayout.core.widgets.analyzer.b.a I0;
    public com.obric.oui.constraintlayout.core.widgets.analyzer.b.InterfaceC4669b J0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public int f399868z0;

    public void U(int r100, int r101, int r102, int r103) {
    }

    @Override // ula.b, ula.a
    public final void a() {
        int r100 = 0;
    L4:
        if (r100 >= this.f550643y0) goto L9;
        ConstraintWidget r101 = this.f550642x0[r100];
        if (r101 == null) goto L8;
        r101.I = true;
    L8:
        r100 = r100 + 1;
        goto L4
    }

    public i() {
        this.f399868z0 = 0;
        this.A0 = 0;
        this.B0 = 0;
        this.C0 = 0;
        this.D0 = 0;
        this.E0 = 0;
        this.F0 = false;
        this.G0 = 0;
        this.H0 = 0;
        this.I0 = new com.obric.oui.constraintlayout.core.widgets.analyzer.b.a();
        this.J0 = null;
    }

    public final void V(ConstraintWidget r100, ConstraintWidget.DimensionBehaviour r101, int r102, ConstraintWidget.DimensionBehaviour r103, int r104) {
    L2:
        com.obric.oui.constraintlayout.core.widgets.analyzer.b.InterfaceC4669b r105 = this.J0;
        if (r105 != null) goto L7;
        ConstraintWidget r106 = this.X;
        if (r106 == null) goto L7;
        this.J0 = ((d) r106).B0;
    L7:
        com.obric.oui.constraintlayout.core.widgets.analyzer.b.a r107 = this.I0;
        r107.f399782a = r101;
        r107.f399783b = r103;
        r107.f399784c = r102;
        r107.f399785d = r104;
        ((ConstraintLayout.b) r105).b(r100, r107);
        r100.Q(this.I0.f399786e);
        r100.N(this.I0.f399787f);
        com.obric.oui.constraintlayout.core.widgets.analyzer.b.a r108 = this.I0;
        r100.G = r108.f399789h;
        int r109 = r108.f399788g;
        r100.f399710e0 = r109;
        if (r109 <= 0) goto L10;
        boolean r110 = true;
    L11:
        r100.G = r110;
        return;
    L10:
        r110 = false;
        goto L11
    }
}
