package com.bytedance.android.shopping.api.mall.model;

import com.bytedance.android.shopping.buynow.data.model.ErrorPageButtonAction;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/SearchSuggestWordExtra;", "", "loadMore", "", ErrorPageButtonAction.REFRESH, "(Ljava/lang/String;Ljava/lang/String;)V", "getLoadMore", "()Ljava/lang/String;", "getRefresh", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchSuggestWordExtra {

    @SerializedName("load_frequency_according_to_loadmore")
    private final String loadMore;

    @SerializedName("load_frequency_according_to_refresh")
    private final String refresh;

    public SearchSuggestWordExtra() {
        String r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ SearchSuggestWordExtra copy$default(SearchSuggestWordExtra r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.loadMore;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.refresh;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.loadMore;
    }

    public final String component2() {
        return this.refresh;
    }

    public final SearchSuggestWordExtra copy(String r2, String r3) {
        return new SearchSuggestWordExtra(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof SearchSuggestWordExtra) == false) goto L10;
        SearchSuggestWordExtra r4 = (SearchSuggestWordExtra) r3;
        if (Intrinsics.areEqual(this.loadMore, r4.loadMore) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.refresh, r4.refresh) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        String r0 = this.loadMore;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.refresh;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "SearchSuggestWordExtra(loadMore=" + this.loadMore + ", refresh=" + this.refresh + ")";
    }

    public final String getLoadMore() {
        return this.loadMore;
    }

    public final String getRefresh() {
        return this.refresh;
    }

    public SearchSuggestWordExtra(String r1, String r2) {
        this.loadMore = r1;
        this.refresh = r2;
    }

    public /* synthetic */ SearchSuggestWordExtra(String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
