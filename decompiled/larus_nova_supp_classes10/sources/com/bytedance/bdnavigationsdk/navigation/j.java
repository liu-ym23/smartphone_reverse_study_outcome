package com.bytedance.bdnavigationsdk.navigation;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
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
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Serializable
public final class j {
    public static final b Companion = null;
    public com.bytedance.bdnavigationsdk.pojo.b a;
    public com.bytedance.bdnavigationsdk.pojo.a b;
    public float c;
    public boolean d;
    public int e;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<j> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d(com.bytedance.bdnavigationsdk.pojo.b.a.a), kuc.a.d(com.bytedance.bdnavigationsdk.pojo.a.C0133a.a), l0.a, nuc.i.a, w0.a};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.navigation.NavigationLocation", r0, 5);
            r1.j(LocationMonitorConst.LOCATION, true);
            r1.j("projection", true);
            r1.j("projection_bearing", true);
            r1.j("suspected_yaw", true);
            r1.j("projection_segment_idx", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r22) {
            Intrinsics.checkNotNullParameter(r22, "decoder");
            g2 r1 = b;
            muc.c r0 = r22.beginStructure(r1);
            if (r0.decodeSequentially() == false) goto L5;
            com.bytedance.bdnavigationsdk.pojo.b r2 = (com.bytedance.bdnavigationsdk.pojo.b) r0.decodeNullableSerializableElement(r1, 0, com.bytedance.bdnavigationsdk.pojo.b.a.a, null);
            com.bytedance.bdnavigationsdk.pojo.a r5 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeNullableSerializableElement(r1, 1, com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, null);
            float r3 = r0.decodeFloatElement(r1, 2);
            boolean r6 = r0.decodeBooleanElement(r1, 3);
            com.bytedance.bdnavigationsdk.pojo.b r16 = r2;
            float r18 = r3;
            int r20 = r0.decodeIntElement(r1, 4);
            com.bytedance.bdnavigationsdk.pojo.a r17 = r5;
            boolean r19 = r6;
            int r15 = 31;
        L23:
            r0.endStructure(r1);
            return new j(r15, r16, r17, r18, r19, r20);
        L5:
            float r4 = 0.0f;
            com.bytedance.bdnavigationsdk.pojo.b r11 = null;
            com.bytedance.bdnavigationsdk.pojo.a r12 = null;
            int r8 = 0;
            boolean r9 = false;
            int r10 = 0;
            boolean r13 = true;
        L6:
            if (r13 == false) goto L22;
            int r14 = r0.decodeElementIndex(r1);
            if (r14 != (-1)) goto L9;
            r13 = false;
            goto L6
        L9:
            if (r14 != 0) goto L10;
            r11 = (com.bytedance.bdnavigationsdk.pojo.b) r0.decodeNullableSerializableElement(r1, 0, com.bytedance.bdnavigationsdk.pojo.b.a.a, r11);
            r10 = r10 | 1;
            goto L6
        L10:
            if (r14 != 1) goto L11;
            r12 = (com.bytedance.bdnavigationsdk.pojo.a) r0.decodeNullableSerializableElement(r1, 1, com.bytedance.bdnavigationsdk.pojo.a.C0133a.a, r12);
            r10 = r10 | 2;
            goto L6
        L11:
            if (r14 != 2) goto L12;
            r4 = r0.decodeFloatElement(r1, 2);
            r10 = r10 | 4;
            goto L6
        L12:
            if (r14 != 3) goto L13;
            r9 = r0.decodeBooleanElement(r1, 3);
            r10 = r10 | 8;
            goto L6
        L13:
            if (r14 != 4) goto L16;
            r8 = r0.decodeIntElement(r1, 4);
            r10 = r10 | 16;
            goto L6
        L16:
            throw new UnknownFieldException(r14);
        L22:
            r18 = r4;
            r20 = r8;
            r19 = r9;
            r15 = r10;
            r16 = r11;
            r17 = r12;
            goto L23
        }

        public final void serialize(muc.f r7, Object r8) {
            j r9 = (j) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            b r1 = j.Companion;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeNullableSerializableElement(r0, 0, com.bytedance.bdnavigationsdk.pojo.b.a.a, r9.a);
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
            r10.encodeFloatElement(r0, 2, r9.c);
        L30:
            if (r10.shouldEncodeElementDefault(r0, 3) == false) goto L33;
        L34:
            boolean r6 = true;
        L36:
            if (r6 == false) goto L39;
            r10.encodeBooleanElement(r0, 3, r9.d);
        L39:
            if (r10.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            r2 = true;
        L44:
            if (r2 == false) goto L46;
            r10.encodeIntElement(r0, 4, r9.e);
        L46:
            r10.endStructure(r0);
            return;
        L42:
            if (r9.e == 0) goto L44;
        L33:
            if (r9.d == true) goto L34;
            r6 = false;
            goto L36
        L24:
            if (Float.compare(r9.c, 0.0f) != 0) goto L25;
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

        public final juc.d<j> serializer() {
            return a.a;
        }
    }

    public j() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof j) == true) goto L8;
        return false;
    L8:
        j r6 = (j) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Float.compare(this.c, r6.c) == 0) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        com.bytedance.bdnavigationsdk.pojo.b r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        com.bytedance.bdnavigationsdk.pojo.a r4 = this.b;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        int r5 = (((r3 + r1) * 31) + Float.floatToIntBits(this.c)) * 31;
        if (this.d == false) goto L13;
        int r6 = 1231;
    L15:
        return ((r5 + r6) * 31) + this.e;
    L13:
        r6 = 1237;
        goto L15
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    static {
        Companion = new b();
    }

    public final String a() {
        ouc.v r0 = ouc.w.a(new i());
        return r0.a(Companion.serializer(), this);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public final String toString() {
        return "NavigationLocation{location=" + this.a + ", projection=" + this.b + ", projectionSegmentIdx=" + this.e + ", projectionBearing=" + this.c + ", suspectedYaw=" + this.d + "}";
    }

    public j(int r1) {
        this.a = null;
        this.b = null;
        this.c = 0.0f;
        this.d = false;
        this.e = 0;
    }

    public j(int r4, com.bytedance.bdnavigationsdk.pojo.b r5, com.bytedance.bdnavigationsdk.pojo.a r6, float r7, boolean r8, int r9) {
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
        this.c = 0.0f;
    L17:
        if ((r4 & 8) != 0) goto L19;
        this.d = false;
    L21:
        if ((r4 & 16) != 0) goto L23;
        this.e = 0;
        return;
    L23:
        this.e = r9;
        return;
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
