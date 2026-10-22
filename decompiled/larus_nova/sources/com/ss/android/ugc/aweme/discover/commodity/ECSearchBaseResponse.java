package com.ss.android.ugc.aweme.discover.commodity;

import com.bytedance.ies.modulize.rule.AllowImpl;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.commercialize.model.SearchAdInfo;
import com.ss.android.ugc.aweme.discover.mixfeed.SearchEasterEggConfig;
import com.ss.android.ugc.aweme.discover.model.ECJsonNullToJsonObjectAdapter;
import com.ss.android.ugc.aweme.discover.model.GuideSearchWord;
import com.ss.android.ugc.aweme.discover.model.GuideSearchWordsExtra;
import com.ss.android.ugc.aweme.discover.model.GuideSearchWordsV2;
import com.ss.android.ugc.aweme.discover.model.QueryCorrectInfo;
import com.ss.android.ugc.aweme.discover.model.SearchNilInfo;
import com.ss.android.ugc.aweme.discover.model.SearchNilText;
import com.ss.android.ugc.aweme.discover.model.SearchPreventSuicide;
import com.ss.android.ugc.aweme.discover.model.globaldoodle.GlobalDoodleConfig;
import com.ss.android.ugc.aweme.discover.model.globaldoodle.SearchBackgroundConfig;
import com.ss.android.ugc.aweme.discover.model.globaldoodle.WaterfallSearchBackgroundConfig;
import com.ss.android.ugc.aweme.discover.model.immersive.SearchImmersiveConfig;
import com.ss.android.ugc.aweme.ec.search.common.CommerceBaseResponse;
import com.ss.android.ugc.aweme.feed.model.LogPbBean;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\b¢\u0006\u0005\b\u0088\u0001\u0010vJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016R.\u0010\n\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b8W@WX\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR.\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\u00108W@WX\u0097\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R.\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\t\u001a\u0004\u0018\u00010\u00178W@WX\u0097\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR:\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e8W@WX\u0097\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R.\u0010'\u001a\u0004\u0018\u00010&2\b\u0010\t\u001a\u0004\u0018\u00010&8W@WX\u0097\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R.\u0010.\u001a\u0004\u0018\u00010-2\b\u0010\t\u001a\u0004\u0018\u00010-8W@WX\u0097\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R.\u00105\u001a\u0004\u0018\u0001042\b\u0010\t\u001a\u0004\u0018\u0001048W@WX\u0097\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R.\u0010<\u001a\u0004\u0018\u00010;2\b\u0010\t\u001a\u0004\u0018\u00010;8W@WX\u0097\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR*\u0010C\u001a\u00020B2\u0006\u0010\t\u001a\u00020B8W@WX\u0097\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR.\u0010J\u001a\u0004\u0018\u00010I2\b\u0010\t\u001a\u0004\u0018\u00010I8W@WX\u0097\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR.\u0010Q\u001a\u0004\u0018\u00010P2\b\u0010\t\u001a\u0004\u0018\u00010P8W@WX\u0097\u000e¢\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR.\u0010X\u001a\u0004\u0018\u00010W2\b\u0010\t\u001a\u0004\u0018\u00010W8W@WX\u0097\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R.\u0010_\u001a\u0004\u0018\u00010^2\b\u0010\t\u001a\u0004\u0018\u00010^8W@WX\u0097\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR.\u0010f\u001a\u0004\u0018\u00010e2\b\u0010\t\u001a\u0004\u0018\u00010e8W@WX\u0097\u000e¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR.\u0010m\u001a\u0004\u0018\u00010l2\b\u0010\t\u001a\u0004\u0018\u00010l8W@WX\u0097\u000e¢\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR \u0010s\u001a\u00020B8\u0016X\u0097\u0004¢\u0006\u0012\n\u0004\bs\u0010D\u0012\u0004\bu\u0010v\u001a\u0004\bt\u0010FR\u001c\u0010w\u001a\u0004\u0018\u00010\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\bw\u0010x\u001a\u0004\by\u0010zR\u001c\u0010|\u001a\u0004\u0018\u00010{8\u0016X\u0096D¢\u0006\f\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007fR&\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00038\u0016X\u0097\u0004¢\u0006\u0015\n\u0005\b\u0080\u0001\u0010x\u0012\u0005\b\u0082\u0001\u0010v\u001a\u0005\b\u0081\u0001\u0010zR\"\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0016X\u0096\u0004¢\u0006\u0010\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001¨\u0006\u0089\u0001"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/ECSearchBaseResponse;", "Lcom/ss/android/ugc/aweme/ec/search/common/CommerceBaseResponse;", "", "", "requestId", "", "setRequestId", "getRequestId", "Lcom/ss/android/ugc/aweme/discover/model/SearchNilInfo;", "<set-?>", "searchNilInfo", "Lcom/ss/android/ugc/aweme/discover/model/SearchNilInfo;", "getSearchNilInfo", "()Lcom/ss/android/ugc/aweme/discover/model/SearchNilInfo;", "setSearchNilInfo", "(Lcom/ss/android/ugc/aweme/discover/model/SearchNilInfo;)V", "Lcom/ss/android/ugc/aweme/discover/model/SearchNilText;", "searchNilText", "Lcom/ss/android/ugc/aweme/discover/model/SearchNilText;", "getSearchNilText", "()Lcom/ss/android/ugc/aweme/discover/model/SearchNilText;", "setSearchNilText", "(Lcom/ss/android/ugc/aweme/discover/model/SearchNilText;)V", "Lcom/ss/android/ugc/aweme/discover/model/GuideSearchWordsV2;", "guideSearchWordsV2", "Lcom/ss/android/ugc/aweme/discover/model/GuideSearchWordsV2;", "getGuideSearchWordsV2", "()Lcom/ss/android/ugc/aweme/discover/model/GuideSearchWordsV2;", "setGuideSearchWordsV2", "(Lcom/ss/android/ugc/aweme/discover/model/GuideSearchWordsV2;)V", "", "Lcom/ss/android/ugc/aweme/discover/model/GuideSearchWord;", "guideSearchWordList", "Ljava/util/List;", "getGuideSearchWordList", "()Ljava/util/List;", "setGuideSearchWordList", "(Ljava/util/List;)V", "Lcom/ss/android/ugc/aweme/discover/model/GuideSearchWordsExtra;", "guideSearchWordsExtra", "Lcom/ss/android/ugc/aweme/discover/model/GuideSearchWordsExtra;", "getGuideSearchWordsExtra", "()Lcom/ss/android/ugc/aweme/discover/model/GuideSearchWordsExtra;", "setGuideSearchWordsExtra", "(Lcom/ss/android/ugc/aweme/discover/model/GuideSearchWordsExtra;)V", "Lcom/ss/android/ugc/aweme/discover/model/QueryCorrectInfo;", "queryCorrectInfo", "Lcom/ss/android/ugc/aweme/discover/model/QueryCorrectInfo;", "getQueryCorrectInfo", "()Lcom/ss/android/ugc/aweme/discover/model/QueryCorrectInfo;", "setQueryCorrectInfo", "(Lcom/ss/android/ugc/aweme/discover/model/QueryCorrectInfo;)V", "Lcom/ss/android/ugc/aweme/discover/model/SearchPreventSuicide;", "suicidePrevent", "Lcom/ss/android/ugc/aweme/discover/model/SearchPreventSuicide;", "getSuicidePrevent", "()Lcom/ss/android/ugc/aweme/discover/model/SearchPreventSuicide;", "setSuicidePrevent", "(Lcom/ss/android/ugc/aweme/discover/model/SearchPreventSuicide;)V", "Lcom/ss/android/ugc/aweme/commercialize/model/SearchAdInfo;", "adInfo", "Lcom/ss/android/ugc/aweme/commercialize/model/SearchAdInfo;", "getAdInfo", "()Lcom/ss/android/ugc/aweme/commercialize/model/SearchAdInfo;", "setAdInfo", "(Lcom/ss/android/ugc/aweme/commercialize/model/SearchAdInfo;)V", "", "pollingInterval", "I", "getPollingInterval", "()I", "setPollingInterval", "(I)V", "Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;", "logPb", "Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;", "getLogPb", "()Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;", "setLogPb", "(Lcom/ss/android/ugc/aweme/feed/model/LogPbBean;)V", "Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/GlobalDoodleConfig;", "globalDoodleConfig", "Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/GlobalDoodleConfig;", "getGlobalDoodleConfig", "()Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/GlobalDoodleConfig;", "setGlobalDoodleConfig", "(Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/GlobalDoodleConfig;)V", "Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SearchBackgroundConfig;", "searchBackgroundConfig", "Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SearchBackgroundConfig;", "getSearchBackgroundConfig", "()Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SearchBackgroundConfig;", "setSearchBackgroundConfig", "(Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/SearchBackgroundConfig;)V", "Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/WaterfallSearchBackgroundConfig;", "waterfallSearchBackgroundConfig", "Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/WaterfallSearchBackgroundConfig;", "getWaterfallSearchBackgroundConfig", "()Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/WaterfallSearchBackgroundConfig;", "setWaterfallSearchBackgroundConfig", "(Lcom/ss/android/ugc/aweme/discover/model/globaldoodle/WaterfallSearchBackgroundConfig;)V", "Lcom/ss/android/ugc/aweme/discover/mixfeed/SearchEasterEggConfig;", "searchEasterEggConfig", "Lcom/ss/android/ugc/aweme/discover/mixfeed/SearchEasterEggConfig;", "getSearchEasterEggConfig", "()Lcom/ss/android/ugc/aweme/discover/mixfeed/SearchEasterEggConfig;", "setSearchEasterEggConfig", "(Lcom/ss/android/ugc/aweme/discover/mixfeed/SearchEasterEggConfig;)V", "Lcom/google/gson/JsonObject;", "serverTimeCost", "Lcom/google/gson/JsonObject;", "getServerTimeCost", "()Lcom/google/gson/JsonObject;", "setServerTimeCost", "(Lcom/google/gson/JsonObject;)V", "errorCode", "getErrorCode", "getErrorCode$annotations", "()V", "responseMessage", "Ljava/lang/String;", "getResponseMessage", "()Ljava/lang/String;", "", "disableFeedScroll", "Ljava/lang/Boolean;", "getDisableFeedScroll", "()Ljava/lang/Boolean;", "guideSearchBarHideExtra", "getGuideSearchBarHideExtra", "getGuideSearchBarHideExtra$annotations", "Lcom/ss/android/ugc/aweme/discover/model/immersive/SearchImmersiveConfig;", "immersiveData", "Lcom/ss/android/ugc/aweme/discover/model/immersive/SearchImmersiveConfig;", "getImmersiveData", "()Lcom/ss/android/ugc/aweme/discover/model/immersive/SearchImmersiveConfig;", "<init>", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECSearchBaseResponse extends CommerceBaseResponse {

    @SerializedName("ad_info")
    private SearchAdInfo adInfo;
    private final Boolean disableFeedScroll;
    private final int errorCode;

    @SerializedName("global_doodle_config")
    private GlobalDoodleConfig globalDoodleConfig;
    private final String guideSearchBarHideExtra;

    @SerializedName("guide_search_words")
    private List<GuideSearchWord> guideSearchWordList;

    @SerializedName("guide_search_words_extra")
    private GuideSearchWordsExtra guideSearchWordsExtra;

    @SerializedName("guide_search_wordsv2")
    private GuideSearchWordsV2 guideSearchWordsV2;
    private final SearchImmersiveConfig immersiveData;

    @SerializedName("log_pb")
    private LogPbBean logPb;

    @SerializedName("polling_time")
    private int pollingInterval;

    @SerializedName("query_correct_info")
    private QueryCorrectInfo queryCorrectInfo;
    private final String responseMessage;

    @SerializedName("search_background_config")
    private SearchBackgroundConfig searchBackgroundConfig;

    @SerializedName("search_easter_egg_config")
    private SearchEasterEggConfig searchEasterEggConfig;

    @SerializedName("search_nil_info")
    private SearchNilInfo searchNilInfo;

    @SerializedName("search_nil_text")
    private SearchNilText searchNilText;

    @SerializedName("time_cost")
    @JsonAdapter(ECJsonNullToJsonObjectAdapter.class)
    private JsonObject serverTimeCost;

    @SerializedName("suicide_prevent")
    private SearchPreventSuicide suicidePrevent;

    @SerializedName("waterfall_search_background_config")
    private WaterfallSearchBackgroundConfig waterfallSearchBackgroundConfig;

    @AllowImpl
    public static /* synthetic */ void getErrorCode$annotations() {
    }

    @AllowImpl
    public static /* synthetic */ void getGuideSearchBarHideExtra$annotations() {
    }

    public String getRequestId() {
        return null;
    }

    @AllowImpl
    public WaterfallSearchBackgroundConfig getWaterfallSearchBackgroundConfig() {
        return null;
    }

    public void setRequestId(String r100) {
    }

    @AllowImpl
    public void setWaterfallSearchBackgroundConfig(WaterfallSearchBackgroundConfig r100) {
    }

    public ECSearchBaseResponse() {
        this.errorCode = getStatusCode();
        this.responseMessage = getMessage();
        this.disableFeedScroll = Boolean.FALSE;
    }

    @AllowImpl
    public SearchAdInfo getAdInfo() {
        return this.adInfo;
    }

    public Boolean getDisableFeedScroll() {
        return this.disableFeedScroll;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    @AllowImpl
    public GlobalDoodleConfig getGlobalDoodleConfig() {
        return this.globalDoodleConfig;
    }

    public String getGuideSearchBarHideExtra() {
        return this.guideSearchBarHideExtra;
    }

    @AllowImpl
    public List<GuideSearchWord> getGuideSearchWordList() {
        return this.guideSearchWordList;
    }

    @AllowImpl
    public GuideSearchWordsExtra getGuideSearchWordsExtra() {
        return this.guideSearchWordsExtra;
    }

    @AllowImpl
    public GuideSearchWordsV2 getGuideSearchWordsV2() {
        return this.guideSearchWordsV2;
    }

    public SearchImmersiveConfig getImmersiveData() {
        return this.immersiveData;
    }

    @AllowImpl
    public LogPbBean getLogPb() {
        return this.logPb;
    }

    @AllowImpl
    public int getPollingInterval() {
        return this.pollingInterval;
    }

    @AllowImpl
    public QueryCorrectInfo getQueryCorrectInfo() {
        return this.queryCorrectInfo;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }

    @AllowImpl
    public SearchBackgroundConfig getSearchBackgroundConfig() {
        return this.searchBackgroundConfig;
    }

    @AllowImpl
    public SearchEasterEggConfig getSearchEasterEggConfig() {
        return this.searchEasterEggConfig;
    }

    @AllowImpl
    public SearchNilInfo getSearchNilInfo() {
        return this.searchNilInfo;
    }

    @AllowImpl
    public SearchNilText getSearchNilText() {
        return this.searchNilText;
    }

    @AllowImpl
    public JsonObject getServerTimeCost() {
        return this.serverTimeCost;
    }

    @AllowImpl
    public SearchPreventSuicide getSuicidePrevent() {
        return this.suicidePrevent;
    }

    @AllowImpl
    public void setAdInfo(SearchAdInfo r100) {
        this.adInfo = r100;
    }

    @AllowImpl
    public void setGlobalDoodleConfig(GlobalDoodleConfig r100) {
        this.globalDoodleConfig = r100;
    }

    @AllowImpl
    public void setGuideSearchWordList(List<GuideSearchWord> r100) {
        this.guideSearchWordList = r100;
    }

    @AllowImpl
    public void setGuideSearchWordsExtra(GuideSearchWordsExtra r100) {
        this.guideSearchWordsExtra = r100;
    }

    @AllowImpl
    public void setGuideSearchWordsV2(GuideSearchWordsV2 r100) {
        this.guideSearchWordsV2 = r100;
    }

    @AllowImpl
    public void setLogPb(LogPbBean r100) {
        this.logPb = r100;
    }

    @AllowImpl
    public void setPollingInterval(int r100) {
        this.pollingInterval = r100;
    }

    @AllowImpl
    public void setQueryCorrectInfo(QueryCorrectInfo r100) {
        this.queryCorrectInfo = r100;
    }

    @AllowImpl
    public void setSearchBackgroundConfig(SearchBackgroundConfig r100) {
        this.searchBackgroundConfig = r100;
    }

    @AllowImpl
    public void setSearchEasterEggConfig(SearchEasterEggConfig r100) {
        this.searchEasterEggConfig = r100;
    }

    @AllowImpl
    public void setSearchNilInfo(SearchNilInfo r100) {
        this.searchNilInfo = r100;
    }

    @AllowImpl
    public void setSearchNilText(SearchNilText r100) {
        this.searchNilText = r100;
    }

    @AllowImpl
    public void setServerTimeCost(JsonObject r100) {
        this.serverTimeCost = r100;
    }

    @AllowImpl
    public void setSuicidePrevent(SearchPreventSuicide r100) {
        this.suicidePrevent = r100;
    }
}
