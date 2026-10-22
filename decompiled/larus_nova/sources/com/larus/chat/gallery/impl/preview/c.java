package com.larus.chat.gallery.impl.preview;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f324218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f324219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f324220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f324221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f324222e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f324223f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f324224g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f324225h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f324226i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f324227j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f324218a == r101.f324218a) goto L12;
        return false;
    L12:
        if (this.f324219b == r101.f324219b) goto L15;
        return false;
    L15:
        if (this.f324220c == r101.f324220c) goto L18;
        return false;
    L18:
        if (this.f324221d == r101.f324221d) goto L21;
        return false;
    L21:
        if (this.f324222e == r101.f324222e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f324223f, r101.f324223f) == true) goto L27;
        return false;
    L27:
        if (this.f324224g == r101.f324224g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f324225h, r101.f324225h) == true) goto L33;
        return false;
    L33:
        if (this.f324226i == r101.f324226i) goto L36;
        return false;
    L36:
        if (this.f324227j == r101.f324227j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f324218a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f324219b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f324220c == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.f324221d == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.f324222e == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        Boolean r111 = this.f324223f;
        int r112 = 0;
        if (r111 != null) goto L25;
        int r113 = 0;
    L26:
        int r114 = (r110 + r113) * 31;
        if (this.f324224g == false) goto L29;
        int r115 = 1231;
    L30:
        int r116 = (r114 + r115) * 31;
        Boolean r117 = this.f324225h;
        if (r117 == null) goto L34;
        r112 = r117.hashCode();
    L34:
        int r118 = (r116 + r112) * 31;
        if (this.f324226i == false) goto L37;
        int r119 = 1231;
    L38:
        int r120 = (r118 + r119) * 31;
        if (this.f324227j == true) goto L43;
        r100 = 1237;
    L43:
        return r120 + r100;
    L37:
        r119 = 1237;
        goto L38
    L29:
        r115 = 1237;
        goto L30
    L25:
        r113 = r111.hashCode();
        goto L26
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
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
        return "PreviewAlbumFlowPolicy(showPlusButton=" + this.f324218a + ", includeCurrentImage=" + this.f324219b + ", includeCurrentVideo=" + this.f324220c + ", fallbackToOriginImage=" + this.f324221d + ", includeCurrentRawImage=" + this.f324222e + ", supportVideo=" + this.f324223f + ", injectCurrentDraft=" + this.f324224g + ", useUnifiedPreview=" + this.f324225h + ", registerSingleResult=" + this.f324226i + ", closeOnAlbumSend=" + this.f324227j + ')';
    }

    public c(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, Boolean r105, boolean r106, Boolean r107, boolean r108, boolean r110) {
        this.f324218a = r100;
        this.f324219b = r101;
        this.f324220c = r102;
        this.f324221d = r103;
        this.f324222e = r104;
        this.f324223f = r105;
        this.f324224g = r106;
        this.f324225h = r107;
        this.f324226i = r108;
        this.f324227j = r110;
    }
}
