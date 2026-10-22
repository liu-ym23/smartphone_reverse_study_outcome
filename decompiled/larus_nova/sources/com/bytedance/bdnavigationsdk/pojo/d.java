package com.bytedance.bdnavigationsdk.pojo;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
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
import nuc.w0;

/* JADX INFO: loaded from: classes10.dex */
@Serializable
public final class d {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.bdnavigationsdk.pojo.a f200353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.bdnavigationsdk.pojo.a f200354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f200355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f200356d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f200357e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f200358f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f200359g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f200360h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f200361i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f200362j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f200363k;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f200364a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f200365b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f200365b;
        }

        static {
            a r100 = new a();
            f200364a = r100;
            g2 r101 = new g2("com.bytedance.bdnavigationsdk.pojo.Segment", r100, 11);
            r101.j("source", true);
            r101.j(PickerReporterConstants.KEY.TARGET, true);
            r101.j("sourceIdx", true);
            r101.j("stepIdx", true);
            r101.j("_length", true);
            r101.j("duration", true);
            r101.j("_sDistToStart", true);
            r101.j("_sDistToEnd", true);
            r101.j("_bearing", true);
            r101.j("_turnFrom", true);
            r101.j("_turnTo", true);
            f200365b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            com.bytedance.bdnavigationsdk.pojo.a.C2885a r100 = com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a;
            w0 r101 = w0.f520792a;
            l0 r102 = l0.f520731a;
            return new juc.d[]{kuc.a.d(r100), kuc.a.d(r100), r101, r101, r102, r102, r102, r102, r102, r102, r102};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f200365b;
            muc.c r101 = r210.beginStructure(r100);
            int r102 = 2;
            int r103 = 4;
            int r104 = 8;
            int r110 = 0;
            if (r101.decodeSequentially() == false) goto L5;
            com.bytedance.bdnavigationsdk.pojo.a.C2885a r105 = com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a;
            com.bytedance.bdnavigationsdk.pojo.a r111 = (com.bytedance.bdnavigationsdk.pojo.a) r101.decodeNullableSerializableElement(r100, 0, r105, null);
            com.bytedance.bdnavigationsdk.pojo.a r106 = (com.bytedance.bdnavigationsdk.pojo.a) r101.decodeNullableSerializableElement(r100, 1, r105, null);
            int r107 = r101.decodeIntElement(r100, 2);
            int r108 = r101.decodeIntElement(r100, 3);
            float r109 = r101.decodeFloatElement(r100, 4);
            float r112 = r101.decodeFloatElement(r100, 5);
            float r113 = r101.decodeFloatElement(r100, 6);
            float r114 = r101.decodeFloatElement(r100, 7);
            float r115 = r101.decodeFloatElement(r100, 8);
            com.bytedance.bdnavigationsdk.pojo.a r116 = r106;
            int r117 = r107;
            float r118 = r109;
            float r211 = r115;
            float r119 = r114;
            float r212 = r101.decodeFloatElement(r100, 9);
            float r213 = r101.decodeFloatElement(r100, 10);
            int r120 = r108;
            float r121 = r113;
            float r122 = r112;
            int r123 = 2047;
            com.bytedance.bdnavigationsdk.pojo.a r124 = r111;
        L27:
            r101.endStructure(r100);
            return new d(r123, r124, r116, r117, r120, r118, r122, r121, r119, r211, r212, r213);
        L5:
            com.bytedance.bdnavigationsdk.pojo.a r214 = null;
            com.bytedance.bdnavigationsdk.pojo.a r215 = null;
            int r125 = 0;
            float r126 = 0.0f;
            float r127 = 0.0f;
            float r128 = 0.0f;
            float r129 = 0.0f;
            float r130 = 0.0f;
            int r131 = 0;
            float r216 = 0.0f;
            float r217 = 0.0f;
            boolean r218 = true;
        L6:
            if (r218 == false) goto L26;
            int r132 = r101.decodeElementIndex(r100);
            switch(r132) {
                case -1: goto L25;
                case 0: goto L23;
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
            throw new UnknownFieldException(r132);
        L25:
            r102 = 2;
            r103 = 4;
            r104 = 8;
            r218 = false;
            goto L6
        L11:
            r130 = r101.decodeFloatElement(r100, 10);
            int r133 = r110 | 1024;
        L20:
            com.bytedance.bdnavigationsdk.pojo.a r134 = r215;
        L22:
            r110 = r133;
        L24:
            r215 = r134;
            r102 = 2;
            r103 = 4;
            r104 = 8;
            goto L6
        L12:
            r129 = r101.decodeFloatElement(r100, 9);
            r133 = r110 | 512;
            goto L20
        L13:
            r127 = r101.decodeFloatElement(r100, r104);
            r133 = r110 | 256;
            goto L20
        L14:
            r128 = r101.decodeFloatElement(r100, 7);
            r133 = r110 | 128;
            goto L20
        L15:
            r216 = r101.decodeFloatElement(r100, 6);
            r133 = r110 | 64;
            goto L20
        L16:
            r217 = r101.decodeFloatElement(r100, 5);
            r133 = r110 | 32;
            goto L20
        L17:
            r126 = r101.decodeFloatElement(r100, r103);
            r133 = r110 | 16;
            goto L20
        L18:
            r131 = r101.decodeIntElement(r100, 3);
            r133 = r110 | 8;
            goto L20
        L19:
            r125 = r101.decodeIntElement(r100, r102);
            r133 = r110 | 4;
            goto L20
        L21:
            r134 = (com.bytedance.bdnavigationsdk.pojo.a) r101.decodeNullableSerializableElement(r100, 1, com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a, r215);
            r133 = r110 | 2;
            goto L22
        L23:
            r134 = r215;
            r214 = (com.bytedance.bdnavigationsdk.pojo.a) r101.decodeNullableSerializableElement(r100, 0, com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a, r214);
            r110 = r110 | 1;
            goto L24
        L26:
            r116 = r215;
            r124 = r214;
            r123 = r110;
            r213 = r130;
            r121 = r216;
            r211 = r127;
            r120 = r131;
            r119 = r128;
            r118 = r126;
            r117 = r125;
            float r219 = r217;
            r212 = r129;
            r122 = r219;
            goto L27
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            d r102 = (d) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f200365b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = d.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a, r102.f200353a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeNullableSerializableElement(r103, 1, com.bytedance.bdnavigationsdk.pojo.a.C2885a.f200332a, r102.f200354b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            boolean r109 = true;
        L27:
            if (r109 == false) goto L30;
            r104.encodeIntElement(r103, 2, r102.f200355c);
        L30:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
        L34:
            boolean r110 = true;
        L36:
            if (r110 == false) goto L39;
            r104.encodeIntElement(r103, 3, r102.f200356d);
        L39:
            if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L42;
        L43:
            boolean r111 = true;
        L45:
            if (r111 == false) goto L48;
            r104.encodeFloatElement(r103, 4, r102.f200357e);
        L48:
            if (r104.shouldEncodeElementDefault(r103, 5) == false) goto L51;
        L52:
            boolean r112 = true;
        L54:
            if (r112 == false) goto L57;
            r104.encodeFloatElement(r103, 5, r102.f200358f);
        L57:
            if (r104.shouldEncodeElementDefault(r103, 6) == false) goto L60;
        L61:
            boolean r113 = true;
        L63:
            if (r113 == false) goto L66;
            r104.encodeFloatElement(r103, 6, r102.f200359g);
        L66:
            if (r104.shouldEncodeElementDefault(r103, 7) == false) goto L69;
        L70:
            boolean r114 = true;
        L72:
            if (r114 == false) goto L75;
            r104.encodeFloatElement(r103, 7, r102.f200360h);
        L75:
            if (r104.shouldEncodeElementDefault(r103, 8) == false) goto L78;
        L79:
            boolean r115 = true;
        L81:
            if (r115 == false) goto L84;
            r104.encodeFloatElement(r103, 8, r102.f200361i);
        L84:
            if (r104.shouldEncodeElementDefault(r103, 9) == false) goto L87;
        L88:
            boolean r116 = true;
        L90:
            if (r116 == false) goto L93;
            r104.encodeFloatElement(r103, 9, r102.f200362j);
        L93:
            if (r104.shouldEncodeElementDefault(r103, 10) == false) goto L96;
        L97:
            r106 = true;
        L98:
            if (r106 == false) goto L100;
            r104.encodeFloatElement(r103, 10, r102.f200363k);
        L100:
            r104.endStructure(r103);
            return;
        L96:
            if (Float.compare(r102.f200363k, 0.0f) == 0) goto L98;
        L87:
            if (Float.compare(r102.f200362j, 0.0f) != 0) goto L88;
            r116 = false;
            goto L90
        L78:
            if (Float.compare(r102.f200361i, 0.0f) != 0) goto L79;
            r115 = false;
            goto L81
        L69:
            if (Float.compare(r102.f200360h, 0.0f) != 0) goto L70;
            r114 = false;
            goto L72
        L60:
            if (Float.compare(r102.f200359g, 0.0f) != 0) goto L61;
            r113 = false;
            goto L63
        L51:
            if (Float.compare(r102.f200358f, 0.0f) != 0) goto L52;
            r112 = false;
            goto L54
        L42:
            if (Float.compare(r102.f200357e, 0.0f) != 0) goto L43;
            r111 = false;
            goto L45
        L33:
            if (r102.f200356d != 0) goto L34;
            r110 = false;
            goto L36
        L24:
            if (r102.f200355c != 0) goto L25;
            r109 = false;
            goto L27
        L15:
            if (r102.f200354b != null) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f200353a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<d> serializer() {
            return a.f200364a;
        }
    }

    public d() {
        this(null, null, 0, 0, 2047);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f200353a, r101.f200353a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f200354b, r101.f200354b) == true) goto L15;
        return false;
    L15:
        if (this.f200355c == r101.f200355c) goto L18;
        return false;
    L18:
        if (this.f200356d == r101.f200356d) goto L21;
        return false;
    L21:
        if (Float.compare(this.f200357e, r101.f200357e) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(this.f200358f, r101.f200358f) == 0) goto L27;
        return false;
    L27:
        if (Float.compare(this.f200359g, r101.f200359g) == 0) goto L30;
        return false;
    L30:
        if (Float.compare(this.f200360h, r101.f200360h) == 0) goto L33;
        return false;
    L33:
        if (Float.compare(this.f200361i, r101.f200361i) == 0) goto L36;
        return false;
    L36:
        if (Float.compare(this.f200362j, r101.f200362j) == 0) goto L39;
        return false;
    L39:
        if (Float.compare(this.f200363k, r101.f200363k) == 0) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        com.bytedance.bdnavigationsdk.pojo.a r100 = this.f200353a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        com.bytedance.bdnavigationsdk.pojo.a r104 = this.f200354b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((((((((((((((((((r103 + r101) * 31) + this.f200355c) * 31) + this.f200356d) * 31) + Float.floatToIntBits(this.f200357e)) * 31) + Float.floatToIntBits(this.f200358f)) * 31) + Float.floatToIntBits(this.f200359g)) * 31) + Float.floatToIntBits(this.f200360h)) * 31) + Float.floatToIntBits(this.f200361i)) * 31) + Float.floatToIntBits(this.f200362j)) * 31) + Float.floatToIntBits(this.f200363k);
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "Segment(source=" + this.f200353a + ", target=" + this.f200354b + ", sourceIdx=" + this.f200355c + ", stepIdx=" + this.f200356d + ", _length=" + this.f200357e + ", duration=" + this.f200358f + ", _sDistToStart=" + this.f200359g + ", _sDistToEnd=" + this.f200360h + ", _bearing=" + this.f200361i + ", _turnFrom=" + this.f200362j + ", _turnTo=" + this.f200363k + ")";
    }

    static {
        Companion = new b();
    }

    public d(com.bytedance.bdnavigationsdk.pojo.a r100, com.bytedance.bdnavigationsdk.pojo.a r101, int r102, int r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0;
    L14:
        this.f200353a = r100;
        this.f200354b = r101;
        this.f200355c = r102;
        this.f200356d = r103;
        this.f200357e = 0.0f;
        this.f200358f = 0.0f;
        this.f200359g = 0.0f;
        this.f200360h = 0.0f;
        this.f200361i = 0.0f;
        this.f200362j = 0.0f;
        this.f200363k = 0.0f;
        if (r101 == null) goto L19;
        if (r100 == null) goto L20;
        int r105 = com.bytedance.bdnavigationsdk.utils.b.f200375a;
        int r106 = w84.b.f558623a;
        Intrinsics.checkNotNull(r100);
        Intrinsics.checkNotNull(r101);
        this.f200357e = com.bytedance.bdnavigationsdk.utils.b.b(com.bytedance.bdnavigationsdk.utils.b.b(w84.b.a(r100, r101), 2), 2);
        int r107 = w84.a.f558622a;
        Intrinsics.checkNotNull(r100);
        Intrinsics.checkNotNull(r101);
        this.f200361i = com.bytedance.bdnavigationsdk.utils.b.b(com.bytedance.bdnavigationsdk.utils.b.b(w84.a.a(r100, r101), 2), 2);
        return;
    L20:
        return;
    }

    public d(int r100, com.bytedance.bdnavigationsdk.pojo.a r101, com.bytedance.bdnavigationsdk.pojo.a r102, int r103, int r104, float r105, float r110, float r111, float r112, float r113, float r114, float r115) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f200365b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f200353a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f200354b = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f200355c = 0;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f200356d = 0;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.f200357e = 0.0f;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.f200358f = 0.0f;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.f200359g = 0.0f;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.f200360h = 0.0f;
    L37:
        if ((r100 & 256) != 0) goto L39;
        this.f200361i = 0.0f;
    L41:
        if ((r100 & 512) != 0) goto L43;
        this.f200362j = 0.0f;
    L45:
        if ((r100 & 1024) != 0) goto L47;
        this.f200363k = 0.0f;
    L49:
        if (this.f200354b == null) goto L56;
        com.bytedance.bdnavigationsdk.pojo.a r106 = this.f200353a;
        if (r106 == null) goto L57;
        int r107 = com.bytedance.bdnavigationsdk.utils.b.f200375a;
        int r108 = w84.b.f558623a;
        Intrinsics.checkNotNull(r106);
        com.bytedance.bdnavigationsdk.pojo.a r109 = this.f200354b;
        Intrinsics.checkNotNull(r109);
        this.f200357e = com.bytedance.bdnavigationsdk.utils.b.b(com.bytedance.bdnavigationsdk.utils.b.b(w84.b.a(r106, r109), 2), 2);
        int r116 = w84.a.f558622a;
        com.bytedance.bdnavigationsdk.pojo.a r117 = this.f200353a;
        Intrinsics.checkNotNull(r117);
        com.bytedance.bdnavigationsdk.pojo.a r118 = this.f200354b;
        Intrinsics.checkNotNull(r118);
        this.f200361i = com.bytedance.bdnavigationsdk.utils.b.b(com.bytedance.bdnavigationsdk.utils.b.b(w84.a.a(r117, r118), 2), 2);
        return;
    L57:
        return;
    L56:
        return;
    L47:
        this.f200363k = r115;
        goto L49
    L43:
        this.f200362j = r114;
        goto L45
    L39:
        this.f200361i = r113;
        goto L41
    L35:
        this.f200360h = r112;
        goto L37
    L31:
        this.f200359g = r111;
        goto L33
    L27:
        this.f200358f = r110;
        goto L29
    L23:
        this.f200357e = r105;
        goto L25
    L19:
        this.f200356d = r104;
        goto L21
    L15:
        this.f200355c = r103;
        goto L17
    L11:
        this.f200354b = r102;
        goto L13
    L7:
        this.f200353a = r101;
        goto L9
    }
}
