package com.larus.bmhome.chat.trace.appreciable;

import androidx.collection.LruCache;
import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.google.gson.annotations.SerializedName;
import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.MessageTrackContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class CommonParamManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache<String, CommonParam> f310103a = null;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\ba\b\u0007\u0018\u00002\u00020\u0001B÷\u0003\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010$\u001a\u00020\f\u0012\u0014\b\u0002\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0014\u0012\u0014\b\u0002\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030'\u0012\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060'\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b.\u0010/J\t\u0010\u0087\u0001\u001a\u00020\u0003H\u0016R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00101\"\u0004\b5\u00103R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b;\u00107\"\u0004\b<\u00109R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b=\u00107\"\u0004\b>\u00109R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\b?\u00107\"\u0004\b@\u00109R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00101\"\u0004\bB\u00103R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001e\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\bH\u00107\"\u0004\bI\u00109R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\bJ\u00107\"\u0004\bK\u00109R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\bL\u00107\"\u0004\bM\u00109R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\bN\u00107\"\u0004\bO\u00109R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u00101\"\u0004\bP\u00103R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u00101\"\u0004\bR\u00103R(\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\bW\u00107\"\u0004\bX\u00109R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010:\u001a\u0004\bY\u00107\"\u0004\bZ\u00109R \u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u00101\"\u0004\b\\\u00103R \u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u00101\"\u0004\b]\u00103R\"\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010b\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR \u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u00101\"\u0004\bd\u00103R \u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u00101\"\u0004\bf\u00103R \u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u00101\"\u0004\bh\u00103R \u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u00101\"\u0004\bj\u00103R \u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u00101\"\u0004\bl\u00103R \u0010 \u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u00101\"\u0004\bn\u00103R \u0010!\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u00101\"\u0004\bp\u00103R \u0010\"\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u00101\"\u0004\br\u00103R\"\u0010#\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010b\u001a\u0004\bs\u0010_\"\u0004\bt\u0010aR\u001a\u0010$\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR&\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010T\"\u0004\bz\u0010VR\u001d\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030'¢\u0006\b\n\u0000\u001a\u0004\b{\u0010|R\u001d\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060'¢\u0006\b\n\u0000\u001a\u0004\b}\u0010|R \u0010)\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u00101\"\u0004\b\u007f\u00103R!\u0010*\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b*\u00101\"\u0005\b\u0080\u0001\u00103R\"\u0010+\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u00101\"\u0005\b\u0082\u0001\u00103R\"\u0010,\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u00101\"\u0005\b\u0084\u0001\u00103R\"\u0010-\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u00101\"\u0005\b\u0086\u0001\u00103¨\u0006\u0088\u0001"}, d2 = {"Lcom/larus/bmhome/chat/trace/appreciable/CommonParamManager$CommonParam;", "", "localSendMsgId", "", "sendMsgId", "sendStartTime", "", "sendStartEpochMs", "ackTime", "sendLoadingHideTime", "endReceiveMsgId", "leavedChatPage", "", "sendMsgOnBusinessTime", "sendMsgOnSDKInternalTime", "sdkReceiveTime", "sdkTotalTimeFromSendToReceive", "isFromCache", "intention", "intentionMap", "", "businessReceiveMsgCallbackTime", "sendToSdkTimeDuration", "generalAgent", "isAsyncTask", "sendMsgContentType", "", "sendFuncChannel", "scene", "cvsId", "botId", "chatType", "convType", "traceId", "cTraceId", "agentMode", "hasEnterBackground", "messageTrackCommonTags", "latestPerfMarkRenderTokens", "Ljava/util/concurrent/ConcurrentHashMap;", "perfMarkDurations", "springGuideCardId", "isSpringGuide", "delayRequestIntervalMs", "intervalMs", "entryToSendMsgCost", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLjava/util/Map;Ljava/util/concurrent/ConcurrentHashMap;Ljava/util/concurrent/ConcurrentHashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLocalSendMsgId", "()Ljava/lang/String;", "setLocalSendMsgId", "(Ljava/lang/String;)V", "getSendMsgId", "setSendMsgId", "getSendStartTime", "()Ljava/lang/Long;", "setSendStartTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getSendStartEpochMs", "setSendStartEpochMs", "getAckTime", "setAckTime", "getSendLoadingHideTime", "setSendLoadingHideTime", "getEndReceiveMsgId", "setEndReceiveMsgId", "getLeavedChatPage", "()Ljava/lang/Boolean;", "setLeavedChatPage", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getSendMsgOnBusinessTime", "setSendMsgOnBusinessTime", "getSendMsgOnSDKInternalTime", "setSendMsgOnSDKInternalTime", "getSdkReceiveTime", "setSdkReceiveTime", "getSdkTotalTimeFromSendToReceive", "setSdkTotalTimeFromSendToReceive", "setFromCache", "getIntention", "setIntention", "getIntentionMap", "()Ljava/util/Map;", "setIntentionMap", "(Ljava/util/Map;)V", "getBusinessReceiveMsgCallbackTime", "setBusinessReceiveMsgCallbackTime", "getSendToSdkTimeDuration", "setSendToSdkTimeDuration", "getGeneralAgent", "setGeneralAgent", "setAsyncTask", "getSendMsgContentType", "()Ljava/lang/Integer;", "setSendMsgContentType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getSendFuncChannel", "setSendFuncChannel", "getScene", "setScene", "getCvsId", "setCvsId", "getBotId", "setBotId", "getChatType", "setChatType", "getConvType", "setConvType", "getTraceId", "setTraceId", "getCTraceId", "setCTraceId", "getAgentMode", "setAgentMode", "getHasEnterBackground", "()Z", "setHasEnterBackground", "(Z)V", "getMessageTrackCommonTags", "setMessageTrackCommonTags", "getLatestPerfMarkRenderTokens", "()Ljava/util/concurrent/ConcurrentHashMap;", "getPerfMarkDurations", "getSpringGuideCardId", "setSpringGuideCardId", "setSpringGuide", "getDelayRequestIntervalMs", "setDelayRequestIntervalMs", "getIntervalMs", "setIntervalMs", "getEntryToSendMsgCost", "setEntryToSendMsgCost", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CommonParam {
        private transient Long ackTime;

        @SerializedName("agent_mode")
        private Integer agentMode;

        @SerializedName("bot_id")
        private String botId;
        private transient Long businessReceiveMsgCallbackTime;

        @SerializedName("c_trace_id")
        private String cTraceId;

        @SerializedName("chat_type")
        private String chatType;

        @SerializedName("conv_type")
        private String convType;

        @SerializedName("conversation_id")
        private String cvsId;

        @SerializedName("delay_request_interval_ms")
        private String delayRequestIntervalMs;
        private transient String endReceiveMsgId;

        @SerializedName("entry_to_send_msg_ms")
        private String entryToSendMsgCost;

        @SerializedName("general_agent")
        private String generalAgent;
        private transient boolean hasEnterBackground;
        private transient String intention;
        private transient Map<String, String> intentionMap;

        @SerializedName("interval_ms")
        private String intervalMs;

        @SerializedName("is_async_task")
        private String isAsyncTask;
        private transient String isFromCache;

        @SerializedName("is_spring_guide")
        private String isSpringGuide;
        private final transient ConcurrentHashMap<String, String> latestPerfMarkRenderTokens;
        private transient Boolean leavedChatPage;

        @SerializedName("local_message_id")
        private String localSendMsgId;
        private transient Map<String, String> messageTrackCommonTags;
        private final transient ConcurrentHashMap<String, Long> perfMarkDurations;

        @SerializedName("scene")
        private String scene;
        private transient Long sdkReceiveTime;
        private transient Long sdkTotalTimeFromSendToReceive;

        @SerializedName("send_func_channel")
        private String sendFuncChannel;
        private transient Long sendLoadingHideTime;

        @SerializedName("send_msg_content_type")
        private Integer sendMsgContentType;
        private transient String sendMsgId;
        private transient Long sendMsgOnBusinessTime;
        private transient Long sendMsgOnSDKInternalTime;
        private transient Long sendStartEpochMs;
        private transient Long sendStartTime;
        private transient Long sendToSdkTimeDuration;

        @SerializedName("spring_guide_card_id")
        private String springGuideCardId;

        @SerializedName(BindCardPayConfirmConstants.Key.TRACE_ID)
        private String traceId;

        public CommonParam() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, -1, 63, null);
        }

        public String toString() {
            return "scene=" + this.scene + ", localSendMsgId=" + this.localSendMsgId + ", cvsId=" + this.cvsId + ", botId=" + this.botId + ", chatType=" + this.chatType;
        }

        public final Long getAckTime() {
            return this.ackTime;
        }

        public final Integer getAgentMode() {
            return this.agentMode;
        }

        public final String getBotId() {
            return this.botId;
        }

        public final Long getBusinessReceiveMsgCallbackTime() {
            return this.businessReceiveMsgCallbackTime;
        }

        public final String getCTraceId() {
            return this.cTraceId;
        }

        public final String getChatType() {
            return this.chatType;
        }

        public final String getConvType() {
            return this.convType;
        }

        public final String getCvsId() {
            return this.cvsId;
        }

        public final String getDelayRequestIntervalMs() {
            return this.delayRequestIntervalMs;
        }

        public final String getEndReceiveMsgId() {
            return this.endReceiveMsgId;
        }

        public final String getEntryToSendMsgCost() {
            return this.entryToSendMsgCost;
        }

        public final String getGeneralAgent() {
            return this.generalAgent;
        }

        public final boolean getHasEnterBackground() {
            return this.hasEnterBackground;
        }

        public final String getIntention() {
            return this.intention;
        }

        public final Map<String, String> getIntentionMap() {
            return this.intentionMap;
        }

        public final String getIntervalMs() {
            return this.intervalMs;
        }

        public final ConcurrentHashMap<String, String> getLatestPerfMarkRenderTokens() {
            return this.latestPerfMarkRenderTokens;
        }

        public final Boolean getLeavedChatPage() {
            return this.leavedChatPage;
        }

        public final String getLocalSendMsgId() {
            return this.localSendMsgId;
        }

        public final Map<String, String> getMessageTrackCommonTags() {
            return this.messageTrackCommonTags;
        }

        public final ConcurrentHashMap<String, Long> getPerfMarkDurations() {
            return this.perfMarkDurations;
        }

        public final String getScene() {
            return this.scene;
        }

        public final Long getSdkReceiveTime() {
            return this.sdkReceiveTime;
        }

        public final Long getSdkTotalTimeFromSendToReceive() {
            return this.sdkTotalTimeFromSendToReceive;
        }

        public final String getSendFuncChannel() {
            return this.sendFuncChannel;
        }

        public final Long getSendLoadingHideTime() {
            return this.sendLoadingHideTime;
        }

        public final Integer getSendMsgContentType() {
            return this.sendMsgContentType;
        }

        public final String getSendMsgId() {
            return this.sendMsgId;
        }

        public final Long getSendMsgOnBusinessTime() {
            return this.sendMsgOnBusinessTime;
        }

        public final Long getSendMsgOnSDKInternalTime() {
            return this.sendMsgOnSDKInternalTime;
        }

        public final Long getSendStartEpochMs() {
            return this.sendStartEpochMs;
        }

        public final Long getSendStartTime() {
            return this.sendStartTime;
        }

        public final Long getSendToSdkTimeDuration() {
            return this.sendToSdkTimeDuration;
        }

        public final String getSpringGuideCardId() {
            return this.springGuideCardId;
        }

        public final String getTraceId() {
            return this.traceId;
        }

        public final String isAsyncTask() {
            return this.isAsyncTask;
        }

        public final String isFromCache() {
            return this.isFromCache;
        }

        public final String isSpringGuide() {
            return this.isSpringGuide;
        }

        public final void setAckTime(Long r100) {
            this.ackTime = r100;
        }

        public final void setAgentMode(Integer r100) {
            this.agentMode = r100;
        }

        public final void setAsyncTask(String r100) {
            this.isAsyncTask = r100;
        }

        public final void setBotId(String r100) {
            this.botId = r100;
        }

        public final void setBusinessReceiveMsgCallbackTime(Long r100) {
            this.businessReceiveMsgCallbackTime = r100;
        }

        public final void setCTraceId(String r100) {
            this.cTraceId = r100;
        }

        public final void setChatType(String r100) {
            this.chatType = r100;
        }

        public final void setConvType(String r100) {
            this.convType = r100;
        }

        public final void setCvsId(String r100) {
            this.cvsId = r100;
        }

        public final void setDelayRequestIntervalMs(String r100) {
            this.delayRequestIntervalMs = r100;
        }

        public final void setEndReceiveMsgId(String r100) {
            this.endReceiveMsgId = r100;
        }

        public final void setEntryToSendMsgCost(String r100) {
            this.entryToSendMsgCost = r100;
        }

        public final void setFromCache(String r100) {
            this.isFromCache = r100;
        }

        public final void setGeneralAgent(String r100) {
            this.generalAgent = r100;
        }

        public final void setHasEnterBackground(boolean r100) {
            this.hasEnterBackground = r100;
        }

        public final void setIntention(String r100) {
            this.intention = r100;
        }

        public final void setIntentionMap(Map<String, String> r100) {
            this.intentionMap = r100;
        }

        public final void setIntervalMs(String r100) {
            this.intervalMs = r100;
        }

        public final void setLeavedChatPage(Boolean r100) {
            this.leavedChatPage = r100;
        }

        public final void setLocalSendMsgId(String r100) {
            this.localSendMsgId = r100;
        }

        public final void setMessageTrackCommonTags(Map<String, String> r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.messageTrackCommonTags = r100;
        }

        public final void setScene(String r100) {
            this.scene = r100;
        }

        public final void setSdkReceiveTime(Long r100) {
            this.sdkReceiveTime = r100;
        }

        public final void setSdkTotalTimeFromSendToReceive(Long r100) {
            this.sdkTotalTimeFromSendToReceive = r100;
        }

        public final void setSendFuncChannel(String r100) {
            this.sendFuncChannel = r100;
        }

        public final void setSendLoadingHideTime(Long r100) {
            this.sendLoadingHideTime = r100;
        }

        public final void setSendMsgContentType(Integer r100) {
            this.sendMsgContentType = r100;
        }

        public final void setSendMsgId(String r100) {
            this.sendMsgId = r100;
        }

        public final void setSendMsgOnBusinessTime(Long r100) {
            this.sendMsgOnBusinessTime = r100;
        }

        public final void setSendMsgOnSDKInternalTime(Long r100) {
            this.sendMsgOnSDKInternalTime = r100;
        }

        public final void setSendStartEpochMs(Long r100) {
            this.sendStartEpochMs = r100;
        }

        public final void setSendStartTime(Long r100) {
            this.sendStartTime = r100;
        }

        public final void setSendToSdkTimeDuration(Long r100) {
            this.sendToSdkTimeDuration = r100;
        }

        public final void setSpringGuide(String r100) {
            this.isSpringGuide = r100;
        }

        public final void setSpringGuideCardId(String r100) {
            this.springGuideCardId = r100;
        }

        public final void setTraceId(String r100) {
            this.traceId = r100;
        }

        public CommonParam(String r100, String r101, Long r102, Long r103, Long r110, Long r111, String r112, Boolean r113, Long r114, Long r115, Long r116, Long r117, String r118, String r119, Map<String, String> r210, Long r211, Long r212, String r213, String r214, Integer r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, String r313, Integer r314, boolean r315, Map<String, String> r316, ConcurrentHashMap<String, String> r317, ConcurrentHashMap<String, Long> r318, String r319, String r410, String r411, String r412, String r413) {
            Intrinsics.checkNotNullParameter(r316, "messageTrackCommonTags");
            Intrinsics.checkNotNullParameter(r317, "latestPerfMarkRenderTokens");
            Intrinsics.checkNotNullParameter(r318, "perfMarkDurations");
            this.localSendMsgId = r100;
            this.sendMsgId = r101;
            this.sendStartTime = r102;
            this.sendStartEpochMs = r103;
            this.ackTime = r110;
            this.sendLoadingHideTime = r111;
            this.endReceiveMsgId = r112;
            this.leavedChatPage = r113;
            this.sendMsgOnBusinessTime = r114;
            this.sendMsgOnSDKInternalTime = r115;
            this.sdkReceiveTime = r116;
            this.sdkTotalTimeFromSendToReceive = r117;
            this.isFromCache = r118;
            this.intention = r119;
            this.intentionMap = r210;
            this.businessReceiveMsgCallbackTime = r211;
            this.sendToSdkTimeDuration = r212;
            this.generalAgent = r213;
            this.isAsyncTask = r214;
            this.sendMsgContentType = r215;
            this.sendFuncChannel = r216;
            this.scene = r217;
            this.cvsId = r218;
            this.botId = r219;
            this.chatType = r310;
            this.convType = r311;
            this.traceId = r312;
            this.cTraceId = r313;
            this.agentMode = r314;
            this.hasEnterBackground = r315;
            this.messageTrackCommonTags = r316;
            this.latestPerfMarkRenderTokens = r317;
            this.perfMarkDurations = r318;
            this.springGuideCardId = r319;
            this.isSpringGuide = r410;
            this.delayRequestIntervalMs = r411;
            this.intervalMs = r412;
            this.entryToSendMsgCost = r413;
        }

        public /* synthetic */ CommonParam(String r310, String r410, Long r411, Long r412, Long r413, Long r414, String r415, Boolean r416, Long r417, Long r418, Long r419, Long r510, String r511, String r512, Map r513, Long r514, Long r515, String r516, String r517, Integer r518, String r519, String r610, String r611, String r612, String r613, String r614, String r615, String r616, Integer r617, boolean r618, Map r619, ConcurrentHashMap r710, ConcurrentHashMap r711, String r712, String r713, String r714, String r715, String r716, int r717, int r718, DefaultConstructorMarker r719) {
            if ((r717 & 1) == 0) goto L5;
            String r100 = null;
        L7:
            if ((r717 & 2) == 0) goto L9;
            String r101 = null;
        L11:
            if ((r717 & 4) == 0) goto L13;
            Long r102 = null;
        L15:
            if ((r717 & 8) == 0) goto L17;
            Long r103 = null;
        L19:
            if ((r717 & 16) == 0) goto L21;
            Long r104 = null;
        L23:
            if ((r717 & 32) == 0) goto L25;
            Long r105 = null;
        L27:
            if ((r717 & 64) == 0) goto L29;
            String r106 = null;
        L31:
            if ((r717 & 128) == 0) goto L33;
            Boolean r107 = null;
        L35:
            if ((r717 & 256) == 0) goto L37;
            Long r110 = null;
        L39:
            if ((r717 & 512) == 0) goto L41;
            Long r111 = null;
        L43:
            if ((r717 & 1024) == 0) goto L45;
            Long r112 = null;
        L47:
            if ((r717 & 2048) == 0) goto L49;
            Long r113 = null;
        L51:
            if ((r717 & 4096) == 0) goto L53;
            String r114 = null;
        L55:
            if ((r717 & 8192) == 0) goto L57;
            String r115 = null;
        L59:
            if ((r717 & 16384) == 0) goto L61;
            Map r108 = null;
        L63:
            if ((r717 & 32768) == 0) goto L65;
            Long r116 = null;
        L67:
            if ((r717 & 65536) == 0) goto L69;
            Long r117 = null;
        L71:
            if ((r717 & 131072) == 0) goto L73;
            String r118 = null;
        L75:
            if ((r717 & 262144) == 0) goto L77;
            String r119 = null;
        L79:
            if ((r717 & 524288) == 0) goto L81;
            Integer r210 = null;
        L83:
            if ((r717 & 1048576) == 0) goto L85;
            String r211 = null;
        L87:
            if ((r717 & 2097152) == 0) goto L89;
            String r212 = null;
        L91:
            if ((r717 & 4194304) == 0) goto L93;
            String r213 = null;
        L95:
            if ((r717 & 8388608) == 0) goto L97;
            String r214 = null;
        L99:
            if ((r717 & 16777216) == 0) goto L101;
            String r215 = null;
        L103:
            if ((r717 & 33554432) == 0) goto L105;
            String r216 = null;
        L107:
            if ((r717 & 67108864) == 0) goto L109;
            String r217 = null;
        L111:
            if ((r717 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
            String r218 = null;
        L115:
            if ((r717 & 268435456) == 0) goto L117;
            Integer r219 = null;
        L119:
            if ((r717 & 536870912) == 0) goto L121;
            boolean r311 = false;
        L123:
            if ((r717 & 1073741824) == 0) goto L125;
            Map r312 = MapsKt.emptyMap();
        L127:
            if ((r717 & Integer.MIN_VALUE) == 0) goto L129;
            ConcurrentHashMap r109 = new ConcurrentHashMap();
        L131:
            if ((r718 & 1) == 0) goto L133;
            ConcurrentHashMap r313 = new ConcurrentHashMap();
        L135:
            if ((r718 & 2) == 0) goto L137;
            String r314 = null;
        L139:
            if ((r718 & 4) == 0) goto L141;
            String r315 = null;
        L143:
            if ((r718 & 8) == 0) goto L145;
            String r316 = null;
        L147:
            if ((r718 & 16) == 0) goto L149;
            String r317 = null;
        L151:
            if ((r718 & 32) == 0) goto L153;
            String r318 = null;
        L154:
            this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r311, r312, r109, r313, r314, r315, r316, r317, r318);
            return;
        L153:
            r318 = r716;
            goto L154
        L149:
            r317 = r715;
            goto L151
        L145:
            r316 = r714;
            goto L147
        L141:
            r315 = r713;
            goto L143
        L137:
            r314 = r712;
            goto L139
        L133:
            r313 = r711;
            goto L135
        L129:
            r109 = r710;
            goto L131
        L125:
            r312 = r619;
            goto L127
        L121:
            r311 = r618;
            goto L123
        L117:
            r219 = r617;
            goto L119
        L113:
            r218 = r616;
            goto L115
        L109:
            r217 = r615;
            goto L111
        L105:
            r216 = r614;
            goto L107
        L101:
            r215 = r613;
            goto L103
        L97:
            r214 = r612;
            goto L99
        L93:
            r213 = r611;
            goto L95
        L89:
            r212 = r610;
            goto L91
        L85:
            r211 = r519;
            goto L87
        L81:
            r210 = r518;
            goto L83
        L77:
            r119 = r517;
            goto L79
        L73:
            r118 = r516;
            goto L75
        L69:
            r117 = r515;
            goto L71
        L65:
            r116 = r514;
            goto L67
        L61:
            r108 = r513;
            goto L63
        L57:
            r115 = r512;
            goto L59
        L53:
            r114 = r511;
            goto L55
        L49:
            r113 = r510;
            goto L51
        L45:
            r112 = r419;
            goto L47
        L41:
            r111 = r418;
            goto L43
        L37:
            r110 = r417;
            goto L39
        L33:
            r107 = r416;
            goto L35
        L29:
            r106 = r415;
            goto L31
        L25:
            r105 = r414;
            goto L27
        L21:
            r104 = r413;
            goto L23
        L17:
            r103 = r412;
            goto L19
        L13:
            r102 = r411;
            goto L15
        L9:
            r101 = r410;
            goto L11
        L5:
            r100 = r310;
            goto L7
        }
    }

    public static final class a implements f09.a.b {
        public a() {
        }

        @Override // f09.a.b
        public final void onAllActivityDestroyed() {
        }

        @Override // f09.a.b
        public final void onAppForeground() {
        }

        @Override // f09.a.b
        public final void onAppBackground() {
            Iterator<T> r100 = CommonParamManager.f310103a.snapshot().values().iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            ((CommonParam) r100.next()).setHasEnterBackground(true);
            goto L4
        }
    }

    static {
        f310103a = new LruCache(10);
        AppHost.f326268a.a().j(new a());
    }

    public static String b() {
    L2:
        long r100 = Random.Default.nextLong() >>> 1;
        if (r100 == 0) goto L2;
    L4:
        long r101 = Random.Default.nextLong() >>> 1;
        if (r101 == 0) goto L4;
        return StringsKt.padStart(Long.toString(r100, CharsKt.checkRadix(16)), 16, '0') + StringsKt.padStart(Long.toString(r101, CharsKt.checkRadix(16)), 16, '0');
    }

    public static CommonParam c(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return f310103a.get(r100);
    }

    public static MessageTrackContext a(List r100, Integer r110, String r111) {
        Intrinsics.checkNotNullParameter(r100, "localMessageIds");
        List r101 = CollectionsKt.distinct(r100);
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        CommonParam r104 = c((String) r103.next());
        if (r104 == null) goto L4;
        r102.add(r104);
        goto L4
    L8:
        CommonParam r105 = (CommonParam) CollectionsKt.firstOrNull(r102);
        ArrayList r106 = new ArrayList();
        Iterator r107 = r102.iterator();
    L10:
        if (r107.hasNext() == false) goto L14;
        Long r108 = ((CommonParam) r107.next()).getSendStartEpochMs();
        if (r108 == null) goto L10;
        r106.add(r108);
        goto L10
    L14:
        Long r109 = (Long) CollectionsKt.firstOrNull(r106);
        String r112 = null;
        if (r109 == null) goto L60;
        long r113 = r109.longValue();
        boolean r114 = false;
        if (r105 == null) goto L28;
        String r115 = r105.getCTraceId();
        if (r115 == null) goto L28;
        if (r115.length() <= 0) goto L23;
        boolean r116 = true;
    L24:
        if (r116 == true) goto L27;
        r115 = null;
    L27:
        if (r115 == null) goto L28;
    L29:
        if (r110 != null) goto L33;
        if (r105 == null) goto L32;
        r110 = r105.getAgentMode();
        goto L33
    L32:
        r110 = null;
    L33:
        if (r105 == null) goto L35;
        Map<String, String> r117 = r105.getMessageTrackCommonTags();
    L36:
        if (r117 != null) goto L38;
        r117 = MapsKt.emptyMap();
    L38:
        Map r118 = MapsKt.toMutableMap(r117);
        r118.put("c_trace_id", r115);
        if (r105 == null) goto L44;
        String r119 = r105.getScene();
        if (r119 == null) goto L44;
        r111 = r119;
    L44:
        if (r111 != null) goto L46;
    L52:
        if (r110 == null) goto L54;
        r118.put("agent_mode", String.valueOf(r110.intValue()));
    L54:
        Iterator r120 = r102.iterator();
    L56:
        if (r120.hasNext() == false) goto L59;
        CommonParam r121 = (CommonParam) r120.next();
        r121.setCTraceId(r115);
        r121.setAgentMode(r110);
        r121.setMessageTrackCommonTags(MapsKt.toMap(r118));
        goto L56
    L59:
        return new MessageTrackContext(r113, r118);
    L46:
        if (r111.length() <= 0) goto L48;
        r114 = true;
    L48:
        if (r114 == false) goto L50;
        r112 = r111;
    L50:
        if (r112 == null) goto L52;
        String r122 = (String) r118.put("scene", r112);
        goto L52
    L35:
        r117 = null;
        goto L36
    L23:
        r116 = false;
    L28:
        r115 = b();
        goto L29
    L60:
        return null;
    }
}
