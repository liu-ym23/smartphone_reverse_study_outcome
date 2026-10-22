package t84;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Serializable
public final class c {
    public static final b Companion = null;
    public final float a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    public final float f;
    public final float g;
    public final float h;
    public final float i;
    public final float j;
    public final float k;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<c> {
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
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.pojo.Threshold.Universal", r0, 11);
            r1.j("speed", true);
            r1.j("timestamp_diff", true);
            r1.j("dist_to_start", true);
            r1.j("dist_to_end", true);
            r1.j("suspected_projection_dist", true);
            r1.j("suspected_dist_at_start", true);
            r1.j("max_projection_dist", true);
            r1.j("user_location_dist", true);
            r1.j("cross_corner_max_dist", true);
            r1.j("cross_corner_min_dist", true);
            r1.j("cross_corner_interval_dist", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            l0 r1 = l0.a;
            return new juc.d[]{r1, r1, r1, r1, r1, r1, r1, r1, r1, r1, r1};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r28) {
            Intrinsics.checkNotNullParameter(r28, "decoder");
            g2 r1 = b;
            muc.c r0 = r28.beginStructure(r1);
            int r6 = 0;
            if (r0.decodeSequentially() == false) goto L5;
            float r2 = r0.decodeFloatElement(r1, 0);
            float r7 = r0.decodeFloatElement(r1, 1);
            float r3 = r0.decodeFloatElement(r1, 2);
            float r8 = r0.decodeFloatElement(r1, 3);
            float r4 = r0.decodeFloatElement(r1, 4);
            float r12 = r0.decodeFloatElement(r1, 5);
            float r11 = r0.decodeFloatElement(r1, 6);
            float r10 = r0.decodeFloatElement(r1, 7);
            float r5 = r0.decodeFloatElement(r1, 8);
            float r9 = r0.decodeFloatElement(r1, 9);
            float r14 = r4;
            float r18 = r5;
            float r13 = r8;
            float r20 = r0.decodeFloatElement(r1, 10);
            float r19 = r9;
            float r17 = r10;
            float r16 = r11;
            float r15 = r12;
            int r21 = 2047;
            float r110 = r2;
            float r111 = r3;
            float r112 = r7;
        L26:
            r0.endStructure(r1);
            return new c(r21, r110, r112, r111, r13, r14, r15, r16, r17, r18, r19, r20);
        L5:
            float r22 = 0.0f;
            float r113 = 0.0f;
            float r114 = 0.0f;
            float r115 = 0.0f;
            float r116 = 0.0f;
            float r117 = 0.0f;
            float r118 = 0.0f;
            float r23 = 0.0f;
            float r24 = 0.0f;
            float r25 = 0.0f;
            float r26 = 0.0f;
            boolean r27 = true;
        L6:
            if (r27 == false) goto L25;
            int r29 = r0.decodeElementIndex(r1);
            switch(r29) {
                case -1: goto L23;
                case 0: goto L22;
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
            throw new UnknownFieldException(r29);
        L21:
            r116 = r0.decodeFloatElement(r1, 1);
            r6 = r6 | 2;
            goto L6
        L22:
            r6 = r6 | 1;
            r22 = r0.decodeFloatElement(r1, 0);
            goto L6
        L11:
            r118 = r0.decodeFloatElement(r1, 10);
            r6 = r6 | DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION;
        L20:
            boolean r210 = r27;
        L24:
            r27 = r210;
            goto L6
        L12:
            r23 = r0.decodeFloatElement(r1, 9);
            r6 = r6 | DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE;
            goto L20
        L13:
            r115 = r0.decodeFloatElement(r1, 8);
            r6 = r6 | DeviceStatus$DiffDimension.DIFF_LOCATION_MODE;
            goto L20
        L14:
            r24 = r0.decodeFloatElement(r1, 7);
            r6 = r6 | DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE;
            goto L20
        L15:
            r25 = r0.decodeFloatElement(r1, 6);
            r6 = r6 | 64;
            goto L20
        L16:
            r26 = r0.decodeFloatElement(r1, 5);
            r6 = r6 | 32;
            goto L20
        L17:
            r114 = r0.decodeFloatElement(r1, 4);
            r6 = r6 | 16;
            goto L20
        L18:
            r117 = r0.decodeFloatElement(r1, 3);
            r6 = r6 | 8;
            goto L20
        L19:
            r113 = r0.decodeFloatElement(r1, 2);
            r6 = r6 | 4;
            goto L20
        L23:
            r210 = false;
            goto L24
        L25:
            r110 = r22;
            r21 = r6;
            r111 = r113;
            r14 = r114;
            r112 = r116;
            r13 = r117;
            r17 = r24;
            r15 = r26;
            r18 = r115;
            r16 = r25;
            float r211 = r23;
            r20 = r118;
            r19 = r211;
            goto L26
        }

        public final void serialize(muc.f r7, Object r8) {
            c r9 = (c) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            b r1 = c.Companion;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeFloatElement(r0, 0, r9.a);
        L12:
            if (r10.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r10.encodeFloatElement(r0, 1, r9.b);
        L21:
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L24;
        L25:
            boolean r5 = true;
        L27:
            if (r5 == false) goto L30;
            r10.encodeFloatElement(r0, 2, r9.c);
        L30:
            if (r10.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r10.encodeFloatElement(r0, 3, r9.d);
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
            if (Float.compare(r9.d, 0.0f) != 0) goto L34;
            r6 = false;
            goto L36
        L24:
            if (Float.compare(r9.c, 0.0f) != 0) goto L25;
            r5 = false;
            goto L27
        L15:
            if (Float.compare(r9.b, 0.0f) != 0) goto L16;
            r4 = false;
            goto L18
        L6:
            if (Float.compare(r9.a, 0.0f) != 0) goto L7;
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
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Float.compare(this.a, r6.a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.b, r6.b) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.c, r6.c) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.d, r6.d) == 0) goto L21;
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
        return (((((((((((((((((((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e)) * 31) + Float.floatToIntBits(this.f)) * 31) + Float.floatToIntBits(this.g)) * 31) + Float.floatToIntBits(this.h)) * 31) + Float.floatToIntBits(this.i)) * 31) + Float.floatToIntBits(this.j)) * 31) + Float.floatToIntBits(this.k);
    }

    static {
        Companion = new b();
    }

    public final String toString() {
        return "Universal{speed=" + this.a + ", timestampDiff=" + this.b + ", distToStart=" + this.c + ", distToEnd=" + this.d + ", suspectedProjectionDist=" + this.e + ", suspectedDistAtStart=" + this.f + ", maxProjectionDist=" + this.g + ", userLocationDist=" + this.h + ", crossCornerMaxDist=" + this.i + ", crossCornerMinDist=" + this.j + ", crossCornerIntervalDist=" + this.k + "}";
    }

    public /* synthetic */ c(int r13) {
        this(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    public c(float r1, float r2, float r3, float r4, float r5, float r6, float r7, float r8, float r9, float r10, float r11) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r11;
    }

    public c(int r3, float r4, float r5, float r6, float r7, float r8, float r9, float r10, float r11, float r12, float r13, float r14) {
        if ((r3 & 0) == 0) goto L5;
        b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        this.a = 0.0f;
    L9:
        if ((r3 & 2) != 0) goto L11;
        this.b = 0.0f;
    L13:
        if ((r3 & 4) != 0) goto L15;
        this.c = 0.0f;
    L17:
        if ((r3 & 8) != 0) goto L19;
        this.d = 0.0f;
    L21:
        if ((r3 & 16) != 0) goto L23;
        this.e = 0.0f;
    L25:
        if ((r3 & 32) != 0) goto L27;
        this.f = 0.0f;
    L29:
        if ((r3 & 64) != 0) goto L31;
        this.g = 0.0f;
    L33:
        if ((r3 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) != 0) goto L35;
        this.h = 0.0f;
    L37:
        if ((r3 & DeviceStatus$DiffDimension.DIFF_LOCATION_MODE) != 0) goto L39;
        this.i = 0.0f;
    L41:
        if ((r3 & DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE) != 0) goto L43;
        this.j = 0.0f;
    L45:
        if ((r3 & DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION) != 0) goto L47;
        this.k = 0.0f;
        return;
    L47:
        this.k = r14;
        return;
    L43:
        this.j = r13;
        goto L45
    L39:
        this.i = r12;
        goto L41
    L35:
        this.h = r11;
        goto L37
    L31:
        this.g = r10;
        goto L33
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
