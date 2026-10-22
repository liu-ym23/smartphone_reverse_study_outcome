package com.ss.android.ugc.aweme.discover.commodity.api.v3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.commodity.api.AladdinStruct;
import com.ss.android.ugc.aweme.discover.commodity.api.KiwiStruct;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015R \u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R&\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0013\"\u0004\b$\u0010\u0015R \u0010%\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R&\u0010+\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0013\"\u0004\b.\u0010\u0015R&\u0010/\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0013\"\u0004\b2\u0010\u0015¨\u00063"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/OuterCardLayer;", "Ljava/io/Serializable;", "()V", "aladdinInfo", "Lcom/ss/android/ugc/aweme/discover/commodity/api/AladdinStruct;", "getAladdinInfo", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/AladdinStruct;", "setAladdinInfo", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/AladdinStruct;)V", "bannerData", "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/BannerData;", "getBannerData", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/BannerData;", "setBannerData", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/BannerData;)V", "boxDetection", "", "", "getBoxDetection", "()Ljava/util/List;", "setBoxDetection", "(Ljava/util/List;)V", "feedSections", "", "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/FeedSection;", "getFeedSections", "setFeedSections", "kiwiInfo", "Lcom/ss/android/ugc/aweme/discover/commodity/api/KiwiStruct;", "getKiwiInfo", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/KiwiStruct;", "setKiwiInfo", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/KiwiStruct;)V", "productPreloadList", "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/ProductPreloadInfo;", "getProductPreloadList", "setProductPreloadList", "resultSection", "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/ResultSection;", "getResultSection", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/ResultSection;", "setResultSection", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/ResultSection;)V", "tabInfo", "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/ResultSectionConfig;", "getTabInfo", "setTabInfo", "videoQueryData", "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/VideoQueryData;", "getVideoQueryData", "setVideoQueryData", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OuterCardLayer implements Serializable {

    @SerializedName("aladdin_info")
    private AladdinStruct aladdinInfo;

    @SerializedName("banner_data")
    private BannerData bannerData;

    @SerializedName("box_detection")
    private List<String> boxDetection;

    @SerializedName("sections")
    private List<FeedSection> feedSections;

    @SerializedName("kiwi_info")
    private KiwiStruct kiwiInfo;

    @SerializedName("product_preload_list")
    private List<ProductPreloadInfo> productPreloadList;

    @SerializedName("image_search_tab_config")
    private ResultSection resultSection;

    @SerializedName("tab_info")
    private List<ResultSectionConfig> tabInfo;

    @SerializedName("multi_image_query_list")
    private List<VideoQueryData> videoQueryData;

    public OuterCardLayer() {
    }

    public final AladdinStruct getAladdinInfo() {
        return this.aladdinInfo;
    }

    public final BannerData getBannerData() {
        return this.bannerData;
    }

    public final List<String> getBoxDetection() {
        return this.boxDetection;
    }

    public final List<FeedSection> getFeedSections() {
        return this.feedSections;
    }

    public final KiwiStruct getKiwiInfo() {
        return this.kiwiInfo;
    }

    public final List<ProductPreloadInfo> getProductPreloadList() {
        return this.productPreloadList;
    }

    public final ResultSection getResultSection() {
        return this.resultSection;
    }

    public final List<ResultSectionConfig> getTabInfo() {
        return this.tabInfo;
    }

    public final List<VideoQueryData> getVideoQueryData() {
        return this.videoQueryData;
    }

    public final void setAladdinInfo(AladdinStruct r100) {
        this.aladdinInfo = r100;
    }

    public final void setBannerData(BannerData r100) {
        this.bannerData = r100;
    }

    public final void setBoxDetection(List<String> r100) {
        this.boxDetection = r100;
    }

    public final void setFeedSections(List<FeedSection> r100) {
        this.feedSections = r100;
    }

    public final void setKiwiInfo(KiwiStruct r100) {
        this.kiwiInfo = r100;
    }

    public final void setProductPreloadList(List<ProductPreloadInfo> r100) {
        this.productPreloadList = r100;
    }

    public final void setResultSection(ResultSection r100) {
        this.resultSection = r100;
    }

    public final void setTabInfo(List<ResultSectionConfig> r100) {
        this.tabInfo = r100;
    }

    public final void setVideoQueryData(List<VideoQueryData> r100) {
        this.videoQueryData = r100;
    }
}
