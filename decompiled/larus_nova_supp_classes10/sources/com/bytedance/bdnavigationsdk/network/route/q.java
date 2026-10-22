package com.bytedance.bdnavigationsdk.network.route;

import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.l0;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Serializable
public final class q {
    public static final b Companion = null;
    public static final juc.d<Object>[] h = null;
    public final String a;
    public final String b;
    public final float c;
    public final e d;
    public final List<t> e;
    public final List<r> f;
    public final List<com.bytedance.bdnavigationsdk.pojo.a> g;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<q> {
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
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.network.route.RouteStep", r0, 7);
            r1.j("orientation", true);
            r1.j("road_name", true);
            r1.j("step_distance", true);
            r1.j("cost", true);
            r1.j("visual_instructions", true);
            r1.j("verbal_instructions", true);
            r1.j("polyline", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            juc.d<Object>[] r0 = q.h;
            v2 r2 = v2.a;
            return new juc.d[]{kuc.a.d(r2), kuc.a.d(r2), l0.a, kuc.a.d(f.a), kuc.a.d(r0[4]), kuc.a.d(r0[5]), kuc.a.d(com.bytedance.bdnavigationsdk.network.route.a.a)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r20) {
            Intrinsics.checkNotNullParameter(r20, "decoder");
            g2 r1 = b;
            muc.c r0 = r20.beginStructure(r1);
            juc.c[] r2 = q.h;
            int r4 = 4;
            int r5 = 3;
            if (r0.decodeSequentially() == false) goto L5;
            v2 r3 = v2.a;
            String r8 = (String) r0.decodeNullableSerializableElement(r1, 0, r3, null);
            String r6 = (String) r0.decodeNullableSerializableElement(r1, 1, r3, null);
            float r7 = r0.decodeFloatElement(r1, 2);
            e r9 = (e) r0.decodeNullableSerializableElement(r1, 3, f.a, null);
            List r10 = (List) r0.decodeNullableSerializableElement(r1, 4, r2[4], null);
            List r17 = (List) r0.decodeNullableSerializableElement(r1, 5, r2[5], null);
            String r13 = r6;
            List r16 = r10;
            e r15 = r9;
            List r18 = (List) r0.decodeNullableSerializableElement(r1, 6, com.bytedance.bdnavigationsdk.network.route.a.a, null);
            float r14 = r7;
            String r12 = r8;
            int r11 = 127;
        L24:
            r0.endStructure(r1);
            return new q(r11, r12, r13, r14, r15, r16, r17, r18);
        L5:
            float r19 = 0.0f;
            e r21 = null;
            String r110 = null;
            List r111 = null;
            List r112 = null;
            List r113 = null;
            String r114 = null;
            r11 = 0;
            boolean r115 = true;
        L6:
            if (r115 == false) goto L23;
            int r22 = r0.decodeElementIndex(r1);
            switch(r22) {
                case -1: goto L22;
                case 0: goto L19;
                case 1: goto L18;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r22);
        L22:
            r4 = 4;
            r5 = 3;
            r115 = false;
            goto L6
        L11:
            r11 = r11 | 64;
            r113 = (List) r0.decodeNullableSerializableElement(r1, 6, com.bytedance.bdnavigationsdk.network.route.a.a, r113);
        L21:
            r4 = 4;
            r5 = 3;
            goto L6
        L12:
            r11 = r11 | 32;
            r111 = (List) r0.decodeNullableSerializableElement(r1, 5, r2[5], r111);
            goto L21
        L13:
            r11 = r11 | 16;
            r112 = (List) r0.decodeNullableSerializableElement(r1, r4, r2[r4], r112);
            goto L21
        L14:
            r21 = (e) r0.decodeNullableSerializableElement(r1, r5, f.a, r21);
            int r23 = r11 | 8;
        L16:
            r11 = r23;
            goto L21
        L15:
            r19 = r0.decodeFloatElement(r1, 2);
            r23 = r11 | 4;
            goto L16
        L18:
            r110 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r110);
            int r24 = r11 | 2;
        L20:
            r11 = r24;
            goto L21
        L19:
            r114 = (String) r0.decodeNullableSerializableElement(r1, 0, v2.a, r114);
            r24 = r11 | 1;
            goto L20
        L23:
            String r25 = r114;
            r17 = r111;
            r16 = r112;
            r18 = r113;
            r14 = r19;
            r15 = r21;
            r13 = r110;
            r12 = r25;
            goto L24
        }

        public final void serialize(muc.f r8, Object r9) {
            q r10 = (q) r9;
            Intrinsics.checkNotNullParameter(r8, "encoder");
            Intrinsics.checkNotNullParameter(r10, "value");
            g2 r0 = b;
            muc.d r11 = r8.beginStructure(r0);
            juc.n[] r1 = q.h;
            boolean r2 = false;
            if (r11.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r11.encodeNullableSerializableElement(r0, 0, v2.a, r10.a);
        L12:
            if (r11.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r11.encodeNullableSerializableElement(r0, 1, v2.a, r10.b);
        L21:
            if (r11.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r11.encodeFloatElement(r0, 2, r10.c);
        L30:
            if (r11.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r11.encodeNullableSerializableElement(r0, 3, f.a, r10.d);
        L39:
            if (r11.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            boolean r7 = true;
        L45:
            if (r7 == false) goto L48;
            r11.encodeNullableSerializableElement(r0, 4, r1[4], r10.e);
        L48:
            if (r11.shouldEncodeElementDefault(r0, 5) == false) goto L51;
        L52:
            boolean r12 = true;
        L54:
            if (r12 == false) goto L57;
            r11.encodeNullableSerializableElement(r0, 5, r1[5], r10.f);
        L57:
            if (r11.shouldEncodeElementDefault(r0, 6) == false) goto L60;
        L61:
            r2 = true;
        L62:
            if (r2 == false) goto L64;
            r11.encodeNullableSerializableElement(r0, 6, com.bytedance.bdnavigationsdk.network.route.a.a, r10.g);
        L64:
            r11.endStructure(r0);
            return;
        L60:
            if (r10.g == null) goto L62;
        L51:
            if (r10.f != null) goto L52;
            r12 = false;
            goto L54
        L42:
            if (r10.e != null) goto L43;
            r7 = false;
            goto L45
        L33:
            if (r10.d != null) goto L34;
            r6 = false;
            goto L36
        L24:
            if (Float.compare(r10.c, 0.0f) != 0) goto L25;
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

        public final juc.d<q> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof q) == true) goto L8;
        return false;
    L8:
        q r6 = (q) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Float.compare(this.c, r6.c) == 0) goto L18;
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
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((r3 + r5) * 31) + Float.floatToIntBits(this.c)) * 31;
        e r7 = this.d;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<t> r10 = this.e;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        List<r> r13 = this.f;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        List<com.bytedance.bdnavigationsdk.pojo.a> r16 = this.g;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    static {
        Companion = new b();
        h = new juc.d[]{null, null, null, null, new nuc.f(t.a.a), new nuc.f(r.a.a), null};
    }

    public final String toString() {
        return "Step{orientation='" + this.a + "', roadName='" + this.b + "', stepDistance=" + this.c + ", cost=" + this.d + ", polyline=" + this.g + "}";
    }

    public q() {
        this.a = null;
        this.b = null;
        this.c = 0.0f;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
    }

    public q(int r3, String r4, String r5, float r6, e r7, List r8, List r9, List r10) {
        if ((r3 & 0) == 0) goto L5;
        b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r3 & 2) != 0) goto L11;
        this.b = null;
    L13:
        if ((r3 & 4) != 0) goto L15;
        this.c = 0.0f;
    L17:
        if ((r3 & 8) != 0) goto L19;
        this.d = null;
    L21:
        if ((r3 & 16) != 0) goto L23;
        this.e = null;
    L25:
        if ((r3 & 32) != 0) goto L27;
        this.f = null;
    L29:
        if ((r3 & 64) != 0) goto L31;
        this.g = null;
        return;
    L31:
        this.g = r10;
        return;
    L27:
        this.f = r9;
        goto L29
    L23:
        this.e = r8;
        goto L25
    L19:
        this.d = r7;
        goto L21
    L15:
        this.c = r6;
        goto L17
    L11:
        this.b = r5;
        goto L13
    L7:
        this.a = r4;
        goto L9
    }
}
