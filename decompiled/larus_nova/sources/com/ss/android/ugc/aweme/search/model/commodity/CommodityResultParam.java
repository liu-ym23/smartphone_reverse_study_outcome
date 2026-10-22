package com.ss.android.ugc.aweme.search.model.commodity;

import com.bytedance.ies.modulize.rule.AllowImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b3\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bi\u0010jJ\u0019\u0010\u0005\u001a\u00020\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0003H\u0007J\u0012\u0010\n\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J\n\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\r\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0007J\n\u0010\u000e\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\u0010\u001a\u00020\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0007J\n\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\u0013\u001a\u00020\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0007J\n\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\u0016\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007J\u0018\u0010\u001b\u001a\u00020\u00002\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007J\n\u0010\u001c\u001a\u0004\u0018\u00010\bH\u0007J\n\u0010\u001d\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\u001f\u001a\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\bH\u0007J\n\u0010 \u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010\"\u001a\u00020\u00002\b\u0010!\u001a\u0004\u0018\u00010\bH\u0007J\n\u0010#\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010%\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010\bH\u0007J\n\u0010&\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010(\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010\bH\u0007J\n\u0010)\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010+\u001a\u00020\u00002\b\u0010*\u001a\u0004\u0018\u00010\bH\u0007J\n\u0010,\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u0010.\u001a\u0004\u0018\u00010\u00002\u0006\u0010-\u001a\u00020\bH\u0007J\u0012\u00100\u001a\u0004\u0018\u00010\u00002\u0006\u0010/\u001a\u00020\bH\u0007J\n\u00101\u001a\u0004\u0018\u00010\bH\u0007J\u0012\u00102\u001a\u0004\u0018\u00010\u00002\u0006\u0010/\u001a\u00020\bH\u0007J\n\u00103\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u00106\u001a\u0002052\u0006\u00104\u001a\u00020\u0003H\u0007J\b\u00104\u001a\u00020\u0003H\u0007J\u0018\u00109\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u000108\u0018\u000107H\u0007J \u0010;\u001a\u0002052\u0016\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u000108\u0018\u000107H\u0007J\b\u0010<\u001a\u00020\u0003H\u0007J\u0010\u0010>\u001a\u0002052\u0006\u0010=\u001a\u00020\u0003H\u0007J\b\u0010?\u001a\u00020\u0003H\u0007J\u0010\u0010A\u001a\u0002052\u0006\u0010@\u001a\u00020\u0003H\u0007J\b\u0010B\u001a\u00020\u0000H\u0007R\u0018\u0010C\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010E\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010DR\u0018\u0010F\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010DR\u0018\u0010G\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010DR$\u0010H\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010D\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010M\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010D\u001a\u0004\bN\u0010J\"\u0004\bO\u0010LR\"\u0010P\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR0\u0010V\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u000208\u0018\u0001078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0018\u0010\\\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010DR\u0018\u0010]\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010DR\u0018\u0010^\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010DR\u0018\u0010_\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010DR\u0018\u0010`\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010DR\u0018\u0010a\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010c\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010DR\u0018\u0010-\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010DR\u0018\u0010d\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010DR\u0018\u0010e\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010DR\u0016\u00104\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010QR&\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u000108\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010WR\u0016\u0010=\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010QR\u0016\u0010@\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010QR\"\u0010f\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bf\u0010Q\u001a\u0004\bg\u0010S\"\u0004\bh\u0010U¨\u0006k"}, d2 = {"Lcom/ss/android/ugc/aweme/search/model/commodity/CommodityResultParam;", "Ljava/io/Serializable;", "", "", "needGuideSearchWord", "setNeedAppendGuideSearchWord", "(Ljava/lang/Boolean;)Lcom/ss/android/ugc/aweme/search/model/commodity/CommodityResultParam;", "needAppendGuideSearchWord", "", "guideSearchWord", "setGuideSearchWord", "getGuideSearchWord", "originSearchId", "setOriginSearchId", "getOriginSearchId", "sortParams", "setSortParams", "getSortParams", "sortBy", "setSortBy", "getSortBy", "filterOption", "setFilterOption", "", "Lorg/json/JSONObject;", "getFilterOptionTotalList", "filterOptionTotalList", "setFilterOptionTotalList", "getFilterOption", "getFilterOptionListStr", "filterOptionListStr", "setFilterOptionListStr", "getFilterOptionNum", "filterOptionNum", "setFilterOptionNum", "getFilterOptionRank", "filterOptionRank", "setFilterOptionRank", "getIsHidden", "isHidden", "setIsHidden", "getTabSearchType", "tabSearchType", "setTabSearchType", "getResultsFormat", "resultsFormat", "setResultsFormat", "params", "setPreTabSearchParams", "getPreTabSearchParams", "setSearchForceInsertInfo", "getSearchForceInsertInfo", "isSearchFromSort", "", "setSearchFromSort", "", "", "getEcomBtmMap", "ecomBtmMap", "setEcomBtmMap", "getIsBannerSearch", "isBannerSearch", "setIsBannerSearch", "getIsBannerSelect", "isBannerSelect", "setIsBannerSelect", "copy", "mOriginSearchId", "Ljava/lang/String;", "mSortParams", "mSortBy", "mFilterOption", "filterOptionId", "getFilterOptionId", "()Ljava/lang/String;", "setFilterOptionId", "(Ljava/lang/String;)V", "filterOptionType", "getFilterOptionType", "setFilterOptionType", "clearLastFormat", "Z", "getClearLastFormat", "()Z", "setClearLastFormat", "(Z)V", "filterLogInfo", "Ljava/util/Map;", "getFilterLogInfo", "()Ljava/util/Map;", "setFilterLogInfo", "(Ljava/util/Map;)V", "mFilterOptionListStr", "mFilterOptionNum", "mFilterOptionRank", "mIsHidden", "mTabSearchType", "mNeedAppendGuideSearchWord", "Ljava/lang/Boolean;", "mGuideSearchWord", "preTabSearchParams", "searchForceInsertInfo", "keepHeadCard", "getKeepHeadCard", "setKeepHeadCard", "<init>", "()V", "trade-search-model_release"}, k = 1, mv = {1, 4, 3})
public final class CommodityResultParam implements Serializable, Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient List<? extends JSONObject> f453349a;
    private boolean clearLastFormat;
    private Map<String, ? extends Object> ecomBtmMap;
    private Map<String, ? extends Object> filterLogInfo;
    private String filterOptionId;
    private String filterOptionType;
    private boolean isBannerSearch;
    private boolean isBannerSelect;
    private boolean isSearchFromSort;
    private boolean keepHeadCard;
    private String mFilterOption;
    private String mFilterOptionListStr;
    private String mFilterOptionNum;
    private String mFilterOptionRank;
    private String mGuideSearchWord;
    private String mIsHidden;
    private Boolean mNeedAppendGuideSearchWord;
    private String mOriginSearchId;
    private String mSortBy;
    private String mSortParams;
    private String mTabSearchType;
    private String preTabSearchParams;
    private String resultsFormat;
    private String searchForceInsertInfo;

    @AllowImpl
    public final CommodityResultParam copy() {
        CommodityResultParam r100 = new CommodityResultParam();
        r100.mOriginSearchId = this.mOriginSearchId;
        r100.mSortParams = this.mSortParams;
        r100.f453349a = this.f453349a;
        r100.mSortBy = this.mSortBy;
        r100.mFilterOption = this.mFilterOption;
        r100.filterOptionId = this.filterOptionId;
        r100.filterOptionType = this.filterOptionType;
        r100.preTabSearchParams = this.preTabSearchParams;
        r100.searchForceInsertInfo = this.searchForceInsertInfo;
        r100.isSearchFromSort = this.isSearchFromSort;
        r100.isBannerSearch = this.isBannerSearch;
        r100.isBannerSelect = this.isBannerSelect;
        r100.keepHeadCard = this.keepHeadCard;
        return r100;
    }

    @AllowImpl
    public final List<JSONObject> getFilterOptionTotalList() {
        List r100 = this.f453349a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new ArrayList();
    }

    @AllowImpl
    public final boolean needAppendGuideSearchWord() {
        Boolean r100 = this.mNeedAppendGuideSearchWord;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.booleanValue();
    }

    public CommodityResultParam() {
        this.isSearchFromSort = true;
    }

    public Object clone() {
        return super.clone();
    }

    public final boolean getClearLastFormat() {
        return this.clearLastFormat;
    }

    @AllowImpl
    public final Map<String, Object> getEcomBtmMap() {
        return this.ecomBtmMap;
    }

    public final Map<String, Object> getFilterLogInfo() {
        return this.filterLogInfo;
    }

    @AllowImpl
    public final String getFilterOption() {
        return this.mFilterOption;
    }

    public final String getFilterOptionId() {
        return this.filterOptionId;
    }

    @AllowImpl
    public final String getFilterOptionListStr() {
        return this.mFilterOptionListStr;
    }

    @AllowImpl
    public final String getFilterOptionNum() {
        return this.mFilterOptionNum;
    }

    @AllowImpl
    public final String getFilterOptionRank() {
        return this.mFilterOptionRank;
    }

    public final String getFilterOptionType() {
        return this.filterOptionType;
    }

    @AllowImpl
    public final String getGuideSearchWord() {
        return this.mGuideSearchWord;
    }

    @AllowImpl
    public final boolean getIsBannerSearch() {
        return this.isBannerSearch;
    }

    @AllowImpl
    public final boolean getIsBannerSelect() {
        return this.isBannerSelect;
    }

    @AllowImpl
    public final String getIsHidden() {
        return this.mIsHidden;
    }

    public final boolean getKeepHeadCard() {
        return this.keepHeadCard;
    }

    @AllowImpl
    public final String getOriginSearchId() {
        return this.mOriginSearchId;
    }

    @AllowImpl
    public final String getPreTabSearchParams() {
        return this.preTabSearchParams;
    }

    @AllowImpl
    public final String getResultsFormat() {
        return this.resultsFormat;
    }

    @AllowImpl
    public final String getSearchForceInsertInfo() {
        return this.searchForceInsertInfo;
    }

    @AllowImpl
    public final String getSortBy() {
        return this.mSortBy;
    }

    @AllowImpl
    public final String getSortParams() {
        return this.mSortParams;
    }

    @AllowImpl
    public final String getTabSearchType() {
        return this.mTabSearchType;
    }

    @AllowImpl
    public final boolean isSearchFromSort() {
        return this.isSearchFromSort;
    }

    public final void setClearLastFormat(boolean r100) {
        this.clearLastFormat = r100;
    }

    @AllowImpl
    public final void setEcomBtmMap(Map<String, ? extends Object> r100) {
        this.ecomBtmMap = r100;
    }

    public final void setFilterLogInfo(Map<String, ? extends Object> r100) {
        this.filterLogInfo = r100;
    }

    @AllowImpl
    public final CommodityResultParam setFilterOption(String r100) {
        this.mFilterOption = r100;
        return this;
    }

    public final void setFilterOptionId(String r100) {
        this.filterOptionId = r100;
    }

    @AllowImpl
    public final CommodityResultParam setFilterOptionListStr(String r100) {
        this.mFilterOptionListStr = r100;
        return this;
    }

    @AllowImpl
    public final CommodityResultParam setFilterOptionNum(String r100) {
        this.mFilterOptionNum = r100;
        return this;
    }

    @AllowImpl
    public final CommodityResultParam setFilterOptionRank(String r100) {
        this.mFilterOptionRank = r100;
        return this;
    }

    @AllowImpl
    public final CommodityResultParam setFilterOptionTotalList(List<? extends JSONObject> r100) {
        this.f453349a = r100;
        return this;
    }

    public final void setFilterOptionType(String r100) {
        this.filterOptionType = r100;
    }

    @AllowImpl
    public final CommodityResultParam setGuideSearchWord(String r100) {
        this.mGuideSearchWord = r100;
        return this;
    }

    @AllowImpl
    public final void setIsBannerSearch(boolean r100) {
        this.isBannerSearch = r100;
    }

    @AllowImpl
    public final void setIsBannerSelect(boolean r100) {
        this.isBannerSelect = r100;
    }

    @AllowImpl
    public final CommodityResultParam setIsHidden(String r100) {
        this.mIsHidden = r100;
        return this;
    }

    public final void setKeepHeadCard(boolean r100) {
        this.keepHeadCard = r100;
    }

    @AllowImpl
    public final CommodityResultParam setNeedAppendGuideSearchWord(Boolean r100) {
        this.mNeedAppendGuideSearchWord = r100;
        return this;
    }

    @AllowImpl
    public final CommodityResultParam setOriginSearchId(String r100) {
        this.mOriginSearchId = r100;
        return this;
    }

    @AllowImpl
    public final CommodityResultParam setPreTabSearchParams(String r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.preTabSearchParams = r100;
        return this;
    }

    @AllowImpl
    public final CommodityResultParam setResultsFormat(String r100) {
        Intrinsics.checkNotNullParameter(r100, "resultsFormat");
        this.resultsFormat = r100;
        return this;
    }

    @AllowImpl
    public final CommodityResultParam setSearchForceInsertInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.searchForceInsertInfo = r100;
        return this;
    }

    @AllowImpl
    public final void setSearchFromSort(boolean r100) {
        this.isSearchFromSort = r100;
    }

    @AllowImpl
    public final CommodityResultParam setSortBy(String r100) {
        this.mSortBy = r100;
        return this;
    }

    @AllowImpl
    public final CommodityResultParam setSortParams(String r100) {
        this.mSortParams = r100;
        if (r100 != null) goto L5;
        setFilterOptionTotalList(null);
    L5:
        return this;
    }

    @AllowImpl
    public final CommodityResultParam setTabSearchType(String r100) {
        this.mTabSearchType = r100;
        return this;
    }
}
