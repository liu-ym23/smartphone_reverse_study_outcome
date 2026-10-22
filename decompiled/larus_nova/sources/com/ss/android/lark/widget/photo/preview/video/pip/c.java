package com.ss.android.lark.widget.photo.preview.video.pip;

import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f447417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f447418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f447419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect f447420d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f447417a == r101.f447417a) goto L12;
        return false;
    L12:
        if (this.f447418b == r101.f447418b) goto L15;
        return false;
    L15:
        if (this.f447419c == r101.f447419c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f447420d, r101.f447420d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f447417a * 31) + this.f447418b) * 31;
        if (this.f447419c == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.f447420d.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "PipModeInfo(width=" + this.f447417a + ", height=" + this.f447418b + ", isVideoPlaying=" + this.f447419c + ", visibleRect=" + this.f447420d + ')';
    }

    public c(int r100, int r101, boolean r102, Rect r103) {
        Intrinsics.checkNotNullParameter(r103, "visibleRect");
        this.f447417a = r100;
        this.f447418b = r101;
        this.f447419c = r102;
        this.f447420d = r103;
    }
}
