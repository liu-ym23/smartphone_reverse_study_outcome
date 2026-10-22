package md6;

import androidx.camera.video.AudioStats;
import com.ttnet.org.chromium.net.impl.URLDispatch;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.v2;

/* JADX INFO: loaded from: classes19.dex */
@Serializable
public final class f1 implements c {
    public static final Lazy<juc.d<Object>>[] B = null;
    public static final b Companion = null;
    public final long A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f513326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f513327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f513328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f513329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final double f513330e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final double f513331f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final double f513332g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f513333h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f513334i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f513335j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f513336k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f513337l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f513338m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f513339n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f513340o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final long f513341p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f513342q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final long f513343r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f513344s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final long f513345t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final long f513346u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f513347v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f513348w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f513349x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final long f513350y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final long f513351z;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<f1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f513352a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f513353b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f513353b;
        }

        static {
            a r100 = new a();
            f513352a = r100;
            g2 r101 = new g2("com.bytedance.kmp.performance.model.KPerfMemoryData", r100, 27);
            r101.j("scene", true);
            r101.j("custom_params", true);
            r101.j("alive_second", true);
            r101.j(URLDispatch.KEY_EPOCH, true);
            r101.j("duration", true);
            r101.j("pause_time", true);
            r101.j("second_pause_time", true);
            r101.j("mark_count", true);
            r101.j("root_thread_local_ref_count", true);
            r101.j("root_stack_ref_count", true);
            r101.j("root_global_ref_count", true);
            r101.j("root_stable_ref_count", true);
            r101.j("memory_usage_before_heap", true);
            r101.j("memory_usage_after_heap", true);
            r101.j("heap_swept_count", true);
            r101.j("heap_kept_count", true);
            r101.j("extra_swept_count", true);
            r101.j("extra_kept_count", true);
            r101.j("system_total_mem", true);
            r101.j("system_free_mem", true);
            r101.j("system_available_mem", true);
            r101.j("app_native_rss", true);
            r101.j("app_native_pss", true);
            r101.j("app_native_shared_dirty", true);
            r101.j("app_total_pss", true);
            r101.j("app_vm_pss", true);
            r101.j("app_other_pss", true);
            f513353b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r100 = f1.B;
            nuc.g1 r101 = nuc.g1.f520681a;
            nuc.b0 r102 = nuc.b0.f520644a;
            return new juc.d[]{v2.f520790a, kuc.a.d(r100[1].getValue()), r101, nuc.w0.f520792a, r102, r102, r102, r101, r101, r101, r101, r101, r101, r101, r101, r101, r101, r101, r101, r101, r101, r101, r101, r101, r101, r101, r101};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r810) {
            Intrinsics.checkNotNullParameter(r810, "decoder");
            g2 r100 = f513353b;
            muc.c r101 = r810.beginStructure(r100);
            Lazy<juc.d<Object>>[] r102 = f1.B;
            int r103 = 6;
            if (r101.decodeSequentially() == false) goto L5;
            String r104 = r101.decodeStringElement(r100, 0);
            Map r105 = (Map) r101.decodeNullableSerializableElement(r100, 1, r102[1].getValue(), null);
            long r110 = r101.decodeLongElement(r100, 2);
            int r106 = r101.decodeIntElement(r100, 3);
            double r107 = r101.decodeDoubleElement(r100, 4);
            double r310 = r101.decodeDoubleElement(r100, 5);
            double r108 = r101.decodeDoubleElement(r100, 6);
            long r311 = r101.decodeLongElement(r100, 7);
            long r111 = r101.decodeLongElement(r100, 8);
            long r112 = r101.decodeLongElement(r100, 9);
            long r312 = r101.decodeLongElement(r100, 10);
            long r313 = r101.decodeLongElement(r100, 11);
            long r210 = r101.decodeLongElement(r100, 12);
            long r314 = r101.decodeLongElement(r100, 13);
            long r211 = r101.decodeLongElement(r100, 14);
            long r410 = r101.decodeLongElement(r100, 15);
            long r212 = r101.decodeLongElement(r100, 16);
            long r411 = r101.decodeLongElement(r100, 17);
            long r213 = r101.decodeLongElement(r100, 18);
            long r412 = r101.decodeLongElement(r100, 19);
            long r214 = r101.decodeLongElement(r100, 20);
            long r413 = r101.decodeLongElement(r100, 21);
            long r113 = r101.decodeLongElement(r100, 22);
            long r414 = r101.decodeLongElement(r100, 23);
            long r114 = r101.decodeLongElement(r100, 24);
            long r510 = r114;
            long r511 = r414;
            long r610 = r101.decodeLongElement(r100, 25);
            long r611 = r101.decodeLongElement(r100, 26);
            int r115 = r106;
            long r512 = r113;
            long r513 = r214;
            double r215 = r310;
            long r514 = r413;
            double r116 = r107;
            long r415 = r412;
            long r416 = r213;
            long r417 = r411;
            double r216 = r108;
            Map r117 = r105;
            long r118 = r110;
            int r119 = 134217727;
            String r120 = r104;
            long r418 = r410;
            long r419 = r212;
            long r217 = r311;
            long r315 = r313;
            long r316 = r211;
            long r218 = r111;
            long r317 = r314;
            long r318 = r210;
            long r319 = r312;
            long r219 = r112;
        L48:
            r101.endStructure(r100);
            return new f1(r119, r120, r117, r118, r115, r116, r215, r216, r217, r218, r219, r319, r315, r318, r317, r316, r418, r419, r417, r416, r415, r513, r514, r512, r511, r510, r610, r611);
        L5:
            int r109 = 26;
            double r320 = AudioStats.AUDIO_AMPLITUDE_NONE;
            Map r121 = null;
            long r321 = 0;
            long r322 = 0;
            long r420 = 0;
            long r421 = 0;
            long r422 = 0;
            long r423 = 0;
            long r424 = 0;
            long r515 = 0;
            long r516 = 0;
            long r517 = 0;
            long r518 = 0;
            long r612 = 0;
            long r613 = 0;
            long r614 = 0;
            long r615 = 0;
            long r616 = 0;
            long r710 = 0;
            long r711 = 0;
            long r712 = 0;
            long r713 = 0;
            long r714 = 0;
            double r323 = 0.0d;
            double r519 = 0.0d;
            r119 = 0;
            boolean r811 = true;
            String r324 = null;
            int r122 = 0;
        L6:
            if (r811 == false) goto L47;
            int r123 = r101.decodeElementIndex(r100);
            switch(r123) {
                case -1: goto L45;
                case 0: goto L44;
                case 1: goto L42;
                case 2: goto L40;
                case 3: goto L38;
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
                case 17: goto L21;
                case 18: goto L20;
                case 19: goto L19;
                case 20: goto L18;
                case 21: goto L16;
                case 22: goto L15;
                case 23: goto L14;
                case 24: goto L13;
                case 25: goto L12;
                case 26: goto L11;
                default: goto L10;
            };
        L11:
            r714 = r101.decodeLongElement(r100, r109);
            int r124 = 67108864;
        L25:
            r119 = r119 | r124;
        L39:
            Unit r125 = Unit.INSTANCE;
        L46:
            r109 = 26;
            r103 = 6;
            goto L6
        L12:
            r713 = r101.decodeLongElement(r100, 25);
            r124 = 33554432;
            goto L25
        L13:
            r421 = r101.decodeLongElement(r100, 24);
            r124 = 16777216;
            goto L25
        L14:
            r712 = r101.decodeLongElement(r100, 23);
            r124 = 8388608;
            goto L25
        L15:
            r422 = r101.decodeLongElement(r100, 22);
            r124 = 4194304;
            goto L25
        L16:
            r711 = r101.decodeLongElement(r100, 21);
            r124 = 2097152;
            goto L25
        L18:
            r423 = r101.decodeLongElement(r100, 20);
            r124 = 1048576;
            goto L25
        L19:
            r710 = r101.decodeLongElement(r100, 19);
            r124 = 524288;
            goto L25
        L20:
            r424 = r101.decodeLongElement(r100, 18);
            r124 = 262144;
            goto L25
        L21:
            r616 = r101.decodeLongElement(r100, 17);
            r124 = 131072;
            goto L25
        L22:
            r515 = r101.decodeLongElement(r100, 16);
            r124 = 65536;
            goto L25
        L24:
            r615 = r101.decodeLongElement(r100, 15);
            r124 = 32768;
            goto L25
        L26:
            r516 = r101.decodeLongElement(r100, 14);
            r119 = r119 | 16384;
            goto L39
        L27:
            r614 = r101.decodeLongElement(r100, 13);
            r119 = r119 | 8192;
            goto L39
        L29:
            r517 = r101.decodeLongElement(r100, 12);
            r119 = r119 | 4096;
            goto L39
        L30:
            r613 = r101.decodeLongElement(r100, 11);
            r119 = r119 | 2048;
            goto L39
        L31:
            r612 = r101.decodeLongElement(r100, 10);
            r119 = r119 | 1024;
            goto L39
        L32:
            r420 = r101.decodeLongElement(r100, 9);
            r119 = r119 | 512;
            goto L39
        L33:
            r321 = r101.decodeLongElement(r100, 8);
            r119 = r119 | 256;
            goto L39
        L34:
            r518 = r101.decodeLongElement(r100, 7);
            r119 = r119 | 128;
            goto L39
        L35:
            r320 = r101.decodeDoubleElement(r100, r103);
            r119 = r119 | 64;
            goto L39
        L36:
            r519 = r101.decodeDoubleElement(r100, 5);
            r119 = r119 | 32;
            goto L39
        L37:
            r323 = r101.decodeDoubleElement(r100, 4);
            r119 = r119 | 16;
            goto L39
        L38:
            r122 = r101.decodeIntElement(r100, 3);
            r119 = r119 | 8;
            goto L39
        L40:
            r322 = r101.decodeLongElement(r100, 2);
            r119 = r119 | 4;
            Unit r126 = Unit.INSTANCE;
            goto L46
        L42:
            r121 = (Map) r101.decodeNullableSerializableElement(r100, 1, r102[1].getValue(), r121);
            int r127 = r119 | 2;
            Unit r128 = Unit.INSTANCE;
            r119 = r127;
            goto L46
        L44:
            String r129 = r101.decodeStringElement(r100, 0);
            r119 = r119 | 1;
            Unit r325 = Unit.INSTANCE;
            r324 = r129;
            goto L46
        L45:
            Unit r130 = Unit.INSTANCE;
            r811 = false;
            goto L46
        L10:
            throw new UnknownFieldException(r123);
        L47:
            r115 = r122;
            r117 = r121;
            r120 = r324;
            r216 = r320;
            r116 = r323;
            r218 = r321;
            r118 = r322;
            r219 = r420;
            r316 = r516;
            r318 = r517;
            r215 = r519;
            r217 = r518;
            r319 = r612;
            r315 = r613;
            r317 = r614;
            r418 = r615;
            r511 = r712;
            r610 = r713;
            r611 = r714;
            r510 = r421;
            r512 = r422;
            r419 = r515;
            r417 = r616;
            r514 = r711;
            r415 = r710;
            r513 = r423;
            r416 = r424;
            goto L48
        }

        @Override // juc.n
        public final void serialize(muc.f r110, Object r111) {
            f1 r112 = (f1) r111;
            Intrinsics.checkNotNullParameter(r110, "encoder");
            Intrinsics.checkNotNullParameter(r112, "value");
            g2 r100 = f513353b;
            muc.d r113 = r110.beginStructure(r100);
            Lazy<juc.d<Object>>[] r101 = f1.B;
            boolean r102 = false;
            if (r113.shouldEncodeElementDefault(r100, 0) == false) goto L6;
        L7:
            boolean r103 = true;
        L9:
            if (r103 == false) goto L12;
            r113.encodeStringElement(r100, 0, r112.f513326a);
        L12:
            if (r113.shouldEncodeElementDefault(r100, 1) == false) goto L15;
        L16:
            boolean r104 = true;
        L18:
            if (r104 == false) goto L21;
            r113.encodeNullableSerializableElement(r100, 1, r101[1].getValue(), r112.f513327b);
        L21:
            if (r113.shouldEncodeElementDefault(r100, 2) == false) goto L24;
        L25:
            boolean r105 = true;
        L27:
            if (r105 == false) goto L30;
            r113.encodeLongElement(r100, 2, r112.f513328c);
        L30:
            if (r113.shouldEncodeElementDefault(r100, 3) == false) goto L33;
        L34:
            boolean r106 = true;
        L36:
            if (r106 == false) goto L39;
            r113.encodeIntElement(r100, 3, r112.f513329d);
        L39:
            if (r113.shouldEncodeElementDefault(r100, 4) == false) goto L42;
        L43:
            boolean r107 = true;
        L45:
            if (r107 == false) goto L48;
            r113.encodeDoubleElement(r100, 4, r112.f513330e);
        L48:
            if (r113.shouldEncodeElementDefault(r100, 5) == false) goto L51;
        L52:
            boolean r108 = true;
        L54:
            if (r108 == false) goto L57;
            r113.encodeDoubleElement(r100, 5, r112.f513331f);
        L57:
            if (r113.shouldEncodeElementDefault(r100, 6) == false) goto L60;
        L61:
            boolean r109 = true;
        L63:
            if (r109 == false) goto L66;
            r113.encodeDoubleElement(r100, 6, r112.f513332g);
        L66:
            if (r113.shouldEncodeElementDefault(r100, 7) == false) goto L69;
        L70:
            boolean r114 = true;
        L72:
            if (r114 == false) goto L75;
            r113.encodeLongElement(r100, 7, r112.f513333h);
        L75:
            if (r113.shouldEncodeElementDefault(r100, 8) == false) goto L78;
        L79:
            boolean r115 = true;
        L81:
            if (r115 == false) goto L84;
            r113.encodeLongElement(r100, 8, r112.f513334i);
        L84:
            if (r113.shouldEncodeElementDefault(r100, 9) == false) goto L87;
        L88:
            boolean r116 = true;
        L90:
            if (r116 == false) goto L93;
            r113.encodeLongElement(r100, 9, r112.f513335j);
        L93:
            if (r113.shouldEncodeElementDefault(r100, 10) == false) goto L96;
        L97:
            boolean r117 = true;
        L99:
            if (r117 == false) goto L102;
            r113.encodeLongElement(r100, 10, r112.f513336k);
        L102:
            if (r113.shouldEncodeElementDefault(r100, 11) == false) goto L105;
        L106:
            boolean r118 = true;
        L108:
            if (r118 == false) goto L111;
            r113.encodeLongElement(r100, 11, r112.f513337l);
        L111:
            if (r113.shouldEncodeElementDefault(r100, 12) == false) goto L114;
        L115:
            boolean r119 = true;
        L117:
            if (r119 == false) goto L120;
            r113.encodeLongElement(r100, 12, r112.f513338m);
        L120:
            if (r113.shouldEncodeElementDefault(r100, 13) == false) goto L123;
        L124:
            boolean r120 = true;
        L126:
            if (r120 == false) goto L129;
            r113.encodeLongElement(r100, 13, r112.f513339n);
        L129:
            if (r113.shouldEncodeElementDefault(r100, 14) == false) goto L132;
        L133:
            boolean r121 = true;
        L135:
            if (r121 == false) goto L138;
            r113.encodeLongElement(r100, 14, r112.f513340o);
        L138:
            if (r113.shouldEncodeElementDefault(r100, 15) == false) goto L141;
        L142:
            boolean r122 = true;
        L144:
            if (r122 == false) goto L147;
            r113.encodeLongElement(r100, 15, r112.f513341p);
        L147:
            if (r113.shouldEncodeElementDefault(r100, 16) == false) goto L150;
        L151:
            boolean r123 = true;
        L153:
            if (r123 == false) goto L156;
            r113.encodeLongElement(r100, 16, r112.f513342q);
        L156:
            if (r113.shouldEncodeElementDefault(r100, 17) == false) goto L159;
        L160:
            boolean r124 = true;
        L162:
            if (r124 == false) goto L165;
            r113.encodeLongElement(r100, 17, r112.f513343r);
        L165:
            if (r113.shouldEncodeElementDefault(r100, 18) == false) goto L168;
        L169:
            boolean r125 = true;
        L171:
            if (r125 == false) goto L174;
            r113.encodeLongElement(r100, 18, r112.f513344s);
        L174:
            if (r113.shouldEncodeElementDefault(r100, 19) == false) goto L177;
        L178:
            boolean r126 = true;
        L180:
            if (r126 == false) goto L183;
            r113.encodeLongElement(r100, 19, r112.f513345t);
        L183:
            if (r113.shouldEncodeElementDefault(r100, 20) == false) goto L186;
        L187:
            boolean r127 = true;
        L189:
            if (r127 == false) goto L192;
            r113.encodeLongElement(r100, 20, r112.f513346u);
        L192:
            if (r113.shouldEncodeElementDefault(r100, 21) == false) goto L195;
        L196:
            boolean r128 = true;
        L198:
            if (r128 == false) goto L201;
            r113.encodeLongElement(r100, 21, r112.f513347v);
        L201:
            if (r113.shouldEncodeElementDefault(r100, 22) == false) goto L204;
        L205:
            boolean r129 = true;
        L207:
            if (r129 == false) goto L210;
            r113.encodeLongElement(r100, 22, r112.f513348w);
        L210:
            if (r113.shouldEncodeElementDefault(r100, 23) == false) goto L213;
        L214:
            boolean r130 = true;
        L216:
            if (r130 == false) goto L219;
            r113.encodeLongElement(r100, 23, r112.f513349x);
        L219:
            if (r113.shouldEncodeElementDefault(r100, 24) == false) goto L222;
        L223:
            boolean r131 = true;
        L225:
            if (r131 == false) goto L228;
            r113.encodeLongElement(r100, 24, r112.f513350y);
        L228:
            if (r113.shouldEncodeElementDefault(r100, 25) == false) goto L231;
        L232:
            boolean r132 = true;
        L234:
            if (r132 == false) goto L237;
            r113.encodeLongElement(r100, 25, r112.f513351z);
        L237:
            if (r113.shouldEncodeElementDefault(r100, 26) == false) goto L240;
        L241:
            r102 = true;
        L242:
            if (r102 == false) goto L244;
            r113.encodeLongElement(r100, 26, r112.A);
        L244:
            r113.endStructure(r100);
            return;
        L240:
            if (r112.A == 0) goto L242;
        L231:
            if (r112.f513351z != 0) goto L232;
            r132 = false;
            goto L234
        L222:
            if (r112.f513350y != 0) goto L223;
            r131 = false;
            goto L225
        L213:
            if (r112.f513349x != 0) goto L214;
            r130 = false;
            goto L216
        L204:
            if (r112.f513348w != 0) goto L205;
            r129 = false;
            goto L207
        L195:
            if (r112.f513347v != 0) goto L196;
            r128 = false;
            goto L198
        L186:
            if (r112.f513346u != 0) goto L187;
            r127 = false;
            goto L189
        L177:
            if (r112.f513345t != 0) goto L178;
            r126 = false;
            goto L180
        L168:
            if (r112.f513344s != 0) goto L169;
            r125 = false;
            goto L171
        L159:
            if (r112.f513343r != 0) goto L160;
            r124 = false;
            goto L162
        L150:
            if (r112.f513342q != 0) goto L151;
            r123 = false;
            goto L153
        L141:
            if (r112.f513341p != 0) goto L142;
            r122 = false;
            goto L144
        L132:
            if (r112.f513340o != 0) goto L133;
            r121 = false;
            goto L135
        L123:
            if (r112.f513339n != 0) goto L124;
            r120 = false;
            goto L126
        L114:
            if (r112.f513338m != 0) goto L115;
            r119 = false;
            goto L117
        L105:
            if (r112.f513337l != 0) goto L106;
            r118 = false;
            goto L108
        L96:
            if (r112.f513336k != 0) goto L97;
            r117 = false;
            goto L99
        L87:
            if (r112.f513335j != 0) goto L88;
            r116 = false;
            goto L90
        L78:
            if (r112.f513334i != 0) goto L79;
            r115 = false;
            goto L81
        L69:
            if (r112.f513333h != 0) goto L70;
            r114 = false;
            goto L72
        L60:
            if (Double.compare(r112.f513332g, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) goto L61;
            r109 = false;
            goto L63
        L51:
            if (Double.compare(r112.f513331f, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) goto L52;
            r108 = false;
            goto L54
        L42:
            if (Double.compare(r112.f513330e, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) goto L43;
            r107 = false;
            goto L45
        L33:
            if (r112.f513329d != 0) goto L34;
            r106 = false;
            goto L36
        L24:
            if (r112.f513328c != 0) goto L25;
            r105 = false;
            goto L27
        L15:
            if (r112.f513327b != null) goto L16;
            r104 = false;
            goto L18
        L6:
            if (Intrinsics.areEqual(r112.f513326a, "") == false) goto L7;
            r103 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<f1> serializer() {
            return a.f513352a;
        }
    }

    public f1() {
        this(0, 0, 0, 0, 0, 0, 0, 134217727);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f1) == true) goto L8;
        return false;
    L8:
        f1 r101 = (f1) r100;
        if (Intrinsics.areEqual(this.f513326a, r101.f513326a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f513327b, r101.f513327b) == true) goto L15;
        return false;
    L15:
        if (this.f513328c == r101.f513328c) goto L18;
        return false;
    L18:
        if (this.f513329d == r101.f513329d) goto L21;
        return false;
    L21:
        if (Double.compare(this.f513330e, r101.f513330e) == 0) goto L24;
        return false;
    L24:
        if (Double.compare(this.f513331f, r101.f513331f) == 0) goto L27;
        return false;
    L27:
        if (Double.compare(this.f513332g, r101.f513332g) == 0) goto L30;
        return false;
    L30:
        if (this.f513333h == r101.f513333h) goto L33;
        return false;
    L33:
        if (this.f513334i == r101.f513334i) goto L36;
        return false;
    L36:
        if (this.f513335j == r101.f513335j) goto L39;
        return false;
    L39:
        if (this.f513336k == r101.f513336k) goto L42;
        return false;
    L42:
        if (this.f513337l == r101.f513337l) goto L45;
        return false;
    L45:
        if (this.f513338m == r101.f513338m) goto L48;
        return false;
    L48:
        if (this.f513339n == r101.f513339n) goto L51;
        return false;
    L51:
        if (this.f513340o == r101.f513340o) goto L54;
        return false;
    L54:
        if (this.f513341p == r101.f513341p) goto L57;
        return false;
    L57:
        if (this.f513342q == r101.f513342q) goto L60;
        return false;
    L60:
        if (this.f513343r == r101.f513343r) goto L63;
        return false;
    L63:
        if (this.f513344s == r101.f513344s) goto L66;
        return false;
    L66:
        if (this.f513345t == r101.f513345t) goto L69;
        return false;
    L69:
        if (this.f513346u == r101.f513346u) goto L72;
        return false;
    L72:
        if (this.f513347v == r101.f513347v) goto L75;
        return false;
    L75:
        if (this.f513348w == r101.f513348w) goto L78;
        return false;
    L78:
        if (this.f513349x == r101.f513349x) goto L81;
        return false;
    L81:
        if (this.f513350y == r101.f513350y) goto L84;
        return false;
    L84:
        if (this.f513351z == r101.f513351z) goto L87;
        return false;
    L87:
        if (this.A == r101.A) goto L89;
        return false;
    L89:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f513326a.hashCode() * 31;
        Map<String, String> r101 = this.f513327b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        long r104 = this.f513328c;
        int r105 = (((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.f513329d) * 31;
        long r106 = Double.doubleToLongBits(this.f513330e);
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = Double.doubleToLongBits(this.f513331f);
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = Double.doubleToLongBits(this.f513332g);
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        long r112 = this.f513333h;
        int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
        long r114 = this.f513334i;
        int r115 = (r113 + ((int) (r114 ^ (r114 >>> 32)))) * 31;
        long r116 = this.f513335j;
        int r117 = (r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31;
        long r118 = this.f513336k;
        int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
        long r120 = this.f513337l;
        int r121 = (r119 + ((int) (r120 ^ (r120 >>> 32)))) * 31;
        long r122 = this.f513338m;
        int r123 = (r121 + ((int) (r122 ^ (r122 >>> 32)))) * 31;
        long r124 = this.f513339n;
        int r125 = (r123 + ((int) (r124 ^ (r124 >>> 32)))) * 31;
        long r126 = this.f513340o;
        int r127 = (r125 + ((int) (r126 ^ (r126 >>> 32)))) * 31;
        long r128 = this.f513341p;
        int r129 = (r127 + ((int) (r128 ^ (r128 >>> 32)))) * 31;
        long r130 = this.f513342q;
        int r131 = (r129 + ((int) (r130 ^ (r130 >>> 32)))) * 31;
        long r132 = this.f513343r;
        int r133 = (r131 + ((int) (r132 ^ (r132 >>> 32)))) * 31;
        long r134 = this.f513344s;
        int r135 = (r133 + ((int) (r134 ^ (r134 >>> 32)))) * 31;
        long r136 = this.f513345t;
        int r137 = (r135 + ((int) (r136 ^ (r136 >>> 32)))) * 31;
        long r138 = this.f513346u;
        int r139 = (r137 + ((int) (r138 ^ (r138 >>> 32)))) * 31;
        long r140 = this.f513347v;
        int r141 = (r139 + ((int) (r140 ^ (r140 >>> 32)))) * 31;
        long r142 = this.f513348w;
        int r143 = (r141 + ((int) (r142 ^ (r142 >>> 32)))) * 31;
        long r144 = this.f513349x;
        int r145 = (r143 + ((int) (r144 ^ (r144 >>> 32)))) * 31;
        long r146 = this.f513350y;
        int r147 = (r145 + ((int) (r146 ^ (r146 >>> 32)))) * 31;
        long r148 = this.f513351z;
        int r149 = (r147 + ((int) (r148 ^ (r148 >>> 32)))) * 31;
        long r150 = this.A;
        return r149 + ((int) (r150 ^ (r150 >>> 32)));
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "KPerfMemoryData(scene=" + this.f513326a + ", customParams=" + this.f513327b + ", aliveSecond=" + this.f513328c + ", epoch=" + this.f513329d + ", duration=" + this.f513330e + ", pauseTime=" + this.f513331f + ", secondPauseTime=" + this.f513332g + ", markCount=" + this.f513333h + ", rootThreadLocalRefCount=" + this.f513334i + ", rootStackRefCount=" + this.f513335j + ", rootGlobalRefCount=" + this.f513336k + ", rootStableRefCount=" + this.f513337l + ", memoryUsageBeforeHeap=" + this.f513338m + ", memoryUsageAfterHeap=" + this.f513339n + ", heapSweptCount=" + this.f513340o + ", heapKeptCount=" + this.f513341p + ", extraSweptCount=" + this.f513342q + ", extraKeptCount=" + this.f513343r + ", systemTotalMem=" + this.f513344s + ", systemFreeMem=" + this.f513345t + ", systemAvailableMem=" + this.f513346u + ", appNativeRss=" + this.f513347v + ", appNativePss=" + this.f513348w + ", appNativeSharedDirty=" + this.f513349x + ", appTotalPss=" + this.f513350y + ", appVmPss=" + this.f513351z + ", appOtherPss=" + this.A + ')';
    }

    static {
        Companion = new b();
        B = new Lazy[]{null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new e1()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};
    }

    @Override // md6.c
    public final Map<String, String> a() {
        return this.f513327b;
    }

    @Override // md6.c
    public final void b(Map<String, String> r100) {
        this.f513327b = r100;
    }

    public f1(long r210, long r211, long r212, long r213, long r214, long r310, long r311, int r312) {
        if ((r312 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r312 & 262144) == 0) goto L9;
        long r101 = 0;
    L11:
        if ((r312 & 524288) == 0) goto L13;
        long r102 = 0;
    L15:
        if ((r312 & 1048576) == 0) goto L17;
        long r110 = 0;
    L19:
        if ((r312 & 4194304) == 0) goto L21;
        long r111 = 0;
    L23:
        if ((r312 & 16777216) == 0) goto L25;
        long r112 = 0;
    L27:
        if ((r312 & 33554432) == 0) goto L29;
        long r113 = 0;
    L31:
        if ((r312 & 67108864) == 0) goto L33;
        long r114 = 0;
    L34:
        Intrinsics.checkNotNullParameter(r100, "scene");
        this.f513326a = r100;
        this.f513327b = null;
        this.f513328c = 0;
        this.f513329d = 0;
        this.f513330e = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f513331f = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f513332g = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f513333h = 0;
        this.f513334i = 0;
        this.f513335j = 0;
        this.f513336k = 0;
        this.f513337l = 0;
        this.f513338m = 0;
        this.f513339n = 0;
        this.f513340o = 0;
        this.f513341p = 0;
        this.f513342q = 0;
        this.f513343r = 0;
        this.f513344s = r101;
        this.f513345t = r102;
        this.f513346u = r110;
        this.f513347v = 0;
        this.f513348w = r111;
        this.f513349x = 0;
        this.f513350y = r112;
        this.f513351z = r113;
        this.A = r114;
        return;
    L33:
        r114 = r311;
        goto L34
    L29:
        r113 = r310;
        goto L31
    L25:
        r112 = r214;
        goto L27
    L21:
        r111 = r213;
        goto L23
    L17:
        r110 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = null;
        goto L7
    }

    public f1(int r100, String r110, Map r111, long r112, int r113, double r114, double r115, double r116, long r210, long r211, long r212, long r213, long r214, long r310, long r311, long r312, long r313, long r314, long r410, long r411, long r412, long r413, long r414, long r510, long r511, long r512, long r513, long r514) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f513353b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        String r101 = "";
    L8:
        this.f513326a = r101;
        if ((r100 & 2) != 0) goto L11;
        this.f513327b = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f513328c = 0;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f513329d = 0;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.f513330e = AudioStats.AUDIO_AMPLITUDE_NONE;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.f513331f = AudioStats.AUDIO_AMPLITUDE_NONE;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.f513332g = AudioStats.AUDIO_AMPLITUDE_NONE;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.f513333h = 0;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.f513334i = 0;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.f513335j = 0;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.f513336k = 0;
    L49:
        if ((r100 & 2048) != 0) goto L51;
        this.f513337l = 0;
    L53:
        if ((r100 & 4096) != 0) goto L55;
        this.f513338m = 0;
    L57:
        if ((r100 & 8192) != 0) goto L59;
        this.f513339n = 0;
    L61:
        if ((r100 & 16384) != 0) goto L63;
        this.f513340o = 0;
    L65:
        if ((32768 & r100) != 0) goto L67;
        this.f513341p = 0;
    L69:
        if ((65536 & r100) != 0) goto L71;
        this.f513342q = 0;
    L73:
        if ((131072 & r100) != 0) goto L75;
        this.f513343r = 0;
    L77:
        if ((262144 & r100) != 0) goto L79;
        this.f513344s = 0;
    L81:
        if ((524288 & r100) != 0) goto L83;
        this.f513345t = 0;
    L85:
        if ((1048576 & r100) != 0) goto L87;
        this.f513346u = 0;
    L89:
        if ((2097152 & r100) != 0) goto L91;
        this.f513347v = 0;
    L93:
        if ((4194304 & r100) != 0) goto L95;
        this.f513348w = 0;
    L97:
        if ((8388608 & r100) != 0) goto L99;
        this.f513349x = 0;
    L101:
        if ((16777216 & r100) != 0) goto L103;
        this.f513350y = 0;
    L105:
        if ((33554432 & r100) != 0) goto L107;
        this.f513351z = 0;
    L109:
        if ((r100 & 67108864) != 0) goto L111;
        this.A = 0;
        return;
    L111:
        this.A = r514;
        return;
    L107:
        this.f513351z = r513;
        goto L109
    L103:
        this.f513350y = r512;
        goto L105
    L99:
        this.f513349x = r511;
        goto L101
    L95:
        this.f513348w = r510;
        goto L97
    L91:
        this.f513347v = r414;
        goto L93
    L87:
        this.f513346u = r413;
        goto L89
    L83:
        this.f513345t = r412;
        goto L85
    L79:
        this.f513344s = r411;
        goto L81
    L75:
        this.f513343r = r410;
        goto L77
    L71:
        this.f513342q = r314;
        goto L73
    L67:
        this.f513341p = r313;
        goto L69
    L63:
        this.f513340o = r312;
        goto L65
    L59:
        this.f513339n = r311;
        goto L61
    L55:
        this.f513338m = r310;
        goto L57
    L51:
        this.f513337l = r214;
        goto L53
    L47:
        this.f513336k = r213;
        goto L49
    L43:
        this.f513335j = r212;
        goto L45
    L39:
        this.f513334i = r211;
        goto L41
    L35:
        this.f513333h = r210;
        goto L37
    L31:
        this.f513332g = r116;
        goto L33
    L27:
        this.f513331f = r115;
        goto L29
    L23:
        this.f513330e = r114;
        goto L25
    L19:
        this.f513329d = r113;
        goto L21
    L15:
        this.f513328c = r112;
        goto L17
    L11:
        this.f513327b = r111;
        goto L13
    L7:
        r101 = r110;
        goto L8
    }
}
