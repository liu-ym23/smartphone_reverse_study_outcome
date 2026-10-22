package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class j extends WidgetRun {
    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void e() {
        this.f399769c = null;
        this.f399774h.b();
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public final boolean j() {
        return false;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void c() {
        ConstraintWidget r100 = this.f399768b;
        if ((r100 instanceof com.obric.oui.constraintlayout.core.widgets.a) == false) goto L69;
        DependencyNode r101 = this.f399774h;
        r101.f399755b = true;
        com.obric.oui.constraintlayout.core.widgets.a r102 = (com.obric.oui.constraintlayout.core.widgets.a) r100;
        int r103 = r102.f399753z0;
        boolean r104 = r102.A0;
        int r105 = 0;
        if (r103 == 0) goto L45;
        if (r103 != 1) goto L8;
        r101.f399758e = DependencyNode.Type.RIGHT;
    L36:
        if (r105 >= r102.f550643y0) goto L44;
        ConstraintWidget r106 = r102.f550642x0[r105];
        if (r104 == false) goto L40;
    L42:
        DependencyNode r107 = r106.f399707d.f399775i;
        List<d> r108 = r107.f399764k;
        ArrayList r109 = (ArrayList) r108;
        r109.add(this.f399774h);
        ((ArrayList) this.f399774h.f399765l).add(r107);
    L43:
        r105 = r105 + 1;
        goto L36
    L40:
        if (r106.f399722k0 != 8) goto L42;
    L44:
        l(this.f399768b.f399707d.f399774h);
        l(this.f399768b.f399707d.f399775i);
        return;
    L8:
        if (r103 != 2) goto L10;
        r101.f399758e = DependencyNode.Type.TOP;
    L25:
        if (r105 >= r102.f550643y0) goto L33;
        ConstraintWidget r110 = r102.f550642x0[r105];
        if (r104 == false) goto L29;
    L31:
        DependencyNode r111 = r110.f399709e.f399774h;
        List<d> r112 = r111.f399764k;
        ArrayList r113 = (ArrayList) r112;
        r113.add(this.f399774h);
        ((ArrayList) this.f399774h.f399765l).add(r111);
    L32:
        r105 = r105 + 1;
        goto L25
    L29:
        if (r110.f399722k0 != 8) goto L31;
    L33:
        l(this.f399768b.f399709e.f399774h);
        l(this.f399768b.f399709e.f399775i);
        return;
    L10:
        if (r103 != 3) goto L73;
        r101.f399758e = DependencyNode.Type.BOTTOM;
    L14:
        if (r105 >= r102.f550643y0) goto L22;
        ConstraintWidget r114 = r102.f550642x0[r105];
        if (r104 == false) goto L18;
    L20:
        DependencyNode r115 = r114.f399709e.f399775i;
        List<d> r116 = r115.f399764k;
        ArrayList r117 = (ArrayList) r116;
        r117.add(this.f399774h);
        ((ArrayList) this.f399774h.f399765l).add(r115);
    L21:
        r105 = r105 + 1;
        goto L14
    L18:
        if (r114.f399722k0 != 8) goto L20;
    L22:
        l(this.f399768b.f399709e.f399774h);
        l(this.f399768b.f399709e.f399775i);
        return;
    L73:
        return;
    L45:
        r101.f399758e = DependencyNode.Type.LEFT;
    L47:
        if (r105 >= r102.f550643y0) goto L55;
        ConstraintWidget r118 = r102.f550642x0[r105];
        if (r104 == false) goto L51;
    L53:
        DependencyNode r119 = r118.f399707d.f399774h;
        List<d> r120 = r119.f399764k;
        ArrayList r121 = (ArrayList) r120;
        r121.add(this.f399774h);
        ((ArrayList) this.f399774h.f399765l).add(r119);
    L54:
        r105 = r105 + 1;
        goto L47
    L51:
        if (r118.f399722k0 != 8) goto L53;
    L55:
        l(this.f399768b.f399707d.f399774h);
        l(this.f399768b.f399707d.f399775i);
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void d() {
        ConstraintWidget r100 = this.f399768b;
        if ((r100 instanceof com.obric.oui.constraintlayout.core.widgets.a) == false) goto L12;
        int r101 = ((com.obric.oui.constraintlayout.core.widgets.a) r100).f399753z0;
        if (r101 != 0) goto L7;
    L10:
        r100.f399706c0 = this.f399774h.f399760g;
        return;
    L7:
        if (r101 == 1) goto L10;
        r100.f399708d0 = this.f399774h.f399760g;
        return;
    }

    public j(ConstraintWidget r100) {
        super(r100);
    }

    public final void l(DependencyNode r100) {
        ((ArrayList) this.f399774h.f399764k).add(r100);
        List<DependencyNode> r101 = r100.f399765l;
        ArrayList r102 = (ArrayList) r101;
        r102.add(this.f399774h);
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun, com.obric.oui.constraintlayout.core.widgets.analyzer.d
    public void update(d r100) {
        com.obric.oui.constraintlayout.core.widgets.a r101 = (com.obric.oui.constraintlayout.core.widgets.a) this.f399768b;
        int r102 = r101.f399753z0;
        Iterator r103 = ((ArrayList) this.f399774h.f399765l).iterator();
        int r104 = 0;
        int r105 = -1;
    L4:
        if (r103.hasNext() == false) goto L11;
        int r106 = ((DependencyNode) r103.next()).f399760g;
        if (r105 == (-1)) goto L8;
        if (r106 < r105) goto L8;
    L9:
        if (r104 >= r106) goto L4;
        r104 = r106;
    L8:
        r105 = r106;
        goto L9
    L11:
        if (r102 != 0) goto L13;
    L16:
        this.f399774h.c(r105 + r101.B0);
        return;
    L13:
        if (r102 == 2) goto L16;
        this.f399774h.c(r104 + r101.B0);
    }
}
