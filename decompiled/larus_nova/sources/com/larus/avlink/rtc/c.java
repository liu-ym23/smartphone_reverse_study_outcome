package com.larus.avlink.rtc;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;

/* JADX INFO: loaded from: classes4.dex */
@Serializable
public final class c {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.avlink.rtc.b f294462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.larus.avlink.rtc.b f294463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.avlink.rtc.b f294464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f294465d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f f294466e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f f294467f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f f294468g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f f294469h;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f294470a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f294471b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f294471b;
        }

        static {
            a r100 = new a();
            f294470a = r100;
            g2 r101 = new g2("com.larus.avlink.rtc.DoraRtcDowngradeResponse", r100, 8);
            r101.j("dora_lite_rtc_downgrade_config", true);
            r101.j("dora_g_rtc_downgrade_config", true);
            r101.j("dora_h_rtc_downgrade_config", true);
            r101.j("dora_g1_mmt_downgrade_config", true);
            r101.j("dora_g2_mmt_downgrade_config", true);
            r101.j("dora_lite_mmt_downgrade_config", true);
            r101.j("dora_h_mmt_downgrade_config", true);
            r101.j("dora_anker_mmt_downgrade_config", true);
            f294471b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            com.larus.avlink.rtc.b.a r100 = com.larus.avlink.rtc.b.a.f294460a;
            f.a r101 = f.a.f294475a;
            return new juc.d[]{kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101)};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f294471b;
            muc.c r101 = r210.beginStructure(r100);
            int r102 = 4;
            com.larus.avlink.rtc.b r110 = null;
            if (r101.decodeSequentially() == false) goto L5;
            com.larus.avlink.rtc.b.a r103 = com.larus.avlink.rtc.b.a.f294460a;
            com.larus.avlink.rtc.b r104 = (com.larus.avlink.rtc.b) r101.decodeNullableSerializableElement(r100, 0, r103, null);
            com.larus.avlink.rtc.b r105 = (com.larus.avlink.rtc.b) r101.decodeNullableSerializableElement(r100, 1, r103, null);
            com.larus.avlink.rtc.b r106 = (com.larus.avlink.rtc.b) r101.decodeNullableSerializableElement(r100, 2, r103, null);
            f.a r107 = f.a.f294475a;
            f r108 = (f) r101.decodeNullableSerializableElement(r100, 3, r107, null);
            f r109 = (f) r101.decodeNullableSerializableElement(r100, 4, r107, null);
            f r111 = (f) r101.decodeNullableSerializableElement(r100, 5, r107, null);
            f r112 = (f) r101.decodeNullableSerializableElement(r100, 6, r107, null);
            f r113 = (f) r101.decodeNullableSerializableElement(r100, 7, r107, null);
            int r114 = 255;
            f r115 = r109;
            f r116 = r113;
            f r117 = r112;
            f r118 = r111;
            com.larus.avlink.rtc.b r119 = r106;
            f r120 = r108;
        L24:
            r101.endStructure(r100);
            return new c(r114, r104, r105, r119, r120, r115, r118, r117, r116);
        L5:
            f r121 = null;
            f r122 = null;
            f r123 = null;
            f r124 = null;
            com.larus.avlink.rtc.b r125 = null;
            com.larus.avlink.rtc.b r126 = null;
            f r127 = null;
            int r128 = 0;
            boolean r129 = true;
        L6:
            if (r129 == false) goto L23;
            int r130 = r101.decodeElementIndex(r100);
            switch(r130) {
                case -1: goto L22;
                case 0: goto L20;
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r130);
        L22:
            r102 = 4;
            r129 = false;
            goto L6
        L11:
            r124 = (f) r101.decodeNullableSerializableElement(r100, 7, f.a.f294475a, r124);
            r128 = r128 | 128;
        L21:
            r102 = 4;
            goto L6
        L12:
            r122 = (f) r101.decodeNullableSerializableElement(r100, 6, f.a.f294475a, r122);
            r128 = r128 | 64;
            goto L21
        L13:
            r127 = (f) r101.decodeNullableSerializableElement(r100, 5, f.a.f294475a, r127);
            r128 = r128 | 32;
            goto L21
        L14:
            r123 = (f) r101.decodeNullableSerializableElement(r100, r102, f.a.f294475a, r123);
            r128 = r128 | 16;
            goto L21
        L15:
            r121 = (f) r101.decodeNullableSerializableElement(r100, 3, f.a.f294475a, r121);
            r128 = r128 | 8;
            goto L21
        L16:
            r126 = (com.larus.avlink.rtc.b) r101.decodeNullableSerializableElement(r100, 2, com.larus.avlink.rtc.b.a.f294460a, r126);
            r128 = r128 | 4;
            goto L21
        L18:
            r110 = (com.larus.avlink.rtc.b) r101.decodeNullableSerializableElement(r100, 1, com.larus.avlink.rtc.b.a.f294460a, r110);
            r128 = r128 | 2;
            goto L21
        L20:
            r128 = r128 | 1;
            r125 = (com.larus.avlink.rtc.b) r101.decodeNullableSerializableElement(r100, 0, com.larus.avlink.rtc.b.a.f294460a, r125);
            goto L21
        L23:
            r120 = r121;
            r119 = r126;
            r114 = r128;
            r116 = r124;
            r118 = r127;
            com.larus.avlink.rtc.b r131 = r125;
            r117 = r122;
            r104 = r131;
            com.larus.avlink.rtc.b r132 = r110;
            r115 = r123;
            r105 = r132;
            goto L24
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            c r102 = (c) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f294471b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = c.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, com.larus.avlink.rtc.b.a.f294460a, r102.f294462a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeNullableSerializableElement(r103, 1, com.larus.avlink.rtc.b.a.f294460a, r102.f294463b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            boolean r109 = true;
        L27:
            if (r109 == false) goto L30;
            r104.encodeNullableSerializableElement(r103, 2, com.larus.avlink.rtc.b.a.f294460a, r102.f294464c);
        L30:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
        L34:
            boolean r110 = true;
        L36:
            if (r110 == false) goto L39;
            r104.encodeNullableSerializableElement(r103, 3, f.a.f294475a, r102.f294465d);
        L39:
            if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L42;
        L43:
            boolean r111 = true;
        L45:
            if (r111 == false) goto L48;
            r104.encodeNullableSerializableElement(r103, 4, f.a.f294475a, r102.f294466e);
        L48:
            if (r104.shouldEncodeElementDefault(r103, 5) == false) goto L51;
        L52:
            boolean r112 = true;
        L54:
            if (r112 == false) goto L57;
            r104.encodeNullableSerializableElement(r103, 5, f.a.f294475a, r102.f294467f);
        L57:
            if (r104.shouldEncodeElementDefault(r103, 6) == false) goto L60;
        L61:
            boolean r113 = true;
        L63:
            if (r113 == false) goto L66;
            r104.encodeNullableSerializableElement(r103, 6, f.a.f294475a, r102.f294468g);
        L66:
            if (r104.shouldEncodeElementDefault(r103, 7) == false) goto L69;
        L70:
            r106 = true;
        L71:
            if (r106 == false) goto L73;
            r104.encodeNullableSerializableElement(r103, 7, f.a.f294475a, r102.f294469h);
        L73:
            r104.endStructure(r103);
            return;
        L69:
            if (r102.f294469h == null) goto L71;
        L60:
            if (r102.f294468g != null) goto L61;
            r113 = false;
            goto L63
        L51:
            if (r102.f294467f != null) goto L52;
            r112 = false;
            goto L54
        L42:
            if (r102.f294466e != null) goto L43;
            r111 = false;
            goto L45
        L33:
            if (r102.f294465d != null) goto L34;
            r110 = false;
            goto L36
        L24:
            if (r102.f294464c != null) goto L25;
            r109 = false;
            goto L27
        L15:
            if (r102.f294463b != null) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f294462a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<c> serializer() {
            return a.f294470a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f294462a, r101.f294462a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f294463b, r101.f294463b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f294464c, r101.f294464c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f294465d, r101.f294465d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f294466e, r101.f294466e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f294467f, r101.f294467f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f294468g, r101.f294468g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f294469h, r101.f294469h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        com.larus.avlink.rtc.b r100 = this.f294462a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        com.larus.avlink.rtc.b r104 = this.f294463b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        com.larus.avlink.rtc.b r107 = this.f294464c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        f r110 = this.f294465d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        f r113 = this.f294466e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        f r116 = this.f294467f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        f r119 = this.f294468g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        f r122 = this.f294469h;
        if (r122 == null) goto L35;
        r101 = r122.hashCode();
    L35:
        return r121 + r101;
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
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

    public final String toString() {
        return "DoraRtcDowngradeResponse(liteConfig=" + this.f294462a + ", gConfig=" + this.f294463b + ", hConfig=" + this.f294464c + ", g1MmtConfig=" + this.f294465d + ", g2MmtConfig=" + this.f294466e + ", liteMmtConfig=" + this.f294467f + ", hMmtConfig=" + this.f294468g + ", ankerMmtConfig=" + this.f294469h + ')';
    }

    static {
        Companion = new b();
    }

    public c() {
        this.f294462a = null;
        this.f294463b = null;
        this.f294464c = null;
        this.f294465d = null;
        this.f294466e = null;
        this.f294467f = null;
        this.f294468g = null;
        this.f294469h = null;
    }

    public c(int r100, com.larus.avlink.rtc.b r101, com.larus.avlink.rtc.b r102, com.larus.avlink.rtc.b r103, f r104, f r105, f r106, f r110, f r111) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f294471b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f294462a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f294463b = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f294464c = null;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f294465d = null;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.f294466e = null;
    L25:
        if ((r100 & 32) != 0) goto L27;
        this.f294467f = null;
    L29:
        if ((r100 & 64) != 0) goto L31;
        this.f294468g = null;
    L33:
        if ((r100 & 128) != 0) goto L35;
        this.f294469h = null;
        return;
    L35:
        this.f294469h = r111;
        return;
    L31:
        this.f294468g = r110;
        goto L33
    L27:
        this.f294467f = r106;
        goto L29
    L23:
        this.f294466e = r105;
        goto L25
    L19:
        this.f294465d = r104;
        goto L21
    L15:
        this.f294464c = r103;
        goto L17
    L11:
        this.f294463b = r102;
        goto L13
    L7:
        this.f294462a = r101;
        goto L9
    }
}
