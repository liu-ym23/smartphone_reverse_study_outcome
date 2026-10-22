package com.bytedance.live.layout;

import android.graphics.Matrix;
import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f255210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f255211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Matrix f255212c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f255210a, r101.f255210a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f255211b, r101.f255211b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f255212c, r101.f255212c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f255210a.hashCode() * 31) + this.f255211b.hashCode()) * 31) + this.f255212c.hashCode();
    }

    public final String toString() {
        return "LayoutResult(visibleArea=" + this.f255210a + ", playerArea=" + this.f255211b + ", girdMatrix=" + this.f255212c + ')';
    }

    public d(RectF r100, RectF r101, Matrix r102) {
        Intrinsics.checkNotNullParameter(r100, "visibleArea");
        Intrinsics.checkNotNullParameter(r101, "playerArea");
        Intrinsics.checkNotNullParameter(r102, "girdMatrix");
        this.f255210a = r100;
        this.f255211b = r101;
        this.f255212c = r102;
    }
}
