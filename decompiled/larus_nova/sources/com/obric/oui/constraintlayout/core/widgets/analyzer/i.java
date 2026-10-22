package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class i extends WidgetRun {
    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public final boolean j() {
        return false;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void c() {
        ConstraintWidget r100 = this.f399768b;
        com.obric.oui.constraintlayout.core.widgets.f r101 = (com.obric.oui.constraintlayout.core.widgets.f) r100;
        int r102 = r101.f399864y0;
        int r103 = r101.f399865z0;
        if (r101.B0 != 1) goto L10;
        if (r102 == (-1)) goto L6;
        List<DependencyNode> r104 = this.f399774h.f399765l;
        ArrayList r105 = (ArrayList) r104;
        r105.add(r100.X.f399707d.f399774h);
        List<d> r106 = this.f399768b.X.f399707d.f399774h.f399764k;
        ArrayList r107 = (ArrayList) r106;
        r107.add(this.f399774h);
        this.f399774h.f399759f = r102;
    L9:
        l(this.f399768b.f399707d.f399774h);
        l(this.f399768b.f399707d.f399775i);
        return;
    L6:
        if (r103 == (-1)) goto L8;
        List<DependencyNode> r108 = this.f399774h.f399765l;
        ArrayList r109 = (ArrayList) r108;
        r109.add(r100.X.f399707d.f399775i);
        List<d> r110 = this.f399768b.X.f399707d.f399775i.f399764k;
        ArrayList r111 = (ArrayList) r110;
        r111.add(this.f399774h);
        int r112 = -r103;
        this.f399774h.f399759f = r112;
        goto L9
    L8:
        DependencyNode r113 = this.f399774h;
        r113.f399755b = true;
        List<DependencyNode> r114 = r113.f399765l;
        ArrayList r115 = (ArrayList) r114;
        r115.add(r100.X.f399707d.f399775i);
        List<d> r116 = this.f399768b.X.f399707d.f399775i.f399764k;
        ArrayList r117 = (ArrayList) r116;
        r117.add(this.f399774h);
        goto L9
    L10:
        if (r102 == (-1)) goto L12;
        List<DependencyNode> r118 = this.f399774h.f399765l;
        ArrayList r119 = (ArrayList) r118;
        r119.add(r100.X.f399709e.f399774h);
        List<d> r120 = this.f399768b.X.f399709e.f399774h.f399764k;
        ArrayList r121 = (ArrayList) r120;
        r121.add(this.f399774h);
        this.f399774h.f399759f = r102;
    L15:
        l(this.f399768b.f399709e.f399774h);
        l(this.f399768b.f399709e.f399775i);
        return;
    L12:
        if (r103 == (-1)) goto L14;
        List<DependencyNode> r122 = this.f399774h.f399765l;
        ArrayList r123 = (ArrayList) r122;
        r123.add(r100.X.f399709e.f399775i);
        List<d> r124 = this.f399768b.X.f399709e.f399775i.f399764k;
        ArrayList r125 = (ArrayList) r124;
        r125.add(this.f399774h);
        int r126 = -r103;
        this.f399774h.f399759f = r126;
        goto L15
    L14:
        DependencyNode r127 = this.f399774h;
        r127.f399755b = true;
        List<DependencyNode> r128 = r127.f399765l;
        ArrayList r129 = (ArrayList) r128;
        r129.add(r100.X.f399709e.f399775i);
        List<d> r130 = this.f399768b.X.f399709e.f399775i.f399764k;
        ArrayList r131 = (ArrayList) r130;
        r131.add(this.f399774h);
        goto L15
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void d() {
        ConstraintWidget r100 = this.f399768b;
        if (((com.obric.oui.constraintlayout.core.widgets.f) r100).B0 != 1) goto L5;
        r100.f399706c0 = this.f399774h.f399760g;
        return;
    L5:
        r100.f399708d0 = this.f399774h.f399760g;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void e() {
        this.f399774h.b();
    }

    public i(ConstraintWidget r100) {
        super(r100);
        r100.f399707d.e();
        r100.f399709e.e();
        this.f399772f = ((com.obric.oui.constraintlayout.core.widgets.f) r100).B0;
    }

    public final void l(DependencyNode r100) {
        ((ArrayList) this.f399774h.f399764k).add(r100);
        List<DependencyNode> r101 = r100.f399765l;
        ArrayList r102 = (ArrayList) r101;
        r102.add(this.f399774h);
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun, com.obric.oui.constraintlayout.core.widgets.analyzer.d
    public void update(d r100) {
        DependencyNode r101 = this.f399774h;
        if (r101.f399756c == true) goto L6;
        return;
    L6:
        if (r101.f399763j == false) goto L8;
        return;
    L8:
        this.f399774h.c((int) ((((DependencyNode) ListProtector.get(r101.f399765l, 0)).f399760g * ((com.obric.oui.constraintlayout.core.widgets.f) this.f399768b).f399863x0) + 0.5f));
    }
}
