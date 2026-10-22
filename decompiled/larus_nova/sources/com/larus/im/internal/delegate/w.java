package com.larus.im.internal.delegate;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.facebook.keyframes.model.KFImage;
import com.larus.im.internal.network.proto2.AvCmd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.v2;

/* JADX INFO: loaded from: classes4.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f348265a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f348266b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f348267c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static q f348268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static i f348269e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static o f348270f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static g f348271g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Integer f348272h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f348273i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy f348274j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Lazy f348275k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy f348276l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Lazy f348277m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Lazy f348278n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Lazy f348279o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Lazy f348280p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Lazy f348281q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Lazy f348282r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Lazy f348283s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Lazy f348284t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Lazy f348285u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Lazy f348286v = null;

    /* JADX INFO: loaded from: classes29.dex */
    @Serializable
    public static final class a {
        public static final b Companion = null;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final Lazy<juc.d<Object>>[] f348287w = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f348288a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f348289b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<Integer> f348290c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<Integer> f348291d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map<String, List<Integer>> f348292e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f348293f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float f348294g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final float f348295h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f348296i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f348297j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f348298k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f348299l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final boolean f348300m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final boolean f348301n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final int f348302o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final boolean f348303p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final int f348304q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final int f348305r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final boolean f348306s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final boolean f348307t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final boolean f348308u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final long f348309v;

        /* JADX INFO: renamed from: com.larus.im.internal.delegate.w$a$a, reason: collision with other inner class name */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class C4354a implements nuc.m0<a> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C4354a f348310a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348311b = null;

            public C4354a() {
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348311b;
            }

            static {
                C4354a r100 = new C4354a();
                f348310a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowAudioSettingsDelegate.AVConfig", r100, 22);
                r101.j("pseudo_connect_prepare_threshold_ms", true);
                r101.j("pseudo_connect_window_period_ms", true);
                r101.j("message_replay_exclude_strategy", true);
                r101.j("message_replay_bypass_strategy", true);
                r101.j("message_replay_override_strategy", true);
                r101.j("enable_stereo_playout_gain", true);
                r101.j("stereo_play_left_gain_percent", true);
                r101.j("stereo_play_right_gain_percent", true);
                r101.j("ref_signal_buffer_ms", true);
                r101.j("ref_signal_trim_keep_ms", true);
                r101.j("ref_signal_max_age_ms", true);
                r101.j("play_per_write_ms", true);
                r101.j("play_resample", true);
                r101.j("enable_record_per_read_ms", true);
                r101.j("record_per_read_ms", true);
                r101.j("enable_play_low_latency", true);
                r101.j("mmt_record_sample_rate", true);
                r101.j("mmt_play_sample_rate", true);
                r101.j("enable_player_fill_silent_when_idle", true);
                r101.j("enable_low_watermark_silence_playout", true);
                r101.j("disable_omni_first_frame_publish", true);
                r101.j("audio_performance_report_interval_ms", true);
                f348311b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                Lazy<juc.d<Object>>[] r100 = a.f348287w;
                nuc.g1 r101 = nuc.g1.f520681a;
                nuc.i r102 = nuc.i.f520705a;
                nuc.l0 r103 = nuc.l0.f520731a;
                nuc.w0 r104 = nuc.w0.f520792a;
                return new juc.d[]{r101, r101, kuc.a.d(r100[2].getValue()), kuc.a.d(r100[3].getValue()), kuc.a.d(r100[4].getValue()), r102, r103, r103, r104, r104, r104, r104, r102, r102, r104, r102, r104, r104, r102, r102, r102, r101};
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r510) {
                Intrinsics.checkNotNullParameter(r510, "decoder");
                g2 r100 = f348311b;
                muc.c r101 = r510.beginStructure(r100);
                Lazy<juc.d<Object>>[] r102 = a.f348287w;
                int r103 = 8;
                if (r101.decodeSequentially() == false) goto L5;
                long r210 = r101.decodeLongElement(r100, 0);
                long r104 = r101.decodeLongElement(r100, 1);
                List r105 = (List) r101.decodeNullableSerializableElement(r100, 2, r102[2].getValue(), null);
                List r106 = (List) r101.decodeNullableSerializableElement(r100, 3, r102[3].getValue(), null);
                Map r107 = (Map) r101.decodeNullableSerializableElement(r100, 4, r102[4].getValue(), null);
                boolean r108 = r101.decodeBooleanElement(r100, 5);
                float r110 = r101.decodeFloatElement(r100, 6);
                float r111 = r101.decodeFloatElement(r100, 7);
                int r109 = r101.decodeIntElement(r100, 8);
                int r112 = r101.decodeIntElement(r100, 9);
                int r113 = r101.decodeIntElement(r100, 10);
                int r114 = r101.decodeIntElement(r100, 11);
                boolean r115 = r101.decodeBooleanElement(r100, 12);
                boolean r116 = r101.decodeBooleanElement(r100, 13);
                int r117 = r101.decodeIntElement(r100, 14);
                boolean r118 = r101.decodeBooleanElement(r100, 15);
                int r119 = r101.decodeIntElement(r100, 16);
                int r120 = r101.decodeIntElement(r100, 17);
                boolean r121 = r101.decodeBooleanElement(r100, 18);
                boolean r122 = r101.decodeBooleanElement(r100, 19);
                boolean r310 = r101.decodeBooleanElement(r100, 20);
                long r311 = r101.decodeLongElement(r100, 21);
                float r123 = r110;
                boolean r211 = r122;
                boolean r212 = r121;
                int r124 = 4194303;
                int r125 = r109;
                float r126 = r111;
                long r127 = r104;
                boolean r213 = r118;
                int r214 = r117;
                int r215 = r114;
                boolean r216 = r115;
                Map r128 = r107;
                List r129 = r106;
                boolean r217 = r116;
                boolean r130 = r108;
                List r131 = r105;
                int r132 = r112;
                long r133 = r210;
                int r218 = r120;
                int r219 = r119;
                int r220 = r113;
            L44:
                r101.endStructure(r100);
                return new a(r124, r133, r127, r131, r129, r128, r130, r123, r126, r125, r132, r220, r215, r216, r217, r214, r213, r219, r218, r212, r211, r310, r311);
            L5:
                int r134 = 21;
                List r135 = null;
                List r136 = null;
                Map r137 = null;
                long r312 = 0;
                long r313 = 0;
                long r410 = 0;
                boolean r138 = false;
                int r139 = 0;
                int r221 = 0;
                boolean r222 = false;
                int r223 = 0;
                boolean r224 = false;
                int r314 = 0;
                boolean r315 = false;
                boolean r316 = false;
                int r317 = 0;
                int r318 = 0;
                float r319 = 0.0f;
                float r411 = 0.0f;
                int r412 = 0;
                int r413 = 0;
                boolean r414 = false;
                boolean r415 = false;
                boolean r416 = true;
            L6:
                if (r416 == false) goto L43;
                int r140 = r101.decodeElementIndex(r100);
                switch(r140) {
                    case -1: goto L42;
                    case 0: goto L40;
                    case 1: goto L38;
                    case 2: goto L37;
                    case 3: goto L35;
                    case 4: goto L34;
                    case 5: goto L33;
                    case 6: goto L32;
                    case 7: goto L31;
                    case 8: goto L30;
                    case 9: goto L29;
                    case 10: goto L28;
                    case 11: goto L27;
                    case 12: goto L25;
                    case 13: goto L23;
                    case 14: goto L22;
                    case 15: goto L20;
                    case 16: goto L18;
                    case 17: goto L17;
                    case 18: goto L15;
                    case 19: goto L13;
                    case 20: goto L12;
                    case 21: goto L11;
                    default: goto L10;
                };
            L10:
                throw new UnknownFieldException(r140);
            L42:
                r103 = 8;
                r416 = false;
                goto L6
            L11:
                r313 = r101.decodeLongElement(r100, r134);
                int r141 = 2097152;
            L14:
                r139 = r139 | r141;
            L41:
                r103 = 8;
                r134 = 21;
                goto L6
            L12:
                r224 = r101.decodeBooleanElement(r100, 20);
                r141 = 1048576;
                goto L14
            L13:
                r222 = r101.decodeBooleanElement(r100, 19);
                r141 = 524288;
                goto L14
            L15:
                r139 = r139 | 262144;
                r138 = r101.decodeBooleanElement(r100, 18);
                goto L41
            L17:
                r221 = r101.decodeIntElement(r100, 17);
                int r142 = 131072;
            L21:
                r139 = r139 | r142;
                goto L41
            L18:
                r314 = r101.decodeIntElement(r100, 16);
                r142 = 65536;
                goto L21
            L20:
                r315 = r101.decodeBooleanElement(r100, 15);
                r142 = 32768;
                goto L21
            L22:
                r223 = r101.decodeIntElement(r100, 14);
                r139 = r139 | 16384;
                goto L41
            L23:
                r415 = r101.decodeBooleanElement(r100, 13);
                r139 = r139 | 8192;
                goto L41
            L25:
                r414 = r101.decodeBooleanElement(r100, 12);
                r139 = r139 | 4096;
                goto L41
            L27:
                r413 = r101.decodeIntElement(r100, 11);
                r139 = r139 | 2048;
                goto L41
            L28:
                r412 = r101.decodeIntElement(r100, 10);
                r139 = r139 | 1024;
                goto L41
            L29:
                r318 = r101.decodeIntElement(r100, 9);
                r139 = r139 | 512;
                goto L41
            L30:
                r317 = r101.decodeIntElement(r100, r103);
                r139 = r139 | 256;
                goto L41
            L31:
                r319 = r101.decodeFloatElement(r100, 7);
                r139 = r139 | 128;
                goto L41
            L32:
                r411 = r101.decodeFloatElement(r100, 6);
                r139 = r139 | 64;
                goto L41
            L33:
                r316 = r101.decodeBooleanElement(r100, 5);
                r139 = r139 | 32;
                goto L41
            L34:
                r137 = (Map) r101.decodeNullableSerializableElement(r100, 4, r102[4].getValue(), r137);
                r139 = r139 | 16;
                goto L41
            L35:
                r136 = (List) r101.decodeNullableSerializableElement(r100, 3, r102[3].getValue(), r136);
                r139 = r139 | 8;
                goto L41
            L37:
                r135 = (List) r101.decodeNullableSerializableElement(r100, 2, r102[2].getValue(), r135);
                r139 = r139 | 4;
                goto L41
            L38:
                r312 = r101.decodeLongElement(r100, 1);
                r139 = r139 | 2;
                goto L41
            L40:
                r410 = r101.decodeLongElement(r100, 0);
                r139 = r139 | 1;
                goto L41
            L43:
                r131 = r135;
                r128 = r137;
                r124 = r139;
                r214 = r223;
                r213 = r315;
                r130 = r316;
                r125 = r317;
                r127 = r312;
                r311 = r313;
                r132 = r318;
                r126 = r319;
                r123 = r411;
                r220 = r412;
                r215 = r413;
                r216 = r414;
                r217 = r415;
                r133 = r410;
                r212 = r138;
                r129 = r136;
                boolean r417 = r222;
                r218 = r221;
                r219 = r314;
                r310 = r224;
                r211 = r417;
                goto L44
            }

            @Override // juc.n
            public final void serialize(muc.f r110, Object r111) {
                a r112 = (a) r111;
                Intrinsics.checkNotNullParameter(r110, "encoder");
                Intrinsics.checkNotNullParameter(r112, "value");
                g2 r100 = f348311b;
                muc.d r113 = r110.beginStructure(r100);
                Lazy<juc.d<Object>>[] r101 = a.f348287w;
                boolean r102 = false;
                if (r113.shouldEncodeElementDefault(r100, 0) == false) goto L6;
            L7:
                boolean r103 = true;
            L9:
                if (r103 == false) goto L12;
                r113.encodeLongElement(r100, 0, r112.f348288a);
            L12:
                if (r113.shouldEncodeElementDefault(r100, 1) == false) goto L15;
            L16:
                boolean r104 = true;
            L18:
                if (r104 == false) goto L21;
                r113.encodeLongElement(r100, 1, r112.f348289b);
            L21:
                if (r113.shouldEncodeElementDefault(r100, 2) == false) goto L24;
            L25:
                boolean r105 = true;
            L27:
                if (r105 == false) goto L30;
                r113.encodeNullableSerializableElement(r100, 2, r101[2].getValue(), r112.f348290c);
            L30:
                if (r113.shouldEncodeElementDefault(r100, 3) == false) goto L33;
            L34:
                boolean r106 = true;
            L36:
                if (r106 == false) goto L39;
                r113.encodeNullableSerializableElement(r100, 3, r101[3].getValue(), r112.f348291d);
            L39:
                if (r113.shouldEncodeElementDefault(r100, 4) == false) goto L42;
            L43:
                boolean r107 = true;
            L45:
                if (r107 == false) goto L48;
                r113.encodeNullableSerializableElement(r100, 4, r101[4].getValue(), r112.f348292e);
            L48:
                if (r113.shouldEncodeElementDefault(r100, 5) == false) goto L51;
            L52:
                boolean r108 = true;
            L54:
                if (r108 == false) goto L57;
                r113.encodeBooleanElement(r100, 5, r112.f348293f);
            L57:
                if (r113.shouldEncodeElementDefault(r100, 6) == false) goto L60;
            L61:
                boolean r109 = true;
            L63:
                if (r109 == false) goto L66;
                r113.encodeFloatElement(r100, 6, r112.f348294g);
            L66:
                if (r113.shouldEncodeElementDefault(r100, 7) == false) goto L69;
            L70:
                boolean r114 = true;
            L72:
                if (r114 == false) goto L75;
                r113.encodeFloatElement(r100, 7, r112.f348295h);
            L75:
                if (r113.shouldEncodeElementDefault(r100, 8) == false) goto L78;
            L79:
                boolean r115 = true;
            L81:
                if (r115 == false) goto L84;
                r113.encodeIntElement(r100, 8, r112.f348296i);
            L84:
                if (r113.shouldEncodeElementDefault(r100, 9) == false) goto L87;
            L88:
                boolean r116 = true;
            L90:
                if (r116 == false) goto L93;
                r113.encodeIntElement(r100, 9, r112.f348297j);
            L93:
                if (r113.shouldEncodeElementDefault(r100, 10) == false) goto L96;
            L97:
                boolean r117 = true;
            L99:
                if (r117 == false) goto L102;
                r113.encodeIntElement(r100, 10, r112.f348298k);
            L102:
                if (r113.shouldEncodeElementDefault(r100, 11) == false) goto L105;
            L106:
                boolean r118 = true;
            L108:
                if (r118 == false) goto L111;
                r113.encodeIntElement(r100, 11, r112.f348299l);
            L111:
                if (r113.shouldEncodeElementDefault(r100, 12) == false) goto L114;
            L115:
                boolean r119 = true;
            L117:
                if (r119 == false) goto L120;
                r113.encodeBooleanElement(r100, 12, r112.f348300m);
            L120:
                if (r113.shouldEncodeElementDefault(r100, 13) == false) goto L123;
            L124:
                boolean r120 = true;
            L126:
                if (r120 == false) goto L129;
                r113.encodeBooleanElement(r100, 13, r112.f348301n);
            L129:
                if (r113.shouldEncodeElementDefault(r100, 14) == false) goto L132;
            L133:
                boolean r121 = true;
            L135:
                if (r121 == false) goto L138;
                r113.encodeIntElement(r100, 14, r112.f348302o);
            L138:
                if (r113.shouldEncodeElementDefault(r100, 15) == false) goto L141;
            L142:
                boolean r122 = true;
            L144:
                if (r122 == false) goto L147;
                r113.encodeBooleanElement(r100, 15, r112.f348303p);
            L147:
                if (r113.shouldEncodeElementDefault(r100, 16) == false) goto L150;
            L151:
                boolean r123 = true;
            L153:
                if (r123 == false) goto L156;
                r113.encodeIntElement(r100, 16, r112.f348304q);
            L156:
                if (r113.shouldEncodeElementDefault(r100, 17) == false) goto L159;
            L160:
                boolean r124 = true;
            L162:
                if (r124 == false) goto L165;
                r113.encodeIntElement(r100, 17, r112.f348305r);
            L165:
                if (r113.shouldEncodeElementDefault(r100, 18) == false) goto L168;
            L169:
                boolean r125 = true;
            L171:
                if (r125 == false) goto L174;
                r113.encodeBooleanElement(r100, 18, r112.f348306s);
            L174:
                if (r113.shouldEncodeElementDefault(r100, 19) == false) goto L177;
            L178:
                boolean r126 = true;
            L180:
                if (r126 == false) goto L183;
                r113.encodeBooleanElement(r100, 19, r112.f348307t);
            L183:
                if (r113.shouldEncodeElementDefault(r100, 20) == false) goto L186;
            L187:
                boolean r127 = true;
            L189:
                if (r127 == false) goto L192;
                r113.encodeBooleanElement(r100, 20, r112.f348308u);
            L192:
                if (r113.shouldEncodeElementDefault(r100, 21) == false) goto L195;
            L196:
                r102 = true;
            L197:
                if (r102 == false) goto L199;
                r113.encodeLongElement(r100, 21, r112.f348309v);
            L199:
                r113.endStructure(r100);
                return;
            L195:
                if (r112.f348309v == 2000) goto L197;
            L186:
                if (r112.f348308u != true) goto L187;
                r127 = false;
                goto L189
            L177:
                if (r112.f348307t == true) goto L178;
                r126 = false;
                goto L180
            L168:
                if (r112.f348306s == true) goto L169;
                r125 = false;
                goto L171
            L159:
                if (r112.f348305r != 0) goto L160;
                r124 = false;
                goto L162
            L150:
                if (r112.f348304q != 0) goto L151;
                r123 = false;
                goto L153
            L141:
                if (r112.f348303p == true) goto L142;
                r122 = false;
                goto L144
            L132:
                if (r112.f348302o != 20) goto L133;
                r121 = false;
                goto L135
            L123:
                if (r112.f348301n == true) goto L124;
                r120 = false;
                goto L126
            L114:
                if (r112.f348300m != true) goto L115;
                r119 = false;
                goto L117
            L105:
                if (r112.f348299l != 20) goto L106;
                r118 = false;
                goto L108
            L96:
                if (r112.f348298k != 200) goto L97;
                r117 = false;
                goto L99
            L87:
                if (r112.f348297j != 200) goto L88;
                r116 = false;
                goto L90
            L78:
                if (r112.f348296i != 400) goto L79;
                r115 = false;
                goto L81
            L69:
                if (Float.compare(r112.f348295h, 100.0f) != 0) goto L70;
                r114 = false;
                goto L72
            L60:
                if (Float.compare(r112.f348294g, 50.0f) != 0) goto L61;
                r109 = false;
                goto L63
            L51:
                if (r112.f348293f != true) goto L52;
                r108 = false;
                goto L54
            L42:
                if (Intrinsics.areEqual(r112.f348292e, w.b()) == false) goto L43;
                r107 = false;
                goto L45
            L33:
                if (Intrinsics.areEqual(r112.f348291d, CollectionsKt.emptyList()) == false) goto L34;
                r106 = false;
                goto L36
            L24:
                if (Intrinsics.areEqual(r112.f348290c, w.a()) == false) goto L25;
                r105 = false;
                goto L27
            L15:
                if (r112.f348289b != 1500) goto L16;
                r104 = false;
                goto L18
            L6:
                if (r112.f348288a != 300) goto L7;
                r103 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<a> serializer() {
                return C4354a.f348310a;
            }
        }

        public a() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f348288a == r101.f348288a) goto L12;
            return false;
        L12:
            if (this.f348289b == r101.f348289b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f348290c, r101.f348290c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f348291d, r101.f348291d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f348292e, r101.f348292e) == true) goto L24;
            return false;
        L24:
            if (this.f348293f == r101.f348293f) goto L27;
            return false;
        L27:
            if (Float.compare(this.f348294g, r101.f348294g) == 0) goto L30;
            return false;
        L30:
            if (Float.compare(this.f348295h, r101.f348295h) == 0) goto L33;
            return false;
        L33:
            if (this.f348296i == r101.f348296i) goto L36;
            return false;
        L36:
            if (this.f348297j == r101.f348297j) goto L39;
            return false;
        L39:
            if (this.f348298k == r101.f348298k) goto L42;
            return false;
        L42:
            if (this.f348299l == r101.f348299l) goto L45;
            return false;
        L45:
            if (this.f348300m == r101.f348300m) goto L48;
            return false;
        L48:
            if (this.f348301n == r101.f348301n) goto L51;
            return false;
        L51:
            if (this.f348302o == r101.f348302o) goto L54;
            return false;
        L54:
            if (this.f348303p == r101.f348303p) goto L57;
            return false;
        L57:
            if (this.f348304q == r101.f348304q) goto L60;
            return false;
        L60:
            if (this.f348305r == r101.f348305r) goto L63;
            return false;
        L63:
            if (this.f348306s == r101.f348306s) goto L66;
            return false;
        L66:
            if (this.f348307t == r101.f348307t) goto L69;
            return false;
        L69:
            if (this.f348308u == r101.f348308u) goto L72;
            return false;
        L72:
            if (this.f348309v == r101.f348309v) goto L74;
            return false;
        L74:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f348288a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f348289b;
            int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            List<Integer> r104 = this.f348290c;
            int r105 = 0;
            if (r104 != null) goto L5;
            int r106 = 0;
        L6:
            int r107 = (r103 + r106) * 31;
            List<Integer> r108 = this.f348291d;
            if (r108 != null) goto L9;
            int r109 = 0;
        L10:
            int r110 = (r107 + r109) * 31;
            Map<String, List<Integer>> r111 = this.f348292e;
            if (r111 == null) goto L14;
            r105 = r111.hashCode();
        L14:
            int r112 = (r110 + r105) * 31;
            int r113 = 1231;
            if (this.f348293f == false) goto L17;
            int r114 = 1231;
        L18:
            int r115 = (((((((((((((r112 + r114) * 31) + Float.floatToIntBits(this.f348294g)) * 31) + Float.floatToIntBits(this.f348295h)) * 31) + this.f348296i) * 31) + this.f348297j) * 31) + this.f348298k) * 31) + this.f348299l) * 31;
            if (this.f348300m == false) goto L21;
            int r116 = 1231;
        L22:
            int r117 = (r115 + r116) * 31;
            if (this.f348301n == false) goto L25;
            int r118 = 1231;
        L26:
            int r119 = (((r117 + r118) * 31) + this.f348302o) * 31;
            if (this.f348303p == false) goto L29;
            int r120 = 1231;
        L30:
            int r121 = (((((r119 + r120) * 31) + this.f348304q) * 31) + this.f348305r) * 31;
            if (this.f348306s == false) goto L33;
            int r122 = 1231;
        L34:
            int r123 = (r121 + r122) * 31;
            if (this.f348307t == false) goto L37;
            int r124 = 1231;
        L38:
            int r125 = (r123 + r124) * 31;
            if (this.f348308u == true) goto L42;
            r113 = 1237;
        L42:
            int r126 = (r125 + r113) * 31;
            long r127 = this.f348309v;
            return r126 + ((int) (r127 ^ (r127 >>> 32)));
        L37:
            r124 = 1237;
            goto L38
        L33:
            r122 = 1237;
            goto L34
        L29:
            r120 = 1237;
            goto L30
        L25:
            r118 = 1237;
            goto L26
        L21:
            r116 = 1237;
            goto L22
        L17:
            r114 = 1237;
            goto L18
        L9:
            r109 = r108.hashCode();
            goto L10
        L5:
            r106 = r104.hashCode();
            goto L6
        }

        public final String toString() {
            return "AVConfig(pseudoConnectPrepareThresholdMs=" + this.f348288a + ", pseudoConnectWindowPeriodMs=" + this.f348289b + ", messageReplayExcludeStrategy=" + this.f348290c + ", messageReplayBypassStrategy=" + this.f348291d + ", messageReplayOverrideStrategy=" + this.f348292e + ", enableStereoPlayoutGain=" + this.f348293f + ", stereoPlayLeftGainPercent=" + this.f348294g + ", stereoPlayRightGainPercent=" + this.f348295h + ", refSignalBufferMs=" + this.f348296i + ", refSignalTrimKeepMs=" + this.f348297j + ", refSignalMaxAgeMs=" + this.f348298k + ", playWriteMs=" + this.f348299l + ", enablePlayResample=" + this.f348300m + ", enableRecordReadFrameDuration=" + this.f348301n + ", recordReadFrameDurationMs=" + this.f348302o + ", enablePlayLowLatency=" + this.f348303p + ", mmtRecordSampleRate=" + this.f348304q + ", mmtPlaySampleRate=" + this.f348305r + ", enablePlayerFillSilentWhenIdle=" + this.f348306s + ", enableLowWatermarkSilencePlayout=" + this.f348307t + ", disableOmniFirstFramePublish=" + this.f348308u + ", audioPerformanceReportIntervalMs=" + this.f348309v + ')';
        }

        static {
            Companion = new b();
            LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
            f348287w = new Lazy[]{null, null, LazyKt.lazy(r100, new t()), LazyKt.lazy(r100, new u()), LazyKt.lazy(r100, new v()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};
        }

        public a(Object r100) {
            List<Integer> r101 = w.a();
            List<Integer> r102 = CollectionsKt.emptyList();
            Map<String, List<Integer>> r103 = w.b();
            this.f348288a = 300;
            this.f348289b = 1500;
            this.f348290c = r101;
            this.f348291d = r102;
            this.f348292e = r103;
            this.f348293f = true;
            this.f348294g = 50.0f;
            this.f348295h = 100.0f;
            this.f348296i = 400;
            this.f348297j = 200;
            this.f348298k = 200;
            this.f348299l = 20;
            this.f348300m = true;
            this.f348301n = false;
            this.f348302o = 20;
            this.f348303p = false;
            this.f348304q = 0;
            this.f348305r = 0;
            this.f348306s = false;
            this.f348307t = false;
            this.f348308u = true;
            this.f348309v = 2000;
        }

        public a(int r100, long r101, long r110, List r111, List r112, Map r113, boolean r114, float r115, float r116, int r117, int r118, int r210, int r211, boolean r212, boolean r213, int r214, boolean r215, int r216, int r217, boolean r218, boolean r219, boolean r310, long r311) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, C4354a.f348311b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            long r102 = 300;
        L8:
            this.f348288a = r102;
            if ((r100 & 2) != 0) goto L11;
            long r103 = 1500;
        L12:
            this.f348289b = r103;
            if ((r100 & 4) != 0) goto L15;
            List r104 = w.a();
        L16:
            this.f348290c = r104;
            if ((r100 & 8) != 0) goto L19;
            List r105 = CollectionsKt.emptyList();
        L20:
            this.f348291d = r105;
            if ((r100 & 16) != 0) goto L23;
            Map r106 = w.b();
        L24:
            this.f348292e = r106;
            if ((r100 & 32) != 0) goto L27;
            this.f348293f = true;
        L29:
            if ((r100 & 64) != 0) goto L31;
            float r107 = 50.0f;
        L32:
            this.f348294g = r107;
            if ((r100 & 128) != 0) goto L35;
            float r108 = 100.0f;
        L36:
            this.f348295h = r108;
            if ((r100 & 256) != 0) goto L39;
            int r109 = 400;
        L40:
            this.f348296i = r109;
            if ((r100 & 512) != 0) goto L43;
            this.f348297j = 200;
        L45:
            if ((r100 & 1024) != 0) goto L47;
            this.f348298k = 200;
        L49:
            if ((r100 & 2048) != 0) goto L51;
            this.f348299l = 20;
        L53:
            if ((r100 & 4096) != 0) goto L55;
            this.f348300m = true;
        L57:
            if ((r100 & 8192) != 0) goto L59;
            this.f348301n = false;
        L61:
            if ((r100 & 16384) != 0) goto L63;
            this.f348302o = 20;
        L65:
            if ((32768 & r100) != 0) goto L67;
            this.f348303p = false;
        L69:
            if ((65536 & r100) != 0) goto L71;
            this.f348304q = 0;
        L73:
            if ((131072 & r100) != 0) goto L75;
            this.f348305r = 0;
        L77:
            if ((262144 & r100) != 0) goto L79;
            this.f348306s = false;
        L81:
            if ((524288 & r100) != 0) goto L83;
            this.f348307t = false;
        L85:
            if ((1048576 & r100) != 0) goto L87;
            this.f348308u = true;
        L89:
            if ((r100 & 2097152) != 0) goto L91;
            long r119 = 2000;
        L92:
            this.f348309v = r119;
            return;
        L91:
            r119 = r311;
            goto L92
        L87:
            this.f348308u = r310;
            goto L89
        L83:
            this.f348307t = r219;
            goto L85
        L79:
            this.f348306s = r218;
            goto L81
        L75:
            this.f348305r = r217;
            goto L77
        L71:
            this.f348304q = r216;
            goto L73
        L67:
            this.f348303p = r215;
            goto L69
        L63:
            this.f348302o = r214;
            goto L65
        L59:
            this.f348301n = r213;
            goto L61
        L55:
            this.f348300m = r212;
            goto L57
        L51:
            this.f348299l = r211;
            goto L53
        L47:
            this.f348298k = r210;
            goto L49
        L43:
            this.f348297j = r118;
            goto L45
        L39:
            r109 = r117;
            goto L40
        L35:
            r108 = r116;
            goto L36
        L31:
            r107 = r115;
            goto L32
        L27:
            this.f348293f = r114;
            goto L29
        L23:
            r106 = r113;
            goto L24
        L19:
            r105 = r112;
            goto L20
        L15:
            r104 = r111;
            goto L16
        L11:
            r103 = r110;
            goto L12
        L7:
            r102 = r101;
            goto L8
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    @Serializable
    public static final class b {
        public static final C4355b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f348312a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f348313b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f348314c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f348315d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f348316e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f348317f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f348318g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f348319h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f348320i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f348321j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final float f348322k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f348323l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f348324m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f348325n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final int f348326o;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<b> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348327a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348328b = null;

            public a() {
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348328b;
            }

            static {
                a r100 = new a();
                f348327a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowAudioSettingsDelegate.AVConnectConfig", r100, 15);
                r101.j("quic_connect_retry_count", true);
                r101.j("quic_connect_retry_duration_ms", true);
                r101.j("quic_connect_retry_duration_factor", true);
                r101.j("quic_interpret_connect_retry_count", true);
                r101.j("start_session_timeout_ms", true);
                r101.j("session_started_timeout_ms", true);
                r101.j("enable_create_room_start_session_retry_android", true);
                r101.j("enable_network_recovery_reconnect_android", true);
                r101.j("quic_reconnecting_max_count", true);
                r101.j("quic_reconnecting_duration_ms", true);
                r101.j("quic_reconnecting_duration_factor", true);
                r101.j("get_rtc_token_retry_count_limit", true);
                r101.j("get_rtc_token_retry_interval", true);
                r101.j("rest_token_count", true);
                r101.j("batch_get_token_count", true);
                f348328b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                nuc.w0 r100 = nuc.w0.f520792a;
                nuc.l0 r101 = nuc.l0.f520731a;
                nuc.i r102 = nuc.i.f520705a;
                return new juc.d[]{r100, r100, r101, r100, r100, r100, r102, r102, r100, r100, r101, r100, r100, r100, r100};
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r310) {
                Intrinsics.checkNotNullParameter(r310, "decoder");
                g2 r100 = f348328b;
                muc.c r101 = r310.beginStructure(r100);
                int r102 = 3;
                if (r101.decodeSequentially() == false) goto L5;
                int r103 = r101.decodeIntElement(r100, 0);
                int r104 = r101.decodeIntElement(r100, 1);
                float r105 = r101.decodeFloatElement(r100, 2);
                int r106 = r101.decodeIntElement(r100, 3);
                int r107 = r101.decodeIntElement(r100, 4);
                int r108 = r101.decodeIntElement(r100, 5);
                boolean r109 = r101.decodeBooleanElement(r100, 6);
                boolean r110 = r101.decodeBooleanElement(r100, 7);
                int r111 = r101.decodeIntElement(r100, 8);
                int r112 = r101.decodeIntElement(r100, 9);
                float r113 = r101.decodeFloatElement(r100, 10);
                int r114 = r101.decodeIntElement(r100, 11);
                int r115 = r101.decodeIntElement(r100, 12);
                int r116 = r101.decodeIntElement(r100, 13);
                int r117 = r111;
                int r210 = r101.decodeIntElement(r100, 14);
                int r211 = r115;
                int r212 = r114;
                float r213 = r113;
                int r214 = r112;
                boolean r118 = r110;
                int r215 = r116;
                boolean r119 = r109;
                int r120 = 32767;
                int r121 = r103;
                int r122 = r106;
                int r123 = r108;
                float r124 = r105;
                int r125 = r107;
                int r126 = r104;
            L30:
                r101.endStructure(r100);
                return new b(r120, r121, r126, r124, r122, r125, r123, r119, r118, r117, r214, r213, r212, r211, r215, r210);
            L5:
                int r127 = 0;
                int r128 = 0;
                int r129 = 0;
                int r130 = 0;
                float r216 = 0.0f;
                int r217 = 0;
                int r218 = 0;
                int r219 = 0;
                boolean r220 = false;
                r210 = 0;
                int r221 = 0;
                int r222 = 0;
                float r223 = 0.0f;
                int r224 = 0;
                boolean r311 = false;
                int r312 = 0;
                boolean r313 = true;
            L6:
                if (r313 == false) goto L29;
                int r131 = r101.decodeElementIndex(r100);
                switch(r131) {
                    case -1: goto L28;
                    case 0: goto L26;
                    case 1: goto L25;
                    case 2: goto L23;
                    case 3: goto L22;
                    case 4: goto L21;
                    case 5: goto L20;
                    case 6: goto L19;
                    case 7: goto L18;
                    case 8: goto L17;
                    case 9: goto L16;
                    case 10: goto L15;
                    case 11: goto L14;
                    case 12: goto L13;
                    case 13: goto L12;
                    case 14: goto L11;
                    default: goto L10;
                };
            L10:
                throw new UnknownFieldException(r131);
            L28:
                r102 = 3;
                r313 = false;
                goto L6
            L11:
                r210 = r101.decodeIntElement(r100, 14);
                r127 = r127 | 16384;
            L27:
                r102 = 3;
                goto L6
            L12:
                r312 = r101.decodeIntElement(r100, 13);
                r127 = r127 | 8192;
                goto L27
            L13:
                r221 = r101.decodeIntElement(r100, 12);
                r127 = r127 | 4096;
                goto L27
            L14:
                r222 = r101.decodeIntElement(r100, 11);
                r127 = r127 | 2048;
                goto L27
            L15:
                r223 = r101.decodeFloatElement(r100, 10);
                r127 = r127 | 1024;
                goto L27
            L16:
                r224 = r101.decodeIntElement(r100, 9);
                r127 = r127 | 512;
                goto L27
            L17:
                r218 = r101.decodeIntElement(r100, 8);
                r127 = r127 | 256;
                goto L27
            L18:
                r311 = r101.decodeBooleanElement(r100, 7);
                r127 = r127 | 128;
                goto L27
            L19:
                r220 = r101.decodeBooleanElement(r100, 6);
                r127 = r127 | 64;
                goto L27
            L20:
                r130 = r101.decodeIntElement(r100, 5);
                r127 = r127 | 32;
                goto L27
            L21:
                r217 = r101.decodeIntElement(r100, 4);
                r127 = r127 | 16;
                goto L27
            L22:
                r129 = r101.decodeIntElement(r100, r102);
                r127 = r127 | 8;
                goto L27
            L23:
                r216 = r101.decodeFloatElement(r100, 2);
                r127 = r127 | 4;
                goto L27
            L25:
                r219 = r101.decodeIntElement(r100, 1);
                r127 = r127 | 2;
                goto L27
            L26:
                r128 = r101.decodeIntElement(r100, 0);
                r127 = r127 | 1;
                goto L27
            L29:
                r120 = r127;
                r121 = r128;
                r122 = r129;
                r123 = r130;
                r124 = r216;
                r125 = r217;
                r117 = r218;
                r126 = r219;
                r119 = r220;
                r211 = r221;
                r212 = r222;
                r213 = r223;
                r214 = r224;
                r118 = r311;
                r215 = r312;
                goto L30
            }

            @Override // juc.n
            public final void serialize(muc.f r110, Object r111) {
                b r112 = (b) r111;
                Intrinsics.checkNotNullParameter(r110, "encoder");
                Intrinsics.checkNotNullParameter(r112, "value");
                g2 r100 = f348328b;
                muc.d r113 = r110.beginStructure(r100);
                C4355b r101 = b.Companion;
                boolean r102 = false;
                if (r113.shouldEncodeElementDefault(r100, 0) == false) goto L6;
            L7:
                boolean r103 = true;
            L9:
                if (r103 == false) goto L12;
                r113.encodeIntElement(r100, 0, r112.f348312a);
            L12:
                if (r113.shouldEncodeElementDefault(r100, 1) == false) goto L15;
            L16:
                boolean r104 = true;
            L18:
                if (r104 == false) goto L21;
                r113.encodeIntElement(r100, 1, r112.f348313b);
            L21:
                if (r113.shouldEncodeElementDefault(r100, 2) == false) goto L24;
            L25:
                boolean r105 = true;
            L27:
                if (r105 == false) goto L30;
                r113.encodeFloatElement(r100, 2, r112.f348314c);
            L30:
                if (r113.shouldEncodeElementDefault(r100, 3) == false) goto L33;
            L34:
                boolean r106 = true;
            L36:
                if (r106 == false) goto L39;
                r113.encodeIntElement(r100, 3, r112.f348315d);
            L39:
                if (r113.shouldEncodeElementDefault(r100, 4) == false) goto L42;
            L43:
                boolean r107 = true;
            L45:
                if (r107 == false) goto L48;
                r113.encodeIntElement(r100, 4, r112.f348316e);
            L48:
                if (r113.shouldEncodeElementDefault(r100, 5) == false) goto L51;
            L52:
                boolean r108 = true;
            L54:
                if (r108 == false) goto L57;
                r113.encodeIntElement(r100, 5, r112.f348317f);
            L57:
                if (r113.shouldEncodeElementDefault(r100, 6) == false) goto L60;
            L61:
                boolean r109 = true;
            L63:
                if (r109 == false) goto L66;
                r113.encodeBooleanElement(r100, 6, r112.f348318g);
            L66:
                if (r113.shouldEncodeElementDefault(r100, 7) == false) goto L69;
            L70:
                boolean r114 = true;
            L72:
                if (r114 == false) goto L75;
                r113.encodeBooleanElement(r100, 7, r112.f348319h);
            L75:
                if (r113.shouldEncodeElementDefault(r100, 8) == false) goto L78;
            L79:
                boolean r115 = true;
            L81:
                if (r115 == false) goto L84;
                r113.encodeIntElement(r100, 8, r112.f348320i);
            L84:
                if (r113.shouldEncodeElementDefault(r100, 9) == false) goto L87;
            L88:
                boolean r116 = true;
            L90:
                if (r116 == false) goto L93;
                r113.encodeIntElement(r100, 9, r112.f348321j);
            L93:
                if (r113.shouldEncodeElementDefault(r100, 10) == false) goto L96;
            L97:
                boolean r117 = true;
            L99:
                if (r117 == false) goto L102;
                r113.encodeFloatElement(r100, 10, r112.f348322k);
            L102:
                if (r113.shouldEncodeElementDefault(r100, 11) == false) goto L105;
            L106:
                boolean r118 = true;
            L108:
                if (r118 == false) goto L111;
                r113.encodeIntElement(r100, 11, r112.f348323l);
            L111:
                if (r113.shouldEncodeElementDefault(r100, 12) == false) goto L114;
            L115:
                boolean r119 = true;
            L117:
                if (r119 == false) goto L120;
                r113.encodeIntElement(r100, 12, r112.f348324m);
            L120:
                if (r113.shouldEncodeElementDefault(r100, 13) == false) goto L123;
            L124:
                boolean r120 = true;
            L126:
                if (r120 == false) goto L129;
                r113.encodeIntElement(r100, 13, r112.f348325n);
            L129:
                if (r113.shouldEncodeElementDefault(r100, 14) == false) goto L132;
            L133:
                r102 = true;
            L134:
                if (r102 == false) goto L136;
                r113.encodeIntElement(r100, 14, r112.f348326o);
            L136:
                r113.endStructure(r100);
                return;
            L132:
                if (r112.f348326o == 5) goto L134;
            L123:
                if (r112.f348325n != 3) goto L124;
                r120 = false;
                goto L126
            L114:
                if (r112.f348324m != 1) goto L115;
                r119 = false;
                goto L117
            L105:
                if (r112.f348323l != 2) goto L106;
                r118 = false;
                goto L108
            L96:
                if (Float.compare(r112.f348322k, 0.0f) != 0) goto L97;
                r117 = false;
                goto L99
            L87:
                if (r112.f348321j != 2000) goto L88;
                r116 = false;
                goto L90
            L78:
                if (r112.f348320i != 30) goto L79;
                r115 = false;
                goto L81
            L69:
                if (r112.f348319h == true) goto L70;
                r114 = false;
                goto L72
            L60:
                if (r112.f348318g == true) goto L61;
                r109 = false;
                goto L63
            L51:
                if (r112.f348317f != 5000) goto L52;
                r108 = false;
                goto L54
            L42:
                if (r112.f348316e != 72000) goto L43;
                r107 = false;
                goto L45
            L33:
                if (r112.f348315d != 10) goto L34;
                r106 = false;
                goto L36
            L24:
                if (Float.compare(r112.f348314c, 0.0f) != 0) goto L25;
                r105 = false;
                goto L27
            L15:
                if (r112.f348313b != 500) goto L16;
                r104 = false;
                goto L18
            L6:
                if (r112.f348312a != 3) goto L7;
                r103 = false;
                goto L9
            }
        }

        /* JADX INFO: renamed from: com.larus.im.internal.delegate.w$b$b, reason: collision with other inner class name */
        public static final class C4355b {
            public C4355b() {
            }

            public final juc.d<b> serializer() {
                return a.f348327a;
            }
        }

        public b() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f348312a == r101.f348312a) goto L12;
            return false;
        L12:
            if (this.f348313b == r101.f348313b) goto L15;
            return false;
        L15:
            if (Float.compare(this.f348314c, r101.f348314c) == 0) goto L18;
            return false;
        L18:
            if (this.f348315d == r101.f348315d) goto L21;
            return false;
        L21:
            if (this.f348316e == r101.f348316e) goto L24;
            return false;
        L24:
            if (this.f348317f == r101.f348317f) goto L27;
            return false;
        L27:
            if (this.f348318g == r101.f348318g) goto L30;
            return false;
        L30:
            if (this.f348319h == r101.f348319h) goto L33;
            return false;
        L33:
            if (this.f348320i == r101.f348320i) goto L36;
            return false;
        L36:
            if (this.f348321j == r101.f348321j) goto L39;
            return false;
        L39:
            if (Float.compare(this.f348322k, r101.f348322k) == 0) goto L42;
            return false;
        L42:
            if (this.f348323l == r101.f348323l) goto L45;
            return false;
        L45:
            if (this.f348324m == r101.f348324m) goto L48;
            return false;
        L48:
            if (this.f348325n == r101.f348325n) goto L51;
            return false;
        L51:
            if (this.f348326o == r101.f348326o) goto L53;
            return false;
        L53:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((((((this.f348312a * 31) + this.f348313b) * 31) + Float.floatToIntBits(this.f348314c)) * 31) + this.f348315d) * 31) + this.f348316e) * 31) + this.f348317f) * 31;
            int r101 = 1231;
            if (this.f348318g == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f348319h == true) goto L11;
            r101 = 1237;
        L11:
            return ((((((((((((((r103 + r101) * 31) + this.f348320i) * 31) + this.f348321j) * 31) + Float.floatToIntBits(this.f348322k)) * 31) + this.f348323l) * 31) + this.f348324m) * 31) + this.f348325n) * 31) + this.f348326o;
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "AVConnectConfig(quicConnectRetryCount=" + this.f348312a + ", quicConnectRetryDurationMs=" + this.f348313b + ", quicConnectRetryDurationFactor=" + this.f348314c + ", quicInterpretConnectRetryCount=" + this.f348315d + ", startSessionTimeoutMs=" + this.f348316e + ", sessionStartedTimeoutMs=" + this.f348317f + ", enableCreateRoomStartSessionRetryAndroid=" + this.f348318g + ", enableNetworkRecoveryReconnectAndroid=" + this.f348319h + ", quicReconnectingMaxCount=" + this.f348320i + ", quicReconnectingDurationMs=" + this.f348321j + ", quicReconnectingDurationFactor=" + this.f348322k + ", getRTCTokenRetryCountLimit=" + this.f348323l + ", getRTCTokenRetryInterval=" + this.f348324m + ", restTokenCount=" + this.f348325n + ", batchGetTokenCount=" + this.f348326o + ')';
        }

        static {
            Companion = new C4355b();
        }

        public b(int r100) {
            this.f348312a = 3;
            this.f348313b = 500;
            this.f348314c = 0.0f;
            this.f348315d = 10;
            this.f348316e = 72000;
            this.f348317f = 5000;
            this.f348318g = false;
            this.f348319h = false;
            this.f348320i = 30;
            this.f348321j = 2000;
            this.f348322k = 0.0f;
            this.f348323l = 2;
            this.f348324m = 1;
            this.f348325n = 3;
            this.f348326o = 5;
        }

        public b(int r100, int r101, int r102, float r110, int r111, int r112, int r113, boolean r114, boolean r115, int r116, int r117, float r118, int r119, int r210, int r211, int r212) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348328b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            this.f348312a = 3;
        L9:
            if ((r100 & 2) != 0) goto L11;
            int r103 = 500;
        L12:
            this.f348313b = r103;
            if ((r100 & 4) != 0) goto L15;
            this.f348314c = 0.0f;
        L17:
            if ((r100 & 8) != 0) goto L19;
            int r104 = 10;
        L20:
            this.f348315d = r104;
            if ((r100 & 16) != 0) goto L23;
            int r105 = 72000;
        L24:
            this.f348316e = r105;
            if ((r100 & 32) != 0) goto L27;
            int r106 = 5000;
        L28:
            this.f348317f = r106;
            if ((r100 & 64) != 0) goto L31;
            this.f348318g = false;
        L33:
            if ((r100 & 128) != 0) goto L35;
            this.f348319h = false;
        L37:
            if ((r100 & 256) != 0) goto L39;
            int r107 = 30;
        L40:
            this.f348320i = r107;
            if ((r100 & 512) != 0) goto L43;
            int r108 = 2000;
        L44:
            this.f348321j = r108;
            if ((r100 & 1024) != 0) goto L47;
            this.f348322k = 0.0f;
        L49:
            if ((r100 & 2048) != 0) goto L51;
            int r109 = 2;
        L52:
            this.f348323l = r109;
            if ((r100 & 4096) != 0) goto L55;
            int r120 = 1;
        L56:
            this.f348324m = r120;
            if ((r100 & 8192) != 0) goto L59;
            this.f348325n = 3;
        L61:
            if ((r100 & 16384) != 0) goto L63;
            int r121 = 5;
        L64:
            this.f348326o = r121;
            return;
        L63:
            r121 = r212;
            goto L64
        L59:
            this.f348325n = r211;
            goto L61
        L55:
            r120 = r210;
            goto L56
        L51:
            r109 = r119;
            goto L52
        L47:
            this.f348322k = r118;
            goto L49
        L43:
            r108 = r117;
            goto L44
        L39:
            r107 = r116;
            goto L40
        L35:
            this.f348319h = r115;
            goto L37
        L31:
            this.f348318g = r114;
            goto L33
        L27:
            r106 = r113;
            goto L28
        L23:
            r105 = r112;
            goto L24
        L19:
            r104 = r111;
            goto L20
        L15:
            this.f348314c = r110;
            goto L17
        L11:
            r103 = r102;
            goto L12
        L7:
            this.f348312a = r101;
            goto L9
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    @Serializable
    public static final class c {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f348329a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f348330b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f348331c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f348332d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f348333e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f348334f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f348335g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f348336h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f348337i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f348338j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final boolean f348339k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final boolean f348340l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final boolean f348341m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final boolean f348342n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final boolean f348343o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final boolean f348344p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final boolean f348345q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final boolean f348346r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final j f348347s;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<c> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348348a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348349b = null;

            public a() {
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348349b;
            }

            static {
                a r100 = new a();
                f348348a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowAudioSettingsDelegate.AVFixConfig", r100, 19);
                r101.j("enable_sender_pool", true);
                r101.j("enable_rtc_engine_pool", true);
                r101.j("enable_async_engine_creation", true);
                r101.j("enable_skip_async_engine_creation_on_worker", true);
                r101.j("enable_async_cache_rtc_did", true);
                r101.j("engine_destroy_delay_ms", true);
                r101.j("obtain_engine_on_other_destroy", true);
                r101.j("disable_downgrade_config", true);
                r101.j("defer_unstarted_session_destroy", true);
                r101.j("fix_quic_early_stop_invoke", true);
                r101.j("fix_dora_auto_publish_audio", true);
                r101.j("disable_rtc_aigc_callback_with_code", true);
                r101.j("fix_rtc_join_leave_room_sync", true);
                r101.j("fix_rtc_leave_room_invoke", true);
                r101.j("reset_loudness_on_first_frame", true);
                r101.j("enable_finish_session_stats", true);
                r101.j("fix_omni_audio_engine_release_in_session", true);
                r101.j("enable_rtc_lazy_init", true);
                r101.j("omni_recorder_silent_restart_config", true);
                f348349b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                nuc.i r100 = nuc.i.f520705a;
                return new juc.d[]{r100, r100, r100, r100, r100, nuc.g1.f520681a, r100, r100, r100, r100, r100, r100, r100, r100, r100, r100, r100, r100, kuc.a.d(j.a.f348397a)};
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r410) {
                Intrinsics.checkNotNullParameter(r410, "decoder");
                g2 r100 = f348349b;
                muc.c r101 = r410.beginStructure(r100);
                int r102 = 11;
                if (r101.decodeSequentially() == false) goto L5;
                boolean r103 = r101.decodeBooleanElement(r100, 0);
                boolean r110 = r101.decodeBooleanElement(r100, 1);
                boolean r111 = r101.decodeBooleanElement(r100, 2);
                boolean r104 = r101.decodeBooleanElement(r100, 3);
                boolean r112 = r101.decodeBooleanElement(r100, 4);
                long r210 = r101.decodeLongElement(r100, 5);
                boolean r105 = r101.decodeBooleanElement(r100, 6);
                boolean r106 = r101.decodeBooleanElement(r100, 7);
                boolean r107 = r101.decodeBooleanElement(r100, 8);
                boolean r108 = r101.decodeBooleanElement(r100, 9);
                boolean r109 = r101.decodeBooleanElement(r100, 10);
                boolean r113 = r101.decodeBooleanElement(r100, 11);
                boolean r114 = r101.decodeBooleanElement(r100, 12);
                boolean r115 = r101.decodeBooleanElement(r100, 13);
                boolean r116 = r101.decodeBooleanElement(r100, 14);
                boolean r117 = r101.decodeBooleanElement(r100, 15);
                boolean r118 = r101.decodeBooleanElement(r100, 16);
                boolean r119 = r101.decodeBooleanElement(r100, 17);
                int r120 = 524287;
                boolean r121 = r110;
                j r310 = (j) r101.decodeNullableSerializableElement(r100, 18, j.a.f348397a, null);
                boolean r211 = r113;
                boolean r212 = r108;
                boolean r213 = r109;
                boolean r214 = r107;
                boolean r215 = r114;
                boolean r216 = r115;
                boolean r311 = r119;
                boolean r312 = r118;
                boolean r313 = r117;
                boolean r122 = r103;
                boolean r314 = r116;
                long r217 = r210;
                boolean r218 = r105;
                boolean r219 = r106;
                boolean r123 = r104;
                boolean r124 = r111;
                boolean r125 = r112;
            L38:
                r101.endStructure(r100);
                return new c(r120, r122, r121, r124, r123, r125, r217, r218, r219, r214, r212, r213, r211, r215, r216, r314, r313, r312, r311, r310);
            L5:
                int r126 = 18;
                long r315 = 0;
                int r127 = 0;
                j r128 = null;
                boolean r129 = false;
                boolean r220 = false;
                boolean r221 = false;
                boolean r222 = false;
                boolean r223 = false;
                boolean r224 = false;
                boolean r225 = false;
                boolean r226 = false;
                boolean r227 = false;
                boolean r316 = false;
                boolean r317 = false;
                boolean r318 = false;
                boolean r319 = false;
                boolean r320 = false;
                boolean r321 = false;
                boolean r322 = false;
                boolean r323 = false;
                boolean r411 = true;
            L6:
                if (r411 == false) goto L37;
                int r130 = r101.decodeElementIndex(r100);
                switch(r130) {
                    case -1: goto L36;
                    case 0: goto L34;
                    case 1: goto L32;
                    case 2: goto L30;
                    case 3: goto L29;
                    case 4: goto L28;
                    case 5: goto L27;
                    case 6: goto L26;
                    case 7: goto L25;
                    case 8: goto L24;
                    case 9: goto L23;
                    case 10: goto L22;
                    case 11: goto L21;
                    case 12: goto L20;
                    case 13: goto L19;
                    case 14: goto L17;
                    case 15: goto L15;
                    case 16: goto L14;
                    case 17: goto L12;
                    case 18: goto L11;
                    default: goto L10;
                };
            L10:
                throw new UnknownFieldException(r130);
            L14:
                r221 = r101.decodeBooleanElement(r100, 16);
                r127 = r127 | 65536;
            L35:
                r102 = 11;
                r126 = 18;
                goto L6
            L15:
                r222 = r101.decodeBooleanElement(r100, 15);
                r127 = r127 | 32768;
                goto L35
            L17:
                r323 = r101.decodeBooleanElement(r100, 14);
                r127 = r127 | 16384;
                goto L35
            L19:
                r319 = r101.decodeBooleanElement(r100, 13);
                r127 = r127 | 8192;
                goto L35
            L20:
                r318 = r101.decodeBooleanElement(r100, 12);
                r127 = r127 | 4096;
                goto L35
            L21:
                r223 = r101.decodeBooleanElement(r100, r102);
                r127 = r127 | 2048;
                goto L35
            L22:
                r316 = r101.decodeBooleanElement(r100, 10);
                r127 = r127 | 1024;
                goto L35
            L23:
                r224 = r101.decodeBooleanElement(r100, 9);
                r127 = r127 | 512;
                goto L35
            L24:
                r317 = r101.decodeBooleanElement(r100, 8);
                r127 = r127 | 256;
                goto L35
            L25:
                r226 = r101.decodeBooleanElement(r100, 7);
                r127 = r127 | 128;
                goto L35
            L26:
                r225 = r101.decodeBooleanElement(r100, 6);
                r127 = r127 | 64;
                goto L35
            L27:
                r315 = r101.decodeLongElement(r100, 5);
                r127 = r127 | 32;
                goto L35
            L28:
                r321 = r101.decodeBooleanElement(r100, 4);
                r127 = r127 | 16;
                goto L35
            L29:
                r227 = r101.decodeBooleanElement(r100, 3);
                r127 = r127 | 8;
                goto L35
            L30:
                r320 = r101.decodeBooleanElement(r100, 2);
                r127 = r127 | 4;
                goto L35
            L32:
                r322 = r101.decodeBooleanElement(r100, 1);
                r127 = r127 | 2;
                goto L35
            L34:
                r129 = r101.decodeBooleanElement(r100, 0);
                r127 = r127 | 1;
                goto L35
            L36:
                r102 = 11;
                r126 = 18;
                r411 = false;
                goto L6
            L11:
                r127 = r127 | 262144;
                r128 = (j) r101.decodeNullableSerializableElement(r100, r126, j.a.f348397a, r128);
                goto L6
            L12:
                r220 = r101.decodeBooleanElement(r100, 17);
                r127 = r127 | 131072;
                goto L6
            L37:
                r122 = r129;
                r123 = r227;
                r216 = r319;
                r124 = r320;
                r125 = r321;
                r121 = r322;
                r217 = r315;
                r310 = r128;
                r311 = r220;
                r218 = r225;
                r120 = r127;
                r211 = r223;
                r212 = r224;
                r213 = r316;
                r314 = r323;
                boolean r412 = r318;
                r312 = r221;
                r219 = r226;
                r215 = r412;
                boolean r413 = r317;
                r313 = r222;
                r214 = r413;
                goto L38
            }

            @Override // juc.n
            public final void serialize(muc.f r110, Object r111) {
                c r112 = (c) r111;
                Intrinsics.checkNotNullParameter(r110, "encoder");
                Intrinsics.checkNotNullParameter(r112, "value");
                g2 r100 = f348349b;
                muc.d r113 = r110.beginStructure(r100);
                b r101 = c.Companion;
                boolean r102 = false;
                if (r113.shouldEncodeElementDefault(r100, 0) == false) goto L6;
            L7:
                boolean r103 = true;
            L9:
                if (r103 == false) goto L12;
                r113.encodeBooleanElement(r100, 0, r112.f348329a);
            L12:
                if (r113.shouldEncodeElementDefault(r100, 1) == false) goto L15;
            L16:
                boolean r104 = true;
            L18:
                if (r104 == false) goto L21;
                r113.encodeBooleanElement(r100, 1, r112.f348330b);
            L21:
                if (r113.shouldEncodeElementDefault(r100, 2) == false) goto L24;
            L25:
                boolean r105 = true;
            L27:
                if (r105 == false) goto L30;
                r113.encodeBooleanElement(r100, 2, r112.f348331c);
            L30:
                if (r113.shouldEncodeElementDefault(r100, 3) == false) goto L33;
            L34:
                boolean r106 = true;
            L36:
                if (r106 == false) goto L39;
                r113.encodeBooleanElement(r100, 3, r112.f348332d);
            L39:
                if (r113.shouldEncodeElementDefault(r100, 4) == false) goto L42;
            L43:
                boolean r107 = true;
            L45:
                if (r107 == false) goto L48;
                r113.encodeBooleanElement(r100, 4, r112.f348333e);
            L48:
                if (r113.shouldEncodeElementDefault(r100, 5) == false) goto L51;
            L52:
                boolean r108 = true;
            L54:
                if (r108 == false) goto L57;
                r113.encodeLongElement(r100, 5, r112.f348334f);
            L57:
                if (r113.shouldEncodeElementDefault(r100, 6) == false) goto L60;
            L61:
                boolean r109 = true;
            L63:
                if (r109 == false) goto L66;
                r113.encodeBooleanElement(r100, 6, r112.f348335g);
            L66:
                if (r113.shouldEncodeElementDefault(r100, 7) == false) goto L69;
            L70:
                boolean r114 = true;
            L72:
                if (r114 == false) goto L75;
                r113.encodeBooleanElement(r100, 7, r112.f348336h);
            L75:
                if (r113.shouldEncodeElementDefault(r100, 8) == false) goto L78;
            L79:
                boolean r115 = true;
            L81:
                if (r115 == false) goto L84;
                r113.encodeBooleanElement(r100, 8, r112.f348337i);
            L84:
                if (r113.shouldEncodeElementDefault(r100, 9) == false) goto L87;
            L88:
                boolean r116 = true;
            L90:
                if (r116 == false) goto L93;
                r113.encodeBooleanElement(r100, 9, r112.f348338j);
            L93:
                if (r113.shouldEncodeElementDefault(r100, 10) == false) goto L96;
            L97:
                boolean r117 = true;
            L99:
                if (r117 == false) goto L102;
                r113.encodeBooleanElement(r100, 10, r112.f348339k);
            L102:
                if (r113.shouldEncodeElementDefault(r100, 11) == false) goto L105;
            L106:
                boolean r118 = true;
            L108:
                if (r118 == false) goto L111;
                r113.encodeBooleanElement(r100, 11, r112.f348340l);
            L111:
                if (r113.shouldEncodeElementDefault(r100, 12) == false) goto L114;
            L115:
                boolean r119 = true;
            L117:
                if (r119 == false) goto L120;
                r113.encodeBooleanElement(r100, 12, r112.f348341m);
            L120:
                if (r113.shouldEncodeElementDefault(r100, 13) == false) goto L123;
            L124:
                boolean r120 = true;
            L126:
                if (r120 == false) goto L129;
                r113.encodeBooleanElement(r100, 13, r112.f348342n);
            L129:
                if (r113.shouldEncodeElementDefault(r100, 14) == false) goto L132;
            L133:
                boolean r121 = true;
            L135:
                if (r121 == false) goto L138;
                r113.encodeBooleanElement(r100, 14, r112.f348343o);
            L138:
                if (r113.shouldEncodeElementDefault(r100, 15) == false) goto L141;
            L142:
                boolean r122 = true;
            L144:
                if (r122 == false) goto L147;
                r113.encodeBooleanElement(r100, 15, r112.f348344p);
            L147:
                if (r113.shouldEncodeElementDefault(r100, 16) == false) goto L150;
            L151:
                boolean r123 = true;
            L153:
                if (r123 == false) goto L156;
                r113.encodeBooleanElement(r100, 16, r112.f348345q);
            L156:
                if (r113.shouldEncodeElementDefault(r100, 17) == false) goto L159;
            L160:
                boolean r124 = true;
            L162:
                if (r124 == false) goto L165;
                r113.encodeBooleanElement(r100, 17, r112.f348346r);
            L165:
                if (r113.shouldEncodeElementDefault(r100, 18) == false) goto L168;
            L169:
                r102 = true;
            L170:
                if (r102 == false) goto L172;
                r113.encodeNullableSerializableElement(r100, 18, j.a.f348397a, r112.f348347s);
            L172:
                r113.endStructure(r100);
                return;
            L168:
                if (Intrinsics.areEqual(r112.f348347s, new j(0)) == true) goto L170;
            L159:
                if (r112.f348346r != true) goto L160;
                r124 = false;
                goto L162
            L150:
                if (r112.f348345q != true) goto L151;
                r123 = false;
                goto L153
            L141:
                if (r112.f348344p != true) goto L142;
                r122 = false;
                goto L144
            L132:
                if (r112.f348343o != true) goto L133;
                r121 = false;
                goto L135
            L123:
                if (r112.f348342n != true) goto L124;
                r120 = false;
                goto L126
            L114:
                if (r112.f348341m != true) goto L115;
                r119 = false;
                goto L117
            L105:
                if (r112.f348340l == true) goto L106;
                r118 = false;
                goto L108
            L96:
                if (r112.f348339k != true) goto L97;
                r117 = false;
                goto L99
            L87:
                if (r112.f348338j != true) goto L88;
                r116 = false;
                goto L90
            L78:
                if (r112.f348337i != true) goto L79;
                r115 = false;
                goto L81
            L69:
                if (r112.f348336h == true) goto L70;
                r114 = false;
                goto L72
            L60:
                if (r112.f348335g == true) goto L61;
                r109 = false;
                goto L63
            L51:
                if (r112.f348334f != 0) goto L52;
                r108 = false;
                goto L54
            L42:
                if (r112.f348333e != true) goto L43;
                r107 = false;
                goto L45
            L33:
                if (r112.f348332d != true) goto L34;
                r106 = false;
                goto L36
            L24:
                if (r112.f348331c != true) goto L25;
                r105 = false;
                goto L27
            L15:
                if (r112.f348330b != true) goto L16;
                r104 = false;
                goto L18
            L6:
                if (r112.f348329a != true) goto L7;
                r103 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<c> serializer() {
                return a.f348348a;
            }
        }

        public c() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f348329a == r101.f348329a) goto L12;
            return false;
        L12:
            if (this.f348330b == r101.f348330b) goto L15;
            return false;
        L15:
            if (this.f348331c == r101.f348331c) goto L18;
            return false;
        L18:
            if (this.f348332d == r101.f348332d) goto L21;
            return false;
        L21:
            if (this.f348333e == r101.f348333e) goto L24;
            return false;
        L24:
            if (this.f348334f == r101.f348334f) goto L27;
            return false;
        L27:
            if (this.f348335g == r101.f348335g) goto L30;
            return false;
        L30:
            if (this.f348336h == r101.f348336h) goto L33;
            return false;
        L33:
            if (this.f348337i == r101.f348337i) goto L36;
            return false;
        L36:
            if (this.f348338j == r101.f348338j) goto L39;
            return false;
        L39:
            if (this.f348339k == r101.f348339k) goto L42;
            return false;
        L42:
            if (this.f348340l == r101.f348340l) goto L45;
            return false;
        L45:
            if (this.f348341m == r101.f348341m) goto L48;
            return false;
        L48:
            if (this.f348342n == r101.f348342n) goto L51;
            return false;
        L51:
            if (this.f348343o == r101.f348343o) goto L54;
            return false;
        L54:
            if (this.f348344p == r101.f348344p) goto L57;
            return false;
        L57:
            if (this.f348345q == r101.f348345q) goto L60;
            return false;
        L60:
            if (this.f348346r == r101.f348346r) goto L63;
            return false;
        L63:
            if (Intrinsics.areEqual(this.f348347s, r101.f348347s) == true) goto L65;
            return false;
        L65:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f348329a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f348330b == false) goto L9;
            int r103 = 1231;
        L10:
            int r104 = (r102 + r103) * 31;
            if (this.f348331c == false) goto L13;
            int r105 = 1231;
        L14:
            int r106 = (r104 + r105) * 31;
            if (this.f348332d == false) goto L17;
            int r107 = 1231;
        L18:
            int r108 = (r106 + r107) * 31;
            if (this.f348333e == false) goto L21;
            int r109 = 1231;
        L22:
            int r110 = (r108 + r109) * 31;
            long r111 = this.f348334f;
            int r112 = (r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31;
            if (this.f348335g == false) goto L25;
            int r113 = 1231;
        L26:
            int r114 = (r112 + r113) * 31;
            if (this.f348336h == false) goto L29;
            int r115 = 1231;
        L30:
            int r116 = (r114 + r115) * 31;
            if (this.f348337i == false) goto L33;
            int r117 = 1231;
        L34:
            int r118 = (r116 + r117) * 31;
            if (this.f348338j == false) goto L37;
            int r119 = 1231;
        L38:
            int r120 = (r118 + r119) * 31;
            if (this.f348339k == false) goto L41;
            int r121 = 1231;
        L42:
            int r122 = (r120 + r121) * 31;
            if (this.f348340l == false) goto L45;
            int r123 = 1231;
        L46:
            int r124 = (r122 + r123) * 31;
            if (this.f348341m == false) goto L49;
            int r125 = 1231;
        L50:
            int r126 = (r124 + r125) * 31;
            if (this.f348342n == false) goto L53;
            int r127 = 1231;
        L54:
            int r128 = (r126 + r127) * 31;
            if (this.f348343o == false) goto L57;
            int r129 = 1231;
        L58:
            int r130 = (r128 + r129) * 31;
            if (this.f348344p == false) goto L61;
            int r131 = 1231;
        L62:
            int r132 = (r130 + r131) * 31;
            if (this.f348345q == false) goto L65;
            int r133 = 1231;
        L66:
            int r134 = (r132 + r133) * 31;
            if (this.f348346r == true) goto L70;
            r100 = 1237;
        L70:
            int r135 = (r134 + r100) * 31;
            j r136 = this.f348347s;
            if (r136 != null) goto L73;
            int r137 = 0;
        L75:
            return r135 + r137;
        L73:
            r137 = r136.hashCode();
            goto L75
        L65:
            r133 = 1237;
            goto L66
        L61:
            r131 = 1237;
            goto L62
        L57:
            r129 = 1237;
            goto L58
        L53:
            r127 = 1237;
            goto L54
        L49:
            r125 = 1237;
            goto L50
        L45:
            r123 = 1237;
            goto L46
        L41:
            r121 = 1237;
            goto L42
        L37:
            r119 = 1237;
            goto L38
        L33:
            r117 = 1237;
            goto L34
        L29:
            r115 = 1237;
            goto L30
        L25:
            r113 = 1237;
            goto L26
        L21:
            r109 = 1237;
            goto L22
        L17:
            r107 = 1237;
            goto L18
        L13:
            r105 = 1237;
            goto L14
        L9:
            r103 = 1237;
            goto L10
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "AVFixConfig(enableSenderPool=" + this.f348329a + ", enableEnginePool=" + this.f348330b + ", enableAsyncEngineCreation=" + this.f348331c + ", enableSkipAsyncEngineCreationOnWorker=" + this.f348332d + ", enableAsyncCacheRtcDid=" + this.f348333e + ", engineDestroyDelayMs=" + this.f348334f + ", obtainEngineOnOtherDestroy=" + this.f348335g + ", disableDowngradeConfig=" + this.f348336h + ", deferUnstartedSessionDestroy=" + this.f348337i + ", fixQuicEarlyStopInvoke=" + this.f348338j + ", fixDoraAutoPublishAudio=" + this.f348339k + ", disableRtcAigcCallbackWithCode=" + this.f348340l + ", fixRtcJoinLeaveRoomSync=" + this.f348341m + ", fixRtcLeaveRoomInvoke=" + this.f348342n + ", resetLoudnessOnFirstFrame=" + this.f348343o + ", enableFinishSessionStats=" + this.f348344p + ", fixOmniAudioEngineReleaseInSession=" + this.f348345q + ", enableRtcLazyInit=" + this.f348346r + ", omniRecorderSilentRestartConfig=" + this.f348347s + ')';
        }

        static {
            Companion = new b();
        }

        public c(int r100) {
            j r101 = new j(0);
            this.f348329a = true;
            this.f348330b = true;
            this.f348331c = true;
            this.f348332d = true;
            this.f348333e = true;
            this.f348334f = 0;
            this.f348335g = false;
            this.f348336h = false;
            this.f348337i = true;
            this.f348338j = true;
            this.f348339k = true;
            this.f348340l = false;
            this.f348341m = true;
            this.f348342n = true;
            this.f348343o = true;
            this.f348344p = true;
            this.f348345q = true;
            this.f348346r = true;
            this.f348347s = r101;
        }

        public c(int r100, boolean r101, boolean r110, boolean r111, boolean r112, boolean r113, long r114, boolean r115, boolean r116, boolean r117, boolean r118, boolean r210, boolean r211, boolean r212, boolean r213, boolean r214, boolean r215, boolean r216, boolean r217, j r218) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348349b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            this.f348329a = true;
        L9:
            if ((r100 & 2) != 0) goto L11;
            this.f348330b = true;
        L13:
            if ((r100 & 4) != 0) goto L15;
            this.f348331c = true;
        L17:
            if ((r100 & 8) != 0) goto L19;
            this.f348332d = true;
        L21:
            if ((r100 & 16) != 0) goto L23;
            this.f348333e = true;
        L25:
            if ((r100 & 32) != 0) goto L27;
            long r102 = 0;
        L28:
            this.f348334f = r102;
            if ((r100 & 64) != 0) goto L31;
            this.f348335g = false;
        L33:
            if ((r100 & 128) != 0) goto L35;
            this.f348336h = false;
        L37:
            if ((r100 & 256) != 0) goto L39;
            this.f348337i = true;
        L41:
            if ((r100 & 512) != 0) goto L43;
            this.f348338j = true;
        L45:
            if ((r100 & 1024) != 0) goto L47;
            this.f348339k = true;
        L49:
            if ((r100 & 2048) != 0) goto L51;
            this.f348340l = false;
        L53:
            if ((r100 & 4096) != 0) goto L55;
            this.f348341m = true;
        L57:
            if ((r100 & 8192) != 0) goto L59;
            this.f348342n = true;
        L61:
            if ((r100 & 16384) != 0) goto L63;
            this.f348343o = true;
        L65:
            if ((32768 & r100) != 0) goto L67;
            this.f348344p = true;
        L69:
            if ((65536 & r100) != 0) goto L71;
            this.f348345q = true;
        L73:
            if ((131072 & r100) != 0) goto L75;
            this.f348346r = true;
        L77:
            if ((r100 & 262144) != 0) goto L79;
            j r103 = new j(0);
        L80:
            this.f348347s = r103;
            return;
        L79:
            r103 = r218;
            goto L80
        L75:
            this.f348346r = r217;
            goto L77
        L71:
            this.f348345q = r216;
            goto L73
        L67:
            this.f348344p = r215;
            goto L69
        L63:
            this.f348343o = r214;
            goto L65
        L59:
            this.f348342n = r213;
            goto L61
        L55:
            this.f348341m = r212;
            goto L57
        L51:
            this.f348340l = r211;
            goto L53
        L47:
            this.f348339k = r210;
            goto L49
        L43:
            this.f348338j = r118;
            goto L45
        L39:
            this.f348337i = r117;
            goto L41
        L35:
            this.f348336h = r116;
            goto L37
        L31:
            this.f348335g = r115;
            goto L33
        L27:
            r102 = r114;
            goto L28
        L23:
            this.f348333e = r113;
            goto L25
        L19:
            this.f348332d = r112;
            goto L21
        L15:
            this.f348331c = r111;
            goto L17
        L11:
            this.f348330b = r110;
            goto L13
        L7:
            this.f348329a = r101;
            goto L9
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    @Serializable
    public static final class d {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f348350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f348351b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f348352c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f348353d;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<d> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348354a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348355b = null;

            public a() {
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                nuc.w0 r100 = nuc.w0.f520792a;
                return new juc.d[]{r100, r100, r100, r100};
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348355b;
            }

            static {
                a r100 = new a();
                f348354a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowAudioSettingsDelegate.AecDumpConfig", r100, 4);
                r101.j("max_chunk_bytes", true);
                r101.j("max_total_bytes", true);
                r101.j("gc_interval_ms", true);
                r101.j("async_register_interval_ms", true);
                f348355b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r110) {
                Intrinsics.checkNotNullParameter(r110, "decoder");
                g2 r100 = f348355b;
                muc.c r101 = r110.beginStructure(r100);
                if (r101.decodeSequentially() == false) goto L5;
                int r102 = r101.decodeIntElement(r100, 0);
                int r103 = r101.decodeIntElement(r100, 1);
                int r104 = r101.decodeIntElement(r100, 2);
                int r111 = r102;
                int r112 = r104;
                int r113 = r103;
                int r114 = r101.decodeIntElement(r100, 3);
                int r115 = 15;
            L21:
                r101.endStructure(r100);
                return new d(r115, r111, r113, r112, r114);
            L5:
                int r105 = 0;
                int r106 = 0;
                int r107 = 0;
                int r108 = 0;
                int r116 = 0;
                boolean r117 = true;
            L6:
                if (r117 == false) goto L20;
                int r118 = r101.decodeElementIndex(r100);
                if (r118 != (-1)) goto L9;
                r117 = false;
                goto L6
            L9:
                if (r118 != 0) goto L10;
                r105 = r101.decodeIntElement(r100, 0);
                r116 = r116 | 1;
                goto L6
            L10:
                if (r118 != 1) goto L11;
                r107 = r101.decodeIntElement(r100, 1);
                r116 = r116 | 2;
                goto L6
            L11:
                if (r118 != 2) goto L12;
                r106 = r101.decodeIntElement(r100, 2);
                r116 = r116 | 4;
                goto L6
            L12:
                if (r118 != 3) goto L15;
                r108 = r101.decodeIntElement(r100, 3);
                r116 = r116 | 8;
                goto L6
            L15:
                throw new UnknownFieldException(r118);
            L20:
                r111 = r105;
                r112 = r106;
                r113 = r107;
                r114 = r108;
                r115 = r116;
                goto L21
            }

            @Override // juc.n
            public final void serialize(muc.f r100, Object r101) {
                d r102 = (d) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                g2 r103 = f348355b;
                muc.d r104 = r100.beginStructure(r103);
                b r105 = d.Companion;
                boolean r106 = false;
                if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
            L7:
                boolean r107 = true;
            L9:
                if (r107 == false) goto L12;
                r104.encodeIntElement(r103, 0, r102.f348350a);
            L12:
                if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
            L16:
                boolean r108 = true;
            L18:
                if (r108 == false) goto L21;
                r104.encodeIntElement(r103, 1, r102.f348351b);
            L21:
                if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
            L25:
                boolean r109 = true;
            L27:
                if (r109 == false) goto L30;
                r104.encodeIntElement(r103, 2, r102.f348352c);
            L30:
                if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
            L34:
                r106 = true;
            L35:
                if (r106 == false) goto L37;
                r104.encodeIntElement(r103, 3, r102.f348353d);
            L37:
                r104.endStructure(r103);
                return;
            L33:
                if (r102.f348353d == 0) goto L35;
            L24:
                if (r102.f348352c != 0) goto L25;
                r109 = false;
                goto L27
            L15:
                if (r102.f348351b != 0) goto L16;
                r108 = false;
                goto L18
            L6:
                if (r102.f348350a != 0) goto L7;
                r107 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<d> serializer() {
                return a.f348354a;
            }
        }

        public d() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (this.f348350a == r101.f348350a) goto L12;
            return false;
        L12:
            if (this.f348351b == r101.f348351b) goto L15;
            return false;
        L15:
            if (this.f348352c == r101.f348352c) goto L18;
            return false;
        L18:
            if (this.f348353d == r101.f348353d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f348350a * 31) + this.f348351b) * 31) + this.f348352c) * 31) + this.f348353d;
        }

        public final String toString() {
            return "AecDumpConfig(maxChunkBytes=" + this.f348350a + ", maxTotalBytes=" + this.f348351b + ", gcIntervalMs=" + this.f348352c + ", asyncRegisterIntervalMs=" + this.f348353d + ')';
        }

        static {
            Companion = new b();
        }

        public d(int r100) {
            this.f348350a = 0;
            this.f348351b = 0;
            this.f348352c = 0;
            this.f348353d = 0;
        }

        public d(int r100, int r101, int r102, int r103, int r104) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348355b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            this.f348350a = 0;
        L9:
            if ((r100 & 2) != 0) goto L11;
            this.f348351b = 0;
        L13:
            if ((r100 & 4) != 0) goto L15;
            this.f348352c = 0;
        L17:
            if ((r100 & 8) != 0) goto L19;
            this.f348353d = 0;
            return;
        L19:
            this.f348353d = r104;
            return;
        L15:
            this.f348352c = r103;
            goto L17
        L11:
            this.f348351b = r102;
            goto L13
        L7:
            this.f348350a = r101;
            goto L9
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    @Serializable
    public static final class e {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l f348356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final n f348357b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final m f348358c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b f348359d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final c f348360e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final a f348361f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final h f348362g;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<e> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348363a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348364b = null;

            public a() {
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                return new juc.d[]{kuc.a.d(l.a.f348418a), kuc.a.d(n.a.f348426a), kuc.a.d(m.a.f348422a), kuc.a.d(b.a.f348327a), kuc.a.d(c.a.f348348a), kuc.a.d(a.C4354a.f348310a), kuc.a.d(h.a.f348382a)};
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348364b;
            }

            static {
                a r100 = new a();
                f348363a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowAudioSettingsDelegate.AvSdkMechanismConfig", r100, 7);
                r101.j("rtc_config", true);
                r101.j("track_config", true);
                r101.j("net_config", true);
                r101.j("connect_config", true);
                r101.j("fix_config", true);
                r101.j("av_config", true);
                r101.j("mmt_config", true);
                f348364b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r110) {
                Intrinsics.checkNotNullParameter(r110, "decoder");
                g2 r100 = f348364b;
                muc.c r101 = r110.beginStructure(r100);
                int r102 = 2;
                l r111 = null;
                if (r101.decodeSequentially() == false) goto L5;
                l r103 = (l) r101.decodeNullableSerializableElement(r100, 0, l.a.f348418a, null);
                n r104 = (n) r101.decodeNullableSerializableElement(r100, 1, n.a.f348426a, null);
                m r105 = (m) r101.decodeNullableSerializableElement(r100, 2, m.a.f348422a, null);
                b r106 = (b) r101.decodeNullableSerializableElement(r100, 3, b.a.f348327a, null);
                c r107 = (c) r101.decodeNullableSerializableElement(r100, 4, c.a.f348348a, null);
                a r108 = (a) r101.decodeNullableSerializableElement(r100, 5, a.C4354a.f348310a, null);
                int r109 = 127;
                r111 = r103;
                m r112 = r105;
                c r113 = r107;
                h r114 = (h) r101.decodeNullableSerializableElement(r100, 6, h.a.f348382a, null);
                n r115 = r104;
                b r116 = r106;
                a r117 = r108;
            L23:
                r101.endStructure(r100);
                return new e(r109, r111, r115, r112, r116, r113, r117, r114);
            L5:
                c r118 = null;
                r115 = null;
                h r119 = null;
                m r120 = null;
                a r121 = null;
                b r122 = null;
                int r123 = 0;
                boolean r124 = true;
            L6:
                if (r124 == false) goto L22;
                int r125 = r101.decodeElementIndex(r100);
                switch(r125) {
                    case -1: goto L21;
                    case 0: goto L19;
                    case 1: goto L17;
                    case 2: goto L15;
                    case 3: goto L14;
                    case 4: goto L13;
                    case 5: goto L12;
                    case 6: goto L11;
                    default: goto L10;
                };
            L10:
                throw new UnknownFieldException(r125);
            L21:
                r102 = 2;
                r124 = false;
                goto L6
            L11:
                r119 = (h) r101.decodeNullableSerializableElement(r100, 6, h.a.f348382a, r119);
                r123 = r123 | 64;
            L20:
                r102 = 2;
                goto L6
            L12:
                r121 = (a) r101.decodeNullableSerializableElement(r100, 5, a.C4354a.f348310a, r121);
                r123 = r123 | 32;
                goto L20
            L13:
                r118 = (c) r101.decodeNullableSerializableElement(r100, 4, c.a.f348348a, r118);
                r123 = r123 | 16;
                goto L20
            L14:
                r122 = (b) r101.decodeNullableSerializableElement(r100, 3, b.a.f348327a, r122);
                r123 = r123 | 8;
                goto L20
            L15:
                r120 = (m) r101.decodeNullableSerializableElement(r100, r102, m.a.f348422a, r120);
                r123 = r123 | 4;
                goto L20
            L17:
                r115 = (n) r101.decodeNullableSerializableElement(r100, 1, n.a.f348426a, r115);
                r123 = r123 | 2;
                goto L20
            L19:
                r123 = r123 | 1;
                r111 = (l) r101.decodeNullableSerializableElement(r100, 0, l.a.f348418a, r111);
                goto L20
            L22:
                r109 = r123;
                r114 = r119;
                r112 = r120;
                r116 = r122;
                r117 = r121;
                r113 = r118;
                goto L23
            }

            @Override // juc.n
            public final void serialize(muc.f r100, Object r101) {
                e r102 = (e) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                g2 r103 = f348364b;
                muc.d r104 = r100.beginStructure(r103);
                b r105 = e.Companion;
                boolean r106 = false;
                if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
            L7:
                boolean r107 = true;
            L9:
                if (r107 == false) goto L12;
                r104.encodeNullableSerializableElement(r103, 0, l.a.f348418a, r102.f348356a);
            L12:
                if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
            L16:
                boolean r108 = true;
            L18:
                if (r108 == false) goto L21;
                r104.encodeNullableSerializableElement(r103, 1, n.a.f348426a, r102.f348357b);
            L21:
                if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
            L25:
                boolean r109 = true;
            L27:
                if (r109 == false) goto L30;
                r104.encodeNullableSerializableElement(r103, 2, m.a.f348422a, r102.f348358c);
            L30:
                if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
            L34:
                boolean r110 = true;
            L36:
                if (r110 == false) goto L39;
                r104.encodeNullableSerializableElement(r103, 3, b.a.f348327a, r102.f348359d);
            L39:
                if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L42;
            L43:
                boolean r111 = true;
            L45:
                if (r111 == false) goto L48;
                r104.encodeNullableSerializableElement(r103, 4, c.a.f348348a, r102.f348360e);
            L48:
                if (r104.shouldEncodeElementDefault(r103, 5) == false) goto L51;
            L52:
                boolean r112 = true;
            L54:
                if (r112 == false) goto L57;
                r104.encodeNullableSerializableElement(r103, 5, a.C4354a.f348310a, r102.f348361f);
            L57:
                if (r104.shouldEncodeElementDefault(r103, 6) == false) goto L60;
            L58:
                r106 = true;
            L62:
                if (r106 == false) goto L64;
                r104.encodeNullableSerializableElement(r103, 6, h.a.f348382a, r102.f348362g);
            L64:
                r104.endStructure(r103);
                return;
            L60:
                if (Intrinsics.areEqual(r102.f348362g, new h(0)) == true) goto L62;
            L51:
                if (Intrinsics.areEqual(r102.f348361f, new a(null)) == false) goto L52;
                r112 = false;
                goto L54
            L42:
                if (Intrinsics.areEqual(r102.f348360e, new c(0)) == false) goto L43;
                r111 = false;
                goto L45
            L33:
                if (Intrinsics.areEqual(r102.f348359d, new b(0)) == false) goto L34;
                r110 = false;
                goto L36
            L24:
                if (r102.f348358c != null) goto L25;
                r109 = false;
                goto L27
            L15:
                if (r102.f348357b != null) goto L16;
                r108 = false;
                goto L18
            L6:
                if (r102.f348356a != null) goto L7;
                r107 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<e> serializer() {
                return a.f348363a;
            }
        }

        public e() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (Intrinsics.areEqual(this.f348356a, r101.f348356a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f348357b, r101.f348357b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f348358c, r101.f348358c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f348359d, r101.f348359d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f348360e, r101.f348360e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f348361f, r101.f348361f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f348362g, r101.f348362g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            l r100 = this.f348356a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            n r104 = this.f348357b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            m r107 = this.f348358c;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            b r110 = this.f348359d;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            c r113 = this.f348360e;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            a r116 = this.f348361f;
            if (r116 != null) goto L25;
            int r117 = 0;
        L26:
            int r118 = (r115 + r117) * 31;
            h r119 = this.f348362g;
            if (r119 == null) goto L31;
            r101 = r119.hashCode();
        L31:
            return r118 + r101;
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
            return "AvSdkMechanismConfig(rtcConfig=" + this.f348356a + ", trackConfig=" + this.f348357b + ", netConfig=" + this.f348358c + ", connectConfig=" + this.f348359d + ", fixConfig=" + this.f348360e + ", avConfig=" + this.f348361f + ", mmtConfig=" + this.f348362g + ')';
        }

        static {
            Companion = new b();
        }

        public e(int r100) {
            b r101 = new b(0);
            c r102 = new c(0);
            a r103 = new a(null);
            h r104 = new h(0);
            this.f348356a = null;
            this.f348357b = null;
            this.f348358c = null;
            this.f348359d = r101;
            this.f348360e = r102;
            this.f348361f = r103;
            this.f348362g = r104;
        }

        public e(int r100, l r101, n r102, m r103, b r104, c r105, a r110, h r111) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348364b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            this.f348356a = null;
        L9:
            if ((r100 & 2) != 0) goto L11;
            this.f348357b = null;
        L13:
            if ((r100 & 4) != 0) goto L15;
            this.f348358c = null;
        L17:
            if ((r100 & 8) != 0) goto L19;
            r104 = new b(0);
        L19:
            this.f348359d = r104;
            if ((r100 & 16) != 0) goto L22;
            r105 = new c(0);
        L22:
            this.f348360e = r105;
            if ((r100 & 32) != 0) goto L25;
            r110 = new a(null);
        L25:
            this.f348361f = r110;
            if ((r100 & 64) != 0) goto L28;
            r111 = new h(0);
        L28:
            this.f348362g = r111;
            return;
        L15:
            this.f348358c = r103;
            goto L17
        L11:
            this.f348357b = r102;
            goto L13
        L7:
            this.f348356a = r101;
            goto L9
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    @Serializable
    public static final class f {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f348365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f348366b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f348367c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f348368d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f348369e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f348370f;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<f> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348371a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348372b = null;

            public a() {
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                nuc.w0 r100 = nuc.w0.f520792a;
                return new juc.d[]{r100, r100, r100, r100, r100, r100};
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348372b;
            }

            static {
                a r100 = new a();
                f348371a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowAudioSettingsDelegate.ClientFrameSampleConfig", r100, 6);
                r101.j("target_fps", true);
                r101.j(KFImage.FRAME_RATE_JSON_FIELD, true);
                r101.j(SpeechEngineDefines.PARAMS_KEY_SAMPLE_RATE_INT, true);
                r101.j("max_delay", true);
                r101.j("min_interval", true);
                r101.j("downsample_ratio", true);
                f348372b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r110) {
                Intrinsics.checkNotNullParameter(r110, "decoder");
                g2 r100 = f348372b;
                muc.c r101 = r110.beginStructure(r100);
                if (r101.decodeSequentially() == false) goto L5;
                int r102 = r101.decodeIntElement(r100, 0);
                int r103 = r101.decodeIntElement(r100, 1);
                int r104 = r101.decodeIntElement(r100, 2);
                int r105 = r101.decodeIntElement(r100, 3);
                int r106 = r101.decodeIntElement(r100, 4);
                int r107 = 63;
                int r108 = r102;
                int r111 = r104;
                int r112 = r106;
                int r113 = r103;
                int r114 = r105;
                int r115 = r101.decodeIntElement(r100, 5);
            L20:
                r101.endStructure(r100);
                return new f(r107, r108, r113, r111, r114, r112, r115);
            L5:
                int r109 = 0;
                int r116 = 0;
                int r117 = 0;
                int r118 = 0;
                r114 = 0;
                int r119 = 0;
                int r120 = 0;
                boolean r121 = true;
            L6:
                if (r121 == false) goto L19;
                int r122 = r101.decodeElementIndex(r100);
                switch(r122) {
                    case -1: goto L18;
                    case 0: goto L17;
                    case 1: goto L15;
                    case 2: goto L14;
                    case 3: goto L13;
                    case 4: goto L12;
                    case 5: goto L11;
                    default: goto L10;
                };
            L10:
                throw new UnknownFieldException(r122);
            L17:
                r109 = r101.decodeIntElement(r100, 0);
                r120 = r120 | 1;
                goto L6
            L18:
                r121 = false;
                goto L6
            L11:
                r119 = r101.decodeIntElement(r100, 5);
                int r123 = r120 | 32;
            L16:
                r120 = r123;
                goto L6
            L12:
                r117 = r101.decodeIntElement(r100, 4);
                r123 = r120 | 16;
                goto L16
            L13:
                r114 = r101.decodeIntElement(r100, 3);
                r123 = r120 | 8;
                goto L16
            L14:
                r116 = r101.decodeIntElement(r100, 2);
                r123 = r120 | 4;
                goto L16
            L15:
                r118 = r101.decodeIntElement(r100, 1);
                r123 = r120 | 2;
                goto L16
            L19:
                r107 = r120;
                r115 = r119;
                r112 = r117;
                r113 = r118;
                r111 = r116;
                r108 = r109;
                goto L20
            }

            @Override // juc.n
            public final void serialize(muc.f r100, Object r101) {
                f r102 = (f) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                g2 r103 = f348372b;
                muc.d r104 = r100.beginStructure(r103);
                b r105 = f.Companion;
                boolean r106 = false;
                if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
            L7:
                boolean r107 = true;
            L9:
                if (r107 == false) goto L12;
                r104.encodeIntElement(r103, 0, r102.f348365a);
            L12:
                if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
            L16:
                boolean r108 = true;
            L18:
                if (r108 == false) goto L21;
                r104.encodeIntElement(r103, 1, r102.f348366b);
            L21:
                if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
            L25:
                boolean r109 = true;
            L27:
                if (r109 == false) goto L30;
                r104.encodeIntElement(r103, 2, r102.f348367c);
            L30:
                if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
            L34:
                boolean r110 = true;
            L36:
                if (r110 == false) goto L39;
                r104.encodeIntElement(r103, 3, r102.f348368d);
            L39:
                if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L42;
            L43:
                boolean r111 = true;
            L45:
                if (r111 == false) goto L48;
                r104.encodeIntElement(r103, 4, r102.f348369e);
            L48:
                if (r104.shouldEncodeElementDefault(r103, 5) == false) goto L51;
            L52:
                r106 = true;
            L53:
                if (r106 == false) goto L55;
                r104.encodeIntElement(r103, 5, r102.f348370f);
            L55:
                r104.endStructure(r103);
                return;
            L51:
                if (r102.f348370f == 0) goto L53;
            L42:
                if (r102.f348369e != 2) goto L43;
                r111 = false;
                goto L45
            L33:
                if (r102.f348368d != 3) goto L34;
                r110 = false;
                goto L36
            L24:
                if (r102.f348367c != 5) goto L25;
                r109 = false;
                goto L27
            L15:
                if (r102.f348366b != 0) goto L16;
                r108 = false;
                goto L18
            L6:
                if (r102.f348365a != 0) goto L7;
                r107 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<f> serializer() {
                return a.f348371a;
            }
        }

        public f() {
            this(0, 0, 63);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L8;
            return false;
        L8:
            f r101 = (f) r100;
            if (this.f348365a == r101.f348365a) goto L12;
            return false;
        L12:
            if (this.f348366b == r101.f348366b) goto L15;
            return false;
        L15:
            if (this.f348367c == r101.f348367c) goto L18;
            return false;
        L18:
            if (this.f348368d == r101.f348368d) goto L21;
            return false;
        L21:
            if (this.f348369e == r101.f348369e) goto L24;
            return false;
        L24:
            if (this.f348370f == r101.f348370f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            return (((((((((this.f348365a * 31) + this.f348366b) * 31) + this.f348367c) * 31) + this.f348368d) * 31) + this.f348369e) * 31) + this.f348370f;
        }

        public final String toString() {
            return "ClientFrameSampleConfig(targetFps=" + this.f348365a + ", frameRate=" + this.f348366b + ", sampleRate=" + this.f348367c + ", maxDelay=" + this.f348368d + ", minInterval=" + this.f348369e + ", downsampleRatio=" + this.f348370f + ')';
        }

        static {
            Companion = new b();
        }

        public f(int r100, int r101, int r102) {
            if ((r102 & 1) == 0) goto L6;
            r100 = 0;
        L6:
            if ((r102 & 4) == 0) goto L9;
            r101 = 5;
        L9:
            if ((r102 & 8) == 0) goto L11;
            int r103 = 3;
        L13:
            if ((r102 & 16) == 0) goto L15;
            int r104 = 2;
        L16:
            this.f348365a = r100;
            this.f348366b = 0;
            this.f348367c = r101;
            this.f348368d = r103;
            this.f348369e = r104;
            this.f348370f = 0;
            return;
        L15:
            r104 = 0;
            goto L16
        L11:
            r103 = 0;
            goto L13
        }

        public f(int r100, int r101, int r102, int r103, int r104, int r105, int r106) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348372b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            this.f348365a = 0;
        L9:
            if ((r100 & 2) != 0) goto L11;
            this.f348366b = 0;
        L13:
            if ((r100 & 4) != 0) goto L15;
            this.f348367c = 5;
        L17:
            if ((r100 & 8) != 0) goto L19;
            this.f348368d = 3;
        L21:
            if ((r100 & 16) != 0) goto L23;
            this.f348369e = 2;
        L25:
            if ((r100 & 32) != 0) goto L27;
            this.f348370f = 0;
            return;
        L27:
            this.f348370f = r106;
            return;
        L23:
            this.f348369e = r105;
            goto L25
        L19:
            this.f348368d = r104;
            goto L21
        L15:
            this.f348367c = r103;
            goto L17
        L11:
            this.f348366b = r102;
            goto L13
        L7:
            this.f348365a = r101;
            goto L9
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    @Serializable
    public static final class g {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f348373a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f348374b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f348375c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f348376d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f348377e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f348378f;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<g> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348379a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348380b = null;

            public a() {
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                nuc.w0 r100 = nuc.w0.f520792a;
                return new juc.d[]{r100, nuc.i.f520705a, kuc.a.d(v2.f520790a), r100, r100, r100};
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348380b;
            }

            static {
                a r100 = new a();
                f348379a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowAudioSettingsDelegate.InternalMediaConfig", r100, 6);
                r101.j("capture_per_call_ms", true);
                r101.j("enable_sami_process", true);
                r101.j("rtc_custom_media_ip", true);
                r101.j("connect_lost_timeout", true);
                r101.j("signaling_timeout_interrupt", true);
                r101.j("rtc_vad_report", true);
                f348380b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r110) {
                Intrinsics.checkNotNullParameter(r110, "decoder");
                g2 r100 = f348380b;
                muc.c r101 = r110.beginStructure(r100);
                if (r101.decodeSequentially() == false) goto L5;
                int r102 = r101.decodeIntElement(r100, 0);
                boolean r103 = r101.decodeBooleanElement(r100, 1);
                String r104 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, null);
                int r105 = r101.decodeIntElement(r100, 3);
                int r106 = 63;
                int r107 = r102;
                String r111 = r104;
                int r112 = r101.decodeIntElement(r100, 4);
                boolean r113 = r103;
                int r114 = r105;
                int r115 = r101.decodeIntElement(r100, 5);
            L21:
                r101.endStructure(r100);
                return new g(r106, r107, r113, r111, r114, r112, r115);
            L5:
                String r116 = null;
                int r108 = 0;
                int r109 = 0;
                r113 = false;
                int r117 = 0;
                int r118 = 0;
                int r119 = 0;
                boolean r120 = true;
            L6:
                if (r120 == false) goto L20;
                int r121 = r101.decodeElementIndex(r100);
                switch(r121) {
                    case -1: goto L19;
                    case 0: goto L18;
                    case 1: goto L15;
                    case 2: goto L14;
                    case 3: goto L13;
                    case 4: goto L12;
                    case 5: goto L11;
                    default: goto L10;
                };
            L10:
                throw new UnknownFieldException(r121);
            L18:
                r108 = r101.decodeIntElement(r100, 0);
                r119 = r119 | 1;
                goto L6
            L19:
                r120 = false;
                goto L6
            L11:
                r118 = r101.decodeIntElement(r100, 5);
                int r122 = r119 | 32;
            L16:
                r119 = r122;
                goto L6
            L12:
                r109 = r101.decodeIntElement(r100, 4);
                r122 = r119 | 16;
                goto L16
            L13:
                r117 = r101.decodeIntElement(r100, 3);
                r122 = r119 | 8;
                goto L16
            L14:
                r119 = r119 | 4;
                r116 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r116);
                goto L6
            L15:
                r113 = r101.decodeBooleanElement(r100, 1);
                r122 = r119 | 2;
                goto L16
            L20:
                r106 = r119;
                r112 = r109;
                r107 = r108;
                int r123 = r118;
                r114 = r117;
                r111 = r116;
                r115 = r123;
                goto L21
            }

            @Override // juc.n
            public final void serialize(muc.f r100, Object r101) {
                g r102 = (g) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                g2 r103 = f348380b;
                muc.d r104 = r100.beginStructure(r103);
                b r105 = g.Companion;
                boolean r106 = false;
                if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
            L7:
                boolean r107 = true;
            L9:
                if (r107 == false) goto L12;
                r104.encodeIntElement(r103, 0, r102.f348373a);
            L12:
                if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
            L16:
                boolean r108 = true;
            L18:
                if (r108 == false) goto L21;
                r104.encodeBooleanElement(r103, 1, r102.f348374b);
            L21:
                if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
            L25:
                boolean r109 = true;
            L27:
                if (r109 == false) goto L30;
                r104.encodeNullableSerializableElement(r103, 2, v2.f520790a, r102.f348375c);
            L30:
                if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
            L34:
                boolean r110 = true;
            L36:
                if (r110 == false) goto L39;
                r104.encodeIntElement(r103, 3, r102.f348376d);
            L39:
                if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L42;
            L43:
                boolean r111 = true;
            L45:
                if (r111 == false) goto L48;
                r104.encodeIntElement(r103, 4, r102.f348377e);
            L48:
                if (r104.shouldEncodeElementDefault(r103, 5) == false) goto L51;
            L52:
                r106 = true;
            L53:
                if (r106 == false) goto L55;
                r104.encodeIntElement(r103, 5, r102.f348378f);
            L55:
                r104.endStructure(r103);
                return;
            L51:
                if (r102.f348378f == (-1)) goto L53;
            L42:
                if (r102.f348377e != 0) goto L43;
                r111 = false;
                goto L45
            L33:
                if (r102.f348376d != 60000) goto L34;
                r110 = false;
                goto L36
            L24:
                if (Intrinsics.areEqual(r102.f348375c, "") == false) goto L25;
                r109 = false;
                goto L27
            L15:
                if (r102.f348374b != true) goto L16;
                r108 = false;
                goto L18
            L6:
                if (r102.f348373a != 40) goto L7;
                r107 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<g> serializer() {
                return a.f348379a;
            }
        }

        public g() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L8;
            return false;
        L8:
            g r101 = (g) r100;
            if (this.f348373a == r101.f348373a) goto L12;
            return false;
        L12:
            if (this.f348374b == r101.f348374b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f348375c, r101.f348375c) == true) goto L18;
            return false;
        L18:
            if (this.f348376d == r101.f348376d) goto L21;
            return false;
        L21:
            if (this.f348377e == r101.f348377e) goto L24;
            return false;
        L24:
            if (this.f348378f == r101.f348378f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f348373a * 31;
            if (this.f348374b == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = (r100 + r101) * 31;
            String r103 = this.f348375c;
            if (r103 != null) goto L9;
            int r104 = 0;
        L11:
            return ((((((r102 + r104) * 31) + this.f348376d) * 31) + this.f348377e) * 31) + this.f348378f;
        L9:
            r104 = r103.hashCode();
            goto L11
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "InternalMediaConfig(enableMediaSessionReplayOpt=" + this.f348373a + ", enableSamiProcess=" + this.f348374b + ", rtcCustomMediaIP=" + this.f348375c + ", connectLostTimeout=" + this.f348376d + ", signalingTimeoutInterrupt=" + this.f348377e + ", rtcVadReport=" + this.f348378f + ')';
        }

        static {
            Companion = new b();
        }

        public g(int r100) {
            this.f348373a = 40;
            this.f348374b = true;
            this.f348375c = "";
            this.f348376d = 60000;
            this.f348377e = 0;
            this.f348378f = -1;
        }

        public g(int r100, int r101, boolean r102, String r103, int r104, int r105, int r106) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348380b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            r101 = 40;
        L7:
            this.f348373a = r101;
            if ((r100 & 2) != 0) goto L10;
            this.f348374b = true;
        L12:
            if ((r100 & 4) != 0) goto L14;
            this.f348375c = "";
        L16:
            if ((r100 & 8) != 0) goto L18;
            this.f348376d = 60000;
        L20:
            if ((r100 & 16) != 0) goto L22;
            this.f348377e = 0;
        L24:
            if ((r100 & 32) != 0) goto L26;
            this.f348378f = -1;
            return;
        L26:
            this.f348378f = r106;
            return;
        L22:
            this.f348377e = r105;
            goto L24
        L18:
            this.f348376d = r104;
            goto L20
        L14:
            this.f348375c = r103;
            goto L16
        L10:
            this.f348374b = r102;
            goto L12
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    @Serializable
    public static final class h {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f348381a;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<h> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348382a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348383b = null;

            public a() {
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                return new juc.d[]{nuc.i.f520705a};
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348383b;
            }

            static {
                a r100 = new a();
                f348382a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowAudioSettingsDelegate.MMTConfig", r100, 1);
                r101.j("enable_av_audio_dump", true);
                f348383b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r100) {
                Intrinsics.checkNotNullParameter(r100, "decoder");
                g2 r101 = f348383b;
                muc.c r102 = r100.beginStructure(r101);
                int r103 = 1;
                if (r102.decodeSequentially() == false) goto L5;
                boolean r104 = r102.decodeBooleanElement(r101, 0);
            L15:
                r102.endStructure(r101);
                return new h(r103, r104);
            L5:
                r104 = false;
                int r105 = 0;
            L6:
                if (r103 == 0) goto L14;
                int r106 = r102.decodeElementIndex(r101);
                if (r106 != (-1)) goto L9;
                r103 = 0;
                goto L6
            L9:
                if (r106 != 0) goto L12;
                r104 = r102.decodeBooleanElement(r101, 0);
                r105 = r105 | 1;
                goto L6
            L12:
                throw new UnknownFieldException(r106);
            L14:
                r103 = r105;
                goto L15
            }

            @Override // juc.n
            public final void serialize(muc.f r100, Object r101) {
                h r102 = (h) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                g2 r103 = f348383b;
                muc.d r104 = r100.beginStructure(r103);
                b r105 = h.Companion;
                if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
            L7:
                boolean r106 = true;
            L9:
                if (r106 == false) goto L11;
                r104.encodeBooleanElement(r103, 0, r102.f348381a);
            L11:
                r104.endStructure(r103);
                return;
            L6:
                if (r102.f348381a == true) goto L7;
                r106 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<h> serializer() {
                return a.f348382a;
            }
        }

        public h() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L9;
            return false;
        L9:
            if (this.f348381a == ((h) r100).f348381a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f348381a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "MMTConfig(enableAVAudioDump=" + this.f348381a + ')';
        }

        static {
            Companion = new b();
        }

        public h(int r100) {
            this.f348381a = false;
        }

        public h(int r100, boolean r101) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348383b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            this.f348381a = false;
            return;
        L7:
            this.f348381a = r101;
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    @Serializable
    public static final class i {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p f348384a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p f348385b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final f f348386c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f348387d;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<i> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348388a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348389b = null;

            public a() {
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                p.a r100 = p.a.f348435a;
                return new juc.d[]{kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(f.a.f348371a), nuc.i.f520705a};
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348389b;
            }

            static {
                a r100 = new a();
                f348388a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowAudioSettingsDelegate.MmtVlmConfig", r100, 4);
                r101.j("capture_config", true);
                r101.j("encoder_config", true);
                r101.j("client_frame_sample_config", true);
                r101.j("enable_client_frame_sample", true);
                f348389b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r110) {
                Intrinsics.checkNotNullParameter(r110, "decoder");
                g2 r100 = f348389b;
                muc.c r101 = r110.beginStructure(r100);
                if (r101.decodeSequentially() == false) goto L5;
                p.a r102 = p.a.f348435a;
                p r103 = (p) r101.decodeNullableSerializableElement(r100, 0, r102, null);
                p r104 = (p) r101.decodeNullableSerializableElement(r100, 1, r102, null);
                p r111 = r104;
                f r112 = (f) r101.decodeNullableSerializableElement(r100, 2, f.a.f348371a, null);
                boolean r113 = r101.decodeBooleanElement(r100, 3);
                p r114 = r103;
                int r115 = 15;
            L21:
                r101.endStructure(r100);
                return new i(r115, r114, r111, r112, r113);
            L5:
                p r105 = null;
                p r106 = null;
                f r116 = null;
                boolean r107 = false;
                int r108 = 0;
                boolean r117 = true;
            L6:
                if (r117 == false) goto L20;
                int r118 = r101.decodeElementIndex(r100);
                if (r118 != (-1)) goto L9;
                r117 = false;
                goto L6
            L9:
                if (r118 != 0) goto L10;
                r105 = (p) r101.decodeNullableSerializableElement(r100, 0, p.a.f348435a, r105);
                r108 = r108 | 1;
                goto L6
            L10:
                if (r118 != 1) goto L11;
                r106 = (p) r101.decodeNullableSerializableElement(r100, 1, p.a.f348435a, r106);
                r108 = r108 | 2;
                goto L6
            L11:
                if (r118 != 2) goto L12;
                r116 = (f) r101.decodeNullableSerializableElement(r100, 2, f.a.f348371a, r116);
                r108 = r108 | 4;
                goto L6
            L12:
                if (r118 != 3) goto L15;
                r107 = r101.decodeBooleanElement(r100, 3);
                r108 = r108 | 8;
                goto L6
            L15:
                throw new UnknownFieldException(r118);
            L20:
                r113 = r107;
                r115 = r108;
                r114 = r105;
                r111 = r106;
                r112 = r116;
                goto L21
            }

            @Override // juc.n
            public final void serialize(muc.f r110, Object r111) {
                i r112 = (i) r111;
                Intrinsics.checkNotNullParameter(r110, "encoder");
                Intrinsics.checkNotNullParameter(r112, "value");
                g2 r100 = f348389b;
                muc.d r113 = r110.beginStructure(r100);
                b r101 = i.Companion;
                boolean r102 = false;
                if (r113.shouldEncodeElementDefault(r100, 0) == false) goto L6;
            L7:
                boolean r103 = true;
            L9:
                if (r103 == false) goto L12;
                r113.encodeNullableSerializableElement(r100, 0, p.a.f348435a, r112.f348384a);
            L12:
                if (r113.shouldEncodeElementDefault(r100, 1) == false) goto L15;
            L16:
                boolean r104 = true;
            L18:
                if (r104 == false) goto L21;
                r113.encodeNullableSerializableElement(r100, 1, p.a.f348435a, r112.f348385b);
            L21:
                if (r113.shouldEncodeElementDefault(r100, 2) == false) goto L24;
            L25:
                boolean r105 = true;
            L27:
                if (r105 == false) goto L30;
                r113.encodeNullableSerializableElement(r100, 2, f.a.f348371a, r112.f348386c);
            L30:
                if (r113.shouldEncodeElementDefault(r100, 3) == false) goto L33;
            L34:
                r102 = true;
            L35:
                if (r102 == false) goto L37;
                r113.encodeBooleanElement(r100, 3, r112.f348387d);
            L37:
                r113.endStructure(r100);
                return;
            L33:
                if (r112.f348387d == true) goto L35;
            L24:
                if (Intrinsics.areEqual(r112.f348386c, new f(6, 0, 62)) == false) goto L25;
                r105 = false;
                goto L27
            L15:
                if (Intrinsics.areEqual(r112.f348385b, new p(6, 3)) == false) goto L16;
                r104 = false;
                goto L18
            L6:
                if (Intrinsics.areEqual(r112.f348384a, new p(0, 7)) == false) goto L7;
                r103 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<i> serializer() {
                return a.f348388a;
            }
        }

        public i() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof i) == true) goto L8;
            return false;
        L8:
            i r101 = (i) r100;
            if (Intrinsics.areEqual(this.f348384a, r101.f348384a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f348385b, r101.f348385b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f348386c, r101.f348386c) == true) goto L18;
            return false;
        L18:
            if (this.f348387d == r101.f348387d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            p r100 = this.f348384a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            p r104 = this.f348385b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            f r107 = this.f348386c;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            int r108 = (r106 + r101) * 31;
            if (this.f348387d == false) goto L17;
            int r109 = 1231;
        L19:
            return r108 + r109;
        L17:
            r109 = 1237;
            goto L19
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "MmtVlmConfig(captureConfig=" + this.f348384a + ", encoderConfig=" + this.f348385b + ", clientFrameSampleConfig=" + this.f348386c + ", enableClientFrameSample=" + this.f348387d + ')';
        }

        static {
            Companion = new b();
        }

        public i(int r100) {
            p r101 = new p(0, 7);
            p r102 = new p(6, 3);
            f r103 = new f(6, 0, 62);
            this.f348384a = r101;
            this.f348385b = r102;
            this.f348386c = r103;
            this.f348387d = true;
        }

        public i(int r100, p r101, p r102, f r103, boolean r104) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348389b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            r101 = new p(0, 7);
        L7:
            this.f348384a = r101;
            if ((r100 & 2) != 0) goto L10;
            this.f348385b = new p(6, 3);
        L12:
            if ((r100 & 4) != 0) goto L14;
            this.f348386c = new f(6, 0, 62);
        L16:
            if ((r100 & 8) != 0) goto L18;
            this.f348387d = true;
            return;
        L18:
            this.f348387d = r104;
            return;
        L14:
            this.f348386c = r103;
            goto L16
        L10:
            this.f348385b = r102;
            goto L12
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    @Serializable
    public static final class j {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f348390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f348391b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f348392c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f348393d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f348394e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f348395f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f348396g;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<j> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348397a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348398b = null;

            public a() {
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                nuc.i r100 = nuc.i.f520705a;
                nuc.g1 r101 = nuc.g1.f520681a;
                return new juc.d[]{r100, r101, nuc.l0.f520731a, r101, nuc.w0.f520792a, r100, r101};
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348398b;
            }

            static {
                a r100 = new a();
                f348397a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowAudioSettingsDelegate.OmniRecorderSilentRestartConfig", r100, 7);
                r101.j("enable", true);
                r101.j("silence_duration_ms", true);
                r101.j("amplitude_threshold", true);
                r101.j("restart_cooldown_ms", true);
                r101.j("max_retry_count", true);
                r101.j("enable_volume_log", true);
                r101.j("volume_log_interval_ms", true);
                f348398b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r210) {
                Intrinsics.checkNotNullParameter(r210, "decoder");
                g2 r100 = f348398b;
                muc.c r101 = r210.beginStructure(r100);
                if (r101.decodeSequentially() == false) goto L5;
                boolean r102 = r101.decodeBooleanElement(r100, 0);
                long r103 = r101.decodeLongElement(r100, 1);
                float r104 = r101.decodeFloatElement(r100, 2);
                long r105 = r101.decodeLongElement(r100, 3);
                int r106 = r101.decodeIntElement(r100, 4);
                int r110 = r106;
                boolean r111 = r101.decodeBooleanElement(r100, 5);
                long r112 = r105;
                long r113 = r101.decodeLongElement(r100, 6);
                int r107 = 127;
                boolean r108 = r102;
                float r114 = r104;
                long r115 = r103;
            L21:
                r101.endStructure(r100);
                return new j(r107, r108, r115, r114, r112, r110, r111, r113);
            L5:
                long r116 = 0;
                long r117 = 0;
                long r118 = 0;
                boolean r109 = false;
                float r119 = 0.0f;
                int r120 = 0;
                int r121 = 0;
                boolean r122 = false;
                boolean r211 = true;
            L6:
                if (r211 == false) goto L20;
                int r123 = r101.decodeElementIndex(r100);
                switch(r123) {
                    case -1: goto L19;
                    case 0: goto L18;
                    case 1: goto L16;
                    case 2: goto L15;
                    case 3: goto L14;
                    case 4: goto L13;
                    case 5: goto L12;
                    case 6: goto L11;
                    default: goto L10;
                };
            L10:
                throw new UnknownFieldException(r123);
            L18:
                r109 = r101.decodeBooleanElement(r100, 0);
                r121 = r121 | 1;
                goto L6
            L19:
                r211 = false;
                goto L6
            L11:
                r118 = r101.decodeLongElement(r100, 6);
                int r124 = r121 | 64;
            L17:
                r121 = r124;
                goto L6
            L12:
                r122 = r101.decodeBooleanElement(r100, 5);
                r124 = r121 | 32;
                goto L17
            L13:
                r120 = r101.decodeIntElement(r100, 4);
                r124 = r121 | 16;
                goto L17
            L14:
                r117 = r101.decodeLongElement(r100, 3);
                r124 = r121 | 8;
                goto L17
            L15:
                r119 = r101.decodeFloatElement(r100, 2);
                r124 = r121 | 4;
                goto L17
            L16:
                r116 = r101.decodeLongElement(r100, 1);
                r124 = r121 | 2;
                goto L17
            L20:
                r108 = r109;
                r107 = r121;
                long r212 = r116;
                r114 = r119;
                r112 = r117;
                r113 = r118;
                r111 = r122;
                r110 = r120;
                r115 = r212;
                goto L21
            }

            @Override // juc.n
            public final void serialize(muc.f r110, Object r111) {
                j r112 = (j) r111;
                Intrinsics.checkNotNullParameter(r110, "encoder");
                Intrinsics.checkNotNullParameter(r112, "value");
                g2 r100 = f348398b;
                muc.d r113 = r110.beginStructure(r100);
                b r101 = j.Companion;
                boolean r102 = false;
                if (r113.shouldEncodeElementDefault(r100, 0) == false) goto L6;
            L7:
                boolean r103 = true;
            L9:
                if (r103 == false) goto L12;
                r113.encodeBooleanElement(r100, 0, r112.f348390a);
            L12:
                if (r113.shouldEncodeElementDefault(r100, 1) == false) goto L15;
            L16:
                boolean r104 = true;
            L18:
                if (r104 == false) goto L21;
                r113.encodeLongElement(r100, 1, r112.f348391b);
            L21:
                if (r113.shouldEncodeElementDefault(r100, 2) == false) goto L24;
            L25:
                boolean r105 = true;
            L27:
                if (r105 == false) goto L30;
                r113.encodeFloatElement(r100, 2, r112.f348392c);
            L30:
                if (r113.shouldEncodeElementDefault(r100, 3) == false) goto L33;
            L34:
                boolean r106 = true;
            L36:
                if (r106 == false) goto L39;
                r113.encodeLongElement(r100, 3, r112.f348393d);
            L39:
                if (r113.shouldEncodeElementDefault(r100, 4) == false) goto L42;
            L43:
                boolean r107 = true;
            L45:
                if (r107 == false) goto L48;
                r113.encodeIntElement(r100, 4, r112.f348394e);
            L48:
                if (r113.shouldEncodeElementDefault(r100, 5) == false) goto L51;
            L52:
                boolean r108 = true;
            L54:
                if (r108 == false) goto L57;
                r113.encodeBooleanElement(r100, 5, r112.f348395f);
            L57:
                if (r113.shouldEncodeElementDefault(r100, 6) == false) goto L60;
            L61:
                r102 = true;
            L62:
                if (r102 == false) goto L64;
                r113.encodeLongElement(r100, 6, r112.f348396g);
            L64:
                r113.endStructure(r100);
                return;
            L60:
                if (r112.f348396g == 2000) goto L62;
            L51:
                if (r112.f348395f != true) goto L52;
                r108 = false;
                goto L54
            L42:
                if (r112.f348394e != 2) goto L43;
                r107 = false;
                goto L45
            L33:
                if (r112.f348393d != 5000) goto L34;
                r106 = false;
                goto L36
            L24:
                if (Float.compare(r112.f348392c, 0.0f) != 0) goto L25;
                r105 = false;
                goto L27
            L15:
                if (r112.f348391b != 5000) goto L16;
                r104 = false;
                goto L18
            L6:
                if (r112.f348390a != true) goto L7;
                r103 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<j> serializer() {
                return a.f348397a;
            }
        }

        public j() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof j) == true) goto L8;
            return false;
        L8:
            j r101 = (j) r100;
            if (this.f348390a == r101.f348390a) goto L12;
            return false;
        L12:
            if (this.f348391b == r101.f348391b) goto L15;
            return false;
        L15:
            if (Float.compare(this.f348392c, r101.f348392c) == 0) goto L18;
            return false;
        L18:
            if (this.f348393d == r101.f348393d) goto L21;
            return false;
        L21:
            if (this.f348394e == r101.f348394e) goto L24;
            return false;
        L24:
            if (this.f348395f == r101.f348395f) goto L27;
            return false;
        L27:
            if (this.f348396g == r101.f348396g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f348390a == false) goto L5;
            int r101 = 1231;
        L6:
            long r102 = this.f348391b;
            int r103 = ((((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31) + Float.floatToIntBits(this.f348392c)) * 31;
            long r104 = this.f348393d;
            int r105 = (((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.f348394e) * 31;
            if (this.f348395f == true) goto L10;
            r100 = 1237;
        L10:
            int r106 = (r105 + r100) * 31;
            long r107 = this.f348396g;
            return r106 + ((int) (r107 ^ (r107 >>> 32)));
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "OmniRecorderSilentRestartConfig(enable=" + this.f348390a + ", silenceDurationMs=" + this.f348391b + ", amplitudeThreshold=" + this.f348392c + ", restartCooldownMs=" + this.f348393d + ", maxRetryCount=" + this.f348394e + ", enableVolumeLog=" + this.f348395f + ", volumeLogIntervalMs=" + this.f348396g + ')';
        }

        static {
            Companion = new b();
        }

        public j(int r100) {
            this.f348390a = true;
            this.f348391b = 5000;
            this.f348392c = 0.0f;
            this.f348393d = 5000;
            this.f348394e = 2;
            this.f348395f = true;
            this.f348396g = 2000;
        }

        public j(int r100, boolean r101, long r102, float r103, long r110, int r111, boolean r112, long r113) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348398b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            this.f348390a = true;
        L9:
            if ((r100 & 2) != 0) goto L11;
            this.f348391b = 5000;
        L13:
            if ((r100 & 4) != 0) goto L15;
            this.f348392c = 0.0f;
        L17:
            if ((r100 & 8) != 0) goto L19;
            this.f348393d = 5000;
        L21:
            if ((r100 & 16) != 0) goto L23;
            this.f348394e = 2;
        L25:
            if ((r100 & 32) != 0) goto L27;
            this.f348395f = true;
        L29:
            if ((r100 & 64) != 0) goto L31;
            this.f348396g = 2000;
            return;
        L31:
            this.f348396g = r113;
            return;
        L27:
            this.f348395f = r112;
            goto L29
        L23:
            this.f348394e = r111;
            goto L25
        L19:
            this.f348393d = r110;
            goto L21
        L15:
            this.f348392c = r103;
            goto L17
        L11:
            this.f348391b = r102;
            goto L13
        L7:
            this.f348390a = r101;
            goto L9
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    @Serializable
    public static final class k {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f348399a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f348400b;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<k> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348401a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348402b = null;

            public a() {
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                v2 r100 = v2.f520790a;
                return new juc.d[]{kuc.a.d(r100), kuc.a.d(r100)};
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348402b;
            }

            static {
                a r100 = new a();
                f348401a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowAudioSettingsDelegate.RTCABLabel", r100, 2);
                r101.j("vid", true);
                r101.j("label", true);
                f348402b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r110) {
                Intrinsics.checkNotNullParameter(r110, "decoder");
                g2 r100 = f348402b;
                muc.c r111 = r110.beginStructure(r100);
                String r101 = null;
                if (r111.decodeSequentially() == false) goto L5;
                v2 r102 = v2.f520790a;
                String r103 = (String) r111.decodeNullableSerializableElement(r100, 0, r102, null);
                String r104 = (String) r111.decodeNullableSerializableElement(r100, 1, r102, null);
                int r105 = 3;
            L17:
                r111.endStructure(r100);
                return new k(r105, r103, r104);
            L5:
                String r106 = null;
                int r107 = 0;
                boolean r108 = true;
            L6:
                if (r108 == false) goto L16;
                int r109 = r111.decodeElementIndex(r100);
                if (r109 != (-1)) goto L9;
                r108 = false;
                goto L6
            L9:
                if (r109 != 0) goto L10;
                r101 = (String) r111.decodeNullableSerializableElement(r100, 0, v2.f520790a, r101);
                r107 = r107 | 1;
                goto L6
            L10:
                if (r109 != 1) goto L13;
                r106 = (String) r111.decodeNullableSerializableElement(r100, 1, v2.f520790a, r106);
                r107 = r107 | 2;
                goto L6
            L13:
                throw new UnknownFieldException(r109);
            L16:
                r105 = r107;
                r103 = r101;
                r104 = r106;
                goto L17
            }

            @Override // juc.n
            public final void serialize(muc.f r100, Object r101) {
                k r102 = (k) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                g2 r103 = f348402b;
                muc.d r104 = r100.beginStructure(r103);
                b r105 = k.Companion;
                boolean r106 = false;
                if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
            L7:
                boolean r107 = true;
            L9:
                if (r107 == false) goto L12;
                r104.encodeNullableSerializableElement(r103, 0, v2.f520790a, r102.f348399a);
            L12:
                if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
            L16:
                r106 = true;
            L17:
                if (r106 == false) goto L19;
                r104.encodeNullableSerializableElement(r103, 1, v2.f520790a, r102.f348400b);
            L19:
                r104.endStructure(r103);
                return;
            L15:
                if (r102.f348400b == null) goto L17;
            L6:
                if (r102.f348399a != null) goto L7;
                r107 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<k> serializer() {
                return a.f348401a;
            }
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof k) == true) goto L8;
            return false;
        L8:
            k r101 = (k) r100;
            if (Intrinsics.areEqual(this.f348399a, r101.f348399a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f348400b, r101.f348400b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f348399a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f348400b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "RTCABLabel(vid=" + this.f348399a + ", label=" + this.f348400b + ')';
        }

        static {
            Companion = new b();
        }

        public k() {
            this.f348399a = null;
            this.f348400b = null;
        }

        public k(int r100, String r101, String r102) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348402b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            this.f348399a = null;
        L9:
            if ((r100 & 2) != 0) goto L11;
            this.f348400b = null;
            return;
        L11:
            this.f348400b = r102;
            return;
        L7:
            this.f348399a = r101;
            goto L9
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    @Serializable
    public static final class l {
        public static final b Companion = null;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final Lazy<juc.d<Object>>[] f348403o = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ouc.d0 f348404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ouc.d0 f348405b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, k> f348406c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final d f348407d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f348408e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f348409f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f348410g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f348411h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f348412i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f348413j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final boolean f348414k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final boolean f348415l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final String f348416m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final boolean f348417n;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<l> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348418a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348419b = null;

            public a() {
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348419b;
            }

            static {
                a r100 = new a();
                f348418a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowAudioSettingsDelegate.RTCConfig", r100, 14);
                r101.j("fg_config", true);
                r101.j("dora_server_fg_config", true);
                r101.j("flow_av_rtc_ab_label", true);
                r101.j("aec_dump_config", true);
                r101.j("enable_rtc_nico", true);
                r101.j("enable_token_storage", true);
                r101.j("enable_load_audio_effect_so", true);
                r101.j("enable_rtc_audio_cache", true);
                r101.j("enable_faster_frame_out_ratio", true);
                r101.j("support_fake_connect_ab", true);
                r101.j("can_disable_apm", true);
                r101.j("uplink_burst_mode", true);
                r101.j("uplink_audio_format", true);
                r101.j("enable_rtc_native", true);
                f348419b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                Lazy<juc.d<Object>>[] r100 = l.f348403o;
                ouc.f0 r101 = ouc.f0.f526848a;
                nuc.i r102 = nuc.i.f520705a;
                return new juc.d[]{kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r100[2].getValue()), kuc.a.d(d.a.f348354a), r102, r102, r102, r102, r102, r102, r102, r102, kuc.a.d(v2.f520790a), r102};
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r310) {
                Intrinsics.checkNotNullParameter(r310, "decoder");
                g2 r100 = f348419b;
                muc.c r101 = r310.beginStructure(r100);
                Lazy<juc.d<Object>>[] r102 = l.f348403o;
                int r103 = 8;
                int r104 = 7;
                int r105 = 6;
                if (r101.decodeSequentially() == false) goto L5;
                ouc.f0 r106 = ouc.f0.f526848a;
                ouc.d0 r110 = (ouc.d0) r101.decodeNullableSerializableElement(r100, 0, r106, null);
                ouc.d0 r107 = (ouc.d0) r101.decodeNullableSerializableElement(r100, 1, r106, null);
                Map r108 = (Map) r101.decodeNullableSerializableElement(r100, 2, r102[2].getValue(), null);
                d r109 = (d) r101.decodeNullableSerializableElement(r100, 3, d.a.f348354a, null);
                boolean r111 = r101.decodeBooleanElement(r100, 4);
                boolean r112 = r101.decodeBooleanElement(r100, 5);
                boolean r113 = r101.decodeBooleanElement(r100, 6);
                boolean r114 = r101.decodeBooleanElement(r100, 7);
                boolean r115 = r101.decodeBooleanElement(r100, 8);
                boolean r116 = r101.decodeBooleanElement(r100, 9);
                boolean r117 = r101.decodeBooleanElement(r100, 10);
                boolean r118 = r101.decodeBooleanElement(r100, 11);
                Map r119 = r108;
                String r210 = (String) r101.decodeNullableSerializableElement(r100, 12, v2.f520790a, null);
                ouc.d0 r120 = r107;
                boolean r211 = r114;
                boolean r212 = r113;
                boolean r213 = r101.decodeBooleanElement(r100, 13);
                boolean r214 = r115;
                d r121 = r109;
                boolean r215 = r112;
                boolean r216 = r117;
                boolean r122 = r111;
                boolean r217 = r116;
                boolean r218 = r118;
                ouc.d0 r123 = r110;
                int r124 = 16383;
            L33:
                r101.endStructure(r100);
                return new l(r124, r123, r120, r119, r121, r122, r215, r212, r211, r214, r217, r216, r218, r210, r213);
            L5:
                int r125 = 13;
                String r126 = null;
                Map r127 = null;
                ouc.d0 r128 = null;
                ouc.d0 r129 = null;
                d r219 = null;
                boolean r130 = false;
                int r131 = 0;
                boolean r132 = false;
                boolean r220 = false;
                boolean r221 = false;
                boolean r222 = false;
                boolean r223 = false;
                boolean r224 = false;
                boolean r225 = false;
                boolean r226 = false;
                boolean r311 = true;
            L6:
                if (r311 == false) goto L32;
                int r133 = r101.decodeElementIndex(r100);
                switch(r133) {
                    case -1: goto L31;
                    case 0: goto L28;
                    case 1: goto L25;
                    case 2: goto L24;
                    case 3: goto L23;
                    case 4: goto L21;
                    case 5: goto L19;
                    case 6: goto L18;
                    case 7: goto L17;
                    case 8: goto L16;
                    case 9: goto L15;
                    case 10: goto L14;
                    case 11: goto L13;
                    case 12: goto L12;
                    case 13: goto L11;
                    default: goto L10;
                };
            L10:
                throw new UnknownFieldException(r133);
            L31:
                r125 = 13;
                r104 = 7;
                r103 = 8;
                r311 = false;
                goto L6
            L11:
                r220 = r101.decodeBooleanElement(r100, r125);
                r131 = r131 | 8192;
                d r134 = r219;
            L30:
                r219 = r134;
                r125 = 13;
                r104 = 7;
                r105 = 6;
                r103 = 8;
                goto L6
            L12:
                r126 = (String) r101.decodeNullableSerializableElement(r100, 12, v2.f520790a, r126);
                r131 = r131 | 4096;
            L22:
                r134 = r219;
                goto L30
            L13:
                r226 = r101.decodeBooleanElement(r100, 11);
                r131 = r131 | 2048;
                goto L22
            L14:
                r223 = r101.decodeBooleanElement(r100, 10);
                r131 = r131 | 1024;
                goto L22
            L15:
                r225 = r101.decodeBooleanElement(r100, 9);
                r131 = r131 | 512;
                goto L22
            L16:
                r221 = r101.decodeBooleanElement(r100, r103);
                r131 = r131 | 256;
                goto L22
            L17:
                r130 = r101.decodeBooleanElement(r100, r104);
                r131 = r131 | 128;
                goto L22
            L18:
                r132 = r101.decodeBooleanElement(r100, r105);
                r131 = r131 | 64;
                goto L22
            L19:
                r222 = r101.decodeBooleanElement(r100, 5);
                r131 = r131 | 32;
                goto L22
            L21:
                r224 = r101.decodeBooleanElement(r100, 4);
                r131 = r131 | 16;
                goto L22
            L23:
                int r135 = r131 | 8;
                r134 = (d) r101.decodeNullableSerializableElement(r100, 3, d.a.f348354a, r219);
            L29:
                r131 = r135;
                goto L30
            L24:
                r127 = (Map) r101.decodeNullableSerializableElement(r100, 2, r102[2].getValue(), r127);
                int r136 = r131 | 4;
            L26:
                int r312 = r136;
                r134 = r219;
                r135 = r312;
                goto L29
            L25:
                r128 = (ouc.d0) r101.decodeNullableSerializableElement(r100, 1, ouc.f0.f526848a, r128);
                r136 = r131 | 2;
                goto L26
            L28:
                r129 = (ouc.d0) r101.decodeNullableSerializableElement(r100, 0, ouc.f0.f526848a, r129);
                r134 = r219;
                r135 = r131 | 1;
                goto L29
            L32:
                d r137 = r219;
                r123 = r129;
                r211 = r130;
                r119 = r127;
                r120 = r128;
                r212 = r132;
                r215 = r222;
                r216 = r223;
                r122 = r224;
                r218 = r226;
                r121 = r137;
                r124 = r131;
                r210 = r126;
                boolean r313 = r225;
                r213 = r220;
                r214 = r221;
                r217 = r313;
                goto L33
            }

            @Override // juc.n
            public final void serialize(muc.f r100, Object r110) {
                l r111 = (l) r110;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r111, "value");
                g2 r101 = f348419b;
                muc.d r102 = r100.beginStructure(r101);
                Lazy<juc.d<Object>>[] r103 = l.f348403o;
                boolean r104 = false;
                if (r102.shouldEncodeElementDefault(r101, 0) == false) goto L6;
            L7:
                boolean r105 = true;
            L9:
                if (r105 == false) goto L12;
                r102.encodeNullableSerializableElement(r101, 0, ouc.f0.f526848a, r111.f348404a);
            L12:
                if (r102.shouldEncodeElementDefault(r101, 1) == true) goto L16;
                ouc.d0 r106 = r111.f348405b;
                ouc.e0 r107 = new ouc.e0();
                ouc.j.c(r107, "dora_jitter_buffer", "true");
                if (Intrinsics.areEqual(r106, r107.a()) == false) goto L16;
                boolean r108 = false;
            L18:
                if (r108 == false) goto L21;
                r102.encodeNullableSerializableElement(r101, 1, ouc.f0.f526848a, r111.f348405b);
            L21:
                if (r102.shouldEncodeElementDefault(r101, 2) == false) goto L24;
            L25:
                boolean r109 = true;
            L27:
                if (r109 == false) goto L30;
                r102.encodeNullableSerializableElement(r101, 2, r103[2].getValue(), r111.f348406c);
            L30:
                if (r102.shouldEncodeElementDefault(r101, 3) == false) goto L33;
            L34:
                boolean r112 = true;
            L36:
                if (r112 == false) goto L39;
                r102.encodeNullableSerializableElement(r101, 3, d.a.f348354a, r111.f348407d);
            L39:
                if (r102.shouldEncodeElementDefault(r101, 4) == false) goto L42;
            L43:
                boolean r113 = true;
            L45:
                if (r113 == false) goto L48;
                r102.encodeBooleanElement(r101, 4, r111.f348408e);
            L48:
                if (r102.shouldEncodeElementDefault(r101, 5) == false) goto L51;
            L52:
                boolean r114 = true;
            L54:
                if (r114 == false) goto L57;
                r102.encodeBooleanElement(r101, 5, r111.f348409f);
            L57:
                if (r102.shouldEncodeElementDefault(r101, 6) == false) goto L60;
            L61:
                boolean r115 = true;
            L63:
                if (r115 == false) goto L66;
                r102.encodeBooleanElement(r101, 6, r111.f348410g);
            L66:
                if (r102.shouldEncodeElementDefault(r101, 7) == false) goto L69;
            L70:
                boolean r116 = true;
            L72:
                if (r116 == false) goto L75;
                r102.encodeBooleanElement(r101, 7, r111.f348411h);
            L75:
                if (r102.shouldEncodeElementDefault(r101, 8) == false) goto L78;
            L79:
                boolean r117 = true;
            L81:
                if (r117 == false) goto L84;
                r102.encodeBooleanElement(r101, 8, r111.f348412i);
            L84:
                if (r102.shouldEncodeElementDefault(r101, 9) == false) goto L87;
            L88:
                boolean r118 = true;
            L90:
                if (r118 == false) goto L93;
                r102.encodeBooleanElement(r101, 9, r111.f348413j);
            L93:
                if (r102.shouldEncodeElementDefault(r101, 10) == false) goto L96;
            L97:
                boolean r119 = true;
            L99:
                if (r119 == false) goto L102;
                r102.encodeBooleanElement(r101, 10, r111.f348414k);
            L102:
                if (r102.shouldEncodeElementDefault(r101, 11) == false) goto L105;
            L106:
                boolean r120 = true;
            L108:
                if (r120 == false) goto L111;
                r102.encodeBooleanElement(r101, 11, r111.f348415l);
            L111:
                if (r102.shouldEncodeElementDefault(r101, 12) == false) goto L114;
            L115:
                boolean r121 = true;
            L117:
                if (r121 == false) goto L120;
                r102.encodeNullableSerializableElement(r101, 12, v2.f520790a, r111.f348416m);
            L120:
                if (r102.shouldEncodeElementDefault(r101, 13) == false) goto L123;
            L124:
                r104 = true;
            L125:
                if (r104 == false) goto L127;
                r102.encodeBooleanElement(r101, 13, r111.f348417n);
            L127:
                r102.endStructure(r101);
                return;
            L123:
                if (r111.f348417n == false) goto L125;
            L114:
                if (r111.f348416m != null) goto L115;
                r121 = false;
                goto L117
            L105:
                if (r111.f348415l == true) goto L106;
                r120 = false;
                goto L108
            L96:
                if (r111.f348414k != true) goto L97;
                r119 = false;
                goto L99
            L87:
                if (r111.f348413j != true) goto L88;
                r118 = false;
                goto L90
            L78:
                if (r111.f348412i != true) goto L79;
                r117 = false;
                goto L81
            L69:
                if (r111.f348411h != true) goto L70;
                r116 = false;
                goto L72
            L60:
                if (r111.f348410g != true) goto L61;
                r115 = false;
                goto L63
            L51:
                if (r111.f348409f != true) goto L52;
                r114 = false;
                goto L54
            L42:
                if (r111.f348408e == true) goto L43;
                r113 = false;
                goto L45
            L33:
                if (Intrinsics.areEqual(r111.f348407d, new d(0)) == false) goto L34;
                r112 = false;
                goto L36
            L24:
                if (r111.f348406c != null) goto L25;
                r109 = false;
            L16:
                r108 = true;
                goto L18
            L6:
                if (r111.f348404a != null) goto L7;
                r105 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<l> serializer() {
                return a.f348418a;
            }
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof l) == true) goto L8;
            return false;
        L8:
            l r101 = (l) r100;
            if (Intrinsics.areEqual(this.f348404a, r101.f348404a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f348405b, r101.f348405b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f348406c, r101.f348406c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f348407d, r101.f348407d) == true) goto L21;
            return false;
        L21:
            if (this.f348408e == r101.f348408e) goto L24;
            return false;
        L24:
            if (this.f348409f == r101.f348409f) goto L27;
            return false;
        L27:
            if (this.f348410g == r101.f348410g) goto L30;
            return false;
        L30:
            if (this.f348411h == r101.f348411h) goto L33;
            return false;
        L33:
            if (this.f348412i == r101.f348412i) goto L36;
            return false;
        L36:
            if (this.f348413j == r101.f348413j) goto L39;
            return false;
        L39:
            if (this.f348414k == r101.f348414k) goto L42;
            return false;
        L42:
            if (this.f348415l == r101.f348415l) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.f348416m, r101.f348416m) == true) goto L48;
            return false;
        L48:
            if (this.f348417n == r101.f348417n) goto L50;
            return false;
        L50:
            return true;
        }

        public final int hashCode() {
            ouc.d0 r100 = this.f348404a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            ouc.d0 r104 = this.f348405b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Map<String, k> r107 = this.f348406c;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            d r110 = this.f348407d;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            int r113 = 1231;
            if (this.f348408e == false) goto L21;
            int r114 = 1231;
        L22:
            int r115 = (r112 + r114) * 31;
            if (this.f348409f == false) goto L25;
            int r116 = 1231;
        L26:
            int r117 = (r115 + r116) * 31;
            if (this.f348410g == false) goto L29;
            int r118 = 1231;
        L30:
            int r119 = (r117 + r118) * 31;
            if (this.f348411h == false) goto L33;
            int r120 = 1231;
        L34:
            int r121 = (r119 + r120) * 31;
            if (this.f348412i == false) goto L37;
            int r122 = 1231;
        L38:
            int r123 = (r121 + r122) * 31;
            if (this.f348413j == false) goto L41;
            int r124 = 1231;
        L42:
            int r125 = (r123 + r124) * 31;
            if (this.f348414k == false) goto L45;
            int r126 = 1231;
        L46:
            int r127 = (r125 + r126) * 31;
            if (this.f348415l == false) goto L49;
            int r128 = 1231;
        L50:
            int r129 = (r127 + r128) * 31;
            String r130 = this.f348416m;
            if (r130 == null) goto L54;
            r101 = r130.hashCode();
        L54:
            int r131 = (r129 + r101) * 31;
            if (this.f348417n == true) goto L59;
            r113 = 1237;
        L59:
            return r131 + r113;
        L49:
            r128 = 1237;
            goto L50
        L45:
            r126 = 1237;
            goto L46
        L41:
            r124 = 1237;
            goto L42
        L37:
            r122 = 1237;
            goto L38
        L33:
            r120 = 1237;
            goto L34
        L29:
            r118 = 1237;
            goto L30
        L25:
            r116 = 1237;
            goto L26
        L21:
            r114 = 1237;
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
            return "RTCConfig(featureConfig=" + this.f348404a + ", doraServerFgConfig=" + this.f348405b + ", abLabel=" + this.f348406c + ", aecDumpConfig=" + this.f348407d + ", enableRtcNico=" + this.f348408e + ", enableTokenStorage=" + this.f348409f + ", enableLoadAudioEffectSo=" + this.f348410g + ", enableRtcAudioCache=" + this.f348411h + ", enableFasterFrameOutRatio=" + this.f348412i + ", supportFakeConnectAb=" + this.f348413j + ", canDisableRTCApm=" + this.f348414k + ", uplinkBurstMode=" + this.f348415l + ", uplinkAudioFormat=" + this.f348416m + ", enableRTCNative=" + this.f348417n + ')';
        }

        static {
            Companion = new b();
            f348403o = new Lazy[]{null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new x()), null, null, null, null, null, null, null, null, null, null, null};
        }

        public l() {
            ouc.e0 r100 = new ouc.e0();
            ouc.j.c(r100, "dora_jitter_buffer", "true");
            ouc.d0 r101 = r100.a();
            d r102 = new d(0);
            this.f348404a = null;
            this.f348405b = r101;
            this.f348406c = null;
            this.f348407d = r102;
            this.f348408e = false;
            this.f348409f = true;
            this.f348410g = true;
            this.f348411h = true;
            this.f348412i = true;
            this.f348413j = true;
            this.f348414k = true;
            this.f348415l = false;
            this.f348416m = null;
            this.f348417n = false;
        }

        public l(int r100, ouc.d0 r101, ouc.d0 r110, Map r111, d r112, boolean r113, boolean r114, boolean r115, boolean r116, boolean r117, boolean r118, boolean r119, boolean r210, String r211, boolean r212) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348419b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            this.f348404a = null;
        L9:
            if ((r100 & 2) != 0) goto L11;
            ouc.e0 r102 = new ouc.e0();
            ouc.j.c(r102, "dora_jitter_buffer", "true");
            ouc.d0 r103 = r102.a();
        L12:
            this.f348405b = r103;
            if ((r100 & 4) != 0) goto L15;
            this.f348406c = null;
        L17:
            if ((r100 & 8) != 0) goto L19;
            d r104 = new d(0);
        L20:
            this.f348407d = r104;
            if ((r100 & 16) != 0) goto L23;
            this.f348408e = false;
        L25:
            if ((r100 & 32) != 0) goto L27;
            this.f348409f = true;
        L29:
            if ((r100 & 64) != 0) goto L31;
            this.f348410g = true;
        L33:
            if ((r100 & 128) != 0) goto L35;
            this.f348411h = true;
        L37:
            if ((r100 & 256) != 0) goto L39;
            this.f348412i = true;
        L41:
            if ((r100 & 512) != 0) goto L43;
            this.f348413j = true;
        L45:
            if ((r100 & 1024) != 0) goto L47;
            this.f348414k = true;
        L49:
            if ((r100 & 2048) != 0) goto L51;
            this.f348415l = false;
        L53:
            if ((r100 & 4096) != 0) goto L55;
            this.f348416m = null;
        L57:
            if ((r100 & 8192) != 0) goto L59;
            this.f348417n = false;
            return;
        L59:
            this.f348417n = r212;
            return;
        L55:
            this.f348416m = r211;
            goto L57
        L51:
            this.f348415l = r210;
            goto L53
        L47:
            this.f348414k = r119;
            goto L49
        L43:
            this.f348413j = r118;
            goto L45
        L39:
            this.f348412i = r117;
            goto L41
        L35:
            this.f348411h = r116;
            goto L37
        L31:
            this.f348410g = r115;
            goto L33
        L27:
            this.f348409f = r114;
            goto L29
        L23:
            this.f348408e = r113;
            goto L25
        L19:
            r104 = r112;
            goto L20
        L15:
            this.f348406c = r111;
            goto L17
        L11:
            r103 = r110;
            goto L12
        L7:
            this.f348404a = r101;
            goto L9
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    @Serializable
    public static final class m {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f348420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f348421b;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<m> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348422a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348423b = null;

            public a() {
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                nuc.i r100 = nuc.i.f520705a;
                return new juc.d[]{r100, r100};
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348423b;
            }

            static {
                a r100 = new a();
                f348422a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowAudioSettingsDelegate.RTCNetConfig", r100, 2);
                r101.j("enable_multipath", true);
                r101.j("enable_accelarate", true);
                f348423b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r110) {
                Intrinsics.checkNotNullParameter(r110, "decoder");
                g2 r100 = f348423b;
                muc.c r111 = r110.beginStructure(r100);
                if (r111.decodeSequentially() == false) goto L5;
                boolean r101 = r111.decodeBooleanElement(r100, 0);
                boolean r102 = r111.decodeBooleanElement(r100, 1);
                int r103 = 3;
            L17:
                r111.endStructure(r100);
                return new m(r103, r101, r102);
            L5:
                r101 = false;
                boolean r104 = false;
                int r105 = 0;
                boolean r106 = true;
            L6:
                if (r106 == false) goto L16;
                int r107 = r111.decodeElementIndex(r100);
                if (r107 != (-1)) goto L9;
                r106 = false;
                goto L6
            L9:
                if (r107 != 0) goto L10;
                r101 = r111.decodeBooleanElement(r100, 0);
                r105 = r105 | 1;
                goto L6
            L10:
                if (r107 != 1) goto L13;
                r104 = r111.decodeBooleanElement(r100, 1);
                r105 = r105 | 2;
                goto L6
            L13:
                throw new UnknownFieldException(r107);
            L16:
                r102 = r104;
                r103 = r105;
                goto L17
            }

            @Override // juc.n
            public final void serialize(muc.f r100, Object r101) {
                m r102 = (m) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                g2 r103 = f348423b;
                muc.d r104 = r100.beginStructure(r103);
                b r105 = m.Companion;
                boolean r106 = false;
                if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
            L7:
                boolean r107 = true;
            L9:
                if (r107 == false) goto L12;
                r104.encodeBooleanElement(r103, 0, r102.f348420a);
            L12:
                if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
            L16:
                r106 = true;
            L17:
                if (r106 == false) goto L19;
                r104.encodeBooleanElement(r103, 1, r102.f348421b);
            L19:
                r104.endStructure(r103);
                return;
            L15:
                if (r102.f348421b == false) goto L17;
            L6:
                if (r102.f348420a == true) goto L7;
                r107 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<m> serializer() {
                return a.f348422a;
            }
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof m) == true) goto L8;
            return false;
        L8:
            m r101 = (m) r100;
            if (this.f348420a == r101.f348420a) goto L12;
            return false;
        L12:
            if (this.f348421b == r101.f348421b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f348420a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f348421b == true) goto L11;
            r100 = 1237;
        L11:
            return r102 + r100;
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "RTCNetConfig(enableMultipath=" + this.f348420a + ", enableAccelarate=" + this.f348421b + ')';
        }

        static {
            Companion = new b();
        }

        public m() {
            this.f348420a = false;
            this.f348421b = false;
        }

        public m(int r100, boolean r101, boolean r102) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348423b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            this.f348420a = false;
        L9:
            if ((r100 & 2) != 0) goto L11;
            this.f348421b = false;
            return;
        L11:
            this.f348421b = r102;
            return;
        L7:
            this.f348420a = r101;
            goto L9
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    @Serializable
    public static final class n {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f348424a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final r f348425b;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<n> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348426a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348427b = null;

            public a() {
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                return new juc.d[]{nuc.i.f520705a, kuc.a.d(r.a.f348457a)};
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348427b;
            }

            static {
                a r100 = new a();
                f348426a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowAudioSettingsDelegate.RTCTrackConfig", r100, 2);
                r101.j("enable_session_tracker", true);
                r101.j("timeout_config", true);
                f348427b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r110) {
                Intrinsics.checkNotNullParameter(r110, "decoder");
                g2 r100 = f348427b;
                muc.c r111 = r110.beginStructure(r100);
                if (r111.decodeSequentially() == false) goto L5;
                boolean r101 = r111.decodeBooleanElement(r100, 0);
                r r102 = (r) r111.decodeNullableSerializableElement(r100, 1, r.a.f348457a, null);
                int r103 = 3;
            L17:
                r111.endStructure(r100);
                return new n(r103, r101, r102);
            L5:
                r r104 = null;
                r101 = false;
                int r105 = 0;
                boolean r106 = true;
            L6:
                if (r106 == false) goto L16;
                int r107 = r111.decodeElementIndex(r100);
                if (r107 != (-1)) goto L9;
                r106 = false;
                goto L6
            L9:
                if (r107 != 0) goto L10;
                r101 = r111.decodeBooleanElement(r100, 0);
                r105 = r105 | 1;
                goto L6
            L10:
                if (r107 != 1) goto L13;
                r104 = (r) r111.decodeNullableSerializableElement(r100, 1, r.a.f348457a, r104);
                r105 = r105 | 2;
                goto L6
            L13:
                throw new UnknownFieldException(r107);
            L16:
                r103 = r105;
                r102 = r104;
                goto L17
            }

            @Override // juc.n
            public final void serialize(muc.f r100, Object r101) {
                n r102 = (n) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                g2 r103 = f348427b;
                muc.d r104 = r100.beginStructure(r103);
                b r105 = n.Companion;
                boolean r106 = false;
                if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
            L7:
                boolean r107 = true;
            L9:
                if (r107 == false) goto L12;
                r104.encodeBooleanElement(r103, 0, r102.f348424a);
            L12:
                if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
            L16:
                r106 = true;
            L17:
                if (r106 == false) goto L19;
                r104.encodeNullableSerializableElement(r103, 1, r.a.f348457a, r102.f348425b);
            L19:
                r104.endStructure(r103);
                return;
            L15:
                if (Intrinsics.areEqual(r102.f348425b, new r(0)) == true) goto L17;
            L6:
                if (r102.f348424a != true) goto L7;
                r107 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<n> serializer() {
                return a.f348426a;
            }
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof n) == true) goto L8;
            return false;
        L8:
            n r101 = (n) r100;
            if (this.f348424a == r101.f348424a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f348425b, r101.f348425b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f348424a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            r r102 = this.f348425b;
            if (r102 != null) goto L9;
            int r103 = 0;
        L11:
            return r101 + r103;
        L9:
            r103 = r102.hashCode();
            goto L11
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "RTCTrackConfig(enableSessionTracker=" + this.f348424a + ", timeoutConfig=" + this.f348425b + ')';
        }

        static {
            Companion = new b();
        }

        public n() {
            r r100 = new r(0);
            this.f348424a = true;
            this.f348425b = r100;
        }

        public n(int r100, boolean r101, r r102) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348427b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            r101 = true;
        L7:
            this.f348424a = r101;
            if ((r100 & 2) != 0) goto L10;
            this.f348425b = new r(0);
            return;
        L10:
            this.f348425b = r102;
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    @Serializable
    public static final class o {
        public static final b Companion = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Lazy<juc.d<Object>>[] f348428b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<Integer> f348429a;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<o> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348430a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348431b = null;

            public a() {
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348431b;
            }

            static {
                a r100 = new a();
                f348430a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowAudioSettingsDelegate.RtcTraceConfig", r100, 1);
                r101.j("exp_code_ignore_list", true);
                f348431b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                return new juc.d[]{kuc.a.d(o.f348428b[0].getValue())};
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r100) {
                Intrinsics.checkNotNullParameter(r100, "decoder");
                g2 r101 = f348431b;
                muc.c r102 = r100.beginStructure(r101);
                Lazy<juc.d<Object>>[] r103 = o.f348428b;
                int r104 = 1;
                List r105 = null;
                if (r102.decodeSequentially() == false) goto L5;
                List r106 = (List) r102.decodeNullableSerializableElement(r101, 0, r103[0].getValue(), null);
            L15:
                r102.endStructure(r101);
                return new o(r104, r106);
            L5:
                int r107 = 0;
            L6:
                if (r104 == 0) goto L14;
                int r108 = r102.decodeElementIndex(r101);
                if (r108 != (-1)) goto L9;
                r104 = 0;
                goto L6
            L9:
                if (r108 != 0) goto L12;
                r105 = (List) r102.decodeNullableSerializableElement(r101, 0, r103[0].getValue(), r105);
                r107 = r107 | 1;
                goto L6
            L12:
                throw new UnknownFieldException(r108);
            L14:
                r104 = r107;
                r106 = r105;
                goto L15
            }

            @Override // juc.n
            public final void serialize(muc.f r100, Object r101) {
                o r102 = (o) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                g2 r103 = f348431b;
                muc.d r104 = r100.beginStructure(r103);
                Lazy<juc.d<Object>>[] r105 = o.f348428b;
                if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
            L7:
                boolean r106 = true;
            L9:
                if (r106 == false) goto L11;
                r104.encodeNullableSerializableElement(r103, 0, r105[0].getValue(), r102.f348429a);
            L11:
                r104.endStructure(r103);
                return;
            L6:
                if (r102.f348429a != null) goto L7;
                r106 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<o> serializer() {
                return a.f348430a;
            }
        }

        public o() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof o) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f348429a, ((o) r100).f348429a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            List<Integer> r100 = this.f348429a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "RtcTraceConfig(expCodeIgnoreList=" + this.f348429a + ')';
        }

        static {
            Companion = new b();
            f348428b = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new y())};
        }

        public o(Object r100) {
            this.f348429a = null;
        }

        public o(int r100, List r101) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348431b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            this.f348429a = null;
            return;
        L7:
            this.f348429a = r101;
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    @Serializable
    public static final class p {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f348432a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f348433b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f348434c;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<p> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348435a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348436b = null;

            public a() {
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                nuc.w0 r100 = nuc.w0.f520792a;
                return new juc.d[]{r100, r100, r100};
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348436b;
            }

            static {
                a r100 = new a();
                f348435a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowAudioSettingsDelegate.RtcVideoConfig", r100, 3);
                r101.j("width", true);
                r101.j("height", true);
                r101.j("fps", true);
                f348436b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r110) {
                Intrinsics.checkNotNullParameter(r110, "decoder");
                g2 r100 = f348436b;
                muc.c r111 = r110.beginStructure(r100);
                if (r111.decodeSequentially() == false) goto L5;
                int r101 = r111.decodeIntElement(r100, 0);
                int r102 = r111.decodeIntElement(r100, 1);
                int r103 = r111.decodeIntElement(r100, 2);
                int r104 = 7;
            L19:
                r111.endStructure(r100);
                return new p(r104, r101, r102, r103);
            L5:
                r101 = 0;
                int r105 = 0;
                int r106 = 0;
                int r107 = 0;
                boolean r108 = true;
            L6:
                if (r108 == false) goto L18;
                int r109 = r111.decodeElementIndex(r100);
                if (r109 != (-1)) goto L9;
                r108 = false;
                goto L6
            L9:
                if (r109 != 0) goto L10;
                r101 = r111.decodeIntElement(r100, 0);
                r107 = r107 | 1;
                goto L6
            L10:
                if (r109 != 1) goto L11;
                r106 = r111.decodeIntElement(r100, 1);
                r107 = r107 | 2;
                goto L6
            L11:
                if (r109 != 2) goto L14;
                r105 = r111.decodeIntElement(r100, 2);
                r107 = r107 | 4;
                goto L6
            L14:
                throw new UnknownFieldException(r109);
            L18:
                r103 = r105;
                r102 = r106;
                r104 = r107;
                goto L19
            }

            @Override // juc.n
            public final void serialize(muc.f r100, Object r101) {
                p r102 = (p) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                g2 r103 = f348436b;
                muc.d r104 = r100.beginStructure(r103);
                b r105 = p.Companion;
                boolean r106 = false;
                if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
            L7:
                boolean r107 = true;
            L9:
                if (r107 == false) goto L12;
                r104.encodeIntElement(r103, 0, r102.f348432a);
            L12:
                if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
            L16:
                boolean r108 = true;
            L18:
                if (r108 == false) goto L21;
                r104.encodeIntElement(r103, 1, r102.f348433b);
            L21:
                if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
            L25:
                r106 = true;
            L26:
                if (r106 == false) goto L28;
                r104.encodeIntElement(r103, 2, r102.f348434c);
            L28:
                r104.endStructure(r103);
                return;
            L24:
                if (r102.f348434c == 30) goto L26;
            L15:
                if (r102.f348433b != 720) goto L16;
                r108 = false;
                goto L18
            L6:
                if (r102.f348432a != 1280) goto L7;
                r107 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<p> serializer() {
                return a.f348435a;
            }
        }

        public p() {
            this(0, 7);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof p) == true) goto L8;
            return false;
        L8:
            p r101 = (p) r100;
            if (this.f348432a == r101.f348432a) goto L12;
            return false;
        L12:
            if (this.f348433b == r101.f348433b) goto L15;
            return false;
        L15:
            if (this.f348434c == r101.f348434c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f348432a * 31) + this.f348433b) * 31) + this.f348434c;
        }

        public final String toString() {
            return "RtcVideoConfig(width=" + this.f348432a + ", height=" + this.f348433b + ", fps=" + this.f348434c + ')';
        }

        static {
            Companion = new b();
        }

        public p(int r100, int r101) {
            int r102 = 0;
            if ((r101 & 1) == 0) goto L5;
            int r103 = 1280;
        L7:
            if ((r101 & 2) == 0) goto L10;
            r102 = 720;
        L10:
            if ((r101 & 4) == 0) goto L12;
            r100 = 30;
        L12:
            this.f348432a = r103;
            this.f348433b = r102;
            this.f348434c = r100;
            return;
        L5:
            r103 = 0;
            goto L7
        }

        public p(int r100, int r101, int r102, int r103) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348436b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            r101 = 1280;
        L7:
            this.f348432a = r101;
            if ((r100 & 2) != 0) goto L10;
            this.f348433b = 720;
        L12:
            if ((r100 & 4) != 0) goto L14;
            this.f348434c = 30;
            return;
        L14:
            this.f348434c = r103;
            return;
        L10:
            this.f348433b = r102;
            goto L12
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    @Serializable
    public static final class q {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p f348437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p f348438b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final f f348439c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f348440d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f348441e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final p f348442f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final p f348443g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final f f348444h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final p f348445i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final p f348446j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final f f348447k;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<q> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348448a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348449b = null;

            public a() {
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348449b;
            }

            static {
                a r100 = new a();
                f348448a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowAudioSettingsDelegate.RtcVlmConfig", r100, 11);
                r101.j("capture_config", true);
                r101.j("encoder_config", true);
                r101.j("client_frame_sample_config", true);
                r101.j("enable_client_frame_sample", true);
                r101.j("enable_downgrade_video_fps", true);
                r101.j("medium_capture_config", true);
                r101.j("medium_encoder_config", true);
                r101.j("medium_client_frame_sample_config", true);
                r101.j("lower_capture_config", true);
                r101.j("lower_encoder_config", true);
                r101.j("lower_client_frame_sample_config", true);
                f348449b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                p.a r100 = p.a.f348435a;
                f.a r101 = f.a.f348371a;
                nuc.i r102 = nuc.i.f520705a;
                return new juc.d[]{kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r101), r102, r102, kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r101), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r101)};
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r210) {
                Intrinsics.checkNotNullParameter(r210, "decoder");
                g2 r100 = f348449b;
                muc.c r101 = r210.beginStructure(r100);
                int r102 = 9;
                int r103 = 10;
                int r110 = 8;
                if (r101.decodeSequentially() == false) goto L5;
                p.a r104 = p.a.f348435a;
                p r111 = (p) r101.decodeNullableSerializableElement(r100, 0, r104, null);
                p r112 = (p) r101.decodeNullableSerializableElement(r100, 1, r104, null);
                f.a r113 = f.a.f348371a;
                f r105 = (f) r101.decodeNullableSerializableElement(r100, 2, r113, null);
                boolean r106 = r101.decodeBooleanElement(r100, 3);
                boolean r114 = r101.decodeBooleanElement(r100, 4);
                p r107 = (p) r101.decodeNullableSerializableElement(r100, 5, r104, null);
                p r108 = (p) r101.decodeNullableSerializableElement(r100, 6, r104, null);
                f r109 = (f) r101.decodeNullableSerializableElement(r100, 7, r113, null);
                p r115 = (p) r101.decodeNullableSerializableElement(r100, 8, r104, null);
                p r116 = (p) r101.decodeNullableSerializableElement(r100, 9, r104, null);
                f r117 = (f) r101.decodeNullableSerializableElement(r100, 10, r113, null);
                int r118 = 2047;
                p r119 = r116;
                p r120 = r107;
                p r121 = r108;
                f r122 = r109;
                f r123 = r117;
                p r124 = r115;
                f r125 = r105;
                p r126 = r111;
                boolean r127 = r114;
                p r128 = r112;
                boolean r129 = r106;
            L31:
                r101.endStructure(r100);
                return new q(r118, r126, r128, r125, r129, r127, r120, r121, r122, r124, r119, r123);
            L5:
                f r130 = null;
                p r131 = null;
                f r132 = null;
                p r133 = null;
                p r134 = null;
                f r135 = null;
                p r136 = null;
                p r137 = null;
                p r138 = null;
                boolean r139 = false;
                int r140 = 0;
                boolean r141 = false;
                boolean r211 = true;
            L6:
                if (r211 == false) goto L30;
                int r142 = r101.decodeElementIndex(r100);
                switch(r142) {
                    case -1: goto L29;
                    case 0: goto L26;
                    case 1: goto L24;
                    case 2: goto L23;
                    case 3: goto L21;
                    case 4: goto L20;
                    case 5: goto L19;
                    case 6: goto L17;
                    case 7: goto L15;
                    case 8: goto L14;
                    case 9: goto L13;
                    case 10: goto L11;
                    default: goto L10;
                };
            L10:
                throw new UnknownFieldException(r142);
            L29:
                r102 = 9;
                r103 = 10;
                r110 = 8;
                r211 = false;
                goto L6
            L11:
                r130 = (f) r101.decodeNullableSerializableElement(r100, r103, f.a.f348371a, r130);
                r140 = r140 | 1024;
            L28:
                r138 = r138;
                r102 = 9;
                r103 = 10;
                r110 = 8;
                goto L6
            L13:
                p r143 = (p) r101.decodeNullableSerializableElement(r100, r102, p.a.f348435a, r133);
                r140 = r140 | 512;
                r138 = r138;
                r133 = r143;
                goto L28
            L14:
                r131 = (p) r101.decodeNullableSerializableElement(r100, r110, p.a.f348435a, r131);
                int r144 = r140 | 256;
            L18:
                boolean r212 = r139;
                r140 = r144;
            L22:
                r139 = r212;
                goto L28
            L15:
                r132 = (f) r101.decodeNullableSerializableElement(r100, 7, f.a.f348371a, r132);
                r144 = r140 | 128;
                goto L18
            L17:
                r134 = (p) r101.decodeNullableSerializableElement(r100, 6, p.a.f348435a, r134);
                r144 = r140 | 64;
                goto L18
            L19:
                r136 = (p) r101.decodeNullableSerializableElement(r100, 5, p.a.f348435a, r136);
                r212 = r139;
                r140 = r140 | 32;
                goto L22
            L20:
                r141 = r101.decodeBooleanElement(r100, 4);
                r140 = r140 | 16;
                r212 = r139;
                goto L22
            L21:
                r212 = r101.decodeBooleanElement(r100, 3);
                r140 = r140 | 8;
                goto L22
            L23:
                r135 = (f) r101.decodeNullableSerializableElement(r100, 2, f.a.f348371a, r135);
                int r145 = r140 | 4;
            L25:
                r138 = r138;
            L27:
                r140 = r145;
                goto L28
            L24:
                r138 = (p) r101.decodeNullableSerializableElement(r100, 1, p.a.f348435a, r138);
                r145 = r140 | 2;
                goto L25
            L26:
                r138 = r138;
                r137 = (p) r101.decodeNullableSerializableElement(r100, 0, p.a.f348435a, r137);
                r145 = r140 | 1;
                goto L27
            L30:
                p r146 = r137;
                p r147 = r138;
                r123 = r130;
                r124 = r131;
                r122 = r132;
                r119 = r133;
                r125 = r135;
                r129 = r139;
                r126 = r146;
                r118 = r140;
                r120 = r136;
                r127 = r141;
                r121 = r134;
                r128 = r147;
                goto L31
            }

            @Override // juc.n
            public final void serialize(muc.f r110, Object r111) {
                q r112 = (q) r111;
                Intrinsics.checkNotNullParameter(r110, "encoder");
                Intrinsics.checkNotNullParameter(r112, "value");
                g2 r100 = f348449b;
                muc.d r113 = r110.beginStructure(r100);
                b r101 = q.Companion;
                boolean r102 = false;
                if (r113.shouldEncodeElementDefault(r100, 0) == false) goto L6;
            L7:
                boolean r103 = true;
            L9:
                if (r103 == false) goto L12;
                r113.encodeNullableSerializableElement(r100, 0, p.a.f348435a, r112.f348437a);
            L12:
                if (r113.shouldEncodeElementDefault(r100, 1) == false) goto L15;
            L16:
                boolean r104 = true;
            L18:
                if (r104 == false) goto L21;
                r113.encodeNullableSerializableElement(r100, 1, p.a.f348435a, r112.f348438b);
            L21:
                if (r113.shouldEncodeElementDefault(r100, 2) == false) goto L24;
            L25:
                boolean r105 = true;
            L27:
                if (r105 == false) goto L30;
                r113.encodeNullableSerializableElement(r100, 2, f.a.f348371a, r112.f348439c);
            L30:
                if (r113.shouldEncodeElementDefault(r100, 3) == false) goto L33;
            L34:
                boolean r106 = true;
            L36:
                if (r106 == false) goto L39;
                r113.encodeBooleanElement(r100, 3, r112.f348440d);
            L39:
                if (r113.shouldEncodeElementDefault(r100, 4) == false) goto L42;
            L43:
                boolean r107 = true;
            L45:
                if (r107 == false) goto L48;
                r113.encodeBooleanElement(r100, 4, r112.f348441e);
            L48:
                if (r113.shouldEncodeElementDefault(r100, 5) == false) goto L51;
            L52:
                boolean r108 = true;
            L54:
                if (r108 == false) goto L57;
                r113.encodeNullableSerializableElement(r100, 5, p.a.f348435a, r112.f348442f);
            L57:
                if (r113.shouldEncodeElementDefault(r100, 6) == false) goto L60;
            L61:
                boolean r109 = true;
            L63:
                if (r109 == false) goto L66;
                r113.encodeNullableSerializableElement(r100, 6, p.a.f348435a, r112.f348443g);
            L66:
                if (r113.shouldEncodeElementDefault(r100, 7) == false) goto L69;
            L70:
                boolean r114 = true;
            L72:
                if (r114 == false) goto L75;
                r113.encodeNullableSerializableElement(r100, 7, f.a.f348371a, r112.f348444h);
            L75:
                if (r113.shouldEncodeElementDefault(r100, 8) == false) goto L78;
            L79:
                boolean r115 = true;
            L81:
                if (r115 == false) goto L84;
                r113.encodeNullableSerializableElement(r100, 8, p.a.f348435a, r112.f348445i);
            L84:
                if (r113.shouldEncodeElementDefault(r100, 9) == false) goto L87;
            L88:
                boolean r116 = true;
            L90:
                if (r116 == false) goto L93;
                r113.encodeNullableSerializableElement(r100, 9, p.a.f348435a, r112.f348446j);
            L93:
                if (r113.shouldEncodeElementDefault(r100, 10) == false) goto L96;
            L97:
                r102 = true;
            L98:
                if (r102 == false) goto L100;
                r113.encodeNullableSerializableElement(r100, 10, f.a.f348371a, r112.f348447k);
            L100:
                r113.endStructure(r100);
                return;
            L96:
                if (Intrinsics.areEqual(r112.f348447k, new f(0, 3, 59)) == true) goto L98;
            L87:
                if (Intrinsics.areEqual(r112.f348446j, new p(18, 3)) == false) goto L88;
                r116 = false;
                goto L90
            L78:
                if (Intrinsics.areEqual(r112.f348445i, new p(18, 3)) == false) goto L79;
                r115 = false;
                goto L81
            L69:
                if (Intrinsics.areEqual(r112.f348444h, new f(0, 4, 59)) == false) goto L70;
                r114 = false;
                goto L72
            L60:
                if (Intrinsics.areEqual(r112.f348443g, new p(24, 3)) == false) goto L61;
                r109 = false;
                goto L63
            L51:
                if (Intrinsics.areEqual(r112.f348442f, new p(24, 3)) == false) goto L52;
                r108 = false;
                goto L54
            L42:
                if (r112.f348441e == true) goto L43;
                r107 = false;
                goto L45
            L33:
                if (r112.f348440d != true) goto L34;
                r106 = false;
                goto L36
            L24:
                if (Intrinsics.areEqual(r112.f348439c, new f(0, 0, 63)) == false) goto L25;
                r105 = false;
                goto L27
            L15:
                if (Intrinsics.areEqual(r112.f348438b, new p(0, 7)) == false) goto L16;
                r104 = false;
                goto L18
            L6:
                if (Intrinsics.areEqual(r112.f348437a, new p(0, 7)) == false) goto L7;
                r103 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<q> serializer() {
                return a.f348448a;
            }
        }

        public q() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof q) == true) goto L8;
            return false;
        L8:
            q r101 = (q) r100;
            if (Intrinsics.areEqual(this.f348437a, r101.f348437a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f348438b, r101.f348438b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f348439c, r101.f348439c) == true) goto L18;
            return false;
        L18:
            if (this.f348440d == r101.f348440d) goto L21;
            return false;
        L21:
            if (this.f348441e == r101.f348441e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f348442f, r101.f348442f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f348443g, r101.f348443g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f348444h, r101.f348444h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.f348445i, r101.f348445i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.f348446j, r101.f348446j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.f348447k, r101.f348447k) == true) goto L41;
            return false;
        L41:
            return true;
        }

        public final int hashCode() {
            p r100 = this.f348437a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            p r104 = this.f348438b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            f r107 = this.f348439c;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            int r110 = 1231;
            if (this.f348440d == false) goto L17;
            int r111 = 1231;
        L18:
            int r112 = (r109 + r111) * 31;
            if (this.f348441e == true) goto L22;
            r110 = 1237;
        L22:
            int r113 = (r112 + r110) * 31;
            p r114 = this.f348442f;
            if (r114 != null) goto L25;
            int r115 = 0;
        L26:
            int r116 = (r113 + r115) * 31;
            p r117 = this.f348443g;
            if (r117 != null) goto L29;
            int r118 = 0;
        L30:
            int r119 = (r116 + r118) * 31;
            f r120 = this.f348444h;
            if (r120 != null) goto L33;
            int r121 = 0;
        L34:
            int r122 = (r119 + r121) * 31;
            p r123 = this.f348445i;
            if (r123 != null) goto L37;
            int r124 = 0;
        L38:
            int r125 = (r122 + r124) * 31;
            p r126 = this.f348446j;
            if (r126 != null) goto L41;
            int r127 = 0;
        L42:
            int r128 = (r125 + r127) * 31;
            f r129 = this.f348447k;
            if (r129 == null) goto L47;
            r101 = r129.hashCode();
        L47:
            return r128 + r101;
        L41:
            r127 = r126.hashCode();
            goto L42
        L37:
            r124 = r123.hashCode();
            goto L38
        L33:
            r121 = r120.hashCode();
            goto L34
        L29:
            r118 = r117.hashCode();
            goto L30
        L25:
            r115 = r114.hashCode();
            goto L26
        L17:
            r111 = 1237;
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
            return "RtcVlmConfig(captureConfig=" + this.f348437a + ", encoderConfig=" + this.f348438b + ", clientFrameSampleConfig=" + this.f348439c + ", enableClientFrameSample=" + this.f348440d + ", enableDowngradeVideoFps=" + this.f348441e + ", mediumCaptureConfig=" + this.f348442f + ", mediumEncoderConfig=" + this.f348443g + ", mediumClientFrameSampleConfig=" + this.f348444h + ", lowerCaptureConfig=" + this.f348445i + ", lowerEncoderConfig=" + this.f348446j + ", lowerClientFrameSampleConfig=" + this.f348447k + ')';
        }

        static {
            Companion = new b();
        }

        public q(int r110) {
            p r111 = new p(0, 7);
            p r100 = new p(0, 7);
            f r101 = new f(0, 0, 63);
            p r102 = new p(24, 3);
            p r103 = new p(24, 3);
            f r104 = new f(0, 4, 59);
            p r105 = new p(18, 3);
            p r112 = new p(18, 3);
            f r106 = new f(0, 3, 59);
            this.f348437a = r111;
            this.f348438b = r100;
            this.f348439c = r101;
            this.f348440d = true;
            this.f348441e = false;
            this.f348442f = r102;
            this.f348443g = r103;
            this.f348444h = r104;
            this.f348445i = r105;
            this.f348446j = r112;
            this.f348447k = r106;
        }

        public q(int r100, p r101, p r102, f r103, boolean r104, boolean r105, p r110, p r111, f r112, p r113, p r114, f r115) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348449b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            r101 = new p(0, 7);
        L7:
            this.f348437a = r101;
            if ((r100 & 2) != 0) goto L10;
            r102 = new p(0, 7);
        L10:
            this.f348438b = r102;
            if ((r100 & 4) != 0) goto L13;
            r103 = new f(0, 0, 63);
        L13:
            this.f348439c = r103;
            if ((r100 & 8) != 0) goto L16;
            r104 = true;
        L16:
            this.f348440d = r104;
            if ((r100 & 16) != 0) goto L19;
            this.f348441e = false;
        L21:
            if ((r100 & 32) != 0) goto L23;
            r110 = new p(24, 3);
        L23:
            this.f348442f = r110;
            if ((r100 & 64) != 0) goto L26;
            r111 = new p(24, 3);
        L26:
            this.f348443g = r111;
            if ((r100 & 128) != 0) goto L29;
            r112 = new f(0, 4, 59);
        L29:
            this.f348444h = r112;
            if ((r100 & 256) != 0) goto L32;
            r113 = new p(18, 3);
        L32:
            this.f348445i = r113;
            if ((r100 & 512) != 0) goto L35;
            r114 = new p(18, 3);
        L35:
            this.f348446j = r114;
            if ((r100 & 1024) != 0) goto L38;
            r115 = new f(0, 3, 59);
        L38:
            this.f348447k = r115;
            return;
        L19:
            this.f348441e = r105;
            goto L21
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    @Serializable
    public static final class r {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f348450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f348451b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f348452c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f348453d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f348454e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f348455f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f348456g;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<r> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348457a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348458b = null;

            public a() {
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                nuc.w0 r100 = nuc.w0.f520792a;
                return new juc.d[]{r100, r100, r100, r100, r100, r100, r100};
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348458b;
            }

            static {
                a r100 = new a();
                f348457a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowAudioSettingsDelegate.TrackerTimeoutConfig", r100, 7);
                r101.j(PTYSocketStateCallback.CONNECTED, true);
                r101.j("query_begin", true);
                r101.j("query_update", true);
                r101.j("query_end", true);
                r101.j("reply_begin", true);
                r101.j("reply_update", true);
                r101.j("reply_end", true);
                f348458b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r210) {
                Intrinsics.checkNotNullParameter(r210, "decoder");
                g2 r100 = f348458b;
                muc.c r101 = r210.beginStructure(r100);
                if (r101.decodeSequentially() == false) goto L5;
                int r102 = r101.decodeIntElement(r100, 0);
                int r103 = r101.decodeIntElement(r100, 1);
                int r104 = r101.decodeIntElement(r100, 2);
                int r105 = r101.decodeIntElement(r100, 3);
                int r106 = r101.decodeIntElement(r100, 4);
                int r107 = r101.decodeIntElement(r100, 5);
                int r108 = r102;
                int r110 = r104;
                int r111 = r106;
                int r112 = r103;
                int r113 = r105;
                int r114 = r101.decodeIntElement(r100, 6);
                int r115 = r107;
                int r109 = 127;
            L21:
                r101.endStructure(r100);
                return new r(r109, r108, r112, r110, r113, r111, r115, r114);
            L5:
                int r116 = 0;
                int r117 = 0;
                int r118 = 0;
                int r119 = 0;
                int r120 = 0;
                int r121 = 0;
                int r122 = 0;
                int r123 = 0;
                boolean r124 = true;
            L6:
                if (r124 == false) goto L20;
                int r125 = r101.decodeElementIndex(r100);
                switch(r125) {
                    case -1: goto L19;
                    case 0: goto L18;
                    case 1: goto L16;
                    case 2: goto L15;
                    case 3: goto L14;
                    case 4: goto L13;
                    case 5: goto L12;
                    case 6: goto L11;
                    default: goto L10;
                };
            L10:
                throw new UnknownFieldException(r125);
            L18:
                r116 = r101.decodeIntElement(r100, 0);
                r123 = r123 | 1;
                goto L6
            L19:
                r124 = false;
                goto L6
            L11:
                r121 = r101.decodeIntElement(r100, 6);
                int r126 = r123 | 64;
            L17:
                r123 = r126;
                goto L6
            L12:
                r122 = r101.decodeIntElement(r100, 5);
                r126 = r123 | 32;
                goto L17
            L13:
                r118 = r101.decodeIntElement(r100, 4);
                r126 = r123 | 16;
                goto L17
            L14:
                r120 = r101.decodeIntElement(r100, 3);
                r126 = r123 | 8;
                goto L17
            L15:
                r117 = r101.decodeIntElement(r100, 2);
                r126 = r123 | 4;
                goto L17
            L16:
                r119 = r101.decodeIntElement(r100, 1);
                r126 = r123 | 2;
                goto L17
            L20:
                r108 = r116;
                r109 = r123;
                int r127 = r118;
                r110 = r117;
                r112 = r119;
                r113 = r120;
                r111 = r127;
                int r128 = r122;
                r114 = r121;
                r115 = r128;
                goto L21
            }

            @Override // juc.n
            public final void serialize(muc.f r100, Object r101) {
                r r102 = (r) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                g2 r103 = f348458b;
                muc.d r104 = r100.beginStructure(r103);
                b r105 = r.Companion;
                boolean r106 = false;
                if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
            L7:
                boolean r107 = true;
            L9:
                if (r107 == false) goto L12;
                r104.encodeIntElement(r103, 0, r102.f348450a);
            L12:
                if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
            L16:
                boolean r108 = true;
            L18:
                if (r108 == false) goto L21;
                r104.encodeIntElement(r103, 1, r102.f348451b);
            L21:
                if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
            L25:
                boolean r109 = true;
            L27:
                if (r109 == false) goto L30;
                r104.encodeIntElement(r103, 2, r102.f348452c);
            L30:
                if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
            L34:
                boolean r110 = true;
            L36:
                if (r110 == false) goto L39;
                r104.encodeIntElement(r103, 3, r102.f348453d);
            L39:
                if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L42;
            L43:
                boolean r111 = true;
            L45:
                if (r111 == false) goto L48;
                r104.encodeIntElement(r103, 4, r102.f348454e);
            L48:
                if (r104.shouldEncodeElementDefault(r103, 5) == false) goto L51;
            L52:
                boolean r112 = true;
            L54:
                if (r112 == false) goto L57;
                r104.encodeIntElement(r103, 5, r102.f348455f);
            L57:
                if (r104.shouldEncodeElementDefault(r103, 6) == false) goto L60;
            L61:
                r106 = true;
            L62:
                if (r106 == false) goto L64;
                r104.encodeIntElement(r103, 6, r102.f348456g);
            L64:
                r104.endStructure(r103);
                return;
            L60:
                if (r102.f348456g == 600) goto L62;
            L51:
                if (r102.f348455f != 60) goto L52;
                r112 = false;
                goto L54
            L42:
                if (r102.f348454e != 60) goto L43;
                r111 = false;
                goto L45
            L33:
                if (r102.f348453d != 60) goto L34;
                r110 = false;
                goto L36
            L24:
                if (r102.f348452c != 60) goto L25;
                r109 = false;
                goto L27
            L15:
                if (r102.f348451b != 60) goto L16;
                r108 = false;
                goto L18
            L6:
                if (r102.f348450a != 600) goto L7;
                r107 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<r> serializer() {
                return a.f348457a;
            }
        }

        public r() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof r) == true) goto L8;
            return false;
        L8:
            r r101 = (r) r100;
            if (this.f348450a == r101.f348450a) goto L12;
            return false;
        L12:
            if (this.f348451b == r101.f348451b) goto L15;
            return false;
        L15:
            if (this.f348452c == r101.f348452c) goto L18;
            return false;
        L18:
            if (this.f348453d == r101.f348453d) goto L21;
            return false;
        L21:
            if (this.f348454e == r101.f348454e) goto L24;
            return false;
        L24:
            if (this.f348455f == r101.f348455f) goto L27;
            return false;
        L27:
            if (this.f348456g == r101.f348456g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            return (((((((((((this.f348450a * 31) + this.f348451b) * 31) + this.f348452c) * 31) + this.f348453d) * 31) + this.f348454e) * 31) + this.f348455f) * 31) + this.f348456g;
        }

        public final String toString() {
            return "TrackerTimeoutConfig(connected=" + this.f348450a + ", queryBegin=" + this.f348451b + ", queryUpdate=" + this.f348452c + ", queryEnd=" + this.f348453d + ", replyBegin=" + this.f348454e + ", replyUpdate=" + this.f348455f + ", replyEnd=" + this.f348456g + ')';
        }

        static {
            Companion = new b();
        }

        public r(int r100) {
            this.f348450a = 600;
            this.f348451b = 60;
            this.f348452c = 60;
            this.f348453d = 60;
            this.f348454e = 60;
            this.f348455f = 60;
            this.f348456g = 600;
        }

        public r(int r100, int r101, int r102, int r103, int r104, int r105, int r106, int r110) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348458b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            this.f348450a = 600;
        L9:
            if ((r100 & 2) != 0) goto L11;
            this.f348451b = 60;
        L13:
            if ((r100 & 4) != 0) goto L15;
            this.f348452c = 60;
        L17:
            if ((r100 & 8) != 0) goto L19;
            this.f348453d = 60;
        L21:
            if ((r100 & 16) != 0) goto L23;
            this.f348454e = 60;
        L25:
            if ((r100 & 32) != 0) goto L27;
            this.f348455f = 60;
        L29:
            if ((r100 & 64) != 0) goto L31;
            this.f348456g = 600;
            return;
        L31:
            this.f348456g = r110;
            return;
        L27:
            this.f348455f = r106;
            goto L29
        L23:
            this.f348454e = r105;
            goto L25
        L19:
            this.f348453d = r104;
            goto L21
        L15:
            this.f348452c = r103;
            goto L17
        L11:
            this.f348451b = r102;
            goto L13
        L7:
            this.f348450a = r101;
            goto L9
        }
    }

    public static List a() {
        return CollectionsKt.listOf(new Integer[]{1, 12003, 12004, 12005, 12006, Integer.valueOf(AvCmd.CommandEventType.TTS_PLAYBACK_RESUME_VALUE)});
    }

    public static Map b() {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("10002", CollectionsKt.listOf(10003)), TuplesKt.to("10003", CollectionsKt.listOf(10002)), TuplesKt.to("10004", CollectionsKt.listOf(10005)), TuplesKt.to("10005", CollectionsKt.listOf(10004)), TuplesKt.to("24001", CollectionsKt.listOf(Integer.valueOf(AvCmd.CommandEventType.SWITCH_MODAL_VALUE))), TuplesKt.to("24003", CollectionsKt.listOf(Integer.valueOf(AvCmd.CommandEventType.SWITCH_SCENE_VALUE)))});
    }

    static {
        f348265a = LazyKt.lazy(new com.larus.im.internal.delegate.d());
        f348266b = LazyKt.lazy(new com.larus.im.internal.delegate.q());
        f348267c = "is_fix_start_session_enable";
        f348273i = LazyKt.lazy(new com.larus.im.internal.delegate.r());
        f348274j = LazyKt.lazy(new s());
        f348275k = LazyKt.lazy(new com.larus.im.internal.delegate.e());
        f348276l = LazyKt.lazy(new com.larus.im.internal.delegate.f());
        f348277m = LazyKt.lazy(new com.larus.im.internal.delegate.g());
        f348278n = LazyKt.lazy(new com.larus.im.internal.delegate.h());
        f348279o = LazyKt.lazy(new com.larus.im.internal.delegate.i());
        f348280p = LazyKt.lazy(new com.larus.im.internal.delegate.j());
        f348281q = LazyKt.lazy(new com.larus.im.internal.delegate.k());
        f348282r = LazyKt.lazy(new com.larus.im.internal.delegate.l());
        f348283s = LazyKt.lazy(new com.larus.im.internal.delegate.m());
        f348284t = LazyKt.lazy(new com.larus.im.internal.delegate.n());
        f348285u = LazyKt.lazy(new com.larus.im.internal.delegate.o());
        f348286v = LazyKt.lazy(new com.larus.im.internal.delegate.p());
    }

    public static Map d() {
        return ((gd9.s) f348266b.getValue()).k();
    }

    public static int g() {
        Integer r100 = f348272h;
        if (r100 == null) goto L20;
        return r100.intValue();
    L20:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        Object r102 = Result.m9449constructorimpl(Integer.valueOf(sf9.a.b(sf9.a.f(q().getValue("voice_call_hello_trigger_wait_time", SliceInitService.DEFAULT_SWITCH)), "wait_time", -1)));     // Catch: Throwable -> L9
    L11:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L15;
        a0.a().b("FlowAudioSettingsDelegate", "getCallHelloTriggerWaitTime(): err=" + r103.getMessage());
    L15:
        if (Result.m9452exceptionOrNullimpl(r102) == null) goto L18;
        r102 = -1;
    L18:
        int r104 = ((Number) r102).intValue();
        f348272h = Integer.valueOf(r104);
        return r104;
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static boolean h() {
        return ((Boolean) f348275k.getValue()).booleanValue();
    }

    public static g i() {
        g r100 = f348271g;
        if (r100 == null) goto L22;
        return r100;
    L22:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
        String r102 = q().getValue("flow_av_internal_media_config", SliceInitService.DEFAULT_SWITCH);     // Catch: Throwable -> L11
        wt7.c r103 = wt7.a.f561230a;     // Catch: Throwable -> L11
        String r104 = r102.toString();     // Catch: Throwable -> L11
        juc.d<g> r105 = g.Companion.serializer();     // Catch: Throwable -> L11
        r103.getClass();     // Catch: Throwable -> L11
        g r106 = (g) wt7.c.a(r104, r105);     // Catch: Throwable -> L11
        if (r106 != null) goto L9;
        r106 = new g(0);     // Catch: Throwable -> L11
    L9:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L11
    L13:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L17;
        a0.a().b("FlowAudioSettingsDelegate", "getInternalMediaConfig(): err=" + r108.getMessage());
    L17:
        if (Result.m9452exceptionOrNullimpl(r107) == null) goto L20;
        r107 = new g(0);
    L20:
        g r109 = (g) r107;
        f348271g = r109;
        return r109;
    L11:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static e j() {
        return (e) f348274j.getValue();
    }

    public static i k() {
        i r100 = f348269e;
        if (r100 == null) goto L22;
        return r100;
    L22:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
        String r102 = q().getValue("flow_mmt_vlm_config", SliceInitService.DEFAULT_SWITCH);     // Catch: Throwable -> L11
        wt7.c r103 = wt7.a.f561230a;     // Catch: Throwable -> L11
        juc.d<i> r104 = i.Companion.serializer();     // Catch: Throwable -> L11
        r103.getClass();     // Catch: Throwable -> L11
        i r105 = (i) wt7.c.a(r102, r104);     // Catch: Throwable -> L11
        if (r105 != null) goto L9;
        r105 = new i(0);     // Catch: Throwable -> L11
    L9:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L11
    L13:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L17;
        a0.a().b("FlowAudioSettingsDelegate", "getMmtVlmConfig(): err=" + r107.getMessage());
    L17:
        if (Result.m9452exceptionOrNullimpl(r106) == null) goto L20;
        r106 = new i(0);
    L20:
        i r108 = (i) r106;
        f348269e = r108;
        return r108;
    L11:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static q p() {
        q r100 = f348268d;
        if (r100 == null) goto L22;
        return r100;
    L22:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
        String r102 = q().getValue("flow_rtc_vlm_config", SliceInitService.DEFAULT_SWITCH);     // Catch: Throwable -> L11
        wt7.c r103 = wt7.a.f561230a;     // Catch: Throwable -> L11
        juc.d<q> r104 = q.Companion.serializer();     // Catch: Throwable -> L11
        r103.getClass();     // Catch: Throwable -> L11
        q r105 = (q) wt7.c.a(r102, r104);     // Catch: Throwable -> L11
        if (r105 != null) goto L9;
        r105 = new q(0);     // Catch: Throwable -> L11
    L9:
        Object r106 = Result.m9449constructorimpl(r105);     // Catch: Throwable -> L11
    L13:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L17;
        a0.a().b("FlowAudioSettingsDelegate", "getRtcVlmConfig(): err=" + r107.getMessage());
    L17:
        if (Result.m9452exceptionOrNullimpl(r106) == null) goto L20;
        r106 = new q(0);
    L20:
        q r108 = (q) r106;
        f348268d = r108;
        return r108;
    L11:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static gd9.y q() {
        return (gd9.y) f348265a.getValue();
    }

    public static boolean c() {
        c r100 = j().f348360e;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.f348336h;
    }

    public static boolean e() {
        Map r100 = r();
        if (r100 == null) goto L8;
        Object r101 = r100.get("enable_rtc_dump");
        if (r101 != null) goto L10;
        r101 = Boolean.FALSE;
    L10:
        return Intrinsics.areEqual(r101, Boolean.TRUE);
    L8:
        return false;
    }

    public static long f() {
        if (c() == true) goto L14;
        Map r100 = d();
        if (r100 == null) goto L14;
        if (r100.containsKey("destroy_engine_delay_ms") == false) goto L14;
        String r101 = (String) r100.get("destroy_engine_delay_ms");
        if (r101 == null) goto L18;
        Long r102 = StringsKt.toLongOrNull(r101);
        if (r102 != null) goto L13;
        return 0;
    L13:
        return r102.longValue();
    L18:
        return 0;
    L14:
        c r103 = j().f348360e;
        if (r103 != null) goto L17;
        return 0;
    L17:
        return r103.f348334f;
    }

    public static int l() {
        if (c() == true) goto L15;
        Map r100 = d();
        if (r100 == null) goto L15;
        if (r100.containsKey("token_retry_count") == false) goto L15;
        String r101 = (String) r100.get("token_retry_count");
        if (r101 == null) goto L11;
        Integer r102 = StringsKt.toIntOrNull(r101);
    L12:
        if (r102 == null) goto L15;
        a0.a().e("FlowAudioSettingsDelegate", "return realtime retry count: " + r102);
        return r102.intValue();
    L11:
        r102 = null;
    L15:
        b r103 = j().f348359d;
        if (r103 != null) goto L20;
        return 2;
    L20:
        return r103.f348323l;
    }

    public static long m() {
        if (c() == true) goto L14;
        Map r100 = d();
        if (r100 == null) goto L14;
        if (r100.containsKey("token_retry_interval") == false) goto L14;
        String r101 = (String) r100.get("token_retry_interval");
        if (r101 == null) goto L11;
        Long r102 = StringsKt.toLongOrNull(r101);
    L12:
        if (r102 == null) goto L14;
        a0.a().e("FlowAudioSettingsDelegate", "return realtime retry interval: " + r102);
        long r103 = r102.longValue();
        long r104 = (long) 1000;
    L20:
        return r103 * r104;
    L11:
        r102 = null;
    L14:
        b r105 = j().f348359d;
        if (r105 == null) goto L17;
        int r106 = r105.f348324m;
    L18:
        r103 = r106;
        r104 = 1000;
        goto L20
    L17:
        r106 = 1;
        goto L18
    }

    public static p n() {
        p r100 = p().f348437a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new p(0, 7);
    }

    public static p o() {
        p r100 = p().f348438b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new p(0, 7);
    }

    public static Map r() {
        l r100 = j().f348356a;
        if (r100 == null) goto L10;
        ouc.d0 r101 = r100.f348404a;
        if (r101 == null) goto L10;
        Map r102 = s(r101);
        LinkedHashMap r103 = new LinkedHashMap(MapsKt.mapCapacity(r102.size()));
        Iterator r104 = ((LinkedHashMap) r102).entrySet().iterator();
    L8:
        if (r104.hasNext() == false) goto L13;
        Map.Entry r105 = (Map.Entry) r104.next();
        r103.put((String) r105.getKey(), r105.getValue());
        goto L8
    L13:
        return r103;
    L10:
        return null;
    }

    public static Map s(ouc.d0 r100) {
        Set<Map.Entry<String, ouc.i>> r101 = r100.entrySet();
        LinkedHashMap r102 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r101, 10)), 16));
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        Map.Entry r104 = (Map.Entry) r103.next();
        Pair r105 = TuplesKt.to((String) r104.getKey(), t((ouc.i) r104.getValue()));
        r102.put(r105.getFirst(), r105.getSecond());
        goto L4
    L6:
        return r102;
    }

    public static Object t(ouc.i r100) {
        if (Intrinsics.areEqual(r100, ouc.a0.INSTANCE) == false) goto L6;
        return null;
    L6:
        if ((r100 instanceof ouc.d0) == true) goto L38;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L14
        ouc.b r102 = ouc.k.m(r100);     // Catch: Throwable -> L14
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));     // Catch: Throwable -> L14
        Iterator<ouc.i> r104 = r102.iterator();     // Catch: Throwable -> L14
    L10:
        if (r104.hasNext() == false) goto L12;
        r103.add(t(r104.next()));     // Catch: Throwable -> L14
        goto L10
    L12:
        Object r105 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L14
    L17:
        if (Result.m9452exceptionOrNullimpl(r105) == null) goto L39;
        ouc.g0 r106 = ouc.k.o(r100);
        if (r106.c() == true) goto L40;
        String r107 = ouc.k.g(r106);
        if (r107 != null) goto L25;
        r107 = "";
    L25:
        Object r108 = StringsKt.toBooleanStrictOrNull(r107);
        if (r108 != null) goto L33;
        r108 = StringsKt.toLongOrNull(r107);
        if (r108 != null) goto L33;
        r105 = StringsKt.toDoubleOrNull(r107);
        if (r105 != null) goto L39;
        return ouc.k.g(r106);
    L33:
        return r108;
    L40:
        return ouc.k.g(r106);
    L39:
        return r105;
    L14:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    L38:
        return s((ouc.d0) r100);
    }
}
