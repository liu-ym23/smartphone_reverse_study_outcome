package com.larus.avlink.activeSummary;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.avlink.model.ProactiveSummaryScene;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes24.dex */
@Serializable
public final class f {
    public static final b Companion = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f291458n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f291459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f291460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f291461c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.larus.avlink.activeSummary.b f291462d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f291463e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f291464f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<u> f291465g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f291466h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f291467i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, String> f291468j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f291469k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f291470l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Long f291471m;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<f> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f291472a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f291473b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f291473b;
        }

        static {
            a r100 = new a();
            f291472a = r100;
            g2 r101 = new g2("com.larus.avlink.activeSummary.ProactiveSummaryInfoResponse", r100, 13);
            r101.j("summary_id", true);
            r101.j("scene", true);
            r101.j(BdpAppEventConstant.PARAMS_SUB_SCENE, true);
            r101.j("occupy_avoid_conf", true);
            r101.j("proactive_methods", true);
            r101.j("skip_wakeup_hardware", true);
            r101.j("original_system_notification_list", true);
            r101.j("system_notify_version", true);
            r101.j("priority_broadcast_switch", true);
            r101.j("extra", true);
            r101.j("system_notification_id", true);
            r101.j("notification_id", true);
            r101.j("notification_timestamp", true);
            f291473b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r100 = f.f291458n;
            v2 r101 = v2.f520790a;
            w0 r102 = w0.f520792a;
            return new juc.d[]{kuc.a.d(r101), kuc.a.d(r102), kuc.a.d(r101), kuc.a.d(com.larus.avlink.activeSummary.b.a.f291451a), kuc.a.d(r102), kuc.a.d(nuc.i.f520705a), kuc.a.d(r100[6].getValue()), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r100[9].getValue()), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(g1.f520681a)};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r310) {
            Intrinsics.checkNotNullParameter(r310, "decoder");
            g2 r100 = f291473b;
            muc.c r101 = r310.beginStructure(r100);
            Lazy<juc.d<Object>>[] r102 = f.f291458n;
            int r110 = 8;
            String r103 = null;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r104 = v2.f520790a;
            String r111 = (String) r101.decodeNullableSerializableElement(r100, 0, r104, null);
            w0 r105 = w0.f520792a;
            Integer r106 = (Integer) r101.decodeNullableSerializableElement(r100, 1, r105, null);
            String r112 = (String) r101.decodeNullableSerializableElement(r100, 2, r104, null);
            com.larus.avlink.activeSummary.b r107 = (com.larus.avlink.activeSummary.b) r101.decodeNullableSerializableElement(r100, 3, com.larus.avlink.activeSummary.b.a.f291451a, null);
            Integer r108 = (Integer) r101.decodeNullableSerializableElement(r100, 4, r105, null);
            Boolean r109 = (Boolean) r101.decodeNullableSerializableElement(r100, 5, nuc.i.f520705a, null);
            List r113 = (List) r101.decodeNullableSerializableElement(r100, 6, r102[6].getValue(), null);
            String r114 = (String) r101.decodeNullableSerializableElement(r100, 7, r104, null);
            String r115 = (String) r101.decodeNullableSerializableElement(r100, 8, r104, null);
            Map r116 = (Map) r101.decodeNullableSerializableElement(r100, 9, r102[9].getValue(), null);
            String r117 = (String) r101.decodeNullableSerializableElement(r100, 10, r104, null);
            Map r210 = r116;
            String r211 = (String) r101.decodeNullableSerializableElement(r100, 11, r104, null);
            Integer r118 = r106;
            Long r212 = (Long) r101.decodeNullableSerializableElement(r100, 12, g1.f520681a, null);
            Integer r119 = r108;
            com.larus.avlink.activeSummary.b r120 = r107;
            List r213 = r113;
            Boolean r121 = r109;
            String r214 = r114;
            String r215 = r115;
            String r216 = r117;
            String r122 = r111;
            int r123 = 8191;
            String r124 = r112;
        L36:
            r101.endStructure(r100);
            return new f(r123, r122, r118, r124, r120, r119, r121, r213, r214, r215, r210, r216, r211, r212);
        L5:
            int r125 = 12;
            String r126 = null;
            String r127 = null;
            String r128 = null;
            com.larus.avlink.activeSummary.b r129 = null;
            Map r130 = null;
            String r131 = null;
            Long r132 = null;
            String r133 = null;
            Integer r217 = null;
            Integer r218 = null;
            List r219 = null;
            Boolean r220 = null;
            int r134 = 0;
            boolean r221 = true;
        L6:
            if (r221 == false) goto L35;
            int r135 = r101.decodeElementIndex(r100);
            switch(r135) {
                case -1: goto L32;
                case 0: goto L31;
                case 1: goto L29;
                case 2: goto L27;
                case 3: goto L26;
                case 4: goto L25;
                case 5: goto L24;
                case 6: goto L23;
                case 7: goto L19;
                case 8: goto L18;
                case 9: goto L15;
                case 10: goto L14;
                case 11: goto L13;
                case 12: goto L11;
                default: goto L10;
            };
        L11:
            r132 = (Long) r101.decodeNullableSerializableElement(r100, r125, g1.f520681a, r132);
            r134 = r134 | 4096;
        L16:
            r102 = r102;
            r127 = r127;
            r218 = r218;
            List r136 = r219;
            Boolean r137 = r220;
        L28:
            Integer r138 = r218;
            r127 = r127;
        L30:
            r219 = r136;
            r220 = r137;
            r218 = r138;
        L34:
            r102 = r102;
            r110 = 8;
            r125 = 12;
            goto L6
        L13:
            r103 = (String) r101.decodeNullableSerializableElement(r100, 11, v2.f520790a, r103);
            r134 = r134 | 2048;
            goto L16
        L14:
            r127 = (String) r101.decodeNullableSerializableElement(r100, 10, v2.f520790a, r127);
            r134 = r134 | 1024;
            goto L16
        L15:
            r130 = (Map) r101.decodeNullableSerializableElement(r100, 9, r102[9].getValue(), r130);
            r134 = r134 | 512;
            goto L16
        L18:
            r131 = (String) r101.decodeNullableSerializableElement(r100, r110, v2.f520790a, r131);
            r134 = r134 | 256;
        L20:
            r136 = r219;
        L21:
            r137 = r220;
            goto L28
        L19:
            r133 = (String) r101.decodeNullableSerializableElement(r100, 7, v2.f520790a, r133);
            r134 = r134 | 128;
            goto L20
        L23:
            r219 = (List) r101.decodeNullableSerializableElement(r100, 6, r102[6].getValue(), r219);
            r134 = r134 | 64;
            goto L20
        L24:
            r136 = r219;
            r220 = (Boolean) r101.decodeNullableSerializableElement(r100, 5, nuc.i.f520705a, r220);
            r134 = r134 | 32;
            goto L21
        L25:
            r102 = r102;
            r136 = r219;
            r137 = r220;
            r127 = r127;
            r134 = r134 | 16;
            r218 = (Integer) r101.decodeNullableSerializableElement(r100, 4, w0.f520792a, r218);
            goto L28
        L26:
            r102 = r102;
            r127 = r127;
            r218 = r218;
            r136 = r219;
            r137 = r220;
            r129 = (com.larus.avlink.activeSummary.b) r101.decodeNullableSerializableElement(r100, 3, com.larus.avlink.activeSummary.b.a.f291451a, r129);
            r134 = r134 | 8;
            goto L28
        L27:
            r102 = r102;
            r127 = r127;
            r218 = r218;
            r136 = r219;
            r137 = r220;
            r126 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r126);
            r134 = r134 | 4;
            goto L28
        L29:
            r102 = r102;
            r136 = r219;
            r137 = r220;
            r138 = r218;
            r134 = r134 | 2;
            r217 = (Integer) r101.decodeNullableSerializableElement(r100, 1, w0.f520792a, r217);
            r127 = r127;
            goto L30
        L31:
            r128 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r128);
            r134 = r134 | 1;
        L33:
            r217 = r217;
            r219 = r219;
            r220 = r220;
            r218 = r218;
            r127 = r127;
            goto L34
        L32:
            r221 = false;
            goto L33
        L10:
            throw new UnknownFieldException(r135);
        L35:
            String r222 = r127;
            Integer r139 = r217;
            List r140 = r219;
            r124 = r126;
            r211 = r103;
            r120 = r129;
            r215 = r131;
            r212 = r132;
            r214 = r133;
            r213 = r140;
            r119 = r218;
            r216 = r222;
            r122 = r128;
            r123 = r134;
            r210 = r130;
            r121 = r220;
            r118 = r139;
            goto L36
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r110) {
            f r111 = (f) r110;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r111, "value");
            g2 r101 = f291473b;
            muc.d r102 = r100.beginStructure(r101);
            Lazy<juc.d<Object>>[] r103 = f.f291458n;
            boolean r104 = false;
            if (r102.shouldEncodeElementDefault(r101, 0) == false) goto L6;
        L7:
            boolean r105 = true;
        L9:
            if (r105 == false) goto L12;
            r102.encodeNullableSerializableElement(r101, 0, v2.f520790a, r111.f291459a);
        L12:
            if (r102.shouldEncodeElementDefault(r101, 1) == true) goto L19;
            Integer r106 = r111.f291460b;
            if (r106 == null) goto L19;
            if (r106.intValue() != 0) goto L19;
            boolean r107 = false;
        L21:
            if (r107 == false) goto L24;
            r102.encodeNullableSerializableElement(r101, 1, w0.f520792a, r111.f291460b);
        L24:
            if (r102.shouldEncodeElementDefault(r101, 2) == false) goto L27;
        L28:
            boolean r108 = true;
        L30:
            if (r108 == false) goto L33;
            r102.encodeNullableSerializableElement(r101, 2, v2.f520790a, r111.f291461c);
        L33:
            if (r102.shouldEncodeElementDefault(r101, 3) == false) goto L36;
        L37:
            boolean r109 = true;
        L39:
            if (r109 == false) goto L42;
            r102.encodeNullableSerializableElement(r101, 3, com.larus.avlink.activeSummary.b.a.f291451a, r111.f291462d);
        L42:
            if (r102.shouldEncodeElementDefault(r101, 4) == false) goto L45;
        L46:
            boolean r112 = true;
        L48:
            if (r112 == false) goto L51;
            r102.encodeNullableSerializableElement(r101, 4, w0.f520792a, r111.f291463e);
        L51:
            if (r102.shouldEncodeElementDefault(r101, 5) == false) goto L54;
        L55:
            boolean r113 = true;
        L57:
            if (r113 == false) goto L60;
            r102.encodeNullableSerializableElement(r101, 5, nuc.i.f520705a, r111.f291464f);
        L60:
            if (r102.shouldEncodeElementDefault(r101, 6) == false) goto L63;
        L64:
            boolean r114 = true;
        L66:
            if (r114 == false) goto L69;
            r102.encodeNullableSerializableElement(r101, 6, r103[6].getValue(), r111.f291465g);
        L69:
            if (r102.shouldEncodeElementDefault(r101, 7) == false) goto L72;
        L73:
            boolean r115 = true;
        L75:
            if (r115 == false) goto L78;
            r102.encodeNullableSerializableElement(r101, 7, v2.f520790a, r111.f291466h);
        L78:
            if (r102.shouldEncodeElementDefault(r101, 8) == false) goto L81;
        L82:
            boolean r116 = true;
        L84:
            if (r116 == false) goto L87;
            r102.encodeNullableSerializableElement(r101, 8, v2.f520790a, r111.f291467i);
        L87:
            if (r102.shouldEncodeElementDefault(r101, 9) == false) goto L90;
        L91:
            boolean r117 = true;
        L93:
            if (r117 == false) goto L96;
            r102.encodeNullableSerializableElement(r101, 9, r103[9].getValue(), r111.f291468j);
        L96:
            if (r102.shouldEncodeElementDefault(r101, 10) == false) goto L99;
        L100:
            boolean r118 = true;
        L102:
            if (r118 == false) goto L105;
            r102.encodeNullableSerializableElement(r101, 10, v2.f520790a, r111.f291469k);
        L105:
            if (r102.shouldEncodeElementDefault(r101, 11) == false) goto L108;
        L109:
            boolean r119 = true;
        L111:
            if (r119 == false) goto L114;
            r102.encodeNullableSerializableElement(r101, 11, v2.f520790a, r111.f291470l);
        L114:
            if (r102.shouldEncodeElementDefault(r101, 12) == false) goto L117;
        L118:
            r104 = true;
        L119:
            if (r104 == false) goto L121;
            r102.encodeNullableSerializableElement(r101, 12, g1.f520681a, r111.f291471m);
        L121:
            r102.endStructure(r101);
            return;
        L117:
            if (r111.f291471m == null) goto L119;
        L108:
            if (r111.f291470l != null) goto L109;
            r119 = false;
            goto L111
        L99:
            if (r111.f291469k != null) goto L100;
            r118 = false;
            goto L102
        L90:
            if (r111.f291468j != null) goto L91;
            r117 = false;
            goto L93
        L81:
            if (r111.f291467i != null) goto L82;
            r116 = false;
            goto L84
        L72:
            if (r111.f291466h != null) goto L73;
            r115 = false;
            goto L75
        L63:
            if (r111.f291465g != null) goto L64;
            r114 = false;
            goto L66
        L54:
            if (Intrinsics.areEqual(r111.f291464f, Boolean.FALSE) == false) goto L55;
            r113 = false;
            goto L57
        L45:
            if (r111.f291463e != null) goto L46;
            r112 = false;
            goto L48
        L36:
            if (Intrinsics.areEqual(r111.f291462d, new com.larus.avlink.activeSummary.b(2)) == false) goto L37;
            r109 = false;
            goto L39
        L27:
            if (r111.f291461c != null) goto L28;
            r108 = false;
        L19:
            r107 = true;
            goto L21
        L6:
            if (r111.f291459a != null) goto L7;
            r105 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<f> serializer() {
            return a.f291472a;
        }
    }

    public f() {
        com.larus.avlink.activeSummary.b r100 = new com.larus.avlink.activeSummary.b(2);
        Boolean r101 = Boolean.FALSE;
        this.f291459a = null;
        this.f291460b = 0;
        this.f291461c = null;
        this.f291462d = r100;
        this.f291463e = null;
        this.f291464f = r101;
        this.f291465g = null;
        this.f291466h = null;
        this.f291467i = null;
        this.f291468j = null;
        this.f291469k = null;
        this.f291470l = null;
        this.f291471m = null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f291459a, r101.f291459a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f291460b, r101.f291460b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f291461c, r101.f291461c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f291462d, r101.f291462d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f291463e, r101.f291463e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f291464f, r101.f291464f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f291465g, r101.f291465g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f291466h, r101.f291466h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f291467i, r101.f291467i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f291468j, r101.f291468j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f291469k, r101.f291469k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f291470l, r101.f291470l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f291471m, r101.f291471m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f291459a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f291460b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f291461c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        com.larus.avlink.activeSummary.b r110 = this.f291462d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f291463e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.f291464f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        List<u> r119 = this.f291465g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.f291466h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f291467i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Map<String, String> r128 = this.f291468j;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.f291469k;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.f291470l;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Long r137 = this.f291471m;
        if (r137 == null) goto L55;
        r101 = r137.hashCode();
    L55:
        return r136 + r101;
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
        return "ProactiveSummaryInfoResponse(summaryId=" + this.f291459a + ", scene=" + this.f291460b + ", subScene=" + this.f291461c + ", avoidConfig=" + this.f291462d + ", proactiveMethods=" + this.f291463e + ", skipWakeup=" + this.f291464f + ", originalSystemNotificationList=" + this.f291465g + ", systemNotifyVersion=" + this.f291466h + ", priorityBroadcastSwitch=" + this.f291467i + ", extra=" + this.f291468j + ", systemNotificationId=" + this.f291469k + ", notificationId=" + this.f291470l + ", notificationTimestamp=" + this.f291471m + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        f291458n = new Lazy[]{null, null, null, null, null, null, LazyKt.lazy(r100, new d()), null, null, LazyKt.lazy(r100, new e()), null, null, null};
    }

    public final Long a() {
        List<u> r100 = this.f291465g;
        if (r100 == null) goto L20;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L14;
        u r103 = (u) r102.next();
        if (r103 == null) goto L10;
        Long r104 = r103.f291501b;
    L11:
        if (r104 == null) goto L6;
        r101.add(r104);
        goto L6
    L10:
        r104 = null;
        goto L11
    L14:
        return (Long) CollectionsKt.minOrNull(r101);
    L20:
        return null;
    }

    public final String b() {
        Integer r100 = this.f291460b;
        int r101 = ProactiveSummaryScene.SystemNotify.getValue();
        if (r100 != null) goto L6;
    L7:
        return null;
    L6:
        if (r100.intValue() != r101) goto L7;
        if (g() == false) goto L12;
        return "v3";
    L12:
        if (f() == false) goto L14;
        return "v2";
    L14:
        return "v1";
    }

    public final Long c() {
        String r100 = this.f291469k;
        if (r100 != null) goto L6;
        r100 = this.f291470l;
    L6:
        if (r100 == null) goto L27;
        List<u> r101 = this.f291465g;
        if (r101 == null) goto L23;
        Iterator<T> r102 = r101.iterator();
    L11:
        if (r102.hasNext() == false) goto L19;
        Object r103 = r102.next();
        u r104 = (u) r103;
        if (r104 == null) goto L15;
        String r105 = r104.f291500a;
    L17:
        if (Intrinsics.areEqual(r105, r100) == false) goto L11;
    L20:
        u r106 = (u) r103;
        if (r106 == null) goto L23;
        Long r107 = r106.f291501b;
    L24:
        if (r107 == null) goto L27;
        return r107;
    L15:
        r105 = null;
        goto L17
    L19:
        r103 = null;
    L23:
        r107 = null;
    L27:
        List<u> r108 = this.f291465g;
        if (r108 == null) goto L37;
        u r109 = (u) CollectionsKt.firstOrNull(r108);
        if (r109 != null) goto L32;
        return null;
    L32:
        return r109.f291501b;
    L37:
        return null;
    }

    public final String d() {
        String r100 = this.f291469k;
        if (r100 != null) goto L13;
        String r101 = this.f291470l;
        if (r101 != null) goto L14;
        List<u> r102 = this.f291465g;
        if (r102 == null) goto L11;
        u r103 = (u) CollectionsKt.firstOrNull(r102);
        if (r103 == null) goto L11;
        return r103.f291500a;
    L11:
        return null;
    L14:
        return r101;
    L13:
        return r100;
    }

    public final boolean e() {
        Integer r100 = this.f291460b;
        int r101 = ProactiveSummaryScene.DoraAutoGreet.getValue();
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != r101) goto L8;
        return true;
    }

    public final boolean f() {
        Integer r100 = this.f291460b;
        int r101 = ProactiveSummaryScene.SystemNotify.getValue();
        if (r100 != null) goto L6;
    L10:
        return false;
    L6:
        if (r100.intValue() != r101) goto L10;
        if (Intrinsics.areEqual(this.f291461c, "system_notify_v2") == false) goto L10;
        return true;
    }

    public final boolean g() {
        Integer r100 = this.f291460b;
        int r101 = ProactiveSummaryScene.SystemNotify.getValue();
        if (r100 != null) goto L6;
    L10:
        return false;
    L6:
        if (r100.intValue() != r101) goto L10;
        if (Intrinsics.areEqual(this.f291461c, "system_notify_v3") == false) goto L10;
        return true;
    }

    public f(int r100, String r101, Integer r102, String r103, com.larus.avlink.activeSummary.b r110, Integer r111, Boolean r112, List r113, String r114, String r115, Map r116, String r117, String r118, Long r119) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f291473b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f291459a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        Integer r104 = 0;
    L12:
        this.f291460b = r104;
        if ((r100 & 4) != 0) goto L15;
        this.f291461c = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        com.larus.avlink.activeSummary.b r105 = new com.larus.avlink.activeSummary.b(2);
    L20:
        this.f291462d = r105;
        if ((r100 & 16) != 0) goto L23;
        this.f291463e = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        Boolean r106 = Boolean.FALSE;
    L28:
        this.f291464f = r106;
        if ((r100 & 64) != 0) goto L31;
        this.f291465g = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.f291466h = null;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.f291467i = null;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.f291468j = null;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.f291469k = null;
    L49:
        if ((r100 & 2048) != 0) goto L51;
        this.f291470l = null;
    L53:
        if ((r100 & 4096) != 0) goto L55;
        this.f291471m = null;
        return;
    L55:
        this.f291471m = r119;
        return;
    L51:
        this.f291470l = r118;
        goto L53
    L47:
        this.f291469k = r117;
        goto L49
    L43:
        this.f291468j = r116;
        goto L45
    L39:
        this.f291467i = r115;
        goto L41
    L35:
        this.f291466h = r114;
        goto L37
    L31:
        this.f291465g = r113;
        goto L33
    L27:
        r106 = r112;
        goto L28
    L23:
        this.f291463e = r111;
        goto L25
    L19:
        r105 = r110;
        goto L20
    L15:
        this.f291461c = r103;
        goto L17
    L11:
        r104 = r102;
        goto L12
    L7:
        this.f291459a = r101;
        goto L9
    }
}
