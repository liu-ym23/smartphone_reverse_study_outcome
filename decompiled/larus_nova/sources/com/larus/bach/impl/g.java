package com.larus.bach.impl;

import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f294830a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DetectType f294831b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f294830a, r101.f294830a) == true) goto L12;
        return false;
    L12:
        if (this.f294831b == r101.f294831b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f294830a.hashCode() * 31) + this.f294831b.hashCode();
    }

    public final String toString() {
        return "BachDetectTask(uri=" + this.f294830a + ", detectType=" + this.f294831b + ')';
    }

    public g(Uri r100, DetectType r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "detectType");
        this.f294830a = r100;
        this.f294831b = r101;
    }
}
