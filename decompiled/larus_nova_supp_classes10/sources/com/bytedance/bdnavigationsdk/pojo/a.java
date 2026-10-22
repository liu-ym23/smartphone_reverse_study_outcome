package com.bytedance.bdnavigationsdk.pojo;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b0;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Serializable
public final class a {
    public static final b Companion = null;
    public final double a;
    public final double b;

    /* JADX INFO: renamed from: com.bytedance.bdnavigationsdk.pojo.a$a, reason: collision with other inner class name */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class C0133a implements m0<a> {
        public static final C0133a a = null;
        public static final g2 b = null;

        public C0133a() {
        }

        public final juc.d<?>[] childSerializers() {
            b0 r1 = b0.a;
            return new juc.d[]{r1, r1};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            C0133a r0 = new C0133a();
            a = r0;
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.pojo.LatLng", r0, 2);
            r1.j("latitude", false);
            r1.j("longitude", false);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r17) {
            Intrinsics.checkNotNullParameter(r17, "decoder");
            g2 r1 = b;
            muc.c r0 = r17.beginStructure(r1);
            if (r0.decodeSequentially() == false) goto L5;
            double r12 = r0.decodeDoubleElement(r1, 0);
            double r14 = r0.decodeDoubleElement(r1, 1);
            int r11 = 3;
        L17:
            r0.endStructure(r1);
            return new a(r11, r12, r14);
        L5:
            double r5 = 0.0d;
            double r7 = 0.0d;
            int r2 = 0;
            boolean r9 = true;
        L6:
            if (r9 == false) goto L16;
            int r10 = r0.decodeElementIndex(r1);
            if (r10 != (-1)) goto L9;
            r9 = false;
            goto L6
        L9:
            if (r10 != 0) goto L10;
            r5 = r0.decodeDoubleElement(r1, 0);
            r2 = r2 | 1;
            goto L6
        L10:
            if (r10 != 1) goto L13;
            r7 = r0.decodeDoubleElement(r1, 1);
            r2 = r2 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r10);
        L16:
            r11 = r2;
            r12 = r5;
            r14 = r7;
            goto L17
        }

        public final void serialize(muc.f r5, Object r6) {
            a r7 = (a) r6;
            Intrinsics.checkNotNullParameter(r5, "encoder");
            Intrinsics.checkNotNullParameter(r7, "value");
            g2 r0 = b;
            muc.d r8 = r5.beginStructure(r0);
            r8.encodeDoubleElement(r0, 0, r7.a);
            r8.encodeDoubleElement(r0, 1, r7.b);
            r8.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<a> serializer() {
            return C0133a.a;
        }
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof a) == true) goto L8;
        return false;
    L8:
        a r9 = (a) r8;
        if (Double.compare(this.a, r9.a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.b, r9.b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r0 = Double.doubleToLongBits(this.a);
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = Double.doubleToLongBits(this.b);
        return r1 + ((int) (r3 ^ (r3 >>> 32)));
    }

    static {
        Companion = new b();
    }

    public a() {
        this(0.0d, 0.0d);
    }

    public final String toString() {
        return "lat/lng: (" + this.a + "," + this.b + ")";
    }

    public static a a(a r4) {
        double r0 = r4.a;
        double r2 = r4.b;
        r4.getClass();
        return new a(r0, r2);
    }

    public a(double r8, double r10) {
        this.a = r8;
        this.b = r10;
        if ((-180.0d) <= r10) goto L5;
    L7:
        double r0 = 180.0f;
        double r4 = 360.0f;
        double r2 = ((((r10 - r0) % r4) + r4) % r4) - r0;
    L8:
        boolean r5 = true;
        if (Math.max(-90.0d, Math.min(90.0d, r8)) != r8) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L20;
        if (r2 == r10) goto L17;
        r5 = false;
    L17:
        if (r5 == false) goto L20;
        return;
    L20:
        throw new IllegalArgumentException("非法坐标值: latitude=" + r8 + ", longitude=" + r10 + " 必须在 [-90, 90] 和 [-180, 180) 范围内");
    L11:
        r1 = false;
        goto L12
    L5:
        if (r10 >= 180.0d) goto L7;
        r2 = r10;
        goto L8
    }

    public a(int r7, double r8, double r10) {
        if (3 != (r7 & 3)) goto L22;
        this.a = r8;
        this.b = r10;
        if ((-180.0d) <= r10) goto L7;
    L9:
        double r0 = 180.0f;
        double r4 = 360.0f;
        double r2 = ((((r10 - r0) % r4) + r4) % r4) - r0;
    L10:
        boolean r9 = false;
        if (Math.max(-90.0d, Math.min(90.0d, r8)) != r8) goto L13;
        boolean r1 = true;
    L14:
        if (r1 == false) goto L21;
        if (r2 != r10) goto L18;
        r9 = true;
    L18:
        if (r9 == false) goto L21;
        return;
    L21:
        throw new IllegalArgumentException("非法坐标值: latitude=" + r8 + ", longitude=" + r10 + " 必须在 [-90, 90] 和 [-180, 180) 范围内");
    L13:
        r1 = false;
        goto L14
    L7:
        if (r10 >= 180.0d) goto L9;
        r2 = r10;
        goto L10
    L22:
        b2.b(r7, 3, C0133a.b);
        throw null;
    }
}
