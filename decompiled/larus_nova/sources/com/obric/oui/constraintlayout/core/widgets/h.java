package com.obric.oui.constraintlayout.core.widgets;

/* JADX INFO: loaded from: classes34.dex */
public final class h extends i {
    public h() {
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public final void d(com.obric.oui.constraintlayout.core.c r100, boolean r101) {
        super.d(r100, r101);
        if (this.f550643y0 <= 0) goto L6;
        ConstraintWidget r102 = this.f550642x0[0];
        r102.G();
        r102.f399718i0 = 0.5f;
        r102.f399716h0 = 0.5f;
        ConstraintAnchor.Type r103 = ConstraintAnchor.Type.LEFT;
        r102.g(r103, this, r103, 0);
        ConstraintAnchor.Type r104 = ConstraintAnchor.Type.RIGHT;
        r102.g(r104, this, r104, 0);
        ConstraintAnchor.Type r105 = ConstraintAnchor.Type.TOP;
        r102.g(r105, this, r105, 0);
        ConstraintAnchor.Type r106 = ConstraintAnchor.Type.BOTTOM;
        r102.g(r106, this, r106, 0);
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.i
    public final void U(int r100, int r101, int r102, int r103) {
        int r104 = this.D0;
        int r105 = this.E0;
        int r106 = r104 + r105;
        boolean r107 = false;
        int r108 = r106 + 0;
        int r109 = (this.f399868z0 + this.A0) + 0;
        if (this.f550643y0 <= 0) goto L5;
        r108 = r108 + this.f550642x0[0].t();
        r109 = r109 + this.f550642x0[0].n();
    L5:
        int r110 = Math.max(this.f399712f0, r108);
        int r111 = Math.max(this.f399714g0, r109);
        if (r100 == 1073741824) goto L13;
        if (r100 != Integer.MIN_VALUE) goto L10;
        r101 = Math.min(r110, r101);
        goto L13
    L10:
        if (r100 != 0) goto L12;
        r101 = r110;
        goto L13
    L12:
        r101 = 0;
    L13:
        if (r102 == 1073741824) goto L20;
        if (r102 != Integer.MIN_VALUE) goto L17;
        r103 = Math.min(r111, r103);
        goto L20
    L17:
        if (r102 != 0) goto L19;
        r103 = r111;
        goto L20
    L19:
        r103 = 0;
    L20:
        this.G0 = r101;
        this.H0 = r103;
        Q(r101);
        N(r103);
        if (this.f550643y0 <= 0) goto L23;
        r107 = true;
    L23:
        this.F0 = r107;
    }
}
