package com.larus.platform.service.watermark;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f365843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f365844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DownloadWatermarkScene f365845c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f365843a, r101.f365843a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f365844b, r101.f365844b) == true) goto L15;
        return false;
    L15:
        if (this.f365845c == r101.f365845c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f365843a.hashCode() * 31;
        String r101 = this.f365844b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return ((r100 + r102) * 31) + this.f365845c.hashCode();
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "FileWatermarkRequest(localFilePath=" + this.f365843a + ", mimeType=" + this.f365844b + ", scene=" + this.f365845c + ')';
    }

    public a(String r100, String r101, DownloadWatermarkScene r102) {
        Intrinsics.checkNotNullParameter(r100, "localFilePath");
        Intrinsics.checkNotNullParameter(r102, "scene");
        this.f365843a = r100;
        this.f365844b = r101;
        this.f365845c = r102;
    }
}
