package com.larus.im.internal.delegate;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.bytedance.android.livesdk.announcement.AnnouncementViewModel;
import com.google.gson.annotations.JsonAdapter;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.v2;

/* JADX INFO: loaded from: classes4.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f348459a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f348460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static List<Integer> f348461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static n f348462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile Boolean f348463e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static k f348464f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static r f348465g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile d f348466h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy f348467i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static volatile b f348468j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile l f348469k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Object f348470l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Lazy f348471m = null;

    @Serializable
    public static final class a {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f348472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f348473b;

        /* JADX INFO: renamed from: com.larus.im.internal.delegate.y0$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: classes29.dex */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class C4356a implements nuc.m0<a> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C4356a f348474a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348475b = null;

            public C4356a() {
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                return new juc.d[]{nuc.i.f520705a, nuc.g1.f520681a};
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348475b;
            }

            static {
                C4356a r100 = new C4356a();
                f348474a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowSettingsDelegate.AsyncLoadConversationData", r100, 2);
                r101.j("enable", true);
                r101.j("fetch_cvs_data_duration", true);
                f348475b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r110) {
                Intrinsics.checkNotNullParameter(r110, "decoder");
                g2 r100 = f348475b;
                muc.c r111 = r110.beginStructure(r100);
                if (r111.decodeSequentially() == false) goto L5;
                boolean r101 = r111.decodeBooleanElement(r100, 0);
                long r102 = r111.decodeLongElement(r100, 1);
                int r103 = 3;
            L17:
                r111.endStructure(r100);
                return new a(r103, r101, r102);
            L5:
                long r104 = 0;
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
                r104 = r111.decodeLongElement(r100, 1);
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
            public final void serialize(muc.f r100, Object r110) {
                a r111 = (a) r110;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r111, "value");
                g2 r101 = f348475b;
                muc.d r102 = r100.beginStructure(r101);
                b r103 = a.Companion;
                boolean r104 = false;
                if (r102.shouldEncodeElementDefault(r101, 0) == false) goto L6;
            L7:
                boolean r105 = true;
            L9:
                if (r105 == false) goto L12;
                r102.encodeBooleanElement(r101, 0, r111.f348472a);
            L12:
                if (r102.shouldEncodeElementDefault(r101, 1) == false) goto L15;
            L16:
                r104 = true;
            L17:
                if (r104 == false) goto L19;
                r102.encodeLongElement(r101, 1, r111.f348473b);
            L19:
                r102.endStructure(r101);
                return;
            L15:
                if (r111.f348473b == 1000) goto L17;
            L6:
                if (r111.f348472a != true) goto L7;
                r105 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<a> serializer() {
                return C4356a.f348474a;
            }
        }

        public a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f348472a == r101.f348472a) goto L12;
            return false;
        L12:
            if (this.f348473b == r101.f348473b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f348472a == false) goto L5;
            int r100 = 1231;
        L6:
            long r101 = this.f348473b;
            return (r100 * 31) + ((int) (r101 ^ (r101 >>> 32)));
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "AsyncLoadConversationData(enable=" + this.f348472a + ", fetchCvsDataDuration=" + this.f348473b + ')';
        }

        static {
            Companion = new b();
        }

        public a(int r100) {
            this.f348472a = true;
            this.f348473b = 1000;
        }

        public a(int r100, boolean r101, long r102) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, C4356a.f348475b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            r101 = true;
        L7:
            this.f348472a = r101;
            if ((r100 & 2) != 0) goto L10;
            this.f348473b = 1000;
            return;
        L10:
            this.f348473b = r102;
        }
    }

    @Serializable
    public static final class b {
        public static final C4357b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f348476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double f348477b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f348478c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final double f348479d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final double f348480e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final double f348481f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f348482g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f348483h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f348484i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final boolean f348485j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final boolean f348486k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final boolean f348487l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f348488m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final int f348489n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final int f348490o;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<b> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348491a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348492b = null;

            public a() {
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348492b;
            }

            static {
                a r100 = new a();
                f348491a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowSettingsDelegate.CommunicationConfig", r100, 15);
                r101.j("send_action_connection_timeout_sec", true);
                r101.j("send_action_timeout_sec", true);
                r101.j("send_action_retry_time", true);
                r101.j("send_action_retry_interval_sec", true);
                r101.j("receiver_compensation_interval_sec", true);
                r101.j("frozen_compensate_recent_conv_request", true);
                r101.j("thinking_data_cache_enable", true);
                r101.j("message_list_get_fix", true);
                r101.j("message_list_interval_range_fix", true);
                r101.j("message_list_final_data_fix", true);
                r101.j("multi_chain_clear_memory_cache", true);
                r101.j("message_list_new_processor", true);
                r101.j("single_chain_fix_blank_once_limit", true);
                r101.j("single_chain_fix_blank_recursion_times", true);
                r101.j("single_chain_fix_blank_no_net_recursion_times", true);
                f348492b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                nuc.b0 r100 = nuc.b0.f520644a;
                nuc.w0 r101 = nuc.w0.f520792a;
                nuc.i r102 = nuc.i.f520705a;
                return new juc.d[]{r100, r100, r101, r100, r100, r100, r102, r102, r102, r102, r102, r102, r101, r101, r101};
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r410) {
                Intrinsics.checkNotNullParameter(r410, "decoder");
                g2 r100 = f348492b;
                muc.c r101 = r410.beginStructure(r100);
                int r102 = 0;
                if (r101.decodeSequentially() == false) goto L5;
                double r110 = r101.decodeDoubleElement(r100, 0);
                double r103 = r101.decodeDoubleElement(r100, 1);
                int r104 = r101.decodeIntElement(r100, 2);
                double r105 = r101.decodeDoubleElement(r100, 3);
                double r111 = r101.decodeDoubleElement(r100, 4);
                double r210 = r101.decodeDoubleElement(r100, 5);
                boolean r106 = r101.decodeBooleanElement(r100, 6);
                boolean r107 = r101.decodeBooleanElement(r100, 7);
                boolean r108 = r101.decodeBooleanElement(r100, 8);
                boolean r112 = r101.decodeBooleanElement(r100, 9);
                boolean r113 = r101.decodeBooleanElement(r100, 10);
                boolean r114 = r101.decodeBooleanElement(r100, 11);
                int r115 = r101.decodeIntElement(r100, 12);
                boolean r211 = r107;
                boolean r212 = r108;
                int r213 = r115;
                boolean r214 = r114;
                boolean r215 = r113;
                boolean r216 = r112;
                int r217 = r101.decodeIntElement(r100, 13);
                int r310 = r101.decodeIntElement(r100, 14);
                double r116 = r110;
                double r117 = r111;
                double r218 = r210;
                int r118 = 32767;
                int r119 = r104;
                boolean r219 = r106;
                double r120 = r105;
                double r121 = r103;
            L31:
                r101.endStructure(r100);
                return new b(r118, r116, r121, r119, r120, r117, r218, r219, r211, r212, r216, r215, r214, r213, r217, r310);
            L5:
                int r109 = 14;
                double r122 = 0.0d;
                double r220 = 0.0d;
                double r311 = 0.0d;
                double r312 = 0.0d;
                double r313 = 0.0d;
                int r123 = 0;
                boolean r124 = false;
                boolean r221 = false;
                boolean r222 = false;
                int r223 = 0;
                boolean r224 = false;
                boolean r225 = false;
                boolean r226 = false;
                r217 = 0;
                r310 = 0;
                boolean r314 = true;
            L6:
                if (r314 == false) goto L30;
                int r125 = r101.decodeElementIndex(r100);
                switch(r125) {
                    case -1: goto L29;
                    case 0: goto L27;
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
                throw new UnknownFieldException(r125);
            L29:
                r109 = 14;
                r314 = false;
                goto L6
            L11:
                r310 = r101.decodeIntElement(r100, r109);
                r102 = r102 | 16384;
            L28:
                r109 = 14;
                goto L6
            L12:
                r217 = r101.decodeIntElement(r100, 13);
                r102 = r102 | 8192;
                goto L28
            L13:
                r223 = r101.decodeIntElement(r100, 12);
                r102 = r102 | 4096;
                goto L28
            L14:
                r224 = r101.decodeBooleanElement(r100, 11);
                r102 = r102 | 2048;
                goto L28
            L15:
                r225 = r101.decodeBooleanElement(r100, 10);
                r102 = r102 | 1024;
                goto L28
            L16:
                r226 = r101.decodeBooleanElement(r100, 9);
                r102 = r102 | 512;
                goto L28
            L17:
                r222 = r101.decodeBooleanElement(r100, 8);
                r102 = r102 | 256;
                goto L28
            L18:
                r221 = r101.decodeBooleanElement(r100, 7);
                r102 = r102 | 128;
                goto L28
            L19:
                r124 = r101.decodeBooleanElement(r100, 6);
                r102 = r102 | 64;
                goto L28
            L20:
                r313 = r101.decodeDoubleElement(r100, 5);
                r102 = r102 | 32;
                goto L28
            L21:
                r312 = r101.decodeDoubleElement(r100, 4);
                r102 = r102 | 16;
                goto L28
            L22:
                r122 = r101.decodeDoubleElement(r100, 3);
                r102 = r102 | 8;
                goto L28
            L23:
                r123 = r101.decodeIntElement(r100, 2);
                r102 = r102 | 4;
                goto L28
            L25:
                r220 = r101.decodeDoubleElement(r100, 1);
                r102 = r102 | 2;
                goto L28
            L27:
                r311 = r101.decodeDoubleElement(r100, 0);
                r102 = r102 | 1;
                goto L28
            L30:
                r118 = r102;
                r119 = r123;
                r120 = r122;
                r121 = r220;
                r116 = r311;
                r211 = r221;
                r212 = r222;
                r218 = r313;
                r219 = r124;
                r117 = r312;
                boolean r315 = r226;
                r213 = r223;
                r216 = r315;
                boolean r316 = r225;
                r214 = r224;
                r215 = r316;
                goto L31
            }

            @Override // juc.n
            public final void serialize(muc.f r110, Object r111) {
                b r112 = (b) r111;
                Intrinsics.checkNotNullParameter(r110, "encoder");
                Intrinsics.checkNotNullParameter(r112, "value");
                g2 r100 = f348492b;
                muc.d r113 = r110.beginStructure(r100);
                C4357b r101 = b.Companion;
                boolean r102 = false;
                if (r113.shouldEncodeElementDefault(r100, 0) == false) goto L6;
            L7:
                boolean r103 = true;
            L9:
                if (r103 == false) goto L12;
                r113.encodeDoubleElement(r100, 0, r112.f348476a);
            L12:
                if (r113.shouldEncodeElementDefault(r100, 1) == false) goto L15;
            L16:
                boolean r104 = true;
            L18:
                if (r104 == false) goto L21;
                r113.encodeDoubleElement(r100, 1, r112.f348477b);
            L21:
                if (r113.shouldEncodeElementDefault(r100, 2) == false) goto L24;
            L25:
                boolean r105 = true;
            L27:
                if (r105 == false) goto L30;
                r113.encodeIntElement(r100, 2, r112.f348478c);
            L30:
                if (r113.shouldEncodeElementDefault(r100, 3) == false) goto L33;
            L34:
                boolean r106 = true;
            L36:
                if (r106 == false) goto L39;
                r113.encodeDoubleElement(r100, 3, r112.f348479d);
            L39:
                if (r113.shouldEncodeElementDefault(r100, 4) == false) goto L42;
            L43:
                boolean r107 = true;
            L45:
                if (r107 == false) goto L48;
                r113.encodeDoubleElement(r100, 4, r112.f348480e);
            L48:
                if (r113.shouldEncodeElementDefault(r100, 5) == false) goto L51;
            L52:
                boolean r108 = true;
            L54:
                if (r108 == false) goto L57;
                r113.encodeDoubleElement(r100, 5, r112.f348481f);
            L57:
                if (r113.shouldEncodeElementDefault(r100, 6) == false) goto L60;
            L61:
                boolean r109 = true;
            L63:
                if (r109 == false) goto L66;
                r113.encodeBooleanElement(r100, 6, r112.f348482g);
            L66:
                if (r113.shouldEncodeElementDefault(r100, 7) == false) goto L69;
            L70:
                boolean r114 = true;
            L72:
                if (r114 == false) goto L75;
                r113.encodeBooleanElement(r100, 7, r112.f348483h);
            L75:
                if (r113.shouldEncodeElementDefault(r100, 8) == false) goto L78;
            L79:
                boolean r115 = true;
            L81:
                if (r115 == false) goto L84;
                r113.encodeBooleanElement(r100, 8, r112.f348484i);
            L84:
                if (r113.shouldEncodeElementDefault(r100, 9) == false) goto L87;
            L88:
                boolean r116 = true;
            L90:
                if (r116 == false) goto L93;
                r113.encodeBooleanElement(r100, 9, r112.f348485j);
            L93:
                if (r113.shouldEncodeElementDefault(r100, 10) == false) goto L96;
            L97:
                boolean r117 = true;
            L99:
                if (r117 == false) goto L102;
                r113.encodeBooleanElement(r100, 10, r112.f348486k);
            L102:
                if (r113.shouldEncodeElementDefault(r100, 11) == false) goto L105;
            L106:
                boolean r118 = true;
            L108:
                if (r118 == false) goto L111;
                r113.encodeBooleanElement(r100, 11, r112.f348487l);
            L111:
                if (r113.shouldEncodeElementDefault(r100, 12) == false) goto L114;
            L115:
                boolean r119 = true;
            L117:
                if (r119 == false) goto L120;
                r113.encodeIntElement(r100, 12, r112.f348488m);
            L120:
                if (r113.shouldEncodeElementDefault(r100, 13) == false) goto L123;
            L124:
                boolean r120 = true;
            L126:
                if (r120 == false) goto L129;
                r113.encodeIntElement(r100, 13, r112.f348489n);
            L129:
                if (r113.shouldEncodeElementDefault(r100, 14) == false) goto L132;
            L133:
                r102 = true;
            L134:
                if (r102 == false) goto L136;
                r113.encodeIntElement(r100, 14, r112.f348490o);
            L136:
                r113.endStructure(r100);
                return;
            L132:
                if (r112.f348490o == 3) goto L134;
            L123:
                if (r112.f348489n != 30) goto L124;
                r120 = false;
                goto L126
            L114:
                if (r112.f348488m != 20) goto L115;
                r119 = false;
                goto L117
            L105:
                if (r112.f348487l != true) goto L106;
                r118 = false;
                goto L108
            L96:
                if (r112.f348486k != true) goto L97;
                r117 = false;
                goto L99
            L87:
                if (r112.f348485j != true) goto L88;
                r116 = false;
                goto L90
            L78:
                if (r112.f348484i != true) goto L79;
                r115 = false;
                goto L81
            L69:
                if (r112.f348483h != true) goto L70;
                r114 = false;
                goto L72
            L60:
                if (r112.f348482g != true) goto L61;
                r109 = false;
                goto L63
            L51:
                if (Double.compare(r112.f348481f, 10.0d) != 0) goto L52;
                r108 = false;
                goto L54
            L42:
                if (Double.compare(r112.f348480e, 10.0d) != 0) goto L43;
                r107 = false;
                goto L45
            L33:
                if (Double.compare(r112.f348479d, 2.0d) != 0) goto L34;
                r106 = false;
                goto L36
            L24:
                if (r112.f348478c != 10) goto L25;
                r105 = false;
                goto L27
            L15:
                if (Double.compare(r112.f348477b, 60.0d) != 0) goto L16;
                r104 = false;
                goto L18
            L6:
                if (Double.compare(r112.f348476a, 2.0d) != 0) goto L7;
                r103 = false;
                goto L9
            }
        }

        /* JADX INFO: renamed from: com.larus.im.internal.delegate.y0$b$b, reason: collision with other inner class name */
        public static final class C4357b {
            public C4357b() {
            }

            public final juc.d<b> serializer() {
                return a.f348491a;
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
            if (Double.compare(this.f348476a, r101.f348476a) == 0) goto L12;
            return false;
        L12:
            if (Double.compare(this.f348477b, r101.f348477b) == 0) goto L15;
            return false;
        L15:
            if (this.f348478c == r101.f348478c) goto L18;
            return false;
        L18:
            if (Double.compare(this.f348479d, r101.f348479d) == 0) goto L21;
            return false;
        L21:
            if (Double.compare(this.f348480e, r101.f348480e) == 0) goto L24;
            return false;
        L24:
            if (Double.compare(this.f348481f, r101.f348481f) == 0) goto L27;
            return false;
        L27:
            if (this.f348482g == r101.f348482g) goto L30;
            return false;
        L30:
            if (this.f348483h == r101.f348483h) goto L33;
            return false;
        L33:
            if (this.f348484i == r101.f348484i) goto L36;
            return false;
        L36:
            if (this.f348485j == r101.f348485j) goto L39;
            return false;
        L39:
            if (this.f348486k == r101.f348486k) goto L42;
            return false;
        L42:
            if (this.f348487l == r101.f348487l) goto L45;
            return false;
        L45:
            if (this.f348488m == r101.f348488m) goto L48;
            return false;
        L48:
            if (this.f348489n == r101.f348489n) goto L51;
            return false;
        L51:
            if (this.f348490o == r101.f348490o) goto L53;
            return false;
        L53:
            return true;
        }

        public final int hashCode() {
            long r100 = Double.doubleToLongBits(this.f348476a);
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = Double.doubleToLongBits(this.f348477b);
            int r103 = (((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f348478c) * 31;
            long r104 = Double.doubleToLongBits(this.f348479d);
            int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
            long r106 = Double.doubleToLongBits(this.f348480e);
            int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
            long r108 = Double.doubleToLongBits(this.f348481f);
            int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
            int r110 = 1231;
            if (this.f348482g == false) goto L5;
            int r111 = 1231;
        L6:
            int r112 = (r109 + r111) * 31;
            if (this.f348483h == false) goto L9;
            int r113 = 1231;
        L10:
            int r114 = (r112 + r113) * 31;
            if (this.f348484i == false) goto L13;
            int r115 = 1231;
        L14:
            int r116 = (r114 + r115) * 31;
            if (this.f348485j == false) goto L17;
            int r117 = 1231;
        L18:
            int r118 = (r116 + r117) * 31;
            if (this.f348486k == false) goto L21;
            int r119 = 1231;
        L22:
            int r120 = (r118 + r119) * 31;
            if (this.f348487l == true) goto L27;
            r110 = 1237;
        L27:
            return ((((((r120 + r110) * 31) + this.f348488m) * 31) + this.f348489n) * 31) + this.f348490o;
        L21:
            r119 = 1237;
            goto L22
        L17:
            r117 = 1237;
            goto L18
        L13:
            r115 = 1237;
            goto L14
        L9:
            r113 = 1237;
            goto L10
        L5:
            r111 = 1237;
            goto L6
        }

        public final String toString() {
            return "CommunicationConfig(sendActionConnectionTimeoutSec=" + this.f348476a + ", sendActionTimeoutSec=" + this.f348477b + ", sendActionRetryTime=" + this.f348478c + ", sendActionRetryIntervalSec=" + this.f348479d + ", receiverCompensationIntervalSec=" + this.f348480e + ", frozenCompensateRecentConvRequest=" + this.f348481f + ", thinkingDataCacheEnable=" + this.f348482g + ", messageListGetFix=" + this.f348483h + ", messageListIntervalRangeFix=" + this.f348484i + ", messageListFinalDataFix=" + this.f348485j + ", multiChainClearMemoryCache=" + this.f348486k + ", messageListNewProcessor=" + this.f348487l + ", singleChainFixBlankOnceLimit=" + this.f348488m + ", singleChainFixBlankRecursionTimes=" + this.f348489n + ", singleChainFixBlankNoNetRecursionTimes=" + this.f348490o + ')';
        }

        static {
            Companion = new C4357b();
        }

        public b(int r100) {
            this.f348476a = 2.0d;
            this.f348477b = 60.0d;
            this.f348478c = 10;
            this.f348479d = 2.0d;
            this.f348480e = 10.0d;
            this.f348481f = 10.0d;
            this.f348482g = true;
            this.f348483h = true;
            this.f348484i = true;
            this.f348485j = true;
            this.f348486k = true;
            this.f348487l = true;
            this.f348488m = 20;
            this.f348489n = 30;
            this.f348490o = 3;
        }

        public b(int r100, double r101, double r110, int r111, double r112, double r113, double r114, boolean r210, boolean r211, boolean r212, boolean r213, boolean r214, boolean r215, int r216, int r217, int r218) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348492b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            this.f348476a = 2.0d;
        L9:
            if ((r100 & 2) != 0) goto L11;
            double r102 = 60.0d;
        L12:
            this.f348477b = r102;
            if ((r100 & 4) != 0) goto L15;
            int r103 = 10;
        L16:
            this.f348478c = r103;
            if ((r100 & 8) != 0) goto L19;
            this.f348479d = 2.0d;
        L21:
            if ((r100 & 16) != 0) goto L23;
            this.f348480e = 10.0d;
        L25:
            if ((r100 & 32) != 0) goto L27;
            this.f348481f = 10.0d;
        L29:
            if ((r100 & 64) != 0) goto L31;
            this.f348482g = true;
        L33:
            if ((r100 & 128) != 0) goto L35;
            this.f348483h = true;
        L37:
            if ((r100 & 256) != 0) goto L39;
            this.f348484i = true;
        L41:
            if ((r100 & 512) != 0) goto L43;
            this.f348485j = true;
        L45:
            if ((r100 & 1024) != 0) goto L47;
            this.f348486k = true;
        L49:
            if ((r100 & 2048) != 0) goto L51;
            this.f348487l = true;
        L53:
            if ((r100 & 4096) != 0) goto L55;
            int r104 = 20;
        L56:
            this.f348488m = r104;
            if ((r100 & 8192) != 0) goto L59;
            int r105 = 30;
        L60:
            this.f348489n = r105;
            if ((r100 & 16384) != 0) goto L63;
            int r106 = 3;
        L64:
            this.f348490o = r106;
            return;
        L63:
            r106 = r218;
            goto L64
        L59:
            r105 = r217;
            goto L60
        L55:
            r104 = r216;
            goto L56
        L51:
            this.f348487l = r215;
            goto L53
        L47:
            this.f348486k = r214;
            goto L49
        L43:
            this.f348485j = r213;
            goto L45
        L39:
            this.f348484i = r212;
            goto L41
        L35:
            this.f348483h = r211;
            goto L37
        L31:
            this.f348482g = r210;
            goto L33
        L27:
            this.f348481f = r114;
            goto L29
        L23:
            this.f348480e = r113;
            goto L25
        L19:
            this.f348479d = r112;
            goto L21
        L15:
            r103 = r111;
            goto L16
        L11:
            r102 = r110;
            goto L12
        L7:
            this.f348476a = r101;
            goto L9
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    @Serializable
    public static final class c {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p f348493a;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<c> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348494a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348495b = null;

            public a() {
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                return new juc.d[]{kuc.a.d(p.a.f348594a)};
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348495b;
            }

            static {
                a r100 = new a();
                f348494a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowSettingsDelegate.ConsistencyConfig", r100, 1);
                r101.j("msg_config", true);
                f348495b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r100) {
                Intrinsics.checkNotNullParameter(r100, "decoder");
                g2 r101 = f348495b;
                muc.c r102 = r100.beginStructure(r101);
                int r103 = 1;
                p r104 = null;
                if (r102.decodeSequentially() == false) goto L5;
                p r105 = (p) r102.decodeNullableSerializableElement(r101, 0, p.a.f348594a, null);
            L15:
                r102.endStructure(r101);
                return new c(r103, r105);
            L5:
                int r106 = 0;
            L6:
                if (r103 == 0) goto L14;
                int r107 = r102.decodeElementIndex(r101);
                if (r107 != (-1)) goto L9;
                r103 = 0;
                goto L6
            L9:
                if (r107 != 0) goto L12;
                r104 = (p) r102.decodeNullableSerializableElement(r101, 0, p.a.f348594a, r104);
                r106 = r106 | 1;
                goto L6
            L12:
                throw new UnknownFieldException(r107);
            L14:
                r103 = r106;
                r105 = r104;
                goto L15
            }

            @Override // juc.n
            public final void serialize(muc.f r100, Object r101) {
                c r102 = (c) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                g2 r103 = f348495b;
                muc.d r104 = r100.beginStructure(r103);
                b r105 = c.Companion;
                if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
            L7:
                boolean r106 = true;
            L9:
                if (r106 == false) goto L11;
                r104.encodeNullableSerializableElement(r103, 0, p.a.f348594a, r102.f348493a);
            L11:
                r104.endStructure(r103);
                return;
            L6:
                if (Intrinsics.areEqual(r102.f348493a, new p(0)) == false) goto L7;
                r106 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<c> serializer() {
                return a.f348494a;
            }
        }

        public c() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f348493a, ((c) r100).f348493a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            p r100 = this.f348493a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "ConsistencyConfig(msgConfig=" + this.f348493a + ')';
        }

        static {
            Companion = new b();
        }

        public c(int r100) {
            this.f348493a = new p(0);
        }

        public c(int r100, p r101) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348495b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            this.f348493a = new p(0);
            return;
        L7:
            this.f348493a = r101;
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    @Serializable
    public static final class d {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f348496a;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<d> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348497a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348498b = null;

            public a() {
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                return new juc.d[]{nuc.g1.f520681a};
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348498b;
            }

            static {
                a r100 = new a();
                f348497a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowSettingsDelegate.CppCoreConfig", r100, 1);
                r101.j("release_delay", true);
                f348498b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r100) {
                Intrinsics.checkNotNullParameter(r100, "decoder");
                g2 r101 = f348498b;
                muc.c r102 = r100.beginStructure(r101);
                int r103 = 1;
                if (r102.decodeSequentially() == false) goto L5;
                long r104 = r102.decodeLongElement(r101, 0);
            L15:
                r102.endStructure(r101);
                return new d(r103, r104);
            L5:
                long r105 = 0;
                int r106 = 0;
            L6:
                if (r103 == 0) goto L14;
                int r107 = r102.decodeElementIndex(r101);
                if (r107 != (-1)) goto L9;
                r103 = 0;
                goto L6
            L9:
                if (r107 != 0) goto L12;
                r105 = r102.decodeLongElement(r101, 0);
                r106 = r106 | 1;
                goto L6
            L12:
                throw new UnknownFieldException(r107);
            L14:
                r103 = r106;
                r104 = r105;
                goto L15
            }

            @Override // juc.n
            public final void serialize(muc.f r100, Object r101) {
                d r102 = (d) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                g2 r103 = f348498b;
                muc.d r104 = r100.beginStructure(r103);
                b r105 = d.Companion;
                if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
            L7:
                boolean r106 = true;
            L9:
                if (r106 == false) goto L11;
                r104.encodeLongElement(r103, 0, r102.f348496a);
            L11:
                r104.endStructure(r103);
                return;
            L6:
                if (r102.f348496a != 30) goto L7;
                r106 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<d> serializer() {
                return a.f348497a;
            }
        }

        public d() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.f348496a == ((d) r100).f348496a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f348496a;
            return (int) (r100 ^ (r100 >>> 32));
        }

        public final String toString() {
            return "CppCoreConfig(releaseDelay=" + this.f348496a + ')';
        }

        static {
            Companion = new b();
        }

        public d(int r100) {
            this.f348496a = 30;
        }

        public d(int r100, long r101) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348498b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            this.f348496a = 30;
            return;
        L7:
            this.f348496a = r101;
        }
    }

    @Serializable
    public static final class e {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f348499a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f348500b;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<e> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348501a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348502b = null;

            public a() {
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                return new juc.d[]{nuc.l0.f520731a, nuc.g1.f520681a};
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348502b;
            }

            static {
                a r100 = new a();
                f348501a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowSettingsDelegate.DBIndexLimitConfig", r100, 2);
                r101.j("disk_db_size_factor", true);
                r101.j("disk_min_size", true);
                f348502b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r110) {
                Intrinsics.checkNotNullParameter(r110, "decoder");
                g2 r100 = f348502b;
                muc.c r111 = r110.beginStructure(r100);
                if (r111.decodeSequentially() == false) goto L5;
                float r101 = r111.decodeFloatElement(r100, 0);
                long r102 = r111.decodeLongElement(r100, 1);
                int r103 = 3;
            L17:
                r111.endStructure(r100);
                return new e(r103, r101, r102);
            L5:
                r101 = 0.0f;
                long r104 = 0;
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
                r101 = r111.decodeFloatElement(r100, 0);
                r105 = r105 | 1;
                goto L6
            L10:
                if (r107 != 1) goto L13;
                r104 = r111.decodeLongElement(r100, 1);
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
            public final void serialize(muc.f r100, Object r110) {
                e r111 = (e) r110;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r111, "value");
                g2 r101 = f348502b;
                muc.d r102 = r100.beginStructure(r101);
                b r103 = e.Companion;
                boolean r104 = false;
                if (r102.shouldEncodeElementDefault(r101, 0) == false) goto L6;
            L7:
                boolean r105 = true;
            L9:
                if (r105 == false) goto L12;
                r102.encodeFloatElement(r101, 0, r111.f348499a);
            L12:
                if (r102.shouldEncodeElementDefault(r101, 1) == false) goto L15;
            L16:
                r104 = true;
            L17:
                if (r104 == false) goto L19;
                r102.encodeLongElement(r101, 1, r111.f348500b);
            L19:
                r102.endStructure(r101);
                return;
            L15:
                if (r111.f348500b == com.larus.dora.impl.ota.g2.j0.G2_OTA_SPACE_CHECK_BYTES) goto L17;
            L6:
                if (Float.compare(r111.f348499a, 1.0f) != 0) goto L7;
                r105 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<e> serializer() {
                return a.f348501a;
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
            if (Float.compare(this.f348499a, r101.f348499a) == 0) goto L12;
            return false;
        L12:
            if (this.f348500b == r101.f348500b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = Float.floatToIntBits(this.f348499a) * 31;
            long r101 = this.f348500b;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "DBIndexLimitConfig(diskDBSizeFactor=" + this.f348499a + ", diskMinSize=" + this.f348500b + ')';
        }

        static {
            Companion = new b();
        }

        public e(int r100) {
            this.f348499a = 1.0f;
            this.f348500b = com.larus.dora.impl.ota.g2.j0.G2_OTA_SPACE_CHECK_BYTES;
        }

        public e(int r100, float r101, long r102) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348502b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            r101 = 1.0f;
        L7:
            this.f348499a = r101;
            if ((r100 & 2) != 0) goto L10;
            this.f348500b = com.larus.dora.impl.ota.g2.j0.G2_OTA_SPACE_CHECK_BYTES;
            return;
        L10:
            this.f348500b = r102;
        }
    }

    @Serializable
    public static final class f {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f348503a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f348504b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f348505c;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<f> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348506a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348507b = null;

            public a() {
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                nuc.g1 r100 = nuc.g1.f520681a;
                return new juc.d[]{nuc.i.f520705a, r100, r100};
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348507b;
            }

            static {
                a r100 = new a();
                f348506a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowSettingsDelegate.DBSizeMonitorConfig", r100, 3);
                r101.j("enable", true);
                r101.j("min_collect_interval", true);
                r101.j("next_collect_max_duration", true);
                f348507b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r210) {
                Intrinsics.checkNotNullParameter(r210, "decoder");
                g2 r100 = f348507b;
                muc.c r101 = r210.beginStructure(r100);
                if (r101.decodeSequentially() == false) goto L5;
                boolean r102 = r101.decodeBooleanElement(r100, 0);
                boolean r110 = r102;
                long r111 = r101.decodeLongElement(r100, 1);
                long r112 = r101.decodeLongElement(r100, 2);
                int r113 = 7;
            L19:
                r101.endStructure(r100);
                return new f(r113, r110, r111, r112);
            L5:
                long r103 = 0;
                boolean r104 = false;
                boolean r114 = true;
                long r105 = 0;
                int r106 = 0;
            L6:
                if (r114 == false) goto L18;
                int r115 = r101.decodeElementIndex(r100);
                if (r115 != (-1)) goto L9;
                r114 = false;
                goto L6
            L9:
                if (r115 != 0) goto L10;
                r104 = r101.decodeBooleanElement(r100, 0);
                r106 = r106 | 1;
                goto L6
            L10:
                if (r115 != 1) goto L11;
                r105 = r101.decodeLongElement(r100, 1);
                r106 = r106 | 2;
                goto L6
            L11:
                if (r115 != 2) goto L14;
                r103 = r101.decodeLongElement(r100, 2);
                r106 = r106 | 4;
                goto L6
            L14:
                throw new UnknownFieldException(r115);
            L18:
                r110 = r104;
                r113 = r106;
                r111 = r105;
                r112 = r103;
                goto L19
            }

            @Override // juc.n
            public final void serialize(muc.f r110, Object r111) {
                f r112 = (f) r111;
                Intrinsics.checkNotNullParameter(r110, "encoder");
                Intrinsics.checkNotNullParameter(r112, "value");
                g2 r100 = f348507b;
                muc.d r113 = r110.beginStructure(r100);
                b r101 = f.Companion;
                boolean r102 = false;
                if (r113.shouldEncodeElementDefault(r100, 0) == false) goto L6;
            L7:
                boolean r103 = true;
            L9:
                if (r103 == false) goto L12;
                r113.encodeBooleanElement(r100, 0, r112.f348503a);
            L12:
                if (r113.shouldEncodeElementDefault(r100, 1) == false) goto L15;
            L16:
                boolean r104 = true;
            L18:
                if (r104 == false) goto L21;
                r113.encodeLongElement(r100, 1, r112.f348504b);
            L21:
                if (r113.shouldEncodeElementDefault(r100, 2) == false) goto L24;
            L25:
                r102 = true;
            L26:
                if (r102 == false) goto L28;
                r113.encodeLongElement(r100, 2, r112.f348505c);
            L28:
                r113.endStructure(r100);
                return;
            L24:
                if (r112.f348505c == 5000) goto L26;
            L15:
                if (r112.f348504b != 604800000) goto L16;
                r104 = false;
                goto L18
            L6:
                if (r112.f348503a != true) goto L7;
                r103 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<f> serializer() {
                return a.f348506a;
            }
        }

        public f() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L8;
            return false;
        L8:
            f r101 = (f) r100;
            if (this.f348503a == r101.f348503a) goto L12;
            return false;
        L12:
            if (this.f348504b == r101.f348504b) goto L15;
            return false;
        L15:
            if (this.f348505c == r101.f348505c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.f348503a == false) goto L5;
            int r100 = 1231;
        L6:
            long r101 = this.f348504b;
            int r102 = ((r100 * 31) + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            long r103 = this.f348505c;
            return r102 + ((int) (r103 ^ (r103 >>> 32)));
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "DBSizeMonitorConfig(enable=" + this.f348503a + ", minCollectInterval=" + this.f348504b + ", nextCollectMaxDuration=" + this.f348505c + ')';
        }

        static {
            Companion = new b();
        }

        public f(int r100) {
            this.f348503a = true;
            this.f348504b = 604800000;
            this.f348505c = 5000;
        }

        public f(int r100, boolean r101, long r102, long r103) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348507b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            r101 = true;
        L7:
            this.f348503a = r101;
            if ((r100 & 2) != 0) goto L10;
            this.f348504b = 604800000;
        L12:
            if ((r100 & 4) != 0) goto L14;
            this.f348505c = 5000;
            return;
        L14:
            this.f348505c = r103;
            return;
        L10:
            this.f348504b = r102;
            goto L12
        }
    }

    @Serializable
    public static final class g {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f348508a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f348509b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f348510c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f348511d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f348512e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final f f348513f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final h f348514g;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<g> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348515a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348516b = null;

            public a() {
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                nuc.g1 r100 = nuc.g1.f520681a;
                return new juc.d[]{nuc.i.f520705a, r100, r100, r100, r100, kuc.a.d(f.a.f348506a), kuc.a.d(h.a.f348522a)};
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348516b;
            }

            static {
                a r100 = new a();
                f348515a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowSettingsDelegate.DBSlowTaskConfig", r100, 7);
                r101.j("enable", true);
                r101.j("min_delay_duration", true);
                r101.j("min_idle_duration", true);
                r101.j("max_monitor_count", true);
                r101.j("max_task_duration", true);
                r101.j("db_size_monitor", true);
                r101.j("table_index", true);
                f348516b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r210) {
                Intrinsics.checkNotNullParameter(r210, "decoder");
                g2 r100 = f348516b;
                muc.c r101 = r210.beginStructure(r100);
                if (r101.decodeSequentially() == false) goto L5;
                boolean r102 = r101.decodeBooleanElement(r100, 0);
                long r103 = r101.decodeLongElement(r100, 1);
                long r110 = r101.decodeLongElement(r100, 2);
                long r111 = r101.decodeLongElement(r100, 3);
                long r104 = r101.decodeLongElement(r100, 4);
                f r105 = (f) r101.decodeNullableSerializableElement(r100, 5, f.a.f348506a, null);
                long r112 = r104;
                long r106 = r103;
                h r113 = (h) r101.decodeNullableSerializableElement(r100, 6, h.a.f348522a, null);
                f r114 = r105;
                int r107 = 127;
                boolean r108 = r102;
            L22:
                r101.endStructure(r100);
                return new g(r107, r108, r106, r110, r111, r112, r114, r113);
            L5:
                long r115 = 0;
                f r109 = null;
                h r116 = null;
                long r117 = 0;
                long r118 = 0;
                long r119 = 0;
                boolean r120 = false;
                int r121 = 0;
                boolean r211 = true;
            L6:
                if (r211 == false) goto L21;
                int r122 = r101.decodeElementIndex(r100);
                switch(r122) {
                    case -1: goto L19;
                    case 0: goto L18;
                    case 1: goto L17;
                    case 2: goto L15;
                    case 3: goto L14;
                    case 4: goto L13;
                    case 5: goto L12;
                    case 6: goto L11;
                    default: goto L10;
                };
            L10:
                throw new UnknownFieldException(r122);
            L17:
                r117 = r101.decodeLongElement(r100, 1);
                r121 = r121 | 2;
                goto L6
            L18:
                r121 = r121 | 1;
                r120 = r101.decodeBooleanElement(r100, 0);
                goto L6
            L11:
                r116 = (h) r101.decodeNullableSerializableElement(r100, 6, h.a.f348522a, r116);
                int r123 = r121 | 64;
            L16:
                r121 = r123;
                boolean r212 = r211;
            L20:
                r211 = r212;
                goto L6
            L12:
                r109 = (f) r101.decodeNullableSerializableElement(r100, 5, f.a.f348506a, r109);
                r123 = r121 | 32;
                goto L16
            L13:
                r115 = r101.decodeLongElement(r100, 4);
                r123 = r121 | 16;
                goto L16
            L14:
                r119 = r101.decodeLongElement(r100, 3);
                r123 = r121 | 8;
                goto L16
            L15:
                r118 = r101.decodeLongElement(r100, 2);
                r123 = r121 | 4;
                goto L16
            L19:
                r212 = false;
                goto L20
            L21:
                r108 = r120;
                r107 = r121;
                r106 = r117;
                r111 = r119;
                r113 = r116;
                r114 = r109;
                r112 = r115;
                r110 = r118;
                goto L22
            }

            @Override // juc.n
            public final void serialize(muc.f r110, Object r111) {
                g r112 = (g) r111;
                Intrinsics.checkNotNullParameter(r110, "encoder");
                Intrinsics.checkNotNullParameter(r112, "value");
                g2 r100 = f348516b;
                muc.d r113 = r110.beginStructure(r100);
                b r101 = g.Companion;
                boolean r102 = false;
                if (r113.shouldEncodeElementDefault(r100, 0) == false) goto L6;
            L7:
                boolean r103 = true;
            L9:
                if (r103 == false) goto L12;
                r113.encodeBooleanElement(r100, 0, r112.f348508a);
            L12:
                if (r113.shouldEncodeElementDefault(r100, 1) == false) goto L15;
            L16:
                boolean r104 = true;
            L18:
                if (r104 == false) goto L21;
                r113.encodeLongElement(r100, 1, r112.f348509b);
            L21:
                if (r113.shouldEncodeElementDefault(r100, 2) == false) goto L24;
            L25:
                boolean r105 = true;
            L27:
                if (r105 == false) goto L30;
                r113.encodeLongElement(r100, 2, r112.f348510c);
            L30:
                if (r113.shouldEncodeElementDefault(r100, 3) == false) goto L33;
            L34:
                boolean r106 = true;
            L36:
                if (r106 == false) goto L39;
                r113.encodeLongElement(r100, 3, r112.f348511d);
            L39:
                if (r113.shouldEncodeElementDefault(r100, 4) == false) goto L42;
            L43:
                boolean r107 = true;
            L45:
                if (r107 == false) goto L48;
                r113.encodeLongElement(r100, 4, r112.f348512e);
            L48:
                if (r113.shouldEncodeElementDefault(r100, 5) == false) goto L51;
            L52:
                boolean r108 = true;
            L54:
                if (r108 == false) goto L57;
                r113.encodeNullableSerializableElement(r100, 5, f.a.f348506a, r112.f348513f);
            L57:
                if (r113.shouldEncodeElementDefault(r100, 6) == false) goto L60;
            L61:
                r102 = true;
            L62:
                if (r102 == false) goto L64;
                r113.encodeNullableSerializableElement(r100, 6, h.a.f348522a, r112.f348514g);
            L64:
                r113.endStructure(r100);
                return;
            L60:
                if (Intrinsics.areEqual(r112.f348514g, new h(null)) == true) goto L62;
            L51:
                if (Intrinsics.areEqual(r112.f348513f, new f(0)) == false) goto L52;
                r108 = false;
                goto L54
            L42:
                if (r112.f348512e != 5000) goto L43;
                r107 = false;
                goto L45
            L33:
                if (r112.f348511d != 500) goto L34;
                r106 = false;
                goto L36
            L24:
                if (r112.f348510c != 3000) goto L25;
                r105 = false;
                goto L27
            L15:
                if (r112.f348509b != 30000) goto L16;
                r104 = false;
                goto L18
            L6:
                if (r112.f348508a != true) goto L7;
                r103 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<g> serializer() {
                return a.f348515a;
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
            if (this.f348508a == r101.f348508a) goto L12;
            return false;
        L12:
            if (this.f348509b == r101.f348509b) goto L15;
            return false;
        L15:
            if (this.f348510c == r101.f348510c) goto L18;
            return false;
        L18:
            if (this.f348511d == r101.f348511d) goto L21;
            return false;
        L21:
            if (this.f348512e == r101.f348512e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f348513f, r101.f348513f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f348514g, r101.f348514g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            if (this.f348508a == false) goto L5;
            int r100 = 1231;
        L6:
            long r101 = this.f348509b;
            int r102 = ((r100 * 31) + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            long r103 = this.f348510c;
            int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
            long r105 = this.f348511d;
            int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
            long r107 = this.f348512e;
            int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
            f r109 = this.f348513f;
            int r110 = 0;
            if (r109 != null) goto L9;
            int r111 = 0;
        L10:
            int r112 = (r108 + r111) * 31;
            h r113 = this.f348514g;
            if (r113 == null) goto L15;
            r110 = r113.hashCode();
        L15:
            return r112 + r110;
        L9:
            r111 = r109.hashCode();
            goto L10
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "DBSlowTaskConfig(enable=" + this.f348508a + ", minDelayDuration=" + this.f348509b + ", minIdleDuration=" + this.f348510c + ", maxMonitorCount=" + this.f348511d + ", maxTaskDuration=" + this.f348512e + ", sizeMonitorConfig=" + this.f348513f + ", tableIndexConfig=" + this.f348514g + ')';
        }

        static {
            Companion = new b();
        }

        public g(int r100) {
            f r101 = new f(0);
            h r102 = new h(null);
            this.f348508a = true;
            this.f348509b = 30000;
            this.f348510c = 3000;
            this.f348511d = 500;
            this.f348512e = 5000;
            this.f348513f = r101;
            this.f348514g = r102;
        }

        public g(int r100, boolean r101, long r102, long r103, long r110, long r111, f r112, h r113) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348516b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            r101 = true;
        L7:
            this.f348508a = r101;
            if ((r100 & 2) != 0) goto L10;
            this.f348509b = 30000;
        L12:
            if ((r100 & 4) != 0) goto L14;
            this.f348510c = 3000;
        L16:
            if ((r100 & 8) != 0) goto L18;
            this.f348511d = 500;
        L20:
            if ((r100 & 16) != 0) goto L22;
            this.f348512e = 5000;
        L24:
            if ((r100 & 32) != 0) goto L26;
            this.f348513f = new f(0);
        L28:
            if ((r100 & 64) != 0) goto L30;
            this.f348514g = new h(null);
            return;
        L30:
            this.f348514g = r113;
            return;
        L26:
            this.f348513f = r112;
            goto L28
        L22:
            this.f348512e = r111;
            goto L24
        L18:
            this.f348511d = r110;
            goto L20
        L14:
            this.f348510c = r103;
            goto L16
        L10:
            this.f348509b = r102;
            goto L12
        }
    }

    @Serializable
    public static final class h {
        public static final b Companion = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Lazy<juc.d<Object>>[] f348517e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f348518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e f348519b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f348520c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
        private final List<i> f348521d;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<h> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348522a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348523b = null;

            public a() {
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348523b;
            }

            static {
                a r100 = new a();
                f348522a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowSettingsDelegate.DBTableIndexConfig", r100, 4);
                r101.j("enable", true);
                r101.j(VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, true);
                r101.j("max_task_duration", true);
                r101.j("indices", true);
                f348523b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                return new juc.d[]{nuc.i.f520705a, kuc.a.d(e.a.f348501a), nuc.g1.f520681a, kuc.a.d(h.f348517e[3].getValue())};
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r210) {
                Intrinsics.checkNotNullParameter(r210, "decoder");
                g2 r100 = f348523b;
                muc.c r101 = r210.beginStructure(r100);
                Lazy<juc.d<Object>>[] r102 = h.f348517e;
                if (r101.decodeSequentially() == false) goto L5;
                boolean r103 = r101.decodeBooleanElement(r100, 0);
                e r104 = (e) r101.decodeNullableSerializableElement(r100, 1, e.a.f348501a, null);
                long r105 = r101.decodeLongElement(r100, 2);
                List r211 = (List) r101.decodeNullableSerializableElement(r100, 3, r102[3].getValue(), null);
                boolean r110 = r103;
                e r111 = r104;
                long r112 = r105;
                int r113 = 15;
            L21:
                r101.endStructure(r100);
                return new h(r113, r110, r111, r112, r211);
            L5:
                long r114 = 0;
                boolean r106 = false;
                boolean r115 = true;
                e r107 = null;
                List r116 = null;
                int r108 = 0;
            L6:
                if (r115 == false) goto L20;
                int r117 = r101.decodeElementIndex(r100);
                if (r117 != (-1)) goto L9;
                r115 = false;
                goto L6
            L9:
                if (r117 != 0) goto L10;
                r106 = r101.decodeBooleanElement(r100, 0);
                r108 = r108 | 1;
                goto L6
            L10:
                if (r117 != 1) goto L11;
                r107 = (e) r101.decodeNullableSerializableElement(r100, 1, e.a.f348501a, r107);
                r108 = r108 | 2;
                goto L6
            L11:
                if (r117 != 2) goto L12;
                r114 = r101.decodeLongElement(r100, 2);
                r108 = r108 | 4;
                goto L6
            L12:
                if (r117 != 3) goto L15;
                r116 = (List) r101.decodeNullableSerializableElement(r100, 3, r102[3].getValue(), r116);
                r108 = r108 | 8;
                goto L6
            L15:
                throw new UnknownFieldException(r117);
            L20:
                r110 = r106;
                r113 = r108;
                r111 = r107;
                r211 = r116;
                r112 = r114;
                goto L21
            }

            @Override // juc.n
            public final void serialize(muc.f r100, Object r101) {
                h r102 = (h) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                g2 r103 = f348523b;
                muc.d r104 = r100.beginStructure(r103);
                h.b(r102, r104, r103);
                r104.endStructure(r103);
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<h> serializer() {
                return a.f348522a;
            }
        }

        public h() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L8;
            return false;
        L8:
            h r101 = (h) r100;
            if (this.f348518a == r101.f348518a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f348519b, r101.f348519b) == true) goto L15;
            return false;
        L15:
            if (this.f348520c == r101.f348520c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f348521d, r101.f348521d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            if (this.f348518a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            e r102 = this.f348519b;
            int r103 = 0;
            if (r102 != null) goto L9;
            int r104 = 0;
        L10:
            long r105 = this.f348520c;
            int r106 = (((r101 + r104) * 31) + ((int) (r105 ^ (r105 >>> 32)))) * 31;
            List<i> r107 = this.f348521d;
            if (r107 == null) goto L15;
            r103 = r107.hashCode();
        L15:
            return r106 + r103;
        L9:
            r104 = r102.hashCode();
            goto L10
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "DBTableIndexConfig(enable=" + this.f348518a + ", limit=" + this.f348519b + ", maxTaskDuration=" + this.f348520c + ", indices=" + this.f348521d + ')';
        }

        static {
            Companion = new b();
            f348517e = new Lazy[]{null, null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new z0())};
        }

        public final List<i> a() {
            return this.f348521d;
        }

        public h(Object r100) {
            e r101 = new e(0);
            ArrayList r102 = new ArrayList();
            this.f348518a = false;
            this.f348519b = r101;
            this.f348520c = 5000;
            this.f348521d = r102;
        }

        @JvmStatic
        public static final /* synthetic */ void b(h r100, muc.d r110, g2 r111) {
            Lazy<juc.d<Object>>[] r101 = f348517e;
            boolean r102 = false;
            if (r110.shouldEncodeElementDefault(r111, 0) == false) goto L6;
        L7:
            boolean r103 = true;
        L9:
            if (r103 == false) goto L12;
            r110.encodeBooleanElement(r111, 0, r100.f348518a);
        L12:
            if (r110.shouldEncodeElementDefault(r111, 1) == false) goto L15;
        L16:
            boolean r104 = true;
        L18:
            if (r104 == false) goto L21;
            r110.encodeNullableSerializableElement(r111, 1, e.a.f348501a, r100.f348519b);
        L21:
            if (r110.shouldEncodeElementDefault(r111, 2) == false) goto L24;
        L25:
            boolean r105 = true;
        L27:
            if (r105 == false) goto L30;
            r110.encodeLongElement(r111, 2, r100.f348520c);
        L30:
            if (r110.shouldEncodeElementDefault(r111, 3) == false) goto L33;
        L34:
            r102 = true;
        L35:
            if (r102 == false) goto L38;
            r110.encodeNullableSerializableElement(r111, 3, r101[3].getValue(), r100.f348521d);
            return;
        L38:
            return;
        L33:
            if (Intrinsics.areEqual(r100.f348521d, new ArrayList()) == true) goto L35;
        L24:
            if (r100.f348520c != 5000) goto L25;
            r105 = false;
            goto L27
        L15:
            if (Intrinsics.areEqual(r100.f348519b, new e(0)) == false) goto L16;
            r104 = false;
            goto L18
        L6:
            if (r100.f348518a == true) goto L7;
            r103 = false;
            goto L9
        }

        public h(int r100, boolean r101, e r102, long r103, List r104) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348523b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            this.f348518a = false;
        L9:
            if ((r100 & 2) != 0) goto L11;
            this.f348519b = new e(0);
        L13:
            if ((r100 & 4) != 0) goto L15;
            this.f348520c = 5000;
        L17:
            if ((r100 & 8) != 0) goto L19;
            this.f348521d = new ArrayList();
            return;
        L19:
            this.f348521d = r104;
            return;
        L15:
            this.f348520c = r103;
            goto L17
        L11:
            this.f348519b = r102;
            goto L13
        L7:
            this.f348518a = r101;
            goto L9
        }
    }

    @Serializable
    public static final class i {
        public static final b Companion = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<juc.d<Object>>[] f348524c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f348525a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
        private final List<j> f348526b;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<i> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348527a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348528b = null;

            public a() {
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348528b;
            }

            static {
                a r100 = new a();
                f348527a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowSettingsDelegate.DBTableTableIndexConfig", r100, 2);
                r101.j("table_name", true);
                r101.j("table_indices", true);
                f348528b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                return new juc.d[]{kuc.a.d(v2.f520790a), kuc.a.d(i.f348524c[1].getValue())};
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r110) {
                Intrinsics.checkNotNullParameter(r110, "decoder");
                g2 r100 = f348528b;
                muc.c r111 = r110.beginStructure(r100);
                Lazy<juc.d<Object>>[] r101 = i.f348524c;
                List r102 = null;
                if (r111.decodeSequentially() == false) goto L5;
                String r103 = (String) r111.decodeNullableSerializableElement(r100, 0, v2.f520790a, null);
                List r104 = (List) r111.decodeNullableSerializableElement(r100, 1, r101[1].getValue(), null);
                int r105 = 3;
            L17:
                r111.endStructure(r100);
                return new i(r105, r103, r104);
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
                r106 = (String) r111.decodeNullableSerializableElement(r100, 0, v2.f520790a, r106);
                r107 = r107 | 1;
                goto L6
            L10:
                if (r109 != 1) goto L13;
                r102 = (List) r111.decodeNullableSerializableElement(r100, 1, r101[1].getValue(), r102);
                r107 = r107 | 2;
                goto L6
            L13:
                throw new UnknownFieldException(r109);
            L16:
                r105 = r107;
                r104 = r102;
                r103 = r106;
                goto L17
            }

            @Override // juc.n
            public final void serialize(muc.f r100, Object r101) {
                i r102 = (i) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                g2 r103 = f348528b;
                muc.d r104 = r100.beginStructure(r103);
                i.b(r102, r104, r103);
                r104.endStructure(r103);
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<i> serializer() {
                return a.f348527a;
            }
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof i) == true) goto L8;
            return false;
        L8:
            i r101 = (i) r100;
            if (Intrinsics.areEqual(this.f348525a, r101.f348525a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f348526b, r101.f348526b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f348525a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            List<j> r104 = this.f348526b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "DBTableTableIndexConfig(tableName=" + this.f348525a + ", tableIndexItemConfigs=" + this.f348526b + ')';
        }

        static {
            Companion = new b();
            f348524c = new Lazy[]{null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new a1())};
        }

        public i() {
            ArrayList r100 = new ArrayList();
            this.f348525a = "";
            this.f348526b = r100;
        }

        public final List<j> a() {
            return this.f348526b;
        }

        public i(int r100, String r101, List r102) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348528b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            r101 = "";
        L7:
            this.f348525a = r101;
            if ((r100 & 2) != 0) goto L10;
            this.f348526b = new ArrayList();
            return;
        L10:
            this.f348526b = r102;
        }

        @JvmStatic
        public static final /* synthetic */ void b(i r100, muc.d r101, g2 r102) {
            Lazy<juc.d<Object>>[] r103 = f348524c;
            boolean r104 = false;
            if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
        L7:
            boolean r105 = true;
        L9:
            if (r105 == false) goto L12;
            r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.f348525a);
        L12:
            if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
        L16:
            r104 = true;
        L17:
            if (r104 == false) goto L20;
            r101.encodeNullableSerializableElement(r102, 1, r103[1].getValue(), r100.f348526b);
            return;
        L20:
            return;
        L15:
            if (Intrinsics.areEqual(r100.f348526b, new ArrayList()) == true) goto L17;
        L6:
            if (Intrinsics.areEqual(r100.f348525a, "") == false) goto L7;
            r105 = false;
            goto L9
        }
    }

    @Serializable
    public static final class j {
        public static final b Companion = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Lazy<juc.d<Object>>[] f348529d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f348530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f348531b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
        private final List<String> f348532c;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<j> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348533a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348534b = null;

            public a() {
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348534b;
            }

            static {
                a r100 = new a();
                f348533a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowSettingsDelegate.DBTableTableIndexItemConfig", r100, 3);
                r101.j("enable", true);
                r101.j("index_name", true);
                r101.j("field_array", true);
                f348534b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                return new juc.d[]{nuc.i.f520705a, kuc.a.d(v2.f520790a), kuc.a.d(j.f348529d[2].getValue())};
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r110) {
                Intrinsics.checkNotNullParameter(r110, "decoder");
                g2 r100 = f348534b;
                muc.c r111 = r110.beginStructure(r100);
                Lazy<juc.d<Object>>[] r101 = j.f348529d;
                if (r111.decodeSequentially() == false) goto L5;
                boolean r102 = r111.decodeBooleanElement(r100, 0);
                String r103 = (String) r111.decodeNullableSerializableElement(r100, 1, v2.f520790a, null);
                List r104 = (List) r111.decodeNullableSerializableElement(r100, 2, r101[2].getValue(), null);
                int r105 = 7;
            L19:
                r111.endStructure(r100);
                return new j(r105, r102, r103, r104);
            L5:
                String r106 = null;
                List r107 = null;
                r102 = false;
                int r108 = 0;
                boolean r109 = true;
            L6:
                if (r109 == false) goto L18;
                int r112 = r111.decodeElementIndex(r100);
                if (r112 != (-1)) goto L9;
                r109 = false;
                goto L6
            L9:
                if (r112 != 0) goto L10;
                r102 = r111.decodeBooleanElement(r100, 0);
                r108 = r108 | 1;
                goto L6
            L10:
                if (r112 != 1) goto L11;
                r106 = (String) r111.decodeNullableSerializableElement(r100, 1, v2.f520790a, r106);
                r108 = r108 | 2;
                goto L6
            L11:
                if (r112 != 2) goto L14;
                r107 = (List) r111.decodeNullableSerializableElement(r100, 2, r101[2].getValue(), r107);
                r108 = r108 | 4;
                goto L6
            L14:
                throw new UnknownFieldException(r112);
            L18:
                r105 = r108;
                r103 = r106;
                r104 = r107;
                goto L19
            }

            @Override // juc.n
            public final void serialize(muc.f r100, Object r101) {
                j r102 = (j) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                g2 r103 = f348534b;
                muc.d r104 = r100.beginStructure(r103);
                j.b(r102, r104, r103);
                r104.endStructure(r103);
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<j> serializer() {
                return a.f348533a;
            }
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof j) == true) goto L8;
            return false;
        L8:
            j r101 = (j) r100;
            if (this.f348530a == r101.f348530a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f348531b, r101.f348531b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f348532c, r101.f348532c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.f348530a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            String r102 = this.f348531b;
            int r103 = 0;
            if (r102 != null) goto L9;
            int r104 = 0;
        L10:
            int r105 = (r101 + r104) * 31;
            List<String> r106 = this.f348532c;
            if (r106 == null) goto L15;
            r103 = r106.hashCode();
        L15:
            return r105 + r103;
        L9:
            r104 = r102.hashCode();
            goto L10
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "DBTableTableIndexItemConfig(enable=" + this.f348530a + ", indexName=" + this.f348531b + ", fieldArray=" + this.f348532c + ')';
        }

        static {
            Companion = new b();
            f348529d = new Lazy[]{null, null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new b1())};
        }

        public j() {
            ArrayList r100 = new ArrayList();
            this.f348530a = false;
            this.f348531b = "";
            this.f348532c = r100;
        }

        public final List<String> a() {
            return this.f348532c;
        }

        @JvmStatic
        public static final /* synthetic */ void b(j r100, muc.d r101, g2 r102) {
            Lazy<juc.d<Object>>[] r103 = f348529d;
            boolean r104 = false;
            if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
        L7:
            boolean r105 = true;
        L9:
            if (r105 == false) goto L12;
            r101.encodeBooleanElement(r102, 0, r100.f348530a);
        L12:
            if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
        L16:
            boolean r106 = true;
        L18:
            if (r106 == false) goto L21;
            r101.encodeNullableSerializableElement(r102, 1, v2.f520790a, r100.f348531b);
        L21:
            if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
        L25:
            r104 = true;
        L26:
            if (r104 == false) goto L29;
            r101.encodeNullableSerializableElement(r102, 2, r103[2].getValue(), r100.f348532c);
            return;
        L29:
            return;
        L24:
            if (Intrinsics.areEqual(r100.f348532c, new ArrayList()) == true) goto L26;
        L15:
            if (Intrinsics.areEqual(r100.f348531b, "") == false) goto L16;
            r106 = false;
            goto L18
        L6:
            if (r100.f348530a == true) goto L7;
            r105 = false;
            goto L9
        }

        public j(int r100, boolean r101, String r102, List r103) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348534b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            this.f348530a = false;
        L9:
            if ((r100 & 2) != 0) goto L11;
            this.f348531b = "";
        L13:
            if ((r100 & 4) != 0) goto L15;
            this.f348532c = new ArrayList();
            return;
        L15:
            this.f348532c = r103;
            return;
        L11:
            this.f348531b = r102;
            goto L13
        L7:
            this.f348530a = r101;
            goto L9
        }
    }

    @Serializable
    public static final class k {
        public static final b Companion = null;
        public final boolean A;
        public final boolean B;
        public final boolean C;
        public final boolean D;
        public final boolean E;
        public final boolean F;
        public final boolean G;
        public final boolean H;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f348535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f348536b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f348537c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f348538d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f348539e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f348540f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f348541g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f348542h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f348543i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f348544j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f348545k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f348546l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final boolean f348547m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final boolean f348548n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final boolean f348549o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final boolean f348550p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final boolean f348551q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final boolean f348552r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final boolean f348553s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final boolean f348554t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final boolean f348555u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final boolean f348556v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public final boolean f348557w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public final boolean f348558x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public final int f348559y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public final boolean f348560z;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<k> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348561a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348562b = null;

            public a() {
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348562b;
            }

            static {
                a r100 = new a();
                f348561a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowSettingsDelegate.FixConfig", r100, 34);
                r101.j("use_new_interrupt_check", true);
                r101.j("fix_enter_foreground_fill_streaming_message", true);
                r101.j("fix_local_msg_skip", true);
                r101.j("fix_stop_chunk_failed", true);
                r101.j("fix_pull_streaming_message", true);
                r101.j("fix_db_wal", true);
                r101.j("fix_single_chain_first_page_content_empty", true);
                r101.j("fix_db_long_time_error", true);
                r101.j("fix_sub_list_error", true);
                r101.j("fix_list_order_error", true);
                r101.j("fix_invalid_loading_error", true);
                r101.j("fix_clear_history_error", true);
                r101.j("fix_cmd_replace", true);
                r101.j("fix_search_filter_cursor", true);
                r101.j("search_filter_conversation", true);
                r101.j("fix_get_main_cvs", true);
                r101.j("fix_mock_main_cvs", true);
                r101.j("filter_null_content_msg", true);
                r101.j("fix_cmd_bugs", true);
                r101.j("fix_long_cmd_loss", true);
                r101.j("fix_feedback_bugs", true);
                r101.j("fix_replace_local", true);
                r101.j("fix_call_replace_failed", true);
                r101.j("fix_chunk_read_line_loop", true);
                r101.j("net_package_length", true);
                r101.j("first_return_local_bot_id", true);
                r101.j("fix_replace_new_local", true);
                r101.j("last_cancel_typing", true);
                r101.j("use_new_main_bot_local_cvs_id", true);
                r101.j("release_asr_on_prepare_message", true);
                r101.j("offline_conversation_in_out", true);
                r101.j("new_omni_scope", true);
                r101.j("replace_invalid_scope", true);
                r101.j("flush_stream_on_typing_error", true);
                f348562b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                nuc.i r100 = nuc.i.f520705a;
                nuc.w0 r101 = nuc.w0.f520792a;
                return new juc.d[]{r100, r101, r101, r101, r101, r101, r101, r101, r101, r101, r101, r101, r100, r100, r100, r100, r100, r100, r100, r100, r100, r100, r100, r100, r101, r100, r100, r100, r100, r100, r100, r100, r100, r100};
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r710) {
                Intrinsics.checkNotNullParameter(r710, "decoder");
                g2 r100 = f348562b;
                muc.c r101 = r710.beginStructure(r100);
                int r110 = 0;
                int r102 = 6;
                if (r101.decodeSequentially() == false) goto L5;
                boolean r103 = r101.decodeBooleanElement(r100, 0);
                int r111 = r101.decodeIntElement(r100, 1);
                int r104 = r101.decodeIntElement(r100, 2);
                int r112 = r101.decodeIntElement(r100, 3);
                int r105 = r101.decodeIntElement(r100, 4);
                int r106 = r101.decodeIntElement(r100, 5);
                int r107 = r101.decodeIntElement(r100, 6);
                int r113 = r101.decodeIntElement(r100, 7);
                int r108 = r101.decodeIntElement(r100, 8);
                int r114 = r101.decodeIntElement(r100, 9);
                int r109 = r101.decodeIntElement(r100, 10);
                int r115 = r101.decodeIntElement(r100, 11);
                boolean r116 = r101.decodeBooleanElement(r100, 12);
                boolean r117 = r101.decodeBooleanElement(r100, 13);
                boolean r118 = r101.decodeBooleanElement(r100, 14);
                boolean r119 = r101.decodeBooleanElement(r100, 15);
                boolean r120 = r101.decodeBooleanElement(r100, 16);
                boolean r121 = r101.decodeBooleanElement(r100, 17);
                boolean r122 = r101.decodeBooleanElement(r100, 18);
                boolean r123 = r101.decodeBooleanElement(r100, 19);
                boolean r124 = r101.decodeBooleanElement(r100, 20);
                boolean r125 = r101.decodeBooleanElement(r100, 21);
                boolean r126 = r101.decodeBooleanElement(r100, 22);
                boolean r127 = r101.decodeBooleanElement(r100, 23);
                int r128 = r101.decodeIntElement(r100, 24);
                boolean r129 = r101.decodeBooleanElement(r100, 25);
                boolean r130 = r101.decodeBooleanElement(r100, 26);
                boolean r131 = r101.decodeBooleanElement(r100, 27);
                boolean r132 = r101.decodeBooleanElement(r100, 28);
                boolean r133 = r101.decodeBooleanElement(r100, 29);
                boolean r134 = r101.decodeBooleanElement(r100, 30);
                boolean r135 = r101.decodeBooleanElement(r100, 31);
                boolean r136 = r101.decodeBooleanElement(r100, 32);
                boolean r410 = r131;
                boolean r411 = r101.decodeBooleanElement(r100, 33);
                boolean r412 = r130;
                boolean r413 = r136;
                boolean r310 = r129;
                int r311 = r128;
                boolean r312 = r127;
                boolean r313 = r126;
                boolean r314 = r121;
                boolean r414 = r132;
                boolean r415 = r133;
                boolean r416 = r134;
                boolean r417 = r135;
                int r210 = r107;
                int r137 = r105;
                int r138 = r106;
                int r139 = r104;
                int r140 = r112;
                boolean r211 = r116;
                int r212 = r113;
                boolean r315 = r125;
                boolean r316 = r124;
                boolean r317 = r123;
                boolean r318 = r122;
                int r141 = -1;
                int r213 = r109;
                int r214 = r108;
                int r142 = r111;
                int r215 = r115;
                int r216 = r114;
                boolean r143 = r103;
                int r144 = 3;
                boolean r319 = r120;
                boolean r217 = r117;
                boolean r218 = r119;
                boolean r219 = r118;
            L60:
                r101.endStructure(r100);
                return new k(r141, r144, r143, r142, r139, r140, r137, r138, r210, r212, r214, r216, r213, r215, r211, r217, r219, r218, r319, r314, r318, r317, r316, r315, r313, r312, r311, r310, r412, r410, r414, r415, r416, r417, r413, r411);
            L5:
                boolean r145 = false;
                boolean r146 = false;
                boolean r320 = false;
                boolean r321 = false;
                boolean r322 = false;
                boolean r323 = false;
                boolean r324 = false;
                boolean r325 = false;
                boolean r326 = false;
                boolean r327 = false;
                boolean r418 = false;
                boolean r419 = false;
                boolean r420 = false;
                boolean r421 = false;
                boolean r422 = false;
                r417 = false;
                boolean r423 = false;
                boolean r424 = false;
                int r425 = 0;
                boolean r426 = false;
                boolean r510 = false;
                int r511 = 0;
                int r512 = 0;
                int r513 = 0;
                int r514 = 0;
                int r515 = 0;
                boolean r516 = false;
                int r517 = 0;
                int r518 = 0;
                int r519 = 0;
                boolean r610 = false;
                int r611 = 0;
                int r612 = 0;
                int r613 = 0;
                boolean r614 = true;
                int r615 = 0;
            L6:
                if (r614 == false) goto L59;
                int r147 = r101.decodeElementIndex(r100);
                switch(r147) {
                    case -1: goto L57;
                    case 0: goto L55;
                    case 1: goto L54;
                    case 2: goto L52;
                    case 3: goto L50;
                    case 4: goto L48;
                    case 5: goto L47;
                    case 6: goto L46;
                    case 7: goto L45;
                    case 8: goto L44;
                    case 9: goto L43;
                    case 10: goto L42;
                    case 11: goto L41;
                    case 12: goto L40;
                    case 13: goto L39;
                    case 14: goto L37;
                    case 15: goto L33;
                    case 16: goto L32;
                    case 17: goto L31;
                    case 18: goto L30;
                    case 19: goto L29;
                    case 20: goto L28;
                    case 21: goto L26;
                    case 22: goto L25;
                    case 23: goto L23;
                    case 24: goto L22;
                    case 25: goto L21;
                    case 26: goto L19;
                    case 27: goto L18;
                    case 28: goto L17;
                    case 29: goto L16;
                    case 30: goto L15;
                    case 31: goto L14;
                    case 32: goto L13;
                    case 33: goto L11;
                    default: goto L10;
                };
            L11:
                r419 = r101.decodeBooleanElement(r100, 33);
                r615 = r615 | 2;
            L35:
                Unit r220 = Unit.INSTANCE;
            L38:
                boolean r328 = r145;
            L56:
                r145 = r328;
            L58:
                r102 = 6;
                goto L6
            L13:
                boolean r148 = r101.decodeBooleanElement(r100, 32);
                int r329 = r615 | 1;
                Unit r616 = Unit.INSTANCE;
                r615 = r329;
                r325 = r148;
                goto L38
            L14:
                r417 = r101.decodeBooleanElement(r100, 31);
                int r149 = Integer.MIN_VALUE;
            L27:
                r110 = r110 | r149;
                goto L35
            L15:
                r423 = r101.decodeBooleanElement(r100, 30);
                r149 = 1073741824;
                goto L27
            L16:
                r420 = r101.decodeBooleanElement(r100, 29);
                r149 = 536870912;
                goto L27
            L17:
                r326 = r101.decodeBooleanElement(r100, 28);
                r149 = 268435456;
                goto L27
            L18:
                r323 = r101.decodeBooleanElement(r100, 27);
                r149 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
                goto L27
            L19:
                r327 = r101.decodeBooleanElement(r100, 26);
                r149 = 67108864;
                goto L27
            L21:
                r324 = r101.decodeBooleanElement(r100, 25);
                r149 = 33554432;
                goto L27
            L22:
                r425 = r101.decodeIntElement(r100, 24);
                r149 = 16777216;
                goto L27
            L23:
                r421 = r101.decodeBooleanElement(r100, 23);
                r149 = 8388608;
                goto L27
            L25:
                r510 = r101.decodeBooleanElement(r100, 22);
                r149 = 4194304;
                goto L27
            L26:
                r426 = r101.decodeBooleanElement(r100, 21);
                r149 = 2097152;
                goto L27
            L28:
                r418 = r101.decodeBooleanElement(r100, 20);
                int r221 = 1048576;
            L34:
                r110 = r110 | r221;
                goto L35
            L29:
                r422 = r101.decodeBooleanElement(r100, 19);
                r221 = 524288;
                goto L34
            L30:
                r424 = r101.decodeBooleanElement(r100, 18);
                r221 = 262144;
                goto L34
            L31:
                r321 = r101.decodeBooleanElement(r100, 17);
                r221 = 131072;
                goto L34
            L32:
                r221 = 65536;
                r146 = r101.decodeBooleanElement(r100, 16);
                goto L34
            L33:
                r322 = r101.decodeBooleanElement(r100, 15);
                r221 = 32768;
                goto L34
            L37:
                r320 = r101.decodeBooleanElement(r100, 14);
                r110 = r110 | 16384;
                Unit r222 = Unit.INSTANCE;
                goto L38
            L39:
                r516 = r101.decodeBooleanElement(r100, 13);
                r110 = r110 | 8192;
            L49:
                Unit r223 = Unit.INSTANCE;
            L53:
                r328 = r145;
                goto L56
            L40:
                r610 = r101.decodeBooleanElement(r100, 12);
                r110 = r110 | 4096;
                goto L49
            L41:
                r611 = r101.decodeIntElement(r100, 11);
                r110 = r110 | 2048;
                goto L49
            L42:
                r512 = r101.decodeIntElement(r100, 10);
                r110 = r110 | 1024;
                goto L49
            L43:
                r612 = r101.decodeIntElement(r100, 9);
                r110 = r110 | 512;
                goto L49
            L44:
                r514 = r101.decodeIntElement(r100, 8);
                r110 = r110 | 256;
                goto L49
            L45:
                r613 = r101.decodeIntElement(r100, 7);
                r110 = r110 | 128;
                goto L49
            L46:
                r511 = r101.decodeIntElement(r100, r102);
                r110 = r110 | 64;
                goto L49
            L47:
                r515 = r101.decodeIntElement(r100, 5);
                r110 = r110 | 32;
                goto L49
            L48:
                r513 = r101.decodeIntElement(r100, 4);
                r110 = r110 | 16;
                goto L49
            L50:
                r519 = r101.decodeIntElement(r100, 3);
                r110 = r110 | 8;
                Unit r330 = Unit.INSTANCE;
                goto L53
            L52:
                r517 = r101.decodeIntElement(r100, 2);
                r110 = r110 | 4;
                Unit r331 = Unit.INSTANCE;
                goto L53
            L54:
                int r332 = r101.decodeIntElement(r100, 1);
                r110 = r110 | 2;
                Unit r520 = Unit.INSTANCE;
                r518 = r332;
                r328 = r145;
                goto L56
            L55:
                r328 = r101.decodeBooleanElement(r100, 0);
                r110 = r110 | 1;
                Unit r617 = Unit.INSTANCE;
                goto L56
            L57:
                Unit r618 = Unit.INSTANCE;
                r614 = false;
                goto L58
            L10:
                throw new UnknownFieldException(r147);
            L59:
                r143 = r145;
                r319 = r146;
                r141 = r110;
                r219 = r320;
                r314 = r321;
                r218 = r322;
                r316 = r418;
                r317 = r422;
                r416 = r423;
                r318 = r424;
                r210 = r511;
                r213 = r512;
                r137 = r513;
                r214 = r514;
                r138 = r515;
                r217 = r516;
                r139 = r517;
                r142 = r518;
                r140 = r519;
                r211 = r610;
                r215 = r611;
                r216 = r612;
                r212 = r613;
                r144 = r615;
                r413 = r325;
                r412 = r327;
                r411 = r419;
                r312 = r421;
                r410 = r323;
                r310 = r324;
                r415 = r420;
                r315 = r426;
                r313 = r510;
                r414 = r326;
                r311 = r425;
                goto L60
            }

            @Override // juc.n
            public final void serialize(muc.f r100, Object r101) {
                k r102 = (k) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                g2 r103 = f348562b;
                muc.d r104 = r100.beginStructure(r103);
                b r105 = k.Companion;
                boolean r106 = false;
                if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
            L7:
                boolean r107 = true;
            L9:
                if (r107 == false) goto L12;
                r104.encodeBooleanElement(r103, 0, r102.f348535a);
            L12:
                if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
            L16:
                boolean r108 = true;
            L18:
                if (r108 == false) goto L21;
                r104.encodeIntElement(r103, 1, r102.f348536b);
            L21:
                if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
            L25:
                boolean r109 = true;
            L27:
                if (r109 == false) goto L30;
                r104.encodeIntElement(r103, 2, r102.f348537c);
            L30:
                if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
            L34:
                boolean r110 = true;
            L36:
                if (r110 == false) goto L39;
                r104.encodeIntElement(r103, 3, r102.f348538d);
            L39:
                if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L42;
            L43:
                boolean r111 = true;
            L45:
                if (r111 == false) goto L48;
                r104.encodeIntElement(r103, 4, r102.f348539e);
            L48:
                if (r104.shouldEncodeElementDefault(r103, 5) == false) goto L51;
            L52:
                boolean r112 = true;
            L54:
                if (r112 == false) goto L57;
                r104.encodeIntElement(r103, 5, r102.f348540f);
            L57:
                if (r104.shouldEncodeElementDefault(r103, 6) == false) goto L60;
            L61:
                boolean r113 = true;
            L63:
                if (r113 == false) goto L66;
                r104.encodeIntElement(r103, 6, r102.f348541g);
            L66:
                if (r104.shouldEncodeElementDefault(r103, 7) == false) goto L69;
            L70:
                boolean r114 = true;
            L72:
                if (r114 == false) goto L75;
                r104.encodeIntElement(r103, 7, r102.f348542h);
            L75:
                if (r104.shouldEncodeElementDefault(r103, 8) == false) goto L78;
            L79:
                boolean r115 = true;
            L81:
                if (r115 == false) goto L84;
                r104.encodeIntElement(r103, 8, r102.f348543i);
            L84:
                if (r104.shouldEncodeElementDefault(r103, 9) == false) goto L87;
            L88:
                boolean r116 = true;
            L90:
                if (r116 == false) goto L93;
                r104.encodeIntElement(r103, 9, r102.f348544j);
            L93:
                if (r104.shouldEncodeElementDefault(r103, 10) == false) goto L96;
            L97:
                boolean r117 = true;
            L99:
                if (r117 == false) goto L102;
                r104.encodeIntElement(r103, 10, r102.f348545k);
            L102:
                if (r104.shouldEncodeElementDefault(r103, 11) == false) goto L105;
            L106:
                boolean r118 = true;
            L108:
                if (r118 == false) goto L111;
                r104.encodeIntElement(r103, 11, r102.f348546l);
            L111:
                if (r104.shouldEncodeElementDefault(r103, 12) == false) goto L114;
            L115:
                boolean r119 = true;
            L117:
                if (r119 == false) goto L120;
                r104.encodeBooleanElement(r103, 12, r102.f348547m);
            L120:
                if (r104.shouldEncodeElementDefault(r103, 13) == false) goto L123;
            L124:
                boolean r120 = true;
            L126:
                if (r120 == false) goto L129;
                r104.encodeBooleanElement(r103, 13, r102.f348548n);
            L129:
                if (r104.shouldEncodeElementDefault(r103, 14) == false) goto L132;
            L133:
                boolean r121 = true;
            L135:
                if (r121 == false) goto L138;
                r104.encodeBooleanElement(r103, 14, r102.f348549o);
            L138:
                if (r104.shouldEncodeElementDefault(r103, 15) == false) goto L141;
            L142:
                boolean r122 = true;
            L144:
                if (r122 == false) goto L147;
                r104.encodeBooleanElement(r103, 15, r102.f348550p);
            L147:
                if (r104.shouldEncodeElementDefault(r103, 16) == false) goto L150;
            L151:
                boolean r123 = true;
            L153:
                if (r123 == false) goto L156;
                r104.encodeBooleanElement(r103, 16, r102.f348551q);
            L156:
                if (r104.shouldEncodeElementDefault(r103, 17) == false) goto L159;
            L160:
                boolean r124 = true;
            L162:
                if (r124 == false) goto L165;
                r104.encodeBooleanElement(r103, 17, r102.f348552r);
            L165:
                if (r104.shouldEncodeElementDefault(r103, 18) == false) goto L168;
            L169:
                boolean r125 = true;
            L171:
                if (r125 == false) goto L174;
                r104.encodeBooleanElement(r103, 18, r102.f348553s);
            L174:
                if (r104.shouldEncodeElementDefault(r103, 19) == false) goto L177;
            L178:
                boolean r126 = true;
            L180:
                if (r126 == false) goto L183;
                r104.encodeBooleanElement(r103, 19, r102.f348554t);
            L183:
                if (r104.shouldEncodeElementDefault(r103, 20) == false) goto L186;
            L187:
                boolean r127 = true;
            L189:
                if (r127 == false) goto L192;
                r104.encodeBooleanElement(r103, 20, r102.f348555u);
            L192:
                if (r104.shouldEncodeElementDefault(r103, 21) == false) goto L195;
            L196:
                boolean r128 = true;
            L198:
                if (r128 == false) goto L201;
                r104.encodeBooleanElement(r103, 21, r102.f348556v);
            L201:
                if (r104.shouldEncodeElementDefault(r103, 22) == false) goto L204;
            L205:
                boolean r129 = true;
            L207:
                if (r129 == false) goto L210;
                r104.encodeBooleanElement(r103, 22, r102.f348557w);
            L210:
                if (r104.shouldEncodeElementDefault(r103, 23) == false) goto L213;
            L214:
                boolean r130 = true;
            L216:
                if (r130 == false) goto L219;
                r104.encodeBooleanElement(r103, 23, r102.f348558x);
            L219:
                if (r104.shouldEncodeElementDefault(r103, 24) == false) goto L222;
            L223:
                boolean r131 = true;
            L225:
                if (r131 == false) goto L228;
                r104.encodeIntElement(r103, 24, r102.f348559y);
            L228:
                if (r104.shouldEncodeElementDefault(r103, 25) == false) goto L231;
            L232:
                boolean r132 = true;
            L234:
                if (r132 == false) goto L237;
                r104.encodeBooleanElement(r103, 25, r102.f348560z);
            L237:
                if (r104.shouldEncodeElementDefault(r103, 26) == false) goto L240;
            L241:
                boolean r133 = true;
            L243:
                if (r133 == false) goto L246;
                r104.encodeBooleanElement(r103, 26, r102.A);
            L246:
                if (r104.shouldEncodeElementDefault(r103, 27) == false) goto L249;
            L250:
                boolean r134 = true;
            L252:
                if (r134 == false) goto L255;
                r104.encodeBooleanElement(r103, 27, r102.B);
            L255:
                if (r104.shouldEncodeElementDefault(r103, 28) == false) goto L258;
            L259:
                boolean r135 = true;
            L261:
                if (r135 == false) goto L264;
                r104.encodeBooleanElement(r103, 28, r102.C);
            L264:
                if (r104.shouldEncodeElementDefault(r103, 29) == false) goto L267;
            L268:
                boolean r136 = true;
            L270:
                if (r136 == false) goto L273;
                r104.encodeBooleanElement(r103, 29, r102.D);
            L273:
                if (r104.shouldEncodeElementDefault(r103, 30) == false) goto L276;
            L277:
                boolean r137 = true;
            L279:
                if (r137 == false) goto L282;
                r104.encodeBooleanElement(r103, 30, r102.E);
            L282:
                if (r104.shouldEncodeElementDefault(r103, 31) == false) goto L285;
            L286:
                boolean r138 = true;
            L288:
                if (r138 == false) goto L291;
                r104.encodeBooleanElement(r103, 31, r102.F);
            L291:
                if (r104.shouldEncodeElementDefault(r103, 32) == false) goto L294;
            L295:
                boolean r139 = true;
            L297:
                if (r139 == false) goto L300;
                r104.encodeBooleanElement(r103, 32, r102.G);
            L300:
                if (r104.shouldEncodeElementDefault(r103, 33) == false) goto L303;
            L304:
                r106 = true;
            L305:
                if (r106 == false) goto L307;
                r104.encodeBooleanElement(r103, 33, r102.H);
            L307:
                r104.endStructure(r103);
                return;
            L303:
                if (r102.H == true) goto L305;
            L294:
                if (r102.G != true) goto L295;
                r139 = false;
                goto L297
            L285:
                if (r102.F != true) goto L286;
                r138 = false;
                goto L288
            L276:
                if (r102.E != true) goto L277;
                r137 = false;
                goto L279
            L267:
                if (r102.D != true) goto L268;
                r136 = false;
                goto L270
            L258:
                if (r102.C != true) goto L259;
                r135 = false;
                goto L261
            L249:
                if (r102.B != true) goto L250;
                r134 = false;
                goto L252
            L240:
                if (r102.A != true) goto L241;
                r133 = false;
                goto L243
            L231:
                if (r102.f348560z != true) goto L232;
                r132 = false;
                goto L234
            L222:
                if (r102.f348559y != 10485760) goto L223;
                r131 = false;
                goto L225
            L213:
                if (r102.f348558x != true) goto L214;
                r130 = false;
                goto L216
            L204:
                if (r102.f348557w != true) goto L205;
                r129 = false;
                goto L207
            L195:
                if (r102.f348556v != true) goto L196;
                r128 = false;
                goto L198
            L186:
                if (r102.f348555u != true) goto L187;
                r127 = false;
                goto L189
            L177:
                if (r102.f348554t != true) goto L178;
                r126 = false;
                goto L180
            L168:
                if (r102.f348553s != true) goto L169;
                r125 = false;
                goto L171
            L159:
                if (r102.f348552r != true) goto L160;
                r124 = false;
                goto L162
            L150:
                if (r102.f348551q == true) goto L151;
                r123 = false;
                goto L153
            L141:
                if (r102.f348550p == true) goto L142;
                r122 = false;
                goto L144
            L132:
                if (r102.f348549o != true) goto L133;
                r121 = false;
                goto L135
            L123:
                if (r102.f348548n != true) goto L124;
                r120 = false;
                goto L126
            L114:
                if (r102.f348547m == true) goto L115;
                r119 = false;
                goto L117
            L105:
                if (r102.f348546l != 1) goto L106;
                r118 = false;
                goto L108
            L96:
                if (r102.f348545k != 1) goto L97;
                r117 = false;
                goto L99
            L87:
                if (r102.f348544j != 1) goto L88;
                r116 = false;
                goto L90
            L78:
                if (r102.f348543i != 1) goto L79;
                r115 = false;
                goto L81
            L69:
                if (r102.f348542h != 1) goto L70;
                r114 = false;
                goto L72
            L60:
                if (r102.f348541g != 1) goto L61;
                r113 = false;
                goto L63
            L51:
                if (r102.f348540f != 1) goto L52;
                r112 = false;
                goto L54
            L42:
                if (r102.f348539e != 1) goto L43;
                r111 = false;
                goto L45
            L33:
                if (r102.f348538d != 1) goto L34;
                r110 = false;
                goto L36
            L24:
                if (r102.f348537c != 1) goto L25;
                r109 = false;
                goto L27
            L15:
                if (r102.f348536b != 1) goto L16;
                r108 = false;
                goto L18
            L6:
                if (r102.f348535a != true) goto L7;
                r107 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<k> serializer() {
                return a.f348561a;
            }
        }

        public k() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof k) == true) goto L8;
            return false;
        L8:
            k r101 = (k) r100;
            if (this.f348535a == r101.f348535a) goto L12;
            return false;
        L12:
            if (this.f348536b == r101.f348536b) goto L15;
            return false;
        L15:
            if (this.f348537c == r101.f348537c) goto L18;
            return false;
        L18:
            if (this.f348538d == r101.f348538d) goto L21;
            return false;
        L21:
            if (this.f348539e == r101.f348539e) goto L24;
            return false;
        L24:
            if (this.f348540f == r101.f348540f) goto L27;
            return false;
        L27:
            if (this.f348541g == r101.f348541g) goto L30;
            return false;
        L30:
            if (this.f348542h == r101.f348542h) goto L33;
            return false;
        L33:
            if (this.f348543i == r101.f348543i) goto L36;
            return false;
        L36:
            if (this.f348544j == r101.f348544j) goto L39;
            return false;
        L39:
            if (this.f348545k == r101.f348545k) goto L42;
            return false;
        L42:
            if (this.f348546l == r101.f348546l) goto L45;
            return false;
        L45:
            if (this.f348547m == r101.f348547m) goto L48;
            return false;
        L48:
            if (this.f348548n == r101.f348548n) goto L51;
            return false;
        L51:
            if (this.f348549o == r101.f348549o) goto L54;
            return false;
        L54:
            if (this.f348550p == r101.f348550p) goto L57;
            return false;
        L57:
            if (this.f348551q == r101.f348551q) goto L60;
            return false;
        L60:
            if (this.f348552r == r101.f348552r) goto L63;
            return false;
        L63:
            if (this.f348553s == r101.f348553s) goto L66;
            return false;
        L66:
            if (this.f348554t == r101.f348554t) goto L69;
            return false;
        L69:
            if (this.f348555u == r101.f348555u) goto L72;
            return false;
        L72:
            if (this.f348556v == r101.f348556v) goto L75;
            return false;
        L75:
            if (this.f348557w == r101.f348557w) goto L78;
            return false;
        L78:
            if (this.f348558x == r101.f348558x) goto L81;
            return false;
        L81:
            if (this.f348559y == r101.f348559y) goto L84;
            return false;
        L84:
            if (this.f348560z == r101.f348560z) goto L87;
            return false;
        L87:
            if (this.A == r101.A) goto L90;
            return false;
        L90:
            if (this.B == r101.B) goto L93;
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
            if (this.G == r101.G) goto L108;
            return false;
        L108:
            if (this.H == r101.H) goto L110;
            return false;
        L110:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f348535a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = ((((((((((((((((((((((r101 * 31) + this.f348536b) * 31) + this.f348537c) * 31) + this.f348538d) * 31) + this.f348539e) * 31) + this.f348540f) * 31) + this.f348541g) * 31) + this.f348542h) * 31) + this.f348543i) * 31) + this.f348544j) * 31) + this.f348545k) * 31) + this.f348546l) * 31;
            if (this.f348547m == false) goto L9;
            int r103 = 1231;
        L10:
            int r104 = (r102 + r103) * 31;
            if (this.f348548n == false) goto L13;
            int r105 = 1231;
        L14:
            int r106 = (r104 + r105) * 31;
            if (this.f348549o == false) goto L17;
            int r107 = 1231;
        L18:
            int r108 = (r106 + r107) * 31;
            if (this.f348550p == false) goto L21;
            int r109 = 1231;
        L22:
            int r110 = (r108 + r109) * 31;
            if (this.f348551q == false) goto L25;
            int r111 = 1231;
        L26:
            int r112 = (r110 + r111) * 31;
            if (this.f348552r == false) goto L29;
            int r113 = 1231;
        L30:
            int r114 = (r112 + r113) * 31;
            if (this.f348553s == false) goto L33;
            int r115 = 1231;
        L34:
            int r116 = (r114 + r115) * 31;
            if (this.f348554t == false) goto L37;
            int r117 = 1231;
        L38:
            int r118 = (r116 + r117) * 31;
            if (this.f348555u == false) goto L41;
            int r119 = 1231;
        L42:
            int r120 = (r118 + r119) * 31;
            if (this.f348556v == false) goto L45;
            int r121 = 1231;
        L46:
            int r122 = (r120 + r121) * 31;
            if (this.f348557w == false) goto L49;
            int r123 = 1231;
        L50:
            int r124 = (r122 + r123) * 31;
            if (this.f348558x == false) goto L53;
            int r125 = 1231;
        L54:
            int r126 = (((r124 + r125) * 31) + this.f348559y) * 31;
            if (this.f348560z == false) goto L57;
            int r127 = 1231;
        L58:
            int r128 = (r126 + r127) * 31;
            if (this.A == false) goto L61;
            int r129 = 1231;
        L62:
            int r130 = (r128 + r129) * 31;
            if (this.B == false) goto L65;
            int r131 = 1231;
        L66:
            int r132 = (r130 + r131) * 31;
            if (this.C == false) goto L69;
            int r133 = 1231;
        L70:
            int r134 = (r132 + r133) * 31;
            if (this.D == false) goto L73;
            int r135 = 1231;
        L74:
            int r136 = (r134 + r135) * 31;
            if (this.E == false) goto L77;
            int r137 = 1231;
        L78:
            int r138 = (r136 + r137) * 31;
            if (this.F == false) goto L81;
            int r139 = 1231;
        L82:
            int r140 = (r138 + r139) * 31;
            if (this.G == false) goto L85;
            int r141 = 1231;
        L86:
            int r142 = (r140 + r141) * 31;
            if (this.H == true) goto L91;
            r100 = 1237;
        L91:
            return r142 + r100;
        L85:
            r141 = 1237;
            goto L86
        L81:
            r139 = 1237;
            goto L82
        L77:
            r137 = 1237;
            goto L78
        L73:
            r135 = 1237;
            goto L74
        L69:
            r133 = 1237;
            goto L70
        L65:
            r131 = 1237;
            goto L66
        L61:
            r129 = 1237;
            goto L62
        L57:
            r127 = 1237;
            goto L58
        L53:
            r125 = 1237;
            goto L54
        L49:
            r123 = 1237;
            goto L50
        L45:
            r121 = 1237;
            goto L46
        L41:
            r119 = 1237;
            goto L42
        L37:
            r117 = 1237;
            goto L38
        L33:
            r115 = 1237;
            goto L34
        L29:
            r113 = 1237;
            goto L30
        L25:
            r111 = 1237;
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
            return "FixConfig(useNewInterruptCheck=" + this.f348535a + ", fixEnterForegroundFillStreamingMessage=" + this.f348536b + ", fixLocalMsgSkip=" + this.f348537c + ", fixStopChunkFailed=" + this.f348538d + ", fixPullStreamingMessage=" + this.f348539e + ", fixDbWal=" + this.f348540f + ", fixSingleChainFirstPageContentEmpty=" + this.f348541g + ", fixDbLongDurationBug=" + this.f348542h + ", fixSubListError=" + this.f348543i + ", fixListOrderError=" + this.f348544j + ", fixInvalidLoadingError=" + this.f348545k + ", fixClearHistoryError=" + this.f348546l + ", fixCmdReplace=" + this.f348547m + ", fixSearchFilterMessageCursor=" + this.f348548n + ", searchFilterConversation=" + this.f348549o + ", fixGetMainCvs=" + this.f348550p + ", fixMockMainCvs=" + this.f348551q + ", filterNullContentMsg=" + this.f348552r + ", fixCmdBugs=" + this.f348553s + ", fixLongCmdLoss=" + this.f348554t + ", fixFeedbackBugs=" + this.f348555u + ", fixReplaceLocal=" + this.f348556v + ", fixCallReplaceFailed=" + this.f348557w + ", fixChunkReadLineLoop=" + this.f348558x + ", netPackageMaxLength=" + this.f348559y + ", firstReturnLocalBotId=" + this.f348560z + ", fixReplaceNewLocal=" + this.A + ", lastCancelTyping=" + this.B + ", useNewMainBotLocalCvsId=" + this.C + ", releaseAsrOnPrepareMessage=" + this.D + ", offlineConversationInOut=" + this.E + ", newOmniScope=" + this.F + ", replaceInvalidScope=" + this.G + ", flushStreamOnTypingError=" + this.H + ')';
        }

        static {
            Companion = new b();
        }

        public k(int r100) {
            this.f348535a = true;
            this.f348536b = 1;
            this.f348537c = 1;
            this.f348538d = 1;
            this.f348539e = 1;
            this.f348540f = 1;
            this.f348541g = 1;
            this.f348542h = 1;
            this.f348543i = 1;
            this.f348544j = 1;
            this.f348545k = 1;
            this.f348546l = 1;
            this.f348547m = false;
            this.f348548n = true;
            this.f348549o = true;
            this.f348550p = false;
            this.f348551q = false;
            this.f348552r = true;
            this.f348553s = true;
            this.f348554t = true;
            this.f348555u = true;
            this.f348556v = true;
            this.f348557w = true;
            this.f348558x = true;
            this.f348559y = BmLocated.ALIGN_RIGHT_BOTTOM;
            this.f348560z = true;
            this.A = true;
            this.B = true;
            this.C = true;
            this.D = true;
            this.E = true;
            this.F = true;
            this.G = true;
            this.H = true;
        }

        public k(int r100, int r101, boolean r102, int r110, int r111, int r112, int r113, int r114, int r115, int r116, int r117, int r118, int r119, int r210, boolean r211, boolean r212, boolean r213, boolean r214, boolean r215, boolean r216, boolean r217, boolean r218, boolean r219, boolean r310, boolean r311, boolean r312, int r313, boolean r314, boolean r315, boolean r316, boolean r317, boolean r318, boolean r319, boolean r410, boolean r411, boolean r412) {
            if ((r100 & 0) == 0) goto L5;
            boolean r103 = true;
        L7:
            if ((r101 & 0) == 0) goto L9;
            boolean r104 = true;
        L11:
            if ((r103 | r104) == false) goto L13;
            b2.a(new int[]{r100, r101}, new int[]{0, 0}, a.f348562b);
            throw null;
        L13:
            if ((r100 & 1) != 0) goto L15;
            this.f348535a = true;
        L17:
            if ((r100 & 2) != 0) goto L19;
            this.f348536b = 1;
        L21:
            if ((r100 & 4) != 0) goto L23;
            this.f348537c = 1;
        L25:
            if ((r100 & 8) != 0) goto L27;
            this.f348538d = 1;
        L29:
            if ((r100 & 16) != 0) goto L31;
            this.f348539e = 1;
        L33:
            if ((r100 & 32) != 0) goto L35;
            this.f348540f = 1;
        L37:
            if ((r100 & 64) != 0) goto L39;
            this.f348541g = 1;
        L41:
            if ((r100 & 128) != 0) goto L43;
            this.f348542h = 1;
        L45:
            if ((r100 & 256) != 0) goto L47;
            this.f348543i = 1;
        L49:
            if ((r100 & 512) != 0) goto L51;
            this.f348544j = 1;
        L53:
            if ((r100 & 1024) != 0) goto L55;
            this.f348545k = 1;
        L57:
            if ((r100 & 2048) != 0) goto L59;
            this.f348546l = 1;
        L61:
            if ((r100 & 4096) != 0) goto L63;
            this.f348547m = false;
        L65:
            if ((r100 & 8192) != 0) goto L67;
            this.f348548n = true;
        L69:
            if ((r100 & 16384) != 0) goto L71;
            this.f348549o = true;
        L73:
            if ((32768 & r100) != 0) goto L75;
            this.f348550p = false;
        L77:
            if ((65536 & r100) != 0) goto L79;
            this.f348551q = false;
        L81:
            if ((131072 & r100) != 0) goto L83;
            this.f348552r = true;
        L85:
            if ((262144 & r100) != 0) goto L87;
            this.f348553s = true;
        L89:
            if ((524288 & r100) != 0) goto L91;
            this.f348554t = true;
        L93:
            if ((1048576 & r100) != 0) goto L95;
            this.f348555u = true;
        L97:
            if ((2097152 & r100) != 0) goto L99;
            this.f348556v = true;
        L101:
            if ((4194304 & r100) != 0) goto L103;
            this.f348557w = true;
        L105:
            if ((8388608 & r100) != 0) goto L107;
            this.f348558x = true;
        L109:
            if ((16777216 & r100) != 0) goto L111;
            int r105 = BmLocated.ALIGN_RIGHT_BOTTOM;
        L112:
            this.f348559y = r105;
            if ((33554432 & r100) != 0) goto L115;
            this.f348560z = true;
        L117:
            if ((67108864 & r100) != 0) goto L119;
            this.A = true;
        L121:
            if ((134217728 & r100) != 0) goto L123;
            this.B = true;
        L125:
            if ((268435456 & r100) != 0) goto L127;
            this.C = true;
        L129:
            if ((536870912 & r100) != 0) goto L131;
            this.D = true;
        L133:
            if ((1073741824 & r100) != 0) goto L135;
            this.E = true;
        L137:
            if ((r100 & Integer.MIN_VALUE) != 0) goto L139;
            this.F = true;
        L141:
            if ((r101 & 1) != 0) goto L143;
            this.G = true;
        L145:
            if ((r101 & 2) != 0) goto L147;
            this.H = true;
            return;
        L147:
            this.H = r412;
            return;
        L143:
            this.G = r411;
            goto L145
        L139:
            this.F = r410;
            goto L141
        L135:
            this.E = r319;
            goto L137
        L131:
            this.D = r318;
            goto L133
        L127:
            this.C = r317;
            goto L129
        L123:
            this.B = r316;
            goto L125
        L119:
            this.A = r315;
            goto L121
        L115:
            this.f348560z = r314;
            goto L117
        L111:
            r105 = r313;
            goto L112
        L107:
            this.f348558x = r312;
            goto L109
        L103:
            this.f348557w = r311;
            goto L105
        L99:
            this.f348556v = r310;
            goto L101
        L95:
            this.f348555u = r219;
            goto L97
        L91:
            this.f348554t = r218;
            goto L93
        L87:
            this.f348553s = r217;
            goto L89
        L83:
            this.f348552r = r216;
            goto L85
        L79:
            this.f348551q = r215;
            goto L81
        L75:
            this.f348550p = r214;
            goto L77
        L71:
            this.f348549o = r213;
            goto L73
        L67:
            this.f348548n = r212;
            goto L69
        L63:
            this.f348547m = r211;
            goto L65
        L59:
            this.f348546l = r210;
            goto L61
        L55:
            this.f348545k = r119;
            goto L57
        L51:
            this.f348544j = r118;
            goto L53
        L47:
            this.f348543i = r117;
            goto L49
        L43:
            this.f348542h = r116;
            goto L45
        L39:
            this.f348541g = r115;
            goto L41
        L35:
            this.f348540f = r114;
            goto L37
        L31:
            this.f348539e = r113;
            goto L33
        L27:
            this.f348538d = r112;
            goto L29
        L23:
            this.f348537c = r111;
            goto L25
        L19:
            this.f348536b = r110;
            goto L21
        L15:
            this.f348535a = r102;
            goto L17
        L9:
            r104 = false;
            goto L11
        L5:
            r103 = false;
            goto L7
        }
    }

    @Serializable
    public static final class l {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m f348563a;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<l> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348564a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348565b = null;

            public a() {
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                return new juc.d[]{kuc.a.d(m.a.f348567a)};
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348565b;
            }

            static {
                a r100 = new a();
                f348564a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowSettingsDelegate.IMSDKDBConfig", r100, 1);
                r101.j("omni_db_indexes_config", true);
                f348565b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r100) {
                Intrinsics.checkNotNullParameter(r100, "decoder");
                g2 r101 = f348565b;
                muc.c r102 = r100.beginStructure(r101);
                int r103 = 1;
                m r104 = null;
                if (r102.decodeSequentially() == false) goto L5;
                m r105 = (m) r102.decodeNullableSerializableElement(r101, 0, m.a.f348567a, null);
            L15:
                r102.endStructure(r101);
                return new l(r103, r105);
            L5:
                int r106 = 0;
            L6:
                if (r103 == 0) goto L14;
                int r107 = r102.decodeElementIndex(r101);
                if (r107 != (-1)) goto L9;
                r103 = 0;
                goto L6
            L9:
                if (r107 != 0) goto L12;
                r104 = (m) r102.decodeNullableSerializableElement(r101, 0, m.a.f348567a, r104);
                r106 = r106 | 1;
                goto L6
            L12:
                throw new UnknownFieldException(r107);
            L14:
                r103 = r106;
                r105 = r104;
                goto L15
            }

            @Override // juc.n
            public final void serialize(muc.f r100, Object r101) {
                l r102 = (l) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                g2 r103 = f348565b;
                muc.d r104 = r100.beginStructure(r103);
                b r105 = l.Companion;
                if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
            L7:
                boolean r106 = true;
            L9:
                if (r106 == false) goto L11;
                r104.encodeNullableSerializableElement(r103, 0, m.a.f348567a, r102.f348563a);
            L11:
                r104.endStructure(r103);
                return;
            L6:
                if (Intrinsics.areEqual(r102.f348563a, new m(0)) == false) goto L7;
                r106 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<l> serializer() {
                return a.f348564a;
            }
        }

        public l() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof l) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f348563a, ((l) r100).f348563a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            m r100 = this.f348563a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "IMSDKDBConfig(indexConfig=" + this.f348563a + ')';
        }

        static {
            Companion = new b();
        }

        public l(int r100) {
            this.f348563a = new m(0);
        }

        public l(int r100, m r101) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348565b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            this.f348563a = new m(0);
            return;
        L7:
            this.f348563a = r101;
        }
    }

    @Serializable
    public static final class m {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f348566a;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<m> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348567a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348568b = null;

            public a() {
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                return new juc.d[]{nuc.i.f520705a};
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348568b;
            }

            static {
                a r100 = new a();
                f348567a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowSettingsDelegate.IndexConfig", r100, 1);
                r101.j("enable", true);
                f348568b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r100) {
                Intrinsics.checkNotNullParameter(r100, "decoder");
                g2 r101 = f348568b;
                muc.c r102 = r100.beginStructure(r101);
                int r103 = 1;
                if (r102.decodeSequentially() == false) goto L5;
                boolean r104 = r102.decodeBooleanElement(r101, 0);
            L15:
                r102.endStructure(r101);
                return new m(r103, r104);
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
                m r102 = (m) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                g2 r103 = f348568b;
                muc.d r104 = r100.beginStructure(r103);
                b r105 = m.Companion;
                if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
            L7:
                boolean r106 = true;
            L9:
                if (r106 == false) goto L11;
                r104.encodeBooleanElement(r103, 0, r102.f348566a);
            L11:
                r104.endStructure(r103);
                return;
            L6:
                if (r102.f348566a == true) goto L7;
                r106 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<m> serializer() {
                return a.f348567a;
            }
        }

        public m() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof m) == true) goto L9;
            return false;
        L9:
            if (this.f348566a == ((m) r100).f348566a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f348566a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "IndexConfig(enable=" + this.f348566a + ')';
        }

        static {
            Companion = new b();
        }

        public m(int r100) {
            this.f348566a = false;
        }

        public m(int r100, boolean r101) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348568b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            this.f348566a = false;
            return;
        L7:
            this.f348566a = r101;
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    @Serializable
    public static final class n {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f348569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double f348570b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f348571c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final double f348572d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final double f348573e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f348574f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f348575g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final s f348576h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final v f348577i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f348578j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final long f348579k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final int f348580l;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<n> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348581a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348582b = null;

            public a() {
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348582b;
            }

            static {
                a r100 = new a();
                f348581a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowSettingsDelegate.MechanismChunkConfig", r100, 12);
                r101.j("binary_type", true);
                r101.j("timeout_sec", true);
                r101.j("max_retry_times", true);
                r101.j("retry_interval_sec", true);
                r101.j("timeout_sec_per_chunk", true);
                r101.j("enable_v2", true);
                r101.j("direct_sse_send", true);
                r101.j("recent_conv_fetcher_config", true);
                r101.j("track_config", true);
                r101.j("timeout_protect", true);
                r101.j("timeout_write", true);
                r101.j("write_chunk_seq_start", true);
                f348582b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                nuc.b0 r100 = nuc.b0.f520644a;
                nuc.w0 r101 = nuc.w0.f520792a;
                nuc.i r102 = nuc.i.f520705a;
                nuc.g1 r103 = nuc.g1.f520681a;
                return new juc.d[]{kuc.a.d(v2.f520790a), r100, r101, r100, r100, r102, r102, kuc.a.d(s.a.f348615a), kuc.a.d(v.a.f348636a), r103, r103, r101};
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r310) {
                Intrinsics.checkNotNullParameter(r310, "decoder");
                g2 r100 = f348582b;
                muc.c r101 = r310.beginStructure(r100);
                int r102 = 4;
                int r103 = 8;
                int r110 = 0;
                if (r101.decodeSequentially() == false) goto L5;
                String r104 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, null);
                double r111 = r101.decodeDoubleElement(r100, 1);
                int r105 = r101.decodeIntElement(r100, 2);
                double r112 = r101.decodeDoubleElement(r100, 3);
                double r113 = r101.decodeDoubleElement(r100, 4);
                boolean r106 = r101.decodeBooleanElement(r100, 5);
                boolean r107 = r101.decodeBooleanElement(r100, 6);
                s r114 = (s) r101.decodeNullableSerializableElement(r100, 7, s.a.f348615a, null);
                v r108 = (v) r101.decodeNullableSerializableElement(r100, 8, v.a.f348636a, null);
                long r115 = r101.decodeLongElement(r100, 9);
                long r210 = r101.decodeLongElement(r100, 10);
                int r211 = r101.decodeIntElement(r100, 11);
                long r212 = r115;
                double r116 = r113;
                int r109 = UnixStat.PERM_MASK;
                String r117 = r104;
                v r118 = r108;
                s r119 = r114;
                double r120 = r112;
                boolean r121 = r106;
                boolean r122 = r107;
                int r123 = r105;
                double r124 = r111;
            L29:
                r101.endStructure(r100);
                return new n(r109, r117, r124, r123, r120, r116, r121, r122, r119, r118, r212, r210, r211);
            L5:
                long r125 = 0;
                v r126 = null;
                s r127 = null;
                String r213 = null;
                double r214 = 0.0d;
                double r215 = 0.0d;
                double r216 = 0.0d;
                long r217 = 0;
                boolean r128 = false;
                boolean r129 = false;
                int r130 = 0;
                int r131 = 0;
                boolean r218 = true;
            L6:
                if (r218 == false) goto L28;
                int r132 = r101.decodeElementIndex(r100);
                switch(r132) {
                    case -1: goto L27;
                    case 0: goto L25;
                    case 1: goto L23;
                    case 2: goto L22;
                    case 3: goto L21;
                    case 4: goto L19;
                    case 5: goto L18;
                    case 6: goto L17;
                    case 7: goto L15;
                    case 8: goto L14;
                    case 9: goto L13;
                    case 10: goto L12;
                    case 11: goto L11;
                    default: goto L10;
                };
            L10:
                throw new UnknownFieldException(r132);
            L21:
                r215 = r101.decodeDoubleElement(r100, 3);
                r110 = r110 | 8;
                goto L6
            L22:
                r131 = r101.decodeIntElement(r100, 2);
                r110 = r110 | 4;
            L24:
                r102 = 4;
                goto L6
            L23:
                r214 = r101.decodeDoubleElement(r100, 1);
                r110 = r110 | 2;
                goto L24
            L27:
                r103 = 8;
                r218 = false;
                goto L6
            L11:
                r130 = r101.decodeIntElement(r100, 11);
                int r133 = r110 | 2048;
            L20:
                r110 = r133;
            L26:
                r213 = r213;
                r102 = 4;
                r103 = 8;
                goto L6
            L12:
                r125 = r101.decodeLongElement(r100, 10);
                r133 = r110 | 1024;
                goto L20
            L13:
                r217 = r101.decodeLongElement(r100, 9);
                r133 = r110 | 512;
                goto L20
            L14:
                r110 = r110 | 256;
                r126 = (v) r101.decodeNullableSerializableElement(r100, r103, v.a.f348636a, r126);
                goto L26
            L15:
                r110 = r110 | 128;
                r127 = (s) r101.decodeNullableSerializableElement(r100, 7, s.a.f348615a, r127);
                goto L26
            L17:
                r129 = r101.decodeBooleanElement(r100, 6);
                r133 = r110 | 64;
                goto L20
            L18:
                r128 = r101.decodeBooleanElement(r100, 5);
                r133 = r110 | 32;
                goto L20
            L19:
                r216 = r101.decodeDoubleElement(r100, r102);
                r133 = r110 | 16;
                goto L20
            L25:
                r213 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r213);
                r110 = r110 | 1;
                goto L26
            L28:
                r117 = r213;
                r109 = r110;
                r211 = r130;
                r123 = r131;
                r120 = r215;
                r121 = r128;
                r122 = r129;
                r116 = r216;
                long r311 = r125;
                r118 = r126;
                r119 = r127;
                r124 = r214;
                r212 = r217;
                r210 = r311;
                goto L29
            }

            @Override // juc.n
            public final void serialize(muc.f r110, Object r111) {
                n r112 = (n) r111;
                Intrinsics.checkNotNullParameter(r110, "encoder");
                Intrinsics.checkNotNullParameter(r112, "value");
                g2 r100 = f348582b;
                muc.d r113 = r110.beginStructure(r100);
                b r101 = n.Companion;
                boolean r102 = false;
                if (r113.shouldEncodeElementDefault(r100, 0) == false) goto L6;
            L7:
                boolean r103 = true;
            L9:
                if (r103 == false) goto L12;
                r113.encodeNullableSerializableElement(r100, 0, v2.f520790a, r112.f348569a);
            L12:
                if (r113.shouldEncodeElementDefault(r100, 1) == false) goto L15;
            L16:
                boolean r104 = true;
            L18:
                if (r104 == false) goto L21;
                r113.encodeDoubleElement(r100, 1, r112.f348570b);
            L21:
                if (r113.shouldEncodeElementDefault(r100, 2) == false) goto L24;
            L25:
                boolean r105 = true;
            L27:
                if (r105 == false) goto L30;
                r113.encodeIntElement(r100, 2, r112.f348571c);
            L30:
                if (r113.shouldEncodeElementDefault(r100, 3) == false) goto L33;
            L34:
                boolean r106 = true;
            L36:
                if (r106 == false) goto L39;
                r113.encodeDoubleElement(r100, 3, r112.f348572d);
            L39:
                if (r113.shouldEncodeElementDefault(r100, 4) == false) goto L42;
            L43:
                boolean r107 = true;
            L45:
                if (r107 == false) goto L48;
                r113.encodeDoubleElement(r100, 4, r112.f348573e);
            L48:
                if (r113.shouldEncodeElementDefault(r100, 5) == false) goto L51;
            L52:
                boolean r108 = true;
            L54:
                if (r108 == false) goto L57;
                r113.encodeBooleanElement(r100, 5, r112.f348574f);
            L57:
                if (r113.shouldEncodeElementDefault(r100, 6) == false) goto L60;
            L61:
                boolean r109 = true;
            L63:
                if (r109 == false) goto L66;
                r113.encodeBooleanElement(r100, 6, r112.f348575g);
            L66:
                if (r113.shouldEncodeElementDefault(r100, 7) == false) goto L69;
            L70:
                boolean r114 = true;
            L72:
                if (r114 == false) goto L75;
                r113.encodeNullableSerializableElement(r100, 7, s.a.f348615a, r112.f348576h);
            L75:
                if (r113.shouldEncodeElementDefault(r100, 8) == false) goto L78;
            L79:
                boolean r115 = true;
            L81:
                if (r115 == false) goto L84;
                r113.encodeNullableSerializableElement(r100, 8, v.a.f348636a, r112.f348577i);
            L84:
                if (r113.shouldEncodeElementDefault(r100, 9) == false) goto L87;
            L88:
                boolean r116 = true;
            L90:
                if (r116 == false) goto L93;
                r113.encodeLongElement(r100, 9, r112.f348578j);
            L93:
                if (r113.shouldEncodeElementDefault(r100, 10) == false) goto L96;
            L97:
                boolean r117 = true;
            L99:
                if (r117 == false) goto L102;
                r113.encodeLongElement(r100, 10, r112.f348579k);
            L102:
                if (r113.shouldEncodeElementDefault(r100, 11) == false) goto L105;
            L106:
                r102 = true;
            L107:
                if (r102 == false) goto L109;
                r113.encodeIntElement(r100, 11, r112.f348580l);
            L109:
                r113.endStructure(r100);
                return;
            L105:
                if (r112.f348580l == Integer.MIN_VALUE) goto L107;
            L96:
                if (r112.f348579k != 60) goto L97;
                r117 = false;
                goto L99
            L87:
                if (r112.f348578j != 400) goto L88;
                r116 = false;
                goto L90
            L78:
                if (Intrinsics.areEqual(r112.f348577i, new v(0)) == false) goto L79;
                r115 = false;
                goto L81
            L69:
                if (Intrinsics.areEqual(r112.f348576h, new s(0)) == false) goto L70;
                r114 = false;
                goto L72
            L60:
                if (r112.f348575g != true) goto L61;
                r109 = false;
                goto L63
            L51:
                if (r112.f348574f != true) goto L52;
                r108 = false;
                goto L54
            L42:
                if (Double.compare(r112.f348573e, 60.0d) != 0) goto L43;
                r107 = false;
                goto L45
            L33:
                if (Double.compare(r112.f348572d, 2.0d) != 0) goto L34;
                r106 = false;
                goto L36
            L24:
                if (r112.f348571c != 1) goto L25;
                r105 = false;
                goto L27
            L15:
                if (Double.compare(r112.f348570b, 60.0d) != 0) goto L16;
                r104 = false;
                goto L18
            L6:
                if (Intrinsics.areEqual(r112.f348569a, "json") == false) goto L7;
                r103 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<n> serializer() {
                return a.f348581a;
            }
        }

        public n() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof n) == true) goto L8;
            return false;
        L8:
            n r101 = (n) r100;
            if (Intrinsics.areEqual(this.f348569a, r101.f348569a) == true) goto L12;
            return false;
        L12:
            if (Double.compare(this.f348570b, r101.f348570b) == 0) goto L15;
            return false;
        L15:
            if (this.f348571c == r101.f348571c) goto L18;
            return false;
        L18:
            if (Double.compare(this.f348572d, r101.f348572d) == 0) goto L21;
            return false;
        L21:
            if (Double.compare(this.f348573e, r101.f348573e) == 0) goto L24;
            return false;
        L24:
            if (this.f348574f == r101.f348574f) goto L27;
            return false;
        L27:
            if (this.f348575g == r101.f348575g) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f348576h, r101.f348576h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.f348577i, r101.f348577i) == true) goto L36;
            return false;
        L36:
            if (this.f348578j == r101.f348578j) goto L39;
            return false;
        L39:
            if (this.f348579k == r101.f348579k) goto L42;
            return false;
        L42:
            if (this.f348580l == r101.f348580l) goto L44;
            return false;
        L44:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f348569a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            long r103 = Double.doubleToLongBits(this.f348570b);
            int r104 = ((((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f348571c) * 31;
            long r105 = Double.doubleToLongBits(this.f348572d);
            int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
            long r107 = Double.doubleToLongBits(this.f348573e);
            int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
            int r109 = 1231;
            if (this.f348574f == false) goto L9;
            int r110 = 1231;
        L10:
            int r111 = (r108 + r110) * 31;
            if (this.f348575g == true) goto L14;
            r109 = 1237;
        L14:
            int r112 = (r111 + r109) * 31;
            s r113 = this.f348576h;
            if (r113 != null) goto L17;
            int r114 = 0;
        L18:
            int r115 = (r112 + r114) * 31;
            v r116 = this.f348577i;
            if (r116 == null) goto L22;
            r101 = r116.hashCode();
        L22:
            int r117 = (r115 + r101) * 31;
            long r118 = this.f348578j;
            int r119 = (r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31;
            long r120 = this.f348579k;
            return ((r119 + ((int) (r120 ^ (r120 >>> 32)))) * 31) + this.f348580l;
        L17:
            r114 = r113.hashCode();
            goto L18
        L9:
            r110 = 1237;
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "MechanismChunkConfig(binaryType=" + this.f348569a + ", timeoutSec=" + this.f348570b + ", maxRetryTimes=" + this.f348571c + ", retryIntervalSec=" + this.f348572d + ", timeoutSecPerChunk=" + this.f348573e + ", enableSseProtocolV2=" + this.f348574f + ", directSseSend=" + this.f348575g + ", recentConvFetcherConfig=" + this.f348576h + ", trackConfig=" + this.f348577i + ", chunkProtectTimeout=" + this.f348578j + ", timeoutWriter=" + this.f348579k + ", writeChunkSeqStart=" + this.f348580l + ')';
        }

        static {
            Companion = new b();
        }

        public n(int r100) {
            s r101 = new s(0);
            v r102 = new v(0);
            this.f348569a = "json";
            this.f348570b = 60.0d;
            this.f348571c = 1;
            this.f348572d = 2.0d;
            this.f348573e = 60.0d;
            this.f348574f = true;
            this.f348575g = true;
            this.f348576h = r101;
            this.f348577i = r102;
            this.f348578j = 400;
            this.f348579k = 60;
            this.f348580l = Integer.MIN_VALUE;
        }

        public n(int r110, String r111, double r112, int r113, double r114, double r115, boolean r116, boolean r210, s r211, v r212, long r213, long r214, int r215) {
            if ((r110 & 0) == 0) goto L5;
            b2.b(r110, 0, a.f348582b);
            throw null;
        L5:
            if ((r110 & 1) != 0) goto L7;
            String r100 = "json";
        L8:
            this.f348569a = r100;
            double r101 = 60.0d;
            if ((r110 & 2) != 0) goto L11;
            this.f348570b = 60.0d;
        L13:
            if ((r110 & 4) != 0) goto L15;
            this.f348571c = 1;
        L17:
            if ((r110 & 8) != 0) goto L19;
            double r102 = 2.0d;
        L20:
            this.f348572d = r102;
            if ((r110 & 16) == 0) goto L24;
            r101 = r115;
        L24:
            this.f348573e = r101;
            if ((r110 & 32) != 0) goto L27;
            this.f348574f = true;
        L29:
            if ((r110 & 64) != 0) goto L31;
            this.f348575g = true;
        L33:
            if ((r110 & 128) != 0) goto L35;
            s r103 = new s(0);
        L36:
            this.f348576h = r103;
            if ((r110 & 256) != 0) goto L39;
            v r104 = new v(0);
        L40:
            this.f348577i = r104;
            if ((r110 & 512) != 0) goto L43;
            long r105 = 400;
        L44:
            this.f348578j = r105;
            if ((r110 & 1024) != 0) goto L47;
            long r106 = 60;
        L48:
            this.f348579k = r106;
            if ((r110 & 2048) != 0) goto L51;
            int r107 = Integer.MIN_VALUE;
        L52:
            this.f348580l = r107;
            return;
        L51:
            r107 = r215;
            goto L52
        L47:
            r106 = r214;
            goto L48
        L43:
            r105 = r213;
            goto L44
        L39:
            r104 = r212;
            goto L40
        L35:
            r103 = r211;
            goto L36
        L31:
            this.f348575g = r210;
            goto L33
        L27:
            this.f348574f = r116;
            goto L29
        L19:
            r102 = r114;
            goto L20
        L15:
            this.f348571c = r113;
            goto L17
        L11:
            this.f348570b = r112;
            goto L13
        L7:
            r100 = r111;
            goto L8
        }
    }

    @Serializable
    public static final class o {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f348583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f348584b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f348585c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f348586d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f348587e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f348588f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f348589g;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<o> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348590a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348591b = null;

            public a() {
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                nuc.i r100 = nuc.i.f520705a;
                nuc.w0 r101 = nuc.w0.f520792a;
                return new juc.d[]{r100, r100, r100, r101, r101, r101, r101};
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348591b;
            }

            static {
                a r100 = new a();
                f348590a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowSettingsDelegate.MemoryCacheConfig", r100, 7);
                r101.j("enable", true);
                r101.j("async", true);
                r101.j("monitor", true);
                r101.j("size", true);
                r101.j("message_num", true);
                r101.j("load_coco", true);
                r101.j(VideoThumbInfo.KEY_INTERVAL, true);
                f348591b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r210) {
                Intrinsics.checkNotNullParameter(r210, "decoder");
                g2 r100 = f348591b;
                muc.c r101 = r210.beginStructure(r100);
                if (r101.decodeSequentially() == false) goto L5;
                boolean r102 = r101.decodeBooleanElement(r100, 0);
                boolean r103 = r101.decodeBooleanElement(r100, 1);
                boolean r104 = r101.decodeBooleanElement(r100, 2);
                int r105 = r101.decodeIntElement(r100, 3);
                int r106 = r101.decodeIntElement(r100, 4);
                int r107 = r101.decodeIntElement(r100, 5);
                boolean r108 = r102;
                boolean r110 = r104;
                int r111 = r106;
                boolean r112 = r103;
                int r113 = r105;
                int r114 = r101.decodeIntElement(r100, 6);
                int r115 = r107;
                int r109 = 127;
            L21:
                r101.endStructure(r100);
                return new o(r109, r108, r112, r110, r113, r111, r115, r114);
            L5:
                boolean r116 = false;
                boolean r117 = false;
                int r118 = 0;
                boolean r119 = false;
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
                r116 = r101.decodeBooleanElement(r100, 0);
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
                r117 = r101.decodeBooleanElement(r100, 2);
                r126 = r123 | 4;
                goto L17
            L16:
                r119 = r101.decodeBooleanElement(r100, 1);
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
                o r102 = (o) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                g2 r103 = f348591b;
                muc.d r104 = r100.beginStructure(r103);
                b r105 = o.Companion;
                boolean r106 = false;
                if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
            L7:
                boolean r107 = true;
            L9:
                if (r107 == false) goto L12;
                r104.encodeBooleanElement(r103, 0, r102.f348583a);
            L12:
                if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
            L16:
                boolean r108 = true;
            L18:
                if (r108 == false) goto L21;
                r104.encodeBooleanElement(r103, 1, r102.f348584b);
            L21:
                if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
            L25:
                boolean r109 = true;
            L27:
                if (r109 == false) goto L30;
                r104.encodeBooleanElement(r103, 2, r102.f348585c);
            L30:
                if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
            L34:
                boolean r110 = true;
            L36:
                if (r110 == false) goto L39;
                r104.encodeIntElement(r103, 3, r102.f348586d);
            L39:
                if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L42;
            L43:
                boolean r111 = true;
            L45:
                if (r111 == false) goto L48;
                r104.encodeIntElement(r103, 4, r102.f348587e);
            L48:
                if (r104.shouldEncodeElementDefault(r103, 5) == false) goto L51;
            L52:
                boolean r112 = true;
            L54:
                if (r112 == false) goto L57;
                r104.encodeIntElement(r103, 5, r102.f348588f);
            L57:
                if (r104.shouldEncodeElementDefault(r103, 6) == false) goto L60;
            L61:
                r106 = true;
            L62:
                if (r106 == false) goto L64;
                r104.encodeIntElement(r103, 6, r102.f348589g);
            L64:
                r104.endStructure(r103);
                return;
            L60:
                if (r102.f348589g == 20) goto L62;
            L51:
                if (r102.f348588f != 50) goto L52;
                r112 = false;
                goto L54
            L42:
                if (r102.f348587e != 50) goto L43;
                r111 = false;
                goto L45
            L33:
                if (r102.f348586d != 50) goto L34;
                r110 = false;
                goto L36
            L24:
                if (r102.f348585c != true) goto L25;
                r109 = false;
                goto L27
            L15:
                if (r102.f348584b != true) goto L16;
                r108 = false;
                goto L18
            L6:
                if (r102.f348583a != true) goto L7;
                r107 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<o> serializer() {
                return a.f348590a;
            }
        }

        public o() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof o) == true) goto L8;
            return false;
        L8:
            o r101 = (o) r100;
            if (this.f348583a == r101.f348583a) goto L12;
            return false;
        L12:
            if (this.f348584b == r101.f348584b) goto L15;
            return false;
        L15:
            if (this.f348585c == r101.f348585c) goto L18;
            return false;
        L18:
            if (this.f348586d == r101.f348586d) goto L21;
            return false;
        L21:
            if (this.f348587e == r101.f348587e) goto L24;
            return false;
        L24:
            if (this.f348588f == r101.f348588f) goto L27;
            return false;
        L27:
            if (this.f348589g == r101.f348589g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f348583a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f348584b == false) goto L9;
            int r103 = 1231;
        L10:
            int r104 = (r102 + r103) * 31;
            if (this.f348585c == true) goto L15;
            r100 = 1237;
        L15:
            return ((((((((r104 + r100) * 31) + this.f348586d) * 31) + this.f348587e) * 31) + this.f348588f) * 31) + this.f348589g;
        L9:
            r103 = 1237;
            goto L10
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "MemoryCacheConfig(enable=" + this.f348583a + ", async=" + this.f348584b + ", monitor=" + this.f348585c + ", size=" + this.f348586d + ", messageNum=" + this.f348587e + ", loadCoco=" + this.f348588f + ", interval=" + this.f348589g + ')';
        }

        static {
            Companion = new b();
        }

        public o(int r100) {
            this.f348583a = true;
            this.f348584b = true;
            this.f348585c = true;
            this.f348586d = 50;
            this.f348587e = 50;
            this.f348588f = 50;
            this.f348589g = 20;
        }

        public o(int r100, boolean r101, boolean r102, boolean r103, int r104, int r105, int r106, int r110) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348591b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            this.f348583a = true;
        L9:
            if ((r100 & 2) != 0) goto L11;
            this.f348584b = true;
        L13:
            if ((r100 & 4) != 0) goto L15;
            this.f348585c = true;
        L17:
            if ((r100 & 8) != 0) goto L19;
            this.f348586d = 50;
        L21:
            if ((r100 & 16) != 0) goto L23;
            this.f348587e = 50;
        L25:
            if ((r100 & 32) != 0) goto L27;
            this.f348588f = 50;
        L29:
            if ((r100 & 64) != 0) goto L31;
            this.f348589g = 20;
            return;
        L31:
            this.f348589g = r110;
            return;
        L27:
            this.f348588f = r106;
            goto L29
        L23:
            this.f348587e = r105;
            goto L25
        L19:
            this.f348586d = r104;
            goto L21
        L15:
            this.f348585c = r103;
            goto L17
        L11:
            this.f348584b = r102;
            goto L13
        L7:
            this.f348583a = r101;
            goto L9
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    @Serializable
    public static final class p {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f348592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f348593b;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<p> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348594a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348595b = null;

            public a() {
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                return new juc.d[]{nuc.i.f520705a, nuc.w0.f520792a};
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348595b;
            }

            static {
                a r100 = new a();
                f348594a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowSettingsDelegate.MessageConsistencyConfig", r100, 2);
                r101.j("monitor_msg_enable", true);
                r101.j("list_limit", true);
                f348595b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r110) {
                Intrinsics.checkNotNullParameter(r110, "decoder");
                g2 r100 = f348595b;
                muc.c r111 = r110.beginStructure(r100);
                if (r111.decodeSequentially() == false) goto L5;
                boolean r101 = r111.decodeBooleanElement(r100, 0);
                int r102 = r111.decodeIntElement(r100, 1);
                int r103 = 3;
            L17:
                r111.endStructure(r100);
                return new p(r103, r101, r102);
            L5:
                r101 = false;
                int r104 = 0;
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
                r104 = r111.decodeIntElement(r100, 1);
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
                p r102 = (p) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                g2 r103 = f348595b;
                muc.d r104 = r100.beginStructure(r103);
                b r105 = p.Companion;
                boolean r106 = false;
                if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
            L7:
                boolean r107 = true;
            L9:
                if (r107 == false) goto L12;
                r104.encodeBooleanElement(r103, 0, r102.f348592a);
            L12:
                if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
            L16:
                r106 = true;
            L17:
                if (r106 == false) goto L19;
                r104.encodeIntElement(r103, 1, r102.f348593b);
            L19:
                r104.endStructure(r103);
                return;
            L15:
                if (r102.f348593b == 20) goto L17;
            L6:
                if (r102.f348592a == true) goto L7;
                r107 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<p> serializer() {
                return a.f348594a;
            }
        }

        public p() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof p) == true) goto L8;
            return false;
        L8:
            p r101 = (p) r100;
            if (this.f348592a == r101.f348592a) goto L12;
            return false;
        L12:
            if (this.f348593b == r101.f348593b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f348592a == false) goto L5;
            int r100 = 1231;
        L7:
            return (r100 * 31) + this.f348593b;
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "MessageConsistencyConfig(monitorMsgEnable=" + this.f348592a + ", listLimit=" + this.f348593b + ')';
        }

        static {
            Companion = new b();
        }

        public p(int r100) {
            this.f348592a = false;
            this.f348593b = 20;
        }

        public p(int r100, boolean r101, int r102) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348595b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            this.f348592a = false;
        L9:
            if ((r100 & 2) != 0) goto L11;
            this.f348593b = 20;
            return;
        L11:
            this.f348593b = r102;
            return;
        L7:
            this.f348592a = r101;
            goto L9
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    @Serializable
    public static final class q {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f348596a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f348597b;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<q> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348598a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348599b = null;

            public a() {
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                nuc.w0 r100 = nuc.w0.f520792a;
                return new juc.d[]{r100, r100};
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348599b;
            }

            static {
                a r100 = new a();
                f348598a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowSettingsDelegate.MessageStreamPerfConfig", r100, 2);
                r101.j("lag_duration_threshold_ms", true);
                r101.j("hang_duration_threshold_ms", true);
                f348599b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r110) {
                Intrinsics.checkNotNullParameter(r110, "decoder");
                g2 r100 = f348599b;
                muc.c r111 = r110.beginStructure(r100);
                if (r111.decodeSequentially() == false) goto L5;
                int r101 = r111.decodeIntElement(r100, 0);
                int r102 = r111.decodeIntElement(r100, 1);
                int r103 = 3;
            L17:
                r111.endStructure(r100);
                return new q(r103, r101, r102);
            L5:
                r101 = 0;
                int r104 = 0;
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
                r101 = r111.decodeIntElement(r100, 0);
                r105 = r105 | 1;
                goto L6
            L10:
                if (r107 != 1) goto L13;
                r104 = r111.decodeIntElement(r100, 1);
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
                q r102 = (q) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                g2 r103 = f348599b;
                muc.d r104 = r100.beginStructure(r103);
                b r105 = q.Companion;
                boolean r106 = false;
                if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
            L7:
                boolean r107 = true;
            L9:
                if (r107 == false) goto L12;
                r104.encodeIntElement(r103, 0, r102.f348596a);
            L12:
                if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
            L16:
                r106 = true;
            L17:
                if (r106 == false) goto L19;
                r104.encodeIntElement(r103, 1, r102.f348597b);
            L19:
                r104.endStructure(r103);
                return;
            L15:
                if (r102.f348597b == 2000) goto L17;
            L6:
                if (r102.f348596a != 500) goto L7;
                r107 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<q> serializer() {
                return a.f348598a;
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
            if (this.f348596a == r101.f348596a) goto L12;
            return false;
        L12:
            if (this.f348597b == r101.f348597b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f348596a * 31) + this.f348597b;
        }

        public final String toString() {
            return "MessageStreamPerfConfig(lagDurationThresholdMs=" + this.f348596a + ", hangDurationThresholdMs=" + this.f348597b + ')';
        }

        static {
            Companion = new b();
        }

        public q(int r100) {
            this.f348596a = 500;
            this.f348597b = 2000;
        }

        public q(int r100, int r101, int r102) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348599b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            r101 = 500;
        L7:
            this.f348596a = r101;
            if ((r100 & 2) != 0) goto L10;
            this.f348597b = 2000;
            return;
        L10:
            this.f348597b = r102;
        }
    }

    @Serializable
    public static final class r {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f348600a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f348601b;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<r> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348602a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348603b = null;

            public a() {
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                return new juc.d[]{nuc.i.f520705a, kuc.a.d(v2.f520790a)};
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348603b;
            }

            static {
                a r100 = new a();
                f348602a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowSettingsDelegate.OmniDatabaseSettings", r100, 2);
                r101.j("enable_cpp_implementation", true);
                r101.j("db_path_version", true);
                f348603b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r110) {
                Intrinsics.checkNotNullParameter(r110, "decoder");
                g2 r100 = f348603b;
                muc.c r111 = r110.beginStructure(r100);
                if (r111.decodeSequentially() == false) goto L5;
                boolean r101 = r111.decodeBooleanElement(r100, 0);
                String r102 = (String) r111.decodeNullableSerializableElement(r100, 1, v2.f520790a, null);
                int r103 = 3;
            L17:
                r111.endStructure(r100);
                return new r(r103, r101, r102);
            L5:
                String r104 = null;
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
                r104 = (String) r111.decodeNullableSerializableElement(r100, 1, v2.f520790a, r104);
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
                r r102 = (r) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                g2 r103 = f348603b;
                muc.d r104 = r100.beginStructure(r103);
                b r105 = r.Companion;
                boolean r106 = false;
                if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
            L7:
                boolean r107 = true;
            L9:
                if (r107 == false) goto L12;
                r104.encodeBooleanElement(r103, 0, r102.f348600a);
            L12:
                if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
            L16:
                r106 = true;
            L17:
                if (r106 == false) goto L19;
                r104.encodeNullableSerializableElement(r103, 1, v2.f520790a, r102.f348601b);
            L19:
                r104.endStructure(r103);
                return;
            L15:
                if (r102.f348601b == null) goto L17;
            L6:
                if (r102.f348600a != true) goto L7;
                r107 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<r> serializer() {
                return a.f348602a;
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
            if (this.f348600a == r101.f348600a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f348601b, r101.f348601b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f348600a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            String r102 = this.f348601b;
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
            return "OmniDatabaseSettings(enableCppImplementation=" + this.f348600a + ", dbPathVersion=" + this.f348601b + ')';
        }

        static {
            Companion = new b();
        }

        public r(int r100) {
            this.f348600a = true;
            this.f348601b = null;
        }

        public r(int r100, boolean r101, String r102) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348603b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            r101 = true;
        L7:
            this.f348600a = r101;
            if ((r100 & 2) != 0) goto L10;
            this.f348601b = null;
            return;
        L10:
            this.f348601b = r102;
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    @Serializable
    public static final class s {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f348604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f348605b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f348606c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f348607d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f348608e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f348609f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f348610g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f348611h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f348612i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f348613j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f348614k;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<s> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348615a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348616b = null;

            public a() {
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348616b;
            }

            static {
                a r100 = new a();
                f348615a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowSettingsDelegate.RecentConvFetcherConfig", r100, 11);
                r101.j("first_page_size", true);
                r101.j("paged_size", true);
                r101.j("disable_paging", true);
                r101.j("recent_conv_version_code", true);
                r101.j("cache_duration_sec", true);
                r101.j("recent_conv_chain_api_version", true);
                r101.j("retry_delay_sec", true);
                r101.j("max_retry_time", true);
                r101.j("msg_count_per_conv", true);
                r101.j("re_pull_min_delay_time", true);
                r101.j("re_pull_max_delay_time", true);
                f348616b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                nuc.w0 r100 = nuc.w0.f520792a;
                return new juc.d[]{r100, r100, nuc.i.f520705a, kuc.a.d(v2.f520790a), r100, r100, r100, r100, r100, r100, r100};
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r210) {
                Intrinsics.checkNotNullParameter(r210, "decoder");
                g2 r100 = f348616b;
                muc.c r101 = r210.beginStructure(r100);
                int r102 = 4;
                int r103 = 0;
                if (r101.decodeSequentially() == false) goto L5;
                int r104 = r101.decodeIntElement(r100, 0);
                int r105 = r101.decodeIntElement(r100, 1);
                boolean r106 = r101.decodeBooleanElement(r100, 2);
                String r107 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, null);
                int r108 = r101.decodeIntElement(r100, 4);
                int r110 = r101.decodeIntElement(r100, 5);
                int r111 = r101.decodeIntElement(r100, 6);
                int r112 = r101.decodeIntElement(r100, 7);
                int r109 = r101.decodeIntElement(r100, 8);
                int r113 = r101.decodeIntElement(r100, 9);
                int r114 = r108;
                int r115 = r109;
                int r116 = r101.decodeIntElement(r100, 10);
                int r117 = r113;
                int r118 = r112;
                int r119 = r111;
                int r120 = r110;
                int r121 = r104;
                boolean r122 = r106;
                int r123 = r105;
                String r124 = r107;
                r103 = 2047;
            L27:
                r101.endStructure(r100);
                return new s(r103, r121, r123, r122, r124, r114, r120, r119, r118, r115, r117, r116);
            L5:
                String r125 = null;
                int r126 = 0;
                int r127 = 0;
                int r128 = 0;
                int r129 = 0;
                boolean r130 = false;
                int r131 = 0;
                int r132 = 0;
                int r211 = 0;
                int r212 = 0;
                int r213 = 0;
                boolean r214 = true;
            L6:
                if (r214 == false) goto L26;
                int r133 = r101.decodeElementIndex(r100);
                switch(r133) {
                    case -1: goto L25;
                    case 0: goto L23;
                    case 1: goto L22;
                    case 2: goto L21;
                    case 3: goto L19;
                    case 4: goto L17;
                    case 5: goto L16;
                    case 6: goto L15;
                    case 7: goto L14;
                    case 8: goto L13;
                    case 9: goto L12;
                    case 10: goto L11;
                    default: goto L10;
                };
            L10:
                throw new UnknownFieldException(r133);
            L21:
                r130 = r101.decodeBooleanElement(r100, 2);
                r103 = r103 | 4;
                goto L6
            L22:
                r131 = r101.decodeIntElement(r100, 1);
                r103 = r103 | 2;
                int r215 = r126;
            L24:
                r126 = r215;
                r102 = 4;
                goto L6
            L23:
                r215 = r101.decodeIntElement(r100, 0);
                r103 = r103 | 1;
                goto L24
            L25:
                r102 = 4;
                r214 = false;
                goto L6
            L11:
                r129 = r101.decodeIntElement(r100, 10);
                int r134 = r103 | 1024;
            L18:
                r103 = r134;
                goto L6
            L12:
                r132 = r101.decodeIntElement(r100, 9);
                r134 = r103 | 512;
                goto L18
            L13:
                r128 = r101.decodeIntElement(r100, 8);
                r134 = r103 | 256;
                goto L18
            L14:
                r211 = r101.decodeIntElement(r100, 7);
                r134 = r103 | 128;
                goto L18
            L15:
                r212 = r101.decodeIntElement(r100, 6);
                r134 = r103 | 64;
                goto L18
            L16:
                r213 = r101.decodeIntElement(r100, 5);
                r134 = r103 | 32;
                goto L18
            L17:
                r127 = r101.decodeIntElement(r100, r102);
                r134 = r103 | 16;
                goto L18
            L19:
                r103 = r103 | 8;
                r125 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r125);
                goto L6
            L26:
                r121 = r126;
                r124 = r125;
                r114 = r127;
                r122 = r130;
                r123 = r131;
                r117 = r132;
                r120 = r213;
                r115 = r128;
                r116 = r129;
                r118 = r211;
                r119 = r212;
                goto L27
            }

            @Override // juc.n
            public final void serialize(muc.f r100, Object r110) {
                s r111 = (s) r110;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r111, "value");
                g2 r101 = f348616b;
                muc.d r102 = r100.beginStructure(r101);
                b r103 = s.Companion;
                boolean r104 = false;
                if (r102.shouldEncodeElementDefault(r101, 0) == false) goto L6;
            L7:
                boolean r105 = true;
            L9:
                if (r105 == false) goto L12;
                r102.encodeIntElement(r101, 0, r111.f348604a);
            L12:
                if (r102.shouldEncodeElementDefault(r101, 1) == false) goto L15;
            L16:
                boolean r106 = true;
            L18:
                if (r106 == false) goto L21;
                r102.encodeIntElement(r101, 1, r111.f348605b);
            L21:
                if (r102.shouldEncodeElementDefault(r101, 2) == false) goto L24;
            L25:
                boolean r107 = true;
            L27:
                if (r107 == false) goto L30;
                r102.encodeBooleanElement(r101, 2, r111.f348606c);
            L30:
                if (r102.shouldEncodeElementDefault(r101, 3) == false) goto L33;
            L34:
                boolean r108 = true;
            L36:
                if (r108 == false) goto L39;
                r102.encodeNullableSerializableElement(r101, 3, v2.f520790a, r111.f348607d);
            L39:
                if (r102.shouldEncodeElementDefault(r101, 4) == false) goto L42;
            L43:
                boolean r109 = true;
            L45:
                if (r109 == false) goto L48;
                r102.encodeIntElement(r101, 4, r111.f348608e);
            L48:
                if (r102.shouldEncodeElementDefault(r101, 5) == false) goto L51;
            L52:
                boolean r112 = true;
            L54:
                if (r112 == false) goto L57;
                r102.encodeIntElement(r101, 5, r111.f348609f);
            L57:
                if (r102.shouldEncodeElementDefault(r101, 6) == false) goto L60;
            L61:
                boolean r113 = true;
            L63:
                if (r113 == false) goto L66;
                r102.encodeIntElement(r101, 6, r111.f348610g);
            L66:
                if (r102.shouldEncodeElementDefault(r101, 7) == false) goto L69;
            L70:
                boolean r114 = true;
            L72:
                if (r114 == false) goto L75;
                r102.encodeIntElement(r101, 7, r111.f348611h);
            L75:
                if (r102.shouldEncodeElementDefault(r101, 8) == false) goto L78;
            L79:
                boolean r115 = true;
            L81:
                if (r115 == false) goto L84;
                r102.encodeIntElement(r101, 8, r111.f348612i);
            L84:
                if (r102.shouldEncodeElementDefault(r101, 9) == false) goto L87;
            L88:
                boolean r116 = true;
            L90:
                if (r116 == false) goto L93;
                r102.encodeIntElement(r101, 9, r111.f348613j);
            L93:
                if (r102.shouldEncodeElementDefault(r101, 10) == false) goto L96;
            L97:
                r104 = true;
            L98:
                if (r104 == false) goto L100;
                r102.encodeIntElement(r101, 10, r111.f348614k);
            L100:
                r102.endStructure(r101);
                return;
            L96:
                if (r111.f348614k == 3600) goto L98;
            L87:
                if (r111.f348613j != 180) goto L88;
                r116 = false;
                goto L90
            L78:
                if (r111.f348612i != 5) goto L79;
                r115 = false;
                goto L81
            L69:
                if (r111.f348611h != 1) goto L70;
                r114 = false;
                goto L72
            L60:
                if (r111.f348610g != 3) goto L61;
                r113 = false;
                goto L63
            L51:
                if (r111.f348609f != 1) goto L52;
                r112 = false;
                goto L54
            L42:
                if (r111.f348608e != 5) goto L43;
                r109 = false;
                goto L45
            L33:
                if (Intrinsics.areEqual(r111.f348607d, "0") == false) goto L34;
                r108 = false;
                goto L36
            L24:
                if (r111.f348606c == true) goto L25;
                r107 = false;
                goto L27
            L15:
                if (r111.f348605b != 10) goto L16;
                r106 = false;
                goto L18
            L6:
                if (r111.f348604a != 10) goto L7;
                r105 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<s> serializer() {
                return a.f348615a;
            }
        }

        public s() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof s) == true) goto L8;
            return false;
        L8:
            s r101 = (s) r100;
            if (this.f348604a == r101.f348604a) goto L12;
            return false;
        L12:
            if (this.f348605b == r101.f348605b) goto L15;
            return false;
        L15:
            if (this.f348606c == r101.f348606c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f348607d, r101.f348607d) == true) goto L21;
            return false;
        L21:
            if (this.f348608e == r101.f348608e) goto L24;
            return false;
        L24:
            if (this.f348609f == r101.f348609f) goto L27;
            return false;
        L27:
            if (this.f348610g == r101.f348610g) goto L30;
            return false;
        L30:
            if (this.f348611h == r101.f348611h) goto L33;
            return false;
        L33:
            if (this.f348612i == r101.f348612i) goto L36;
            return false;
        L36:
            if (this.f348613j == r101.f348613j) goto L39;
            return false;
        L39:
            if (this.f348614k == r101.f348614k) goto L41;
            return false;
        L41:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f348604a * 31) + this.f348605b) * 31;
            if (this.f348606c == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = (r100 + r101) * 31;
            String r103 = this.f348607d;
            if (r103 != null) goto L9;
            int r104 = 0;
        L11:
            return ((((((((((((((r102 + r104) * 31) + this.f348608e) * 31) + this.f348609f) * 31) + this.f348610g) * 31) + this.f348611h) * 31) + this.f348612i) * 31) + this.f348613j) * 31) + this.f348614k;
        L9:
            r104 = r103.hashCode();
            goto L11
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "RecentConvFetcherConfig(firstPageSize=" + this.f348604a + ", pageSize=" + this.f348605b + ", disablePaging=" + this.f348606c + ", recentVersionCode=" + this.f348607d + ", throttleTime=" + this.f348608e + ", apiVersion=" + this.f348609f + ", retryDelaySec=" + this.f348610g + ", maxRetryTime=" + this.f348611h + ", messageCountPerConv=" + this.f348612i + ", rePullMinDelayTime=" + this.f348613j + ", rePullMaxDelayTime=" + this.f348614k + ')';
        }

        static {
            Companion = new b();
        }

        public s(int r100) {
            this.f348604a = 10;
            this.f348605b = 10;
            this.f348606c = false;
            this.f348607d = "0";
            this.f348608e = 5;
            this.f348609f = 1;
            this.f348610g = 3;
            this.f348611h = 1;
            this.f348612i = 5;
            this.f348613j = 180;
            this.f348614k = AnnouncementViewModel.HOUR_DURATION;
        }

        public s(int r100, int r101, int r102, boolean r103, String r104, int r105, int r110, int r111, int r112, int r113, int r114, int r115) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348616b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            this.f348604a = 10;
        L9:
            if ((r100 & 2) != 0) goto L11;
            this.f348605b = 10;
        L13:
            if ((r100 & 4) != 0) goto L15;
            this.f348606c = false;
        L17:
            if ((r100 & 8) != 0) goto L19;
            this.f348607d = "0";
        L21:
            if ((r100 & 16) != 0) goto L23;
            this.f348608e = 5;
        L25:
            if ((r100 & 32) != 0) goto L27;
            this.f348609f = 1;
        L29:
            if ((r100 & 64) != 0) goto L31;
            this.f348610g = 3;
        L33:
            if ((r100 & 128) != 0) goto L35;
            this.f348611h = 1;
        L37:
            if ((r100 & 256) != 0) goto L39;
            this.f348612i = 5;
        L41:
            if ((r100 & 512) != 0) goto L43;
            this.f348613j = 180;
        L45:
            if ((r100 & 1024) != 0) goto L47;
            this.f348614k = AnnouncementViewModel.HOUR_DURATION;
            return;
        L47:
            this.f348614k = r115;
            return;
        L43:
            this.f348613j = r114;
            goto L45
        L39:
            this.f348612i = r113;
            goto L41
        L35:
            this.f348611h = r112;
            goto L37
        L31:
            this.f348610g = r111;
            goto L33
        L27:
            this.f348609f = r110;
            goto L29
        L23:
            this.f348608e = r105;
            goto L25
        L19:
            this.f348607d = r104;
            goto L21
        L15:
            this.f348606c = r103;
            goto L17
        L11:
            this.f348605b = r102;
            goto L13
        L7:
            this.f348604a = r101;
            goto L9
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    @Serializable
    public static final class t {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f348617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double f348618b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f348619c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f348620d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Integer f348621e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f348622f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f348623g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f348624h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f348625i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final double f348626j;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<t> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348627a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348628b = null;

            public a() {
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348628b;
            }

            static {
                a r100 = new a();
                f348627a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowSettingsDelegate.StreamSmoothConfig", r100, 10);
                r101.j("flow_stream_smooth_enable", true);
                r101.j("flow_stream_acceleration", true);
                r101.j("flow_stream_min_interval", true);
                r101.j("flow_stream_max_interval", true);
                r101.j("flow_stream_block_interval", true);
                r101.j("flow_stream_default_interval", true);
                r101.j("flow_stream_balance_distance", true);
                r101.j("flow_stream_low_water_deceleration_enable", true);
                r101.j("flow_stream_low_water_step_bytes", true);
                r101.j("flow_stream_low_water_delay_floor_ratio", true);
                f348628b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                nuc.i r100 = nuc.i.f520705a;
                nuc.b0 r101 = nuc.b0.f520644a;
                nuc.w0 r102 = nuc.w0.f520792a;
                return new juc.d[]{r100, r101, r102, r102, kuc.a.d(r102), r102, r102, r100, r102, r101};
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r210) {
                Intrinsics.checkNotNullParameter(r210, "decoder");
                g2 r100 = f348628b;
                muc.c r101 = r210.beginStructure(r100);
                int r102 = 0;
                if (r101.decodeSequentially() == false) goto L5;
                boolean r103 = r101.decodeBooleanElement(r100, 0);
                double r104 = r101.decodeDoubleElement(r100, 1);
                int r105 = r101.decodeIntElement(r100, 2);
                int r110 = r101.decodeIntElement(r100, 3);
                Integer r106 = (Integer) r101.decodeNullableSerializableElement(r100, 4, nuc.w0.f520792a, null);
                int r111 = r101.decodeIntElement(r100, 5);
                int r112 = r101.decodeIntElement(r100, 6);
                boolean r107 = r101.decodeBooleanElement(r100, 7);
                int r113 = r101.decodeIntElement(r100, 8);
                double r108 = r104;
                double r114 = r101.decodeDoubleElement(r100, 9);
                int r109 = 1023;
                boolean r115 = r103;
                boolean r116 = r107;
                int r117 = r112;
                int r118 = r110;
                int r119 = r105;
                int r120 = r111;
                Integer r121 = r106;
            L28:
                r101.endStructure(r100);
                return new t(r109, r115, r108, r119, r118, r121, r120, r117, r116, r113, r114);
            L5:
                Integer r122 = null;
                double r211 = 0.0d;
                boolean r123 = false;
                int r124 = 0;
                boolean r125 = false;
                int r126 = 0;
                int r127 = 0;
                int r212 = 0;
                boolean r213 = true;
                double r128 = 0.0d;
                int r129 = 0;
            L6:
                if (r213 == false) goto L27;
                int r130 = r101.decodeElementIndex(r100);
                switch(r130) {
                    case -1: goto L25;
                    case 0: goto L22;
                    case 1: goto L21;
                    case 2: goto L19;
                    case 3: goto L17;
                    case 4: goto L16;
                    case 5: goto L15;
                    case 6: goto L14;
                    case 7: goto L13;
                    case 8: goto L12;
                    case 9: goto L11;
                    default: goto L10;
                };
            L11:
                r211 = r101.decodeDoubleElement(r100, 9);
                int r131 = r102 | 512;
            L18:
                r102 = r131;
            L26:
                r213 = r213;
                goto L6
            L12:
                r129 = r101.decodeIntElement(r100, 8);
                r131 = r102 | 256;
                goto L18
            L13:
                r125 = r101.decodeBooleanElement(r100, 7);
                r131 = r102 | 128;
                goto L18
            L14:
                r126 = r101.decodeIntElement(r100, 6);
                r131 = r102 | 64;
                goto L18
            L15:
                r127 = r101.decodeIntElement(r100, 5);
                r131 = r102 | 32;
                goto L18
            L16:
                r122 = (Integer) r101.decodeNullableSerializableElement(r100, 4, nuc.w0.f520792a, r122);
                r131 = r102 | 16;
                goto L18
            L17:
                r212 = r101.decodeIntElement(r100, 3);
                r131 = r102 | 8;
                goto L18
            L19:
                r124 = r101.decodeIntElement(r100, 2);
                r102 = r102 | 4;
                goto L26
            L21:
                r102 = r102 | 2;
                r128 = r101.decodeDoubleElement(r100, 1);
                goto L26
            L22:
                r102 = r102 | 1;
                r123 = r101.decodeBooleanElement(r100, 0);
                goto L26
            L25:
                r213 = false;
                goto L26
            L10:
                throw new UnknownFieldException(r130);
            L27:
                r121 = r122;
                r109 = r102;
                r119 = r124;
                r108 = r128;
                r117 = r126;
                r120 = r127;
                r118 = r212;
                r115 = r123;
                r113 = r129;
                r116 = r125;
                r114 = r211;
                goto L28
            }

            @Override // juc.n
            public final void serialize(muc.f r100, Object r110) {
                t r111 = (t) r110;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r111, "value");
                g2 r101 = f348628b;
                muc.d r102 = r100.beginStructure(r101);
                b r103 = t.Companion;
                boolean r104 = false;
                if (r102.shouldEncodeElementDefault(r101, 0) == false) goto L6;
            L7:
                boolean r105 = true;
            L9:
                if (r105 == false) goto L12;
                r102.encodeBooleanElement(r101, 0, r111.f348617a);
            L12:
                if (r102.shouldEncodeElementDefault(r101, 1) == false) goto L15;
            L16:
                boolean r106 = true;
            L18:
                if (r106 == false) goto L21;
                r102.encodeDoubleElement(r101, 1, r111.f348618b);
            L21:
                if (r102.shouldEncodeElementDefault(r101, 2) == false) goto L24;
            L25:
                boolean r107 = true;
            L27:
                if (r107 == false) goto L30;
                r102.encodeIntElement(r101, 2, r111.f348619c);
            L30:
                if (r102.shouldEncodeElementDefault(r101, 3) == false) goto L33;
            L34:
                boolean r108 = true;
            L36:
                if (r108 == false) goto L39;
                r102.encodeIntElement(r101, 3, r111.f348620d);
            L39:
                if (r102.shouldEncodeElementDefault(r101, 4) == false) goto L42;
            L43:
                boolean r109 = true;
            L45:
                if (r109 == false) goto L48;
                r102.encodeNullableSerializableElement(r101, 4, nuc.w0.f520792a, r111.f348621e);
            L48:
                if (r102.shouldEncodeElementDefault(r101, 5) == false) goto L51;
            L52:
                boolean r112 = true;
            L54:
                if (r112 == false) goto L57;
                r102.encodeIntElement(r101, 5, r111.f348622f);
            L57:
                if (r102.shouldEncodeElementDefault(r101, 6) == false) goto L60;
            L61:
                boolean r113 = true;
            L63:
                if (r113 == false) goto L66;
                r102.encodeIntElement(r101, 6, r111.f348623g);
            L66:
                if (r102.shouldEncodeElementDefault(r101, 7) == false) goto L69;
            L70:
                boolean r114 = true;
            L72:
                if (r114 == false) goto L75;
                r102.encodeBooleanElement(r101, 7, r111.f348624h);
            L75:
                if (r102.shouldEncodeElementDefault(r101, 8) == false) goto L78;
            L79:
                boolean r115 = true;
            L81:
                if (r115 == false) goto L84;
                r102.encodeIntElement(r101, 8, r111.f348625i);
            L84:
                if (r102.shouldEncodeElementDefault(r101, 9) == false) goto L87;
            L88:
                r104 = true;
            L89:
                if (r104 == false) goto L91;
                r102.encodeDoubleElement(r101, 9, r111.f348626j);
            L91:
                r102.endStructure(r101);
                return;
            L87:
                if (Double.compare(r111.f348626j, 0.6d) == 0) goto L89;
            L78:
                if (r111.f348625i != 3) goto L79;
                r115 = false;
                goto L81
            L69:
                if (r111.f348624h == true) goto L70;
                r114 = false;
                goto L72
            L60:
                if (r111.f348623g != 20) goto L61;
                r113 = false;
                goto L63
            L51:
                if (r111.f348622f != 50) goto L52;
                r112 = false;
                goto L54
            L42:
                if (r111.f348621e != null) goto L43;
                r109 = false;
                goto L45
            L33:
                if (r111.f348620d != 70) goto L34;
                r108 = false;
                goto L36
            L24:
                if (r111.f348619c != 5) goto L25;
                r107 = false;
                goto L27
            L15:
                if (Double.compare(r111.f348618b, 2.0E-6d) != 0) goto L16;
                r106 = false;
                goto L18
            L6:
                if (r111.f348617a == true) goto L7;
                r105 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<t> serializer() {
                return a.f348627a;
            }
        }

        public t() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof t) == true) goto L8;
            return false;
        L8:
            t r101 = (t) r100;
            if (this.f348617a == r101.f348617a) goto L12;
            return false;
        L12:
            if (Double.compare(this.f348618b, r101.f348618b) == 0) goto L15;
            return false;
        L15:
            if (this.f348619c == r101.f348619c) goto L18;
            return false;
        L18:
            if (this.f348620d == r101.f348620d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f348621e, r101.f348621e) == true) goto L24;
            return false;
        L24:
            if (this.f348622f == r101.f348622f) goto L27;
            return false;
        L27:
            if (this.f348623g == r101.f348623g) goto L30;
            return false;
        L30:
            if (this.f348624h == r101.f348624h) goto L33;
            return false;
        L33:
            if (this.f348625i == r101.f348625i) goto L36;
            return false;
        L36:
            if (Double.compare(this.f348626j, r101.f348626j) == 0) goto L38;
            return false;
        L38:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f348617a == false) goto L5;
            int r101 = 1231;
        L6:
            long r102 = Double.doubleToLongBits(this.f348618b);
            int r103 = ((((((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f348619c) * 31) + this.f348620d) * 31;
            Integer r104 = this.f348621e;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (((((r103 + r105) * 31) + this.f348622f) * 31) + this.f348623g) * 31;
            if (this.f348624h == true) goto L14;
            r100 = 1237;
        L14:
            int r107 = (((r106 + r100) * 31) + this.f348625i) * 31;
            long r108 = Double.doubleToLongBits(this.f348626j);
            return r107 + ((int) (r108 ^ (r108 >>> 32)));
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "StreamSmoothConfig(enable=" + this.f348617a + ", k=" + this.f348618b + ", minInterval=" + this.f348619c + ", maxInterval=" + this.f348620d + ", blockInterval=" + this.f348621e + ", defaultInterval=" + this.f348622f + ", balanceDistance=" + this.f348623g + ", lowWaterDecelerationEnable=" + this.f348624h + ", lowWaterStepBytes=" + this.f348625i + ", lowWaterDelayFloorRatio=" + this.f348626j + ')';
        }

        static {
            Companion = new b();
        }

        public t(int r100) {
            this.f348617a = false;
            this.f348618b = 2.0E-6d;
            this.f348619c = 5;
            this.f348620d = 70;
            this.f348621e = null;
            this.f348622f = 50;
            this.f348623g = 20;
            this.f348624h = false;
            this.f348625i = 3;
            this.f348626j = 0.6d;
        }

        public t(int r100, boolean r101, double r110, int r111, int r112, Integer r113, int r114, int r115, boolean r116, int r117, double r118) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348628b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            this.f348617a = false;
        L9:
            if ((r100 & 2) != 0) goto L11;
            double r102 = 2.0E-6d;
        L12:
            this.f348618b = r102;
            if ((r100 & 4) != 0) goto L15;
            int r103 = 5;
        L16:
            this.f348619c = r103;
            if ((r100 & 8) != 0) goto L19;
            int r104 = 70;
        L20:
            this.f348620d = r104;
            if ((r100 & 16) != 0) goto L23;
            this.f348621e = null;
        L25:
            if ((r100 & 32) != 0) goto L27;
            int r105 = 50;
        L28:
            this.f348622f = r105;
            if ((r100 & 64) != 0) goto L31;
            int r106 = 20;
        L32:
            this.f348623g = r106;
            if ((r100 & 128) != 0) goto L35;
            this.f348624h = false;
        L37:
            if ((r100 & 256) != 0) goto L39;
            int r107 = 3;
        L40:
            this.f348625i = r107;
            if ((r100 & 512) != 0) goto L43;
            double r108 = 0.6d;
        L44:
            this.f348626j = r108;
            return;
        L43:
            r108 = r118;
            goto L44
        L39:
            r107 = r117;
            goto L40
        L35:
            this.f348624h = r116;
            goto L37
        L31:
            r106 = r115;
            goto L32
        L27:
            r105 = r114;
            goto L28
        L23:
            this.f348621e = r113;
            goto L25
        L19:
            r104 = r112;
            goto L20
        L15:
            r103 = r111;
            goto L16
        L11:
            r102 = r110;
            goto L12
        L7:
            this.f348617a = r101;
            goto L9
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    @Serializable
    public static final class u {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f348629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f348630b;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<u> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348631a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348632b = null;

            public a() {
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                return new juc.d[]{nuc.b0.f520644a, nuc.w0.f520792a};
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348632b;
            }

            static {
                a r100 = new a();
                f348631a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowSettingsDelegate.TextTypingConfig", r100, 2);
                r101.j("message_queue_time_interval", true);
                r101.j("message_split_en_char_count", true);
                f348632b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r110) {
                Intrinsics.checkNotNullParameter(r110, "decoder");
                g2 r100 = f348632b;
                muc.c r111 = r110.beginStructure(r100);
                if (r111.decodeSequentially() == false) goto L5;
                double r101 = r111.decodeDoubleElement(r100, 0);
                int r102 = r111.decodeIntElement(r100, 1);
                int r103 = 3;
            L17:
                r111.endStructure(r100);
                return new u(r103, r101, r102);
            L5:
                double r104 = 0.0d;
                r102 = 0;
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
                r104 = r111.decodeDoubleElement(r100, 0);
                r105 = r105 | 1;
                goto L6
            L10:
                if (r107 != 1) goto L13;
                r102 = r111.decodeIntElement(r100, 1);
                r105 = r105 | 2;
                goto L6
            L13:
                throw new UnknownFieldException(r107);
            L16:
                r103 = r105;
                r101 = r104;
                goto L17
            }

            @Override // juc.n
            public final void serialize(muc.f r100, Object r110) {
                u r111 = (u) r110;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r111, "value");
                g2 r101 = f348632b;
                muc.d r102 = r100.beginStructure(r101);
                b r103 = u.Companion;
                boolean r104 = false;
                if (r102.shouldEncodeElementDefault(r101, 0) == false) goto L6;
            L7:
                boolean r105 = true;
            L9:
                if (r105 == false) goto L12;
                r102.encodeDoubleElement(r101, 0, r111.f348629a);
            L12:
                if (r102.shouldEncodeElementDefault(r101, 1) == false) goto L15;
            L16:
                r104 = true;
            L17:
                if (r104 == false) goto L19;
                r102.encodeIntElement(r101, 1, r111.f348630b);
            L19:
                r102.endStructure(r101);
                return;
            L15:
                if (r111.f348630b == 3) goto L17;
            L6:
                if (Double.compare(r111.f348629a, 0.05d) != 0) goto L7;
                r105 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<u> serializer() {
                return a.f348631a;
            }
        }

        public u() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof u) == true) goto L8;
            return false;
        L8:
            u r101 = (u) r100;
            if (Double.compare(this.f348629a, r101.f348629a) == 0) goto L12;
            return false;
        L12:
            if (this.f348630b == r101.f348630b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r100 = Double.doubleToLongBits(this.f348629a);
            return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f348630b;
        }

        public final String toString() {
            return "TextTypingConfig(typingInterval=" + this.f348629a + ", splitByteCount=" + this.f348630b + ')';
        }

        static {
            Companion = new b();
        }

        public u(int r100) {
            this.f348629a = 0.05d;
            this.f348630b = 3;
        }

        public u(int r100, double r101, int r102) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348632b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            r101 = 0.05d;
        L7:
            this.f348629a = r101;
            if ((r100 & 2) != 0) goto L10;
            this.f348630b = 3;
            return;
        L10:
            this.f348630b = r102;
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    @Serializable
    public static final class v {
        public static final b Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f348633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f348634b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f348635c;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        public /* synthetic */ class a implements nuc.m0<v> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f348636a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final g2 f348637b = null;

            public a() {
            }

            @Override // nuc.m0
            public final juc.d<?>[] childSerializers() {
                nuc.w0 r100 = nuc.w0.f520792a;
                return new juc.d[]{nuc.i.f520705a, r100, r100};
            }

            @Override // juc.d, juc.n, juc.c
            public final luc.f getDescriptor() {
                return f348637b;
            }

            static {
                a r100 = new a();
                f348636a = r100;
                g2 r101 = new g2("com.larus.im.internal.delegate.FlowSettingsDelegate.TrackConfig", r100, 3);
                r101.j("extremum_status_enable", true);
                r101.j("maximum", true);
                r101.j("minimum", true);
                f348637b = r101;
            }

            @Override // nuc.m0
            public final juc.d<?>[] typeParametersSerializers() {
                return i2.f520710a;
            }

            @Override // juc.c
            public final Object deserialize(muc.e r110) {
                Intrinsics.checkNotNullParameter(r110, "decoder");
                g2 r100 = f348637b;
                muc.c r111 = r110.beginStructure(r100);
                if (r111.decodeSequentially() == false) goto L5;
                boolean r101 = r111.decodeBooleanElement(r100, 0);
                int r102 = r111.decodeIntElement(r100, 1);
                int r103 = r111.decodeIntElement(r100, 2);
                int r104 = 7;
            L19:
                r111.endStructure(r100);
                return new v(r104, r101, r102, r103);
            L5:
                r101 = false;
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
                r101 = r111.decodeBooleanElement(r100, 0);
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
                v r102 = (v) r101;
                Intrinsics.checkNotNullParameter(r100, "encoder");
                Intrinsics.checkNotNullParameter(r102, "value");
                g2 r103 = f348637b;
                muc.d r104 = r100.beginStructure(r103);
                b r105 = v.Companion;
                boolean r106 = false;
                if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
            L7:
                boolean r107 = true;
            L9:
                if (r107 == false) goto L12;
                r104.encodeBooleanElement(r103, 0, r102.f348633a);
            L12:
                if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
            L16:
                boolean r108 = true;
            L18:
                if (r108 == false) goto L21;
                r104.encodeIntElement(r103, 1, r102.f348634b);
            L21:
                if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
            L25:
                r106 = true;
            L26:
                if (r106 == false) goto L28;
                r104.encodeIntElement(r103, 2, r102.f348635c);
            L28:
                r104.endStructure(r103);
                return;
            L24:
                if (r102.f348635c == 0) goto L26;
            L15:
                if (r102.f348634b != 300) goto L16;
                r108 = false;
                goto L18
            L6:
                if (r102.f348633a != true) goto L7;
                r107 = false;
                goto L9
            }
        }

        public static final class b {
            public b() {
            }

            public final juc.d<v> serializer() {
                return a.f348636a;
            }
        }

        public v() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof v) == true) goto L8;
            return false;
        L8:
            v r101 = (v) r100;
            if (this.f348633a == r101.f348633a) goto L12;
            return false;
        L12:
            if (this.f348634b == r101.f348634b) goto L15;
            return false;
        L15:
            if (this.f348635c == r101.f348635c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.f348633a == false) goto L5;
            int r100 = 1231;
        L7:
            return (((r100 * 31) + this.f348634b) * 31) + this.f348635c;
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "TrackConfig(extremumStatusEnable=" + this.f348633a + ", maximum=" + this.f348634b + ", minimum=" + this.f348635c + ')';
        }

        static {
            Companion = new b();
        }

        public v(int r100) {
            this.f348633a = true;
            this.f348634b = 300;
            this.f348635c = 0;
        }

        public v(int r100, boolean r101, int r102, int r103) {
            if ((r100 & 0) == 0) goto L5;
            b2.b(r100, 0, a.f348637b);
            throw null;
        L5:
            if ((r100 & 1) != 0) goto L7;
            r101 = true;
        L7:
            this.f348633a = r101;
            if ((r100 & 2) != 0) goto L10;
            this.f348634b = 300;
        L12:
            if ((r100 & 4) != 0) goto L14;
            this.f348635c = 0;
            return;
        L14:
            this.f348635c = r103;
            return;
        L10:
            this.f348634b = r102;
            goto L12
        }
    }

    static {
        f348459a = LazyKt.lazy(new v0());
        f348467i = LazyKt.lazy(new w0());
        f348470l = new Object();
        f348471m = LazyKt.lazy(new x0());
    }

    public static boolean a() {
        Boolean r100 = f348463e;
        if (r100 != null) goto L5;
        Boolean r101 = f348463e;
        if (r101 == null) goto L21;
        return r101.booleanValue();
    L21:
        ouc.i r102 = (ouc.i) i().e("flow_im_sdk_mechanism_config", new ouc.d0(MapsKt.emptyMap()), true).get("enable_callback_improve");     // Catch: Throwable -> L18
        if (r102 == null) goto L15;
        Boolean r103 = ouc.k.f(ouc.k.o(r102));     // Catch: Throwable -> L18
        if (r103 == null) goto L15;
        boolean r104 = r103.booleanValue();     // Catch: Throwable -> L18
    L16:
        com.larus.im.internal.delegate.a.f348188b.i("FlowSettingsDelegate", "enableCallbackImprove(): " + r104);     // Catch: Throwable -> L18
        f348463e = Boolean.valueOf(r104);     // Catch: Throwable -> L18
        return r104;
    L15:
        r104 = false;
    L18:
        th = move-exception;
        com.larus.im.internal.delegate.a.f348188b.e("FlowSettingsDelegate", "enableCallbackImprove(): err=" + th.getMessage());
        f348463e = Boolean.FALSE;
        return false;
    L5:
        return r100.booleanValue();
    }

    public static b c() {
        b r100 = f348468j;
        if (r100 == null) goto L5;
        return r100;
    L5:
        b r101 = new b(0);
        ouc.d0 r102 = i().e("flow_im_sdk_communication_config", new ouc.d0(MapsKt.emptyMap()), true);     // Catch: Throwable -> L11
        wt7.c r103 = wt7.a.f561230a;     // Catch: Throwable -> L11
        String r104 = r102.toString();     // Catch: Throwable -> L11
        juc.d<b> r105 = b.Companion.serializer();     // Catch: Throwable -> L11
        r103.getClass();     // Catch: Throwable -> L11
        b r106 = (b) wt7.c.a(r104, r105);     // Catch: Throwable -> L11
        f348468j = r106;     // Catch: Throwable -> L11
        if (r106 != null) goto L10;
        return r101;
    L10:
        return r106;
    L11:
        th = move-exception;
        com.larus.im.internal.delegate.a.f348188b.e("FlowSettingsDelegate", "getCommunicationConfig(): err=" + th.getMessage());
        return r101;
    }

    public static k d() {
        k r100 = new k(0);
        if (f348464f == null) goto L18;
    L13:
        k r101 = f348464f;
        if (r101 != null) goto L17;
        return r100;
    L17:
        return r101;
    L18:
        ouc.d0 r102 = i().e("flow_im_sdk_mechanism_config", new ouc.d0(MapsKt.emptyMap()), true);     // Catch: Throwable -> L9
        if (r102.containsKey("fix_config") == false) goto L11;
        ouc.d0 r103 = ouc.k.n((ouc.i) MapsKt.getValue(r102, "fix_config"));     // Catch: Throwable -> L9
        wt7.c r104 = wt7.a.f561230a;     // Catch: Throwable -> L9
        String r105 = r103.toString();     // Catch: Throwable -> L9
        juc.d<k> r106 = k.Companion.serializer();     // Catch: Throwable -> L9
        r104.getClass();     // Catch: Throwable -> L9
        k r107 = (k) wt7.c.a(r105, r106);     // Catch: Throwable -> L9
        if (r107 == null) goto L11;
    L12:
        f348464f = r107;
    L11:
        r107 = r100;
    L9:
        th = move-exception;
        com.larus.im.internal.delegate.a.f348188b.e("FlowSettingsDelegate", "getFixConfig(): err=" + th.getMessage());
        goto L11
    }

    public static n e() {
        n r100 = new n(0);
        if (f348462d == null) goto L15;
    L13:
        n r101 = f348462d;
        Intrinsics.checkNotNull(r101);
        return r101;
    L15:
        ouc.d0 r102 = i().e("flow_im_sdk_mechanism_config", new ouc.d0(MapsKt.emptyMap()), true);     // Catch: Throwable -> L10
        if (r102.containsKey("chunk_config") == false) goto L12;
        ouc.d0 r103 = ouc.k.n((ouc.i) MapsKt.getValue(r102, "chunk_config"));     // Catch: Throwable -> L10
        wt7.c r104 = wt7.a.f561230a;     // Catch: Throwable -> L10
        String r105 = r103.toString();     // Catch: Throwable -> L10
        juc.d<n> r106 = n.Companion.serializer();     // Catch: Throwable -> L10
        r104.getClass();     // Catch: Throwable -> L10
        n r107 = (n) wt7.c.a(r105, r106);     // Catch: Throwable -> L10
        if (r107 == null) goto L12;
        r100 = r107;
    L12:
        f348462d = r100;
    L10:
        th = move-exception;
        com.larus.im.internal.delegate.a.f348188b.e("FlowSettingsDelegate", "getMechanismChunkConfig(): err=" + th.getMessage());
        goto L12
    }

    public static q f() {
        q r100 = new q(0);
        ouc.d0 r101 = i().e("message_stream_perf_config", new ouc.d0(MapsKt.emptyMap()), true);     // Catch: Throwable -> L8
        wt7.c r102 = wt7.a.f561230a;     // Catch: Throwable -> L8
        String r103 = r101.toString();     // Catch: Throwable -> L8
        juc.d<q> r104 = q.Companion.serializer();     // Catch: Throwable -> L8
        r102.getClass();     // Catch: Throwable -> L8
        q r105 = (q) wt7.c.a(r103, r104);     // Catch: Throwable -> L8
        if (r105 != null) goto L7;
        return r100;
    L7:
        return r105;
    L8:
        th = move-exception;
        com.larus.im.internal.delegate.a.f348188b.e("FlowSettingsDelegate", "getMessageStreamPerfConfig(): err=" + th);
        return r100;
    }

    public static List h() {
        if (f348461c != null) goto L18;
        f348461c = new ArrayList();
        ouc.d0 r100 = i().e("flow_im_sdk_mechanism_config", new ouc.d0(MapsKt.emptyMap()), true);
        if (r100.containsKey("send_message_business_error_code") == false) goto L18;
        ouc.i r101 = (ouc.i) r100.get("send_message_business_error_code");
        if (r101 == null) goto L9;
        ouc.b r102 = ouc.k.m(r101);
    L10:
        if (r102 == null) goto L18;
        int r103 = r102.size();
        int r104 = 0;
    L12:
        if (r104 >= r103) goto L18;
        List<Integer> r105 = f348461c;
        Intrinsics.checkNotNull(r105);
        Integer r106 = ouc.k.l(ouc.k.o(r102.a(r104)));
        if (r106 == null) goto L16;
        int r107 = r106.intValue();
    L17:
        r105.add(Integer.valueOf(r107));
        r104 = r104 + 1;
        goto L12
    L16:
        r107 = 0;
        goto L17
    L9:
        r102 = null;
    L18:
        List<Integer> r108 = f348461c;
        if (r108 != null) goto L21;
    L24:
        boolean r109 = true;
    L25:
        if (r109 == false) goto L27;
        f348461c = CollectionsKt.mutableListOf(new Integer[]{710022013, 710022014, 710022015, 710022020, 710022021, 710022022});
    L27:
        List<Integer> r110 = f348461c;
        Intrinsics.checkNotNull(r110);
        return r110;
    L21:
        if (r108.isEmpty() == true) goto L24;
        r109 = false;
        goto L25
    }

    public static gd9.y i() {
        return (gd9.y) f348459a.getValue();
    }

    public static l m() {
        l r100 = new l(0);
        ouc.d0 r101 = i().e("flow_im_sdk_database_config", new ouc.d0(MapsKt.emptyMap()), true);     // Catch: Throwable -> L8
        wt7.c r102 = wt7.a.f561230a;     // Catch: Throwable -> L8
        String r103 = r101.toString();     // Catch: Throwable -> L8
        juc.d<l> r104 = l.Companion.serializer();     // Catch: Throwable -> L8
        r102.getClass();     // Catch: Throwable -> L8
        l r105 = (l) wt7.c.a(r103, r104);     // Catch: Throwable -> L8
        com.larus.im.internal.delegate.a.f348188b.i("FlowSettingsDelegate", "getIMSDKDBConfig, rawStr=" + r101);     // Catch: Throwable -> L8
        if (r105 != null) goto L7;
        return r100;
    L7:
        return r105;
    L8:
        th = move-exception;
        com.larus.im.internal.delegate.a.f348188b.e("FlowSettingsDelegate", "getIMSDKDBConfig(): err=" + th);
        return r100;
    }

    public static long b() {
        return (long) (e().f348573e * ((double) 1000));
    }

    public static s g() {
        s r100 = e().f348576h;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new s(0);
    }

    public static long j() {
        return (long) (e().f348570b * ((double) 1000));
    }

    public static v k() {
        v r100 = e().f348577i;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new v(0);
    }

    public static boolean l() {
        ouc.i r100 = (ouc.i) i().e("conversation_group_config", new ouc.d0(MapsKt.emptyMap()), false).get("enable_archive");     // Catch: Throwable -> L8
        if (r100 == null) goto L10;
        Boolean r101 = ouc.k.f(ouc.k.o(r100));     // Catch: Throwable -> L8
        if (r101 == null) goto L10;
        return r101.booleanValue();
    L10:
        return true;
    L8:
        th = move-exception;
        com.larus.im.internal.delegate.a.f348188b.e("FlowSettingsDelegate", "isArchiveEnabled(): err=" + th);
        goto L10
    }
}
