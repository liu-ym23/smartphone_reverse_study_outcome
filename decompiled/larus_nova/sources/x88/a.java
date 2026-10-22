package x88;

import juc.d;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.c;
import muc.e;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.l0;
import nuc.m0;
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes23.dex */
@Serializable
public final class a {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f562916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f562917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f562918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f562919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f562920e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f562921f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f562922g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f562923h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f562924i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f562925j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final float f562926k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f562927l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final float f562928m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f562929n;

    /* JADX INFO: renamed from: x88.a$a, reason: collision with other inner class name */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class C8204a implements m0<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C8204a f562930a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f562931b = null;

        public C8204a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f562931b;
        }

        static {
            C8204a r100 = new C8204a();
            f562930a = r100;
            g2 r101 = new g2("com.larus.avlink.api.model.SessionWakeupParam", r100, 14);
            r101.j("query", true);
            r101.j("kw", true);
            r101.j("sn", true);
            r101.j("version", true);
            r101.j("cred", true);
            r101.j("trace", true);
            r101.j("conf", true);
            r101.j("threshold", true);
            r101.j("bg", true);
            r101.j("info_type", true);
            r101.j("info_endoffset", true);
            r101.j("engine_version", true);
            r101.j("fallback_threshold", true);
            r101.j(com.bytedance.android.ec.core.event.a.KEY_DID, true);
            f562931b = r101;
        }

        @Override // nuc.m0
        public final d<?>[] childSerializers() {
            w0 r100 = w0.f520792a;
            v2 r101 = v2.f520790a;
            l0 r102 = l0.f520731a;
            return new d[]{r100, kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), r100, r102, r102, r102, r100, r100, r102, kuc.a.d(r101), r102, kuc.a.d(r101)};
        }

        @Override // nuc.m0
        public final d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r310) {
            Intrinsics.checkNotNullParameter(r310, "decoder");
            g2 r100 = f562931b;
            c r101 = r310.beginStructure(r100);
            int r102 = 8;
            int r103 = 9;
            int r104 = 6;
            if (r101.decodeSequentially() == false) goto L5;
            int r105 = r101.decodeIntElement(r100, 0);
            v2 r110 = v2.f520790a;
            String r111 = (String) r101.decodeNullableSerializableElement(r100, 1, r110, null);
            String r112 = (String) r101.decodeNullableSerializableElement(r100, 2, r110, null);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 3, r110, null);
            int r113 = r101.decodeIntElement(r100, 4);
            float r107 = r101.decodeFloatElement(r100, 5);
            float r108 = r101.decodeFloatElement(r100, 6);
            float r114 = r101.decodeFloatElement(r100, 7);
            int r109 = r101.decodeIntElement(r100, 8);
            int r115 = r101.decodeIntElement(r100, 9);
            float r116 = r101.decodeFloatElement(r100, 10);
            String r117 = (String) r101.decodeNullableSerializableElement(r100, 11, r110, null);
            float r210 = r101.decodeFloatElement(r100, 12);
            String r211 = (String) r101.decodeNullableSerializableElement(r100, 13, r110, null);
            int r118 = r109;
            String r119 = r106;
            int r120 = r115;
            float r212 = r116;
            String r213 = r117;
            int r121 = r113;
            int r122 = r105;
            int r123 = 16383;
            String r124 = r112;
            float r125 = r114;
            String r126 = r111;
            float r127 = r108;
            float r128 = r107;
        L32:
            r101.endStructure(r100);
            return new a(r123, r122, r126, r124, r119, r121, r128, r127, r125, r118, r120, r212, r213, r210, r211);
        L5:
            float r129 = 0.0f;
            String r130 = null;
            String r131 = null;
            String r132 = null;
            String r133 = null;
            String r214 = null;
            int r134 = 0;
            int r135 = 0;
            float r215 = 0.0f;
            int r216 = 0;
            float r217 = 0.0f;
            int r218 = 0;
            float r219 = 0.0f;
            int r220 = 0;
            float r221 = 0.0f;
            boolean r222 = true;
        L6:
            if (r222 == false) goto L31;
            int r136 = r101.decodeElementIndex(r100);
            switch(r136) {
                case -1: goto L30;
                case 0: goto L28;
                case 1: goto L27;
                case 2: goto L25;
                case 3: goto L24;
                case 4: goto L22;
                case 5: goto L21;
                case 6: goto L19;
                case 7: goto L18;
                case 8: goto L17;
                case 9: goto L16;
                case 10: goto L15;
                case 11: goto L13;
                case 12: goto L12;
                case 13: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r136);
        L21:
            r217 = r101.decodeFloatElement(r100, 5);
            r135 = r135 | 32;
        L29:
            r104 = 6;
            r102 = 8;
            r103 = 9;
            goto L6
        L22:
            r220 = r101.decodeIntElement(r100, 4);
            r135 = r135 | 16;
            goto L29
        L24:
            r132 = (String) r101.decodeNullableSerializableElement(r100, 3, v2.f520790a, r132);
            int r137 = r135 | 8;
        L26:
            r135 = r137;
            goto L29
        L25:
            r133 = (String) r101.decodeNullableSerializableElement(r100, 2, v2.f520790a, r133);
            r137 = r135 | 4;
            goto L26
        L27:
            r214 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r214);
            r135 = r135 | 2;
            goto L29
        L28:
            r134 = r101.decodeIntElement(r100, 0);
            r135 = r135 | 1;
            goto L29
        L30:
            r104 = 6;
            r102 = 8;
            r103 = 9;
            r222 = false;
            goto L6
        L11:
            r131 = (String) r101.decodeNullableSerializableElement(r100, 13, v2.f520790a, r131);
            int r138 = r135 | 8192;
        L14:
            r135 = r138;
            goto L6
        L12:
            r129 = r101.decodeFloatElement(r100, 12);
            r135 = r135 | 4096;
            goto L6
        L13:
            r130 = (String) r101.decodeNullableSerializableElement(r100, 11, v2.f520790a, r130);
            r138 = r135 | 2048;
            goto L14
        L15:
            r219 = r101.decodeFloatElement(r100, 10);
            r138 = r135 | 1024;
            goto L14
        L16:
            r218 = r101.decodeIntElement(r100, r103);
            r138 = r135 | 512;
            goto L14
        L17:
            r216 = r101.decodeIntElement(r100, r102);
            r138 = r135 | 256;
            goto L14
        L18:
            r221 = r101.decodeFloatElement(r100, 7);
            r138 = r135 | 128;
            goto L14
        L19:
            r215 = r101.decodeFloatElement(r100, r104);
            r135 = r135 | 64;
            goto L6
        L31:
            String r139 = r214;
            r213 = r130;
            r122 = r134;
            r119 = r132;
            r123 = r135;
            r124 = r133;
            r127 = r215;
            r118 = r216;
            r128 = r217;
            r120 = r218;
            r212 = r219;
            r121 = r220;
            r126 = r139;
            r211 = r131;
            r210 = r129;
            r125 = r221;
            goto L32
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r110) {
            a r111 = (a) r110;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r111, "value");
            g2 r101 = f562931b;
            muc.d r102 = r100.beginStructure(r101);
            b r103 = a.Companion;
            boolean r104 = false;
            if (r102.shouldEncodeElementDefault(r101, 0) == false) goto L6;
        L7:
            boolean r105 = true;
        L9:
            if (r105 == false) goto L12;
            r102.encodeIntElement(r101, 0, r111.f562916a);
        L12:
            if (r102.shouldEncodeElementDefault(r101, 1) == false) goto L15;
        L16:
            boolean r106 = true;
        L18:
            if (r106 == false) goto L21;
            r102.encodeNullableSerializableElement(r101, 1, v2.f520790a, r111.f562917b);
        L21:
            if (r102.shouldEncodeElementDefault(r101, 2) == false) goto L24;
        L25:
            boolean r107 = true;
        L27:
            if (r107 == false) goto L30;
            r102.encodeNullableSerializableElement(r101, 2, v2.f520790a, r111.f562918c);
        L30:
            if (r102.shouldEncodeElementDefault(r101, 3) == false) goto L33;
        L34:
            boolean r108 = true;
        L36:
            if (r108 == false) goto L39;
            r102.encodeNullableSerializableElement(r101, 3, v2.f520790a, r111.f562919d);
        L39:
            if (r102.shouldEncodeElementDefault(r101, 4) == false) goto L42;
        L43:
            boolean r109 = true;
        L45:
            if (r109 == false) goto L48;
            r102.encodeIntElement(r101, 4, r111.f562920e);
        L48:
            if (r102.shouldEncodeElementDefault(r101, 5) == false) goto L51;
        L52:
            boolean r112 = true;
        L54:
            if (r112 == false) goto L57;
            r102.encodeFloatElement(r101, 5, r111.f562921f);
        L57:
            if (r102.shouldEncodeElementDefault(r101, 6) == false) goto L60;
        L61:
            boolean r113 = true;
        L63:
            if (r113 == false) goto L66;
            r102.encodeFloatElement(r101, 6, r111.f562922g);
        L66:
            if (r102.shouldEncodeElementDefault(r101, 7) == false) goto L69;
        L70:
            boolean r114 = true;
        L72:
            if (r114 == false) goto L75;
            r102.encodeFloatElement(r101, 7, r111.f562923h);
        L75:
            if (r102.shouldEncodeElementDefault(r101, 8) == false) goto L78;
        L79:
            boolean r115 = true;
        L81:
            if (r115 == false) goto L84;
            r102.encodeIntElement(r101, 8, r111.f562924i);
        L84:
            if (r102.shouldEncodeElementDefault(r101, 9) == false) goto L87;
        L88:
            boolean r116 = true;
        L90:
            if (r116 == false) goto L93;
            r102.encodeIntElement(r101, 9, r111.f562925j);
        L93:
            if (r102.shouldEncodeElementDefault(r101, 10) == false) goto L96;
        L97:
            boolean r117 = true;
        L99:
            if (r117 == false) goto L102;
            r102.encodeFloatElement(r101, 10, r111.f562926k);
        L102:
            if (r102.shouldEncodeElementDefault(r101, 11) == false) goto L105;
        L106:
            boolean r118 = true;
        L108:
            if (r118 == false) goto L111;
            r102.encodeNullableSerializableElement(r101, 11, v2.f520790a, r111.f562927l);
        L111:
            if (r102.shouldEncodeElementDefault(r101, 12) == false) goto L114;
        L115:
            boolean r119 = true;
        L117:
            if (r119 == false) goto L120;
            r102.encodeFloatElement(r101, 12, r111.f562928m);
        L120:
            if (r102.shouldEncodeElementDefault(r101, 13) == false) goto L123;
        L124:
            r104 = true;
        L125:
            if (r104 == false) goto L127;
            r102.encodeNullableSerializableElement(r101, 13, v2.f520790a, r111.f562929n);
        L127:
            r102.endStructure(r101);
            return;
        L123:
            if (Intrinsics.areEqual(r111.f562929n, "") == true) goto L125;
        L114:
            if (Float.compare(r111.f562928m, 0.0f) != 0) goto L115;
            r119 = false;
            goto L117
        L105:
            if (Intrinsics.areEqual(r111.f562927l, "") == false) goto L106;
            r118 = false;
            goto L108
        L96:
            if (Float.compare(r111.f562926k, 0.0f) != 0) goto L97;
            r117 = false;
            goto L99
        L87:
            if (r111.f562925j != 0) goto L88;
            r116 = false;
            goto L90
        L78:
            if (r111.f562924i != 0) goto L79;
            r115 = false;
            goto L81
        L69:
            if (Float.compare(r111.f562923h, 0.0f) != 0) goto L70;
            r114 = false;
            goto L72
        L60:
            if (Float.compare(r111.f562922g, 0.0f) != 0) goto L61;
            r113 = false;
            goto L63
        L51:
            if (Float.compare(r111.f562921f, 0.0f) != 0) goto L52;
            r112 = false;
            goto L54
        L42:
            if (r111.f562920e != 0) goto L43;
            r109 = false;
            goto L45
        L33:
            if (Intrinsics.areEqual(r111.f562919d, "") == false) goto L34;
            r108 = false;
            goto L36
        L24:
            if (Intrinsics.areEqual(r111.f562918c, "") == false) goto L25;
            r107 = false;
            goto L27
        L15:
            if (Intrinsics.areEqual(r111.f562917b, "") == false) goto L16;
            r106 = false;
            goto L18
        L6:
            if (r111.f562916a != 0) goto L7;
            r105 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final d<a> serializer() {
            return C8204a.f562930a;
        }
    }

    public a() {
        this(0, "", "", "", 0, 0.0f, 0.0f, 0.0f, 0, 0, 0.0f, "", 0.0f, "");
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f562916a == r101.f562916a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f562917b, r101.f562917b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f562918c, r101.f562918c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f562919d, r101.f562919d) == true) goto L21;
        return false;
    L21:
        if (this.f562920e == r101.f562920e) goto L24;
        return false;
    L24:
        if (Float.compare(this.f562921f, r101.f562921f) == 0) goto L27;
        return false;
    L27:
        if (Float.compare(this.f562922g, r101.f562922g) == 0) goto L30;
        return false;
    L30:
        if (Float.compare(this.f562923h, r101.f562923h) == 0) goto L33;
        return false;
    L33:
        if (this.f562924i == r101.f562924i) goto L36;
        return false;
    L36:
        if (this.f562925j == r101.f562925j) goto L39;
        return false;
    L39:
        if (Float.compare(this.f562926k, r101.f562926k) == 0) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f562927l, r101.f562927l) == true) goto L45;
        return false;
    L45:
        if (Float.compare(this.f562928m, r101.f562928m) == 0) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f562929n, r101.f562929n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f562916a * 31;
        String r101 = this.f562917b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f562918c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f562919d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (((((((((((((((r107 + r109) * 31) + this.f562920e) * 31) + Float.floatToIntBits(this.f562921f)) * 31) + Float.floatToIntBits(this.f562922g)) * 31) + Float.floatToIntBits(this.f562923h)) * 31) + this.f562924i) * 31) + this.f562925j) * 31) + Float.floatToIntBits(this.f562926k)) * 31;
        String r111 = this.f562927l;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (((r110 + r112) * 31) + Float.floatToIntBits(this.f562928m)) * 31;
        String r114 = this.f562929n;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "SessionWakeupParam(query=" + this.f562916a + ", kw=" + this.f562917b + ", sn=" + this.f562918c + ", version=" + this.f562919d + ", cred=" + this.f562920e + ", trace=" + this.f562921f + ", conf=" + this.f562922g + ", threshold=" + this.f562923h + ", bg=" + this.f562924i + ", info_type=" + this.f562925j + ", info_endoffset=" + this.f562926k + ", engine_version=" + this.f562927l + ", fallback_threshold=" + this.f562928m + ", did=" + this.f562929n + ')';
    }

    static {
        Companion = new b();
    }

    public a(int r100, String r101, String r102, String r103, int r104, float r105, float r106, float r107, int r108, int r110, float r111, String r112, float r113, String r114) {
        this.f562916a = r100;
        this.f562917b = r101;
        this.f562918c = r102;
        this.f562919d = r103;
        this.f562920e = r104;
        this.f562921f = r105;
        this.f562922g = r106;
        this.f562923h = r107;
        this.f562924i = r108;
        this.f562925j = r110;
        this.f562926k = r111;
        this.f562927l = r112;
        this.f562928m = r113;
        this.f562929n = r114;
    }

    public a(int r100, int r101, String r102, String r110, String r111, int r112, float r113, float r114, float r115, int r116, int r117, float r118, String r119, float r210, String r211) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, C8204a.f562931b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f562916a = 0;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f562917b = "";
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f562918c = "";
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f562919d = "";
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.f562920e = 0;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.f562921f = 0.0f;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.f562922g = 0.0f;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.f562923h = 0.0f;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.f562924i = 0;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.f562925j = 0;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.f562926k = 0.0f;
    L49:
        if ((r100 & 2048) != 0) goto L51;
        this.f562927l = "";
    L53:
        if ((r100 & 4096) != 0) goto L55;
        this.f562928m = 0.0f;
    L57:
        if ((r100 & 8192) != 0) goto L59;
        this.f562929n = "";
        return;
    L59:
        this.f562929n = r211;
        return;
    L55:
        this.f562928m = r210;
        goto L57
    L51:
        this.f562927l = r119;
        goto L53
    L47:
        this.f562926k = r118;
        goto L49
    L43:
        this.f562925j = r117;
        goto L45
    L39:
        this.f562924i = r116;
        goto L41
    L35:
        this.f562923h = r115;
        goto L37
    L31:
        this.f562922g = r114;
        goto L33
    L27:
        this.f562921f = r113;
        goto L29
    L23:
        this.f562920e = r112;
        goto L25
    L19:
        this.f562919d = r111;
        goto L21
    L15:
        this.f562918c = r110;
        goto L17
    L11:
        this.f562917b = r102;
        goto L13
    L7:
        this.f562916a = r101;
        goto L9
    }
}
