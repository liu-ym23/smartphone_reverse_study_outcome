package mn0;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.multilink.layoutconfig.model.LayoutConfigModel;
import java.util.List;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Triple<Integer, Integer, String> f514514a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f514515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f514516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f514517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LayoutConfigModel.g f514518e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final LayoutConfigModel.b f514519f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LayoutConfigModel.d f514520g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<LayoutConfigModel.e> f514521h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final nn0.a f514522i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final mn0.a f514523j;

    public static final class a {
    }

    /* JADX INFO: renamed from: mn0.b$b, reason: collision with other inner class name */
    public static final class C6834b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f514524a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f514525b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C6834b) == false) goto L10;
            C6834b r101 = (C6834b) r100;
            if (this.f514524a == r101.f514524a) goto L8;
            return false;
        L8:
            if (this.f514525b == r101.f514525b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            return (this.f514524a * 31) + this.f514525b;
        }

        public final String toString() {
            return "Position[" + this.f514524a + ", " + this.f514525b + ']';
        }

        public C6834b(int r100, int r101) {
            this.f514524a = r100;
            this.f514525b = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C6834b f514526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f514527b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L10;
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f514526a, r101.f514526a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f514527b, r101.f514527b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            C6834b r100 = this.f514526a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            d r104 = this.f514527b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return this.f514527b + ", " + this.f514526a;
        }

        public c(C6834b r100, d r101) {
            Intrinsics.checkNotNullParameter(r100, "position");
            Intrinsics.checkNotNullParameter(r101, "size");
            this.f514526a = r100;
            this.f514527b = r101;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f514528a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f514529b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == false) goto L10;
            d r101 = (d) r100;
            if (this.f514528a == r101.f514528a) goto L8;
            return false;
        L8:
            if (this.f514529b == r101.f514529b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            return (this.f514528a * 31) + this.f514529b;
        }

        public final String toString() {
            return "Size[" + this.f514528a + ", " + this.f514529b + ']';
        }

        public d(int r100, int r101) {
            this.f514528a = r100;
            this.f514529b = r101;
        }
    }

    static {
    }

    public final c c(Pair r100) {
        int r101 = ((Number) r100.getFirst()).intValue();
        int r102 = ((Number) r100.getSecond()).intValue();
        this.f514523j.getClass();
        return new c(new C6834b(0, 0), new d(r101, r102));
    }

    public static d a(c r100, float r101) {
        boolean r102 = true;
        if (r101 > 1) goto L6;
        r102 = false;
    L6:
        if (r102 == false) goto L10;
        d r103 = r100.f514527b;
        int r104 = r103.f514529b;
        int r105 = (int) (r104 * r101);
        int r106 = r103.f514528a;
        if (r105 >= r106) goto L14;
        r104 = (int) (r106 / r101);
        r105 = r106;
    L14:
        return new d(r105, r104);
    L10:
        d r107 = r100.f514527b;
        r105 = r107.f514528a;
        r104 = (int) (r105 / r101);
        int r108 = r107.f514529b;
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
        d r103 = r100.f514527b;
        int r104 = r103.f514528a;
        int r105 = (int) (r104 / r101);
        int r106 = r103.f514529b;
        if (r105 <= r106) goto L14;
        r104 = (int) (r106 * r101);
        r105 = r106;
    L14:
        return new d(r104, r105);
    L10:
        d r107 = r100.f514527b;
        r105 = r107.f514529b;
        r104 = (int) (r105 * r101);
        int r108 = r107.f514528a;
        if (r104 <= r108) goto L14;
        r105 = (int) (r108 / r101);
        r104 = r108;
        goto L14
    }

    public final C6834b d(d r110, c r111) {
        C6834b r100 = r111.f514526a;
        int r101 = r100.f514524a;
        int r102 = r100.f514525b;
        int r103 = this.f514517d;
        if (r103 == 5) goto L8;
        if (r103 == 2) goto L8;
        if (r103 == 8) goto L8;
        if (r103 == 4) goto L8;
        if (r103 == 6) goto L8;
    L36:
        if (r103 == 1) goto L39;
        if (r103 == 3) goto L39;
        if (r103 == 2) goto L39;
    L41:
        if (r103 == 9) goto L44;
        if (r103 == 3) goto L44;
        if (r103 == 6) goto L44;
    L46:
        return new C6834b(r101, r102);
    L44:
        r101 = r101 + (r111.f514527b.f514528a - r110.f514528a);
    L39:
        r102 = r102 + (r111.f514527b.f514529b - r110.f514529b);
    L8:
        int r104 = this.f514516c;
        if (r104 != 1) goto L22;
        int r105 = r110.f514528a;
        d r112 = r111.f514527b;
        int r113 = r112.f514528a;
        if (r105 >= r113) goto L16;
        if (r103 == 5) goto L15;
        if (r103 == 2) goto L15;
        if (r103 != 8) goto L16;
    L15:
        r101 = r101 + ((int) ((r113 - r105) / 2.0f));
    L16:
        int r106 = r110.f514529b;
        int r107 = r112.f514529b;
        if (r106 >= r107) goto L36;
        if (r103 == 5) goto L34;
        if (r103 == 4) goto L34;
        if (r103 != 6) goto L36;
    L34:
        r102 = r102 + ((int) ((r107 - r106) / 2.0f));
        goto L36
    L22:
        if (r104 != 2) goto L36;
        int r108 = r110.f514528a;
        d r114 = r111.f514527b;
        int r115 = r114.f514528a;
        if (r108 <= r115) goto L29;
        if (r103 == 5) goto L28;
        if (r103 == 2) goto L28;
        if (r103 != 8) goto L29;
    L28:
        r101 = r101 + ((int) ((r115 - r108) / 2.0f));
    L29:
        r106 = r110.f514529b;
        r107 = r114.f514529b;
        if (r106 <= r107) goto L36;
        if (r103 == 5) goto L34;
        if (r103 == 4) goto L34;
        if (r103 != 6) goto L36;
        goto L34
    }

    public final c e(c r100, LayoutConfigModel.g r101) {
        C6834b r102 = r100.f514526a;
        int r103 = r102.f514524a;
        int r104 = r102.f514525b;
        d r105 = r100.f514527b;
        int r106 = r105.f514528a;
        int r107 = r105.f514529b;
        float r108 = this.f514514a.getSecond().intValue() / RangesKt.coerceAtLeast(s1.w(), s1.y());
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
        return new c(new C6834b(r103, r104), new d(r106, r107));
    }

    public b(Triple<Integer, Integer, String> r100, int r101, int r102, int r103, LayoutConfigModel.g r104, LayoutConfigModel.b r105, LayoutConfigModel.d r106, List<LayoutConfigModel.e> r107, nn0.a r110, mn0.a r111) {
        Intrinsics.checkNotNullParameter(r100, "absContainerWHAndReason");
        Intrinsics.checkNotNullParameter(r104, "uiMarginParams");
        Intrinsics.checkNotNullParameter(r105, "canvasParams");
        Intrinsics.checkNotNullParameter(r106, "contentParams");
        Intrinsics.checkNotNullParameter(r107, "regionListParams");
        Intrinsics.checkNotNullParameter(r110, "monitorProvider");
        Intrinsics.checkNotNullParameter(r111, "configParams");
        this.f514514a = r100;
        this.f514515b = r101;
        this.f514516c = r102;
        this.f514517d = r103;
        this.f514518e = r104;
        this.f514519f = r105;
        this.f514520g = r106;
        this.f514521h = r107;
        this.f514522i = r110;
        this.f514523j = r111;
    }
}
