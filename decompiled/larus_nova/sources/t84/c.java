package t84;

import com.alipay.sdk.m.u.i;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.l0;
import nuc.m0;

/* JADX INFO: loaded from: classes10.dex */
@Serializable
public final class c {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f545024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f545025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f545026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f545027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f545028e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f545029f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f545030g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f545031h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f545032i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f545033j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f545034k;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f545035a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f545036b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f545036b;
        }

        static {
            a r100 = new a();
            f545035a = r100;
            g2 r101 = new g2("com.bytedance.bdnavigationsdk.pojo.Threshold.Universal", r100, 11);
            r101.j("speed", true);
            r101.j("timestamp_diff", true);
            r101.j("dist_to_start", true);
            r101.j("dist_to_end", true);
            r101.j("suspected_projection_dist", true);
            r101.j("suspected_dist_at_start", true);
            r101.j("max_projection_dist", true);
            r101.j("user_location_dist", true);
            r101.j("cross_corner_max_dist", true);
            r101.j("cross_corner_min_dist", true);
            r101.j("cross_corner_interval_dist", true);
            f545036b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            l0 r100 = l0.f520731a;
            return new juc.d[]{r100, r100, r100, r100, r100, r100, r100, r100, r100, r100, r100};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f545036b;
            muc.c r101 = r210.beginStructure(r100);
            int r102 = 0;
            if (r101.decodeSequentially() == false) goto L5;
            float r103 = r101.decodeFloatElement(r100, 0);
            float r104 = r101.decodeFloatElement(r100, 1);
            float r105 = r101.decodeFloatElement(r100, 2);
            float r106 = r101.decodeFloatElement(r100, 3);
            float r107 = r101.decodeFloatElement(r100, 4);
            float r110 = r101.decodeFloatElement(r100, 5);
            float r111 = r101.decodeFloatElement(r100, 6);
            float r112 = r101.decodeFloatElement(r100, 7);
            float r108 = r101.decodeFloatElement(r100, 8);
            float r109 = r101.decodeFloatElement(r100, 9);
            float r113 = r107;
            float r114 = r108;
            float r115 = r106;
            float r211 = r101.decodeFloatElement(r100, 10);
            float r116 = r109;
            float r117 = r112;
            float r118 = r111;
            float r119 = r110;
            int r120 = 2047;
            float r121 = r103;
            float r122 = r105;
            float r123 = r104;
        L26:
            r101.endStructure(r100);
            return new c(r120, r121, r123, r122, r115, r113, r119, r118, r117, r114, r116, r211);
        L5:
            float r124 = 0.0f;
            float r125 = 0.0f;
            float r126 = 0.0f;
            float r127 = 0.0f;
            float r128 = 0.0f;
            float r129 = 0.0f;
            float r130 = 0.0f;
            float r212 = 0.0f;
            float r213 = 0.0f;
            float r214 = 0.0f;
            float r215 = 0.0f;
            boolean r216 = true;
        L6:
            if (r216 == false) goto L25;
            int r131 = r101.decodeElementIndex(r100);
            switch(r131) {
                case -1: goto L23;
                case 0: goto L22;
                case 1: goto L21;
                case 2: goto L19;
                case 3: goto L18;
                case 4: goto L17;
                case 5: goto L16;
                case 6: goto L15;
                case 7: goto L14;
                case 8: goto L13;
                case 9: goto L12;
                case 10: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r131);
        L21:
            r128 = r101.decodeFloatElement(r100, 1);
            r102 = r102 | 2;
            goto L6
        L22:
            r102 = r102 | 1;
            r124 = r101.decodeFloatElement(r100, 0);
            goto L6
        L11:
            r130 = r101.decodeFloatElement(r100, 10);
            r102 = r102 | 1024;
        L20:
            boolean r217 = r216;
        L24:
            r216 = r217;
            goto L6
        L12:
            r212 = r101.decodeFloatElement(r100, 9);
            r102 = r102 | 512;
            goto L20
        L13:
            r127 = r101.decodeFloatElement(r100, 8);
            r102 = r102 | 256;
            goto L20
        L14:
            r213 = r101.decodeFloatElement(r100, 7);
            r102 = r102 | 128;
            goto L20
        L15:
            r214 = r101.decodeFloatElement(r100, 6);
            r102 = r102 | 64;
            goto L20
        L16:
            r215 = r101.decodeFloatElement(r100, 5);
            r102 = r102 | 32;
            goto L20
        L17:
            r126 = r101.decodeFloatElement(r100, 4);
            r102 = r102 | 16;
            goto L20
        L18:
            r129 = r101.decodeFloatElement(r100, 3);
            r102 = r102 | 8;
            goto L20
        L19:
            r125 = r101.decodeFloatElement(r100, 2);
            r102 = r102 | 4;
            goto L20
        L23:
            r217 = false;
            goto L24
        L25:
            r121 = r124;
            r120 = r102;
            r122 = r125;
            r113 = r126;
            r123 = r128;
            r115 = r129;
            r117 = r213;
            r119 = r215;
            r114 = r127;
            r118 = r214;
            float r218 = r212;
            r211 = r130;
            r116 = r218;
            goto L26
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            c r102 = (c) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f545036b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = c.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeFloatElement(r103, 0, r102.f545024a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeFloatElement(r103, 1, r102.f545025b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            boolean r109 = true;
        L27:
            if (r109 == false) goto L30;
            r104.encodeFloatElement(r103, 2, r102.f545026c);
        L30:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
        L34:
            boolean r110 = true;
        L36:
            if (r110 == false) goto L39;
            r104.encodeFloatElement(r103, 3, r102.f545027d);
        L39:
            if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L42;
        L43:
            boolean r111 = true;
        L45:
            if (r111 == false) goto L48;
            r104.encodeFloatElement(r103, 4, r102.f545028e);
        L48:
            if (r104.shouldEncodeElementDefault(r103, 5) == false) goto L51;
        L52:
            boolean r112 = true;
        L54:
            if (r112 == false) goto L57;
            r104.encodeFloatElement(r103, 5, r102.f545029f);
        L57:
            if (r104.shouldEncodeElementDefault(r103, 6) == false) goto L60;
        L61:
            boolean r113 = true;
        L63:
            if (r113 == false) goto L66;
            r104.encodeFloatElement(r103, 6, r102.f545030g);
        L66:
            if (r104.shouldEncodeElementDefault(r103, 7) == false) goto L69;
        L70:
            boolean r114 = true;
        L72:
            if (r114 == false) goto L75;
            r104.encodeFloatElement(r103, 7, r102.f545031h);
        L75:
            if (r104.shouldEncodeElementDefault(r103, 8) == false) goto L78;
        L79:
            boolean r115 = true;
        L81:
            if (r115 == false) goto L84;
            r104.encodeFloatElement(r103, 8, r102.f545032i);
        L84:
            if (r104.shouldEncodeElementDefault(r103, 9) == false) goto L87;
        L88:
            boolean r116 = true;
        L90:
            if (r116 == false) goto L93;
            r104.encodeFloatElement(r103, 9, r102.f545033j);
        L93:
            if (r104.shouldEncodeElementDefault(r103, 10) == false) goto L96;
        L97:
            r106 = true;
        L98:
            if (r106 == false) goto L100;
            r104.encodeFloatElement(r103, 10, r102.f545034k);
        L100:
            r104.endStructure(r103);
            return;
        L96:
            if (Float.compare(r102.f545034k, 0.0f) == 0) goto L98;
        L87:
            if (Float.compare(r102.f545033j, 0.0f) != 0) goto L88;
            r116 = false;
            goto L90
        L78:
            if (Float.compare(r102.f545032i, 0.0f) != 0) goto L79;
            r115 = false;
            goto L81
        L69:
            if (Float.compare(r102.f545031h, 0.0f) != 0) goto L70;
            r114 = false;
            goto L72
        L60:
            if (Float.compare(r102.f545030g, 0.0f) != 0) goto L61;
            r113 = false;
            goto L63
        L51:
            if (Float.compare(r102.f545029f, 0.0f) != 0) goto L52;
            r112 = false;
            goto L54
        L42:
            if (Float.compare(r102.f545028e, 0.0f) != 0) goto L43;
            r111 = false;
            goto L45
        L33:
            if (Float.compare(r102.f545027d, 0.0f) != 0) goto L34;
            r110 = false;
            goto L36
        L24:
            if (Float.compare(r102.f545026c, 0.0f) != 0) goto L25;
            r109 = false;
            goto L27
        L15:
            if (Float.compare(r102.f545025b, 0.0f) != 0) goto L16;
            r108 = false;
            goto L18
        L6:
            if (Float.compare(r102.f545024a, 0.0f) != 0) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<c> serializer() {
            return a.f545035a;
        }
    }

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Float.compare(this.f545024a, r101.f545024a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f545025b, r101.f545025b) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.f545026c, r101.f545026c) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.f545027d, r101.f545027d) == 0) goto L21;
        return false;
    L21:
        if (Float.compare(this.f545028e, r101.f545028e) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(this.f545029f, r101.f545029f) == 0) goto L27;
        return false;
    L27:
        if (Float.compare(this.f545030g, r101.f545030g) == 0) goto L30;
        return false;
    L30:
        if (Float.compare(this.f545031h, r101.f545031h) == 0) goto L33;
        return false;
    L33:
        if (Float.compare(this.f545032i, r101.f545032i) == 0) goto L36;
        return false;
    L36:
        if (Float.compare(this.f545033j, r101.f545033j) == 0) goto L39;
        return false;
    L39:
        if (Float.compare(this.f545034k, r101.f545034k) == 0) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((((((((Float.floatToIntBits(this.f545024a) * 31) + Float.floatToIntBits(this.f545025b)) * 31) + Float.floatToIntBits(this.f545026c)) * 31) + Float.floatToIntBits(this.f545027d)) * 31) + Float.floatToIntBits(this.f545028e)) * 31) + Float.floatToIntBits(this.f545029f)) * 31) + Float.floatToIntBits(this.f545030g)) * 31) + Float.floatToIntBits(this.f545031h)) * 31) + Float.floatToIntBits(this.f545032i)) * 31) + Float.floatToIntBits(this.f545033j)) * 31) + Float.floatToIntBits(this.f545034k);
    }

    static {
        Companion = new b();
    }

    public final String toString() {
        return "Universal{speed=" + this.f545024a + ", timestampDiff=" + this.f545025b + ", distToStart=" + this.f545026c + ", distToEnd=" + this.f545027d + ", suspectedProjectionDist=" + this.f545028e + ", suspectedDistAtStart=" + this.f545029f + ", maxProjectionDist=" + this.f545030g + ", userLocationDist=" + this.f545031h + ", crossCornerMaxDist=" + this.f545032i + ", crossCornerMinDist=" + this.f545033j + ", crossCornerIntervalDist=" + this.f545034k + i.f25855d;
    }

    public /* synthetic */ c(int r110) {
        this(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    public c(float r100, float r101, float r102, float r103, float r104, float r105, float r106, float r107, float r108, float r110, float r111) {
        this.f545024a = r100;
        this.f545025b = r101;
        this.f545026c = r102;
        this.f545027d = r103;
        this.f545028e = r104;
        this.f545029f = r105;
        this.f545030g = r106;
        this.f545031h = r107;
        this.f545032i = r108;
        this.f545033j = r110;
        this.f545034k = r111;
    }

    public c(int r100, float r101, float r102, float r103, float r104, float r105, float r106, float r110, float r111, float r112, float r113, float r114) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f545036b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f545024a = 0.0f;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f545025b = 0.0f;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f545026c = 0.0f;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f545027d = 0.0f;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.f545028e = 0.0f;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.f545029f = 0.0f;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.f545030g = 0.0f;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.f545031h = 0.0f;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.f545032i = 0.0f;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.f545033j = 0.0f;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.f545034k = 0.0f;
        return;
    L47:
        this.f545034k = r114;
        return;
    L43:
        this.f545033j = r113;
        goto L45
    L39:
        this.f545032i = r112;
        goto L41
    L35:
        this.f545031h = r111;
        goto L37
    L31:
        this.f545030g = r110;
        goto L33
    L27:
        this.f545029f = r106;
        goto L29
    L23:
        this.f545028e = r105;
        goto L25
    L19:
        this.f545027d = r104;
        goto L21
    L15:
        this.f545026c = r103;
        goto L17
    L11:
        this.f545025b = r102;
        goto L13
    L7:
        this.f545024a = r101;
        goto L9
    }
}
