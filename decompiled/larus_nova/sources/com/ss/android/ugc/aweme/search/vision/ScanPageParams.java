package com.ss.android.ugc.aweme.search.vision;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001d\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR \u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\bR \u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR \u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR \u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR \u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR \u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR \u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\b¨\u0006!"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/ScanPageParams;", "Ljava/io/Serializable;", "()V", "enterFromSecond", "", "getEnterFromSecond", "()Ljava/lang/String;", "setEnterFromSecond", "(Ljava/lang/String;)V", "isSearchButton", "setSearchButton", "middleInfoExtra", "getMiddleInfoExtra", "setMiddleInfoExtra", "photoSearchPreviousPage", "getPhotoSearchPreviousPage", "setPhotoSearchPreviousPage", "searchChannel", "getSearchChannel", "setSearchChannel", "searchEntrance", "getSearchEntrance", "setSearchEntrance", "searchEntranceStyle", "getSearchEntranceStyle", "setSearchEntranceStyle", "searchType", "getSearchType", "setSearchType", "shopId", "getShopId", "setShopId", "Companion", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScanPageParams implements Serializable {
    public static final Companion Companion = null;
    public static final String TAG = "ScanPageParams";

    @SerializedName(ECFindSimilarConfig.ENTER_FROM_SECOND)
    private String enterFromSecond;

    @SerializedName("is_search_button")
    private String isSearchButton;

    @SerializedName("middleInfoExtra")
    private String middleInfoExtra;

    @SerializedName(ECFindSimilarConfig.PHOTO_SEARCH_PREVIOUS_PAGE)
    private String photoSearchPreviousPage;

    @SerializedName("search_channel")
    private String searchChannel;

    @SerializedName("search_entrance")
    private String searchEntrance;

    @SerializedName("search_entrance_style")
    private String searchEntranceStyle;

    @SerializedName("search_type")
    private String searchType;

    @SerializedName(a.KEY_SHOP_ID)
    private String shopId;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/ScanPageParams$Companion;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Companion = new Companion(0);
    }

    public ScanPageParams() {
    }

    public final String getEnterFromSecond() {
        return this.enterFromSecond;
    }

    public final String getMiddleInfoExtra() {
        return this.middleInfoExtra;
    }

    public final String getPhotoSearchPreviousPage() {
        return this.photoSearchPreviousPage;
    }

    public final String getSearchChannel() {
        return this.searchChannel;
    }

    public final String getSearchEntrance() {
        return this.searchEntrance;
    }

    public final String getSearchEntranceStyle() {
        return this.searchEntranceStyle;
    }

    public final String getSearchType() {
        return this.searchType;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final String isSearchButton() {
        return this.isSearchButton;
    }

    public final void setEnterFromSecond(String r100) {
        this.enterFromSecond = r100;
    }

    public final void setMiddleInfoExtra(String r100) {
        this.middleInfoExtra = r100;
    }

    public final void setPhotoSearchPreviousPage(String r100) {
        this.photoSearchPreviousPage = r100;
    }

    public final void setSearchButton(String r100) {
        this.isSearchButton = r100;
    }

    public final void setSearchChannel(String r100) {
        this.searchChannel = r100;
    }

    public final void setSearchEntrance(String r100) {
        this.searchEntrance = r100;
    }

    public final void setSearchEntranceStyle(String r100) {
        this.searchEntranceStyle = r100;
    }

    public final void setSearchType(String r100) {
        this.searchType = r100;
    }

    public final void setShopId(String r100) {
        this.shopId = r100;
    }
}
