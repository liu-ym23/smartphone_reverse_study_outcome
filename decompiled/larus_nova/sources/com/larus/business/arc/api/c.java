package com.larus.business.arc.api;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: classes26.dex */
@Serializable
public final class c {
    public static final b Companion = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Lazy<juc.d<Object>>[] f319871l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArcPlatform f319872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f319873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f319874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f319875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f319876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f319877f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArcRegion f319878g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f319879h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f319880i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f319881j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArcCallLifecycle f319882k;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f319883a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f319884b = null;

        public a() {
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f319884b;
        }

        static {
            a r100 = new a();
            f319883a = r100;
            g2 r101 = new g2("com.larus.business.arc.api.ArcActionContext", r100, 10);
            r101.j("platform", true);
            r101.j("packageName", true);
            r101.j("processName", true);
            r101.j("uid", true);
            r101.j(com.bytedance.android.ec.core.event.a.KEY_DID, true);
            r101.j("channel", true);
            r101.j(EffectConfiguration.KEY_REGION, true);
            r101.j("updateVersionCode", true);
            r101.j("requestId", true);
            r101.j("traceId", true);
            f319884b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            Lazy<juc.d<Object>>[] r100 = c.f319871l;
            v2 r101 = v2.f520790a;
            return new juc.d[]{r100[0].getValue(), r101, r101, r101, r101, r101, r100[6].getValue(), r101, r101, r101};
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f319884b;
            muc.c r101 = r210.beginStructure(r100);
            Lazy<juc.d<Object>>[] r102 = c.f319871l;
            int r103 = 2;
            int r104 = 4;
            ArcPlatform r110 = null;
            if (r101.decodeSequentially() == false) goto L5;
            ArcPlatform r105 = (ArcPlatform) r101.decodeSerializableElement(r100, 0, r102[0].getValue(), null);
            String r106 = r101.decodeStringElement(r100, 1);
            String r107 = r101.decodeStringElement(r100, 2);
            String r111 = r101.decodeStringElement(r100, 3);
            String r108 = r101.decodeStringElement(r100, 4);
            String r112 = r101.decodeStringElement(r100, 5);
            ArcRegion r109 = (ArcRegion) r101.decodeSerializableElement(r100, 6, r102[6].getValue(), null);
            String r113 = r101.decodeStringElement(r100, 7);
            int r114 = 1023;
            ArcRegion r115 = r109;
            ArcPlatform r116 = r105;
            String r117 = r107;
            String r118 = r108;
            String r211 = r101.decodeStringElement(r100, 8);
            String r212 = r113;
            String r213 = r101.decodeStringElement(r100, 9);
            String r119 = r106;
            String r120 = r111;
            String r121 = r112;
        L24:
            r101.endStructure(r100);
            return new c(r114, r116, r119, r117, r120, r118, r121, r115, r212, r211, r213);
        L5:
            ArcRegion r122 = null;
            String r123 = null;
            String r124 = null;
            String r125 = null;
            String r126 = null;
            String r127 = null;
            String r214 = null;
            String r215 = null;
            String r216 = null;
            int r128 = 0;
            boolean r217 = true;
        L6:
            if (r217 == false) goto L23;
            int r129 = r101.decodeElementIndex(r100);
            switch(r129) {
                case -1: goto L22;
                case 0: goto L21;
                case 1: goto L20;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r129);
        L20:
            r127 = r101.decodeStringElement(r100, 1);
            r128 = r128 | 2;
            goto L6
        L21:
            r110 = (ArcPlatform) r101.decodeSerializableElement(r100, 0, r102[0].getValue(), r110);
            r128 = r128 | 1;
            r103 = 2;
            r104 = 4;
            goto L6
        L22:
            r103 = 2;
            r217 = false;
            goto L6
        L11:
            r128 = r128 | 512;
            r123 = r101.decodeStringElement(r100, 9);
            goto L6
        L12:
            r128 = r128 | 256;
            r214 = r101.decodeStringElement(r100, 8);
            goto L6
        L13:
            r128 = r128 | 128;
            r125 = r101.decodeStringElement(r100, 7);
            goto L6
        L14:
            r122 = (ArcRegion) r101.decodeSerializableElement(r100, 6, r102[6].getValue(), r122);
            r128 = r128 | 64;
            goto L6
        L15:
            r128 = r128 | 32;
            r216 = r101.decodeStringElement(r100, 5);
            goto L6
        L16:
            r128 = r128 | 16;
            r215 = r101.decodeStringElement(r100, r104);
            goto L6
        L17:
            r128 = r128 | 8;
            r126 = r101.decodeStringElement(r100, 3);
            goto L6
        L18:
            r128 = r128 | 4;
            r124 = r101.decodeStringElement(r100, r103);
            goto L6
        L23:
            r114 = r128;
            r116 = r110;
            r119 = r127;
            r115 = r122;
            String r218 = r216;
            r213 = r123;
            r117 = r124;
            r120 = r126;
            r121 = r218;
            String r219 = r214;
            r212 = r125;
            r118 = r215;
            r211 = r219;
            goto L24
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r110) {
            c r111 = (c) r110;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r111, "value");
            g2 r101 = f319884b;
            muc.d r102 = r100.beginStructure(r101);
            Lazy<juc.d<Object>>[] r103 = c.f319871l;
            boolean r104 = false;
            if (r102.shouldEncodeElementDefault(r101, 0) == false) goto L6;
        L7:
            boolean r105 = true;
        L9:
            if (r105 == false) goto L12;
            r102.encodeSerializableElement(r101, 0, r103[0].getValue(), r111.f319872a);
        L12:
            if (r102.shouldEncodeElementDefault(r101, 1) == false) goto L15;
        L16:
            boolean r106 = true;
        L18:
            if (r106 == false) goto L21;
            r102.encodeStringElement(r101, 1, r111.f319873b);
        L21:
            if (r102.shouldEncodeElementDefault(r101, 2) == false) goto L24;
        L25:
            boolean r107 = true;
        L27:
            if (r107 == false) goto L30;
            r102.encodeStringElement(r101, 2, r111.f319874c);
        L30:
            if (r102.shouldEncodeElementDefault(r101, 3) == false) goto L33;
        L34:
            boolean r108 = true;
        L36:
            if (r108 == false) goto L39;
            r102.encodeStringElement(r101, 3, r111.f319875d);
        L39:
            if (r102.shouldEncodeElementDefault(r101, 4) == false) goto L42;
        L43:
            boolean r109 = true;
        L45:
            if (r109 == false) goto L48;
            r102.encodeStringElement(r101, 4, r111.f319876e);
        L48:
            if (r102.shouldEncodeElementDefault(r101, 5) == false) goto L51;
        L52:
            boolean r112 = true;
        L54:
            if (r112 == false) goto L57;
            r102.encodeStringElement(r101, 5, r111.f319877f);
        L57:
            if (r102.shouldEncodeElementDefault(r101, 6) == false) goto L60;
        L61:
            boolean r113 = true;
        L63:
            if (r113 == false) goto L66;
            r102.encodeSerializableElement(r101, 6, r103[6].getValue(), r111.f319878g);
        L66:
            if (r102.shouldEncodeElementDefault(r101, 7) == false) goto L69;
        L70:
            boolean r114 = true;
        L72:
            if (r114 == false) goto L75;
            r102.encodeStringElement(r101, 7, r111.f319879h);
        L75:
            if (r102.shouldEncodeElementDefault(r101, 8) == false) goto L78;
        L79:
            boolean r115 = true;
        L81:
            if (r115 == false) goto L84;
            r102.encodeStringElement(r101, 8, r111.f319880i);
        L84:
            if (r102.shouldEncodeElementDefault(r101, 9) == false) goto L87;
        L88:
            r104 = true;
        L89:
            if (r104 == false) goto L91;
            r102.encodeStringElement(r101, 9, r111.f319881j);
        L91:
            r102.endStructure(r101);
            return;
        L87:
            if (Intrinsics.areEqual(r111.f319881j, "") == true) goto L89;
        L78:
            if (Intrinsics.areEqual(r111.f319880i, "") == false) goto L79;
            r115 = false;
            goto L81
        L69:
            if (Intrinsics.areEqual(r111.f319879h, "") == false) goto L70;
            r114 = false;
            goto L72
        L60:
            if (r111.f319878g != ArcRegion.UNKNOWN) goto L61;
            r113 = false;
            goto L63
        L51:
            if (Intrinsics.areEqual(r111.f319877f, "") == false) goto L52;
            r112 = false;
            goto L54
        L42:
            if (Intrinsics.areEqual(r111.f319876e, "") == false) goto L43;
            r109 = false;
            goto L45
        L33:
            if (Intrinsics.areEqual(r111.f319875d, "") == false) goto L34;
            r108 = false;
            goto L36
        L24:
            if (Intrinsics.areEqual(r111.f319874c, "") == false) goto L25;
            r107 = false;
            goto L27
        L15:
            if (Intrinsics.areEqual(r111.f319873b, "") == false) goto L16;
            r106 = false;
            goto L18
        L6:
            if (r111.f319872a != ArcPlatform.UNKNOWN) goto L7;
            r105 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<c> serializer() {
            return a.f319883a;
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
        if (this.f319872a == r101.f319872a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f319873b, r101.f319873b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f319874c, r101.f319874c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f319875d, r101.f319875d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f319876e, r101.f319876e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f319877f, r101.f319877f) == true) goto L27;
        return false;
    L27:
        if (this.f319878g == r101.f319878g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f319879h, r101.f319879h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f319880i, r101.f319880i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f319881j, r101.f319881j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f319882k, r101.f319882k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((((((((this.f319872a.hashCode() * 31) + this.f319873b.hashCode()) * 31) + this.f319874c.hashCode()) * 31) + this.f319875d.hashCode()) * 31) + this.f319876e.hashCode()) * 31) + this.f319877f.hashCode()) * 31) + this.f319878g.hashCode()) * 31) + this.f319879h.hashCode()) * 31) + this.f319880i.hashCode()) * 31) + this.f319881j.hashCode()) * 31;
        ArcCallLifecycle r101 = this.f319882k;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ArcActionContext(platform=" + this.f319872a + ", packageName=" + this.f319873b + ", processName=" + this.f319874c + ", uid=" + this.f319875d + ", did=" + this.f319876e + ", channel=" + this.f319877f + ", region=" + this.f319878g + ", updateVersionCode=" + this.f319879h + ", requestId=" + this.f319880i + ", traceId=" + this.f319881j + ", callLifecycle=" + this.f319882k + ')';
    }

    static {
        Companion = new b();
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.PUBLICATION;
        f319871l = new Lazy[]{LazyKt.lazy(r100, new com.larus.business.arc.api.a()), null, null, null, null, null, LazyKt.lazy(r100, new com.larus.business.arc.api.b()), null, null, null};
    }

    public /* synthetic */ c(int r110) {
        this(ArcPlatform.UNKNOWN, "", "", "", "", "", ArcRegion.UNKNOWN, "", "", "", null);
    }

    public static c a(c r110, String r111, String r112, ArcCallLifecycle r113) {
        String r100 = r110.f319873b;
        String r101 = r110.f319874c;
        String r102 = r110.f319875d;
        String r103 = r110.f319876e;
        String r104 = r110.f319877f;
        ArcRegion r105 = r110.f319878g;
        String r106 = r110.f319879h;
        Intrinsics.checkNotNullParameter(null, "platform");
        Intrinsics.checkNotNullParameter(r100, "packageName");
        Intrinsics.checkNotNullParameter(r101, "processName");
        Intrinsics.checkNotNullParameter(r102, "uid");
        Intrinsics.checkNotNullParameter(r103, com.bytedance.android.ec.core.event.a.KEY_DID);
        Intrinsics.checkNotNullParameter(r104, "channel");
        Intrinsics.checkNotNullParameter(r105, EffectConfiguration.KEY_REGION);
        Intrinsics.checkNotNullParameter(r106, "updateVersionCode");
        Intrinsics.checkNotNullParameter(r111, "requestId");
        Intrinsics.checkNotNullParameter(r112, "traceId");
        new c(null, r100, r101, r102, r103, r104, r105, r106, r111, r112, r113);
        throw null;
    }

    public c(int r100, ArcPlatform r101, String r102, String r103, String r104, String r105, String r106, ArcRegion r110, String r111, String r112, String r113) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f319884b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = ArcPlatform.UNKNOWN;
    L7:
        this.f319872a = r101;
        if ((r100 & 2) != 0) goto L10;
        this.f319873b = "";
    L12:
        if ((r100 & 4) != 0) goto L14;
        this.f319874c = "";
    L16:
        if ((r100 & 8) != 0) goto L18;
        this.f319875d = "";
    L20:
        if ((r100 & 16) != 0) goto L22;
        this.f319876e = "";
    L24:
        if ((r100 & 32) != 0) goto L26;
        this.f319877f = "";
    L28:
        if ((r100 & 64) != 0) goto L30;
        this.f319878g = ArcRegion.UNKNOWN;
    L32:
        if ((r100 & 128) != 0) goto L34;
        this.f319879h = "";
    L36:
        if ((r100 & 256) != 0) goto L38;
        this.f319880i = "";
    L40:
        if ((r100 & 512) != 0) goto L42;
        this.f319881j = "";
    L43:
        this.f319882k = null;
        return;
    L42:
        this.f319881j = r113;
        goto L43
    L38:
        this.f319880i = r112;
        goto L40
    L34:
        this.f319879h = r111;
        goto L36
    L30:
        this.f319878g = r110;
        goto L32
    L26:
        this.f319877f = r106;
        goto L28
    L22:
        this.f319876e = r105;
        goto L24
    L18:
        this.f319875d = r104;
        goto L20
    L14:
        this.f319874c = r103;
        goto L16
    L10:
        this.f319873b = r102;
        goto L12
    }

    public c(ArcPlatform r100, String r101, String r102, String r103, String r104, String r105, ArcRegion r106, String r107, String r110, String r111, ArcCallLifecycle r112) {
        Intrinsics.checkNotNullParameter(r100, "platform");
        Intrinsics.checkNotNullParameter(r101, "packageName");
        Intrinsics.checkNotNullParameter(r102, "processName");
        Intrinsics.checkNotNullParameter(r103, "uid");
        Intrinsics.checkNotNullParameter(r104, com.bytedance.android.ec.core.event.a.KEY_DID);
        Intrinsics.checkNotNullParameter(r105, "channel");
        Intrinsics.checkNotNullParameter(r106, EffectConfiguration.KEY_REGION);
        Intrinsics.checkNotNullParameter(r107, "updateVersionCode");
        Intrinsics.checkNotNullParameter(r110, "requestId");
        Intrinsics.checkNotNullParameter(r111, "traceId");
        this.f319872a = r100;
        this.f319873b = r101;
        this.f319874c = r102;
        this.f319875d = r103;
        this.f319876e = r104;
        this.f319877f = r105;
        this.f319878g = r106;
        this.f319879h = r107;
        this.f319880i = r110;
        this.f319881j = r111;
        this.f319882k = r112;
    }
}
