package com.larus.gallery.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f343889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final nr9.g f343890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f343891c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f343892d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f343893e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f343894f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f343889a, r101.f343889a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f343890b, r101.f343890b) == true) goto L15;
        return false;
    L15:
        if (this.f343891c == r101.f343891c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f343892d, r101.f343892d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f343893e, r101.f343893e) == true) goto L24;
        return false;
    L24:
        if (this.f343894f == r101.f343894f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f343889a.hashCode() * 31;
        nr9.g r101 = this.f343890b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (((((((r100 + r102) * 31) + this.f343891c) * 31) + this.f343892d.hashCode()) * 31) + this.f343893e.hashCode()) * 31;
        if (this.f343894f == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "GalleryVideo(engineKey=" + this.f343889a + ", data=" + this.f343890b + ", startTime=" + this.f343891c + ", tag=" + this.f343892d + ", subTag=" + this.f343893e + ", preferVideoModel=" + this.f343894f + ')';
    }

    public /* synthetic */ q(String r100, nr9.g r101, int r110, String r111, String r112, int r113) {
        if ((r113 & 2) == 0) goto L5;
        r101 = null;
    L5:
        nr9.g r102 = r101;
        if ((r113 & 4) == 0) goto L8;
        int r103 = 0;
    L10:
        if ((r113 & 8) == 0) goto L12;
        String r104 = "";
    L14:
        if ((r113 & 16) == 0) goto L16;
        String r105 = "";
    L17:
        this(r100, r102, r103, r104, r105, false);
        return;
    L16:
        r105 = r112;
        goto L17
    L12:
        r104 = r111;
        goto L14
    L8:
        r103 = r110;
        goto L10
    }

    public q(String r100, nr9.g r101, int r102, String r103, String r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r100, "engineKey");
        Intrinsics.checkNotNullParameter(r103, "tag");
        Intrinsics.checkNotNullParameter(r104, "subTag");
        this.f343889a = r100;
        this.f343890b = r101;
        this.f343891c = r102;
        this.f343892d = r103;
        this.f343893e = r104;
        this.f343894f = r105;
    }
}
