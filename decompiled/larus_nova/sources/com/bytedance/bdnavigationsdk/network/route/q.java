package com.bytedance.bdnavigationsdk.network.route;

import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.util.List;
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

/* JADX INFO: loaded from: classes10.dex */
@Serializable
public final class q {
    public static final b Companion = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final juc.d<Object>[] f200263h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f200264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f200265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f200266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f200267d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<t> f200268e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<r> f200269f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<com.bytedance.bdnavigationsdk.pojo.a> f200270g;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<q> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f200271a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f200272b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f200272b;
        }

        static {
            a r100 = new a();
            f200271a = r100;
            g2 r101 = new g2("com.bytedance.bdnavigationsdk.network.route.RouteStep", r100, 7);
            r101.j("orientation", true);
            r101.j("road_name", true);
            r101.j("step_distance", true);
            r101.j(ChameleonOpenTracker.ParamKey.COST, true);
            r101.j("visual_instructions", true);
            r101.j("verbal_instructions", true);
            r101.j(SVGRenderEngine.POLYLINE, true);
            f200272b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            juc.d<Object>[] r100 = q.f200263h;
            v2 r101 = v2.f520790a;
            return new juc.d[]{kuc.a.d(r101), kuc.a.d(r101), l0.f520731a, kuc.a.d(f.f200222a), kuc.a.d(r100[4]), kuc.a.d(r100[5]), kuc.a.d(com.bytedance.bdnavigationsdk.network.route.a.f200205a)};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f200272b;
            muc.c r101 = r210.beginStructure(r100);
            juc.d<Object>[] r102 = q.f200263h;
            int r103 = 4;
            int r104 = 3;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r105 = v2.f520790a;
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 0, r105, null);
            String r107 = (String) r101.decodeNullableSerializableElement(r100, 1, r105, null);
            float r108 = r101.decodeFloatElement(r100, 2);
            e r109 = (e) r101.decodeNullableSerializableElement(r100, 3, f.f200222a, null);
            List r110 = (List) r101.decodeNullableSerializableElement(r100, 4, r102[4], null);
            List r111 = (List) r101.decodeNullableSerializableElement(r100, 5, r102[5], null);
            String r112 = r107;
            List r113 = r110;
            e r114 = r109;
            List r115 = (List) r101.decodeNullableSerializableElement(r100, 6, com.bytedance.bdnavigationsdk.network.route.a.f200205a, null);
            float r116 = r108;
            String r117 = r106;
            int r118 = 127;
        L24:
            r101.endStructure(r100);
            return new q(r118, r117, r112, r116, r114, r113, r111, r115);
        L5:
            float r119 = 0.0f;
            e r120 = null;
            String r121 = null;
            List r122 = null;
            List r123 = null;
            List r124 = null;
            String r125 = null;
            r118 = 0;
            boolean r126 = true;
        L6:
            if (r126 == false) goto L23;
            int r127 = r101.decodeElementIndex(r100);
            switch(r127) {
                case -1: goto L22;
                case 0: goto L19;
                case 1: goto L18;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r127);
        L22:
            r103 = 4;
            r104 = 3;
            r126 = false;
            goto L6
        L11:
            r118 = r118 | 64;
            r124 = (List) r101.decodeNullableSerializableElement(r100, 6, com.bytedance.bdnavigationsdk.network.route.a.f200205a, r124);
        L21:
            r103 = 4;
            r104 = 3;
            goto L6
        L12:
            r118 = r118 | 32;
            r122 = (List) r101.decodeNullableSerializableElement(r100, 5, r102[5], r122);
            goto L21
        L13:
            r118 = r118 | 16;
            r123 = (List) r101.decodeNullableSerializableElement(r100, r103, r102[r103], r123);
            goto L21
        L14:
            r120 = (e) r101.decodeNullableSerializableElement(r100, r104, f.f200222a, r120);
            int r128 = r118 | 8;
        L16:
            r118 = r128;
            goto L21
        L15:
            r119 = r101.decodeFloatElement(r100, 2);
            r128 = r118 | 4;
            goto L16
        L18:
            r121 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r121);
            int r129 = r118 | 2;
        L20:
            r118 = r129;
            goto L21
        L19:
            r125 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r125);
            r129 = r118 | 1;
            goto L20
        L23:
            String r130 = r125;
            r111 = r122;
            r113 = r123;
            r115 = r124;
            r116 = r119;
            r114 = r120;
            r112 = r121;
            r117 = r130;
            goto L24
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            q r102 = (q) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f200272b;
            muc.d r104 = r100.beginStructure(r103);
            juc.d<Object>[] r105 = q.f200263h;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, v2.f520790a, r102.f200264a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeNullableSerializableElement(r103, 1, v2.f520790a, r102.f200265b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            boolean r109 = true;
        L27:
            if (r109 == false) goto L30;
            r104.encodeFloatElement(r103, 2, r102.f200266c);
        L30:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
        L34:
            boolean r110 = true;
        L36:
            if (r110 == false) goto L39;
            r104.encodeNullableSerializableElement(r103, 3, f.f200222a, r102.f200267d);
        L39:
            if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L42;
        L43:
            boolean r111 = true;
        L45:
            if (r111 == false) goto L48;
            r104.encodeNullableSerializableElement(r103, 4, r105[4], r102.f200268e);
        L48:
            if (r104.shouldEncodeElementDefault(r103, 5) == false) goto L51;
        L52:
            boolean r112 = true;
        L54:
            if (r112 == false) goto L57;
            r104.encodeNullableSerializableElement(r103, 5, r105[5], r102.f200269f);
        L57:
            if (r104.shouldEncodeElementDefault(r103, 6) == false) goto L60;
        L61:
            r106 = true;
        L62:
            if (r106 == false) goto L64;
            r104.encodeNullableSerializableElement(r103, 6, com.bytedance.bdnavigationsdk.network.route.a.f200205a, r102.f200270g);
        L64:
            r104.endStructure(r103);
            return;
        L60:
            if (r102.f200270g == null) goto L62;
        L51:
            if (r102.f200269f != null) goto L52;
            r112 = false;
            goto L54
        L42:
            if (r102.f200268e != null) goto L43;
            r111 = false;
            goto L45
        L33:
            if (r102.f200267d != null) goto L34;
            r110 = false;
            goto L36
        L24:
            if (Float.compare(r102.f200266c, 0.0f) != 0) goto L25;
            r109 = false;
            goto L27
        L15:
            if (r102.f200265b != null) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f200264a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<q> serializer() {
            return a.f200271a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f200264a, r101.f200264a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f200265b, r101.f200265b) == true) goto L15;
        return false;
    L15:
        if (Float.compare(this.f200266c, r101.f200266c) == 0) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f200267d, r101.f200267d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f200268e, r101.f200268e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f200269f, r101.f200269f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f200270g, r101.f200270g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f200264a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f200265b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + Float.floatToIntBits(this.f200266c)) * 31;
        e r107 = this.f200267d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<t> r110 = this.f200268e;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        List<r> r113 = this.f200269f;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        List<com.bytedance.bdnavigationsdk.pojo.a> r116 = this.f200270g;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    static {
        Companion = new b();
        f200263h = new juc.d[]{null, null, null, null, new nuc.f(t.a.f200288a), new nuc.f(r.a.f200276a), null};
    }

    public final String toString() {
        return "Step{orientation='" + this.f200264a + "', roadName='" + this.f200265b + "', stepDistance=" + this.f200266c + ", cost=" + this.f200267d + ", polyline=" + this.f200270g + com.alipay.sdk.m.u.i.f25855d;
    }

    public q() {
        this.f200264a = null;
        this.f200265b = null;
        this.f200266c = 0.0f;
        this.f200267d = null;
        this.f200268e = null;
        this.f200269f = null;
        this.f200270g = null;
    }

    public q(int r100, String r101, String r102, float r103, e r104, List r105, List r106, List r110) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f200272b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f200264a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f200265b = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f200266c = 0.0f;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f200267d = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.f200268e = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.f200269f = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.f200270g = null;
        return;
    L31:
        this.f200270g = r110;
        return;
    L27:
        this.f200269f = r106;
        goto L29
    L23:
        this.f200268e = r105;
        goto L25
    L19:
        this.f200267d = r104;
        goto L21
    L15:
        this.f200266c = r103;
        goto L17
    L11:
        this.f200265b = r102;
        goto L13
    L7:
        this.f200264a = r101;
        goto L9
    }
}
