package com.larus.bmhome.actionbar.model;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;
import nuc.v2;

/* JADX INFO: loaded from: classes25.dex */
@Serializable
public final class w {
    public static final b Companion = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f295509x = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f295510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f295511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f295512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f295513d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f295514e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final g1 f295515f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g1 f295516g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f295517h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f295518i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f295519j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f295520k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f295521l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f295522m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Boolean f295523n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f295524o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Boolean f295525p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Map<String, String> f295526q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Boolean f295527r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Integer f295528s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f295529t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f295530u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List<c2> f295531v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final z1 f295532w;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<w> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f295533a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f295534b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f295534b;
        }

        static {
            a r100 = new a();
            f295533a = r100;
            g2 r101 = new g2("com.larus.bmhome.actionbar.model.ActionBarInstructionOption", r100, 23);
            r101.j("id", true);
            r101.j("display_text", true);
            r101.j("selected_display_text", true);
            r101.j(TTDelegateActivity.MESSAGE_TEXT, true);
            r101.j("option_key", true);
            r101.j("icon", true);
            r101.j("dark_mode_icon", true);
            r101.j("type", true);
            r101.j("option_type", true);
            r101.j(com.bytedance.android.ec.core.event.a.KEY_IS_SHOW, true);
            r101.j("language", true);
            r101.j("source_message_text", true);
            r101.j("target_message_text", true);
            r101.j("bidirectional", true);
            r101.j("location", true);
            r101.j("prefix", true);
            r101.j("extra", true);
            r101.j("disable_with_ai_replica", true);
            r101.j("status", true);
            r101.j("display_starling", true);
            r101.j("message_starling", true);
            r101.j(PromotionProductPrivilegesStruct.TAGS, true);
            r101.j("subscribe_config", true);
            f295534b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r100 = w.f295509x;
            v2 r101 = v2.f520790a;
            g1.a r102 = g1.a.f295160a;
            nuc.w0 r103 = nuc.w0.f520792a;
            nuc.i r104 = nuc.i.f520705a;
            return new juc.d[]{kuc.a.d(nuc.g1.f520681a), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r102), kuc.a.d(r102), r103, r103, r104, kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r104), kuc.a.d(r101), kuc.a.d(r104), kuc.a.d(r100[16].getValue()), kuc.a.d(r104), kuc.a.d(r103), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r100[21].getValue()), kuc.a.d(z1.a.f295638a)};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r510) {
            Intrinsics.checkNotNullParameter(r510, "decoder");
            g2 r100 = f295534b;
            muc.c r101 = r510.beginStructure(r100);
            Lazy<juc.d<Object>>[] r102 = w.f295509x;
            if (r101.decodeSequentially() == false) goto L5;
            Long r103 = (Long) r101.decodeNullableSerializableElement(r100, 0, nuc.g1.f520681a, null);
            v2 r110 = v2.f520790a;
            String r111 = (String) r101.decodeNullableSerializableElement(r100, 1, r110, null);
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 2, r110, null);
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 3, r110, null);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 4, r110, null);
            g1.a r112 = g1.a.f295160a;
            g1 r107 = (g1) r101.decodeNullableSerializableElement(r100, 5, r112, null);
            g1 r108 = (g1) r101.decodeNullableSerializableElement(r100, 6, r112, null);
            int r109 = r101.decodeIntElement(r100, 7);
            int r113 = r101.decodeIntElement(r100, 8);
            boolean r114 = r101.decodeBooleanElement(r100, 9);
            String r115 = (String) r101.decodeNullableSerializableElement(r100, 10, r110, null);
            String r116 = (String) r101.decodeNullableSerializableElement(r100, 11, r110, null);
            String r117 = (String) r101.decodeNullableSerializableElement(r100, 12, r110, null);
            nuc.i r118 = nuc.i.f520705a;
            Boolean r119 = (Boolean) r101.decodeNullableSerializableElement(r100, 13, r118, null);
            String r210 = (String) r101.decodeNullableSerializableElement(r100, 14, r110, null);
            Boolean r120 = (Boolean) r101.decodeNullableSerializableElement(r100, 15, r118, null);
            Map r121 = (Map) r101.decodeNullableSerializableElement(r100, 16, r102[16].getValue(), null);
            Boolean r122 = (Boolean) r101.decodeNullableSerializableElement(r100, 17, r118, null);
            Integer r123 = (Integer) r101.decodeNullableSerializableElement(r100, 18, nuc.w0.f520792a, null);
            String r124 = (String) r101.decodeNullableSerializableElement(r100, 19, r110, null);
            String r125 = (String) r101.decodeNullableSerializableElement(r100, 20, r110, null);
            List r211 = (List) r101.decodeNullableSerializableElement(r100, 21, r102[21].getValue(), null);
            z1 r212 = (z1) r101.decodeNullableSerializableElement(r100, 22, z1.a.f295638a, null);
            String r213 = r125;
            g1 r126 = r107;
            String r127 = r106;
            String r128 = r115;
            int r129 = r109;
            String r130 = r104;
            String r131 = r111;
            String r132 = r117;
            Long r133 = r103;
            Map r214 = r121;
            Integer r215 = r123;
            boolean r134 = r114;
            g1 r135 = r108;
            int r136 = 8388607;
            int r137 = r113;
            String r138 = r105;
            String r216 = r124;
            Boolean r217 = r122;
            String r139 = r116;
            Boolean r218 = r120;
            Boolean r219 = r119;
        L50:
            r101.endStructure(r100);
            return new w(r136, r133, r131, r130, r138, r127, r126, r135, r129, r137, r134, r128, r139, r132, r219, r210, r218, r214, r217, r215, r216, r213, r211, r212);
        L5:
            String r140 = null;
            Boolean r141 = null;
            String r142 = null;
            Map r143 = null;
            Integer r144 = null;
            List r145 = null;
            String r146 = null;
            String r147 = null;
            Boolean r148 = null;
            Boolean r149 = null;
            String r150 = null;
            z1 r151 = null;
            Long r310 = null;
            String r311 = null;
            String r312 = null;
            String r313 = null;
            String r314 = null;
            g1 r410 = null;
            g1 r411 = null;
            String r412 = null;
            int r152 = 0;
            boolean r220 = false;
            int r315 = 0;
            int r413 = 0;
            boolean r414 = true;
        L6:
            if (r414 == false) goto L49;
            String r415 = r142;
            int r153 = r101.decodeElementIndex(r100);
            switch(r153) {
                case -1: goto L47;
                case 0: goto L45;
                case 1: goto L43;
                case 2: goto L41;
                case 3: goto L40;
                case 4: goto L39;
                case 5: goto L38;
                case 6: goto L37;
                case 7: goto L35;
                case 8: goto L33;
                case 9: goto L32;
                case 10: goto L31;
                case 11: goto L30;
                case 12: goto L29;
                case 13: goto L26;
                case 14: goto L24;
                case 15: goto L22;
                case 16: goto L21;
                case 17: goto L19;
                case 18: goto L18;
                case 19: goto L16;
                case 20: goto L14;
                case 21: goto L12;
                case 22: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r153);
        L29:
            r140 = (String) r101.decodeNullableSerializableElement(r100, 12, v2.f520790a, r140);
            r152 = r152 | 4096;
            r102 = r102;
            r141 = r141;
            r142 = r415;
            goto L6
        L30:
            Lazy<juc.d<Object>>[] r154 = r102;
            r152 = r152 | 2048;
            r142 = (String) r101.decodeNullableSerializableElement(r100, 11, v2.f520790a, r415);
            r102 = r154;
            r141 = r141;
            r140 = r140;
            goto L6
        L31:
            r102 = r102;
            r141 = r141;
            r140 = r140;
            r415 = r415;
            r412 = (String) r101.decodeNullableSerializableElement(r100, 10, v2.f520790a, r412);
            r152 = r152 | 1024;
        L36:
            String r221 = r311;
        L46:
            r412 = r412;
        L48:
            r411 = r411;
            r410 = r410;
            r102 = r102;
            r141 = r141;
            r140 = r140;
            r142 = r415;
            r311 = r221;
            r312 = r312;
            r313 = r313;
            r143 = r143;
            r412 = r412;
            r314 = r314;
            goto L6
        L32:
            r220 = r101.decodeBooleanElement(r100, 9);
            r152 = r152 | 512;
            goto L36
        L33:
            r152 = r152 | 256;
            r413 = r101.decodeIntElement(r100, 8);
            goto L36
        L35:
            r102 = r102;
            r141 = r141;
            r140 = r140;
            r412 = r412;
            r415 = r415;
            r152 = r152 | 128;
            r315 = r101.decodeIntElement(r100, 7);
            goto L36
        L37:
            r411 = (g1) r101.decodeNullableSerializableElement(r100, 6, g1.a.f295160a, r411);
            r152 = r152 | 64;
            r102 = r102;
            r141 = r141;
            r140 = r140;
            r142 = r415;
            goto L6
        L38:
            r410 = (g1) r101.decodeNullableSerializableElement(r100, 5, g1.a.f295160a, r410);
            r152 = r152 | 32;
            r102 = r102;
            r141 = r141;
            r140 = r140;
            r142 = r415;
            r412 = r412;
            goto L6
        L39:
            Lazy<juc.d<Object>>[] r155 = r102;
            r152 = r152 | 16;
            r141 = r141;
            r140 = r140;
            r142 = r415;
            r143 = r143;
            r314 = (String) r101.decodeNullableSerializableElement(r100, 4, v2.f520790a, r314);
            r102 = r155;
            goto L6
        L40:
            r314 = r314;
            r152 = r152 | 8;
            r312 = r312;
            r313 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r313);
        L44:
            r221 = r311;
            goto L48
        L41:
            r314 = r314;
            r313 = r313;
            r152 = r152 | 4;
            r312 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r312);
            goto L44
        L43:
            r102 = r102;
            r141 = r141;
            r140 = r140;
            r313 = r313;
            r314 = r314;
            r410 = r410;
            r411 = r411;
            r412 = r412;
            r415 = r415;
            r143 = r143;
            r312 = r312;
            r311 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r311);
            r152 = r152 | 2;
            goto L44
        L45:
            r102 = r102;
            r141 = r141;
            r140 = r140;
            r415 = r415;
            r221 = r311;
            r310 = (Long) r101.decodeNullableSerializableElement(r100, 0, nuc.g1.f520681a, r310);
            r152 = r152 | 1;
            r412 = r412;
            goto L46
        L47:
            r102 = r102;
            r141 = r141;
            r140 = r140;
            r221 = r311;
            r312 = r312;
            r313 = r313;
            r314 = r314;
            r410 = r410;
            r411 = r411;
            r412 = r412;
            r415 = r415;
            r143 = r143;
            r414 = false;
            goto L48
        L11:
            r151 = (z1) r101.decodeNullableSerializableElement(r100, 22, z1.a.f295638a, r151);
            int r156 = 4194304;
        L17:
            r152 = r156 | r152;
        L28:
            r102 = r102;
            r142 = r415;
            r140 = r140;
            goto L6
        L12:
            r140 = r140;
            r152 = 2097152 | r152;
            r145 = (List) r101.decodeNullableSerializableElement(r100, 21, r102[21].getValue(), r145);
            goto L28
        L14:
            r146 = (String) r101.decodeNullableSerializableElement(r100, 20, v2.f520790a, r146);
            r156 = 1048576;
            goto L17
        L16:
            r140 = r140;
            r147 = (String) r101.decodeNullableSerializableElement(r100, 19, v2.f520790a, r147);
            r156 = 524288;
            goto L17
        L18:
            r144 = (Integer) r101.decodeNullableSerializableElement(r100, 18, nuc.w0.f520792a, r144);
            int r157 = 262144;
        L20:
            r102 = r102;
            int r158 = r157 | r152;
        L27:
            r152 = r158;
            goto L28
        L19:
            r149 = (Boolean) r101.decodeNullableSerializableElement(r100, 17, nuc.i.f520705a, r149);
            r157 = 131072;
            goto L20
        L21:
            r143 = (Map) r101.decodeNullableSerializableElement(r100, 16, r102[16].getValue(), r143);
            int r159 = 65536;
        L23:
            r158 = r159 | r152;
            goto L27
        L22:
            r148 = (Boolean) r101.decodeNullableSerializableElement(r100, 15, nuc.i.f520705a, r148);
            r159 = 32768;
            goto L23
        L24:
            r102 = r102;
            r140 = r140;
            r150 = (String) r101.decodeNullableSerializableElement(r100, 14, v2.f520790a, r150);
            r158 = r152 | 16384;
            goto L27
        L26:
            r102 = r102;
            r140 = r140;
            r141 = (Boolean) r101.decodeNullableSerializableElement(r100, 13, nuc.i.f520705a, r141);
            r158 = r152 | 8192;
            goto L27
        L49:
            r218 = r148;
            r210 = r150;
            r219 = r141;
            r132 = r140;
            r139 = r142;
            r134 = r220;
            r138 = r313;
            r214 = r143;
            r128 = r412;
            r135 = r411;
            r215 = r144;
            r216 = r147;
            r217 = r149;
            r212 = r151;
            r136 = r152;
            r130 = r312;
            r129 = r315;
            r137 = r413;
            r211 = r145;
            r126 = r410;
            r127 = r314;
            r133 = r310;
            r213 = r146;
            r131 = r311;
            goto L50
        }

        @Override // juc.n
        public final void serialize(muc.f r110, Object r111) {
            w r112 = (w) r111;
            Intrinsics.checkNotNullParameter(r110, "encoder");
            Intrinsics.checkNotNullParameter(r112, "value");
            g2 r100 = f295534b;
            muc.d r113 = r110.beginStructure(r100);
            Lazy<juc.d<Object>>[] r101 = w.f295509x;
            boolean r102 = false;
            if (r113.shouldEncodeElementDefault(r100, 0) == true) goto L10;
            Long r103 = r112.f295510a;
            if (r103 == null) goto L10;
            if (r103.longValue() != (-1)) goto L10;
            boolean r104 = false;
        L12:
            if (r104 == false) goto L15;
            r113.encodeNullableSerializableElement(r100, 0, nuc.g1.f520681a, r112.f295510a);
        L15:
            if (r113.shouldEncodeElementDefault(r100, 1) == false) goto L18;
        L19:
            boolean r105 = true;
        L21:
            if (r105 == false) goto L24;
            r113.encodeNullableSerializableElement(r100, 1, v2.f520790a, r112.f295511b);
        L24:
            if (r113.shouldEncodeElementDefault(r100, 2) == false) goto L27;
        L28:
            boolean r106 = true;
        L30:
            if (r106 == false) goto L33;
            r113.encodeNullableSerializableElement(r100, 2, v2.f520790a, r112.f295512c);
        L33:
            if (r113.shouldEncodeElementDefault(r100, 3) == false) goto L36;
        L37:
            boolean r107 = true;
        L39:
            if (r107 == false) goto L42;
            r113.encodeNullableSerializableElement(r100, 3, v2.f520790a, r112.f295513d);
        L42:
            if (r113.shouldEncodeElementDefault(r100, 4) == false) goto L45;
        L46:
            boolean r108 = true;
        L48:
            if (r108 == false) goto L51;
            r113.encodeNullableSerializableElement(r100, 4, v2.f520790a, r112.f295514e);
        L51:
            if (r113.shouldEncodeElementDefault(r100, 5) == false) goto L54;
        L55:
            boolean r109 = true;
        L57:
            if (r109 == false) goto L60;
            r113.encodeNullableSerializableElement(r100, 5, g1.a.f295160a, r112.f295515f);
        L60:
            if (r113.shouldEncodeElementDefault(r100, 6) == false) goto L63;
        L64:
            boolean r114 = true;
        L66:
            if (r114 == false) goto L69;
            r113.encodeNullableSerializableElement(r100, 6, g1.a.f295160a, r112.f295516g);
        L69:
            if (r113.shouldEncodeElementDefault(r100, 7) == false) goto L72;
        L73:
            boolean r115 = true;
        L75:
            if (r115 == false) goto L78;
            r113.encodeIntElement(r100, 7, r112.f295517h);
        L78:
            if (r113.shouldEncodeElementDefault(r100, 8) == false) goto L81;
        L82:
            boolean r116 = true;
        L84:
            if (r116 == false) goto L87;
            r113.encodeIntElement(r100, 8, r112.f295518i);
        L87:
            if (r113.shouldEncodeElementDefault(r100, 9) == false) goto L90;
        L91:
            boolean r117 = true;
        L93:
            if (r117 == false) goto L96;
            r113.encodeBooleanElement(r100, 9, r112.f295519j);
        L96:
            if (r113.shouldEncodeElementDefault(r100, 10) == false) goto L99;
        L100:
            boolean r118 = true;
        L102:
            if (r118 == false) goto L105;
            r113.encodeNullableSerializableElement(r100, 10, v2.f520790a, r112.f295520k);
        L105:
            if (r113.shouldEncodeElementDefault(r100, 11) == false) goto L108;
        L109:
            boolean r119 = true;
        L111:
            if (r119 == false) goto L114;
            r113.encodeNullableSerializableElement(r100, 11, v2.f520790a, r112.f295521l);
        L114:
            if (r113.shouldEncodeElementDefault(r100, 12) == false) goto L117;
        L118:
            boolean r120 = true;
        L120:
            if (r120 == false) goto L123;
            r113.encodeNullableSerializableElement(r100, 12, v2.f520790a, r112.f295522m);
        L123:
            if (r113.shouldEncodeElementDefault(r100, 13) == false) goto L126;
        L127:
            boolean r121 = true;
        L129:
            if (r121 == false) goto L132;
            r113.encodeNullableSerializableElement(r100, 13, nuc.i.f520705a, r112.f295523n);
        L132:
            if (r113.shouldEncodeElementDefault(r100, 14) == false) goto L135;
        L136:
            boolean r122 = true;
        L138:
            if (r122 == false) goto L141;
            r113.encodeNullableSerializableElement(r100, 14, v2.f520790a, r112.f295524o);
        L141:
            if (r113.shouldEncodeElementDefault(r100, 15) == false) goto L144;
        L145:
            boolean r123 = true;
        L147:
            if (r123 == false) goto L150;
            r113.encodeNullableSerializableElement(r100, 15, nuc.i.f520705a, r112.f295525p);
        L150:
            if (r113.shouldEncodeElementDefault(r100, 16) == false) goto L153;
        L154:
            boolean r124 = true;
        L156:
            if (r124 == false) goto L159;
            r113.encodeNullableSerializableElement(r100, 16, r101[16].getValue(), r112.f295526q);
        L159:
            if (r113.shouldEncodeElementDefault(r100, 17) == false) goto L162;
        L163:
            boolean r125 = true;
        L165:
            if (r125 == false) goto L168;
            r113.encodeNullableSerializableElement(r100, 17, nuc.i.f520705a, r112.f295527r);
        L168:
            if (r113.shouldEncodeElementDefault(r100, 18) == true) goto L175;
            Integer r126 = r112.f295528s;
            if (r126 == null) goto L175;
            if (r126.intValue() != 0) goto L175;
            boolean r127 = false;
        L177:
            if (r127 == false) goto L180;
            r113.encodeNullableSerializableElement(r100, 18, nuc.w0.f520792a, r112.f295528s);
        L180:
            if (r113.shouldEncodeElementDefault(r100, 19) == false) goto L183;
        L184:
            boolean r128 = true;
        L186:
            if (r128 == false) goto L189;
            r113.encodeNullableSerializableElement(r100, 19, v2.f520790a, r112.f295529t);
        L189:
            if (r113.shouldEncodeElementDefault(r100, 20) == false) goto L192;
        L193:
            boolean r129 = true;
        L195:
            if (r129 == false) goto L198;
            r113.encodeNullableSerializableElement(r100, 20, v2.f520790a, r112.f295530u);
        L198:
            if (r113.shouldEncodeElementDefault(r100, 21) == false) goto L201;
        L202:
            boolean r130 = true;
        L204:
            if (r130 == false) goto L207;
            r113.encodeNullableSerializableElement(r100, 21, r101[21].getValue(), r112.f295531v);
        L207:
            if (r113.shouldEncodeElementDefault(r100, 22) == false) goto L210;
        L211:
            r102 = true;
        L212:
            if (r102 == false) goto L214;
            r113.encodeNullableSerializableElement(r100, 22, z1.a.f295638a, r112.f295532w);
        L214:
            r113.endStructure(r100);
            return;
        L210:
            if (r112.f295532w == null) goto L212;
        L201:
            if (r112.f295531v != null) goto L202;
            r130 = false;
            goto L204
        L192:
            if (r112.f295530u != null) goto L193;
            r129 = false;
            goto L195
        L183:
            if (r112.f295529t != null) goto L184;
            r128 = false;
        L175:
            r127 = true;
            goto L177
        L162:
            if (Intrinsics.areEqual(r112.f295527r, Boolean.FALSE) == false) goto L163;
            r125 = false;
            goto L165
        L153:
            if (r112.f295526q != null) goto L154;
            r124 = false;
            goto L156
        L144:
            if (Intrinsics.areEqual(r112.f295525p, Boolean.FALSE) == false) goto L145;
            r123 = false;
            goto L147
        L135:
            if (r112.f295524o != null) goto L136;
            r122 = false;
            goto L138
        L126:
            if (Intrinsics.areEqual(r112.f295523n, Boolean.FALSE) == false) goto L127;
            r121 = false;
            goto L129
        L117:
            if (r112.f295522m != null) goto L118;
            r120 = false;
            goto L120
        L108:
            if (r112.f295521l != null) goto L109;
            r119 = false;
            goto L111
        L99:
            if (r112.f295520k != null) goto L100;
            r118 = false;
            goto L102
        L90:
            if (r112.f295519j == true) goto L91;
            r117 = false;
            goto L93
        L81:
            if (r112.f295518i != 0) goto L82;
            r116 = false;
            goto L84
        L72:
            if (r112.f295517h != 0) goto L73;
            r115 = false;
            goto L75
        L63:
            if (r112.f295516g != null) goto L64;
            r114 = false;
            goto L66
        L54:
            if (r112.f295515f != null) goto L55;
            r109 = false;
            goto L57
        L45:
            if (r112.f295514e != null) goto L46;
            r108 = false;
            goto L48
        L36:
            if (Intrinsics.areEqual(r112.f295513d, "") == false) goto L37;
            r107 = false;
            goto L39
        L27:
            if (r112.f295512c != null) goto L28;
            r106 = false;
            goto L30
        L18:
            if (Intrinsics.areEqual(r112.f295511b, "") == false) goto L19;
            r105 = false;
        L10:
            r104 = true;
            goto L12
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<w> serializer() {
            return a.f295533a;
        }
    }

    public w() {
        this(null, null, null, null, 0, null, null, 8388607);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (Intrinsics.areEqual(this.f295510a, r101.f295510a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f295511b, r101.f295511b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f295512c, r101.f295512c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f295513d, r101.f295513d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f295514e, r101.f295514e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f295515f, r101.f295515f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f295516g, r101.f295516g) == true) goto L30;
        return false;
    L30:
        if (this.f295517h == r101.f295517h) goto L33;
        return false;
    L33:
        if (this.f295518i == r101.f295518i) goto L36;
        return false;
    L36:
        if (this.f295519j == r101.f295519j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f295520k, r101.f295520k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f295521l, r101.f295521l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f295522m, r101.f295522m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f295523n, r101.f295523n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f295524o, r101.f295524o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f295525p, r101.f295525p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f295526q, r101.f295526q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f295527r, r101.f295527r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f295528s, r101.f295528s) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.f295529t, r101.f295529t) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.f295530u, r101.f295530u) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.f295531v, r101.f295531v) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.f295532w, r101.f295532w) == true) goto L77;
        return false;
    L77:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.f295510a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f295511b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f295512c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f295513d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f295514e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        g1 r116 = this.f295515f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        g1 r119 = this.f295516g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (((((r118 + r120) * 31) + this.f295517h) * 31) + this.f295518i) * 31;
        if (this.f295519j == false) goto L33;
        int r122 = 1231;
    L34:
        int r123 = (r121 + r122) * 31;
        String r124 = this.f295520k;
        if (r124 != null) goto L37;
        int r125 = 0;
    L38:
        int r126 = (r123 + r125) * 31;
        String r127 = this.f295521l;
        if (r127 != null) goto L41;
        int r128 = 0;
    L42:
        int r129 = (r126 + r128) * 31;
        String r130 = this.f295522m;
        if (r130 != null) goto L45;
        int r131 = 0;
    L46:
        int r132 = (r129 + r131) * 31;
        Boolean r133 = this.f295523n;
        if (r133 != null) goto L49;
        int r134 = 0;
    L50:
        int r135 = (r132 + r134) * 31;
        String r136 = this.f295524o;
        if (r136 != null) goto L53;
        int r137 = 0;
    L54:
        int r138 = (r135 + r137) * 31;
        Boolean r139 = this.f295525p;
        if (r139 != null) goto L57;
        int r140 = 0;
    L58:
        int r141 = (r138 + r140) * 31;
        Map<String, String> r142 = this.f295526q;
        if (r142 != null) goto L61;
        int r143 = 0;
    L62:
        int r144 = (r141 + r143) * 31;
        Boolean r145 = this.f295527r;
        if (r145 != null) goto L65;
        int r146 = 0;
    L66:
        int r147 = (r144 + r146) * 31;
        Integer r148 = this.f295528s;
        if (r148 != null) goto L69;
        int r149 = 0;
    L70:
        int r150 = (r147 + r149) * 31;
        String r151 = this.f295529t;
        if (r151 != null) goto L73;
        int r152 = 0;
    L74:
        int r153 = (r150 + r152) * 31;
        String r154 = this.f295530u;
        if (r154 != null) goto L77;
        int r155 = 0;
    L78:
        int r156 = (r153 + r155) * 31;
        List<c2> r157 = this.f295531v;
        if (r157 != null) goto L81;
        int r158 = 0;
    L82:
        int r159 = (r156 + r158) * 31;
        z1 r160 = this.f295532w;
        if (r160 == null) goto L87;
        r101 = r160.hashCode();
    L87:
        return r159 + r101;
    L81:
        r158 = r157.hashCode();
        goto L82
    L77:
        r155 = r154.hashCode();
        goto L78
    L73:
        r152 = r151.hashCode();
        goto L74
    L69:
        r149 = r148.hashCode();
        goto L70
    L65:
        r146 = r145.hashCode();
        goto L66
    L61:
        r143 = r142.hashCode();
        goto L62
    L57:
        r140 = r139.hashCode();
        goto L58
    L53:
        r137 = r136.hashCode();
        goto L54
    L49:
        r134 = r133.hashCode();
        goto L50
    L45:
        r131 = r130.hashCode();
        goto L46
    L41:
        r128 = r127.hashCode();
        goto L42
    L37:
        r125 = r124.hashCode();
        goto L38
    L33:
        r122 = 1237;
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
        return "ActionBarInstructionOption(id=" + this.f295510a + ", displayText=" + this.f295511b + ", selectedDisplayText=" + this.f295512c + ", messageText=" + this.f295513d + ", optionKey=" + this.f295514e + ", icon=" + this.f295515f + ", darkModeIcon=" + this.f295516g + ", type=" + this.f295517h + ", optionType=" + this.f295518i + ", isShow=" + this.f295519j + ", language=" + this.f295520k + ", sourceMessageText=" + this.f295521l + ", targetMessageText=" + this.f295522m + ", bidirectional=" + this.f295523n + ", location=" + this.f295524o + ", prefix=" + this.f295525p + ", extra=" + this.f295526q + ", disableWithAiReplica=" + this.f295527r + ", status=" + this.f295528s + ", displayStarling=" + this.f295529t + ", messageStarling=" + this.f295530u + ", tags=" + this.f295531v + ", subscribeConfig=" + this.f295532w + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        f295509x = new Lazy[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, LazyKt.lazy(r100, new wa8.y()), null, null, null, null, LazyKt.lazy(r100, new wa8.z()), null};
    }

    public final String b() {
        String r100 = this.f295512c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return this.f295511b;
    }

    public final e2 c() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L9
        Map<String, String> r101 = this.f295526q;     // Catch: Throwable -> L9
        if (r101 == null) goto L6;
        String r102 = r101.get("ref_media_info");     // Catch: Throwable -> L9
        if (r102 == null) goto L6;
    L7:
        Object r103 = Result.m9449constructorimpl((e2) xt7.d.f565073b.c(e2.Companion.serializer(), r102));     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r103) == false) goto L15;
        r103 = null;
    L15:
        return (e2) r103;
    L6:
        r102 = "";
    L9:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public final int getType() {
        return this.f295517h;
    }

    public /* synthetic */ w(Long r210, String r211, String r212, g1 r310, int r311, Map r312, Integer r313, int r314) {
        if ((r314 & 1) == 0) goto L5;
        Long r100 = -1L;
    L7:
        if ((r314 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r314 & 8) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r314 & 32) == 0) goto L17;
        g1 r103 = null;
    L19:
        if ((r314 & 128) == 0) goto L21;
        int r104 = 0;
    L23:
        if ((r314 & 8192) == 0) goto L25;
        Boolean r110 = Boolean.FALSE;
    L27:
        if ((32768 & r314) == 0) goto L29;
        Boolean r111 = Boolean.FALSE;
    L31:
        if ((65536 & r314) == 0) goto L33;
        Map r112 = null;
    L35:
        if ((131072 & r314) == 0) goto L37;
        Boolean r213 = Boolean.FALSE;
    L39:
        if ((r314 & 262144) == 0) goto L41;
        Integer r214 = 0;
    L42:
        this(r100, r101, null, r102, null, r103, null, r104, 0, false, null, null, null, r110, null, r111, r112, r213, r214, null, null, null, null);
        return;
    L41:
        r214 = r313;
        goto L42
    L37:
        r213 = null;
        goto L39
    L33:
        r112 = r312;
        goto L35
    L29:
        r111 = null;
        goto L31
    L25:
        r110 = null;
        goto L27
    L21:
        r104 = r311;
        goto L23
    L17:
        r103 = r310;
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

    public static w a(w r210, String r211, String r310, Integer r311, String r312, List r313, z1 r314, int r315) {
        String r100 = null;
        if ((r315 & 1) == 0) goto L5;
        Long r101 = r210.f295510a;
    L7:
        if ((r315 & 2) == 0) goto L9;
        String r102 = r210.f295511b;
    L11:
        if ((r315 & 4) == 0) goto L13;
        String r103 = r210.f295512c;
    L15:
        if ((r315 & 8) == 0) goto L17;
        String r104 = r210.f295513d;
    L19:
        if ((r315 & 16) == 0) goto L21;
        String r105 = r210.f295514e;
    L23:
        if ((r315 & 32) == 0) goto L25;
        g1 r110 = r210.f295515f;
    L27:
        if ((r315 & 64) == 0) goto L29;
        g1 r111 = r210.f295516g;
    L31:
        if ((r315 & 128) == 0) goto L33;
        int r112 = r210.f295517h;
    L35:
        if ((r315 & 256) == 0) goto L37;
        int r113 = r210.f295518i;
    L39:
        if ((r315 & 512) == 0) goto L41;
        boolean r114 = r210.f295519j;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        String r115 = r210.f295520k;
    L47:
        if ((r315 & 2048) == 0) goto L49;
        String r116 = r210.f295521l;
    L51:
        if ((r315 & 4096) == 0) goto L53;
        String r117 = r210.f295522m;
    L55:
        if ((r315 & 8192) == 0) goto L57;
        Boolean r118 = r210.f295523n;
    L59:
        if ((r315 & 16384) == 0) goto L61;
        String r119 = r210.f295524o;
    L63:
        if ((32768 & r315) == 0) goto L65;
        Boolean r212 = r210.f295525p;
    L67:
        if ((65536 & r315) == 0) goto L69;
        Map<String, String> r213 = r210.f295526q;
    L71:
        if ((131072 & r315) == 0) goto L73;
        Boolean r214 = r210.f295527r;
    L75:
        if ((262144 & r315) == 0) goto L77;
        Integer r215 = r210.f295528s;
    L79:
        if ((524288 & r315) == 0) goto L81;
        r100 = r210.f295529t;
    L81:
        String r216 = r100;
        if ((1048576 & r315) == 0) goto L84;
        String r217 = r210.f295530u;
    L86:
        if ((2097152 & r315) == 0) goto L88;
        List r218 = r210.f295531v;
    L90:
        if ((r315 & 4194304) == 0) goto L92;
        z1 r219 = r210.f295532w;
    L93:
        r210.getClass();
        return new w(r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r212, r213, r214, r215, r216, r217, r218, r219);
    L92:
        r219 = r314;
        goto L93
    L88:
        r218 = r313;
        goto L90
    L84:
        r217 = r312;
        goto L86
    L77:
        r215 = r311;
        goto L79
    L73:
        r214 = null;
        goto L75
    L69:
        r213 = null;
        goto L71
    L65:
        r212 = null;
        goto L67
    L61:
        r119 = null;
        goto L63
    L57:
        r118 = null;
        goto L59
    L53:
        r117 = null;
        goto L55
    L49:
        r116 = null;
        goto L51
    L45:
        r115 = null;
        goto L47
    L41:
        r114 = false;
        goto L43
    L37:
        r113 = 0;
        goto L39
    L33:
        r112 = 0;
        goto L35
    L29:
        r111 = null;
        goto L31
    L25:
        r110 = null;
        goto L27
    L21:
        r105 = r310;
        goto L23
    L17:
        r104 = r211;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public w(Long r100, String r101, String r102, String r103, String r104, g1 r105, g1 r106, int r110, int r111, boolean r112, String r113, String r114, String r115, Boolean r116, String r117, Boolean r118, Map<String, String> r119, Boolean r210, Integer r211, String r212, String r213, List<c2> r214, z1 r215) {
        this.f295510a = r100;
        this.f295511b = r101;
        this.f295512c = r102;
        this.f295513d = r103;
        this.f295514e = r104;
        this.f295515f = r105;
        this.f295516g = r106;
        this.f295517h = r110;
        this.f295518i = r111;
        this.f295519j = r112;
        this.f295520k = r113;
        this.f295521l = r114;
        this.f295522m = r115;
        this.f295523n = r116;
        this.f295524o = r117;
        this.f295525p = r118;
        this.f295526q = r119;
        this.f295527r = r210;
        this.f295528s = r211;
        this.f295529t = r212;
        this.f295530u = r213;
        this.f295531v = r214;
        this.f295532w = r215;
    }

    public w(int r100, Long r101, String r110, String r111, String r112, String r113, g1 r114, g1 r115, int r116, int r117, boolean r118, String r119, String r210, String r211, Boolean r212, String r213, Boolean r214, Map r215, Boolean r216, Integer r217, String r218, String r219, List r310, z1 r311) {
        if ((r100 & 0) == 0) goto L5;
        nuc.b2.b(r100, 0, a.f295534b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        Long r102 = -1L;
    L8:
        this.f295510a = r102;
        if ((r100 & 2) != 0) goto L11;
        this.f295511b = "";
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f295512c = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f295513d = "";
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.f295514e = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.f295515f = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.f295516g = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.f295517h = 0;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.f295518i = 0;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.f295519j = false;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.f295520k = null;
    L49:
        if ((r100 & 2048) != 0) goto L51;
        this.f295521l = null;
    L53:
        if ((r100 & 4096) != 0) goto L55;
        this.f295522m = null;
    L57:
        if ((r100 & 8192) != 0) goto L59;
        Boolean r103 = Boolean.FALSE;
    L60:
        this.f295523n = r103;
        if ((r100 & 16384) != 0) goto L63;
        this.f295524o = null;
    L65:
        if ((32768 & r100) != 0) goto L67;
        Boolean r104 = Boolean.FALSE;
    L68:
        this.f295525p = r104;
        if ((65536 & r100) != 0) goto L71;
        this.f295526q = null;
    L73:
        if ((131072 & r100) != 0) goto L75;
        Boolean r105 = Boolean.FALSE;
    L76:
        this.f295527r = r105;
        if ((262144 & r100) != 0) goto L79;
        Integer r106 = 0;
    L80:
        this.f295528s = r106;
        if ((524288 & r100) != 0) goto L83;
        this.f295529t = null;
    L85:
        if ((1048576 & r100) != 0) goto L87;
        this.f295530u = null;
    L89:
        if ((2097152 & r100) != 0) goto L91;
        this.f295531v = null;
    L93:
        if ((r100 & 4194304) != 0) goto L95;
        this.f295532w = null;
        return;
    L95:
        this.f295532w = r311;
        return;
    L91:
        this.f295531v = r310;
        goto L93
    L87:
        this.f295530u = r219;
        goto L89
    L83:
        this.f295529t = r218;
        goto L85
    L79:
        r106 = r217;
        goto L80
    L75:
        r105 = r216;
        goto L76
    L71:
        this.f295526q = r215;
        goto L73
    L67:
        r104 = r214;
        goto L68
    L63:
        this.f295524o = r213;
        goto L65
    L59:
        r103 = r212;
        goto L60
    L55:
        this.f295522m = r211;
        goto L57
    L51:
        this.f295521l = r210;
        goto L53
    L47:
        this.f295520k = r119;
        goto L49
    L43:
        this.f295519j = r118;
        goto L45
    L39:
        this.f295518i = r117;
        goto L41
    L35:
        this.f295517h = r116;
        goto L37
    L31:
        this.f295516g = r115;
        goto L33
    L27:
        this.f295515f = r114;
        goto L29
    L23:
        this.f295514e = r113;
        goto L25
    L19:
        this.f295513d = r112;
        goto L21
    L15:
        this.f295512c = r111;
        goto L17
    L11:
        this.f295511b = r110;
        goto L13
    L7:
        r102 = r101;
        goto L8
    }
}
