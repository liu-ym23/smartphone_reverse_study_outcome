package com.bytedance.badger.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f199224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f199225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f199226c;

    public b0(String r100, Integer r101, String r102) {
        this.f199224a = r100;
        this.f199225b = r101;
        this.f199226c = r102;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b0) == false) goto L12;
        b0 r101 = (b0) r100;
        if (Intrinsics.areEqual(this.f199224a, r101.f199224a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f199225b, r101.f199225b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f199226c, r101.f199226c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f199224a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f199225b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f199226c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "FetchResult(openId=" + this.f199224a + ", errorCode=" + this.f199225b + ", errorMessage=" + this.f199226c + ")";
    }
}
