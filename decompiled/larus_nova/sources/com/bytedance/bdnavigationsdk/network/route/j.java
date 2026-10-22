package com.bytedance.bdnavigationsdk.network.route;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes10.dex */
@Serializable
public final class j {
    public static final b Companion = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final juc.d<Object>[] f200237l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f200238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f200239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f200240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.bdnavigationsdk.pojo.a f200241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.bdnavigationsdk.pojo.a f200242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f200243f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f200244g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f200245h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PoiType f200246i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PoiType f200247j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<v> f200248k;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f200249a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f200250b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f200250b;
        }

        static {
            a r100 = new a();
            f200249a = r100;
            g2 r101 = new g2("com.bytedance.bdnavigationsdk.network.route.RoutePlanParam", r100, 11);
            r101.j("session_id", false);
            r101.j("business", false);
            r101.j("plan_type", false);
            r101.j(PlayerResolution.SDKKEY.ORIGIN, false);
            r101.j(com.bytedance.android.ec.core.event.a.KEY_DESTINATION, false);
            r101.j(com.bytedance.android.ec.core.event.a.KEY_ORIGIN_ID, true);
            r101.j("destination_id", true);
            r101.j("alternative_route", true);
            r101.j("origin_id_type", true);
            r101.j("destination_id_type", true);
            r101.j("waypoints", true);
            f200250b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            juc.d<Object>[] r100 = j.f200237l;
            v2 r101 = v2.f520790a;
            com.bytedance.bdnavigationsdk.pojo.a.C2885a r102 = com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a;
            return new juc.d[]{r101, r101, r101, r102, r102, kuc.a.d(r101), kuc.a.d(r101), w0.f520792a, kuc.a.d(r100[8]), kuc.a.d(r100[9]), kuc.a.d(r100[10])};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f200250b;
            muc.c r101 = r210.beginStructure(r100);
            juc.d<Object>[] r102 = j.f200237l;
            int r103 = 8;
            int r104 = 10;
            if (r101.decodeSequentially() == false) goto L5;
            String r105 = r101.decodeStringElement(r100, 0);
            String r110 = r101.decodeStringElement(r100, 1);
            String r111 = r101.decodeStringElement(r100, 2);
            com.bytedance.bdnavigationsdk.pojo.a.C2885a r112 = com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a;
            com.bytedance.bdnavigationsdk.pojo.a r106 = (com.bytedance.bdnavigationsdk.pojo.a) r101.decodeSerializableElement(r100, 3, r112, null);
            com.bytedance.bdnavigationsdk.pojo.a r113 = (com.bytedance.bdnavigationsdk.pojo.a) r101.decodeSerializableElement(r100, 4, r112, null);
            v2 r114 = v2.f520790a;
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 5, r114, null);
            String r108 = (String) r101.decodeNullableSerializableElement(r100, 6, r114, null);
            int r109 = r101.decodeIntElement(r100, 7);
            PoiType r115 = (PoiType) r101.decodeNullableSerializableElement(r100, 8, r102[8], null);
            PoiType r116 = (PoiType) r101.decodeNullableSerializableElement(r100, 9, r102[9], null);
            List r211 = (List) r101.decodeNullableSerializableElement(r100, 10, r102[10], null);
            PoiType r117 = r115;
            com.bytedance.bdnavigationsdk.pojo.a r118 = r106;
            String r119 = r107;
            String r120 = r108;
            int r121 = r109;
            com.bytedance.bdnavigationsdk.pojo.a r122 = r113;
            PoiType r212 = r116;
            String r123 = r105;
            String r124 = r111;
            int r125 = 2047;
        L29:
            r101.endStructure(r100);
            return new j(r125, r123, r110, r124, r118, r122, r119, r120, r121, r117, r212, r211);
        L5:
            String r126 = null;
            PoiType r127 = null;
            com.bytedance.bdnavigationsdk.pojo.a r128 = null;
            String r129 = null;
            PoiType r130 = null;
            List r131 = null;
            String r132 = null;
            String r213 = null;
            String r214 = null;
            com.bytedance.bdnavigationsdk.pojo.a r215 = null;
            int r133 = 0;
            int r134 = 0;
            boolean r216 = true;
        L6:
            if (r216 == false) goto L28;
            int r135 = r101.decodeElementIndex(r100);
            switch(r135) {
                case -1: goto L27;
                case 0: goto L25;
                case 1: goto L23;
                case 2: goto L22;
                case 3: goto L21;
                case 4: goto L19;
                case 5: goto L17;
                case 6: goto L16;
                case 7: goto L14;
                case 8: goto L13;
                case 9: goto L12;
                case 10: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r135);
        L27:
            r103 = 8;
            r104 = 10;
            r216 = false;
            goto L6
        L11:
            r133 = r133 | 1024;
            r131 = (List) r101.decodeNullableSerializableElement(r100, r104, r102[r104], r131);
            goto L6
        L12:
            r133 = r133 | 512;
            r130 = (PoiType) r101.decodeNullableSerializableElement(r100, 9, r102[9], r130);
            goto L6
        L13:
            r127 = (PoiType) r101.decodeNullableSerializableElement(r100, r103, r102[r103], r127);
            r133 = r133 | 256;
            goto L6
        L14:
            r134 = r101.decodeIntElement(r100, 7);
            r133 = r133 | 128;
            goto L6
        L16:
            r129 = (String) r101.decodeNullableSerializableElement(r100, 6, v2.f520790a, r129);
            r133 = r133 | 64;
        L26:
            r103 = 8;
            r104 = 10;
            goto L6
        L17:
            r126 = (String) r101.decodeNullableSerializableElement(r100, 5, v2.f520790a, r126);
            r133 = r133 | 32;
            goto L26
        L19:
            r128 = (com.bytedance.bdnavigationsdk.pojo.a) r101.decodeSerializableElement(r100, 4, com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a, r128);
            r133 = r133 | 16;
            goto L26
        L21:
            r215 = (com.bytedance.bdnavigationsdk.pojo.a) r101.decodeSerializableElement(r100, 3, com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a, r215);
            r133 = r133 | 8;
            goto L26
        L22:
            r132 = r101.decodeStringElement(r100, 2);
            r133 = r133 | 4;
            goto L26
        L23:
            r214 = r101.decodeStringElement(r100, 1);
            r133 = r133 | 2;
            goto L26
        L25:
            r213 = r101.decodeStringElement(r100, 0);
            r133 = r133 | 1;
            goto L26
        L28:
            r118 = r215;
            r119 = r126;
            r120 = r129;
            r121 = r134;
            r123 = r213;
            r122 = r128;
            r212 = r130;
            r110 = r214;
            r125 = r133;
            r211 = r131;
            r124 = r132;
            r117 = r127;
            goto L29
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            j r102 = (j) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f200250b;
            muc.d r104 = r100.beginStructure(r103);
            juc.d<Object>[] r105 = j.f200237l;
            boolean r106 = false;
            r104.encodeStringElement(r103, 0, r102.f200238a);
            r104.encodeStringElement(r103, 1, r102.f200239b);
            r104.encodeStringElement(r103, 2, r102.f200240c);
            com.bytedance.bdnavigationsdk.pojo.a.C2885a r107 = com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a;
            r104.encodeSerializableElement(r103, 3, r107, r102.f200241d);
            r104.encodeSerializableElement(r103, 4, r107, r102.f200242e);
            if (r104.shouldEncodeElementDefault(r103, 5) == false) goto L6;
        L7:
            boolean r108 = true;
        L9:
            if (r108 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 5, v2.f520790a, r102.f200243f);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 6) == false) goto L15;
        L16:
            boolean r109 = true;
        L18:
            if (r109 == false) goto L21;
            r104.encodeNullableSerializableElement(r103, 6, v2.f520790a, r102.f200244g);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 7) == false) goto L24;
        L25:
            boolean r110 = true;
        L27:
            if (r110 == false) goto L30;
            r104.encodeIntElement(r103, 7, r102.f200245h);
        L30:
            if (r104.shouldEncodeElementDefault(r103, 8) == false) goto L33;
        L34:
            boolean r111 = true;
        L36:
            if (r111 == false) goto L39;
            r104.encodeNullableSerializableElement(r103, 8, r105[8], r102.f200246i);
        L39:
            if (r104.shouldEncodeElementDefault(r103, 9) == false) goto L42;
        L43:
            boolean r112 = true;
        L45:
            if (r112 == false) goto L48;
            r104.encodeNullableSerializableElement(r103, 9, r105[9], r102.f200247j);
        L48:
            if (r104.shouldEncodeElementDefault(r103, 10) == false) goto L51;
        L52:
            r106 = true;
        L53:
            if (r106 == false) goto L55;
            r104.encodeNullableSerializableElement(r103, 10, r105[10], r102.f200248k);
        L55:
            r104.endStructure(r103);
            return;
        L51:
            if (r102.f200248k == null) goto L53;
        L42:
            if (r102.f200247j != null) goto L43;
            r112 = false;
            goto L45
        L33:
            if (r102.f200246i != null) goto L34;
            r111 = false;
            goto L36
        L24:
            if (r102.f200245h != 1) goto L25;
            r110 = false;
            goto L27
        L15:
            if (r102.f200244g != null) goto L16;
            r109 = false;
            goto L18
        L6:
            if (r102.f200243f != null) goto L7;
            r108 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<j> serializer() {
            return a.f200249a;
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
        if (Intrinsics.areEqual(this.f200238a, r101.f200238a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f200239b, r101.f200239b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f200240c, r101.f200240c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f200241d, r101.f200241d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f200242e, r101.f200242e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f200243f, r101.f200243f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f200244g, r101.f200244g) == true) goto L30;
        return false;
    L30:
        if (this.f200245h == r101.f200245h) goto L33;
        return false;
    L33:
        if (this.f200246i == r101.f200246i) goto L36;
        return false;
    L36:
        if (this.f200247j == r101.f200247j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f200248k, r101.f200248k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f200238a.hashCode() * 31) + this.f200239b.hashCode()) * 31) + this.f200240c.hashCode()) * 31) + this.f200241d.hashCode()) * 31) + this.f200242e.hashCode()) * 31;
        String r101 = this.f200243f;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f200244g;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.f200245h) * 31;
        PoiType r108 = this.f200246i;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        PoiType r111 = this.f200247j;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        List<v> r114 = this.f200248k;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
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

    static {
        Companion = new b();
        PoiType.a r100 = PoiType.Companion;
        f200237l = new juc.d[]{null, null, null, null, null, null, null, null, r100.serializer(), r100.serializer(), new nuc.f(v.a.f200297a)};
    }

    public final String toString() {
        return "RoutePlanParam{sessionId='" + this.f200238a + "', businessId='" + this.f200239b + "', planType='" + this.f200240c + "', origin=" + this.f200241d + ", destination=" + this.f200242e + ", originId='" + this.f200243f + "', destinationId='" + this.f200244g + "', alternativeRoute=" + this.f200245h + ", originIdType='" + this.f200246i + "', destinationIdType='" + this.f200247j + "', wayPoints=" + this.f200248k + com.alipay.sdk.m.u.i.f25855d;
    }

    public /* synthetic */ j(String r110, String r111, String r112, com.bytedance.bdnavigationsdk.pojo.a r113, com.bytedance.bdnavigationsdk.pojo.a r114, String r115, int r116, PoiType r210, List r211, int r212) {
        if ((r212 & 64) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r212 & 128) == 0) goto L9;
        int r101 = 1;
    L11:
        if ((r212 & 512) == 0) goto L13;
        PoiType r117 = null;
    L15:
        if ((r212 & 1024) == 0) goto L17;
        List r118 = null;
    L18:
        this(r110, r111, r112, r113, r114, null, r100, r101, null, r117, r118);
        return;
    L17:
        r118 = r211;
        goto L18
    L13:
        r117 = r210;
        goto L15
    L9:
        r101 = r116;
        goto L11
    L5:
        r100 = r115;
        goto L7
    }

    public j(String r100, String r101, String r102, com.bytedance.bdnavigationsdk.pojo.a r103, com.bytedance.bdnavigationsdk.pojo.a r104, String r105, String r106, int r107, PoiType r110, PoiType r111, List<v> r112) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r101, "businessId");
        Intrinsics.checkNotNullParameter(r102, "planType");
        Intrinsics.checkNotNullParameter(r103, PlayerResolution.SDKKEY.ORIGIN);
        Intrinsics.checkNotNullParameter(r104, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        this.f200238a = r100;
        this.f200239b = r101;
        this.f200240c = r102;
        this.f200241d = r103;
        this.f200242e = r104;
        this.f200243f = r105;
        this.f200244g = r106;
        this.f200245h = r107;
        this.f200246i = r110;
        this.f200247j = r111;
        this.f200248k = r112;
    }

    public j(int r100, String r101, String r102, String r103, com.bytedance.bdnavigationsdk.pojo.a r104, com.bytedance.bdnavigationsdk.pojo.a r105, String r110, String r111, int r112, PoiType r113, PoiType r114, List r115) {
        if (31 != (r100 & 31)) goto L29;
        this.f200238a = r101;
        this.f200239b = r102;
        this.f200240c = r103;
        this.f200241d = r104;
        this.f200242e = r105;
        if ((r100 & 32) != 0) goto L7;
        this.f200243f = null;
    L9:
        if ((r100 & 64) != 0) goto L11;
        this.f200244g = null;
    L13:
        if ((r100 & 128) != 0) goto L15;
        this.f200245h = 1;
    L17:
        if ((r100 & 256) != 0) goto L19;
        this.f200246i = null;
    L21:
        if ((r100 & 512) != 0) goto L23;
        this.f200247j = null;
    L25:
        if ((r100 & 1024) != 0) goto L27;
        this.f200248k = null;
        return;
    L27:
        this.f200248k = r115;
        return;
    L23:
        this.f200247j = r114;
        goto L25
    L19:
        this.f200246i = r113;
        goto L21
    L15:
        this.f200245h = r112;
        goto L17
    L11:
        this.f200244g = r111;
        goto L13
    L7:
        this.f200243f = r110;
        goto L9
    L29:
        b2.b(r100, 31, a.f200250b);
        throw null;
    }
}
