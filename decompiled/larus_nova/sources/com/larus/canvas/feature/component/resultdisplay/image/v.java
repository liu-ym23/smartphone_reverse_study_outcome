package com.larus.canvas.feature.component.resultdisplay.image;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CanvasSaveActionPlacement f323576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f323577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f323578c;

    public v() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v) == true) goto L8;
        return false;
    L8:
        v r101 = (v) r100;
        if (this.f323576a == r101.f323576a) goto L12;
        return false;
    L12:
        if (this.f323577b == r101.f323577b) goto L15;
        return false;
    L15:
        if (this.f323578c == r101.f323578c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f323576a.hashCode() * 31;
        int r101 = 1231;
        if (this.f323577b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f323578c == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ImageSaveActionUiState(placement=" + this.f323576a + ", visible=" + this.f323577b + ", allowResaveAfterSuccess=" + this.f323578c + ')';
    }

    public /* synthetic */ v(int r100) {
        this(CanvasSaveActionPlacement.TITLE_RIGHT, false, false);
    }

    public final boolean a(y r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (b(r100) == false) goto L13;
        w r101 = r100.f323681j;
        if (r101.f323580b == false) goto L13;
        if (r101.f323581c == true) goto L13;
        if (this.f323578c == false) goto L11;
    L12:
        return true;
    L11:
        if (r101.f323582d == false) goto L12;
    L13:
        return false;
    }

    public final boolean b(y r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (this.f323577b == true) goto L5;
    L11:
        return false;
    L5:
        if (this.f323576a != CanvasSaveActionPlacement.IMAGE_OVERLAY_BOTTOM_START) goto L11;
        if (r100.f323680i == false) goto L11;
        if (r100.f323681j.f323579a == false) goto L11;
        return true;
    }

    public v(CanvasSaveActionPlacement r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "placement");
        this.f323576a = r100;
        this.f323577b = r101;
        this.f323578c = r102;
    }
}
