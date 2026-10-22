package com.larus.bmhome.actionbar.model;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;
import nuc.v2;

/* JADX INFO: loaded from: classes25.dex */
@Serializable
public final class t0 {
    public static final b Companion = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f295449s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f295450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f295451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g1 f295452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g1 f295453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g1 f295454e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g1 f295455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f295456g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<c2> f295457h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f295458i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f295459j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f295460k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Boolean f295461l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final o1 f295462m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<o1> f295463n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<String> f295464o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f295465p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Boolean f295466q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final a2 f295467r;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<t0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f295468a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f295469b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f295469b;
        }

        static {
            a r100 = new a();
            f295468a = r100;
            g2 r101 = new g2("com.larus.bmhome.actionbar.model.ActiveSwitchMenuMode", r100, 18);
            r101.j("mode_id", true);
            r101.j("name", true);
            r101.j("icon", true);
            r101.j("dark_mode_icon", true);
            r101.j("active_icon", true);
            r101.j("active_dark_mode_icon", true);
            r101.j("sub_title_name", true);
            r101.j("tag_list", true);
            r101.j("show_task_tools", true);
            r101.j("agent_mode", true);
            r101.j("selected_name", true);
            r101.j("need_login", true);
            r101.j("default_model", true);
            r101.j("support_models", true);
            r101.j("conversation_mode_list", true);
            r101.j("default_conversation_mode", true);
            r101.j("show_reasoning_effort", true);
            r101.j("model_list", true);
            f295469b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r100 = t0.f295449s;
            v2 r101 = v2.f520790a;
            g1.a r102 = g1.a.f295160a;
            nuc.w0 r103 = nuc.w0.f520792a;
            nuc.i r104 = nuc.i.f520705a;
            return new juc.d[]{kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(r101), kuc.a.d(r100[7].getValue()), kuc.a.d(r103), kuc.a.d(r103), kuc.a.d(r101), kuc.a.d(r104), kuc.a.d(o1.a.f295359a), kuc.a.d(r100[13].getValue()), kuc.a.d(r100[14].getValue()), kuc.a.d(r101), kuc.a.d(r104), kuc.a.d(a2.a.f294976a)};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r310) {
            Intrinsics.checkNotNullParameter(r310, "decoder");
            g2 r100 = f295469b;
            muc.c r101 = r310.beginStructure(r100);
            Lazy<juc.d<Object>>[] r102 = t0.f295449s;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r103 = v2.f520790a;
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 0, r103, null);
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 1, r103, null);
            g1.a r110 = g1.a.f295160a;
            g1 r111 = (g1) r101.decodeNullableSerializableElement(r100, 2, r110, null);
            g1 r112 = (g1) r101.decodeNullableSerializableElement(r100, 3, r110, null);
            g1 r106 = (g1) r101.decodeNullableSerializableElement(r100, 4, r110, null);
            g1 r113 = (g1) r101.decodeNullableSerializableElement(r100, 5, r110, null);
            String r114 = (String) r101.decodeNullableSerializableElement(r100, 6, r103, null);
            List r115 = (List) r101.decodeNullableSerializableElement(r100, 7, r102[7].getValue(), null);
            nuc.w0 r116 = nuc.w0.f520792a;
            Integer r107 = (Integer) r101.decodeNullableSerializableElement(r100, 8, r116, null);
            Integer r108 = (Integer) r101.decodeNullableSerializableElement(r100, 9, r116, null);
            String r117 = (String) r101.decodeNullableSerializableElement(r100, 10, r103, null);
            nuc.i r109 = nuc.i.f520705a;
            Boolean r210 = (Boolean) r101.decodeNullableSerializableElement(r100, 11, r109, null);
            o1 r118 = (o1) r101.decodeNullableSerializableElement(r100, 12, o1.a.f295359a, null);
            List r119 = (List) r101.decodeNullableSerializableElement(r100, 13, r102[13].getValue(), null);
            List r120 = (List) r101.decodeNullableSerializableElement(r100, 14, r102[14].getValue(), null);
            String r121 = (String) r101.decodeNullableSerializableElement(r100, 15, r103, null);
            String r211 = r121;
            Boolean r212 = (Boolean) r101.decodeNullableSerializableElement(r100, 16, r109, null);
            a2 r213 = (a2) r101.decodeNullableSerializableElement(r100, 17, a2.a.f294976a, null);
            List r122 = r115;
            Integer r123 = r108;
            Integer r124 = r107;
            int r125 = 262143;
            List r214 = r120;
            g1 r126 = r111;
            o1 r215 = r118;
            String r127 = r105;
            String r216 = r117;
            g1 r128 = r113;
            String r129 = r104;
            String r130 = r114;
            g1 r131 = r106;
            List r217 = r119;
        L45:
            r101.endStructure(r100);
            return new t0(r125, r129, r127, r126, r112, r131, r128, r130, r122, r124, r123, r216, r210, r215, r217, r214, r211, r212, r213);
        L5:
            Integer r132 = null;
            a2 r133 = null;
            Boolean r134 = null;
            String r135 = null;
            g1 r136 = null;
            String r137 = null;
            List r138 = null;
            List r139 = null;
            String r140 = null;
            Integer r141 = null;
            o1 r142 = null;
            String r218 = null;
            g1 r219 = null;
            g1 r220 = null;
            g1 r311 = null;
            Boolean r312 = null;
            List r313 = null;
            String r314 = null;
            r125 = 0;
            boolean r315 = true;
        L6:
            if (r315 == false) goto L44;
            int r143 = r101.decodeElementIndex(r100);
            switch(r143) {
                case -1: goto L43;
                case 0: goto L40;
                case 1: goto L39;
                case 2: goto L36;
                case 3: goto L34;
                case 4: goto L32;
                case 5: goto L31;
                case 6: goto L30;
                case 7: goto L27;
                case 8: goto L25;
                case 9: goto L24;
                case 10: goto L22;
                case 11: goto L19;
                case 12: goto L17;
                case 13: goto L16;
                case 14: goto L15;
                case 15: goto L13;
                case 16: goto L12;
                case 17: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r143);
        L43:
            r133 = r133;
            r132 = r132;
            r102 = r102;
            r315 = false;
            r220 = r220;
            goto L6
        L11:
            r133 = (a2) r101.decodeNullableSerializableElement(r100, 17, a2.a.f294976a, r133);
            int r144 = 131072;
            r312 = r312;
        L14:
            int r145 = r144 | r125;
            List r146 = r313;
            r314 = r314;
        L20:
            List r316 = r146;
            r125 = r145;
            List r147 = r316;
        L21:
            List r148 = r147;
        L29:
            r102 = r102;
            r219 = r219;
            g1 r221 = r220;
            r132 = r132;
        L38:
            List r149 = r148;
            r132 = r132;
            r137 = r137;
            r220 = r221;
            g1 r317 = r311;
        L42:
            r313 = r149;
            r312 = r312;
            r314 = r314;
            r219 = r219;
            r102 = r102;
            r311 = r317;
            goto L6
        L12:
            int r150 = 65536 | r125;
            r312 = (Boolean) r101.decodeNullableSerializableElement(r100, 16, nuc.i.f520705a, r312);
        L26:
            r125 = r150;
        L28:
            r148 = r313;
            r133 = r133;
            goto L29
        L13:
            r312 = r312;
            r314 = (String) r101.decodeNullableSerializableElement(r100, 15, v2.f520790a, r314);
            r144 = 32768;
            r133 = r133;
            goto L14
        L15:
            r137 = r137;
            r312 = r312;
            r139 = (List) r101.decodeNullableSerializableElement(r100, 14, r102[14].getValue(), r139);
            r125 = r125 | 16384;
            r314 = r314;
            r133 = r133;
            r147 = r313;
            goto L21
        L16:
            r137 = r137;
            r312 = r312;
            r314 = r314;
            List r318 = (List) r101.decodeNullableSerializableElement(r100, 13, r102[13].getValue(), r313);
            r145 = r125 | 8192;
            r133 = r133;
            r146 = r318;
            goto L20
        L17:
            r137 = r137;
            r312 = r312;
            r314 = r314;
            r142 = (o1) r101.decodeNullableSerializableElement(r100, 12, o1.a.f295359a, r142);
            r145 = r125 | 4096;
            r146 = r313;
            r133 = r133;
            goto L20
        L19:
            r137 = r137;
            r312 = r312;
            r314 = r314;
            r134 = (Boolean) r101.decodeNullableSerializableElement(r100, 11, nuc.i.f520705a, r134);
            r145 = r125 | 2048;
            r146 = r313;
            r133 = r133;
            goto L20
        L22:
            r312 = r312;
            r135 = (String) r101.decodeNullableSerializableElement(r100, 10, v2.f520790a, r135);
            r150 = r125 | 1024;
            goto L26
        L24:
            r133 = r133;
            r137 = r137;
            r312 = r312;
            r313 = r313;
            r314 = r314;
            r141 = (Integer) r101.decodeNullableSerializableElement(r100, 9, nuc.w0.f520792a, r141);
            r150 = r125 | 512;
            goto L26
        L25:
            r133 = r133;
            r137 = r137;
            r312 = r312;
            r313 = r313;
            r314 = r314;
            r132 = (Integer) r101.decodeNullableSerializableElement(r100, 8, nuc.w0.f520792a, r132);
            r150 = r125 | 256;
            goto L26
        L27:
            r133 = r133;
            r137 = r137;
            r312 = r312;
            r313 = r313;
            r314 = r314;
            r138 = (List) r101.decodeNullableSerializableElement(r100, 7, r102[7].getValue(), r138);
            r125 = r125 | 128;
            goto L28
        L30:
            r140 = (String) r101.decodeNullableSerializableElement(r100, 6, v2.f520790a, r140);
            r125 = r125 | 64;
            g1 r151 = r220;
        L33:
            r221 = r151;
        L35:
            r219 = r219;
        L37:
            r148 = r313;
            r133 = r133;
            goto L38
        L31:
            r102 = r102;
            r133 = r133;
            r137 = r137;
            r312 = r312;
            r313 = r313;
            r314 = r314;
            r136 = (g1) r101.decodeNullableSerializableElement(r100, 5, g1.a.f295160a, r136);
            r125 = r125 | 32;
            r221 = r220;
            r132 = r132;
            goto L35
        L32:
            r151 = (g1) r101.decodeNullableSerializableElement(r100, 4, g1.a.f295160a, r220);
            r125 = r125 | 16;
            goto L33
        L34:
            r102 = r102;
            r133 = r133;
            r137 = r137;
            g1 r152 = r220;
            r312 = r312;
            r313 = r313;
            r314 = r314;
            r132 = r132;
            r221 = r152;
            r219 = (g1) r101.decodeNullableSerializableElement(r100, 3, g1.a.f295160a, r219);
            r125 = r125 | 8;
            goto L35
        L36:
            r102 = r102;
            r133 = r133;
            r137 = r137;
            r221 = r220;
            r312 = r312;
            r313 = r313;
            r314 = r314;
            r132 = r132;
            r219 = r219;
            r311 = (g1) r101.decodeNullableSerializableElement(r100, 2, g1.a.f295160a, r311);
            r125 = r125 | 4;
            goto L37
        L39:
            r317 = r311;
            r137 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r137);
            int r153 = r125 | 2;
        L41:
            r125 = r153;
            r149 = r313;
            r133 = r133;
            r132 = r132;
            r220 = r220;
            goto L42
        L40:
            r317 = r311;
            r218 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r218);
            r137 = r137;
            r153 = r125 | 1;
            goto L41
        L44:
            g1 r222 = r219;
            g1 r223 = r220;
            Integer r224 = r132;
            String r154 = r137;
            r129 = r218;
            r217 = r313;
            r210 = r134;
            r216 = r135;
            r123 = r141;
            r215 = r142;
            r213 = r133;
            r211 = r314;
            r131 = r223;
            r124 = r224;
            r128 = r136;
            r130 = r140;
            r212 = r312;
            r112 = r222;
            r122 = r138;
            r214 = r139;
            r126 = r311;
            r127 = r154;
            goto L45
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            t0 r102 = (t0) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f295469b;
            muc.d r104 = r100.beginStructure(r103);
            Lazy<juc.d<Object>>[] r105 = t0.f295449s;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, v2.f520790a, r102.f295450a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeNullableSerializableElement(r103, 1, v2.f520790a, r102.f295451b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            boolean r109 = true;
        L27:
            if (r109 == false) goto L30;
            r104.encodeNullableSerializableElement(r103, 2, g1.a.f295160a, r102.f295452c);
        L30:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
        L34:
            boolean r110 = true;
        L36:
            if (r110 == false) goto L39;
            r104.encodeNullableSerializableElement(r103, 3, g1.a.f295160a, r102.f295453d);
        L39:
            if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L42;
        L43:
            boolean r111 = true;
        L45:
            if (r111 == false) goto L48;
            r104.encodeNullableSerializableElement(r103, 4, g1.a.f295160a, r102.f295454e);
        L48:
            if (r104.shouldEncodeElementDefault(r103, 5) == false) goto L51;
        L52:
            boolean r112 = true;
        L54:
            if (r112 == false) goto L57;
            r104.encodeNullableSerializableElement(r103, 5, g1.a.f295160a, r102.f295455f);
        L57:
            if (r104.shouldEncodeElementDefault(r103, 6) == false) goto L60;
        L61:
            boolean r113 = true;
        L63:
            if (r113 == false) goto L66;
            r104.encodeNullableSerializableElement(r103, 6, v2.f520790a, r102.f295456g);
        L66:
            if (r104.shouldEncodeElementDefault(r103, 7) == false) goto L69;
        L70:
            boolean r114 = true;
        L72:
            if (r114 == false) goto L75;
            r104.encodeNullableSerializableElement(r103, 7, r105[7].getValue(), r102.f295457h);
        L75:
            if (r104.shouldEncodeElementDefault(r103, 8) == false) goto L78;
        L79:
            boolean r115 = true;
        L81:
            if (r115 == false) goto L84;
            r104.encodeNullableSerializableElement(r103, 8, nuc.w0.f520792a, r102.f295458i);
        L84:
            if (r104.shouldEncodeElementDefault(r103, 9) == false) goto L87;
        L88:
            boolean r116 = true;
        L90:
            if (r116 == false) goto L93;
            r104.encodeNullableSerializableElement(r103, 9, nuc.w0.f520792a, r102.f295459j);
        L93:
            if (r104.shouldEncodeElementDefault(r103, 10) == false) goto L96;
        L97:
            boolean r117 = true;
        L99:
            if (r117 == false) goto L102;
            r104.encodeNullableSerializableElement(r103, 10, v2.f520790a, r102.f295460k);
        L102:
            if (r104.shouldEncodeElementDefault(r103, 11) == false) goto L105;
        L106:
            boolean r118 = true;
        L108:
            if (r118 == false) goto L111;
            r104.encodeNullableSerializableElement(r103, 11, nuc.i.f520705a, r102.f295461l);
        L111:
            if (r104.shouldEncodeElementDefault(r103, 12) == false) goto L114;
        L115:
            boolean r119 = true;
        L117:
            if (r119 == false) goto L120;
            r104.encodeNullableSerializableElement(r103, 12, o1.a.f295359a, r102.f295462m);
        L120:
            if (r104.shouldEncodeElementDefault(r103, 13) == false) goto L123;
        L124:
            boolean r120 = true;
        L126:
            if (r120 == false) goto L129;
            r104.encodeNullableSerializableElement(r103, 13, r105[13].getValue(), r102.f295463n);
        L129:
            if (r104.shouldEncodeElementDefault(r103, 14) == false) goto L132;
        L133:
            boolean r121 = true;
        L135:
            if (r121 == false) goto L138;
            r104.encodeNullableSerializableElement(r103, 14, r105[14].getValue(), r102.f295464o);
        L138:
            if (r104.shouldEncodeElementDefault(r103, 15) == false) goto L141;
        L142:
            boolean r122 = true;
        L144:
            if (r122 == false) goto L147;
            r104.encodeNullableSerializableElement(r103, 15, v2.f520790a, r102.f295465p);
        L147:
            if (r104.shouldEncodeElementDefault(r103, 16) == false) goto L150;
        L151:
            boolean r123 = true;
        L153:
            if (r123 == false) goto L156;
            r104.encodeNullableSerializableElement(r103, 16, nuc.i.f520705a, r102.f295466q);
        L156:
            if (r104.shouldEncodeElementDefault(r103, 17) == false) goto L159;
        L160:
            r106 = true;
        L161:
            if (r106 == false) goto L163;
            r104.encodeNullableSerializableElement(r103, 17, a2.a.f294976a, r102.f295467r);
        L163:
            r104.endStructure(r103);
            return;
        L159:
            if (r102.f295467r == null) goto L161;
        L150:
            if (r102.f295466q != null) goto L151;
            r123 = false;
            goto L153
        L141:
            if (r102.f295465p != null) goto L142;
            r122 = false;
            goto L144
        L132:
            if (r102.f295464o != null) goto L133;
            r121 = false;
            goto L135
        L123:
            if (r102.f295463n != null) goto L124;
            r120 = false;
            goto L126
        L114:
            if (r102.f295462m != null) goto L115;
            r119 = false;
            goto L117
        L105:
            if (r102.f295461l != null) goto L106;
            r118 = false;
            goto L108
        L96:
            if (r102.f295460k != null) goto L97;
            r117 = false;
            goto L99
        L87:
            if (r102.f295459j != null) goto L88;
            r116 = false;
            goto L90
        L78:
            if (r102.f295458i != null) goto L79;
            r115 = false;
            goto L81
        L69:
            if (r102.f295457h != null) goto L70;
            r114 = false;
            goto L72
        L60:
            if (r102.f295456g != null) goto L61;
            r113 = false;
            goto L63
        L51:
            if (r102.f295455f != null) goto L52;
            r112 = false;
            goto L54
        L42:
            if (r102.f295454e != null) goto L43;
            r111 = false;
            goto L45
        L33:
            if (r102.f295453d != null) goto L34;
            r110 = false;
            goto L36
        L24:
            if (r102.f295452c != null) goto L25;
            r109 = false;
            goto L27
        L15:
            if (r102.f295451b != null) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f295450a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<t0> serializer() {
            return a.f295468a;
        }
    }

    public t0() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 262143);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t0) == true) goto L8;
        return false;
    L8:
        t0 r101 = (t0) r100;
        if (Intrinsics.areEqual(this.f295450a, r101.f295450a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f295451b, r101.f295451b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f295452c, r101.f295452c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f295453d, r101.f295453d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f295454e, r101.f295454e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f295455f, r101.f295455f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f295456g, r101.f295456g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f295457h, r101.f295457h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f295458i, r101.f295458i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f295459j, r101.f295459j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f295460k, r101.f295460k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f295461l, r101.f295461l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f295462m, r101.f295462m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f295463n, r101.f295463n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f295464o, r101.f295464o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f295465p, r101.f295465p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f295466q, r101.f295466q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f295467r, r101.f295467r) == true) goto L62;
        return false;
    L62:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f295450a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f295451b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        g1 r107 = this.f295452c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        g1 r110 = this.f295453d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        g1 r113 = this.f295454e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        g1 r116 = this.f295455f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f295456g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        List<c2> r122 = this.f295457h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.f295458i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.f295459j;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f295460k;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Boolean r134 = this.f295461l;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        o1 r137 = this.f295462m;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        List<o1> r140 = this.f295463n;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        List<String> r143 = this.f295464o;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.f295465p;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        Boolean r149 = this.f295466q;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        a2 r152 = this.f295467r;
        if (r152 == null) goto L75;
        r101 = r152.hashCode();
    L75:
        return r151 + r101;
    L69:
        r150 = r149.hashCode();
        goto L70
    L65:
        r147 = r146.hashCode();
        goto L66
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ActiveSwitchMenuMode(modeId=" + this.f295450a + ", name=" + this.f295451b + ", icon=" + this.f295452c + ", darkModeIcon=" + this.f295453d + ", activeIcon=" + this.f295454e + ", activeDarkModeIcon=" + this.f295455f + ", subTitleName=" + this.f295456g + ", tagList=" + this.f295457h + ", showTaskTools=" + this.f295458i + ", agentMode=" + this.f295459j + ", selectedName=" + this.f295460k + ", needLogin=" + this.f295461l + ", defaultModel=" + this.f295462m + ", supportModels=" + this.f295463n + ", conversationModeList=" + this.f295464o + ", defaultConversationMode=" + this.f295465p + ", showReasoningEffort=" + this.f295466q + ", modelList=" + this.f295467r + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        f295449s = new Lazy[]{null, null, null, null, null, null, null, LazyKt.lazy(r100, new wa8.x0()), null, null, null, null, null, LazyKt.lazy(r100, new wa8.y0()), LazyKt.lazy(r100, new wa8.z0()), null, null, null};
    }

    public /* synthetic */ t0(String r210, String r211, g1 r212, g1 r213, g1 r214, g1 r215, Integer r216, String r310, o1 r311, List r312, Boolean r313, a2 r314, int r315) {
        if ((r315 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r315 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r315 & 4) == 0) goto L13;
        g1 r102 = null;
    L15:
        if ((r315 & 8) == 0) goto L17;
        g1 r103 = null;
    L19:
        if ((r315 & 16) == 0) goto L21;
        g1 r104 = null;
    L23:
        if ((r315 & 32) == 0) goto L25;
        g1 r105 = null;
    L27:
        if ((r315 & 512) == 0) goto L29;
        Integer r110 = null;
    L31:
        if ((r315 & 1024) == 0) goto L33;
        String r111 = null;
    L35:
        if ((r315 & 4096) == 0) goto L37;
        o1 r112 = null;
    L39:
        if ((r315 & 8192) == 0) goto L41;
        List r113 = null;
    L43:
        if ((65536 & r315) == 0) goto L45;
        Boolean r217 = null;
    L47:
        if ((r315 & 131072) == 0) goto L49;
        a2 r218 = null;
    L50:
        this(r100, r101, r102, r103, r104, r105, null, null, null, r110, r111, null, r112, r113, null, null, r217, r218);
        return;
    L49:
        r218 = r314;
        goto L50
    L45:
        r217 = r313;
        goto L47
    L41:
        r113 = r312;
        goto L43
    L37:
        r112 = r311;
        goto L39
    L33:
        r111 = r310;
        goto L35
    L29:
        r110 = r216;
        goto L31
    L25:
        r105 = r215;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    public t0(String r100, String r101, g1 r102, g1 r103, g1 r104, g1 r105, String r106, List<c2> r110, Integer r111, Integer r112, String r113, Boolean r114, o1 r115, List<o1> r116, List<String> r117, String r118, Boolean r119, a2 r210) {
        this.f295450a = r100;
        this.f295451b = r101;
        this.f295452c = r102;
        this.f295453d = r103;
        this.f295454e = r104;
        this.f295455f = r105;
        this.f295456g = r106;
        this.f295457h = r110;
        this.f295458i = r111;
        this.f295459j = r112;
        this.f295460k = r113;
        this.f295461l = r114;
        this.f295462m = r115;
        this.f295463n = r116;
        this.f295464o = r117;
        this.f295465p = r118;
        this.f295466q = r119;
        this.f295467r = r210;
    }

    public t0(int r100, String r101, String r102, g1 r103, g1 r110, g1 r111, g1 r112, String r113, List r114, Integer r115, Integer r116, String r117, Boolean r118, o1 r119, List r210, List r211, String r212, Boolean r213, a2 r214) {
        if ((r100 & 0) == 0) goto L5;
        nuc.b2.b(r100, 0, a.f295469b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f295450a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f295451b = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f295452c = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f295453d = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.f295454e = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.f295455f = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.f295456g = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.f295457h = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.f295458i = null;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.f295459j = null;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.f295460k = null;
    L49:
        if ((r100 & 2048) != 0) goto L51;
        this.f295461l = null;
    L53:
        if ((r100 & 4096) != 0) goto L55;
        this.f295462m = null;
    L57:
        if ((r100 & 8192) != 0) goto L59;
        this.f295463n = null;
    L61:
        if ((r100 & 16384) != 0) goto L63;
        this.f295464o = null;
    L65:
        if ((32768 & r100) != 0) goto L67;
        this.f295465p = null;
    L69:
        if ((65536 & r100) != 0) goto L71;
        this.f295466q = null;
    L73:
        if ((r100 & 131072) != 0) goto L75;
        this.f295467r = null;
        return;
    L75:
        this.f295467r = r214;
        return;
    L71:
        this.f295466q = r213;
        goto L73
    L67:
        this.f295465p = r212;
        goto L69
    L63:
        this.f295464o = r211;
        goto L65
    L59:
        this.f295463n = r210;
        goto L61
    L55:
        this.f295462m = r119;
        goto L57
    L51:
        this.f295461l = r118;
        goto L53
    L47:
        this.f295460k = r117;
        goto L49
    L43:
        this.f295459j = r116;
        goto L45
    L39:
        this.f295458i = r115;
        goto L41
    L35:
        this.f295457h = r114;
        goto L37
    L31:
        this.f295456g = r113;
        goto L33
    L27:
        this.f295455f = r112;
        goto L29
    L23:
        this.f295454e = r111;
        goto L25
    L19:
        this.f295453d = r110;
        goto L21
    L15:
        this.f295452c = r103;
        goto L17
    L11:
        this.f295451b = r102;
        goto L13
    L7:
        this.f295450a = r101;
        goto L9
    }
}
