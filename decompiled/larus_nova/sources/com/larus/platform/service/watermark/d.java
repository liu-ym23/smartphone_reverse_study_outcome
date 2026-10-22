package com.larus.platform.service.watermark;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f365850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DownloadWatermarkScene f365851b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f365850a, r101.f365850a) == true) goto L12;
        return false;
    L12:
        if (this.f365851b == r101.f365851b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f365850a.hashCode() * 31) + this.f365851b.hashCode();
    }

    public final String toString() {
        return "UrlWatermarkRequest(sourceUrl=" + this.f365850a + ", scene=" + this.f365851b + ')';
    }

    public d(String r100, DownloadWatermarkScene r101) {
        Intrinsics.checkNotNullParameter(r100, "sourceUrl");
        Intrinsics.checkNotNullParameter(r101, "scene");
        this.f365850a = r100;
        this.f365851b = r101;
    }
}
