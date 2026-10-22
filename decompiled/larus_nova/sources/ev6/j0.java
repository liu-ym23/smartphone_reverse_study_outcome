package ev6;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f474351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f474352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Float f474353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Float f474354d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f474355e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Float f474356f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f474357g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float[] f474358h;

    public j0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j0) == true) goto L8;
        return false;
    L8:
        j0 r101 = (j0) r100;
        if (this.f474351a == r101.f474351a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f474352b, r101.f474352b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f474353c, r101.f474353c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f474354d, r101.f474354d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f474355e, r101.f474355e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f474356f, r101.f474356f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f474357g, r101.f474357g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f474358h, r101.f474358h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        if (this.f474351a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f474352b;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        Float r106 = this.f474353c;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        Float r109 = this.f474354d;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        String r112 = this.f474355e;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        Float r115 = this.f474356f;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        String r118 = this.f474357g;
        if (r118 != null) goto L29;
        int r119 = 0;
    L30:
        int r120 = (r117 + r119) * 31;
        float[] r121 = this.f474358h;
        if (r121 == null) goto L35;
        r103 = Arrays.hashCode(r121);
    L35:
        return r120 + r103;
    L29:
        r119 = r118.hashCode();
        goto L30
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "ShelfProductThirdPriceUIData(prefixImgVisible=" + this.f474351a + ", prefixImgUrl=" + this.f474352b + ", prefixImgWidth=" + this.f474353c + ", prefixImgHeight=" + this.f474354d + ", text=" + this.f474355e + ", textSize=" + this.f474356f + ", textColor=" + this.f474357g + ", textMargin=" + Arrays.toString(this.f474358h) + ')';
    }

    public j0(int r100) {
        this.f474351a = false;
        this.f474352b = null;
        this.f474353c = null;
        this.f474354d = null;
        this.f474355e = null;
        this.f474356f = null;
        this.f474357g = null;
        this.f474358h = null;
    }

    public final void a(Float r100) {
        this.f474354d = r100;
    }

    public final void b(String r100) {
        this.f474352b = r100;
    }

    public final void c(boolean r100) {
        this.f474351a = r100;
    }

    public final void d(Float r100) {
        this.f474353c = r100;
    }

    public final void e(String r100) {
        this.f474357g = r100;
    }

    public final void f(Float r100) {
        this.f474356f = r100;
    }
}
