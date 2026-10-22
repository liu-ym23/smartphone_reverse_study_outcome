package com.larus.bmhome.chat.trace.appreciable;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import androidx.collection.LruCache;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.auth.LaunchCacheDelegate;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class ChatPageTrace {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache<String, ChatPageRecord> f310101a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f310102b;

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\bK\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001Bá\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b$\u0010%J\u0006\u0010j\u001a\u00020kJ\u0010\u0010l\u001a\u00020k2\u0006\u0010m\u001a\u00020\u0005H\u0002J\b\u0010n\u001a\u0004\u0018\u00010oJ \u0010p\u001a\u00020k2\u0006\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020\u00032\u0006\u0010t\u001a\u00020\u0003H\u0002R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b1\u0010+\"\u0004\b2\u0010-R \u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010'\"\u0004\b4\u0010)R\"\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b5\u0010+\"\u0004\b6\u0010-R \u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010'\"\u0004\b8\u0010)R \u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010'\"\u0004\b:\u0010)R \u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010'\"\u0004\b<\u0010)R \u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010'\"\u0004\b>\u0010)R\"\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010C\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\bD\u0010+\"\u0004\bE\u0010-R\"\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\bF\u0010+\"\u0004\bG\u0010-R \u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010'\"\u0004\bI\u0010)R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010M\u001a\u0004\b\u0013\u0010J\"\u0004\bK\u0010LR\u001e\u0010\u0015\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\"\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010M\u001a\u0004\b\u0016\u0010J\"\u0004\bR\u0010LR\"\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\bS\u0010+\"\u0004\bT\u0010-R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\bU\u0010+\"\u0004\bV\u0010-R\"\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\bW\u0010+\"\u0004\bX\u0010-R \u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010'\"\u0004\bZ\u0010)R\"\u0010\u001b\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010C\u001a\u0004\b[\u0010@\"\u0004\b\\\u0010BR\"\u0010\u001c\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010C\u001a\u0004\b\u001c\u0010@\"\u0004\b]\u0010BR\"\u0010\u001d\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010C\u001a\u0004\b^\u0010@\"\u0004\b_\u0010BR\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b`\u0010aR\u001e\u0010 \u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\bb\u0010+\"\u0004\bc\u0010-R\u001e\u0010!\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\bd\u0010+\"\u0004\be\u0010-R\u001e\u0010\"\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\bf\u0010+\"\u0004\bg\u0010-R\u001e\u0010#\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\bh\u0010+\"\u0004\bi\u0010-¨\u0006u"}, d2 = {"Lcom/larus/bmhome/chat/trace/appreciable/ChatPageTrace$ChatPageRecord;", "", "channel", "", "totalDuration", "", "loadDuration", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "schema", "distanceToAppStart", "cvsId", "botId", "chatType", "previousPage", "hasLocal", "", "bindDuration", "createToBindDuration", "mainBotCovId", "isMainBot", "", "bindMessageType", "isPluginReadyWhenClick", "clickEntranceToPluginReadyCost", "pluginReadyToFlowSdkReadyCost", "silentAuthCost", "initEnterFrom", "flowInited", "isFirstEnter", "authStatusCode", "extraInfoBundle", "Landroid/os/Bundle;", "onCreateTime", "onStartTime", "onPageLoadTime", "onDataBindTime", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;ILjava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Landroid/os/Bundle;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getChannel", "()Ljava/lang/String;", "setChannel", "(Ljava/lang/String;)V", "getTotalDuration", "()Ljava/lang/Long;", "setTotalDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getLoadDuration", "setLoadDuration", "getSession", "setSession", "getSchema", "setSchema", "getDistanceToAppStart", "setDistanceToAppStart", "getCvsId", "setCvsId", "getBotId", "setBotId", "getChatType", "setChatType", "getPreviousPage", "setPreviousPage", "getHasLocal", "()Ljava/lang/Integer;", "setHasLocal", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getBindDuration", "setBindDuration", "getCreateToBindDuration", "setCreateToBindDuration", "getMainBotCovId", "setMainBotCovId", "()Ljava/lang/Boolean;", "setMainBot", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getBindMessageType", "()I", "setBindMessageType", "(I)V", "setPluginReadyWhenClick", "getClickEntranceToPluginReadyCost", "setClickEntranceToPluginReadyCost", "getPluginReadyToFlowSdkReadyCost", "setPluginReadyToFlowSdkReadyCost", "getSilentAuthCost", "setSilentAuthCost", "getInitEnterFrom", "setInitEnterFrom", "getFlowInited", "setFlowInited", "setFirstEnter", "getAuthStatusCode", "setAuthStatusCode", "getExtraInfoBundle", "()Landroid/os/Bundle;", "getOnCreateTime", "setOnCreateTime", "getOnStartTime", "setOnStartTime", "getOnPageLoadTime", "setOnPageLoadTime", "getOnDataBindTime", "setOnDataBindTime", "report", "", "appendAdditionalTracingInfo", "onDataBindTimeStamp", "toJSONObject", "Lorg/json/JSONObject;", "writeFileToExternalStorage", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "filename", "content", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ChatPageRecord {

        @SerializedName("auth_status_code")
        private Integer authStatusCode;

        @SerializedName("bind_duration")
        private Long bindDuration;

        @SerializedName("bind_msg_type")
        private int bindMessageType;

        @SerializedName("bot_id")
        private String botId;

        @SerializedName("channel")
        private String channel;

        @SerializedName("chat_type")
        private String chatType;

        @SerializedName("click_entrance_to_plugin_ready_cost")
        private Long clickEntranceToPluginReadyCost;

        @SerializedName("created_to_bind_duration")
        private Long createToBindDuration;

        @SerializedName("conversation_id")
        private String cvsId;

        @SerializedName("distance_to_app_start")
        private Long distanceToAppStart;
        private final transient Bundle extraInfoBundle;

        @SerializedName("flow_inited")
        private Integer flowInited;

        @SerializedName("has_local")
        private Integer hasLocal;

        @SerializedName("init_enter_from")
        private String initEnterFrom;

        @SerializedName("is_first_enter")
        private Integer isFirstEnter;

        @SerializedName("is_main_bot")
        private Boolean isMainBot;

        @SerializedName("is_plugin_ready_when_click")
        private Boolean isPluginReadyWhenClick;

        @SerializedName("load_duration")
        private Long loadDuration;

        @SerializedName("main_bot_conv_id")
        private String mainBotCovId;
        private transient Long onCreateTime;
        private transient Long onDataBindTime;
        private transient Long onPageLoadTime;
        private transient Long onStartTime;

        @SerializedName("plugin_ready_to_flow_sdk_ready_cost")
        private Long pluginReadyToFlowSdkReadyCost;

        @SerializedName("previous_page")
        private String previousPage;

        @SerializedName("schema")
        private String schema;

        @SerializedName(AppbrandHostConstants.SCHEMA_INSPECT.SESSION)
        private Long session;

        @SerializedName("silent_auth_cost")
        private Long silentAuthCost;

        @SerializedName("total_duration")
        private Long totalDuration;

        public ChatPageRecord() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 536870911, null);
        }

        public final void report() {
            Long r100 = this.onStartTime;
            Long r101 = this.onPageLoadTime;
            Long r102 = this.onDataBindTime;
            Long r103 = this.onCreateTime;
            wc9.e r104 = AuthModelDelegate.f297134b.y().getValue();
            if (r104 != null) goto L6;
            r104 = LaunchCacheDelegate.f295726b.b();
        L6:
            if (r104 == null) goto L8;
            String r105 = r104.f559198a;
        L9:
            this.mainBotCovId = r105;
            this.isMainBot = Boolean.valueOf(Intrinsics.areEqual(r105, this.cvsId));
            if (r100 == null) goto L24;
            if (r101 == null) goto L25;
            if (r102 == null) goto L26;
            if (r103 == null) goto L27;
            this.loadDuration = Long.valueOf(r101.longValue() - r100.longValue());
            this.bindDuration = Long.valueOf(r102.longValue() - r101.longValue());
            this.totalDuration = Long.valueOf(r102.longValue() - r100.longValue());
            this.createToBindDuration = Long.valueOf(r102.longValue() - r103.longValue());
            appendAdditionalTracingInfo(r102.longValue());
            JSONObject r106 = toJSONObject();
            if (r106 == null) goto L17;
            com.larus.utils.a0.a(r106, com.flow.kmp.common.util.g.b(ce9.a.a().toString()));
        L18:
            FLogger.f375446a.i("ChatPageTrace", "reportEvent, param=" + r106);
            Objects.toString(r106);
            if (r106 == null) goto L28;
            com.larus.platform.service.o.f365780a.reportEvent("page_chat_first_paint", r106);
            com.larus.bmhome.utils.c.a("page_chat_first_paint", r106, true);
            if (com.larus.network.http.d.f360144e == false) goto L29;
            BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new ChatPageTrace$ChatPageRecord$report$1$1(this, r106, null), 2, null);
            return;
        L29:
            return;
        L28:
            return;
        L17:
            r106 = null;
            goto L18
        L27:
            return;
        L26:
            return;
        L25:
            return;
        L24:
            return;
        L8:
            r105 = null;
            goto L9
        }

        public final JSONObject toJSONObject() {
            Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
            Object r101 = Result.m9449constructorimpl(new JSONObject(new Gson().toJson(this)));     // Catch: Throwable -> L4
        L7:
            if (Result.m9455isFailureimpl(r101) == false) goto L10;
            r101 = null;
        L10:
            return (JSONObject) r101;
        L4:
            th = move-exception;
            Result.Companion r102 = Result.Companion;
            r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L7
        }

        public final Integer getAuthStatusCode() {
            return this.authStatusCode;
        }

        public final Long getBindDuration() {
            return this.bindDuration;
        }

        public final int getBindMessageType() {
            return this.bindMessageType;
        }

        public final String getBotId() {
            return this.botId;
        }

        public final String getChannel() {
            return this.channel;
        }

        public final String getChatType() {
            return this.chatType;
        }

        public final Long getClickEntranceToPluginReadyCost() {
            return this.clickEntranceToPluginReadyCost;
        }

        public final Long getCreateToBindDuration() {
            return this.createToBindDuration;
        }

        public final String getCvsId() {
            return this.cvsId;
        }

        public final Long getDistanceToAppStart() {
            return this.distanceToAppStart;
        }

        public final Bundle getExtraInfoBundle() {
            return this.extraInfoBundle;
        }

        public final Integer getFlowInited() {
            return this.flowInited;
        }

        public final Integer getHasLocal() {
            return this.hasLocal;
        }

        public final String getInitEnterFrom() {
            return this.initEnterFrom;
        }

        public final Long getLoadDuration() {
            return this.loadDuration;
        }

        public final String getMainBotCovId() {
            return this.mainBotCovId;
        }

        public final Long getOnCreateTime() {
            return this.onCreateTime;
        }

        public final Long getOnDataBindTime() {
            return this.onDataBindTime;
        }

        public final Long getOnPageLoadTime() {
            return this.onPageLoadTime;
        }

        public final Long getOnStartTime() {
            return this.onStartTime;
        }

        public final Long getPluginReadyToFlowSdkReadyCost() {
            return this.pluginReadyToFlowSdkReadyCost;
        }

        public final String getPreviousPage() {
            return this.previousPage;
        }

        public final String getSchema() {
            return this.schema;
        }

        public final Long getSession() {
            return this.session;
        }

        public final Long getSilentAuthCost() {
            return this.silentAuthCost;
        }

        public final Long getTotalDuration() {
            return this.totalDuration;
        }

        public final Integer isFirstEnter() {
            return this.isFirstEnter;
        }

        public final Boolean isMainBot() {
            return this.isMainBot;
        }

        public final Boolean isPluginReadyWhenClick() {
            return this.isPluginReadyWhenClick;
        }

        private final void appendAdditionalTracingInfo(long r100) {
            if (AppHost.f326268a.isPlugin() == false) goto L61;
            Bundle r101 = this.extraInfoBundle;
            boolean r102 = true;
            if (r101 != null) goto L7;
        L9:
            boolean r103 = false;
        L10:
            if (r103 == false) goto L12;
            this.isPluginReadyWhenClick = Boolean.valueOf(this.extraInfoBundle.getBoolean("is_plugin_ready_when_click"));
        L12:
            Bundle r104 = this.extraInfoBundle;
            if (r104 != null) goto L15;
        L17:
            boolean r105 = false;
        L18:
            if (r105 == false) goto L20;
            this.clickEntranceToPluginReadyCost = Long.valueOf(this.extraInfoBundle.getLong("click_entrance_to_plugin_ready_cost"));
        L20:
            Bundle r106 = this.extraInfoBundle;
            if (r106 != null) goto L23;
        L25:
            boolean r107 = false;
        L26:
            if (r107 == false) goto L28;
            this.pluginReadyToFlowSdkReadyCost = Long.valueOf(this.extraInfoBundle.getLong("plugin_ready_to_flow_sdk_ready_cost"));
        L28:
            Bundle r108 = this.extraInfoBundle;
            if (r108 != null) goto L31;
        L33:
            boolean r109 = false;
        L34:
            if (r109 == false) goto L36;
            this.silentAuthCost = Long.valueOf(this.extraInfoBundle.getLong("silent_auth_cost"));
        L36:
            Bundle r110 = this.extraInfoBundle;
            if (r110 != null) goto L39;
        L41:
            boolean r111 = false;
        L42:
            if (r111 == false) goto L44;
            this.totalDuration = Long.valueOf(r100 - this.extraInfoBundle.getLong("click_douyin_entrance_timestamp"));
        L44:
            Bundle r112 = this.extraInfoBundle;
            if (r112 != null) goto L47;
        L49:
            boolean r113 = false;
        L50:
            if (r113 == false) goto L52;
            this.initEnterFrom = this.extraInfoBundle.getString("init_enter_from");
        L52:
            Bundle r114 = this.extraInfoBundle;
            if (r114 != null) goto L55;
        L57:
            r102 = false;
        L58:
            if (r102 == false) goto L62;
            this.flowInited = Integer.valueOf(this.extraInfoBundle.getInt("flow_inited"));
            return;
        L62:
            return;
        L55:
            if (r114.containsKey("flow_inited") != true) goto L57;
        L47:
            if (r112.containsKey("init_enter_from") != true) goto L49;
            r113 = true;
            goto L50
        L39:
            if (r110.containsKey("click_douyin_entrance_timestamp") != true) goto L41;
            r111 = true;
            goto L42
        L31:
            if (r108.containsKey("silent_auth_cost") != true) goto L33;
            r109 = true;
            goto L34
        L23:
            if (r106.containsKey("plugin_ready_to_flow_sdk_ready_cost") != true) goto L25;
            r107 = true;
            goto L26
        L15:
            if (r104.containsKey("click_entrance_to_plugin_ready_cost") != true) goto L17;
            r105 = true;
            goto L18
        L7:
            if (r101.containsKey("is_plugin_ready_when_click") != true) goto L9;
            r103 = true;
            goto L10
        }

        public final void setAuthStatusCode(Integer r100) {
            this.authStatusCode = r100;
        }

        public final void setBindDuration(Long r100) {
            this.bindDuration = r100;
        }

        public final void setBindMessageType(int r100) {
            this.bindMessageType = r100;
        }

        public final void setBotId(String r100) {
            this.botId = r100;
        }

        public final void setChannel(String r100) {
            this.channel = r100;
        }

        public final void setChatType(String r100) {
            this.chatType = r100;
        }

        public final void setClickEntranceToPluginReadyCost(Long r100) {
            this.clickEntranceToPluginReadyCost = r100;
        }

        public final void setCreateToBindDuration(Long r100) {
            this.createToBindDuration = r100;
        }

        public final void setCvsId(String r100) {
            this.cvsId = r100;
        }

        public final void setDistanceToAppStart(Long r100) {
            this.distanceToAppStart = r100;
        }

        public final void setFirstEnter(Integer r100) {
            this.isFirstEnter = r100;
        }

        public final void setFlowInited(Integer r100) {
            this.flowInited = r100;
        }

        public final void setHasLocal(Integer r100) {
            this.hasLocal = r100;
        }

        public final void setInitEnterFrom(String r100) {
            this.initEnterFrom = r100;
        }

        public final void setLoadDuration(Long r100) {
            this.loadDuration = r100;
        }

        public final void setMainBot(Boolean r100) {
            this.isMainBot = r100;
        }

        public final void setMainBotCovId(String r100) {
            this.mainBotCovId = r100;
        }

        public final void setOnCreateTime(Long r100) {
            this.onCreateTime = r100;
        }

        public final void setOnDataBindTime(Long r100) {
            this.onDataBindTime = r100;
        }

        public final void setOnPageLoadTime(Long r100) {
            this.onPageLoadTime = r100;
        }

        public final void setOnStartTime(Long r100) {
            this.onStartTime = r100;
        }

        public final void setPluginReadyToFlowSdkReadyCost(Long r100) {
            this.pluginReadyToFlowSdkReadyCost = r100;
        }

        public final void setPluginReadyWhenClick(Boolean r100) {
            this.isPluginReadyWhenClick = r100;
        }

        public final void setPreviousPage(String r100) {
            this.previousPage = r100;
        }

        public final void setSchema(String r100) {
            this.schema = r100;
        }

        public final void setSession(Long r100) {
            this.session = r100;
        }

        public final void setSilentAuthCost(Long r100) {
            this.silentAuthCost = r100;
        }

        public final void setTotalDuration(Long r100) {
            this.totalDuration = r100;
        }

        private final void writeFileToExternalStorage(Context r100, String r101, String r102) {
            if (Intrinsics.areEqual(Environment.getExternalStorageState(), "mounted") == false) goto L21;
            PolarisFileOutputStreamWrapper r103 = new PolarisFileOutputStreamWrapper(new PolarisFileWrapper(r100.getExternalFilesDir(null), r101));     // Catch: Exception -> L13
            r103.write(r102.getBytes(Charsets.UTF_8));     // Catch: Throwable -> L8
            Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L8
            CloseableKt.closeFinally(r103, null);     // Catch: Exception -> L13
            return;
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            CloseableKt.closeFinally(r103, th);     // Catch: Exception -> L13
            throw th;     // Catch: Exception -> L13
        L13:
            e = move-exception;
            FLogger.f375446a.e("ChatPageTrace", "exception=" + e.getMessage());
            com.larus.platform.service.g.f365738a.ensureNotReachHere(e);
            return;
        }

        public static final /* synthetic */ void access$writeFileToExternalStorage(ChatPageRecord r100, Context r101, String r102, String r103) {
            r100.writeFileToExternalStorage(r101, r102, r103);
        }

        public ChatPageRecord(String r100, Long r101, Long r102, Long r103, String r104, Long r105, String r106, String r110, String r111, String r112, Integer r113, Long r114, Long r115, String r116, Boolean r117, int r118, Boolean r119, Long r210, Long r211, Long r212, String r213, Integer r214, Integer r215, Integer r216, Bundle r217, Long r218, Long r219, Long r310, Long r311) {
            this.channel = r100;
            this.totalDuration = r101;
            this.loadDuration = r102;
            this.session = r103;
            this.schema = r104;
            this.distanceToAppStart = r105;
            this.cvsId = r106;
            this.botId = r110;
            this.chatType = r111;
            this.previousPage = r112;
            this.hasLocal = r113;
            this.bindDuration = r114;
            this.createToBindDuration = r115;
            this.mainBotCovId = r116;
            this.isMainBot = r117;
            this.bindMessageType = r118;
            this.isPluginReadyWhenClick = r119;
            this.clickEntranceToPluginReadyCost = r210;
            this.pluginReadyToFlowSdkReadyCost = r211;
            this.silentAuthCost = r212;
            this.initEnterFrom = r213;
            this.flowInited = r214;
            this.isFirstEnter = r215;
            this.authStatusCode = r216;
            this.extraInfoBundle = r217;
            this.onCreateTime = r218;
            this.onStartTime = r219;
            this.onPageLoadTime = r310;
            this.onDataBindTime = r311;
        }

        public /* synthetic */ ChatPageRecord(String r310, Long r311, Long r312, Long r313, String r314, Long r315, String r316, String r317, String r318, String r410, Integer r411, Long r412, Long r413, String r414, Boolean r415, int r416, Boolean r417, Long r418, Long r419, Long r510, String r511, Integer r512, Integer r513, Integer r514, Bundle r515, Long r516, Long r517, Long r518, Long r519, int r610, DefaultConstructorMarker r611) {
            if ((r610 & 1) == 0) goto L5;
            String r100 = null;
        L7:
            if ((r610 & 2) == 0) goto L9;
            Long r101 = null;
        L11:
            if ((r610 & 4) == 0) goto L13;
            Long r102 = null;
        L15:
            if ((r610 & 8) == 0) goto L17;
            Long r103 = null;
        L19:
            if ((r610 & 16) == 0) goto L21;
            String r104 = null;
        L23:
            if ((r610 & 32) == 0) goto L25;
            Long r105 = null;
        L27:
            if ((r610 & 64) == 0) goto L29;
            String r106 = null;
        L31:
            if ((r610 & 128) == 0) goto L33;
            String r107 = null;
        L35:
            if ((r610 & 256) == 0) goto L37;
            String r110 = null;
        L39:
            if ((r610 & 512) == 0) goto L41;
            String r111 = null;
        L43:
            if ((r610 & 1024) == 0) goto L45;
            Integer r112 = null;
        L47:
            if ((r610 & 2048) == 0) goto L49;
            Long r113 = null;
        L51:
            if ((r610 & 4096) == 0) goto L53;
            Long r114 = null;
        L55:
            if ((r610 & 8192) == 0) goto L57;
            String r115 = null;
        L59:
            if ((r610 & 16384) == 0) goto L61;
            Boolean r108 = null;
        L63:
            if ((r610 & 32768) == 0) goto L65;
            int r116 = -1;
        L67:
            if ((r610 & 65536) == 0) goto L69;
            Boolean r117 = null;
        L71:
            if ((r610 & 131072) == 0) goto L73;
            Long r118 = null;
        L75:
            if ((r610 & 262144) == 0) goto L77;
            Long r210 = null;
        L79:
            if ((r610 & 524288) == 0) goto L81;
            Long r211 = 0L;
        L83:
            if ((r610 & 1048576) == 0) goto L85;
            String r212 = null;
        L87:
            if ((r610 & 2097152) == 0) goto L89;
            Integer r213 = -1;
        L91:
            if ((r610 & 4194304) == 0) goto L93;
            Integer r214 = -1;
        L95:
            if ((r610 & 8388608) == 0) goto L97;
            Integer r119 = -1;
        L99:
            if ((r610 & 16777216) == 0) goto L101;
            Bundle r215 = null;
        L103:
            if ((r610 & 33554432) == 0) goto L105;
            Long r216 = null;
        L107:
            if ((r610 & 67108864) == 0) goto L109;
            Long r217 = null;
        L111:
            if ((r610 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
            Long r218 = null;
        L115:
            if ((r610 & 268435456) == 0) goto L117;
            Long r109 = null;
        L118:
            this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r210, r211, r212, r213, r214, r119, r215, r216, r217, r218, r109);
            return;
        L117:
            r109 = r519;
            goto L118
        L113:
            r218 = r518;
            goto L115
        L109:
            r217 = r517;
            goto L111
        L105:
            r216 = r516;
            goto L107
        L101:
            r215 = r515;
            goto L103
        L97:
            r119 = r514;
            goto L99
        L93:
            r214 = r513;
            goto L95
        L89:
            r213 = r512;
            goto L91
        L85:
            r212 = r511;
            goto L87
        L81:
            r211 = r510;
            goto L83
        L77:
            r210 = r419;
            goto L79
        L73:
            r118 = r418;
            goto L75
        L69:
            r117 = r417;
            goto L71
        L65:
            r116 = r416;
            goto L67
        L61:
            r108 = r415;
            goto L63
        L57:
            r115 = r414;
            goto L59
        L53:
            r114 = r413;
            goto L55
        L49:
            r113 = r412;
            goto L51
        L45:
            r112 = r411;
            goto L47
        L41:
            r111 = r410;
            goto L43
        L37:
            r110 = r318;
            goto L39
        L33:
            r107 = r317;
            goto L35
        L29:
            r106 = r316;
            goto L31
        L25:
            r105 = r315;
            goto L27
        L21:
            r104 = r314;
            goto L23
        L17:
            r103 = r313;
            goto L19
        L13:
            r102 = r312;
            goto L15
        L9:
            r101 = r311;
            goto L11
        L5:
            r100 = r310;
            goto L7
        }
    }

    static {
        f310101a = new LruCache(10);
        f310102b = true;
    }

    public static String a(String r100) {
        if (o0.d(r100) == true) goto L13;
        wc9.e r101 = AuthModelDelegate.f297134b.y().getValue();
        if (r101 != null) goto L8;
        r101 = LaunchCacheDelegate.f295726b.b();
    L8:
        if (r101 != null) goto L12;
        return null;
    L12:
        return r101.f559198a;
    L13:
        return r100;
    }
}
