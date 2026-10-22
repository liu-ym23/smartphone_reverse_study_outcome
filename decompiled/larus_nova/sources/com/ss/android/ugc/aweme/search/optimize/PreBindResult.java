package com.ss.android.ugc.aweme.search.optimize;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/optimize/PreBindResult;", "", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PreBindResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f453351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f453352b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PreBindResult) == true) goto L8;
        return false;
    L8:
        PreBindResult r101 = (PreBindResult) r100;
        if (this.f453351a == r101.f453351a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f453352b, r101.f453352b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f453351a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = r100 * 31;
        String r102 = this.f453352b;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "PreBindResult(success=" + this.f453351a + ", msg=" + this.f453352b + ')';
    }

    public PreBindResult(boolean r100, String r101) {
        this.f453351a = r100;
        this.f453352b = r101;
    }
}
