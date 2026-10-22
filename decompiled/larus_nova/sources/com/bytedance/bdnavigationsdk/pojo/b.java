package com.bytedance.bdnavigationsdk.pojo;

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
import nuc.i;
import nuc.i2;
import nuc.l0;
import nuc.m0;
import nuc.w0;

/* JADX INFO: loaded from: classes10.dex */
@Serializable
public final class b {
    public static final C2886b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f200334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f200335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.bdnavigationsdk.pojo.a f200336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f200337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f200338e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f200339f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f200340g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f200341h;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f200342a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f200343b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f200343b;
        }

        static {
            a r100 = new a();
            f200342a = r100;
            g2 r101 = new g2("com.bytedance.bdnavigationsdk.pojo.Location", r100, 8);
            r101.j("idx", true);
            r101.j("usable", true);
            r101.j("latlng", true);
            r101.j("locationType", true);
            r101.j("trustedLevel", true);
            r101.j("timestamp", true);
            r101.j("speed", true);
            r101.j("bearing", true);
            f200343b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            w0 r100 = w0.f520792a;
            l0 r101 = l0.f520731a;
            return new juc.d[]{r100, i.f520705a, kuc.a.d(com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a), r100, r100, g1.f520681a, r101, r101};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f200343b;
            muc.c r101 = r210.beginStructure(r100);
            int r102 = 4;
            if (r101.decodeSequentially() == false) goto L6;
            int r103 = r101.decodeIntElement(r100, 0);
            boolean r104 = r101.decodeBooleanElement(r100, 1);
            com.bytedance.bdnavigationsdk.pojo.a r105 = (com.bytedance.bdnavigationsdk.pojo.a) r101.decodeNullableSerializableElement(r100, 2, com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a, null);
            int r106 = r101.decodeIntElement(r100, 3);
            int r107 = r101.decodeIntElement(r100, 4);
            long r108 = r101.decodeLongElement(r100, 5);
            float r109 = r101.decodeFloatElement(r100, 6);
            float r110 = r101.decodeFloatElement(r100, 7);
            float r111 = r109;
            long r112 = r108;
            com.bytedance.bdnavigationsdk.pojo.a r113 = r105;
            int r114 = r107;
            boolean r115 = r104;
            int r116 = r106;
            int r117 = 255;
        L5:
            int r118 = r103;
            r101.endStructure(r100);
            return new b(r117, r118, r115, r113, r116, r114, r112, r111, r110);
        L6:
            com.bytedance.bdnavigationsdk.pojo.a r119 = null;
            long r120 = 0;
            r103 = 0;
            r117 = 0;
            int r121 = 0;
            boolean r122 = false;
            int r123 = 0;
            r110 = 0.0f;
            float r124 = 0.0f;
            boolean r125 = true;
        L7:
            if (r125 == false) goto L25;
            int r126 = r101.decodeElementIndex(r100);
            switch(r126) {
                case -1: goto L23;
                case 0: goto L21;
                case 1: goto L20;
                case 2: goto L18;
                case 3: goto L16;
                case 4: goto L15;
                case 5: goto L14;
                case 6: goto L13;
                case 7: goto L12;
                default: goto L11;
            };
        L12:
            r110 = r101.decodeFloatElement(r100, 7);
            int r127 = r117 | 128;
        L17:
            r117 = r127;
        L24:
            r102 = 4;
            goto L7
        L13:
            r124 = r101.decodeFloatElement(r100, 6);
            r127 = r117 | 64;
            goto L17
        L14:
            r120 = r101.decodeLongElement(r100, 5);
            r127 = r117 | 32;
            goto L17
        L15:
            r121 = r101.decodeIntElement(r100, r102);
            r127 = r117 | 16;
            goto L17
        L16:
            r123 = r101.decodeIntElement(r100, 3);
            r127 = r117 | 8;
            goto L17
        L18:
            r119 = (com.bytedance.bdnavigationsdk.pojo.a) r101.decodeNullableSerializableElement(r100, 2, com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a, r119);
            r117 = r117 | 4;
            goto L24
        L20:
            r122 = r101.decodeBooleanElement(r100, 1);
            r117 = r117 | 2;
            goto L24
        L21:
            r117 = r117 | 1;
            r103 = r101.decodeIntElement(r100, 0);
            goto L24
        L23:
            r125 = false;
            goto L24
        L11:
            throw new UnknownFieldException(r126);
        L25:
            r113 = r119;
            r114 = r121;
            r115 = r122;
            r116 = r123;
            r111 = r124;
            r112 = r120;
            goto L5
        }

        @Override // juc.n
        public final void serialize(muc.f r110, Object r111) {
            b r112 = (b) r111;
            Intrinsics.checkNotNullParameter(r110, "encoder");
            Intrinsics.checkNotNullParameter(r112, "value");
            g2 r100 = f200343b;
            muc.d r113 = r110.beginStructure(r100);
            C2886b r101 = b.Companion;
            boolean r102 = false;
            if (r113.shouldEncodeElementDefault(r100, 0) == false) goto L6;
        L7:
            boolean r103 = true;
        L9:
            if (r103 == false) goto L12;
            r113.encodeIntElement(r100, 0, r112.f200334a);
        L12:
            if (r113.shouldEncodeElementDefault(r100, 1) == false) goto L15;
        L16:
            boolean r104 = true;
        L18:
            if (r104 == false) goto L21;
            r113.encodeBooleanElement(r100, 1, r112.f200335b);
        L21:
            if (r113.shouldEncodeElementDefault(r100, 2) == false) goto L24;
        L25:
            boolean r105 = true;
        L27:
            if (r105 == false) goto L30;
            r113.encodeNullableSerializableElement(r100, 2, com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a, r112.f200336c);
        L30:
            if (r113.shouldEncodeElementDefault(r100, 3) == false) goto L33;
        L34:
            boolean r106 = true;
        L36:
            if (r106 == false) goto L39;
            r113.encodeIntElement(r100, 3, r112.f200337d);
        L39:
            if (r113.shouldEncodeElementDefault(r100, 4) == false) goto L42;
        L43:
            boolean r107 = true;
        L45:
            if (r107 == false) goto L48;
            r113.encodeIntElement(r100, 4, r112.f200338e);
        L48:
            if (r113.shouldEncodeElementDefault(r100, 5) == false) goto L51;
        L52:
            boolean r108 = true;
        L54:
            if (r108 == false) goto L57;
            r113.encodeLongElement(r100, 5, r112.f200339f);
        L57:
            if (r113.shouldEncodeElementDefault(r100, 6) == false) goto L60;
        L61:
            boolean r109 = true;
        L63:
            if (r109 == false) goto L66;
            r113.encodeFloatElement(r100, 6, r112.f200340g);
        L66:
            if (r113.shouldEncodeElementDefault(r100, 7) == false) goto L69;
        L70:
            r102 = true;
        L71:
            if (r102 == false) goto L73;
            r113.encodeFloatElement(r100, 7, r112.f200341h);
        L73:
            r113.endStructure(r100);
            return;
        L69:
            if (Float.compare(r112.f200341h, 0.0f) == 0) goto L71;
        L60:
            if (Float.compare(r112.f200340g, 0.0f) != 0) goto L61;
            r109 = false;
            goto L63
        L51:
            if (r112.f200339f != 0) goto L52;
            r108 = false;
            goto L54
        L42:
            if (r112.f200338e != 0) goto L43;
            r107 = false;
            goto L45
        L33:
            if (r112.f200337d != 0) goto L34;
            r106 = false;
            goto L36
        L24:
            if (r112.f200336c != null) goto L25;
            r105 = false;
            goto L27
        L15:
            if (r112.f200335b == true) goto L16;
            r104 = false;
            goto L18
        L6:
            if (r112.f200334a != 0) goto L7;
            r103 = false;
            goto L9
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bdnavigationsdk.pojo.b$b, reason: collision with other inner class name */
    public static final class C2886b {
        public C2886b() {
        }

        public final juc.d<b> serializer() {
            return a.f200342a;
        }
    }

    public b() {
        this(0, false, null, 0, 0, 0, 0.0f, 0.0f);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f200334a == r101.f200334a) goto L12;
        return false;
    L12:
        if (this.f200335b == r101.f200335b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f200336c, r101.f200336c) == true) goto L18;
        return false;
    L18:
        if (this.f200337d == r101.f200337d) goto L21;
        return false;
    L21:
        if (this.f200338e == r101.f200338e) goto L24;
        return false;
    L24:
        if (this.f200339f == r101.f200339f) goto L27;
        return false;
    L27:
        if (Float.compare(this.f200340g, r101.f200340g) == 0) goto L30;
        return false;
    L30:
        if (Float.compare(this.f200341h, r101.f200341h) == 0) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f200334a * 31;
        if (this.f200335b == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        com.bytedance.bdnavigationsdk.pojo.a r103 = this.f200336c;
        if (r103 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (((((r102 + r104) * 31) + this.f200337d) * 31) + this.f200338e) * 31;
        long r106 = this.f200339f;
        return ((((r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31) + Float.floatToIntBits(this.f200340g)) * 31) + Float.floatToIntBits(this.f200341h);
    L9:
        r104 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    static {
        Companion = new C2886b();
    }

    public final String toString() {
        return "Location{idx=" + this.f200334a + ", usable=" + this.f200335b + ", latlng=" + this.f200336c + ", locationType=" + this.f200337d + ", trustedLevel=" + this.f200338e + ", timestamp=" + this.f200339f + ", speed=" + this.f200340g + ", bearing=" + this.f200341h + com.alipay.sdk.m.u.i.f25855d;
    }

    public b(int r100, boolean r101, com.bytedance.bdnavigationsdk.pojo.a r102, int r103, int r104, long r105, float r106, float r107) {
        this.f200334a = r100;
        this.f200335b = r101;
        this.f200336c = r102;
        this.f200337d = r103;
        this.f200338e = r104;
        this.f200339f = r105;
        this.f200340g = r106;
        this.f200341h = r107;
    }

    public b(int r100, int r101, boolean r102, com.bytedance.bdnavigationsdk.pojo.a r103, int r104, int r105, long r110, float r111, float r112) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f200343b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f200334a = 0;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f200335b = false;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f200336c = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f200337d = 0;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.f200338e = 0;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.f200339f = 0;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.f200340g = 0.0f;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.f200341h = 0.0f;
        return;
    L35:
        this.f200341h = r112;
        return;
    L31:
        this.f200340g = r111;
        goto L33
    L27:
        this.f200339f = r110;
        goto L29
    L23:
        this.f200338e = r105;
        goto L25
    L19:
        this.f200337d = r104;
        goto L21
    L15:
        this.f200336c = r103;
        goto L17
    L11:
        this.f200335b = r102;
        goto L13
    L7:
        this.f200334a = r101;
        goto L9
    }
}
