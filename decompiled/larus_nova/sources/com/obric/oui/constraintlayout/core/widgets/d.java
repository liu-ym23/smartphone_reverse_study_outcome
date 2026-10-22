package com.obric.oui.constraintlayout.core.widgets;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.oui.constraintlayout.core.SolverVariable;
import com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun;
import com.obric.oui.constraintlayout.core.widgets.analyzer.n;
import com.obric.oui.constraintlayout.widget.ConstraintLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes34.dex */
public final class d extends ula.c {
    public int A0;
    public com.obric.oui.constraintlayout.core.widgets.analyzer.b.InterfaceC4669b B0;
    public boolean C0;
    public final com.obric.oui.constraintlayout.core.c D0;
    public int E0;
    public int F0;
    public int G0;
    public int H0;
    public c[] I0;
    public c[] J0;
    public int K0;
    public boolean L0;
    public boolean M0;
    public WeakReference<ConstraintAnchor> N0;
    public WeakReference<ConstraintAnchor> O0;
    public WeakReference<ConstraintAnchor> P0;
    public WeakReference<ConstraintAnchor> Q0;
    public final HashSet<ConstraintWidget> R0;
    public final com.obric.oui.constraintlayout.core.widgets.analyzer.b.a S0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public final com.obric.oui.constraintlayout.core.widgets.analyzer.b f399834y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public final com.obric.oui.constraintlayout.core.widgets.analyzer.e f399835z0;

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public String getType() {
        return "ConstraintLayout";
    }

    @Override // ula.c, com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public final void F() {
        this.D0.t();
        this.E0 = 0;
        this.F0 = 0;
        super.F();
    }

    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9, types: [boolean] */
    @Override // ula.c
    public final void T() {
        this.f399706c0 = 0;
        this.f399708d0 = 0;
        this.L0 = false;
        this.M0 = false;
        int r100 = this.f550644x0.size();
        int r101 = Math.max(0, t());
        int r102 = Math.max(0, n());
        ConstraintWidget.DimensionBehaviour[] r103 = this.W;
        ConstraintWidget.DimensionBehaviour r104 = r103[1];
        ConstraintWidget.DimensionBehaviour r105 = r103[0];
        if (this.A0 != 0) goto L148;
        if (g.b(this.K0, 1) == false) goto L148;
        com.obric.oui.constraintlayout.core.widgets.analyzer.b.InterfaceC4669b r106 = this.B0;
        com.obric.oui.constraintlayout.core.widgets.analyzer.b.a r110 = com.obric.oui.constraintlayout.core.widgets.analyzer.g.f399803a;
        ConstraintWidget.DimensionBehaviour[] r111 = this.W;
        ConstraintWidget.DimensionBehaviour r112 = r111[0];
        ConstraintWidget.DimensionBehaviour r113 = r111[1];
        H();
        ArrayList<ConstraintWidget> r114 = this.f550644x0;
        int r115 = r114.size();
        int r116 = 0;
    L7:
        if (r116 >= r115) goto L9;
        ((ConstraintWidget) ListProtector.get(r114, r116)).H();
        r116 = r116 + 1;
        goto L7
    L9:
        boolean r117 = this.C0;
        if (r112 != ConstraintWidget.DimensionBehaviour.FIXED) goto L12;
        L(0, t());
    L13:
        int r118 = 0;
        boolean r119 = false;
        boolean r120 = false;
    L15:
        if (r118 >= r115) goto L38;
        ConstraintWidget r107 = (ConstraintWidget) ListProtector.get(r114, r118);
        if ((r107 instanceof f) == false) goto L33;
        f r108 = (f) r107;
        if (r108.B0 != 1) goto L37;
        int r109 = r108.f399864y0;
        if (r109 == (-1)) goto L24;
        r108.T(r109);
    L31:
        r119 = true;
        goto L37
    L24:
        if (r108.f399865z0 == (-1)) goto L29;
        if (D() == false) goto L29;
        r108.T(t() - r108.f399865z0);
    L29:
        if (D() == false) goto L31;
        r108.T((int) ((r108.f399863x0 * t()) + 0.5f));
    L37:
        r118 = r118 + 1;
        goto L15
    L33:
        if ((r107 instanceof a) == false) goto L37;
        if (((a) r107).V() != 0) goto L37;
        r120 = true;
        goto L37
    L38:
        if (r119 == false) goto L48;
        int r121 = 0;
    L40:
        if (r121 >= r115) goto L48;
        ConstraintWidget r122 = (ConstraintWidget) ListProtector.get(r114, r121);
        if ((r122 instanceof f) == false) goto L47;
        f r123 = (f) r122;
        if (r123.B0 != 1) goto L47;
        com.obric.oui.constraintlayout.core.widgets.analyzer.g.b(0, r123, r106, r117);
    L47:
        r121 = r121 + 1;
    L48:
        com.obric.oui.constraintlayout.core.widgets.analyzer.g.b(0, this, r106, r117);
        if (r120 == false) goto L61;
        int r124 = 0;
    L51:
        if (r124 >= r115) goto L61;
        ConstraintWidget r125 = (ConstraintWidget) ListProtector.get(r114, r124);
        if ((r125 instanceof a) == false) goto L59;
        a r126 = (a) r125;
        if (r126.V() != 0) goto L59;
        if (r126.U() == false) goto L59;
        com.obric.oui.constraintlayout.core.widgets.analyzer.g.b(1, r126, r106, r117);
    L59:
        r124 = r124 + 1;
    L61:
        if (r113 != ConstraintWidget.DimensionBehaviour.FIXED) goto L63;
        M(0, n());
    L64:
        int r127 = 0;
        boolean r128 = false;
        boolean r129 = false;
    L65:
        if (r127 >= r115) goto L88;
        ConstraintWidget r130 = (ConstraintWidget) ListProtector.get(r114, r127);
        if ((r130 instanceof f) == false) goto L83;
        f r131 = (f) r130;
        if (r131.B0 != 0) goto L87;
        int r132 = r131.f399864y0;
        if (r132 == (-1)) goto L74;
        r131.T(r132);
    L81:
        r128 = true;
        goto L87
    L74:
        if (r131.f399865z0 == (-1)) goto L79;
        if (E() == false) goto L79;
        r131.T(n() - r131.f399865z0);
    L79:
        if (E() == false) goto L81;
        r131.T((int) ((r131.f399863x0 * n()) + 0.5f));
    L87:
        r127 = r127 + 1;
        goto L65
    L83:
        if ((r130 instanceof a) == false) goto L87;
        if (((a) r130).V() != 1) goto L87;
        r129 = true;
        goto L87
    L88:
        if (r128 == false) goto L97;
        int r133 = 0;
    L90:
        if (r133 >= r115) goto L97;
        ConstraintWidget r134 = (ConstraintWidget) ListProtector.get(r114, r133);
        if ((r134 instanceof f) == false) goto L96;
        f r135 = (f) r134;
        if (r135.B0 != 0) goto L96;
        com.obric.oui.constraintlayout.core.widgets.analyzer.g.g(1, r135, r106);
    L96:
        r133 = r133 + 1;
    L97:
        com.obric.oui.constraintlayout.core.widgets.analyzer.g.g(0, this, r106);
        if (r129 == false) goto L109;
        int r136 = 0;
    L100:
        if (r136 >= r115) goto L109;
        ConstraintWidget r137 = (ConstraintWidget) ListProtector.get(r114, r136);
        if ((r137 instanceof a) == false) goto L108;
        a r138 = (a) r137;
        if (r138.V() != 1) goto L108;
        if (r138.U() == false) goto L108;
        com.obric.oui.constraintlayout.core.widgets.analyzer.g.g(1, r138, r106);
    L108:
        r136 = r136 + 1;
    L109:
        int r139 = 0;
    L110:
        if (r139 >= r115) goto L123;
        ConstraintWidget r140 = (ConstraintWidget) ListProtector.get(r114, r139);
        if (r140.C() == false) goto L122;
        if (com.obric.oui.constraintlayout.core.widgets.analyzer.g.a(r140) == false) goto L122;
        X(r140, r106, com.obric.oui.constraintlayout.core.widgets.analyzer.g.f399803a);
        if ((r140 instanceof f) == true) goto L118;
        com.obric.oui.constraintlayout.core.widgets.analyzer.g.b(0, r140, r106, r117);
        com.obric.oui.constraintlayout.core.widgets.analyzer.g.g(0, r140, r106);
        goto L122
    L118:
        if (((f) r140).B0 != 0) goto L120;
        com.obric.oui.constraintlayout.core.widgets.analyzer.g.g(0, r140, r106);
        goto L122
    L120:
        com.obric.oui.constraintlayout.core.widgets.analyzer.g.b(0, r140, r106, r117);
    L122:
        r139 = r139 + 1;
        goto L110
    L123:
        int r141 = 0;
    L124:
        if (r141 >= r100) goto L148;
        ConstraintWidget r142 = (ConstraintWidget) ListProtector.get(this.f550644x0, r141);
        if (r142.C() == false) goto L146;
        if ((r142 instanceof f) == true) goto L146;
        if ((r142 instanceof a) == true) goto L146;
        if ((r142 instanceof i) == true) goto L146;
        if (r142.I == true) goto L146;
        ConstraintWidget.DimensionBehaviour r143 = r142.m(0);
        ConstraintWidget.DimensionBehaviour r144 = r142.m(1);
        ConstraintWidget.DimensionBehaviour r145 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r143 == r145) goto L138;
    L143:
        boolean r146 = false;
    L144:
        if (r146 == true) goto L146;
        X(r142, this.B0, new com.obric.oui.constraintlayout.core.widgets.analyzer.b.a());
        goto L146
    L138:
        if (r142.f399739t == 1) goto L143;
        if (r144 != r145) goto L143;
        if (r142.f399741u == 1) goto L143;
        r146 = true;
    L146:
        r141 = r141 + 1;
        goto L124
    L63:
        this.M.l(0);
        this.f399708d0 = 0;
        goto L64
    L12:
        this.L.l(0);
        this.f399706c0 = 0;
    L148:
        if (r100 <= 2) goto L385;
        ConstraintWidget.DimensionBehaviour r147 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r105 == r147) goto L153;
        if (r104 != r147) goto L385;
    L153:
        if (g.b(this.K0, 1024) == false) goto L385;
        com.obric.oui.constraintlayout.core.widgets.analyzer.b.InterfaceC4669b r148 = this.B0;
        ArrayList<ConstraintWidget> r149 = this.f550644x0;
        int r150 = r149.size();
        int r151 = 0;
    L155:
        if (r151 >= r150) goto L163;
        ConstraintWidget r152 = (ConstraintWidget) ListProtector.get(r149, r151);
        ConstraintWidget.DimensionBehaviour[] r153 = this.W;
        ConstraintWidget.DimensionBehaviour r154 = r153[0];
        ConstraintWidget.DimensionBehaviour r155 = r153[1];
        ConstraintWidget.DimensionBehaviour[] r156 = r152.W;
        int r210 = r100;
        if (com.obric.oui.constraintlayout.core.widgets.analyzer.h.b(r154, r155, r156[0], r156[1]) == false) goto L161;
        if ((r152 instanceof e) == true) goto L161;
        r151 = r151 + 1;
        r100 = r210;
    L161:
        int r211 = r101;
        int r212 = r102;
        ConstraintWidget.DimensionBehaviour r213 = r105;
        ConstraintWidget.DimensionBehaviour r214 = r104;
    L362:
        boolean r157 = false;
    L364:
        if (r157 == false) goto L384;
        ConstraintWidget.DimensionBehaviour r158 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        ConstraintWidget.DimensionBehaviour r159 = r213;
        if (r159 != r158) goto L372;
        int r160 = r211;
        if (r160 >= t()) goto L371;
        if (r160 <= 0) goto L371;
        Q(r160);
        this.L0 = true;
    L373:
        int r161 = r160;
    L374:
        ConstraintWidget.DimensionBehaviour r162 = r214;
        if (r162 != r158) goto L381;
        int r163 = r212;
        if (r163 >= n()) goto L380;
        if (r163 <= 0) goto L380;
        N(r163);
        this.M0 = true;
    L382:
        int r164 = r163;
    L383:
        boolean r165 = true;
    L388:
        if (Y(64) == false) goto L390;
    L393:
        boolean r166 = true;
    L394:
        com.obric.oui.constraintlayout.core.c r167 = this.D0;
        r167.getClass();
        r167.f399642h = false;
        if (this.K0 == 0) goto L398;
        if (r166 == false) goto L398;
        char r168 = 1;
        r167.f399642h = true;
    L399:
        ArrayList<ConstraintWidget> r169 = this.f550644x0;
        ConstraintWidget.DimensionBehaviour[] r170 = this.W;
        ConstraintWidget.DimensionBehaviour r171 = r170[0];
        ConstraintWidget.DimensionBehaviour r172 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r171 != r172) goto L402;
    L405:
        boolean r173 = true;
    L406:
        this.G0 = 0;
        this.H0 = 0;
        int r174 = r210;
        int r175 = 0;
    L407:
        if (r175 >= r174) goto L412;
        ConstraintWidget r176 = (ConstraintWidget) ListProtector.get(this.f550644x0, r175);
        if ((r176 instanceof ula.c) == false) goto L411;
        ((ula.c) r176).T();
    L411:
        r175 = r175 + 1;
        goto L407
    L412:
        boolean r177 = Y(64);
        boolean r178 = r165;
        int r179 = 0;
        boolean r180 = true;
    L413:
        if (r180 == false) goto L522;
        int r181 = r179 + 1;
        this.D0.t();     // Catch: Exception -> L458
        this.G0 = 0;     // Catch: Exception -> L458
        this.H0 = 0;     // Catch: Exception -> L458
        j(this.D0);     // Catch: Exception -> L458
        int r182 = 0;
    L416:
        if (r182 >= r174) goto L418;
        ((ConstraintWidget) ListProtector.get(this.f550644x0, r182)).j(this.D0);     // Catch: Exception -> L458
        r182 = r182 + 1;     // Catch: Exception -> L458
        goto L416
    L418:
        V(this.D0);     // Catch: Exception -> L458
        WeakReference<ConstraintAnchor> r183 = this.N0;     // Catch: Exception -> L451
        if (r183 != null) goto L529;
    L429:
        WeakReference<ConstraintAnchor> r184 = this.P0;     // Catch: Exception -> L451
        if (r184 != null) goto L432;
    L436:
        WeakReference<ConstraintAnchor> r185 = this.O0;     // Catch: Exception -> L451
        if (r185 != null) goto L439;
    L444:
        WeakReference<ConstraintAnchor> r186 = this.Q0;     // Catch: Exception -> L451
        if (r186 == null) goto L454;
        if (r186.get() == null) goto L454;
        ConstraintAnchor r187 = this.Q0.get();     // Catch: Exception -> L451
        this.D0.f(this.D0.k(this.N), this.D0.k(r187), 0, 5);     // Catch: Exception -> L451
        this.Q0 = null;     // Catch: Exception -> L456
    L456:
        e = e;
    L457:
        r180 = true;
    L460:
        e.printStackTrace();
        System.out.println("EXCEPTION : " + e);
    L461:
        boolean[] r188 = g.f399867a;
        if (r180 == false) goto L476;
        com.obric.oui.constraintlayout.core.c r189 = this.D0;
        r188[2] = false;
        boolean r190 = Y(64);
        S(r189, r190);
        int r191 = this.f550644x0.size();
        int r192 = 0;
        boolean r215 = false;
    L464:
        if (r192 >= r191) goto L481;
        int r216 = r191;
        ConstraintWidget r193 = (ConstraintWidget) ListProtector.get(this.f550644x0, r192);
        r193.S(r189, r190);
        com.obric.oui.constraintlayout.core.c r217 = r189;
        boolean r218 = r190;
        if (r193.f399717i == (-1)) goto L468;
    L471:
        boolean r194 = true;
    L472:
        if (r194 == false) goto L474;
        r215 = true;
    L474:
        r192 = r192 + 1;
        r191 = r216;
        r189 = r217;
        r190 = r218;
        goto L464
    L468:
        if (r193.f399719j != (-1)) goto L471;
        r194 = false;
    L481:
        if (r173 == false) goto L497;
        if (r181 >= 8) goto L497;
        if (r188[2] == false) goto L497;
        int r195 = 0;
        int r196 = 0;
        int r197 = 0;
    L486:
        if (r195 >= r174) goto L488;
        ConstraintWidget r198 = (ConstraintWidget) ListProtector.get(this.f550644x0, r195);
        r197 = Math.max(r197, r198.f399706c0 + r198.t());
        r196 = Math.max(r196, r198.f399708d0 + r198.n());
        r195 = r195 + 1;
        goto L486
    L488:
        int r199 = Math.max(this.f399712f0, r197);
        int r200 = Math.max(this.f399714g0, r196);
        ConstraintWidget.DimensionBehaviour r1100 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r159 == r1100) goto L491;
    L493:
        if (r162 != r1100) goto L497;
        if (n() >= r200) goto L497;
        N(r200);
        this.W[1] = r1100;
        r178 = true;
        r215 = true;
        goto L497
    L491:
        if (t() >= r199) goto L493;
        Q(r199);
        this.W[0] = r1100;
        r178 = true;
        r215 = true;
    L497:
        int r201 = Math.max(this.f399712f0, t());
        if (r201 <= t()) goto L500;
        Q(r201);
        this.W[0] = ConstraintWidget.DimensionBehaviour.FIXED;
        r178 = true;
        r215 = true;
    L500:
        int r202 = Math.max(this.f399714g0, n());
        if (r202 <= n()) goto L503;
        N(r202);
        ?? r1101 = 1;
        this.W[1] = ConstraintWidget.DimensionBehaviour.FIXED;
        r178 = true;
        r215 = true;
    L504:
        if (r178 == true) goto L517;
        ConstraintWidget.DimensionBehaviour r203 = this.W[0];
        ConstraintWidget.DimensionBehaviour r1102 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r203 != r1102) goto L512;
        if (r161 <= 0) goto L512;
        if (t() <= r161) goto L512;
        this.L0 = r1101;
        this.W[0] = ConstraintWidget.DimensionBehaviour.FIXED;
        Q(r161);
        r178 = true;
        r215 = true;
    L512:
        if (this.W[r1101] != r1102) goto L517;
        if (r164 <= 0) goto L517;
        if (n() <= r164) goto L517;
        this.M0 = r1101;
        this.W[r1101] = ConstraintWidget.DimensionBehaviour.FIXED;
        N(r164);
        int r204 = 8;
        r178 = true;
        r215 = true;
    L518:
        if (r181 <= r204) goto L520;
        r180 = false;
    L521:
        r179 = r181;
        goto L413
    L520:
        r180 = r215;
    L517:
        r204 = 8;
        goto L518
    L503:
        r1101 = 1;
        goto L504
    L476:
        S(this.D0, r177);
        int r205 = 0;
    L477:
        if (r205 >= r174) goto L479;
        ((ConstraintWidget) ListProtector.get(this.f550644x0, r205)).S(this.D0, r177);
        r205 = r205 + 1;
        goto L477
    L479:
        r215 = false;
    L454:
        this.D0.p();     // Catch: Exception -> L456
        r180 = true;
        goto L461
    L439:
        if (r185.get() == null) goto L444;
        ConstraintAnchor r206 = this.O0.get();     // Catch: Exception -> L427
        SolverVariable r207 = this.D0.k(this.L);     // Catch: Exception -> L427
        this.D0.f(this.D0.k(r206), r207, 0, 5);     // Catch: Exception -> L427
        this.O0 = null;     // Catch: Exception -> L451
        goto L444
    L432:
        if (r184.get() == null) goto L436;
        ConstraintAnchor r208 = this.P0.get();     // Catch: Exception -> L427
        this.D0.f(this.D0.k(this.O), this.D0.k(r208), 0, 5);     // Catch: Exception -> L427
        this.P0 = null;     // Catch: Exception -> L451
        goto L436
    L529:
        if (r183.get() == null) goto L429;
        ConstraintAnchor r209 = this.N0.get();     // Catch: Exception -> L427
        SolverVariable r1103 = this.D0.k(this.M);     // Catch: Exception -> L427
        this.D0.f(this.D0.k(r209), r1103, 0, 5);     // Catch: Exception -> L427
        this.N0 = null;     // Catch: Exception -> L451
    L427:
        e = e;
    L451:
        e = e;
    L458:
        e = e;
        goto L460
    L522:
        this.f550644x0 = r169;
        if (r178 == false) goto L525;
        ConstraintWidget.DimensionBehaviour[] r219 = this.W;
        r219[0] = r159;
        r219[1] = r162;
    L525:
        I(this.D0.f399647m);
        return;
    L402:
        if (r170[r168] == r172) goto L405;
        r173 = false;
    L398:
        r168 = 1;
        goto L399
    L390:
        if (Y(128) == true) goto L393;
        r166 = false;
    L380:
        r164 = n();
        goto L383
    L381:
        r163 = r212;
    L371:
        r161 = t();
        goto L374
    L372:
        r160 = r211;
        goto L373
    L384:
        int r220 = r212;
        r162 = r214;
        int r221 = r211;
        r159 = r213;
    L386:
        r161 = r221;
        r164 = r220;
        r165 = false;
        goto L388
    L163:
        r210 = r100;
        ArrayList r222 = null;
        ArrayList r223 = null;
        ArrayList r224 = null;
        ArrayList r1104 = null;
        ArrayList r1105 = null;
        ArrayList r1106 = null;
        int r1107 = 0;
    L164:
        if (r1107 >= r150) goto L224;
        ConstraintWidget r225 = (ConstraintWidget) ListProtector.get(r149, r1107);
        int r226 = r102;
        ConstraintWidget.DimensionBehaviour[] r227 = this.W;
        ConstraintWidget.DimensionBehaviour r228 = r104;
        ConstraintWidget.DimensionBehaviour r229 = r227[0];
        ConstraintWidget.DimensionBehaviour r230 = r227[1];
        int r231 = r101;
        ConstraintWidget.DimensionBehaviour[] r232 = r225.W;
        ConstraintWidget.DimensionBehaviour r233 = r105;
        if (com.obric.oui.constraintlayout.core.widgets.analyzer.h.b(r229, r230, r232[0], r232[1]) == true) goto L168;
        X(r225, r148, this.S0);
    L168:
        boolean r234 = r225 instanceof f;
        if (r234 == false) goto L181;
        f r235 = (f) r225;
        if (r235.B0 != 0) goto L176;
        if (r224 != null) goto L174;
        r224 = new ArrayList();
    L174:
        r224.add(r235);
    L176:
        if (r235.B0 != 1) goto L181;
        if (r222 != null) goto L179;
        r222 = new ArrayList();
    L179:
        r222.add(r235);
    L181:
        if ((r225 instanceof ula.b) == false) goto L202;
        if ((r225 instanceof a) == false) goto L194;
        a r236 = (a) r225;
        if (r236.V() != 0) goto L190;
        if (r223 != null) goto L188;
        r223 = new ArrayList();
    L188:
        r223.add(r236);
    L190:
        if (r236.V() != 1) goto L202;
        if (r1104 != null) goto L193;
        r1104 = new ArrayList();
    L193:
        r1104.add(r236);
        goto L202
    L194:
        ula.b r237 = (ula.b) r225;
        if (r223 != null) goto L197;
        r223 = new ArrayList();
    L197:
        r223.add(r237);
        if (r1104 != null) goto L200;
        r1104 = new ArrayList();
    L200:
        r1104.add(r237);
    L202:
        if (r225.L.f399694f != null) goto L212;
        if (r225.N.f399694f != null) goto L212;
        if (r234 == true) goto L212;
        if ((r225 instanceof a) == true) goto L212;
        if (r1105 != null) goto L210;
        r1105 = new ArrayList();
    L210:
        r1105.add(r225);
    L212:
        if (r225.M.f399694f != null) goto L223;
        if (r225.O.f399694f != null) goto L223;
        if (r225.P.f399694f != null) goto L223;
        if (r234 == true) goto L223;
        if ((r225 instanceof a) == true) goto L223;
        if (r1106 != null) goto L222;
        r1106 = new ArrayList();
    L222:
        r1106.add(r225);
    L223:
        r1107 = r1107 + 1;
        r102 = r226;
        r104 = r228;
        r101 = r231;
        r105 = r233;
        goto L164
    L224:
        r211 = r101;
        r212 = r102;
        r213 = r105;
        r214 = r104;
        ArrayList<n> r238 = new ArrayList();
        if (r222 == null) goto L230;
        Iterator r239 = r222.iterator();
    L228:
        if (r239.hasNext() == false) goto L230;
        com.obric.oui.constraintlayout.core.widgets.analyzer.h.a((f) r239.next(), 0, r238, null);
    L230:
        n r240 = null;
        int r241 = 0;
        if (r223 == null) goto L236;
        Iterator r242 = r223.iterator();
    L234:
        if (r242.hasNext() == false) goto L236;
        ula.b r243 = (ula.b) r242.next();
        n r244 = com.obric.oui.constraintlayout.core.widgets.analyzer.h.a(r243, r241, r238, r240);
        r243.T(r238, r241, r244);
        r244.b(r238);
        r240 = null;
        r241 = 0;
    L236:
        HashSet<ConstraintAnchor> r245 = l(ConstraintAnchor.Type.LEFT).f399689a;
        if (r245 == null) goto L242;
        Iterator<ConstraintAnchor> r246 = r245.iterator();
    L240:
        if (r246.hasNext() == false) goto L242;
        com.obric.oui.constraintlayout.core.widgets.analyzer.h.a(r246.next().f399692d, 0, r238, null);
    L242:
        HashSet<ConstraintAnchor> r247 = l(ConstraintAnchor.Type.RIGHT).f399689a;
        if (r247 == null) goto L248;
        Iterator<ConstraintAnchor> r248 = r247.iterator();
    L246:
        if (r248.hasNext() == false) goto L248;
        com.obric.oui.constraintlayout.core.widgets.analyzer.h.a(r248.next().f399692d, 0, r238, null);
    L248:
        HashSet<ConstraintAnchor> r249 = l(ConstraintAnchor.Type.CENTER).f399689a;
        if (r249 == null) goto L254;
        Iterator<ConstraintAnchor> r250 = r249.iterator();
    L252:
        if (r250.hasNext() == false) goto L254;
        com.obric.oui.constraintlayout.core.widgets.analyzer.h.a(r250.next().f399692d, 0, r238, null);
    L254:
        n r251 = null;
        if (r1105 == null) goto L260;
        Iterator r252 = r1105.iterator();
    L258:
        if (r252.hasNext() == false) goto L260;
        com.obric.oui.constraintlayout.core.widgets.analyzer.h.a((ConstraintWidget) r252.next(), 0, r238, null);
    L260:
        if (r224 == null) goto L265;
        Iterator r253 = r224.iterator();
    L263:
        if (r253.hasNext() == false) goto L265;
        com.obric.oui.constraintlayout.core.widgets.analyzer.h.a((f) r253.next(), 1, r238, null);
    L265:
        int r254 = 1;
        if (r1104 == null) goto L271;
        Iterator r255 = r1104.iterator();
    L269:
        if (r255.hasNext() == false) goto L271;
        ula.b r256 = (ula.b) r255.next();
        n r257 = com.obric.oui.constraintlayout.core.widgets.analyzer.h.a(r256, r254, r238, r251);
        r256.T(r238, r254, r257);
        r257.b(r238);
        r251 = null;
        r254 = 1;
    L271:
        HashSet<ConstraintAnchor> r258 = l(ConstraintAnchor.Type.TOP).f399689a;
        if (r258 == null) goto L277;
        Iterator<ConstraintAnchor> r259 = r258.iterator();
    L275:
        if (r259.hasNext() == false) goto L277;
        com.obric.oui.constraintlayout.core.widgets.analyzer.h.a(r259.next().f399692d, 1, r238, null);
    L277:
        HashSet<ConstraintAnchor> r260 = l(ConstraintAnchor.Type.BASELINE).f399689a;
        if (r260 == null) goto L283;
        Iterator<ConstraintAnchor> r261 = r260.iterator();
    L281:
        if (r261.hasNext() == false) goto L283;
        com.obric.oui.constraintlayout.core.widgets.analyzer.h.a(r261.next().f399692d, 1, r238, null);
    L283:
        HashSet<ConstraintAnchor> r262 = l(ConstraintAnchor.Type.BOTTOM).f399689a;
        if (r262 == null) goto L289;
        Iterator<ConstraintAnchor> r263 = r262.iterator();
    L287:
        if (r263.hasNext() == false) goto L289;
        com.obric.oui.constraintlayout.core.widgets.analyzer.h.a(r263.next().f399692d, 1, r238, null);
    L289:
        HashSet<ConstraintAnchor> r264 = l(ConstraintAnchor.Type.CENTER).f399689a;
        if (r264 == null) goto L296;
        Iterator<ConstraintAnchor> r265 = r264.iterator();
    L293:
        if (r265.hasNext() == false) goto L296;
        com.obric.oui.constraintlayout.core.widgets.analyzer.h.a(r265.next().f399692d, 1, r238, null);
    L296:
        if (r1106 == null) goto L301;
        Iterator r266 = r1106.iterator();
    L299:
        if (r266.hasNext() == false) goto L301;
        com.obric.oui.constraintlayout.core.widgets.analyzer.h.a((ConstraintWidget) r266.next(), 1, r238, null);
    L301:
        int r267 = 0;
    L302:
        if (r267 >= r150) goto L329;
        ConstraintWidget r268 = (ConstraintWidget) ListProtector.get(r149, r267);
        ConstraintWidget.DimensionBehaviour[] r269 = r268.W;
        ConstraintWidget.DimensionBehaviour r270 = r269[0];
        ConstraintWidget.DimensionBehaviour r271 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r270 == r271) goto L306;
    L308:
        boolean r272 = false;
    L309:
        if (r272 == false) goto L327;
        int r273 = r268.f399744v0;
        int r274 = r238.size();
        int r275 = 0;
    L311:
        if (r275 >= r274) goto L316;
        n r276 = (n) ListProtector.get(r238, r275);
        if (r273 == r276.f399813b) goto L317;
        r275 = r275 + 1;
    L317:
        int r277 = r268.f399746w0;
        int r278 = r238.size();
        int r279 = 0;
    L318:
        if (r279 >= r278) goto L323;
        n r280 = (n) ListProtector.get(r238, r279);
        if (r277 == r280.f399813b) goto L324;
        r279 = r279 + 1;
    L324:
        if (r276 == null) goto L327;
        if (r280 == null) goto L327;
        r276.d(0, r280);
        r280.f399814c = 2;
        r238.remove(r276);
        goto L327
    L323:
        r280 = null;
        goto L324
    L316:
        r276 = null;
    L327:
        r267 = r267 + 1;
        goto L302
    L306:
        if (r269[1] != r271) goto L308;
        r272 = true;
        goto L309
    L329:
        if (r238.size() <= 1) goto L362;
        if (this.W[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L344;
        Iterator<n> r281 = r238.iterator();
        n r282 = null;
        int r283 = 0;
    L335:
        if (r281.hasNext() == false) goto L342;
        n r284 = r281.next();
        if (r284.f399814c == 1) goto L335;
        int r285 = r284.c(this.D0, 0);
        if (r285 <= r283) goto L335;
        r282 = r284;
        r283 = r285;
        goto L335
    L342:
        if (r282 == null) goto L344;
        O(ConstraintWidget.DimensionBehaviour.FIXED);
        Q(r283);
    L346:
        if (this.W[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L358;
        Iterator<n> r286 = r238.iterator();
        n r287 = null;
        int r288 = 0;
    L349:
        if (r286.hasNext() == false) goto L356;
        n r289 = r286.next();
        if (r289.f399814c == 0) goto L349;
        int r290 = r289.c(this.D0, 1);
        if (r290 <= r288) goto L349;
        r287 = r289;
        r288 = r290;
        goto L349
    L356:
        if (r287 == null) goto L358;
        P(ConstraintWidget.DimensionBehaviour.FIXED);
        N(r288);
    L359:
        if (r282 != null) goto L363;
        if (r287 == null) goto L362;
    L363:
        r157 = true;
    L358:
        r287 = null;
    L344:
        r282 = null;
    L385:
        r210 = r100;
        r220 = r102;
        r159 = r105;
        r162 = r104;
        r221 = r101;
        goto L386
    }

    public d() {
        this.f399834y0 = new com.obric.oui.constraintlayout.core.widgets.analyzer.b(this);
        this.f399835z0 = new com.obric.oui.constraintlayout.core.widgets.analyzer.e(this);
        this.B0 = null;
        this.C0 = false;
        this.D0 = new com.obric.oui.constraintlayout.core.c();
        this.G0 = 0;
        this.H0 = 0;
        this.I0 = new c[4];
        this.J0 = new c[4];
        this.K0 = 257;
        this.L0 = false;
        this.M0 = false;
        this.N0 = null;
        this.O0 = null;
        this.P0 = null;
        this.Q0 = null;
        this.R0 = new HashSet();
        this.S0 = new com.obric.oui.constraintlayout.core.widgets.analyzer.b.a();
    }

    public final void V(com.obric.oui.constraintlayout.core.c r110) {
        boolean r100 = Y(64);
        d(r110, r100);
        int r101 = this.f550644x0.size();
        int r102 = 0;
        boolean r103 = false;
    L4:
        if (r102 >= r101) goto L9;
        ConstraintWidget r104 = (ConstraintWidget) ListProtector.get(this.f550644x0, r102);
        boolean[] r105 = r104.V;
        r105[0] = false;
        r105[1] = false;
        if ((r104 instanceof a) == false) goto L8;
        r103 = true;
    L8:
        r102 = r102 + 1;
        goto L4
    L9:
        if (r103 == false) goto L34;
        int r106 = 0;
    L11:
        if (r106 >= r101) goto L34;
        ConstraintWidget r107 = (ConstraintWidget) ListProtector.get(this.f550644x0, r106);
        if ((r107 instanceof a) == false) goto L33;
        a r108 = (a) r107;
        int r109 = 0;
    L16:
        if (r109 >= r108.f550643y0) goto L33;
        ConstraintWidget r111 = r108.f550642x0[r109];
        if (r108.A0 == false) goto L20;
    L22:
        int r112 = r108.f399753z0;
        if (r112 == 0) goto L31;
        if (r112 == 1) goto L31;
        if (r112 != 2) goto L29;
    L30:
        r111.V[1] = true;
    L32:
        r109 = r109 + 1;
        goto L16
    L29:
        if (r112 != 3) goto L32;
    L31:
        r111.V[0] = true;
        goto L32
    L20:
        if (r111.e() == true) goto L22;
    L33:
        r106 = r106 + 1;
    L34:
        this.R0.clear();
        int r113 = 0;
    L35:
        if (r113 >= r101) goto L50;
        ConstraintWidget r114 = (ConstraintWidget) ListProtector.get(this.f550644x0, r113);
        r114.getClass();
        if ((r114 instanceof i) == false) goto L39;
    L42:
        boolean r115 = true;
    L43:
        if (r115 == false) goto L48;
        if ((r114 instanceof i) == false) goto L47;
        this.R0.add(r114);
        goto L48
    L47:
        r114.d(r110, r100);
    L48:
        r113 = r113 + 1;
        goto L35
    L39:
        if ((r114 instanceof f) == true) goto L42;
        r115 = false;
    L50:
        if (this.R0.size() <= 0) goto L72;
        int r116 = this.R0.size();
        Iterator<ConstraintWidget> r117 = this.R0.iterator();
    L53:
        if (r117.hasNext() == false) goto L65;
        i r118 = (i) r117.next();
        HashSet<ConstraintWidget> r119 = this.R0;
        int r120 = 0;
    L56:
        if (r120 >= r118.f550643y0) goto L61;
        if (r119.contains(r118.f550642x0[r120]) == true) goto L59;
        r120 = r120 + 1;
        goto L56
    L59:
        boolean r121 = true;
    L62:
        if (r121 == false) goto L53;
        r118.d(r110, r100);
        this.R0.remove(r118);
        goto L65
    L61:
        r121 = false;
    L65:
        if (r116 != this.R0.size()) goto L50;
        Iterator<ConstraintWidget> r122 = this.R0.iterator();
    L68:
        if (r122.hasNext() == false) goto L70;
        r122.next().d(r110, r100);
        goto L68
    L70:
        this.R0.clear();
        goto L50
    L72:
        if (com.obric.oui.constraintlayout.core.c.f399634q == false) goto L93;
        HashSet<ConstraintWidget> r123 = new HashSet();
        int r124 = 0;
    L74:
        if (r124 >= r101) goto L86;
        ConstraintWidget r125 = (ConstraintWidget) ListProtector.get(this.f550644x0, r124);
        r125.getClass();
        if ((r125 instanceof i) == false) goto L78;
    L81:
        boolean r126 = true;
    L82:
        if (r126 == true) goto L84;
        r123.add(r125);
    L84:
        r124 = r124 + 1;
        goto L74
    L78:
        if ((r125 instanceof f) == true) goto L81;
        r126 = false;
        goto L82
    L86:
        if (this.W[0] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L88;
        int r127 = 0;
    L89:
        c(this, r110, r123, r127, false);
        Iterator<ConstraintWidget> r128 = r123.iterator();
    L91:
        if (r128.hasNext() == false) goto L118;
        ConstraintWidget r129 = r128.next();
        g.a(this, r110, r129);
        r129.d(r110, r100);
    L118:
        if (this.G0 <= 0) goto L121;
        b.a(this, r110, null, 0);
    L121:
        if (this.H0 <= 0) goto L160;
        b.a(this, r110, null, 1);
        return;
    L160:
        return;
    L88:
        r127 = 1;
        goto L89
    L93:
        int r130 = 0;
    L94:
        if (r130 >= r101) goto L118;
        ConstraintWidget r131 = (ConstraintWidget) ListProtector.get(this.f550644x0, r130);
        if ((r131 instanceof d) == false) goto L107;
        ConstraintWidget.DimensionBehaviour[] r132 = r131.W;
        ConstraintWidget.DimensionBehaviour r133 = r132[0];
        ConstraintWidget.DimensionBehaviour r134 = r132[1];
        ConstraintWidget.DimensionBehaviour r135 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r133 != r135) goto L100;
        r131.O(ConstraintWidget.DimensionBehaviour.FIXED);
    L100:
        if (r134 != r135) goto L102;
        r131.P(ConstraintWidget.DimensionBehaviour.FIXED);
    L102:
        r131.d(r110, r100);
        if (r133 != r135) goto L105;
        r131.O(r133);
    L105:
        if (r134 != r135) goto L116;
        r131.P(r134);
    L116:
        r130 = r130 + 1;
        goto L94
    L107:
        g.a(this, r110, r131);
        if ((r131 instanceof i) == false) goto L110;
    L113:
        boolean r136 = true;
    L114:
        if (r136 == true) goto L116;
        r131.d(r110, r100);
        goto L116
    L110:
        if ((r131 instanceof f) == true) goto L113;
        r136 = false;
        goto L114
    }

    public final boolean Y(int r100) {
        if ((this.K0 & r100) != r100) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public final void q(StringBuilder r100) {
        r100.append(this.f399723l + ":{\n");
        StringBuilder r101 = new StringBuilder("  actualWidth:");
        r101.append(this.Y);
        r100.append(r101.toString());
        r100.append("\n");
        r100.append("  actualHeight:" + this.Z);
        r100.append("\n");
        Iterator<ConstraintWidget> r102 = this.f550644x0.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().q(r100);
        r100.append(",\n");
        goto L4
    L6:
        r100.append(com.alipay.sdk.m.u.i.f25855d);
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.ConstraintWidget
    public final void R(boolean r100, boolean r101) {
        super.R(r100, r101);
        int r102 = this.f550644x0.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        ((ConstraintWidget) ListProtector.get(this.f550644x0, r103)).R(r100, r101);
        r103 = r103 + 1;
        goto L3
    }

    public final void U(ConstraintWidget r100, int r101) {
        if (r101 != 0) goto L8;
        int r102 = this.G0 + 1;
        c[] r103 = this.J0;
        if (r102 < r103.length) goto L7;
        this.J0 = (c[]) Arrays.copyOf(r103, r103.length * 2);
    L7:
        c[] r104 = this.J0;
        int r105 = this.G0;
        r104[r105] = new c(r100, 0, this.C0);
        this.G0 = r105 + 1;
        return;
    L8:
        if (r101 != 1) goto L15;
        int r106 = this.H0 + 1;
        c[] r107 = this.I0;
        if (r106 < r107.length) goto L12;
        this.I0 = (c[]) Arrays.copyOf(r107, r107.length * 2);
    L12:
        c[] r108 = this.I0;
        int r109 = this.H0;
        r108[r109] = new c(r100, 1, this.C0);
        this.H0 = r109 + 1;
        return;
    }

    public final boolean W(boolean r110, int r111) {
        com.obric.oui.constraintlayout.core.widgets.analyzer.e r100 = this.f399835z0;
        boolean r101 = true;
        boolean r112 = r110 & true;
        ConstraintWidget.DimensionBehaviour r102 = r100.f399794a.m(0);
        ConstraintWidget.DimensionBehaviour r103 = r100.f399794a.m(1);
        int r104 = r100.f399794a.u();
        int r105 = r100.f399794a.v();
        if (r112 == false) goto L24;
        ConstraintWidget.DimensionBehaviour r106 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r102 == r106) goto L7;
        if (r103 != r106) goto L24;
    L7:
        Iterator<WidgetRun> r107 = r100.f399798e.iterator();
    L9:
        if (r107.hasNext() == false) goto L15;
        WidgetRun r108 = r107.next();
        if (r108.f399772f != r111) goto L9;
        if (r108.j() == true) goto L9;
        r112 = false;
    L15:
        if (r111 != 0) goto L20;
        if (r112 == false) goto L24;
        if (r102 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L24;
        r100.f399794a.O(ConstraintWidget.DimensionBehaviour.FIXED);
        d r113 = r100.f399794a;
        r113.Q(r100.d(r113, 0));
        d r114 = r100.f399794a;
        r114.f399707d.f399771e.c(r114.t());
        goto L24
    L20:
        if (r112 == false) goto L24;
        if (r103 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L24;
        r100.f399794a.P(ConstraintWidget.DimensionBehaviour.FIXED);
        d r115 = r100.f399794a;
        r115.N(r100.d(r115, 1));
        d r116 = r100.f399794a;
        r116.f399709e.f399771e.c(r116.n());
    L24:
        if (r111 != 0) goto L30;
        d r117 = r100.f399794a;
        ConstraintWidget.DimensionBehaviour r109 = r117.W[0];
        if (r109 != ConstraintWidget.DimensionBehaviour.FIXED) goto L28;
    L29:
        int r118 = r117.t() + r104;
        r100.f399794a.f399707d.f399775i.c(r118);
        r100.f399794a.f399707d.f399771e.c(r118 - r104);
    L37:
        boolean r119 = true;
    L38:
        r100.g();
        Iterator<WidgetRun> r120 = r100.f399798e.iterator();
    L40:
        if (r120.hasNext() == false) goto L50;
        WidgetRun r121 = r120.next();
        if (r121.f399772f != r111) goto L40;
        if (r121.f399768b != r100.f399794a) goto L49;
        if (r121.f399773g == false) goto L40;
    L49:
        r121.d();
        goto L40
    L50:
        Iterator<WidgetRun> r122 = r100.f399798e.iterator();
    L52:
        if (r122.hasNext() == false) goto L71;
        WidgetRun r123 = r122.next();
        if (r123.f399772f != r111) goto L52;
        if (r119 == true) goto L61;
        if (r123.f399768b == r100.f399794a) goto L52;
    L61:
        if (r123.f399774h.f399763j == false) goto L70;
        if (r123.f399775i.f399763j == false) goto L70;
        if ((r123 instanceof com.obric.oui.constraintlayout.core.widgets.analyzer.c) == true) goto L52;
        if (r123.f399771e.f399763j == true) goto L52;
    L70:
        r101 = false;
    L71:
        r100.f399794a.O(r102);
        r100.f399794a.P(r103);
        return r101;
    L28:
        if (r109 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L29;
    L35:
        r119 = false;
        goto L38
    L30:
        d r124 = r100.f399794a;
        ConstraintWidget.DimensionBehaviour r125 = r124.W[1];
        if (r125 != ConstraintWidget.DimensionBehaviour.FIXED) goto L33;
    L36:
        int r126 = r124.n() + r105;
        r100.f399794a.f399709e.f399775i.c(r126);
        r100.f399794a.f399709e.f399771e.c(r126 - r105);
        goto L37
    L33:
        if (r125 != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) goto L35;
        goto L35
    }

    public static void X(ConstraintWidget r100, com.obric.oui.constraintlayout.core.widgets.analyzer.b.InterfaceC4669b r101, com.obric.oui.constraintlayout.core.widgets.analyzer.b.a r102) {
        if (r101 != null) goto L5;
        return;
    L5:
        if (r100.f399722k0 != 8) goto L7;
    L90:
        r102.f399786e = 0;
        r102.f399787f = 0;
        return;
    L7:
        if ((r100 instanceof f) == true) goto L90;
        if ((r100 instanceof a) == true) goto L90;
        ConstraintWidget.DimensionBehaviour[] r103 = r100.W;
        r102.f399782a = r103[0];
        boolean r104 = true;
        r102.f399783b = r103[1];
        r102.f399784c = r100.t();
        r102.f399785d = r100.n();
        r102.f399790i = false;
        r102.f399791j = 0;
        ConstraintWidget.DimensionBehaviour r105 = r102.f399782a;
        ConstraintWidget.DimensionBehaviour r106 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r105 != r106) goto L14;
        boolean r107 = true;
    L16:
        if (r102.f399783b != r106) goto L18;
        boolean r108 = true;
    L20:
        if (r107 == true) goto L22;
    L24:
        boolean r109 = false;
    L25:
        if (r108 == true) goto L27;
    L29:
        boolean r110 = false;
    L30:
        if (r107 == true) goto L32;
    L42:
        if (r108 == false) goto L55;
        if (r100.w(1) == false) goto L55;
        if (r100.f399741u != 0) goto L55;
        if (r110 == true) goto L55;
        r102.f399783b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r107 == true) goto L51;
    L53:
        r108 = false;
        goto L55
    L51:
        if (r100.f399739t != 0) goto L53;
        r102.f399783b = ConstraintWidget.DimensionBehaviour.FIXED;
    L55:
        if (r100.D() == false) goto L58;
        r102.f399782a = ConstraintWidget.DimensionBehaviour.FIXED;
        r107 = false;
    L58:
        if (r100.E() == false) goto L61;
        r102.f399783b = ConstraintWidget.DimensionBehaviour.FIXED;
        r108 = false;
    L61:
        if (r109 == true) goto L63;
    L71:
        if (r110 == true) goto L73;
    L84:
        ((ConstraintLayout.b) r101).b(r100, r102);
        r100.Q(r102.f399786e);
        r100.N(r102.f399787f);
        r100.G = r102.f399789h;
        int r111 = r102.f399788g;
        r100.f399710e0 = r111;
        if (r111 > 0) goto L88;
        r104 = false;
    L88:
        r100.G = r104;
        r102.f399791j = 0;
        return;
    L73:
        if (r100.f399743v[1] != 4) goto L75;
        r102.f399783b = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L84
    L75:
        if (r107 == true) goto L84;
        ConstraintWidget.DimensionBehaviour r112 = r102.f399782a;
        ConstraintWidget.DimensionBehaviour r113 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r112 != r113) goto L79;
        int r114 = r102.f399784c;
    L80:
        r102.f399783b = r113;
        if (r100.f399704b0 != (-1)) goto L83;
        r102.f399785d = (int) (r114 / r100.f399702a0);
        goto L84
    L83:
        r102.f399785d = (int) (r100.f399702a0 * r114);
        goto L84
    L79:
        r102.f399783b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        ((ConstraintLayout.b) r101).b(r100, r102);
        r114 = r102.f399786e;
        goto L80
    L63:
        if (r100.f399743v[0] != 4) goto L65;
        r102.f399782a = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L71
    L65:
        if (r108 == true) goto L71;
        ConstraintWidget.DimensionBehaviour r115 = r102.f399783b;
        ConstraintWidget.DimensionBehaviour r116 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (r115 != r116) goto L69;
        int r117 = r102.f399785d;
    L70:
        r102.f399782a = r116;
        r102.f399784c = (int) (r100.f399702a0 * r117);
        goto L71
    L69:
        r102.f399782a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        ((ConstraintLayout.b) r101).b(r100, r102);
        r117 = r102.f399787f;
        goto L70
    L32:
        if (r100.w(0) == false) goto L42;
        if (r100.f399739t != 0) goto L42;
        if (r109 == true) goto L42;
        r102.f399782a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (r108 == true) goto L39;
    L41:
        r107 = false;
        goto L42
    L39:
        if (r100.f399741u != 0) goto L41;
        r102.f399782a = ConstraintWidget.DimensionBehaviour.FIXED;
        goto L41
    L27:
        if (r100.f399702a0 <= 0.0f) goto L29;
        r110 = true;
        goto L30
    L22:
        if (r100.f399702a0 <= 0.0f) goto L24;
        r109 = true;
        goto L25
    L18:
        r108 = false;
        goto L20
    L14:
        r107 = false;
        goto L16
    }
}
