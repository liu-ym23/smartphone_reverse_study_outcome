package oi8;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.search.MoreInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J>\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00072\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/larus/bmhome/chat/search/SearchListData;", "", "searchResult", "Lcom/larus/bmhome/chat/search/SearchResult;", "queryParams", "Lcom/google/gson/JsonElement;", "hasMore", "", "moreInfo", "Lcom/larus/bmhome/chat/search/MoreInfo;", "<init>", "(Lcom/larus/bmhome/chat/search/SearchResult;Lcom/google/gson/JsonElement;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/search/MoreInfo;)V", "getSearchResult", "()Lcom/larus/bmhome/chat/search/SearchResult;", "setSearchResult", "(Lcom/larus/bmhome/chat/search/SearchResult;)V", "getQueryParams", "()Lcom/google/gson/JsonElement;", "getHasMore", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMoreInfo", "()Lcom/larus/bmhome/chat/search/MoreInfo;", "component1", "component2", "component3", "component4", "copy", "(Lcom/larus/bmhome/chat/search/SearchResult;Lcom/google/gson/JsonElement;Ljava/lang/Boolean;Lcom/larus/bmhome/chat/search/MoreInfo;)Lcom/larus/bmhome/chat/search/SearchListData;", "equals", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k {

    @SerializedName("has_more")
    private final Boolean hasMore;

    @SerializedName("ext")
    private final MoreInfo moreInfo;

    @SerializedName("query_params")
    private final JsonElement queryParams;

    @SerializedName("search_result")
    private com.larus.bmhome.chat.search.b searchResult;

    public k() {
        this(null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.searchResult, r101.searchResult) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.queryParams, r101.queryParams) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.hasMore, r101.hasMore) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.moreInfo, r101.moreInfo) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        com.larus.bmhome.chat.search.b r100 = this.searchResult;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        JsonElement r104 = this.queryParams;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.hasMore;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        MoreInfo r110 = this.moreInfo;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SearchListData(searchResult=" + this.searchResult + ", queryParams=" + this.queryParams + ", hasMore=" + this.hasMore + ", moreInfo=" + this.moreInfo + ')';
    }

    public final Boolean b() {
        return this.hasMore;
    }

    public final MoreInfo c() {
        return this.moreInfo;
    }

    public final JsonElement d() {
        return this.queryParams;
    }

    public final com.larus.bmhome.chat.search.b e() {
        return this.searchResult;
    }

    public final void f(com.larus.bmhome.chat.search.b r100) {
        this.searchResult = r100;
    }

    public /* synthetic */ k(Boolean r100, int r101) {
        if ((r101 & 4) == 0) goto L5;
        r100 = Boolean.FALSE;
    L5:
        this(null, null, r100, null);
    }

    public static k a(k r100, com.larus.bmhome.chat.search.b r101) {
        return new k(r101, r100.queryParams, r100.hasMore, r100.moreInfo);
    }

    public k(com.larus.bmhome.chat.search.b r100, JsonElement r101, Boolean r102, MoreInfo r103) {
        this.searchResult = r100;
        this.queryParams = r101;
        this.hasMore = r102;
        this.moreInfo = r103;
    }
}
