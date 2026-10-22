package com.ss.android.lark.search.dto.setting;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.bytedance.lark.pb.search.v2.SearchEntityType;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes38.dex */
@AppConfig(key = "suite_search_client_config")
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b9\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\b\b\u0007\u0018\u0000 l2\u00020\u0001:\u0001lB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010k\u001a\u00020!H\u0016R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R$\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010+\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*R\u001e\u0010.\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010(\"\u0004\b0\u0010*R\u001e\u00101\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010(\"\u0004\b3\u0010*R$\u00104\u001a\b\u0012\u0004\u0012\u00020!0 8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010#\"\u0004\b6\u0010%R$\u00107\u001a\b\u0012\u0004\u0012\u00020!0 8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010#\"\u0004\b9\u0010%R$\u0010:\u001a\b\u0012\u0004\u0012\u00020!0 8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010#\"\u0004\b<\u0010%R\u001e\u0010=\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001e\u0010B\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010(\"\u0004\bD\u0010*R\u001e\u0010E\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010(\"\u0004\bG\u0010*R\u001e\u0010H\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010(\"\u0004\bJ\u0010*R\u001e\u0010K\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010?\"\u0004\bM\u0010AR\u001e\u0010N\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010?\"\u0004\bP\u0010AR\u001e\u0010Q\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010?\"\u0004\bS\u0010AR\u001e\u0010T\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010?\"\u0004\bV\u0010AR\u001e\u0010W\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010?\"\u0004\bY\u0010AR>\u0010Z\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010[j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\\8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R>\u0010a\u001a\"\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!\u0018\u00010[j\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!\u0018\u0001`\\8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010^\"\u0004\bc\u0010`R$\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00050e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010#\"\u0004\bg\u0010%R\u001e\u0010h\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010?\"\u0004\bj\u0010A¨\u0006m"}, d2 = {"Lcom/ss/android/lark/search/dto/setting/SearchArgsSetting;", "", "<init>", "()V", "emptyChatLen", "", "topNLimit", "debounceMs", "", "firstCharDebounce", "firstCharLowDeviceDebounce", "lowDeviceDebounce", "onScreenLimitTimeMs", "onSearchLoadingShowDelayTimeMs", "onFeedbackOrientationDelayTimeMs", "searchEnableRecommendLoading", "", "searchEnableMonitor", "searchTabUpdate", "debounceForQAInSearch", "chineseLengthThreshold", "englishLengthThreshold", "mixLengthThreshold", "pinyinSearchTimeout", "answerInSearchAnimInterval", "isTenantNotPayed", "searchDocTipDuration", "searchInChatMyAiQaEntranceMinResultCount", "searchInChatMyAiQaEntranceRequestIntervalMin", "searchInChatMyAiQaEntranceRequestIntervalMax", "thumbnailRequestLimitTime", "thumbnailFileType", "", "", "getThumbnailFileType", "()Ljava/util/List;", "setThumbnailFileType", "(Ljava/util/List;)V", "thumbnailFoldPlayLimitWidth", "getThumbnailFoldPlayLimitWidth", "()J", "setThumbnailFoldPlayLimitWidth", "(J)V", "startPreloadThumbnailDuration", "getStartPreloadThumbnailDuration", "setStartPreloadThumbnailDuration", "delayShowThumbnailDuration", "getDelayShowThumbnailDuration", "setDelayShowThumbnailDuration", "thumbnailPullDismissHeight", "getThumbnailPullDismissHeight", "setThumbnailPullDismissHeight", "voiceInputATipList", "getVoiceInputATipList", "setVoiceInputATipList", "voiceInputBTipList", "getVoiceInputBTipList", "setVoiceInputBTipList", "deleteCharList", "getDeleteCharList", "setDeleteCharList", "answerInVoiceOptAnswerPosQueryCount", "getAnswerInVoiceOptAnswerPosQueryCount", "()I", "setAnswerInVoiceOptAnswerPosQueryCount", "(I)V", "voiceInputQueryChangeTime", "getVoiceInputQueryChangeTime", "setVoiceInputQueryChangeTime", "firstVoiceInputQueryChangeTime", "getFirstVoiceInputQueryChangeTime", "setFirstVoiceInputQueryChangeTime", "voiceInputDBChangeTime", "getVoiceInputDBChangeTime", "setVoiceInputDBChangeTime", "voiceInputDBThreshold", "getVoiceInputDBThreshold", "setVoiceInputDBThreshold", "scrollPageLimit", "getScrollPageLimit", "setScrollPageLimit", "searchPutAiRoundTimeOut", "getSearchPutAiRoundTimeOut", "setSearchPutAiRoundTimeOut", "searchDeleteQAHistoryTimeOut", "getSearchDeleteQAHistoryTimeOut", "setSearchDeleteQAHistoryTimeOut", "knowledgeStreamButterHeight", "getKnowledgeStreamButterHeight", "setKnowledgeStreamButterHeight", "qaSectionSpotlightEntityMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getQaSectionSpotlightEntityMap", "()Ljava/util/HashMap;", "setQaSectionSpotlightEntityMap", "(Ljava/util/HashMap;)V", "appIDMap", "getAppIDMap", "setAppIDMap", "qaSpecialSectionEntityList", "", "getQaSpecialSectionEntityList", "setQaSpecialSectionEntityList", "searchKnowledgeShineCount", "getSearchKnowledgeShineCount", "setSearchKnowledgeShineCount", "toString", "Companion", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchArgsSetting {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f440207a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f440208b = null;

    @SerializedName("answer_in_search_refresh_interval_ms")
    public long answerInSearchAnimInterval;

    @SerializedName("answer_in_search_asr_short_query_count")
    private int answerInVoiceOptAnswerPosQueryCount;

    @SerializedName("app_id_map")
    private HashMap<String, String> appIDMap;

    @SerializedName("answer_in_search_short_query_count_only_chinese")
    public int chineseLengthThreshold;

    @SerializedName("answer_in_search_delay_ms")
    public long debounceForQAInSearch;

    @SerializedName("search_debounce_ms")
    public long debounceMs;

    @SerializedName("delay_show_thumbnail_duration_for_long_press")
    private long delayShowThumbnailDuration;

    @SerializedName("delete_char_list_in_query_end")
    private List<String> deleteCharList;

    @SerializedName("search_in_chat_messages_empty_char_length")
    public int emptyChatLen;

    @SerializedName("answer_in_search_short_query_count_only_english")
    public int englishLengthThreshold;

    @SerializedName("search_first_char_debounce")
    public long firstCharDebounce;

    @SerializedName("search_first_char_low_device_debounce")
    public long firstCharLowDeviceDebounce;

    @SerializedName("first_voice_input_query_change_time")
    private long firstVoiceInputQueryChangeTime;

    @SerializedName("is_tenant_not_payed")
    public boolean isTenantNotPayed;

    @SerializedName("knowledge_stream_buffer_height")
    private int knowledgeStreamButterHeight;

    @SerializedName("search_low_device_debounce")
    public long lowDeviceDebounce;

    @SerializedName("answer_in_search_short_query_count_mix")
    public int mixLengthThreshold;

    @SerializedName("search_feedback_orientation_delay_ms")
    public int onFeedbackOrientationDelayTimeMs;

    @SerializedName("search_main_onscreen_waiting_time")
    public int onScreenLimitTimeMs;

    @SerializedName("search_loadingShow_delay_ms")
    public int onSearchLoadingShowDelayTimeMs;

    @SerializedName("pinyin_search_chatter_timeout_ms")
    public long pinyinSearchTimeout;

    @SerializedName("qa_section_spotlight_entity_map")
    private HashMap<Integer, Integer> qaSectionSpotlightEntityMap;

    @SerializedName("qa_special_section_entity_list")
    private List<Integer> qaSpecialSectionEntityList;

    @SerializedName("feedback_card_show_distance")
    private int scrollPageLimit;

    @SerializedName("search_delete_qa_history_time_out")
    private int searchDeleteQAHistoryTimeOut;

    @SerializedName("search_doc_tip_duration")
    public long searchDocTipDuration;

    @SerializedName("enable_post_stable_tracker")
    public boolean searchEnableMonitor;

    @SerializedName("search_enable_recommend_loading")
    public boolean searchEnableRecommendLoading;

    @SerializedName("search_in_chat_myai_qa_entrence_min_result_count")
    public int searchInChatMyAiQaEntranceMinResultCount;

    @SerializedName("search_in_chat_myai_qa_entrence_request_interval_max")
    public int searchInChatMyAiQaEntranceRequestIntervalMax;

    @SerializedName("search_in_chat_myai_qa_entrence_request_interval_min")
    public int searchInChatMyAiQaEntranceRequestIntervalMin;

    @SerializedName("search_knowledge_confirm_flash_count")
    private int searchKnowledgeShineCount;

    @SerializedName("search_put_ai_round_time_out")
    private int searchPutAiRoundTimeOut;

    @SerializedName("enable_fix_search_tab_update")
    public boolean searchTabUpdate;

    @SerializedName("start_preload_thumbnail_duration_for_long_press")
    private long startPreloadThumbnailDuration;

    @SerializedName("thumbnail_suffix_list")
    private List<String> thumbnailFileType;

    @SerializedName("thumnail_fold_play_limit_width")
    private long thumbnailFoldPlayLimitWidth;

    @SerializedName("thumbnail_pull_dismiss_height")
    private long thumbnailPullDismissHeight;

    @SerializedName("thumbnail_request_limit_time")
    public int thumbnailRequestLimitTime;

    @SerializedName("search_top_n_report_limit")
    public int topNLimit;

    @SerializedName("voice_input_tip_list_fg_open")
    private List<String> voiceInputATipList;

    @SerializedName("voice_input_tip_list_fg_close")
    private List<String> voiceInputBTipList;

    @SerializedName("voice_input_db_change_time")
    private long voiceInputDBChangeTime;

    @SerializedName("voice_input_db_threshold")
    private int voiceInputDBThreshold;

    @SerializedName("voice_input_query_change_time")
    private long voiceInputQueryChangeTime;

    public static final class a {
    }

    static {
        f440207a = CollectionsKt.listOf(new String[]{"!", ".", "！", "。"});
        f440208b = CollectionsKt.listOf(new String[]{ExportFileExtension.PDF, "ppt", ExportFileExtension.PPTX, "pps", "ppsx", "doc", DocumentType.DOCX_NAME, "dot", "dotx", "csv", "xls", "xlsx", "xlsm"});
    }

    public final String toString() {
        return "SearchArgsSetting{emptyChatLen=" + this.emptyChatLen + ", isTNPed=" + this.isTenantNotPayed + ", topNLimit=" + this.topNLimit + ", debounceMs=" + this.debounceMs + ", onScreenLimitTimeMs=" + this.onScreenLimitTimeMs + ", onQuerySearchDelayTimeMs=" + this.onSearchLoadingShowDelayTimeMs + "}, onFeedbackOrientationDelayTimeMs=" + this.onFeedbackOrientationDelayTimeMs + '}';
    }

    public SearchArgsSetting() {
        this.topNLimit = 5;
        this.debounceMs = 200;
        this.firstCharDebounce = 400;
        this.firstCharLowDeviceDebounce = 600;
        this.lowDeviceDebounce = 300;
        this.onScreenLimitTimeMs = 400;
        this.onSearchLoadingShowDelayTimeMs = 300;
        this.onFeedbackOrientationDelayTimeMs = 100;
        this.searchEnableRecommendLoading = true;
        this.searchEnableMonitor = true;
        this.searchTabUpdate = true;
        this.debounceForQAInSearch = 100;
        this.chineseLengthThreshold = 8;
        this.englishLengthThreshold = 4;
        this.mixLengthThreshold = 5;
        this.pinyinSearchTimeout = 400;
        this.answerInSearchAnimInterval = 80;
        this.searchDocTipDuration = 3000;
        this.searchInChatMyAiQaEntranceRequestIntervalMin = 5;
        this.searchInChatMyAiQaEntranceRequestIntervalMax = 60;
        this.thumbnailRequestLimitTime = 6000;
        this.thumbnailFileType = f440208b;
        this.thumbnailFoldPlayLimitWidth = 411;
        this.startPreloadThumbnailDuration = 100;
        this.delayShowThumbnailDuration = 150;
        this.thumbnailPullDismissHeight = 50;
        this.voiceInputATipList = CollectionsKt.emptyList();
        this.voiceInputBTipList = CollectionsKt.emptyList();
        this.deleteCharList = f440207a;
        this.answerInVoiceOptAnswerPosQueryCount = 4;
        this.voiceInputQueryChangeTime = 1000;
        this.firstVoiceInputQueryChangeTime = 10000;
        this.voiceInputDBChangeTime = 3000;
        this.voiceInputDBThreshold = 30;
        this.scrollPageLimit = 5;
        this.searchPutAiRoundTimeOut = 500;
        this.searchDeleteQAHistoryTimeOut = 800;
        this.knowledgeStreamButterHeight = 108;
        HashMap<Integer, Integer> r100 = new HashMap();
        r100.put(Integer.valueOf(SearchEntityType.USER.getValue()), 0);
        r100.put(Integer.valueOf(SearchEntityType.GROUP_CHAT.getValue()), 0);
        this.qaSectionSpotlightEntityMap = r100;
        HashMap<String, String> r101 = new HashMap();
        r101.put("knowledge", "7478165836852183041");
        this.appIDMap = r101;
        ArrayList r102 = new ArrayList();
        r102.add(Integer.valueOf(SearchEntityType.MESSAGE.getValue()));
        this.qaSpecialSectionEntityList = r102;
        this.searchKnowledgeShineCount = 5;
    }
}
