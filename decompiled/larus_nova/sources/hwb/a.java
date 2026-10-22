package hwb;

import com.larus.nova.R;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f487430a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f487431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f487432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f487433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f487434e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f487435f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f487436g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f487437h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f487438i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f487430a == r101.f487430a) goto L12;
        return false;
    L12:
        if (this.f487431b == r101.f487431b) goto L15;
        return false;
    L15:
        if (this.f487432c == r101.f487432c) goto L18;
        return false;
    L18:
        if (this.f487433d == r101.f487433d) goto L21;
        return false;
    L21:
        if (this.f487434e == r101.f487434e) goto L24;
        return false;
    L24:
        if (Float.compare(this.f487435f, r101.f487435f) == 0) goto L27;
        return false;
    L27:
        if (Float.compare(this.f487436g, r101.f487436g) == 0) goto L30;
        return false;
    L30:
        if (Float.compare(this.f487437h, r101.f487437h) == 0) goto L33;
        return false;
    L33:
        if (Float.compare(this.f487438i, r101.f487438i) == 0) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((((this.f487430a * 31) + this.f487431b) * 31) + this.f487432c) * 31) + this.f487433d) * 31) + this.f487434e) * 31) + Float.floatToIntBits(this.f487435f)) * 31) + Float.floatToIntBits(this.f487436g)) * 31) + Float.floatToIntBits(this.f487437h)) * 31) + Float.floatToIntBits(this.f487438i);
    }

    public final String toString() {
        return "MmRecordingFloatContainerSpec(layoutRes=" + this.f487430a + ", contentContainerId=" + this.f487431b + ", sideHideContainerId=" + this.f487432c + ", leftArrowViewId=" + this.f487433d + ", rightArrowViewId=" + this.f487434e + ", contentWidthDp=" + this.f487435f + ", contentHeightDp=" + this.f487436g + ", shadowInsetDp=" + this.f487437h + ", sideHideButtonWidthDp=" + this.f487438i + ')';
    }

    public a(int r100) {
        this.f487430a = r100;
        this.f487431b = R.id.mm_float_content_view;
        this.f487432c = R.id.mm_side_hide_view_container;
        this.f487433d = R.id.mm_side_hide_left_arrow_view;
        this.f487434e = R.id.mm_side_hide_right_arrow_view;
        this.f487435f = 78.0f;
        this.f487436g = 96.0f;
        this.f487437h = 16.0f;
        this.f487438i = 24.0f;
    }
}
