package com.larus.bmhome.actionbar.model;

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
public final class j1 {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f295229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f295230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f295231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f295232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f295233e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f295234f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f295235g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f295236h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f295237i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f295238j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f295239k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f295240l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f295241m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f295242n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Boolean f295243o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f295244p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f295245q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f295246r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f295247s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f295248t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f295249u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f295250v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f295251w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f295252x;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<j1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f295253a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f295254b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f295254b;
        }

        static {
            a r100 = new a();
            f295253a = r100;
            g2 r101 = new g2("com.larus.bmhome.actionbar.model.InstructionConfExt", r100, 24);
            r101.j("music_lyrics_format", true);
            r101.j("music_lyrics_help_me_writing_format", true);
            r101.j("music_gen_style_select", true);
            r101.j("user_avatar_id", true);
            r101.j("first_avatar", true);
            r101.j("is_audio", true);
            r101.j("video_allow_ratio_select_after_img", true);
            r101.j("replica_auto_popup", true);
            r101.j("img_gen_landing_tab_id", true);
            r101.j("client_generate_podcast_scene", true);
            r101.j("sub_instruction_id", true);
            r101.j("v3_speaker_id_list", true);
            r101.j("target_scene", true);
            r101.j("distribution_page_disable", true);
            r101.j("force_half_scree_page", true);
            r101.j("ref_img_url", true);
            r101.j("ref_face_num", true);
            r101.j("ref_width", true);
            r101.j("ref_height", true);
            r101.j("sub_instruction_list", true);
            r101.j(com.bytedance.android.ec.core.event.a.KEY_SCHEMA_URL, true);
            r101.j("default_select_model_id_in_creation_combo", true);
            r101.j("is_style_prompt_from_prompt_list", true);
            r101.j("has_skip_prefix", true);
            f295254b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new juc.d[]{kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(nuc.w0.f520792a), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(nuc.i.f520705a), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100)};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r510) {
            Intrinsics.checkNotNullParameter(r510, "decoder");
            g2 r100 = f295254b;
            muc.c r101 = r510.beginStructure(r100);
            Boolean r110 = null;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r102 = v2.f520790a;
            String r103 = (String) r101.decodeNullableSerializableElement(r100, 0, r102, null);
            String r111 = (String) r101.decodeNullableSerializableElement(r100, 1, r102, null);
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 2, r102, null);
            String r112 = (String) r101.decodeNullableSerializableElement(r100, 3, r102, null);
            String r113 = (String) r101.decodeNullableSerializableElement(r100, 4, r102, null);
            String r114 = (String) r101.decodeNullableSerializableElement(r100, 5, r102, null);
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 6, r102, null);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 7, r102, null);
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 8, r102, null);
            Integer r108 = (Integer) r101.decodeNullableSerializableElement(r100, 9, nuc.w0.f520792a, null);
            String r109 = (String) r101.decodeNullableSerializableElement(r100, 10, r102, null);
            String r115 = (String) r101.decodeNullableSerializableElement(r100, 11, r102, null);
            String r116 = (String) r101.decodeNullableSerializableElement(r100, 12, r102, null);
            String r210 = (String) r101.decodeNullableSerializableElement(r100, 13, r102, null);
            Boolean r117 = (Boolean) r101.decodeNullableSerializableElement(r100, 14, nuc.i.f520705a, null);
            String r118 = (String) r101.decodeNullableSerializableElement(r100, 15, r102, null);
            String r119 = (String) r101.decodeNullableSerializableElement(r100, 16, r102, null);
            String r120 = (String) r101.decodeNullableSerializableElement(r100, 17, r102, null);
            String r121 = (String) r101.decodeNullableSerializableElement(r100, 18, r102, null);
            String r122 = (String) r101.decodeNullableSerializableElement(r100, 19, r102, null);
            String r123 = (String) r101.decodeNullableSerializableElement(r100, 20, r102, null);
            String r124 = (String) r101.decodeNullableSerializableElement(r100, 21, r102, null);
            String r125 = (String) r101.decodeNullableSerializableElement(r100, 22, r102, null);
            String r310 = r124;
            String r311 = (String) r101.decodeNullableSerializableElement(r100, 23, r102, null);
            String r126 = r111;
            String r312 = r123;
            String r211 = r122;
            String r212 = r121;
            String r213 = r120;
            String r313 = r125;
            String r214 = r116;
            String r127 = r105;
            String r128 = r106;
            String r215 = r118;
            Integer r129 = r108;
            String r130 = r107;
            String r131 = r103;
            String r216 = r119;
            Boolean r217 = r117;
            int r132 = 16777215;
            String r218 = r109;
            String r219 = r115;
            String r133 = r104;
            String r134 = r113;
            String r135 = r112;
        L51:
            r101.endStructure(r100);
            return new j1(r132, r131, r126, r133, r135, r134, r114, r127, r128, r130, r129, r218, r219, r214, r210, r217, r215, r216, r213, r212, r211, r312, r310, r313, r311);
        L5:
            String r136 = null;
            String r137 = null;
            String r138 = null;
            String r139 = null;
            String r140 = null;
            String r141 = null;
            String r142 = null;
            String r143 = null;
            String r144 = null;
            String r145 = null;
            String r146 = null;
            String r147 = null;
            String r220 = null;
            String r314 = null;
            String r315 = null;
            String r316 = null;
            String r410 = null;
            String r411 = null;
            String r412 = null;
            String r413 = null;
            String r414 = null;
            Integer r415 = null;
            String r416 = null;
            int r148 = 0;
            boolean r417 = true;
        L6:
            if (r417 == false) goto L50;
            String r418 = r140;
            int r149 = r101.decodeElementIndex(r100);
            switch(r149) {
                case -1: goto L49;
                case 0: goto L45;
                case 1: goto L43;
                case 2: goto L41;
                case 3: goto L39;
                case 4: goto L37;
                case 5: goto L36;
                case 6: goto L35;
                case 7: goto L34;
                case 8: goto L33;
                case 9: goto L32;
                case 10: goto L31;
                case 11: goto L30;
                case 12: goto L29;
                case 13: goto L27;
                case 14: goto L26;
                case 15: goto L24;
                case 16: goto L22;
                case 17: goto L20;
                case 18: goto L19;
                case 19: goto L18;
                case 20: goto L15;
                case 21: goto L13;
                case 22: goto L12;
                case 23: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r149);
        L29:
            r143 = (String) r101.decodeNullableSerializableElement(r100, 12, v2.f520790a, r143);
            r148 = r148 | 4096;
            r136 = r136;
            r140 = r418;
            goto L6
        L30:
            r136 = r136;
            r137 = r137;
            r148 = r148 | 2048;
            r140 = (String) r101.decodeNullableSerializableElement(r100, 11, v2.f520790a, r418);
            String r221 = r314;
            String r222 = r315;
            String r150 = r410;
            r411 = r411;
            r412 = r412;
            r413 = r413;
            String r223 = r414;
            r415 = r415;
            String r317 = r416;
        L48:
            r410 = r150;
            r136 = r136;
            r137 = r137;
            r314 = r221;
            r315 = r222;
            r414 = r223;
            r411 = r411;
            r412 = r412;
            r413 = r413;
            r415 = r415;
            r416 = r317;
            goto L6
        L31:
            r418 = r418;
            String r151 = (String) r101.decodeNullableSerializableElement(r100, 10, v2.f520790a, r416);
            r148 = r148 | 1024;
            r221 = r314;
            r222 = r315;
        L46:
            r317 = r151;
            String r152 = r414;
        L47:
            r140 = r418;
            String r511 = r316;
            r223 = r152;
            r150 = r410;
            r316 = r511;
            goto L48
        L32:
            r317 = r416;
            r148 = r148 | 512;
            r415 = (Integer) r101.decodeNullableSerializableElement(r100, 9, nuc.w0.f520792a, r415);
            r410 = r410;
            r411 = r411;
            r412 = r412;
            String r153 = r413;
            String r318 = r414;
        L40:
            r413 = r153;
            r316 = r316;
        L42:
            r221 = r314;
            r222 = r315;
            r152 = r318;
            goto L47
        L33:
            r317 = r416;
            r415 = r415;
            r148 = r148 | 256;
            r318 = (String) r101.decodeNullableSerializableElement(r100, 8, v2.f520790a, r414);
            r410 = r410;
            r411 = r411;
            r412 = r412;
            r153 = r413;
            goto L40
        L34:
            r415 = r415;
            r317 = r416;
            r318 = r414;
            r153 = (String) r101.decodeNullableSerializableElement(r100, 7, v2.f520790a, r413);
            r148 = r148 | 128;
            r410 = r410;
            r411 = r411;
            r412 = r412;
            goto L40
        L35:
            r318 = r414;
            r415 = r415;
            r317 = r416;
            r148 = r148 | 64;
            r412 = (String) r101.decodeNullableSerializableElement(r100, 6, v2.f520790a, r412);
            r153 = r413;
            r410 = r410;
            r411 = r411;
            goto L40
        L36:
            r318 = r414;
            r415 = r415;
            r317 = r416;
            r412 = r412;
            r148 = r148 | 32;
            r411 = (String) r101.decodeNullableSerializableElement(r100, 5, v2.f520790a, r411);
            r153 = r413;
            r410 = r410;
            goto L40
        L37:
            r412 = r412;
            r318 = r414;
            r415 = r415;
            r317 = r416;
            r411 = r411;
            r148 = r148 | 16;
            r153 = r413;
            r410 = (String) r101.decodeNullableSerializableElement(r100, 4, v2.f520790a, r410);
            goto L40
        L39:
            r136 = r136;
            r137 = r137;
            r411 = r411;
            r412 = r412;
            r318 = r414;
            r415 = r415;
            r317 = r416;
            r418 = r418;
            String r154 = r316;
            r410 = r410;
            r148 = r148 | 8;
            r316 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r154);
            r153 = r413;
            goto L40
        L41:
            r136 = r136;
            r137 = r137;
            String r155 = r316;
            r410 = r410;
            r411 = r411;
            r412 = r412;
            r413 = r413;
            r318 = r414;
            r415 = r415;
            r317 = r416;
            r418 = r418;
            r316 = r155;
            r315 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r315);
            r148 = r148 | 4;
            goto L42
        L43:
            r418 = r418;
            r222 = r315;
            r148 = r148 | 2;
            r221 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r314);
            r151 = r416;
            goto L46
        L45:
            r136 = r136;
            r137 = r137;
            r222 = r315;
            r316 = r316;
            r410 = r410;
            r411 = r411;
            r412 = r412;
            r413 = r413;
            r414 = r414;
            r415 = r415;
            r418 = r418;
            r221 = r314;
            r220 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r220);
            r148 = r148 | 1;
            r151 = r416;
            goto L46
        L49:
            r136 = r136;
            r137 = r137;
            r140 = r418;
            r417 = false;
            r316 = r316;
            goto L6
        L11:
            r142 = (String) r101.decodeNullableSerializableElement(r100, 23, v2.f520790a, r142);
            int r156 = 8388608;
        L16:
            r148 = r148 | r156;
        L28:
            r140 = r418;
            r143 = r143;
            goto L6
        L12:
            r136 = (String) r101.decodeNullableSerializableElement(r100, 22, v2.f520790a, r136);
            r156 = 4194304;
            goto L16
        L13:
            r141 = (String) r101.decodeNullableSerializableElement(r100, 21, v2.f520790a, r141);
            r156 = 2097152;
            goto L16
        L15:
            r143 = r143;
            r137 = (String) r101.decodeNullableSerializableElement(r100, 20, v2.f520790a, r137);
            r156 = 1048576;
            goto L16
        L18:
            r147 = (String) r101.decodeNullableSerializableElement(r100, 19, v2.f520790a, r147);
            int r157 = 524288;
        L25:
            r148 = r148 | r157;
            goto L28
        L19:
            r146 = (String) r101.decodeNullableSerializableElement(r100, 18, v2.f520790a, r146);
            r157 = 262144;
            goto L25
        L20:
            r138 = (String) r101.decodeNullableSerializableElement(r100, 17, v2.f520790a, r138);
            r157 = 131072;
            goto L25
        L22:
            r143 = r143;
            r139 = (String) r101.decodeNullableSerializableElement(r100, 16, v2.f520790a, r139);
            r157 = 65536;
            goto L25
        L24:
            r143 = r143;
            r144 = (String) r101.decodeNullableSerializableElement(r100, 15, v2.f520790a, r144);
            r157 = 32768;
            goto L25
        L26:
            r143 = r143;
            r110 = (Boolean) r101.decodeNullableSerializableElement(r100, 14, nuc.i.f520705a, r110);
            r148 = r148 | 16384;
            goto L28
        L27:
            r143 = r143;
            r145 = (String) r101.decodeNullableSerializableElement(r100, 13, v2.f520790a, r145);
            r148 = r148 | 8192;
            goto L28
        L50:
            String r224 = r137;
            String r158 = r220;
            String r225 = r314;
            String r226 = r315;
            r310 = r141;
            r311 = r142;
            r214 = r143;
            r210 = r145;
            r211 = r147;
            r312 = r224;
            r135 = r316;
            r114 = r411;
            r127 = r412;
            r128 = r413;
            r130 = r414;
            r129 = r415;
            r218 = r416;
            r219 = r140;
            r132 = r148;
            r131 = r158;
            r215 = r144;
            r212 = r146;
            r133 = r226;
            r134 = r410;
            r213 = r138;
            r313 = r136;
            r217 = r110;
            r126 = r225;
            r216 = r139;
            goto L51
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            j1 r102 = (j1) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f295254b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = j1.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, v2.f520790a, r102.f295229a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeNullableSerializableElement(r103, 1, v2.f520790a, r102.f295230b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            boolean r109 = true;
        L27:
            if (r109 == false) goto L30;
            r104.encodeNullableSerializableElement(r103, 2, v2.f520790a, r102.f295231c);
        L30:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
        L34:
            boolean r110 = true;
        L36:
            if (r110 == false) goto L39;
            r104.encodeNullableSerializableElement(r103, 3, v2.f520790a, r102.f295232d);
        L39:
            if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L42;
        L43:
            boolean r111 = true;
        L45:
            if (r111 == false) goto L48;
            r104.encodeNullableSerializableElement(r103, 4, v2.f520790a, r102.f295233e);
        L48:
            if (r104.shouldEncodeElementDefault(r103, 5) == false) goto L51;
        L52:
            boolean r112 = true;
        L54:
            if (r112 == false) goto L57;
            r104.encodeNullableSerializableElement(r103, 5, v2.f520790a, r102.f295234f);
        L57:
            if (r104.shouldEncodeElementDefault(r103, 6) == false) goto L60;
        L61:
            boolean r113 = true;
        L63:
            if (r113 == false) goto L66;
            r104.encodeNullableSerializableElement(r103, 6, v2.f520790a, r102.f295235g);
        L66:
            if (r104.shouldEncodeElementDefault(r103, 7) == false) goto L69;
        L70:
            boolean r114 = true;
        L72:
            if (r114 == false) goto L75;
            r104.encodeNullableSerializableElement(r103, 7, v2.f520790a, r102.f295236h);
        L75:
            if (r104.shouldEncodeElementDefault(r103, 8) == false) goto L78;
        L79:
            boolean r115 = true;
        L81:
            if (r115 == false) goto L84;
            r104.encodeNullableSerializableElement(r103, 8, v2.f520790a, r102.f295237i);
        L84:
            if (r104.shouldEncodeElementDefault(r103, 9) == false) goto L87;
        L88:
            boolean r116 = true;
        L90:
            if (r116 == false) goto L93;
            r104.encodeNullableSerializableElement(r103, 9, nuc.w0.f520792a, r102.f295238j);
        L93:
            if (r104.shouldEncodeElementDefault(r103, 10) == false) goto L96;
        L97:
            boolean r117 = true;
        L99:
            if (r117 == false) goto L102;
            r104.encodeNullableSerializableElement(r103, 10, v2.f520790a, r102.f295239k);
        L102:
            if (r104.shouldEncodeElementDefault(r103, 11) == false) goto L105;
        L106:
            boolean r118 = true;
        L108:
            if (r118 == false) goto L111;
            r104.encodeNullableSerializableElement(r103, 11, v2.f520790a, r102.f295240l);
        L111:
            if (r104.shouldEncodeElementDefault(r103, 12) == false) goto L114;
        L115:
            boolean r119 = true;
        L117:
            if (r119 == false) goto L120;
            r104.encodeNullableSerializableElement(r103, 12, v2.f520790a, r102.f295241m);
        L120:
            if (r104.shouldEncodeElementDefault(r103, 13) == false) goto L123;
        L124:
            boolean r120 = true;
        L126:
            if (r120 == false) goto L129;
            r104.encodeNullableSerializableElement(r103, 13, v2.f520790a, r102.f295242n);
        L129:
            if (r104.shouldEncodeElementDefault(r103, 14) == false) goto L132;
        L133:
            boolean r121 = true;
        L135:
            if (r121 == false) goto L138;
            r104.encodeNullableSerializableElement(r103, 14, nuc.i.f520705a, r102.f295243o);
        L138:
            if (r104.shouldEncodeElementDefault(r103, 15) == false) goto L141;
        L142:
            boolean r122 = true;
        L144:
            if (r122 == false) goto L147;
            r104.encodeNullableSerializableElement(r103, 15, v2.f520790a, r102.f295244p);
        L147:
            if (r104.shouldEncodeElementDefault(r103, 16) == false) goto L150;
        L151:
            boolean r123 = true;
        L153:
            if (r123 == false) goto L156;
            r104.encodeNullableSerializableElement(r103, 16, v2.f520790a, r102.f295245q);
        L156:
            if (r104.shouldEncodeElementDefault(r103, 17) == false) goto L159;
        L160:
            boolean r124 = true;
        L162:
            if (r124 == false) goto L165;
            r104.encodeNullableSerializableElement(r103, 17, v2.f520790a, r102.f295246r);
        L165:
            if (r104.shouldEncodeElementDefault(r103, 18) == false) goto L168;
        L169:
            boolean r125 = true;
        L171:
            if (r125 == false) goto L174;
            r104.encodeNullableSerializableElement(r103, 18, v2.f520790a, r102.f295247s);
        L174:
            if (r104.shouldEncodeElementDefault(r103, 19) == false) goto L177;
        L178:
            boolean r126 = true;
        L180:
            if (r126 == false) goto L183;
            r104.encodeNullableSerializableElement(r103, 19, v2.f520790a, r102.f295248t);
        L183:
            if (r104.shouldEncodeElementDefault(r103, 20) == false) goto L186;
        L187:
            boolean r127 = true;
        L189:
            if (r127 == false) goto L192;
            r104.encodeNullableSerializableElement(r103, 20, v2.f520790a, r102.f295249u);
        L192:
            if (r104.shouldEncodeElementDefault(r103, 21) == false) goto L195;
        L196:
            boolean r128 = true;
        L198:
            if (r128 == false) goto L201;
            r104.encodeNullableSerializableElement(r103, 21, v2.f520790a, r102.f295250v);
        L201:
            if (r104.shouldEncodeElementDefault(r103, 22) == false) goto L204;
        L205:
            boolean r129 = true;
        L207:
            if (r129 == false) goto L210;
            r104.encodeNullableSerializableElement(r103, 22, v2.f520790a, r102.f295251w);
        L210:
            if (r104.shouldEncodeElementDefault(r103, 23) == false) goto L213;
        L214:
            r106 = true;
        L215:
            if (r106 == false) goto L217;
            r104.encodeNullableSerializableElement(r103, 23, v2.f520790a, r102.f295252x);
        L217:
            r104.endStructure(r103);
            return;
        L213:
            if (r102.f295252x == null) goto L215;
        L204:
            if (r102.f295251w != null) goto L205;
            r129 = false;
            goto L207
        L195:
            if (r102.f295250v != null) goto L196;
            r128 = false;
            goto L198
        L186:
            if (r102.f295249u != null) goto L187;
            r127 = false;
            goto L189
        L177:
            if (r102.f295248t != null) goto L178;
            r126 = false;
            goto L180
        L168:
            if (r102.f295247s != null) goto L169;
            r125 = false;
            goto L171
        L159:
            if (r102.f295246r != null) goto L160;
            r124 = false;
            goto L162
        L150:
            if (r102.f295245q != null) goto L151;
            r123 = false;
            goto L153
        L141:
            if (r102.f295244p != null) goto L142;
            r122 = false;
            goto L144
        L132:
            if (Intrinsics.areEqual(r102.f295243o, Boolean.FALSE) == false) goto L133;
            r121 = false;
            goto L135
        L123:
            if (r102.f295242n != null) goto L124;
            r120 = false;
            goto L126
        L114:
            if (r102.f295241m != null) goto L115;
            r119 = false;
            goto L117
        L105:
            if (r102.f295240l != null) goto L106;
            r118 = false;
            goto L108
        L96:
            if (r102.f295239k != null) goto L97;
            r117 = false;
            goto L99
        L87:
            if (r102.f295238j != null) goto L88;
            r116 = false;
            goto L90
        L78:
            if (r102.f295237i != null) goto L79;
            r115 = false;
            goto L81
        L69:
            if (r102.f295236h != null) goto L70;
            r114 = false;
            goto L72
        L60:
            if (r102.f295235g != null) goto L61;
            r113 = false;
            goto L63
        L51:
            if (r102.f295234f != null) goto L52;
            r112 = false;
            goto L54
        L42:
            if (r102.f295233e != null) goto L43;
            r111 = false;
            goto L45
        L33:
            if (r102.f295232d != null) goto L34;
            r110 = false;
            goto L36
        L24:
            if (r102.f295231c != null) goto L25;
            r109 = false;
            goto L27
        L15:
            if (r102.f295230b != null) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f295229a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<j1> serializer() {
            return a.f295253a;
        }
    }

    public j1() {
        this(null, 16777215);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j1) == true) goto L8;
        return false;
    L8:
        j1 r101 = (j1) r100;
        if (Intrinsics.areEqual(this.f295229a, r101.f295229a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f295230b, r101.f295230b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f295231c, r101.f295231c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f295232d, r101.f295232d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f295233e, r101.f295233e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f295234f, r101.f295234f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f295235g, r101.f295235g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f295236h, r101.f295236h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f295237i, r101.f295237i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f295238j, r101.f295238j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f295239k, r101.f295239k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f295240l, r101.f295240l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f295241m, r101.f295241m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f295242n, r101.f295242n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f295243o, r101.f295243o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f295244p, r101.f295244p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f295245q, r101.f295245q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f295246r, r101.f295246r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f295247s, r101.f295247s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.f295248t, r101.f295248t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.f295249u, r101.f295249u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.f295250v, r101.f295250v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.f295251w, r101.f295251w) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.f295252x, r101.f295252x) == true) goto L80;
        return false;
    L80:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f295229a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f295230b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f295231c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f295232d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f295233e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f295234f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f295235g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f295236h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f295237i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.f295238j;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f295239k;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.f295240l;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.f295241m;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.f295242n;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        Boolean r143 = this.f295243o;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.f295244p;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        String r149 = this.f295245q;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        String r152 = this.f295246r;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        String r155 = this.f295247s;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        String r158 = this.f295248t;
        if (r158 != null) goto L81;
        int r159 = 0;
    L82:
        int r160 = (r157 + r159) * 31;
        String r161 = this.f295249u;
        if (r161 != null) goto L85;
        int r162 = 0;
    L86:
        int r163 = (r160 + r162) * 31;
        String r164 = this.f295250v;
        if (r164 != null) goto L89;
        int r165 = 0;
    L90:
        int r166 = (r163 + r165) * 31;
        String r167 = this.f295251w;
        if (r167 != null) goto L93;
        int r168 = 0;
    L94:
        int r169 = (r166 + r168) * 31;
        String r170 = this.f295252x;
        if (r170 == null) goto L99;
        r101 = r170.hashCode();
    L99:
        return r169 + r101;
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
        return "InstructionConfExt(musicLyricsFormat=" + this.f295229a + ", musicLyricsHelpMeWritingFormat=" + this.f295230b + ", musicGenStyleSelect=" + this.f295231c + ", userAvatarId=" + this.f295232d + ", isFirstAvatar=" + this.f295233e + ", isAudio=" + this.f295234f + ", videoAllowRatioSelectAfterImg=" + this.f295235g + ", replicaAutoPopup=" + this.f295236h + ", imgGenLandingTabId=" + this.f295237i + ", clientGeneratePodcastScene=" + this.f295238j + ", subInstructionId=" + this.f295239k + ", v3SpeakerIdList=" + this.f295240l + ", targetScene=" + this.f295241m + ", distributionPageDisable=" + this.f295242n + ", forceHalfScreenPage=" + this.f295243o + ", refImgUrl=" + this.f295244p + ", refFaceNum=" + this.f295245q + ", refWidth=" + this.f295246r + ", refHeight=" + this.f295247s + ", subInstructionList=" + this.f295248t + ", schemaUrl=" + this.f295249u + ", defaultSelectModelIdInCreationCombo=" + this.f295250v + ", isStylePromptFromPromptList=" + this.f295251w + ", hasSkipPrefix=" + this.f295252x + ')';
    }

    static {
        Companion = new b();
    }

    public /* synthetic */ j1(Integer r210, int r211) {
        if ((r211 & 512) == 0) goto L5;
        Integer r110 = null;
    L7:
        if ((r211 & 16384) == 0) goto L9;
        Boolean r111 = Boolean.FALSE;
    L10:
        this(null, null, null, null, null, null, null, null, null, r110, null, null, null, null, r111, null, null, null, null, null, null, null, null, null);
        return;
    L9:
        r111 = null;
        goto L10
    L5:
        r110 = r210;
        goto L7
    }

    public static j1 a(j1 r210, String r211, String r310, String r311, String r312, String r313, String r314, String r315, String r316, String r317, int r318) {
        if ((r318 & 1) == 0) goto L5;
        String r100 = r210.f295229a;
    L7:
        if ((r318 & 2) == 0) goto L9;
        String r101 = r210.f295230b;
    L11:
        if ((r318 & 4) == 0) goto L13;
        String r102 = r210.f295231c;
    L15:
        if ((r318 & 8) == 0) goto L17;
        String r103 = r210.f295232d;
    L19:
        if ((r318 & 16) == 0) goto L21;
        String r104 = r210.f295233e;
    L23:
        if ((r318 & 32) == 0) goto L25;
        String r105 = r210.f295234f;
    L27:
        if ((r318 & 64) == 0) goto L29;
        String r110 = r210.f295235g;
    L31:
        if ((r318 & 128) == 0) goto L33;
        String r111 = r210.f295236h;
    L35:
        if ((r318 & 256) == 0) goto L37;
        String r112 = r210.f295237i;
    L39:
        if ((r318 & 512) == 0) goto L41;
        Integer r113 = r210.f295238j;
    L43:
        if ((r318 & 1024) == 0) goto L45;
        String r114 = r210.f295239k;
    L47:
        if ((r318 & 2048) == 0) goto L49;
        String r115 = r210.f295240l;
    L51:
        if ((r318 & 4096) == 0) goto L53;
        String r116 = r210.f295241m;
    L55:
        if ((r318 & 8192) == 0) goto L57;
        String r117 = r210.f295242n;
    L59:
        if ((r318 & 16384) == 0) goto L61;
        Boolean r118 = r210.f295243o;
    L63:
        if ((32768 & r318) == 0) goto L65;
        String r119 = r210.f295244p;
    L67:
        if ((65536 & r318) == 0) goto L69;
        String r212 = r210.f295245q;
    L71:
        if ((131072 & r318) == 0) goto L73;
        String r213 = r210.f295246r;
    L75:
        if ((262144 & r318) == 0) goto L77;
        String r214 = r210.f295247s;
    L79:
        if ((524288 & r318) == 0) goto L81;
        String r215 = r210.f295248t;
    L83:
        if ((1048576 & r318) == 0) goto L85;
        String r216 = r210.f295249u;
    L87:
        if ((2097152 & r318) == 0) goto L89;
        String r217 = r210.f295250v;
    L91:
        if ((4194304 & r318) == 0) goto L93;
        String r218 = r210.f295251w;
    L95:
        if ((r318 & 8388608) == 0) goto L97;
        String r219 = r210.f295252x;
    L99:
        return new j1(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r212, r213, r214, r215, r216, r217, r218, r219);
    L97:
        r219 = r317;
        goto L99
    L93:
        r218 = r316;
        goto L95
    L89:
        r217 = null;
        goto L91
    L85:
        r216 = null;
        goto L87
    L81:
        r215 = null;
        goto L83
    L77:
        r214 = r315;
        goto L79
    L73:
        r213 = r314;
        goto L75
    L69:
        r212 = r313;
        goto L71
    L65:
        r119 = r312;
        goto L67
    L61:
        r118 = null;
        goto L63
    L57:
        r117 = null;
        goto L59
    L53:
        r116 = null;
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
        r110 = null;
        goto L31
    L25:
        r105 = null;
        goto L27
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = r311;
        goto L15
    L9:
        r101 = r310;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }

    public j1(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r110, String r111, Integer r112, String r113, String r114, String r115, String r116, Boolean r117, String r118, String r119, String r210, String r211, String r212, String r213, String r214, String r215, String r216) {
        this.f295229a = r100;
        this.f295230b = r101;
        this.f295231c = r102;
        this.f295232d = r103;
        this.f295233e = r104;
        this.f295234f = r105;
        this.f295235g = r106;
        this.f295236h = r110;
        this.f295237i = r111;
        this.f295238j = r112;
        this.f295239k = r113;
        this.f295240l = r114;
        this.f295241m = r115;
        this.f295242n = r116;
        this.f295243o = r117;
        this.f295244p = r118;
        this.f295245q = r119;
        this.f295246r = r210;
        this.f295247s = r211;
        this.f295248t = r212;
        this.f295249u = r213;
        this.f295250v = r214;
        this.f295251w = r215;
        this.f295252x = r216;
    }

    public j1(int r100, String r101, String r102, String r103, String r110, String r111, String r112, String r113, String r114, String r115, Integer r116, String r117, String r118, String r119, String r210, Boolean r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, String r219, String r310) {
        if ((r100 & 0) == 0) goto L5;
        nuc.b2.b(r100, 0, a.f295254b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f295229a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f295230b = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f295231c = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f295232d = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.f295233e = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.f295234f = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.f295235g = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.f295236h = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.f295237i = null;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.f295238j = null;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.f295239k = null;
    L49:
        if ((r100 & 2048) != 0) goto L51;
        this.f295240l = null;
    L53:
        if ((r100 & 4096) != 0) goto L55;
        this.f295241m = null;
    L57:
        if ((r100 & 8192) != 0) goto L59;
        this.f295242n = null;
    L61:
        if ((r100 & 16384) != 0) goto L63;
        Boolean r104 = Boolean.FALSE;
    L64:
        this.f295243o = r104;
        if ((32768 & r100) != 0) goto L67;
        this.f295244p = null;
    L69:
        if ((65536 & r100) != 0) goto L71;
        this.f295245q = null;
    L73:
        if ((131072 & r100) != 0) goto L75;
        this.f295246r = null;
    L77:
        if ((262144 & r100) != 0) goto L79;
        this.f295247s = null;
    L81:
        if ((524288 & r100) != 0) goto L83;
        this.f295248t = null;
    L85:
        if ((1048576 & r100) != 0) goto L87;
        this.f295249u = null;
    L89:
        if ((2097152 & r100) != 0) goto L91;
        this.f295250v = null;
    L93:
        if ((4194304 & r100) != 0) goto L95;
        this.f295251w = null;
    L97:
        if ((r100 & 8388608) != 0) goto L99;
        this.f295252x = null;
        return;
    L99:
        this.f295252x = r310;
        return;
    L95:
        this.f295251w = r219;
        goto L97
    L91:
        this.f295250v = r218;
        goto L93
    L87:
        this.f295249u = r217;
        goto L89
    L83:
        this.f295248t = r216;
        goto L85
    L79:
        this.f295247s = r215;
        goto L81
    L75:
        this.f295246r = r214;
        goto L77
    L71:
        this.f295245q = r213;
        goto L73
    L67:
        this.f295244p = r212;
        goto L69
    L63:
        r104 = r211;
        goto L64
    L59:
        this.f295242n = r210;
        goto L61
    L55:
        this.f295241m = r119;
        goto L57
    L51:
        this.f295240l = r118;
        goto L53
    L47:
        this.f295239k = r117;
        goto L49
    L43:
        this.f295238j = r116;
        goto L45
    L39:
        this.f295237i = r115;
        goto L41
    L35:
        this.f295236h = r114;
        goto L37
    L31:
        this.f295235g = r113;
        goto L33
    L27:
        this.f295234f = r112;
        goto L29
    L23:
        this.f295233e = r111;
        goto L25
    L19:
        this.f295232d = r110;
        goto L21
    L15:
        this.f295231c = r103;
        goto L17
    L11:
        this.f295230b = r102;
        goto L13
    L7:
        this.f295229a = r101;
        goto L9
    }
}
