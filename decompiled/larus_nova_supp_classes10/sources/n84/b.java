package n84;

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
public final class b {
    public static final C0157b Companion = null;
    public static final juc.d<Object>[] i = null;
    public final float a;
    public final float b;
    public final List<c> c;
    public final c d;
    public final c e;
    public final long f;
    public final long g;
    public final List<String> h;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<b> {
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
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.agent.NavigationAgentEndInfo", r0, 8);
            r1.j("passed_duration", false);
            r1.j("passed_distance", false);
            r1.j("passed_waypoints", false);
            r1.j("origin", false);
            r1.j("destination", false);
            r1.j("started_at", false);
            r1.j("ended_at", false);
            r1.j("passed_road_names", false);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            juc.d<?>[] r0 = b.i;
            l0 r2 = l0.a;
            c.a r3 = c.a.a;
            g1 r4 = g1.a;
            return new juc.d[]{r2, r2, r0[2], r3, r3, r4, r4, r0[7]};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r24) {
            Intrinsics.checkNotNullParameter(r24, "decoder");
            g2 r1 = b;
            muc.c r0 = r24.beginStructure(r1);
            juc.c[] r2 = b.i;
            int r5 = 6;
            int r7 = 4;
            if (r0.decodeSequentially() == false) goto L5;
            float r3 = r0.decodeFloatElement(r1, 0);
            float r8 = r0.decodeFloatElement(r1, 1);
            List r6 = (List) r0.decodeSerializableElement(r1, 2, r2[2], null);
            c.a r9 = c.a.a;
            c r4 = (c) r0.decodeSerializableElement(r1, 3, r9, null);
            c r10 = (c) r0.decodeSerializableElement(r1, 4, r9, null);
            long r11 = r0.decodeLongElement(r1, 5);
            long r13 = r0.decodeLongElement(r1, 6);
            List r16 = (List) r0.decodeSerializableElement(r1, 7, r2[7], null);
            c r12 = r10;
            long r14 = r13;
            float r15 = r3;
            long r17 = r11;
            c r18 = r4;
            List r19 = r6;
            int r20 = 255;
        L25:
            r0.endStructure(r1);
            return new b(r20, r15, r8, r19, r18, r12, r17, r14, r16);
        L5:
            float r21 = 0.0f;
            c r22 = null;
            List r23 = null;
            List r25 = null;
            c r110 = null;
            long r111 = 0;
            int r112 = 0;
            boolean r26 = true;
            long r113 = 0;
            float r114 = 0.0f;
        L6:
            if (r26 == false) goto L24;
            int r27 = r0.decodeElementIndex(r1);
            switch(r27) {
                case -1: goto L23;
                case 0: goto L21;
                case 1: goto L20;
                case 2: goto L18;
                case 3: goto L16;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r27);
        L23:
            r5 = 6;
            r7 = 4;
            r26 = false;
            goto L6
        L11:
            List r28 = (List) r0.decodeSerializableElement(r1, 7, r2[7], r25);
            float r115 = r21;
            r112 = r112 | DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE;
            c r29 = r110;
            r25 = r28;
        L22:
            r110 = r29;
            r21 = r115;
            r5 = 6;
            r7 = 4;
            goto L6
        L12:
            r111 = r0.decodeLongElement(r1, r5);
            int r30 = r112 | 64;
        L15:
            r29 = r110;
        L17:
            int r31 = r30;
        L19:
            r115 = r21;
            r112 = r31;
            goto L22
        L13:
            r113 = r0.decodeLongElement(r1, 5);
            r30 = r112 | 32;
            goto L15
        L14:
            r22 = (c) r0.decodeSerializableElement(r1, r7, c.a.a, r22);
            r30 = r112 | 16;
            goto L15
        L16:
            r29 = (c) r0.decodeSerializableElement(r1, 3, c.a.a, r110);
            r30 = r112 | 8;
            goto L17
        L18:
            r29 = r110;
            r23 = (List) r0.decodeSerializableElement(r1, 2, r2[2], r23);
            r31 = r112 | 4;
            goto L19
        L20:
            r29 = r110;
            r114 = r0.decodeFloatElement(r1, 1);
            r112 = r112 | 2;
            r115 = r21;
            goto L22
        L21:
            r29 = r110;
            r115 = r0.decodeFloatElement(r1, 0);
            r112 = r112 | 1;
            goto L22
        L24:
            r15 = r21;
            r18 = r110;
            r12 = r22;
            r16 = r25;
            r20 = r112;
            r19 = r23;
            r8 = r114;
            r17 = r113;
            r14 = r111;
            goto L25
        }

        public final void serialize(muc.f r6, Object r7) {
            b r8 = (b) r7;
            Intrinsics.checkNotNullParameter(r6, "encoder");
            Intrinsics.checkNotNullParameter(r8, "value");
            g2 r0 = b;
            muc.d r9 = r6.beginStructure(r0);
            n[] r1 = b.i;
            r9.encodeFloatElement(r0, 0, r8.a);
            r9.encodeFloatElement(r0, 1, r8.b);
            r9.encodeSerializableElement(r0, 2, r1[2], r8.c);
            c.a r2 = c.a.a;
            r9.encodeSerializableElement(r0, 3, r2, r8.d);
            r9.encodeSerializableElement(r0, 4, r2, r8.e);
            r9.encodeLongElement(r0, 5, r8.f);
            r9.encodeLongElement(r0, 6, r8.g);
            r9.encodeSerializableElement(r0, 7, r1[7], r8.h);
            r9.endStructure(r0);
        }
    }

    /* JADX INFO: renamed from: n84.b$b, reason: collision with other inner class name */
    public static final class C0157b {
        public C0157b() {
        }

        public final juc.d<b> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof b) == true) goto L8;
        return false;
    L8:
        b r9 = (b) r8;
        if (Float.compare(this.a, r9.a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.b, r9.b) == 0) goto L15;
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
        if (this.f == r9.f) goto L27;
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
        int r0 = ((((((((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        long r1 = this.f;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.g;
        return ((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.h.hashCode();
    }

    public final String toString() {
        return "NavigationAgentEndInfo(passedDuration=" + this.a + ", passedDistance=" + this.b + ", passedWaypoints=" + this.c + ", origin=" + this.d + ", destination=" + this.e + ", startedAt=" + this.f + ", endedAt=" + this.g + ", passedRoadNames=" + this.h + ")";
    }

    static {
        Companion = new C0157b();
        i = new juc.d[]{null, null, new nuc.f(c.a.a), null, null, null, null, new nuc.f(v2.a)};
    }

    public b(float r2, float r3, List<c> r4, c r5, c r6, long r7, long r9, List<String> r11) {
        Intrinsics.checkNotNullParameter(r4, "passedWaypoints");
        Intrinsics.checkNotNullParameter(r5, "origin");
        Intrinsics.checkNotNullParameter(r6, "destination");
        Intrinsics.checkNotNullParameter(r11, "passedRoadNames");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r9;
        this.h = r11;
    }

    public b(int r3, float r4, float r5, List r6, c r7, c r8, long r9, long r11, List r13) {
        if (255 != (r3 & 255)) goto L6;
        this.a = r4;
        this.b = r5;
        this.c = r6;
        this.d = r7;
        this.e = r8;
        this.f = r9;
        this.g = r11;
        this.h = r13;
        return;
    L6:
        b2.b(r3, 255, a.b);
        throw null;
    }
}
