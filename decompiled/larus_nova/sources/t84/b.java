package t84;

import com.alipay.sdk.m.u.i;
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

/* JADX INFO: loaded from: classes10.dex */
@Serializable
public final class b {
    public static final C7694b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f545020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f545021b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f545022a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f545023b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            l0 r100 = l0.f520731a;
            return new juc.d[]{r100, r100};
        }

        @Override // juc.d, juc.n, juc.c
        public final f getDescriptor() {
            return f545023b;
        }

        static {
            a r100 = new a();
            f545022a = r100;
            g2 r101 = new g2("com.bytedance.bdnavigationsdk.pojo.Threshold.Dynamic", r100, 2);
            r101.j("projection_dist", true);
            r101.j("bearing_angle", true);
            f545023b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(e r110) {
            Intrinsics.checkNotNullParameter(r110, "decoder");
            g2 r100 = f545023b;
            muc.c r111 = r110.beginStructure(r100);
            if (r111.decodeSequentially() == false) goto L5;
            float r101 = r111.decodeFloatElement(r100, 0);
            float r102 = r111.decodeFloatElement(r100, 1);
            int r103 = 3;
        L17:
            r111.endStructure(r100);
            return new b(r103, r101, r102);
        L5:
            r101 = 0.0f;
            float r104 = 0.0f;
            int r105 = 0;
            boolean r106 = true;
        L6:
            if (r106 == false) goto L16;
            int r107 = r111.decodeElementIndex(r100);
            if (r107 != (-1)) goto L9;
            r106 = false;
            goto L6
        L9:
            if (r107 != 0) goto L10;
            r101 = r111.decodeFloatElement(r100, 0);
            r105 = r105 | 1;
            goto L6
        L10:
            if (r107 != 1) goto L13;
            r104 = r111.decodeFloatElement(r100, 1);
            r105 = r105 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r107);
        L16:
            r102 = r104;
            r103 = r105;
            goto L17
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            b r102 = (b) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f545023b;
            muc.d r104 = r100.beginStructure(r103);
            C7694b r105 = b.Companion;
            boolean r106 = false;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r107 = true;
        L9:
            if (r107 == false) goto L12;
            r104.encodeFloatElement(r103, 0, r102.f545020a);
        L12:
            if (r104.shouldEncodeElementDefault(r103, 1) == false) goto L15;
        L16:
            r106 = true;
        L17:
            if (r106 == false) goto L19;
            r104.encodeFloatElement(r103, 1, r102.f545021b);
        L19:
            r104.endStructure(r103);
            return;
        L15:
            if (Float.compare(r102.f545021b, 0.0f) == 0) goto L17;
        L6:
            if (Float.compare(r102.f545020a, 0.0f) != 0) goto L7;
            r107 = false;
            goto L9
        }
    }

    /* JADX INFO: renamed from: t84.b$b, reason: collision with other inner class name */
    public static final class C7694b {
        public C7694b() {
        }

        public final juc.d<b> serializer() {
            return a.f545022a;
        }
    }

    public b() {
        this(0.0f, 0.0f);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Float.compare(this.f545020a, r101.f545020a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f545021b, r101.f545021b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f545020a) * 31) + Float.floatToIntBits(this.f545021b);
    }

    static {
        Companion = new C7694b();
    }

    public final String toString() {
        return "Dynamic{projectionDist=" + this.f545020a + ", bearingAngle=" + this.f545021b + i.f25855d;
    }

    public b(float r100, float r101) {
        this.f545020a = r100;
        this.f545021b = r101;
    }

    public b(int r100, float r101, float r102) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f545023b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f545020a = 0.0f;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.f545021b = 0.0f;
        return;
    L11:
        this.f545021b = r102;
        return;
    L7:
        this.f545020a = r101;
        goto L9
    }
}
