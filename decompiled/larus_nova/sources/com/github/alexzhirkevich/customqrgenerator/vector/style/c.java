package com.github.alexzhirkevich.customqrgenerator.vector.style;

import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f274272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.github.alexzhirkevich.customqrgenerator.style.a f274273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f274274c;

    public c() {
        this(0);
    }

    public final int hashCode() {
        Drawable r100 = this.f274272a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((r101 * 31) + this.f274273b.hashCode()) * 31) + this.f274274c.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "QrVectorBackground(drawable=" + this.f274272a + ", scale=" + this.f274273b + ", color=" + this.f274274c + ')';
    }

    public c(int r100) {
        com.github.alexzhirkevich.customqrgenerator.style.a.C3844a r101 = com.github.alexzhirkevich.customqrgenerator.style.a.C3844a.f274255a;
        e.b r102 = e.b.f274281a;
        Intrinsics.checkNotNullParameter(r101, "scale");
        Intrinsics.checkNotNullParameter(r102, "color");
        this.f274272a = null;
        this.f274273b = r101;
        this.f274274c = r102;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f274272a, r101.f274272a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f274273b, r101.f274273b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f274274c, r101.f274274c) == true) goto L17;
        return false;
    L17:
        return true;
    }
}
