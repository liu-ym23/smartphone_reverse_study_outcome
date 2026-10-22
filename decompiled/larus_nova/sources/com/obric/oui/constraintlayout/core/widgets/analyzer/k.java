package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public final class k extends WidgetRun {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f399804k = null;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f399805a = null;

        static {
            int[] r100 = new int[WidgetRun.RunType.values().length];
            f399805a = r100;
            r100[WidgetRun.RunType.START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f399805a[WidgetRun.RunType.END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f399805a[WidgetRun.RunType.CENTER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    static {
        f399804k = new int[2];
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void e() {
        this.f399769c = null;
        this.f399774h.b();
        this.f399775i.b();
        this.f399771e.b();
        this.f399773g = false;
    }

    public final void m() {
        this.f399773g = false;
        this.f399774h.b();
        this.f399774h.f399763j = false;
        this.f399775i.b();
        this.f399775i.f399763j = false;
        this.f399771e.f399763j = false;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void c() {
        ConstraintWidget r100 = this.f399768b;
        if (r100.f399701a == false) goto L5;
        this.f399771e.c(r100.t());
    L5:
        f r101 = this.f399771e;
        if (r101.f399763j == true) goto L21;
        ConstraintWidget r102 = this.f399768b;
        ConstraintWidget.DimensionBehaviour r103 = r102.W[0];
        this.f399770d = r103;
        if (r103 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L30;
        ConstraintWidget.DimensionBehaviour r104 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        if (r103 != r104) goto L19;
        ConstraintWidget r105 = r102.X;
        if (r105 == null) goto L19;
        ConstraintWidget.DimensionBehaviour r106 = r105.W[0];
        if (r106 == ConstraintWidget.DimensionBehaviour.FIXED) goto L16;
        if (r106 != r104) goto L19;
    L16:
        int r107 = (r105.t() - this.f399768b.L.e()) - this.f399768b.N.e();
        WidgetRun.a(this.f399774h, r105.f399707d.f399774h, this.f399768b.L.e());
        WidgetRun.a(this.f399775i, r105.f399707d.f399775i, -this.f399768b.N.e());
        this.f399771e.c(r107);
        return;
    L19:
        if (r103 != ConstraintWidget.DimensionBehaviour.FIXED) goto L30;
        r101.c(r102.t());
    L30:
        f r108 = this.f399771e;
        if (r108.f399763j == false) goto L65;
        ConstraintWidget r109 = this.f399768b;
        if (r109.f399701a == false) goto L65;
        ConstraintAnchor[] r110 = r109.T;
        ConstraintAnchor r111 = r110[0];
        ConstraintAnchor r112 = r111.f399694f;
        if (r112 != null) goto L37;
    L48:
        if (r112 == null) goto L52;
        DependencyNode r113 = WidgetRun.g(r111);
        if (r113 == null) goto L115;
        WidgetRun.a(this.f399774h, r113, this.f399768b.T[0].e());
        WidgetRun.a(this.f399775i, this.f399774h, this.f399771e.f399760g);
        return;
    L115:
        return;
    L52:
        ConstraintAnchor r114 = r110[1];
        if (r114.f399694f == null) goto L58;
        DependencyNode r115 = WidgetRun.g(r114);
        if (r115 == null) goto L117;
        WidgetRun.a(this.f399775i, r115, -this.f399768b.T[1].e());
        WidgetRun.a(this.f399774h, this.f399775i, -this.f399771e.f399760g);
        return;
    L117:
        return;
    L58:
        if ((r109 instanceof ula.a) == false) goto L60;
        return;
    L60:
        if (r109.X != null) goto L62;
        return;
    L62:
        if (r109.l(ConstraintAnchor.Type.CENTER).f399694f != null) goto L121;
        ConstraintWidget r116 = this.f399768b;
        DependencyNode r117 = r116.X.f399707d.f399774h;
        WidgetRun.a(this.f399774h, r117, r116.u());
        WidgetRun.a(this.f399775i, this.f399774h, this.f399771e.f399760g);
        return;
    L121:
        return;
    L37:
        if (r110[1].f399694f == null) goto L48;
        if (r109.A() == false) goto L41;
        DependencyNode r118 = this.f399774h;
        r118.f399759f = this.f399768b.T[0].e();
        DependencyNode r119 = this.f399775i;
        r119.f399759f = -this.f399768b.T[1].e();
        return;
    L41:
        DependencyNode r120 = WidgetRun.g(this.f399768b.T[0]);
        if (r120 == null) goto L44;
        WidgetRun.a(this.f399774h, r120, this.f399768b.T[0].e());
    L44:
        DependencyNode r121 = WidgetRun.g(this.f399768b.T[1]);
        if (r121 == null) goto L47;
        WidgetRun.a(this.f399775i, r121, -this.f399768b.T[1].e());
    L47:
        this.f399774h.f399755b = true;
        this.f399775i.f399755b = true;
        return;
    L65:
        if (this.f399770d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L85;
        ConstraintWidget r122 = this.f399768b;
        int r123 = r122.f399739t;
        if (r123 != 2) goto L69;
        ConstraintWidget r124 = r122.X;
        if (r124 == null) goto L85;
        f r125 = r124.f399709e.f399771e;
        ((ArrayList) r108.f399765l).add(r125);
        List<d> r126 = r125.f399764k;
        ArrayList r127 = (ArrayList) r126;
        r127.add(this.f399771e);
        f r128 = this.f399771e;
        r128.f399755b = true;
        List<d> r129 = r128.f399764k;
        ArrayList r130 = (ArrayList) r129;
        r130.add(this.f399774h);
        List<d> r131 = this.f399771e.f399764k;
        ArrayList r132 = (ArrayList) r131;
        r132.add(this.f399775i);
        goto L85
    L69:
        if (r123 != 3) goto L85;
        if (r122.f399741u != 3) goto L80;
        this.f399774h.f399754a = this;
        this.f399775i.f399754a = this;
        m r133 = r122.f399709e;
        r133.f399774h.f399754a = this;
        r133.f399775i.f399754a = this;
        r108.f399754a = this;
        if (r122.B() == false) goto L77;
        List<DependencyNode> r134 = this.f399771e.f399765l;
        ArrayList r135 = (ArrayList) r134;
        r135.add(this.f399768b.f399709e.f399771e);
        List<d> r136 = this.f399768b.f399709e.f399771e.f399764k;
        ArrayList r137 = (ArrayList) r136;
        r137.add(this.f399771e);
        m r138 = this.f399768b.f399709e;
        r138.f399771e.f399754a = this;
        List<DependencyNode> r139 = this.f399771e.f399765l;
        ArrayList r140 = (ArrayList) r139;
        r140.add(r138.f399774h);
        List<DependencyNode> r141 = this.f399771e.f399765l;
        ArrayList r142 = (ArrayList) r141;
        r142.add(this.f399768b.f399709e.f399775i);
        List<d> r143 = this.f399768b.f399709e.f399774h.f399764k;
        ArrayList r144 = (ArrayList) r143;
        r144.add(this.f399771e);
        List<d> r145 = this.f399768b.f399709e.f399775i.f399764k;
        ArrayList r146 = (ArrayList) r145;
        r146.add(this.f399771e);
        goto L85
    L77:
        if (this.f399768b.A() == false) goto L79;
        List<DependencyNode> r147 = this.f399768b.f399709e.f399771e.f399765l;
        ArrayList r148 = (ArrayList) r147;
        r148.add(this.f399771e);
        List<d> r149 = this.f399771e.f399764k;
        ArrayList r150 = (ArrayList) r149;
        r150.add(this.f399768b.f399709e.f399771e);
        goto L85
    L79:
        List<DependencyNode> r151 = this.f399768b.f399709e.f399771e.f399765l;
        ArrayList r152 = (ArrayList) r151;
        r152.add(this.f399771e);
        goto L85
    L80:
        f r153 = r122.f399709e.f399771e;
        ((ArrayList) r108.f399765l).add(r153);
        List<d> r154 = r153.f399764k;
        ArrayList r155 = (ArrayList) r154;
        r155.add(this.f399771e);
        List<d> r156 = this.f399768b.f399709e.f399774h.f399764k;
        ArrayList r157 = (ArrayList) r156;
        r157.add(this.f399771e);
        List<d> r158 = this.f399768b.f399709e.f399775i.f399764k;
        ArrayList r159 = (ArrayList) r158;
        r159.add(this.f399771e);
        f r160 = this.f399771e;
        r160.f399755b = true;
        List<d> r161 = r160.f399764k;
        ArrayList r162 = (ArrayList) r161;
        r162.add(this.f399774h);
        List<d> r163 = this.f399771e.f399764k;
        ArrayList r164 = (ArrayList) r163;
        r164.add(this.f399775i);
        List<DependencyNode> r165 = this.f399774h.f399765l;
        ArrayList r166 = (ArrayList) r165;
        r166.add(this.f399771e);
        List<DependencyNode> r167 = this.f399775i.f399765l;
        ArrayList r168 = (ArrayList) r167;
        r168.add(this.f399771e);
    L85:
        ConstraintWidget r169 = this.f399768b;
        ConstraintAnchor[] r170 = r169.T;
        ConstraintAnchor r171 = r170[0];
        ConstraintAnchor r172 = r171.f399694f;
        if (r172 != null) goto L88;
    L98:
        if (r172 == null) goto L102;
        DependencyNode r173 = WidgetRun.g(r171);
        if (r173 == null) goto L125;
        WidgetRun.a(this.f399774h, r173, this.f399768b.T[0].e());
        b(this.f399775i, this.f399774h, 1, this.f399771e);
        return;
    L125:
        return;
    L102:
        ConstraintAnchor r174 = r170[1];
        if (r174.f399694f == null) goto L108;
        DependencyNode r175 = WidgetRun.g(r174);
        if (r175 == null) goto L127;
        WidgetRun.a(this.f399775i, r175, -this.f399768b.T[1].e());
        b(this.f399774h, this.f399775i, -1, this.f399771e);
        return;
    L127:
        return;
    L108:
        if ((r169 instanceof ula.a) == true) goto L129;
        ConstraintWidget r176 = r169.X;
        if (r176 == null) goto L130;
        DependencyNode r177 = r176.f399707d.f399774h;
        WidgetRun.a(this.f399774h, r177, r169.u());
        b(this.f399775i, this.f399774h, 1, this.f399771e);
        return;
    L130:
        return;
    L129:
        return;
    L88:
        if (r170[1].f399694f == null) goto L98;
        if (r169.A() == false) goto L92;
        DependencyNode r178 = this.f399774h;
        r178.f399759f = this.f399768b.T[0].e();
        DependencyNode r179 = this.f399775i;
        r179.f399759f = -this.f399768b.T[1].e();
        return;
    L92:
        DependencyNode r180 = WidgetRun.g(this.f399768b.T[0]);
        DependencyNode r181 = WidgetRun.g(this.f399768b.T[1]);
        if (r180 == null) goto L95;
        r180.a(this);
    L95:
        if (r181 == null) goto L97;
        r181.a(this);
    L97:
        this.f399776j = WidgetRun.RunType.CENTER;
        return;
    L21:
        ConstraintWidget.DimensionBehaviour r182 = this.f399770d;
        ConstraintWidget.DimensionBehaviour r183 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
        if (r182 != r183) goto L30;
        ConstraintWidget r184 = this.f399768b;
        ConstraintWidget r185 = r184.X;
        if (r185 == null) goto L30;
        ConstraintWidget.DimensionBehaviour r186 = r185.W[0];
        if (r186 == ConstraintWidget.DimensionBehaviour.FIXED) goto L28;
        if (r186 != r183) goto L30;
    L28:
        WidgetRun.a(this.f399774h, r185.f399707d.f399774h, r184.L.e());
        WidgetRun.a(this.f399775i, r185.f399707d.f399775i, -this.f399768b.N.e());
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void d() {
        DependencyNode r100 = this.f399774h;
        if (r100.f399763j == false) goto L6;
        ConstraintWidget r101 = this.f399768b;
        r101.f399706c0 = r100.f399760g;
        return;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public final boolean j() {
        if (this.f399770d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L5;
        return true;
    L5:
        if (this.f399768b.f399739t != 0) goto L7;
        return true;
    L7:
        return false;
    }

    public final String toString() {
        return "HorizontalRun " + this.f399768b.f399726m0;
    }

    public k(ConstraintWidget r100) {
        super(r100);
        DependencyNode r101 = this.f399774h;
        r101.f399758e = DependencyNode.Type.LEFT;
        DependencyNode r102 = this.f399775i;
        r102.f399758e = DependencyNode.Type.RIGHT;
        this.f399772f = 0;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun, com.obric.oui.constraintlayout.core.widgets.analyzer.d
    public void update(d r210) {
        if (a.f399805a[this.f399776j.ordinal()] == 3) goto L174;
        f r100 = this.f399771e;
        if (r100.f399763j == false) goto L7;
    L129:
        DependencyNode r101 = this.f399774h;
        if (r101.f399756c == false) goto L184;
        DependencyNode r102 = this.f399775i;
        if (r102.f399756c == true) goto L135;
        return;
    L135:
        if (r101.f399763j == false) goto L142;
        if (r102.f399763j == false) goto L142;
        if (this.f399771e.f399763j == false) goto L142;
        return;
    L142:
        if (this.f399771e.f399763j == true) goto L152;
        if (this.f399770d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L152;
        ConstraintWidget r103 = this.f399768b;
        if (r103.f399739t != 0) goto L152;
        if (r103.A() == true) goto L152;
        DependencyNode r104 = (DependencyNode) ListProtector.get(this.f399774h.f399765l, 0);
        DependencyNode r105 = (DependencyNode) ListProtector.get(this.f399775i.f399765l, 0);
        int r106 = r104.f399760g;
        DependencyNode r107 = this.f399774h;
        int r108 = r106 + r107.f399759f;
        int r109 = r105.f399760g + this.f399775i.f399759f;
        r107.c(r108);
        this.f399775i.c(r109);
        this.f399771e.c(r109 - r108);
        return;
    L152:
        if (this.f399771e.f399763j == true) goto L166;
        if (this.f399770d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L166;
        if (this.f399767a != 1) goto L166;
        if (((ArrayList) this.f399774h.f399765l).size() <= 0) goto L166;
        if (((ArrayList) this.f399775i.f399765l).size() <= 0) goto L166;
        DependencyNode r110 = (DependencyNode) ListProtector.get(this.f399774h.f399765l, 0);
        DependencyNode r111 = (DependencyNode) ListProtector.get(this.f399775i.f399765l, 0);
        int r112 = Math.min((r111.f399760g + this.f399775i.f399759f) - (r110.f399760g + this.f399774h.f399759f), this.f399771e.f399802m);
        ConstraintWidget r113 = this.f399768b;
        int r114 = r113.f399747x;
        int r115 = Math.max(r113.f399745w, r112);
        if (r114 <= 0) goto L164;
        r115 = Math.min(r114, r115);
    L164:
        this.f399771e.c(r115);
    L166:
        if (this.f399771e.f399763j == true) goto L168;
        return;
    L168:
        DependencyNode r116 = (DependencyNode) ListProtector.get(this.f399774h.f399765l, 0);
        DependencyNode r117 = (DependencyNode) ListProtector.get(this.f399775i.f399765l, 0);
        int r118 = r116.f399760g;
        DependencyNode r119 = this.f399774h;
        int r120 = r119.f399759f + r118;
        int r121 = r117.f399760g;
        int r122 = this.f399775i.f399759f + r121;
        float r123 = this.f399768b.f399716h0;
        if (r116 != r117) goto L171;
        r123 = 0.5f;
    L172:
        r119.c((int) ((r118 + 0.5f) + (((r121 - r118) - this.f399771e.f399760g) * r123)));
        this.f399775i.c(this.f399774h.f399760g + this.f399771e.f399760g);
        return;
    L171:
        r118 = r120;
        r121 = r122;
        goto L172
    L184:
        return;
    L7:
        if (this.f399770d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L129;
        ConstraintWidget r124 = this.f399768b;
        int r125 = r124.f399739t;
        if (r125 == 2) goto L124;
        if (r125 != 3) goto L129;
        int r126 = r124.f399741u;
        if (r126 == 0) goto L27;
        if (r126 == 3) goto L27;
        int r127 = r124.f399704b0;
        if (r127 == (-1)) goto L23;
        if (r127 == 0) goto L22;
        if (r127 == 1) goto L21;
        int r128 = 0;
    L26:
        r100.c(r128);
        goto L129
    L21:
        float r129 = r124.f399709e.f399771e.f399760g;
        float r130 = r124.f399702a0;
    L24:
        float r131 = r129 * r130;
    L25:
        r128 = (int) (r131 + 0.5f);
        goto L26
    L22:
        r131 = r124.f399709e.f399771e.f399760g / r124.f399702a0;
        goto L25
    L23:
        r129 = r124.f399709e.f399771e.f399760g;
        r130 = r124.f399702a0;
    L27:
        m r132 = r124.f399709e;
        DependencyNode r133 = r132.f399774h;
        DependencyNode r134 = r132.f399775i;
        if (r124.L.f399694f == null) goto L30;
        boolean r135 = true;
    L32:
        if (r124.M.f399694f == null) goto L34;
        boolean r136 = true;
    L36:
        if (r124.N.f399694f == null) goto L38;
        boolean r137 = true;
    L40:
        if (r124.O.f399694f == null) goto L42;
        boolean r138 = true;
    L43:
        int r139 = r124.f399704b0;
        if (r135 == false) goto L82;
        if (r136 == false) goto L82;
        if (r137 == false) goto L82;
        if (r138 == false) goto L82;
        float r140 = r124.f399702a0;
        boolean r141 = r133.f399763j;
        int[] r142 = f399804k;
        if (r141 == true) goto L51;
    L59:
        DependencyNode r143 = this.f399774h;
        if (r143.f399763j == false) goto L70;
        DependencyNode r144 = this.f399775i;
        if (r144.f399763j == false) goto L70;
        if (r133.f399756c == true) goto L66;
        return;
    L66:
        if (r134.f399756c == false) goto L178;
        l(r142, r143.f399760g + r143.f399759f, r144.f399760g - r144.f399759f, ((DependencyNode) ListProtector.get(r133.f399765l, 0)).f399760g + r133.f399759f, ((DependencyNode) ListProtector.get(r134.f399765l, 0)).f399760g - r134.f399759f, r140, r139);
        this.f399771e.c(r142[0]);
        this.f399768b.f399709e.f399771e.c(r142[1]);
        goto L70
    L178:
        return;
    L70:
        DependencyNode r145 = this.f399774h;
        if (r145.f399756c == true) goto L73;
        return;
    L73:
        if (this.f399775i.f399756c == true) goto L75;
        return;
    L75:
        if (r133.f399756c == true) goto L77;
        return;
    L77:
        if (r134.f399756c == false) goto L181;
        l(r142, ((DependencyNode) ListProtector.get(r145.f399765l, 0)).f399760g + this.f399774h.f399759f, ((DependencyNode) ListProtector.get(this.f399775i.f399765l, 0)).f399760g - this.f399775i.f399759f, ((DependencyNode) ListProtector.get(r133.f399765l, 0)).f399760g + r133.f399759f, ((DependencyNode) ListProtector.get(r134.f399765l, 0)).f399760g - r134.f399759f, r140, r139);
        this.f399771e.c(r142[0]);
        this.f399768b.f399709e.f399771e.c(r142[1]);
        goto L129
    L181:
        return;
    L51:
        if (r134.f399763j == false) goto L59;
        DependencyNode r146 = this.f399774h;
        if (r146.f399756c == true) goto L55;
        return;
    L55:
        if (this.f399775i.f399756c == false) goto L177;
        l(r142, ((DependencyNode) ListProtector.get(r146.f399765l, 0)).f399760g + this.f399774h.f399759f, ((DependencyNode) ListProtector.get(this.f399775i.f399765l, 0)).f399760g - this.f399775i.f399759f, r133.f399759f + r133.f399760g, r134.f399760g - r134.f399759f, r140, r139);
        this.f399771e.c(r142[0]);
        this.f399768b.f399709e.f399771e.c(r142[1]);
        return;
    L177:
        return;
    L82:
        if (r135 == false) goto L103;
        if (r137 == false) goto L103;
        DependencyNode r147 = this.f399774h;
        if (r147.f399756c == true) goto L87;
        return;
    L87:
        if (this.f399775i.f399756c == false) goto L182;
        float r148 = r124.f399702a0;
        int r149 = ((DependencyNode) ListProtector.get(r147.f399765l, 0)).f399760g + this.f399774h.f399759f;
        int r150 = ((DependencyNode) ListProtector.get(this.f399775i.f399765l, 0)).f399760g - this.f399775i.f399759f;
        if (r139 == (-1)) goto L98;
        if (r139 == 0) goto L98;
        if (r139 != 1) goto L129;
        int r151 = f(r150 - r149, 0);
        int r152 = (int) ((r151 / r148) + 0.5f);
        int r153 = f(r152, 1);
        if (r152 == r153) goto L97;
        r151 = (int) ((r153 * r148) + 0.5f);
    L97:
        this.f399771e.c(r151);
        this.f399768b.f399709e.f399771e.c(r153);
    L98:
        int r154 = f(r150 - r149, 0);
        int r155 = (int) ((r154 * r148) + 0.5f);
        int r156 = f(r155, 1);
        if (r155 == r156) goto L101;
        r154 = (int) ((r156 / r148) + 0.5f);
    L101:
        this.f399771e.c(r154);
        this.f399768b.f399709e.f399771e.c(r156);
        goto L129
    L182:
        return;
    L103:
        if (r136 == false) goto L129;
        if (r138 == false) goto L129;
        if (r133.f399756c == true) goto L108;
        return;
    L108:
        if (r134.f399756c == false) goto L183;
        float r157 = r124.f399702a0;
        int r158 = ((DependencyNode) ListProtector.get(r133.f399765l, 0)).f399760g + r133.f399759f;
        int r159 = ((DependencyNode) ListProtector.get(r134.f399765l, 0)).f399760g - r134.f399759f;
        if (r139 == (-1)) goto L119;
        if (r139 == 0) goto L115;
        if (r139 == 1) goto L119;
    L115:
        int r160 = f(r159 - r158, 1);
        int r161 = (int) ((r160 * r157) + 0.5f);
        int r162 = f(r161, 0);
        if (r161 == r162) goto L118;
        r160 = (int) ((r162 / r157) + 0.5f);
    L118:
        this.f399771e.c(r162);
        this.f399768b.f399709e.f399771e.c(r160);
    L119:
        int r163 = f(r159 - r158, 1);
        int r164 = (int) ((r163 / r157) + 0.5f);
        int r165 = f(r164, 0);
        if (r164 == r165) goto L122;
        r163 = (int) ((r165 * r157) + 0.5f);
    L122:
        this.f399771e.c(r165);
        this.f399768b.f399709e.f399771e.c(r163);
        goto L129
    L183:
        return;
    L42:
        r138 = false;
        goto L43
    L38:
        r137 = false;
        goto L40
    L34:
        r136 = false;
        goto L36
    L30:
        r135 = false;
        goto L32
    L124:
        ConstraintWidget r166 = r124.X;
        if (r166 == null) goto L129;
        f r167 = r166.f399707d.f399771e;
        if (r167.f399763j == false) goto L129;
        r100.c((int) ((r167.f399760g * r124.f399748y) + 0.5f));
        goto L129
    L174:
        ConstraintWidget r168 = this.f399768b;
        k(r168.L, r168.N, 0);
    }

    public static void l(int[] r100, int r101, int r102, int r103, int r104, float r105, int r106) {
        int r107 = r102 - r101;
        int r108 = r104 - r103;
        if (r106 == (-1)) goto L9;
        if (r106 == 0) goto L8;
        if (r106 != 1) goto L19;
        r100[0] = r107;
        r100[1] = (int) ((r107 * r105) + 0.5f);
        return;
    L19:
        return;
    L8:
        r100[0] = (int) ((r108 * r105) + 0.5f);
        r100[1] = r108;
        return;
    L9:
        int r109 = (int) ((r108 * r105) + 0.5f);
        int r110 = (int) ((r107 / r105) + 0.5f);
        if (r109 > r107) goto L12;
        r100[0] = r109;
        r100[1] = r108;
        return;
    L12:
        if (r110 > r108) goto L18;
        r100[0] = r107;
        r100[1] = r110;
        return;
    }
}
