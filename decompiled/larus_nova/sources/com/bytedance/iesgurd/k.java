package com.bytedance.iesgurd;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f250723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f250724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f250725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f250726d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L14;
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f250723a, r101.f250723a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f250724b, r101.f250724b) == true) goto L10;
        return false;
    L10:
        if (this.f250725c == r101.f250725c) goto L12;
        return false;
    L12:
        if (this.f250726d == r101.f250726d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f250723a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f250724b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        long r106 = this.f250725c;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.f250726d;
        return r107 + ((int) (r108 ^ (r108 >>> 32)));
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "IESGurdUpdateProgressInfo(accessKey=" + this.f250723a + ", channel=" + this.f250724b + ", totalSize=" + this.f250725c + ", currentSize=" + this.f250726d + ")";
    }

    public k(String r100, String r101, long r102, long r103) {
        this.f250723a = r100;
        this.f250724b = r101;
        this.f250725c = r102;
        this.f250726d = r103;
    }
}
