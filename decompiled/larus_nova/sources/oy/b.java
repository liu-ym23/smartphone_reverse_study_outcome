package oy;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Triple<Integer, Integer, String> f527098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LayoutConfigModel f527099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LayoutConfigModel.g f527100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LayoutConfigModel.b f527101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LayoutConfigModel.d f527102e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final mn0.a f527103f;

    public static final class a {
    }

    /* JADX INFO: renamed from: oy.b$b, reason: collision with other inner class name */
    public static final class C7126b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f527104a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f527105b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C7126b) == false) goto L10;
            C7126b r101 = (C7126b) r100;
            if (this.f527104a == r101.f527104a) goto L8;
            return false;
        L8:
            if (this.f527105b == r101.f527105b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            return (this.f527104a * 31) + this.f527105b;
        }

        public final String toString() {
            return "Position[" + this.f527104a + ", " + this.f527105b + ']';
        }

        public C7126b(int r100, int r101) {
            this.f527104a = r100;
            this.f527105b = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C7126b f527106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f527107b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L10;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f527106a, r101.f527106a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f527107b, r101.f527107b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            C7126b r100 = this.f527106a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            d r104 = this.f527107b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return this.f527107b + ", " + this.f527106a;
        }

        public c(C7126b r100, d r101) {
            Intrinsics.checkNotNullParameter(r100, "position");
            Intrinsics.checkNotNullParameter(r101, "size");
            this.f527106a = r100;
            this.f527107b = r101;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f527108a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f527109b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == false) goto L10;
            d r101 = (d) r100;
            if (this.f527108a == r101.f527108a) goto L8;
            return false;
        L8:
            if (this.f527109b == r101.f527109b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            return (this.f527108a * 31) + this.f527109b;
        }

        public final String toString() {
            return "Size[" + this.f527108a + ", " + this.f527109b + ']';
        }

        public d(int r100, int r101) {
            this.f527108a = r100;
            this.f527109b = r101;
        }
    }

    static {
    }

    public final c c(Pair r100) {
        int r101 = ((Number) r100.getFirst()).intValue();
        int r102 = ((Number) r100.getSecond()).intValue();
        this.f527103f.getClass();
        return new c(new C7126b(0, 0), new d(r101, r102));
    }

    public static d a(c r100, float r101) {
        boolean r102 = true;
        if (r101 > 1) goto L6;
        r102 = false;
    L6:
        if (r102 == false) goto L10;
        d r103 = r100.f527107b;
        int r104 = r103.f527109b;
        int r105 = (int) (r104 * r101);
        int r106 = r103.f527108a;
        if (r105 >= r106) goto L14;
        r104 = (int) (r106 / r101);
        r105 = r106;
    L14:
        return new d(r105, r104);
    L10:
        d r107 = r100.f527107b;
        r105 = r107.f527108a;
        r104 = (int) (r105 / r101);
        int r108 = r107.f527109b;
        if (r104 >= r108) goto L14;
        r105 = (int) (r108 * r101);
        r104 = r108;
        goto L14
    }

    public static d b(c r100, float r101) {
        boolean r102 = true;
        if (r101 > 1) goto L6;
        r102 = false;
    L6:
        if (r102 == false) goto L10;
        d r103 = r100.f527107b;
        int r104 = r103.f527108a;
        int r105 = (int) (r104 / r101);
        int r106 = r103.f527109b;
        if (r105 <= r106) goto L14;
        r104 = (int) (r106 * r101);
        r105 = r106;
    L14:
        return new d(r104, r105);
    L10:
        d r107 = r100.f527107b;
        r105 = r107.f527109b;
        r104 = (int) (r105 * r101);
        int r108 = r107.f527108a;
        if (r104 <= r108) goto L14;
        r105 = (int) (r108 / r101);
        r104 = r108;
        goto L14
    }

    public final C7126b d(d r110, c r111) {
        C7126b r100 = r111.f527106a;
        int r101 = r100.f527104a;
        int r102 = r100.f527105b;
        int r103 = this.f527099b.d();
        int r104 = this.f527099b.j();
        if (r103 == 5) goto L9;
        if (r103 == 2) goto L9;
        if (r103 == 8) goto L9;
        if (r103 == 4) goto L9;
        if (r103 == 6) goto L9;
    L36:
        if (r103 == 1) goto L39;
        if (r103 == 3) goto L39;
        if (r103 == 2) goto L39;
    L41:
        if (r103 == 9) goto L44;
        if (r103 == 3) goto L44;
        if (r103 == 6) goto L44;
    L46:
        return new C7126b(r101, r102);
    L44:
        r101 = r101 + (r111.f527107b.f527108a - r110.f527108a);
    L39:
        r102 = r102 + (r111.f527107b.f527109b - r110.f527109b);
    L9:
        if (r104 != 1) goto L22;
        int r105 = r110.f527108a;
        d r112 = r111.f527107b;
        int r113 = r112.f527108a;
        if (r105 >= r113) goto L16;
        if (r103 == 5) goto L15;
        if (r103 == 2) goto L15;
        if (r103 != 8) goto L16;
    L15:
        r101 = r101 + ((int) ((r113 - r105) / 2.0f));
    L16:
        int r106 = r110.f527109b;
        int r107 = r112.f527109b;
        if (r106 >= r107) goto L36;
        if (r103 == 5) goto L34;
        if (r103 == 4) goto L34;
        if (r103 != 6) goto L36;
    L34:
        r102 = r102 + ((int) ((r107 - r106) / 2.0f));
        goto L36
    L22:
        if (r104 != 2) goto L36;
        int r108 = r110.f527108a;
        d r114 = r111.f527107b;
        int r115 = r114.f527108a;
        if (r108 <= r115) goto L29;
        if (r103 == 5) goto L28;
        if (r103 == 2) goto L28;
        if (r103 != 8) goto L29;
    L28:
        r101 = r101 + ((int) ((r115 - r108) / 2.0f));
    L29:
        r106 = r110.f527109b;
        r107 = r114.f527109b;
        if (r106 <= r107) goto L36;
        if (r103 == 5) goto L34;
        if (r103 == 4) goto L34;
        if (r103 != 6) goto L36;
        goto L34
    }

    public final c e(c r100, LayoutConfigModel.g r101) {
        C7126b r102 = r100.f527106a;
        int r103 = r102.f527104a;
        int r104 = r102.f527105b;
        d r105 = r100.f527107b;
        int r106 = r105.f527108a;
        int r107 = r105.f527109b;
        float r108 = this.f527098a.getSecond().intValue() / Math.max(s1.w(), this.f527098a.getSecond().intValue());
        if (r101.e() <= 0) goto L6;
        int r109 = (int) (s1.f(r101.e()) * r108);
        r107 = r107 - r109;
        r104 = r104 + r109;
    L6:
        if (r101.b() <= 0) goto L9;
        r107 = r107 - ((int) (s1.f(r101.b()) * r108));
    L9:
        if (r101.c() <= 0) goto L12;
        int r110 = (int) (s1.f(r101.c()) * r108);
        r106 = r106 - r110;
        r103 = r103 + r110;
    L12:
        if (r101.d() <= 0) goto L15;
        r106 = r106 - ((int) (s1.f(r101.d()) * r108));
    L15:
        return new c(new C7126b(r103, r104), new d(r106, r107));
    }

    public b(Triple<Integer, Integer, String> r100, LayoutConfigModel r101, LayoutConfigModel.g r102, LayoutConfigModel.b r103, LayoutConfigModel.d r104, mn0.a r105) {
        Intrinsics.checkNotNullParameter(r100, "absContainerWHAndReason");
        Intrinsics.checkNotNullParameter(r101, "layoutConfig");
        Intrinsics.checkNotNullParameter(r102, "uiMarginParams");
        Intrinsics.checkNotNullParameter(r103, "canvasParams");
        Intrinsics.checkNotNullParameter(r104, "contentParams");
        Intrinsics.checkNotNullParameter(r105, "configParams");
        this.f527098a = r100;
        this.f527099b = r101;
        this.f527100c = r102;
        this.f527101d = r103;
        this.f527102e = r104;
        this.f527103f = r105;
    }
}
