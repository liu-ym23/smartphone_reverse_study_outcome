package com.ss.android.ugc.aweme.search.filter.view.component;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/view/component/FilterSingleSelectViewConfig;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FilterSingleSelectViewConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f453034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f453035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f453036c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof FilterSingleSelectViewConfig) == false) goto L12;
        FilterSingleSelectViewConfig r101 = (FilterSingleSelectViewConfig) r100;
        if (this.f453034a == r101.f453034a) goto L8;
        return false;
    L8:
        if (this.f453035b == r101.f453035b) goto L10;
        return false;
    L10:
        if (Float.compare(this.f453036c, r101.f453036c) == 0) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    public final int hashCode() {
        boolean r100 = this.f453034a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        boolean r104 = this.f453035b;
        if (r104 == true) goto L10;
        r101 = r104;
    L10:
        return ((r103 + r101) * 31) + Float.floatToIntBits(this.f453036c);
    }

    public final String toString() {
        return "FilterSingleSelectViewConfig(hasNullableItem=" + this.f453034a + ", supportBackGround=" + this.f453035b + ", horizonPadding=" + this.f453036c + ")";
    }

    public FilterSingleSelectViewConfig() {
        this(false, false, -1.0f);
    }

    public FilterSingleSelectViewConfig(boolean r100, boolean r101, float r102) {
        this.f453034a = r100;
        this.f453035b = r101;
        this.f453036c = r102;
    }
}
