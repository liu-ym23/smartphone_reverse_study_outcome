package com.ss.android.ugc.aweme.discover.mixfeed;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ>\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0006HÖ\u0001R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\"\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\fR \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/mixfeed/SearchAdDynamicPatchData;", "Ljava/io/Serializable;", "creativeId", "", "adId", "logExtra", "", "groupId", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)V", "getAdId", "()Ljava/lang/Long;", "setAdId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getCreativeId", "setCreativeId", "getGroupId", "setGroupId", "getLogExtra", "()Ljava/lang/String;", "setLogExtra", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;)Lcom/ss/android/ugc/aweme/discover/mixfeed/SearchAdDynamicPatchData;", "equals", "", "other", "", "hashCode", "", "toString", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class SearchAdDynamicPatchData implements Serializable {

    @SerializedName("ad_id")
    private Long adId;

    @SerializedName("creative_id")
    private Long creativeId;

    @SerializedName("group_id")
    private Long groupId;

    @SerializedName("log_extra")
    private String logExtra;

    public SearchAdDynamicPatchData() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ SearchAdDynamicPatchData copy$default(SearchAdDynamicPatchData r100, Long r101, Long r102, String r103, Long r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.creativeId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.adId;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.logExtra;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.groupId;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final Long component1() {
        return this.creativeId;
    }

    public final Long component2() {
        return this.adId;
    }

    public final String component3() {
        return this.logExtra;
    }

    public final Long component4() {
        return this.groupId;
    }

    public final SearchAdDynamicPatchData copy(Long r100, Long r101, String r102, Long r103) {
        return new SearchAdDynamicPatchData(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SearchAdDynamicPatchData) == true) goto L8;
        return false;
    L8:
        SearchAdDynamicPatchData r101 = (SearchAdDynamicPatchData) r100;
        if (Intrinsics.areEqual(this.creativeId, r101.creativeId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.adId, r101.adId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.logExtra, r101.logExtra) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.groupId, r101.groupId) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Long r100 = this.creativeId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.adId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.logExtra;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.groupId;
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

    public String toString() {
        return "SearchAdDynamicPatchData(creativeId=" + this.creativeId + ", adId=" + this.adId + ", logExtra=" + this.logExtra + ", groupId=" + this.groupId + ')';
    }

    public final Long getAdId() {
        return this.adId;
    }

    public final Long getCreativeId() {
        return this.creativeId;
    }

    public final Long getGroupId() {
        return this.groupId;
    }

    public final String getLogExtra() {
        return this.logExtra;
    }

    public final void setAdId(Long r100) {
        this.adId = r100;
    }

    public final void setCreativeId(Long r100) {
        this.creativeId = r100;
    }

    public final void setGroupId(Long r100) {
        this.groupId = r100;
    }

    public final void setLogExtra(String r100) {
        this.logExtra = r100;
    }

    public SearchAdDynamicPatchData(Long r100, Long r101, String r102, Long r103) {
        this.creativeId = r100;
        this.adId = r101;
        this.logExtra = r102;
        this.groupId = r103;
    }

    public /* synthetic */ SearchAdDynamicPatchData(Long r100, Long r101, String r102, Long r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
