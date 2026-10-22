package com.bytedance.locallife.dito.data;

import com.bytedance.locallife.dito.Dito;
import com.bytedance.locallife.dito.utils.DitoFixMapValueTypeAdapter;
import com.bytedance.locallife.dito.utils.DitoPageInfoAdapter;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.hihonor.honorid.core.data.UserInfo;
import com.obric.sva.sdk.utils.InteractConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@JsonAdapter(DitoPageInfoAdapter.class)
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u008f\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000f\u0012\u0018\b\u0002\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011\u0012\u0018\b\u0002\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011\u0012\u0016\b\u0002\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\u0018\b\u0002\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011\u0012\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\bf\u0010gJ\u0010\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0000J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0019\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011HÆ\u0003J\u0019\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011HÆ\u0003J\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011HÆ\u0003J\u0019\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u0011HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÆ\u0003J\u0091\u0002\u0010.\u001a\u00020\u00002\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000f2\u0018\b\u0002\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u00112\u0018\b\u0002\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u00112\u0016\b\u0002\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0018\b\u0002\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u00112\u0010\b\u0002\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u001bHÆ\u0001J\t\u0010/\u001a\u00020\u0005HÖ\u0001J\t\u00101\u001a\u000200HÖ\u0001J\u0013\u00104\u001a\u0002032\b\u00102\u001a\u0004\u0018\u00010\u0012HÖ\u0003R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00105\u001a\u0004\b6\u00107R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00105\u001a\u0004\b8\u00107R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00105\u001a\u0004\b9\u00107R\u001c\u0010 \u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u00105\u001a\u0004\b:\u00107R\u001c\u0010!\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u00105\u001a\u0004\b;\u00107R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u00105\u001a\u0004\b<\u00107R\u001c\u0010#\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u00105\u001a\u0004\b=\u00107R\u001c\u0010$\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u00105\u001a\u0004\b>\u00107R\u001c\u0010%\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u00105\u001a\u0004\b?\u00107R\u001c\u0010&\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010@\u001a\u0004\bA\u0010BR*\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010C\u001a\u0004\bD\u0010ER*\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010C\u001a\u0004\bF\u0010ER(\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010C\u001a\u0004\bG\u0010ER2\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010C\u001a\u0004\bH\u0010E\"\u0004\bI\u0010JR*\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001c\u0010,\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u00105\u001a\u0004\bP\u00107R\u001c\u0010-\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010Q\u001a\u0004\bR\u0010SR\u001b\u0010Y\u001a\u00020T8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR%\u0010Z\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00118\u0006¢\u0006\f\n\u0004\bZ\u0010C\u001a\u0004\b[\u0010ER)\u0010^\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\\\u0010V\u001a\u0004\b]\u0010ER$\u0010`\u001a\u0004\u0018\u00010_8F@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010e¨\u0006h"}, d2 = {"Lcom/bytedance/locallife/dito/data/DitoPageInfo;", "Ljava/io/Serializable;", "pageInfo", "", "updatePageInfo", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "Lcom/bytedance/locallife/dito/data/g;", "component10", "", "", "component11", "component12", "component13", "component14", "", "Lcom/bytedance/locallife/dito/data/DitoEvent;", "component15", "component16", "Lcom/google/gson/JsonObject;", "component17", "id", "pageId", "pageKey", "version", "createdTime", "name", UserInfo.UPDATE_TIME, "sessionId", InteractConst.WAKEUP_SESSION_TYPE, "extraConfig", "trackParams", "globalTrackParams", "globalBtmParams", "data", "events", "bizCode", "debugInfo", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "getPageId", "getPageKey", "getVersion", "getCreatedTime", "getName", "getUpdateTime", "getSessionId", "getSessionType", "Lcom/bytedance/locallife/dito/data/g;", "getExtraConfig", "()Lcom/bytedance/locallife/dito/data/g;", "Ljava/util/Map;", "getTrackParams", "()Ljava/util/Map;", "getGlobalTrackParams", "getGlobalBtmParams", "getData", "setData", "(Ljava/util/Map;)V", "Ljava/util/List;", "getEvents", "()Ljava/util/List;", "setEvents", "(Ljava/util/List;)V", "getBizCode", "Lcom/google/gson/JsonObject;", "getDebugInfo", "()Lcom/google/gson/JsonObject;", "Lcom/google/gson/Gson;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lkotlin/Lazy;", "getGsonWithMapTypeAdapter", "()Lcom/google/gson/Gson;", "gsonWithMapTypeAdapter", "qualityParams", "getQualityParams", "b", "getGlobalTrackParamsStrMap", "globalTrackParamsStrMap", "Lcom/bytedance/locallife/dito/data/w;", "disasterRecoveryConfig", "Lcom/bytedance/locallife/dito/data/w;", "getDisasterRecoveryConfig", "()Lcom/bytedance/locallife/dito/data/w;", "setDisasterRecoveryConfig", "(Lcom/bytedance/locallife/dito/data/w;)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/locallife/dito/data/g;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/lang/String;Lcom/google/gson/JsonObject;)V", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3})
public final class DitoPageInfo implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient Lazy f258188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient Lazy f258189b;

    @SerializedName(UniContext.KEY_OF_BIZ_CODE)
    private final String bizCode;

    @SerializedName("createdTime")
    private final String createdTime;

    @SerializedName("data")
    private Map<String, Object> data;

    @SerializedName("debugInfo")
    private final JsonObject debugInfo;
    private w disasterRecoveryConfig;

    @SerializedName("events")
    private List<DitoEvent> events;

    @SerializedName(GearStrategy.GEAR_STRATEGY_KEY_EXTRA_CONFIG)
    private final g extraConfig;

    @SerializedName("globalBtmParams")
    private final Map<String, Object> globalBtmParams;

    @SerializedName("globalTrackParams")
    @JsonAdapter(DitoFixMapValueTypeAdapter.class)
    private final Map<String, Object> globalTrackParams;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f258190id;

    @SerializedName("name")
    private final String name;

    @SerializedName("pageId")
    private final String pageId;

    @SerializedName("pageKey")
    private final String pageKey;
    private final Map<String, Object> qualityParams;

    @SerializedName("session_id")
    private final String sessionId;

    @SerializedName(alternate = {InteractConst.WAKEUP_SESSION_TYPE}, value = "session_type")
    private final String sessionType;

    @SerializedName("trackParams")
    @JsonAdapter(DitoFixMapValueTypeAdapter.class)
    private final Map<String, Object> trackParams;

    @SerializedName(UserInfo.UPDATE_TIME)
    private final String updateTime;

    @SerializedName("version")
    private final String version;

    public DitoPageInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DitoPageInfo copy$default(DitoPageInfo r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, String r215, String r216, g r217, Map r218, Map r219, Map r310, Map r311, List r312, String r313, JsonObject r314, int r315, Object r316) {
        if ((r315 & 1) == 0) goto L5;
        String r100 = r110.f258190id;
    L7:
        if ((r315 & 2) == 0) goto L9;
        String r101 = r110.pageId;
    L11:
        if ((r315 & 4) == 0) goto L13;
        String r102 = r110.pageKey;
    L15:
        if ((r315 & 8) == 0) goto L17;
        String r103 = r110.version;
    L19:
        if ((r315 & 16) == 0) goto L21;
        String r104 = r110.createdTime;
    L23:
        if ((r315 & 32) == 0) goto L25;
        String r105 = r110.name;
    L27:
        if ((r315 & 64) == 0) goto L29;
        String r106 = r110.updateTime;
    L31:
        if ((r315 & 128) == 0) goto L33;
        String r107 = r110.sessionId;
    L35:
        if ((r315 & 256) == 0) goto L37;
        String r113 = r110.sessionType;
    L39:
        if ((r315 & 512) == 0) goto L41;
        g r114 = r110.extraConfig;
    L43:
        if ((r315 & 1024) == 0) goto L45;
        Map r115 = r110.trackParams;
    L47:
        if ((r315 & 2048) == 0) goto L49;
        Map r116 = r110.globalTrackParams;
    L51:
        if ((r315 & 4096) == 0) goto L53;
        Map r117 = r110.globalBtmParams;
    L55:
        if ((r315 & 8192) == 0) goto L57;
        Map r118 = r110.data;
    L58:
        Map r317 = r118;
        if ((r315 & 16384) == 0) goto L61;
        List r119 = r110.events;
    L62:
        List r318 = r119;
        if ((r315 & 32768) == 0) goto L65;
        String r120 = r110.bizCode;
    L67:
        if ((r315 & 65536) == 0) goto L69;
        JsonObject r108 = r110.debugInfo;
    L71:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r317, r318, r120, r108);
    L69:
        r108 = r314;
        goto L71
    L65:
        r120 = r313;
        goto L67
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final String component1() {
        return this.f258190id;
    }

    public final g component10() {
        return this.extraConfig;
    }

    public final Map<String, Object> component11() {
        return this.trackParams;
    }

    public final Map<String, Object> component12() {
        return this.globalTrackParams;
    }

    public final Map<String, Object> component13() {
        return this.globalBtmParams;
    }

    public final Map<String, Object> component14() {
        return this.data;
    }

    public final List<DitoEvent> component15() {
        return this.events;
    }

    public final String component16() {
        return this.bizCode;
    }

    public final JsonObject component17() {
        return this.debugInfo;
    }

    public final String component2() {
        return this.pageId;
    }

    public final String component3() {
        return this.pageKey;
    }

    public final String component4() {
        return this.version;
    }

    public final String component5() {
        return this.createdTime;
    }

    public final String component6() {
        return this.name;
    }

    public final String component7() {
        return this.updateTime;
    }

    public final String component8() {
        return this.sessionId;
    }

    public final String component9() {
        return this.sessionType;
    }

    public final DitoPageInfo copy(String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, g r219, Map<String, Object> r310, Map<String, Object> r311, Map<String, Object> r312, Map<String, Object> r313, List<DitoEvent> r314, String r315, JsonObject r316) {
        return new DitoPageInfo(r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DitoPageInfo) == true) goto L8;
        return false;
    L8:
        DitoPageInfo r101 = (DitoPageInfo) r100;
        if (Intrinsics.areEqual(this.f258190id, r101.f258190id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.pageId, r101.pageId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.pageKey, r101.pageKey) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.version, r101.version) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.createdTime, r101.createdTime) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.name, r101.name) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.updateTime, r101.updateTime) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.sessionId, r101.sessionId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.sessionType, r101.sessionType) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.extraConfig, r101.extraConfig) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.trackParams, r101.trackParams) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.globalTrackParams, r101.globalTrackParams) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.globalBtmParams, r101.globalBtmParams) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.data, r101.data) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.events, r101.events) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.bizCode, r101.bizCode) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.debugInfo, r101.debugInfo) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public int hashCode() {
        String r100 = this.f258190id;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.pageId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.pageKey;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.version;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.createdTime;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.name;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.updateTime;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.sessionId;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.sessionType;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        g r128 = this.extraConfig;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Map<String, Object> r131 = this.trackParams;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Map<String, Object> r134 = this.globalTrackParams;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Map<String, Object> r137 = this.globalBtmParams;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        Map<String, Object> r140 = this.data;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        List<DitoEvent> r143 = this.events;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.bizCode;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (r145 + r147) * 31;
        JsonObject r149 = this.debugInfo;
        if (r149 == null) goto L71;
        r101 = r149.hashCode();
    L71:
        return r148 + r101;
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

    public String toString() {
        return "DitoPageInfo(id=" + this.f258190id + ", pageId=" + this.pageId + ", pageKey=" + this.pageKey + ", version=" + this.version + ", createdTime=" + this.createdTime + ", name=" + this.name + ", updateTime=" + this.updateTime + ", sessionId=" + this.sessionId + ", sessionType=" + this.sessionType + ", extraConfig=" + this.extraConfig + ", trackParams=" + this.trackParams + ", globalTrackParams=" + this.globalTrackParams + ", globalBtmParams=" + this.globalBtmParams + ", data=" + this.data + ", events=" + this.events + ", bizCode=" + this.bizCode + ", debugInfo=" + this.debugInfo + ')';
    }

    public final void updatePageInfo(DitoPageInfo r100) {
    }

    public final w getDisasterRecoveryConfig() {
        w r100 = this.disasterRecoveryConfig;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Map<String, Object> r101 = this.data;
        w r102 = null;
        if (r101 == null) goto L8;
        Object r103 = r101.get("disasterRecoveryConfig");
    L10:
        if ((r103 instanceof Map) == false) goto L12;
        Map r104 = (Map) r103;
    L13:
        if (r104 == null) goto L15;
        Dito r105 = Dito.f257280a;
        Gson r106 = com.bytedance.locallife.dito.utils.l.d();
        r102 = (w) GsonProtectorUtils.fromJson(r106, GsonProtectorUtils.toJson(r106, r104), w.class);
    L15:
        this.disasterRecoveryConfig = r102;
        return r102;
    L12:
        r104 = null;
        goto L13
    L8:
        r103 = null;
        goto L10
    }

    public final Map<String, String> getGlobalTrackParamsStrMap() {
        return (Map) this.f258189b.getValue();
    }

    public final Gson getGsonWithMapTypeAdapter() {
        return (Gson) this.f258188a.getValue();
    }

    public final String getBizCode() {
        return this.bizCode;
    }

    public final String getCreatedTime() {
        return this.createdTime;
    }

    public final Map<String, Object> getData() {
        return this.data;
    }

    public final JsonObject getDebugInfo() {
        return this.debugInfo;
    }

    public final List<DitoEvent> getEvents() {
        return this.events;
    }

    public final g getExtraConfig() {
        return this.extraConfig;
    }

    public final Map<String, Object> getGlobalBtmParams() {
        return this.globalBtmParams;
    }

    public final Map<String, Object> getGlobalTrackParams() {
        return this.globalTrackParams;
    }

    public final String getId() {
        return this.f258190id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final String getPageKey() {
        return this.pageKey;
    }

    public final Map<String, Object> getQualityParams() {
        return this.qualityParams;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getSessionType() {
        return this.sessionType;
    }

    public final Map<String, Object> getTrackParams() {
        return this.trackParams;
    }

    public final String getUpdateTime() {
        return this.updateTime;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setData(Map<String, Object> r100) {
        this.data = r100;
    }

    public final void setDisasterRecoveryConfig(w r100) {
        this.disasterRecoveryConfig = r100;
    }

    public final void setEvents(List<DitoEvent> r100) {
        this.events = r100;
    }

    public DitoPageInfo(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r110, String r111, g r112, Map<String, Object> r113, Map<String, Object> r114, Map<String, Object> r115, Map<String, Object> r116, List<DitoEvent> r117, String r118, JsonObject r119) {
        this.f258190id = r100;
        this.pageId = r101;
        this.pageKey = r102;
        this.version = r103;
        this.createdTime = r104;
        this.name = r105;
        this.updateTime = r106;
        this.sessionId = r110;
        this.sessionType = r111;
        this.extraConfig = r112;
        this.trackParams = r113;
        this.globalTrackParams = r114;
        this.globalBtmParams = r115;
        this.data = r116;
        this.events = r117;
        this.bizCode = r118;
        this.debugInfo = r119;
        this.f258188a = LazyKt.lazy(DitoPageInfo$gsonWithMapTypeAdapter$2.INSTANCE);
        this.qualityParams = new LinkedHashMap();
        this.f258189b = LazyKt.lazy(new DitoPageInfo$globalTrackParamsStrMap$2(this));
    }

    public /* synthetic */ DitoPageInfo(String r110, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, g r218, Map r219, Map r310, Map r311, Map r312, List r313, String r314, JsonObject r315, int r316, DefaultConstructorMarker r317) {
        if ((r316 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r316 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r316 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r316 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r316 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r316 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r316 & 64) == 0) goto L29;
        String r106 = "";
    L31:
        if ((r316 & 128) == 0) goto L33;
        String r107 = UUID.randomUUID().toString();
    L35:
        if ((r316 & 256) == 0) goto L37;
        String r111 = "";
    L39:
        if ((r316 & 512) == 0) goto L41;
        g r112 = null;
    L43:
        if ((r316 & 1024) == 0) goto L45;
        Map r113 = null;
    L47:
        if ((r316 & 2048) == 0) goto L49;
        Map r114 = new LinkedHashMap();
    L51:
        if ((r316 & 4096) == 0) goto L53;
        Map r115 = new LinkedHashMap();
    L55:
        if ((r316 & 8192) == 0) goto L57;
        Map r116 = null;
    L59:
        if ((r316 & 16384) == 0) goto L61;
        List r108 = null;
    L63:
        if ((r316 & 32768) == 0) goto L65;
        String r117 = "";
    L67:
        if ((r316 & 65536) == 0) goto L69;
        JsonObject r109 = null;
    L70:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r111, r112, r113, r114, r115, r116, r108, r117, r109);
        return;
    L69:
        r109 = r315;
        goto L70
    L65:
        r117 = r314;
        goto L67
    L61:
        r108 = r313;
        goto L63
    L57:
        r116 = r312;
        goto L59
    L53:
        r115 = r311;
        goto L55
    L49:
        r114 = r310;
        goto L51
    L45:
        r113 = r219;
        goto L47
    L41:
        r112 = r218;
        goto L43
    L37:
        r111 = r217;
        goto L39
    L33:
        r107 = r216;
        goto L35
    L29:
        r106 = r215;
        goto L31
    L25:
        r105 = r214;
        goto L27
    L21:
        r104 = r213;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
