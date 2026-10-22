package com.bytedance.kmp.performance;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.w0;

/* JADX INFO: loaded from: classes19.dex */
@Serializable
public final class r {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f252826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f252827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f252828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f252829d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f252830e;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<r> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f252831a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f252832b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            nuc.i r100 = nuc.i.f520705a;
            w0 r101 = w0.f520792a;
            return new juc.d[]{r100, r101, r101, r100, r101};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f252832b;
        }

        static {
            a r100 = new a();
            f252831a = r100;
            g2 r101 = new g2("com.bytedance.kmp.performance.KmpMemoryUploadConfig", r100, 5);
            r101.j("enable", true);
            r101.j("memThresholdMB", true);
            r101.j("uploadIntervalMin", true);
            r101.j("gcEnable", true);
            r101.j("gcIntervalMin", true);
            f252832b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f252832b;
            muc.c r101 = r210.beginStructure(r100);
            if (r101.decodeSequentially() == false) goto L5;
            boolean r102 = r101.decodeBooleanElement(r100, 0);
            int r103 = r101.decodeIntElement(r100, 1);
            int r104 = r101.decodeIntElement(r100, 2);
            boolean r105 = r101.decodeBooleanElement(r100, 3);
            boolean r110 = r102;
            int r111 = r104;
            int r211 = r101.decodeIntElement(r100, 4);
            int r112 = r103;
            boolean r113 = r105;
            int r114 = 31;
        L23:
            r101.endStructure(r100);
            return new r(r114, r110, r112, r111, r113, r211);
        L5:
            boolean r106 = false;
            int r107 = 0;
            int r108 = 0;
            int r115 = 0;
            boolean r116 = false;
            int r117 = 0;
            boolean r118 = true;
        L6:
            if (r118 == false) goto L22;
            int r119 = r101.decodeElementIndex(r100);
            if (r119 != (-1)) goto L9;
            r118 = false;
            goto L6
        L9:
            if (r119 != 0) goto L10;
            r106 = r101.decodeBooleanElement(r100, 0);
            r117 = r117 | 1;
            goto L6
        L10:
            if (r119 != 1) goto L11;
            r115 = r101.decodeIntElement(r100, 1);
            r117 = r117 | 2;
            goto L6
        L11:
            if (r119 != 2) goto L12;
            r107 = r101.decodeIntElement(r100, 2);
            r117 = r117 | 4;
            goto L6
        L12:
            if (r119 != 3) goto L13;
            r116 = r101.decodeBooleanElement(r100, 3);
            r117 = r117 | 8;
            goto L6
        L13:
            if (r119 != 4) goto L16;
            r108 = r101.decodeIntElement(r100, 4);
            r117 = r117 | 16;
            goto L6
        L16:
            throw new UnknownFieldException(r119);
        L22:
            r110 = r106;
            r111 = r107;
            r211 = r108;
            r112 = r115;
            r113 = r116;
            r114 = r117;
            goto L23
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            r r102 = (r) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f252832b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = r.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeBooleanElement(r103, 0, r102.f252826a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            boolean r108 = true;
        L18:
            if (r108 == false) goto L21;
            r104.encodeIntElement(r103, 1, r102.f252827b);
        L21:
            if (r104.shouldEncodeElementDefault(r103, 2) == false) goto L24;
        L25:
            boolean r109 = true;
        L27:
            if (r109 == false) goto L30;
            r104.encodeIntElement(r103, 2, r102.f252828c);
        L30:
            if (r104.shouldEncodeElementDefault(r103, 3) == false) goto L33;
        L34:
            boolean r110 = true;
        L36:
            if (r110 == false) goto L39;
            r104.encodeBooleanElement(r103, 3, r102.f252829d);
        L39:
            if (r104.shouldEncodeElementDefault(r103, 4) == false) goto L42;
        L43:
            r106 = true;
        L44:
            if (r106 == false) goto L46;
            r104.encodeIntElement(r103, 4, r102.f252830e);
        L46:
            r104.endStructure(r103);
            return;
        L42:
            if (r102.f252830e == 2880) goto L44;
        L33:
            if (r102.f252829d == true) goto L34;
            r110 = false;
            goto L36
        L24:
            if (r102.f252828c != 2880) goto L25;
            r109 = false;
            goto L27
        L15:
            if (r102.f252827b != 150) goto L16;
            r108 = false;
            goto L18
        L6:
            if (r102.f252826a == true) goto L7;
            r107 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<r> serializer() {
            return a.f252831a;
        }
    }

    public r() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof r) == true) goto L8;
        return false;
    L8:
        r r101 = (r) r100;
        if (this.f252826a == r101.f252826a) goto L12;
        return false;
    L12:
        if (this.f252827b == r101.f252827b) goto L15;
        return false;
    L15:
        if (this.f252828c == r101.f252828c) goto L18;
        return false;
    L18:
        if (this.f252829d == r101.f252829d) goto L21;
        return false;
    L21:
        if (this.f252830e == r101.f252830e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f252826a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((((r101 * 31) + this.f252827b) * 31) + this.f252828c) * 31;
        if (this.f252829d == true) goto L11;
        r100 = 1237;
    L11:
        return ((r102 + r100) * 31) + this.f252830e;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "KmpMemoryUploadConfig(enable=" + this.f252826a + ", memThresholdMB=" + this.f252827b + ", uploadIntervalMin=" + this.f252828c + ", gcEnable=" + this.f252829d + ", gcIntervalMin=" + this.f252830e + ')';
    }

    static {
        Companion = new b();
    }

    public r(int r100) {
        this.f252826a = false;
        this.f252827b = 150;
        this.f252828c = 2880;
        this.f252829d = false;
        this.f252830e = 2880;
    }

    public r(int r100, boolean r101, int r102, int r103, boolean r104, int r105) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f252832b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f252826a = false;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f252827b = 150;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.f252828c = 2880;
    L17:
        if ((r100 & 8) != 0) goto L19;
        this.f252829d = false;
    L21:
        if ((r100 & 16) != 0) goto L23;
        this.f252830e = 2880;
        return;
    L23:
        this.f252830e = r105;
        return;
    L19:
        this.f252829d = r104;
        goto L21
    L15:
        this.f252828c = r103;
        goto L17
    L11:
        this.f252827b = r102;
        goto L13
    L7:
        this.f252826a = r101;
        goto L9
    }
}
