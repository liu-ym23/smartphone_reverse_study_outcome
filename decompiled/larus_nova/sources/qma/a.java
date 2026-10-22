package qma;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public abstract class a {

    /* JADX INFO: renamed from: qma.a$a, reason: collision with other inner class name */
    public static final class C7361a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f533925a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f533926b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f533927c;

        public C7361a() {
            this(0.0f, 7);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C7361a) == true) goto L8;
            return false;
        L8:
            C7361a r101 = (C7361a) r100;
            if (this.f533925a == r101.f533925a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(Float.valueOf(this.f533926b), Float.valueOf(r101.f533926b)) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(Float.valueOf(this.f533927c), Float.valueOf(r101.f533927c)) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f533925a * 31) + Float.floatToIntBits(this.f533926b)) * 31) + Float.floatToIntBits(this.f533927c);
        }

        public final String toString() {
            return "AeAnimator(mode=" + this.f533925a + ", easeLow=" + this.f533926b + ", easeHigh=" + this.f533927c + ')';
        }

        public C7361a(float r100, int r101) {
            if ((r101 & 2) == 0) goto L5;
            r100 = 0.0f;
        L5:
            this.f533925a = 0;
            this.f533926b = r100;
            this.f533927c = 0.0f;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f533928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f533929b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f533930c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f533931d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(Float.valueOf(this.f533928a), Float.valueOf(r101.f533928a)) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(Float.valueOf(this.f533929b), Float.valueOf(r101.f533929b)) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(Float.valueOf(this.f533930c), Float.valueOf(r101.f533930c)) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(Float.valueOf(this.f533931d), Float.valueOf(r101.f533931d)) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((Float.floatToIntBits(this.f533928a) * 31) + Float.floatToIntBits(this.f533929b)) * 31) + Float.floatToIntBits(this.f533930c)) * 31) + Float.floatToIntBits(this.f533931d);
        }

        public final String toString() {
            return "CubicBezier(x1=" + this.f533928a + ", y1=" + this.f533929b + ", x2=" + this.f533930c + ", y2=" + this.f533931d + ')';
        }

        public b(float r100, float r101, float r102) {
            this.f533928a = r100;
            this.f533929b = 0.0f;
            this.f533930c = r101;
            this.f533931d = r102;
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f533932a = null;

        static {
            f533932a = new c();
        }

        public c() {
        }
    }

    public a() {
    }
}
