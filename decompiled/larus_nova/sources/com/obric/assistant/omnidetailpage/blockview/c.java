package com.obric.assistant.omnidetailpage.blockview;

import android.graphics.Rect;
import android.util.Size;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Size f390615a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Rect f390616b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f390615a, r101.f390615a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f390616b, r101.f390616b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f390615a.hashCode() * 31) + this.f390616b.hashCode();
    }

    public final String toString() {
        return "LocalMediaItemLayout(size=" + this.f390615a + ", margins=" + this.f390616b + ')';
    }

    public c(Size r100, Rect r101) {
        Intrinsics.checkNotNullParameter(r100, "size");
        Intrinsics.checkNotNullParameter(r101, "margins");
        this.f390615a = r100;
        this.f390616b = r101;
    }
}
