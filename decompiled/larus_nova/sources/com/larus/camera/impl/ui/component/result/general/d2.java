package com.larus.camera.impl.ui.component.result.general;

/* JADX INFO: loaded from: classes26.dex */
public final class d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f322246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f322247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f322248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f322249d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d2) == true) goto L8;
        return false;
    L8:
        d2 r101 = (d2) r100;
        if (this.f322246a == r101.f322246a) goto L12;
        return false;
    L12:
        if (this.f322247b == r101.f322247b) goto L15;
        return false;
    L15:
        if (this.f322248c == r101.f322248c) goto L18;
        return false;
    L18:
        if (this.f322249d == r101.f322249d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f322246a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f322247b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f322248c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f322249d == true) goto L19;
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
        return "ResultTitleEditState(redoEnabled=" + this.f322246a + ", undoEnabled=" + this.f322247b + ", inMarkSelectMode=" + this.f322248c + ", inCropMode=" + this.f322249d + ')';
    }

    public d2(boolean r100, boolean r101, boolean r102, boolean r103) {
        this.f322246a = r100;
        this.f322247b = r101;
        this.f322248c = r102;
        this.f322249d = r103;
    }
}
