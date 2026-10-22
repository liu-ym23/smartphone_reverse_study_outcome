package com.larus.voicecall.api.bean;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b;\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\u0018\u0010 \u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R\u0018\u0010\"\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0007R\u0018\u0010$\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0007R\u0018\u0010%\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0007R\u0018\u0010&\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0007R\u0018\u0010(\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0007R\u0018\u0010*\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0007R\u0018\u0010,\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0007R\u0018\u0010.\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0007R\u0018\u00100\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0007R\u0018\u00102\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0007R\u0018\u00104\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0007R\u0018\u00106\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0007R\u0018\u00108\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0007R\u0018\u0010:\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0007R\u0018\u0010<\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0007R\u0018\u0010>\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0007¨\u0006@"}, d2 = {"Lcom/larus/voicecall/api/bean/ChatParam;", "", "<init>", "()V", "artistName", "", "getArtistName", "()Ljava/lang/String;", "coverUri", "getCoverUri", "coverUrls", "getCoverUrls", "songName", "getSongName", "templatePrefix", "getTemplatePrefix", "popupText", "getPopupText", "refuseText", "getRefuseText", "uiType", "getUiType", "botId", "getBotId", "cvsId", "getCvsId", "jumpUrl", "getJumpUrl", "spaceId", "getSpaceId", "questionId", "getQuestionId", "answerId", "getAnswerId", "intention", "getIntention", "isPacity", "isChatRespFirst", "agentId", "getAgentId", "pluginId", "getPluginId", "teaTagsInfo", "getTeaTagsInfo", "fpaCommonParams", "getFpaCommonParams", "ackRemindType", "getAckRemindType", "notificationMsgId", "getNotificationMsgId", "notificationScene", "getNotificationScene", "needConfirm", "getNeedConfirm", "activePushRound", "getActivePushRound", "intentionItems", "getIntentionItems", "visionModeIntention", "getVisionModeIntention", "modeControlParams", "getModeControlParams", "sourceMessageId", "getSourceMessageId", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatParam {

    @SerializedName("ack_remind_type")
    private final String ackRemindType;

    @SerializedName("active_push_round")
    private final String activePushRound;

    @SerializedName("agent_id")
    private final String agentId;

    @SerializedName("vui_auth_answer_id")
    private final String answerId;

    @SerializedName("artist_name")
    private final String artistName;

    @SerializedName("vui_auth_bot_id")
    private final String botId;

    @SerializedName("cover_uri")
    private final String coverUri;

    @SerializedName("cover_urls")
    private final String coverUrls;

    @SerializedName("vui_auth_conversation_id")
    private final String cvsId;

    @SerializedName("fpa_common_param")
    private final String fpaCommonParams;

    @SerializedName("intention")
    private final String intention;

    @SerializedName("vision_intention")
    private final String intentionItems;

    @SerializedName("is_chat_resp_first")
    private final String isChatRespFirst;

    @SerializedName("is_pacity")
    private final String isPacity;

    @SerializedName("vui_auth_jump_url")
    private final String jumpUrl;

    @SerializedName("mode_control_params")
    private final String modeControlParams;

    @SerializedName("need_conform_notification")
    private final String needConfirm;

    @SerializedName("summary_id")
    private final String notificationMsgId;

    @SerializedName("summary_scene")
    private final String notificationScene;

    @SerializedName("vui_auth_plugin_id")
    private final String pluginId;

    @SerializedName("vui_auth_popup_text")
    private final String popupText;

    @SerializedName("vui_auth_question_id")
    private final String questionId;

    @SerializedName("vui_auth_refuse_text")
    private final String refuseText;

    @SerializedName("song_name")
    private final String songName;

    @SerializedName("source_message_id")
    private final String sourceMessageId;

    @SerializedName("vui_auth_space_id")
    private final String spaceId;

    @SerializedName("tea_tags_time_cost")
    private final String teaTagsInfo;

    @SerializedName("template_prefix")
    private final String templatePrefix;

    @SerializedName("vui_auth_ui_type")
    private final String uiType;

    @SerializedName("vision_mode_intention")
    private final String visionModeIntention;

    public ChatParam() {
    }

    public final String getAckRemindType() {
        return this.ackRemindType;
    }

    public final String getActivePushRound() {
        return this.activePushRound;
    }

    public final String getAgentId() {
        return this.agentId;
    }

    public final String getAnswerId() {
        return this.answerId;
    }

    public final String getArtistName() {
        return this.artistName;
    }

    public final String getBotId() {
        return this.botId;
    }

    public final String getCoverUri() {
        return this.coverUri;
    }

    public final String getCoverUrls() {
        return this.coverUrls;
    }

    public final String getCvsId() {
        return this.cvsId;
    }

    public final String getFpaCommonParams() {
        return this.fpaCommonParams;
    }

    public final String getIntention() {
        return this.intention;
    }

    public final String getIntentionItems() {
        return this.intentionItems;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getModeControlParams() {
        return this.modeControlParams;
    }

    public final String getNeedConfirm() {
        return this.needConfirm;
    }

    public final String getNotificationMsgId() {
        return this.notificationMsgId;
    }

    public final String getNotificationScene() {
        return this.notificationScene;
    }

    public final String getPluginId() {
        return this.pluginId;
    }

    public final String getPopupText() {
        return this.popupText;
    }

    public final String getQuestionId() {
        return this.questionId;
    }

    public final String getRefuseText() {
        return this.refuseText;
    }

    public final String getSongName() {
        return this.songName;
    }

    public final String getSourceMessageId() {
        return this.sourceMessageId;
    }

    public final String getSpaceId() {
        return this.spaceId;
    }

    public final String getTeaTagsInfo() {
        return this.teaTagsInfo;
    }

    public final String getTemplatePrefix() {
        return this.templatePrefix;
    }

    public final String getUiType() {
        return this.uiType;
    }

    public final String getVisionModeIntention() {
        return this.visionModeIntention;
    }

    public final String isChatRespFirst() {
        return this.isChatRespFirst;
    }

    public final String isPacity() {
        return this.isPacity;
    }
}
