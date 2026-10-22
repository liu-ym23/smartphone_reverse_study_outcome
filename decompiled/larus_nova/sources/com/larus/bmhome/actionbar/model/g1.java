package com.larus.bmhome.actionbar.model;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;
import nuc.v2;

/* JADX INFO: loaded from: classes25.dex */
@Serializable
public final class g1 {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f295155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f295156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f295157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f295158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f295159e;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<g1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f295160a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f295161b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            v2 r100 = v2.f520790a;
            nuc.w0 r101 = nuc.w0.f520792a;
            return new juc.d[]{kuc.a.d(r100), kuc.a.d(r100), kuc.a.d(r101), kuc.a.d(r101), kuc.a.d(r101)};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f295161b;
        }

        static {
            a r100 = new a();
            f295160a = r100;
            g2 r101 = new g2("com.larus.bmhome.actionbar.model.Icon", r100, 5);
            r101.j("uri", true);
            r101.j("url", true);
            r101.j("width", true);
            r101.j("height", true);
            r101.j("radius", true);
            f295161b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f295161b;
            muc.c r101 = r210.beginStructure(r100);
            String r102 = null;
            if (r101.decodeSequentially() == false) goto L5;
            v2 r103 = v2.f520790a;
            String r104 = (String) r101.decodeNullableSerializableElement(r100, 0, r103, null);
            String r105 = (String) r101.decodeNullableSerializableElement(r100, 1, r103, null);
            nuc.w0 r106 = nuc.w0.f520792a;
            Integer r107 = (Integer) r101.decodeNullableSerializableElement(r100, 2, r106, null);
            Integer r108 = (Integer) r101.decodeNullableSerializableElement(r100, 3, r106, null);
            String r110 = r105;
            Integer r111 = r107;
            Integer r211 = (Integer) r101.decodeNullableSerializableElement(r100, 4, r106, null);
            String r112 = r104;
            Integer r113 = r108;
            int r114 = 31;
        L23:
            r101.endStructure(r100);
            return new g1(r114, r112, r110, r111, r113, r211);
        L5:
            String r109 = null;
            Integer r115 = null;
            Integer r116 = null;
            Integer r117 = null;
            int r118 = 0;
            boolean r119 = true;
        L6:
            if (r119 == false) goto L22;
            int r120 = r101.decodeElementIndex(r100);
            if (r120 != (-1)) goto L9;
            r119 = false;
            goto L6
        L9:
            if (r120 != 0) goto L10;
            r102 = (String) r101.decodeNullableSerializableElement(r100, 0, v2.f520790a, r102);
            r118 = r118 | 1;
            goto L6
        L10:
            if (r120 != 1) goto L11;
            r109 = (String) r101.decodeNullableSerializableElement(r100, 1, v2.f520790a, r109);
            r118 = r118 | 2;
            goto L6
        L11:
            if (r120 != 2) goto L12;
            r115 = (Integer) r101.decodeNullableSerializableElement(r100, 2, nuc.w0.f520792a, r115);
            r118 = r118 | 4;
            goto L6
        L12:
            if (r120 != 3) goto L13;
            r116 = (Integer) r101.decodeNullableSerializableElement(r100, 3, nuc.w0.f520792a, r116);
            r118 = r118 | 8;
            goto L6
        L13:
            if (r120 != 4) goto L16;
            r117 = (Integer) r101.decodeNullableSerializableElement(r100, 4, nuc.w0.f520792a, r117);
            r118 = r118 | 16;
            goto L6
        L16:
            throw new UnknownFieldException(r120);
        L22:
            r114 = r118;
            r112 = r102;
            r110 = r109;
            r111 = r115;
            r113 = r116;
            r211 = r117;
            goto L23
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            g1 r102 = (g1) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f295161b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = g1.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeNullableSerializableElement(r103, 0, v2.f520790a, r102.f295155a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeNullableSerializableElement(r103, 1, v2.f520790a, r102.f295156b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == true) goto L28;
            Integer r109 = r102.f295157c;
            if (r109 == null) goto L28;
            if (r109.intValue() != 0) goto L28;
            boolean r110 = false;
        L30:
            if (r110 == false) goto L33;
            r104.encodeNullableSerializableElement(r103, 2, nuc.w0.f520792a, r102.f295157c);
        L33:
            if (r104.shouldEncodeElementDefault(r103, 3) == true) goto L40;
            Integer r111 = r102.f295158d;
            if (r111 == null) goto L40;
            if (r111.intValue() != 0) goto L40;
            boolean r112 = false;
        L42:
            if (r112 == false) goto L45;
            r104.encodeNullableSerializableElement(r103, 3, nuc.w0.f520792a, r102.f295158d);
        L45:
            if (r104.shouldEncodeElementDefault(r103, 4) == true) goto L52;
            Integer r113 = r102.f295159e;
            if (r113 == null) goto L52;
            if (r113.intValue() != 4) goto L52;
        L53:
            if (r106 == false) goto L55;
            r104.encodeNullableSerializableElement(r103, 4, nuc.w0.f520792a, r102.f295159e);
        L55:
            r104.endStructure(r103);
            return;
        L52:
            r106 = true;
        L40:
            r112 = true;
        L28:
            r110 = true;
            goto L30
        L15:
            if (r102.f295156b != null) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f295155a != null) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<g1> serializer() {
            return a.f295160a;
        }
    }

    public g1() {
        this(null, null, null, null, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g1) == true) goto L8;
        return false;
    L8:
        g1 r101 = (g1) r100;
        if (Intrinsics.areEqual(this.f295155a, r101.f295155a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f295156b, r101.f295156b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f295157c, r101.f295157c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f295158d, r101.f295158d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f295159e, r101.f295159e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f295155a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f295156b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f295157c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f295158d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f295159e;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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
        return "Icon(uri=" + this.f295155a + ", url=" + this.f295156b + ", width=" + this.f295157c + ", height=" + this.f295158d + ", radius=" + this.f295159e + ')';
    }

    static {
        Companion = new b();
    }

    public g1(String r100, String r101, Integer r102, Integer r103, int r104) {
        Integer r105 = null;
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r104 & 8) == 0) goto L15;
        r103 = 0;
    L15:
        if ((r104 & 16) == 0) goto L17;
        r105 = 4;
    L17:
        this.f295155a = r100;
        this.f295156b = r101;
        this.f295157c = r102;
        this.f295158d = r103;
        this.f295159e = r105;
    }

    public g1(int r100, String r101, String r102, Integer r103, Integer r104, Integer r110) {
        if ((r100 & 0) == 0) goto L5;
        nuc.b2.b(r100, 0, a.f295161b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f295155a = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f295156b = null;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f295157c = 0;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f295158d = 0;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.f295159e = 4;
        return;
    L23:
        this.f295159e = r110;
        return;
    L19:
        this.f295158d = r104;
        goto L21
    L15:
        this.f295157c = r103;
        goto L17
    L11:
        this.f295156b = r102;
        goto L13
    L7:
        this.f295155a = r101;
        goto L9
    }
}
