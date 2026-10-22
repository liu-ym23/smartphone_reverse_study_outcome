package com.obric.oui.constraintlayout.core.widgets;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes34.dex */
public final class e extends i {
    public int K0;
    public int L0;
    public int M0;
    public int N0;
    public int O0;
    public int P0;
    public float Q0;
    public float R0;
    public float S0;
    public float T0;
    public float U0;
    public float V0;
    public int W0;
    public int X0;
    public int Y0;
    public int Z0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public int f399836a1;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public int f399837b1;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public int f399838c1;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public final ArrayList<a> f399839d1;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public ConstraintWidget[] f399840e1;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public ConstraintWidget[] f399841f1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public int[] f399842g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public ConstraintWidget[] f399843h1;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public int f399844i1;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f399845a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ConstraintWidget f399846b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f399847c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ConstraintAnchor f399848d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ConstraintAnchor f399849e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ConstraintAnchor f399850f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ConstraintAnchor f399851g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f399852h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f399853i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f399854j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f399855k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f399856l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f399857m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f399858n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f399859o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f399860p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f399861q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final /* synthetic */ e f399862r;

        public final int c() {
            if (this.f399845a != 1) goto L7;
            return this.f399857m - this.f399862r.X0;
        L7:
            return this.f399857m;
        }

        public final int d() {
            if (this.f399845a != 0) goto L7;
            return this.f399856l - this.f399862r.W0;
        L7:
            return this.f399856l;
        }

        public final void a(ConstraintWidget r100) {
            int r101 = 0;
            if (this.f399845a != 0) goto L16;
            int r102 = this.f399862r.X(r100, this.f399861q);
            if (r100.W[0] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L7;
            this.f399860p++;
            r102 = 0;
        L7:
            e r103 = this.f399862r;
            int r104 = r103.W0;
            if (r100.f399722k0 == 8) goto L11;
            r101 = r104;
        L11:
            this.f399856l += r102 + r101;
            int r105 = r103.W(r100, this.f399861q);
            if (this.f399846b != null) goto L14;
        L15:
            this.f399846b = r100;
            this.f399847c = r105;
            this.f399857m = r105;
        L28:
            this.f399859o++;
            return;
        L14:
            if (this.f399847c >= r105) goto L28;
        L16:
            int r106 = this.f399862r.X(r100, this.f399861q);
            int r107 = this.f399862r.W(r100, this.f399861q);
            if (r100.W[1] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L19;
            this.f399860p++;
            r107 = 0;
        L19:
            int r108 = this.f399862r.X0;
            if (r100.f399722k0 == 8) goto L23;
            r101 = r108;
        L23:
            this.f399857m += r107 + r101;
            if (this.f399846b != null) goto L26;
        L27:
            this.f399846b = r100;
            this.f399847c = r106;
            this.f399856l = r106;
            goto L28
        L26:
            if (this.f399847c >= r106) goto L28;
            goto L27
        }

        public final void e(int r110) {
            int r100 = this.f399860p;
            if (r100 != 0) goto L5;
            return;
        L5:
            int r101 = this.f399859o;
            int r111 = r110 / r100;
            int r102 = 0;
        L6:
            if (r102 >= r101) goto L25;
            int r103 = this.f399858n;
            int r104 = r103 + r102;
            e r105 = this.f399862r;
            if (r104 >= r105.f399844i1) goto L25;
            ConstraintWidget r106 = r105.f399843h1[r103 + r102];
            if (this.f399845a != 0) goto L18;
            if (r106 == null) goto L24;
            ConstraintWidget.DimensionBehaviour[] r107 = r106.W;
            if (r107[0] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
            if (r106.f399739t != 0) goto L24;
            r105.V(r106, ConstraintWidget.DimensionBehaviour.FIXED, r111, r107[1], r106.n());
        L24:
            r102 = r102 + 1;
            goto L6
        L18:
            if (r106 == null) goto L24;
            ConstraintWidget.DimensionBehaviour[] r108 = r106.W;
            if (r108[1] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
            if (r106.f399741u != 0) goto L24;
            r105.V(r106, r108[0], r106.t(), ConstraintWidget.DimensionBehaviour.FIXED, r111);
        L25:
            this.f399856l = 0;
            this.f399857m = 0;
            this.f399846b = null;
            this.f399847c = 0;
            int r112 = this.f399859o;
            int r109 = 0;
        L26:
            if (r109 >= r112) goto L49;
            int r113 = this.f399858n + r109;
            e r114 = this.f399862r;
            if (r113 >= r114.f399844i1) goto L66;
            ConstraintWidget r115 = r114.f399843h1[r113];
            if (this.f399845a != 0) goto L40;
            int r116 = r115.t();
            e r117 = this.f399862r;
            int r118 = r117.W0;
            if (r115.f399722k0 != 8) goto L35;
            r118 = 0;
        L35:
            this.f399856l += r116 + r118;
            int r119 = r117.W(r115, this.f399861q);
            if (this.f399846b != null) goto L38;
        L39:
            this.f399846b = r115;
            this.f399847c = r119;
            this.f399857m = r119;
        L48:
            r109 = r109 + 1;
            goto L26
        L38:
            if (this.f399847c >= r119) goto L48;
        L40:
            int r120 = r114.X(r115, this.f399861q);
            int r121 = this.f399862r.W(r115, this.f399861q);
            int r122 = this.f399862r.X0;
            if (r115.f399722k0 != 8) goto L43;
            r122 = 0;
        L43:
            this.f399857m += r121 + r122;
            if (this.f399846b != null) goto L46;
        L47:
            this.f399846b = r115;
            this.f399847c = r120;
            this.f399856l = r120;
            goto L48
        L46:
            if (this.f399847c >= r120) goto L48;
        L66:
            return;
        }

        public final void b(boolean r110, int r111, boolean r112) {
            int r100 = this.f399859o;
            int r101 = 0;
        L3:
            if (r101 >= r100) goto L11;
            int r102 = this.f399858n + r101;
            e r103 = this.f399862r;
            if (r102 >= r103.f399844i1) goto L11;
            ConstraintWidget r104 = r103.f399843h1[r102];
            if (r104 == null) goto L10;
            r104.G();
        L10:
            r101 = r101 + 1;
        L11:
            if (r100 != 0) goto L13;
            return;
        L13:
            if (this.f399846b == null) goto L226;
            if (r112 == false) goto L18;
            if (r111 != 0) goto L18;
            boolean r105 = true;
        L19:
            int r106 = 0;
            int r107 = -1;
            int r108 = -1;
        L20:
            if (r106 >= r100) goto L35;
            if (r110 == false) goto L23;
            int r109 = (r100 - 1) - r106;
        L24:
            int r113 = this.f399858n + r109;
            e r114 = this.f399862r;
            if (r113 >= r114.f399844i1) goto L35;
            ConstraintWidget r115 = r114.f399843h1[r113];
            if (r115 == null) goto L34;
            if (r115.f399722k0 != 0) goto L34;
            if (r107 != (-1)) goto L33;
            r107 = r106;
        L33:
            r108 = r106;
        L34:
            r106 = r106 + 1;
            goto L20
        L23:
            r109 = r106;
        L35:
            ConstraintWidget r116 = null;
            if (this.f399845a != 0) goto L130;
            ConstraintWidget r117 = this.f399846b;
            e r118 = this.f399862r;
            r117.f399732p0 = r118.L0;
            int r119 = this.f399853i;
            if (r111 <= 0) goto L40;
            r119 = r119 + r118.X0;
        L40:
            r117.M.a(this.f399849e, r119);
            if (r112 == false) goto L43;
            r117.O.a(this.f399851g, this.f399855k);
        L43:
            if (r111 <= 0) goto L46;
            this.f399849e.f399692d.O.a(r117.M, 0);
        L46:
            if (this.f399862r.Z0 == 3) goto L48;
        L61:
            ConstraintWidget r120 = r117;
        L62:
            int r121 = 0;
        L63:
            if (r121 >= r100) goto L227;
            if (r110 == false) goto L66;
            int r122 = (r100 - 1) - r121;
        L67:
            int r123 = this.f399858n + r122;
            e r124 = this.f399862r;
            if (r123 >= r124.f399844i1) goto L228;
            ConstraintWidget r125 = r124.f399843h1[r123];
            if (r125 == null) goto L129;
            if (r121 != 0) goto L75;
            r125.h(r125.L, this.f399848d, this.f399852h);
        L75:
            if (r122 != 0) goto L97;
            e r126 = this.f399862r;
            int r127 = r126.K0;
            if (r110 == false) goto L79;
            float r128 = 1.0f - r126.Q0;
        L81:
            if (this.f399858n != 0) goto L87;
            int r129 = r126.M0;
            if (r129 == (-1)) goto L87;
            if (r110 == false) goto L86;
            float r130 = r126.S0;
        L92:
            r127 = r129;
            r128 = 1.0f - r130;
        L95:
            r125.f399730o0 = r127;
            r125.f399716h0 = r128;
            goto L97
        L86:
            float r131 = r126.S0;
        L94:
            r127 = r129;
            r128 = r131;
        L87:
            if (r112 == false) goto L95;
            r129 = r126.O0;
            if (r129 == (-1)) goto L95;
            if (r110 == false) goto L93;
            r130 = r126.U0;
            goto L92
        L93:
            r131 = r126.U0;
            goto L94
        L79:
            r128 = r126.Q0;
        L97:
            if (r121 != (r100 - 1)) goto L99;
            r125.h(r125.N, this.f399850f, this.f399854j);
        L99:
            if (r116 == null) goto L110;
            r125.L.a(r116.N, this.f399862r.W0);
            if (r121 != r107) goto L105;
            ConstraintAnchor r132 = r125.L;
            int r133 = this.f399852h;
            if (r132.h() == false) goto L105;
            r132.f399696h = r133;
        L105:
            r116.N.a(r125.L, 0);
            if (r121 != (r108 + 1)) goto L110;
            ConstraintAnchor r134 = r116.N;
            int r135 = this.f399854j;
            if (r134.h() == false) goto L110;
            r134.f399696h = r135;
        L110:
            if (r125 == r117) goto L127;
            int r136 = this.f399862r.Z0;
            if (r136 == 3) goto L114;
        L119:
            if (r136 != 0) goto L121;
            r125.M.a(r117.M, 0);
            goto L127
        L121:
            if (r136 == 1) goto L125;
            if (r105 == false) goto L124;
            r125.M.a(this.f399849e, this.f399853i);
            r125.O.a(this.f399851g, this.f399855k);
            goto L127
        L124:
            r125.M.a(r117.M, 0);
            r125.O.a(r117.O, 0);
            goto L127
        L125:
            r125.O.a(r117.O, 0);
            goto L127
        L114:
            if (r120.G == false) goto L119;
            if (r125 == r120) goto L119;
            if (r125.G == false) goto L119;
            r125.P.a(r120.P, 0);
        L127:
            r116 = r125;
        L129:
            r121 = r121 + 1;
            goto L63
        L228:
            return;
        L66:
            r122 = r121;
            goto L67
        L227:
            return;
        L48:
            if (r117.G == true) goto L61;
            int r137 = 0;
        L50:
            if (r137 >= r100) goto L61;
            if (r110 == false) goto L53;
            int r138 = (r100 - 1) - r137;
        L54:
            int r139 = this.f399858n + r138;
            e r140 = this.f399862r;
            if (r139 >= r140.f399844i1) goto L61;
            r120 = r140.f399843h1[r139];
            if (r120.G == true) goto L62;
            r137 = r137 + 1;
            goto L50
        L53:
            r138 = r137;
            goto L54
        L130:
            ConstraintWidget r141 = this.f399846b;
            e r142 = this.f399862r;
            r141.f399730o0 = r142.K0;
            int r143 = this.f399852h;
            if (r111 <= 0) goto L133;
            r143 = r143 + r142.W0;
        L133:
            if (r110 == false) goto L139;
            r141.N.a(this.f399850f, r143);
            if (r112 == false) goto L137;
            r141.L.a(this.f399848d, this.f399854j);
        L137:
            if (r111 <= 0) goto L144;
            this.f399850f.f399692d.L.a(r141.N, 0);
        L144:
            int r144 = 0;
        L145:
            if (r144 >= r100) goto L229;
            int r145 = this.f399858n + r144;
            e r146 = this.f399862r;
            if (r145 >= r146.f399844i1) goto L230;
            ConstraintWidget r147 = r146.f399843h1[r145];
            if (r147 == null) goto L204;
            if (r144 != 0) goto L165;
            r147.h(r147.M, this.f399849e, this.f399853i);
            e r148 = this.f399862r;
            int r149 = r148.L0;
            float r150 = r148.R0;
            if (this.f399858n != 0) goto L159;
            int r151 = r148.N0;
            if (r151 == (-1)) goto L159;
            float r152 = r148.T0;
        L158:
            r150 = r152;
            r149 = r151;
        L163:
            r147.f399732p0 = r149;
            r147.f399718i0 = r150;
        L159:
            if (r112 == false) goto L163;
            r151 = r148.P0;
            if (r151 == (-1)) goto L163;
            r152 = r148.V0;
        L165:
            if (r144 != (r100 - 1)) goto L167;
            r147.h(r147.O, this.f399851g, this.f399855k);
        L167:
            if (r116 == null) goto L178;
            r147.M.a(r116.O, this.f399862r.X0);
            if (r144 != r107) goto L173;
            ConstraintAnchor r153 = r147.M;
            int r154 = this.f399853i;
            if (r153.h() == false) goto L173;
            r153.f399696h = r154;
        L173:
            r116.O.a(r147.M, 0);
            if (r144 != (r108 + 1)) goto L178;
            ConstraintAnchor r155 = r116.O;
            int r156 = this.f399855k;
            if (r155.h() == false) goto L178;
            r155.f399696h = r156;
        L178:
            if (r147 == r141) goto L203;
            if (r110 == false) goto L190;
            int r157 = this.f399862r.Y0;
            if (r157 != 0) goto L184;
            r147.N.a(r141.N, 0);
            goto L203
        L184:
            if (r157 == 1) goto L188;
            if (r157 != 2) goto L203;
            r147.L.a(r141.L, 0);
            r147.N.a(r141.N, 0);
            goto L203
        L188:
            r147.L.a(r141.L, 0);
            goto L203
        L190:
            int r158 = this.f399862r.Y0;
            if (r158 != 0) goto L193;
            r147.L.a(r141.L, 0);
            goto L203
        L193:
            if (r158 == 1) goto L199;
            if (r158 != 2) goto L203;
            if (r105 == false) goto L198;
            r147.L.a(this.f399848d, this.f399852h);
            r147.N.a(this.f399850f, this.f399854j);
            goto L203
        L198:
            r147.L.a(r141.L, 0);
            r147.N.a(r141.N, 0);
            goto L203
        L199:
            r147.N.a(r141.N, 0);
        L203:
            r116 = r147;
        L204:
            r144 = r144 + 1;
            goto L145
        L230:
            return;
        L229:
            return;
        L139:
            r141.L.a(this.f399848d, r143);
            if (r112 == false) goto L142;
            r141.N.a(this.f399850f, this.f399854j);
        L142:
            if (r111 <= 0) goto L144;
            this.f399848d.f399692d.N.a(r141.L, 0);
        L18:
            r105 = false;
            goto L19
        }

        public a(e r100, int r101, ConstraintAnchor r102, ConstraintAnchor r103, ConstraintAnchor r104, ConstraintAnchor r105, int r106) {
            this.f399862r = r100;
            this.f399846b = null;
            this.f399847c = 0;
            this.f399852h = 0;
            this.f399853i = 0;
            this.f399854j = 0;
            this.f399855k = 0;
            this.f399856l = 0;
            this.f399857m = 0;
            this.f399858n = 0;
            this.f399859o = 0;
            this.f399860p = 0;
            this.f399861q = 0;
            this.f399845a = r101;
            this.f399848d = r102;
            this.f399849e = r103;
            this.f399850f = r104;
            this.f399851g = r105;
            this.f399852h = r100.D0;
            this.f399853i = r100.f399868z0;
            this.f399854j = r100.E0;
            this.f399855k = r100.A0;
            this.f399861q = r106;
        }

        public final void f(int r100, ConstraintAnchor r101, ConstraintAnchor r102, ConstraintAnchor r103, ConstraintAnchor r104, int r105, int r106, int r107, int r108, int r110) {
            this.f399845a = r100;
            this.f399848d = r101;
            this.f399849e = r102;
            this.f399850f = r103;
            this.f399851g = r104;
            this.f399852h = r105;
            this.f399853i = r106;
            this.f399854j = r107;
            this.f399855k = r108;
            this.f399861q = r110;
        }
    }

    public e() {
        this.K0 = -1;
        this.L0 = -1;
        this.M0 = -1;
        this.N0 = -1;
        this.O0 = -1;
        this.P0 = -1;
        this.Q0 = 0.5f;
        this.R0 = 0.5f;
        this.S0 = 0.5f;
        this.T0 = 0.5f;
        this.U0 = 0.5f;
        this.V0 = 0.5f;
        this.W0 = 0;
        this.X0 = 0;
        this.Y0 = 2;
        this.Z0 = 2;
        this.f399836a1 = 0;
        this.f399837b1 = -1;
        this.f399838c1 = 0;
        this.f399839d1 = new ArrayList();
        this.f399840e1 = null;
        this.f399841f1 = null;
        this.f399842g1 = null;
        this.f399844i1 = 0;
    }

    public final int W(ConstraintWidget r110, int r111) {
        if (r110 != null) goto L6;
        return 0;
    L6:
        if (r110.W[1] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
        int r100 = r110.f399741u;
        if (r100 != 0) goto L11;
        return 0;
    L11:
        if (r100 != 2) goto L16;
        int r112 = (int) (r110.B * r111);
        if (r112 == r110.n()) goto L15;
        r110.f399713g = true;
        V(r110, r110.W[0], r110.t(), ConstraintWidget.DimensionBehaviour.FIXED, r112);
    L15:
        return r112;
    L16:
        if (r100 != 1) goto L20;
        return r110.n();
    L20:
        if (r100 != 3) goto L24;
        return (int) ((r110.t() * r110.f399702a0) + 0.5f);
    L24:
        return r110.n();
    }

    public final int X(ConstraintWidget r110, int r111) {
        if (r110 != null) goto L6;
        return 0;
    L6:
        if (r110.W[0] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L24;
        int r100 = r110.f399739t;
        if (r100 != 0) goto L11;
        return 0;
    L11:
        if (r100 != 2) goto L16;
        int r112 = (int) (r110.f399748y * r111);
        if (r112 == r110.t()) goto L15;
        r110.f399713g = true;
        V(r110, ConstraintWidget.DimensionBehaviour.FIXED, r112, r110.W[1], r110.n());
    L15:
        return r112;
    L16:
        if (r100 != 1) goto L20;
        return r110.t();
    L20:
        if (r100 != 3) goto L24;
        return (int) ((r110.n() * r110.f399702a0) + 0.5f);
    L24:
        return r110.t();
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public final void d(com.obric.oui.constraintlayout.core.c r110, boolean r111) {
        super.d(r110, r111);
        ConstraintWidget r112 = this.X;
        if (r112 != null) goto L5;
    L7:
        boolean r113 = false;
    L8:
        int r100 = this.f399836a1;
        if (r100 == 0) goto L102;
        if (r100 != 1) goto L12;
        int r101 = this.f399839d1.size();
        int r102 = 0;
    L95:
        if (r102 >= r101) goto L104;
        a r103 = (a) ListProtector.get(this.f399839d1, r102);
        if (r102 != (r101 - 1)) goto L99;
        boolean r104 = true;
    L100:
        r103.b(r113, r102, r104);
        r102 = r102 + 1;
        goto L95
    L99:
        r104 = false;
    L104:
        this.F0 = false;
        return;
    L12:
        if (r100 == 2) goto L24;
        if (r100 != 3) goto L104;
        int r105 = this.f399839d1.size();
        int r106 = 0;
    L17:
        if (r106 >= r105) goto L104;
        a r107 = (a) ListProtector.get(this.f399839d1, r106);
        if (r106 != (r105 - 1)) goto L21;
        boolean r108 = true;
    L22:
        r107.b(r113, r106, r108);
        r106 = r106 + 1;
        goto L17
    L21:
        r108 = false;
        goto L22
    L24:
        if (this.f399842g1 == null) goto L104;
        if (this.f399841f1 == null) goto L104;
        if (this.f399840e1 == null) goto L104;
        int r109 = 0;
    L32:
        if (r109 >= this.f399844i1) goto L34;
        this.f399843h1[r109].G();
        r109 = r109 + 1;
        goto L32
    L34:
        int[] r114 = this.f399842g1;
        int r115 = r114[0];
        int r116 = r114[1];
        float r117 = this.Q0;
        ConstraintWidget r118 = null;
        int r119 = 0;
    L36:
        if (r119 >= r115) goto L55;
        if (r113 == false) goto L39;
        int r120 = (r115 - r119) - 1;
        float r121 = 1.0f - this.Q0;
    L40:
        ConstraintWidget r122 = this.f399841f1[r120];
        if (r122 == null) goto L54;
        if (r122.f399722k0 == 8) goto L54;
        if (r119 != 0) goto L48;
        r122.h(r122.L, this.L, this.D0);
        r122.f399730o0 = this.K0;
        r122.f399716h0 = r121;
    L48:
        if (r119 != (r115 - 1)) goto L50;
        r122.h(r122.N, this.N, this.E0);
    L50:
        if (r119 <= 0) goto L53;
        if (r118 == null) goto L53;
        r122.h(r122.L, r118.N, this.W0);
        r118.h(r118.N, r122.L, 0);
    L53:
        r118 = r122;
    L54:
        r119 = r119 + 1;
        r117 = r121;
        goto L36
    L39:
        r121 = r117;
        r120 = r119;
        goto L40
    L55:
        int r123 = 0;
    L56:
        if (r123 >= r116) goto L72;
        ConstraintWidget r124 = this.f399840e1[r123];
        if (r124 == null) goto L71;
        if (r124.f399722k0 == 8) goto L71;
        if (r123 != 0) goto L65;
        r124.h(r124.M, this.M, this.f399868z0);
        r124.f399732p0 = this.L0;
        r124.f399718i0 = this.R0;
    L65:
        if (r123 != (r116 - 1)) goto L67;
        r124.h(r124.O, this.O, this.A0);
    L67:
        if (r123 <= 0) goto L70;
        if (r118 == null) goto L70;
        r124.h(r124.M, r118.O, this.X0);
        r118.h(r118.O, r124.M, 0);
    L70:
        r118 = r124;
    L71:
        r123 = r123 + 1;
        goto L56
    L72:
        int r125 = 0;
    L73:
        if (r125 >= r115) goto L104;
        int r126 = 0;
    L75:
        if (r126 >= r116) goto L93;
        int r127 = (r126 * r115) + r125;
        if (this.f399838c1 != 1) goto L79;
        r127 = (r125 * r116) + r126;
    L79:
        ConstraintWidget[] r128 = this.f399843h1;
        if (r127 >= r128.length) goto L92;
        ConstraintWidget r129 = r128[r127];
        if (r129 == null) goto L92;
        if (r129.f399722k0 == 8) goto L92;
        ConstraintWidget r130 = this.f399841f1[r125];
        ConstraintWidget r131 = this.f399840e1[r126];
        if (r129 == r130) goto L90;
        r129.h(r129.L, r130.L, 0);
        r129.h(r129.N, r130.N, 0);
    L90:
        if (r129 == r131) goto L92;
        r129.h(r129.M, r131.M, 0);
        r129.h(r129.O, r131.O, 0);
    L92:
        r126 = r126 + 1;
        goto L75
    L93:
        r125 = r125 + 1;
        goto L73
    L102:
        if (this.f399839d1.size() <= 0) goto L104;
        ((a) ListProtector.get(this.f399839d1, 0)).b(r113, 0, true);
        goto L104
    L5:
        if (((d) r112).C0 == false) goto L7;
        r113 = true;
        goto L8
    }

    @Override // ula.b, com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public final void i(ConstraintWidget r100, HashMap<ConstraintWidget, ConstraintWidget> r101) {
        super.i(r100, r101);
        e r102 = (e) r100;
        this.K0 = r102.K0;
        this.L0 = r102.L0;
        this.M0 = r102.M0;
        this.N0 = r102.N0;
        this.O0 = r102.O0;
        this.P0 = r102.P0;
        this.Q0 = r102.Q0;
        this.R0 = r102.R0;
        this.S0 = r102.S0;
        this.T0 = r102.T0;
        this.U0 = r102.U0;
        this.V0 = r102.V0;
        this.W0 = r102.W0;
        this.X0 = r102.X0;
        this.Y0 = r102.Y0;
        this.Z0 = r102.Z0;
        this.f399836a1 = r102.f399836a1;
        this.f399837b1 = r102.f399837b1;
        this.f399838c1 = r102.f399838c1;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:291:0x04f3 -> B:292:0x04fe). Please report as a decompilation issue!!! */
    @Override // com.obric.oui.constraintlayout.core.widgets.i
    public final void U(int r310, int r311, int r312, int r313) {
        if (this.f550643y0 <= 0) goto L44;
        ConstraintWidget r100 = this.X;
        if (r100 == null) goto L7;
        com.obric.oui.constraintlayout.core.widgets.analyzer.b.InterfaceC4669b r101 = ((d) r100).B0;
    L8:
        if (r101 != null) goto L10;
        boolean r102 = false;
    L41:
        if (r102 == true) goto L44;
        this.G0 = 0;
        this.H0 = 0;
        this.F0 = false;
        return;
    L10:
        int r103 = 0;
    L12:
        if (r103 >= this.f550643y0) goto L40;
        ConstraintWidget r104 = this.f550642x0[r103];
        if (r104 == null) goto L39;
        if ((r104 instanceof f) == true) goto L39;
        ConstraintWidget.DimensionBehaviour r105 = r104.m(0);
        ConstraintWidget.DimensionBehaviour r106 = r104.m(1);
        ConstraintWidget.DimensionBehaviour r107 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r105 == r107) goto L22;
    L27:
        boolean r108 = false;
    L28:
        if (r108 == true) goto L39;
        if (r105 != r107) goto L32;
        r105 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
    L32:
        if (r106 != r107) goto L34;
        r106 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
    L34:
        com.obric.oui.constraintlayout.core.widgets.analyzer.b.a r109 = this.I0;
        r109.f399782a = r105;
        r109.f399783b = r106;
        r109.f399784c = r104.t();
        this.I0.f399785d = r104.n();
        ((ConstraintLayout.b) r101).b(r104, this.I0);
        r104.Q(this.I0.f399786e);
        r104.N(this.I0.f399787f);
        int r110 = this.I0.f399788g;
        r104.f399710e0 = r110;
        if (r110 <= 0) goto L37;
        boolean r111 = true;
    L38:
        r104.G = r111;
        goto L39
    L37:
        r111 = false;
        goto L38
    L22:
        if (r104.f399739t == 1) goto L27;
        if (r106 != r107) goto L27;
        if (r104.f399741u == 1) goto L27;
        r108 = true;
    L39:
        r103 = r103 + 1;
        goto L12
    L40:
        r102 = true;
        goto L41
    L7:
        r101 = null;
    L44:
        int r112 = this.D0;
        int r113 = this.E0;
        int r114 = this.f399868z0;
        int r115 = this.A0;
        int[] r116 = new int[2];
        int r117 = (r311 - r112) - r113;
        int r118 = this.f399838c1;
        if (r118 != 1) goto L47;
        r117 = (r313 - r114) - r115;
    L47:
        int r119 = r117;
        if (r118 != 0) goto L56;
        if (this.K0 != (-1)) goto L53;
        this.K0 = 0;
    L53:
        if (this.L0 != (-1)) goto L61;
        this.L0 = 0;
    L61:
        ConstraintWidget[] r120 = this.f550642x0;
        int r121 = 0;
        int r122 = 0;
    L62:
        int r123 = this.f550643y0;
        if (r121 >= r123) goto L68;
        if (this.f550642x0[r121].f399722k0 != 8) goto L67;
        r122 = r122 + 1;
    L67:
        r121 = r121 + 1;
        goto L62
    L68:
        if (r122 <= 0) goto L76;
        r120 = new ConstraintWidget[r123 - r122];
        int r124 = 0;
        r123 = 0;
    L71:
        if (r124 >= this.f550643y0) goto L76;
        ConstraintWidget r125 = this.f550642x0[r124];
        if (r125.f399722k0 == 8) goto L75;
        r120[r123] = r125;
        r123 = r123 + 1;
    L75:
        r124 = r124 + 1;
    L76:
        ConstraintWidget[] r126 = r120;
        this.f399843h1 = r126;
        this.f399844i1 = r123;
        int r127 = this.f399836a1;
        if (r127 == 0) goto L389;
        if (r127 == 1) goto L294;
        if (r127 != 2) goto L81;
        int r128 = r123;
        int r129 = this.f399838c1;
        if (r129 != 0) goto L197;
        int r130 = this.f399837b1;
        if (r130 > 0) goto L196;
        int r131 = 0;
        int r132 = 0;
        int r133 = 0;
    L184:
        if (r131 >= r128) goto L195;
        if (r131 <= 0) goto L187;
        r132 = r132 + this.W0;
    L187:
        ConstraintWidget r134 = r126[r131];
        if (r134 == null) goto L194;
        r132 = r132 + X(r134, r119);
        if (r132 > r119) goto L195;
        r133 = r133 + 1;
    L194:
        r131 = r131 + 1;
    L195:
        r130 = r133;
    L196:
        int r135 = r130;
        int r136 = 0;
    L214:
        if (this.f399842g1 != null) goto L216;
        this.f399842g1 = new int[2];
    L216:
        if (r136 == 0) goto L218;
    L219:
        if (r135 != 0) goto L222;
        if (r129 != 0) goto L222;
    L221:
        int r137 = r313;
        int r138 = r129;
        int r139 = r136;
        int r140 = r135;
        e r141 = this;
        ConstraintWidget[] r142 = r126;
        int r143 = r113;
        int r144 = r115;
        int[] r145 = r116;
        int r146 = r310;
        int r147 = r311;
        int r148 = r312;
        e r149 = r141;
    L292:
        int r150 = r146;
        int r151 = r147;
        int r152 = r148;
        int r153 = r137;
        int r154 = r138;
        int r155 = r139;
        int r156 = r140;
        ConstraintWidget[] r157 = r142;
        boolean r158 = true;
    L223:
        if (r158 == true) goto L293;
        if (r154 != 0) goto L226;
        r155 = (int) Math.ceil(r128 / r156);
    L227:
        ConstraintWidget[] r159 = r149.f399841f1;
        if (r159 != null) goto L230;
    L233:
        r149.f399841f1 = new ConstraintWidget[r156];
    L234:
        ConstraintWidget[] r160 = r149.f399840e1;
        if (r160 != null) goto L237;
    L240:
        r149.f399840e1 = new ConstraintWidget[r155];
    L241:
        int r161 = 0;
    L242:
        if (r161 >= r156) goto L266;
        int r162 = 0;
    L244:
        if (r162 >= r155) goto L265;
        int r163 = (r162 * r156) + r161;
        int r314 = r152;
        if (r154 != 1) goto L248;
        r163 = (r161 * r155) + r162;
    L248:
        int r315 = r153;
        int r164 = r163;
        if (r164 < r157.length) goto L251;
    L250:
        ConstraintWidget[] r165 = r157;
    L264:
        r162 = r162 + 1;
        r152 = r314;
        r153 = r315;
        r157 = r165;
        goto L244
    L251:
        ConstraintWidget r166 = r157[r164];
        if (r166 == null) goto L250;
        int r167 = r149.X(r166, r119);
        r165 = r157;
        ConstraintWidget r168 = r149.f399841f1[r161];
        if (r168 != null) goto L257;
    L258:
        r149.f399841f1[r161] = r166;
    L259:
        int r169 = r149.W(r166, r119);
        ConstraintWidget r170 = r149.f399840e1[r162];
        if (r170 != null) goto L262;
    L263:
        r149.f399840e1[r162] = r166;
        goto L264
    L262:
        if (r170.n() >= r169) goto L264;
    L257:
        if (r168.t() >= r167) goto L259;
    L265:
        r161 = r161 + 1;
        goto L242
    L266:
        int r316 = r152;
        int r317 = r153;
        r142 = r157;
        int r171 = 0;
        int r172 = 0;
    L267:
        if (r171 >= r156) goto L274;
        ConstraintWidget r173 = r149.f399841f1[r171];
        if (r173 == null) goto L273;
        if (r171 <= 0) goto L272;
        r172 = r172 + r149.W0;
    L272:
        r172 = r172 + r149.X(r173, r119);
    L273:
        r171 = r171 + 1;
        goto L267
    L274:
        int r174 = 0;
        int r175 = 0;
    L275:
        if (r174 >= r155) goto L282;
        ConstraintWidget r176 = r149.f399840e1[r174];
        if (r176 == null) goto L281;
        if (r174 <= 0) goto L280;
        r175 = r175 + r149.X0;
    L280:
        r175 = r175 + r149.W(r176, r119);
    L281:
        r174 = r174 + 1;
        goto L275
    L282:
        r116[0] = r172;
        r116[1] = r175;
        if (r154 != 0) goto L287;
        if (r172 <= r119) goto L291;
        if (r156 <= 1) goto L291;
        r156 = r156 - 1;
    L290:
        r150 = r150;
        r151 = r151;
        r152 = r316;
        r153 = r317;
        r157 = r142;
    L291:
        r146 = r150;
        r147 = r151;
        r148 = r316;
        r140 = r156;
        r139 = r155;
        r138 = r154;
        r137 = r317;
        goto L292
    L287:
        if (r175 <= r119) goto L291;
        if (r155 <= 1) goto L291;
        r155 = r155 - 1;
        goto L290
    L237:
        if (r160.length < r155) goto L240;
        Arrays.fill(r160, null);
        goto L241
    L230:
        if (r159.length < r156) goto L233;
        Arrays.fill(r159, null);
        goto L234
    L226:
        r156 = (int) Math.ceil(r128 / r155);
        goto L227
    L293:
        int r318 = r151;
        int[] r177 = r149.f399842g1;
        r177[0] = r156;
        r177[1] = r155;
        int r178 = r150;
        int r179 = r318;
        int r180 = r152;
        int r181 = r112;
        int r182 = r114;
    L392:
        int r183 = r153;
        e r184 = r141;
        char r185 = 0;
        int r186 = r180;
        int r187 = r179;
        char r188 = 1;
    L401:
        int r189 = (r145[r185] + r181) + r143;
        int r190 = (r145[r188] + r182) + r144;
        if (r178 != 1073741824) goto L404;
        int r191 = r187;
    L409:
        if (r186 != 1073741824) goto L411;
        int r192 = r183;
    L416:
        r184.G0 = r191;
        r184.H0 = r192;
        r184.Q(r191);
        r184.N(r192);
        if (r184.f550643y0 <= 0) goto L419;
        boolean r193 = true;
    L420:
        r184.F0 = r193;
        return;
    L419:
        r193 = false;
        goto L420
    L411:
        if (r186 != Integer.MIN_VALUE) goto L413;
        r192 = Math.min(r190, r183);
        goto L416
    L413:
        if (r186 != 0) goto L415;
        r192 = r190;
        goto L416
    L415:
        r192 = 0;
        goto L416
    L404:
        if (r178 != Integer.MIN_VALUE) goto L406;
        r191 = Math.min(r189, r187);
        goto L409
    L406:
        if (r178 != 0) goto L408;
        r191 = r189;
        goto L409
    L408:
        r191 = 0;
    L222:
        r150 = r310;
        r154 = r129;
        r155 = r136;
        r156 = r135;
        r141 = this;
        r157 = r126;
        r143 = r113;
        r144 = r115;
        r145 = r116;
        r158 = false;
        r151 = r311;
        r152 = r312;
        r153 = r313;
        r149 = r141;
        goto L223
    L218:
        if (r129 == 1) goto L221;
    L197:
        r136 = this.f399837b1;
        if (r136 > 0) goto L212;
        int r194 = 0;
        int r195 = 0;
        int r196 = 0;
    L200:
        if (r194 >= r128) goto L211;
        if (r194 <= 0) goto L203;
        r195 = r195 + this.X0;
    L203:
        ConstraintWidget r197 = r126[r194];
        if (r197 == null) goto L210;
        r195 = r195 + W(r197, r119);
        if (r195 > r119) goto L211;
        r196 = r196 + 1;
    L210:
        r194 = r194 + 1;
    L211:
        r136 = r196;
    L212:
        r135 = 0;
        goto L214
    L81:
        if (r127 != 3) goto L85;
        int r198 = this.f399838c1;
        if (r123 == 0) goto L85;
        this.f399839d1.clear();
        int r210 = r112;
        int r199 = r123;
        int r211 = r119;
        a r200 = new a(this, r198, this.L, this.M, this.N, this.O, r211);
        this.f399839d1.add(r200);
        if (r198 != 0) goto L115;
        a r201 = r200;
        int r202 = 0;
        int r203 = 0;
        int r204 = 0;
        int r205 = 0;
    L89:
        if (r205 >= r199) goto L114;
        r202 = r202 + 1;
        ConstraintWidget r206 = r126[r205];
        int r207 = r211;
        int r1100 = X(r206, r207);
        if (r206.W[0] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L93;
        r203 = r203 + 1;
    L93:
        int r1101 = r203;
        if (r204 == r207) goto L98;
        if (((this.W0 + r204) + r1100) > r207) goto L98;
    L100:
        boolean r208 = false;
    L101:
        if (r208 == true) goto L107;
        if (r205 <= 0) goto L107;
        int r209 = this.f399837b1;
        if (r209 <= 0) goto L107;
        if (r202 <= r209) goto L107;
        r208 = true;
    L107:
        if (r208 == false) goto L109;
        int r212 = r113;
        int r319 = r207;
        int r320 = r114;
        ConstraintWidget r1102 = r206;
        a r213 = new a(this, r198, this.L, this.M, this.N, this.O, r319);
        r213.f399858n = r205;
        this.f399839d1.add(r213);
        r201 = r213;
        r204 = r1100;
        r202 = 1;
    L113:
        r201.a(r1102);
        r205 = r205 + 1;
        r203 = r1101;
        r113 = r212;
        r211 = r319;
        r114 = r320;
        goto L89
    L109:
        r319 = r207;
        r212 = r113;
        r320 = r114;
        r1102 = r206;
        if (r205 <= 0) goto L112;
        r204 = r204 + (this.W0 + r1100);
        goto L113
    L112:
        r204 = r1100;
    L98:
        if (r201.f399846b == null) goto L100;
        r208 = true;
        goto L101
    L114:
        int r321 = r114;
        int r322 = r211;
        int r214 = r113;
    L141:
        int r1103 = r322;
        int r323 = r115;
        int r215 = this.f399839d1.size();
        ConstraintAnchor r216 = this.L;
        ConstraintAnchor r217 = this.M;
        ConstraintAnchor r218 = this.N;
        ConstraintAnchor r219 = this.O;
        int r220 = this.D0;
        int r221 = this.f399868z0;
        int r222 = this.E0;
        int r1104 = this.A0;
        ConstraintWidget.DimensionBehaviour[] r1105 = this.W;
        ConstraintWidget.DimensionBehaviour r1106 = r1105[0];
        ConstraintWidget.DimensionBehaviour r1107 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r1106 != r1107) goto L144;
    L147:
        boolean r1108 = true;
    L148:
        if (r203 <= 0) goto L157;
        if (r1108 == false) goto L157;
        int r223 = 0;
    L151:
        if (r223 >= r215) goto L157;
        a r1109 = (a) ListProtector.get(this.f399839d1, r223);
        if (r198 != 0) goto L155;
        r1109.e(r1103 - r1109.d());
    L156:
        r223 = r223 + 1;
        goto L151
    L155:
        r1109.e(r1103 - r1109.c());
    L157:
        int r224 = 0;
        int r1110 = 0;
        int r1111 = 0;
    L158:
        if (r224 >= r215) goto L178;
        a r1112 = (a) ListProtector.get(this.f399839d1, r224);
        if (r198 == 0) goto L162;
        r116 = r116;
        if (r224 >= (r215 - 1)) goto L172;
        r218 = ((a) ListProtector.get(this.f399839d1, r224 + 1)).f399846b.L;
        r222 = 0;
    L173:
        ConstraintAnchor r1113 = r1112.f399846b.N;
        r1112.f(r198, r216, r217, r218, r219, r220, r221, r222, r1104, r1103);
        r1110 = r1110 + r1112.d();
        int r225 = Math.max(r1111, r1112.c());
        if (r224 <= 0) goto L176;
        r1110 = r1110 + this.W0;
    L176:
        r1111 = r225;
        r216 = r1113;
        r220 = 0;
    L177:
        r224 = r224 + 1;
        r116 = r116;
        goto L158
    L172:
        r218 = this.N;
        r222 = this.E0;
        goto L173
    L162:
        if (r224 >= (r215 - 1)) goto L164;
        r219 = ((a) ListProtector.get(this.f399839d1, r224 + 1)).f399846b.M;
        r1104 = 0;
    L165:
        ConstraintAnchor r1114 = r1112.f399846b.O;
        r1112.f(r198, r216, r217, r218, r219, r220, r221, r222, r1104, r1103);
        int r226 = Math.max(r1110, r1112.d());
        r1111 = r1111 + r1112.c();
        if (r224 <= 0) goto L168;
        r1111 = r1111 + this.X0;
    L168:
        r1110 = r226;
        r217 = r1114;
        r221 = 0;
        goto L177
    L164:
        r219 = this.O;
        r1104 = this.A0;
        goto L165
    L178:
        int[] r324 = r116;
        r324[0] = r1110;
        r324[1] = r1111;
    L391:
        r178 = r310;
        r179 = r311;
        r180 = r312;
        r153 = r313;
        r141 = this;
        r181 = r210;
        r143 = r214;
        r144 = r323;
        r182 = r321;
        r145 = r324;
        goto L392
    L144:
        if (r1105[1] == r1107) goto L147;
        r1108 = false;
        goto L148
    L115:
        r321 = r114;
        r322 = r211;
        r214 = r113;
        a r227 = r200;
        int r228 = 0;
        r203 = 0;
        int r229 = 0;
        int r230 = 0;
    L116:
        if (r230 >= r199) goto L141;
        r228 = r228 + 1;
        ConstraintWidget r1115 = r126[r230];
        int r1116 = r322;
        int r1117 = W(r1115, r1116);
        if (r1115.W[1] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L120;
        r203 = r203 + 1;
    L120:
        int r1118 = r203;
        if (r229 == r1116) goto L125;
        if (((this.X0 + r229) + r1117) > r1116) goto L125;
    L127:
        boolean r231 = false;
    L128:
        if (r231 == true) goto L134;
        if (r230 <= 0) goto L134;
        int r232 = this.f399837b1;
        if (r232 <= 0) goto L134;
        if (r228 <= r232) goto L134;
        r231 = true;
    L134:
        if (r231 == false) goto L136;
        int r325 = r115;
        a r233 = new a(this, r198, this.L, this.M, this.N, this.O, r1116);
        r233.f399858n = r230;
        this.f399839d1.add(r233);
        r227 = r233;
        r229 = r1117;
        r228 = 1;
    L140:
        r227.a(r1115);
        r230 = r230 + 1;
        r203 = r1118;
        r115 = r325;
        r322 = r1116;
        goto L116
    L136:
        r325 = r115;
        if (r230 <= 0) goto L139;
        r229 = r229 + (this.X0 + r1117);
        goto L140
    L139:
        r229 = r1117;
    L125:
        if (r227.f399846b == null) goto L127;
        r231 = true;
    L85:
        r210 = r112;
        r214 = r113;
        r321 = r114;
        r323 = r115;
        r324 = r116;
        goto L391
    L294:
        r210 = r112;
        r214 = r113;
        r321 = r114;
        r323 = r115;
        r324 = r116;
        int r1119 = r123;
        int r234 = this.f399838c1;
        if (r1119 == 0) goto L391;
        this.f399839d1.clear();
        a r1120 = new a(this, r234, this.L, this.M, this.N, this.O, r119);
        this.f399839d1.add(r1120);
        if (r234 != 0) goto L325;
        int r235 = 0;
        int r236 = 0;
        int r1121 = 0;
    L300:
        if (r1121 >= r1119) goto L351;
        ConstraintWidget r1122 = r126[r1121];
        int r1123 = X(r1122, r119);
        if (r1122.W[0] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L304;
        r235 = r235 + 1;
    L304:
        int r1124 = r235;
        if (r236 == r119) goto L309;
        if (((this.W0 + r236) + r1123) > r119) goto L309;
    L311:
        boolean r237 = false;
    L312:
        if (r237 == true) goto L319;
        if (r1121 <= 0) goto L319;
        int r238 = this.f399837b1;
        if (r238 <= 0) goto L319;
        if ((r1121 % r238) != 0) goto L319;
        r237 = true;
    L319:
        if (r237 == false) goto L321;
        r1120 = new a(this, r234, this.L, this.M, this.N, this.O, r119);
        r1120.f399858n = r1121;
        this.f399839d1.add(r1120);
    L323:
        r236 = r1123;
    L324:
        r1120.a(r1122);
        r1121 = r1121 + 1;
        r235 = r1124;
        goto L300
    L321:
        if (r1121 <= 0) goto L323;
        r236 = r236 + (this.W0 + r1123);
    L309:
        if (r1120.f399846b == null) goto L311;
        r237 = true;
    L351:
        int r239 = this.f399839d1.size();
        ConstraintAnchor r240 = this.L;
        ConstraintAnchor r241 = this.M;
        ConstraintAnchor r242 = this.N;
        ConstraintAnchor r243 = this.O;
        int r244 = this.D0;
        int r245 = this.f399868z0;
        int r1125 = this.E0;
        int r1126 = this.A0;
        ConstraintWidget.DimensionBehaviour[] r1127 = this.W;
        ConstraintWidget.DimensionBehaviour r1128 = r1127[0];
        ConstraintWidget.DimensionBehaviour r1129 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r1128 != r1129) goto L354;
    L357:
        boolean r1130 = true;
    L358:
        if (r235 <= 0) goto L367;
        if (r1130 == false) goto L367;
        int r246 = 0;
    L361:
        if (r246 >= r239) goto L367;
        a r1131 = (a) ListProtector.get(this.f399839d1, r246);
        if (r234 != 0) goto L365;
        r1131.e(r119 - r1131.d());
    L366:
        r246 = r246 + 1;
        goto L361
    L365:
        r1131.e(r119 - r1131.c());
    L367:
        int r247 = 0;
        int r1132 = 0;
        int r1133 = 0;
    L368:
        if (r247 >= r239) goto L388;
        a r1134 = (a) ListProtector.get(this.f399839d1, r247);
        if (r234 == 0) goto L372;
        r239 = r239;
        if (r247 >= (r239 - 1)) goto L382;
        ConstraintAnchor r248 = ((a) ListProtector.get(this.f399839d1, r247 + 1)).f399846b.L;
        int r249 = 0;
    L383:
        ConstraintAnchor r1135 = r1134.f399846b.N;
        r1134.f(r234, r240, r241, r248, r243, r244, r245, r249, r1126, r119);
        r1132 = r1132 + r1134.d();
        int r250 = Math.max(r1133, r1134.c());
        if (r247 <= 0) goto L386;
        r1132 = r1132 + this.W0;
    L386:
        r1133 = r250;
        r240 = r1135;
        r244 = 0;
        r1125 = r249;
        r242 = r248;
    L387:
        r247 = r247 + 1;
        r239 = r239;
        goto L368
    L382:
        r248 = this.N;
        r249 = this.E0;
        goto L383
    L372:
        if (r247 >= (r239 - 1)) goto L374;
        r243 = ((a) ListProtector.get(this.f399839d1, r247 + 1)).f399846b.M;
        r1126 = 0;
    L375:
        ConstraintAnchor r251 = r1134.f399846b.O;
        r1134.f(r234, r240, r241, r242, r243, r244, r245, r1125, r1126, r119);
        int r252 = Math.max(r1132, r1134.d());
        r1133 = r1133 + r1134.c();
        if (r247 <= 0) goto L378;
        r1133 = r1133 + this.X0;
    L378:
        r1132 = r252;
        r245 = 0;
        r241 = r251;
        goto L387
    L374:
        r243 = this.O;
        r1126 = this.A0;
        goto L375
    L388:
        r324[0] = r1132;
        r324[1] = r1133;
        goto L391
    L354:
        if (r1127[1] == r1129) goto L357;
        r1130 = false;
        goto L358
    L325:
        r235 = 0;
        int r253 = 0;
        int r1136 = 0;
    L326:
        if (r1136 >= r1119) goto L351;
        ConstraintWidget r1137 = r126[r1136];
        int r1138 = W(r1137, r119);
        if (r1137.W[1] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L330;
        r235 = r235 + 1;
    L330:
        int r1139 = r235;
        if (r253 == r119) goto L335;
        if (((this.X0 + r253) + r1138) > r119) goto L335;
    L337:
        boolean r254 = false;
    L338:
        if (r254 == true) goto L345;
        if (r1136 <= 0) goto L345;
        int r255 = this.f399837b1;
        if (r255 <= 0) goto L345;
        if ((r1136 % r255) != 0) goto L345;
        r254 = true;
    L345:
        if (r254 == false) goto L347;
        r1120 = new a(this, r234, this.L, this.M, this.N, this.O, r119);
        r1120.f399858n = r1136;
        this.f399839d1.add(r1120);
    L349:
        r253 = r1138;
    L350:
        r1120.a(r1137);
        r1136 = r1136 + 1;
        r235 = r1139;
        goto L326
    L347:
        if (r1136 <= 0) goto L349;
        r253 = r253 + (this.X0 + r1138);
    L335:
        if (r1120.f399846b == null) goto L337;
        r254 = true;
        goto L338
    L389:
        r210 = r112;
        r214 = r113;
        r321 = r114;
        r323 = r115;
        r324 = r116;
        int r1140 = r123;
        int r256 = this.f399838c1;
        if (r1140 == 0) goto L391;
        if (this.f399839d1.size() != 0) goto L396;
        a r257 = new a(this, r256, this.L, this.M, this.N, this.O, r119);
        this.f399839d1.add(r257);
    L397:
        int r258 = 0;
    L398:
        if (r258 >= r1140) goto L400;
        r257.a(r126[r258]);
        r258 = r258 + 1;
        goto L398
    L400:
        r185 = 0;
        r324[0] = r257.d();
        r188 = 1;
        r324[1] = r257.c();
        r178 = r310;
        r187 = r311;
        r186 = r312;
        r183 = r313;
        r184 = this;
        r181 = r210;
        r143 = r214;
        r144 = r323;
        r182 = r321;
        r145 = r324;
        goto L401
    L396:
        r257 = (a) ListProtector.get(this.f399839d1, 0);
        r257.f399847c = 0;
        r257.f399846b = null;
        r257.f399856l = 0;
        r257.f399857m = 0;
        r257.f399858n = 0;
        r257.f399859o = 0;
        r257.f399860p = 0;
        r257.f(r256, this.L, this.M, this.N, this.O, this.D0, this.f399868z0, this.E0, this.A0, r119);
        goto L397
    L56:
        if (this.K0 != (-1)) goto L59;
        this.K0 = 0;
    L59:
        if (this.L0 != (-1)) goto L61;
        this.L0 = 0;
        goto L61
    }
}
