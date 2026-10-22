package com.larus.bmhome.actionbar.model;

import java.util.List;
import java.util.Map;
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
public final class b2 {
    public static final b Companion = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f294993v = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f294994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f294995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g1 f294996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g1 f294997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g1 f294998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g1 f294999f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f295000g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f295001h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Long f295002i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<c2> f295003j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f295004k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Integer f295005l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Boolean f295006m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final z1 f295007n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f295008o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Map<String, String> f295009p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final List<String> f295010q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f295011r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f295012s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final u1 f295013t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f295014u;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<b2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f295015a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f295016b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f295016b;
        }

        static {
            a r100 = new a();
            f295015a = r100;
            g2 r101 = new g2("com.larus.bmhome.actionbar.model.SwitchMenuItem", r100, 20);
            r101.j("item_id", true);
            r101.j("name", true);
            r101.j("icon", true);
            r101.j("dark_mode_icon", true);
            r101.j("active_icon", true);
            r101.j("active_dark_mode_icon", true);
            r101.j("sub_title_name", true);
            r101.j("show_task_tools", true);
            r101.j("red_dot_version", true);
            r101.j("tag_list", true);
            r101.j("selected_name", true);
            r101.j("agent_mode", true);
            r101.j("need_login", true);
            r101.j("subscribe_config", true);
            r101.j("model_item_key", true);
            r101.j("model_extra_params", true);
            r101.j("conversation_mode_list", true);
            r101.j("default_conversation_mode", true);
            r101.j("default_mode", true);
            r101.j("reasoning_effort_config", true);
            f295016b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r100 = b2.f294993v;
            nuc.w0 r101 = nuc.w0.f520792a;
            v2 r102 = v2.f520790a;
            g1.a r103 = g1.a.f295160a;
            return new juc.d[]{kuc.a.d(r101), kuc.a.d(r102), kuc.a.d(r103), kuc.a.d(r103), kuc.a.d(r103), kuc.a.d(r103), kuc.a.d(r102), kuc.a.d(r101), kuc.a.d(nuc.g1.f520681a), kuc.a.d(r100[9].getValue()), kuc.a.d(r102), kuc.a.d(r101), kuc.a.d(nuc.i.f520705a), kuc.a.d(z1.a.f295638a), kuc.a.d(r102), kuc.a.d(r100[15].getValue()), kuc.a.d(r100[16].getValue()), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(u1.a.f295492a)};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r410) {
            Intrinsics.checkNotNullParameter(r410, "decoder");
            g2 r100 = f295016b;
            muc.c r101 = r410.beginStructure(r100);
            Lazy<juc.d<Object>>[] r102 = b2.f294993v;
            if (r101.decodeSequentially() == false) goto L5;
            nuc.w0 r103 = nuc.w0.f520792a;
            Integer r110 = (Integer) r101.decodeNullableSerializableElement(r100, 0, r103, null);
            v2 r111 = v2.f520790a;
            String r112 = (String) r101.decodeNullableSerializableElement(r100, 1, r111, null);
            g1.a r113 = g1.a.f295160a;
            g1 r104 = (g1) r101.decodeNullableSerializableElement(r100, 2, r113, null);
            g1 r105 = (g1) r101.decodeNullableSerializableElement(r100, 3, r113, null);
            g1 r106 = (g1) r101.decodeNullableSerializableElement(r100, 4, r113, null);
            g1 r107 = (g1) r101.decodeNullableSerializableElement(r100, 5, r113, null);
            String r108 = (String) r101.decodeNullableSerializableElement(r100, 6, r111, null);
            Integer r114 = (Integer) r101.decodeNullableSerializableElement(r100, 7, r103, null);
            Long r109 = (Long) r101.decodeNullableSerializableElement(r100, 8, nuc.g1.f520681a, null);
            List r115 = (List) r101.decodeNullableSerializableElement(r100, 9, r102[9].getValue(), null);
            String r116 = (String) r101.decodeNullableSerializableElement(r100, 10, r111, null);
            Integer r117 = (Integer) r101.decodeNullableSerializableElement(r100, 11, r103, null);
            Boolean r118 = (Boolean) r101.decodeNullableSerializableElement(r100, 12, nuc.i.f520705a, null);
            z1 r119 = (z1) r101.decodeNullableSerializableElement(r100, 13, z1.a.f295638a, null);
            String r120 = (String) r101.decodeNullableSerializableElement(r100, 14, r111, null);
            Map r121 = (Map) r101.decodeNullableSerializableElement(r100, 15, r102[15].getValue(), null);
            List r122 = (List) r101.decodeNullableSerializableElement(r100, 16, r102[16].getValue(), null);
            String r123 = (String) r101.decodeNullableSerializableElement(r100, 17, r111, null);
            String r310 = (String) r101.decodeNullableSerializableElement(r100, 18, r111, null);
            Map r210 = r121;
            String r211 = r120;
            g1 r124 = r106;
            u1 r311 = (u1) r101.decodeNullableSerializableElement(r100, 19, u1.a.f295492a, null);
            Integer r212 = r114;
            String r312 = r123;
            String r125 = r112;
            List r313 = r122;
            z1 r213 = r119;
            Integer r214 = r117;
            List r215 = r115;
            g1 r126 = r105;
            int r127 = 1048575;
            String r216 = r108;
            g1 r128 = r104;
            String r217 = r116;
            Integer r129 = r110;
            Boolean r218 = r118;
            g1 r130 = r107;
            Long r219 = r109;
        L51:
            r101.endStructure(r100);
            return new b2(r127, r129, r125, r128, r126, r124, r130, r216, r212, r219, r215, r217, r214, r218, r213, r211, r210, r313, r312, r310, r311);
        L5:
            String r131 = null;
            Integer r132 = null;
            Long r133 = null;
            String r134 = null;
            List r135 = null;
            g1 r136 = null;
            List r137 = null;
            String r138 = null;
            Map r139 = null;
            Integer r140 = null;
            u1 r141 = null;
            Integer r220 = null;
            g1 r314 = null;
            g1 r315 = null;
            g1 r316 = null;
            String r317 = null;
            String r318 = null;
            z1 r319 = null;
            Boolean r320 = null;
            String r321 = null;
            int r142 = 0;
            boolean r411 = true;
        L6:
            if (r411 == false) goto L50;
            int r143 = r101.decodeElementIndex(r100);
            switch(r143) {
                case -1: goto L49;
                case 0: goto L46;
                case 1: goto L45;
                case 2: goto L42;
                case 3: goto L40;
                case 4: goto L38;
                case 5: goto L36;
                case 6: goto L34;
                case 7: goto L33;
                case 8: goto L31;
                case 9: goto L28;
                case 10: goto L26;
                case 11: goto L23;
                case 12: goto L21;
                case 13: goto L19;
                case 14: goto L18;
                case 15: goto L16;
                case 16: goto L15;
                case 17: goto L13;
                case 18: goto L12;
                case 19: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r143);
        L49:
            r141 = r141;
            r134 = r134;
            r102 = r102;
            r131 = r131;
            r411 = false;
            r314 = r314;
            goto L6
        L11:
            r141 = (u1) r101.decodeNullableSerializableElement(r100, 19, u1.a.f295492a, r141);
            int r144 = 524288;
            String r145 = r317;
            r321 = r321;
        L17:
            r142 = r142 | r144;
            r319 = r319;
            Boolean r146 = r320;
        L25:
            Boolean r147 = r146;
        L30:
            r102 = r102;
            Boolean r221 = r147;
            String r322 = r321;
            r315 = r315;
            r136 = r136;
            String r148 = r145;
            g1 r149 = r316;
        L44:
            String r150 = r318;
        L48:
            r318 = r150;
            r316 = r149;
            r317 = r148;
            r320 = r221;
            r319 = r319;
            r102 = r102;
            r315 = r315;
            r321 = r322;
            goto L6
        L12:
            r142 = 262144 | r142;
            r321 = (String) r101.decodeNullableSerializableElement(r100, 18, v2.f520790a, r321);
        L29:
            r147 = r320;
            r134 = r134;
            u1 r412 = r141;
            r145 = r317;
            r141 = r412;
            goto L30
        L13:
            r321 = r321;
            r144 = 131072;
            r141 = r141;
            r145 = (String) r101.decodeNullableSerializableElement(r100, 17, v2.f520790a, r317);
            goto L17
        L15:
            r137 = (List) r101.decodeNullableSerializableElement(r100, 16, r102[16].getValue(), r137);
            r142 = 65536 | r142;
        L20:
            r319 = r319;
        L22:
            r146 = r320;
        L24:
            u1 r413 = r141;
            r145 = r317;
            r141 = r413;
            goto L25
        L16:
            r136 = r136;
            r321 = r321;
            r139 = (Map) r101.decodeNullableSerializableElement(r100, 15, r102[15].getValue(), r139);
            r144 = 32768;
            r145 = r317;
            r141 = r141;
            goto L17
        L18:
            r134 = (String) r101.decodeNullableSerializableElement(r100, 14, v2.f520790a, r134);
            r142 = r142 | 16384;
            goto L20
        L19:
            r319 = (z1) r101.decodeNullableSerializableElement(r100, 13, z1.a.f295638a, r319);
            r142 = r142 | 8192;
            r134 = r134;
            goto L20
        L21:
            r136 = r136;
            r141 = r141;
            r317 = r317;
            r321 = r321;
            r319 = r319;
            r320 = (Boolean) r101.decodeNullableSerializableElement(r100, 12, nuc.i.f520705a, r320);
            r142 = r142 | 4096;
            r134 = r134;
            goto L22
        L23:
            r136 = r136;
            r141 = r141;
            r317 = r317;
            r319 = r319;
            r321 = r321;
            r140 = (Integer) r101.decodeNullableSerializableElement(r100, 11, nuc.w0.f520792a, r140);
            r142 = r142 | 2048;
            r146 = r320;
            r134 = r134;
            goto L24
        L26:
            r321 = r321;
            r131 = (String) r101.decodeNullableSerializableElement(r100, 10, v2.f520790a, r131);
            r142 = r142 | 1024;
            goto L29
        L28:
            r134 = r134;
            r136 = r136;
            r141 = r141;
            r317 = r317;
            r319 = r319;
            r320 = r320;
            r321 = r321;
            r135 = (List) r101.decodeNullableSerializableElement(r100, 9, r102[9].getValue(), r135);
            r142 = r142 | 512;
            goto L29
        L31:
            r134 = r134;
            g1 r414 = r136;
            r141 = r141;
            r317 = r317;
            r319 = r319;
            r320 = r320;
            r321 = r321;
            r102 = r102;
            r133 = (Long) r101.decodeNullableSerializableElement(r100, 8, nuc.g1.f520681a, r133);
            int r151 = r142 | 256;
            r131 = r131;
            g1 r323 = r414;
        L39:
            r142 = r151;
            r136 = r323;
            r315 = r315;
        L41:
            g1 r152 = r316;
        L43:
            r322 = r321;
            r148 = r317;
            r141 = r141;
            r149 = r152;
            r131 = r131;
            String r415 = r134;
            r221 = r320;
            r134 = r415;
            goto L44
        L33:
            r132 = (Integer) r101.decodeNullableSerializableElement(r100, 7, nuc.w0.f520792a, r132);
            int r153 = r142 | 128;
        L35:
            int r154 = r153;
            g1 r155 = r136;
        L37:
            r323 = r155;
            r151 = r154;
            goto L39
        L34:
            r138 = (String) r101.decodeNullableSerializableElement(r100, 6, v2.f520790a, r138);
            r153 = r142 | 64;
            goto L35
        L36:
            r102 = r102;
            r134 = r134;
            r141 = r141;
            r317 = r317;
            r319 = r319;
            r320 = r320;
            r321 = r321;
            r155 = (g1) r101.decodeNullableSerializableElement(r100, 5, g1.a.f295160a, r136);
            r154 = r142 | 32;
            goto L37
        L38:
            r102 = r102;
            r131 = r131;
            r134 = r134;
            r141 = r141;
            r317 = r317;
            r319 = r319;
            r320 = r320;
            r321 = r321;
            r323 = r136;
            r315 = (g1) r101.decodeNullableSerializableElement(r100, 4, g1.a.f295160a, r315);
            r151 = r142 | 16;
            goto L39
        L40:
            r102 = r102;
            r131 = r131;
            r134 = r134;
            r141 = r141;
            r317 = r317;
            r319 = r319;
            r320 = r320;
            r321 = r321;
            r315 = r315;
            r316 = (g1) r101.decodeNullableSerializableElement(r100, 3, g1.a.f295160a, r316);
            r142 = r142 | 8;
            r136 = r136;
            goto L41
        L42:
            r102 = r102;
            r131 = r131;
            r134 = r134;
            r141 = r141;
            r315 = r315;
            r317 = r317;
            r319 = r319;
            r320 = r320;
            r321 = r321;
            r142 = r142 | 4;
            r136 = r136;
            r314 = (g1) r101.decodeNullableSerializableElement(r100, 2, g1.a.f295160a, r314);
            r152 = r316;
            goto L43
        L45:
            g1 r222 = r314;
            r150 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r318);
            int r156 = r142 | 2;
        L47:
            r142 = r156;
            r136 = r136;
            r131 = r131;
            r322 = r321;
            r148 = r317;
            r141 = r141;
            r149 = r316;
            r314 = r222;
            r221 = r320;
            r134 = r134;
            goto L48
        L46:
            r222 = r314;
            r150 = r318;
            r220 = (Integer) r101.decodeNullableSerializableElement(r100, 0, nuc.w0.f520792a, r220);
            r156 = r142 | 1;
            goto L47
        L50:
            String r324 = r131;
            Integer r157 = r220;
            g1 r223 = r315;
            r218 = r320;
            r215 = r135;
            r216 = r138;
            r214 = r140;
            r311 = r141;
            r211 = r134;
            r128 = r314;
            r124 = r223;
            r130 = r136;
            r217 = r324;
            r129 = r157;
            r212 = r132;
            r313 = r137;
            r210 = r139;
            r312 = r317;
            r213 = r319;
            r125 = r318;
            r219 = r133;
            r127 = r142;
            r310 = r321;
            r126 = r316;
            goto L51
        }

        @Override // juc.n
        public final void serialize(muc.f r110, Object r111) {
            b2 r100 = (b2) r111;
            Intrinsics.checkNotNullParameter(r110, "encoder");
            Intrinsics.checkNotNullParameter(r100, "value");
            g2 r101 = f295016b;
            muc.d r102 = r110.beginStructure(r101);
            Lazy<juc.d<Object>>[] r103 = b2.f294993v;
            boolean r104 = false;
            if (r102.shouldEncodeElementDefault(r101, 0) == false) goto L6;
        L7:
            boolean r105 = true;
        L9:
            if (r105 == false) goto L12;
            r102.encodeNullableSerializableElement(r101, 0, nuc.w0.f520792a, r100.f294994a);
        L12:
            if (r102.shouldEncodeElementDefault(r101, 1) == false) goto L15;
        L16:
            boolean r106 = true;
        L18:
            if (r106 == false) goto L21;
            r102.encodeNullableSerializableElement(r101, 1, v2.f520790a, r100.f294995b);
        L21:
            if (r102.shouldEncodeElementDefault(r101, 2) == false) goto L24;
        L25:
            boolean r107 = true;
        L27:
            if (r107 == false) goto L30;
            r102.encodeNullableSerializableElement(r101, 2, g1.a.f295160a, r100.f294996c);
        L30:
            if (r102.shouldEncodeElementDefault(r101, 3) == false) goto L33;
        L31:
            boolean r108 = true;
        L36:
            if (r108 == false) goto L39;
            r102.encodeNullableSerializableElement(r101, 3, g1.a.f295160a, r100.f294997d);
        L39:
            if (r102.shouldEncodeElementDefault(r101, 4) == false) goto L42;
        L43:
            boolean r109 = true;
        L45:
            if (r109 == false) goto L48;
            r102.encodeNullableSerializableElement(r101, 4, g1.a.f295160a, r100.f294998e);
        L48:
            if (r102.shouldEncodeElementDefault(r101, 5) == false) goto L51;
        L52:
            boolean r112 = true;
        L54:
            if (r112 == false) goto L57;
            r102.encodeNullableSerializableElement(r101, 5, g1.a.f295160a, r100.f294999f);
        L57:
            if (r102.shouldEncodeElementDefault(r101, 6) == false) goto L60;
        L61:
            boolean r113 = true;
        L63:
            if (r113 == false) goto L66;
            r102.encodeNullableSerializableElement(r101, 6, v2.f520790a, r100.f295000g);
        L66:
            if (r102.shouldEncodeElementDefault(r101, 7) == false) goto L69;
        L70:
            boolean r114 = true;
        L72:
            if (r114 == false) goto L75;
            r102.encodeNullableSerializableElement(r101, 7, nuc.w0.f520792a, r100.f295001h);
        L75:
            if (r102.shouldEncodeElementDefault(r101, 8) == false) goto L78;
        L79:
            boolean r115 = true;
        L81:
            if (r115 == false) goto L84;
            r102.encodeNullableSerializableElement(r101, 8, nuc.g1.f520681a, r100.f295002i);
        L84:
            if (r102.shouldEncodeElementDefault(r101, 9) == false) goto L87;
        L88:
            boolean r116 = true;
        L90:
            if (r116 == false) goto L93;
            r102.encodeNullableSerializableElement(r101, 9, r103[9].getValue(), r100.f295003j);
        L93:
            if (r102.shouldEncodeElementDefault(r101, 10) == false) goto L96;
        L97:
            boolean r117 = true;
        L99:
            if (r117 == false) goto L102;
            r102.encodeNullableSerializableElement(r101, 10, v2.f520790a, r100.f295004k);
        L102:
            if (r102.shouldEncodeElementDefault(r101, 11) == false) goto L105;
        L106:
            boolean r118 = true;
        L108:
            if (r118 == false) goto L111;
            r102.encodeNullableSerializableElement(r101, 11, nuc.w0.f520792a, r100.f295005l);
        L111:
            if (r102.shouldEncodeElementDefault(r101, 12) == false) goto L114;
        L115:
            boolean r119 = true;
        L117:
            if (r119 == false) goto L120;
            r102.encodeNullableSerializableElement(r101, 12, nuc.i.f520705a, r100.f295006m);
        L120:
            if (r102.shouldEncodeElementDefault(r101, 13) == false) goto L123;
        L124:
            boolean r120 = true;
        L126:
            if (r120 == false) goto L129;
            r102.encodeNullableSerializableElement(r101, 13, z1.a.f295638a, r100.f295007n);
        L129:
            if (r102.shouldEncodeElementDefault(r101, 14) == false) goto L132;
        L133:
            boolean r121 = true;
        L135:
            if (r121 == false) goto L138;
            r102.encodeNullableSerializableElement(r101, 14, v2.f520790a, r100.f295008o);
        L138:
            if (r102.shouldEncodeElementDefault(r101, 15) == false) goto L141;
        L142:
            boolean r122 = true;
        L144:
            if (r122 == false) goto L147;
            r102.encodeNullableSerializableElement(r101, 15, r103[15].getValue(), r100.f295009p);
        L147:
            if (r102.shouldEncodeElementDefault(r101, 16) == false) goto L150;
        L151:
            boolean r123 = true;
        L153:
            if (r123 == false) goto L156;
            r102.encodeNullableSerializableElement(r101, 16, r103[16].getValue(), r100.f295010q);
        L156:
            if (r102.shouldEncodeElementDefault(r101, 17) == false) goto L159;
        L160:
            boolean r124 = true;
        L162:
            if (r124 == false) goto L165;
            r102.encodeNullableSerializableElement(r101, 17, v2.f520790a, r100.f295011r);
        L165:
            if (r102.shouldEncodeElementDefault(r101, 18) == false) goto L168;
        L169:
            boolean r125 = true;
        L171:
            if (r125 == false) goto L174;
            r102.encodeNullableSerializableElement(r101, 18, v2.f520790a, r100.f295012s);
        L174:
            if (r102.shouldEncodeElementDefault(r101, 19) == false) goto L177;
        L178:
            r104 = true;
        L179:
            if (r104 == false) goto L181;
            r102.encodeNullableSerializableElement(r101, 19, u1.a.f295492a, r100.f295013t);
        L181:
            r102.endStructure(r101);
            return;
        L177:
            if (r100.f295013t == null) goto L179;
        L168:
            if (r100.f295012s != null) goto L169;
            r125 = false;
            goto L171
        L159:
            if (r100.f295011r != null) goto L160;
            r124 = false;
            goto L162
        L150:
            if (r100.f295010q != null) goto L151;
            r123 = false;
            goto L153
        L141:
            if (r100.f295009p != null) goto L142;
            r122 = false;
            goto L144
        L132:
            if (r100.f295008o != null) goto L133;
            r121 = false;
            goto L135
        L123:
            if (r100.f295007n != null) goto L124;
            r120 = false;
            goto L126
        L114:
            if (r100.f295006m != null) goto L115;
            r119 = false;
            goto L117
        L105:
            if (r100.f295005l != null) goto L106;
            r118 = false;
            goto L108
        L96:
            if (Intrinsics.areEqual(r100.f295004k, "") == false) goto L97;
            r117 = false;
            goto L99
        L87:
            if (r100.f295003j != null) goto L88;
            r116 = false;
            goto L90
        L78:
            if (r100.f295002i != null) goto L79;
            r115 = false;
            goto L81
        L69:
            if (r100.f295001h != null) goto L70;
            r114 = false;
            goto L72
        L60:
            if (Intrinsics.areEqual(r100.f295000g, "") == false) goto L61;
            r113 = false;
            goto L63
        L51:
            if (Intrinsics.areEqual(r100.f294999f, new g1("", "", null, null, 28)) == false) goto L52;
            r112 = false;
            goto L54
        L42:
            if (Intrinsics.areEqual(r100.f294998e, new g1("", "", null, null, 28)) == false) goto L43;
            r109 = false;
            goto L45
        L33:
            if (Intrinsics.areEqual(r100.f294997d, new g1("", "", null, null, 28)) == false) goto L31;
            r108 = false;
            goto L36
        L24:
            if (Intrinsics.areEqual(r100.f294996c, new g1("", "", null, null, 28)) == false) goto L25;
            r107 = false;
            goto L27
        L15:
            if (Intrinsics.areEqual(r100.f294995b, "") == false) goto L16;
            r106 = false;
            goto L18
        L6:
            if (r100.f294994a != null) goto L7;
            r105 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<b2> serializer() {
            return a.f295015a;
        }
    }

    public b2() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2097151);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b2) == true) goto L8;
        return false;
    L8:
        b2 r101 = (b2) r100;
        if (Intrinsics.areEqual(this.f294994a, r101.f294994a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f294995b, r101.f294995b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f294996c, r101.f294996c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f294997d, r101.f294997d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f294998e, r101.f294998e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f294999f, r101.f294999f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f295000g, r101.f295000g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f295001h, r101.f295001h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f295002i, r101.f295002i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f295003j, r101.f295003j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f295004k, r101.f295004k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f295005l, r101.f295005l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f295006m, r101.f295006m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f295007n, r101.f295007n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f295008o, r101.f295008o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f295009p, r101.f295009p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f295010q, r101.f295010q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f295011r, r101.f295011r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f295012s, r101.f295012s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.f295013t, r101.f295013t) == true) goto L69;
        return false;
    L69:
        if (this.f295014u == r101.f295014u) goto L71;
        return false;
    L71:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f294994a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f294995b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        g1 r107 = this.f294996c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        g1 r110 = this.f294997d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        g1 r113 = this.f294998e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        g1 r116 = this.f294999f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f295000g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.f295001h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Long r125 = this.f295002i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        List<c2> r128 = this.f295003j;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f295004k;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.f295005l;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Boolean r137 = this.f295006m;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        z1 r140 = this.f295007n;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.f295008o;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        Map<String, String> r146 = this.f295009p;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        List<String> r149 = this.f295010q;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        String r152 = this.f295011r;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        String r155 = this.f295012s;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        u1 r158 = this.f295013t;
        if (r158 == null) goto L82;
        r101 = r158.hashCode();
    L82:
        int r159 = (r157 + r101) * 31;
        if (this.f295014u == false) goto L85;
        int r160 = 1231;
    L87:
        return r159 + r160;
    L85:
        r160 = 1237;
        goto L87
    L77:
        r156 = r155.hashCode();
        goto L78
    L73:
        r153 = r152.hashCode();
        goto L74
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
        return "SwitchMenuItem(itemId=" + this.f294994a + ", name=" + this.f294995b + ", icon=" + this.f294996c + ", darkModeIcon=" + this.f294997d + ", activeIcon=" + this.f294998e + ", activeDarkModeIcon=" + this.f294999f + ", subTitleName=" + this.f295000g + ", showTaskTools=" + this.f295001h + ", redDotVersion=" + this.f295002i + ", tagList=" + this.f295003j + ", selectedName=" + this.f295004k + ", agentMode=" + this.f295005l + ", needLogin=" + this.f295006m + ", subscribeConfig=" + this.f295007n + ", modelItemKey=" + this.f295008o + ", modelExtraParams=" + this.f295009p + ", conversationModeList=" + this.f295010q + ", defaultConversationMode=" + this.f295011r + ", defaultMode=" + this.f295012s + ", reasoningEffortConfig=" + this.f295013t + ", hasRedDot=" + this.f295014u + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        f294993v = new Lazy[]{null, null, null, null, null, null, null, null, null, LazyKt.lazy(r100, new wa8.z1()), null, null, null, null, null, LazyKt.lazy(r100, new wa8.a2()), LazyKt.lazy(r100, new wa8.b2()), null, null, null};
    }

    public final ModelItemIdentity b() {
        String r100 = this.f295008o;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L15;
        if (this.f294994a != null) goto L15;
        return null;
    L15:
        return new ModelItemIdentity(this.f295008o, this.f294994a);
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public static b2 a(b2 r210, String r211, String r212) {
        Integer r100 = r210.f294994a;
        g1 r101 = r210.f294996c;
        g1 r102 = r210.f294997d;
        g1 r103 = r210.f294998e;
        g1 r104 = r210.f294999f;
        String r105 = r210.f295000g;
        Integer r106 = r210.f295001h;
        Long r107 = r210.f295002i;
        List<c2> r110 = r210.f295003j;
        Integer r111 = r210.f295005l;
        Boolean r112 = r210.f295006m;
        z1 r113 = r210.f295007n;
        String r114 = r210.f295008o;
        Map<String, String> r115 = r210.f295009p;
        List<String> r108 = r210.f295010q;
        String r116 = r210.f295011r;
        String r117 = r210.f295012s;
        u1 r118 = r210.f295013t;
        boolean r119 = r210.f295014u;
        r210.getClass();
        return new b2(r100, r211, r101, r102, r103, r104, r105, r106, r107, r110, r212, r111, r112, r113, r114, r115, r108, r116, r117, r118, r119);
    }

    public b2(int r110, Integer r111, String r112, g1 r113, g1 r114, g1 r115, g1 r116, String r210, Integer r211, Long r212, List r213, String r214, Integer r215, Boolean r216, z1 r217, String r218, Map r219, List r310, String r311, String r312, u1 r313) {
        if ((r110 & 0) == 0) goto L5;
        nuc.b2.b(r110, 0, a.f295016b);
        throw null;
    L5:
        if ((r110 & 1) != 0) goto L7;
        this.f294994a = null;
    L9:
        if ((r110 & 2) != 0) goto L11;
        this.f294995b = "";
    L13:
        if ((r110 & 4) != 0) goto L15;
        g1 r100 = new g1("", "", null, null, 28);
    L16:
        this.f294996c = r100;
        if ((r110 & 8) != 0) goto L19;
        g1 r101 = new g1("", "", null, null, 28);
    L20:
        this.f294997d = r101;
        if ((r110 & 16) != 0) goto L23;
        g1 r102 = new g1("", "", null, null, 28);
    L24:
        this.f294998e = r102;
        if ((r110 & 32) != 0) goto L27;
        g1 r103 = new g1("", "", null, null, 28);
    L28:
        this.f294999f = r103;
        if ((r110 & 64) != 0) goto L31;
        this.f295000g = "";
    L33:
        if ((r110 & 128) != 0) goto L35;
        this.f295001h = null;
    L37:
        if ((r110 & 256) != 0) goto L39;
        this.f295002i = null;
    L41:
        if ((r110 & 512) != 0) goto L43;
        this.f295003j = null;
    L45:
        if ((r110 & 1024) != 0) goto L47;
        this.f295004k = "";
    L49:
        if ((r110 & 2048) != 0) goto L51;
        this.f295005l = null;
    L53:
        if ((r110 & 4096) != 0) goto L55;
        this.f295006m = null;
    L57:
        if ((r110 & 8192) != 0) goto L59;
        this.f295007n = null;
    L61:
        if ((r110 & 16384) != 0) goto L63;
        this.f295008o = null;
    L65:
        if ((32768 & r110) != 0) goto L67;
        this.f295009p = null;
    L69:
        if ((65536 & r110) != 0) goto L71;
        this.f295010q = null;
    L73:
        if ((131072 & r110) != 0) goto L75;
        this.f295011r = null;
    L77:
        if ((262144 & r110) != 0) goto L79;
        this.f295012s = null;
    L81:
        if ((r110 & 524288) != 0) goto L83;
        this.f295013t = null;
    L84:
        this.f295014u = false;
        return;
    L83:
        this.f295013t = r313;
        goto L84
    L79:
        this.f295012s = r312;
        goto L81
    L75:
        this.f295011r = r311;
        goto L77
    L71:
        this.f295010q = r310;
        goto L73
    L67:
        this.f295009p = r219;
        goto L69
    L63:
        this.f295008o = r218;
        goto L65
    L59:
        this.f295007n = r217;
        goto L61
    L55:
        this.f295006m = r216;
        goto L57
    L51:
        this.f295005l = r215;
        goto L53
    L47:
        this.f295004k = r214;
        goto L49
    L43:
        this.f295003j = r213;
        goto L45
    L39:
        this.f295002i = r212;
        goto L41
    L35:
        this.f295001h = r211;
        goto L37
    L31:
        this.f295000g = r210;
        goto L33
    L27:
        r103 = r116;
        goto L28
    L23:
        r102 = r115;
        goto L24
    L19:
        r101 = r114;
        goto L20
    L15:
        r100 = r113;
        goto L16
    L11:
        this.f294995b = r112;
        goto L13
    L7:
        this.f294994a = r111;
        goto L9
    }

    public /* synthetic */ b2(Integer r210, String r211, g1 r212, g1 r213, g1 r310, g1 r311, String r312, Integer r313, Long r314, List r315, String r316, Integer r317, Boolean r318, z1 r319, String r410, Map r411, List r412, String r413, String r414, u1 r415, int r416) {
        if ((r416 & 1) == 0) goto L5;
        Integer r100 = null;
    L7:
        if ((r416 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r416 & 4) == 0) goto L13;
        g1 r102 = new g1("", "", null, null, 28);
    L15:
        if ((r416 & 8) == 0) goto L17;
        g1 r103 = new g1("", "", null, null, 28);
    L19:
        if ((r416 & 16) == 0) goto L21;
        g1 r104 = new g1("", "", null, null, 28);
    L23:
        if ((r416 & 32) == 0) goto L25;
        g1 r105 = new g1("", "", null, null, 28);
    L27:
        if ((r416 & 64) == 0) goto L29;
        String r110 = "";
    L31:
        if ((r416 & 128) == 0) goto L33;
        Integer r111 = null;
    L35:
        if ((r416 & 256) == 0) goto L37;
        Long r112 = null;
    L39:
        if ((r416 & 512) == 0) goto L41;
        List r113 = null;
    L43:
        if ((r416 & 1024) == 0) goto L45;
        String r114 = "";
    L47:
        if ((r416 & 2048) == 0) goto L49;
        Integer r115 = null;
    L51:
        if ((r416 & 4096) == 0) goto L53;
        Boolean r116 = null;
    L55:
        if ((r416 & 8192) == 0) goto L57;
        z1 r117 = null;
    L59:
        if ((r416 & 16384) == 0) goto L61;
        String r118 = null;
    L63:
        if ((32768 & r416) == 0) goto L65;
        Map r119 = null;
    L67:
        if ((65536 & r416) == 0) goto L69;
        List r214 = null;
    L71:
        if ((131072 & r416) == 0) goto L73;
        String r215 = null;
    L75:
        if ((262144 & r416) == 0) goto L77;
        String r216 = null;
    L79:
        if ((r416 & 524288) == 0) goto L81;
        u1 r217 = null;
    L82:
        this(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r214, r215, r216, r217, false);
        return;
    L81:
        r217 = r415;
        goto L82
    L77:
        r216 = r414;
        goto L79
    L73:
        r215 = r413;
        goto L75
    L69:
        r214 = r412;
        goto L71
    L65:
        r119 = r411;
        goto L67
    L61:
        r118 = r410;
        goto L63
    L57:
        r117 = r319;
        goto L59
    L53:
        r116 = r318;
        goto L55
    L49:
        r115 = r317;
        goto L51
    L45:
        r114 = r316;
        goto L47
    L41:
        r113 = r315;
        goto L43
    L37:
        r112 = r314;
        goto L39
    L33:
        r111 = r313;
        goto L35
    L29:
        r110 = r312;
        goto L31
    L25:
        r105 = r311;
        goto L27
    L21:
        r104 = r310;
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

    public b2(Integer r100, String r101, g1 r102, g1 r103, g1 r104, g1 r105, String r106, Integer r110, Long r111, List<c2> r112, String r113, Integer r114, Boolean r115, z1 r116, String r117, Map<String, String> r118, List<String> r119, String r210, String r211, u1 r212, boolean r213) {
        this.f294994a = r100;
        this.f294995b = r101;
        this.f294996c = r102;
        this.f294997d = r103;
        this.f294998e = r104;
        this.f294999f = r105;
        this.f295000g = r106;
        this.f295001h = r110;
        this.f295002i = r111;
        this.f295003j = r112;
        this.f295004k = r113;
        this.f295005l = r114;
        this.f295006m = r115;
        this.f295007n = r116;
        this.f295008o = r117;
        this.f295009p = r118;
        this.f295010q = r119;
        this.f295011r = r210;
        this.f295012s = r211;
        this.f295013t = r212;
        this.f295014u = r213;
    }
}
