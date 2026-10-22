package com.bytedance.bdnavigationsdk.pojo;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
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
import nuc.i;
import nuc.i2;
import nuc.l0;
import nuc.m0;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Serializable
public final class b {
    public static final C0134b Companion = null;
    public final int a;
    public boolean b;
    public final com.bytedance.bdnavigationsdk.pojo.a c;
    public final int d;
    public final int e;
    public final long f;
    public final float g;
    public final float h;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<b> {
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
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.pojo.Location", r0, 8);
            r1.j("idx", true);
            r1.j("usable", true);
            r1.j("latlng", true);
            r1.j("locationType", true);
            r1.j("trustedLevel", true);
            r1.j(LocationMonitorConst.TIMESTAMP, true);
            r1.j("speed", true);
            r1.j("bearing", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            w0 r1 = w0.a;
            l0 r2 = l0.a;
            return new juc.d[]{r1, i.a, kuc.a.d(com.bytedance.bdnavigationsdk.pojo.a.C0133a.a), r1, r1, g1.a, r2, r2};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r21) {
            Intrinsics.checkNotNullParameter(r21, "decoder");
            g2 r1 = b;
            muc.c r0 = r21.beginStructure(r1);
            int r4 = 4;
            if (r0.decodeSequentially() == false) goto L6;
            int r2 = r0.decodeIntElement(r1, 0);
            boolean r5 = r0.decodeBooleanElement(r1, 1);
            com.bytedance.bdnavigationsdk.pojo.a r3 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeNullableSerializableElement(r1, 2, com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, null);
            int r6 = r0.decodeIntElement(r1, 3);
            int r7 = r0.decodeIntElement(r1, 4);
            long r9 = r0.decodeLongElement(r1, 5);
            float r8 = r0.decodeFloatElement(r1, 6);
            float r14 = r0.decodeFloatElement(r1, 7);
            float r13 = r8;
            long r11 = r9;
            com.bytedance.bdnavigationsdk.pojo.a r10 = r3;
            int r12 = r7;
            boolean r15 = r5;
            int r16 = r6;
            int r17 = 255;
        L5:
            int r18 = r2;
            r0.endStructure(r1);
            return new b(r17, r18, r15, r10, r16, r12, r11, r13, r14);
        L6:
            com.bytedance.bdnavigationsdk.pojo.a r19 = null;
            long r110 = 0;
            r2 = 0;
            r17 = 0;
            int r111 = 0;
            boolean r112 = false;
            int r113 = 0;
            r14 = 0.0f;
            float r114 = 0.0f;
            boolean r115 = true;
        L7:
            if (r115 == false) goto L25;
            int r20 = r0.decodeElementIndex(r1);
            switch(r20) {
                case -1: goto L23;
                case 0: goto L21;
                case 1: goto L20;
                case 2: goto L18;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                default: goto L11;
            };
        L12:
            r14 = r0.decodeFloatElement(r1, 7);
            int r22 = r17 | DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE;
        L17:
            r17 = r22;
        L24:
            r4 = 4;
            goto L7
        L13:
            r114 = r0.decodeFloatElement(r1, 6);
            r22 = r17 | 64;
            goto L17
        L14:
            r110 = r0.decodeLongElement(r1, 5);
            r22 = r17 | 32;
            goto L17
        L15:
            r111 = r0.decodeIntElement(r1, r4);
            r22 = r17 | 16;
            goto L17
        L16:
            r113 = r0.decodeIntElement(r1, 3);
            r22 = r17 | 8;
            goto L17
        L18:
            r19 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeNullableSerializableElement(r1, 2, com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, r19);
            r17 = r17 | 4;
            goto L24
        L20:
            r112 = r0.decodeBooleanElement(r1, 1);
            r17 = r17 | 2;
            goto L24
        L21:
            r17 = r17 | 1;
            r2 = r0.decodeIntElement(r1, 0);
            goto L24
        L23:
            r115 = false;
            goto L24
        L11:
            throw new UnknownFieldException(r20);
        L25:
            r10 = r19;
            r12 = r111;
            r15 = r112;
            r16 = r113;
            r13 = r114;
            r11 = r110;
            goto L5
        }

        public final void serialize(muc.f r10, Object r11) {
            b r12 = (b) r11;
            Intrinsics.checkNotNullParameter(r10, "encoder");
            Intrinsics.checkNotNullParameter(r12, "value");
            g2 r0 = b;
            muc.d r13 = r10.beginStructure(r0);
            C0134b r1 = b.Companion;
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
            r13.encodeBooleanElement(r0, 1, r12.b);
        L21:
            if (r13.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r13.encodeNullableSerializableElement(r0, 2, com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, r12.c);
        L30:
            if (r13.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r13.encodeIntElement(r0, 3, r12.d);
        L39:
            if (r13.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            boolean r7 = true;
        L45:
            if (r7 == false) goto L48;
            r13.encodeIntElement(r0, 4, r12.e);
        L48:
            if (r13.shouldEncodeElementDefault(r0, 5) == false) goto L51;
        L52:
            boolean r8 = true;
        L54:
            if (r8 == false) goto L57;
            r13.encodeLongElement(r0, 5, r12.f);
        L57:
            if (r13.shouldEncodeElementDefault(r0, 6) == false) goto L60;
        L61:
            boolean r9 = true;
        L63:
            if (r9 == false) goto L66;
            r13.encodeFloatElement(r0, 6, r12.g);
        L66:
            if (r13.shouldEncodeElementDefault(r0, 7) == false) goto L69;
        L70:
            r2 = true;
        L71:
            if (r2 == false) goto L73;
            r13.encodeFloatElement(r0, 7, r12.h);
        L73:
            r13.endStructure(r0);
            return;
        L69:
            if (Float.compare(r12.h, 0.0f) == 0) goto L71;
        L60:
            if (Float.compare(r12.g, 0.0f) != 0) goto L61;
            r9 = false;
            goto L63
        L51:
            if (r12.f != 0) goto L52;
            r8 = false;
            goto L54
        L42:
            if (r12.e != 0) goto L43;
            r7 = false;
            goto L45
        L33:
            if (r12.d != 0) goto L34;
            r6 = false;
            goto L36
        L24:
            if (r12.c != null) goto L25;
            r5 = false;
            goto L27
        L15:
            if (r12.b == true) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r12.a != 0) goto L7;
            r3 = false;
            goto L9
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bdnavigationsdk.pojo.b$b, reason: collision with other inner class name */
    public static final class C0134b {
        public C0134b() {
        }

        public final juc.d<b> serializer() {
            return a.a;
        }
    }

    public b() {
        this(0, false, null, 0, 0, 0, 0.0f, 0.0f);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == true) goto L8;
        return false;
    L8:
        b r9 = (b) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (this.f == r9.f) goto L27;
        return false;
    L27:
        if (Float.compare(this.g, r9.g) == 0) goto L30;
        return false;
    L30:
        if (Float.compare(this.h, r9.h) == 0) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (r0 + r1) * 31;
        com.bytedance.bdnavigationsdk.pojo.a r3 = this.c;
        if (r3 != null) goto L9;
        int r4 = 0;
    L10:
        int r5 = (((((r2 + r4) * 31) + this.d) * 31) + this.e) * 31;
        long r6 = this.f;
        return ((((r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31) + Float.floatToIntBits(this.g)) * 31) + Float.floatToIntBits(this.h);
    L9:
        r4 = r3.hashCode();
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    static {
        Companion = new C0134b();
    }

    public final String toString() {
        return "Location{idx=" + this.a + ", usable=" + this.b + ", latlng=" + this.c + ", locationType=" + this.d + ", trustedLevel=" + this.e + ", timestamp=" + this.f + ", speed=" + this.g + ", bearing=" + this.h + "}";
    }

    public b(int r1, boolean r2, com.bytedance.bdnavigationsdk.pojo.a r3, int r4, int r5, long r6, float r8, float r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r8;
        this.h = r9;
    }

    public b(int r4, int r5, boolean r6, com.bytedance.bdnavigationsdk.pojo.a r7, int r8, int r9, long r10, float r12, float r13) {
        if ((r4 & 0) == 0) goto L5;
        b2.b(r4, 0, a.b);
        throw null;
    L5:
        if ((r4 & 1) != 0) goto L7;
        this.a = 0;
    L9:
        if ((r4 & 2) != 0) goto L11;
        this.b = false;
    L13:
        if ((r4 & 4) != 0) goto L15;
        this.c = null;
    L17:
        if ((r4 & 8) != 0) goto L19;
        this.d = 0;
    L21:
        if ((r4 & 16) != 0) goto L23;
        this.e = 0;
    L25:
        if ((r4 & 32) != 0) goto L27;
        this.f = 0;
    L29:
        if ((r4 & 64) != 0) goto L31;
        this.g = 0.0f;
    L33:
        if ((r4 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) != 0) goto L35;
        this.h = 0.0f;
        return;
    L35:
        this.h = r13;
        return;
    L31:
        this.g = r12;
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
