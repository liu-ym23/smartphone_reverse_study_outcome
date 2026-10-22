package com.larus.im.service;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.v2;

/* JADX INFO: loaded from: classes30.dex */
@Serializable
public final class d {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f350826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f350827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f350828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f350829d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f350830e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f350831f;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f350832a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f350833b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            return new juc.d[]{kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r100), nuc.i.f520705a, r100, kuc.a.d(r100)};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f350833b;
        }

        static {
            a r100 = new a();
            f350832a = r100;
            g2 r101 = new g2("com.larus.im.service.FlowAVMMTInitConfig", r100, 6);
            r101.j("mmtAppId", true);
            r101.j("bizId", true);
            r101.j("streamApp", true);
            r101.j("enableTestEnv", false);
            r101.j("ppeLane", false);
            r101.j("bmmtConfig", true);
            f350833b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f350833b;
            muc.c r101 = r110.beginStructure(r100);
            int r102 = 2;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r103 = v2.f520790a;
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 0, r103, null);
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 1, r103, null);
            String r106 = (String) r101.decodeNullableSerializableElement(r100, 2, r103, null);
            boolean r107 = r101.decodeBooleanElement(r100, 3);
            String r108 = r101.decodeStringElement(r100, 4);
            String r111 = (String) r101.decodeNullableSerializableElement(r100, 5, r103, null);
            String r112 = r106;
            String r113 = r108;
            String r114 = r105;
            String r115 = r104;
            boolean r116 = r107;
            int r109 = 63;
        L21:
            r101.endStructure(r100);
            return new d(r109, r115, r114, r112, r116, r113, r111);
        L5:
            String r117 = null;
            r114 = null;
            String r118 = null;
            String r119 = null;
            String r120 = null;
            int r121 = 0;
            boolean r122 = false;
            boolean r123 = true;
        L6:
            if (r123 == false) goto L20;
            int r124 = r101.decodeElementIndex(r100);
            switch(r124) {
                case -1: goto L19;
                case 0: goto L17;
                case 1: goto L15;
                case 2: goto L14;
                case 3: goto L13;
                case 4: goto L12;
                case 5: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r124);
        L19:
            r102 = 2;
            r123 = false;
            goto L6
        L11:
            r117 = (String) r101.decodeNullableSerializableElement(r100, 5, v2.f520790a, r117);
            r121 = r121 | 32;
        L18:
            r102 = 2;
            goto L6
        L12:
            r119 = r101.decodeStringElement(r100, 4);
            r121 = r121 | 16;
            goto L18
        L13:
            r122 = r101.decodeBooleanElement(r100, 3);
            r121 = r121 | 8;
            goto L18
        L14:
            r120 = (String) r101.decodeNullableSerializableElement(r100, r102, v2.f520790a, r120);
            r121 = r121 | 4;
            goto L18
        L15:
            r114 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r114);
            r121 = r121 | 2;
            goto L18
        L17:
            r121 = r121 | 1;
            r118 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r118);
            goto L18
        L20:
            r111 = r117;
            r115 = r118;
            r112 = r120;
            r113 = r119;
            r116 = r122;
            r109 = r121;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            d r102 = (d) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f350833b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = d.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, v2.f520790a, r102.f350826a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeNullableSerializableElement(r103, 1, v2.f520790a, r102.f350827b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            boolean r109 = true;
        L27:
            if (r109 == false) goto L29;
            r104.encodeNullableSerializableElement(r103, 2, v2.f520790a, r102.f350828c);
        L29:
            r104.encodeBooleanElement(r103, 3, r102.f350829d);
            r104.encodeStringElement(r103, 4, r102.f350830e);
            if (r104.shouldEncodeElementDefault(r103, 5) == false) goto L33;
        L34:
            r106 = true;
        L35:
            if (r106 == false) goto L37;
            r104.encodeNullableSerializableElement(r103, 5, v2.f520790a, r102.f350831f);
        L37:
            r104.endStructure(r103);
            return;
        L33:
            if (r102.f350831f == null) goto L35;
        L24:
            if (r102.f350828c != null) goto L25;
            r109 = false;
            goto L27
        L15:
            if (r102.f350827b != null) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f350826a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<d> serializer() {
            return a.f350832a;
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
        if (Intrinsics.areEqual(this.f350826a, r101.f350826a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f350827b, r101.f350827b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f350828c, r101.f350828c) == true) goto L18;
        return false;
    L18:
        if (this.f350829d == r101.f350829d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f350830e, r101.f350830e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f350831f, r101.f350831f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f350826a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f350827b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f350828c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.f350829d == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (((r109 + r110) * 31) + this.f350830e.hashCode()) * 31;
        String r112 = this.f350831f;
        if (r112 == null) goto L23;
        r101 = r112.hashCode();
    L23:
        return r111 + r101;
    L17:
        r110 = 1237;
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
        return "FlowAVMMTInitConfig(mmtAppId=" + this.f350826a + ", bizId=" + this.f350827b + ", streamApp=" + this.f350828c + ", enableTestEnv=" + this.f350829d + ", ppeLane=" + this.f350830e + ", bmmtConfig=" + this.f350831f + ')';
    }

    static {
        Companion = new b();
    }

    public d(String r100, String r101, String r102, boolean r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r104, "ppeLane");
        this.f350826a = r100;
        this.f350827b = r101;
        this.f350828c = r102;
        this.f350829d = r103;
        this.f350830e = r104;
        this.f350831f = r105;
    }

    public d(int r100, String r101, String r102, String r103, boolean r104, String r105, String r110) {
        if (24 == (r100 & 24)) goto L5;
        b2.b(r100, 24, a.f350833b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f350826a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f350827b = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f350828c = null;
    L16:
        this.f350829d = r104;
        this.f350830e = r105;
        if ((r100 & 32) != 0) goto L19;
        this.f350831f = null;
        return;
    L19:
        this.f350831f = r110;
        return;
    L15:
        this.f350828c = r103;
        goto L16
    L11:
        this.f350827b = r102;
        goto L13
    L7:
        this.f350826a = r101;
        goto L9
    }
}
