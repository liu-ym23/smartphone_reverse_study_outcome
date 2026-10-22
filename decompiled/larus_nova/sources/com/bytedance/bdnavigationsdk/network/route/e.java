package com.bytedance.bdnavigationsdk.network.route;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.b2;
import nuc.g2;
import nuc.i2;
import nuc.l0;
import nuc.m0;

/* JADX INFO: loaded from: classes10.dex */
@Serializable
public final class e {
    public static final b Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f200219a;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements m0<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f200220a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g2 f200221b = null;

        public a() {
        }

        @Override // nuc.m0
        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{l0.f520731a};
        }

        @Override // juc.d, juc.n, juc.c
        public final luc.f getDescriptor() {
            return f200221b;
        }

        static {
            a r100 = new a();
            f200220a = r100;
            g2 r101 = new g2("com.bytedance.bdnavigationsdk.network.route.RouteCost", r100, 1);
            r101.j("duration", true);
            f200221b = r101;
        }

        @Override // nuc.m0
        public final juc.d<?>[] typeParametersSerializers() {
            return i2.f520710a;
        }

        @Override // juc.c
        public final Object deserialize(muc.e r100) {
            Intrinsics.checkNotNullParameter(r100, "decoder");
            g2 r101 = f200221b;
            muc.c r102 = r100.beginStructure(r101);
            int r103 = 1;
            if (r102.decodeSequentially() == false) goto L5;
            float r104 = r102.decodeFloatElement(r101, 0);
        L15:
            r102.endStructure(r101);
            return new e(r103, r104);
        L5:
            r104 = 0.0f;
            int r105 = 0;
        L6:
            if (r103 == 0) goto L14;
            int r106 = r102.decodeElementIndex(r101);
            if (r106 != (-1)) goto L9;
            r103 = 0;
            goto L6
        L9:
            if (r106 != 0) goto L12;
            r104 = r102.decodeFloatElement(r101, 0);
            r105 = r105 | 1;
            goto L6
        L12:
            throw new UnknownFieldException(r106);
        L14:
            r103 = r105;
            goto L15
        }

        @Override // juc.n
        public final void serialize(muc.f r100, Object r101) {
            e r102 = (e) r101;
            Intrinsics.checkNotNullParameter(r100, "encoder");
            Intrinsics.checkNotNullParameter(r102, "value");
            g2 r103 = f200221b;
            muc.d r104 = r100.beginStructure(r103);
            b r105 = e.Companion;
            if (r104.shouldEncodeElementDefault(r103, 0) == false) goto L6;
        L7:
            boolean r106 = true;
        L9:
            if (r106 == false) goto L11;
            r104.encodeFloatElement(r103, 0, r102.f200219a);
        L11:
            r104.endStructure(r103);
            return;
        L6:
            if (Float.compare(r102.f200219a, 0.0f) != 0) goto L7;
            r106 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<e> serializer() {
            return a.f200220a;
        }
    }

    public e() {
        this(0.0f);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L9;
        return false;
    L9:
        if (Float.compare(this.f200219a, ((e) r100).f200219a) == 0) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.f200219a);
    }

    static {
        Companion = new b();
    }

    public final String toString() {
        return "Cost{duration=" + this.f200219a + com.alipay.sdk.m.u.i.f25855d;
    }

    public e(float r100) {
        this.f200219a = r100;
    }

    public e(int r100, float r101) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, a.f200221b);
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.f200219a = 0.0f;
        return;
    L7:
        this.f200219a = r101;
    }
}
