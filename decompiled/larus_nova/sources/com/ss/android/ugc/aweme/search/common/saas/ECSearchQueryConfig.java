package com.ss.android.ugc.aweme.search.common.saas;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/saas/ECSearchQueryConfig;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchQueryConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f451967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f451968b;

    public ECSearchQueryConfig() {
        this("", false);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECSearchQueryConfig) == false) goto L10;
        ECSearchQueryConfig r101 = (ECSearchQueryConfig) r100;
        if (Intrinsics.areEqual(this.f451967a, r101.f451967a) == true) goto L8;
        return false;
    L8:
        if (this.f451968b == r101.f451968b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        String r100 = this.f451967a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.f451968b;
        ?? r104 = r103;
        if (r103 == false) goto L10;
        r104 = 1;
    L10:
        return r102 + r104;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "ECSearchQueryConfig(query=" + this.f451967a + ", isHistSearch=" + this.f451968b + ")";
    }

    public ECSearchQueryConfig(String r100, boolean r101) {
        this.f451967a = r100;
        this.f451968b = r101;
    }
}
