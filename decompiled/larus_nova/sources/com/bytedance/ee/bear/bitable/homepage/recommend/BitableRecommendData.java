package com.bytedance.ee.bear.bitable.homepage.recommend;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0011\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J8\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\bHÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/recommend/BitableRecommendData;", "Lcom/bytedance/ee/util/io/NonProguard;", "hasMore", "", "contents", "", "Lcom/bytedance/ee/bear/bitable/homepage/recommend/BitableRecommendItemData;", "changeExtra", "", "<init>", "(Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;)V", "getHasMore", "()Ljava/lang/Boolean;", "setHasMore", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getContents", "()Ljava/util/List;", "setContents", "(Ljava/util/List;)V", "getChangeExtra", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;)Lcom/bytedance/ee/bear/bitable/homepage/recommend/BitableRecommendData;", "equals", "other", "", "hashCode", "", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableRecommendData implements NonProguard {

    @SerializedName("change_extra")
    private final String changeExtra;

    @SerializedName("contents")
    private List<BitableRecommendItemData> contents;

    @SerializedName("has_more")
    private Boolean hasMore;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BitableRecommendData copy$default(BitableRecommendData r100, Boolean r101, List r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.hasMore;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.contents;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.changeExtra;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Boolean component1() {
        return this.hasMore;
    }

    public final List<BitableRecommendItemData> component2() {
        return this.contents;
    }

    public final String component3() {
        return this.changeExtra;
    }

    public final BitableRecommendData copy(Boolean r100, List<BitableRecommendItemData> r101, String r102) {
        return new BitableRecommendData(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BitableRecommendData) == true) goto L8;
        return false;
    L8:
        BitableRecommendData r101 = (BitableRecommendData) r100;
        if (Intrinsics.areEqual(this.hasMore, r101.hasMore) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.contents, r101.contents) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.changeExtra, r101.changeExtra) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.hasMore;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<BitableRecommendItemData> r104 = this.contents;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.changeExtra;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "BitableRecommendData(hasMore=" + this.hasMore + ", contents=" + this.contents + ", changeExtra=" + this.changeExtra + ')';
    }

    public final String getChangeExtra() {
        return this.changeExtra;
    }

    public final List<BitableRecommendItemData> getContents() {
        return this.contents;
    }

    public final Boolean getHasMore() {
        return this.hasMore;
    }

    public final void setContents(List<BitableRecommendItemData> r100) {
        this.contents = r100;
    }

    public final void setHasMore(Boolean r100) {
        this.hasMore = r100;
    }

    public BitableRecommendData(Boolean r100, List<BitableRecommendItemData> r101, String r102) {
        this.hasMore = r100;
        this.contents = r101;
        this.changeExtra = r102;
    }
}
