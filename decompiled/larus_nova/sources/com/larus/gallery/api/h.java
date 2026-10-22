package com.larus.gallery.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f343855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f343856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f343857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f343858d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f343855a, r101.f343855a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f343856b, r101.f343856b) == true) goto L15;
        return false;
    L15:
        if (this.f343857c == r101.f343857c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f343858d, r101.f343858d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f343855a.hashCode() * 31;
        String r101 = this.f343856b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        if (this.f343857c == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r104 + r105) * 31;
        Object r107 = this.f343858d;
        if (r107 == null) goto L15;
        r102 = r107.hashCode();
    L15:
        return r106 + r102;
    L9:
        r105 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "GalleryCustomData(key=" + this.f343855a + ", thumbUri=" + this.f343856b + ", showBlockedPlaceholder=" + this.f343857c + ", payload=" + this.f343858d + ')';
    }

    public h(String r100, String r101, boolean r102, kza.m r103) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f343855a = r100;
        this.f343856b = r101;
        this.f343857c = r102;
        this.f343858d = r103;
    }
}
