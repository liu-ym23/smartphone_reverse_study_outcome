package fr3;

import com.bytedance.android.ec.model.ECUrlModel;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class a<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f478581a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f478582b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f478583c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C5943a f478584d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final E f478585e;

    /* JADX INFO: renamed from: fr3.a$a, reason: collision with other inner class name */
    public static final class C5943a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final C5943a f478586e = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final C5944a f478587f = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f478588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f478589b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f478590c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f478591d;

        /* JADX INFO: renamed from: fr3.a$a$a, reason: collision with other inner class name */
        public static final class C5944a {
            public C5944a() {
            }

            public static C5943a a(er3.a r100) {
                if (r100 == null) goto L4;
                Float r101 = r100.c();
                float r102 = 0.0f;
                if (r101 == null) goto L8;
                float r103 = r101.floatValue();
            L9:
                Float r104 = r100.d();
                if (r104 == null) goto L12;
                float r105 = r104.floatValue();
            L13:
                Float r106 = r100.b();
                if (r106 == null) goto L16;
                float r107 = r106.floatValue();
            L17:
                Float r108 = r100.a();
                if (r108 == null) goto L21;
                r102 = r108.floatValue();
            L21:
                return new C5943a(r103, r105, r107, r102);
            L16:
                r107 = 0.0f;
                goto L17
            L12:
                r105 = 0.0f;
                goto L13
            L8:
                r103 = 0.0f;
                goto L9
            L4:
                return C5943a.f478586e;
            }
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C5943a) == false) goto L14;
            C5943a r101 = (C5943a) r100;
            if (Float.compare(this.f478588a, r101.f478588a) == 0) goto L8;
            return false;
        L8:
            if (Float.compare(this.f478589b, r101.f478589b) == 0) goto L10;
            return false;
        L10:
            if (Float.compare(this.f478590c, r101.f478590c) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f478591d, r101.f478591d) == 0) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            return (((((Float.floatToIntBits(this.f478588a) * 31) + Float.floatToIntBits(this.f478589b)) * 31) + Float.floatToIntBits(this.f478590c)) * 31) + Float.floatToIntBits(this.f478591d);
        }

        public final String toString() {
            return "CornerRadius(topLeft=" + this.f478588a + ", topRight=" + this.f478589b + ", bottomRight=" + this.f478590c + ", bottomLeft=" + this.f478591d + ")";
        }

        static {
            f478587f = new C5944a();
            f478586e = new C5943a(0.0f, 0.0f, 0.0f, 0.0f);
        }

        public final float[] a() {
            float r100 = this.f478588a;
            float r101 = this.f478589b;
            float r102 = this.f478590c;
            float r103 = this.f478591d;
            return new float[]{r100, r100, r101, r101, r102, r102, r103, r103};
        }

        public C5943a(float r100, float r101, float r102, float r103) {
            this.f478588a = r100;
            this.f478589b = r101;
            this.f478590c = r102;
            this.f478591d = r103;
        }
    }

    public static final class b extends a<Unit> {
        public b(int r100) {
            C5943a.f478587f.getClass();
            super(r100, 0, 0, C5943a.f478586e, Unit.INSTANCE);
        }
    }

    public static final class c extends a<d> {
        public c(int r110, int r111, int r112, int r113, int r114, int r115, boolean r210, int r211, C5943a r212) {
            Intrinsics.checkNotNullParameter(r212, "cornerRadius");
            super(r110, r111, r211, r212, new d(r112, r113, r114, r115, r210, 2));
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f478592a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f478593b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f478594c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f478595d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f478596e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f478597f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == false) goto L18;
            d r101 = (d) r100;
            if (this.f478592a == r101.f478592a) goto L8;
            return false;
        L8:
            if (this.f478593b == r101.f478593b) goto L10;
            return false;
        L10:
            if (this.f478594c == r101.f478594c) goto L12;
            return false;
        L12:
            if (this.f478595d == r101.f478595d) goto L14;
            return false;
        L14:
            if (this.f478596e == r101.f478596e) goto L16;
            return false;
        L16:
            if (this.f478597f == r101.f478597f) goto L28;
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
            int r100 = ((((((this.f478592a * 31) + this.f478593b) * 31) + this.f478594c) * 31) + this.f478595d) * 31;
            boolean r101 = this.f478596e;
            ?? r102 = r101;
            if (r101 == false) goto L6;
            r102 = 1;
        L6:
            return ((r100 + r102) * 31) + this.f478597f;
        }

        public final String toString() {
            return "GroupExtra(verticalPadding=" + this.f478592a + ", marginToTarget=" + this.f478593b + ", marginToEdge=" + this.f478594c + ", arrowHeight=" + this.f478595d + ", clickOutDismiss=" + this.f478596e + ", arrowTargetViewPercent=" + this.f478597f + ")";
        }

        public d(int r100, int r101, int r102, int r103, boolean r104, int r105) {
            this.f478592a = r100;
            this.f478593b = r101;
            this.f478594c = r102;
            this.f478595d = r103;
            this.f478596e = r104;
            this.f478597f = r105;
        }
    }

    public static final class e extends a<f> {
        public e(int r100, int r101, int r110, C5943a r111, ECUrlModel r112, C5943a r113) {
            Intrinsics.checkNotNullParameter(r111, "cornerRadius");
            Intrinsics.checkNotNullParameter(r112, "url");
            Intrinsics.checkNotNullParameter(r113, "imageCornerRadius");
            super(r100, r101, r110, r111, new f(r112, r113));
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ECUrlModel f478598a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C5943a f478599b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof f) == false) goto L10;
            f r101 = (f) r100;
            if (Intrinsics.areEqual(this.f478598a, r101.f478598a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f478599b, r101.f478599b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            ECUrlModel r100 = this.f478598a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            C5943a r104 = this.f478599b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "ImageExtra(url=" + this.f478598a + ", imageCornerRadius=" + this.f478599b + ")";
        }

        public f(ECUrlModel r100, C5943a r101) {
            Intrinsics.checkNotNullParameter(r100, "url");
            Intrinsics.checkNotNullParameter(r101, "imageCornerRadius");
            this.f478598a = r100;
            this.f478599b = r101;
        }
    }

    public static final class g extends a<h> {
        public g(int r100, int r101, int r110, C5943a r111, int r112, int r113, String r114, boolean r115) {
            Intrinsics.checkNotNullParameter(r111, "cornerRadius");
            Intrinsics.checkNotNullParameter(r114, "text");
            super(r100, r101, r110, r111, new h(r112, r113, r114, r115));
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f478600a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f478601b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f478602c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f478603d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof h) == false) goto L14;
            h r101 = (h) r100;
            if (this.f478600a == r101.f478600a) goto L8;
            return false;
        L8:
            if (this.f478601b == r101.f478601b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f478602c, r101.f478602c) == true) goto L12;
            return false;
        L12:
            if (this.f478603d == r101.f478603d) goto L22;
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
            int r100 = ((this.f478600a * 31) + this.f478601b) * 31;
            String r101 = this.f478602c;
            if (r101 == null) goto L5;
            int r102 = r101.hashCode();
        L6:
            int r103 = (r100 + r102) * 31;
            boolean r104 = this.f478603d;
            ?? r105 = r104;
            if (r104 == false) goto L10;
            r105 = 1;
        L10:
            return r103 + r105;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "TextExtra(textSizeDp=" + this.f478600a + ", textColor=" + this.f478601b + ", text=" + this.f478602c + ", bold=" + this.f478603d + ")";
        }

        public h(int r100, int r101, String r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r102, "text");
            this.f478600a = r100;
            this.f478601b = r101;
            this.f478602c = r102;
            this.f478603d = r103;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(int r100, int r101, int r102, C5943a r103, Object r104) {
        this.f478581a = r100;
        this.f478582b = r101;
        this.f478583c = r102;
        this.f478584d = r103;
        this.f478585e = r104;
    }
}
