package n84;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.ss.ttvideoengine.model.BarrageMaskInfo;
import java.util.List;
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

/* JADX INFO: loaded from: classes10.dex */
@Serializable
public final class d {
    public static final b Companion = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final juc.d<Object>[] f518282q = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f518283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f518284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f518285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c f518286d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f518287e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<c> f518288f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f518289g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f518290h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<String> f518291i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f518292j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f518293k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f518294l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f518295m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final List<c> f518296n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List<c> f518297o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final n84.a f518298p;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f518299a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f518300b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f518300b;
        }

        static {
            a r100 = new a();
            f518299a = r100;
            g2 r101 = new g2("com.bytedance.bdnavigationsdk.agent.NavigationAgentSnapshot", r100, 16);
            r101.j(BarrageMaskInfo.KEY_MASK_UPDATED_AT, false);
            r101.j("is_suspected_yaw", false);
            r101.j(PlayerResolution.SDKKEY.ORIGIN, false);
            r101.j(com.bytedance.android.ec.core.event.a.KEY_DESTINATION, false);
            r101.j("plan_type", false);
            r101.j("waypoints", false);
            r101.j("route_distance", false);
            r101.j("route_duration", false);
            r101.j("route_road_names", false);
            r101.j("passed_distance", false);
            r101.j("passed_duration", false);
            r101.j("remaining_distance", false);
            r101.j("remaining_duration", false);
            r101.j("passed_waypoints", false);
            r101.j("remaining_waypoints", false);
            r101.j("next_action", false);
            f518300b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            juc.d<?>[] r100 = d.f518282q;
            c.a r101 = c.a.f518280a;
            l0 r102 = l0.f520731a;
            return new juc.d[]{g1.f520681a, i.f520705a, r101, r101, v2.f520790a, r100[5], r102, r102, r100[8], r102, r102, r102, r102, r100[13], r100[14], n84.a.C6904a.f518262a};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r410) {
            Intrinsics.checkNotNullParameter(r410, "decoder");
            g2 r100 = f518300b;
            muc.c r101 = r410.beginStructure(r100);
            juc.d<Object>[] r102 = d.f518282q;
            int r110 = 9;
            int r103 = 8;
            if (r101.decodeSequentially() == false) goto L5;
            long r210 = r101.decodeLongElement(r100, 0);
            boolean r104 = r101.decodeBooleanElement(r100, 1);
            c.a r105 = c.a.f518280a;
            c r106 = (c) r101.decodeSerializableElement(r100, 2, r105, null);
            c r107 = (c) r101.decodeSerializableElement(r100, 3, r105, null);
            String r108 = r101.decodeStringElement(r100, 4);
            List r109 = (List) r101.decodeSerializableElement(r100, 5, r102[5], null);
            float r111 = r101.decodeFloatElement(r100, 6);
            float r112 = r101.decodeFloatElement(r100, 7);
            List r113 = (List) r101.decodeSerializableElement(r100, 8, r102[8], null);
            float r114 = r101.decodeFloatElement(r100, 9);
            float r115 = r101.decodeFloatElement(r100, 10);
            float r116 = r101.decodeFloatElement(r100, 11);
            float r117 = r101.decodeFloatElement(r100, 12);
            boolean r118 = r104;
            List r119 = (List) r101.decodeSerializableElement(r100, 13, r102[13], null);
            List r310 = (List) r101.decodeSerializableElement(r100, 14, r102[14], null);
            List r311 = r119;
            List r211 = r113;
            c r120 = r106;
            n84.a r312 = (n84.a) r101.decodeSerializableElement(r100, 15, n84.a.C6904a.f518262a, null);
            float r212 = r111;
            float r213 = r112;
            float r214 = r114;
            float r215 = r115;
            float r216 = r116;
            float r217 = r117;
            List r218 = r109;
            int r121 = 65535;
            String r219 = r108;
            c r220 = r107;
            long r122 = r210;
        L38:
            r101.endStructure(r100);
            return new d(r121, r122, r118, r120, r220, r219, r218, r212, r213, r211, r214, r215, r216, r217, r311, r310, r312);
        L5:
            int r123 = 15;
            int r124 = 0;
            c r125 = null;
            List r126 = null;
            List r127 = null;
            n84.a r128 = null;
            List r129 = null;
            List r130 = null;
            c r221 = null;
            String r222 = null;
            long r313 = 0;
            boolean r131 = false;
            float r223 = 0.0f;
            float r224 = 0.0f;
            float r314 = 0.0f;
            float r315 = 0.0f;
            float r316 = 0.0f;
            float r317 = 0.0f;
            boolean r318 = true;
        L6:
            if (r318 == false) goto L37;
            int r132 = r101.decodeElementIndex(r100);
            switch(r132) {
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
            throw new UnknownFieldException(r132);
        L12:
            r130 = (List) r101.decodeSerializableElement(r100, 14, r102[14], r130);
            r124 = r124 | 16384;
        L35:
            r103 = 8;
            r123 = 15;
            r110 = 9;
            goto L6
        L13:
            r127 = (List) r101.decodeSerializableElement(r100, 13, r102[13], r127);
            r124 = r124 | 8192;
            goto L35
        L15:
            r317 = r101.decodeFloatElement(r100, 12);
            r124 = r124 | 4096;
            goto L35
        L16:
            r316 = r101.decodeFloatElement(r100, 11);
            r124 = r124 | 2048;
            goto L35
        L17:
            r315 = r101.decodeFloatElement(r100, 10);
            r124 = r124 | 1024;
            goto L35
        L18:
            r314 = r101.decodeFloatElement(r100, r110);
            r124 = r124 | 512;
            goto L35
        L20:
            r129 = (List) r101.decodeSerializableElement(r100, r103, r102[r103], r129);
            int r133 = r124 | 256;
        L25:
            int r134 = r133;
        L30:
            r124 = r134;
            goto L35
        L21:
            r224 = r101.decodeFloatElement(r100, 7);
            int r135 = r124 | 128;
        L28:
            r134 = r135;
            goto L30
        L22:
            r223 = r101.decodeFloatElement(r100, 6);
            r135 = r124 | 64;
            goto L28
        L24:
            r126 = (List) r101.decodeSerializableElement(r100, 5, r102[5], r126);
            r133 = r124 | 32;
            goto L25
        L27:
            r222 = r101.decodeStringElement(r100, 4);
            r135 = r124 | 16;
            goto L28
        L29:
            r125 = (c) r101.decodeSerializableElement(r100, 3, c.a.f518280a, r125);
            r134 = r124 | 8;
            goto L30
        L31:
            r221 = (c) r101.decodeSerializableElement(r100, 2, c.a.f518280a, r221);
            r124 = r124 | 4;
            goto L35
        L32:
            r131 = r101.decodeBooleanElement(r100, 1);
            r124 = r124 | 2;
        L34:
            r221 = r221;
            goto L35
        L33:
            r313 = r101.decodeLongElement(r100, 0);
            r124 = r124 | 1;
            goto L34
        L36:
            r103 = 8;
            r123 = 15;
            r110 = 9;
            r318 = false;
            goto L6
        L11:
            r128 = (n84.a) r101.decodeSerializableElement(r100, r123, n84.a.C6904a.f518262a, r128);
            r124 = r124 | 32768;
            goto L6
        L37:
            r220 = r125;
            r218 = r126;
            r120 = r221;
            r118 = r131;
            r121 = r124;
            r211 = r129;
            r219 = r222;
            r212 = r223;
            r213 = r224;
            r214 = r314;
            r215 = r315;
            r216 = r316;
            r217 = r317;
            r122 = r313;
            r311 = r127;
            r312 = r128;
            r310 = r130;
            goto L38
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            d r102 = (d) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f518300b;
            muc.d r104 = r100.beginStructure(r103);
            juc.d<Object>[] r105 = d.f518282q;
            r104.encodeLongElement(r103, 0, r102.f518283a);
            r104.encodeBooleanElement(r103, 1, r102.f518284b);
            c.a r106 = c.a.f518280a;
            r104.encodeSerializableElement(r103, 2, r106, r102.f518285c);
            r104.encodeSerializableElement(r103, 3, r106, r102.f518286d);
            r104.encodeStringElement(r103, 4, r102.f518287e);
            r104.encodeSerializableElement(r103, 5, r105[5], r102.f518288f);
            r104.encodeFloatElement(r103, 6, r102.f518289g);
            r104.encodeFloatElement(r103, 7, r102.f518290h);
            r104.encodeSerializableElement(r103, 8, r105[8], r102.f518291i);
            r104.encodeFloatElement(r103, 9, r102.f518292j);
            r104.encodeFloatElement(r103, 10, r102.f518293k);
            r104.encodeFloatElement(r103, 11, r102.f518294l);
            r104.encodeFloatElement(r103, 12, r102.f518295m);
            r104.encodeSerializableElement(r103, 13, r105[13], r102.f518296n);
            r104.encodeSerializableElement(r103, 14, r105[14], r102.f518297o);
            r104.encodeSerializableElement(r103, 15, n84.a.C6904a.f518262a, r102.f518298p);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<d> serializer() {
            return a.f518299a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f518283a == r101.f518283a) goto L12;
        return false;
    L12:
        if (this.f518284b == r101.f518284b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f518285c, r101.f518285c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f518286d, r101.f518286d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f518287e, r101.f518287e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f518288f, r101.f518288f) == true) goto L27;
        return false;
    L27:
        if (Float.compare(this.f518289g, r101.f518289g) == 0) goto L30;
        return false;
    L30:
        if (Float.compare(this.f518290h, r101.f518290h) == 0) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f518291i, r101.f518291i) == true) goto L36;
        return false;
    L36:
        if (Float.compare(this.f518292j, r101.f518292j) == 0) goto L39;
        return false;
    L39:
        if (Float.compare(this.f518293k, r101.f518293k) == 0) goto L42;
        return false;
    L42:
        if (Float.compare(this.f518294l, r101.f518294l) == 0) goto L45;
        return false;
    L45:
        if (Float.compare(this.f518295m, r101.f518295m) == 0) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f518296n, r101.f518296n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f518297o, r101.f518297o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f518298p, r101.f518298p) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public final int hashCode() {
        long r100 = this.f518283a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        if (this.f518284b == false) goto L5;
        int r102 = 1231;
    L7:
        return ((((((((((((((((((((((((((((r101 + r102) * 31) + this.f518285c.hashCode()) * 31) + this.f518286d.hashCode()) * 31) + this.f518287e.hashCode()) * 31) + this.f518288f.hashCode()) * 31) + Float.floatToIntBits(this.f518289g)) * 31) + Float.floatToIntBits(this.f518290h)) * 31) + this.f518291i.hashCode()) * 31) + Float.floatToIntBits(this.f518292j)) * 31) + Float.floatToIntBits(this.f518293k)) * 31) + Float.floatToIntBits(this.f518294l)) * 31) + Float.floatToIntBits(this.f518295m)) * 31) + this.f518296n.hashCode()) * 31) + this.f518297o.hashCode()) * 31) + this.f518298p.hashCode();
    L5:
        r102 = 1237;
        goto L7
    }

    public final String toString() {
        return "NavigationAgentSnapshot(updatedAt=" + this.f518283a + ", isSuspectedYaw=" + this.f518284b + ", origin=" + this.f518285c + ", destination=" + this.f518286d + ", planType=" + this.f518287e + ", waypoints=" + this.f518288f + ", routeDistance=" + this.f518289g + ", routeDuration=" + this.f518290h + ", routeRoadNames=" + this.f518291i + ", passedDistance=" + this.f518292j + ", passedDuration=" + this.f518293k + ", remainingDistance=" + this.f518294l + ", remainingDuration=" + this.f518295m + ", passedWaypoints=" + this.f518296n + ", remainingWaypoints=" + this.f518297o + ", nextAction=" + this.f518298p + ")";
    }

    static {
        Companion = new b();
        c.a r100 = c.a.f518280a;
        f518282q = new juc.d[]{null, null, null, null, null, new nuc.f(r100), null, null, new nuc.f(v2.f520790a), null, null, null, null, new nuc.f(r100), new nuc.f(r100), null};
    }

    public d(long r110, boolean r111, c r112, c r113, String r114, List<c> r115, float r116, float r210, List<String> r211, float r212, float r213, float r214, float r215, List<c> r216, List<c> r217, n84.a r218) {
        Intrinsics.checkNotNullParameter(r112, PlayerResolution.SDKKEY.ORIGIN);
        Intrinsics.checkNotNullParameter(r113, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
        Intrinsics.checkNotNullParameter(r114, "planType");
        Intrinsics.checkNotNullParameter(r115, "waypoints");
        Intrinsics.checkNotNullParameter(r211, "routeRoadNames");
        Intrinsics.checkNotNullParameter(r216, "passedWaypoints");
        Intrinsics.checkNotNullParameter(r217, "remainingWaypoints");
        Intrinsics.checkNotNullParameter(r218, "nextAction");
        this.f518283a = r110;
        this.f518284b = r111;
        this.f518285c = r112;
        this.f518286d = r113;
        this.f518287e = r114;
        this.f518288f = r115;
        this.f518289g = r116;
        this.f518290h = r210;
        this.f518291i = r211;
        this.f518292j = r212;
        this.f518293k = r213;
        this.f518294l = r214;
        this.f518295m = r215;
        this.f518296n = r216;
        this.f518297o = r217;
        this.f518298p = r218;
    }

    public d(int r100, long r101, boolean r102, c r103, c r110, String r111, List r112, float r113, float r114, List r115, float r116, float r117, float r118, float r119, List r210, List r211, n84.a r212) {
        if (65535 != (r100 & 65535)) goto L6;
        this.f518283a = r101;
        this.f518284b = r102;
        this.f518285c = r103;
        this.f518286d = r110;
        this.f518287e = r111;
        this.f518288f = r112;
        this.f518289g = r113;
        this.f518290h = r114;
        this.f518291i = r115;
        this.f518292j = r116;
        this.f518293k = r117;
        this.f518294l = r118;
        this.f518295m = r119;
        this.f518296n = r210;
        this.f518297o = r211;
        this.f518298p = r212;
        return;
    L6:
        b2.b(r100, 65535, a.f518300b);
        throw null;
    }
}
