package com.bytedance.lark.lark_bitable_android;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f253066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f253067b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f253066a, r101.f253066a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f253067b, r101.f253067b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f253066a.hashCode() * 31) + this.f253067b.hashCode();
    }

    public final String toString() {
        return "BitableMarketplaceInstallResult(url=" + this.f253066a + ", baseAppToken=" + this.f253067b + ')';
    }

    public i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "baseAppToken");
        this.f253066a = r100;
        this.f253067b = r101;
    }
}
