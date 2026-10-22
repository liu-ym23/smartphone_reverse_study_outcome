package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J9\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/SearchSuggestWordData;", "", "word", "", "wordType", "id", "params", "Lcom/bytedance/android/shopping/api/mall/model/SearchSuggestWordDataParams;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/api/mall/model/SearchSuggestWordDataParams;)V", "getId", "()Ljava/lang/String;", "getParams", "()Lcom/bytedance/android/shopping/api/mall/model/SearchSuggestWordDataParams;", "getWord", "getWordType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchSuggestWordData {

    @SerializedName("id")
    private final String id;

    @SerializedName("params")
    private final SearchSuggestWordDataParams params;

    @SerializedName("word")
    private final String word;

    @SerializedName("words_type")
    private final String wordType;

    public SearchSuggestWordData() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ SearchSuggestWordData copy$default(SearchSuggestWordData r0, String r1, String r2, String r3, SearchSuggestWordDataParams r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.word;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.wordType;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.id;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.params;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.word;
    }

    public final String component2() {
        return this.wordType;
    }

    public final String component3() {
        return this.id;
    }

    public final SearchSuggestWordDataParams component4() {
        return this.params;
    }

    public final SearchSuggestWordData copy(String r2, String r3, String r4, SearchSuggestWordDataParams r5) {
        return new SearchSuggestWordData(r2, r3, r4, r5);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof SearchSuggestWordData) == false) goto L14;
        SearchSuggestWordData r4 = (SearchSuggestWordData) r3;
        if (Intrinsics.areEqual(this.word, r4.word) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.wordType, r4.wordType) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.id, r4.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.params, r4.params) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r0 = this.word;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.wordType;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.id;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        SearchSuggestWordDataParams r10 = this.params;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "SearchSuggestWordData(word=" + this.word + ", wordType=" + this.wordType + ", id=" + this.id + ", params=" + this.params + ")";
    }

    public final String getId() {
        return this.id;
    }

    public final SearchSuggestWordDataParams getParams() {
        return this.params;
    }

    public final String getWord() {
        return this.word;
    }

    public final String getWordType() {
        return this.wordType;
    }

    public SearchSuggestWordData(String r1, String r2, String r3, SearchSuggestWordDataParams r4) {
        this.word = r1;
        this.wordType = r2;
        this.id = r3;
        this.params = r4;
    }

    public /* synthetic */ SearchSuggestWordData(String r2, String r3, String r4, SearchSuggestWordDataParams r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
