package com.bytedance.bdnavigationsdk.network.route;

import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Serializable
public final class j {
    public static final b Companion = null;
    public static final juc.d<Object>[] l = null;
    public final String a;
    public final String b;
    public final String c;
    public final com.bytedance.bdnavigationsdk.pojo.a d;
    public final com.bytedance.bdnavigationsdk.pojo.a e;
    public final String f;
    public final String g;
    public final int h;
    public final PoiType i;
    public final PoiType j;
    public final List<v> k;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<j> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.network.route.RoutePlanParam", r0, 11);
            r1.j("session_id", false);
            r1.j("business", false);
            r1.j("plan_type", false);
            r1.j("origin", false);
            r1.j("destination", false);
            r1.j("origin_id", true);
            r1.j("destination_id", true);
            r1.j("alternative_route", true);
            r1.j("origin_id_type", true);
            r1.j("destination_id_type", true);
            r1.j("waypoints", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            juc.d<Object>[] r0 = j.l;
            v2 r2 = v2.a;
            com.bytedance.bdnavigationsdk.pojo.a.C0133a r3 = com.bytedance.bdnavigationsdk.pojo.a.C0133a.a;
            return new juc.d[]{r2, r2, r2, r3, r3, kuc.a.d(r2), kuc.a.d(r2), w0.a, kuc.a.d(r0[8]), kuc.a.d(r0[9]), kuc.a.d(r0[10])};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r25) {
            Intrinsics.checkNotNullParameter(r25, "decoder");
            g2 r1 = b;
            muc.c r0 = r25.beginStructure(r1);
            juc.c[] r2 = j.l;
            int r4 = 8;
            int r5 = 10;
            if (r0.decodeSequentially() == false) goto L5;
            String r3 = r0.decodeStringElement(r1, 0);
            String r12 = r0.decodeStringElement(r1, 1);
            String r10 = r0.decodeStringElement(r1, 2);
            com.bytedance.bdnavigationsdk.pojo.a.C0133a r13 = com.bytedance.bdnavigationsdk.pojo.a.C0133a.a;
            com.bytedance.bdnavigationsdk.pojo.a r6 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeSerializableElement(r1, 3, r13, null);
            com.bytedance.bdnavigationsdk.pojo.a r11 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeSerializableElement(r1, 4, r13, null);
            v2 r14 = v2.a;
            String r7 = (String) r0.decodeNullableSerializableElement(r1, 5, r14, null);
            String r8 = (String) r0.decodeNullableSerializableElement(r1, 6, r14, null);
            int r9 = r0.decodeIntElement(r1, 7);
            PoiType r15 = (PoiType) r0.decodeNullableSerializableElement(r1, 8, r2[8], null);
            PoiType r16 = (PoiType) r0.decodeNullableSerializableElement(r1, 9, r2[9], null);
            List r21 = (List) r0.decodeNullableSerializableElement(r1, 10, r2[10], null);
            PoiType r19 = r15;
            com.bytedance.bdnavigationsdk.pojo.a r17 = r6;
            String r18 = r7;
            String r110 = r8;
            int r111 = r9;
            com.bytedance.bdnavigationsdk.pojo.a r112 = r11;
            PoiType r20 = r16;
            String r113 = r3;
            String r114 = r10;
            int r115 = 2047;
        L29:
            r0.endStructure(r1);
            return new j(r115, r113, r12, r114, r17, r112, r18, r110, r111, r19, r20, r21);
        L5:
            String r22 = null;
            PoiType r23 = null;
            com.bytedance.bdnavigationsdk.pojo.a r116 = null;
            String r117 = null;
            PoiType r118 = null;
            List r119 = null;
            String r120 = null;
            String r24 = null;
            String r26 = null;
            com.bytedance.bdnavigationsdk.pojo.a r27 = null;
            int r28 = 0;
            int r121 = 0;
            boolean r29 = true;
        L6:
            if (r29 == false) goto L28;
            int r30 = r0.decodeElementIndex(r1);
            switch(r30) {
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
            throw new UnknownFieldException(r30);
        L27:
            r4 = 8;
            r5 = 10;
            r29 = false;
            goto L6
        L11:
            List r31 = (List) r0.decodeNullableSerializableElement(r1, r5, r2[r5], r119);
            r28 = r28 | DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION;
            r119 = r31;
            goto L6
        L12:
            PoiType r32 = (PoiType) r0.decodeNullableSerializableElement(r1, 9, r2[9], r118);
            r28 = r28 | DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE;
            r118 = r32;
            goto L6
        L13:
            r23 = (PoiType) r0.decodeNullableSerializableElement(r1, r4, r2[r4], r23);
            r28 = r28 | DeviceStatus$DiffDimension.DIFF_LOCATION_MODE;
            goto L6
        L14:
            r121 = r0.decodeIntElement(r1, 7);
            r28 = r28 | DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE;
            goto L6
        L16:
            r117 = (String) r0.decodeNullableSerializableElement(r1, 6, v2.a, r117);
            r28 = r28 | 64;
        L26:
            r4 = 8;
            r5 = 10;
            goto L6
        L17:
            r22 = (String) r0.decodeNullableSerializableElement(r1, 5, v2.a, r22);
            r28 = r28 | 32;
            goto L26
        L19:
            r116 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeSerializableElement(r1, 4, com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, r116);
            r28 = r28 | 16;
            goto L26
        L21:
            r27 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeSerializableElement(r1, 3, com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, r27);
            r28 = r28 | 8;
            goto L26
        L22:
            r120 = r0.decodeStringElement(r1, 2);
            r28 = r28 | 4;
            goto L26
        L23:
            r26 = r0.decodeStringElement(r1, 1);
            r28 = r28 | 2;
            goto L26
        L25:
            r24 = r0.decodeStringElement(r1, 0);
            r28 = r28 | 1;
            goto L26
        L28:
            r17 = r27;
            r18 = r22;
            r110 = r117;
            r111 = r121;
            r113 = r24;
            r112 = r116;
            r20 = r118;
            r12 = r26;
            r115 = r28;
            r21 = r119;
            r114 = r120;
            r19 = r23;
            goto L29
        }

        public final void serialize(muc.f r8, Object r9) {
            j r10 = (j) r9;
            Intrinsics.checkNotNullParameter(r8, "encoder");
            Intrinsics.checkNotNullParameter(r10, "value");
            g2 r0 = b;
            muc.d r11 = r8.beginStructure(r0);
            juc.n[] r1 = j.l;
            boolean r3 = false;
            r11.encodeStringElement(r0, 0, r10.a);
            r11.encodeStringElement(r0, 1, r10.b);
            r11.encodeStringElement(r0, 2, r10.c);
            com.bytedance.bdnavigationsdk.pojo.a.C0133a r2 = com.bytedance.bdnavigationsdk.pojo.a.C0133a.a;
            r11.encodeSerializableElement(r0, 3, r2, r10.d);
            r11.encodeSerializableElement(r0, 4, r2, r10.e);
            if (r11.shouldEncodeElementDefault(r0, 5) == false) goto L6;
        L7:
            boolean r5 = true;
        L9:
            if (r5 == false) goto L12;
            r11.encodeNullableSerializableElement(r0, 5, v2.a, r10.f);
        L12:
            if (r11.shouldEncodeElementDefault(r0, 6) == false) goto L15;
        L16:
            boolean r6 = true;
        L18:
            if (r6 == false) goto L21;
            r11.encodeNullableSerializableElement(r0, 6, v2.a, r10.g);
        L21:
            if (r11.shouldEncodeElementDefault(r0, 7) == false) goto L24;
        L25:
            boolean r7 = true;
        L27:
            if (r7 == false) goto L30;
            r11.encodeIntElement(r0, 7, r10.h);
        L30:
            if (r11.shouldEncodeElementDefault(r0, 8) == false) goto L33;
        L34:
            boolean r12 = true;
        L36:
            if (r12 == false) goto L39;
            r11.encodeNullableSerializableElement(r0, 8, r1[8], r10.i);
        L39:
            if (r11.shouldEncodeElementDefault(r0, 9) == false) goto L42;
        L43:
            boolean r13 = true;
        L45:
            if (r13 == false) goto L48;
            r11.encodeNullableSerializableElement(r0, 9, r1[9], r10.j);
        L48:
            if (r11.shouldEncodeElementDefault(r0, 10) == false) goto L51;
        L52:
            r3 = true;
        L53:
            if (r3 == false) goto L55;
            r11.encodeNullableSerializableElement(r0, 10, r1[10], r10.k);
        L55:
            r11.endStructure(r0);
            return;
        L51:
            if (r10.k == null) goto L53;
        L42:
            if (r10.j != null) goto L43;
            r13 = false;
            goto L45
        L33:
            if (r10.i != null) goto L34;
            r12 = false;
            goto L36
        L24:
            if (r10.h != 1) goto L25;
            r7 = false;
            goto L27
        L15:
            if (r10.g != null) goto L16;
            r6 = false;
            goto L18
        L6:
            if (r10.f != null) goto L7;
            r5 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<j> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r6 = (j) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
        return false;
    L30:
        if (this.h == r6.h) goto L33;
        return false;
    L33:
        if (this.i == r6.i) goto L36;
        return false;
    L36:
        if (this.j == r6.j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r6.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        String r1 = this.f;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.g;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + this.h) * 31;
        PoiType r8 = this.i;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        PoiType r11 = this.j;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        List<v> r14 = this.k;
        if (r14 == null) goto L23;
        r2 = r14.hashCode();
    L23:
        return r13 + r2;
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    static {
        Companion = new b();
        PoiType.a r1 = PoiType.Companion;
        l = new juc.d[]{null, null, null, null, null, null, null, null, r1.serializer(), r1.serializer(), new nuc.f(v.a.a)};
    }

    public final String toString() {
        return "RoutePlanParam{sessionId='" + this.a + "', businessId='" + this.b + "', planType='" + this.c + "', origin=" + this.d + ", destination=" + this.e + ", originId='" + this.f + "', destinationId='" + this.g + "', alternativeRoute=" + this.h + ", originIdType='" + this.i + "', destinationIdType='" + this.j + "', wayPoints=" + this.k + "}";
    }

    public /* synthetic */ j(String r13, String r14, String r15, com.bytedance.bdnavigationsdk.pojo.a r16, com.bytedance.bdnavigationsdk.pojo.a r17, String r18, int r19, PoiType r20, List r21, int r22) {
        if ((r22 & 64) == 0) goto L5;
        String r7 = null;
    L7:
        if ((r22 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) == 0) goto L9;
        int r8 = 1;
    L11:
        if ((r22 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) == 0) goto L13;
        PoiType r10 = null;
    L15:
        if ((r22 & DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION) == 0) goto L17;
        List r11 = null;
    L18:
        this(r13, r14, r15, r16, r17, null, r7, r8, null, r10, r11);
        return;
    L17:
        r11 = r21;
        goto L18
    L13:
        r10 = r20;
        goto L15
    L9:
        r8 = r19;
        goto L11
    L5:
        r7 = r18;
        goto L7
    }

    public j(String r2, String r3, String r4, com.bytedance.bdnavigationsdk.pojo.a r5, com.bytedance.bdnavigationsdk.pojo.a r6, String r7, String r8, int r9, PoiType r10, PoiType r11, List<v> r12) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        Intrinsics.checkNotNullParameter(r3, "businessId");
        Intrinsics.checkNotNullParameter(r4, "planType");
        Intrinsics.checkNotNullParameter(r5, "origin");
        Intrinsics.checkNotNullParameter(r6, "destination");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = r12;
    }

    public j(int r4, String r5, String r6, String r7, com.bytedance.bdnavigationsdk.pojo.a r8, com.bytedance.bdnavigationsdk.pojo.a r9, String r10, String r11, int r12, PoiType r13, PoiType r14, List r15) {
        if (31 != (r4 & 31)) goto L29;
        this.a = r5;
        this.b = r6;
        this.c = r7;
        this.d = r8;
        this.e = r9;
        if ((r4 & 32) != 0) goto L7;
        this.f = null;
    L9:
        if ((r4 & 64) != 0) goto L11;
        this.g = null;
    L13:
        if ((r4 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) != 0) goto L15;
        this.h = 1;
    L17:
        if ((r4 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) != 0) goto L19;
        this.i = null;
    L21:
        if ((r4 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) != 0) goto L23;
        this.j = null;
    L25:
        if ((r4 & DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION) != 0) goto L27;
        this.k = null;
        return;
    L27:
        this.k = r15;
        return;
    L23:
        this.j = r14;
        goto L25
    L19:
        this.i = r13;
        goto L21
    L15:
        this.h = r12;
        goto L17
    L11:
        this.g = r11;
        goto L13
    L7:
        this.f = r10;
        goto L9
    L29:
        b2.b(r4, 31, a.b);
        throw null;
    }
}
