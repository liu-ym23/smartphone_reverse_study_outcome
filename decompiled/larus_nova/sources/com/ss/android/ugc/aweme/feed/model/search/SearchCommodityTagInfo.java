package com.ss.android.ugc.aweme.feed.model.search;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\u0010\b\u0003\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0003J[\u0010\u0014\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\u0010\b\u0003\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0012\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/ugc/aweme/feed/model/search/SearchCommodityTagInfo;", "Ljava/io/Serializable;", "icon", "", "labelName", "type", "", "id", "width", "height", "urlList", "", "(Ljava/lang/String;Ljava/lang/String;JJJJLjava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "", "toString", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class SearchCommodityTagInfo implements Serializable {

    @SerializedName("height")
    public long height;

    @SerializedName("icon")
    public String icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    public long f450816id;

    @SerializedName("text")
    public String labelName;

    @SerializedName("type")
    public long type;

    @SerializedName(ScoreTags.STAR_URL_LIST)
    public List<String> urlList;

    @SerializedName("width")
    public long width;

    public SearchCommodityTagInfo() {
        this(null, null, 0, 0, 0, 0, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchCommodityTagInfo copy$default(SearchCommodityTagInfo r110, String r111, String r112, long r113, long r114, long r115, long r210, List r211, int r212, Object r213) {
        if ((r212 & 1) == 0) goto L5;
        String r100 = r110.icon;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r101 = r110.labelName;
    L11:
        if ((r212 & 4) == 0) goto L13;
        long r102 = r110.type;
    L15:
        if ((r212 & 8) == 0) goto L17;
        long r103 = r110.f450816id;
    L19:
        if ((r212 & 16) == 0) goto L21;
        long r104 = r110.width;
    L23:
        if ((r212 & 32) == 0) goto L25;
        long r105 = r110.height;
    L27:
        if ((r212 & 64) == 0) goto L29;
        List r116 = r110.urlList;
    L31:
        return r110.copy(r100, r101, r102, r103, r104, r105, r116);
    L29:
        r116 = r211;
        goto L31
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.icon;
    }

    public final String component2() {
        return this.labelName;
    }

    public final long component3() {
        return this.type;
    }

    public final long component4() {
        return this.f450816id;
    }

    public final long component5() {
        return this.width;
    }

    public final long component6() {
        return this.height;
    }

    public final List<String> component7() {
        return this.urlList;
    }

    public final SearchCommodityTagInfo copy(String r110, String r111, long r112, long r113, long r210, long r211, List<String> r212) {
        return new SearchCommodityTagInfo(r110, r111, r112, r113, r210, r211, r212);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SearchCommodityTagInfo) == true) goto L8;
        return false;
    L8:
        SearchCommodityTagInfo r101 = (SearchCommodityTagInfo) r100;
        if (Intrinsics.areEqual(this.icon, r101.icon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.labelName, r101.labelName) == true) goto L15;
        return false;
    L15:
        if (this.type == r101.type) goto L18;
        return false;
    L18:
        if (this.f450816id == r101.f450816id) goto L21;
        return false;
    L21:
        if (this.width == r101.width) goto L24;
        return false;
    L24:
        if (this.height == r101.height) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.urlList, r101.urlList) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r100 = this.icon;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.labelName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        long r107 = this.type;
        int r108 = (r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31;
        long r109 = this.f450816id;
        int r110 = (r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31;
        long r111 = this.width;
        int r112 = (r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31;
        long r113 = this.height;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        List<String> r115 = this.urlList;
        if (r115 == null) goto L15;
        r101 = r115.hashCode();
    L15:
        return r114 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "SearchCommodityTagInfo(icon=" + this.icon + ", labelName=" + this.labelName + ", type=" + this.type + ", id=" + this.f450816id + ", width=" + this.width + ", height=" + this.height + ", urlList=" + this.urlList + ')';
    }

    public SearchCommodityTagInfo(String r100, String r101, long r102, long r103, long r104, long r105, List<String> r110) {
        this.icon = r100;
        this.labelName = r101;
        this.type = r102;
        this.f450816id = r103;
        this.width = r104;
        this.height = r105;
        this.urlList = r110;
    }

    public /* synthetic */ SearchCommodityTagInfo(String r110, String r111, long r112, long r113, long r114, long r210, List r211, int r212, DefaultConstructorMarker r213) {
        List r100 = null;
        if ((r212 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r212 & 2) == 0) goto L9;
        String r102 = null;
    L10:
        long r103 = 0;
        if ((r212 & 4) == 0) goto L13;
        long r104 = 0;
    L15:
        if ((r212 & 8) == 0) goto L17;
        long r105 = 0;
    L19:
        if ((r212 & 16) == 0) goto L21;
        long r115 = 0;
    L23:
        if ((r212 & 32) != 0) goto L27;
        r103 = r210;
    L27:
        if ((r212 & 64) != 0) goto L30;
        r100 = r211;
    L30:
        this(r101, r102, r104, r105, r115, r103, r100);
        return;
    L21:
        r115 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L10
    L5:
        r101 = r110;
        goto L7
    }
}
