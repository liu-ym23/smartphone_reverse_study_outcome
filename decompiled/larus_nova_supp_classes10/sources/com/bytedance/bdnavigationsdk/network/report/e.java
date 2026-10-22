package com.bytedance.bdnavigationsdk.network.report;

import com.bytedance.bdlocation.network.model.DeviceStatus$DiffDimension;
import java.util.List;
import juc.n;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Serializable
public final class e {
    public static final b Companion = null;
    public static final juc.d<Object>[] i = null;
    public final com.bytedance.bdnavigationsdk.network.config.b a;
    public long b;
    public long c;
    public long d;
    public long e;
    public final List<String> f;
    public final List<String> g;
    public List<String> h;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<e> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.network.report.ReportNavigationContent", r0, 8);
            r1.j("navigation_start", false);
            r1.j("navigation_start_ts", true);
            r1.j("navigation_end_ts", true);
            r1.j("first_location_ts", true);
            r1.j("last_location_ts", true);
            r1.j("navigation_routes", false);
            r1.j("navigation_exceptions", false);
            r1.j("navigation_end", false);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            juc.d<?>[] r0 = e.i;
            g1 r2 = g1.a;
            return new juc.d[]{com.bytedance.bdnavigationsdk.network.config.b.a.a, r2, r2, r2, r2, r0[5], r0[6], r0[7]};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r25) {
            Intrinsics.checkNotNullParameter(r25, "decoder");
            g2 r1 = b;
            muc.c r0 = r25.beginStructure(r1);
            juc.c[] r2 = e.i;
            int r4 = 3;
            int r6 = 4;
            List r12 = null;
            if (r0.decodeSequentially() == false) goto L5;
            com.bytedance.bdnavigationsdk.network.config.b r3 = (com.bytedance.bdnavigationsdk.network.config.b) r0.decodeSerializableElement(r1, 0, com.bytedance.bdnavigationsdk.network.config.b.a.a, null);
            long r7 = r0.decodeLongElement(r1, 1);
            long r13 = r0.decodeLongElement(r1, 2);
            long r5 = r0.decodeLongElement(r1, 3);
            long r15 = r0.decodeLongElement(r1, 4);
            List r8 = (List) r0.decodeSerializableElement(r1, 5, r2[5], null);
            List r10 = (List) r0.decodeSerializableElement(r1, 6, r2[6], null);
            List r19 = (List) r0.decodeSerializableElement(r1, 7, r2[7], null);
            List r17 = r8;
            List r18 = r10;
            long r11 = r13;
            long r14 = r5;
            long r9 = r7;
            int r16 = 255;
            com.bytedance.bdnavigationsdk.network.config.b r20 = r3;
        L23:
            r0.endStructure(r1);
            return new e(r16, r20, r9, r11, r14, r15, r17, r18, r19);
        L5:
            r14 = 0;
            List r21 = null;
            List r22 = null;
            com.bytedance.bdnavigationsdk.network.config.b r110 = null;
            long r111 = 0;
            long r112 = 0;
            long r23 = 0;
            int r24 = 0;
            boolean r26 = true;
        L6:
            if (r26 == false) goto L22;
            int r27 = r0.decodeElementIndex(r1);
            switch(r27) {
                case -1: goto L21;
                case 0: goto L19;
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r27);
        L21:
            r6 = 4;
            r26 = false;
            goto L6
        L11:
            r21 = (List) r0.decodeSerializableElement(r1, 7, r2[7], r21);
            r24 = r24 | DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE;
        L20:
            r4 = 3;
            r6 = 4;
            goto L6
        L12:
            r12 = (List) r0.decodeSerializableElement(r1, 6, r2[6], r12);
            r24 = r24 | 64;
            goto L20
        L13:
            r22 = (List) r0.decodeSerializableElement(r1, 5, r2[5], r22);
            r24 = r24 | 32;
            goto L20
        L14:
            r23 = r0.decodeLongElement(r1, r6);
            r24 = r24 | 16;
            goto L20
        L15:
            r14 = r0.decodeLongElement(r1, r4);
            r24 = r24 | 8;
            goto L20
        L16:
            r112 = r0.decodeLongElement(r1, 2);
            r24 = r24 | 4;
            goto L20
        L17:
            r24 = r24 | 2;
            r111 = r0.decodeLongElement(r1, 1);
            goto L20
        L19:
            r110 = (com.bytedance.bdnavigationsdk.network.config.b) r0.decodeSerializableElement(r1, 0, com.bytedance.bdnavigationsdk.network.config.b.a.a, r110);
            r24 = r24 | 1;
            goto L20
        L22:
            com.bytedance.bdnavigationsdk.network.config.b r28 = r110;
            r17 = r22;
            r18 = r12;
            r9 = r111;
            r11 = r112;
            r15 = r23;
            r20 = r28;
            r19 = r21;
            r16 = r24;
            goto L23
        }

        public final void serialize(muc.f r11, Object r12) {
            e r13 = (e) r12;
            Intrinsics.checkNotNullParameter(r11, "encoder");
            Intrinsics.checkNotNullParameter(r13, "value");
            g2 r0 = b;
            muc.d r14 = r11.beginStructure(r0);
            n[] r1 = e.i;
            boolean r4 = false;
            r14.encodeSerializableElement(r0, 0, com.bytedance.bdnavigationsdk.network.config.b.a.a, r13.a);
            if (r14.shouldEncodeElementDefault(r0, 1) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r14.encodeLongElement(r0, 1, r13.b);
        L12:
            if (r14.shouldEncodeElementDefault(r0, 2) == false) goto L15;
        L16:
            boolean r7 = true;
        L18:
            if (r7 == false) goto L21;
            r14.encodeLongElement(r0, 2, r13.c);
        L21:
            if (r14.shouldEncodeElementDefault(r0, 3) == false) goto L24;
        L25:
            boolean r8 = true;
        L27:
            if (r8 == false) goto L30;
            r14.encodeLongElement(r0, 3, r13.d);
        L30:
            if (r14.shouldEncodeElementDefault(r0, 4) == false) goto L33;
        L34:
            r4 = true;
        L35:
            if (r4 == false) goto L37;
            r14.encodeLongElement(r0, 4, r13.e);
        L37:
            r14.encodeSerializableElement(r0, 5, r1[5], r13.f);
            r14.encodeSerializableElement(r0, 6, r1[6], r13.g);
            r14.encodeSerializableElement(r0, 7, r1[7], r13.h);
            r14.endStructure(r0);
            return;
        L33:
            if (r13.e == 0) goto L35;
        L24:
            if (r13.d != 0) goto L25;
            r8 = false;
            goto L27
        L15:
            if (r13.c != 0) goto L16;
            r7 = false;
            goto L18
        L6:
            if (r13.b != 0) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<e> serializer() {
            return a.a;
        }
    }

    public e() {
        throw null;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof e) == true) goto L8;
        return false;
    L8:
        e r9 = (e) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a.hashCode() * 31;
        long r1 = this.b;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.c;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = this.d;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        long r7 = this.e;
        return ((((((r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
    }

    static {
        Companion = new b();
        v2 r2 = v2.a;
        i = new juc.d[]{null, null, null, null, null, new nuc.f(r2), new nuc.f(r2), new nuc.f(r2)};
    }

    public final String toString() {
        return "ReportContent{navigationStart='" + this.a + "', navigationStartTimestamp=" + this.b + ", navigationEndTimestamp=" + this.c + ", firstLocationTimestamp=" + this.d + ", lastLocationTimestamp=" + this.e + ", navigationRoutes=" + this.f + ", navigationExceptions=" + this.g + ", navigationEnd='" + this.h + "'}";
    }

    public e(com.bytedance.bdnavigationsdk.network.config.b r3, List r4, List r5, List r6) {
        Intrinsics.checkNotNullParameter(r3, "navigationStart");
        Intrinsics.checkNotNullParameter(r4, "navigationRoutes");
        Intrinsics.checkNotNullParameter(r5, "navigationExceptions");
        Intrinsics.checkNotNullParameter(r6, "navigationEnd");
        this.a = r3;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = r4;
        this.g = r5;
        this.h = r6;
    }

    public e(int r3, com.bytedance.bdnavigationsdk.network.config.b r4, long r5, long r7, long r9, long r11, List r13, List r14, List r15) {
        if (225 != (r3 & 225)) goto L22;
        this.a = r4;
        if ((r3 & 2) != 0) goto L7;
        this.b = 0;
    L9:
        if ((r3 & 4) != 0) goto L11;
        this.c = 0;
    L13:
        if ((r3 & 8) != 0) goto L15;
        this.d = 0;
    L17:
        if ((r3 & 16) != 0) goto L19;
        this.e = 0;
    L20:
        this.f = r13;
        this.g = r14;
        this.h = r15;
        return;
    L19:
        this.e = r11;
        goto L20
    L15:
        this.d = r9;
        goto L17
    L11:
        this.c = r7;
        goto L13
    L7:
        this.b = r5;
        goto L9
    L22:
        b2.b(r3, 225, a.b);
        throw null;
    }
}
