package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/SearchSuggestWordItem;", "", "params", "Lcom/bytedance/android/shopping/api/mall/model/SearchSuggestWordParams;", "words", "", "Lcom/bytedance/android/shopping/api/mall/model/SearchSuggestWordData;", "(Lcom/bytedance/android/shopping/api/mall/model/SearchSuggestWordParams;Ljava/util/List;)V", "getParams", "()Lcom/bytedance/android/shopping/api/mall/model/SearchSuggestWordParams;", "getWords", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchSuggestWordItem {

    @SerializedName("params")
    private final SearchSuggestWordParams params;

    @SerializedName("words")
    private final List<SearchSuggestWordData> words;

    /* JADX WARN: Multi-variable type inference failed */
    public SearchSuggestWordItem() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchSuggestWordItem copy$default(SearchSuggestWordItem r0, SearchSuggestWordParams r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.params;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.words;
    L9:
        return r0.copy(r1, r2);
    }

    public final SearchSuggestWordParams component1() {
        return this.params;
    }

    public final List<SearchSuggestWordData> component2() {
        return this.words;
    }

    public final SearchSuggestWordItem copy(SearchSuggestWordParams r2, List<SearchSuggestWordData> r3) {
        return new SearchSuggestWordItem(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof SearchSuggestWordItem) == false) goto L10;
        SearchSuggestWordItem r4 = (SearchSuggestWordItem) r3;
        if (Intrinsics.areEqual(this.params, r4.params) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.words, r4.words) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        SearchSuggestWordParams r0 = this.params;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<SearchSuggestWordData> r4 = this.words;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "SearchSuggestWordItem(params=" + this.params + ", words=" + this.words + ")";
    }

    public final SearchSuggestWordParams getParams() {
        return this.params;
    }

    public final List<SearchSuggestWordData> getWords() {
        return this.words;
    }

    public SearchSuggestWordItem(SearchSuggestWordParams r1, List<SearchSuggestWordData> r2) {
        this.params = r1;
        this.words = r2;
    }

    public /* synthetic */ SearchSuggestWordItem(SearchSuggestWordParams r2, List r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
