package com.obric.oui.constraintlayout.core.widgets;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.oui.constraintlayout.core.SolverVariable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes34.dex */
public final class b {
    public static void a(d r310, com.obric.oui.constraintlayout.core.c r311, ArrayList<ConstraintWidget> r312, int r313) {
        d r100 = r310;
        if (r313 != 0) goto L5;
        int r110 = r100.G0;
        c[] r111 = r100.J0;
        int r112 = 0;
    L6:
        int r101 = 0;
    L7:
        if (r101 >= r110) goto L419;
        c r102 = r111[r101];
        int r103 = 8;
        int r104 = 1;
        SolverVariable r113 = null;
        if (r102.f399833q == true) goto L87;
        int r105 = r102.f399828l * 2;
        ConstraintWidget r106 = r102.f399817a;
        ConstraintWidget r107 = r106;
        boolean r108 = false;
    L11:
        if (r108 == true) goto L68;
        r102.f399825i += r104;
        ConstraintWidget[] r114 = r106.f399738s0;
        int r109 = r102.f399828l;
        r114[r109] = null;
        r106.f399736r0[r109] = null;
        if (r106.f399722k0 == r103) goto L55;
        ConstraintWidget.DimensionBehaviour r115 = r106.m(r109);
        ConstraintWidget.DimensionBehaviour r116 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r115 == r116) goto L17;
        int r117 = r102.f399828l;
    L17:
        r106.T[r105].e();
        int r118 = r105 + 1;
        r106.T[r118].e();
        r106.T[r105].e();
        r106.T[r118].e();
        if (r102.f399818b != null) goto L20;
        r102.f399818b = r106;
    L20:
        r102.f399820d = r106;
        ConstraintWidget.DimensionBehaviour[] r119 = r106.W;
        int r120 = r102.f399828l;
        ConstraintWidget.DimensionBehaviour r121 = r119[r120];
        if (r121 != r116) goto L55;
        int r122 = r106.f399743v[r120];
        if (r122 == 0) goto L27;
        if (r122 == 3) goto L27;
        if (r122 != 2) goto L55;
    L27:
        r102.f399826j++;
        float r123 = r106.f399734q0[r120];
        if (r123 <= 0.0f) goto L31;
        r102.f399827k += r123;
    L31:
        if (r106.f399722k0 == 8) goto L37;
        if (r121 != r116) goto L37;
        if (r122 != 0) goto L35;
    L36:
        boolean r124 = true;
    L38:
        if (r124 == false) goto L48;
        if (r123 >= 0.0f) goto L42;
        r102.f399830n = true;
    L44:
        if (r102.f399824h != null) goto L46;
        r102.f399824h = new ArrayList();
    L46:
        r102.f399824h.add(r106);
        goto L48
    L42:
        r102.f399831o = true;
    L48:
        if (r102.f399822f != null) goto L50;
        r102.f399822f = r106;
    L50:
        ConstraintWidget r125 = r102.f399823g;
        if (r125 == null) goto L53;
        r125.f399736r0[r102.f399828l] = r106;
    L53:
        r102.f399823g = r106;
        goto L55
    L35:
        if (r122 == 3) goto L36;
    L37:
        r124 = false;
    L55:
        if (r107 == r106) goto L57;
        r107.f399738s0[r102.f399828l] = r106;
    L57:
        ConstraintAnchor r126 = r106.T[r105 + 1].f399694f;
        if (r126 == null) goto L63;
        ConstraintWidget r127 = r126.f399692d;
        ConstraintAnchor r128 = r127.T[r105].f399694f;
        if (r128 == null) goto L63;
        if (r128.f399692d != r106) goto L63;
    L64:
        if (r127 == null) goto L66;
        r108 = r108;
    L67:
        r107 = r106;
        r104 = 1;
        r103 = 8;
        r106 = r127;
        goto L11
    L66:
        r127 = r106;
        r108 = true;
    L63:
        r127 = null;
        goto L64
    L68:
        ConstraintWidget r129 = r102.f399818b;
        if (r129 == null) goto L71;
        r129.T[r105].e();
    L71:
        ConstraintWidget r130 = r102.f399820d;
        if (r130 == null) goto L74;
        r130.T[r105 + 1].e();
    L74:
        r102.f399819c = r106;
        if (r102.f399828l == 0) goto L77;
    L79:
        r102.f399821e = r102.f399817a;
    L81:
        if (r102.f399831o == true) goto L83;
    L85:
        boolean r131 = false;
    L86:
        r102.f399832p = r131;
        goto L87
    L83:
        if (r102.f399830n == false) goto L85;
        r131 = true;
        goto L86
    L77:
        if (r102.f399829m == false) goto L79;
        r102.f399821e = r106;
    L87:
        r102.f399833q = true;
        if (r312 != 0) goto L90;
    L93:
        ConstraintWidget r132 = r102.f399817a;
        ConstraintWidget r133 = r102.f399819c;
        ConstraintWidget r134 = r102.f399818b;
        ConstraintWidget r135 = r102.f399820d;
        ConstraintWidget r136 = r102.f399821e;
        float r137 = r102.f399827k;
        if (r100.W[r313] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) goto L96;
        boolean r138 = true;
    L97:
        if (r313 != 0) goto L109;
        int r139 = r136.f399730o0;
        if (r139 != 0) goto L101;
        boolean r210 = true;
    L102:
        int r211 = r101;
        if (r139 != 1) goto L105;
        boolean r212 = true;
    L106:
        boolean r140 = r212;
        boolean r213 = r210;
        if (r139 == 2) goto L117;
    L119:
        boolean r214 = r213;
        boolean r141 = false;
    L118:
        boolean r215 = r140;
        ConstraintWidget r142 = r132;
        boolean r143 = false;
    L121:
        if (r143 == true) goto L177;
        ConstraintAnchor r144 = r142.T[r112];
        if (r141 == false) goto L125;
        int r216 = 1;
    L126:
        int r217 = r144.e();
        boolean r218 = r143;
        ConstraintWidget.DimensionBehaviour r145 = r142.W[r313];
        ConstraintWidget.DimensionBehaviour r146 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        if (r145 == r146) goto L129;
    L131:
        boolean r147 = false;
    L132:
        ConstraintAnchor r148 = r144.f399694f;
        if (r148 == null) goto L136;
        if (r142 == r132) goto L136;
        r217 = r217 + r148.e();
    L136:
        int r149 = r217;
        if (r141 == false) goto L142;
        if (r142 == r132) goto L142;
        if (r142 == r134) goto L142;
        r216 = 8;
    L142:
        ConstraintAnchor r150 = r144.f399694f;
        if (r150 == null) goto L157;
        if (r142 != r134) goto L146;
        r311.f(r144.f399697i, r150.f399697i, r149, 6);
    L147:
        if (r147 == false) goto L150;
        if (r141 == true) goto L150;
        r216 = 5;
    L150:
        if (r142 != r134) goto L155;
        if (r141 == false) goto L155;
        if (r142.V[r313] == false) goto L155;
        int r151 = 5;
    L156:
        r311.e(r144.f399697i, r144.f399694f.f399697i, r149, r151);
    L158:
        if (r138 == true) goto L160;
    L166:
        ConstraintAnchor r152 = r142.T[r112 + 1].f399694f;
        if (r152 == null) goto L172;
        ConstraintWidget r153 = r152.f399692d;
        ConstraintAnchor r154 = r153.T[r112].f399694f;
        if (r154 == null) goto L172;
        if (r154.f399692d != r142) goto L172;
    L173:
        if (r153 == null) goto L175;
        r142 = r153;
        r143 = r218;
    L176:
        r111 = r111;
        r110 = r110;
        r136 = r136;
        r132 = r132;
        goto L121
    L175:
        r143 = true;
    L172:
        r153 = null;
        goto L173
    L160:
        if (r142.f399722k0 != 8) goto L162;
    L164:
        int r155 = 0;
    L165:
        r311.f(r142.T[r112].f399697i, r100.T[r112].f399697i, r155, 8);
        goto L166
    L162:
        if (r142.W[r313] != r146) goto L164;
        ConstraintAnchor[] r156 = r142.T;
        r155 = 0;
        r311.f(r156[r112 + 1].f399697i, r156[r112].f399697i, 0, 5);
    L155:
        r151 = r216;
        goto L156
    L146:
        r311.f(r144.f399697i, r150.f399697i, r149, 8);
        goto L147
    L157:
        r136 = r136;
        r132 = r132;
        goto L158
    L129:
        if (r142.f399743v[r313] != 0) goto L131;
        r147 = true;
        goto L132
    L125:
        r216 = 4;
        goto L126
    L177:
        ConstraintWidget r314 = r136;
        ConstraintWidget r315 = r132;
        int r316 = r110;
        c[] r219 = r111;
        if (r135 == null) goto L199;
        int r157 = r112 + 1;
        if (r133.T[r157].f399694f == null) goto L199;
        ConstraintAnchor r158 = r135.T[r157];
        if (r135.W[r313] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) goto L184;
    L186:
        boolean r159 = false;
    L187:
        if (r159 == false) goto L193;
        if (r141 == true) goto L193;
        ConstraintAnchor r160 = r158.f399694f;
        if (r160.f399692d != r100) goto L193;
        r311.e(r158.f399697i, r160.f399697i, -r158.e(), 5);
    L197:
        r311.g(r158.f399697i, r133.T[r157].f399694f.f399697i, -r158.e(), 6);
    L193:
        if (r141 == false) goto L197;
        ConstraintAnchor r161 = r158.f399694f;
        if (r161.f399692d != r100) goto L197;
        r311.e(r158.f399697i, r161.f399697i, -r158.e(), 4);
        goto L197
    L184:
        if (r135.f399743v[r313] != 0) goto L186;
        r159 = true;
    L199:
        if (r138 == false) goto L201;
        int r162 = r112 + 1;
        SolverVariable r163 = r100.T[r162].f399697i;
        ConstraintAnchor r164 = r133.T[r162];
        r311.f(r163, r164.f399697i, r164.e(), 8);
    L201:
        ArrayList<ConstraintWidget> r165 = r102.f399824h;
        if (r165 == null) goto L243;
        int r166 = r165.size();
        if (r166 <= 1) goto L243;
        if (r102.f399830n == true) goto L208;
    L210:
        float r167 = r137;
    L211:
        ConstraintWidget r168 = null;
        float r169 = 0.0f;
        int r170 = 0;
    L212:
        if (r170 >= r166) goto L243;
        ConstraintWidget r171 = (ConstraintWidget) ListProtector.get(r165, r170);
        float r172 = r171.f399734q0[r313];
        if (r172 >= 0.0f) goto L221;
        if (r102.f399832p == false) goto L218;
        ConstraintAnchor[] r173 = r171.T;
        r311.e(r173[r112 + 1].f399697i, r173[r112].f399697i, 0, 4);
    L223:
        r102 = r102;
        r165 = r165;
        r166 = r166;
    L242:
        r170 = r170 + 1;
        r102 = r102;
        r166 = r166;
        r165 = r165;
        goto L212
    L218:
        r172 = 1.0f;
    L221:
        if (r172 != 0.0f) goto L225;
        ConstraintAnchor[] r174 = r171.T;
        r311.e(r174[r112 + 1].f399697i, r174[r112].f399697i, 0, 8);
        goto L223
    L225:
        if (r168 == null) goto L241;
        ConstraintAnchor[] r175 = r168.T;
        SolverVariable r176 = r175[r112].f399697i;
        int r220 = r112 + 1;
        SolverVariable r177 = r175[r220].f399697i;
        ConstraintAnchor[] r178 = r171.T;
        SolverVariable r179 = r178[r112].f399697i;
        SolverVariable r180 = r178[r220].f399697i;
        com.obric.oui.constraintlayout.core.b r181 = r311.l();
        r181.f399630b = 0.0f;
        if (r167 != 0.0f) goto L229;
    L238:
        r181.f399632d.e(r176, 1.0f);
        r181.f399632d.e(r177, -1.0f);
        r181.f399632d.e(r180, 1.0f);
        r181.f399632d.e(r179, -1.0f);
    L239:
        r311.c(r181);
        goto L241
    L229:
        if (r169 == r172) goto L238;
        if (r169 != 0.0f) goto L235;
        r181.f399632d.e(r176, 1.0f);
        r181.f399632d.e(r177, -1.0f);
        goto L239
    L235:
        if (r172 != 0.0f) goto L237;
        r181.f399632d.e(r179, 1.0f);
        r181.f399632d.e(r180, -1.0f);
        goto L239
    L237:
        float r182 = (r169 / r167) / (r172 / r167);
        r181.f399632d.e(r176, 1.0f);
        r181.f399632d.e(r177, -1.0f);
        r181.f399632d.e(r180, r182);
        r181.f399632d.e(r179, -r182);
    L241:
        r169 = r172;
        r168 = r171;
        goto L242
    L208:
        if (r102.f399832p == true) goto L210;
        r167 = r102.f399826j;
    L243:
        c r183 = r102;
        if (r134 == null) goto L265;
        if (r134 == r135) goto L247;
        if (r141 == false) goto L265;
    L247:
        ConstraintAnchor r184 = r315.T[r112];
        int r185 = r112 + 1;
        ConstraintAnchor r186 = r133.T[r185];
        ConstraintAnchor r187 = r184.f399694f;
        if (r187 == null) goto L250;
        SolverVariable r188 = r187.f399697i;
    L251:
        ConstraintAnchor r189 = r186.f399694f;
        if (r189 == null) goto L254;
        SolverVariable r190 = r189.f399697i;
    L255:
        ConstraintAnchor r191 = r134.T[r112];
        if (r135 == null) goto L258;
        r186 = r135.T[r185];
    L258:
        if (r188 == null) goto L264;
        if (r190 == null) goto L264;
        if (r313 != 0) goto L262;
        float r192 = r314.f399716h0;
    L263:
        int r193 = r191.e();
        ConstraintWidget r194 = r135;
        ConstraintWidget r195 = r134;
        int r196 = r211;
        r311.b(r191.f399697i, r188, r193, r192, r190, r186.f399697i, r186.e(), 7);
    L329:
        int r221 = r196;
    L391:
        if (r214 == true) goto L393;
        if (r215 == true) goto L393;
    L418:
        r101 = r221 + 1;
        r100 = r310;
        r111 = r219;
        r110 = r316;
    L393:
        if (r195 == null) goto L418;
        if (r195 == r194) goto L418;
        ConstraintAnchor[] r197 = r195.T;
        ConstraintAnchor r198 = r197[r112];
        if (r194 != null) goto L398;
        ConstraintWidget r199 = r195;
    L399:
        int r200 = r112 + 1;
        ConstraintAnchor r201 = r199.T[r200];
        ConstraintAnchor r202 = r198.f399694f;
        if (r202 == null) goto L402;
        SolverVariable r203 = r202.f399697i;
    L403:
        ConstraintAnchor r204 = r201.f399694f;
        if (r204 == null) goto L406;
        SolverVariable r205 = r204.f399697i;
    L407:
        if (r133 == r199) goto L412;
        ConstraintAnchor r206 = r133.T[r200].f399694f;
        if (r206 == null) goto L411;
        r113 = r206.f399697i;
    L411:
        SolverVariable r207 = r113;
    L413:
        if (r195 != r199) goto L415;
        r201 = r197[r200];
    L415:
        if (r203 == null) goto L418;
        if (r207 == null) goto L418;
        int r208 = r198.e();
        int r209 = r199.T[r200].e();
        r311.b(r198.f399697i, r203, r208, 0.5f, r207, r201.f399697i, r209, 5);
        goto L418
    L412:
        r207 = r205;
        goto L413
    L406:
        r205 = null;
        goto L407
    L402:
        r203 = null;
        goto L403
    L398:
        r199 = r194;
        goto L399
    L262:
        r192 = r314.f399718i0;
    L264:
        r194 = r135;
        r195 = r134;
        r196 = r211;
        goto L329
    L254:
        r190 = null;
        goto L255
    L250:
        r188 = null;
    L265:
        r194 = r135;
        r195 = r134;
        r196 = r211;
        if (r214 == false) goto L330;
        if (r195 == null) goto L330;
        int r222 = r183.f399826j;
        if (r222 > 0) goto L271;
    L273:
        boolean r223 = false;
    L274:
        ConstraintWidget r224 = r195;
        ConstraintWidget r1100 = r224;
    L275:
        if (r1100 == null) goto L329;
        ConstraintWidget r225 = r1100.f399738s0[r313];
    L277:
        if (r225 == null) goto L282;
        if (r225.f399722k0 != 8) goto L282;
        r225 = r225.f399738s0[r313];
    L282:
        if (r225 != null) goto L287;
        if (r1100 == r194) goto L287;
        r225 = r225;
    L286:
        int r1101 = 8;
    L325:
        if (r1100.f399722k0 == r1101) goto L327;
        r224 = r1100;
    L328:
        r1100 = r225;
        r196 = r196;
        goto L275
    L327:
        r224 = r224;
    L287:
        ConstraintAnchor r226 = r1100.T[r112];
        SolverVariable r227 = r226.f399697i;
        ConstraintAnchor r228 = r226.f399694f;
        if (r228 == null) goto L290;
        SolverVariable r229 = r228.f399697i;
    L291:
        if (r224 == r1100) goto L293;
        r229 = r224.T[r112 + 1].f399697i;
    L298:
        int r230 = r226.e();
        int r231 = r112 + 1;
        int r232 = r1100.T[r231].e();
        if (r225 == null) goto L301;
        ConstraintAnchor r233 = r225.T[r112];
        SolverVariable r234 = r233.f399697i;
    L306:
        SolverVariable r235 = r1100.T[r231].f399697i;
        if (r233 == null) goto L309;
        r232 = r232 + r233.e();
    L309:
        int r236 = r230 + r224.T[r231].e();
        if (r227 == null) goto L286;
        if (r229 == null) goto L286;
        if (r234 == null) goto L286;
        if (r235 == null) goto L286;
        if (r1100 != r195) goto L316;
        r236 = r195.T[r112].e();
    L316:
        int r237 = r236;
        if (r1100 != r194) goto L319;
        int r238 = r194.T[r231].e();
    L320:
        if (r223 == false) goto L322;
        int r239 = 8;
    L323:
        r1101 = 8;
        r311.b(r227, r229, r237, 0.5f, r234, r235, r238, r239);
        goto L325
    L322:
        r239 = 5;
        goto L323
    L319:
        r238 = r232;
        goto L320
    L301:
        r233 = r133.T[r231].f399694f;
        if (r233 == null) goto L305;
        r234 = r233.f399697i;
        goto L306
    L305:
        r234 = null;
        goto L306
    L293:
        if (r1100 != r195) goto L298;
        ConstraintAnchor r240 = r315.T[r112].f399694f;
        if (r240 == null) goto L297;
        r229 = r240.f399697i;
        goto L298
    L297:
        r229 = null;
        goto L298
    L290:
        r229 = null;
        goto L291
    L271:
        if (r183.f399825i != r222) goto L273;
        r223 = true;
    L330:
        r221 = r196;
        int r1102 = 8;
        if (r215 == false) goto L391;
        if (r195 == null) goto L391;
        int r241 = r183.f399826j;
        if (r241 > 0) goto L336;
    L338:
        boolean r242 = false;
    L339:
        ConstraintWidget r243 = r195;
        ConstraintWidget r1103 = r243;
    L340:
        if (r1103 == null) goto L382;
        ConstraintWidget r244 = r1103.f399738s0[r313];
    L342:
        if (r244 == null) goto L346;
        if (r244.f399722k0 != r1102) goto L346;
        r244 = r244.f399738s0[r313];
    L346:
        if (r1103 == r195) goto L376;
        if (r1103 == r194) goto L376;
        if (r244 == null) goto L376;
        if (r244 != r194) goto L351;
        ConstraintWidget r245 = null;
    L352:
        ConstraintAnchor r246 = r1103.T[r112];
        SolverVariable r247 = r246.f399697i;
        int r248 = r112 + 1;
        SolverVariable r249 = r243.T[r248].f399697i;
        int r250 = r246.e();
        int r251 = r1103.T[r248].e();
        if (r245 == null) goto L358;
        ConstraintAnchor r252 = r245.T[r112];
        SolverVariable r253 = r252.f399697i;
        ConstraintAnchor r1104 = r252.f399694f;
        if (r1104 == null) goto L357;
        SolverVariable r1105 = r1104.f399697i;
    L363:
        if (r252 == null) goto L365;
        r251 = r251 + r252.e();
    L365:
        int r1106 = r251;
        int r254 = r243.T[r248].e() + r250;
        if (r242 == false) goto L368;
        int r255 = 8;
    L369:
        if (r247 == null) goto L375;
        if (r249 == null) goto L375;
        if (r253 == null) goto L375;
        if (r1105 == null) goto L375;
        r311.b(r247, r249, r254, 0.5f, r253, r1105, r1106, r255);
    L375:
        ConstraintWidget r256 = r245;
    L378:
        if (r1103.f399722k0 == 8) goto L380;
        r243 = r1103;
    L381:
        r1103 = r256;
        r1102 = 8;
        goto L340
    L380:
        r243 = r243;
        goto L381
    L368:
        r255 = 4;
        goto L369
    L357:
        r1105 = null;
        goto L363
    L358:
        r252 = r194.T[r112];
        if (r252 == null) goto L361;
        r253 = r252.f399697i;
    L362:
        r1105 = r1103.T[r248].f399697i;
        goto L363
    L361:
        r253 = null;
        goto L362
    L351:
        r245 = r244;
    L376:
        r243 = r243;
        r256 = r244;
        goto L378
    L382:
        ConstraintAnchor r257 = r195.T[r112];
        ConstraintAnchor r258 = r315.T[r112].f399694f;
        int r259 = r112 + 1;
        ConstraintAnchor r1107 = r194.T[r259];
        ConstraintAnchor r1108 = r133.T[r259].f399694f;
        if (r258 == null) goto L388;
        if (r195 == r194) goto L386;
        r311.e(r257.f399697i, r258.f399697i, r257.e(), 5);
        goto L388
    L386:
        if (r1108 == null) goto L388;
        r311.b(r257.f399697i, r258.f399697i, r257.e(), 0.5f, r1107.f399697i, r1108.f399697i, r1107.e(), 5);
    L388:
        if (r1108 == null) goto L391;
        if (r195 == r194) goto L391;
        r311.e(r1107.f399697i, r1108.f399697i, -r1107.e(), 5);
        goto L391
    L336:
        if (r183.f399825i != r241) goto L338;
        r242 = true;
    L117:
        r214 = r213;
        r141 = true;
        goto L118
    L105:
        r212 = false;
        goto L106
    L101:
        r210 = false;
        goto L102
    L109:
        r211 = r101;
        int r260 = r136.f399732p0;
        if (r260 != 0) goto L112;
        r213 = true;
    L113:
        if (r260 != 1) goto L115;
        r140 = true;
    L116:
        if (r260 != 2) goto L119;
    L115:
        r140 = false;
        goto L116
    L112:
        r213 = false;
        goto L113
    L96:
        r138 = false;
        goto L97
    L90:
        if (r312.contains(r102.f399817a) == true) goto L93;
        r221 = r101;
        r316 = r110;
        r219 = r111;
        goto L418
    L419:
        return;
    L5:
        r110 = r100.H0;
        r111 = r100.I0;
        r112 = 2;
        goto L6
    }
}
