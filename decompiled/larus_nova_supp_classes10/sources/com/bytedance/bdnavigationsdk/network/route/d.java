package com.bytedance.bdnavigationsdk.network.route;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.collections.CollectionsKt;
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
public final class d {
    public static final b Companion = null;
    public static final juc.d<Object>[] f = null;
    public final com.bytedance.bdnavigationsdk.pojo.a a;
    public final com.bytedance.bdnavigationsdk.pojo.a b;
    public final String c;
    public final List<RoutePath> d;
    public List<v> e;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<d> {
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
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.network.route.Route", r0, 5);
            r1.j("origin", true);
            r1.j("destination", true);
            r1.j("session_id", false);
            r1.j("paths", true);
            r1.j("waypoints", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            juc.d<?>[] r0 = d.f;
            com.bytedance.bdnavigationsdk.network.route.b r2 = com.bytedance.bdnavigationsdk.network.route.b.a;
            return new juc.d[]{kuc.a.d(r2), kuc.a.d(r2), v2.a, kuc.a.d(r0[3]), r0[4]};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r24) {
            Intrinsics.checkNotNullParameter(r24, "decoder");
            g2 r1 = b;
            muc.c r0 = r24.beginStructure(r1);
            juc.c[] r2 = d.f;
            com.bytedance.bdnavigationsdk.pojo.a r9 = null;
            if (r0.decodeSequentially() == false) goto L5;
            com.bytedance.bdnavigationsdk.network.route.b r3 = com.bytedance.bdnavigationsdk.network.route.b.a;
            com.bytedance.bdnavigationsdk.pojo.a r7 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeNullableSerializableElement(r1, 0, r3, null);
            com.bytedance.bdnavigationsdk.pojo.a r4 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeNullableSerializableElement(r1, 1, r3, null);
            String r5 = r0.decodeStringElement(r1, 2);
            List r6 = (List) r0.decodeNullableSerializableElement(r1, 3, r2[3], null);
            List r22 = (List) r0.decodeSerializableElement(r1, 4, r2[4], null);
            com.bytedance.bdnavigationsdk.pojo.a r19 = r4;
            String r20 = r5;
            List r21 = r6;
            com.bytedance.bdnavigationsdk.pojo.a r18 = r7;
            int r17 = 31;
        L25:
            r0.endStructure(r1);
            return new d(r17, r18, r19, r20, r21, r22);
        L5:
            com.bytedance.bdnavigationsdk.pojo.a r10 = null;
            String r11 = null;
            List r12 = null;
            List r13 = null;
            int r8 = 0;
            boolean r14 = true;
        L6:
            if (r14 == false) goto L24;
            int r15 = r0.decodeElementIndex(r1);
            if (r15 != (-1)) goto L9;
            r14 = false;
            goto L6
        L9:
            if (r15 == 0) goto L21;
            if (r15 == 1) goto L19;
            if (r15 == 2) goto L18;
            if (r15 == 3) goto L17;
            if (r15 != 4) goto L16;
            r13 = (List) r0.decodeSerializableElement(r1, 4, r2[4], r13);
            r8 = r8 | 16;
            goto L6
        L16:
            throw new UnknownFieldException(r15);
        L17:
            r12 = (List) r0.decodeNullableSerializableElement(r1, 3, r2[3], r12);
            r8 = r8 | 8;
            goto L6
        L18:
            r11 = r0.decodeStringElement(r1, 2);
            r8 = r8 | 4;
            goto L6
        L19:
            r10 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeNullableSerializableElement(r1, 1, com.bytedance.bdnavigationsdk.network.route.b.a, r10);
            r8 = r8 | 2;
            goto L6
        L21:
            r8 = r8 | 1;
            r9 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeNullableSerializableElement(r1, 0, com.bytedance.bdnavigationsdk.network.route.b.a, r9);
            goto L6
        L24:
            r17 = r8;
            r18 = r9;
            r19 = r10;
            r20 = r11;
            r21 = r12;
            r22 = r13;
            goto L25
        }

        public final void serialize(muc.f r8, Object r9) {
            d r10 = (d) r9;
            Intrinsics.checkNotNullParameter(r8, "encoder");
            Intrinsics.checkNotNullParameter(r10, "value");
            g2 r0 = b;
            muc.d r11 = r8.beginStructure(r0);
            juc.n[] r1 = d.f;
            boolean r2 = false;
            if (r11.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r11.encodeNullableSerializableElement(r0, 0, com.bytedance.bdnavigationsdk.network.route.b.a, r10.a);
        L12:
            if (r11.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L20;
            r11.encodeNullableSerializableElement(r0, 1, com.bytedance.bdnavigationsdk.network.route.b.a, r10.b);
        L20:
            r11.encodeStringElement(r0, 2, r10.c);
            if (r11.shouldEncodeElementDefault(r0, 3) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r11.encodeNullableSerializableElement(r0, 3, r1[3], r10.d);
        L30:
            if (r11.shouldEncodeElementDefault(r0, 4) == false) goto L33;
        L34:
            r2 = true;
        L35:
            if (r2 == false) goto L37;
            r11.encodeSerializableElement(r0, 4, r1[4], r10.e);
        L37:
            r11.endStructure(r0);
            return;
        L33:
            if (Intrinsics.areEqual(r10.e, CollectionsKt.emptyList()) == true) goto L35;
        L24:
            if (r10.d != null) goto L25;
            r5 = false;
            goto L27
        L15:
            if (r10.b != null) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r10.a != null) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<d> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L8;
        return false;
    L8:
        d r6 = (d) r5;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        com.bytedance.bdnavigationsdk.pojo.a r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        com.bytedance.bdnavigationsdk.pojo.a r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((r3 + r5) * 31) + this.c.hashCode()) * 31;
        List<RoutePath> r7 = this.d;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return ((r6 + r1) * 31) + this.e.hashCode();
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    static {
        Companion = new b();
        f = new juc.d[]{null, null, null, new nuc.f(RoutePath$$serializer.a), new nuc.f(v.a.a)};
    }

    public final String toString() {
        return "Route{origin=" + this.a + ", destination=" + this.b + ", sessionId='" + this.c + "', paths=" + this.d + ", wayPoints=" + this.e + "}";
    }

    public d(int r4, com.bytedance.bdnavigationsdk.pojo.a r5, com.bytedance.bdnavigationsdk.pojo.a r6, String r7, List r8, List r9) {
        if (4 == (r4 & 4)) goto L5;
        b2.b(r4, 4, a.b);
        throw null;
    L5:
        if ((r4 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r4 & 2) != 0) goto L11;
        this.b = null;
    L12:
        this.c = r7;
        if ((r4 & 8) != 0) goto L15;
        this.d = null;
    L17:
        if ((r4 & 16) != 0) goto L19;
        this.e = CollectionsKt.emptyList();
        return;
    L19:
        this.e = r9;
        return;
    L15:
        this.d = r8;
        goto L17
    L11:
        this.b = r6;
        goto L12
    L7:
        this.a = r5;
        goto L9
    }
}
