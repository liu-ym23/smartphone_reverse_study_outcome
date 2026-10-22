package n84;

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
public final class a {
    public static final b Companion = null;
    public final int a;
    public final int b;
    public final String c;
    public final String d;
    public final Float e;
    public final String f;
    public final String g;

    /* JADX INFO: renamed from: n84.a$a, reason: collision with other inner class name */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class C0156a implements m0<a> {
        public static final C0156a a = null;
        public static final g2 b = null;

        public C0156a() {
        }

        public final juc.d<?>[] childSerializers() {
            w0 r1 = w0.a;
            v2 r2 = v2.a;
            return new juc.d[]{r1, r1, kuc.a.d(r2), kuc.a.d(r2), kuc.a.d(l0.a), kuc.a.d(r2), r2};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            C0156a r0 = new C0156a();
            a = r0;
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.agent.NavigationAgentActionInfo", r0, 7);
            r1.j("flag", false);
            r1.j("action", false);
            r1.j("main_action", true);
            r1.j("assist_action", true);
            r1.j("distance", true);
            r1.j("road_name", true);
            r1.j("action_text", false);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r19) {
            Intrinsics.checkNotNullParameter(r19, "decoder");
            g2 r1 = b;
            muc.c r0 = r19.beginStructure(r1);
            if (r0.decodeSequentially() == false) goto L5;
            int r2 = r0.decodeIntElement(r1, 0);
            int r5 = r0.decodeIntElement(r1, 1);
            v2 r6 = v2.a;
            String r3 = (String) r0.decodeNullableSerializableElement(r1, 2, r6, null);
            String r9 = (String) r0.decodeNullableSerializableElement(r1, 3, r6, null);
            Float r4 = (Float) r0.decodeNullableSerializableElement(r1, 4, l0.a, null);
            int r8 = r2;
            String r10 = r3;
            Float r12 = r4;
            String r13 = (String) r0.decodeNullableSerializableElement(r1, 5, r6, null);
            String r14 = r0.decodeStringElement(r1, 6);
            String r11 = r9;
            int r7 = 127;
            int r15 = r5;
        L22:
            r0.endStructure(r1);
            return new a(r7, r8, r15, r10, r11, r12, r13, r14);
        L5:
            Float r16 = null;
            String r17 = null;
            String r18 = null;
            r14 = null;
            String r110 = null;
            int r20 = 0;
            int r111 = 0;
            int r112 = 0;
            boolean r113 = true;
        L6:
            if (r113 == false) goto L21;
            int r21 = r0.decodeElementIndex(r1);
            switch(r21) {
                case -1: goto L19;
                case 0: goto L18;
                case 1: goto L17;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r21);
        L17:
            r111 = r0.decodeIntElement(r1, 1);
            r112 = r112 | 2;
            goto L6
        L18:
            r112 = r112 | 1;
            r20 = r0.decodeIntElement(r1, 0);
            goto L6
        L11:
            r112 = r112 | 64;
            r14 = r0.decodeStringElement(r1, 6);
        L16:
            boolean r114 = r113;
        L20:
            r113 = r114;
            goto L6
        L12:
            r112 = r112 | 32;
            r110 = (String) r0.decodeNullableSerializableElement(r1, 5, v2.a, r110);
            goto L16
        L13:
            r112 = r112 | 16;
            r16 = (Float) r0.decodeNullableSerializableElement(r1, 4, l0.a, r16);
            goto L16
        L14:
            r112 = r112 | 8;
            r17 = (String) r0.decodeNullableSerializableElement(r1, 3, v2.a, r17);
            goto L16
        L15:
            r112 = r112 | 4;
            r18 = (String) r0.decodeNullableSerializableElement(r1, 2, v2.a, r18);
            goto L16
        L19:
            r114 = false;
            goto L20
        L21:
            r8 = r20;
            r15 = r111;
            r7 = r112;
            r11 = r17;
            r10 = r18;
            r13 = r110;
            r12 = r16;
            goto L22
        }

        public final void serialize(muc.f r7, Object r8) {
            a r9 = (a) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            boolean r2 = false;
            r10.encodeIntElement(r0, 0, r9.a);
            r10.encodeIntElement(r0, 1, r9.b);
            if (r10.shouldEncodeElementDefault(r0, 2) == false) goto L6;
        L7:
            boolean r4 = true;
        L9:
            if (r4 == false) goto L12;
            r10.encodeNullableSerializableElement(r0, 2, v2.a, r9.c);
        L12:
            if (r10.shouldEncodeElementDefault(r0, 3) == false) goto L15;
        L16:
            boolean r5 = true;
        L18:
            if (r5 == false) goto L21;
            r10.encodeNullableSerializableElement(r0, 3, v2.a, r9.d);
        L21:
            if (r10.shouldEncodeElementDefault(r0, 4) == false) goto L24;
        L25:
            boolean r6 = true;
        L27:
            if (r6 == false) goto L30;
            r10.encodeNullableSerializableElement(r0, 4, l0.a, r9.e);
        L30:
            if (r10.shouldEncodeElementDefault(r0, 5) == false) goto L33;
        L34:
            r2 = true;
        L35:
            if (r2 == false) goto L37;
            r10.encodeNullableSerializableElement(r0, 5, v2.a, r9.f);
        L37:
            r10.encodeStringElement(r0, 6, r9.g);
            r10.endStructure(r0);
            return;
        L33:
            if (r9.f == null) goto L35;
        L24:
            if (r9.e != null) goto L25;
            r6 = false;
            goto L27
        L15:
            if (r9.d != null) goto L16;
            r5 = false;
            goto L18
        L6:
            if (r9.c != null) goto L7;
            r4 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<a> serializer() {
            return C0156a.a;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
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
        return ((r10 + r2) * 31) + this.g.hashCode();
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

    public final String toString() {
        return "NavigationAgentActionInfo(flag=" + this.a + ", action=" + this.b + ", mainAction=" + this.c + ", assistAction=" + this.d + ", distance=" + this.e + ", roadName=" + this.f + ", actionText=" + this.g + ")";
    }

    static {
        Companion = new b();
    }

    public a(int r2, int r3, String r4, String r5, Float r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r8, "actionText");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }

    public a(int r4, int r5, int r6, String r7, String r8, Float r9, String r10, String r11) {
        if (67 != (r4 & 67)) goto L22;
        this.a = r5;
        this.b = r6;
        if ((r4 & 4) != 0) goto L7;
        this.c = null;
    L9:
        if ((r4 & 8) != 0) goto L11;
        this.d = null;
    L13:
        if ((r4 & 16) != 0) goto L15;
        this.e = null;
    L17:
        if ((r4 & 32) != 0) goto L19;
        this.f = null;
    L20:
        this.g = r11;
        return;
    L19:
        this.f = r10;
        goto L20
    L15:
        this.e = r9;
        goto L17
    L11:
        this.d = r8;
        goto L13
    L7:
        this.c = r7;
        goto L9
    L22:
        b2.b(r4, 67, C0156a.b);
        throw null;
    }
}
