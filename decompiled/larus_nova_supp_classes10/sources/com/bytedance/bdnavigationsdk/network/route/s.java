package com.bytedance.bdnavigationsdk.network.route;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Serializable
public final class s {
    public static final b Companion = null;
    public final float a;
    public final float b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<s> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            l0 r1 = l0.a;
            return new juc.d[]{r1, r1};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.network.route.RouteVerbalRange", r0, 2);
            r1.j("remain_distance_start", true);
            r1.j("remain_distance_end", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r10) {
            Intrinsics.checkNotNullParameter(r10, "decoder");
            g2 r0 = b;
            muc.c r11 = r10.beginStructure(r0);
            if (r11.decodeSequentially() == false) goto L5;
            float r1 = r11.decodeFloatElement(r0, 0);
            float r2 = r11.decodeFloatElement(r0, 1);
            int r3 = 3;
        L17:
            r11.endStructure(r0);
            return new s(r3, r1, r2);
        L5:
            r1 = 0.0f;
            float r4 = 0.0f;
            int r5 = 0;
            boolean r6 = true;
        L6:
            if (r6 == false) goto L16;
            int r7 = r11.decodeElementIndex(r0);
            if (r7 != (-1)) goto L9;
            r6 = false;
            goto L6
        L9:
            if (r7 != 0) goto L10;
            r1 = r11.decodeFloatElement(r0, 0);
            r5 = r5 | 1;
            goto L6
        L10:
            if (r7 != 1) goto L13;
            r4 = r11.decodeFloatElement(r0, 1);
            r5 = r5 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r7);
        L16:
            r2 = r4;
            r3 = r5;
            goto L17
        }

        public final void serialize(muc.f r6, Object r7) {
            s r8 = (s) r7;
            Intrinsics.checkNotNullParameter(r6, "encoder");
            Intrinsics.checkNotNullParameter(r8, "value");
            g2 r0 = b;
            muc.d r9 = r6.beginStructure(r0);
            b r1 = s.Companion;
            boolean r2 = false;
            if (r9.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r9.encodeFloatElement(r0, 0, r8.a);
        L12:
            if (r9.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            r2 = true;
        L17:
            if (r2 == false) goto L19;
            r9.encodeFloatElement(r0, 1, r8.b);
        L19:
            r9.endStructure(r0);
            return;
        L15:
            if (Float.compare(r8.b, 0.0f) == 0) goto L17;
        L6:
            if (Float.compare(r8.a, 0.0f) != 0) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<s> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof s) == true) goto L8;
        return false;
    L8:
        s r6 = (s) r5;
        if (Float.compare(this.a, r6.a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.b, r6.b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b);
    }

    public final String toString() {
        return "RouteVerbalRange(remainDistanceStart=" + this.a + ", remainDistanceEnd=" + this.b + ")";
    }

    static {
        Companion = new b();
    }

    public s() {
        this.a = 0.0f;
        this.b = 0.0f;
    }

    public s(int r3, float r4, float r5) {
        if ((r3 & 0) == 0) goto L5;
        b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        this.a = 0.0f;
    L9:
        if ((r3 & 2) != 0) goto L11;
        this.b = 0.0f;
        return;
    L11:
        this.b = r5;
        return;
    L7:
        this.a = r4;
        goto L9
    }
}
