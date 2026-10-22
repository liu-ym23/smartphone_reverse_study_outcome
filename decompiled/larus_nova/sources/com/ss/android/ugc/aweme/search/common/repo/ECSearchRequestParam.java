package com.ss.android.ugc.aweme.search.common.repo;

import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.common.utility.StringUtils;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.ttvideoengine.model.SubInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u00109\u001a\u00020\u001c2\b\u0010:\u001a\u0004\u0018\u00010;H\u0096\u0002J\b\u0010<\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0012\u0010!\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00101\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u00103\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001c\u00106\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\r\"\u0004\b8\u0010\u000f¨\u0006="}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/repo/ECSearchRequestParam;", "Ljava/io/Serializable;", "()V", "btmSourceToken", "", "clientEngineExtra", "commonSearchParams", "correctType", "", "count", EffectConfiguration.KEY_CURSOR, "ecomMarketAddress", "getEcomMarketAddress", "()Ljava/lang/String;", "setEcomMarketAddress", "(Ljava/lang/String;)V", "ecomSceneId", "ecomSearchAllPassThrough", "ecomSearchPassThrough", "ecomTheme", "enterFrom", "enterFromSecond", "entranceTab", "extra", "floatPendant", SubInfo.KEY_FORMAT, "fromGroupId", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "hasSideBar", "instantAddress", "isPrefetch", "keyword", "level", "niceSearchType", "originalSearchId", "pageType", "preFetchBtm", "preGeneralSearchId", "preTab", "searchChannel", "searchScene", "searchSource", "secAuthorId", "showDocs", "shownCount", "sortParams", "subBoardWidth", "switchTabFrom", "targetTab", "triggerPrefetchFrom", "getTriggerPrefetchFrom", "setTriggerPrefetchFrom", "equals", "other", "", "hashCode", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchRequestParam implements Serializable {

    @SerializedName("btm_source_token")
    public String btmSourceToken;

    @SerializedName("client_engine_extra")
    public String clientEngineExtra;

    @SerializedName("common_search_params")
    public String commonSearchParams;

    @SerializedName("query_correct_type")
    public int correctType;

    @SerializedName("count")
    public int count;

    @SerializedName(EffectConfiguration.KEY_CURSOR)
    public int cursor;

    @SerializedName("address")
    private String ecomMarketAddress;

    @SerializedName("ecom_scene_id")
    public String ecomSceneId;

    @SerializedName("ecom_search_all_pass_through")
    public String ecomSearchAllPassThrough;

    @SerializedName("ecom_search_pass_through")
    public String ecomSearchPassThrough;

    @SerializedName("ecom_theme")
    public String ecomTheme;

    @SerializedName("enter_from")
    public String enterFrom;

    @SerializedName(ECFindSimilarConfig.ENTER_FROM_SECOND)
    public String enterFromSecond;

    @SerializedName("entrance_tab")
    public String entranceTab;

    @SerializedName("extra")
    public String extra;

    @SerializedName("float_pendant")
    public int floatPendant;

    @SerializedName(SubInfo.KEY_FORMAT)
    public String format;

    @SerializedName(a.KEY_FROM_GROUP_ID)
    public String fromGroupId;
    private boolean hasMore;

    @SerializedName("has_sidebar")
    public boolean hasSideBar;

    @SerializedName("instant_address")
    public String instantAddress;

    @SerializedName("isPrefetch")
    public boolean isPrefetch;

    @SerializedName("keyword")
    public String keyword;

    @SerializedName("level")
    public String level;

    @SerializedName("nice_search_type")
    public String niceSearchType;

    @SerializedName("original_search_id")
    public String originalSearchId;

    @SerializedName("page_type")
    public int pageType;

    @SerializedName("prefetch-btm")
    public String preFetchBtm;

    @SerializedName("pre_general_search_id")
    public String preGeneralSearchId;

    @SerializedName("pre_tab")
    public String preTab;

    @SerializedName("search_channel")
    public String searchChannel;

    @SerializedName("search_scene")
    public String searchScene;

    @SerializedName("search_source")
    public String searchSource;

    @SerializedName("sec_author_id")
    public String secAuthorId;

    @SerializedName("show_docs")
    public String showDocs;

    @SerializedName("shown_count")
    public int shownCount;

    @SerializedName("sort_params")
    public String sortParams;

    @SerializedName("sub_board_width")
    public int subBoardWidth;

    @SerializedName("switch_tab_from")
    public String switchTabFrom;

    @SerializedName("target_tab")
    public String targetTab;
    private String triggerPrefetchFrom;

    public int hashCode() {
        int r100 = this.cursor * 31;
        String r101 = this.keyword;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.enterFrom;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.clientEngineExtra;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.extra;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.searchChannel;
        if (r114 == null) goto L21;
        int r115 = r114.hashCode();
    L22:
        int r116 = (((r113 + r115) * 31) + this.count) * 31;
        String r117 = this.enterFromSecond;
        if (r117 == null) goto L25;
        int r118 = r117.hashCode();
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.searchSource;
        if (r120 == null) goto L29;
        int r121 = r120.hashCode();
    L30:
        int r122 = (r119 + r121) * 31;
        String r123 = this.ecomSceneId;
        if (r123 == null) goto L34;
        r102 = r123.hashCode();
    L34:
        return ((((r122 + r102) * 31) + this.pageType) * 31) + this.floatPendant;
    L29:
        r121 = 0;
        goto L30
    L25:
        r118 = 0;
        goto L26
    L21:
        r115 = 0;
        goto L22
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public ECSearchRequestParam() {
        this.hasMore = true;
        this.keyword = "";
        this.fromGroupId = "";
        this.count = 10;
        this.pageType = 1;
        this.floatPendant = 100;
    }

    public final String getEcomMarketAddress() {
        return this.ecomMarketAddress;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final String getTriggerPrefetchFrom() {
        return this.triggerPrefetchFrom;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(ECSearchRequestParam.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L63;
        ECSearchRequestParam r102 = (ECSearchRequestParam) r100;
        if (this.cursor == r102.cursor) goto L18;
        Logger.b("ECSearchPrefetch", "cursor not equal, cursor = " + this.cursor + ", that.cursor = " + r102.cursor);
        return false;
    L18:
        if ((!Intrinsics.areEqual(this.keyword, r102.keyword)) == false) goto L22;
        Logger.b("ECSearchPrefetch", "keyword not equal, keyword = " + this.keyword + ", that.keyword = " + r102.keyword);
        return false;
    L22:
        if (StringUtils.equal(this.enterFrom, r102.enterFrom) == true) goto L26;
        Logger.b("ECSearchPrefetch", "enterFrom not equal, enterFrom = " + this.enterFrom + ", that.enterFrom = " + r102.enterFrom);
        return false;
    L26:
        if (StringUtils.equal(this.clientEngineExtra, r102.clientEngineExtra) == true) goto L30;
        Logger.b("ECSearchPrefetch", "clientEngineExtra not equal, clientEngineExtra = " + this.clientEngineExtra + ", that.clientEngineExtra = " + r102.clientEngineExtra);
        return false;
    L30:
        if (StringUtils.equal(this.extra, r102.extra) == true) goto L34;
        Logger.b("ECSearchPrefetch", "extra not equal, extra = " + this.extra + ", that.extra = " + r102.extra);
        return false;
    L34:
        if (StringUtils.equal(this.searchChannel, r102.searchChannel) == true) goto L38;
        Logger.b("ECSearchPrefetch", "searchChannel not equal, searchChannel = " + this.searchChannel + ", that.searchChannel = " + r102.searchChannel);
        return false;
    L38:
        if (this.count == r102.count) goto L42;
        Logger.b("ECSearchPrefetch", "count not equal, count = " + this.count + ", that.count = " + r102.count);
        return false;
    L42:
        if (StringUtils.equal(this.enterFromSecond, r102.enterFromSecond) == true) goto L46;
        Logger.b("ECSearchPrefetch", "enterFromSecond not equal, enterFromSecond = " + this.enterFromSecond + ", that.enterFromSecond = " + r102.enterFromSecond);
        return false;
    L46:
        if (StringUtils.equal(this.searchSource, r102.searchSource) == true) goto L50;
        Logger.b("ECSearchPrefetch", "searchSource not equal, searchSource = " + this.searchSource + ", that.searchSource = " + r102.searchSource);
        return false;
    L50:
        if (StringUtils.equal(this.ecomSceneId, r102.ecomSceneId) == true) goto L54;
        Logger.b("ECSearchPrefetch", "ecomSceneId not equal, ecomSceneId = " + this.ecomSceneId + ", that.ecomSceneId = " + r102.ecomSceneId);
        return false;
    L54:
        if (this.pageType == r102.pageType) goto L58;
        Logger.b("ECSearchPrefetch", "pageType not equal, pageType = " + this.pageType + ", that.pageType = " + r102.pageType);
        return false;
    L58:
        if (this.floatPendant == r102.floatPendant) goto L61;
        Logger.b("ECSearchPrefetch", "floatPendant not equal, pageType = " + this.floatPendant + ", that.pageType = " + r102.floatPendant);
        return false;
    L61:
        return true;
    L63:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.android.ugc.aweme.search.common.repo.ECSearchRequestParam");
    L8:
        r101 = null;
        goto L10
    }

    public final void setEcomMarketAddress(String r100) {
        this.ecomMarketAddress = r100;
    }

    public final void setHasMore(boolean r100) {
        this.hasMore = r100;
    }

    public final void setTriggerPrefetchFrom(String r100) {
        this.triggerPrefetchFrom = r100;
    }
}
