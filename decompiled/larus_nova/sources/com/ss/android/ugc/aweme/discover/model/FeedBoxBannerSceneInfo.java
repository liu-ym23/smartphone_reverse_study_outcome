package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.model.commodity.select.SelectItemStatus;
import com.ss.android.ugc.aweme.framework.tab.TabFeedModel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003JJ\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/FeedBoxBannerSceneInfo;", "Ljava/io/Serializable;", "bannerSceneType", "", "headImgProductId", "", "searchForceInsertInfo", "switchTabInfo", "Lcom/ss/android/ugc/aweme/framework/tab/TabFeedModel;", "switchSortParams", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/SelectItemStatus;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/ugc/aweme/framework/tab/TabFeedModel;Lcom/ss/android/ugc/aweme/discover/model/commodity/select/SelectItemStatus;)V", "getBannerSceneType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeadImgProductId", "()Ljava/lang/String;", "getSearchForceInsertInfo", "getSwitchSortParams", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/select/SelectItemStatus;", "getSwitchTabInfo", "()Lcom/ss/android/ugc/aweme/framework/tab/TabFeedModel;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/ugc/aweme/framework/tab/TabFeedModel;Lcom/ss/android/ugc/aweme/discover/model/commodity/select/SelectItemStatus;)Lcom/ss/android/ugc/aweme/discover/model/FeedBoxBannerSceneInfo;", "equals", "", "other", "", "hashCode", "toString", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeedBoxBannerSceneInfo implements Serializable {

    @SerializedName("banner_scene_type")
    private final Integer bannerSceneType;

    @SerializedName("head_img_product_id")
    private final String headImgProductId;

    @SerializedName("search_force_insert_info")
    private final String searchForceInsertInfo;

    @SerializedName("switch_sort_params")
    private final SelectItemStatus switchSortParams;

    @SerializedName("switch_tab_info")
    private final TabFeedModel switchTabInfo;

    public FeedBoxBannerSceneInfo() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ FeedBoxBannerSceneInfo copy$default(FeedBoxBannerSceneInfo r100, Integer r101, String r102, String r103, TabFeedModel r104, SelectItemStatus r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.bannerSceneType;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.headImgProductId;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.searchForceInsertInfo;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.switchTabInfo;
    L14:
        TabFeedModel r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.switchSortParams;
    L17:
        Integer r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Integer component1() {
        return this.bannerSceneType;
    }

    public final String component2() {
        return this.headImgProductId;
    }

    public final String component3() {
        return this.searchForceInsertInfo;
    }

    public final TabFeedModel component4() {
        return this.switchTabInfo;
    }

    public final SelectItemStatus component5() {
        return this.switchSortParams;
    }

    public final FeedBoxBannerSceneInfo copy(Integer r100, String r101, String r110, TabFeedModel r111, SelectItemStatus r112) {
        return new FeedBoxBannerSceneInfo(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof FeedBoxBannerSceneInfo) == false) goto L16;
        FeedBoxBannerSceneInfo r101 = (FeedBoxBannerSceneInfo) r100;
        if (Intrinsics.areEqual(this.bannerSceneType, r101.bannerSceneType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.headImgProductId, r101.headImgProductId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.searchForceInsertInfo, r101.searchForceInsertInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.switchTabInfo, r101.switchTabInfo) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.switchSortParams, r101.switchSortParams) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        Integer r100 = this.bannerSceneType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.headImgProductId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.searchForceInsertInfo;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        TabFeedModel r110 = this.switchTabInfo;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        SelectItemStatus r113 = this.switchSortParams;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "FeedBoxBannerSceneInfo(bannerSceneType=" + this.bannerSceneType + ", headImgProductId=" + this.headImgProductId + ", searchForceInsertInfo=" + this.searchForceInsertInfo + ", switchTabInfo=" + this.switchTabInfo + ", switchSortParams=" + this.switchSortParams + ")";
    }

    public final Integer getBannerSceneType() {
        return this.bannerSceneType;
    }

    public final String getHeadImgProductId() {
        return this.headImgProductId;
    }

    public final String getSearchForceInsertInfo() {
        return this.searchForceInsertInfo;
    }

    public final SelectItemStatus getSwitchSortParams() {
        return this.switchSortParams;
    }

    public final TabFeedModel getSwitchTabInfo() {
        return this.switchTabInfo;
    }

    public FeedBoxBannerSceneInfo(Integer r100, String r101, String r102, TabFeedModel r103, SelectItemStatus r104) {
        this.bannerSceneType = r100;
        this.headImgProductId = r101;
        this.searchForceInsertInfo = r102;
        this.switchTabInfo = r103;
        this.switchSortParams = r104;
    }

    public /* synthetic */ FeedBoxBannerSceneInfo(Integer r100, String r101, String r102, TabFeedModel r103, SelectItemStatus r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        Integer r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        TabFeedModel r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        SelectItemStatus r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
