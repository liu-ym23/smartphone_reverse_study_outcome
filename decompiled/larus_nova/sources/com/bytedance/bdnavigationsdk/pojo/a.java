package com.bytedance.bdnavigationsdk.pojo;

import androidx.camera.video.AudioStats;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import luc.f;
import muc.e;
import nuc.b0;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.m0;

/* JADX INFO: loaded from: classes10.dex */
@Serializable
public final class a {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f200330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f200331b;

    /* JADX INFO: renamed from: com.bytedance.bdnavigationsdk.pojo.a$a, reason: collision with other inner class name */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class C2885a implements m0<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C2885a f200332a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f200333b = null;

        public C2885a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            b0 r100 = b0.f520644a;
            return new juc.d[]{r100, r100};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f200333b;
        }

        static {
            C2885a r100 = new C2885a();
            f200332a = r100;
            g2 r101 = new g2("com.bytedance.bdnavigationsdk.pojo.LatLng", r100, 2);
            r101.j("latitude", false);
            r101.j("longitude", false);
            f200333b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f200333b;
            muc.c r101 = r110.beginStructure(r100);
            if (r101.decodeSequentially() == false) goto L5;
            double r111 = r101.decodeDoubleElement(r100, 0);
            double r112 = r101.decodeDoubleElement(r100, 1);
            int r113 = 3;
        L17:
            r101.endStructure(r100);
            return new a(r113, r111, r112);
        L5:
            double r102 = AudioStats.AUDIO_AMPLITUDE_NONE;
            double r103 = 0.0d;
            int r104 = 0;
            boolean r105 = true;
        L6:
            if (r105 == false) goto L16;
            int r114 = r101.decodeElementIndex(r100);
            if (r114 != (-1)) goto L9;
            r105 = false;
            goto L6
        L9:
            if (r114 != 0) goto L10;
            r102 = r101.decodeDoubleElement(r100, 0);
            r104 = r104 | 1;
            goto L6
        L10:
            if (r114 != 1) goto L13;
            r103 = r101.decodeDoubleElement(r100, 1);
            r104 = r104 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r114);
        L16:
            r113 = r104;
            r111 = r102;
            r112 = r103;
            goto L17
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            a r102 = (a) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f200333b;
            muc.d r104 = r100.beginStructure(r103);
            r104.encodeDoubleElement(r103, 0, r102.f200330a);
            r104.encodeDoubleElement(r103, 1, r102.f200331b);
            r104.endStructure(r103);
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<a> serializer() {
            return C2885a.f200332a;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Double.compare(this.f200330a, r101.f200330a) == 0) goto L12;
        return false;
    L12:
        if (Double.compare(this.f200331b, r101.f200331b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        long r100 = Double.doubleToLongBits(this.f200330a);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.f200331b);
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    static {
        Companion = new b();
    }

    public a() {
        this(AudioStats.AUDIO_AMPLITUDE_NONE, AudioStats.AUDIO_AMPLITUDE_NONE);
    }

    public final String toString() {
        return "lat/lng: (" + this.f200330a + "," + this.f200331b + ")";
    }

    public static a a(a r100) {
        double r101 = r100.f200330a;
        double r102 = r100.f200331b;
        r100.getClass();
        return new a(r101, r102);
    }

    public a(double r100, double r110) {
        this.f200330a = r100;
        this.f200331b = r110;
        if ((-180.0d) <= r110) goto L5;
    L7:
        double r101 = 180.0f;
        double r102 = 360.0f;
        double r103 = ((((r110 - r101) % r102) + r102) % r102) - r101;
    L8:
        boolean r104 = true;
        if (Math.max(-90.0d, Math.min(90.0d, r100)) != r100) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L20;
        if (r103 == r110) goto L17;
        r104 = false;
    L17:
        if (r104 == false) goto L20;
        return;
    L20:
        throw new IllegalArgumentException("非法坐标值: latitude=" + r100 + ", longitude=" + r110 + " 必须在 [-90, 90] 和 [-180, 180) 范围内");
    L11:
        r105 = false;
        goto L12
    L5:
        if (r110 >= 180.0d) goto L7;
        r103 = r110;
        goto L8
    }

    public a(int r100, double r101, double r110) {
        if (3 != (r100 & 3)) goto L22;
        this.f200330a = r101;
        this.f200331b = r110;
        if ((-180.0d) <= r110) goto L7;
    L9:
        double r102 = 180.0f;
        double r103 = 360.0f;
        double r104 = ((((r110 - r102) % r103) + r103) % r103) - r102;
    L10:
        boolean r105 = false;
        if (Math.max(-90.0d, Math.min(90.0d, r101)) != r101) goto L13;
        boolean r106 = true;
    L14:
        if (r106 == false) goto L21;
        if (r104 != r110) goto L18;
        r105 = true;
    L18:
        if (r105 == false) goto L21;
        return;
    L21:
        throw new IllegalArgumentException("非法坐标值: latitude=" + r101 + ", longitude=" + r110 + " 必须在 [-90, 90] 和 [-180, 180) 范围内");
    L13:
        r106 = false;
        goto L14
    L7:
        if (r110 >= 180.0d) goto L9;
        r104 = r110;
        goto L10
    L22:
        b2.b(r100, 3, C2885a.f200333b);
        throw null;
    }
}
