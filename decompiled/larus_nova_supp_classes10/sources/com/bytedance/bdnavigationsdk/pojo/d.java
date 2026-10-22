package com.bytedance.bdnavigationsdk.pojo;

import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.l0;
import nuc.m0;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Serializable
public final class d {
    public static final b Companion = null;
    public final com.bytedance.bdnavigationsdk.pojo.a a;
    public final com.bytedance.bdnavigationsdk.pojo.a b;
    public int c;
    public int d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<d> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.pojo.Segment", r0, 11);
            r1.j("source", true);
            r1.j("target", true);
            r1.j("sourceIdx", true);
            r1.j("stepIdx", true);
            r1.j("_length", true);
            r1.j("duration", true);
            r1.j("_sDistToStart", true);
            r1.j("_sDistToEnd", true);
            r1.j("_bearing", true);
            r1.j("_turnFrom", true);
            r1.j("_turnTo", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            com.bytedance.bdnavigationsdk.pojo.a.C0133a r1 = com.bytedance.bdnavigationsdk.pojo.a.C0133a.a;
            w0 r2 = w0.a;
            l0 r3 = l0.a;
            return new juc.d[]{kuc.a.d(r1), kuc.a.d(r1), r2, r2, r3, r3, r3, r3, r3, r3, r3};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r27) {
            Intrinsics.checkNotNullParameter(r27, "decoder");
            g2 r1 = b;
            muc.c r0 = r27.beginStructure(r1);
            int r3 = 2;
            int r4 = 4;
            int r5 = 8;
            int r10 = 0;
            if (r0.decodeSequentially() == false) goto L5;
            com.bytedance.bdnavigationsdk.pojo.a.C0133a r2 = com.bytedance.bdnavigationsdk.pojo.a.C0133a.a;
            com.bytedance.bdnavigationsdk.pojo.a r11 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeNullableSerializableElement(r1, 0, r2, null);
            com.bytedance.bdnavigationsdk.pojo.a r6 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeNullableSerializableElement(r1, 1, r2, null);
            int r7 = r0.decodeIntElement(r1, 2);
            int r9 = r0.decodeIntElement(r1, 3);
            float r8 = r0.decodeFloatElement(r1, 4);
            float r12 = r0.decodeFloatElement(r1, 5);
            float r13 = r0.decodeFloatElement(r1, 6);
            float r14 = r0.decodeFloatElement(r1, 7);
            float r15 = r0.decodeFloatElement(r1, 8);
            com.bytedance.bdnavigationsdk.pojo.a r16 = r6;
            int r17 = r7;
            float r18 = r8;
            float r20 = r15;
            float r19 = r14;
            float r21 = r0.decodeFloatElement(r1, 9);
            float r22 = r0.decodeFloatElement(r1, 10);
            int r110 = r9;
            float r111 = r13;
            float r112 = r12;
            int r113 = 2047;
            com.bytedance.bdnavigationsdk.pojo.a r114 = r11;
        L27:
            r0.endStructure(r1);
            return new d(r113, r114, r16, r17, r110, r18, r112, r111, r19, r20, r21, r22);
        L5:
            com.bytedance.bdnavigationsdk.pojo.a r23 = null;
            com.bytedance.bdnavigationsdk.pojo.a r24 = null;
            int r25 = 0;
            float r115 = 0.0f;
            float r116 = 0.0f;
            float r117 = 0.0f;
            float r118 = 0.0f;
            float r119 = 0.0f;
            int r120 = 0;
            float r26 = 0.0f;
            float r28 = 0.0f;
            boolean r29 = true;
        L6:
            if (r29 == false) goto L26;
            int r30 = r0.decodeElementIndex(r1);
            switch(r30) {
                case -1: goto L25;
                case 0: goto L23;
                case 1: goto L21;
                case 2: goto L19;
                case 3: goto L18;
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
            throw new UnknownFieldException(r30);
        L25:
            r3 = 2;
            r4 = 4;
            r5 = 8;
            r29 = false;
            goto L6
        L11:
            r119 = r0.decodeFloatElement(r1, 10);
            int r31 = r10 | DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION;
        L20:
            com.bytedance.bdnavigationsdk.pojo.a r32 = r24;
        L22:
            r10 = r31;
        L24:
            r24 = r32;
            r3 = 2;
            r4 = 4;
            r5 = 8;
            goto L6
        L12:
            r118 = r0.decodeFloatElement(r1, 9);
            r31 = r10 | DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE;
            goto L20
        L13:
            r116 = r0.decodeFloatElement(r1, r5);
            r31 = r10 | DeviceStatus$DiffDimension.DIFF_LOCATION_MODE;
            goto L20
        L14:
            r117 = r0.decodeFloatElement(r1, 7);
            r31 = r10 | DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE;
            goto L20
        L15:
            r26 = r0.decodeFloatElement(r1, 6);
            r31 = r10 | 64;
            goto L20
        L16:
            r28 = r0.decodeFloatElement(r1, 5);
            r31 = r10 | 32;
            goto L20
        L17:
            r115 = r0.decodeFloatElement(r1, r4);
            r31 = r10 | 16;
            goto L20
        L18:
            r120 = r0.decodeIntElement(r1, 3);
            r31 = r10 | 8;
            goto L20
        L19:
            r25 = r0.decodeIntElement(r1, r3);
            r31 = r10 | 4;
            goto L20
        L21:
            r32 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeNullableSerializableElement(r1, 1, com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, r24);
            r31 = r10 | 2;
            goto L22
        L23:
            r32 = r24;
            r23 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeNullableSerializableElement(r1, 0, com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, r23);
            r10 = r10 | 1;
            goto L24
        L26:
            r16 = r24;
            r114 = r23;
            r113 = r10;
            r22 = r119;
            r111 = r26;
            r20 = r116;
            r110 = r120;
            r19 = r117;
            r18 = r115;
            r17 = r25;
            float r210 = r28;
            r21 = r118;
            r112 = r210;
            goto L27
        }

        public final void serialize(muc.f r7, Object r8) {
            d r9 = (d) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            b r1 = d.Companion;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeNullableSerializableElement(r0, 0, com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, r9.a);
        L12:
            if (r10.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r10.encodeNullableSerializableElement(r0, 1, com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, r9.b);
        L21:
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r10.encodeIntElement(r0, 2, r9.c);
        L30:
            if (r10.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r10.encodeIntElement(r0, 3, r9.d);
        L39:
            if (r10.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            boolean r11 = true;
        L45:
            if (r11 == false) goto L48;
            r10.encodeFloatElement(r0, 4, r9.e);
        L48:
            if (r10.shouldEncodeElementDefault(r0, 5) == false) goto L51;
        L52:
            boolean r12 = true;
        L54:
            if (r12 == false) goto L57;
            r10.encodeFloatElement(r0, 5, r9.f);
        L57:
            if (r10.shouldEncodeElementDefault(r0, 6) == false) goto L60;
        L61:
            boolean r13 = true;
        L63:
            if (r13 == false) goto L66;
            r10.encodeFloatElement(r0, 6, r9.g);
        L66:
            if (r10.shouldEncodeElementDefault(r0, 7) == false) goto L69;
        L70:
            boolean r14 = true;
        L72:
            if (r14 == false) goto L75;
            r10.encodeFloatElement(r0, 7, r9.h);
        L75:
            if (r10.shouldEncodeElementDefault(r0, 8) == false) goto L78;
        L79:
            boolean r15 = true;
        L81:
            if (r15 == false) goto L84;
            r10.encodeFloatElement(r0, 8, r9.i);
        L84:
            if (r10.shouldEncodeElementDefault(r0, 9) == false) goto L87;
        L88:
            boolean r16 = true;
        L90:
            if (r16 == false) goto L93;
            r10.encodeFloatElement(r0, 9, r9.j);
        L93:
            if (r10.shouldEncodeElementDefault(r0, 10) == false) goto L96;
        L97:
            r2 = true;
        L98:
            if (r2 == false) goto L100;
            r10.encodeFloatElement(r0, 10, r9.k);
        L100:
            r10.endStructure(r0);
            return;
        L96:
            if (Float.compare(r9.k, 0.0f) == 0) goto L98;
        L87:
            if (Float.compare(r9.j, 0.0f) != 0) goto L88;
            r16 = false;
            goto L90
        L78:
            if (Float.compare(r9.i, 0.0f) != 0) goto L79;
            r15 = false;
            goto L81
        L69:
            if (Float.compare(r9.h, 0.0f) != 0) goto L70;
            r14 = false;
            goto L72
        L60:
            if (Float.compare(r9.g, 0.0f) != 0) goto L61;
            r13 = false;
            goto L63
        L51:
            if (Float.compare(r9.f, 0.0f) != 0) goto L52;
            r12 = false;
            goto L54
        L42:
            if (Float.compare(r9.e, 0.0f) != 0) goto L43;
            r11 = false;
            goto L45
        L33:
            if (r9.d != 0) goto L34;
            r6 = false;
            goto L36
        L24:
            if (r9.c != 0) goto L25;
            r5 = false;
            goto L27
        L15:
            if (r9.b != null) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r9.a != null) goto L7;
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

    public d() {
        this(null, null, 0, 0, 2047);
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
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (Float.compare(this.e, r6.e) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(this.f, r6.f) == 0) goto L27;
        return false;
    L27:
        if (Float.compare(this.g, r6.g) == 0) goto L30;
        return false;
    L30:
        if (Float.compare(this.h, r6.h) == 0) goto L33;
        return false;
    L33:
        if (Float.compare(this.i, r6.i) == 0) goto L36;
        return false;
    L36:
        if (Float.compare(this.j, r6.j) == 0) goto L39;
        return false;
    L39:
        if (Float.compare(this.k, r6.k) == 0) goto L41;
        return false;
    L41:
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
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return ((((((((((((((((((r3 + r1) * 31) + this.c) * 31) + this.d) * 31) + Float.floatToIntBits(this.e)) * 31) + Float.floatToIntBits(this.f)) * 31) + Float.floatToIntBits(this.g)) * 31) + Float.floatToIntBits(this.h)) * 31) + Float.floatToIntBits(this.i)) * 31) + Float.floatToIntBits(this.j)) * 31) + Float.floatToIntBits(this.k);
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "Segment(source=" + this.a + ", target=" + this.b + ", sourceIdx=" + this.c + ", stepIdx=" + this.d + ", _length=" + this.e + ", duration=" + this.f + ", _sDistToStart=" + this.g + ", _sDistToEnd=" + this.h + ", _bearing=" + this.i + ", _turnFrom=" + this.j + ", _turnTo=" + this.k + ")";
    }

    static {
        Companion = new b();
    }

    public d(com.bytedance.bdnavigationsdk.pojo.a r3, com.bytedance.bdnavigationsdk.pojo.a r4, int r5, int r6, int r7) {
        if ((r7 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = 0;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = 0;
    L14:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = 0.0f;
        this.k = 0.0f;
        if (r4 == null) goto L19;
        if (r3 == null) goto L20;
        int r8 = com.bytedance.bdnavigationsdk.utils.b.a;
        int r9 = w84.b.a;
        Intrinsics.checkNotNull(r3);
        Intrinsics.checkNotNull(r4);
        this.e = com.bytedance.bdnavigationsdk.utils.b.b(com.bytedance.bdnavigationsdk.utils.b.b(w84.b.a(r3, r4), 2), 2);
        int r10 = w84.a.a;
        Intrinsics.checkNotNull(r3);
        Intrinsics.checkNotNull(r4);
        this.i = com.bytedance.bdnavigationsdk.utils.b.b(com.bytedance.bdnavigationsdk.utils.b.b(w84.a.a(r3, r4), 2), 2);
        return;
    L20:
        return;
    }

    public d(int r4, com.bytedance.bdnavigationsdk.pojo.a r5, com.bytedance.bdnavigationsdk.pojo.a r6, int r7, int r8, float r9, float r10, float r11, float r12, float r13, float r14, float r15) {
        if ((r4 & 0) == 0) goto L5;
        b2.b(r4, 0, a.b);
        throw null;
    L5:
        if ((r4 & 1) != 0) goto L7;
        this.a = null;
    L9:
        if ((r4 & 2) != 0) goto L11;
        this.b = null;
    L13:
        if ((r4 & 4) != 0) goto L15;
        this.c = 0;
    L17:
        if ((r4 & 8) != 0) goto L19;
        this.d = 0;
    L21:
        if ((r4 & 16) != 0) goto L23;
        this.e = 0.0f;
    L25:
        if ((r4 & 32) != 0) goto L27;
        this.f = 0.0f;
    L29:
        if ((r4 & 64) != 0) goto L31;
        this.g = 0.0f;
    L33:
        if ((r4 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) != 0) goto L35;
        this.h = 0.0f;
    L37:
        if ((r4 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) != 0) goto L39;
        this.i = 0.0f;
    L41:
        if ((r4 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) != 0) goto L43;
        this.j = 0.0f;
    L45:
        if ((r4 & DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION) != 0) goto L47;
        this.k = 0.0f;
    L49:
        if (this.b == null) goto L56;
        com.bytedance.bdnavigationsdk.pojo.a r16 = this.a;
        if (r16 == null) goto L57;
        int r17 = com.bytedance.bdnavigationsdk.utils.b.a;
        int r18 = w84.b.a;
        Intrinsics.checkNotNull(r16);
        com.bytedance.bdnavigationsdk.pojo.a r19 = this.b;
        Intrinsics.checkNotNull(r19);
        this.e = com.bytedance.bdnavigationsdk.utils.b.b(com.bytedance.bdnavigationsdk.utils.b.b(w84.b.a(r16, r19), 2), 2);
        int r20 = w84.a.a;
        com.bytedance.bdnavigationsdk.pojo.a r21 = this.a;
        Intrinsics.checkNotNull(r21);
        com.bytedance.bdnavigationsdk.pojo.a r22 = this.b;
        Intrinsics.checkNotNull(r22);
        this.i = com.bytedance.bdnavigationsdk.utils.b.b(com.bytedance.bdnavigationsdk.utils.b.b(w84.a.a(r21, r22), 2), 2);
        return;
    L57:
        return;
    L56:
        return;
    L47:
        this.k = r15;
        goto L49
    L43:
        this.j = r14;
        goto L45
    L39:
        this.i = r13;
        goto L41
    L35:
        this.h = r12;
        goto L37
    L31:
        this.g = r11;
        goto L33
    L27:
        this.f = r10;
        goto L29
    L23:
        this.e = r9;
        goto L25
    L19:
        this.d = r8;
        goto L21
    L15:
        this.c = r7;
        goto L17
    L11:
        this.b = r6;
        goto L13
    L7:
        this.a = r5;
        goto L9
    }
}
