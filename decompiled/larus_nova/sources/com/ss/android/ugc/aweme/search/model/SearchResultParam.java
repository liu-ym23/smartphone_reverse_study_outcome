package com.ss.android.ugc.aweme.search.model;

import android.text.TextUtils;
import com.bytedance.ies.modulize.rule.AllowImpl;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.discover.commodity.utils.SearchSeriesInfoUtils;
import com.ss.android.ugc.aweme.discover.model.QueryCorrectInfo;
import com.ss.android.ugc.aweme.discover.viewmodel.ECSearchEnterViewModel;
import com.ss.android.ugc.aweme.search.model.commodity.CommodityResultParam;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class SearchResultParam implements Serializable, Cloneable {
    public static final String ENTER_PAGE_GENERAL_SEARCH = "general_search";
    public static final String ENTER_PAGE_TYPE_MIDDLE_PAGE = "middle_page";
    public static final String ENTER_PAGE_TYPE_OTHER = "other";
    public static final int NEED_CORRECT = 1;
    public static final int NOT_NEED_CORRECT = 0;
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient JSONObject f453346a;
    public int activityCode;
    private String baseKeyword;
    private String clientEngineExtra;
    private String clientServerExtra;
    private String clientServerPassForOnce;
    private String currentRenderItemDataId;
    private String currentRenderItemDataIds;
    private int disableForecast;
    private Map<String, Object> ecomBtmMap;
    private String ecomSearchAllPassThrough;
    private String ecomSearchPassThrough;
    private String enterMethod;
    private String enterPageType;
    private String extra;
    private Map<String, Object> extraInfo;
    private Boolean firstPassiveSearch;
    public int fragmentCode;
    private String gsTabContent;
    private String gsTabId;
    private int gsTabPosition;
    private String guideSearchBaseWord;
    private String iconType;
    private int index;
    private Boolean isAfterLocate;
    private Boolean isBackupKeyword;
    private boolean isDirectJump;
    private boolean isFromCommodityGuideSearch;
    private boolean isFromHangingWordSearch;
    private boolean isFromPredict;
    private boolean isHidden;
    private boolean isOpenNewSearchContainer;
    private String keyword;
    private List<String> keywordList;
    private String lastChannel;
    private CommodityResultParam mCommodityResultParam;
    private int manualSearchTriggerType;
    private int needCorrect;
    private String originSearchId;
    private String preSearchResultId;
    private String qrecImprId;
    private String qrecQueryId;
    public QueryCorrectInfo queryCorrectInfo;
    private String rawKeywordList;
    private Map<String, String> rebackParams;
    private String respFrom;
    private String saleStyle;
    private String saleTextContent;
    private String saleType;
    public String scrollTo;
    private SearchEnterParam searchEnterParam;
    private String searchFrom;
    private String spuId;
    private String subChannel;
    private String sugType;
    public String suggestWordsExtra;
    public String tabName;
    public String targetTab;
    private String toastExtra;
    private String tokenType;
    private String transEventExtra;
    private String wordReason;
    private String wordType;

    public interface SearchSource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final List<String> f453347a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final List<String> f453348b = null;

        static {
            f453347a = Arrays.asList(new String[]{"guide_card_click_single_word", "guide_card_click_more", "reb_packet_aladdin", "click_more_general_list_aladdin", "click_single_brand_card", "brand_guide_card_click_more", "click_single_brand_card_commodity", "guide_click_single_brand_card", "brand_guide_click_single_commodity", "guide_card_spare_word_1", "guide_card_spare_word_2"});
            f453348b = Arrays.asList(new String[]{"normal_search", "search_sug", "search_history"});
        }
    }

    @AllowImpl
    public boolean fromGuideSearch() {
        if ("guide_search".equals(this.searchFrom) == false) goto L5;
    L8:
        return true;
    L5:
        if ("guide_search_feedbar_multi".equals(this.searchFrom) == true) goto L8;
        return false;
    }

    @AllowImpl
    public boolean fromHangingWordSearch() {
        return "hanging_word".equals(this.searchFrom);
    }

    @AllowImpl
    public CommodityResultParam getCommodityResultParam() {
        if (this.mCommodityResultParam != null) goto L6;
        this.mCommodityResultParam = new CommodityResultParam();
    L6:
        return this.mCommodityResultParam;
    }

    @AllowImpl
    public String getGuideSearchBaseWord() {
        String r100 = this.guideSearchBaseWord;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return this.keyword;
    }

    @AllowImpl
    public String getRebackParams() {
        Map<String, String> r100 = this.rebackParams;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.isEmpty() == true) goto L13;
        return new Gson().toJson(this.rebackParams);
    L14:
        return null;
    L13:
        return null;
    }

    @AllowImpl
    public String getSearchEnterFromPage() {
        SearchEnterParam r100 = this.searchEnterParam;
        if (r100 != null) goto L5;
        return "";
    L5:
        if (TextUtils.isEmpty(r100.getEnterSearchFrom()) == false) goto L7;
        return "";
    L7:
        if (TextUtils.equals(this.searchEnterParam.getEnterSearchFrom(), "others_homepage") == false) goto L13;
        if (this.searchEnterParam.getPreviousPage() == null) goto L13;
        return this.searchEnterParam.getPreviousPage();
    L13:
        return this.searchEnterParam.getEnterSearchFrom();
    }

    @AllowImpl
    public String getSearchEnterFromSecond() {
        SearchEnterParam r100 = this.searchEnterParam;
        if (r100 != null) goto L5;
        return "";
    L5:
        if (TextUtils.isEmpty(r100.getEnterFromSecond()) == false) goto L7;
        return "";
    L7:
        return this.searchEnterParam.getEnterFromSecond();
    }

    @AllowImpl
    public SearchEnterParam getSearchEnterParam() {
        if (this.searchEnterParam != null) goto L6;
        this.searchEnterParam = ECSearchEnterViewModel.getCurSearchEnterParam();
    L6:
        return this.searchEnterParam;
    }

    @AllowImpl
    public String getSearchPreviousPage() {
        SearchEnterParam r100 = this.searchEnterParam;
        if (r100 != null) goto L5;
        return "";
    L5:
        if (TextUtils.isEmpty(r100.getPreviousPage()) == false) goto L7;
        return "";
    L7:
        return this.searchEnterParam.getPreviousPage();
    }

    public String getSearchSource() {
        if (TextUtils.isEmpty(this.enterMethod) == true) goto L6;
        return this.enterMethod;
    L6:
        return this.searchFrom;
    }

    @AllowImpl
    public Boolean isAfterLocate() {
        boolean r100 = this.isAfterLocate.booleanValue();
        this.isAfterLocate = Boolean.FALSE;
        return Boolean.valueOf(r100);
    }

    @AllowImpl
    public boolean isFromCommodityGuideSearch() {
        if (this.isFromCommodityGuideSearch == false) goto L5;
    L8:
        return true;
    L5:
        if (fromGuideSearch() == true) goto L8;
        return false;
    }

    @AllowImpl
    public boolean isFromHangingWordSearch() {
        if (this.isFromHangingWordSearch == false) goto L5;
    L8:
        return true;
    L5:
        if (fromHangingWordSearch() == true) goto L8;
        return false;
    }

    public boolean isManualSearch() {
        return SearchSource.f453348b.contains(getSearchSource());
    }

    @AllowImpl
    public String toString() {
        return "SearchResultParam{searchFrom='" + this.searchFrom + "', isOpenNewSearchContainer=" + this.isOpenNewSearchContainer + ", enterMethod='" + this.enterMethod + "', searchEnterParam=" + this.searchEnterParam + ", index=" + this.index + ", targetTab='" + this.targetTab + "', tokenType='" + this.tokenType + "', sugType='" + this.sugType + "', needCorrect=" + this.needCorrect + ", keyword='" + this.keyword + "', guideSearchBaseWord='" + this.guideSearchBaseWord + "', toastExtra='" + this.toastExtra + "', isDirectJump=" + this.isDirectJump + ", mCommodityResultParam=" + this.mCommodityResultParam + '}';
    }

    public SearchResultParam() {
        this.searchFrom = "";
        this.searchEnterParam = null;
        this.manualSearchTriggerType = 0;
        this.f453346a = null;
        this.needCorrect = 1;
        this.isDirectJump = false;
        this.scrollTo = null;
        this.gsTabPosition = -1;
        this.respFrom = null;
        this.enterPageType = "other";
        this.ecomBtmMap = null;
        this.disableForecast = 0;
        this.keywordList = new ArrayList();
        this.rawKeywordList = null;
        this.extraInfo = null;
        this.suggestWordsExtra = null;
        Boolean r100 = Boolean.FALSE;
        this.isAfterLocate = r100;
        this.firstPassiveSearch = r100;
    }

    @AllowImpl
    public SearchResultParam copy() {
        return (SearchResultParam) clone();
    L4:
        e = move-exception;
        e.printStackTrace();
        SearchResultParam r100 = new SearchResultParam();
        r100.keyword = this.keyword;
        r100.index = this.index;
        r100.tabName = this.tabName;
        r100.activityCode = this.activityCode;
        r100.fragmentCode = this.fragmentCode;
        r100.enterMethod = this.enterMethod;
        r100.guideSearchBaseWord = this.guideSearchBaseWord;
        r100.isOpenNewSearchContainer = this.isOpenNewSearchContainer;
        r100.searchFrom = this.searchFrom;
        r100.sugType = this.sugType;
        r100.needCorrect = this.needCorrect;
        r100.mCommodityResultParam = this.mCommodityResultParam;
        r100.tokenType = this.tokenType;
        r100.subChannel = this.subChannel;
        r100.clientServerPassForOnce = this.clientServerPassForOnce;
        return r100;
    }

    @AllowImpl
    public SearchResultParam deepCopy() {
        SearchResultParam r100 = copy();
        CommodityResultParam r101 = this.mCommodityResultParam;
        if (r101 == null) goto L6;
        r100.mCommodityResultParam = r101.copy();
    L6:
        if (this.f453346a == null) goto L12;
        r100.f453346a = new JSONObject(this.f453346a.toString());     // Catch: JSONException -> L9
    L9:
        e = move-exception;
        e.toString();
    L12:
        if (this.ecomBtmMap == null) goto L14;
        HashMap r102 = new HashMap();
        r100.ecomBtmMap = r102;
        r102.putAll(this.ecomBtmMap);
    L14:
        ArrayList r103 = new ArrayList();
        r100.keywordList = r103;
        r103.addAll(this.keywordList);
        if (this.extraInfo == null) goto L17;
        HashMap r104 = new HashMap();
        r100.extraInfo = r104;
        r104.putAll(this.extraInfo);
    L17:
        QueryCorrectInfo r105 = this.queryCorrectInfo;
        if (r105 == null) goto L21;
        r100.queryCorrectInfo = r105.copy();
    L21:
        if (this.rebackParams == null) goto L23;
        HashMap r106 = new HashMap();
        r100.rebackParams = r106;
        r106.putAll(this.rebackParams);
    L23:
        return r100;
    }

    @AllowImpl
    public String getBaseKeyword() {
        return this.baseKeyword;
    }

    @AllowImpl
    public String getClientEngineExtra() {
        return this.clientEngineExtra;
    }

    @AllowImpl
    public String getClientServerExtra() {
        return this.clientServerExtra;
    }

    @AllowImpl
    public String getClientServerPassForOnce() {
        return this.clientServerPassForOnce;
    }

    @AllowImpl
    public String getCurrentRenderItemDataId() {
        return this.currentRenderItemDataId;
    }

    @AllowImpl
    public String getCurrentRenderItemDataIds() {
        return this.currentRenderItemDataIds;
    }

    public int getDisableForecast() {
        return this.disableForecast;
    }

    public Map<String, Object> getEcomBtmMap() {
        return this.ecomBtmMap;
    }

    @AllowImpl
    public String getEcomSearchAllPassThrough() {
        return this.ecomSearchAllPassThrough;
    }

    @AllowImpl
    public String getEcomSearchPassThrough() {
        return this.ecomSearchPassThrough;
    }

    @AllowImpl
    public String getEnterMethod() {
        return this.enterMethod;
    }

    public String getEnterPageType() {
        return this.enterPageType;
    }

    @AllowImpl
    public String getExtra() {
        return this.extra;
    }

    @AllowImpl
    public Map<String, Object> getExtraInfo() {
        return this.extraInfo;
    }

    public Boolean getFirstPassiveSearch() {
        return this.firstPassiveSearch;
    }

    public String getGsTabContent() {
        return this.gsTabContent;
    }

    public String getGsTabId() {
        return this.gsTabId;
    }

    public int getGsTabPosition() {
        return this.gsTabPosition;
    }

    public String getIconType() {
        return this.iconType;
    }

    @AllowImpl
    public int getIndex() {
        return this.index;
    }

    @AllowImpl
    public String getKeyword() {
        return this.keyword;
    }

    @AllowImpl
    public List<String> getKeywordList() {
        return this.keywordList;
    }

    @AllowImpl
    public JSONObject getLynxExtra() {
        return this.f453346a;
    }

    @AllowImpl
    public int getManualSearchTriggerType() {
        return this.manualSearchTriggerType;
    }

    @AllowImpl
    public int getNeedCorrect() {
        return this.needCorrect;
    }

    @AllowImpl
    public String getOriginSearchId() {
        return this.originSearchId;
    }

    @AllowImpl
    public String getPreSearchResultId() {
        return this.preSearchResultId;
    }

    public String getQrecImprId() {
        return this.qrecImprId;
    }

    public String getQrecQueryId() {
        return this.qrecQueryId;
    }

    @AllowImpl
    public String getRawKeywordList() {
        return this.rawKeywordList;
    }

    @AllowImpl
    public String getSaleStyle() {
        return this.saleStyle;
    }

    @AllowImpl
    public String getSaleTextContent() {
        return this.saleTextContent;
    }

    @AllowImpl
    public String getSaleType() {
        return this.saleType;
    }

    @AllowImpl
    public String getSearchFrom() {
        return this.searchFrom;
    }

    public String getSpuId() {
        return this.spuId;
    }

    public String getSubChannel() {
        return this.subChannel;
    }

    @AllowImpl
    public String getSugType() {
        return this.sugType;
    }

    public String getSuggestWordsExtra() {
        return this.suggestWordsExtra;
    }

    @AllowImpl
    public String getToastExtra() {
        return this.toastExtra;
    }

    @AllowImpl
    public String getTokenType() {
        return this.tokenType;
    }

    @AllowImpl
    public String getTransEventExtra() {
        return this.transEventExtra;
    }

    @AllowImpl
    public String getWordReason() {
        return this.wordReason;
    }

    @AllowImpl
    public String getWordType() {
        return this.wordType;
    }

    @AllowImpl
    public Boolean isBackupKeyword() {
        return this.isBackupKeyword;
    }

    @AllowImpl
    public boolean isDirectJump() {
        return this.isDirectJump;
    }

    public boolean isFromPredict() {
        return this.isFromPredict;
    }

    @AllowImpl
    public boolean isHidden() {
        return this.isHidden;
    }

    @AllowImpl
    public boolean isOpenNewSearchContainer() {
        return this.isOpenNewSearchContainer;
    }

    @AllowImpl
    public static String getSearchEnterFromPage(SearchEnterParam r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (TextUtils.isEmpty(r100.getEnterSearchFrom()) == false) goto L6;
        return "";
    L6:
        return r100.getEnterSearchFrom();
    }

    @AllowImpl
    public SearchResultParam setBaseKeyword(String r100) {
        this.baseKeyword = r100;
        return this;
    }

    @AllowImpl
    public void setClientEngineExtra(String r100) {
        SearchEnterParam r101 = getSearchEnterParam();
        SearchSeriesInfoUtils r102 = SearchSeriesInfoUtils.f450391a;
        if (r101 != null) goto L5;
        JSONObject r103 = null;
    L6:
        r102.getClass();
        if (r103 != null) goto L9;
    L21:
        this.clientEngineExtra = r100;
        return;
    L9:
        if (r103.length() == 0) goto L21;
        if (r100 != null) goto L13;
    L16:
        boolean r104 = true;
    L17:
        if (r104 == false) goto L19;
        JSONObject r105 = new JSONObject();
    L20:
        r105.put("series_info", r103);
        r100 = r105.toString();
        goto L21
    L19:
        r105 = new JSONObject(r100);
        goto L20
    L13:
        if (r100.length() == 0) goto L16;
        r104 = false;
        goto L17
    L5:
        r103 = r101.getSeriesInfoJSON();
        goto L6
    }

    @AllowImpl
    public void setClientServerExtra(String r100) {
        this.clientServerExtra = r100;
    }

    @AllowImpl
    public void setClientServerPassForOnce(String r100) {
        this.clientServerPassForOnce = r100;
    }

    @AllowImpl
    public void setCurrentRenderItemDataId(String r100) {
        this.currentRenderItemDataId = r100;
    }

    @AllowImpl
    public void setCurrentRenderItemDataIds(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        this.currentRenderItemDataIds = r100;
        return;
    }

    public SearchResultParam setDisableForecast(int r100) {
        this.disableForecast = r100;
        return this;
    }

    public void setEcomBtmMap(Map<String, Object> r100) {
        this.ecomBtmMap = r100;
    }

    @AllowImpl
    public void setEcomSearchAllPassThrough(String r100) {
        this.ecomSearchAllPassThrough = r100;
    }

    @AllowImpl
    public void setEcomSearchPassThrough(String r100) {
        this.ecomSearchPassThrough = r100;
    }

    @AllowImpl
    public SearchResultParam setEnterMethod(String r100) {
        this.enterMethod = r100;
        return this;
    }

    public SearchResultParam setEnterPageType(String r100) {
        this.enterPageType = r100;
        return this;
    }

    @AllowImpl
    public SearchResultParam setExtra(String r100) {
        this.extra = r100;
        return this;
    }

    @AllowImpl
    public void setExtraInfo(Map<String, Object> r100) {
        this.extraInfo = r100;
    }

    public SearchResultParam setFirstPassiveSearch(Boolean r100) {
        this.firstPassiveSearch = r100;
        return this;
    }

    public void setGsTabContent(String r100) {
        this.gsTabContent = r100;
    }

    public void setGsTabId(String r100) {
        this.gsTabId = r100;
    }

    public void setGsTabPosition(int r100) {
        this.gsTabPosition = r100;
    }

    @AllowImpl
    public SearchResultParam setGuideSearchBaseWord(String r100) {
        this.guideSearchBaseWord = r100;
        return this;
    }

    @AllowImpl
    public void setHidden(boolean r100) {
        this.isHidden = r100;
    }

    public SearchResultParam setIconType(String r100) {
        this.iconType = r100;
        return this;
    }

    @AllowImpl
    public void setIndex(int r100) {
        this.index = r100;
    }

    @AllowImpl
    public void setIsAfterLocate(Boolean r100) {
        this.isAfterLocate = r100;
    }

    @AllowImpl
    public void setIsBackupKeyword(Boolean r100) {
        this.isBackupKeyword = r100;
    }

    @AllowImpl
    public SearchResultParam setIsDirectJump(boolean r100) {
        this.isDirectJump = r100;
        return this;
    }

    @AllowImpl
    public void setIsFromCommodityGuideSearch(boolean r100) {
        this.isFromCommodityGuideSearch = r100;
    }

    @AllowImpl
    public void setIsFromHangingWordSearch(boolean r100) {
        this.isFromHangingWordSearch = r100;
    }

    public void setIsFromPredict(boolean r100) {
        this.isFromPredict = r100;
    }

    @AllowImpl
    public SearchResultParam setKeyword(String r100) {
        this.keyword = r100;
        return this;
    }

    @AllowImpl
    public SearchResultParam setKeywordList(List<String> r100) {
        this.keywordList = r100;
        return this;
    }

    @AllowImpl
    public void setLynxExtra(JSONObject r100) {
        this.f453346a = r100;
    }

    @AllowImpl
    public SearchResultParam setManualSearchTriggerType(int r100) {
        this.manualSearchTriggerType = r100;
        return this;
    }

    @AllowImpl
    public SearchResultParam setNeedCorrect(int r100) {
        this.needCorrect = r100;
        return this;
    }

    @AllowImpl
    public SearchResultParam setOpenNewSearchContainer(boolean r100) {
        this.isOpenNewSearchContainer = r100;
        return this;
    }

    @AllowImpl
    public void setOriginSearchId(String r100) {
        this.originSearchId = r100;
    }

    @AllowImpl
    public SearchResultParam setPreSearchResultId(String r100) {
        this.preSearchResultId = r100;
        return this;
    }

    public SearchResultParam setQrecImprId(String r100) {
        this.qrecImprId = r100;
        return this;
    }

    public SearchResultParam setQrecQueryId(String r100) {
        this.qrecQueryId = r100;
        return this;
    }

    @AllowImpl
    public SearchResultParam setRawKeywordList(String r100) {
        this.rawKeywordList = r100;
        return this;
    }

    @AllowImpl
    public SearchResultParam setRebackParams(Map<String, String> r100) {
        if (r100 != null) goto L4;
    L15:
        return this;
    L4:
        if (r100.isEmpty() == true) goto L15;
        Map<String, String> r101 = this.rebackParams;
        if (r101 == null) goto L12;
        if (r101.isEmpty() == true) goto L12;
        return this;
    L12:
        if (this.rebackParams != null) goto L14;
        this.rebackParams = new HashMap();
    L14:
        this.rebackParams.putAll(r100);
        goto L15
    }

    @AllowImpl
    public void setSaleStyle(String r100) {
        this.saleStyle = r100;
    }

    @AllowImpl
    public void setSaleTextContent(String r100) {
        this.saleTextContent = r100;
    }

    @AllowImpl
    public void setSaleType(String r100) {
        this.saleType = r100;
    }

    @AllowImpl
    public SearchResultParam setSearchEnterParam(SearchEnterParam r100) {
        if (r100 == null) goto L4;
        this.searchEnterParam = r100;
    L4:
        return this;
    }

    @AllowImpl
    public SearchResultParam setSearchFrom(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L5;
        this.searchFrom = r100;
    L5:
        return this;
    }

    public void setSpuId(String r100) {
        this.spuId = r100;
    }

    public SearchResultParam setSubChannel(String r100) {
        this.subChannel = r100;
        return this;
    }

    @AllowImpl
    public SearchResultParam setSugType(String r100) {
        this.sugType = r100;
        return this;
    }

    public void setSuggestWordsExtra(String r100) {
        this.suggestWordsExtra = r100;
    }

    @AllowImpl
    public SearchResultParam setToastExtra(String r100) {
        this.toastExtra = r100;
        return this;
    }

    @AllowImpl
    public SearchResultParam setTokenType(String r100) {
        this.tokenType = r100;
        return this;
    }

    @AllowImpl
    public SearchResultParam setTransEventExtra(String r100) {
        this.transEventExtra = r100;
        return this;
    }

    @AllowImpl
    public SearchResultParam setWordReason(String r100) {
        this.wordReason = r100;
        return this;
    }

    @AllowImpl
    public SearchResultParam setWordType(String r100) {
        this.wordType = r100;
        return this;
    }
}
