package com.bytedance.bdnavigationsdk.pojo;

import com.alipay.sdk.m.u.i;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.l0;
import nuc.m0;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes10.dex */
@Serializable
public final class c {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f200344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f200345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f200346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.bdnavigationsdk.pojo.a f200347d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f200348e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f200349f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f200350g;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f200351a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f200352b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            w0 r100 = w0.f520792a;
            l0 r101 = l0.f520731a;
            return new juc.d[]{r100, kuc.a.d(v2.f520790a), r100, kuc.a.d(com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a), r101, r101, g1.f520681a};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f200352b;
        }

        static {
            a r100 = new a();
            f200351a = r100;
            g2 r101 = new g2("com.bytedance.bdnavigationsdk.pojo.LocationInfo", r100, 7);
            r101.j("location_type", true);
            r101.j("coordinate_system", true);
            r101.j("trusted_level", true);
            r101.j("latlng", true);
            r101.j("speed", true);
            r101.j("bearing", true);
            r101.j("timestamp", true);
            f200352b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f200352b;
            muc.c r101 = r110.beginStructure(r100);
            int r102 = 4;
            int r103 = 5;
            if (r101.decodeSequentially() == false) goto L5;
            int r104 = r101.decodeIntElement(r100, 0);
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, null);
            int r106 = r101.decodeIntElement(r100, 2);
            com.bytedance.bdnavigationsdk.pojo.a r107 = (com.bytedance.bdnavigationsdk.pojo.a) r101.decodeNullableSerializableElement(r100, 3, com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a, null);
            float r108 = r101.decodeFloatElement(r100, 4);
            float r111 = r108;
            float r112 = r101.decodeFloatElement(r100, 5);
            int r113 = r106;
            com.bytedance.bdnavigationsdk.pojo.a r114 = r107;
            long r115 = r101.decodeLongElement(r100, 6);
            int r109 = 127;
            int r116 = r104;
            String r117 = r105;
        L23:
            r101.endStructure(r100);
            return new c(r109, r116, r117, r113, r114, r111, r112, r115);
        L5:
            com.bytedance.bdnavigationsdk.pojo.a r118 = null;
            String r119 = null;
            long r120 = 0;
            int r121 = 0;
            float r122 = 0.0f;
            float r123 = 0.0f;
            int r124 = 0;
            int r125 = 0;
            boolean r126 = true;
        L6:
            if (r126 == false) goto L22;
            int r127 = r101.decodeElementIndex(r100);
            switch(r127) {
                case -1: goto L21;
                case 0: goto L19;
                case 1: goto L18;
                case 2: goto L17;
                case 3: goto L15;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r127);
        L21:
            r102 = 4;
            r126 = false;
            goto L6
        L11:
            r120 = r101.decodeLongElement(r100, 6);
            int r128 = r124 | 64;
        L14:
            r124 = r128;
        L20:
            r102 = 4;
            r103 = 5;
            goto L6
        L12:
            r123 = r101.decodeFloatElement(r100, r103);
            r128 = r124 | 32;
            goto L14
        L13:
            r122 = r101.decodeFloatElement(r100, r102);
            r128 = r124 | 16;
            goto L14
        L15:
            r124 = r124 | 8;
            r118 = (com.bytedance.bdnavigationsdk.pojo.a) r101.decodeNullableSerializableElement(r100, 3, com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a, r118);
            goto L20
        L17:
            r125 = r101.decodeIntElement(r100, 2);
            r124 = r124 | 4;
            goto L20
        L18:
            r119 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r119);
            r124 = r124 | 2;
            goto L20
        L19:
            r121 = r101.decodeIntElement(r100, 0);
            r124 = r124 | 1;
            goto L20
        L22:
            r116 = r121;
            r115 = r120;
            r112 = r123;
            r113 = r125;
            r111 = r122;
            r117 = r119;
            r109 = r124;
            r114 = r118;
            goto L23
        }

        @Override // juc.n
        public final void serialize(muc.f r110, Object r111) {
            c r112 = (c) r111;
            Intrinsics.checkNotNullParameter(r110, "encoder");
            Intrinsics.checkNotNullParameter(r112, "value");
            g2 r100 = f200352b;
            muc.d r113 = r110.beginStructure(r100);
            b r101 = c.Companion;
            boolean r102 = false;
            if (r113.shouldEncodeElementDefault(r100, 0) == false) goto L6;
        L7:
            boolean r103 = true;
        L9:
            if (r103 == false) goto L12;
            r113.encodeIntElement(r100, 0, r112.f200344a);
        L12:
            if (r113.shouldEncodeElementDefault(r100, 1) == false) goto L15;
        L16:
            boolean r104 = true;
        L18:
            if (r104 == false) goto L21;
            r113.encodeNullableSerializableElement(r100, 1, v2.f520790a, r112.f200345b);
        L21:
            if (r113.shouldEncodeElementDefault(r100, 2) == false) goto L24;
        L25:
            boolean r105 = true;
        L27:
            if (r105 == false) goto L30;
            r113.encodeIntElement(r100, 2, r112.f200346c);
        L30:
            if (r113.shouldEncodeElementDefault(r100, 3) == false) goto L33;
        L34:
            boolean r106 = true;
        L36:
            if (r106 == false) goto L39;
            r113.encodeNullableSerializableElement(r100, 3, com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a, r112.f200347d);
        L39:
            if (r113.shouldEncodeElementDefault(r100, 4) == false) goto L42;
        L43:
            boolean r107 = true;
        L45:
            if (r107 == false) goto L48;
            r113.encodeFloatElement(r100, 4, r112.f200348e);
        L48:
            if (r113.shouldEncodeElementDefault(r100, 5) == false) goto L51;
        L52:
            boolean r108 = true;
        L54:
            if (r108 == false) goto L57;
            r113.encodeFloatElement(r100, 5, r112.f200349f);
        L57:
            if (r113.shouldEncodeElementDefault(r100, 6) == false) goto L60;
        L61:
            r102 = true;
        L62:
            if (r102 == false) goto L64;
            r113.encodeLongElement(r100, 6, r112.f200350g);
        L64:
            r113.endStructure(r100);
            return;
        L60:
            if (r112.f200350g == 0) goto L62;
        L51:
            if (Float.compare(r112.f200349f, 0.0f) != 0) goto L52;
            r108 = false;
            goto L54
        L42:
            if (Float.compare(r112.f200348e, 0.0f) != 0) goto L43;
            r107 = false;
            goto L45
        L33:
            if (r112.f200347d != null) goto L34;
            r106 = false;
            goto L36
        L24:
            if (r112.f200346c != 0) goto L25;
            r105 = false;
            goto L27
        L15:
            if (r112.f200345b != null) goto L16;
            r104 = false;
            goto L18
        L6:
            if (r112.f200344a != 0) goto L7;
            r103 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<c> serializer() {
            return a.f200351a;
        }
    }

    public c() {
        this(0, null, 0, null, 0.0f, 0.0f, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f200344a == r101.f200344a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f200345b, r101.f200345b) == true) goto L15;
        return false;
    L15:
        if (this.f200346c == r101.f200346c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f200347d, r101.f200347d) == true) goto L21;
        return false;
    L21:
        if (Float.compare(this.f200348e, r101.f200348e) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(this.f200349f, r101.f200349f) == 0) goto L27;
        return false;
    L27:
        if (this.f200350g == r101.f200350g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f200344a * 31;
        String r101 = this.f200345b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f200346c) * 31;
        com.bytedance.bdnavigationsdk.pojo.a r105 = this.f200347d;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        int r106 = (((((r104 + r102) * 31) + Float.floatToIntBits(this.f200348e)) * 31) + Float.floatToIntBits(this.f200349f)) * 31;
        long r107 = this.f200350g;
        return r106 + ((int) (r107 ^ (r107 >>> 32)));
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    static {
        Companion = new b();
    }

    public final String toString() {
        return "LocationInfo{locationType=" + this.f200344a + ", coordinateSystem=" + this.f200345b + ", trustedLevel=" + this.f200346c + ", latLng=" + this.f200347d + ", speed=" + this.f200348e + ", bearing=" + this.f200349f + ", timestamp=" + this.f200350g + i.f25855d;
    }

    public static c a(c r100) {
        return new c(r100.f200344a, r100.f200345b, r100.f200346c, r100.f200347d, r100.f200348e, r100.f200349f, r100.f200350g);
    }

    public c(int r100, String r101, int r102, com.bytedance.bdnavigationsdk.pojo.a r103, float r104, float r105, long r106) {
        this.f200344a = r100;
        this.f200345b = r101;
        this.f200346c = r102;
        this.f200347d = r103;
        this.f200348e = r104;
        this.f200349f = r105;
        this.f200350g = r106;
    }

    public c(int r100, int r101, String r102, int r103, com.bytedance.bdnavigationsdk.pojo.a r104, float r105, float r110, long r111) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f200352b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f200344a = 0;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f200345b = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f200346c = 0;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f200347d = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.f200348e = 0.0f;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.f200349f = 0.0f;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.f200350g = 0;
        return;
    L31:
        this.f200350g = r111;
        return;
    L27:
        this.f200349f = r110;
        goto L29
    L23:
        this.f200348e = r105;
        goto L25
    L19:
        this.f200347d = r104;
        goto L21
    L15:
        this.f200346c = r103;
        goto L17
    L11:
        this.f200345b = r102;
        goto L13
    L7:
        this.f200344a = r101;
        goto L9
    }
}
