package tn;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public abstract class a<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f546835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f546836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f546837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C7744a f546838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final E f546839e;

    /* JADX INFO: renamed from: tn.a$a, reason: collision with other inner class name */
    public static final class C7744a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final C7744a f546840e = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f546841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f546842b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f546843c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f546844d;

        /* JADX INFO: renamed from: tn.a$a$a, reason: collision with other inner class name */
        public static final class C7745a {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C7744a) == false) goto L14;
            C7744a r101 = (C7744a) r100;
            if (Float.compare(this.f546841a, r101.f546841a) == 0) goto L8;
            return false;
        L8:
            if (Float.compare(this.f546842b, r101.f546842b) == 0) goto L10;
            return false;
        L10:
            if (Float.compare(this.f546843c, r101.f546843c) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f546844d, r101.f546844d) == 0) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            return (((((Float.floatToIntBits(this.f546841a) * 31) + Float.floatToIntBits(this.f546842b)) * 31) + Float.floatToIntBits(this.f546843c)) * 31) + Float.floatToIntBits(this.f546844d);
        }

        public final String toString() {
            return "CornerRadius(topLeft=" + this.f546841a + ", topRight=" + this.f546842b + ", bottomRight=" + this.f546843c + ", bottomLeft=" + this.f546844d + ")";
        }

        static {
            f546840e = new C7744a(0.0f, 0.0f, 0.0f, 0.0f);
        }

        public C7744a(float r100, float r101, float r102, float r103) {
            this.f546841a = r100;
            this.f546842b = r101;
            this.f546843c = r102;
            this.f546844d = r103;
        }
    }

    public static final class b extends a<Unit> {
        public b() {
            super(12, 0, 0, C7744a.f546840e, Unit.INSTANCE);
        }
    }

    public static final class c extends a<d> {
        public c(int r100, int r101, boolean r102, int r110, C7744a r111) {
            Intrinsics.checkNotNullParameter(r111, "cornerRadius");
            super(-2, -2, r110, r111, new d(r100, r101, r102));
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f546845a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f546846b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f546847c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f546848d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f546849e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f546850f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == false) goto L18;
            d r101 = (d) r100;
            if (this.f546845a == r101.f546845a) goto L8;
            return false;
        L8:
            if (this.f546846b == r101.f546846b) goto L10;
            return false;
        L10:
            if (this.f546847c == r101.f546847c) goto L12;
            return false;
        L12:
            if (this.f546848d == r101.f546848d) goto L14;
            return false;
        L14:
            if (this.f546849e == r101.f546849e) goto L16;
            return false;
        L16:
            if (this.f546850f == r101.f546850f) goto L28;
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
            int r100 = ((((((this.f546845a * 31) + this.f546846b) * 31) + this.f546847c) * 31) + this.f546848d) * 31;
            boolean r101 = this.f546849e;
            ?? r102 = r101;
            if (r101 == false) goto L6;
            r102 = 1;
        L6:
            return ((r100 + r102) * 31) + this.f546850f;
        }

        public final String toString() {
            return "GroupExtra(verticalPadding=" + this.f546845a + ", marginToTarget=" + this.f546846b + ", marginToEdge=" + this.f546847c + ", arrowHeight=" + this.f546848d + ", clickOutDismiss=" + this.f546849e + ", arrowTargetViewPercent=" + this.f546850f + ")";
        }

        public d(int r100, int r101, boolean r102) {
            this.f546845a = 11;
            this.f546846b = r100;
            this.f546847c = r101;
            this.f546848d = 7;
            this.f546849e = r102;
            this.f546850f = 2;
        }
    }

    public static final class e extends a<f> {
        public e(int r100, int r101, int r102, String r110, boolean r111) {
            C7744a r103 = C7744a.f546840e;
            Intrinsics.checkNotNullParameter(r103, "cornerRadius");
            Intrinsics.checkNotNullParameter(r110, "text");
            super(-2, r100, 0, r103, new f(r101, r102, r110, r111));
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f546851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f546852b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f546853c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f546854d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof f) == false) goto L14;
            f r101 = (f) r100;
            if (this.f546851a == r101.f546851a) goto L8;
            return false;
        L8:
            if (this.f546852b == r101.f546852b) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.f546853c, r101.f546853c) == true) goto L12;
            return false;
        L12:
            if (this.f546854d == r101.f546854d) goto L22;
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
            int r100 = ((this.f546851a * 31) + this.f546852b) * 31;
            String r101 = this.f546853c;
            if (r101 == null) goto L5;
            int r102 = r101.hashCode();
        L6:
            int r103 = (r100 + r102) * 31;
            boolean r104 = this.f546854d;
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
            return "TextExtra(textSizeDp=" + this.f546851a + ", textColor=" + this.f546852b + ", text=" + this.f546853c + ", bold=" + this.f546854d + ")";
        }

        public f(int r100, int r101, String r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r102, "text");
            this.f546851a = r100;
            this.f546852b = r101;
            this.f546853c = r102;
            this.f546854d = r103;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(int r100, int r101, int r102, C7744a r103, Object r104) {
        this.f546835a = r100;
        this.f546836b = r101;
        this.f546837c = r102;
        this.f546838d = r103;
        this.f546839e = r104;
    }
}
