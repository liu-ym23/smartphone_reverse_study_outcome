package kl9;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.larus.multitask_management.api.data.TaskDisplayStatus;
import com.larus.multitask_management.api.data.TaskPriority;
import com.larus.multitask_management.api.data.TaskStatus;
import com.larus.multitask_management.api.data.TaskType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
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
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes30.dex */
@Serializable
public final class u {
    public static final b Companion = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f503978y = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f503979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f503980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f503981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f503982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f503983e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TaskType f503984f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TaskStatus f503985g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final TaskDisplayStatus f503986h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final x f503987i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<p> f503988j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final p f503989k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final p f503990l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c0 f503991m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f503992n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final long f503993o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final v f503994p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Map<String, String> f503995q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Map<String, String> f503996r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Map<String, String> f503997s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f503998t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f503999u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f504000v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f504001w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f504002x;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<u> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f504003a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f504004b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f504004b;
        }

        static {
            a r100 = new a();
            f504003a = r100;
            g2 r101 = new g2("com.larus.multitask_management.api.data.TaskBasicInfo", r100, 24);
            r101.j("task_instance_id", true);
            r101.j("task_meta_id", true);
            r101.j("task_reference_id", true);
            r101.j("local_task_instance_id", true);
            r101.j("priority", true);
            r101.j("type", true);
            r101.j("status", true);
            r101.j("display_status", true);
            r101.j("display_data", true);
            r101.j(SlcCommonAction.KEY_ACTIONS, true);
            r101.j("primary_action", true);
            r101.j("remove_action", true);
            r101.j("progress_data", true);
            r101.j("create_time_us", true);
            r101.j("version", true);
            r101.j("config_data", true);
            r101.j("extra", true);
            r101.j("biz_data", true);
            r101.j("biz_extra", true);
            r101.j("taskKey", true);
            r101.j("taskSourceType", true);
            r101.j("taskSourceId", true);
            r101.j("taskSource", true);
            r101.j("realTaskId", true);
            f504004b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r100 = u.f503978y;
            v2 r101 = v2.f520790a;
            p.a r102 = p.a.f503966a;
            g1 r103 = g1.f520681a;
            return new juc.d[]{r101, kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), w0.f520792a, kuc.a.d(f0.f503894a), kuc.a.d(e0.f503892a), kuc.a.d(y.f504022a), kuc.a.d(x.a.f504020a), kuc.a.d(r100[9].getValue()), kuc.a.d(r102), kuc.a.d(r102), kuc.a.d(c0.a.f503879a), r103, r103, kuc.a.d(v.a.f504008a), kuc.a.d(r100[16].getValue()), kuc.a.d(r100[17].getValue()), kuc.a.d(r100[18].getValue()), r101, r101, r101, r101, kuc.a.d(r101)};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r510) {
            Intrinsics.checkNotNullParameter(r510, "decoder");
            g2 r100 = f504004b;
            muc.c r101 = r510.beginStructure(r100);
            Lazy<juc.d<Object>>[] r102 = u.f503978y;
            if (r101.decodeSequentially() == false) goto L5;
            String r103 = r101.decodeStringElement(r100, 0);
            v2 r110 = v2.f520790a;
            String r111 = (String) r101.decodeNullableSerializableElement(r100, 1, r110, null);
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 2, r110, null);
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 3, r110, null);
            int r106 = r101.decodeIntElement(r100, 4);
            TaskType r107 = (TaskType) r101.decodeNullableSerializableElement(r100, 5, f0.f503894a, null);
            TaskStatus r108 = (TaskStatus) r101.decodeNullableSerializableElement(r100, 6, e0.f503892a, null);
            TaskDisplayStatus r112 = (TaskDisplayStatus) r101.decodeNullableSerializableElement(r100, 7, y.f504022a, null);
            x r113 = (x) r101.decodeNullableSerializableElement(r100, 8, x.a.f504020a, null);
            List r109 = (List) r101.decodeNullableSerializableElement(r100, 9, r102[9].getValue(), null);
            p.a r114 = p.a.f503966a;
            p r210 = (p) r101.decodeNullableSerializableElement(r100, 10, r114, null);
            p r115 = (p) r101.decodeNullableSerializableElement(r100, 11, r114, null);
            c0 r116 = (c0) r101.decodeNullableSerializableElement(r100, 12, c0.a.f503879a, null);
            long r211 = r101.decodeLongElement(r100, 13);
            long r212 = r101.decodeLongElement(r100, 14);
            v r117 = (v) r101.decodeNullableSerializableElement(r100, 15, v.a.f504008a, null);
            Map r118 = (Map) r101.decodeNullableSerializableElement(r100, 16, r102[16].getValue(), null);
            Map r119 = (Map) r101.decodeNullableSerializableElement(r100, 17, r102[17].getValue(), null);
            Map r120 = (Map) r101.decodeNullableSerializableElement(r100, 18, r102[18].getValue(), null);
            String r121 = r101.decodeStringElement(r100, 19);
            String r122 = r101.decodeStringElement(r100, 20);
            String r123 = r101.decodeStringElement(r100, 21);
            String r124 = r101.decodeStringElement(r100, 22);
            Map r310 = r120;
            String r410 = (String) r101.decodeNullableSerializableElement(r100, 23, r110, null);
            Map r311 = r119;
            String r312 = r121;
            String r313 = r122;
            String r314 = r123;
            String r315 = r124;
            String r125 = r111;
            Map r316 = r118;
            v r317 = r117;
            String r126 = r103;
            long r318 = r212;
            int r127 = 16777215;
            String r128 = r105;
            TaskType r213 = r107;
            String r129 = r104;
            int r130 = r106;
            c0 r214 = r116;
            long r215 = r211;
            p r216 = r115;
            List r217 = r109;
            TaskStatus r218 = r108;
            x r219 = r113;
            TaskDisplayStatus r220 = r112;
        L56:
            r101.endStructure(r100);
            return new u(r127, r126, r125, r129, r128, r130, r213, r218, r220, r219, r217, r210, r216, r214, r215, r318, r317, r316, r311, r310, r312, r313, r314, r315, r410);
        L5:
            p r131 = null;
            Map r132 = null;
            Map r221 = null;
            Map r133 = null;
            List r134 = null;
            p r135 = null;
            x r136 = null;
            v r137 = null;
            String r138 = null;
            TaskStatus r139 = null;
            c0 r140 = null;
            TaskDisplayStatus r141 = null;
            String r319 = null;
            String r320 = null;
            String r321 = null;
            String r411 = null;
            String r412 = null;
            String r413 = null;
            String r414 = null;
            TaskType r415 = null;
            String r416 = null;
            long r417 = 0;
            long r418 = 0;
            int r142 = 0;
            int r322 = 0;
            boolean r511 = true;
        L6:
            if (r511 == false) goto L55;
            TaskStatus r512 = r139;
            int r143 = r101.decodeElementIndex(r100);
            switch(r143) {
                case -1: goto L54;
                case 0: goto L50;
                case 1: goto L48;
                case 2: goto L47;
                case 3: goto L45;
                case 4: goto L43;
                case 5: goto L42;
                case 6: goto L41;
                case 7: goto L39;
                case 8: goto L37;
                case 9: goto L35;
                case 10: goto L34;
                case 11: goto L32;
                case 12: goto L31;
                case 13: goto L29;
                case 14: goto L28;
                case 15: goto L26;
                case 16: goto L22;
                case 17: goto L20;
                case 18: goto L19;
                case 19: goto L17;
                case 20: goto L15;
                case 21: goto L13;
                case 22: goto L12;
                case 23: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r143);
        L12:
            r412 = r101.decodeStringElement(r100, 22);
            int r144 = 4194304;
        L16:
            r142 = r144 | r142;
            r141 = r141;
        L40:
            r102 = r102;
            r132 = r132;
            r139 = r512;
            goto L6
        L13:
            r411 = r101.decodeStringElement(r100, 21);
            r144 = 2097152;
            goto L16
        L15:
            r141 = r141;
            r416 = r101.decodeStringElement(r100, 20);
            r144 = 1048576;
            goto L16
        L39:
            r142 = r142 | 128;
            r141 = (TaskDisplayStatus) r101.decodeNullableSerializableElement(r100, 7, y.f504022a, r141);
            goto L40
        L41:
            r102 = r102;
            r132 = r132;
            r141 = r141;
            r142 = r142 | 64;
            r139 = (TaskStatus) r101.decodeNullableSerializableElement(r100, 6, e0.f503892a, r512);
            r221 = r221;
            r320 = r320;
            String r145 = r414;
            TaskType r222 = r415;
        L53:
            r414 = r145;
            r320 = r320;
            r102 = r102;
            r415 = r222;
            r221 = r221;
            r141 = r141;
            r132 = r132;
            goto L6
        L42:
            r512 = r512;
            TaskType r146 = (TaskType) r101.decodeNullableSerializableElement(r100, 5, f0.f503894a, r415);
            r142 = r142 | 32;
            int r323 = r322;
        L44:
            r322 = r323;
            String r147 = r414;
        L49:
            r414 = r147;
        L52:
            r222 = r146;
            r145 = r414;
            r139 = r512;
            goto L53
        L43:
            r146 = r415;
            r512 = r512;
            r323 = r101.decodeIntElement(r100, 4);
            r142 = r142 | 16;
            goto L44
        L45:
            r102 = r102;
            r132 = r132;
            r141 = r141;
            r146 = r415;
            r512 = r512;
            r147 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r414);
            r142 = r142 | 8;
            goto L49
        L47:
            TaskType r223 = r415;
            r142 = r142 | 4;
            r320 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r320);
        L51:
            r319 = r319;
            r146 = r223;
            goto L52
        L48:
            r102 = r102;
            r132 = r132;
            r141 = r141;
            r512 = r512;
            r319 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r319);
            r142 = r142 | 2;
            r147 = r414;
            r146 = r415;
            goto L49
        L50:
            r320 = r320;
            r223 = r415;
            r321 = r101.decodeStringElement(r100, 0);
            r142 = r142 | 1;
            goto L51
        L54:
            r102 = r102;
            r221 = r221;
            r139 = r512;
            r141 = r141;
            r132 = r132;
            r511 = false;
            goto L6
        L11:
            r138 = (String) r101.decodeNullableSerializableElement(r100, 23, v2.f520790a, r138);
            int r148 = 8388608;
        L21:
            r142 = r148 | r142;
        L38:
            r102 = r102;
            r139 = r512;
            r141 = r141;
            goto L6
        L17:
            r413 = r101.decodeStringElement(r100, 19);
            r148 = 524288;
            goto L21
        L19:
            r133 = (Map) r101.decodeNullableSerializableElement(r100, 18, r102[18].getValue(), r133);
            int r149 = 262144;
        L23:
            r142 = r142 | r149;
            goto L38
        L20:
            r141 = r141;
            r221 = (Map) r101.decodeNullableSerializableElement(r100, 17, r102[17].getValue(), r221);
            r148 = 131072;
            goto L21
        L22:
            r132 = (Map) r101.decodeNullableSerializableElement(r100, 16, r102[16].getValue(), r132);
            r149 = 65536;
            goto L23
        L26:
            r141 = r141;
            r137 = (v) r101.decodeNullableSerializableElement(r100, 15, v.a.f504008a, r137);
            int r150 = 32768 | r142;
        L33:
            r142 = r150;
            goto L38
        L28:
            r418 = r101.decodeLongElement(r100, 14);
            int r151 = r142 | 16384;
        L30:
            r150 = r151;
            goto L33
        L29:
            r417 = r101.decodeLongElement(r100, 13);
            r151 = r142 | 8192;
            goto L30
        L31:
            r141 = r141;
            r140 = (c0) r101.decodeNullableSerializableElement(r100, 12, c0.a.f503879a, r140);
            r150 = r142 | 4096;
            goto L33
        L32:
            r141 = r141;
            r135 = (p) r101.decodeNullableSerializableElement(r100, 11, p.a.f503966a, r135);
            r150 = r142 | 2048;
            goto L33
        L34:
            r131 = (p) r101.decodeNullableSerializableElement(r100, 10, p.a.f503966a, r131);
            r142 = r142 | 1024;
        L36:
            r102 = r102;
            goto L38
        L35:
            r134 = (List) r101.decodeNullableSerializableElement(r100, 9, r102[9].getValue(), r134);
            r142 = r142 | 512;
            goto L36
        L37:
            r141 = r141;
            r102 = r102;
            r136 = (x) r101.decodeNullableSerializableElement(r100, 8, x.a.f504020a, r136);
            r142 = r142 | 256;
            goto L38
        L55:
            r125 = r319;
            r217 = r134;
            r216 = r135;
            r219 = r136;
            r317 = r137;
            r210 = r131;
            r128 = r414;
            r129 = r320;
            r213 = r415;
            r218 = r139;
            r220 = r141;
            r316 = r132;
            r130 = r322;
            r126 = r321;
            r314 = r411;
            r315 = r412;
            r312 = r413;
            r313 = r416;
            r215 = r417;
            r318 = r418;
            r310 = r133;
            r410 = r138;
            r311 = r221;
            r214 = r140;
            r127 = r142;
            goto L56
        }

        @Override // juc.n
        public final void serialize(muc.f r210, Object r211) {
            u r100 = (u) r211;
            Intrinsics.checkNotNullParameter(r210, "encoder");
            Intrinsics.checkNotNullParameter(r100, "value");
            g2 r101 = f504004b;
            muc.d r102 = r210.beginStructure(r101);
            Lazy<juc.d<Object>>[] r103 = u.f503978y;
            String r104 = "";
            if (r102.shouldEncodeElementDefault(r101, 0) == false) goto L6;
        L7:
            boolean r105 = true;
        L9:
            if (r105 == false) goto L12;
            r102.encodeStringElement(r101, 0, r100.f503979a);
        L12:
            if (r102.shouldEncodeElementDefault(r101, 1) == false) goto L15;
        L16:
            boolean r106 = true;
        L18:
            if (r106 == false) goto L21;
            r102.encodeNullableSerializableElement(r101, 1, v2.f520790a, r100.f503980b);
        L21:
            if (r102.shouldEncodeElementDefault(r101, 2) == false) goto L24;
        L25:
            boolean r107 = true;
        L27:
            if (r107 == false) goto L30;
            r102.encodeNullableSerializableElement(r101, 2, v2.f520790a, r100.f503981c);
        L30:
            if (r102.shouldEncodeElementDefault(r101, 3) == false) goto L33;
        L34:
            boolean r108 = true;
        L36:
            if (r108 == false) goto L39;
            r102.encodeNullableSerializableElement(r101, 3, v2.f520790a, r100.f503982d);
        L39:
            if (r102.shouldEncodeElementDefault(r101, 4) == false) goto L42;
        L43:
            boolean r109 = true;
        L45:
            if (r109 == false) goto L48;
            r102.encodeIntElement(r101, 4, r100.f503983e);
        L48:
            if (r102.shouldEncodeElementDefault(r101, 5) == false) goto L51;
        L52:
            boolean r110 = true;
        L54:
            if (r110 == false) goto L57;
            r102.encodeNullableSerializableElement(r101, 5, f0.f503894a, r100.f503984f);
        L57:
            if (r102.shouldEncodeElementDefault(r101, 6) == false) goto L60;
        L61:
            boolean r111 = true;
        L63:
            if (r111 == false) goto L66;
            r102.encodeNullableSerializableElement(r101, 6, e0.f503892a, r100.f503985g);
        L66:
            if (r102.shouldEncodeElementDefault(r101, 7) == false) goto L69;
        L70:
            boolean r112 = true;
        L72:
            if (r112 == false) goto L75;
            r102.encodeNullableSerializableElement(r101, 7, y.f504022a, r100.f503986h);
        L75:
            if (r102.shouldEncodeElementDefault(r101, 8) == false) goto L78;
        L79:
            boolean r113 = true;
        L81:
            if (r113 == false) goto L84;
            r102.encodeNullableSerializableElement(r101, 8, x.a.f504020a, r100.f503987i);
        L84:
            if (r102.shouldEncodeElementDefault(r101, 9) == false) goto L87;
        L88:
            boolean r114 = true;
        L90:
            if (r114 == false) goto L93;
            r102.encodeNullableSerializableElement(r101, 9, r103[9].getValue(), r100.f503988j);
        L93:
            if (r102.shouldEncodeElementDefault(r101, 10) == false) goto L96;
        L97:
            boolean r115 = true;
        L99:
            if (r115 == false) goto L102;
            r102.encodeNullableSerializableElement(r101, 10, p.a.f503966a, r100.f503989k);
        L102:
            if (r102.shouldEncodeElementDefault(r101, 11) == false) goto L105;
        L106:
            boolean r116 = true;
        L108:
            if (r116 == false) goto L111;
            r102.encodeNullableSerializableElement(r101, 11, p.a.f503966a, r100.f503990l);
        L111:
            if (r102.shouldEncodeElementDefault(r101, 12) == false) goto L114;
        L115:
            boolean r117 = true;
        L117:
            if (r117 == false) goto L120;
            r102.encodeNullableSerializableElement(r101, 12, c0.a.f503879a, r100.f503991m);
        L120:
            if (r102.shouldEncodeElementDefault(r101, 13) == false) goto L123;
        L124:
            boolean r118 = true;
        L126:
            if (r118 == false) goto L129;
            r102.encodeLongElement(r101, 13, r100.f503992n);
        L129:
            if (r102.shouldEncodeElementDefault(r101, 14) == false) goto L132;
        L133:
            boolean r119 = true;
        L135:
            if (r119 == false) goto L138;
            r102.encodeLongElement(r101, 14, r100.f503993o);
        L138:
            if (r102.shouldEncodeElementDefault(r101, 15) == false) goto L141;
        L142:
            boolean r120 = true;
        L144:
            if (r120 == false) goto L147;
            r102.encodeNullableSerializableElement(r101, 15, v.a.f504008a, r100.f503994p);
        L147:
            if (r102.shouldEncodeElementDefault(r101, 16) == false) goto L150;
        L151:
            boolean r121 = true;
        L153:
            if (r121 == false) goto L156;
            r102.encodeNullableSerializableElement(r101, 16, r103[16].getValue(), r100.f503995q);
        L156:
            if (r102.shouldEncodeElementDefault(r101, 17) == false) goto L159;
        L160:
            boolean r122 = true;
        L162:
            if (r122 == false) goto L165;
            r102.encodeNullableSerializableElement(r101, 17, r103[17].getValue(), r100.f503996r);
        L165:
            if (r102.shouldEncodeElementDefault(r101, 18) == false) goto L168;
        L169:
            boolean r123 = true;
        L171:
            if (r123 == false) goto L174;
            r102.encodeNullableSerializableElement(r101, 18, r103[18].getValue(), r100.f503997s);
        L174:
            if (r102.shouldEncodeElementDefault(r101, 19) == true) goto L184;
            String r124 = r100.f503998t;
            Map<String, String> r125 = r100.f503995q;
            if (r125 == null) goto L183;
            String r126 = r125.get(DbJsonConstants.DBJSON_KEY_TASK_KEY);
            if (r126 == null) goto L183;
            r104 = r126;
        L183:
            if (Intrinsics.areEqual(r124, r104) == false) goto L184;
            boolean r127 = false;
        L186:
            if (r127 == false) goto L188;
            r102.encodeStringElement(r101, 19, r100.f503998t);
        L188:
            String r128 = "-1";
            if (r102.shouldEncodeElementDefault(r101, 20) == true) goto L198;
            String r129 = r100.f503999u;
            Map<String, String> r130 = r100.f503995q;
            if (r130 == null) goto L195;
            String r131 = r130.get("source_type");
            if (r131 == null) goto L195;
        L197:
            if (Intrinsics.areEqual(r129, r131) == false) goto L198;
            boolean r132 = false;
        L200:
            if (r132 == false) goto L203;
            r102.encodeStringElement(r101, 20, r100.f503999u);
        L203:
            if (r102.shouldEncodeElementDefault(r101, 21) == true) goto L213;
            String r133 = r100.f504000v;
            Map<String, String> r134 = r100.f503995q;
            if (r134 == null) goto L212;
            String r135 = r134.get("source_id");
            if (r135 == null) goto L212;
            r128 = r135;
        L212:
            if (Intrinsics.areEqual(r133, r128) == false) goto L213;
            boolean r136 = false;
        L215:
            if (r136 == false) goto L218;
            r102.encodeStringElement(r101, 21, r100.f504000v);
        L218:
            if (r102.shouldEncodeElementDefault(r101, 22) == false) goto L221;
        L222:
            boolean r137 = true;
        L224:
            if (r137 == false) goto L227;
            r102.encodeStringElement(r101, 22, r100.f504001w);
        L227:
            if (r102.shouldEncodeElementDefault(r101, 23) == true) goto L238;
            String r138 = r100.f504002x;
            if (r100.f503984f != TaskType.LOCAL) goto L235;
            Map<String, String> r139 = r100.f503995q;
            if (r139 == null) goto L234;
            String r140 = r139.get("real_task_id");
        L237:
            if (Intrinsics.areEqual(r138, r140) == false) goto L238;
            boolean r141 = false;
        L240:
            if (r141 == false) goto L242;
            r102.encodeNullableSerializableElement(r101, 23, v2.f520790a, r100.f504002x);
        L242:
            r102.endStructure(r101);
            return;
        L234:
            r140 = null;
            goto L237
        L235:
            r140 = r100.f503979a;
        L238:
            r141 = true;
            goto L240
        L221:
            if (Intrinsics.areEqual(r100.f504001w, r100.f503999u + '_' + r100.f504000v) == false) goto L222;
            r137 = false;
        L213:
            r136 = true;
        L195:
            r131 = "-1";
        L198:
            r132 = true;
        L184:
            r127 = true;
            goto L186
        L168:
            if (r100.f503997s != null) goto L169;
            r123 = false;
            goto L171
        L159:
            if (r100.f503996r != null) goto L160;
            r122 = false;
            goto L162
        L150:
            if (r100.f503995q != null) goto L151;
            r121 = false;
            goto L153
        L141:
            if (r100.f503994p != null) goto L142;
            r120 = false;
            goto L144
        L132:
            if (r100.f503993o != (-1)) goto L133;
            r119 = false;
            goto L135
        L123:
            if (r100.f503992n != (-1)) goto L124;
            r118 = false;
            goto L126
        L114:
            if (r100.f503991m != null) goto L115;
            r117 = false;
            goto L117
        L105:
            if (r100.f503990l != null) goto L106;
            r116 = false;
            goto L108
        L96:
            if (r100.f503989k != null) goto L97;
            r115 = false;
            goto L99
        L87:
            if (r100.f503988j != null) goto L88;
            r114 = false;
            goto L90
        L78:
            if (Intrinsics.areEqual(r100.f503987i, new x(null, null, null, null, null, null, null, 0, 511)) == false) goto L79;
            r113 = false;
            goto L81
        L69:
            if (r100.f503986h != TaskDisplayStatus.DISPLAYED) goto L70;
            r112 = false;
            goto L72
        L60:
            if (r100.f503985g != TaskStatus.UNDEFINED) goto L61;
            r111 = false;
            goto L63
        L51:
            if (r100.f503984f != TaskType.UNDEFINED) goto L52;
            r110 = false;
            goto L54
        L42:
            if (r100.f503983e != TaskPriority.UNDEFINED.getValue()) goto L43;
            r109 = false;
            goto L45
        L33:
            if (r100.f503982d != null) goto L34;
            r108 = false;
            goto L36
        L24:
            if (r100.f503981c != null) goto L25;
            r107 = false;
            goto L27
        L15:
            if (r100.f503980b != null) goto L16;
            r106 = false;
            goto L18
        L6:
            if (Intrinsics.areEqual(r100.f503979a, "") == false) goto L7;
            r105 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<u> serializer() {
            return a.f504003a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u) == true) goto L8;
        return false;
    L8:
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f503979a, r101.f503979a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f503980b, r101.f503980b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f503981c, r101.f503981c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f503982d, r101.f503982d) == true) goto L21;
        return false;
    L21:
        if (this.f503983e == r101.f503983e) goto L24;
        return false;
    L24:
        if (this.f503984f == r101.f503984f) goto L27;
        return false;
    L27:
        if (this.f503985g == r101.f503985g) goto L30;
        return false;
    L30:
        if (this.f503986h == r101.f503986h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f503987i, r101.f503987i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f503988j, r101.f503988j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f503989k, r101.f503989k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f503990l, r101.f503990l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f503991m, r101.f503991m) == true) goto L48;
        return false;
    L48:
        if (this.f503992n == r101.f503992n) goto L51;
        return false;
    L51:
        if (this.f503993o == r101.f503993o) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f503994p, r101.f503994p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f503995q, r101.f503995q) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.f503996r, r101.f503996r) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f503997s, r101.f503997s) == true) goto L65;
        return false;
    L65:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f503979a.hashCode() * 31;
        String r101 = this.f503980b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f503981c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f503982d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (((r107 + r109) * 31) + this.f503983e) * 31;
        TaskType r111 = this.f503984f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        TaskStatus r114 = this.f503985g;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        TaskDisplayStatus r117 = this.f503986h;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        x r120 = this.f503987i;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        List<p> r123 = this.f503988j;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        p r126 = this.f503989k;
        if (r126 != null) goto L37;
        int r127 = 0;
    L38:
        int r128 = (r125 + r127) * 31;
        p r129 = this.f503990l;
        if (r129 != null) goto L41;
        int r130 = 0;
    L42:
        int r131 = (r128 + r130) * 31;
        c0 r132 = this.f503991m;
        if (r132 != null) goto L45;
        int r133 = 0;
    L46:
        long r134 = this.f503992n;
        int r135 = (((r131 + r133) * 31) + ((int) (r134 ^ (r134 >>> 32)))) * 31;
        long r136 = this.f503993o;
        int r137 = (r135 + ((int) (r136 ^ (r136 >>> 32)))) * 31;
        v r138 = this.f503994p;
        if (r138 != null) goto L49;
        int r139 = 0;
    L50:
        int r140 = (r137 + r139) * 31;
        Map<String, String> r141 = this.f503995q;
        if (r141 != null) goto L53;
        int r142 = 0;
    L54:
        int r143 = (r140 + r142) * 31;
        Map<String, String> r144 = this.f503996r;
        if (r144 != null) goto L57;
        int r145 = 0;
    L58:
        int r146 = (r143 + r145) * 31;
        Map<String, String> r147 = this.f503997s;
        if (r147 == null) goto L63;
        r102 = r147.hashCode();
    L63:
        return r146 + r102;
    L57:
        r145 = r144.hashCode();
        goto L58
    L53:
        r142 = r141.hashCode();
        goto L54
    L49:
        r139 = r138.hashCode();
        goto L50
    L45:
        r133 = r132.hashCode();
        goto L46
    L41:
        r130 = r129.hashCode();
        goto L42
    L37:
        r127 = r126.hashCode();
        goto L38
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "TaskBasicInfo(taskId=" + this.f503979a + ", taskMetaId=" + this.f503980b + ", taskReferenceId=" + this.f503981c + ", localTaskInstanceId=" + this.f503982d + ", priority=" + this.f503983e + ", taskType=" + this.f503984f + ", taskStatus=" + this.f503985g + ", taskDisplayStatus=" + this.f503986h + ", taskDisplayData=" + this.f503987i + ", actions=" + this.f503988j + ", primaryAction=" + this.f503989k + ", removeAction=" + this.f503990l + ", taskProgress=" + this.f503991m + ", createTimeUs=" + this.f503992n + ", version=" + this.f503993o + ", taskConfig=" + this.f503994p + ", extra=" + this.f503995q + ", bizData=" + this.f503996r + ", bizExtra=" + this.f503997s + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        f503978y = new Lazy[]{null, null, null, null, null, null, null, null, null, LazyKt.lazy(r100, new q()), null, null, null, null, null, null, LazyKt.lazy(r100, new r()), LazyKt.lazy(r100, new s()), LazyKt.lazy(r100, new t()), null, null, null, null, null};
    }

    public u() {
        this("", null, null, null, TaskPriority.UNDEFINED.getValue(), TaskType.UNDEFINED, TaskStatus.UNDEFINED, TaskDisplayStatus.DISPLAYED, new x(null, null, null, null, null, null, null, 0, 511), null, null, null, null, -1, -1, null, null, null, null);
    }

    public static u a(u r210, TaskStatus r211, TaskDisplayStatus r212, x r213, List r310, p r311, p r312, c0 r313, long r314, v r315, Map r316, Map r317, Map r318, int r410) {
        TaskType r100 = null;
        if ((r410 & 1) == 0) goto L5;
        String r101 = r210.f503979a;
    L7:
        if ((r410 & 2) == 0) goto L9;
        String r102 = r210.f503980b;
    L11:
        if ((r410 & 4) == 0) goto L13;
        String r103 = r210.f503981c;
    L15:
        if ((r410 & 8) == 0) goto L17;
        String r104 = r210.f503982d;
    L19:
        if ((r410 & 16) == 0) goto L21;
        int r105 = r210.f503983e;
    L23:
        if ((r410 & 32) == 0) goto L25;
        r100 = r210.f503984f;
    L25:
        TaskType r110 = r100;
        if ((r410 & 64) == 0) goto L28;
        TaskStatus r111 = r210.f503985g;
    L30:
        if ((r410 & 128) == 0) goto L32;
        TaskDisplayStatus r112 = r210.f503986h;
    L34:
        if ((r410 & 256) == 0) goto L36;
        x r113 = r210.f503987i;
    L38:
        if ((r410 & 512) == 0) goto L40;
        List r114 = r210.f503988j;
    L42:
        if ((r410 & 1024) == 0) goto L44;
        p r115 = r210.f503989k;
    L46:
        if ((r410 & 2048) == 0) goto L48;
        p r116 = r210.f503990l;
    L50:
        if ((r410 & 4096) == 0) goto L52;
        c0 r117 = r210.f503991m;
    L54:
        if ((r410 & 8192) == 0) goto L56;
        long r106 = r210.f503992n;
    L57:
        long r118 = r106;
        if ((r410 & 16384) == 0) goto L60;
        long r214 = r210.f503993o;
    L62:
        if ((32768 & r410) == 0) goto L64;
        v r215 = r210.f503994p;
    L66:
        if ((65536 & r410) == 0) goto L68;
        Map r216 = r210.f503995q;
    L70:
        if ((131072 & r410) == 0) goto L72;
        Map r217 = r210.f503996r;
    L74:
        if ((r410 & 262144) == 0) goto L76;
        Map r218 = r210.f503997s;
    L77:
        Intrinsics.checkNotNullParameter(r101, DBDefinition.TASK_ID);
        return new u(r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r214, r215, r216, r217, r218);
    L76:
        r218 = r318;
        goto L77
    L72:
        r217 = r317;
        goto L74
    L68:
        r216 = r316;
        goto L70
    L64:
        r215 = r315;
        goto L66
    L60:
        r214 = r314;
        goto L62
    L56:
        r106 = 0;
        goto L57
    L52:
        r117 = r313;
        goto L54
    L48:
        r116 = r312;
        goto L50
    L44:
        r115 = r311;
        goto L46
    L40:
        r114 = r310;
        goto L42
    L36:
        r113 = r213;
        goto L38
    L32:
        r112 = r212;
        goto L34
    L28:
        r111 = r211;
        goto L30
    L21:
        r105 = 0;
        goto L23
    L17:
        r104 = null;
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

    public u(String r100, String r101, String r110, String r111, int r112, TaskType r113, TaskStatus r114, TaskDisplayStatus r115, x r116, List<p> r117, p r118, p r119, c0 r210, long r211, long r212, v r213, Map<String, String> r214, Map<String, String> r215, Map<String, String> r216) {
        String r102 = r100;
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        this.f503979a = r102;
        this.f503980b = r101;
        this.f503981c = r110;
        this.f503982d = r111;
        this.f503983e = r112;
        this.f503984f = r113;
        this.f503985g = r114;
        this.f503986h = r115;
        this.f503987i = r116;
        this.f503988j = r117;
        this.f503989k = r118;
        this.f503990l = r119;
        this.f503991m = r210;
        this.f503992n = r211;
        this.f503993o = r212;
        this.f503994p = r213;
        this.f503995q = r214;
        this.f503996r = r215;
        this.f503997s = r216;
        if (r214 == null) goto L6;
        String r103 = r214.get(DbJsonConstants.DBJSON_KEY_TASK_KEY);
        if (r103 == null) goto L6;
    L7:
        this.f503998t = r103;
        String r104 = "-1";
        if (r214 == null) goto L11;
        String r105 = r214.get("source_type");
        if (r105 == null) goto L11;
    L12:
        this.f503999u = r105;
        if (r214 == null) goto L18;
        String r106 = r214.get("source_id");
        if (r106 == null) goto L18;
        r104 = r106;
    L18:
        this.f504000v = r104;
        this.f504001w = r105 + '_' + r104;
        if (r113 != TaskType.LOCAL) goto L23;
        if (r214 == null) goto L22;
        r102 = r214.get("real_task_id");
        goto L23
    L22:
        r102 = null;
    L23:
        this.f504002x = r102;
        return;
    L11:
        r105 = "-1";
    L6:
        r103 = "";
        goto L7
    }

    public u(int r110, String r111, String r112, String r210, String r211, int r212, TaskType r213, TaskStatus r214, TaskDisplayStatus r215, x r216, List r217, p r218, p r219, c0 r310, long r311, long r312, v r313, Map r314, Map r315, Map r316, String r317, String r410, String r411, String r412, String r413) {
        String r100 = null;
        if ((r110 & 0) != 0) goto L121;
        String r101 = "";
        if ((r110 & 1) != 0) goto L7;
        this.f503979a = "";
    L9:
        if ((r110 & 2) != 0) goto L11;
        this.f503980b = null;
    L13:
        if ((r110 & 4) != 0) goto L15;
        this.f503981c = null;
    L17:
        if ((r110 & 8) != 0) goto L19;
        this.f503982d = null;
    L21:
        if ((r110 & 16) != 0) goto L23;
        int r102 = TaskPriority.UNDEFINED.getValue();
    L24:
        this.f503983e = r102;
        if ((r110 & 32) != 0) goto L27;
        TaskType r103 = TaskType.UNDEFINED;
    L28:
        this.f503984f = r103;
        if ((r110 & 64) != 0) goto L31;
        TaskStatus r104 = TaskStatus.UNDEFINED;
    L32:
        this.f503985g = r104;
        if ((r110 & 128) != 0) goto L35;
        TaskDisplayStatus r105 = TaskDisplayStatus.DISPLAYED;
    L36:
        this.f503986h = r105;
        if ((r110 & 256) != 0) goto L39;
        x r106 = new x(null, null, null, null, null, null, null, 0, 511);
    L40:
        this.f503987i = r106;
        if ((r110 & 512) != 0) goto L43;
        this.f503988j = null;
    L45:
        if ((r110 & 1024) != 0) goto L47;
        this.f503989k = null;
    L49:
        if ((r110 & 2048) != 0) goto L51;
        this.f503990l = null;
    L53:
        if ((r110 & 4096) != 0) goto L55;
        this.f503991m = null;
    L56:
        long r107 = -1;
        if ((r110 & 8192) != 0) goto L59;
        this.f503992n = -1;
    L61:
        if ((r110 & 16384) == 0) goto L64;
        r107 = r312;
    L64:
        this.f503993o = r107;
        if ((32768 & r110) != 0) goto L67;
        this.f503994p = null;
    L69:
        if ((65536 & r110) != 0) goto L71;
        this.f503995q = null;
    L73:
        if ((131072 & r110) != 0) goto L75;
        this.f503996r = null;
    L77:
        if ((262144 & r110) != 0) goto L79;
        this.f503997s = null;
    L81:
        if ((524288 & r110) != 0) goto L88;
        Map<String, String> r108 = this.f503995q;
        if (r108 == null) goto L89;
        String r109 = r108.get(DbJsonConstants.DBJSON_KEY_TASK_KEY);
        if (r109 == null) goto L89;
        r101 = r109;
    L89:
        this.f503998t = r101;
        String r113 = "-1";
        if ((1048576 & r110) != 0) goto L96;
        Map<String, String> r114 = this.f503995q;
        if (r114 == null) goto L95;
        String r115 = r114.get("source_type");
        if (r115 == null) goto L95;
    L97:
        this.f503999u = r115;
        if ((2097152 & r110) != 0) goto L105;
        Map<String, String> r116 = this.f503995q;
        if (r116 == null) goto L106;
        String r117 = r116.get("source_id");
        if (r117 == null) goto L106;
        r113 = r117;
    L106:
        this.f504000v = r113;
        if ((4194304 & r110) != 0) goto L109;
        String r118 = r115 + '_' + this.f504000v;
    L110:
        this.f504001w = r118;
        if ((r110 & 8388608) == 0) goto L113;
        this.f504002x = r413;
        return;
    L113:
        if (r103 != TaskType.LOCAL) goto L117;
        Map<String, String> r119 = this.f503995q;
        if (r119 == null) goto L118;
        r100 = r119.get("real_task_id");
    L118:
        this.f504002x = r100;
        return;
    L117:
        r100 = this.f503979a;
        goto L118
    L109:
        r118 = r412;
        goto L110
    L105:
        r113 = r411;
    L95:
        r115 = "-1";
        goto L97
    L96:
        r115 = r410;
        goto L97
    L88:
        r101 = r317;
        goto L89
    L79:
        this.f503997s = r316;
        goto L81
    L75:
        this.f503996r = r315;
        goto L77
    L71:
        this.f503995q = r314;
        goto L73
    L67:
        this.f503994p = r313;
        goto L69
    L59:
        this.f503992n = r311;
        goto L61
    L55:
        this.f503991m = r310;
        goto L56
    L51:
        this.f503990l = r219;
        goto L53
    L47:
        this.f503989k = r218;
        goto L49
    L43:
        this.f503988j = r217;
        goto L45
    L39:
        r106 = r216;
        goto L40
    L35:
        r105 = r215;
        goto L36
    L31:
        r104 = r214;
        goto L32
    L27:
        r103 = r213;
        goto L28
    L23:
        r102 = r212;
        goto L24
    L19:
        this.f503982d = r211;
        goto L21
    L15:
        this.f503981c = r210;
        goto L17
    L11:
        this.f503980b = r112;
        goto L13
    L7:
        this.f503979a = r111;
        goto L9
    L121:
        b2.b(r110, 0, a.f504004b);
        throw null;
    }
}
