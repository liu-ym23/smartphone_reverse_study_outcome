package md6;

import androidx.camera.video.AudioStats;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;

/* JADX INFO: loaded from: classes19.dex */
@Serializable
public class d1 implements c {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] Z = null;
    public double A;
    public double B;
    public double C;
    public double D;
    public double E;
    public long F;
    public long G;
    public long H;
    public long I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public double f513293J;
    public long K;
    public double L;
    public long M;
    public double N;
    public long O;
    public double P;
    public double Q;
    public long R;
    public long S;
    public long T;
    public long U;
    public long V;
    public long W;
    public double X;
    public long Y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f513294a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, String> f513295b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f513296c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f513297d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f513298e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f513299f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f513300g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public double f513301h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f513302i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f513303j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f513304k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f513305l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f513306m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public double f513307n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public double f513308o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public double f513309p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public double f513310q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public long f513311r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f513312s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f513313t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f513314u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f513315v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f513316w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f513317x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public double f513318y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public double f513319z;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<d1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f513320a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f513321b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f513321b;
        }

        static {
            a r100 = new a();
            f513320a = r100;
            g2 r101 = new g2("com.bytedance.kmp.performance.model.KPerfFrameTraceData", r100, 51);
            r101.j("timestamp", true);
            r101.j("custom_params", true);
            r101.j("frame_total_duration", true);
            r101.j("frame_interval_duration", true);
            r101.j("display_refresh_rate", true);
            r101.j("gc_stw_duration", true);
            r101.j("forgotten_count", true);
            r101.j("remembered_count", true);
            r101.j("ffi_duration", true);
            r101.j("ffi_api_duration", true);
            r101.j("ffi_main_thread_duration", true);
            r101.j("ffi_param_convert_duration", true);
            r101.j("ffi_sync_overhead_duration", true);
            r101.j("ffi_api_call_count", true);
            r101.j("frame_ffi_main_thread_ratio", true);
            r101.j("ffi_sync_overhead_ratio", true);
            r101.j("ffi_param_convert_ratio", true);
            r101.j("ffi_call_duration", true);
            r101.j("ffi_create_string_duration", true);
            r101.j("ffi_as_string_duration", true);
            r101.j("ffi_load_module_duration", true);
            r101.j("ffi_create_object_duration", true);
            r101.j("ffi_create_array_duration", true);
            r101.j("ffi_promise_get_result_duration", true);
            r101.j("ffi_call_count", true);
            r101.j("ffi_create_string_count", true);
            r101.j("ffi_as_string_count", true);
            r101.j("ffi_load_module_count", true);
            r101.j("ffi_create_object_count", true);
            r101.j("ffi_create_array_count", true);
            r101.j("ffi_promise_get_result_count", true);
            r101.j("forgotten_duration", true);
            r101.j("remembered_duration", true);
            r101.j("root_layout_duration", true);
            r101.j("set_content", true);
            r101.j("async_image_forgotten_count", true);
            r101.j("async_image_forgotten_duration", true);
            r101.j("async_image_remembered_count", true);
            r101.j("async_image_remembered_duration", true);
            r101.j("compose_applychange_count", true);
            r101.j("compose_applychange_duration", true);
            r101.j("compose_recompose_count", true);
            r101.j("recomposer_recompose_count", true);
            r101.j("recomposer_recompose_duration", true);
            r101.j("animation_duration", true);
            r101.j("compose_recompose_duration", true);
            r101.j("root_draw_duration", true);
            r101.j("input_duration", true);
            r101.j("compose_resource_duration", true);
            r101.j("compose_resource_count", true);
            r101.j("frame_left_time", true);
            f513321b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r100 = d1.Z;
            nuc.g1 r101 = nuc.g1.f520681a;
            nuc.b0 r102 = nuc.b0.f520644a;
            return new juc.d[]{r101, kuc.a.d(r100[1].getValue()), r101, r101, nuc.w0.f520792a, r101, r102, r102, r101, r101, r101, r101, r101, r102, r102, r102, r102, r101, r101, r101, r101, r101, r101, r101, r102, r102, r102, r102, r102, r102, r102, r101, r101, r101, r101, r102, r101, r102, r101, r102, r101, r102, r102, r101, r101, r101, r101, r101, r101, r102, r101};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r137) {
            Intrinsics.checkNotNullParameter(r137, "decoder");
            g2 r100 = f513321b;
            muc.c r101 = r137.beginStructure(r100);
            Lazy<juc.d<Object>>[] r102 = d1.Z;
            int r103 = 10;
            if (r101.decodeSequentially() == false) goto L5;
            long r310 = r101.decodeLongElement(r100, 0);
            Map r104 = (Map) r101.decodeNullableSerializableElement(r100, 1, r102[1].getValue(), null);
            long r105 = r101.decodeLongElement(r100, 2);
            long r110 = r101.decodeLongElement(r100, 3);
            int r106 = r101.decodeIntElement(r100, 4);
            long r107 = r101.decodeLongElement(r100, 5);
            double r111 = r101.decodeDoubleElement(r100, 6);
            double r311 = r101.decodeDoubleElement(r100, 7);
            long r312 = r101.decodeLongElement(r100, 8);
            long r112 = r101.decodeLongElement(r100, 9);
            long r313 = r101.decodeLongElement(r100, 10);
            long r314 = r101.decodeLongElement(r100, 11);
            long r210 = r101.decodeLongElement(r100, 12);
            double r410 = r101.decodeDoubleElement(r100, 13);
            double r211 = r101.decodeDoubleElement(r100, 14);
            double r411 = r101.decodeDoubleElement(r100, 15);
            double r212 = r101.decodeDoubleElement(r100, 16);
            long r412 = r101.decodeLongElement(r100, 17);
            long r213 = r101.decodeLongElement(r100, 18);
            long r413 = r101.decodeLongElement(r100, 19);
            long r214 = r101.decodeLongElement(r100, 20);
            long r414 = r101.decodeLongElement(r100, 21);
            long r113 = r101.decodeLongElement(r100, 22);
            long r510 = r101.decodeLongElement(r100, 23);
            double r511 = r101.decodeDoubleElement(r100, 24);
            double r512 = r101.decodeDoubleElement(r100, 25);
            double r513 = r101.decodeDoubleElement(r100, 26);
            double r514 = r101.decodeDoubleElement(r100, 27);
            double r610 = r101.decodeDoubleElement(r100, 28);
            double r611 = r101.decodeDoubleElement(r100, 29);
            double r612 = r101.decodeDoubleElement(r100, 30);
            long r613 = r101.decodeLongElement(r100, 31);
            long r114 = r101.decodeLongElement(r100, 32);
            long r614 = r101.decodeLongElement(r100, 33);
            long r710 = r101.decodeLongElement(r100, 34);
            double r711 = r101.decodeDoubleElement(r100, 35);
            long r712 = r101.decodeLongElement(r100, 36);
            double r713 = r101.decodeDoubleElement(r100, 37);
            long r714 = r101.decodeLongElement(r100, 38);
            double r810 = r101.decodeDoubleElement(r100, 39);
            long r811 = r101.decodeLongElement(r100, 40);
            double r812 = r101.decodeDoubleElement(r100, 41);
            double r813 = r101.decodeDoubleElement(r100, 42);
            long r814 = r101.decodeLongElement(r100, 43);
            long r910 = r101.decodeLongElement(r100, 44);
            long r911 = r101.decodeLongElement(r100, 45);
            long r912 = r101.decodeLongElement(r100, 46);
            long r913 = r101.decodeLongElement(r100, 47);
            long r914 = r101.decodeLongElement(r100, 48);
            int r108 = 524287;
            long r109 = r914;
            double r1010 = r101.decodeDoubleElement(r100, 49);
            long r1011 = r101.decodeLongElement(r100, 50);
            long r915 = r911;
            long r1012 = r912;
            long r1013 = r913;
            double r916 = r813;
            long r917 = r814;
            long r918 = r910;
            double r815 = r810;
            long r816 = r811;
            double r919 = r812;
            long r817 = r712;
            double r818 = r713;
            long r819 = r714;
            long r715 = r614;
            long r716 = r710;
            double r717 = r711;
            long r718 = r114;
            double r615 = r612;
            long r719 = r613;
            int r115 = r106;
            double r616 = r610;
            double r617 = r611;
            double r618 = r513;
            double r619 = r514;
            double r515 = r511;
            double r516 = r512;
            long r517 = r113;
            long r518 = r510;
            long r116 = r107;
            long r519 = r414;
            int r117 = -1;
            long r415 = r214;
            double r215 = r111;
            long r118 = r110;
            long r119 = r310;
            long r315 = r314;
            double r316 = r411;
            long r416 = r412;
            long r417 = r213;
            double r216 = r311;
            long r317 = r210;
            long r217 = r313;
            double r318 = r211;
            long r218 = r112;
            Map r120 = r104;
            long r121 = r105;
            double r319 = r410;
            double r418 = r212;
            long r219 = r312;
        L81:
            r101.endStructure(r100);
            return new d1(r117, r108, r119, r120, r121, r118, r115, r116, r215, r216, r219, r218, r217, r315, r317, r319, r318, r316, r418, r416, r417, r413, r415, r519, r517, r518, r515, r516, r618, r619, r616, r617, r615, r719, r718, r715, r716, r717, r817, r818, r819, r815, r816, r919, r916, r917, r918, r915, r1012, r1013, r109, r1010, r1011);
        L5:
            Map r122 = null;
            long r123 = 0;
            long r320 = 0;
            long r321 = 0;
            long r419 = 0;
            long r420 = 0;
            long r421 = 0;
            long r422 = 0;
            long r520 = 0;
            long r521 = 0;
            long r620 = 0;
            long r621 = 0;
            long r622 = 0;
            long r720 = 0;
            long r721 = 0;
            long r722 = 0;
            long r723 = 0;
            long r920 = 0;
            long r921 = 0;
            long r922 = 0;
            long r1014 = 0;
            long r1015 = 0;
            long r1016 = 0;
            long r1110 = 0;
            long r1111 = 0;
            long r1112 = 0;
            long r124 = 0;
            long r125 = 0;
            long r126 = 0;
            long r128 = 0;
            double r423 = 0.0d;
            double r522 = 0.0d;
            double r523 = 0.0d;
            double r524 = 0.0d;
            double r623 = 0.0d;
            double r624 = 0.0d;
            double r724 = 0.0d;
            double r820 = 0.0d;
            double r821 = 0.0d;
            double r822 = 0.0d;
            double r823 = 0.0d;
            double r824 = 0.0d;
            double r923 = 0.0d;
            double r924 = 0.0d;
            double r1017 = 0.0d;
            double r1018 = 0.0d;
            double r1113 = 0.0d;
            double r1114 = 0.0d;
            double r127 = 0.0d;
            int r129 = 0;
            int r130 = 0;
            int r322 = 0;
            boolean r131 = true;
            long r323 = 0;
        L6:
            if (r131 == false) goto L80;
            int r132 = r101.decodeElementIndex(r100);
            switch(r132) {
                case -1: goto L78;
                case 0: goto L77;
                case 1: goto L75;
                case 2: goto L73;
                case 3: goto L70;
                case 4: goto L68;
                case 5: goto L66;
                case 6: goto L65;
                case 7: goto L64;
                case 8: goto L63;
                case 9: goto L62;
                case 10: goto L61;
                case 11: goto L60;
                case 12: goto L58;
                case 13: goto L56;
                case 14: goto L55;
                case 15: goto L53;
                case 16: goto L51;
                case 17: goto L50;
                case 18: goto L49;
                case 19: goto L47;
                case 20: goto L45;
                case 21: goto L43;
                case 22: goto L42;
                case 23: goto L41;
                case 24: goto L40;
                case 25: goto L39;
                case 26: goto L38;
                case 27: goto L37;
                case 28: goto L36;
                case 29: goto L35;
                case 30: goto L34;
                case 31: goto L33;
                case 32: goto L31;
                case 33: goto L29;
                case 34: goto L28;
                case 35: goto L27;
                case 36: goto L26;
                case 37: goto L25;
                case 38: goto L24;
                case 39: goto L23;
                case 40: goto L22;
                case 41: goto L21;
                case 42: goto L20;
                case 43: goto L19;
                case 44: goto L18;
                case 45: goto L17;
                case 46: goto L16;
                case 47: goto L14;
                case 48: goto L13;
                case 49: goto L12;
                case 50: goto L11;
                default: goto L10;
            };
        L11:
            r128 = r101.decodeLongElement(r100, 50);
            int r133 = 262144;
        L15:
            int r134 = r133 | r129;
        L30:
            r129 = r134;
        L59:
            Unit r135 = Unit.INSTANCE;
        L74:
            r123 = r123;
        L79:
            r103 = 10;
            goto L6
        L12:
            r127 = r101.decodeDoubleElement(r100, 49);
            r133 = 131072;
            goto L15
        L13:
            r126 = r101.decodeLongElement(r100, 48);
            r133 = 65536;
            goto L15
        L14:
            r125 = r101.decodeLongElement(r100, 47);
            r133 = 32768;
            goto L15
        L16:
            r124 = r101.decodeLongElement(r100, 46);
            r134 = r129 | 16384;
            goto L30
        L17:
            r1112 = r101.decodeLongElement(r100, 45);
            r134 = r129 | 8192;
            goto L30
        L18:
            r1111 = r101.decodeLongElement(r100, 44);
            r134 = r129 | 4096;
            goto L30
        L19:
            r1110 = r101.decodeLongElement(r100, 43);
            r134 = r129 | 2048;
            goto L30
        L20:
            r1114 = r101.decodeDoubleElement(r100, 42);
            r134 = r129 | 1024;
            goto L30
        L21:
            r1113 = r101.decodeDoubleElement(r100, 41);
            r134 = r129 | 512;
            goto L30
        L22:
            r1016 = r101.decodeLongElement(r100, 40);
            r134 = r129 | 256;
            goto L30
        L23:
            r1018 = r101.decodeDoubleElement(r100, 39);
            r134 = r129 | 128;
            goto L30
        L24:
            r1015 = r101.decodeLongElement(r100, 38);
            r134 = r129 | 64;
            goto L30
        L25:
            r1017 = r101.decodeDoubleElement(r100, 37);
            r134 = r129 | 32;
            goto L30
        L26:
            r1014 = r101.decodeLongElement(r100, 36);
            r134 = r129 | 16;
            goto L30
        L27:
            r924 = r101.decodeDoubleElement(r100, 35);
            r134 = r129 | 8;
            goto L30
        L28:
            r922 = r101.decodeLongElement(r100, 34);
            r134 = r129 | 4;
            goto L30
        L29:
            r921 = r101.decodeLongElement(r100, 33);
            r134 = r129 | 2;
            goto L30
        L31:
            r419 = r101.decodeLongElement(r100, 32);
            r129 = r129 | 1;
            Unit r136 = Unit.INSTANCE;
            goto L74
        L33:
            r920 = r101.decodeLongElement(r100, 31);
            int r138 = Integer.MIN_VALUE;
        L48:
            r130 = r130 | r138;
            goto L59
        L34:
            r923 = r101.decodeDoubleElement(r100, 30);
            r138 = 1073741824;
            goto L48
        L35:
            r824 = r101.decodeDoubleElement(r100, 29);
            r138 = 536870912;
            goto L48
        L36:
            r823 = r101.decodeDoubleElement(r100, 28);
            r138 = 268435456;
            goto L48
        L37:
            r822 = r101.decodeDoubleElement(r100, 27);
            r138 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
            goto L48
        L38:
            r821 = r101.decodeDoubleElement(r100, 26);
            r138 = 67108864;
            goto L48
        L39:
            r820 = r101.decodeDoubleElement(r100, 25);
            r138 = 33554432;
            goto L48
        L40:
            r724 = r101.decodeDoubleElement(r100, 24);
            r138 = 16777216;
            goto L48
        L41:
            r723 = r101.decodeLongElement(r100, 23);
            r138 = 8388608;
            goto L48
        L42:
            r420 = r101.decodeLongElement(r100, 22);
            r138 = 4194304;
            goto L48
        L43:
            r722 = r101.decodeLongElement(r100, 21);
            r138 = 2097152;
            goto L48
        L45:
            r421 = r101.decodeLongElement(r100, 20);
            r138 = 1048576;
            goto L48
        L47:
            r721 = r101.decodeLongElement(r100, 19);
            r138 = 524288;
            goto L48
        L49:
            r422 = r101.decodeLongElement(r100, 18);
            r130 = r130 | 262144;
        L71:
            Unit r220 = Unit.INSTANCE;
        L72:
            r123 = r123;
            goto L74
        L50:
            r720 = r101.decodeLongElement(r100, 17);
            int r139 = 131072;
        L54:
            r130 = r130 | r139;
            goto L59
        L51:
            r522 = r101.decodeDoubleElement(r100, 16);
            r139 = 65536;
            goto L54
        L53:
            r624 = r101.decodeDoubleElement(r100, 15);
            r139 = 32768;
            goto L54
        L55:
            r523 = r101.decodeDoubleElement(r100, 14);
            r130 = r130 | 16384;
            goto L59
        L56:
            r623 = r101.decodeDoubleElement(r100, 13);
            r130 = r130 | 8192;
            goto L59
        L58:
            r520 = r101.decodeLongElement(r100, 12);
            r130 = r130 | 4096;
            goto L59
        L60:
            r622 = r101.decodeLongElement(r100, 11);
            r130 = r130 | 2048;
        L69:
            Unit r221 = Unit.INSTANCE;
            goto L72
        L61:
            r621 = r101.decodeLongElement(r100, r103);
            r130 = r130 | 1024;
            goto L69
        L62:
            r321 = r101.decodeLongElement(r100, 9);
            r130 = r130 | 512;
            goto L69
        L63:
            r620 = r101.decodeLongElement(r100, 8);
            r130 = r130 | 256;
            goto L69
        L64:
            r524 = r101.decodeDoubleElement(r100, 7);
            r130 = r130 | 128;
            goto L69
        L65:
            r423 = r101.decodeDoubleElement(r100, 6);
            r130 = r130 | 64;
            goto L69
        L66:
            r323 = r101.decodeLongElement(r100, 5);
            r130 = r130 | 32;
            goto L69
        L68:
            r322 = r101.decodeIntElement(r100, 4);
            r130 = r130 | 16;
            goto L69
        L70:
            r320 = r101.decodeLongElement(r100, 3);
            r130 = r130 | 8;
            goto L71
        L73:
            r123 = r101.decodeLongElement(r100, 2);
            r130 = r130 | 4;
            Unit r140 = Unit.INSTANCE;
            goto L74
        L75:
            r122 = (Map) r101.decodeNullableSerializableElement(r100, 1, r102[1].getValue(), r122);
            int r141 = r130 | 2;
            Unit r142 = Unit.INSTANCE;
            r130 = r141;
            goto L79
        L77:
            r521 = r101.decodeLongElement(r100, 0);
            r130 = r130 | 1;
            Unit r324 = Unit.INSTANCE;
            goto L79
        L78:
            Unit r325 = Unit.INSTANCE;
            r131 = false;
            goto L79
        L10:
            throw new UnknownFieldException(r132);
        L80:
            r121 = r123;
            r108 = r129;
            r117 = r130;
            r120 = r122;
            r115 = r322;
            r116 = r323;
            r118 = r320;
            r218 = r321;
            r215 = r423;
            r418 = r522;
            r318 = r523;
            r317 = r520;
            r119 = r521;
            r216 = r524;
            r219 = r620;
            r217 = r621;
            r315 = r622;
            r319 = r623;
            r316 = r624;
            r519 = r722;
            r518 = r723;
            r515 = r724;
            r516 = r820;
            r618 = r821;
            r619 = r822;
            r616 = r823;
            r617 = r824;
            r615 = r923;
            r715 = r921;
            r716 = r922;
            r717 = r924;
            r817 = r1014;
            r818 = r1017;
            r819 = r1015;
            r815 = r1018;
            r816 = r1016;
            r919 = r1113;
            r917 = r1110;
            r918 = r1111;
            r915 = r1112;
            r1012 = r124;
            r1013 = r125;
            r109 = r126;
            r1010 = r127;
            r1011 = r128;
            r517 = r420;
            r417 = r422;
            r415 = r421;
            r413 = r721;
            r718 = r419;
            r416 = r720;
            r719 = r920;
            r916 = r1114;
            goto L81
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            d1 r102 = (d1) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f513321b;
            muc.d r104 = r100.beginStructure(r103);
            d1.e(r102, r104, r103);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<d1> serializer() {
            return a.f513320a;
        }
    }

    public d1() {
        this(null);
    }

    static {
        Companion = new b();
        Z = new Lazy[]{null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new j()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};
    }

    public final void d() {
        this.f513308o = h.a(this.f513304k, this.f513297d);
        this.f513309p = h.a(this.f513306m, this.f513304k);
        this.f513310q = h.a(this.f513305l, this.f513304k);
    }

    @Override // md6.c
    public final Map<String, String> a() {
        return this.f513295b;
    }

    public d1(Object r100) {
        this.f513294a = -1;
        this.f513295b = null;
        this.f513296c = 0;
        this.f513297d = 0;
        this.f513298e = 60;
        this.f513299f = 0;
        this.f513300g = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f513301h = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f513302i = 0;
        this.f513303j = 0;
        this.f513304k = 0;
        this.f513305l = 0;
        this.f513306m = 0;
        this.f513307n = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f513308o = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f513309p = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f513310q = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f513311r = 0;
        this.f513312s = 0;
        this.f513313t = 0;
        this.f513314u = 0;
        this.f513315v = 0;
        this.f513316w = 0;
        this.f513317x = 0;
        this.f513318y = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f513319z = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.A = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.B = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.C = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.D = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.E = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.F = 0;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.f513293J = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.K = 0;
        this.L = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.M = 0;
        this.N = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.O = 0;
        this.P = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.Q = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.R = 0;
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = 0;
        this.W = 0;
        this.X = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.Y = 0;
    }

    @Override // md6.c
    public final void b(Map<String, String> r100) {
        this.f513295b = r100;
    }

    public final void c(d1 r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f513294a = r100.f513294a;
        this.f513296c = r100.f513296c;
        this.f513298e = r100.f513298e;
        this.f513299f = r100.f513299f;
        this.f513300g = r100.f513300g;
        this.f513301h = r100.f513301h;
        this.f513302i = r100.f513302i;
        this.f513303j = r100.f513303j;
        this.f513304k = r100.f513304k;
        this.f513305l = r100.f513305l;
        this.f513306m = r100.f513306m;
        this.f513307n = r100.f513307n;
        this.f513308o = r100.f513308o;
        this.f513309p = r100.f513309p;
        this.f513310q = r100.f513310q;
        this.f513311r = r100.f513311r;
        this.f513312s = r100.f513312s;
        this.f513313t = r100.f513313t;
        this.f513314u = r100.f513314u;
        this.f513315v = r100.f513315v;
        this.f513316w = r100.f513316w;
        this.f513317x = r100.f513317x;
        this.f513318y = r100.f513318y;
        this.f513319z = r100.f513319z;
        this.A = r100.A;
        this.B = r100.B;
        this.C = r100.C;
        this.D = r100.D;
        this.E = r100.E;
        this.F = r100.F;
        this.G = r100.G;
        this.H = r100.H;
        this.I = r100.I;
        this.f513293J = r100.f513293J;
        this.K = r100.K;
        this.L = r100.L;
        this.M = r100.M;
        this.N = r100.N;
        this.O = r100.O;
        this.P = r100.P;
        this.Q = r100.Q;
        this.R = r100.R;
        this.S = r100.S;
        this.T = r100.T;
        this.U = r100.U;
        this.X = r100.X;
        this.W = r100.W;
        this.V = r100.V;
        this.Y = r100.Y;
    }

    @JvmStatic
    public static final void e(d1 r110, muc.d r111, g2 r112) {
        Lazy<juc.d<Object>>[] r100 = Z;
        boolean r101 = false;
        if (r111.shouldEncodeElementDefault(r112, 0) == false) goto L6;
    L7:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        r111.encodeLongElement(r112, 0, r110.f513294a);
    L12:
        if (r111.shouldEncodeElementDefault(r112, 1) == false) goto L15;
    L16:
        boolean r103 = true;
    L18:
        if (r103 == false) goto L21;
        r111.encodeNullableSerializableElement(r112, 1, r100[1].getValue(), r110.f513295b);
    L21:
        if (r111.shouldEncodeElementDefault(r112, 2) == false) goto L24;
    L25:
        boolean r104 = true;
    L27:
        if (r104 == false) goto L30;
        r111.encodeLongElement(r112, 2, r110.f513296c);
    L30:
        if (r111.shouldEncodeElementDefault(r112, 3) == false) goto L33;
    L34:
        boolean r105 = true;
    L36:
        if (r105 == false) goto L39;
        r111.encodeLongElement(r112, 3, r110.f513297d);
    L39:
        if (r111.shouldEncodeElementDefault(r112, 4) == false) goto L42;
    L43:
        boolean r106 = true;
    L45:
        if (r106 == false) goto L48;
        r111.encodeIntElement(r112, 4, r110.f513298e);
    L48:
        if (r111.shouldEncodeElementDefault(r112, 5) == false) goto L51;
    L52:
        boolean r107 = true;
    L54:
        if (r107 == false) goto L57;
        r111.encodeLongElement(r112, 5, r110.f513299f);
    L57:
        if (r111.shouldEncodeElementDefault(r112, 6) == false) goto L60;
    L61:
        boolean r108 = true;
    L63:
        if (r108 == false) goto L66;
        r111.encodeDoubleElement(r112, 6, r110.f513300g);
    L66:
        if (r111.shouldEncodeElementDefault(r112, 7) == false) goto L69;
    L70:
        boolean r109 = true;
    L72:
        if (r109 == false) goto L75;
        r111.encodeDoubleElement(r112, 7, r110.f513301h);
    L75:
        if (r111.shouldEncodeElementDefault(r112, 8) == false) goto L78;
    L79:
        boolean r113 = true;
    L81:
        if (r113 == false) goto L84;
        r111.encodeLongElement(r112, 8, r110.f513302i);
    L84:
        if (r111.shouldEncodeElementDefault(r112, 9) == false) goto L87;
    L88:
        boolean r114 = true;
    L90:
        if (r114 == false) goto L93;
        r111.encodeLongElement(r112, 9, r110.f513303j);
    L93:
        if (r111.shouldEncodeElementDefault(r112, 10) == false) goto L96;
    L97:
        boolean r115 = true;
    L99:
        if (r115 == false) goto L102;
        r111.encodeLongElement(r112, 10, r110.f513304k);
    L102:
        if (r111.shouldEncodeElementDefault(r112, 11) == false) goto L105;
    L106:
        boolean r116 = true;
    L108:
        if (r116 == false) goto L111;
        r111.encodeLongElement(r112, 11, r110.f513305l);
    L111:
        if (r111.shouldEncodeElementDefault(r112, 12) == false) goto L114;
    L115:
        boolean r117 = true;
    L117:
        if (r117 == false) goto L120;
        r111.encodeLongElement(r112, 12, r110.f513306m);
    L120:
        if (r111.shouldEncodeElementDefault(r112, 13) == false) goto L123;
    L124:
        boolean r118 = true;
    L126:
        if (r118 == false) goto L129;
        r111.encodeDoubleElement(r112, 13, r110.f513307n);
    L129:
        if (r111.shouldEncodeElementDefault(r112, 14) == false) goto L132;
    L133:
        boolean r119 = true;
    L135:
        if (r119 == false) goto L138;
        r111.encodeDoubleElement(r112, 14, r110.f513308o);
    L138:
        if (r111.shouldEncodeElementDefault(r112, 15) == false) goto L141;
    L142:
        boolean r120 = true;
    L144:
        if (r120 == false) goto L147;
        r111.encodeDoubleElement(r112, 15, r110.f513309p);
    L147:
        if (r111.shouldEncodeElementDefault(r112, 16) == false) goto L150;
    L151:
        boolean r121 = true;
    L153:
        if (r121 == false) goto L156;
        r111.encodeDoubleElement(r112, 16, r110.f513310q);
    L156:
        if (r111.shouldEncodeElementDefault(r112, 17) == false) goto L159;
    L160:
        boolean r122 = true;
    L162:
        if (r122 == false) goto L165;
        r111.encodeLongElement(r112, 17, r110.f513311r);
    L165:
        if (r111.shouldEncodeElementDefault(r112, 18) == false) goto L168;
    L169:
        boolean r123 = true;
    L171:
        if (r123 == false) goto L174;
        r111.encodeLongElement(r112, 18, r110.f513312s);
    L174:
        if (r111.shouldEncodeElementDefault(r112, 19) == false) goto L177;
    L178:
        boolean r124 = true;
    L180:
        if (r124 == false) goto L183;
        r111.encodeLongElement(r112, 19, r110.f513313t);
    L183:
        if (r111.shouldEncodeElementDefault(r112, 20) == false) goto L186;
    L187:
        boolean r125 = true;
    L189:
        if (r125 == false) goto L192;
        r111.encodeLongElement(r112, 20, r110.f513314u);
    L192:
        if (r111.shouldEncodeElementDefault(r112, 21) == false) goto L195;
    L196:
        boolean r126 = true;
    L198:
        if (r126 == false) goto L201;
        r111.encodeLongElement(r112, 21, r110.f513315v);
    L201:
        if (r111.shouldEncodeElementDefault(r112, 22) == false) goto L204;
    L205:
        boolean r127 = true;
    L207:
        if (r127 == false) goto L210;
        r111.encodeLongElement(r112, 22, r110.f513316w);
    L210:
        if (r111.shouldEncodeElementDefault(r112, 23) == false) goto L213;
    L214:
        boolean r128 = true;
    L216:
        if (r128 == false) goto L219;
        r111.encodeLongElement(r112, 23, r110.f513317x);
    L219:
        if (r111.shouldEncodeElementDefault(r112, 24) == false) goto L222;
    L223:
        boolean r129 = true;
    L225:
        if (r129 == false) goto L228;
        r111.encodeDoubleElement(r112, 24, r110.f513318y);
    L228:
        if (r111.shouldEncodeElementDefault(r112, 25) == false) goto L231;
    L232:
        boolean r130 = true;
    L234:
        if (r130 == false) goto L237;
        r111.encodeDoubleElement(r112, 25, r110.f513319z);
    L237:
        if (r111.shouldEncodeElementDefault(r112, 26) == false) goto L240;
    L241:
        boolean r131 = true;
    L243:
        if (r131 == false) goto L246;
        r111.encodeDoubleElement(r112, 26, r110.A);
    L246:
        if (r111.shouldEncodeElementDefault(r112, 27) == false) goto L249;
    L250:
        boolean r132 = true;
    L252:
        if (r132 == false) goto L255;
        r111.encodeDoubleElement(r112, 27, r110.B);
    L255:
        if (r111.shouldEncodeElementDefault(r112, 28) == false) goto L258;
    L259:
        boolean r133 = true;
    L261:
        if (r133 == false) goto L264;
        r111.encodeDoubleElement(r112, 28, r110.C);
    L264:
        if (r111.shouldEncodeElementDefault(r112, 29) == false) goto L267;
    L268:
        boolean r134 = true;
    L270:
        if (r134 == false) goto L273;
        r111.encodeDoubleElement(r112, 29, r110.D);
    L273:
        if (r111.shouldEncodeElementDefault(r112, 30) == false) goto L276;
    L277:
        boolean r135 = true;
    L279:
        if (r135 == false) goto L282;
        r111.encodeDoubleElement(r112, 30, r110.E);
    L282:
        if (r111.shouldEncodeElementDefault(r112, 31) == false) goto L285;
    L286:
        boolean r136 = true;
    L288:
        if (r136 == false) goto L291;
        r111.encodeLongElement(r112, 31, r110.F);
    L291:
        if (r111.shouldEncodeElementDefault(r112, 32) == false) goto L294;
    L295:
        boolean r137 = true;
    L297:
        if (r137 == false) goto L300;
        r111.encodeLongElement(r112, 32, r110.G);
    L300:
        if (r111.shouldEncodeElementDefault(r112, 33) == false) goto L303;
    L304:
        boolean r138 = true;
    L306:
        if (r138 == false) goto L309;
        r111.encodeLongElement(r112, 33, r110.H);
    L309:
        if (r111.shouldEncodeElementDefault(r112, 34) == false) goto L312;
    L313:
        boolean r139 = true;
    L315:
        if (r139 == false) goto L318;
        r111.encodeLongElement(r112, 34, r110.I);
    L318:
        if (r111.shouldEncodeElementDefault(r112, 35) == false) goto L321;
    L322:
        boolean r140 = true;
    L324:
        if (r140 == false) goto L327;
        r111.encodeDoubleElement(r112, 35, r110.f513293J);
    L327:
        if (r111.shouldEncodeElementDefault(r112, 36) == false) goto L330;
    L331:
        boolean r141 = true;
    L333:
        if (r141 == false) goto L336;
        r111.encodeLongElement(r112, 36, r110.K);
    L336:
        if (r111.shouldEncodeElementDefault(r112, 37) == false) goto L339;
    L340:
        boolean r142 = true;
    L342:
        if (r142 == false) goto L345;
        r111.encodeDoubleElement(r112, 37, r110.L);
    L345:
        if (r111.shouldEncodeElementDefault(r112, 38) == false) goto L348;
    L349:
        boolean r143 = true;
    L351:
        if (r143 == false) goto L354;
        r111.encodeLongElement(r112, 38, r110.M);
    L354:
        if (r111.shouldEncodeElementDefault(r112, 39) == false) goto L357;
    L358:
        boolean r144 = true;
    L360:
        if (r144 == false) goto L363;
        r111.encodeDoubleElement(r112, 39, r110.N);
    L363:
        if (r111.shouldEncodeElementDefault(r112, 40) == false) goto L366;
    L367:
        boolean r145 = true;
    L369:
        if (r145 == false) goto L372;
        r111.encodeLongElement(r112, 40, r110.O);
    L372:
        if (r111.shouldEncodeElementDefault(r112, 41) == false) goto L375;
    L376:
        boolean r146 = true;
    L378:
        if (r146 == false) goto L381;
        r111.encodeDoubleElement(r112, 41, r110.P);
    L381:
        if (r111.shouldEncodeElementDefault(r112, 42) == false) goto L384;
    L385:
        boolean r147 = true;
    L387:
        if (r147 == false) goto L390;
        r111.encodeDoubleElement(r112, 42, r110.Q);
    L390:
        if (r111.shouldEncodeElementDefault(r112, 43) == false) goto L393;
    L394:
        boolean r148 = true;
    L396:
        if (r148 == false) goto L399;
        r111.encodeLongElement(r112, 43, r110.R);
    L399:
        if (r111.shouldEncodeElementDefault(r112, 44) == false) goto L402;
    L403:
        boolean r149 = true;
    L405:
        if (r149 == false) goto L408;
        r111.encodeLongElement(r112, 44, r110.S);
    L408:
        if (r111.shouldEncodeElementDefault(r112, 45) == false) goto L411;
    L412:
        boolean r150 = true;
    L414:
        if (r150 == false) goto L417;
        r111.encodeLongElement(r112, 45, r110.T);
    L417:
        if (r111.shouldEncodeElementDefault(r112, 46) == false) goto L420;
    L421:
        boolean r151 = true;
    L423:
        if (r151 == false) goto L426;
        r111.encodeLongElement(r112, 46, r110.U);
    L426:
        if (r111.shouldEncodeElementDefault(r112, 47) == false) goto L429;
    L430:
        boolean r152 = true;
    L432:
        if (r152 == false) goto L435;
        r111.encodeLongElement(r112, 47, r110.V);
    L435:
        if (r111.shouldEncodeElementDefault(r112, 48) == false) goto L438;
    L439:
        boolean r153 = true;
    L441:
        if (r153 == false) goto L444;
        r111.encodeLongElement(r112, 48, r110.W);
    L444:
        if (r111.shouldEncodeElementDefault(r112, 49) == false) goto L447;
    L448:
        boolean r154 = true;
    L450:
        if (r154 == false) goto L453;
        r111.encodeDoubleElement(r112, 49, r110.X);
    L453:
        if (r111.shouldEncodeElementDefault(r112, 50) == false) goto L456;
    L457:
        r101 = true;
    L458:
        if (r101 == false) goto L461;
        r111.encodeLongElement(r112, 50, r110.Y);
        return;
    L461:
        return;
    L456:
        if (r110.Y == 0) goto L458;
    L447:
        if (Double.compare(r110.X, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) goto L448;
        r154 = false;
        goto L450
    L438:
        if (r110.W != 0) goto L439;
        r153 = false;
        goto L441
    L429:
        if (r110.V != 0) goto L430;
        r152 = false;
        goto L432
    L420:
        if (r110.U != 0) goto L421;
        r151 = false;
        goto L423
    L411:
        if (r110.T != 0) goto L412;
        r150 = false;
        goto L414
    L402:
        if (r110.S != 0) goto L403;
        r149 = false;
        goto L405
    L393:
        if (r110.R != 0) goto L394;
        r148 = false;
        goto L396
    L384:
        if (Double.compare(r110.Q, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) goto L385;
        r147 = false;
        goto L387
    L375:
        if (Double.compare(r110.P, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) goto L376;
        r146 = false;
        goto L378
    L366:
        if (r110.O != 0) goto L367;
        r145 = false;
        goto L369
    L357:
        if (Double.compare(r110.N, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) goto L358;
        r144 = false;
        goto L360
    L348:
        if (r110.M != 0) goto L349;
        r143 = false;
        goto L351
    L339:
        if (Double.compare(r110.L, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) goto L340;
        r142 = false;
        goto L342
    L330:
        if (r110.K != 0) goto L331;
        r141 = false;
        goto L333
    L321:
        if (Double.compare(r110.f513293J, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) goto L322;
        r140 = false;
        goto L324
    L312:
        if (r110.I != 0) goto L313;
        r139 = false;
        goto L315
    L303:
        if (r110.H != 0) goto L304;
        r138 = false;
        goto L306
    L294:
        if (r110.G != 0) goto L295;
        r137 = false;
        goto L297
    L285:
        if (r110.F != 0) goto L286;
        r136 = false;
        goto L288
    L276:
        if (Double.compare(r110.E, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) goto L277;
        r135 = false;
        goto L279
    L267:
        if (Double.compare(r110.D, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) goto L268;
        r134 = false;
        goto L270
    L258:
        if (Double.compare(r110.C, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) goto L259;
        r133 = false;
        goto L261
    L249:
        if (Double.compare(r110.B, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) goto L250;
        r132 = false;
        goto L252
    L240:
        if (Double.compare(r110.A, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) goto L241;
        r131 = false;
        goto L243
    L231:
        if (Double.compare(r110.f513319z, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) goto L232;
        r130 = false;
        goto L234
    L222:
        if (Double.compare(r110.f513318y, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) goto L223;
        r129 = false;
        goto L225
    L213:
        if (r110.f513317x != 0) goto L214;
        r128 = false;
        goto L216
    L204:
        if (r110.f513316w != 0) goto L205;
        r127 = false;
        goto L207
    L195:
        if (r110.f513315v != 0) goto L196;
        r126 = false;
        goto L198
    L186:
        if (r110.f513314u != 0) goto L187;
        r125 = false;
        goto L189
    L177:
        if (r110.f513313t != 0) goto L178;
        r124 = false;
        goto L180
    L168:
        if (r110.f513312s != 0) goto L169;
        r123 = false;
        goto L171
    L159:
        if (r110.f513311r != 0) goto L160;
        r122 = false;
        goto L162
    L150:
        if (Double.compare(r110.f513310q, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) goto L151;
        r121 = false;
        goto L153
    L141:
        if (Double.compare(r110.f513309p, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) goto L142;
        r120 = false;
        goto L144
    L132:
        if (Double.compare(r110.f513308o, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) goto L133;
        r119 = false;
        goto L135
    L123:
        if (Double.compare(r110.f513307n, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) goto L124;
        r118 = false;
        goto L126
    L114:
        if (r110.f513306m != 0) goto L115;
        r117 = false;
        goto L117
    L105:
        if (r110.f513305l != 0) goto L106;
        r116 = false;
        goto L108
    L96:
        if (r110.f513304k != 0) goto L97;
        r115 = false;
        goto L99
    L87:
        if (r110.f513303j != 0) goto L88;
        r114 = false;
        goto L90
    L78:
        if (r110.f513302i != 0) goto L79;
        r113 = false;
        goto L81
    L69:
        if (Double.compare(r110.f513301h, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) goto L70;
        r109 = false;
        goto L72
    L60:
        if (Double.compare(r110.f513300g, AudioStats.AUDIO_AMPLITUDE_NONE) != 0) goto L61;
        r108 = false;
        goto L63
    L51:
        if (r110.f513299f != 0) goto L52;
        r107 = false;
        goto L54
    L42:
        if (r110.f513298e != 60) goto L43;
        r106 = false;
        goto L45
    L33:
        if (r110.f513297d != 0) goto L34;
        r105 = false;
        goto L36
    L24:
        if (r110.f513296c != 0) goto L25;
        r104 = false;
        goto L27
    L15:
        if (r110.f513295b != null) goto L16;
        r103 = false;
        goto L18
    L6:
        if (r110.f513294a != (-1)) goto L7;
        r102 = false;
        goto L9
    }

    public d1(int r110, int r111, long r112, Map r113, long r114, long r210, int r211, long r212, double r213, double r214, long r310, long r311, long r312, long r313, long r314, double r410, double r411, double r412, double r413, long r414, long r510, long r511, long r512, long r513, long r514, long r610, double r611, double r612, double r613, double r614, double r710, double r711, double r712, long r713, long r714, long r810, long r811, double r812, long r813, double r814, long r910, double r911, long r912, double r913, double r914, long r100, long r102, long r104, long r106, long r108, long r115, double r116, long r117) {
        if ((r110 & 0) == 0) goto L5;
        boolean r101 = true;
    L7:
        if ((r111 & 0) == 0) goto L9;
        boolean r103 = true;
    L11:
        if ((r101 | r103) == false) goto L13;
        b2.a(new int[]{r110, r111}, new int[]{0, 0}, a.f513321b);
        throw null;
    L13:
        if ((r110 & 1) != 0) goto L15;
        long r105 = -1;
    L16:
        this.f513294a = r105;
        if ((r110 & 2) != 0) goto L19;
        this.f513295b = null;
    L21:
        if ((r110 & 4) != 0) goto L23;
        this.f513296c = 0;
    L25:
        if ((r110 & 8) != 0) goto L27;
        this.f513297d = 0;
    L29:
        if ((r110 & 16) != 0) goto L31;
        int r107 = 60;
    L32:
        this.f513298e = r107;
        if ((r110 & 32) != 0) goto L35;
        this.f513299f = 0;
    L36:
        int r109 = r110 & 64;
        double r118 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r109 != 0) goto L39;
        this.f513300g = AudioStats.AUDIO_AMPLITUDE_NONE;
    L41:
        if ((r110 & 128) != 0) goto L43;
        this.f513301h = AudioStats.AUDIO_AMPLITUDE_NONE;
    L45:
        if ((r110 & 256) != 0) goto L47;
        this.f513302i = 0;
    L49:
        if ((r110 & 512) != 0) goto L51;
        this.f513303j = 0;
    L53:
        if ((r110 & 1024) != 0) goto L55;
        this.f513304k = 0;
    L57:
        if ((r110 & 2048) != 0) goto L59;
        this.f513305l = 0;
    L61:
        if ((r110 & 4096) != 0) goto L63;
        this.f513306m = 0;
    L65:
        if ((r110 & 8192) != 0) goto L67;
        this.f513307n = AudioStats.AUDIO_AMPLITUDE_NONE;
    L69:
        if ((r110 & 16384) != 0) goto L71;
        this.f513308o = AudioStats.AUDIO_AMPLITUDE_NONE;
    L73:
        if ((r110 & 32768) != 0) goto L75;
        this.f513309p = AudioStats.AUDIO_AMPLITUDE_NONE;
    L77:
        if ((r110 & 65536) != 0) goto L79;
        this.f513310q = AudioStats.AUDIO_AMPLITUDE_NONE;
    L81:
        if ((r110 & 131072) != 0) goto L83;
        this.f513311r = 0;
    L85:
        if ((r110 & 262144) != 0) goto L87;
        this.f513312s = 0;
    L89:
        if ((524288 & r110) != 0) goto L91;
        this.f513313t = 0;
    L93:
        if ((1048576 & r110) != 0) goto L95;
        this.f513314u = 0;
    L97:
        if ((2097152 & r110) != 0) goto L99;
        this.f513315v = 0;
    L101:
        if ((4194304 & r110) != 0) goto L103;
        this.f513316w = 0;
    L105:
        if ((8388608 & r110) != 0) goto L107;
        this.f513317x = 0;
    L109:
        if ((16777216 & r110) != 0) goto L111;
        this.f513318y = AudioStats.AUDIO_AMPLITUDE_NONE;
    L113:
        if ((33554432 & r110) != 0) goto L115;
        this.f513319z = AudioStats.AUDIO_AMPLITUDE_NONE;
    L117:
        if ((67108864 & r110) != 0) goto L119;
        this.A = AudioStats.AUDIO_AMPLITUDE_NONE;
    L121:
        if ((134217728 & r110) != 0) goto L123;
        this.B = AudioStats.AUDIO_AMPLITUDE_NONE;
    L125:
        if ((268435456 & r110) != 0) goto L127;
        this.C = AudioStats.AUDIO_AMPLITUDE_NONE;
    L129:
        if ((536870912 & r110) != 0) goto L131;
        this.D = AudioStats.AUDIO_AMPLITUDE_NONE;
    L133:
        if ((1073741824 & r110) != 0) goto L135;
        this.E = AudioStats.AUDIO_AMPLITUDE_NONE;
    L137:
        if ((r110 & Integer.MIN_VALUE) != 0) goto L139;
        this.F = 0;
    L141:
        if ((r111 & 1) != 0) goto L143;
        this.G = 0;
    L145:
        if ((r111 & 2) != 0) goto L147;
        this.H = 0;
    L149:
        if ((r111 & 4) != 0) goto L151;
        this.I = 0;
    L153:
        if ((r111 & 8) != 0) goto L155;
        this.f513293J = AudioStats.AUDIO_AMPLITUDE_NONE;
    L157:
        if ((r111 & 16) != 0) goto L159;
        this.K = 0;
    L161:
        if ((r111 & 32) != 0) goto L163;
        this.L = AudioStats.AUDIO_AMPLITUDE_NONE;
    L165:
        if ((r111 & 64) != 0) goto L167;
        this.M = 0;
    L169:
        if ((r111 & 128) != 0) goto L171;
        this.N = AudioStats.AUDIO_AMPLITUDE_NONE;
    L173:
        if ((r111 & 256) != 0) goto L175;
        this.O = 0;
    L177:
        if ((r111 & 512) != 0) goto L179;
        this.P = AudioStats.AUDIO_AMPLITUDE_NONE;
    L181:
        if ((r111 & 1024) != 0) goto L183;
        this.Q = AudioStats.AUDIO_AMPLITUDE_NONE;
    L185:
        if ((r111 & 2048) != 0) goto L187;
        this.R = 0;
    L189:
        if ((r111 & 4096) != 0) goto L191;
        this.S = 0;
    L193:
        if ((r111 & 8192) != 0) goto L195;
        this.T = 0;
    L197:
        if ((r111 & 16384) != 0) goto L199;
        this.U = 0;
    L201:
        if ((r111 & 32768) != 0) goto L203;
        this.V = 0;
    L205:
        if ((r111 & 65536) != 0) goto L207;
        this.W = 0;
    L209:
        if ((r111 & 131072) == 0) goto L212;
        r118 = r116;
    L212:
        this.X = r118;
        if ((r111 & 262144) != 0) goto L215;
        this.Y = 0;
        return;
    L215:
        this.Y = r117;
        return;
    L207:
        this.W = r115;
        goto L209
    L203:
        this.V = r108;
        goto L205
    L199:
        this.U = r106;
        goto L201
    L195:
        this.T = r104;
        goto L197
    L191:
        this.S = r102;
        goto L193
    L187:
        this.R = r100;
        goto L189
    L183:
        this.Q = r914;
        goto L185
    L179:
        this.P = r913;
        goto L181
    L175:
        this.O = r912;
        goto L177
    L171:
        this.N = r911;
        goto L173
    L167:
        this.M = r910;
        goto L169
    L163:
        this.L = r814;
        goto L165
    L159:
        this.K = r813;
        goto L161
    L155:
        this.f513293J = r812;
        goto L157
    L151:
        this.I = r811;
        goto L153
    L147:
        this.H = r810;
        goto L149
    L143:
        this.G = r714;
        goto L145
    L139:
        this.F = r713;
        goto L141
    L135:
        this.E = r712;
        goto L137
    L131:
        this.D = r711;
        goto L133
    L127:
        this.C = r710;
        goto L129
    L123:
        this.B = r614;
        goto L125
    L119:
        this.A = r613;
        goto L121
    L115:
        this.f513319z = r612;
        goto L117
    L111:
        this.f513318y = r611;
        goto L113
    L107:
        this.f513317x = r610;
        goto L109
    L103:
        this.f513316w = r514;
        goto L105
    L99:
        this.f513315v = r513;
        goto L101
    L95:
        this.f513314u = r512;
        goto L97
    L91:
        this.f513313t = r511;
        goto L93
    L87:
        this.f513312s = r510;
        goto L89
    L83:
        this.f513311r = r414;
        goto L85
    L79:
        this.f513310q = r413;
        goto L81
    L75:
        this.f513309p = r412;
        goto L77
    L71:
        this.f513308o = r411;
        goto L73
    L67:
        this.f513307n = r410;
        goto L69
    L63:
        this.f513306m = r314;
        goto L65
    L59:
        this.f513305l = r313;
        goto L61
    L55:
        this.f513304k = r312;
        goto L57
    L51:
        this.f513303j = r311;
        goto L53
    L47:
        this.f513302i = r310;
        goto L49
    L43:
        this.f513301h = r214;
        goto L45
    L39:
        this.f513300g = r213;
        goto L41
    L35:
        this.f513299f = r212;
        goto L36
    L31:
        r107 = r211;
        goto L32
    L27:
        this.f513297d = r210;
        goto L29
    L23:
        this.f513296c = r114;
        goto L25
    L19:
        this.f513295b = r113;
        goto L21
    L15:
        r105 = r112;
        goto L16
    L9:
        r103 = false;
        goto L11
    L5:
        r101 = false;
        goto L7
    }
}
