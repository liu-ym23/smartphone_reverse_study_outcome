package n84;

import com.bytedance.android.livesdk.link.model.bridge.z0;
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
import nuc.l0;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Serializable
public final class g {
    public static final b Companion = null;
    public static final juc.d<Object>[] i = null;
    public final c a;
    public final c b;
    public final List<c> c;
    public final String d;
    public final Float e;
    public final float f;
    public final long g;
    public final Long h;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<g> {
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
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.agent.NavigationAgentStartInfo", r0, 8);
            r1.j("origin", false);
            r1.j("destination", false);
            r1.j("waypoints", false);
            r1.j("plan_type", false);
            r1.j("expected_duration", true);
            r1.j("route_distance", false);
            r1.j("started_at", false);
            r1.j("expected_arrival_at", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            juc.d<?>[] r0 = g.i;
            c.a r2 = c.a.a;
            l0 r1 = l0.a;
            g1 r3 = g1.a;
            return new juc.d[]{r2, r2, r0[2], v2.a, kuc.a.d(r1), r1, r3, kuc.a.d(r3)};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r21) {
            Intrinsics.checkNotNullParameter(r21, "decoder");
            g2 r1 = b;
            muc.c r0 = r21.beginStructure(r1);
            juc.c[] r2 = g.i;
            int r5 = 6;
            int r6 = 7;
            if (r0.decodeSequentially() == false) goto L5;
            c.a r3 = c.a.a;
            c r9 = (c) r0.decodeSerializableElement(r1, 0, r3, null);
            c r4 = (c) r0.decodeSerializableElement(r1, 1, r3, null);
            List r7 = (List) r0.decodeSerializableElement(r1, 2, r2[2], null);
            String r8 = r0.decodeStringElement(r1, 3);
            Float r10 = (Float) r0.decodeNullableSerializableElement(r1, 4, l0.a, null);
            float r11 = r0.decodeFloatElement(r1, 5);
            long r12 = r0.decodeLongElement(r1, 6);
            int r13 = 255;
            Long r15 = (Long) r0.decodeNullableSerializableElement(r1, 7, g1.a, null);
            float r14 = r11;
            long r16 = r12;
            c r17 = r4;
            String r18 = r8;
            Float r19 = r10;
            c r20 = r9;
            List r22 = r7;
        L25:
            r0.endStructure(r1);
            return new g(r13, r20, r17, r22, r18, r19, r14, r16, r15);
        L5:
            r16 = 0;
            Float r23 = null;
            r22 = null;
            Long r110 = null;
            c r111 = null;
            c r112 = null;
            String r113 = null;
            int r24 = 0;
            r14 = 0.0f;
            boolean r114 = true;
        L6:
            if (r114 == false) goto L24;
            int r25 = r0.decodeElementIndex(r1);
            switch(r25) {
                case -1: goto L23;
                case 0: goto L21;
                case 1: goto L19;
                case 2: goto L17;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r25);
        L23:
            r5 = 6;
            r6 = 7;
            r114 = false;
            goto L6
        L11:
            r110 = (Long) r0.decodeNullableSerializableElement(r1, r6, g1.a, r110);
            r24 = r24 | DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE;
        L18:
            c r26 = r112;
        L22:
            r112 = r26;
            r5 = 6;
            r6 = 7;
            goto L6
        L12:
            r16 = r0.decodeLongElement(r1, r5);
            r24 = r24 | 64;
            goto L18
        L13:
            r14 = r0.decodeFloatElement(r1, 5);
            r24 = r24 | 32;
            goto L18
        L14:
            r23 = (Float) r0.decodeNullableSerializableElement(r1, 4, l0.a, r23);
            r24 = r24 | 16;
            goto L18
        L15:
            r113 = r0.decodeStringElement(r1, 3);
            r24 = r24 | 8;
            goto L18
        L17:
            r22 = (List) r0.decodeSerializableElement(r1, 2, r2[2], r22);
            r24 = r24 | 4;
            goto L18
        L19:
            r26 = (c) r0.decodeSerializableElement(r1, 1, c.a.a, r112);
            r24 = r24 | 2;
            goto L22
        L21:
            r24 = r24 | 1;
            r111 = (c) r0.decodeSerializableElement(r1, 0, c.a.a, r111);
            r26 = r112;
            goto L22
        L24:
            r13 = r24;
            r17 = r112;
            r19 = r23;
            r20 = r111;
            r15 = r110;
            r18 = r113;
            goto L25
        }

        public final void serialize(muc.f r7, Object r8) {
            g r9 = (g) r8;
            Intrinsics.checkNotNullParameter(r7, "encoder");
            Intrinsics.checkNotNullParameter(r9, "value");
            g2 r0 = b;
            muc.d r10 = r7.beginStructure(r0);
            n[] r1 = g.i;
            c.a r2 = c.a.a;
            boolean r4 = false;
            r10.encodeSerializableElement(r0, 0, r2, r9.a);
            r10.encodeSerializableElement(r0, 1, r2, r9.b);
            r10.encodeSerializableElement(r0, 2, r1[2], r9.c);
            r10.encodeStringElement(r0, 3, r9.d);
            if (r10.shouldEncodeElementDefault(r0, 4) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L11;
            r10.encodeNullableSerializableElement(r0, 4, l0.a, r9.e);
        L11:
            r10.encodeFloatElement(r0, 5, r9.f);
            r10.encodeLongElement(r0, 6, r9.g);
            if (r10.shouldEncodeElementDefault(r0, 7) == false) goto L15;
        L16:
            r4 = true;
        L17:
            if (r4 == false) goto L19;
            r10.encodeNullableSerializableElement(r0, 7, g1.a, r9.h);
        L19:
            r10.endStructure(r0);
            return;
        L15:
            if (r9.h == null) goto L17;
        L6:
            if (r9.e != null) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<g> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof g) == true) goto L8;
        return false;
    L8:
        g r9 = (g) r8;
        if (Intrinsics.areEqual(this.a, r9.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r9.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r9.e) == true) goto L24;
        return false;
    L24:
        if (Float.compare(this.f, r9.f) == 0) goto L27;
        return false;
    L27:
        if (this.g == r9.g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        Float r1 = this.e;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + Float.floatToIntBits(this.f)) * 31;
        long r5 = this.g;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        Long r7 = this.h;
        if (r7 == null) goto L11;
        r2 = r7.hashCode();
    L11:
        return r6 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "NavigationAgentStartInfo(origin=" + this.a + ", destination=" + this.b + ", waypoints=" + this.c + ", planType=" + this.d + ", expectedDuration=" + this.e + ", routeDistance=" + this.f + ", startedAt=" + this.g + ", expectedArrivalAt=" + this.h + ")";
    }

    static {
        Companion = new b();
        i = new juc.d[]{null, null, new nuc.f(c.a.a), null, null, null, null, null};
    }

    public g(c r2, c r3, List<c> r4, String r5, Float r6, float r7, long r8, Long r10) {
        Intrinsics.checkNotNullParameter(r2, "origin");
        Intrinsics.checkNotNullParameter(r3, "destination");
        Intrinsics.checkNotNullParameter(r4, "waypoints");
        Intrinsics.checkNotNullParameter(r5, "planType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r10;
    }

    public g(int r4, c r5, c r6, List r7, String r8, Float r9, float r10, long r11, Long r13) {
        if (111 != (r4 & z0.TYPE_APPLY_CLEAN)) goto L13;
        this.a = r5;
        this.b = r6;
        this.c = r7;
        this.d = r8;
        if ((r4 & 16) != 0) goto L7;
        this.e = null;
    L8:
        this.f = r10;
        this.g = r11;
        if ((r4 & DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE) != 0) goto L11;
        this.h = null;
        return;
    L11:
        this.h = r13;
        return;
    L7:
        this.e = r9;
        goto L8
    L13:
        b2.b(r4, z0.TYPE_APPLY_CLEAN, a.b);
        throw null;
    }
}
