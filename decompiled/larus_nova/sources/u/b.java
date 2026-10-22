package u;

import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
public final class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f548082h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f548083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f548084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f548085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f548086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<b> f548087e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f548088f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f548089g;

    public static final class a {
        public static Pair a(float[] r100, int r110) {
            Intrinsics.checkNotNullParameter(r100, "args");
            int r101 = r110 + 1;
            float r102 = r100[r110];
            int r111 = r101 + 1;
            float r103 = r100[r101];
            int r104 = r111 + 1;
            float r105 = r100[r111];
            int r112 = r104 + 1;
            float r106 = r100[r104];
            int r107 = r112 + 1;
            int r113 = (int) r100[r112];
            ArrayList r108 = new ArrayList();
            int r109 = 0;
        L3:
            if (r109 >= r113) goto L6;
            int r114 = b.f548082h;
            Pair r115 = a(r100, r107);
            int r116 = ((Number) r115.getFirst()).intValue();
            r108.add(r115.getSecond());
            r109 = r109 + 1;
            r107 = r116;
            goto L3
        L6:
            return new Pair(Integer.valueOf(r107), new b(r102, r103, r105, r106, r108, "", ""));
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Float.compare(this.f548083a, r101.f548083a) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f548084b, r101.f548084b) == 0) goto L15;
        return false;
    L15:
        if (Float.compare(this.f548085c, r101.f548085c) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.f548086d, r101.f548086d) == 0) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f548087e, r101.f548087e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f548088f, r101.f548088f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f548089g, r101.f548089g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        return (((((((((((Float.floatToIntBits(this.f548083a) * 31) + Float.floatToIntBits(this.f548084b)) * 31) + Float.floatToIntBits(this.f548085c)) * 31) + Float.floatToIntBits(this.f548086d)) * 31) + this.f548087e.hashCode()) * 31) + this.f548088f.hashCode()) * 31) + this.f548089g.hashCode();
    }

    public final String toString() {
        return "Layout(x=" + this.f548083a + ", y=" + this.f548084b + ", width=" + this.f548085c + ", height=" + this.f548086d + ", id='" + this.f548088f + "' idPath='" + this.f548089g + "')";
    }

    public b(float r100, float r101, float r102, float r103, List<b> r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r104, "children");
        Intrinsics.checkNotNullParameter(r105, "id");
        Intrinsics.checkNotNullParameter(r106, "idPath");
        this.f548083a = r100;
        this.f548084b = r101;
        this.f548085c = r102;
        this.f548086d = r103;
        this.f548087e = r104;
        this.f548088f = r105;
        this.f548089g = r106;
    }
}
