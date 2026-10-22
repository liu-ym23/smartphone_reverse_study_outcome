package com.ss.android.ugc.aweme.search.vision.result.content.card;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/result/content/card/SameProductQueryData;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SameProductQueryData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f453684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f453685b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SameProductQueryData) == false) goto L10;
        SameProductQueryData r101 = (SameProductQueryData) r100;
        if (Intrinsics.areEqual(this.f453684a, r101.f453684a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f453685b, r101.f453685b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f453684a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f453685b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SameProductQueryData(searchImageUrl=" + this.f453684a + ", productId=" + this.f453685b + ")";
    }

    public SameProductQueryData(String r100, String r101) {
        this.f453684a = r100;
        this.f453685b = r101;
    }
}
