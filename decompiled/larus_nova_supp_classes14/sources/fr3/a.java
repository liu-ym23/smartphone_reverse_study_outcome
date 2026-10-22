package fr3;

import com.bytedance.android.ec.model.ECUrlModel;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class a<E> {
    public final int a;
    public final int b;
    public final int c;
    public final C0125a d;
    public final E e;

    /* JADX INFO: renamed from: fr3.a$a, reason: collision with other inner class name */
    public static final class C0125a {
        public static final C0125a e = null;
        public static final C0126a f = null;
        public final float a;
        public final float b;
        public final float c;
        public final float d;

        /* JADX INFO: renamed from: fr3.a$a$a, reason: collision with other inner class name */
        public static final class C0126a {
            public C0126a() {
            }

            public static C0125a a(er3.a r5) {
                if (r5 == null) goto L4;
                Float r1 = r5.c();
                float r2 = 0.0f;
                if (r1 == null) goto L8;
                float r3 = r1.floatValue();
            L9:
                Float r4 = r5.d();
                if (r4 == null) goto L12;
                float r6 = r4.floatValue();
            L13:
                Float r7 = r5.b();
                if (r7 == null) goto L16;
                float r8 = r7.floatValue();
            L17:
                Float r9 = r5.a();
                if (r9 == null) goto L21;
                r2 = r9.floatValue();
            L21:
                return new C0125a(r3, r6, r8, r2);
            L16:
                r8 = 0.0f;
                goto L17
            L12:
                r6 = 0.0f;
                goto L13
            L8:
                r3 = 0.0f;
                goto L9
            L4:
                return C0125a.e;
            }
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof C0125a) == false) goto L14;
            C0125a r4 = (C0125a) r3;
            if (Float.compare(this.a, r4.a) == 0) goto L8;
            return false;
        L8:
            if (Float.compare(this.b, r4.b) == 0) goto L10;
            return false;
        L10:
            if (Float.compare(this.c, r4.c) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.d, r4.d) == 0) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            return (((((Float.floatToIntBits(this.a) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d);
        }

        public final String toString() {
            return "CornerRadius(topLeft=" + this.a + ", topRight=" + this.b + ", bottomRight=" + this.c + ", bottomLeft=" + this.d + ")";
        }

        static {
            f = new C0126a();
            e = new C0125a(0.0f, 0.0f, 0.0f, 0.0f);
        }

        public final float[] a() {
            float r1 = this.a;
            float r2 = this.b;
            float r3 = this.c;
            float r4 = this.d;
            return new float[]{r1, r1, r2, r2, r3, r3, r4, r4};
        }

        public C0125a(float r1, float r2, float r3, float r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    public static final class b extends a<Unit> {
        public b(int r7) {
            C0125a.f.getClass();
            super(r7, 0, 0, C0125a.e, Unit.INSTANCE);
        }
    }

    public static final class c extends a<d> {
        public c(int r14, int r15, int r16, int r17, int r18, int r19, boolean r20, int r21, C0125a r22) {
            Intrinsics.checkNotNullParameter(r22, "cornerRadius");
            super(r14, r15, r21, r22, new d(r16, r17, r18, r19, r20, 2));
        }
    }

    public static final class d {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final boolean e;
        public final int f;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof d) == false) goto L18;
            d r4 = (d) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L12;
            return false;
        L12:
            if (this.d == r4.d) goto L14;
            return false;
        L14:
            if (this.e == r4.e) goto L16;
            return false;
        L16:
            if (this.f == r4.f) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v7 */
        public final int hashCode() {
            int r0 = ((((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31;
            boolean r1 = this.e;
            ?? r2 = r1;
            if (r1 == false) goto L6;
            r2 = 1;
        L6:
            return ((r0 + r2) * 31) + this.f;
        }

        public final String toString() {
            return "GroupExtra(verticalPadding=" + this.a + ", marginToTarget=" + this.b + ", marginToEdge=" + this.c + ", arrowHeight=" + this.d + ", clickOutDismiss=" + this.e + ", arrowTargetViewPercent=" + this.f + ")";
        }

        public d(int r1, int r2, int r3, int r4, boolean r5, int r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    public static final class e extends a<f> {
        public e(int r8, int r9, int r10, C0125a r11, ECUrlModel r12, C0125a r13) {
            Intrinsics.checkNotNullParameter(r11, "cornerRadius");
            Intrinsics.checkNotNullParameter(r12, "url");
            Intrinsics.checkNotNullParameter(r13, "imageCornerRadius");
            super(r8, r9, r10, r11, new f(r12, r13));
        }
    }

    public static final class f {
        public final ECUrlModel a;
        public final C0125a b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof f) == false) goto L10;
            f r4 = (f) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            ECUrlModel r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            C0125a r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "ImageExtra(url=" + this.a + ", imageCornerRadius=" + this.b + ")";
        }

        public f(ECUrlModel r2, C0125a r3) {
            Intrinsics.checkNotNullParameter(r2, "url");
            Intrinsics.checkNotNullParameter(r3, "imageCornerRadius");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class g extends a<h> {
        public g(int r8, int r9, int r10, C0125a r11, int r12, int r13, String r14, boolean r15) {
            Intrinsics.checkNotNullParameter(r11, "cornerRadius");
            Intrinsics.checkNotNullParameter(r14, "text");
            super(r8, r9, r10, r11, new h(r12, r13, r14, r15));
        }
    }

    public static final class h {
        public final int a;
        public final int b;
        public final String c;
        public final boolean d;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof h) == false) goto L14;
            h r4 = (h) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (this.b == r4.b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (this.d == r4.d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v8 */
        public final int hashCode() {
            int r0 = ((this.a * 31) + this.b) * 31;
            String r1 = this.c;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L6:
            int r3 = (r0 + r2) * 31;
            boolean r4 = this.d;
            ?? r5 = r4;
            if (r4 == false) goto L10;
            r5 = 1;
        L10:
            return r3 + r5;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "TextExtra(textSizeDp=" + this.a + ", textColor=" + this.b + ", text=" + this.c + ", bold=" + this.d + ")";
        }

        public h(int r2, int r3, String r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r4, "text");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(int r1, int r2, int r3, C0125a r4, Object r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
