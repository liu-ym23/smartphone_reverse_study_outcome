package com.ss.android.ugc.aweme.search.common.tab;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/tab/ECTabMobDataInfo;", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECTabMobDataInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f452207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f452208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f452209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f452210d;

    public ECTabMobDataInfo() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECTabMobDataInfo) == false) goto L14;
        ECTabMobDataInfo r101 = (ECTabMobDataInfo) r100;
        if (this.f452207a == r101.f452207a) goto L8;
        return false;
    L8:
        if (this.f452208b == r101.f452208b) goto L10;
        return false;
    L10:
        if (this.f452209c == r101.f452209c) goto L12;
        return false;
    L12:
        if (this.f452210d == r101.f452210d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    public final int hashCode() {
        boolean r100 = this.f452207a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f452208b;
        if (r104 == true) goto L10;
        r101 = r104;
    L10:
        return ((((r103 + r101) * 31) + this.f452209c) * 31) + this.f452210d;
    }

    public final String toString() {
        return "ECTabMobDataInfo(switchTabByUser=" + this.f452207a + ", switchTabSearch=" + this.f452208b + ", searchLastShowPageIndex=" + this.f452209c + ", lastTabIndex=" + this.f452210d + ")";
    }

    public ECTabMobDataInfo(int r100) {
        this.f452207a = true;
        this.f452208b = false;
        this.f452209c = 0;
        this.f452210d = 0;
    }
}
