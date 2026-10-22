package com.bytedance.bdnavigationsdk.network.route;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Serializable
public final class t {
    public static final b Companion = null;
    public final int a;
    public final int b;
    public final int c;
    public final String d;
    public final String e;
    public final String f;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<t> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            w0 r1 = w0.a;
            v2 r2 = v2.a;
            return new juc.d[]{u.a, r1, r1, kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(r2)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.network.route.RouteVisualInstruction", r0, 6);
            r1.j("remain_distance", true);
            r1.j("mode", true);
            r1.j("action", true);
            r1.j("main_action", true);
            r1.j("assist_action", true);
            r1.j("road_name", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r17) {
            Intrinsics.checkNotNullParameter(r17, "decoder");
            g2 r1 = b;
            muc.c r0 = r17.beginStructure(r1);
            int r3 = 2;
            if (r0.decodeSequentially() == false) goto L5;
            int r2 = ((Number) r0.decodeSerializableElement(r1, 0, u.a, 0)).intValue();
            int r6 = r0.decodeIntElement(r1, 1);
            int r4 = r0.decodeIntElement(r1, 2);
            v2 r7 = v2.a;
            String r8 = (String) r0.decodeNullableSerializableElement(r1, 3, r7, null);
            int r10 = r2;
            int r12 = r4;
            String r14 = (String) r0.decodeNullableSerializableElement(r1, 4, r7, null);
            String r15 = (String) r0.decodeNullableSerializableElement(r1, 5, r7, null);
            int r11 = r6;
            String r13 = r8;
            int r9 = 63;
        L21:
            r0.endStructure(r1);
            return new t(r9, r10, r11, r12, r13, r14, r15);
        L5:
            String r16 = null;
            r13 = null;
            r14 = null;
            int r5 = 0;
            int r18 = 0;
            int r19 = 0;
            int r110 = 0;
            boolean r111 = true;
        L6:
            if (r111 == false) goto L20;
            int r20 = r0.decodeElementIndex(r1);
            switch(r20) {
                case -1: goto L19;
                case 0: goto L17;
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r20);
        L19:
            r3 = 2;
            r111 = false;
            goto L6
        L11:
            r16 = (String) r0.decodeNullableSerializableElement(r1, 5, v2.a, r16);
            int r21 = r110 | 32;
        L16:
            r110 = r21;
        L18:
            r3 = 2;
            goto L6
        L12:
            r14 = (String) r0.decodeNullableSerializableElement(r1, 4, v2.a, r14);
            r21 = r110 | 16;
            goto L16
        L13:
            r13 = (String) r0.decodeNullableSerializableElement(r1, 3, v2.a, r13);
            r21 = r110 | 8;
            goto L16
        L14:
            r18 = r0.decodeIntElement(r1, r3);
            r21 = r110 | 4;
            goto L16
        L15:
            r19 = r0.decodeIntElement(r1, 1);
            r21 = r110 | 2;
            goto L16
        L17:
            r5 = ((Number) r0.decodeSerializableElement(r1, 0, u.a, Integer.valueOf(r5))).intValue();
            r110 = r110 | 1;
            goto L18
        L20:
            r15 = r16;
            r12 = r18;
            r9 = r110;
            r11 = r19;
            r10 = r5;
            goto L21
        }

        public final void serialize(muc.f r7, Object r8) {
            t r9 = (t) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            b r1 = t.Companion;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeSerializableElement(r0, 0, u.a, Integer.valueOf(r9.a));
        L12:
            if (r10.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            boolean r4 = true;
        L18:
            if (r4 == false) goto L21;
            r10.encodeIntElement(r0, 1, r9.b);
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
            r10.encodeNullableSerializableElement(r0, 3, v2.a, r9.d);
        L39:
            if (r10.shouldEncodeElementDefault(r0, 4) == false) goto L42;
        L43:
            boolean r11 = true;
        L45:
            if (r11 == false) goto L48;
            r10.encodeNullableSerializableElement(r0, 4, v2.a, r9.e);
        L48:
            if (r10.shouldEncodeElementDefault(r0, 5) == false) goto L51;
        L52:
            r2 = true;
        L53:
            if (r2 == false) goto L55;
            r10.encodeNullableSerializableElement(r0, 5, v2.a, r9.f);
        L55:
            r10.endStructure(r0);
            return;
        L51:
            if (r9.f == null) goto L53;
        L42:
            if (r9.e != null) goto L43;
            r11 = false;
            goto L45
        L33:
            if (r9.d != null) goto L34;
            r6 = false;
            goto L36
        L24:
            if (r9.c != 0) goto L25;
            r5 = false;
            goto L27
        L15:
            if (r9.b != 1) goto L16;
            r4 = false;
            goto L18
        L6:
            if (r9.a != 0) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<t> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof t) == true) goto L8;
        return false;
    L8:
        t r6 = (t) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a * 31) + this.b) * 31) + this.c) * 31;
        String r1 = this.d;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.e;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.f;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return r7 + r2;
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "RouteVisualInstruction(remainDistance=" + this.a + ", mode=" + this.b + ", action=" + this.c + ", mainAction=" + this.d + ", assistAction=" + this.e + ", roadName=" + this.f + ")";
    }

    static {
        Companion = new b();
    }

    public t() {
        this.a = 0;
        this.b = 1;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = null;
    }

    public t(int r4, int r5, int r6, int r7, String r8, String r9, String r10) {
        if ((r4 & 0) == 0) goto L5;
        b2.b(r4, 0, a.b);
        throw null;
    L5:
        if ((r4 & 1) != 0) goto L7;
        this.a = 0;
    L9:
        if ((r4 & 2) != 0) goto L11;
        this.b = 1;
    L13:
        if ((r4 & 4) != 0) goto L15;
        this.c = 0;
    L17:
        if ((r4 & 8) != 0) goto L19;
        this.d = null;
    L21:
        if ((r4 & 16) != 0) goto L23;
        this.e = null;
    L25:
        if ((r4 & 32) != 0) goto L27;
        this.f = null;
        return;
    L27:
        this.f = r10;
        return;
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
