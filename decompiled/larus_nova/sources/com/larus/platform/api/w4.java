package com.larus.platform.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class w4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f365311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f365312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f365313c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof w4) == true) goto L8;
        return false;
    L8:
        w4 r101 = (w4) r100;
        if (Intrinsics.areEqual(this.f365311a, r101.f365311a) == true) goto L12;
        return false;
    L12:
        if (this.f365312b == r101.f365312b) goto L15;
        return false;
    L15:
        if (this.f365313c == r101.f365313c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f365311a.hashCode() * 31;
        long r101 = this.f365312b;
        return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f365313c;
    }

    public final String toString() {
        return "PrefetchVideoResult(currentProcessStage=" + this.f365311a + ", timeStamp=" + this.f365312b + ", result=" + this.f365313c + ')';
    }

    public w4(String r100, long r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "currentProcessStage");
        this.f365311a = r100;
        this.f365312b = r101;
        this.f365313c = r102;
    }
}
