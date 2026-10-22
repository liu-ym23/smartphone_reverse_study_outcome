package md6;

import com.autonavi.amap.mapcore.AMapEngineUtils;
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
public final class h1 extends d1 {
    public static final b Companion = null;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f513374j0 = null;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final String f513375a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final int f513376b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final long f513377c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final long f513378d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final long f513379e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final long f513380f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final long f513381g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final boolean f513382h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final long f513383i0;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<h1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f513384a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f513385b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f513385b;
        }

        static {
            a r100 = new a();
            f513384a = r100;
            g2 r101 = new g2("com.bytedance.kmp.performance.model.KPerfPageLoadMetrics", r100, 59);
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
            r101.j("scene", true);
            r101.j("frame_count", true);
            r101.j("first_frame_duration", true);
            r101.j("update_frame_duration", true);
            r101.j("data_load_duration", true);
            r101.j("container_duration", true);
            r101.j("duration", true);
            r101.j("has_data_loaded", true);
            f513385b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r100 = h1.f513374j0;
            nuc.g1 r101 = nuc.g1.f520681a;
            nuc.w0 r102 = nuc.w0.f520792a;
            nuc.b0 r103 = nuc.b0.f520644a;
            return new juc.d[]{r101, kuc.a.d(r100[1].getValue()), r101, r101, r102, r101, r103, r103, r101, r101, r101, r101, r101, r103, r103, r103, r103, r101, r101, r101, r101, r101, r101, r101, r103, r103, r103, r103, r103, r103, r103, r101, r101, r101, r101, r103, r101, r103, r101, r103, r101, r103, r103, r101, r101, r101, r101, r101, r101, r103, r101, v2.f520790a, r102, r101, r101, r101, r101, r101, nuc.i.f520705a};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r156) {
            Intrinsics.checkNotNullParameter(r156, "decoder");
            g2 r100 = f513385b;
            muc.c r101 = r156.beginStructure(r100);
            Lazy<juc.d<Object>>[] r102 = h1.f513374j0;
            int r110 = 0;
            int r103 = 10;
            Map r104 = null;
            if (r101.decodeSequentially() == false) goto L5;
            long r310 = r101.decodeLongElement(r100, 0);
            Map r105 = (Map) r101.decodeNullableSerializableElement(r100, 1, r102[1].getValue(), null);
            long r106 = r101.decodeLongElement(r100, 2);
            long r107 = r101.decodeLongElement(r100, 3);
            int r108 = r101.decodeIntElement(r100, 4);
            long r111 = r101.decodeLongElement(r100, 5);
            double r112 = r101.decodeDoubleElement(r100, 6);
            double r311 = r101.decodeDoubleElement(r100, 7);
            long r312 = r101.decodeLongElement(r100, 8);
            long r113 = r101.decodeLongElement(r100, 9);
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
            long r114 = r101.decodeLongElement(r100, 22);
            long r510 = r101.decodeLongElement(r100, 23);
            double r511 = r101.decodeDoubleElement(r100, 24);
            double r512 = r101.decodeDoubleElement(r100, 25);
            double r513 = r101.decodeDoubleElement(r100, 26);
            double r514 = r101.decodeDoubleElement(r100, 27);
            double r610 = r101.decodeDoubleElement(r100, 28);
            double r611 = r101.decodeDoubleElement(r100, 29);
            double r612 = r101.decodeDoubleElement(r100, 30);
            long r613 = r101.decodeLongElement(r100, 31);
            long r115 = r101.decodeLongElement(r100, 32);
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
            double r109 = r101.decodeDoubleElement(r100, 49);
            long r1010 = r101.decodeLongElement(r100, 50);
            String r116 = r101.decodeStringElement(r100, 51);
            int r117 = r101.decodeIntElement(r100, 52);
            long r1011 = r101.decodeLongElement(r100, 53);
            long r1012 = r101.decodeLongElement(r100, 54);
            long r1013 = r101.decodeLongElement(r100, 55);
            long r118 = r101.decodeLongElement(r100, 56);
            long r119 = r101.decodeLongElement(r100, 57);
            boolean r123 = r101.decodeBooleanElement(r100, 58);
            long r1110 = r1012;
            long r1111 = r1013;
            long r1112 = r118;
            long r121 = r119;
            String r1113 = r116;
            int r1114 = r117;
            double r1014 = r109;
            long r1015 = r1010;
            long r1115 = r1011;
            int r120 = -1;
            long r1016 = r912;
            long r1017 = r913;
            long r1018 = r914;
            long r915 = r814;
            long r916 = r910;
            long r917 = r911;
            long r815 = r811;
            double r918 = r812;
            double r919 = r813;
            double r816 = r713;
            long r817 = r714;
            double r818 = r810;
            long r715 = r710;
            double r716 = r711;
            long r819 = r712;
            long r717 = r115;
            long r718 = r613;
            long r719 = r614;
            long r122 = r107;
            double r615 = r611;
            double r616 = r612;
            double r617 = r514;
            double r618 = r610;
            double r515 = r512;
            double r619 = r513;
            long r516 = r510;
            double r517 = r511;
            long r518 = r114;
            long r519 = r414;
            int r124 = r108;
            long r415 = r214;
            long r416 = r413;
            long r125 = r111;
            int r126 = 134217727;
            Map r127 = r105;
            long r128 = r310;
            long r417 = r412;
            long r418 = r213;
            double r215 = r112;
            long r129 = r106;
            double r315 = r411;
            double r419 = r212;
            double r216 = r311;
            long r316 = r314;
            double r317 = r410;
            double r318 = r211;
            long r319 = r210;
            long r217 = r312;
            long r218 = r313;
            long r219 = r113;
        L86:
            r101.endStructure(r100);
            return new h1(r120, r126, r128, r127, r129, r122, r124, r125, r215, r216, r217, r219, r218, r316, r319, r317, r318, r315, r419, r417, r418, r416, r415, r519, r518, r516, r517, r515, r619, r617, r618, r615, r616, r718, r717, r719, r715, r716, r819, r816, r817, r818, r815, r918, r919, r915, r916, r917, r1016, r1017, r1018, r1014, r1015, r1113, r1114, r1115, r1110, r1111, r1112, r121, r123);
        L5:
            long r320 = 0;
            long r321 = 0;
            long r322 = 0;
            long r420 = 0;
            long r421 = 0;
            long r422 = 0;
            long r423 = 0;
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
            long r1019 = 0;
            long r1020 = 0;
            long r1021 = 0;
            long r1116 = 0;
            long r1117 = 0;
            long r1118 = 0;
            long r1210 = 0;
            long r1211 = 0;
            long r1212 = 0;
            long r1213 = 0;
            long r131 = 0;
            long r133 = 0;
            long r135 = 0;
            long r137 = 0;
            long r139 = 0;
            double r424 = 0.0d;
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
            double r1022 = 0.0d;
            double r1023 = 0.0d;
            double r1119 = 0.0d;
            double r1120 = 0.0d;
            double r1214 = 0.0d;
            boolean r130 = false;
            r126 = 0;
            int r323 = 0;
            int r324 = 0;
            boolean r141 = true;
            String r325 = null;
            long r326 = 0;
        L6:
            if (r141 == false) goto L85;
            int r132 = r101.decodeElementIndex(r100);
            switch(r132) {
                case -1: goto L83;
                case 0: goto L82;
                case 1: goto L80;
                case 2: goto L78;
                case 3: goto L76;
                case 4: goto L74;
                case 5: goto L73;
                case 6: goto L72;
                case 7: goto L71;
                case 8: goto L70;
                case 9: goto L69;
                case 10: goto L68;
                case 11: goto L67;
                case 12: goto L65;
                case 13: goto L63;
                case 14: goto L62;
                case 15: goto L60;
                case 16: goto L59;
                case 17: goto L58;
                case 18: goto L56;
                case 19: goto L54;
                case 20: goto L52;
                case 21: goto L51;
                case 22: goto L50;
                case 23: goto L49;
                case 24: goto L48;
                case 25: goto L47;
                case 26: goto L46;
                case 27: goto L45;
                case 28: goto L44;
                case 29: goto L43;
                case 30: goto L42;
                case 31: goto L41;
                case 32: goto L39;
                case 33: goto L37;
                case 34: goto L36;
                case 35: goto L35;
                case 36: goto L34;
                case 37: goto L33;
                case 38: goto L32;
                case 39: goto L31;
                case 40: goto L30;
                case 41: goto L29;
                case 42: goto L28;
                case 43: goto L27;
                case 44: goto L26;
                case 45: goto L25;
                case 46: goto L24;
                case 47: goto L22;
                case 48: goto L21;
                case 49: goto L20;
                case 50: goto L19;
                case 51: goto L18;
                case 52: goto L17;
                case 53: goto L16;
                case 54: goto L15;
                case 55: goto L14;
                case 56: goto L13;
                case 57: goto L12;
                case 58: goto L11;
                default: goto L10;
            };
        L11:
            r130 = r101.decodeBooleanElement(r100, 58);
            int r134 = 67108864;
        L23:
            int r136 = r134 | r126;
        L38:
            r126 = r136;
        L66:
            Unit r138 = Unit.INSTANCE;
        L84:
            r103 = 10;
            goto L6
        L12:
            r139 = r101.decodeLongElement(r100, 57);
            r134 = 33554432;
            goto L23
        L13:
            r137 = r101.decodeLongElement(r100, 56);
            r134 = 16777216;
            goto L23
        L14:
            r135 = r101.decodeLongElement(r100, 55);
            r134 = 8388608;
            goto L23
        L15:
            r133 = r101.decodeLongElement(r100, 54);
            r134 = 4194304;
            goto L23
        L16:
            r131 = r101.decodeLongElement(r100, 53);
            r134 = 2097152;
            goto L23
        L17:
            r324 = r101.decodeIntElement(r100, 52);
            r134 = 1048576;
            goto L23
        L18:
            r325 = r101.decodeStringElement(r100, 51);
            int r140 = 524288 | r126;
            Unit r142 = Unit.INSTANCE;
            r126 = r140;
            goto L84
        L19:
            r1213 = r101.decodeLongElement(r100, 50);
            r134 = 262144;
            goto L23
        L20:
            r1214 = r101.decodeDoubleElement(r100, 49);
            r134 = 131072;
            goto L23
        L21:
            r1212 = r101.decodeLongElement(r100, 48);
            r134 = 65536;
            goto L23
        L22:
            r1211 = r101.decodeLongElement(r100, 47);
            r134 = 32768;
            goto L23
        L24:
            r1210 = r101.decodeLongElement(r100, 46);
            r136 = r126 | 16384;
            goto L38
        L25:
            r1118 = r101.decodeLongElement(r100, 45);
            r136 = r126 | 8192;
            goto L38
        L26:
            r1117 = r101.decodeLongElement(r100, 44);
            r136 = r126 | 4096;
            goto L38
        L27:
            r1116 = r101.decodeLongElement(r100, 43);
            r136 = r126 | 2048;
            goto L38
        L28:
            r1120 = r101.decodeDoubleElement(r100, 42);
            r136 = r126 | 1024;
            goto L38
        L29:
            r1119 = r101.decodeDoubleElement(r100, 41);
            r136 = r126 | 512;
            goto L38
        L30:
            r1021 = r101.decodeLongElement(r100, 40);
            r136 = r126 | 256;
            goto L38
        L31:
            r1023 = r101.decodeDoubleElement(r100, 39);
            r136 = r126 | 128;
            goto L38
        L32:
            r1020 = r101.decodeLongElement(r100, 38);
            r136 = r126 | 64;
            goto L38
        L33:
            r1022 = r101.decodeDoubleElement(r100, 37);
            r136 = r126 | 32;
            goto L38
        L34:
            r1019 = r101.decodeLongElement(r100, 36);
            r136 = r126 | 16;
            goto L38
        L35:
            r924 = r101.decodeDoubleElement(r100, 35);
            r136 = r126 | 8;
            goto L38
        L36:
            r922 = r101.decodeLongElement(r100, 34);
            r136 = r126 | 4;
            goto L38
        L37:
            r921 = r101.decodeLongElement(r100, 33);
            r136 = r126 | 2;
            goto L38
        L39:
            r420 = r101.decodeLongElement(r100, 32);
            r126 = r126 | 1;
            Unit r143 = Unit.INSTANCE;
            goto L84
        L41:
            r920 = r101.decodeLongElement(r100, 31);
            int r144 = Integer.MIN_VALUE;
        L57:
            r110 = r110 | r144;
            goto L66
        L42:
            r923 = r101.decodeDoubleElement(r100, 30);
            r144 = 1073741824;
            goto L57
        L43:
            r824 = r101.decodeDoubleElement(r100, 29);
            r144 = 536870912;
            goto L57
        L44:
            r823 = r101.decodeDoubleElement(r100, 28);
            r144 = 268435456;
            goto L57
        L45:
            r822 = r101.decodeDoubleElement(r100, 27);
            r144 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
            goto L57
        L46:
            r821 = r101.decodeDoubleElement(r100, 26);
            r144 = 67108864;
            goto L57
        L47:
            r820 = r101.decodeDoubleElement(r100, 25);
            r144 = 33554432;
            goto L57
        L48:
            r724 = r101.decodeDoubleElement(r100, 24);
            r144 = 16777216;
            goto L57
        L49:
            r723 = r101.decodeLongElement(r100, 23);
            r144 = 8388608;
            goto L57
        L50:
            r421 = r101.decodeLongElement(r100, 22);
            r144 = 4194304;
            goto L57
        L51:
            r722 = r101.decodeLongElement(r100, 21);
            r144 = 2097152;
            goto L57
        L52:
            r422 = r101.decodeLongElement(r100, 20);
            r144 = 1048576;
            goto L57
        L54:
            r721 = r101.decodeLongElement(r100, 19);
            r144 = 524288;
            goto L57
        L56:
            r423 = r101.decodeLongElement(r100, 18);
            r144 = 262144;
            goto L57
        L58:
            r720 = r101.decodeLongElement(r100, 17);
            r110 = r110 | 131072;
        L75:
            Unit r145 = Unit.INSTANCE;
            goto L84
        L59:
            r522 = r101.decodeDoubleElement(r100, 16);
            int r146 = 65536;
        L61:
            r110 = r110 | r146;
            goto L66
        L60:
            r624 = r101.decodeDoubleElement(r100, 15);
            r146 = 32768;
            goto L61
        L62:
            r523 = r101.decodeDoubleElement(r100, 14);
            r110 = r110 | 16384;
            goto L66
        L63:
            r623 = r101.decodeDoubleElement(r100, 13);
            r110 = r110 | 8192;
            goto L66
        L65:
            r520 = r101.decodeLongElement(r100, 12);
            r110 = r110 | 4096;
            goto L66
        L67:
            r622 = r101.decodeLongElement(r100, 11);
            r110 = r110 | 2048;
            goto L75
        L68:
            r621 = r101.decodeLongElement(r100, r103);
            r110 = r110 | 1024;
            goto L75
        L69:
            r322 = r101.decodeLongElement(r100, 9);
            r110 = r110 | 512;
            goto L75
        L70:
            r620 = r101.decodeLongElement(r100, 8);
            r110 = r110 | 256;
            goto L75
        L71:
            r524 = r101.decodeDoubleElement(r100, 7);
            r110 = r110 | 128;
            goto L75
        L72:
            r424 = r101.decodeDoubleElement(r100, 6);
            r110 = r110 | 64;
            goto L75
        L73:
            r321 = r101.decodeLongElement(r100, 5);
            r110 = r110 | 32;
            goto L75
        L74:
            r323 = r101.decodeIntElement(r100, 4);
            r110 = r110 | 16;
            goto L75
        L76:
            r326 = r101.decodeLongElement(r100, 3);
            r110 = r110 | 8;
            Unit r220 = Unit.INSTANCE;
            goto L84
        L78:
            r320 = r101.decodeLongElement(r100, 2);
            r110 = r110 | 4;
            Unit r221 = Unit.INSTANCE;
            goto L84
        L80:
            r104 = (Map) r101.decodeNullableSerializableElement(r100, 1, r102[1].getValue(), r104);
            int r147 = r110 | 2;
            Unit r148 = Unit.INSTANCE;
            r110 = r147;
            goto L84
        L82:
            r521 = r101.decodeLongElement(r100, 0);
            r110 = r110 | 1;
            Unit r222 = Unit.INSTANCE;
            goto L84
        L83:
            Unit r223 = Unit.INSTANCE;
            r141 = false;
            goto L84
        L10:
            throw new UnknownFieldException(r132);
        L85:
            r127 = r104;
            r120 = r110;
            r129 = r320;
            r122 = r326;
            r124 = r323;
            r125 = r321;
            r219 = r322;
            r215 = r424;
            r419 = r522;
            r318 = r523;
            r319 = r520;
            r128 = r521;
            r216 = r524;
            r217 = r620;
            r218 = r621;
            r315 = r624;
            r519 = r722;
            r516 = r723;
            r517 = r724;
            r515 = r820;
            r619 = r821;
            r617 = r822;
            r616 = r923;
            r719 = r921;
            r715 = r922;
            r716 = r924;
            r819 = r1019;
            r816 = r1022;
            r817 = r1020;
            r918 = r1119;
            r915 = r1116;
            r916 = r1117;
            r917 = r1118;
            r1016 = r1210;
            r1017 = r1211;
            r1018 = r1212;
            r1110 = r133;
            r1111 = r135;
            r1112 = r137;
            r121 = r139;
            r123 = r130;
            r1113 = r325;
            r1114 = r324;
            r518 = r421;
            r418 = r423;
            r316 = r622;
            r317 = r623;
            r618 = r823;
            r615 = r824;
            r818 = r1023;
            r815 = r1021;
            r1014 = r1214;
            r1015 = r1213;
            r415 = r422;
            r416 = r721;
            r717 = r420;
            r417 = r720;
            r718 = r920;
            r919 = r1120;
            r1115 = r131;
            goto L86
        }

        @Override // juc.n
        public final void serialize(muc.f r110, Object r111) {
            h1 r112 = (h1) r111;
            Intrinsics.checkNotNullParameter(r110, "encoder");
            Intrinsics.checkNotNullParameter(r112, "value");
            g2 r100 = f513385b;
            muc.d r113 = r110.beginStructure(r100);
            b r101 = h1.Companion;
            d1.e(r112, r113, r100);
            boolean r102 = true;
            if (r113.shouldEncodeElementDefault(r100, 51) == false) goto L6;
        L7:
            boolean r103 = true;
        L9:
            if (r103 == false) goto L12;
            r113.encodeStringElement(r100, 51, r112.f513375a0);
        L12:
            if (r113.shouldEncodeElementDefault(r100, 52) == false) goto L15;
        L16:
            boolean r104 = true;
        L18:
            if (r104 == false) goto L21;
            r113.encodeIntElement(r100, 52, r112.f513376b0);
        L21:
            if (r113.shouldEncodeElementDefault(r100, 53) == false) goto L24;
        L25:
            boolean r105 = true;
        L27:
            if (r105 == false) goto L30;
            r113.encodeLongElement(r100, 53, r112.f513377c0);
        L30:
            if (r113.shouldEncodeElementDefault(r100, 54) == false) goto L33;
        L34:
            boolean r106 = true;
        L36:
            if (r106 == false) goto L39;
            r113.encodeLongElement(r100, 54, r112.f513378d0);
        L39:
            if (r113.shouldEncodeElementDefault(r100, 55) == false) goto L42;
        L43:
            boolean r107 = true;
        L45:
            if (r107 == false) goto L48;
            r113.encodeLongElement(r100, 55, r112.f513379e0);
        L48:
            if (r113.shouldEncodeElementDefault(r100, 56) == false) goto L51;
        L52:
            boolean r108 = true;
        L54:
            if (r108 == false) goto L57;
            r113.encodeLongElement(r100, 56, r112.f513380f0);
        L57:
            if (r113.shouldEncodeElementDefault(r100, 57) == false) goto L60;
        L61:
            boolean r109 = true;
        L63:
            if (r109 == false) goto L66;
            r113.encodeLongElement(r100, 57, r112.f513381g0);
        L66:
            if (r113.shouldEncodeElementDefault(r100, 58) == false) goto L69;
        L72:
            if (r102 == false) goto L74;
            r113.encodeBooleanElement(r100, 58, r112.f513382h0);
        L74:
            r113.endStructure(r100);
            return;
        L69:
            if (r112.f513382h0 == true) goto L72;
            r102 = false;
            goto L72
        L60:
            if (r112.f513381g0 != 0) goto L61;
            r109 = false;
            goto L63
        L51:
            if (r112.f513380f0 != 0) goto L52;
            r108 = false;
            goto L54
        L42:
            if (r112.f513379e0 != 0) goto L43;
            r107 = false;
            goto L45
        L33:
            if (r112.f513378d0 != 0) goto L34;
            r106 = false;
            goto L36
        L24:
            if (r112.f513377c0 != 0) goto L25;
            r105 = false;
            goto L27
        L15:
            if (r112.f513376b0 != 0) goto L16;
            r104 = false;
            goto L18
        L6:
            if (Intrinsics.areEqual(r112.f513375a0, "") == false) goto L7;
            r103 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<h1> serializer() {
            return a.f513384a;
        }
    }

    public h1() {
        this(null, 0, 0, 0, 0, 0, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h1) == true) goto L8;
        return false;
    L8:
        h1 r101 = (h1) r100;
        if (Intrinsics.areEqual(this.f513375a0, r101.f513375a0) == true) goto L12;
        return false;
    L12:
        if (this.f513376b0 == r101.f513376b0) goto L15;
        return false;
    L15:
        if (this.f513377c0 == r101.f513377c0) goto L18;
        return false;
    L18:
        if (this.f513378d0 == r101.f513378d0) goto L21;
        return false;
    L21:
        if (this.f513379e0 == r101.f513379e0) goto L24;
        return false;
    L24:
        if (this.f513380f0 == r101.f513380f0) goto L27;
        return false;
    L27:
        if (this.f513381g0 == r101.f513381g0) goto L30;
        return false;
    L30:
        if (this.f513382h0 == r101.f513382h0) goto L33;
        return false;
    L33:
        if (this.f513383i0 == r101.f513383i0) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f513375a0.hashCode() * 31) + this.f513376b0) * 31;
        long r101 = this.f513377c0;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f513378d0;
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f513379e0;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        long r107 = this.f513380f0;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.f513381g0;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        if (this.f513382h0 == false) goto L5;
        int r111 = 1231;
    L6:
        int r112 = (r110 + r111) * 31;
        long r113 = this.f513383i0;
        return r112 + ((int) (r113 ^ (r113 >>> 32)));
    L5:
        r111 = 1237;
        goto L6
    }

    public final String toString() {
        return "KPerfPageLoadMetrics(scene=" + this.f513375a0 + ", frameCount=" + this.f513376b0 + ", firstFrameDuration=" + this.f513377c0 + ", updateFrameDuration=" + this.f513378d0 + ", dataLoadDuration=" + this.f513379e0 + ", containerDurationMs=" + this.f513380f0 + ", durationMs=" + this.f513381g0 + ", hasDataLoaded=" + this.f513382h0 + ", launchTimeStampMs=" + this.f513383i0 + ')';
    }

    static {
        Companion = new b();
        f513374j0 = new Lazy[]{null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new g1()), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};
    }

    public /* synthetic */ h1(String r210, int r211, long r212, long r213, long r214, long r215, int r310) {
        if ((r310 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r310 & 2) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r310 & 4) == 0) goto L13;
        long r102 = 0;
    L15:
        if ((r310 & 32) == 0) goto L17;
        long r110 = 0;
    L19:
        if ((r310 & 64) == 0) goto L21;
        long r111 = 0;
    L23:
        if ((r310 & 256) == 0) goto L25;
        long r112 = 0;
    L26:
        this(r100, r101, r102, 0, 0, r110, r111, false, r112);
        return;
    L25:
        r112 = r215;
        goto L26
    L21:
        r111 = r214;
        goto L23
    L17:
        r110 = r213;
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

    public h1(String r100, int r101, long r102, long r103, long r110, long r111, long r112, boolean r113, long r114) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        super(null);
        this.f513375a0 = r100;
        this.f513376b0 = r101;
        this.f513377c0 = r102;
        this.f513378d0 = r103;
        this.f513379e0 = r110;
        this.f513380f0 = r111;
        this.f513381g0 = r112;
        this.f513382h0 = r113;
        this.f513383i0 = r114;
    }

    public h1(int r100, int r101, long r110, Map r111, long r112, long r113, int r114, long r115, double r210, double r211, long r212, long r213, long r214, long r310, long r311, double r312, double r313, double r314, double r410, long r411, long r412, long r413, long r414, long r510, long r511, long r512, double r513, double r514, double r610, double r611, double r612, double r613, double r614, long r710, long r711, long r712, long r713, double r714, long r810, double r811, long r812, double r813, long r814, double r910, double r911, long r912, long r913, long r914, long r102, long r103, long r104, double r106, long r108, String r116, int r117, long r118, long r119, long r1110, long r1111, long r120, boolean r122) {
        boolean r105 = false;
        if ((r100 & 0) == 0) goto L5;
        boolean r107 = true;
    L7:
        if ((r101 & 0) == 0) goto L9;
        boolean r109 = true;
    L11:
        if ((r107 | r109) == true) goto L46;
        super(r100, r101, r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214, r310, r311, r312, r313, r314, r410, r411, r412, r413, r414, r510, r511, r512, r513, r514, r610, r611, r612, r613, r614, r710, r711, r712, r713, r714, r810, r811, r812, r813, r814, r910, r911, r912, r913, r914, r102, r103, r104, r106, r108);
        if ((524288 & r101) != 0) goto L15;
        String r121 = "";
    L16:
        this.f513375a0 = r121;
        if ((1048576 & r101) != 0) goto L19;
        this.f513376b0 = 0;
    L21:
        if ((2097152 & r101) != 0) goto L23;
        this.f513377c0 = 0;
    L25:
        if ((4194304 & r101) != 0) goto L27;
        this.f513378d0 = 0;
    L29:
        if ((8388608 & r101) != 0) goto L31;
        this.f513379e0 = 0;
    L33:
        if ((16777216 & r101) != 0) goto L35;
        this.f513380f0 = 0;
    L37:
        if ((33554432 & r101) != 0) goto L39;
        this.f513381g0 = 0;
    L41:
        if ((67108864 & r101) == 0) goto L44;
        r105 = r122;
    L44:
        this.f513382h0 = r105;
        this.f513383i0 = 0;
        return;
    L39:
        this.f513381g0 = r120;
        goto L41
    L35:
        this.f513380f0 = r1111;
        goto L37
    L31:
        this.f513379e0 = r1110;
        goto L33
    L27:
        this.f513378d0 = r119;
        goto L29
    L23:
        this.f513377c0 = r118;
        goto L25
    L19:
        this.f513376b0 = r117;
        goto L21
    L15:
        r121 = r116;
        goto L16
    L46:
        b2.a(new int[]{r100, r101}, new int[]{0, 0}, a.f513385b);
        throw null;
    L9:
        r109 = false;
        goto L11
    L5:
        r107 = false;
        goto L7
    }
}
