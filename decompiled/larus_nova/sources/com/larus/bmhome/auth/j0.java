package com.larus.bmhome.auth;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.auth.feature_config.model.FeatureDetail;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bP\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BÅ\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\"\u0010#J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0017\u0010F\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u0011\u0010G\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\bHÆ\u0003JÇ\u0002\u0010]\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010^\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010a\u001a\u00020bHÖ\u0001J\t\u0010c\u001a\u00020\bHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R$\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010/R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010/R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010/R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010/R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010/R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010/R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010/R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010/R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010/R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010/R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010/R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010/R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010/R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010/R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010/R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010/R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b@\u0010/R\u0018\u0010 \u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010/R\u0018\u0010!\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010C¨\u0006d"}, d2 = {"Lcom/larus/bmhome/auth/IMLaunchInfo;", "", "config", "Lcom/larus/bmhome/auth/Config;", "imConfig", "Lcom/larus/bmhome/auth/IMConfig;", "conversationBgContent", "", "", "previewUrlPrefixes", "", "suggestClearConf", "Lcom/larus/bmhome/auth/SuggestClearConf;", "namedEntityHighlight", "Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;", "answerWithSuggest", "answerWithVideo", "sendImageMessage", "profileJump", "botHeat", "botRecommendSearch", "bio", "filterAddedConversationInRecommend", "saveChatHistory", "sendFileMessage", "sendMultiFileMessage", "settingExpert", "actionbarExpert", "expertCardAutoCollapse", "sendVlmImageMessage", "sendMultiImageMessage", "sendMultiFileImageMessage", "sendAudioMessage", "aiChatFoldLoadingText", "<init>", "(Lcom/larus/bmhome/auth/Config;Lcom/larus/bmhome/auth/IMConfig;Ljava/util/Map;Ljava/util/List;Lcom/larus/bmhome/auth/SuggestClearConf;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;Ljava/lang/String;)V", "getConfig", "()Lcom/larus/bmhome/auth/Config;", "getImConfig", "()Lcom/larus/bmhome/auth/IMConfig;", "getConversationBgContent", "()Ljava/util/Map;", "getPreviewUrlPrefixes", "()Ljava/util/List;", "getSuggestClearConf", "()Lcom/larus/bmhome/auth/SuggestClearConf;", "getNamedEntityHighlight", "()Lcom/larus/bmhome/auth/feature_config/model/FeatureDetail;", "getAnswerWithSuggest", "getAnswerWithVideo", "getSendImageMessage", "getProfileJump", "getBotHeat", "getBotRecommendSearch", "getBio", "getFilterAddedConversationInRecommend", "getSaveChatHistory", "getSendFileMessage", "getSendMultiFileMessage", "getSettingExpert", "getActionbarExpert", "getExpertCardAutoCollapse", "getSendVlmImageMessage", "getSendMultiImageMessage", "getSendMultiFileImageMessage", "getSendAudioMessage", "getAiChatFoldLoadingText", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "copy", "equals", "", "other", "hashCode", "", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class j0 {

    @SerializedName("actionbar_expert")
    private final FeatureDetail actionbarExpert;

    @SerializedName("ai_chat_fold_loading_text")
    private final String aiChatFoldLoadingText;

    @SerializedName("answer_with_suggest")
    private final FeatureDetail answerWithSuggest;

    @SerializedName("answer_with_video")
    private final FeatureDetail answerWithVideo;

    @SerializedName("bio")
    private final FeatureDetail bio;

    @SerializedName("bot_heat")
    private final FeatureDetail botHeat;

    @SerializedName("bot_recommend_search")
    private final FeatureDetail botRecommendSearch;

    @SerializedName(alternate = {"config"}, value = "im_launch_config")
    private final Config config;

    @SerializedName("conversation_bg_content")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final Map<String, String> conversationBgContent;

    @SerializedName("expert_card_auto_collapse")
    private final FeatureDetail expertCardAutoCollapse;

    @SerializedName("filter_added_conversation_in_recommend")
    private final FeatureDetail filterAddedConversationInRecommend;

    @SerializedName("im_config")
    private final IMConfig imConfig;

    @SerializedName("named_entity_highlight")
    private final FeatureDetail namedEntityHighlight;

    @SerializedName("preview_url_prefixes")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> previewUrlPrefixes;

    @SerializedName("profile_jump")
    private final FeatureDetail profileJump;

    @SerializedName("save_chat_history")
    private final FeatureDetail saveChatHistory;

    @SerializedName("send_audio_message")
    private final FeatureDetail sendAudioMessage;

    @SerializedName("send_file_message")
    private final FeatureDetail sendFileMessage;

    @SerializedName("send_image_message")
    private final FeatureDetail sendImageMessage;

    @SerializedName("send_multi_file_image_message")
    private final FeatureDetail sendMultiFileImageMessage;

    @SerializedName("send_multi_file_message")
    private final FeatureDetail sendMultiFileMessage;

    @SerializedName("send_multi_image_message")
    private final FeatureDetail sendMultiImageMessage;

    @SerializedName("send_vlm_image_message")
    private final FeatureDetail sendVlmImageMessage;

    @SerializedName("setting_expert")
    private final FeatureDetail settingExpert;

    @SerializedName("suggest_clear_conf")
    private final SuggestClearConf suggestClearConf;

    public j0() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j0) == true) goto L8;
        return false;
    L8:
        j0 r101 = (j0) r100;
        if (Intrinsics.areEqual(this.config, r101.config) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imConfig, r101.imConfig) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.conversationBgContent, r101.conversationBgContent) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.previewUrlPrefixes, r101.previewUrlPrefixes) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.suggestClearConf, r101.suggestClearConf) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.namedEntityHighlight, r101.namedEntityHighlight) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.answerWithSuggest, r101.answerWithSuggest) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.answerWithVideo, r101.answerWithVideo) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.sendImageMessage, r101.sendImageMessage) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.profileJump, r101.profileJump) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.botHeat, r101.botHeat) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.botRecommendSearch, r101.botRecommendSearch) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.bio, r101.bio) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.filterAddedConversationInRecommend, r101.filterAddedConversationInRecommend) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.saveChatHistory, r101.saveChatHistory) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.sendFileMessage, r101.sendFileMessage) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.sendMultiFileMessage, r101.sendMultiFileMessage) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.settingExpert, r101.settingExpert) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.actionbarExpert, r101.actionbarExpert) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.expertCardAutoCollapse, r101.expertCardAutoCollapse) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.sendVlmImageMessage, r101.sendVlmImageMessage) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.sendMultiImageMessage, r101.sendMultiImageMessage) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.sendMultiFileImageMessage, r101.sendMultiFileImageMessage) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.sendAudioMessage, r101.sendAudioMessage) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.aiChatFoldLoadingText, r101.aiChatFoldLoadingText) == true) goto L83;
        return false;
    L83:
        return true;
    }

    public final int hashCode() {
        Config r100 = this.config;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        IMConfig r104 = this.imConfig;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, String> r107 = this.conversationBgContent;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.previewUrlPrefixes;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        SuggestClearConf r113 = this.suggestClearConf;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        FeatureDetail r116 = this.namedEntityHighlight;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        FeatureDetail r119 = this.answerWithSuggest;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        FeatureDetail r122 = this.answerWithVideo;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        FeatureDetail r125 = this.sendImageMessage;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        FeatureDetail r128 = this.profileJump;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        FeatureDetail r131 = this.botHeat;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        FeatureDetail r134 = this.botRecommendSearch;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        FeatureDetail r137 = this.bio;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        FeatureDetail r140 = this.filterAddedConversationInRecommend;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        FeatureDetail r143 = this.saveChatHistory;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        FeatureDetail r146 = this.sendFileMessage;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        FeatureDetail r149 = this.sendMultiFileMessage;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        FeatureDetail r152 = this.settingExpert;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (r151 + r153) * 31;
        FeatureDetail r155 = this.actionbarExpert;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (r154 + r156) * 31;
        FeatureDetail r158 = this.expertCardAutoCollapse;
        if (r158 != null) goto L81;
        int r159 = 0;
    L82:
        int r160 = (r157 + r159) * 31;
        FeatureDetail r161 = this.sendVlmImageMessage;
        if (r161 != null) goto L85;
        int r162 = 0;
    L86:
        int r163 = (r160 + r162) * 31;
        FeatureDetail r164 = this.sendMultiImageMessage;
        if (r164 != null) goto L89;
        int r165 = 0;
    L90:
        int r166 = (r163 + r165) * 31;
        FeatureDetail r167 = this.sendMultiFileImageMessage;
        if (r167 != null) goto L93;
        int r168 = 0;
    L94:
        int r169 = (r166 + r168) * 31;
        FeatureDetail r170 = this.sendAudioMessage;
        if (r170 != null) goto L97;
        int r171 = 0;
    L98:
        int r172 = (r169 + r171) * 31;
        String r173 = this.aiChatFoldLoadingText;
        if (r173 == null) goto L103;
        r101 = r173.hashCode();
    L103:
        return r172 + r101;
    L97:
        r171 = r170.hashCode();
        goto L98
    L93:
        r168 = r167.hashCode();
        goto L94
    L89:
        r165 = r164.hashCode();
        goto L90
    L85:
        r162 = r161.hashCode();
        goto L86
    L81:
        r159 = r158.hashCode();
        goto L82
    L77:
        r156 = r155.hashCode();
        goto L78
    L73:
        r153 = r152.hashCode();
        goto L74
    L69:
        r150 = r149.hashCode();
        goto L70
    L65:
        r147 = r146.hashCode();
        goto L66
    L61:
        r144 = r143.hashCode();
        goto L62
    L57:
        r141 = r140.hashCode();
        goto L58
    L53:
        r138 = r137.hashCode();
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "IMLaunchInfo(config=" + this.config + ", imConfig=" + this.imConfig + ", conversationBgContent=" + this.conversationBgContent + ", previewUrlPrefixes=" + this.previewUrlPrefixes + ", suggestClearConf=" + this.suggestClearConf + ", namedEntityHighlight=" + this.namedEntityHighlight + ", answerWithSuggest=" + this.answerWithSuggest + ", answerWithVideo=" + this.answerWithVideo + ", sendImageMessage=" + this.sendImageMessage + ", profileJump=" + this.profileJump + ", botHeat=" + this.botHeat + ", botRecommendSearch=" + this.botRecommendSearch + ", bio=" + this.bio + ", filterAddedConversationInRecommend=" + this.filterAddedConversationInRecommend + ", saveChatHistory=" + this.saveChatHistory + ", sendFileMessage=" + this.sendFileMessage + ", sendMultiFileMessage=" + this.sendMultiFileMessage + ", settingExpert=" + this.settingExpert + ", actionbarExpert=" + this.actionbarExpert + ", expertCardAutoCollapse=" + this.expertCardAutoCollapse + ", sendVlmImageMessage=" + this.sendVlmImageMessage + ", sendMultiImageMessage=" + this.sendMultiImageMessage + ", sendMultiFileImageMessage=" + this.sendMultiFileImageMessage + ", sendAudioMessage=" + this.sendAudioMessage + ", aiChatFoldLoadingText=" + this.aiChatFoldLoadingText + ')';
    }

    public final FeatureDetail a() {
        return this.actionbarExpert;
    }

    public final String b() {
        return this.aiChatFoldLoadingText;
    }

    public final FeatureDetail c() {
        return this.answerWithSuggest;
    }

    public final FeatureDetail d() {
        return this.answerWithVideo;
    }

    public final FeatureDetail e() {
        return this.bio;
    }

    public final FeatureDetail f() {
        return this.botHeat;
    }

    public final FeatureDetail g() {
        return this.botRecommendSearch;
    }

    public final Config h() {
        return this.config;
    }

    public final Map<String, String> i() {
        return this.conversationBgContent;
    }

    public final FeatureDetail j() {
        return this.expertCardAutoCollapse;
    }

    public final FeatureDetail k() {
        return this.filterAddedConversationInRecommend;
    }

    public final IMConfig l() {
        return this.imConfig;
    }

    public final FeatureDetail m() {
        return this.namedEntityHighlight;
    }

    public final List<String> n() {
        return this.previewUrlPrefixes;
    }

    public final FeatureDetail o() {
        return this.profileJump;
    }

    public final FeatureDetail p() {
        return this.saveChatHistory;
    }

    public final FeatureDetail q() {
        return this.sendAudioMessage;
    }

    public final FeatureDetail r() {
        return this.sendFileMessage;
    }

    public final FeatureDetail s() {
        return this.sendImageMessage;
    }

    public final FeatureDetail t() {
        return this.sendMultiFileImageMessage;
    }

    public final FeatureDetail u() {
        return this.sendMultiFileMessage;
    }

    public final FeatureDetail v() {
        return this.sendMultiImageMessage;
    }

    public final FeatureDetail w() {
        return this.sendVlmImageMessage;
    }

    public final FeatureDetail x() {
        return this.settingExpert;
    }

    public final SuggestClearConf y() {
        return this.suggestClearConf;
    }

    public j0(Config r100, IMConfig r101, Map<String, String> r102, List<String> r103, SuggestClearConf r104, FeatureDetail r105, FeatureDetail r106, FeatureDetail r110, FeatureDetail r111, FeatureDetail r112, FeatureDetail r113, FeatureDetail r114, FeatureDetail r115, FeatureDetail r116, FeatureDetail r117, FeatureDetail r118, FeatureDetail r119, FeatureDetail r210, FeatureDetail r211, FeatureDetail r212, FeatureDetail r213, FeatureDetail r214, FeatureDetail r215, FeatureDetail r216, String r217) {
        this.config = r100;
        this.imConfig = r101;
        this.conversationBgContent = r102;
        this.previewUrlPrefixes = r103;
        this.suggestClearConf = r104;
        this.namedEntityHighlight = r105;
        this.answerWithSuggest = r106;
        this.answerWithVideo = r110;
        this.sendImageMessage = r111;
        this.profileJump = r112;
        this.botHeat = r113;
        this.botRecommendSearch = r114;
        this.bio = r115;
        this.filterAddedConversationInRecommend = r116;
        this.saveChatHistory = r117;
        this.sendFileMessage = r118;
        this.sendMultiFileMessage = r119;
        this.settingExpert = r210;
        this.actionbarExpert = r211;
        this.expertCardAutoCollapse = r212;
        this.sendVlmImageMessage = r213;
        this.sendMultiImageMessage = r214;
        this.sendMultiFileImageMessage = r215;
        this.sendAudioMessage = r216;
        this.aiChatFoldLoadingText = r217;
    }
}
