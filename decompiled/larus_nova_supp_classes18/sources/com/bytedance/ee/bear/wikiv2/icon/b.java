package com.bytedance.ee.bear.wikiv2.icon;

import android.widget.ImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public final ImageView a;
    public final int b;
    public final int c;
    public final int d;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L8;
        return false;
    L8:
        b r6 = (b) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public final String toString() {
        return "WikiSpaceIconViewConfig(imageView=" + this.a + ", defaultCustomIcon=" + this.b + ", viewWidth=" + this.c + ", viewHeight=" + this.d + ')';
    }

    public b(ImageView r2, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r2, "imageView");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
