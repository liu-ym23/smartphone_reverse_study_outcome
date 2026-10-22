package ev6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements com.bytedance.locallife.live.goodsshelves.processor.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f474288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f474289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f474290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f474291d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f474292a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f474293b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f474294c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f474295d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f474296e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f474297f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f474298g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f474299h;

        public a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Float.compare(this.f474292a, r101.f474292a) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f474293b, r101.f474293b) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.f474294c, r101.f474294c) == 0) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f474295d, r101.f474295d) == true) goto L21;
            return false;
        L21:
            if (Float.compare(this.f474296e, r101.f474296e) == 0) goto L24;
            return false;
        L24:
            if (Float.compare(this.f474297f, r101.f474297f) == 0) goto L27;
            return false;
        L27:
            if (Float.compare(this.f474298g, r101.f474298g) == 0) goto L30;
            return false;
        L30:
            if (Float.compare(this.f474299h, r101.f474299h) == 0) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            return (((((((((((((Float.floatToIntBits(this.f474292a) * 31) + Float.floatToIntBits(this.f474293b)) * 31) + Float.floatToIntBits(this.f474294c)) * 31) + this.f474295d.hashCode()) * 31) + Float.floatToIntBits(this.f474296e)) * 31) + Float.floatToIntBits(this.f474297f)) * 31) + Float.floatToIntBits(this.f474298g)) * 31) + Float.floatToIntBits(this.f474299h);
        }

        public final String toString() {
            return "PropsUIData(totalHeight=" + this.f474292a + ", marginBottom=" + this.f474293b + ", productHeight=" + this.f474294c + ", productBgColor=" + this.f474295d + ", leftTopRadius=" + this.f474296e + ", rightTopRadius=" + this.f474297f + ", leftBottomRadius=" + this.f474298g + ", rightBottomRadius=" + this.f474299h + ')';
        }

        public a(int r100) {
            Intrinsics.checkNotNullParameter("#FFFFFFFF", "productBgColor");
            this.f474292a = 136.0f;
            this.f474293b = 6.0f;
            this.f474294c = 136.0f;
            this.f474295d = "#FFFFFFFF";
            this.f474296e = 12.0f;
            this.f474297f = 12.0f;
            this.f474298g = 12.0f;
            this.f474299h = 12.0f;
        }
    }

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f474288a, r101.f474288a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474289b, r101.f474289b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474290c, r101.f474290c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474291d, r101.f474291d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        a r100 = this.f474288a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        c r104 = this.f474289b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        e r107 = this.f474290c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        h r110 = this.f474291d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ShelfContainerUIData(propsUIData=" + this.f474288a + ", brandUIData=" + this.f474289b + ", coreUIData=" + this.f474290c + ", industryUIData=" + this.f474291d + ')';
    }

    public d(int r100) {
        this.f474288a = null;
        this.f474289b = null;
        this.f474290c = null;
        this.f474291d = null;
    }
}
