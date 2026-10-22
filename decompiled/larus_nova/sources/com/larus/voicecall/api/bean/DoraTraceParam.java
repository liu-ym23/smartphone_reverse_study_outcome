package com.larus.voicecall.api.bean;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/larus/voicecall/api/bean/DoraTraceParam;", "", "<init>", "()V", "traceTime", "", "getTraceTime", "()Ljava/lang/String;", "queryInfo", "getQueryInfo", "replyInfo", "getReplyInfo", "lastFrameTs", "", "getLastFrameTs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "QueryInfo", "ReplyInfo", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraTraceParam {

    @SerializedName("last_frame_ts")
    private final Long lastFrameTs;

    @SerializedName("query_info")
    private final String queryInfo;

    @SerializedName("reply_info")
    private final String replyInfo;

    @SerializedName("trace_time")
    private final String traceTime;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR \u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/larus/voicecall/api/bean/DoraTraceParam$QueryInfo;", "", "<init>", "()V", "messageId", "", "getMessageId", "()Ljava/lang/String;", "imageMessageId", "getImageMessageId", "messageType", "", "getMessageType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "picIds", "", "getPicIds", "()Ljava/util/List;", "researchId", "getResearchId", "researchPhase", "getResearchPhase", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("image_message_id")
        private final String imageMessageId;

        @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
        private final String messageId;

        @SerializedName("message_type")
        private final Integer messageType;

        @SerializedName("pic_ids")
        private final List<String> picIds;

        @SerializedName("deep_research_id")
        private final String researchId;

        @SerializedName("deep_research_phase")
        private final String researchPhase;

        public a() {
        }

        public final String a() {
            return this.imageMessageId;
        }

        public final String b() {
            return this.messageId;
        }

        public final Integer c() {
            return this.messageType;
        }

        public final String d() {
            return this.researchId;
        }

        public final String e() {
            return this.researchPhase;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010 \n\u0002\b#\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u001a\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\f\u0010\u000eR\u001a\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0013\u0010\u000eR\u0016\u0010\u0014\u001a\u00020\u00158\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00158\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R \u0010\u001e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R \u0010\"\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0016\u0010$\u001a\u00020\u00158\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R\u0016\u0010&\u001a\u00020\u00158\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0017R\u0016\u0010(\u001a\u00020\u00158\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0017R\u0016\u0010*\u001a\u00020\u00158\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0017R\u0016\u0010,\u001a\u00020\u00158\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0017R\u0016\u0010.\u001a\u00020\u00158\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0017R\u001a\u00100\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\b1\u00102R\u001a\u00104\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\b5\u00102R\u001a\u00106\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\b7\u00102R\u001a\u00108\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\b9\u00102R\u001a\u0010:\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\b;\u00102R\u001a\u0010<\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\b=\u00102R\u001a\u0010>\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\b?\u00102R\u0018\u0010@\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0007R\u0016\u0010B\u001a\u00020C8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bD\u0010E¨\u0006F"}, d2 = {"Lcom/larus/voicecall/api/bean/DoraTraceParam$ReplyInfo;", "", "<init>", "()V", "messageId", "", "getMessageId", "()Ljava/lang/String;", "replyMessageId", "getReplyMessageId", "replyImageMessageId", "getReplyImageMessageId", "isBotActive", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "hasVisionIntent", "getHasVisionIntent", "useVisionInfo", "getUseVisionInfo", "firstContentReplyDuration", "", "getFirstContentReplyDuration", "()J", "firstVuiReplyDuration", "getFirstVuiReplyDuration", "picLoadDuration", "getPicLoadDuration", "logId", "getLogId", "researchId", "", "getResearchId", "()Ljava/util/List;", "researchPhase", "getResearchPhase", "vuiUplinkDuration", "getVuiUplinkDuration", "vuiDownlinkDuration", "getVuiDownlinkDuration", "chatUplinkDuration", "getChatUplinkDuration", "chatDownlinkDuration", "getChatDownlinkDuration", "agentUplinkDuration", "getAgentUplinkDuration", "agentDownlinkDuration", "getAgentDownlinkDuration", "voiceDownToAsrText", "getVoiceDownToAsrText", "()Ljava/lang/Long;", "Ljava/lang/Long;", "asrTextToReplyIntervention", "getAsrTextToReplyIntervention", "asrTextToFirstTtsAudio", "getAsrTextToFirstTtsAudio", "voiceDownToAnswerText", "getVoiceDownToAnswerText", "voiceDownClientTimestampMs", "getVoiceDownClientTimestampMs", "answerTextToFirstTtsAudio", "getAnswerTextToFirstTtsAudio", "voiceDownToTtsAudioSent", "getVoiceDownToTtsAudioSent", "signalType", "getSignalType", "vs2tFlag", "", "getVs2tFlag", "()I", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("agent_downlink_duration_ms")
        private final long agentDownlinkDuration;

        @SerializedName("agent_uplink_duration_ms")
        private final long agentUplinkDuration;

        @SerializedName("answer_text_to_first_tts_audio")
        private final Long answerTextToFirstTtsAudio;

        @SerializedName("asr_text_to_first_tts_audio")
        private final Long asrTextToFirstTtsAudio;

        @SerializedName("asr_text_to_reply_intervention")
        private final Long asrTextToReplyIntervention;

        @SerializedName("chat_downlink_duration_ms")
        private final long chatDownlinkDuration;

        @SerializedName("chat_uplink_duration_ms")
        private final long chatUplinkDuration;

        @SerializedName("first_content_reply_duration_ms")
        private final long firstContentReplyDuration;

        @SerializedName("first_vui_reply_duration_ms")
        private final long firstVuiReplyDuration;

        @SerializedName("has_vision_intent")
        private final Boolean hasVisionIntent;

        @SerializedName("is_bot_active")
        private final Boolean isBotActive;

        @SerializedName("log_id")
        private final String logId;

        @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
        private final String messageId;

        @SerializedName("pic_load_duration_ms")
        private final long picLoadDuration;

        @SerializedName("reply_image_message_id")
        private final String replyImageMessageId;

        @SerializedName("reply_message_id")
        private final String replyMessageId;

        @SerializedName("deep_research_id")
        private final List<String> researchId;

        @SerializedName("deep_research_phase")
        private final List<String> researchPhase;

        @SerializedName("signal_type")
        private final String signalType;

        @SerializedName("use_vision_info")
        private final Boolean useVisionInfo;

        @SerializedName("voice_down_client_timestamp_ms")
        private final Long voiceDownClientTimestampMs;

        @SerializedName("voice_down_to_answer_text")
        private final Long voiceDownToAnswerText;

        @SerializedName("voice_down_to_asr_text")
        private final Long voiceDownToAsrText;

        @SerializedName("voice_down_to_tts_audio_sent")
        private final Long voiceDownToTtsAudioSent;

        @SerializedName("vs2t_flag")
        private final int vs2tFlag;

        @SerializedName("vui_downlink_duration_ms")
        private final long vuiDownlinkDuration;

        @SerializedName("vui_uplink_duration_ms")
        private final long vuiUplinkDuration;

        public b() {
            Boolean r100 = Boolean.FALSE;
            this.isBotActive = r100;
            this.hasVisionIntent = r100;
            this.useVisionInfo = r100;
        }

        public final long a() {
            return this.agentDownlinkDuration;
        }

        public final long b() {
            return this.agentUplinkDuration;
        }

        public final Long c() {
            return this.answerTextToFirstTtsAudio;
        }

        public final Long d() {
            return this.asrTextToFirstTtsAudio;
        }

        public final Long e() {
            return this.asrTextToReplyIntervention;
        }

        public final long f() {
            return this.chatDownlinkDuration;
        }

        public final long g() {
            return this.chatUplinkDuration;
        }

        public final long h() {
            return this.firstContentReplyDuration;
        }

        public final long i() {
            return this.firstVuiReplyDuration;
        }

        public final Boolean j() {
            return this.hasVisionIntent;
        }

        public final String k() {
            return this.logId;
        }

        public final String l() {
            return this.messageId;
        }

        public final long m() {
            return this.picLoadDuration;
        }

        public final List<String> n() {
            return this.researchId;
        }

        public final List<String> o() {
            return this.researchPhase;
        }

        public final String p() {
            return this.signalType;
        }

        public final Boolean q() {
            return this.useVisionInfo;
        }

        public final Long r() {
            return this.voiceDownClientTimestampMs;
        }

        public final Long s() {
            return this.voiceDownToAnswerText;
        }

        public final Long t() {
            return this.voiceDownToAsrText;
        }

        public final Long u() {
            return this.voiceDownToTtsAudioSent;
        }

        public final int v() {
            return this.vs2tFlag;
        }

        public final long w() {
            return this.vuiDownlinkDuration;
        }

        public final long x() {
            return this.vuiUplinkDuration;
        }

        public final Boolean y() {
            return this.isBotActive;
        }
    }

    public DoraTraceParam() {
    }

    public final Long getLastFrameTs() {
        return this.lastFrameTs;
    }

    public final String getQueryInfo() {
        return this.queryInfo;
    }

    public final String getReplyInfo() {
        return this.replyInfo;
    }

    public final String getTraceTime() {
        return this.traceTime;
    }
}
