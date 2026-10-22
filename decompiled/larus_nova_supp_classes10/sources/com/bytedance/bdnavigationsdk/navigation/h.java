package com.bytedance.bdnavigationsdk.navigation;

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
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Serializable
public final class h {
    public static final b Companion = null;
    public final int a;
    public final int b;
    public final String c;
    public final String d;
    public final Float e;
    public final String f;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<h> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            w0 r1 = w0.a;
            v2 r2 = v2.a;
            return new juc.d[]{r1, r1, kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(l0.a), kuc.a.d(r2)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.navigation.NavigationInstruction", r0, 6);
            r1.j("flag", true);
            r1.j("action", true);
            r1.j("main_action", true);
            r1.j("assist_action", true);
            r1.j("distance", true);
            r1.j("road_name", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r18) {
            Intrinsics.checkNotNullParameter(r18, "decoder");
            g2 r1 = b;
            muc.c r0 = r18.beginStructure(r1);
            if (r0.decodeSequentially() == false) goto L5;
            int r2 = r0.decodeIntElement(r1, 0);
            int r5 = r0.decodeIntElement(r1, 1);
            v2 r6 = v2.a;
            String r3 = (String) r0.decodeNullableSerializableElement(r1, 2, r6, null);
            String r8 = (String) r0.decodeNullableSerializableElement(r1, 3, r6, null);
            int r9 = r2;
            String r11 = r3;
            Float r13 = (Float) r0.decodeNullableSerializableElement(r1, 4, l0.a, null);
            int r10 = r5;
            String r14 = (String) r0.decodeNullableSerializableElement(r1, 5, r6, null);
            String r12 = r8;
            int r15 = 63;
        L20:
            r0.endStructure(r1);
            return new h(r15, r9, r10, r11, r12, r13, r14);
        L5:
            r11 = null;
            Float r16 = null;
            String r17 = null;
            r14 = null;
            int r4 = 0;
            int r19 = 0;
            int r110 = 0;
            boolean r111 = true;
        L6:
            if (r111 == false) goto L19;
            int r7 = r0.decodeElementIndex(r1);
            switch(r7) {
                case -1: goto L18;
                case 0: goto L17;
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r7);
        L17:
            r4 = r0.decodeIntElement(r1, 0);
            r110 = r110 | 1;
            goto L6
        L18:
            r111 = false;
            goto L6
        L11:
            r110 = r110 | 32;
            r14 = (String) r0.decodeNullableSerializableElement(r1, 5, v2.a, r14);
            goto L6
        L12:
            r110 = r110 | 16;
            r16 = (Float) r0.decodeNullableSerializableElement(r1, 4, l0.a, r16);
            goto L6
        L13:
            r110 = r110 | 8;
            r17 = (String) r0.decodeNullableSerializableElement(r1, 3, v2.a, r17);
            goto L6
        L14:
            r110 = r110 | 4;
            r11 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r11);
            goto L6
        L15:
            r19 = r0.decodeIntElement(r1, 1);
            r110 = r110 | 2;
            goto L6
        L19:
            r15 = r110;
            r10 = r19;
            r9 = r4;
            String r112 = r17;
            r13 = r16;
            r12 = r112;
            goto L20
        }

        public final void serialize(muc.f r7, Object r8) {
            h r9 = (h) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            b r1 = h.Companion;
            boolean r2 = false;
            if (r10.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r10.encodeIntElement(r0, 0, r9.a);
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
            r10.encodeNullableSerializableElement(r0, 2, v2.a, r9.c);
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
            r10.encodeNullableSerializableElement(r0, 4, l0.a, r9.e);
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
            if (r9.c != null) goto L25;
            r5 = false;
            goto L27
        L15:
            if (r9.b != 0) goto L16;
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

        public final juc.d<h> serializer() {
            return a.a;
        }
    }

    public h() {
        int r2 = 0;
        this(r2, r2, null, 63);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof h) == true) goto L8;
        return false;
    L8:
        h r6 = (h) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
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
        int r0 = ((this.a * 31) + this.b) * 31;
        String r1 = this.c;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.d;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Float r8 = this.e;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.f;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    static {
        Companion = new b();
    }

    public final String a() {
        int r0 = this.a;
        String r2 = "Error";
        if (r0 == 0) goto L52;
        String r6 = "";
        if (r0 != 1) goto L7;
        Float r1 = this.e;
        if (r1 == null) goto L42;
        String r3 = com.bytedance.bdnavigationsdk.utils.f.a(r1.floatValue());
        if (r3 == null) goto L42;
        r6 = r3;
    L42:
        String r4 = this.c;
        if (r4 == null) goto L46;
        r2 = r4;
    L46:
        String r5 = r2 + r6;
        String r7 = this.f;
        if (r7 == null) goto L77;
        String r8 = "沿" + r7 + "," + r5;
        if (r8 == null) goto L77;
    L78:
        return r8;
    L77:
        return r5;
    L7:
        if (r0 != 2) goto L79;
        r5 = this.d;
        if (r5 != null) goto L13;
        r5 = "Error";
    L13:
        if (this.c == null) goto L15;
    L19:
        Float r9 = this.e;
        if (r9 == null) goto L25;
        String r10 = com.bytedance.bdnavigationsdk.utils.f.a(r9.floatValue()) + "后" + r5;
        if (r10 == null) goto L25;
        r5 = r10;
    L25:
        String r11 = this.c;
        if (r11 == null) goto L29;
        r8 = r11 + r5;
        if (r8 == null) goto L29;
    L30:
        String r12 = this.f;
        if (r12 == null) goto L78;
        r5 = "沿" + r12 + "," + r8;
        if (r5 != null) goto L77;
    L29:
        r8 = "Error" + r5;
        goto L30
    L15:
        if (this.e != null) goto L19;
        if (this.f != null) goto L19;
    L79:
        return "";
    L52:
        String r13 = this.d;
        if (r13 == null) goto L57;
        String r14 = this.f;
        if (r14 == null) goto L57;
        String r15 = r13.concat(r14);
    L58:
        String r16 = this.c;
        if (r16 == null) goto L62;
        if (r15 == null) goto L62;
        r2 = r16 + "," + r15;
    L68:
        Float r17 = this.e;
        if (r17 == null) goto L74;
        String r18 = com.bytedance.bdnavigationsdk.utils.f.a(r17.floatValue()) + "后" + r2;
        if (r18 == null) goto L74;
        String r19 = r18;
    L75:
        Intrinsics.checkNotNull(r19);
        return r19;
    L74:
        r19 = r2;
    L62:
        if (r16 == null) goto L65;
        if (r15 != null) goto L65;
        r2 = r16;
    L65:
        if (r16 != null) goto L68;
        if (r15 == null) goto L68;
        r2 = "Error," + r15;
    L57:
        r15 = null;
        goto L58
    }

    public final String toString() {
        return "NavigationInstruction{flag=" + this.a + ", action=" + this.b + ", mainAction='" + this.c + "', assistAction='" + this.d + "', distance=" + this.e + ", roadName='" + this.f + "'}";
    }

    public /* synthetic */ h(int r10, int r11, String r12, int r13) {
        if ((r13 & 1) == 0) goto L5;
        int r3 = 0;
    L7:
        if ((r13 & 2) == 0) goto L9;
        int r4 = 0;
    L11:
        if ((r13 & 8) == 0) goto L13;
        r12 = null;
    L13:
        this(r3, r4, null, r12, null, null);
        return;
    L9:
        r4 = r11;
        goto L11
    L5:
        r3 = r10;
        goto L7
    }

    public h(int r1, int r2, String r3, String r4, Float r5, String r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public h(int r4, int r5, int r6, String r7, String r8, Float r9, String r10) {
        if ((r4 & 0) == 0) goto L5;
        b2.b(r4, 0, a.b);
        throw null;
    L5:
        if ((r4 & 1) != 0) goto L7;
        this.a = 0;
    L9:
        if ((r4 & 2) != 0) goto L11;
        this.b = 0;
    L13:
        if ((r4 & 4) != 0) goto L15;
        this.c = null;
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
