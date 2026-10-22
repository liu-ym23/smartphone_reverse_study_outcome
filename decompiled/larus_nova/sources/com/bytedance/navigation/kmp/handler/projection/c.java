package com.bytedance.navigation.kmp.handler.projection;

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
import nuc.v2;
import nuc.w0;

/* JADX INFO: loaded from: classes21.dex */
@Serializable
public final class c {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f265862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f265863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f265864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f265865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f265866e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final double f265867f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f265868g;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f265869a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f265870b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            b0 r100 = b0.f520644a;
            g1 r101 = g1.f520681a;
            return new juc.d[]{v2.f520790a, r100, r100, r101, w0.f520792a, r100, r101};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f265870b;
        }

        static {
            a r100 = new a();
            f265869a = r100;
            g2 r101 = new g2("com.bytedance.navigation.kmp.handler.projection.ProjectionRecord", r100, 7);
            r101.j("navId", false);
            r101.j("projLatitude", false);
            r101.j("projLongitude", false);
            r101.j("locationTimestamp", false);
            r101.j("navYawStatus", false);
            r101.j("deviceDirection", false);
            r101.j("deviceDirectionTimestamp", false);
            f265870b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r210) {
            Intrinsics.checkNotNullParameter(r210, "decoder");
            g2 r100 = f265870b;
            muc.c r101 = r210.beginStructure(r100);
            if (r101.decodeSequentially() == false) goto L5;
            String r102 = r101.decodeStringElement(r100, 0);
            double r103 = r101.decodeDoubleElement(r100, 1);
            double r110 = r101.decodeDoubleElement(r100, 2);
            long r111 = r101.decodeLongElement(r100, 3);
            int r104 = r101.decodeIntElement(r100, 4);
            int r112 = r104;
            double r113 = r101.decodeDoubleElement(r100, 5);
            long r114 = r101.decodeLongElement(r100, 6);
            int r105 = 127;
            String r106 = r102;
            long r115 = r111;
            double r116 = r110;
            double r117 = r103;
        L21:
            r101.endStructure(r100);
            return new c(r105, r106, r117, r116, r115, r112, r113, r114);
        L5:
            String r107 = null;
            double r118 = 0.0d;
            double r119 = 0.0d;
            long r120 = 0;
            long r211 = 0;
            boolean r212 = true;
            double r121 = 0.0d;
            int r122 = 0;
            int r123 = 0;
        L6:
            if (r212 == false) goto L20;
            int r108 = r101.decodeElementIndex(r100);
            switch(r108) {
                case -1: goto L19;
                case 0: goto L18;
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                default: goto L10;
            };
        L10:
            throw new UnknownFieldException(r108);
        L18:
            r107 = r101.decodeStringElement(r100, 0);
            r123 = r123 | 1;
            goto L6
        L19:
            r212 = false;
            goto L6
        L11:
            r211 = r101.decodeLongElement(r100, 6);
            int r109 = r123 | 64;
        L17:
            r123 = r109;
            goto L6
        L12:
            r118 = r101.decodeDoubleElement(r100, 5);
            r109 = r123 | 32;
            goto L17
        L13:
            r122 = r101.decodeIntElement(r100, 4);
            r109 = r123 | 16;
            goto L17
        L14:
            r120 = r101.decodeLongElement(r100, 3);
            r109 = r123 | 8;
            goto L17
        L15:
            r119 = r101.decodeDoubleElement(r100, 2);
            r109 = r123 | 4;
            goto L17
        L16:
            r121 = r101.decodeDoubleElement(r100, 1);
            r109 = r123 | 2;
            goto L17
        L20:
            r106 = r107;
            r105 = r123;
            double r213 = r119;
            r112 = r122;
            r117 = r121;
            r116 = r213;
            r114 = r211;
            r113 = r118;
            r115 = r120;
            goto L21
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            c r102 = (c) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f265870b;
            muc.d r104 = r100.beginStructure(r103);
            r104.encodeStringElement(r103, 0, r102.f265862a);
            r104.encodeDoubleElement(r103, 1, r102.f265863b);
            r104.encodeDoubleElement(r103, 2, r102.f265864c);
            r104.encodeLongElement(r103, 3, r102.f265865d);
            r104.encodeIntElement(r103, 4, r102.f265866e);
            r104.encodeDoubleElement(r103, 5, r102.f265867f);
            r104.encodeLongElement(r103, 6, r102.f265868g);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<c> serializer() {
            return a.f265869a;
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
        if (Intrinsics.areEqual(this.f265862a, r101.f265862a) == true) goto L12;
        return false;
    L12:
        if (Double.compare(this.f265863b, r101.f265863b) == 0) goto L15;
        return false;
    L15:
        if (Double.compare(this.f265864c, r101.f265864c) == 0) goto L18;
        return false;
    L18:
        if (this.f265865d == r101.f265865d) goto L21;
        return false;
    L21:
        if (this.f265866e == r101.f265866e) goto L24;
        return false;
    L24:
        if (Double.compare(this.f265867f, r101.f265867f) == 0) goto L27;
        return false;
    L27:
        if (this.f265868g == r101.f265868g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f265862a.hashCode() * 31;
        long r101 = Double.doubleToLongBits(this.f265863b);
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = Double.doubleToLongBits(this.f265864c);
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f265865d;
        int r106 = (((r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31) + this.f265866e) * 31;
        long r107 = Double.doubleToLongBits(this.f265867f);
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.f265868g;
        return r108 + ((int) (r109 ^ (r109 >>> 32)));
    }

    public final String toString() {
        return "ProjectionRecord(navId=" + this.f265862a + ", projLatitude=" + this.f265863b + ", projLongitude=" + this.f265864c + ", locationTimestamp=" + this.f265865d + ", navYawStatus=" + this.f265866e + ", deviceDirection=" + this.f265867f + ", deviceDirectionTimestamp=" + this.f265868g + ")";
    }

    static {
        Companion = new b();
    }

    public c(String r100, double r101, double r102, long r103, int r104, double r110, long r111) {
        Intrinsics.checkNotNullParameter(r100, "navId");
        this.f265862a = r100;
        this.f265863b = r101;
        this.f265864c = r102;
        this.f265865d = r103;
        this.f265866e = r104;
        this.f265867f = r110;
        this.f265868g = r111;
    }

    public c(int r100, String r101, double r102, double r103, long r104, int r110, double r111, long r112) {
        if (127 != (r100 & 127)) goto L6;
        this.f265862a = r101;
        this.f265863b = r102;
        this.f265864c = r103;
        this.f265865d = r104;
        this.f265866e = r110;
        this.f265867f = r111;
        this.f265868g = r112;
        return;
    L6:
        b2.b(r100, 127, a.f265870b);
        throw null;
    }
}
