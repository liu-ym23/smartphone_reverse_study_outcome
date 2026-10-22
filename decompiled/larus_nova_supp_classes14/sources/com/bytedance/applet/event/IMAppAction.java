package com.bytedance.applet.event;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.common.apphost.AppHost;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import com.larus.utils.gson.TimeTransformAdapter;
import com.larus.utils.o0;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002./B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rJ\b\u0010 \u001a\u00020\tH\u0016J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010%\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJb\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010)J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0018\u0010\u000fR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0019\u0010\u000fR\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001d¨\u00060"}, d2 = {"Lcom/bytedance/applet/event/IMAppAction;", "", "appType", "", "messageId", "", "questionId", "createTime", "content", "", "messageType", "timeoutMs", "<init>", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAppType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessageId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getQuestionId", "getCreateTime", "getContent", "()Ljava/lang/String;", "getMessageType", "getTimeoutMs", "mpParam", "Lcom/bytedance/applet/event/IMAppAction$IMMpParams;", "getMpParam", "()Lcom/bytedance/applet/event/IMAppAction$IMMpParams;", "mpParam$delegate", "Lkotlin/Lazy;", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/applet/event/IMAppAction;", "equals", "", "other", "hashCode", "Companion", "IMMpParams", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IMAppAction {
    public static final int ACTION_TYPE_SERVER_ACTION = 1;
    public static final int ACTION_TYPE_UI_ACTION = 2;
    public static final int ACTION_TYPE_UNDEFINED = 0;
    public static final int APP_TYPE_APPLET = 2;
    public static final int APP_TYPE_NATIVE = 1;
    public static final int APP_TYPE_RESERVED = 0;
    public static final a Companion = null;
    public static final int MESSAGE_TYPE_ACK = 2;
    public static final int MESSAGE_TYPE_MSG = 1;
    private static final Lazy<Gson> gson$delegate = null;

    @SerializedName("app_type")
    private final Integer appType;

    @SerializedName("content")
    private final String content;

    @SerializedName("create_time")
    @JsonAdapter(TimeTransformAdapter.class)
    private final Long createTime;

    @SerializedName("message_id")
    private final Long messageId;

    @SerializedName("message_type")
    private final Integer messageType;
    private final Lazy mpParam$delegate;

    @SerializedName("question_id")
    private final Long questionId;

    @SerializedName("timeout_ms")
    private final Integer timeoutMs;

    public static final class a {
        public a() {
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0017\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010HÆ\u0003Jª\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u00020\u0007HÖ\u0001J\t\u00105\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b \u0010\u0018R$\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00066"}, d2 = {"Lcom/bytedance/applet/event/IMAppAction$IMMpParams;", "", "botId", "", "conversationId", "mpAppId", "actionType", "", "eventName", "data", "apiName", "pluginName", "toolName", "param", "timeoutMs", "featureMap", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)V", "getBotId", "()Ljava/lang/String;", "getConversationId", "getMpAppId", "getActionType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEventName", "getData", "getApiName", "getPluginName", "getToolName", "getParam", "getTimeoutMs", "getFeatureMap", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)Lcom/bytedance/applet/event/IMAppAction$IMMpParams;", "equals", "", "other", "hashCode", "toString", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b {

        @SerializedName("action_type")
        private final Integer actionType;

        @SerializedName("api_name")
        private final String apiName;

        @SerializedName("bot_id")
        private final String botId;

        @SerializedName("conversation_id")
        private final String conversationId;

        @SerializedName("data")
        private final String data;

        @SerializedName("event_name")
        private final String eventName;

        @SerializedName("feature_map")
        @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
        private final Map<String, String> featureMap;

        @SerializedName("mp_app_id")
        private final String mpAppId;

        @SerializedName("param")
        private final String param;

        @SerializedName("plugin_name")
        private final String pluginName;

        @SerializedName("timeout_ms")
        private final Integer timeoutMs;

        @SerializedName("tool_name")
        private final String toolName;

        public b() {
            this.botId = "";
            this.conversationId = "";
            this.mpAppId = "";
            this.actionType = 0;
            this.eventName = "";
            this.data = "";
            this.apiName = "";
            this.pluginName = "";
            this.toolName = "";
            this.param = "";
            this.timeoutMs = 0;
            this.featureMap = null;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.botId, r6.botId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.conversationId, r6.conversationId) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.mpAppId, r6.mpAppId) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.actionType, r6.actionType) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.eventName, r6.eventName) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.data, r6.data) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.apiName, r6.apiName) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.pluginName, r6.pluginName) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.toolName, r6.toolName) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.param, r6.param) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.timeoutMs, r6.timeoutMs) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.featureMap, r6.featureMap) == true) goto L44;
            return false;
        L44:
            return true;
        }

        public final int hashCode() {
            String r0 = this.botId;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.conversationId;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.mpAppId;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            Integer r10 = this.actionType;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.eventName;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            String r16 = this.data;
            if (r16 != null) goto L25;
            int r17 = 0;
        L26:
            int r18 = (r15 + r17) * 31;
            String r19 = this.apiName;
            if (r19 != null) goto L29;
            int r20 = 0;
        L30:
            int r21 = (r18 + r20) * 31;
            String r22 = this.pluginName;
            if (r22 != null) goto L33;
            int r23 = 0;
        L34:
            int r24 = (r21 + r23) * 31;
            String r25 = this.toolName;
            if (r25 != null) goto L37;
            int r26 = 0;
        L38:
            int r27 = (r24 + r26) * 31;
            String r28 = this.param;
            if (r28 != null) goto L41;
            int r29 = 0;
        L42:
            int r30 = (r27 + r29) * 31;
            Integer r31 = this.timeoutMs;
            if (r31 != null) goto L45;
            int r32 = 0;
        L46:
            int r33 = (r30 + r32) * 31;
            Map<String, String> r34 = this.featureMap;
            if (r34 == null) goto L51;
            r1 = r34.hashCode();
        L51:
            return r33 + r1;
        L45:
            r32 = r31.hashCode();
            goto L46
        L41:
            r29 = r28.hashCode();
            goto L42
        L37:
            r26 = r25.hashCode();
            goto L38
        L33:
            r23 = r22.hashCode();
            goto L34
        L29:
            r20 = r19.hashCode();
            goto L30
        L25:
            r17 = r16.hashCode();
            goto L26
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "IMMpParams(botId=" + this.botId + ", conversationId=" + this.conversationId + ", mpAppId=" + this.mpAppId + ", actionType=" + this.actionType + ", eventName=" + this.eventName + ", data=" + this.data + ", apiName=" + this.apiName + ", pluginName=" + this.pluginName + ", toolName=" + this.toolName + ", param=" + this.param + ", timeoutMs=" + this.timeoutMs + ", featureMap=" + this.featureMap + ')';
        }

        public final Integer a() {
            return this.actionType;
        }

        public final String b() {
            return this.apiName;
        }

        public final String c() {
            return this.botId;
        }

        public final String d() {
            return this.conversationId;
        }

        public final String e() {
            return this.data;
        }

        public final String f() {
            return this.eventName;
        }

        public final Map<String, String> g() {
            return this.featureMap;
        }

        public final String h() {
            return this.mpAppId;
        }

        public final String i() {
            return this.param;
        }

        public final String j() {
            return this.pluginName;
        }

        public final Integer k() {
            return this.timeoutMs;
        }

        public final String l() {
            return this.toolName;
        }
    }

    public IMAppAction() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ b a(IMAppAction r0) {
        return mpParam_delegate$lambda$0(r0);
    }

    public static /* synthetic */ Gson b() {
        return gson_delegate$lambda$1();
    }

    public static /* synthetic */ IMAppAction copy$default(IMAppAction r5, Integer r6, Long r7, Long r8, Long r9, String r10, Integer r11, Integer r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.appType;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.messageId;
    L8:
        Long r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.questionId;
    L11:
        Long r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.createTime;
    L14:
        Long r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.content;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.messageType;
    L20:
        Integer r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.timeoutMs;
    L23:
        Integer r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final Integer component1() {
        return this.appType;
    }

    public final Long component2() {
        return this.messageId;
    }

    public final Long component3() {
        return this.questionId;
    }

    public final Long component4() {
        return this.createTime;
    }

    public final String component5() {
        return this.content;
    }

    public final Integer component6() {
        return this.messageType;
    }

    public final Integer component7() {
        return this.timeoutMs;
    }

    public final IMAppAction copy(Integer r10, Long r11, Long r12, Long r13, String r14, Integer r15, Integer r16) {
        return new IMAppAction(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IMAppAction) == true) goto L8;
        return false;
    L8:
        IMAppAction r6 = (IMAppAction) r5;
        if (Intrinsics.areEqual(this.appType, r6.appType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.messageId, r6.messageId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.questionId, r6.questionId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.createTime, r6.createTime) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.messageType, r6.messageType) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.timeoutMs, r6.timeoutMs) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.appType;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.messageId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.questionId;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.createTime;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.content;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.messageType;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.timeoutMs;
        if (r19 == null) goto L31;
        r1 = r19.hashCode();
    L31:
        return r18 + r1;
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    static {
        Companion = new a();
        gson$delegate = LazyKt.lazy(new l());
    }

    private static final Gson gson_delegate$lambda$1() {
        return new Gson();
    }

    public final b getMpParam() {
        return (b) this.mpParam$delegate.getValue();
    }

    public String toString() {
        return "[appType=" + this.appType + ". messageId=" + this.messageId + ", questionId=" + this.questionId + ". msgType=" + this.messageType + ", timeoutMs=" + this.timeoutMs + ". content=" + this.content + ". ]";
    }

    public static final /* synthetic */ Lazy access$getGson$delegate$cp() {
        return gson$delegate;
    }

    public final Integer getAppType() {
        return this.appType;
    }

    public final String getContent() {
        return this.content;
    }

    public final Long getCreateTime() {
        return this.createTime;
    }

    public final Long getMessageId() {
        return this.messageId;
    }

    public final Integer getMessageType() {
        return this.messageType;
    }

    public final Long getQuestionId() {
        return this.questionId;
    }

    public final Integer getTimeoutMs() {
        return this.timeoutMs;
    }

    private static final b mpParam_delegate$lambda$0(IMAppAction r3) {
        String r0 = r3.content;
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L9;
        Companion.getClass();
        return (b) GsonProtectorUtils.fromJson((Gson) access$getGson$delegate$cp().getValue(), r3.content, b.class);
    L9:
        return null;
    L5:
        if (o0.d(r0) != true) goto L7;
        r1 = true;
        goto L7
    }

    public IMAppAction(Integer r1, Long r2, Long r3, Long r4, String r5, Integer r6, Integer r7) {
        this.appType = r1;
        this.messageId = r2;
        this.questionId = r3;
        this.createTime = r4;
        this.content = r5;
        this.messageType = r6;
        this.timeoutMs = r7;
        this.mpParam$delegate = LazyKt.lazy(new m(this));
    }

    public /* synthetic */ IMAppAction(Integer r6, Long r7, Long r8, Long r9, String r10, Integer r11, Integer r12, int r13, DefaultConstructorMarker r14) {
        String r0 = null;
        if ((r13 & 1) == 0) goto L5;
        Integer r15 = null;
    L7:
        if ((r13 & 2) == 0) goto L9;
        Long r1 = null;
    L11:
        if ((r13 & 4) == 0) goto L13;
        Long r2 = null;
    L15:
        if ((r13 & 8) == 0) goto L17;
        r9 = Long.valueOf(AppHost.a.getAppClock().currentTimeMillis());
    L17:
        Long r3 = r9;
        if ((r13 & 16) != 0) goto L22;
        r0 = r10;
    L22:
        if ((r13 & 32) == 0) goto L24;
        r11 = 1;
    L24:
        Integer r4 = r11;
        if ((r13 & 64) == 0) goto L27;
        r12 = 0;
    L27:
        this(r15, r1, r2, r3, r0, r4, r12);
        return;
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r15 = r6;
        goto L7
    }
}
