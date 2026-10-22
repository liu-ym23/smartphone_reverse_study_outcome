package com.ss.android.lark.widget.photo.preview.ocr;

import android.graphics.Point;
import android.graphics.Rect;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f447077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f447078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Point> f447079c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f447077a, r101.f447077a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f447078b, r101.f447078b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f447079c, r101.f447079c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f447077a.hashCode() * 31) + this.f447078b.hashCode()) * 31) + this.f447079c.hashCode();
    }

    public final String toString() {
        return "TextElement(text=" + this.f447077a + ", boundingBox=" + this.f447078b + ", cornerPoints=" + this.f447079c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(String r100, Rect r101, List<? extends Point> r102) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "boundingBox");
        Intrinsics.checkNotNullParameter(r102, "cornerPoints");
        this.f447077a = r100;
        this.f447078b = r101;
        this.f447079c = r102;
    }
}
