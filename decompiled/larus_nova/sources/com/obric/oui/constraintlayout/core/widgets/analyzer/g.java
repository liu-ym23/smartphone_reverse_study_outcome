package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes34.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b.a f399803a = null;

    static {
        f399803a = new b.a();
    }

    public static boolean a(ConstraintWidget r100) {
        ConstraintWidget.DimensionBehaviour[] r101 = r100.W;
        ConstraintWidget.DimensionBehaviour r102 = r101[0];
        ConstraintWidget.DimensionBehaviour r103 = r101[1];
        ConstraintWidget r104 = r100.X;
        if (r104 == null) goto L5;
        com.obric.oui.constraintlayout.core.widgets.d r105 = (com.obric.oui.constraintlayout.core.widgets.d) r104;
    L6:
        if (r105 == null) goto L8;
        ConstraintWidget.DimensionBehaviour r106 = r105.W[0];
        ConstraintWidget.DimensionBehaviour r107 = ConstraintWidget.DimensionBehaviour.FIXED;
    L8:
        if (r105 == null) goto L10;
        ConstraintWidget.DimensionBehaviour r108 = r105.W[1];
        ConstraintWidget.DimensionBehaviour r109 = ConstraintWidget.DimensionBehaviour.FIXED;
    L10:
        ConstraintWidget.DimensionBehaviour r110 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r102 != r110) goto L13;
    L31:
        boolean r111 = true;
    L32:
        if (r103 != r110) goto L34;
    L52:
        boolean r112 = true;
    L54:
        if (r100.f399702a0 <= 0.0f) goto L58;
        if (r111 == true) goto L57;
        if (r112 == false) goto L58;
    L57:
        return true;
    L58:
        if (r111 == false) goto L62;
        if (r112 == false) goto L63;
        return true;
    L63:
        return false;
    L62:
        return false;
    L34:
        if (r100.E() == true) goto L52;
        if (r103 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L52;
        ConstraintWidget.DimensionBehaviour r113 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r103 == r113) goto L40;
    L45:
        if (r103 == r113) goto L47;
    L51:
        r112 = false;
        goto L54
    L47:
        if (r100.f399741u != 1) goto L51;
        if (r100.x(1, r100.n()) == false) goto L51;
    L40:
        if (r100.f399741u != 0) goto L45;
        if (r100.f399702a0 != 0.0f) goto L45;
        if (r100.w(1) == true) goto L52;
    L13:
        if (r100.D() == true) goto L31;
        if (r102 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L31;
        ConstraintWidget.DimensionBehaviour r114 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r102 == r114) goto L19;
    L24:
        if (r102 == r114) goto L26;
    L30:
        r111 = false;
        goto L32
    L26:
        if (r100.f399739t != 1) goto L30;
        if (r100.x(0, r100.t()) == false) goto L30;
    L19:
        if (r100.f399739t != 0) goto L24;
        if (r100.f399702a0 != 0.0f) goto L24;
        if (r100.w(0) == true) goto L31;
    L5:
        r105 = null;
        goto L6
    }

    public static void e(int r100, b.InterfaceC4669b r101, ConstraintWidget r102) {
        float r103 = r102.f399718i0;
        int r104 = r102.M.f399694f.d();
        int r105 = r102.O.f399694f.d();
        int r106 = r102.M.e() + r104;
        int r107 = r105 - r102.O.e();
        if (r104 != r105) goto L5;
        r103 = 0.5f;
    L6:
        int r108 = r102.n();
        int r109 = (r105 - r104) - r108;
        if (r104 <= r105) goto L9;
        r109 = (r104 - r105) - r108;
    L9:
        if (r109 <= 0) goto L11;
        float r110 = (r103 * r109) + 0.5f;
    L12:
        int r111 = (int) r110;
        int r112 = r104 + r111;
        int r113 = r112 + r108;
        if (r104 <= r105) goto L15;
        r112 = r104 - r111;
        r113 = r112 - r108;
    L15:
        r102.M(r112, r113);
        g(r100 + 1, r102, r101);
        return;
    L11:
        r110 = r103 * r109;
        goto L12
    L5:
        r104 = r106;
        r105 = r107;
        goto L6
    }

    public static void g(int r110, ConstraintWidget r111, b.InterfaceC4669b r112) {
        if (r111.f399731p == false) goto L6;
        return;
    L6:
        if ((r111 instanceof com.obric.oui.constraintlayout.core.widgets.d) == false) goto L8;
    L12:
        ConstraintAnchor r100 = r111.l(ConstraintAnchor.Type.TOP);
        ConstraintAnchor r101 = r111.l(ConstraintAnchor.Type.BOTTOM);
        int r102 = r100.d();
        int r103 = r101.d();
        HashSet<ConstraintAnchor> r104 = r100.f399689a;
        if (r104 == null) goto L78;
        if (r100.f399691c == false) goto L78;
        Iterator<ConstraintAnchor> r105 = r104.iterator();
    L18:
        if (r105.hasNext() == false) goto L78;
        ConstraintAnchor r106 = r105.next();
        ConstraintWidget r113 = r106.f399692d;
        int r114 = r110 + 1;
        boolean r115 = a(r113);
        if (r113.C() == false) goto L23;
        if (r115 == false) goto L23;
        com.obric.oui.constraintlayout.core.widgets.d.X(r113, r112, new b.a());
    L23:
        ConstraintAnchor r116 = r113.M;
        if (r106 != r116) goto L30;
        ConstraintAnchor r117 = r113.O.f399694f;
        if (r117 == null) goto L30;
        if (r117.f399691c == false) goto L30;
    L35:
        boolean r118 = true;
    L37:
        ConstraintWidget.DimensionBehaviour r119 = r113.W[1];
        ConstraintWidget.DimensionBehaviour r107 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r119 != r107) goto L61;
        if (r115 == true) goto L61;
        if (r119 != r107) goto L18;
        if (r113.A < 0) goto L18;
        if (r113.f399749z < 0) goto L18;
        if (r113.f399722k0 == 8) goto L53;
        if (r113.f399741u != 0) goto L18;
        if (r113.f399702a0 != 0.0f) goto L18;
    L53:
        if (r113.B() == true) goto L18;
        if (r113.I == true) goto L18;
        if (r118 == false) goto L18;
        if (r113.B() == true) goto L18;
        f(r114, r111, r112, r113);
    L61:
        if (r113.C() == true) goto L18;
        ConstraintAnchor r108 = r113.M;
        if (r106 != r108) goto L68;
        if (r113.O.f399694f != null) goto L68;
        int r109 = r108.e() + r102;
        r113.M(r109, r113.n() + r109);
        g(r114, r113, r112);
    L68:
        ConstraintAnchor r120 = r113.O;
        if (r106 != r120) goto L73;
        if (r108.f399694f != null) goto L73;
        int r121 = r102 - r120.e();
        r113.M(r121 - r113.n(), r121);
        g(r114, r113, r112);
    L73:
        if (r118 == false) goto L18;
        if (r113.B() == true) goto L18;
        e(r114, r112, r113);
    L30:
        if (r106 != r113.O) goto L36;
        ConstraintAnchor r122 = r116.f399694f;
        if (r122 == null) goto L36;
        if (r122.f399691c == true) goto L35;
    L36:
        r118 = false;
    L78:
        if ((r111 instanceof com.obric.oui.constraintlayout.core.widgets.f) == false) goto L80;
        return;
    L80:
        HashSet<ConstraintAnchor> r123 = r101.f399689a;
        if (r123 != null) goto L83;
    L145:
        ConstraintAnchor r124 = r111.l(ConstraintAnchor.Type.BASELINE);
        if (r124.f399689a != null) goto L148;
    L173:
        r111.f399731p = true;
        return;
    L148:
        if (r124.f399691c == false) goto L173;
        int r125 = r124.d();
        Iterator<ConstraintAnchor> r126 = r124.f399689a.iterator();
    L151:
        if (r126.hasNext() == false) goto L173;
        ConstraintAnchor r127 = r126.next();
        ConstraintWidget r128 = r127.f399692d;
        int r129 = r110 + 1;
        boolean r130 = a(r128);
        if (r128.C() == false) goto L157;
        if (r130 == false) goto L157;
        com.obric.oui.constraintlayout.core.widgets.d.X(r128, r112, new b.a());
    L157:
        if (r128.W[1] != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L160;
        if (r130 == false) goto L151;
    L160:
        if (r128.C() == true) goto L151;
        if (r127 != r128.P) goto L151;
        int r131 = r127.e() + r125;
        if (r128.G == false) goto L175;
        int r132 = r131 - r128.f399710e0;
        int r133 = r128.Z + r132;
        r128.f399708d0 = r132;
        r128.M.l(r132);
        r128.O.l(r133);
        r128.P.l(r131);
        r128.f399727n = true;
    L175:
        g(r129, r128, r112);     // Catch: Throwable -> L170
    L170:
        th = move-exception;
        throw th;
    L83:
        if (r101.f399691c == false) goto L145;
        Iterator<ConstraintAnchor> r134 = r123.iterator();
    L86:
        if (r134.hasNext() == false) goto L145;
        ConstraintAnchor r135 = r134.next();
        ConstraintWidget r136 = r135.f399692d;
        int r137 = r110 + 1;
        boolean r138 = a(r136);
        if (r136.C() == false) goto L91;
        if (r138 == false) goto L91;
        com.obric.oui.constraintlayout.core.widgets.d.X(r136, r112, new b.a());
    L91:
        ConstraintAnchor r139 = r136.M;
        if (r135 != r139) goto L98;
        ConstraintAnchor r140 = r136.O.f399694f;
        if (r140 == null) goto L98;
        if (r140.f399691c == false) goto L98;
    L103:
        boolean r141 = true;
    L105:
        ConstraintWidget.DimensionBehaviour r142 = r136.W[1];
        ConstraintWidget.DimensionBehaviour r143 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r142 != r143) goto L129;
        if (r138 == true) goto L129;
        if (r142 != r143) goto L86;
        if (r136.A < 0) goto L86;
        if (r136.f399749z < 0) goto L86;
        if (r136.f399722k0 == 8) goto L121;
        if (r136.f399741u != 0) goto L86;
        if (r136.f399702a0 != 0.0f) goto L86;
    L121:
        if (r136.B() == true) goto L86;
        if (r136.I == true) goto L86;
        if (r141 == false) goto L86;
        if (r136.B() == true) goto L86;
        f(r137, r111, r112, r136);
    L129:
        if (r136.C() == true) goto L86;
        ConstraintAnchor r144 = r136.M;
        if (r135 != r144) goto L136;
        if (r136.O.f399694f != null) goto L136;
        int r145 = r144.e() + r103;
        r136.M(r145, r136.n() + r145);
        g(r137, r136, r112);
    L136:
        ConstraintAnchor r146 = r136.O;
        if (r135 != r146) goto L141;
        if (r144.f399694f != null) goto L141;
        int r147 = r103 - r146.e();
        r136.M(r147 - r136.n(), r147);
        g(r137, r136, r112);
    L141:
        if (r141 == false) goto L86;
        if (r136.B() == true) goto L86;
        e(r137, r112, r136);
    L98:
        if (r135 != r136.O) goto L104;
        ConstraintAnchor r148 = r139.f399694f;
        if (r148 == null) goto L104;
        if (r148.f399691c == true) goto L103;
    L104:
        r141 = false;
        goto L105
    L8:
        if (r111.C() == false) goto L12;
        if (a(r111) == false) goto L12;
        com.obric.oui.constraintlayout.core.widgets.d.X(r111, r112, new b.a());
        goto L12
    }

    public static void b(int r110, ConstraintWidget r111, b.InterfaceC4669b r112, boolean r113) {
        if (r111.f399729o == false) goto L6;
        return;
    L6:
        if ((r111 instanceof com.obric.oui.constraintlayout.core.widgets.d) == false) goto L8;
    L12:
        ConstraintAnchor r100 = r111.l(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor r101 = r111.l(ConstraintAnchor.Type.RIGHT);
        int r102 = r100.d();
        int r103 = r101.d();
        HashSet<ConstraintAnchor> r104 = r100.f399689a;
        char r105 = 0;
        if (r104 == null) goto L79;
        if (r100.f399691c == false) goto L79;
        Iterator<ConstraintAnchor> r106 = r104.iterator();
    L18:
        if (r106.hasNext() == false) goto L79;
        ConstraintAnchor r107 = r106.next();
        ConstraintWidget r114 = r107.f399692d;
        int r115 = r110 + 1;
        boolean r116 = a(r114);
        if (r114.C() == false) goto L23;
        if (r116 == false) goto L23;
        com.obric.oui.constraintlayout.core.widgets.d.X(r114, r112, new b.a());
    L23:
        ConstraintAnchor r117 = r114.L;
        if (r107 != r117) goto L30;
        ConstraintAnchor r108 = r114.N.f399694f;
        if (r108 == null) goto L30;
        if (r108.f399691c == false) goto L30;
    L35:
        boolean r109 = true;
    L37:
        ConstraintWidget.DimensionBehaviour r118 = r114.W[r105];
        ConstraintWidget.DimensionBehaviour r119 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r118 != r119) goto L61;
        if (r116 == true) goto L61;
        if (r118 != r119) goto L77;
        if (r114.f399747x < 0) goto L77;
        if (r114.f399745w < 0) goto L77;
        if (r114.f399722k0 == 8) goto L53;
        if (r114.f399739t != 0) goto L77;
        if (r114.f399702a0 != 0.0f) goto L77;
    L53:
        if (r114.A() == true) goto L77;
        if (r114.I == true) goto L77;
        if (r109 == false) goto L77;
        if (r114.A() == true) goto L77;
        d(r115, r111, r112, r114, r113);
    L77:
        r105 = 0;
    L61:
        if (r114.C() == true) goto L77;
        ConstraintAnchor r120 = r114.L;
        if (r107 == r120) goto L66;
    L68:
        ConstraintAnchor r121 = r114.N;
        if (r107 == r121) goto L71;
    L73:
        if (r109 == false) goto L77;
        if (r114.A() == true) goto L77;
        c(r115, r112, r114, r113);
        goto L77
    L71:
        if (r120.f399694f != null) goto L73;
        int r122 = r102 - r121.e();
        r114.L(r122 - r114.t(), r122);
        b(r115, r114, r112, r113);
        goto L77
    L66:
        if (r114.N.f399694f != null) goto L68;
        int r123 = r120.e() + r102;
        r114.L(r123, r114.t() + r123);
        b(r115, r114, r112, r113);
    L30:
        if (r107 != r114.N) goto L36;
        ConstraintAnchor r124 = r117.f399694f;
        if (r124 == null) goto L36;
        if (r124.f399691c == true) goto L35;
    L36:
        r109 = false;
    L79:
        if ((r111 instanceof com.obric.oui.constraintlayout.core.widgets.f) == false) goto L81;
        return;
    L81:
        HashSet<ConstraintAnchor> r125 = r101.f399689a;
        if (r125 != null) goto L84;
    L146:
        r111.f399729o = true;
        return;
    L84:
        if (r101.f399691c == false) goto L146;
        Iterator<ConstraintAnchor> r126 = r125.iterator();
    L87:
        if (r126.hasNext() == false) goto L146;
        ConstraintAnchor r127 = r126.next();
        ConstraintWidget r128 = r127.f399692d;
        int r129 = r110 + 1;
        boolean r130 = a(r128);
        if (r128.C() == false) goto L92;
        if (r130 == false) goto L92;
        com.obric.oui.constraintlayout.core.widgets.d.X(r128, r112, new b.a());
    L92:
        ConstraintAnchor r131 = r128.L;
        if (r127 != r131) goto L99;
        ConstraintAnchor r132 = r128.N.f399694f;
        if (r132 == null) goto L99;
        if (r132.f399691c == false) goto L99;
    L104:
        boolean r133 = true;
    L106:
        ConstraintWidget.DimensionBehaviour r134 = r128.W[0];
        ConstraintWidget.DimensionBehaviour r135 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r134 != r135) goto L130;
        if (r130 == true) goto L130;
        if (r134 != r135) goto L87;
        if (r128.f399747x < 0) goto L87;
        if (r128.f399745w < 0) goto L87;
        if (r128.f399722k0 == 8) goto L122;
        if (r128.f399739t != 0) goto L87;
        if (r128.f399702a0 != 0.0f) goto L87;
    L122:
        if (r128.A() == true) goto L87;
        if (r128.I == true) goto L87;
        if (r133 == false) goto L87;
        if (r128.A() == true) goto L87;
        d(r129, r111, r112, r128, r113);
    L130:
        if (r128.C() == true) goto L87;
        ConstraintAnchor r136 = r128.L;
        if (r127 != r136) goto L137;
        if (r128.N.f399694f != null) goto L137;
        int r137 = r136.e() + r103;
        r128.L(r137, r128.t() + r137);
        b(r129, r128, r112, r113);
    L137:
        ConstraintAnchor r138 = r128.N;
        if (r127 != r138) goto L142;
        if (r136.f399694f != null) goto L142;
        int r139 = r103 - r138.e();
        r128.L(r139 - r128.t(), r139);
        b(r129, r128, r112, r113);
    L142:
        if (r133 == false) goto L87;
        if (r128.A() == true) goto L87;
        c(r129, r112, r128, r113);
    L99:
        if (r127 != r128.N) goto L105;
        ConstraintAnchor r140 = r131.f399694f;
        if (r140 == null) goto L105;
        if (r140.f399691c == true) goto L104;
    L105:
        r133 = false;
        goto L106
    L8:
        if (r111.C() == false) goto L12;
        if (a(r111) == false) goto L12;
        com.obric.oui.constraintlayout.core.widgets.d.X(r111, r112, new b.a());
        goto L12
    }

    public static void c(int r100, b.InterfaceC4669b r101, ConstraintWidget r102, boolean r103) {
        float r104 = r102.f399716h0;
        int r105 = r102.L.f399694f.d();
        int r106 = r102.N.f399694f.d();
        int r107 = r102.L.e() + r105;
        int r108 = r106 - r102.N.e();
        if (r105 != r106) goto L5;
        r104 = 0.5f;
    L6:
        int r109 = r102.t();
        int r110 = (r106 - r105) - r109;
        if (r105 <= r106) goto L9;
        r110 = (r105 - r106) - r109;
    L9:
        if (r110 <= 0) goto L11;
        float r111 = (r104 * r110) + 0.5f;
    L12:
        int r112 = ((int) r111) + r105;
        int r113 = r112 + r109;
        if (r105 <= r106) goto L15;
        r113 = r112 - r109;
    L15:
        r102.L(r112, r113);
        b(r100 + 1, r102, r101, r103);
        return;
    L11:
        r111 = r104 * r110;
        goto L12
    L5:
        r105 = r107;
        r106 = r108;
        goto L6
    }

    public static void f(int r100, ConstraintWidget r101, b.InterfaceC4669b r102, ConstraintWidget r110) {
        float r103 = r110.f399718i0;
        int r104 = r110.M.f399694f.d() + r110.M.e();
        int r105 = r110.O.f399694f.d() - r110.O.e();
        if (r105 < r104) goto L20;
        int r106 = r110.n();
        if (r110.f399722k0 == 8) goto L18;
        int r107 = r110.f399741u;
        if (r107 == 2) goto L9;
        if (r107 != 0) goto L15;
        r106 = r105 - r104;
    L15:
        r106 = Math.max(r110.f399749z, r106);
        int r108 = r110.A;
        if (r108 <= 0) goto L18;
        r106 = Math.min(r108, r106);
        goto L18
    L9:
        if ((r101 instanceof com.obric.oui.constraintlayout.core.widgets.d) == false) goto L11;
        int r109 = r101.n();
    L12:
        r106 = (int) ((r103 * 0.5f) * r109);
        goto L15
    L11:
        r109 = r101.X.n();
    L18:
        int r111 = r104 + ((int) ((r103 * ((r105 - r104) - r106)) + 0.5f));
        r110.M(r111, r106 + r111);
        g(r100 + 1, r110, r102);
        return;
    }

    public static void d(int r100, ConstraintWidget r101, b.InterfaceC4669b r102, ConstraintWidget r110, boolean r111) {
        float r103 = r110.f399716h0;
        int r104 = r110.L.f399694f.d() + r110.L.e();
        int r105 = r110.N.f399694f.d() - r110.N.e();
        if (r105 < r104) goto L20;
        int r106 = r110.t();
        if (r110.f399722k0 == 8) goto L18;
        int r107 = r110.f399739t;
        if (r107 == 2) goto L9;
        if (r107 != 0) goto L15;
        r106 = r105 - r104;
    L15:
        r106 = Math.max(r110.f399745w, r106);
        int r108 = r110.f399747x;
        if (r108 <= 0) goto L18;
        r106 = Math.min(r108, r106);
        goto L18
    L9:
        if ((r101 instanceof com.obric.oui.constraintlayout.core.widgets.d) == false) goto L11;
        int r109 = r101.t();
    L12:
        r106 = (int) ((r110.f399716h0 * 0.5f) * r109);
        goto L15
    L11:
        r109 = r101.X.t();
    L18:
        int r112 = r104 + ((int) ((r103 * ((r105 - r104) - r106)) + 0.5f));
        r110.L(r112, r106 + r112);
        b(r100 + 1, r110, r102, r111);
        return;
    }
}
