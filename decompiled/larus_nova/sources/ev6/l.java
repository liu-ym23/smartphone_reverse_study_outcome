package ev6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f474362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f474363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f474364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f474365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f474366e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f474367f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f474368g;

    public l() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.f474362a == r101.f474362a) goto L12;
        return false;
    L12:
        if (Float.compare(this.f474363b, r101.f474363b) == 0) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474364c, r101.f474364c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474365d, r101.f474365d) == true) goto L21;
        return false;
    L21:
        if (this.f474366e == r101.f474366e) goto L24;
        return false;
    L24:
        if (this.f474367f == r101.f474367f) goto L27;
        return false;
    L27:
        if (this.f474368g == r101.f474368g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f474362a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + Float.floatToIntBits(this.f474363b)) * 31;
        String r103 = this.f474364c;
        int r104 = 0;
        if (r103 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r102 + r105) * 31;
        String r107 = this.f474365d;
        if (r107 == null) goto L14;
        r104 = r107.hashCode();
    L14:
        int r108 = (r106 + r104) * 31;
        if (this.f474366e == true) goto L18;
        r100 = 1237;
    L18:
        int r109 = (r108 + r100) * 31;
        long r110 = this.f474367f;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        long r112 = this.f474368g;
        return r111 + ((int) (r112 ^ (r112 >>> 32)));
    L9:
        r105 = r103.hashCode();
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ShelfProductFlashSaleUIData(progressVisible=" + this.f474362a + ", progressWidth=" + this.f474363b + ", progressUrl=" + this.f474364c + ", statusText=" + this.f474365d + ", countDownInfoVisible=" + this.f474366e + ", countDownStartTime=" + this.f474367f + ", countDownEndTime=" + this.f474368g + ')';
    }

    public final void f() {
        this.f474364c = "https://lf3-static.bytednsdoc.com/obj/eden-cn/nuvkvhoz/progress.png";
    }

    public final boolean a() {
        return this.f474362a;
    }

    public final float b() {
        return this.f474363b;
    }

    public l(int r100) {
        this.f474362a = false;
        this.f474363b = 46.0f;
        this.f474364c = null;
        this.f474365d = null;
        this.f474366e = false;
        this.f474367f = 0;
        this.f474368g = 0;
    }

    public final void c(long r100) {
        this.f474368g = r100;
    }

    public final void d(boolean r100) {
        this.f474366e = r100;
    }

    public final void e(long r100) {
        this.f474367f = r100;
    }

    public final void g(boolean r100) {
        this.f474362a = r100;
    }

    public final void h(float r100) {
        this.f474363b = r100;
    }

    public final void i(String r100) {
        this.f474365d = r100;
    }
}
