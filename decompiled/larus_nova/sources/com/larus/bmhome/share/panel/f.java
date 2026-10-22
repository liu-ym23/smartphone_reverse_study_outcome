package com.larus.bmhome.share.panel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f313897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f313898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f313899c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f313897a, r101.f313897a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f313898b, r101.f313898b) == true) goto L15;
        return false;
    L15:
        if (this.f313899c == r101.f313899c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f313897a.hashCode() * 31) + this.f313898b.hashCode()) * 31) + this.f313899c;
    }

    public final String toString() {
        return "ManualImageMetadataInfo(produceId=" + this.f313897a + ", produceIdType=" + this.f313898b + ", messageCount=" + this.f313899c + ')';
    }

    public f(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "produceId");
        Intrinsics.checkNotNullParameter(r101, "produceIdType");
        this.f313897a = r100;
        this.f313898b = r101;
        this.f313899c = r102;
    }
}
