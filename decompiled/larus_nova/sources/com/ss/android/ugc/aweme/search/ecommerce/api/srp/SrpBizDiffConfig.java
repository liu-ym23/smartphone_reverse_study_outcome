package com.ss.android.ugc.aweme.search.ecommerce.api.srp;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/ecommerce/api/srp/SrpBizDiffConfig;", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SrpBizDiffConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f452773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f452774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f452775c;

    public SrpBizDiffConfig() {
        this(true, false, true);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SrpBizDiffConfig) == false) goto L12;
        SrpBizDiffConfig r101 = (SrpBizDiffConfig) r100;
        if (this.f452773a == r101.f452773a) goto L8;
        return false;
    L8:
        if (this.f452774b == r101.f452774b) goto L10;
        return false;
    L10:
        if (this.f452775c == r101.f452775c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public final int hashCode() {
        boolean r100 = this.f452773a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f452774b;
        ?? r105 = r104;
        if (r104 == false) goto L8;
        r105 = 1;
    L8:
        int r106 = (r103 + r105) * 31;
        boolean r107 = this.f452775c;
        if (r107 == true) goto L13;
        r101 = r107;
    L13:
        return r106 + r101;
    }

    public final String toString() {
        return "SrpBizDiffConfig(isTabRequestEnable=" + this.f452773a + ", isUserLoginEnable=" + this.f452774b + ", isPageRecreateEnable=" + this.f452775c + ")";
    }

    public SrpBizDiffConfig(boolean r100, boolean r101, boolean r102) {
        this.f452773a = r100;
        this.f452774b = r101;
        this.f452775c = r102;
    }
}
