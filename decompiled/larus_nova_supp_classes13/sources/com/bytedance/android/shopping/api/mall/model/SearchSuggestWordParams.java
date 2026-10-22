package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/SearchSuggestWordParams;", "", "extra", "Lcom/bytedance/android/shopping/api/mall/model/SearchSuggestWordExtra;", "(Lcom/bytedance/android/shopping/api/mall/model/SearchSuggestWordExtra;)V", "getExtra", "()Lcom/bytedance/android/shopping/api/mall/model/SearchSuggestWordExtra;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchSuggestWordParams {

    @SerializedName("extra_info")
    private final SearchSuggestWordExtra extra;

    public SearchSuggestWordParams() {
        SearchSuggestWordExtra r0 = null;
        this(r0, 1, r0);
    }

    public static /* synthetic */ SearchSuggestWordParams copy$default(SearchSuggestWordParams r0, SearchSuggestWordExtra r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.extra;
    L6:
        return r0.copy(r1);
    }

    public final SearchSuggestWordExtra component1() {
        return this.extra;
    }

    public final SearchSuggestWordParams copy(SearchSuggestWordExtra r2) {
        return new SearchSuggestWordParams(r2);
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof SearchSuggestWordParams) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.extra, ((SearchSuggestWordParams) r2).extra) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public int hashCode() {
        SearchSuggestWordExtra r0 = this.extra;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.hashCode();
    }

    public String toString() {
        return "SearchSuggestWordParams(extra=" + this.extra + ")";
    }

    public final SearchSuggestWordExtra getExtra() {
        return this.extra;
    }

    public SearchSuggestWordParams(SearchSuggestWordExtra r1) {
        this.extra = r1;
    }

    public /* synthetic */ SearchSuggestWordParams(SearchSuggestWordExtra r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }
}
