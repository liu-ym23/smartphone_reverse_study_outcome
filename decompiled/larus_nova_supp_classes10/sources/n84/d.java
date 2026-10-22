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
import nuc.i;
import nuc.i2;
import nuc.l0;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Serializable
public final class d {
    public static final b Companion = null;
    public static final juc.d<Object>[] q = null;
    public final long a;
    public final boolean b;
    public final c c;
    public final c d;
    public final String e;
    public final List<c> f;
    public final float g;
    public final float h;
    public final List<String> i;
    public final float j;
    public final float k;
    public final float l;
    public final float m;
    public final List<c> n;
    public final List<c> o;
    public final n84.a p;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<d> {
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
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.agent.NavigationAgentSnapshot", r0, 16);
            r1.j("updated_at", false);
            r1.j("is_suspected_yaw", false);
            r1.j("origin", false);
            r1.j("destination", false);
            r1.j("plan_type", false);
            r1.j("waypoints", false);
            r1.j("route_distance", false);
            r1.j("route_duration", false);
            r1.j("route_road_names", false);
            r1.j("passed_distance", false);
            r1.j("passed_duration", false);
            r1.j("remaining_distance", false);
            r1.j("remaining_duration", false);
            r1.j("passed_waypoints", false);
            r1.j("remaining_waypoints", false);
            r1.j("next_action", false);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            juc.d<?>[] r0 = d.q;
            c.a r2 = c.a.a;
            l0 r3 = l0.a;
            return new juc.d[]{g1.a, i.a, r2, r2, v2.a, r0[5], r3, r3, r0[8], r3, r3, r3, r3, r0[13], r0[14], n84.a.C0156a.a};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r40) {
            Intrinsics.checkNotNullParameter(r40, "decoder");
            g2 r1 = b;
            muc.c r0 = r40.beginStructure(r1);
            juc.c[] r2 = d.q;
            int r14 = 9;
            int r4 = 8;
            if (r0.decodeSequentially() == false) goto L5;
            long r20 = r0.decodeLongElement(r1, 0);
            boolean r3 = r0.decodeBooleanElement(r1, 1);
            c.a r7 = c.a.a;
            c r5 = (c) r0.decodeSerializableElement(r1, 2, r7, null);
            c r8 = (c) r0.decodeSerializableElement(r1, 3, r7, null);
            String r6 = r0.decodeStringElement(r1, 4);
            List r9 = (List) r0.decodeSerializableElement(r1, 5, r2[5], null);
            float r10 = r0.decodeFloatElement(r1, 6);
            float r11 = r0.decodeFloatElement(r1, 7);
            List r12 = (List) r0.decodeSerializableElement(r1, 8, r2[8], null);
            float r13 = r0.decodeFloatElement(r1, 9);
            float r15 = r0.decodeFloatElement(r1, 10);
            float r16 = r0.decodeFloatElement(r1, 11);
            float r17 = r0.decodeFloatElement(r1, 12);
            boolean r18 = r3;
            List r19 = (List) r0.decodeSerializableElement(r1, 13, r2[13], null);
            List r31 = (List) r0.decodeSerializableElement(r1, 14, r2[14], null);
            List r30 = r19;
            List r25 = r12;
            c r110 = r5;
            n84.a r32 = (n84.a) r0.decodeSerializableElement(r1, 15, n84.a.C0156a.a, null);
            float r23 = r10;
            float r24 = r11;
            float r26 = r13;
            float r27 = r15;
            float r28 = r16;
            float r29 = r17;
            List r22 = r9;
            int r111 = 65535;
            String r21 = r6;
            c r210 = r8;
            long r112 = r20;
        L38:
            r0.endStructure(r1);
            return new d(r111, r112, r18, r110, r210, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32);
        L5:
            int r33 = 15;
            int r34 = 0;
            c r35 = null;
            List r36 = null;
            List r37 = null;
            n84.a r113 = null;
            List r114 = null;
            List r115 = null;
            c r211 = null;
            String r212 = null;
            long r38 = 0;
            boolean r39 = false;
            float r213 = 0.0f;
            float r214 = 0.0f;
            float r310 = 0.0f;
            float r311 = 0.0f;
            float r312 = 0.0f;
            float r313 = 0.0f;
            boolean r314 = true;
        L6:
            if (r314 == false) goto L37;
            int r116 = r0.decodeElementIndex(r1);
            switch(r116) {
                case -1: goto L36;
                case 0: goto L33;
                case 1: goto L32;
                case 2: goto L31;
                case 3: goto L29;
                case 4: goto L27;
                case 5: goto L24;
                case 6: goto L22;
                case 7: goto L21;
                case 8: goto L20;
                case 9: goto L18;
                case 10: goto L17;
                case 11: goto L16;
                case 12: goto L15;
                case 13: goto L13;
                case 14: goto L12;
                case 15: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r116);
        L12:
            r115 = (List) r0.decodeSerializableElement(r1, 14, r2[14], r115);
            r34 = r34 | 16384;
        L35:
            r4 = 8;
            r33 = 15;
            r14 = 9;
            goto L6
        L13:
            r37 = (List) r0.decodeSerializableElement(r1, 13, r2[13], r37);
            r34 = r34 | 8192;
            goto L35
        L15:
            r313 = r0.decodeFloatElement(r1, 12);
            r34 = r34 | 4096;
            goto L35
        L16:
            r312 = r0.decodeFloatElement(r1, 11);
            r34 = r34 | 2048;
            goto L35
        L17:
            r311 = r0.decodeFloatElement(r1, 10);
            r34 = r34 | DeviceStatus$DiffDimension.DIFF_BLUETOOTH_PERMISSION;
            goto L35
        L18:
            r310 = r0.decodeFloatElement(r1, r14);
            r34 = r34 | DeviceStatus$DiffDimension.DIFF_IS_STRICT_RESTRICTED_MODE;
            goto L35
        L20:
            r114 = (List) r0.decodeSerializableElement(r1, r4, r2[r4], r114);
            int r41 = r34 | DeviceStatus$DiffDimension.DIFF_LOCATION_MODE;
        L25:
            int r42 = r41;
        L30:
            r34 = r42;
            goto L35
        L21:
            r214 = r0.decodeFloatElement(r1, 7);
            int r43 = r34 | DeviceStatus$DiffDimension.DIFF_RESTRICTED_MODE;
        L28:
            r42 = r43;
            goto L30
        L22:
            r213 = r0.decodeFloatElement(r1, 6);
            r43 = r34 | 64;
            goto L28
        L24:
            r36 = (List) r0.decodeSerializableElement(r1, 5, r2[5], r36);
            r41 = r34 | 32;
            goto L25
        L27:
            r212 = r0.decodeStringElement(r1, 4);
            r43 = r34 | 16;
            goto L28
        L29:
            r35 = (c) r0.decodeSerializableElement(r1, 3, c.a.a, r35);
            r42 = r34 | 8;
            goto L30
        L31:
            r211 = (c) r0.decodeSerializableElement(r1, 2, c.a.a, r211);
            r34 = r34 | 4;
            goto L35
        L32:
            r39 = r0.decodeBooleanElement(r1, 1);
            r34 = r34 | 2;
        L34:
            r211 = r211;
            goto L35
        L33:
            r38 = r0.decodeLongElement(r1, 0);
            r34 = r34 | 1;
            goto L34
        L36:
            r4 = 8;
            r33 = 15;
            r14 = 9;
            r314 = false;
            goto L6
        L11:
            r113 = (n84.a) r0.decodeSerializableElement(r1, r33, n84.a.C0156a.a, r113);
            r34 = r34 | 32768;
            goto L6
        L37:
            r210 = r35;
            r22 = r36;
            r110 = r211;
            r18 = r39;
            r111 = r34;
            r25 = r114;
            r21 = r212;
            r23 = r213;
            r24 = r214;
            r26 = r310;
            r27 = r311;
            r28 = r312;
            r29 = r313;
            r112 = r38;
            r30 = r37;
            r32 = r113;
            r31 = r115;
            goto L38
        }

        public final void serialize(muc.f r6, Object r7) {
            d r8 = (d) r7;
            Intrinsics.checkNotNullParameter(r6, "encoder");
            Intrinsics.checkNotNullParameter(r8, "value");
            g2 r0 = b;
            muc.d r9 = r6.beginStructure(r0);
            n[] r1 = d.q;
            r9.encodeLongElement(r0, 0, r8.a);
            r9.encodeBooleanElement(r0, 1, r8.b);
            c.a r2 = c.a.a;
            r9.encodeSerializableElement(r0, 2, r2, r8.c);
            r9.encodeSerializableElement(r0, 3, r2, r8.d);
            r9.encodeStringElement(r0, 4, r8.e);
            r9.encodeSerializableElement(r0, 5, r1[5], r8.f);
            r9.encodeFloatElement(r0, 6, r8.g);
            r9.encodeFloatElement(r0, 7, r8.h);
            r9.encodeSerializableElement(r0, 8, r1[8], r8.i);
            r9.encodeFloatElement(r0, 9, r8.j);
            r9.encodeFloatElement(r0, 10, r8.k);
            r9.encodeFloatElement(r0, 11, r8.l);
            r9.encodeFloatElement(r0, 12, r8.m);
            r9.encodeSerializableElement(r0, 13, r1[13], r8.n);
            r9.encodeSerializableElement(r0, 14, r1[14], r8.o);
            r9.encodeSerializableElement(r0, 15, n84.a.C0156a.a, r8.p);
            r9.endStructure(r0);
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<d> serializer() {
            return a.a;
        }
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof d) == true) goto L8;
        return false;
    L8:
        d r9 = (d) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
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
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Float.compare(this.g, r9.g) == 0) goto L30;
        return false;
    L30:
        if (Float.compare(this.h, r9.h) == 0) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L36;
        return false;
    L36:
        if (Float.compare(this.j, r9.j) == 0) goto L39;
        return false;
    L39:
        if (Float.compare(this.k, r9.k) == 0) goto L42;
        return false;
    L42:
        if (Float.compare(this.l, r9.l) == 0) goto L45;
        return false;
    L45:
        if (Float.compare(this.m, r9.m) == 0) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r9.n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.o, r9.o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.p, r9.p) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        if (this.b == false) goto L5;
        int r2 = 1231;
    L7:
        return ((((((((((((((((((((((((((((r1 + r2) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + Float.floatToIntBits(this.g)) * 31) + Float.floatToIntBits(this.h)) * 31) + this.i.hashCode()) * 31) + Float.floatToIntBits(this.j)) * 31) + Float.floatToIntBits(this.k)) * 31) + Float.floatToIntBits(this.l)) * 31) + Float.floatToIntBits(this.m)) * 31) + this.n.hashCode()) * 31) + this.o.hashCode()) * 31) + this.p.hashCode();
    L5:
        r2 = 1237;
        goto L7
    }

    public final String toString() {
        return "NavigationAgentSnapshot(updatedAt=" + this.a + ", isSuspectedYaw=" + this.b + ", origin=" + this.c + ", destination=" + this.d + ", planType=" + this.e + ", waypoints=" + this.f + ", routeDistance=" + this.g + ", routeDuration=" + this.h + ", routeRoadNames=" + this.i + ", passedDistance=" + this.j + ", passedDuration=" + this.k + ", remainingDistance=" + this.l + ", remainingDuration=" + this.m + ", passedWaypoints=" + this.n + ", remainingWaypoints=" + this.o + ", nextAction=" + this.p + ")";
    }

    static {
        Companion = new b();
        c.a r3 = c.a.a;
        q = new juc.d[]{null, null, null, null, null, new nuc.f(r3), null, null, new nuc.f(v2.a), null, null, null, null, new nuc.f(r3), new nuc.f(r3), null};
    }

    public d(long r12, boolean r14, c r15, c r16, String r17, List<c> r18, float r19, float r20, List<String> r21, float r22, float r23, float r24, float r25, List<c> r26, List<c> r27, n84.a r28) {
        Intrinsics.checkNotNullParameter(r15, "origin");
        Intrinsics.checkNotNullParameter(r16, "destination");
        Intrinsics.checkNotNullParameter(r17, "planType");
        Intrinsics.checkNotNullParameter(r18, "waypoints");
        Intrinsics.checkNotNullParameter(r21, "routeRoadNames");
        Intrinsics.checkNotNullParameter(r26, "passedWaypoints");
        Intrinsics.checkNotNullParameter(r27, "remainingWaypoints");
        Intrinsics.checkNotNullParameter(r28, "nextAction");
        this.a = r12;
        this.b = r14;
        this.c = r15;
        this.d = r16;
        this.e = r17;
        this.f = r18;
        this.g = r19;
        this.h = r20;
        this.i = r21;
        this.j = r22;
        this.k = r23;
        this.l = r24;
        this.m = r25;
        this.n = r26;
        this.o = r27;
        this.p = r28;
    }

    public d(int r5, long r6, boolean r8, c r9, c r10, String r11, List r12, float r13, float r14, List r15, float r16, float r17, float r18, float r19, List r20, List r21, n84.a r22) {
        if (65535 != (r5 & 65535)) goto L6;
        this.a = r6;
        this.b = r8;
        this.c = r9;
        this.d = r10;
        this.e = r11;
        this.f = r12;
        this.g = r13;
        this.h = r14;
        this.i = r15;
        this.j = r16;
        this.k = r17;
        this.l = r18;
        this.m = r19;
        this.n = r20;
        this.o = r21;
        this.p = r22;
        return;
    L6:
        b2.b(r5, 65535, a.b);
        throw null;
    }
}
