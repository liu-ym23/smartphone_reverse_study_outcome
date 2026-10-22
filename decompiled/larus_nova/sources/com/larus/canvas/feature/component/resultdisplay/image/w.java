package com.larus.canvas.feature.component.resultdisplay.image;

/* JADX INFO: loaded from: classes26.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f323579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f323580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f323581c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f323582d;

    public w() {
        this(false, false, false, false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w) == true) goto L8;
        return false;
    L8:
        w r101 = (w) r100;
        if (this.f323579a == r101.f323579a) goto L12;
        return false;
    L12:
        if (this.f323580b == r101.f323580b) goto L15;
        return false;
    L15:
        if (this.f323581c == r101.f323581c) goto L18;
        return false;
    L18:
        if (this.f323582d == r101.f323582d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f323579a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f323580b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f323581c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f323582d == true) goto L19;
        r100 = 1237;
    L19:
        return r106 + r100;
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ImageSavePageActionState(visible=" + this.f323579a + ", enabled=" + this.f323580b + ", loading=" + this.f323581c + ", saved=" + this.f323582d + ')';
    }

    public w(boolean r100, boolean r101, boolean r102, boolean r103) {
        this.f323579a = r100;
        this.f323580b = r101;
        this.f323581c = r102;
        this.f323582d = r103;
    }
}
