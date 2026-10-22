package com.larus.gallery.dialog;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class f0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f343931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f343932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.gallery.api.k f343933c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f0) == true) goto L8;
        return false;
    L8:
        f0 r101 = (f0) r100;
        if (this.f343931a == r101.f343931a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f343932b, r101.f343932b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f343933c, r101.f343933c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f343931a * 31;
        T r101 = this.f343932b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f343933c.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "MappedGalleryItem(originalPosition=" + this.f343931a + ", originalData=" + this.f343932b + ", displayData=" + this.f343933c + ')';
    }

    public f0(int r100, T r101, com.larus.gallery.api.k r102) {
        Intrinsics.checkNotNullParameter(r102, "displayData");
        this.f343931a = r100;
        this.f343932b = r101;
        this.f343933c = r102;
    }
}
