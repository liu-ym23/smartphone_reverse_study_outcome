package com.bytedance.bdnavigationsdk.network.route;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Serializable
public final class v {
    public static final b Companion = null;
    public static final juc.d<Object>[] e = null;
    public final com.bytedance.bdnavigationsdk.pojo.a a;
    public final PoiType b;
    public final String c;
    public final String d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<v> {
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
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.network.route.RouteWayPoint", r0, 4);
            r1.j(LocationMonitorConst.LOCATION, false);
            r1.j("id_type", true);
            r1.j("poi_id", true);
            r1.j("name", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            juc.d<Object>[] r0 = v.e;
            v2 r1 = v2.a;
            return new juc.d[]{com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, kuc.a.d(r0[1]), kuc.a.d(r1), kuc.a.d(r1)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r20) {
            Intrinsics.checkNotNullParameter(r20, "decoder");
            g2 r1 = b;
            muc.c r0 = r20.beginStructure(r1);
            juc.c[] r2 = v.e;
            com.bytedance.bdnavigationsdk.pojo.a r8 = null;
            if (r0.decodeSequentially() == false) goto L5;
            com.bytedance.bdnavigationsdk.pojo.a r3 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeSerializableElement(r1, 0, com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, null);
            PoiType r4 = (PoiType) r0.decodeNullableSerializableElement(r1, 1, r2[1], null);
            v2 r5 = v2.a;
            PoiType r16 = r4;
            com.bytedance.bdnavigationsdk.pojo.a r15 = r3;
            String r17 = (String) r0.decodeNullableSerializableElement(r1, 2, r5, null);
            String r18 = (String) r0.decodeNullableSerializableElement(r1, 3, r5, null);
            int r14 = 15;
        L21:
            r0.endStructure(r1);
            return new v(r14, r15, r16, r17, r18);
        L5:
            PoiType r9 = null;
            String r10 = null;
            String r11 = null;
            int r6 = 0;
            boolean r12 = true;
        L6:
            if (r12 == false) goto L20;
            int r13 = r0.decodeElementIndex(r1);
            if (r13 != (-1)) goto L9;
            r12 = false;
            goto L6
        L9:
            if (r13 != 0) goto L10;
            r8 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeSerializableElement(r1, 0, com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, r8);
            r6 = r6 | 1;
            goto L6
        L10:
            if (r13 != 1) goto L11;
            r9 = (PoiType) r0.decodeNullableSerializableElement(r1, 1, r2[1], r9);
            r6 = r6 | 2;
            goto L6
        L11:
            if (r13 != 2) goto L12;
            r10 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r10);
            r6 = r6 | 4;
            goto L6
        L12:
            if (r13 != 3) goto L15;
            r11 = (String) r0.decodeNullableSerializableElement(r1, 3, v2.a, r11);
            r6 = r6 | 8;
            goto L6
        L15:
            throw new UnknownFieldException(r13);
        L20:
            r14 = r6;
            r15 = r8;
            r16 = r9;
            r17 = r10;
            r18 = r11;
            goto L21
        }

        public final void serialize(muc.f r7, Object r8) {
            v r9 = (v) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            juc.n[] r1 = v.e;
            boolean r4 = false;
            r10.encodeSerializableElement(r0, 0, com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, r9.a);
            if (r10.shouldEncodeElementDefault(r0, 1) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeNullableSerializableElement(r0, 1, r1[1], r9.b);
        L12:
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L15;
        L16:
            boolean r5 = true;
        L18:
            if (r5 == false) goto L21;
            r10.encodeNullableSerializableElement(r0, 2, v2.a, r9.c);
        L21:
            if (r10.shouldEncodeElementDefault(r0, 3) == false) goto L24;
        L25:
            r4 = true;
        L26:
            if (r4 == false) goto L28;
            r10.encodeNullableSerializableElement(r0, 3, v2.a, r9.d);
        L28:
            r10.endStructure(r0);
            return;
        L24:
            if (r9.d == null) goto L26;
        L15:
            if (r9.c != null) goto L16;
            r5 = false;
            goto L18
        L6:
            if (r9.b != null) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<v> serializer() {
            return a.a;
        }
    }

    static {
        Companion = new b();
        e = new juc.d[]{null, PoiType.Companion.serializer(), null, null};
    }

    public v(com.bytedance.bdnavigationsdk.pojo.a r2, PoiType r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.LOCATION);
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    public v(int r4, com.bytedance.bdnavigationsdk.pojo.a r5, PoiType r6, String r7, String r8) {
        if (1 != (r4 & 1)) goto L17;
        this.a = r5;
        if ((r4 & 2) != 0) goto L7;
        this.b = null;
    L9:
        if ((r4 & 4) != 0) goto L11;
        this.c = null;
    L13:
        if ((r4 & 8) != 0) goto L15;
        this.d = null;
        return;
    L15:
        this.d = r8;
        return;
    L11:
        this.c = r7;
        goto L13
    L7:
        this.b = r6;
        goto L9
    L17:
        b2.b(r4, 1, a.b);
        throw null;
    }
}
