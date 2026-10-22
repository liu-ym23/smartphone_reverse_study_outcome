package t84;

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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Serializable
public final class b {
    public static final C0173b Companion = null;
    public final float a;
    public final float b;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<b> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final juc.d<?>[] childSerializers() {
            l0 r1 = l0.a;
            return new juc.d[]{r1, r1};
        }

        public final f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.bytedance.bdnavigationsdk.pojo.Threshold.Dynamic", r0, 2);
            r1.j("projection_dist", true);
            r1.j("bearing_angle", true);
            b = r1;
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(e r10) {
            Intrinsics.checkNotNullParameter(r10, "decoder");
            g2 r0 = b;
            muc.c r11 = r10.beginStructure(r0);
            if (r11.decodeSequentially() == false) goto L5;
            float r1 = r11.decodeFloatElement(r0, 0);
            float r2 = r11.decodeFloatElement(r0, 1);
            int r3 = 3;
        L17:
            r11.endStructure(r0);
            return new b(r3, r1, r2);
        L5:
            r1 = 0.0f;
            float r4 = 0.0f;
            int r5 = 0;
            boolean r6 = true;
        L6:
            if (r6 == false) goto L16;
            int r7 = r11.decodeElementIndex(r0);
            if (r7 != (-1)) goto L9;
            r6 = false;
            goto L6
        L9:
            if (r7 != 0) goto L10;
            r1 = r11.decodeFloatElement(r0, 0);
            r5 = r5 | 1;
            goto L6
        L10:
            if (r7 != 1) goto L13;
            r4 = r11.decodeFloatElement(r0, 1);
            r5 = r5 | 2;
            goto L6
        L13:
            throw new UnknownFieldException(r7);
        L16:
            r2 = r4;
            r3 = r5;
            goto L17
        }

        public final void serialize(muc.f r6, Object r7) {
            b r8 = (b) r7;
            Intrinsics.checkNotNullParameter(r6, "encoder");
            Intrinsics.checkNotNullParameter(r8, "value");
            g2 r0 = b;
            muc.d r9 = r6.beginStructure(r0);
            C0173b r1 = b.Companion;
            boolean r2 = false;
            if (r9.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L12;
            r9.encodeFloatElement(r0, 0, r8.a);
        L12:
            if (r9.shouldEncodeElementDefault(r0, 1) == false) goto L15;
        L16:
            r2 = true;
        L17:
            if (r2 == false) goto L19;
            r9.encodeFloatElement(r0, 1, r8.b);
        L19:
            r9.endStructure(r0);
            return;
        L15:
            if (Float.compare(r8.b, 0.0f) == 0) goto L17;
        L6:
            if (Float.compare(r8.a, 0.0f) != 0) goto L7;
            r3 = false;
            goto L9
        }
    }

    /* JADX INFO: renamed from: t84.b$b, reason: collision with other inner class name */
    public static final class C0173b {
        public C0173b() {
        }

        public final juc.d<b> serializer() {
            return a.a;
        }
    }

    public b() {
        this(0.0f, 0.0f);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Float.compare(this.a, r6.a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.b, r6.b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b);
    }

    static {
        Companion = new C0173b();
    }

    public final String toString() {
        return "Dynamic{projectionDist=" + this.a + ", bearingAngle=" + this.b + "}";
    }

    public b(float r1, float r2) {
        this.a = r1;
        this.b = r2;
    }

    public b(int r3, float r4, float r5) {
        if ((r3 & 0) == 0) goto L5;
        b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        this.a = 0.0f;
    L9:
        if ((r3 & 2) != 0) goto L11;
        this.b = 0.0f;
        return;
    L11:
        this.b = r5;
        return;
    L7:
        this.a = r4;
        goto L9
    }
}
