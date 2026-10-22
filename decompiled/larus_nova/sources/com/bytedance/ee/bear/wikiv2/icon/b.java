package com.bytedance.ee.bear.wikiv2.icon;

import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f240963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f240964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f240965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f240966d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f240963a, r101.f240963a) == true) goto L12;
        return false;
    L12:
        if (this.f240964b == r101.f240964b) goto L15;
        return false;
    L15:
        if (this.f240965c == r101.f240965c) goto L18;
        return false;
    L18:
        if (this.f240966d == r101.f240966d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f240963a.hashCode() * 31) + this.f240964b) * 31) + this.f240965c) * 31) + this.f240966d;
    }

    public final String toString() {
        return "WikiSpaceIconViewConfig(imageView=" + this.f240963a + ", defaultCustomIcon=" + this.f240964b + ", viewWidth=" + this.f240965c + ", viewHeight=" + this.f240966d + ')';
    }

    public b(ImageView r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "imageView");
        this.f240963a = r100;
        this.f240964b = r101;
        this.f240965c = r102;
        this.f240966d = r103;
    }
}
