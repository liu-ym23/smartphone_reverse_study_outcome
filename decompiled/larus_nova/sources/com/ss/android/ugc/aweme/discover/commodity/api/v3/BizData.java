package com.ss.android.ugc.aweme.discover.commodity.api.v3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.discover.commodity.api.InstantInfo;
import com.ss.android.ugc.aweme.discover.commodity.api.JumpToPageConfig;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010!\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R \u0010'\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R \u0010-\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R \u00103\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R \u00109\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R,\u0010?\u001a\u0010\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020B\u0018\u00010@8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006G"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/BizData;", "Ljava/io/Serializable;", "()V", "basicInfo", "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/BasicInfo;", "getBasicInfo", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/BasicInfo;", "setBasicInfo", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/BasicInfo;)V", "cardConfig", "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/CardConfig;", "getCardConfig", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/CardConfig;", "setCardConfig", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/CardConfig;)V", "clientAiConfig", "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/ClientAiConfig;", "getClientAiConfig", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/ClientAiConfig;", "setClientAiConfig", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/ClientAiConfig;)V", "emptyConfig", "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/EmptyConfig;", "getEmptyConfig", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/EmptyConfig;", "setEmptyConfig", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/EmptyConfig;)V", "extraInfo", "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/ExtraInfo;", "getExtraInfo", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/ExtraInfo;", "setExtraInfo", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/ExtraInfo;)V", "imageAiWords", "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/ImageAiWords;", "getImageAiWords", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/ImageAiWords;", "setImageAiWords", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/ImageAiWords;)V", "instantInfo", "Lcom/ss/android/ugc/aweme/discover/commodity/api/InstantInfo;", "getInstantInfo", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/InstantInfo;", "setInstantInfo", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/InstantInfo;)V", "jumpToPageConfig", "Lcom/ss/android/ugc/aweme/discover/commodity/api/JumpToPageConfig;", "getJumpToPageConfig", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/JumpToPageConfig;", "setJumpToPageConfig", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/JumpToPageConfig;)V", "loadMoreConfig", "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/LoadMoreConfig;", "getLoadMoreConfig", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/LoadMoreConfig;", "setLoadMoreConfig", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/LoadMoreConfig;)V", "searchMarketingInfo", "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/SearchMarketingInfo;", "getSearchMarketingInfo", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/SearchMarketingInfo;", "setSearchMarketingInfo", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/SearchMarketingInfo;)V", "sectionConfig", "", "", "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/SectionConfig;", "getSectionConfig", "()Ljava/util/Map;", "setSectionConfig", "(Ljava/util/Map;)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BizData implements Serializable {

    @SerializedName("basic_info")
    private BasicInfo basicInfo;

    @SerializedName("card_config")
    private CardConfig cardConfig;

    @SerializedName("client_ai_config")
    private ClientAiConfig clientAiConfig;

    @SerializedName("empty_config")
    private EmptyConfig emptyConfig;

    @SerializedName("extra_info")
    private ExtraInfo extraInfo;

    @SerializedName("image_ai_words")
    private ImageAiWords imageAiWords;

    @SerializedName("instant_info")
    private InstantInfo instantInfo;

    @SerializedName("jump_to_page_config")
    private JumpToPageConfig jumpToPageConfig;

    @SerializedName("load_more_config")
    private LoadMoreConfig loadMoreConfig;

    @SerializedName("search_marketing_info")
    private SearchMarketingInfo searchMarketingInfo;

    @SerializedName("section_config")
    private Map<String, SectionConfig> sectionConfig;

    public BizData() {
    }

    public final BasicInfo getBasicInfo() {
        return this.basicInfo;
    }

    public final CardConfig getCardConfig() {
        return this.cardConfig;
    }

    public final ClientAiConfig getClientAiConfig() {
        return this.clientAiConfig;
    }

    public final EmptyConfig getEmptyConfig() {
        return this.emptyConfig;
    }

    public final ExtraInfo getExtraInfo() {
        return this.extraInfo;
    }

    public final ImageAiWords getImageAiWords() {
        return this.imageAiWords;
    }

    public final InstantInfo getInstantInfo() {
        return this.instantInfo;
    }

    public final JumpToPageConfig getJumpToPageConfig() {
        return this.jumpToPageConfig;
    }

    public final LoadMoreConfig getLoadMoreConfig() {
        return this.loadMoreConfig;
    }

    public final SearchMarketingInfo getSearchMarketingInfo() {
        return this.searchMarketingInfo;
    }

    public final Map<String, SectionConfig> getSectionConfig() {
        return this.sectionConfig;
    }

    public final void setBasicInfo(BasicInfo r100) {
        this.basicInfo = r100;
    }

    public final void setCardConfig(CardConfig r100) {
        this.cardConfig = r100;
    }

    public final void setClientAiConfig(ClientAiConfig r100) {
        this.clientAiConfig = r100;
    }

    public final void setEmptyConfig(EmptyConfig r100) {
        this.emptyConfig = r100;
    }

    public final void setExtraInfo(ExtraInfo r100) {
        this.extraInfo = r100;
    }

    public final void setImageAiWords(ImageAiWords r100) {
        this.imageAiWords = r100;
    }

    public final void setInstantInfo(InstantInfo r100) {
        this.instantInfo = r100;
    }

    public final void setJumpToPageConfig(JumpToPageConfig r100) {
        this.jumpToPageConfig = r100;
    }

    public final void setLoadMoreConfig(LoadMoreConfig r100) {
        this.loadMoreConfig = r100;
    }

    public final void setSearchMarketingInfo(SearchMarketingInfo r100) {
        this.searchMarketingInfo = r100;
    }

    public final void setSectionConfig(Map<String, SectionConfig> r100) {
        this.sectionConfig = r100;
    }
}
