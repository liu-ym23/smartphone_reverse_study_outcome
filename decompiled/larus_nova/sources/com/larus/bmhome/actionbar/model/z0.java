package com.larus.bmhome.actionbar.model;

import com.larus.bmhome.instruction.core.model.ActionBarDisplayType;
import com.larus.bmhome.instruction.core.model.ActionBarExecutionType;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;
import nuc.v2;

/* JADX INFO: loaded from: classes25.dex */
@Serializable
public final class z0 {
    public static final b Companion = null;
    public String A;
    public jq9.j B;
    public boolean C;
    public final boolean D;
    public final boolean E;
    public final boolean F;
    public final String G;
    public final Map<String, String> H;
    public final Integer I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final d f295604J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f295605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f295606b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g1 f295607c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g1 f295608d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f295609e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f295610f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f295611g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f295612h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f295613i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ouc.d0 f295614j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final h1 f295615k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final n0 f295616l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final e0 f295617m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final h0 f295618n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final p0 f295619o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ouc.d0 f295620p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final r f295621q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Boolean f295622r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Boolean f295623s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Long f295624t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final m0 f295625u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f295626v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final b1 f295627w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f295628x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f295629y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public wa8.u1 f295630z;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<z0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f295631a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f295632b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f295632b;
        }

        static {
            a r100 = new a();
            f295631a = r100;
            g2 r101 = new g2("com.larus.bmhome.actionbar.model.CustomActionBarItem", r100, 25);
            r101.j("item_id", true);
            r101.j("action_bar_key", true);
            r101.j("icon", true);
            r101.j("dark_mode_icon", true);
            r101.j("name", true);
            r101.j("display_type", true);
            r101.j("action_type", true);
            r101.j("panel_title_name", true);
            r101.j("passthrough_field", true);
            r101.j("bot_send_msg_conf", true);
            r101.j("input_box_content", true);
            r101.j("user_send_msg_conf", true);
            r101.j("open_by_schema_conf", true);
            r101.j("switch_conf", true);
            r101.j("active_switch_conf", true);
            r101.j("msg_template_conf", true);
            r101.j("instruction_conf", true);
            r101.j("hidden", true);
            r101.j("disable_in_tourist", true);
            r101.j("red_dot_version", true);
            r101.j("display_extra", true);
            r101.j("biz_extra", true);
            r101.j("custom_menu_conf", true);
            r101.j("sub_title_name", true);
            r101.j("degrade_config", true);
            f295632b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            nuc.g1 r100 = nuc.g1.f520681a;
            v2 r101 = v2.f520790a;
            g1.a r102 = g1.a.f295160a;
            nuc.w0 r103 = nuc.w0.f520792a;
            ouc.f0 r104 = ouc.f0.f526848a;
            nuc.i r105 = nuc.i.f520705a;
            return new juc.d[]{kuc.a.d(r100), kuc.a.d(r101), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(r101), kuc.a.d(r103), kuc.a.d(r103), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r104), kuc.a.d(h1.a.f295190a), kuc.a.d(n0.a.f295333a), kuc.a.d(e0.a.f295088a), kuc.a.d(h0.a.f295178a), kuc.a.d(p0.a.f295381a), kuc.a.d(r104), kuc.a.d(r.a.f295420a), kuc.a.d(r105), kuc.a.d(r105), kuc.a.d(r100), kuc.a.d(m0.a.f295314a), kuc.a.d(r101), kuc.a.d(b1.a.f294991a), kuc.a.d(r101), kuc.a.d(d.a.f295056a)};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r510) {
            Intrinsics.checkNotNullParameter(r510, "decoder");
            g2 r100 = f295632b;
            muc.c r101 = r510.beginStructure(r100);
            int r102 = 0;
            String r110 = null;
            if (r101.decodeSequentially() == false) goto L5;
            nuc.g1 r103 = nuc.g1.f520681a;
            Long r104 = (Long) r101.decodeNullableSerializableElement(r100, 0, r103, null);
            v2 r111 = v2.f520790a;
            String r112 = (String) r101.decodeNullableSerializableElement(r100, 1, r111, null);
            g1.a r113 = g1.a.f295160a;
            g1 r105 = (g1) r101.decodeNullableSerializableElement(r100, 2, r113, null);
            g1 r114 = (g1) r101.decodeNullableSerializableElement(r100, 3, r113, null);
            String r115 = (String) r101.decodeNullableSerializableElement(r100, 4, r111, null);
            nuc.w0 r116 = nuc.w0.f520792a;
            Integer r106 = (Integer) r101.decodeNullableSerializableElement(r100, 5, r116, null);
            Integer r107 = (Integer) r101.decodeNullableSerializableElement(r100, 6, r116, null);
            String r108 = (String) r101.decodeNullableSerializableElement(r100, 7, r111, null);
            String r109 = (String) r101.decodeNullableSerializableElement(r100, 8, r111, null);
            ouc.f0 r117 = ouc.f0.f526848a;
            ouc.d0 r118 = (ouc.d0) r101.decodeNullableSerializableElement(r100, 9, r117, null);
            h1 r210 = (h1) r101.decodeNullableSerializableElement(r100, 10, h1.a.f295190a, null);
            n0 r119 = (n0) r101.decodeNullableSerializableElement(r100, 11, n0.a.f295333a, null);
            e0 r120 = (e0) r101.decodeNullableSerializableElement(r100, 12, e0.a.f295088a, null);
            h0 r121 = (h0) r101.decodeNullableSerializableElement(r100, 13, h0.a.f295178a, null);
            p0 r122 = (p0) r101.decodeNullableSerializableElement(r100, 14, p0.a.f295381a, null);
            ouc.d0 r123 = (ouc.d0) r101.decodeNullableSerializableElement(r100, 15, r117, null);
            r r124 = (r) r101.decodeNullableSerializableElement(r100, 16, r.a.f295420a, null);
            nuc.i r125 = nuc.i.f520705a;
            Boolean r126 = (Boolean) r101.decodeNullableSerializableElement(r100, 17, r125, null);
            Boolean r127 = (Boolean) r101.decodeNullableSerializableElement(r100, 18, r125, null);
            Long r128 = (Long) r101.decodeNullableSerializableElement(r100, 19, r103, null);
            m0 r129 = (m0) r101.decodeNullableSerializableElement(r100, 20, m0.a.f295314a, null);
            String r130 = (String) r101.decodeNullableSerializableElement(r100, 21, r111, null);
            b1 r131 = (b1) r101.decodeNullableSerializableElement(r100, 22, b1.a.f294991a, null);
            String r132 = (String) r101.decodeNullableSerializableElement(r100, 23, r111, null);
            m0 r310 = r129;
            d r410 = (d) r101.decodeNullableSerializableElement(r100, 24, d.a.f295056a, null);
            String r311 = r132;
            ouc.d0 r312 = r123;
            String r313 = r130;
            Boolean r314 = r127;
            Long r315 = r128;
            b1 r316 = r131;
            Boolean r317 = r126;
            r r318 = r124;
            p0 r319 = r122;
            h0 r211 = r121;
            Integer r212 = r106;
            Integer r213 = r107;
            int r133 = 33554431;
            String r214 = r108;
            g1 r134 = r105;
            Long r135 = r104;
            String r136 = r112;
            g1 r137 = r114;
            String r215 = r115;
            e0 r216 = r120;
            n0 r217 = r119;
            ouc.d0 r218 = r118;
            String r219 = r109;
        L48:
            r101.endStructure(r100);
            return new z0(r133, r135, r136, r134, r137, r215, r212, r213, r214, r219, r218, r210, r217, r216, r211, r319, r312, r318, r317, r314, r315, r310, r313, r316, r311, r410);
        L5:
            p0 r138 = null;
            Boolean r139 = null;
            ouc.d0 r140 = null;
            Long r141 = null;
            m0 r142 = null;
            d r143 = null;
            Boolean r144 = null;
            b1 r145 = null;
            h0 r146 = null;
            e0 r147 = null;
            r r148 = null;
            String r149 = null;
            Long r220 = null;
            String r320 = null;
            g1 r321 = null;
            g1 r411 = null;
            String r412 = null;
            Integer r413 = null;
            Integer r414 = null;
            String r415 = null;
            String r416 = null;
            ouc.d0 r417 = null;
            h1 r418 = null;
            n0 r419 = null;
            boolean r420 = true;
        L6:
            if (r420 == false) goto L47;
            e0 r511 = r147;
            int r150 = r101.decodeElementIndex(r100);
            switch(r150) {
                case -1: goto L45;
                case 0: goto L44;
                case 1: goto L42;
                case 2: goto L41;
                case 3: goto L40;
                case 4: goto L39;
                case 5: goto L38;
                case 6: goto L37;
                case 7: goto L36;
                case 8: goto L35;
                case 9: goto L34;
                case 10: goto L33;
                case 11: goto L32;
                case 12: goto L31;
                case 13: goto L30;
                case 14: goto L27;
                case 15: goto L25;
                case 16: goto L23;
                case 17: goto L21;
                case 18: goto L20;
                case 19: goto L19;
                case 20: goto L17;
                case 21: goto L15;
                case 22: goto L13;
                case 23: goto L12;
                case 24: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r150);
        L30:
            r146 = (h0) r101.decodeNullableSerializableElement(r100, 13, h0.a.f295178a, r146);
            r102 = r102 | 8192;
            r143 = r143;
            r138 = r138;
            r147 = r511;
            goto L6
        L31:
            r143 = r143;
            r102 = r102 | 4096;
            r147 = (e0) r101.decodeNullableSerializableElement(r100, 12, e0.a.f295088a, r511);
            r146 = r146;
            r138 = r138;
            r139 = r139;
        L43:
            r143 = r143;
            goto L6
        L32:
            r143 = r143;
            r419 = (n0) r101.decodeNullableSerializableElement(r100, 11, n0.a.f295333a, r419);
            r102 = r102 | 2048;
            r146 = r146;
            r138 = r138;
            r139 = r139;
            r147 = r511;
            goto L43
        L33:
            r143 = r143;
            r418 = (h1) r101.decodeNullableSerializableElement(r100, 10, h1.a.f295190a, r418);
            r102 = r102 | 1024;
            r146 = r146;
            r138 = r138;
            r139 = r139;
            r147 = r511;
            r419 = r419;
            goto L43
        L34:
            h1 r322 = r418;
            r102 = r102 | 512;
            ouc.d0 r323 = (ouc.d0) r101.decodeNullableSerializableElement(r100, 9, ouc.f0.f526848a, r417);
            String r221 = r320;
        L46:
            r146 = r146;
            r138 = r138;
            r139 = r139;
            r147 = r511;
            r419 = r419;
            r320 = r221;
            r321 = r321;
            r411 = r411;
            r412 = r412;
            r413 = r413;
            r414 = r414;
            r415 = r415;
            r416 = r416;
            r417 = r323;
            r418 = r322;
            goto L43
        L35:
            r143 = r143;
            r416 = (String) r101.decodeNullableSerializableElement(r100, 8, v2.f520790a, r416);
            r102 = r102 | 256;
            r146 = r146;
            r138 = r138;
            r139 = r139;
            r147 = r511;
            r417 = r417;
            goto L43
        L36:
            r143 = r143;
            r415 = (String) r101.decodeNullableSerializableElement(r100, 7, v2.f520790a, r415);
            r102 = r102 | 128;
            r146 = r146;
            r138 = r138;
            r139 = r139;
            r147 = r511;
            r416 = r416;
            goto L43
        L37:
            r143 = r143;
            r414 = (Integer) r101.decodeNullableSerializableElement(r100, 6, nuc.w0.f520792a, r414);
            r102 = r102 | 64;
            r146 = r146;
            r138 = r138;
            r139 = r139;
            r147 = r511;
            r415 = r415;
            goto L43
        L38:
            r143 = r143;
            r413 = (Integer) r101.decodeNullableSerializableElement(r100, 5, nuc.w0.f520792a, r413);
            r102 = r102 | 32;
            r146 = r146;
            r138 = r138;
            r139 = r139;
            r147 = r511;
            r414 = r414;
            goto L43
        L39:
            r143 = r143;
            r412 = (String) r101.decodeNullableSerializableElement(r100, 4, v2.f520790a, r412);
            r102 = r102 | 16;
            r146 = r146;
            r138 = r138;
            r139 = r139;
            r147 = r511;
            r413 = r413;
            goto L43
        L40:
            r143 = r143;
            r411 = (g1) r101.decodeNullableSerializableElement(r100, 3, g1.a.f295160a, r411);
            r102 = r102 | 8;
            r146 = r146;
            r138 = r138;
            r139 = r139;
            r147 = r511;
            r412 = r412;
            goto L43
        L41:
            r143 = r143;
            r321 = (g1) r101.decodeNullableSerializableElement(r100, 2, g1.a.f295160a, r321);
            r102 = r102 | 4;
            r146 = r146;
            r138 = r138;
            r139 = r139;
            r147 = r511;
            r411 = r411;
            goto L43
        L42:
            r143 = r143;
            r320 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r320);
            r102 = r102 | 2;
            r146 = r146;
            r138 = r138;
            r139 = r139;
            r147 = r511;
            r321 = r321;
            goto L43
        L44:
            r323 = r417;
            r322 = r418;
            r221 = r320;
            r220 = (Long) r101.decodeNullableSerializableElement(r100, 0, nuc.g1.f520681a, r220);
            r102 = r102 | 1;
            goto L46
        L45:
            r221 = r320;
            r323 = r417;
            r322 = r418;
            r420 = false;
            goto L46
        L11:
            r143 = (d) r101.decodeNullableSerializableElement(r100, 24, d.a.f295056a, r143);
            int r151 = 16777216;
        L16:
            String r152 = r149;
            int r153 = r151;
            String r154 = r110;
            b1 r155 = r145;
            d r156 = r143;
        L18:
            r102 = r102 | r153;
            r149 = r152;
        L29:
            r143 = r156;
            r145 = r155;
            r110 = r154;
            r147 = r511;
            r146 = r146;
            goto L6
        L12:
            r149 = (String) r101.decodeNullableSerializableElement(r100, 23, v2.f520790a, r149);
            r151 = 8388608;
            goto L16
        L13:
            r145 = (b1) r101.decodeNullableSerializableElement(r100, 22, b1.a.f294991a, r145);
            r151 = 4194304;
            goto L16
        L15:
            r146 = r146;
            r110 = (String) r101.decodeNullableSerializableElement(r100, 21, v2.f520790a, r110);
            r151 = 2097152;
            goto L16
        L17:
            r146 = r146;
            r142 = (m0) r101.decodeNullableSerializableElement(r100, 20, m0.a.f295314a, r142);
            r154 = r110;
            r152 = r149;
            r153 = 1048576;
            r155 = r145;
            r156 = r143;
            goto L18
        L19:
            r141 = (Long) r101.decodeNullableSerializableElement(r100, 19, nuc.g1.f520681a, r141);
            int r157 = 524288;
        L26:
            r102 = r102 | r157;
        L28:
            r154 = r110;
            r155 = r145;
            r156 = r143;
            goto L29
        L20:
            r144 = (Boolean) r101.decodeNullableSerializableElement(r100, 18, nuc.i.f520705a, r144);
            r157 = 262144;
            goto L26
        L21:
            r139 = (Boolean) r101.decodeNullableSerializableElement(r100, 17, nuc.i.f520705a, r139);
            r157 = 131072;
            goto L26
        L23:
            r143 = r143;
            r146 = r146;
            r148 = (r) r101.decodeNullableSerializableElement(r100, 16, r.a.f295420a, r148);
            r157 = 65536;
            goto L26
        L25:
            r143 = r143;
            r146 = r146;
            r140 = (ouc.d0) r101.decodeNullableSerializableElement(r100, 15, ouc.f0.f526848a, r140);
            r157 = 32768;
            goto L26
        L27:
            r143 = r143;
            r146 = r146;
            r138 = (p0) r101.decodeNullableSerializableElement(r100, 14, p0.a.f295381a, r138);
            r102 = r102 | 16384;
            goto L28
        L47:
            String r222 = r320;
            g1 r223 = r321;
            g1 r324 = r411;
            r410 = r143;
            r135 = r220;
            r211 = r146;
            r316 = r145;
            r311 = r149;
            r136 = r222;
            r134 = r223;
            r137 = r324;
            r215 = r412;
            r212 = r413;
            r213 = r414;
            r312 = r140;
            r133 = r102;
            r318 = r148;
            r319 = r138;
            r317 = r139;
            r216 = r147;
            r217 = r419;
            r214 = r415;
            r219 = r416;
            r218 = r417;
            r210 = r418;
            r315 = r141;
            r310 = r142;
            r314 = r144;
            r313 = r110;
            goto L48
        }

        @Override // juc.n
        public final void serialize(muc.f r110, Object r210) {
            z0 r100 = (z0) r210;
            Intrinsics.checkNotNullParameter(r110, "encoder");
            Intrinsics.checkNotNullParameter(r100, "value");
            g2 r101 = f295632b;
            muc.d r102 = r110.beginStructure(r101);
            b r103 = z0.Companion;
            boolean r104 = true;
            if (r102.shouldEncodeElementDefault(r101, 0) == true) goto L10;
            Long r105 = r100.f295605a;
            if (r105 == null) goto L10;
            if (r105.longValue() != 0) goto L10;
            boolean r106 = false;
        L12:
            if (r106 == false) goto L15;
            r102.encodeNullableSerializableElement(r101, 0, nuc.g1.f520681a, r100.f295605a);
        L15:
            if (r102.shouldEncodeElementDefault(r101, 1) == false) goto L18;
        L19:
            boolean r107 = true;
        L21:
            if (r107 == false) goto L24;
            r102.encodeNullableSerializableElement(r101, 1, v2.f520790a, r100.f295606b);
        L24:
            if (r102.shouldEncodeElementDefault(r101, 2) == false) goto L27;
        L28:
            boolean r108 = true;
        L30:
            if (r108 == false) goto L33;
            r102.encodeNullableSerializableElement(r101, 2, g1.a.f295160a, r100.f295607c);
        L33:
            if (r102.shouldEncodeElementDefault(r101, 3) == false) goto L36;
        L39:
            if (r104 == false) goto L42;
            r102.encodeNullableSerializableElement(r101, 3, g1.a.f295160a, r100.f295608d);
        L42:
            if (r102.shouldEncodeElementDefault(r101, 4) == false) goto L45;
        L46:
            boolean r109 = true;
        L48:
            if (r109 == false) goto L51;
            r102.encodeNullableSerializableElement(r101, 4, v2.f520790a, r100.f295609e);
        L51:
            if (r102.shouldEncodeElementDefault(r101, 5) == true) goto L58;
            Integer r111 = r100.f295610f;
            int r112 = ActionBarDisplayType.NORMAL.getValue();
            if (r111 == null) goto L58;
            if (r111.intValue() != r112) goto L58;
            boolean r113 = false;
        L60:
            if (r113 == false) goto L63;
            r102.encodeNullableSerializableElement(r101, 5, nuc.w0.f520792a, r100.f295610f);
        L63:
            if (r102.shouldEncodeElementDefault(r101, 6) == true) goto L70;
            Integer r114 = r100.f295611g;
            int r115 = ActionBarExecutionType.UNKNOWN.getValue();
            if (r114 == null) goto L70;
            if (r114.intValue() != r115) goto L70;
            boolean r116 = false;
        L72:
            if (r116 == false) goto L75;
            r102.encodeNullableSerializableElement(r101, 6, nuc.w0.f520792a, r100.f295611g);
        L75:
            if (r102.shouldEncodeElementDefault(r101, 7) == false) goto L78;
        L79:
            boolean r117 = true;
        L81:
            if (r117 == false) goto L84;
            r102.encodeNullableSerializableElement(r101, 7, v2.f520790a, r100.f295612h);
        L84:
            if (r102.shouldEncodeElementDefault(r101, 8) == false) goto L87;
        L88:
            boolean r118 = true;
        L90:
            if (r118 == false) goto L93;
            r102.encodeNullableSerializableElement(r101, 8, v2.f520790a, r100.f295613i);
        L93:
            if (r102.shouldEncodeElementDefault(r101, 9) == false) goto L96;
        L97:
            boolean r119 = true;
        L99:
            if (r119 == false) goto L102;
            r102.encodeNullableSerializableElement(r101, 9, ouc.f0.f526848a, r100.f295614j);
        L102:
            if (r102.shouldEncodeElementDefault(r101, 10) == false) goto L105;
        L106:
            boolean r120 = true;
        L108:
            if (r120 == false) goto L111;
            r102.encodeNullableSerializableElement(r101, 10, h1.a.f295190a, r100.f295615k);
        L111:
            if (r102.shouldEncodeElementDefault(r101, 11) == false) goto L114;
        L115:
            boolean r121 = true;
        L117:
            if (r121 == false) goto L120;
            r102.encodeNullableSerializableElement(r101, 11, n0.a.f295333a, r100.f295616l);
        L120:
            if (r102.shouldEncodeElementDefault(r101, 12) == false) goto L123;
        L124:
            boolean r122 = true;
        L126:
            if (r122 == false) goto L129;
            r102.encodeNullableSerializableElement(r101, 12, e0.a.f295088a, r100.f295617m);
        L129:
            if (r102.shouldEncodeElementDefault(r101, 13) == false) goto L132;
        L133:
            boolean r123 = true;
        L135:
            if (r123 == false) goto L138;
            r102.encodeNullableSerializableElement(r101, 13, h0.a.f295178a, r100.f295618n);
        L138:
            if (r102.shouldEncodeElementDefault(r101, 14) == false) goto L141;
        L142:
            boolean r124 = true;
        L144:
            if (r124 == false) goto L147;
            r102.encodeNullableSerializableElement(r101, 14, p0.a.f295381a, r100.f295619o);
        L147:
            if (r102.shouldEncodeElementDefault(r101, 15) == false) goto L150;
        L151:
            boolean r125 = true;
        L153:
            if (r125 == false) goto L156;
            r102.encodeNullableSerializableElement(r101, 15, ouc.f0.f526848a, r100.f295620p);
        L156:
            if (r102.shouldEncodeElementDefault(r101, 16) == false) goto L159;
        L160:
            boolean r126 = true;
        L162:
            if (r126 == false) goto L165;
            r102.encodeNullableSerializableElement(r101, 16, r.a.f295420a, r100.f295621q);
        L165:
            if (r102.shouldEncodeElementDefault(r101, 17) == false) goto L168;
        L169:
            boolean r127 = true;
        L171:
            if (r127 == false) goto L174;
            r102.encodeNullableSerializableElement(r101, 17, nuc.i.f520705a, r100.f295622r);
        L174:
            if (r102.shouldEncodeElementDefault(r101, 18) == false) goto L177;
        L178:
            boolean r128 = true;
        L180:
            if (r128 == false) goto L183;
            r102.encodeNullableSerializableElement(r101, 18, nuc.i.f520705a, r100.f295623s);
        L183:
            if (r102.shouldEncodeElementDefault(r101, 19) == true) goto L190;
            Long r129 = r100.f295624t;
            if (r129 == null) goto L190;
            if (r129.longValue() != 0) goto L190;
            boolean r130 = false;
        L192:
            if (r130 == false) goto L195;
            r102.encodeNullableSerializableElement(r101, 19, nuc.g1.f520681a, r100.f295624t);
        L195:
            if (r102.shouldEncodeElementDefault(r101, 20) == false) goto L198;
        L199:
            boolean r131 = true;
        L201:
            if (r131 == false) goto L204;
            r102.encodeNullableSerializableElement(r101, 20, m0.a.f295314a, r100.f295625u);
        L204:
            if (r102.shouldEncodeElementDefault(r101, 21) == false) goto L207;
        L208:
            boolean r132 = true;
        L210:
            if (r132 == false) goto L213;
            r102.encodeNullableSerializableElement(r101, 21, v2.f520790a, r100.f295626v);
        L213:
            if (r102.shouldEncodeElementDefault(r101, 22) == false) goto L216;
        L217:
            boolean r133 = true;
        L219:
            if (r133 == false) goto L222;
            r102.encodeNullableSerializableElement(r101, 22, b1.a.f294991a, r100.f295627w);
        L222:
            if (r102.shouldEncodeElementDefault(r101, 23) == false) goto L225;
        L226:
            boolean r134 = true;
        L228:
            if (r134 == false) goto L231;
            r102.encodeNullableSerializableElement(r101, 23, v2.f520790a, r100.f295628x);
        L231:
            if (r102.shouldEncodeElementDefault(r101, 24) == false) goto L234;
        L235:
            boolean r135 = true;
        L237:
            if (r135 == false) goto L239;
            r102.encodeNullableSerializableElement(r101, 24, d.a.f295056a, r100.f295604J);
        L239:
            r102.endStructure(r101);
            return;
        L234:
            if (r100.f295604J != null) goto L235;
            r135 = false;
            goto L237
        L225:
            if (r100.f295628x != null) goto L226;
            r134 = false;
            goto L228
        L216:
            if (r100.f295627w != null) goto L217;
            r133 = false;
            goto L219
        L207:
            if (r100.f295626v != null) goto L208;
            r132 = false;
            goto L210
        L198:
            if (r100.f295625u != null) goto L199;
            r131 = false;
        L190:
            r130 = true;
            goto L192
        L177:
            if (Intrinsics.areEqual(r100.f295623s, Boolean.FALSE) == false) goto L178;
            r128 = false;
            goto L180
        L168:
            if (Intrinsics.areEqual(r100.f295622r, Boolean.FALSE) == false) goto L169;
            r127 = false;
            goto L171
        L159:
            if (Intrinsics.areEqual(r100.f295621q, new r(null, null, null, null, null, null, null, null, UnixStat.PERM_MASK)) == false) goto L160;
            r126 = false;
            goto L162
        L150:
            if (r100.f295620p != null) goto L151;
            r125 = false;
            goto L153
        L141:
            if (r100.f295619o != null) goto L142;
            r124 = false;
            goto L144
        L132:
            if (Intrinsics.areEqual(r100.f295618n, new h0(Boolean.FALSE)) == false) goto L133;
            r123 = false;
            goto L135
        L123:
            if (r100.f295617m != null) goto L124;
            r122 = false;
            goto L126
        L114:
            if (Intrinsics.areEqual(r100.f295616l, new n0("", 2)) == false) goto L115;
            r121 = false;
            goto L117
        L105:
            if (r100.f295615k != null) goto L106;
            r120 = false;
            goto L108
        L96:
            if (r100.f295614j != null) goto L97;
            r119 = false;
            goto L99
        L87:
            if (Intrinsics.areEqual(r100.f295613i, "") == false) goto L88;
            r118 = false;
            goto L90
        L78:
            if (Intrinsics.areEqual(r100.f295612h, "") == false) goto L79;
            r117 = false;
        L70:
            r116 = true;
        L58:
            r113 = true;
            goto L60
        L45:
            if (Intrinsics.areEqual(r100.f295609e, "") == false) goto L46;
            r109 = false;
            goto L48
        L36:
            if (Intrinsics.areEqual(r100.f295608d, new g1("", "", null, null, 28)) == true) goto L38;
            r104 = true;
            goto L39
        L38:
            r104 = false;
            goto L39
        L27:
            if (Intrinsics.areEqual(r100.f295607c, new g1("", "", null, null, 28)) == false) goto L28;
            r108 = false;
            goto L30
        L18:
            if (Intrinsics.areEqual(r100.f295606b, "") == false) goto L19;
            r107 = false;
        L10:
            r106 = true;
            goto L12
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<z0> serializer() {
            return a.f295631a;
        }
    }

    public z0() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, -1, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof z0) == true) goto L8;
        return false;
    L8:
        z0 r101 = (z0) r100;
        if (Intrinsics.areEqual(this.f295605a, r101.f295605a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f295606b, r101.f295606b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f295607c, r101.f295607c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f295608d, r101.f295608d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f295609e, r101.f295609e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f295610f, r101.f295610f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f295611g, r101.f295611g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f295612h, r101.f295612h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f295613i, r101.f295613i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f295614j, r101.f295614j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f295615k, r101.f295615k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f295616l, r101.f295616l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f295617m, r101.f295617m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f295618n, r101.f295618n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f295619o, r101.f295619o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f295620p, r101.f295620p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f295621q, r101.f295621q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f295622r, r101.f295622r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f295623s, r101.f295623s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.f295624t, r101.f295624t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.f295625u, r101.f295625u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.f295626v, r101.f295626v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.f295627w, r101.f295627w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.f295628x, r101.f295628x) == true) goto L81;
        return false;
    L81:
        if (this.f295629y == r101.f295629y) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.f295630z, r101.f295630z) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.A, r101.A) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.B, r101.B) == true) goto L93;
        return false;
    L93:
        if (this.C == r101.C) goto L96;
        return false;
    L96:
        if (this.D == r101.D) goto L99;
        return false;
    L99:
        if (this.E == r101.E) goto L102;
        return false;
    L102:
        if (this.F == r101.F) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.G, r101.G) == true) goto L108;
        return false;
    L108:
        if (Intrinsics.areEqual(this.H, r101.H) == true) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.I, r101.I) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.f295604J, r101.f295604J) == true) goto L116;
        return false;
    L116:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.f295605a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f295606b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        g1 r107 = this.f295607c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        g1 r110 = this.f295608d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f295609e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f295610f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.f295611g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f295612h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f295613i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        ouc.d0 r128 = this.f295614j;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        h1 r131 = this.f295615k;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        n0 r134 = this.f295616l;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        e0 r137 = this.f295617m;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        h0 r140 = this.f295618n;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        p0 r143 = this.f295619o;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        ouc.d0 r146 = this.f295620p;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        r r149 = this.f295621q;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        Boolean r152 = this.f295622r;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        Boolean r155 = this.f295623s;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        Long r158 = this.f295624t;
        if (r158 != null) goto L81;
        int r159 = 0;
    L82:
        int r160 = (r157 + r159) * 31;
        m0 r161 = this.f295625u;
        if (r161 != null) goto L85;
        int r162 = 0;
    L86:
        int r163 = (r160 + r162) * 31;
        String r164 = this.f295626v;
        if (r164 != null) goto L89;
        int r165 = 0;
    L90:
        int r166 = (r163 + r165) * 31;
        b1 r167 = this.f295627w;
        if (r167 != null) goto L93;
        int r168 = 0;
    L94:
        int r169 = (r166 + r168) * 31;
        String r170 = this.f295628x;
        if (r170 != null) goto L97;
        int r171 = 0;
    L98:
        int r172 = (r169 + r171) * 31;
        int r173 = 1231;
        if (this.f295629y == false) goto L101;
        int r174 = 1231;
    L102:
        int r175 = (r172 + r174) * 31;
        wa8.u1 r176 = this.f295630z;
        if (r176 != null) goto L105;
        int r177 = 0;
    L106:
        int r178 = (r175 + r177) * 31;
        String r179 = this.A;
        if (r179 != null) goto L109;
        int r180 = 0;
    L110:
        int r181 = (r178 + r180) * 31;
        jq9.j r182 = this.B;
        if (r182 != null) goto L113;
        int r183 = 0;
    L114:
        int r184 = (r181 + r183) * 31;
        if (this.C == false) goto L117;
        int r185 = 1231;
    L118:
        int r186 = (r184 + r185) * 31;
        if (this.D == false) goto L121;
        int r187 = 1231;
    L122:
        int r188 = (r186 + r187) * 31;
        if (this.E == false) goto L125;
        int r189 = 1231;
    L126:
        int r190 = (r188 + r189) * 31;
        if (this.F == true) goto L130;
        r173 = 1237;
    L130:
        int r191 = (r190 + r173) * 31;
        String r192 = this.G;
        if (r192 != null) goto L133;
        int r193 = 0;
    L134:
        int r194 = (r191 + r193) * 31;
        Map<String, String> r195 = this.H;
        if (r195 != null) goto L137;
        int r196 = 0;
    L138:
        int r197 = (r194 + r196) * 31;
        Integer r198 = this.I;
        if (r198 != null) goto L141;
        int r199 = 0;
    L142:
        int r200 = (r197 + r199) * 31;
        d r201 = this.f295604J;
        if (r201 == null) goto L147;
        r101 = r201.hashCode();
    L147:
        return r200 + r101;
    L141:
        r199 = r198.hashCode();
        goto L142
    L137:
        r196 = r195.hashCode();
        goto L138
    L133:
        r193 = r192.hashCode();
        goto L134
    L125:
        r189 = 1237;
        goto L126
    L121:
        r187 = 1237;
        goto L122
    L117:
        r185 = 1237;
        goto L118
    L113:
        r183 = r182.hashCode();
        goto L114
    L109:
        r180 = r179.hashCode();
        goto L110
    L105:
        r177 = r176.hashCode();
        goto L106
    L101:
        r174 = 1237;
        goto L102
    L97:
        r171 = r170.hashCode();
        goto L98
    L93:
        r168 = r167.hashCode();
        goto L94
    L89:
        r165 = r164.hashCode();
        goto L90
    L85:
        r162 = r161.hashCode();
        goto L86
    L81:
        r159 = r158.hashCode();
        goto L82
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
        return "CustomActionBarItem(itemId=" + this.f295605a + ", actionBarKey=" + this.f295606b + ", icon=" + this.f295607c + ", darkModeIcon=" + this.f295608d + ", name=" + this.f295609e + ", displayType=" + this.f295610f + ", actionType=" + this.f295611g + ", panelTitleName=" + this.f295612h + ", passThroughField=" + this.f295613i + ", botSendMsgConf=" + this.f295614j + ", inputBoxContent=" + this.f295615k + ", userSendMsgConf=" + this.f295616l + ", openBySchemaConf=" + this.f295617m + ", switchSyncConf=" + this.f295618n + ", activeSwitchConf=" + this.f295619o + ", msgTemplateConf=" + this.f295620p + ", instructionConf=" + this.f295621q + ", hidden=" + this.f295622r + ", disableInTourist=" + this.f295623s + ", redDotVersion=" + this.f295624t + ", displayExtra=" + this.f295625u + ", bizExtra=" + this.f295626v + ", customMenuConf=" + this.f295627w + ", subTitleName=" + this.f295628x + ", hasRedDot=" + this.f295629y + ", customRedDotTextInfo=" + this.f295630z + ", recommendRequestId=" + this.A + ", actionBarGradientStyle=" + this.B + ", fromSegmentFramework=" + this.C + ", notReportApi=" + this.D + ", needReportShowEvent=" + this.E + ", needReportClickEvent=" + this.F + ", defaultPrompt=" + this.G + ", clientBizExtra=" + this.H + ", rightArrowIconColorRes=" + this.I + ", degradeConfig=" + this.f295604J + ')';
    }

    static {
        Companion = new b();
    }

    public static z0 a(z0 r410, Long r411, String r412, g1 r413, g1 r414, String r415, Integer r416, e0 r417, h0 r418, r r419, Boolean r510, m0 r511, String r512, boolean r513, int r514) {
        if ((r514 & 1) == 0) goto L5;
        Long r100 = r410.f295605a;
    L7:
        if ((r514 & 2) == 0) goto L9;
        String r101 = r410.f295606b;
    L11:
        if ((r514 & 4) == 0) goto L13;
        g1 r102 = r410.f295607c;
    L15:
        if ((r514 & 8) == 0) goto L17;
        g1 r103 = r410.f295608d;
    L19:
        if ((r514 & 16) == 0) goto L21;
        String r104 = r410.f295609e;
    L23:
        if ((r514 & 32) == 0) goto L25;
        Integer r105 = r410.f295610f;
    L27:
        if ((r514 & 64) == 0) goto L29;
        Integer r110 = r410.f295611g;
    L31:
        if ((r514 & 128) == 0) goto L33;
        String r111 = r410.f295612h;
    L35:
        if ((r514 & 256) == 0) goto L37;
        String r112 = r410.f295613i;
    L39:
        if ((r514 & 512) == 0) goto L41;
        ouc.d0 r113 = r410.f295614j;
    L43:
        if ((r514 & 1024) == 0) goto L45;
        h1 r114 = r410.f295615k;
    L47:
        if ((r514 & 2048) == 0) goto L49;
        n0 r115 = r410.f295616l;
    L51:
        if ((r514 & 4096) == 0) goto L53;
        e0 r116 = r410.f295617m;
    L55:
        if ((r514 & 8192) == 0) goto L57;
        h0 r117 = r410.f295618n;
    L59:
        if ((r514 & 16384) == 0) goto L61;
        p0 r118 = r410.f295619o;
    L63:
        if ((32768 & r514) == 0) goto L65;
        ouc.d0 r119 = r410.f295620p;
    L67:
        if ((65536 & r514) == 0) goto L69;
        r r210 = r410.f295621q;
    L71:
        if ((131072 & r514) == 0) goto L73;
        Boolean r211 = r410.f295622r;
    L75:
        if ((262144 & r514) == 0) goto L77;
        Boolean r212 = r410.f295623s;
    L79:
        if ((524288 & r514) == 0) goto L81;
        Long r213 = r410.f295624t;
    L83:
        if ((1048576 & r514) == 0) goto L85;
        m0 r214 = r410.f295625u;
    L87:
        if ((2097152 & r514) == 0) goto L89;
        String r215 = r410.f295626v;
    L91:
        if ((4194304 & r514) == 0) goto L93;
        b1 r216 = r410.f295627w;
    L95:
        if ((8388608 & r514) == 0) goto L97;
        String r217 = r410.f295628x;
    L99:
        if ((16777216 & r514) == 0) goto L101;
        boolean r218 = r410.f295629y;
    L103:
        if ((33554432 & r514) == 0) goto L105;
        wa8.u1 r219 = r410.f295630z;
    L107:
        if ((67108864 & r514) == 0) goto L109;
        String r310 = r410.A;
    L111:
        if ((134217728 & r514) == 0) goto L113;
        jq9.j r311 = r410.B;
    L115:
        if ((268435456 & r514) == 0) goto L117;
        boolean r312 = r410.C;
    L119:
        if ((536870912 & r514) == 0) goto L121;
        boolean r313 = r410.D;
    L123:
        if ((1073741824 & r514) == 0) goto L125;
        boolean r314 = r410.E;
    L127:
        if ((r514 & Integer.MIN_VALUE) == 0) goto L129;
        boolean r315 = r410.F;
    L130:
        String r106 = r410.G;
        Map<String, String> r107 = r410.H;
        Integer r108 = r410.I;
        d r109 = r410.f295604J;
        r410.getClass();
        return new z0(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r106, r107, r108, r109);
    L129:
        r315 = false;
        goto L130
    L125:
        r314 = false;
        goto L127
    L121:
        r313 = false;
        goto L123
    L117:
        r312 = false;
        goto L119
    L113:
        r311 = null;
        goto L115
    L109:
        r310 = null;
        goto L111
    L105:
        r219 = null;
        goto L107
    L101:
        r218 = r513;
        goto L103
    L97:
        r217 = null;
        goto L99
    L93:
        r216 = null;
        goto L95
    L89:
        r215 = r512;
        goto L91
    L85:
        r214 = r511;
        goto L87
    L81:
        r213 = null;
        goto L83
    L77:
        r212 = null;
        goto L79
    L73:
        r211 = r510;
        goto L75
    L69:
        r210 = r419;
        goto L71
    L65:
        r119 = null;
        goto L67
    L61:
        r118 = null;
        goto L63
    L57:
        r117 = r418;
        goto L59
    L53:
        r116 = r417;
        goto L55
    L49:
        r115 = null;
        goto L51
    L45:
        r114 = null;
        goto L47
    L41:
        r113 = null;
        goto L43
    L37:
        r112 = null;
        goto L39
    L33:
        r111 = null;
        goto L35
    L29:
        r110 = r416;
        goto L31
    L25:
        r105 = null;
        goto L27
    L21:
        r104 = r415;
        goto L23
    L17:
        r103 = r414;
        goto L19
    L13:
        r102 = r413;
        goto L15
    L9:
        r101 = r412;
        goto L11
    L5:
        r100 = r411;
        goto L7
    }

    public /* synthetic */ z0(Long r410, String r411, g1 r412, g1 r413, String r414, Integer r415, Integer r416, n0 r417, e0 r418, p0 r510, r r511, m0 r512, boolean r513, Map r514, Integer r515, int r516, int r517) {
        if ((r516 & 1) == 0) goto L5;
        Long r100 = 0L;
    L7:
        if ((r516 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r516 & 4) == 0) goto L13;
        g1 r102 = new g1("", "", null, null, 28);
    L15:
        if ((r516 & 8) == 0) goto L17;
        g1 r103 = new g1("", "", null, null, 28);
    L19:
        if ((r516 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r516 & 32) == 0) goto L25;
        Integer r105 = Integer.valueOf(ActionBarDisplayType.NORMAL.getValue());
    L27:
        if ((r516 & 64) == 0) goto L29;
        Integer r110 = Integer.valueOf(ActionBarExecutionType.UNKNOWN.getValue());
    L31:
        if ((r516 & 128) == 0) goto L33;
        String r106 = "";
    L35:
        if ((r516 & 256) == 0) goto L37;
        String r111 = "";
    L39:
        if ((r516 & 2048) == 0) goto L41;
        n0 r112 = new n0("", 2);
    L43:
        if ((r516 & 4096) == 0) goto L45;
        e0 r113 = null;
    L47:
        if ((r516 & 8192) == 0) goto L49;
        h0 r114 = new h0(Boolean.FALSE);
    L51:
        if ((r516 & 16384) == 0) goto L53;
        p0 r115 = null;
    L55:
        if ((65536 & r516) == 0) goto L57;
        r r210 = new r(null, null, null, null, null, null, null, null, UnixStat.PERM_MASK);
    L59:
        if ((131072 & r516) == 0) goto L61;
        Boolean r211 = Boolean.FALSE;
    L63:
        if ((262144 & r516) == 0) goto L65;
        Boolean r212 = Boolean.FALSE;
    L67:
        if ((524288 & r516) == 0) goto L69;
        Long r213 = 0L;
    L71:
        if ((1048576 & r516) == 0) goto L73;
        m0 r214 = null;
    L75:
        if ((67108864 & r516) == 0) goto L77;
        String r310 = "";
    L79:
        if ((536870912 & r516) == 0) goto L81;
        boolean r311 = false;
    L83:
        if ((1073741824 & r516) == 0) goto L85;
        boolean r312 = true;
    L87:
        if ((r516 & Integer.MIN_VALUE) == 0) goto L89;
        boolean r313 = true;
    L91:
        if ((r517 & 2) == 0) goto L93;
        Map r314 = null;
    L95:
        if ((r517 & 4) == 0) goto L97;
        Integer r315 = null;
    L98:
        this(r100, r101, r102, r103, r104, r105, r110, r106, r111, null, null, r112, r113, r114, r115, null, r210, r211, r212, r213, r214, null, null, null, false, null, r310, null, false, r311, r312, r313, null, r314, r315, null);
        return;
    L97:
        r315 = r515;
        goto L98
    L93:
        r314 = r514;
        goto L95
    L89:
        r313 = false;
        goto L91
    L85:
        r312 = false;
        goto L87
    L81:
        r311 = r513;
        goto L83
    L77:
        r310 = null;
        goto L79
    L73:
        r214 = r512;
        goto L75
    L69:
        r213 = null;
        goto L71
    L65:
        r212 = null;
        goto L67
    L61:
        r211 = null;
        goto L63
    L57:
        r210 = r511;
        goto L59
    L53:
        r115 = r510;
        goto L55
    L49:
        r114 = null;
        goto L51
    L45:
        r113 = r418;
        goto L47
    L41:
        r112 = r417;
        goto L43
    L37:
        r111 = null;
        goto L39
    L33:
        r106 = null;
        goto L35
    L29:
        r110 = r416;
        goto L31
    L25:
        r105 = r415;
        goto L27
    L21:
        r104 = r414;
        goto L23
    L17:
        r103 = r413;
        goto L19
    L13:
        r102 = r412;
        goto L15
    L9:
        r101 = r411;
        goto L11
    L5:
        r100 = r410;
        goto L7
    }

    public z0(int r110, Long r111, String r210, g1 r211, g1 r212, String r213, Integer r214, Integer r215, String r216, String r217, ouc.d0 r218, h1 r219, n0 r310, e0 r311, h0 r312, p0 r313, ouc.d0 r314, r r315, Boolean r316, Boolean r317, Long r318, m0 r319, String r410, b1 r411, String r412, d r413) {
        if ((r110 & 0) == 0) goto L5;
        nuc.b2.b(r110, 0, a.f295632b);
        throw null;
    L5:
        if ((r110 & 1) != 0) goto L7;
        Long r100 = 0L;
    L8:
        this.f295605a = r100;
        if ((r110 & 2) != 0) goto L11;
        this.f295606b = "";
    L13:
        if ((r110 & 4) != 0) goto L15;
        g1 r101 = new g1("", "", null, null, 28);
    L16:
        this.f295607c = r101;
        if ((r110 & 8) != 0) goto L19;
        g1 r102 = new g1("", "", null, null, 28);
    L20:
        this.f295608d = r102;
        if ((r110 & 16) != 0) goto L23;
        this.f295609e = "";
    L25:
        if ((r110 & 32) != 0) goto L27;
        Integer r103 = Integer.valueOf(ActionBarDisplayType.NORMAL.getValue());
    L28:
        this.f295610f = r103;
        if ((r110 & 64) != 0) goto L31;
        Integer r104 = Integer.valueOf(ActionBarExecutionType.UNKNOWN.getValue());
    L32:
        this.f295611g = r104;
        if ((r110 & 128) != 0) goto L35;
        this.f295612h = "";
    L37:
        if ((r110 & 256) != 0) goto L39;
        this.f295613i = "";
    L41:
        if ((r110 & 512) != 0) goto L43;
        this.f295614j = null;
    L45:
        if ((r110 & 1024) != 0) goto L47;
        this.f295615k = null;
    L49:
        if ((r110 & 2048) != 0) goto L51;
        n0 r105 = new n0("", 2);
    L52:
        this.f295616l = r105;
        if ((r110 & 4096) != 0) goto L55;
        this.f295617m = null;
    L57:
        if ((r110 & 8192) != 0) goto L59;
        h0 r106 = new h0(Boolean.FALSE);
    L60:
        this.f295618n = r106;
        if ((r110 & 16384) != 0) goto L63;
        this.f295619o = null;
    L65:
        if ((32768 & r110) != 0) goto L67;
        this.f295620p = null;
    L69:
        if ((65536 & r110) != 0) goto L71;
        r r107 = new r(null, null, null, null, null, null, null, null, UnixStat.PERM_MASK);
    L72:
        this.f295621q = r107;
        if ((131072 & r110) != 0) goto L75;
        Boolean r108 = Boolean.FALSE;
    L76:
        this.f295622r = r108;
        if ((262144 & r110) != 0) goto L79;
        Boolean r109 = Boolean.FALSE;
    L80:
        this.f295623s = r109;
        if ((524288 & r110) != 0) goto L83;
        Long r112 = 0L;
    L84:
        this.f295624t = r112;
        if ((1048576 & r110) != 0) goto L87;
        this.f295625u = null;
    L89:
        if ((2097152 & r110) != 0) goto L91;
        this.f295626v = null;
    L93:
        if ((4194304 & r110) != 0) goto L95;
        this.f295627w = null;
    L97:
        if ((8388608 & r110) != 0) goto L99;
        this.f295628x = null;
    L100:
        this.f295629y = false;
        this.f295630z = null;
        this.A = "";
        this.B = null;
        this.C = false;
        this.D = false;
        this.E = true;
        this.F = true;
        this.G = null;
        this.H = null;
        this.I = null;
        if ((r110 & 16777216) != 0) goto L103;
        this.f295604J = null;
        return;
    L103:
        this.f295604J = r413;
        return;
    L99:
        this.f295628x = r412;
        goto L100
    L95:
        this.f295627w = r411;
        goto L97
    L91:
        this.f295626v = r410;
        goto L93
    L87:
        this.f295625u = r319;
        goto L89
    L83:
        r112 = r318;
        goto L84
    L79:
        r109 = r317;
        goto L80
    L75:
        r108 = r316;
        goto L76
    L71:
        r107 = r315;
        goto L72
    L67:
        this.f295620p = r314;
        goto L69
    L63:
        this.f295619o = r313;
        goto L65
    L59:
        r106 = r312;
        goto L60
    L55:
        this.f295617m = r311;
        goto L57
    L51:
        r105 = r310;
        goto L52
    L47:
        this.f295615k = r219;
        goto L49
    L43:
        this.f295614j = r218;
        goto L45
    L39:
        this.f295613i = r217;
        goto L41
    L35:
        this.f295612h = r216;
        goto L37
    L31:
        r104 = r215;
        goto L32
    L27:
        r103 = r214;
        goto L28
    L23:
        this.f295609e = r213;
        goto L25
    L19:
        r102 = r212;
        goto L20
    L15:
        r101 = r211;
        goto L16
    L11:
        this.f295606b = r210;
        goto L13
    L7:
        r100 = r111;
        goto L8
    }

    public z0(Long r100, String r101, g1 r102, g1 r103, String r104, Integer r105, Integer r106, String r110, String r111, ouc.d0 r112, h1 r113, n0 r114, e0 r115, h0 r116, p0 r117, ouc.d0 r118, r r119, Boolean r210, Boolean r211, Long r212, m0 r213, String r214, b1 r215, String r216, boolean r217, wa8.u1 r218, String r219, jq9.j r310, boolean r311, boolean r312, boolean r313, boolean r314, String r315, Map<String, String> r316, Integer r317, d r318) {
        this.f295605a = r100;
        this.f295606b = r101;
        this.f295607c = r102;
        this.f295608d = r103;
        this.f295609e = r104;
        this.f295610f = r105;
        this.f295611g = r106;
        this.f295612h = r110;
        this.f295613i = r111;
        this.f295614j = r112;
        this.f295615k = r113;
        this.f295616l = r114;
        this.f295617m = r115;
        this.f295618n = r116;
        this.f295619o = r117;
        this.f295620p = r118;
        this.f295621q = r119;
        this.f295622r = r210;
        this.f295623s = r211;
        this.f295624t = r212;
        this.f295625u = r213;
        this.f295626v = r214;
        this.f295627w = r215;
        this.f295628x = r216;
        this.f295629y = r217;
        this.f295630z = r218;
        this.A = r219;
        this.B = r310;
        this.C = r311;
        this.D = r312;
        this.E = r313;
        this.F = r314;
        this.G = r315;
        this.H = r316;
        this.I = r317;
        this.f295604J = r318;
    }
}
