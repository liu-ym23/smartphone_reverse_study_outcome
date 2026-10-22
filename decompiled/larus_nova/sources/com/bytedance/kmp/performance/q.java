package com.bytedance.kmp.performance;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b0;
import nuc.b2;
import nuc.g1;
import nuc.g2;
import nuc.i2;
import nuc.m0;
import nuc.w0;

/* JADX INFO: loaded from: classes19.dex */
@Serializable
public final class q {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f252819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f252820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f252821c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f252822d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f252823e;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<q> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f252824a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f252825b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            nuc.i r100 = nuc.i.f520705a;
            return new juc.d[]{r100, r100, b0.f520644a, w0.f520792a, g1.f520681a};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f252825b;
        }

        static {
            a r100 = new a();
            f252824a = r100;
            g2 r101 = new g2("com.bytedance.kmp.performance.KmpMemoryCollectionConfig", r100, 5);
            r101.j("enable", true);
            r101.j("composeEnable", true);
            r101.j("sample", true);
            r101.j("intervalSecond", true);
            r101.j("composeBeatSecond", true);
            f252825b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f252825b;
            muc.c r101 = r210.beginStructure(r100);
            if (r101.decodeSequentially() == false) goto L5;
            boolean r102 = r101.decodeBooleanElement(r100, 0);
            boolean r103 = r101.decodeBooleanElement(r100, 1);
            double r104 = r101.decodeDoubleElement(r100, 2);
            boolean r110 = r102;
            int r211 = r101.decodeIntElement(r100, 3);
            boolean r111 = r103;
            long r212 = r101.decodeLongElement(r100, 4);
            double r213 = r104;
            int r112 = 31;
        L25:
            r101.endStructure(r100);
            return new q(r112, r110, r111, r213, r211, r212);
        L5:
            long r113 = 0;
            double r114 = 0.0d;
            boolean r105 = false;
            int r106 = 0;
            boolean r107 = false;
            int r115 = 0;
            boolean r116 = true;
        L6:
            if (r116 == false) goto L24;
            int r108 = r101.decodeElementIndex(r100);
            if (r108 != (-1)) goto L9;
            r116 = false;
            goto L6
        L9:
            if (r108 != 0) goto L10;
            r105 = r101.decodeBooleanElement(r100, 0);
            r115 = r115 | 1;
            goto L6
        L10:
            if (r108 != 1) goto L12;
            r107 = r101.decodeBooleanElement(r100, 1);
            int r109 = r115 | 2;
        L21:
            r115 = r109;
            goto L6
        L12:
            if (r108 == 2) goto L19;
            if (r108 == 3) goto L18;
            if (r108 != 4) goto L17;
            r113 = r101.decodeLongElement(r100, 4);
            r109 = r115 | 16;
            goto L21
        L17:
            throw new UnknownFieldException(r108);
        L18:
            r106 = r101.decodeIntElement(r100, 3);
            r109 = r115 | 8;
            goto L21
        L19:
            r114 = r101.decodeDoubleElement(r100, 2);
            r109 = r115 | 4;
            goto L21
        L24:
            r110 = r105;
            r211 = r106;
            r111 = r107;
            r212 = r113;
            r112 = r115;
            r213 = r114;
            goto L25
        }

        @Override // juc.n
        public final void serialize(muc.f r110, Object r111) {
            q r112 = (q) r111;
            Intrinsics.checkNotNullParameter(r110, "encoder");
            Intrinsics.checkNotNullParameter(r112, "value");
            g2 r100 = f252825b;
            muc.d r113 = r110.beginStructure(r100);
            b r101 = q.Companion;
            boolean r102 = false;
            if (r113.shouldEncodeElementDefault(r100, 0) == false) goto L6;
        L7:
            boolean r103 = true;
        L9:
            if (r103 == false) goto L12;
            r113.encodeBooleanElement(r100, 0, r112.f252819a);
        L12:
            if (r113.shouldEncodeElementDefault(r100, 1) == false) goto L15;
        L16:
            boolean r104 = true;
        L18:
            if (r104 == false) goto L21;
            r113.encodeBooleanElement(r100, 1, r112.f252820b);
        L21:
            if (r113.shouldEncodeElementDefault(r100, 2) == false) goto L24;
        L25:
            boolean r105 = true;
        L27:
            if (r105 == false) goto L30;
            r113.encodeDoubleElement(r100, 2, r112.f252821c);
        L30:
            if (r113.shouldEncodeElementDefault(r100, 3) == false) goto L33;
        L34:
            boolean r106 = true;
        L36:
            if (r106 == false) goto L39;
            r113.encodeIntElement(r100, 3, r112.f252822d);
        L39:
            if (r113.shouldEncodeElementDefault(r100, 4) == false) goto L42;
        L43:
            r102 = true;
        L44:
            if (r102 == false) goto L46;
            r113.encodeLongElement(r100, 4, r112.f252823e);
        L46:
            r113.endStructure(r100);
            return;
        L42:
            if (r112.f252823e == 10) goto L44;
        L33:
            if (r112.f252822d != 60) goto L34;
            r106 = false;
            goto L36
        L24:
            if (Double.compare(r112.f252821c, 1.0d) != 0) goto L25;
            r105 = false;
            goto L27
        L15:
            if (r112.f252820b == true) goto L16;
            r104 = false;
            goto L18
        L6:
            if (r112.f252819a != true) goto L7;
            r103 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<q> serializer() {
            return a.f252824a;
        }
    }

    public q() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (this.f252819a == r101.f252819a) goto L12;
        return false;
    L12:
        if (this.f252820b == r101.f252820b) goto L15;
        return false;
    L15:
        if (Double.compare(this.f252821c, r101.f252821c) == 0) goto L18;
        return false;
    L18:
        if (this.f252822d == r101.f252822d) goto L21;
        return false;
    L21:
        if (this.f252823e == r101.f252823e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f252819a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f252820b == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        long r104 = Double.doubleToLongBits(this.f252821c);
        int r105 = (((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.f252822d) * 31;
        long r106 = this.f252823e;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "KmpMemoryCollectionConfig(enable=" + this.f252819a + ", composeEnable=" + this.f252820b + ", sample=" + this.f252821c + ", intervalSecond=" + this.f252822d + ", composeBeatSecond=" + this.f252823e + ')';
    }

    static {
        Companion = new b();
    }

    public q(int r100) {
        this.f252819a = true;
        this.f252820b = false;
        this.f252821c = 1.0d;
        this.f252822d = 60;
        this.f252823e = 10;
    }

    public q(int r100, boolean r101, boolean r102, double r103, int r104, long r105) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f252825b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        r101 = true;
    L7:
        this.f252819a = r101;
        if ((r100 & 2) != 0) goto L10;
        this.f252820b = false;
    L12:
        if ((r100 & 4) != 0) goto L14;
        this.f252821c = 1.0d;
    L16:
        if ((r100 & 8) != 0) goto L18;
        this.f252822d = 60;
    L20:
        if ((r100 & 16) != 0) goto L22;
        this.f252823e = 10;
        return;
    L22:
        this.f252823e = r105;
        return;
    L18:
        this.f252822d = r104;
        goto L20
    L14:
        this.f252821c = r103;
        goto L16
    L10:
        this.f252820b = r102;
        goto L12
    }
}
