package ev6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class j implements com.bytedance.locallife.live.goodsshelves.processor.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f474343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public k0 f474344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public z f474345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q f474346d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public q f474347e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public r f474348f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f474349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f474350b;

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
            if (this.f474349a == r101.f474349a) goto L12;
            return false;
        L12:
            if (Float.compare(this.f474350b, r101.f474350b) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f474349a == false) goto L5;
            int r100 = 1231;
        L7:
            return (r100 * 31) + Float.floatToIntBits(this.f474350b);
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "PropsUIData(visible=" + this.f474349a + ", height=" + this.f474350b + ')';
        }

        public a(int r100) {
            this.f474349a = true;
            this.f474350b = 76.0f;
        }
    }

    public j() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f474343a, r101.f474343a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474344b, r101.f474344b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474345c, r101.f474345c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474346d, r101.f474346d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f474347e, r101.f474347e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f474348f, r101.f474348f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        a r100 = this.f474343a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        k0 r104 = this.f474344b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        z r107 = this.f474345c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        q r110 = this.f474346d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        q r113 = this.f474347e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        r r116 = this.f474348f;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "ShelfProductContentUIData(propsUIData=" + this.f474343a + ", titleUIData=" + this.f474344b + ", poiUIData=" + this.f474345c + ", sellingLabelUIData=" + this.f474346d + ", rightLabelUIData=" + this.f474347e + ", lotteryUIData=" + this.f474348f + ')';
    }

    public j(int r100) {
        this.f474343a = null;
        this.f474344b = null;
        this.f474345c = null;
        this.f474346d = null;
        this.f474347e = null;
        this.f474348f = null;
    }
}
