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
import nuc.m0;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Serializable
public final class g {
    public static final b Companion = null;
    public final String a;
    public final String b;
    public int c;
    public final j d;
    public final k e;
    public final h f;
    public final v g;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<g> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            v2 r1 = v2.a;
            return new juc.d[]{r1, r1, w0.a, j.a.a, k.a.a, h.a.a, kuc.a.d(v.a.a)};
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.navigation.NavigationInformation", r0, 7);
            r1.j("session_id", false);
            r1.j("route_id", false);
            r1.j("code", false);
            r1.j(LocationMonitorConst.LOCATION, false);
            r1.j("progress", false);
            r1.j("instruction", false);
            r1.j("notification", false);
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
            String r2 = r0.decodeStringElement(r1, 0);
            String r5 = r0.decodeStringElement(r1, 1);
            int r3 = r0.decodeIntElement(r1, 2);
            j r6 = (j) r0.decodeSerializableElement(r1, 3, j.a.a, null);
            k r4 = (k) r0.decodeSerializableElement(r1, 4, k.a.a, null);
            h r8 = (h) r0.decodeSerializableElement(r1, 5, h.a.a, null);
            int r10 = r3;
            k r12 = r4;
            String r9 = r5;
            j r11 = r6;
            v r14 = (v) r0.decodeNullableSerializableElement(r1, 6, v.a.a, null);
            h r13 = r8;
            int r7 = 127;
            String r15 = r2;
        L21:
            r0.endStructure(r1);
            return new g(r7, r15, r9, r10, r11, r12, r13, r14);
        L5:
            k r16 = null;
            String r17 = null;
            String r18 = null;
            v r110 = null;
            j r111 = null;
            h r112 = null;
            int r20 = 0;
            int r113 = 0;
            boolean r114 = true;
        L6:
            if (r114 == false) goto L20;
            int r21 = r0.decodeElementIndex(r1);
            switch(r21) {
                case -1: goto L18;
                case 0: goto L17;
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r21);
        L16:
            r18 = r0.decodeStringElement(r1, 1);
            r113 = r113 | 2;
            goto L6
        L17:
            r113 = r113 | 1;
            r17 = r0.decodeStringElement(r1, 0);
            goto L6
        L11:
            r113 = r113 | 64;
            r110 = (v) r0.decodeNullableSerializableElement(r1, 6, v.a.a, r110);
            goto L6
        L12:
            r113 = r113 | 32;
            r112 = (h) r0.decodeSerializableElement(r1, 5, h.a.a, r112);
            goto L6
        L13:
            r113 = r113 | 16;
            r16 = (k) r0.decodeSerializableElement(r1, 4, k.a.a, r16);
            goto L6
        L14:
            r113 = r113 | 8;
            r111 = (j) r0.decodeSerializableElement(r1, 3, j.a.a, r111);
            goto L6
        L15:
            r20 = r0.decodeIntElement(r1, 2);
            r113 = r113 | 4;
            goto L6
        L18:
            r114 = false;
            goto L6
        L20:
            r7 = r113;
            r15 = r17;
            r9 = r18;
            r11 = r111;
            r10 = r20;
            r12 = r16;
            r14 = r110;
            r13 = r112;
            goto L21
        }

        public final void serialize(muc.f r5, Object r6) {
            g r7 = (g) r6;
            Intrinsics.checkNotNullParameter(r5, "encoder");
            Intrinsics.checkNotNullParameter(r7, "value");
            g2 r0 = b;
            muc.d r8 = r5.beginStructure(r0);
            r8.encodeStringElement(r0, 0, r7.a);
            r8.encodeStringElement(r0, 1, r7.b);
            r8.encodeIntElement(r0, 2, r7.c);
            r8.encodeSerializableElement(r0, 3, j.a.a, r7.d);
            r8.encodeSerializableElement(r0, 4, k.a.a, r7.e);
            r8.encodeSerializableElement(r0, 5, h.a.a, r7.f);
            r8.encodeNullableSerializableElement(r0, 6, v.a.a, r7.g);
            r8.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<g> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31;
        v r1 = this.g;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    static {
        Companion = new b();
    }

    public final String toString() {
        return "NavigationInformation{, sessionId='" + this.a + "', routeId='" + this.b + "', navigationCode=" + this.c + ", navigationLocation=" + this.d + ", navigationProgress=" + this.e + ", navigationInstruction=" + this.f + ", notificationInstruction=" + this.g + "}";
    }

    public g(String r2, String r3, j r4, k r5, h r6, v r7) {
        Intrinsics.checkNotNullParameter(r2, "sessionId");
        Intrinsics.checkNotNullParameter(r3, "routeId");
        Intrinsics.checkNotNullParameter(r4, "navigationLocation");
        Intrinsics.checkNotNullParameter(r5, "navigationProgress");
        Intrinsics.checkNotNullParameter(r6, "navigationInstruction");
        this.a = r2;
        this.b = r3;
        this.c = 0;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }

    public g(int r3, String r4, String r5, int r6, j r7, k r8, h r9, v r10) {
        if (127 != (r3 & 127)) goto L6;
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r10;
        return;
    L6:
        b2.b(r3, 127, a.b);
        throw null;
    }
}
