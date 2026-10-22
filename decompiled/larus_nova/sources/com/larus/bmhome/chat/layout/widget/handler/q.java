package com.larus.bmhome.chat.layout.widget.handler;

import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f305059a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f305060b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f305061c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f305062d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (this.f305059a == r101.f305059a) goto L12;
        return false;
    L12:
        if (this.f305060b == r101.f305060b) goto L15;
        return false;
    L15:
        if (this.f305061c == r101.f305061c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f305062d, r101.f305062d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f305059a * 31) + this.f305060b) * 31) + this.f305061c) * 31;
        RectF r101 = this.f305062d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "TextViewConfig(textColor=" + this.f305059a + ", textSize=" + this.f305060b + ", lineHeight=" + this.f305061c + ", marginRectF=" + this.f305062d + ')';
    }

    public q(int r100, int r101, int r102, RectF r103) {
        this.f305059a = r100;
        this.f305060b = r101;
        this.f305061c = r102;
        this.f305062d = r103;
    }
}
