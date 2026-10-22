package com.bytedance.bdnavigationsdk.navigation;

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
import nuc.l0;
import nuc.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Serializable
public final class k {
    public static final b Companion = null;
    public static final juc.d<Object>[] h = null;
    public final List<com.bytedance.bdnavigationsdk.pojo.a> a;
    public final float b;
    public final float c;
    public final List<com.bytedance.bdnavigationsdk.pojo.a> d;
    public final float e;
    public final float f;
    public List<m> g;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<k> {
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
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.navigation.NavigationProgress", r0, 7);
            r1.j("passed_route", true);
            r1.j("passed_distance", true);
            r1.j("passed_duration", true);
            r1.j("unpassed_route", true);
            r1.j("unpassed_distance", true);
            r1.j("unpassed_duration", true);
            r1.j("to_via_infos", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            juc.d<?>[] r0 = k.h;
            l0 r2 = l0.a;
            return new juc.d[]{kuc.a.d(r0[0]), r2, r2, kuc.a.d(r0[3]), r2, r2, r0[6]};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r21) {
            Intrinsics.checkNotNullParameter(r21, "decoder");
            g2 r1 = b;
            muc.c r0 = r21.beginStructure(r1);
            juc.c[] r2 = k.h;
            int r4 = 5;
            if (r0.decodeSequentially() == false) goto L5;
            List r3 = (List) r0.decodeNullableSerializableElement(r1, 0, r2[0], null);
            float r7 = r0.decodeFloatElement(r1, 1);
            float r5 = r0.decodeFloatElement(r1, 2);
            List r8 = (List) r0.decodeNullableSerializableElement(r1, 3, r2[3], null);
            float r6 = r0.decodeFloatElement(r1, 4);
            float r9 = r0.decodeFloatElement(r1, 5);
            List r14 = (List) r0.decodeSerializableElement(r1, 6, r2[6], null);
            float r13 = r9;
            float r10 = r5;
            float r12 = r6;
            float r11 = r7;
            List r15 = r8;
            int r16 = 127;
            List r17 = r3;
        L22:
            r0.endStructure(r1);
            return new k(r16, r17, r11, r10, r15, r12, r13, r14);
        L5:
            float r18 = 0.0f;
            List r19 = null;
            List r20 = null;
            List r110 = null;
            float r111 = 0.0f;
            r12 = 0.0f;
            float r112 = 0.0f;
            int r113 = 0;
            boolean r114 = true;
        L6:
            if (r114 == false) goto L21;
            int r22 = r0.decodeElementIndex(r1);
            switch(r22) {
                case -1: goto L20;
                case 0: goto L18;
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r22);
        L16:
            r111 = r0.decodeFloatElement(r1, 2);
            r113 = r113 | 4;
            goto L6
        L17:
            r113 = r113 | 2;
            r112 = r0.decodeFloatElement(r1, 1);
            goto L6
        L20:
            r4 = 5;
            r114 = false;
            goto L6
        L11:
            r19 = (List) r0.decodeSerializableElement(r1, 6, r2[6], r19);
            int r23 = r113 | 64;
        L14:
            r113 = r23;
            goto L6
        L12:
            r18 = r0.decodeFloatElement(r1, r4);
            r23 = r113 | 32;
            goto L14
        L13:
            r12 = r0.decodeFloatElement(r1, 4);
            r23 = r113 | 16;
            goto L14
        L15:
            r113 = r113 | 8;
            r20 = (List) r0.decodeNullableSerializableElement(r1, 3, r2[3], r20);
            goto L6
        L18:
            r110 = (List) r0.decodeNullableSerializableElement(r1, 0, r2[0], r110);
            r113 = r113 | 1;
            r4 = 5;
            goto L6
        L21:
            r10 = r111;
            r11 = r112;
            r13 = r18;
            r15 = r20;
            r17 = r110;
            int r115 = r113;
            r14 = r19;
            r16 = r115;
            goto L22
        }

        public final void serialize(muc.f r9, Object r10) {
            k r11 = (k) r10;
            Intrinsics.checkNotNullParameter(r9, "encoder");
            Intrinsics.checkNotNullParameter(r11, "value");
            g2 r0 = b;
            muc.d r12 = r9.beginStructure(r0);
            juc.n[] r1 = k.h;
            boolean r2 = false;
            if (r12.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r12.encodeNullableSerializableElement(r0, 0, r1[0], r11.a);
        L12:
            if (r12.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r12.encodeFloatElement(r0, 1, r11.b);
        L21:
            if (r12.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r6 = true;
        L27:
            if (r6 == false) goto L30;
            r12.encodeFloatElement(r0, 2, r11.c);
        L30:
            if (r12.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r7 = true;
        L36:
            if (r7 == false) goto L39;
            r12.encodeNullableSerializableElement(r0, 3, r1[3], r11.d);
        L39:
            if (r12.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            boolean r8 = true;
        L45:
            if (r8 == false) goto L48;
            r12.encodeFloatElement(r0, 4, r11.e);
        L48:
            if (r12.shouldEncodeElementDefault(r0, 5) == false) goto L51;
        L52:
            boolean r5 = true;
        L54:
            if (r5 == false) goto L57;
            r12.encodeFloatElement(r0, 5, r11.f);
        L57:
            if (r12.shouldEncodeElementDefault(r0, 6) == false) goto L60;
        L61:
            r2 = true;
        L62:
            if (r2 == false) goto L64;
            r12.encodeSerializableElement(r0, 6, r1[6], r11.g);
        L64:
            r12.endStructure(r0);
            return;
        L60:
            if (Intrinsics.areEqual(r11.g, CollectionsKt.emptyList()) == true) goto L62;
        L51:
            if (Float.compare(r11.f, 0.0f) != 0) goto L52;
            r5 = false;
            goto L54
        L42:
            if (Float.compare(r11.e, 0.0f) != 0) goto L43;
            r8 = false;
            goto L45
        L33:
            if (r11.d != null) goto L34;
            r7 = false;
            goto L36
        L24:
            if (Float.compare(r11.c, 0.0f) != 0) goto L25;
            r6 = false;
            goto L27
        L15:
            if (Float.compare(r11.b, 0.0f) != 0) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r11.a != null) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<k> serializer() {
            return a.a;
        }
    }

    public k() {
        this(null, 0.0f, 0.0f, null, 0.0f, 0.0f, CollectionsKt.emptyList());
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k) == true) goto L8;
        return false;
    L8:
        k r6 = (k) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Float.compare(this.b, r6.b) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.c, r6.c) == 0) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Float.compare(this.e, r6.e) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(this.f, r6.f) == 0) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        List<com.bytedance.bdnavigationsdk.pojo.a> r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((((r2 * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31;
        List<com.bytedance.bdnavigationsdk.pojo.a> r4 = this.d;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((((((r3 + r1) * 31) + Float.floatToIntBits(this.e)) * 31) + Float.floatToIntBits(this.f)) * 31) + this.g.hashCode();
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    static {
        Companion = new b();
        com.bytedance.bdnavigationsdk.pojo.a.C0133a r2 = com.bytedance.bdnavigationsdk.pojo.a.C0133a.a;
        h = new juc.d[]{new nuc.f(r2), null, null, new nuc.f(r2), null, null, new nuc.f(m.a.a)};
    }

    public final String toString() {
        return "NavigationProgress{passedRoute=" + this.a + ", passedDistance=" + this.b + ", passedDuration=" + this.c + ", unPassedRoute=" + this.d + ", unPassedDistance=" + this.e + ", unPassedDuration=" + this.f + "}";
    }

    public k(List<com.bytedance.bdnavigationsdk.pojo.a> r2, float r3, float r4, List<com.bytedance.bdnavigationsdk.pojo.a> r5, float r6, float r7, List<m> r8) {
        Intrinsics.checkNotNullParameter(r8, "toViaInfos");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }

    public k(int r3, List r4, float r5, float r6, List r7, float r8, float r9, List r10) {
        if ((r3 & 0) == 0) goto L5;
        b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r3 & 2) != 0) goto L11;
        this.b = 0.0f;
    L13:
        if ((r3 & 4) != 0) goto L15;
        this.c = 0.0f;
    L17:
        if ((r3 & 8) != 0) goto L19;
        this.d = null;
    L21:
        if ((r3 & 16) != 0) goto L23;
        this.e = 0.0f;
    L25:
        if ((r3 & 32) != 0) goto L27;
        this.f = 0.0f;
    L29:
        if ((r3 & 64) != 0) goto L31;
        this.g = CollectionsKt.emptyList();
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
