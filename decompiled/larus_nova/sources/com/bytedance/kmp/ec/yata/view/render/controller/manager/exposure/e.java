package com.bytedance.kmp.ec.yata.view.render.controller.manager.exposure;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f251878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f251879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f251880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f251881d;

    public e() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f251878a == r101.f251878a) goto L12;
        return false;
    L12:
        if (this.f251879b == r101.f251879b) goto L15;
        return false;
    L15:
        if (this.f251880c == r101.f251880c) goto L18;
        return false;
    L18:
        if (this.f251881d == r101.f251881d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f251878a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f251879b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f251880c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f251881d == true) goto L19;
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
        return "ExposureCheckConfig(checkContainerScrollChanged=" + this.f251878a + ", checkContainerLayoutChanged=" + this.f251879b + ", checkContainerVisibilityChanged=" + this.f251880c + ", checkContainerAttachStateChanged=" + this.f251881d + ')';
    }

    public e(int r100) {
        this.f251878a = false;
        this.f251879b = false;
        this.f251880c = false;
        this.f251881d = false;
    }
}
