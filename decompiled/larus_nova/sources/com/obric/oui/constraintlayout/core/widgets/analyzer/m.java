package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class m extends WidgetRun {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final DependencyNode f399808k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.obric.oui.constraintlayout.core.widgets.analyzer.a f399809l;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f399810a = null;

        static {
            int[] r100 = new int[WidgetRun.RunType.values().length];
            f399810a = r100;
            r100[WidgetRun.RunType.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f399810a[WidgetRun.RunType.END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f399810a[WidgetRun.RunType.CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void e() {
        this.f399769c = null;
        this.f399774h.b();
        this.f399775i.b();
        this.f399808k.b();
        this.f399771e.b();
        this.f399773g = false;
    }

    public final void l() {
        this.f399773g = false;
        this.f399774h.b();
        this.f399774h.f399763j = false;
        this.f399775i.b();
        this.f399775i.f399763j = false;
        this.f399808k.b();
        this.f399808k.f399763j = false;
        this.f399771e.f399763j = false;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void c() {
        ConstraintWidget r100 = this.f399768b;
        if (r100.f399701a == false) goto L6;
        this.f399771e.c(r100.n());
    L6:
        if (this.f399771e.f399763j == true) goto L24;
        ConstraintWidget r101 = this.f399768b;
        this.f399770d = r101.W[1];
        if (r101.G == false) goto L10;
        this.f399809l = new com.obric.oui.constraintlayout.core.widgets.analyzer.a(this);
    L10:
        ConstraintWidget.DimensionBehaviour r102 = this.f399770d;
        if (r102 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L13;
    L31:
        f r103 = this.f399771e;
        boolean r104 = r103.f399763j;
        if (r104 == false) goto L80;
        ConstraintWidget r105 = this.f399768b;
        if (r105.f399701a == false) goto L80;
        ConstraintAnchor[] r106 = r105.T;
        ConstraintAnchor r107 = r106[2];
        ConstraintAnchor r108 = r107.f399694f;
        if (r108 != null) goto L38;
    L52:
        if (r108 == null) goto L58;
        DependencyNode r109 = WidgetRun.g(r107);
        if (r109 == null) goto L160;
        WidgetRun.a(this.f399774h, r109, this.f399768b.T[2].e());
        WidgetRun.a(this.f399775i, this.f399774h, this.f399771e.f399760g);
        ConstraintWidget r110 = this.f399768b;
        if (r110.G == false) goto L161;
        WidgetRun.a(this.f399808k, this.f399774h, r110.f399710e0);
        return;
    L161:
        return;
    L160:
        return;
    L58:
        ConstraintAnchor r111 = r106[3];
        if (r111.f399694f == null) goto L66;
        DependencyNode r112 = WidgetRun.g(r111);
        if (r112 == null) goto L63;
        WidgetRun.a(this.f399775i, r112, -this.f399768b.T[3].e());
        WidgetRun.a(this.f399774h, this.f399775i, -this.f399771e.f399760g);
    L63:
        ConstraintWidget r113 = this.f399768b;
        if (r113.G == false) goto L163;
        WidgetRun.a(this.f399808k, this.f399774h, r113.f399710e0);
        return;
    L163:
        return;
    L66:
        ConstraintAnchor r114 = r106[4];
        if (r114.f399694f == null) goto L72;
        DependencyNode r115 = WidgetRun.g(r114);
        if (r115 == null) goto L165;
        WidgetRun.a(this.f399808k, r115, 0);
        WidgetRun.a(this.f399774h, this.f399808k, -this.f399768b.f399710e0);
        WidgetRun.a(this.f399775i, this.f399774h, this.f399771e.f399760g);
        return;
    L165:
        return;
    L72:
        if ((r105 instanceof ula.a) == false) goto L74;
        return;
    L74:
        if (r105.X != null) goto L76;
        return;
    L76:
        if (r105.l(ConstraintAnchor.Type.CENTER).f399694f != null) goto L169;
        ConstraintWidget r116 = this.f399768b;
        DependencyNode r117 = r116.X.f399709e.f399774h;
        WidgetRun.a(this.f399774h, r117, r116.v());
        WidgetRun.a(this.f399775i, this.f399774h, this.f399771e.f399760g);
        ConstraintWidget r118 = this.f399768b;
        if (r118.G == false) goto L170;
        WidgetRun.a(this.f399808k, this.f399774h, r118.f399710e0);
        return;
    L170:
        return;
    L169:
        return;
    L38:
        if (r106[3].f399694f == null) goto L52;
        if (r105.B() == false) goto L42;
        DependencyNode r119 = this.f399774h;
        r119.f399759f = this.f399768b.T[2].e();
        DependencyNode r120 = this.f399775i;
        r120.f399759f = -this.f399768b.T[3].e();
    L49:
        ConstraintWidget r121 = this.f399768b;
        if (r121.G == false) goto L158;
        WidgetRun.a(this.f399808k, this.f399774h, r121.f399710e0);
        return;
    L158:
        return;
    L42:
        DependencyNode r122 = WidgetRun.g(this.f399768b.T[2]);
        if (r122 == null) goto L45;
        WidgetRun.a(this.f399774h, r122, this.f399768b.T[2].e());
    L45:
        DependencyNode r123 = WidgetRun.g(this.f399768b.T[3]);
        if (r123 == null) goto L48;
        WidgetRun.a(this.f399775i, r123, -this.f399768b.T[3].e());
    L48:
        this.f399774h.f399755b = true;
        this.f399775i.f399755b = true;
    L80:
        if (r104 == false) goto L82;
    L97:
        r103.a(this);
    L98:
        ConstraintWidget r124 = this.f399768b;
        ConstraintAnchor[] r125 = r124.T;
        ConstraintAnchor r126 = r125[2];
        ConstraintAnchor r127 = r126.f399694f;
        if (r127 == null) goto L115;
        if (r125[3].f399694f == null) goto L115;
        if (r124.B() == false) goto L105;
        DependencyNode r128 = this.f399774h;
        r128.f399759f = this.f399768b.T[2].e();
        DependencyNode r129 = this.f399775i;
        r129.f399759f = -this.f399768b.T[3].e();
    L112:
        if (this.f399768b.G == false) goto L155;
        b(this.f399808k, this.f399774h, 1, this.f399809l);
    L155:
        if (((ArrayList) this.f399771e.f399765l).size() != 0) goto L172;
        this.f399771e.f399756c = true;
        return;
    L172:
        return;
    L105:
        DependencyNode r130 = WidgetRun.g(this.f399768b.T[2]);
        DependencyNode r131 = WidgetRun.g(this.f399768b.T[3]);
        if (r130 == null) goto L108;
        r130.a(this);
    L108:
        if (r131 == null) goto L110;
        r131.a(this);
    L110:
        this.f399776j = WidgetRun.RunType.CENTER;
    L115:
        if (r127 == null) goto L128;
        DependencyNode r132 = WidgetRun.g(r126);
        if (r132 == null) goto L155;
        WidgetRun.a(this.f399774h, r132, this.f399768b.T[2].e());
        b(this.f399775i, this.f399774h, 1, this.f399771e);
        if (this.f399768b.G == false) goto L121;
        b(this.f399808k, this.f399774h, 1, this.f399809l);
    L121:
        ConstraintWidget.DimensionBehaviour r133 = this.f399770d;
        ConstraintWidget.DimensionBehaviour r134 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r133 != r134) goto L155;
        ConstraintWidget r135 = this.f399768b;
        if (r135.f399702a0 <= 0.0f) goto L155;
        k r136 = r135.f399707d;
        if (r136.f399770d != r134) goto L155;
        List<d> r137 = r136.f399771e.f399764k;
        ArrayList r138 = (ArrayList) r137;
        r138.add(this.f399771e);
        List<DependencyNode> r139 = this.f399771e.f399765l;
        ArrayList r140 = (ArrayList) r139;
        r140.add(this.f399768b.f399707d.f399771e);
        this.f399771e.f399754a = this;
        goto L155
    L128:
        ConstraintAnchor r141 = r125[3];
        if (r141.f399694f == null) goto L135;
        DependencyNode r142 = WidgetRun.g(r141);
        if (r142 == null) goto L155;
        WidgetRun.a(this.f399775i, r142, -this.f399768b.T[3].e());
        b(this.f399774h, this.f399775i, -1, this.f399771e);
        if (this.f399768b.G == false) goto L155;
        b(this.f399808k, this.f399774h, 1, this.f399809l);
        goto L155
    L135:
        ConstraintAnchor r143 = r125[4];
        if (r143.f399694f == null) goto L141;
        DependencyNode r144 = WidgetRun.g(r143);
        if (r144 == null) goto L155;
        WidgetRun.a(this.f399808k, r144, 0);
        b(this.f399774h, this.f399808k, -1, this.f399809l);
        b(this.f399775i, this.f399774h, 1, this.f399771e);
        goto L155
    L141:
        if ((r124 instanceof ula.a) == true) goto L155;
        ConstraintWidget r145 = r124.X;
        if (r145 == null) goto L155;
        DependencyNode r146 = r145.f399709e.f399774h;
        WidgetRun.a(this.f399774h, r146, r124.v());
        b(this.f399775i, this.f399774h, 1, this.f399771e);
        if (this.f399768b.G == false) goto L147;
        b(this.f399808k, this.f399774h, 1, this.f399809l);
    L147:
        ConstraintWidget.DimensionBehaviour r147 = this.f399770d;
        ConstraintWidget.DimensionBehaviour r148 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r147 != r148) goto L155;
        ConstraintWidget r149 = this.f399768b;
        if (r149.f399702a0 <= 0.0f) goto L155;
        k r150 = r149.f399707d;
        if (r150.f399770d != r148) goto L155;
        List<d> r151 = r150.f399771e.f399764k;
        ArrayList r152 = (ArrayList) r151;
        r152.add(this.f399771e);
        List<DependencyNode> r153 = this.f399771e.f399765l;
        ArrayList r154 = (ArrayList) r153;
        r154.add(this.f399768b.f399707d.f399771e);
        this.f399771e.f399754a = this;
        goto L155
    L82:
        if (this.f399770d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L97;
        ConstraintWidget r155 = this.f399768b;
        int r156 = r155.f399741u;
        if (r156 == 2) goto L93;
        if (r156 != 3) goto L98;
        if (r155.B() == true) goto L98;
        ConstraintWidget r157 = this.f399768b;
        if (r157.f399739t == 3) goto L98;
        f r158 = r157.f399707d.f399771e;
        ((ArrayList) this.f399771e.f399765l).add(r158);
        List<d> r159 = r158.f399764k;
        ArrayList r160 = (ArrayList) r159;
        r160.add(this.f399771e);
        f r161 = this.f399771e;
        r161.f399755b = true;
        List<d> r162 = r161.f399764k;
        ArrayList r163 = (ArrayList) r162;
        r163.add(this.f399774h);
        List<d> r164 = this.f399771e.f399764k;
        ArrayList r165 = (ArrayList) r164;
        r165.add(this.f399775i);
        goto L98
    L93:
        ConstraintWidget r166 = r155.X;
        if (r166 == null) goto L98;
        f r167 = r166.f399709e.f399771e;
        ((ArrayList) r103.f399765l).add(r167);
        List<d> r168 = r167.f399764k;
        ArrayList r169 = (ArrayList) r168;
        r169.add(this.f399771e);
        f r170 = this.f399771e;
        r170.f399755b = true;
        List<d> r171 = r170.f399764k;
        ArrayList r172 = (ArrayList) r171;
        r172.add(this.f399774h);
        List<d> r173 = this.f399771e.f399764k;
        ArrayList r174 = (ArrayList) r173;
        r174.add(this.f399775i);
        goto L98
    L13:
        if (r102 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L21;
        ConstraintWidget r175 = this.f399768b.X;
        if (r175 == null) goto L21;
        if (r175.W[1] != ConstraintWidget.DimensionBehaviour.FIXED) goto L21;
        int r176 = (r175.n() - this.f399768b.M.e()) - this.f399768b.O.e();
        WidgetRun.a(this.f399774h, r175.f399709e.f399774h, this.f399768b.M.e());
        WidgetRun.a(this.f399775i, r175.f399709e.f399775i, -this.f399768b.O.e());
        this.f399771e.c(r176);
        return;
    L21:
        if (r102 != ConstraintWidget.DimensionBehaviour.FIXED) goto L31;
        this.f399771e.c(this.f399768b.n());
        goto L31
    L24:
        if (this.f399770d != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L31;
        ConstraintWidget r177 = this.f399768b;
        ConstraintWidget r178 = r177.X;
        if (r178 == null) goto L31;
        if (r178.W[1] != ConstraintWidget.DimensionBehaviour.FIXED) goto L31;
        WidgetRun.a(this.f399774h, r178.f399709e.f399774h, r177.M.e());
        WidgetRun.a(this.f399775i, r178.f399709e.f399775i, -this.f399768b.O.e());
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void d() {
        DependencyNode r100 = this.f399774h;
        if (r100.f399763j == false) goto L6;
        ConstraintWidget r101 = this.f399768b;
        r101.f399708d0 = r100.f399760g;
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public final boolean j() {
        if (this.f399770d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        return true;
    L5:
        if (this.f399768b.f399741u != 0) goto L7;
        return true;
    L7:
        return false;
    }

    public final String toString() {
        return "VerticalRun " + this.f399768b.f399726m0;
    }

    public m(ConstraintWidget r100) {
        super(r100);
        DependencyNode r101 = new DependencyNode(this);
        this.f399808k = r101;
        this.f399809l = null;
        DependencyNode r102 = this.f399774h;
        r102.f399758e = DependencyNode.Type.TOP;
        DependencyNode r103 = this.f399775i;
        r103.f399758e = DependencyNode.Type.BOTTOM;
        r101.f399758e = DependencyNode.Type.BASELINE;
        this.f399772f = 1;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun, com.obric.oui.constraintlayout.core.widgets.analyzer.d
    public void update(d r100) {
        if (a.f399810a[this.f399776j.ordinal()] == 3) goto L81;
        f r101 = this.f399771e;
        if (r101.f399756c == true) goto L7;
    L32:
        DependencyNode r102 = this.f399774h;
        if (r102.f399756c == false) goto L83;
        DependencyNode r103 = this.f399775i;
        if (r103.f399756c == true) goto L38;
        return;
    L38:
        if (r102.f399763j == false) goto L45;
        if (r103.f399763j == false) goto L45;
        if (this.f399771e.f399763j == false) goto L45;
        return;
    L45:
        if (this.f399771e.f399763j == true) goto L55;
        if (this.f399770d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L55;
        ConstraintWidget r104 = this.f399768b;
        if (r104.f399739t != 0) goto L55;
        if (r104.B() == true) goto L55;
        DependencyNode r105 = (DependencyNode) ListProtector.get(this.f399774h.f399765l, 0);
        DependencyNode r106 = (DependencyNode) ListProtector.get(this.f399775i.f399765l, 0);
        int r107 = r105.f399760g;
        DependencyNode r108 = this.f399774h;
        int r109 = r107 + r108.f399759f;
        int r110 = r106.f399760g + this.f399775i.f399759f;
        r108.c(r109);
        this.f399775i.c(r110);
        this.f399771e.c(r110 - r109);
        return;
    L55:
        if (this.f399771e.f399763j == true) goto L69;
        if (this.f399770d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L69;
        if (this.f399767a != 1) goto L69;
        if (((ArrayList) this.f399774h.f399765l).size() <= 0) goto L69;
        if (((ArrayList) this.f399775i.f399765l).size() <= 0) goto L69;
        DependencyNode r111 = (DependencyNode) ListProtector.get(this.f399774h.f399765l, 0);
        DependencyNode r112 = (DependencyNode) ListProtector.get(this.f399775i.f399765l, 0);
        int r113 = (r112.f399760g + this.f399775i.f399759f) - (r111.f399760g + this.f399774h.f399759f);
        f r114 = this.f399771e;
        int r115 = r114.f399802m;
        if (r113 >= r115) goto L67;
        r114.c(r113);
        goto L69
    L67:
        r114.c(r115);
    L69:
        if (this.f399771e.f399763j == true) goto L72;
        return;
    L72:
        if (((ArrayList) this.f399774h.f399765l).size() > 0) goto L74;
        return;
    L74:
        if (((ArrayList) this.f399775i.f399765l).size() <= 0) goto L85;
        DependencyNode r116 = (DependencyNode) ListProtector.get(this.f399774h.f399765l, 0);
        DependencyNode r117 = (DependencyNode) ListProtector.get(this.f399775i.f399765l, 0);
        int r118 = r116.f399760g;
        DependencyNode r119 = this.f399774h;
        int r120 = r119.f399759f + r118;
        int r121 = r117.f399760g;
        int r122 = this.f399775i.f399759f + r121;
        float r123 = this.f399768b.f399718i0;
        if (r116 != r117) goto L78;
        r123 = 0.5f;
    L79:
        r119.c((int) ((r118 + 0.5f) + (((r121 - r118) - this.f399771e.f399760g) * r123)));
        this.f399775i.c(this.f399774h.f399760g + this.f399771e.f399760g);
        return;
    L78:
        r118 = r120;
        r121 = r122;
        goto L79
    L85:
        return;
    L83:
        return;
    L7:
        if (r101.f399763j == true) goto L32;
        if (this.f399770d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L32;
        ConstraintWidget r124 = this.f399768b;
        int r125 = r124.f399741u;
        if (r125 == 2) goto L27;
        if (r125 != 3) goto L32;
        f r126 = r124.f399707d.f399771e;
        if (r126.f399763j == false) goto L32;
        int r127 = r124.f399704b0;
        if (r127 == (-1)) goto L23;
        if (r127 == 0) goto L22;
        if (r127 == 1) goto L21;
        int r128 = 0;
    L26:
        r101.c(r128);
        goto L32
    L21:
        float r129 = r126.f399760g;
        float r130 = r124.f399702a0;
    L24:
        float r131 = r129 / r130;
    L25:
        r128 = (int) (r131 + 0.5f);
        goto L26
    L22:
        r131 = r126.f399760g * r124.f399702a0;
        goto L25
    L23:
        r129 = r126.f399760g;
        r130 = r124.f399702a0;
        goto L24
    L27:
        ConstraintWidget r132 = r124.X;
        if (r132 == null) goto L32;
        f r133 = r132.f399709e.f399771e;
        if (r133.f399763j == false) goto L32;
        r101.c((int) ((r133.f399760g * r124.B) + 0.5f));
        goto L32
    L81:
        ConstraintWidget r134 = this.f399768b;
        k(r134.M, r134.O, 1);
    }
}
