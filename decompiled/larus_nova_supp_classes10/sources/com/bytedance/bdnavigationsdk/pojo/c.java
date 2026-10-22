package com.bytedance.bdnavigationsdk.pojo;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.l0;
import nuc.m0;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Serializable
public final class c {
    public static final b Companion = null;
    public final int a;
    public final String b;
    public final int c;
    public final com.bytedance.bdnavigationsdk.pojo.a d;
    public final float e;
    public final float f;
    public final long g;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<c> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            w0 r1 = w0.a;
            l0 r2 = l0.a;
            return new juc.d[]{r1, kuc.a.d(v2.a), r1, kuc.a.d(com.bytedance.bdnavigationsdk.pojo.a.C0133a.a), r2, r2, g1.a};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.pojo.LocationInfo", r0, 7);
            r1.j("location_type", true);
            r1.j("coordinate_system", true);
            r1.j("trusted_level", true);
            r1.j("latlng", true);
            r1.j("speed", true);
            r1.j("bearing", true);
            r1.j(LocationMonitorConst.TIMESTAMP, true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r19) {
            Intrinsics.checkNotNullParameter(r19, "decoder");
            g2 r1 = b;
            muc.c r0 = r19.beginStructure(r1);
            int r3 = 4;
            int r4 = 5;
            if (r0.decodeSequentially() == false) goto L5;
            int r2 = r0.decodeIntElement(r1, 0);
            String r7 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, null);
            int r6 = r0.decodeIntElement(r1, 2);
            com.bytedance.bdnavigationsdk.pojo.a r8 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeNullableSerializableElement(r1, 3, com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, null);
            float r5 = r0.decodeFloatElement(r1, 4);
            float r13 = r5;
            float r14 = r0.decodeFloatElement(r1, 5);
            int r11 = r6;
            com.bytedance.bdnavigationsdk.pojo.a r12 = r8;
            long r15 = r0.decodeLongElement(r1, 6);
            int r9 = 127;
            int r10 = r2;
            String r16 = r7;
        L23:
            r0.endStructure(r1);
            return new c(r9, r10, r16, r11, r12, r13, r14, r15);
        L5:
            com.bytedance.bdnavigationsdk.pojo.a r17 = null;
            String r18 = null;
            long r110 = 0;
            int r20 = 0;
            float r111 = 0.0f;
            float r112 = 0.0f;
            int r113 = 0;
            int r114 = 0;
            boolean r115 = true;
        L6:
            if (r115 == false) goto L22;
            int r21 = r0.decodeElementIndex(r1);
            switch(r21) {
                case -1: goto L21;
                case 0: goto L19;
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L15;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r21);
        L21:
            r3 = 4;
            r115 = false;
            goto L6
        L11:
            r110 = r0.decodeLongElement(r1, 6);
            int r22 = r113 | 64;
        L14:
            r113 = r22;
        L20:
            r3 = 4;
            r4 = 5;
            goto L6
        L12:
            r112 = r0.decodeFloatElement(r1, r4);
            r22 = r113 | 32;
            goto L14
        L13:
            r111 = r0.decodeFloatElement(r1, r3);
            r22 = r113 | 16;
            goto L14
        L15:
            r113 = r113 | 8;
            r17 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeNullableSerializableElement(r1, 3, com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, r17);
            goto L20
        L17:
            r114 = r0.decodeIntElement(r1, 2);
            r113 = r113 | 4;
            goto L20
        L18:
            r18 = (String) r0.decodeNullableSerializableElement(r1, 1, v2.a, r18);
            r113 = r113 | 2;
            goto L20
        L19:
            r20 = r0.decodeIntElement(r1, 0);
            r113 = r113 | 1;
            goto L20
        L22:
            r10 = r20;
            r15 = r110;
            r14 = r112;
            r11 = r114;
            r13 = r111;
            r16 = r18;
            r9 = r113;
            r12 = r17;
            goto L23
        }

        public final void serialize(muc.f r10, Object r11) {
            c r12 = (c) r11;
            Intrinsics.checkNotNullParameter(r10, "encoder");
            Intrinsics.checkNotNullParameter(r12, "value");
            g2 r0 = b;
            muc.d r13 = r10.beginStructure(r0);
            b r1 = c.Companion;
            boolean r2 = false;
            if (r13.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r13.encodeIntElement(r0, 0, r12.a);
        L12:
            if (r13.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r13.encodeNullableSerializableElement(r0, 1, v2.a, r12.b);
        L21:
            if (r13.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r13.encodeIntElement(r0, 2, r12.c);
        L30:
            if (r13.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r13.encodeNullableSerializableElement(r0, 3, com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, r12.d);
        L39:
            if (r13.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            boolean r7 = true;
        L45:
            if (r7 == false) goto L48;
            r13.encodeFloatElement(r0, 4, r12.e);
        L48:
            if (r13.shouldEncodeElementDefault(r0, 5) == false) goto L51;
        L52:
            boolean r8 = true;
        L54:
            if (r8 == false) goto L57;
            r13.encodeFloatElement(r0, 5, r12.f);
        L57:
            if (r13.shouldEncodeElementDefault(r0, 6) == false) goto L60;
        L61:
            r2 = true;
        L62:
            if (r2 == false) goto L64;
            r13.encodeLongElement(r0, 6, r12.g);
        L64:
            r13.endStructure(r0);
            return;
        L60:
            if (r12.g == 0) goto L62;
        L51:
            if (Float.compare(r12.f, 0.0f) != 0) goto L52;
            r8 = false;
            goto L54
        L42:
            if (Float.compare(r12.e, 0.0f) != 0) goto L43;
            r7 = false;
            goto L45
        L33:
            if (r12.d != null) goto L34;
            r6 = false;
            goto L36
        L24:
            if (r12.c != 0) goto L25;
            r5 = false;
            goto L27
        L15:
            if (r12.b != null) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r12.a != 0) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<c> serializer() {
            return a.a;
        }
    }

    public c() {
        this(0, null, 0, null, 0.0f, 0.0f, 0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof c) == true) goto L8;
        return false;
    L8:
        c r9 = (c) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Float.compare(this.e, r9.e) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(this.f, r9.f) == 0) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        String r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.c) * 31;
        com.bytedance.bdnavigationsdk.pojo.a r5 = this.d;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        int r6 = (((((r4 + r2) * 31) + Float.floatToIntBits(this.e)) * 31) + Float.floatToIntBits(this.f)) * 31;
        long r7 = this.g;
        return r6 + ((int) (r7 ^ (r7 >>> 32)));
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    static {
        Companion = new b();
    }

    public final String toString() {
        return "LocationInfo{locationType=" + this.a + ", coordinateSystem=" + this.b + ", trustedLevel=" + this.c + ", latLng=" + this.d + ", speed=" + this.e + ", bearing=" + this.f + ", timestamp=" + this.g + "}";
    }

    public static c a(c r9) {
        return new c(r9.a, r9.b, r9.c, r9.d, r9.e, r9.f, r9.g);
    }

    public c(int r1, String r2, int r3, com.bytedance.bdnavigationsdk.pojo.a r4, float r5, float r6, long r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public c(int r4, int r5, String r6, int r7, com.bytedance.bdnavigationsdk.pojo.a r8, float r9, float r10, long r11) {
        if ((r4 & 0) == 0) goto L5;
        b2.b(r4, 0, a.b);
        throw null;
    L5:
        if ((r4 & 1) != 0) goto L7;
        this.a = 0;
    L9:
        if ((r4 & 2) != 0) goto L11;
        this.b = null;
    L13:
        if ((r4 & 4) != 0) goto L15;
        this.c = 0;
    L17:
        if ((r4 & 8) != 0) goto L19;
        this.d = null;
    L21:
        if ((r4 & 16) != 0) goto L23;
        this.e = 0.0f;
    L25:
        if ((r4 & 32) != 0) goto L27;
        this.f = 0.0f;
    L29:
        if ((r4 & 64) != 0) goto L31;
        this.g = 0;
        return;
    L31:
        this.g = r11;
        return;
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
