package com.obric.oui.constraintlayout.core.widgets.analyzer;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.oui.constraintlayout.core.widgets.ConstraintAnchor;
import com.obric.oui.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes34.dex */
public final class c extends WidgetRun {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList<WidgetRun> f399792k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f399793l;

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void d() {
        int r100 = 0;
    L4:
        if (r100 >= this.f399792k.size()) goto L6;
        ((WidgetRun) ListProtector.get(this.f399792k, r100)).d();
        r100 = r100 + 1;
        goto L4
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void e() {
        this.f399769c = null;
        Iterator<WidgetRun> r100 = this.f399792k.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().e();
        goto L4
    }

    public final ConstraintWidget l() {
        int r100 = 0;
    L4:
        if (r100 >= this.f399792k.size()) goto L9;
        ConstraintWidget r101 = ((WidgetRun) ListProtector.get(this.f399792k, r100)).f399768b;
        if (r101.f399722k0 != 8) goto L7;
        r100 = r100 + 1;
        goto L4
    L7:
        return r101;
    L9:
        return null;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void c() {
        Iterator<WidgetRun> r100 = this.f399792k.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().c();
        goto L4
    L6:
        int r101 = this.f399792k.size();
        if (r101 >= 1) goto L9;
        return;
    L9:
        ConstraintWidget r102 = ((WidgetRun) ListProtector.get(this.f399792k, 0)).f399768b;
        ConstraintWidget r103 = ((WidgetRun) ListProtector.get(this.f399792k, r101 - 1)).f399768b;
        if (this.f399772f != 0) goto L21;
        ConstraintAnchor r104 = r102.L;
        ConstraintAnchor r105 = r103.N;
        DependencyNode r106 = WidgetRun.h(r104, 0);
        int r107 = r104.e();
        ConstraintWidget r108 = l();
        if (r108 == null) goto L14;
        r107 = r108.L.e();
    L14:
        if (r106 == null) goto L16;
        WidgetRun.a(this.f399774h, r106, r107);
    L16:
        DependencyNode r109 = WidgetRun.h(r105, 0);
        int r110 = r105.e();
        ConstraintWidget r111 = m();
        if (r111 == null) goto L19;
        r110 = r111.N.e();
    L19:
        if (r109 == null) goto L31;
        WidgetRun.a(this.f399775i, r109, -r110);
    L31:
        this.f399774h.f399754a = this;
        this.f399775i.f399754a = this;
        return;
    L21:
        ConstraintAnchor r112 = r102.M;
        ConstraintAnchor r113 = r103.O;
        DependencyNode r114 = WidgetRun.h(r112, 1);
        int r115 = r112.e();
        ConstraintWidget r116 = l();
        if (r116 == null) goto L24;
        r115 = r116.M.e();
    L24:
        if (r114 == null) goto L26;
        WidgetRun.a(this.f399774h, r114, r115);
    L26:
        DependencyNode r117 = WidgetRun.h(r113, 1);
        int r118 = r113.e();
        ConstraintWidget r119 = m();
        if (r119 == null) goto L29;
        r118 = r119.O.e();
    L29:
        if (r117 == null) goto L31;
        WidgetRun.a(this.f399775i, r117, -r118);
        goto L31
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public final long i() {
        int r100 = this.f399792k.size();
        long r101 = 0;
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L5;
        WidgetRun r103 = (WidgetRun) ListProtector.get(this.f399792k, r102);
        r101 = ((r101 + ((long) r103.f399774h.f399759f)) + r103.i()) + ((long) r103.f399775i.f399759f);
        r102 = r102 + 1;
        goto L3
    L5:
        return r101;
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun
    public final boolean j() {
        int r100 = this.f399792k.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L8;
        if (((WidgetRun) ListProtector.get(this.f399792k, r101)).j() == false) goto L6;
        r101 = r101 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public final ConstraintWidget m() {
        int r100 = this.f399792k.size() - 1;
    L3:
        if (r100 < 0) goto L8;
        ConstraintWidget r101 = ((WidgetRun) ListProtector.get(this.f399792k, r100)).f399768b;
        if (r101.f399722k0 != 8) goto L6;
        r100 = r100 - 1;
        goto L3
    L6:
        return r101;
    L8:
        return null;
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("ChainRun ");
        if (this.f399772f != 0) goto L5;
        String r101 = "horizontal : ";
    L6:
        r100.append(r101);
        Iterator<WidgetRun> r102 = this.f399792k.iterator();
    L8:
        if (r102.hasNext() == false) goto L11;
        WidgetRun r103 = r102.next();
        r100.append("<");
        r100.append(r103);
        r100.append("> ");
        goto L8
    L11:
        return r100.toString();
    L5:
        r101 = "vertical : ";
        goto L6
    }

    @Override // com.obric.oui.constraintlayout.core.widgets.analyzer.WidgetRun, com.obric.oui.constraintlayout.core.widgets.analyzer.d
    public void update(d r210) {
        DependencyNode r100 = this.f399774h;
        if (r100.f399763j == false) goto L282;
        DependencyNode r101 = this.f399775i;
        if (r101.f399763j == false) goto L324;
        ConstraintWidget r102 = this.f399768b.X;
        if ((r102 instanceof com.obric.oui.constraintlayout.core.widgets.d) == false) goto L10;
        boolean r103 = ((com.obric.oui.constraintlayout.core.widgets.d) r102).C0;
    L11:
        int r104 = r101.f399760g - r100.f399760g;
        int r105 = this.f399792k.size();
        int r106 = 0;
    L12:
        int r107 = -1;
        int r108 = 8;
        if (r106 >= r105) goto L17;
        if (((WidgetRun) ListProtector.get(this.f399792k, r106)).f399768b.f399722k0 != 8) goto L18;
        r106 = r106 + 1;
    L18:
        int r109 = r105 - 1;
        int r110 = r109;
    L19:
        if (r110 < 0) goto L24;
        if (((WidgetRun) ListProtector.get(this.f399792k, r110)).f399768b.f399722k0 != 8) goto L23;
        r110 = r110 - 1;
        goto L19
    L23:
        r107 = r110;
    L24:
        int r111 = 0;
    L26:
        if (r111 >= 2) goto L75;
        int r112 = 0;
        int r113 = 0;
        int r114 = 0;
        int r115 = 0;
        float r116 = 0.0f;
    L28:
        if (r112 >= r105) goto L70;
        WidgetRun r117 = (WidgetRun) ListProtector.get(this.f399792k, r112);
        ConstraintWidget r118 = r117.f399768b;
        if (r118.f399722k0 == r108) goto L69;
        r115 = r115 + 1;
        if (r112 <= 0) goto L36;
        if (r112 < r106) goto L36;
        r113 = r113 + r117.f399774h.f399759f;
    L36:
        f r119 = r117.f399771e;
        int r120 = r119.f399760g;
        if (r117.f399770d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L39;
        boolean r121 = true;
    L40:
        if (r121 == false) goto L53;
        int r122 = this.f399772f;
        if (r122 != 0) goto L47;
        if (r118.f399707d.f399771e.f399763j == true) goto L47;
        return;
    L47:
        if (r122 != 1) goto L60;
        if (r118.f399709e.f399771e.f399763j == true) goto L60;
        return;
    L60:
        int r123 = r120;
    L61:
        if (r121 == true) goto L65;
        r114 = r114 + 1;
        float r124 = r118.f399734q0[this.f399772f];
        if (r124 < 0.0f) goto L66;
        r116 = r116 + r124;
    L66:
        if (r112 >= r109) goto L69;
        if (r112 >= r107) goto L69;
        r113 = r113 + (-r117.f399775i.f399759f);
        goto L69
    L65:
        r113 = r113 + r123;
        goto L66
    L53:
        if (r117.f399767a != 1) goto L57;
        if (r111 != 0) goto L57;
        r123 = r119.f399802m;
        r114 = r114 + 1;
    L59:
        r121 = true;
    L57:
        if (r119.f399763j == false) goto L60;
        r123 = r120;
        goto L59
    L39:
        r121 = false;
    L69:
        r112 = r112 + 1;
        r108 = 8;
        goto L28
    L70:
        if (r113 < r104) goto L74;
        if (r114 == 0) goto L74;
        r111 = r111 + 1;
        r108 = 8;
    L74:
        int r125 = r115;
    L76:
        int r126 = this.f399774h.f399760g;
        if (r103 == false) goto L80;
        r126 = this.f399775i.f399760g;
    L80:
        if (r113 > r104) goto L82;
    L85:
        if (r114 <= 0) goto L137;
        float r127 = r104 - r113;
        int r128 = (int) ((r127 / r114) + 0.5f);
        int r129 = 0;
        int r130 = 0;
    L87:
        if (r129 >= r105) goto L115;
        WidgetRun r131 = (WidgetRun) ListProtector.get(this.f399792k, r129);
        int r132 = r128;
        ConstraintWidget r133 = r131.f399768b;
        int r211 = r113;
        int r212 = r126;
        if (r133.f399722k0 != 8) goto L92;
    L113:
        r103 = r103;
    L114:
        r129 = r129 + 1;
        r128 = r132;
        r113 = r211;
        r126 = r212;
        r103 = r103;
        r127 = r127;
        r125 = r125;
        goto L87
    L92:
        if (r131.f399770d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L113;
        f r134 = r131.f399771e;
        if (r134.f399763j == true) goto L113;
        if (r116 <= 0.0f) goto L98;
        int r135 = (int) (((r133.f399734q0[this.f399772f] * r127) / r116) + 0.5f);
    L100:
        if (this.f399772f != 0) goto L102;
        int r136 = r133.f399747x;
        int r137 = r133.f399745w;
    L104:
        if (r131.f399767a != 1) goto L106;
        int r138 = Math.min(r135, r134.f399802m);
    L107:
        int r139 = Math.max(r137, r138);
        if (r136 <= 0) goto L110;
        r139 = Math.min(r136, r139);
    L110:
        if (r139 == r135) goto L112;
        r130 = r130 + 1;
        r135 = r139;
    L112:
        r131.f399771e.c(r135);
        goto L114
    L106:
        r138 = r135;
        goto L107
    L102:
        r136 = r133.A;
        r137 = r133.f399749z;
        goto L104
    L98:
        r135 = r132;
        goto L100
    L115:
        boolean r213 = r103;
        int r214 = r125;
        int r215 = r126;
        int r216 = r113;
        if (r130 <= 0) goto L131;
        r114 = r114 - r130;
        int r140 = 0;
        int r141 = 0;
    L118:
        if (r140 >= r105) goto L130;
        WidgetRun r142 = (WidgetRun) ListProtector.get(this.f399792k, r140);
        if (r142.f399768b.f399722k0 == 8) goto L129;
        if (r140 <= 0) goto L125;
        if (r140 < r106) goto L125;
        r141 = r141 + r142.f399774h.f399759f;
    L125:
        r141 = r141 + r142.f399771e.f399760g;
        if (r140 >= r109) goto L129;
        if (r140 >= r107) goto L129;
        r141 = r141 + (-r142.f399775i.f399759f);
    L129:
        r140 = r140 + 1;
        goto L118
    L130:
        r113 = r141;
    L132:
        int r143 = 2;
        if (this.f399793l != 2) goto L138;
        if (r130 != 0) goto L138;
        this.f399793l = 0;
    L138:
        if (r113 <= r104) goto L140;
        this.f399793l = r143;
    L140:
        if (r214 <= 0) goto L144;
        if (r114 != 0) goto L144;
        if (r106 != r107) goto L144;
        this.f399793l = r143;
    L144:
        int r144 = this.f399793l;
        if (r144 != 1) goto L192;
        int r145 = r214;
        if (r145 <= 1) goto L149;
        int r146 = (r104 - r113) / (r145 - 1);
    L152:
        if (r114 <= 0) goto L154;
        r146 = 0;
    L154:
        int r147 = r215;
        int r148 = 0;
    L155:
        if (r148 >= r105) goto L325;
        if (r213 == false) goto L158;
        int r149 = r105 - (r148 + 1);
    L159:
        WidgetRun r150 = (WidgetRun) ListProtector.get(this.f399792k, r149);
        if (r150.f399768b.f399722k0 != 8) goto L162;
        r150.f399774h.c(r147);
        r150.f399775i.c(r147);
    L191:
        r148 = r148 + 1;
        goto L155
    L162:
        if (r148 <= 0) goto L166;
        if (r213 == false) goto L165;
        r147 = r147 - r146;
        goto L166
    L165:
        r147 = r147 + r146;
    L166:
        if (r148 <= 0) goto L171;
        if (r148 < r106) goto L171;
        if (r213 == false) goto L170;
        r147 = r147 - r150.f399774h.f399759f;
        goto L171
    L170:
        r147 = r147 + r150.f399774h.f399759f;
    L171:
        if (r213 == false) goto L173;
        r150.f399775i.c(r147);
    L174:
        f r151 = r150.f399771e;
        int r152 = r151.f399760g;
        if (r150.f399770d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L177;
    L179:
        if (r213 == false) goto L181;
        r147 = r147 - r152;
    L182:
        if (r213 == false) goto L184;
        r150.f399774h.c(r147);
    L185:
        r150.f399773g = true;
        if (r148 >= r109) goto L191;
        if (r148 >= r107) goto L191;
        if (r213 == false) goto L190;
        r147 = r147 - (-r150.f399775i.f399759f);
        goto L191
    L190:
        r147 = r147 + (-r150.f399775i.f399759f);
        goto L191
    L184:
        r150.f399775i.c(r147);
        goto L185
    L181:
        r147 = r147 + r152;
        goto L182
    L177:
        if (r150.f399767a != 1) goto L179;
        r152 = r151.f399802m;
        goto L179
    L173:
        r150.f399774h.c(r147);
        goto L174
    L158:
        r149 = r148;
        goto L159
    L325:
        return;
    L149:
        if (r145 != 1) goto L151;
        r146 = (r104 - r113) / 2;
        goto L152
    L151:
        r146 = 0;
        goto L152
    L192:
        int r153 = r214;
        if (r144 != 0) goto L234;
        int r154 = (r104 - r113) / (r153 + 1);
        if (r114 <= 0) goto L197;
        r154 = 0;
    L197:
        int r155 = r215;
        int r156 = 0;
    L198:
        if (r156 >= r105) goto L326;
        if (r213 == false) goto L201;
        int r157 = r105 - (r156 + 1);
    L202:
        WidgetRun r158 = (WidgetRun) ListProtector.get(this.f399792k, r157);
        if (r158.f399768b.f399722k0 != 8) goto L205;
        r158.f399774h.c(r155);
        r158.f399775i.c(r155);
    L232:
        r156 = r156 + 1;
        goto L198
    L205:
        if (r213 == false) goto L207;
        int r159 = r155 - r154;
    L208:
        if (r156 <= 0) goto L213;
        if (r156 < r106) goto L213;
        if (r213 == false) goto L212;
        r159 = r159 - r158.f399774h.f399759f;
        goto L213
    L212:
        r159 = r159 + r158.f399774h.f399759f;
    L213:
        if (r213 == false) goto L215;
        r158.f399775i.c(r159);
    L216:
        f r160 = r158.f399771e;
        int r161 = r160.f399760g;
        if (r158.f399770d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L219;
    L221:
        if (r213 == false) goto L223;
        r155 = r159 - r161;
    L224:
        if (r213 == false) goto L226;
        r158.f399774h.c(r155);
    L227:
        if (r156 >= r109) goto L232;
        if (r156 >= r107) goto L232;
        if (r213 == false) goto L231;
        r155 = r155 - (-r158.f399775i.f399759f);
        goto L232
    L231:
        r155 = r155 + (-r158.f399775i.f399759f);
        goto L232
    L226:
        r158.f399775i.c(r155);
        goto L227
    L223:
        r155 = r159 + r161;
        goto L224
    L219:
        if (r158.f399767a != 1) goto L221;
        r161 = Math.min(r161, r160.f399802m);
        goto L221
    L215:
        r158.f399774h.c(r159);
        goto L216
    L207:
        r159 = r155 + r154;
        goto L208
    L201:
        r157 = r156;
        goto L202
    L326:
        return;
    L234:
        if (r144 == 2) goto L236;
        return;
    L236:
        if (this.f399772f != 0) goto L238;
        float r162 = this.f399768b.f399716h0;
    L239:
        if (r213 == false) goto L241;
        r162 = 1.0f - r162;
    L241:
        int r163 = (int) (((r104 - r113) * r162) + 0.5f);
        if (r163 < 0) goto L244;
        if (r114 > 0) goto L244;
    L245:
        if (r213 == false) goto L247;
        int r164 = r215 - r163;
    L248:
        int r165 = 0;
    L249:
        if (r165 >= r105) goto L327;
        if (r213 == false) goto L252;
        int r166 = r105 - (r165 + 1);
    L253:
        WidgetRun r167 = (WidgetRun) ListProtector.get(this.f399792k, r166);
        if (r167.f399768b.f399722k0 != 8) goto L256;
        r167.f399774h.c(r164);
        r167.f399775i.c(r164);
    L281:
        r165 = r165 + 1;
        goto L249
    L256:
        if (r165 <= 0) goto L261;
        if (r165 < r106) goto L261;
        if (r213 == false) goto L260;
        r164 = r164 - r167.f399774h.f399759f;
        goto L261
    L260:
        r164 = r164 + r167.f399774h.f399759f;
    L261:
        if (r213 == false) goto L263;
        r167.f399775i.c(r164);
    L264:
        f r168 = r167.f399771e;
        int r169 = r168.f399760g;
        if (r167.f399770d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L270;
        if (r167.f399767a != 1) goto L270;
        r169 = r168.f399802m;
    L270:
        if (r213 == false) goto L272;
        r164 = r164 - r169;
    L273:
        if (r213 == false) goto L275;
        r167.f399774h.c(r164);
    L276:
        if (r165 >= r109) goto L281;
        if (r165 >= r107) goto L281;
        if (r213 == false) goto L280;
        r164 = r164 - (-r167.f399775i.f399759f);
        goto L281
    L280:
        r164 = r164 + (-r167.f399775i.f399759f);
        goto L281
    L275:
        r167.f399775i.c(r164);
        goto L276
    L272:
        r164 = r164 + r169;
        goto L273
    L263:
        r167.f399774h.c(r164);
        goto L264
    L252:
        r166 = r165;
        goto L253
    L327:
        return;
    L247:
        r164 = r215 + r163;
    L244:
        r163 = 0;
        goto L245
    L238:
        r162 = this.f399768b.f399718i0;
        goto L239
    L131:
        r113 = r216;
        goto L132
    L137:
        r213 = r103;
        r214 = r125;
        r215 = r126;
        r143 = 2;
        goto L138
    L82:
        if (r103 == false) goto L84;
        r126 = r126 + ((int) (((r113 - r104) / 2.0f) + 0.5f));
        goto L85
    L84:
        r126 = r126 - ((int) (((r113 - r104) / 2.0f) + 0.5f));
        goto L85
    L75:
        r125 = 0;
        r113 = 0;
        r114 = 0;
        r116 = 0.0f;
        goto L76
    L17:
        r106 = -1;
        goto L18
    L10:
        r103 = false;
        goto L11
    L324:
        return;
    }

    public c(ConstraintWidget r100, int r101) {
        super(r100);
        this.f399792k = new ArrayList();
        this.f399772f = r101;
        ConstraintWidget r102 = this.f399768b;
        ConstraintWidget r103 = r102.p(r101);
    L3:
        ConstraintWidget r104 = r103;
        ConstraintWidget r105 = r102;
        r102 = r104;
        if (r102 == null) goto L6;
        r103 = r102.p(this.f399772f);
        goto L3
    L6:
        this.f399768b = r105;
        ArrayList<WidgetRun> r106 = this.f399792k;
        int r107 = this.f399772f;
        if (r107 != 0) goto L9;
        WidgetRun r108 = r105.f399707d;
    L12:
        r106.add(r108);
        ConstraintWidget r109 = r105.o(this.f399772f);
    L13:
        if (r109 == null) goto L21;
        ArrayList<WidgetRun> r110 = this.f399792k;
        int r111 = this.f399772f;
        if (r111 != 0) goto L17;
        WidgetRun r112 = r109.f399707d;
    L20:
        r110.add(r112);
        r109 = r109.o(this.f399772f);
        goto L13
    L17:
        if (r111 != 1) goto L19;
        r112 = r109.f399709e;
        goto L20
    L19:
        r112 = null;
        goto L20
    L21:
        Iterator<WidgetRun> r113 = this.f399792k.iterator();
    L23:
        if (r113.hasNext() == false) goto L30;
        WidgetRun r114 = r113.next();
        int r115 = this.f399772f;
        if (r115 == 0) goto L26;
        if (r115 != 1) goto L23;
        r114.f399768b.f399705c = this;
        goto L23
    L26:
        r114.f399768b.f399703b = this;
        goto L23
    L30:
        if (this.f399772f == 0) goto L32;
    L34:
        boolean r116 = false;
    L35:
        if (r116 == false) goto L40;
        if (this.f399792k.size() <= 1) goto L40;
        ArrayList<WidgetRun> r117 = this.f399792k;
        this.f399768b = ((WidgetRun) ListProtector.get(r117, r117.size() - 1)).f399768b;
    L40:
        if (this.f399772f != 0) goto L42;
        int r118 = this.f399768b.f399730o0;
    L43:
        this.f399793l = r118;
        return;
    L42:
        r118 = this.f399768b.f399732p0;
        goto L43
    L32:
        if (((com.obric.oui.constraintlayout.core.widgets.d) this.f399768b.X).C0 == false) goto L34;
        r116 = true;
        goto L35
    L9:
        if (r107 != 1) goto L11;
        r108 = r105.f399709e;
        goto L12
    L11:
        r108 = null;
        goto L12
    }
}
