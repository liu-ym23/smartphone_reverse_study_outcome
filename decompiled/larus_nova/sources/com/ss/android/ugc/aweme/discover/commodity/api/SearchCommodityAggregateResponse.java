package com.ss.android.ugc.aweme.discover.commodity.api;

import com.bytedance.android.chunkstreamprediction.network.c;
import com.bytedance.android.chunkstreamprediction.network.d;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.discover.commodity.ECSearchApiResult;
import com.ss.android.ugc.aweme.discover.commodity.api.v3.ProductPreloadInfo;
import com.ss.android.ugc.aweme.discover.model.GoodsCardFrameStruct;
import com.ss.android.ugc.aweme.discover.model.SearchAggregateCommodity;
import com.ss.android.ugc.aweme.discover.model.globaldoodle.SearchBackgroundConfig;
import com.ss.android.ugc.aweme.feed.model.LogPbBean;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0002B\t¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00108\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010>\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR$\u0010D\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010?\u001a\u0004\bE\u0010A\"\u0004\bF\u0010CR\"\u0010G\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bG\u00109\u001a\u0004\bH\u0010;\"\u0004\bI\u0010=R,\u0010J\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bJ\u0010\u0012\u001a\u0004\bK\u0010\u0014\"\u0004\bL\u0010\u0016R$\u0010N\u001a\u0004\u0018\u00010M8F@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010U\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u0010\\\u001a\u0004\u0018\u00010[8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR$\u0010c\u001a\u0004\u0018\u00010b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bc\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR$\u0010j\u001a\u0004\u0018\u00010i8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR$\u0010q\u001a\u0004\u0018\u00010p8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR*\u0010|\u001a\n\u0012\u0004\u0012\u00020x\u0018\u00010w8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\by\u0010\u0012\u001a\u0004\bz\u0010\u0014\"\u0004\b{\u0010\u0016R(\u0010~\u001a\u0004\u0018\u00010}8\u0006@\u0006X\u0087\u000e¢\u0006\u0016\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R,\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0084\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R,\u0010\u008e\u0001\u001a\u0004\u0018\u00010[2\t\u0010\u008b\u0001\u001a\u0004\u0018\u00010[8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u008c\u0001\u0010_\"\u0005\b\u008d\u0001\u0010a¨\u0006\u0091\u0001"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/api/SearchCommodityAggregateResponse;", "Lcom/ss/android/ugc/aweme/discover/commodity/ECSearchApiResult;", "", "Lcom/bytedance/android/chunkstreamprediction/network/d;", "", "getListCount", "", "hasMore", "Lcom/bytedance/android/chunkstreamprediction/network/c;", "o", "", "setChunkReadingReport", "getChunkReadingReport", "", "getChunkType", "", "Lcom/ss/android/ugc/aweme/discover/model/SearchAggregateCommodity;", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "Lcom/ss/android/ugc/aweme/discover/commodity/api/ActionReportConfig;", "actionReportConfig", "Lcom/ss/android/ugc/aweme/discover/commodity/api/ActionReportConfig;", "getActionReportConfig", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/ActionReportConfig;", "setActionReportConfig", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/ActionReportConfig;)V", "Lcom/ss/android/ugc/aweme/discover/commodity/api/MarketingComponent;", "marketingComponent", "Lcom/ss/android/ugc/aweme/discover/commodity/api/MarketingComponent;", "getMarketingComponent", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/MarketingComponent;", "setMarketingComponent", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/MarketingComponent;)V", "Lcom/ss/android/ugc/aweme/discover/commodity/api/SuspensionItemsSection;", "suspensionItemsSection", "Lcom/ss/android/ugc/aweme/discover/commodity/api/SuspensionItemsSection;", "getSuspensionItemsSection", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/SuspensionItemsSection;", "setSuspensionItemsSection", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/SuspensionItemsSection;)V", "Lcom/ss/android/ugc/aweme/discover/commodity/api/JumpToPageConfig;", "jumpToPageConfig", "Lcom/ss/android/ugc/aweme/discover/commodity/api/JumpToPageConfig;", "getJumpToPageConfig", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/JumpToPageConfig;", "setJumpToPageConfig", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/JumpToPageConfig;)V", "Z", "getHasMore", "()Z", "setHasMore", "(Z)V", EffectConfiguration.KEY_CURSOR, "I", "getCursor", "()I", "setCursor", "(I)V", "ecomSearchPassThrough", "Ljava/lang/String;", "getEcomSearchPassThrough", "()Ljava/lang/String;", "setEcomSearchPassThrough", "(Ljava/lang/String;)V", "ecomSearchAllPassThrough", "getEcomSearchAllPassThrough", "setEcomSearchAllPassThrough", "resultType", "getResultType", "setResultType", "realTimePushOnCardItems", "getRealTimePushOnCardItems", "setRealTimePushOnCardItems", "Lcom/ss/android/ugc/aweme/discover/commodity/api/KiwiStruct;", "kiwiInfo", "Lcom/ss/android/ugc/aweme/discover/commodity/api/KiwiStruct;", "getKiwiInfo", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/KiwiStruct;", "setKiwiInfo", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/KiwiStruct;)V", "Lcom/ss/android/ugc/aweme/discover/commodity/api/AladdinStruct;", "aladdinInfo", "Lcom/ss/android/ugc/aweme/discover/commodity/api/AladdinStruct;", "getAladdinInfo", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/AladdinStruct;", "setAladdinInfo", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/AladdinStruct;)V", "Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SearchBackgroundConfig;", "searchBackgroundConfigOverride", "Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SearchBackgroundConfig;", "getSearchBackgroundConfigOverride", "()Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SearchBackgroundConfig;", "setSearchBackgroundConfigOverride", "(Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SearchBackgroundConfig;)V", "Lcom/ss/android/ugc/aweme/discover/commodity/api/ChunkInfo;", "chunkInfo", "Lcom/ss/android/ugc/aweme/discover/commodity/api/ChunkInfo;", "getChunkInfo", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/ChunkInfo;", "setChunkInfo", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/ChunkInfo;)V", "Lcom/ss/android/ugc/aweme/discover/commodity/api/InstantInfo;", "instantInfo", "Lcom/ss/android/ugc/aweme/discover/commodity/api/InstantInfo;", "getInstantInfo", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/InstantInfo;", "setInstantInfo", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/InstantInfo;)V", "Lcom/ss/android/ugc/aweme/discover/commodity/api/AddressComponent;", "addressComponent", "Lcom/ss/android/ugc/aweme/discover/commodity/api/AddressComponent;", "getAddressComponent", "()Lcom/ss/android/ugc/aweme/discover/commodity/api/AddressComponent;", "setAddressComponent", "(Lcom/ss/android/ugc/aweme/discover/commodity/api/AddressComponent;)V", "", "Lcom/ss/android/ugc/aweme/discover/commodity/api/v3/ProductPreloadInfo;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "getProductPreloadList", "setProductPreloadList", "productPreloadList", "Lcom/ss/android/ugc/aweme/discover/model/GoodsCardFrameStruct;", "goodsCardFrameStruct", "Lcom/ss/android/ugc/aweme/discover/model/GoodsCardFrameStruct;", "getGoodsCardFrameStruct", "()Lcom/ss/android/ugc/aweme/discover/model/GoodsCardFrameStruct;", "setGoodsCardFrameStruct", "(Lcom/ss/android/ugc/aweme/discover/model/GoodsCardFrameStruct;)V", "Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;", "refreshLogPbBean", "Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;", "getRefreshLogPbBean", "()Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;", "setRefreshLogPbBean", "(Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;)V", "value", "getSearchBackgroundConfig", "setSearchBackgroundConfig", "searchBackgroundConfig", "<init>", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchCommodityAggregateResponse extends ECSearchApiResult implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient List<ProductPreloadInfo> f450033a;

    @SerializedName("action_report_cfg")
    private ActionReportConfig actionReportConfig;

    @SerializedName("address_component")
    private AddressComponent addressComponent;

    @SerializedName("aladdin_info")
    private AladdinStruct aladdinInfo;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient c f450034b;

    @SerializedName("chunk_info")
    private ChunkInfo chunkInfo;

    @SerializedName(EffectConfiguration.KEY_CURSOR)
    private int cursor;

    @SerializedName("ecom_search_all_pass_through")
    private String ecomSearchAllPassThrough;

    @SerializedName("ecom_search_pass_through")
    private String ecomSearchPassThrough;

    @SerializedName("goods_card_frame_struct")
    private GoodsCardFrameStruct goodsCardFrameStruct;

    @SerializedName("has_more")
    private boolean hasMore;

    @SerializedName("instant_info")
    private InstantInfo instantInfo;

    @SerializedName("items")
    private List<SearchAggregateCommodity> items;

    @SerializedName("jump_to_page_config")
    private JumpToPageConfig jumpToPageConfig;

    @SerializedName("kiwi_info")
    private KiwiStruct kiwiInfo;

    @SerializedName("marketing_component_container")
    private MarketingComponent marketingComponent;

    @SerializedName("real_time_push_on_card_items")
    private List<Object> realTimePushOnCardItems;
    private LogPbBean refreshLogPbBean;

    @SerializedName("result_type")
    private int resultType;

    @SerializedName("search_background_config_override")
    private SearchBackgroundConfig searchBackgroundConfigOverride;

    @SerializedName("suspension_items_section")
    private SuspensionItemsSection suspensionItemsSection;

    public String getChunkType() {
        ChunkInfo r100 = this.chunkInfo;
        if (r100 == null) goto L6;
        String r101 = r100.getChunkName();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final KiwiStruct getKiwiInfo() {
        AladdinStruct r100 = this.aladdinInfo;
        if (r100 == null) goto L7;
        KiwiStruct r101 = r100.asKiwiStruct();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return this.kiwiInfo;
    }

    public int getListCount() {
        List<SearchAggregateCommodity> r100 = this.items;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    @Override // com.ss.android.ugc.aweme.discover.commodity.ECSearchBaseResponse
    public SearchBackgroundConfig getSearchBackgroundConfig() {
        SearchBackgroundConfig r100 = this.searchBackgroundConfigOverride;
        if (r100 == null) goto L10;
        if (r100 == null) goto L6;
        SearchBackgroundConfig r101 = super.getSearchBackgroundConfig();
    L7:
        r100.setRegressionConfig(r101);
        return r100;
    L6:
        r101 = null;
        goto L7
    L10:
        return super.getSearchBackgroundConfig();
    }

    public SearchCommodityAggregateResponse() {
        this.resultType = 1;
    }

    public final ActionReportConfig getActionReportConfig() {
        return this.actionReportConfig;
    }

    public final AddressComponent getAddressComponent() {
        return this.addressComponent;
    }

    public final AladdinStruct getAladdinInfo() {
        return this.aladdinInfo;
    }

    public final ChunkInfo getChunkInfo() {
        return this.chunkInfo;
    }

    public c getChunkReadingReport() {
        return this.f450034b;
    }

    public final int getCursor() {
        return this.cursor;
    }

    public final String getEcomSearchAllPassThrough() {
        return this.ecomSearchAllPassThrough;
    }

    public final String getEcomSearchPassThrough() {
        return this.ecomSearchPassThrough;
    }

    public final GoodsCardFrameStruct getGoodsCardFrameStruct() {
        return this.goodsCardFrameStruct;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final InstantInfo getInstantInfo() {
        return this.instantInfo;
    }

    public final List<SearchAggregateCommodity> getItems() {
        return this.items;
    }

    public final JumpToPageConfig getJumpToPageConfig() {
        return this.jumpToPageConfig;
    }

    public final MarketingComponent getMarketingComponent() {
        return this.marketingComponent;
    }

    public final List<ProductPreloadInfo> getProductPreloadList() {
        return this.f450033a;
    }

    public final List<Object> getRealTimePushOnCardItems() {
        return this.realTimePushOnCardItems;
    }

    public final LogPbBean getRefreshLogPbBean() {
        return this.refreshLogPbBean;
    }

    public final int getResultType() {
        return this.resultType;
    }

    public final SearchBackgroundConfig getSearchBackgroundConfigOverride() {
        return this.searchBackgroundConfigOverride;
    }

    public final SuspensionItemsSection getSuspensionItemsSection() {
        return this.suspensionItemsSection;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public final void setActionReportConfig(ActionReportConfig r100) {
        this.actionReportConfig = r100;
    }

    public final void setAddressComponent(AddressComponent r100) {
        this.addressComponent = r100;
    }

    public final void setAladdinInfo(AladdinStruct r100) {
        this.aladdinInfo = r100;
    }

    public final void setChunkInfo(ChunkInfo r100) {
        this.chunkInfo = r100;
    }

    @Override // com.bytedance.android.chunkstreamprediction.network.d
    public void setChunkReadingReport(c r100) {
        Intrinsics.checkNotNullParameter(r100, "o");
        r100.getClass();
        monitor-enter(r100);
        List<c.a> r101 = r100.f42525a;     // Catch: Throwable -> L8
        monitor-exit(r100);
        this.f450034b = new c(r101, r100.f42526b);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public final void setCursor(int r100) {
        this.cursor = r100;
    }

    public final void setEcomSearchAllPassThrough(String r100) {
        this.ecomSearchAllPassThrough = r100;
    }

    public final void setEcomSearchPassThrough(String r100) {
        this.ecomSearchPassThrough = r100;
    }

    public final void setGoodsCardFrameStruct(GoodsCardFrameStruct r100) {
        this.goodsCardFrameStruct = r100;
    }

    public final void setHasMore(boolean r100) {
        this.hasMore = r100;
    }

    public final void setInstantInfo(InstantInfo r100) {
        this.instantInfo = r100;
    }

    public final void setItems(List<SearchAggregateCommodity> r100) {
        this.items = r100;
    }

    public final void setJumpToPageConfig(JumpToPageConfig r100) {
        this.jumpToPageConfig = r100;
    }

    public final void setKiwiInfo(KiwiStruct r100) {
        this.kiwiInfo = r100;
    }

    public final void setMarketingComponent(MarketingComponent r100) {
        this.marketingComponent = r100;
    }

    public final void setProductPreloadList(List<ProductPreloadInfo> r100) {
        this.f450033a = r100;
    }

    public final void setRealTimePushOnCardItems(List<Object> r100) {
        this.realTimePushOnCardItems = r100;
    }

    public final void setRefreshLogPbBean(LogPbBean r100) {
        this.refreshLogPbBean = r100;
    }

    public final void setResultType(int r100) {
        this.resultType = r100;
    }

    @Override // com.ss.android.ugc.aweme.discover.commodity.ECSearchBaseResponse
    public void setSearchBackgroundConfig(SearchBackgroundConfig r100) {
        super.setSearchBackgroundConfig(r100);
    }

    public final void setSearchBackgroundConfigOverride(SearchBackgroundConfig r100) {
        this.searchBackgroundConfigOverride = r100;
    }

    public final void setSuspensionItemsSection(SuspensionItemsSection r100) {
        this.suspensionItemsSection = r100;
    }
}
