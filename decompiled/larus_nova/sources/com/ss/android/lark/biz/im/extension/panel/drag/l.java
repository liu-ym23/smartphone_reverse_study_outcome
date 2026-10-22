package com.ss.android.lark.biz.im.extension.panel.drag;

import com.larus.nova.R;

/* JADX INFO: loaded from: classes34.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f410548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f410549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f410550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f410551d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof l) == true) goto L8;
        return false;
    L8:
        l r101 = (l) r100;
        if (this.f410548a == r101.f410548a) goto L12;
        return false;
    L12:
        if (Float.compare(this.f410549b, r101.f410549b) == 0) goto L15;
        return false;
    L15:
        if (this.f410550c == r101.f410550c) goto L18;
        return false;
    L18:
        if (this.f410551d == r101.f410551d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f410548a * 31) + Float.floatToIntBits(this.f410549b)) * 31) + this.f410550c) * 31;
        if (this.f410551d == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "PanelBackgroundConfig(solidColorRes=" + this.f410548a + ", topRadius=" + this.f410549b + ", navigationHeight=" + this.f410550c + ", showTopShadow=" + this.f410551d + ')';
    }

    public l(float r100, int r101) {
        this.f410548a = R.color.bg_body;
        this.f410549b = r100;
        this.f410550c = r101;
        this.f410551d = true;
    }
}
