package com.bytedance.locallife.live.model;

import com.bytedance.locallife.live.settings.c;
import com.bytedance.locallife.live.util.LiveLifeSaaSUtil;
import com.bytedance.locallife.live.util.s;
import com.bytedance.locallife.live.util.t;
import com.bytedance.locallife.live.util.w;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jv6.h;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import nv6.c0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\bo\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 \u0087\u00012\u00020\u0001:\u0002\u0088\u0001B\t¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0007H\u0002J\u0016\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u0016\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\u0002J\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u000f\u001a\u00020\u0002J\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002J\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\tJ\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0007J\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tJ\u0006\u0010\u0014\u001a\u00020\u000bJ\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002J\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tJ\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\tJ\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tJ\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002R\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 R\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001c\u001a\u0004\b%\u0010\u001e\"\u0004\b&\u0010 R\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u001c\u001a\u0004\b(\u0010\u001e\"\u0004\b)\u0010 R\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u001c\u001a\u0004\b+\u0010\u001e\"\u0004\b,\u0010 R\"\u0010-\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010\u001c\u001a\u0004\b.\u0010\u001e\"\u0004\b/\u0010 R\"\u00100\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010\u001c\u001a\u0004\b1\u0010\u001e\"\u0004\b2\u0010 R\"\u00103\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010\u001c\u001a\u0004\b4\u0010\u001e\"\u0004\b5\u0010 R\"\u00106\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010\u001c\u001a\u0004\b7\u0010\u001e\"\u0004\b8\u0010 R\"\u00109\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010\u001c\u001a\u0004\b9\u0010\u001e\"\u0004\b:\u0010 R\"\u0010;\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010\u001c\u001a\u0004\b<\u0010\u001e\"\u0004\b=\u0010 R\"\u0010>\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010\u001c\u001a\u0004\b?\u0010\u001e\"\u0004\b@\u0010 R\"\u0010A\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bA\u0010C\"\u0004\bD\u0010ER\"\u0010F\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010B\u001a\u0004\bF\u0010C\"\u0004\bG\u0010ER\"\u0010H\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010\u001c\u001a\u0004\bI\u0010\u001e\"\u0004\bJ\u0010 R\"\u0010K\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bK\u0010\u001c\u001a\u0004\bL\u0010\u001e\"\u0004\bM\u0010 R\"\u0010N\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010\u001c\u001a\u0004\bO\u0010\u001e\"\u0004\bP\u0010 R\"\u0010Q\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bQ\u0010\u001c\u001a\u0004\bR\u0010\u001e\"\u0004\bS\u0010 R\"\u0010T\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010\u001c\u001a\u0004\bU\u0010\u001e\"\u0004\bV\u0010 R\"\u0010W\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010\u001c\u001a\u0004\bX\u0010\u001e\"\u0004\bY\u0010 R\"\u0010Z\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010\u001c\u001a\u0004\b[\u0010\u001e\"\u0004\b\\\u0010 R\"\u0010]\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010\u001c\u001a\u0004\b^\u0010\u001e\"\u0004\b_\u0010 R\"\u0010`\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010\u001c\u001a\u0004\b`\u0010\u001e\"\u0004\ba\u0010 R\"\u0010b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bb\u0010\u001c\u001a\u0004\bc\u0010\u001e\"\u0004\bd\u0010 R\"\u0010e\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\be\u0010\u001c\u001a\u0004\bf\u0010\u001e\"\u0004\bg\u0010 R\"\u0010h\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bh\u0010\u001c\u001a\u0004\bi\u0010\u001e\"\u0004\bj\u0010 R\"\u0010k\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bk\u0010\u001c\u001a\u0004\bl\u0010\u001e\"\u0004\bm\u0010 R\"\u0010n\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bn\u0010\u001c\u001a\u0004\bo\u0010\u001e\"\u0004\bp\u0010 R\"\u0010q\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bq\u0010\u001c\u001a\u0004\br\u0010\u001e\"\u0004\bs\u0010 R\"\u0010t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bt\u0010\u001c\u001a\u0004\bu\u0010\u001e\"\u0004\bv\u0010 R\"\u0010w\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bw\u0010\u001c\u001a\u0004\bx\u0010\u001e\"\u0004\by\u0010 R\u0016\u0010z\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010\u001cR&\u0010|\u001a\u0004\u0018\u00010{8F@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R(\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u0082\u0001\u0010\u001c\u001a\u0005\b\u0083\u0001\u0010\u001e\"\u0005\b\u0084\u0001\u0010 ¨\u0006\u0089\u0001"}, d2 = {"Lcom/bytedance/locallife/live/model/LiveLocalLifeRoomInfo;", "", "", "key", "getFromEnterLocalLifeLiveParams", "getDataFromSessionV2", "getDataFromSession", "", "getLiveEnvLogInfo", "", "getRequestParams", "", "isAlwaysPin", "getAutoAnchorInfo", "getSaleChannel", "getLifeInitialInfo", "getLifeInitialInfoWithoutDefault", "getLiveSDKLogExtra", "getLogInfoV2", "getRequestParamsV2", "isAlwaysPinV2", "getLiveRoomAddressInfoV2", "getLiveRoomAddressInfo", "getAutoAnchorInfoV2", "getLiveRecommendInfoMap", "getLiveRoomRequestParams", "getLiveRoomExtendAreaParams", "uniqueKey", "Ljava/lang/String;", "getUniqueKey", "()Ljava/lang/String;", "setUniqueKey", "(Ljava/lang/String;)V", "roomId", "getRoomId", "setRoomId", "anchorId", "getAnchorId", "setAnchorId", "enterMethod", "getEnterMethod", "setEnterMethod", ReportConstant.COMMON_ACTION_TYPE, "getActionType", "setActionType", "clickMethod", "getClickMethod", "setClickMethod", "videoId", "getVideoId", "setVideoId", "requestId", "getRequestId", "setRequestId", "enterFromMerge", "getEnterFromMerge", "setEnterFromMerge", "isOtherChannel", "setOtherChannel", "logExtra", "getLogExtra", "setLogExtra", "cid", "getCid", "setCid", "isAnchor", "Z", "()Z", "setAnchor", "(Z)V", "isPortrait", "setPortrait", "enterLocalLifeLiveParams", "getEnterLocalLifeLiveParams", "setEnterLocalLifeLiveParams", "enterLocalLifeLiveEnvParams", "getEnterLocalLifeLiveEnvParams", "setEnterLocalLifeLiveEnvParams", "searchParams", "getSearchParams", "setSearchParams", "searchId", "getSearchId", "setSearchId", "searchResultId", "getSearchResultId", "setSearchResultId", "imTrackerExtra", "getImTrackerExtra", "setImTrackerExtra", "extraParams", "getExtraParams", "setExtraParams", "deliveryStatusStart", "getDeliveryStatusStart", "setDeliveryStatusStart", "isLife", "setLife", "logPb", "getLogPb", "setLogPb", "lifeRefluxInfo", "getLifeRefluxInfo", "setLifeRefluxInfo", "lifeShareRefluxInfo", "getLifeShareRefluxInfo", "setLifeShareRefluxInfo", "lifeShareId", "getLifeShareId", "setLifeShareId", "liveRecommendInfo", "getLiveRecommendInfo", "setLiveRecommendInfo", "feedRespFrom", "getFeedRespFrom", "setFeedRespFrom", "lifeLivePackComponentConfig", "getLifeLivePackComponentConfig", "setLifeLivePackComponentConfig", "enterLocalLifeLiveActionParams", "getEnterLocalLifeLiveActionParams", "setEnterLocalLifeLiveActionParams", "addrParseCache", "Lnv6/c0;", "liveLifeEnterParams", "Lnv6/c0;", "getLiveLifeEnterParams", "()Lnv6/c0;", "setLiveLifeEnterParams", "(Lnv6/c0;)V", "liveLifeEnterParamsString", "getLiveLifeEnterParamsString", "setLiveLifeEnterParamsString", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class LiveLocalLifeRoomInfo {
    public static final a Companion = null;
    public static final String SALE_CHANNEL = "sale_channel";
    public static final String TRACE_SESSION_ID = "trace_session_id";
    private String actionType;
    private String addrParseCache;
    private String anchorId;
    private String cid;
    private String clickMethod;
    private String deliveryStatusStart;
    private String enterFromMerge;
    private String enterLocalLifeLiveActionParams;
    private String enterLocalLifeLiveEnvParams;
    private String enterLocalLifeLiveParams;
    private String enterMethod;
    private String extraParams;
    private String feedRespFrom;
    private String imTrackerExtra;
    private boolean isAnchor;
    private String isLife;
    private String isOtherChannel;
    private boolean isPortrait;
    private String lifeLivePackComponentConfig;
    private String lifeRefluxInfo;
    private String lifeShareId;
    private String lifeShareRefluxInfo;
    private c0 liveLifeEnterParams;
    private String liveLifeEnterParamsString;
    private String liveRecommendInfo;
    private String logExtra;
    private String logPb;
    private String requestId;
    private String roomId;
    private String searchId;
    private String searchParams;
    private String searchResultId;
    private String uniqueKey;
    private String videoId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final String getLiveRoomExtendAreaParams() {
        JSONObject r100 = new JSONObject(this.enterLocalLifeLiveEnvParams).optJSONObject("room_level_params");     // Catch: Exception -> L16
        if (r100 == null) goto L6;
        String r101 = r100.optString("room_id");     // Catch: Exception -> L16
    L8:
        if (Intrinsics.areEqual(r101, this.roomId) == true) goto L10;
        return null;
    L10:
        Object r102 = r100.opt("pack_showing_request_params");     // Catch: Exception -> L16
        if ((r102 instanceof JSONObject) == false) goto L13;
        JSONObject r103 = (JSONObject) r102;     // Catch: Exception -> L16
    L14:
        return String.valueOf(r103);
    L13:
        r103 = null;
        goto L14
    L6:
        r101 = null;
    L19:
        return null;
    }

    public final Map<String, Object> getLiveRoomRequestParams() {
        JSONObject r100 = new JSONObject(this.enterLocalLifeLiveEnvParams).optJSONObject("room_level_params");     // Catch: Exception -> L17
        if (r100 == null) goto L6;
        String r101 = r100.optString("room_id");     // Catch: Exception -> L17
    L8:
        if (Intrinsics.areEqual(r101, this.roomId) == true) goto L10;
        return null;
    L10:
        Object r102 = r100.opt("agg_card_request_params");     // Catch: Exception -> L17
        if ((r102 instanceof JSONObject) == false) goto L13;
        JSONObject r103 = (JSONObject) r102;     // Catch: Exception -> L17
    L14:
        if (r103 == null) goto L20;
        return w.i(r103);
    L20:
        return null;
    L13:
        r103 = null;
        goto L14
    L6:
        r101 = null;
    L21:
        return null;
    }

    private final Map<String, Object> getAutoAnchorInfo() {
        Object r100 = new JSONObject(this.enterLocalLifeLiveParams).opt("anchor_item_params");     // Catch: Exception -> L4
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type org.json.JSONObject");     // Catch: Exception -> L4
        return w.i((JSONObject) r100);
    L4:
        return null;
    }

    private final Map<String, Object> getLiveEnvLogInfo() {
        return w.h(new JSONObject(this.enterLocalLifeLiveEnvParams).optString("log_info"));
    L5:
        return new LinkedHashMap();
    }

    private final Map<String, Object> getRequestParams() {
        Object r100 = new JSONObject(this.enterLocalLifeLiveEnvParams).opt("request_params");     // Catch: Exception -> L4
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type org.json.JSONObject");     // Catch: Exception -> L4
        return w.i((JSONObject) r100);
    L4:
        return null;
    }

    private final boolean isAlwaysPin() {
        return new JSONObject(this.enterLocalLifeLiveEnvParams).optBoolean("always_pin");
    L4:
        return false;
    }

    public final String getLifeInitialInfoWithoutDefault() {
        return getDataFromSessionV2("life_initial_info");
    }

    public final c0 getLiveLifeEnterParams() {
        if (this.liveLifeEnterParams != null) goto L9;
        c0 r100 = (c0) LiveLifeSaaSUtil.r().fromJson(this.liveLifeEnterParamsString, c0.class);     // Catch: Exception -> L6
    L7:
        this.liveLifeEnterParams = r100;
    L6:
        r100 = null;
    L9:
        return this.liveLifeEnterParams;
    }

    public final Map<String, Object> getLiveRecommendInfoMap() {
        LinkedHashMap r100 = new LinkedHashMap();
        Map<String, Object> r101 = w.h(this.liveRecommendInfo);     // Catch: Exception -> L16
        h r102 = c.f();     // Catch: Exception -> L16
        if (r102 == null) goto L7;
        List<String> r103 = r102.x();     // Catch: Exception -> L16
        if (r103 == null) goto L7;
    L8:
        Iterator<T> r104 = r103.iterator();     // Catch: Exception -> L16
    L9:
        if (r104.hasNext() == false) goto L15;
        String r105 = (String) r104.next();     // Catch: Exception -> L16
        Object r106 = r101.get(r105);     // Catch: Exception -> L16
        if (r106 == null) goto L9;
        r100.put(r105, r106);     // Catch: Exception -> L16
    L7:
        r103 = CollectionsKt.listOf(new String[]{"groupon_anchor_strategy", "anchor_identity", "btm_stand_data", "room_zlb_info"});     // Catch: Exception -> L16
    L15:
        return r100;
    }

    public final String getLiveRoomAddressInfo() {
        if (this.addrParseCache.length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        String r101 = new JSONObject(this.enterLocalLifeLiveEnvParams).optString("address_info");     // Catch: Exception -> L11
        this.addrParseCache = r101;     // Catch: Exception -> L11
        return r101;
    L11:
        return null;
    L8:
        return this.addrParseCache;
    L5:
        r100 = false;
        goto L6
    }

    public final String getLiveRoomAddressInfoV2() {
        boolean r100 = false;
        if (this.addrParseCache.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        c0 r102 = getLiveLifeEnterParams();
        String r103 = "";
        if (r102 == null) goto L15;
        Map<String, Object> r104 = r102.b();
        if (r104 == null) goto L15;
        String r105 = com.bytedance.locallife.common.utils.a.a(r104, "address_info");
        if (r105 == null) goto L15;
    L17:
        if (r105.length() != 0) goto L19;
        boolean r106 = true;
    L20:
        if (r106 == false) goto L31;
        String r107 = getLiveRoomAddressInfo();
        if (r107 == null) goto L26;
        r103 = r107;
    L26:
        if (r103.length() != 0) goto L28;
        r100 = true;
    L28:
        if (r100 == true) goto L30;
        LiveLifeSaaSUtil.g().c(this.uniqueKey, "老进房", "address_info");
    L30:
        r105 = r103;
    L32:
        this.addrParseCache = r105;
        return r105;
    L31:
        LiveLifeSaaSUtil.g().c(this.uniqueKey, "新进房", "address_info");
        goto L32
    L19:
        r106 = false;
    L15:
        r105 = "";
        goto L17
    L8:
        return this.addrParseCache;
    L5:
        r101 = false;
        goto L6
    }

    public final Map<String, String> getLiveSDKLogExtra() {
        LinkedHashMap r100 = new LinkedHashMap();
        String r101 = getDataFromSessionV2("livesdk_log_extra");
        if (r101 == null) goto L5;
        getLiveSDKLogExtra$addDataToResult(r100, r101);
    L5:
        String r102 = getFromEnterLocalLifeLiveParams("livesdk_log_extra");
        if (r102 == null) goto L8;
        getLiveSDKLogExtra$addDataToResult(r100, r102);
    L8:
        return r100;
    }

    public LiveLocalLifeRoomInfo() {
        this.uniqueKey = "";
        this.roomId = "";
        this.anchorId = "";
        this.enterMethod = "";
        this.actionType = "";
        this.clickMethod = "";
        this.videoId = "";
        this.requestId = "";
        this.enterFromMerge = "";
        this.isOtherChannel = "";
        this.logExtra = "";
        this.cid = "";
        this.enterLocalLifeLiveParams = "";
        this.enterLocalLifeLiveEnvParams = "";
        this.searchParams = "";
        this.searchId = "";
        this.searchResultId = "";
        this.imTrackerExtra = "";
        this.extraParams = "";
        this.deliveryStatusStart = "";
        this.isLife = "";
        this.logPb = "";
        this.lifeRefluxInfo = "";
        this.lifeShareRefluxInfo = "";
        this.lifeShareId = "";
        this.liveRecommendInfo = "";
        this.feedRespFrom = "";
        this.lifeLivePackComponentConfig = "";
        this.enterLocalLifeLiveActionParams = "";
        this.addrParseCache = "";
    }

    public final Map<String, Object> getAutoAnchorInfoV2() {
        c0 r100 = getLiveLifeEnterParams();
        Map<String, Object> r101 = null;
        if (r100 == null) goto L7;
        Map<String, Object> r102 = r100.b();
        if (r102 == null) goto L7;
        Object r103 = r102.get("anchor_item_params");
    L9:
        if ((r103 instanceof Map) == false) goto L11;
        r101 = (Map) r103;
    L11:
        if (r101 != null) goto L15;
        r101 = getAutoAnchorInfo();
        if (r101 == null) goto L16;
        LiveLifeSaaSUtil.g().c(this.uniqueKey, "老进房", "anchor_item_params");
    L16:
        return r101;
    L15:
        LiveLifeSaaSUtil.g().c(this.uniqueKey, "新进房", "anchor_item_params");
    L7:
        r103 = null;
        goto L9
    }

    public final String getLifeInitialInfo() {
        String r100 = getLifeInitialInfoWithoutDefault();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L14;
        JSONObject r102 = new JSONObject();
        r102.put("initial_container", "livebroadcasting");
        getLifeInitialInfo$lambda$2$addData(r102, "initial_container_enter_page", this.enterFromMerge);
        getLifeInitialInfo$lambda$2$addData(r102, "initial_container_enter_method", this.enterMethod);
        getLifeInitialInfo$lambda$2$addData(r102, "initial_action_type", this.actionType);
        getLifeInitialInfo$lambda$2$addData(r102, "initial_video_id", this.videoId);
        getLifeInitialInfo$lambda$2$addData(r102, "initial_room_id", this.roomId);
        if (s.d(this.requestId) == false) goto L13;
        getLifeInitialInfo$lambda$2$addData(r102, "initial_request_id", this.requestId);
    L13:
        r100 = r102.toString();
    L14:
        if (r100 != null) goto L17;
        return "";
    L17:
        return r100;
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public final Map<String, Object> getLogInfoV2() {
        c0 r100 = getLiveLifeEnterParams();
        if (r100 == null) goto L5;
        Map<String, Object> r101 = r100.c();
    L6:
        boolean r102 = true;
        if (r101 != null) goto L9;
    L12:
        boolean r103 = true;
    L14:
        if (r103 == true) goto L17;
        LiveLifeSaaSUtil.g().c(this.uniqueKey, "新进房", "log_info");
        return r101;
    L17:
        Map<String, Object> r104 = getLiveEnvLogInfo();
        if (r104 != null) goto L20;
    L23:
        if (r102 == true) goto L25;
        LiveLifeSaaSUtil.g().c(this.uniqueKey, "老进房", "log_info");
    L25:
        return r104;
    L20:
        if (r104.isEmpty() == true) goto L23;
        r102 = false;
        goto L23
    L9:
        if (r101.isEmpty() == true) goto L12;
        r103 = false;
        goto L14
    L5:
        r101 = null;
        goto L6
    }

    public final Map<String, Object> getRequestParamsV2() {
        c0 r100 = getLiveLifeEnterParams();
        if (r100 == null) goto L5;
        Map<String, Object> r101 = r100.d();
    L6:
        boolean r102 = true;
        if (r101 != null) goto L9;
    L12:
        boolean r103 = true;
    L14:
        if (r103 == true) goto L17;
        LiveLifeSaaSUtil.g().c(this.uniqueKey, "新进房", "request_params");
        return r101;
    L17:
        Map<String, Object> r104 = getRequestParams();
        if (r104 != null) goto L20;
    L23:
        if (r102 == true) goto L25;
        LiveLifeSaaSUtil.g().c(this.uniqueKey, "老进房", "request_params");
    L25:
        return r104;
    L20:
        if (r104.isEmpty() == true) goto L23;
        r102 = false;
        goto L23
    L9:
        if (r101.isEmpty() == true) goto L12;
        r103 = false;
        goto L14
    L5:
        r101 = null;
        goto L6
    }

    public final String getSaleChannel() {
        c0 r100 = getLiveLifeEnterParams();
        if (r100 == null) goto L7;
        Map<String, Object> r101 = r100.b();
        if (r101 == null) goto L7;
        String r102 = com.bytedance.locallife.common.utils.a.a(r101, SALE_CHANNEL);
    L8:
        boolean r103 = true;
        if (r102 != null) goto L11;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == false) goto L24;
        r102 = getFromEnterLocalLifeLiveParams(SALE_CHANNEL);
        if (r102 != null) goto L19;
    L22:
        if (r103 == true) goto L25;
        LiveLifeSaaSUtil.g().c(this.uniqueKey, "老进房", SALE_CHANNEL);
    L25:
        return r102;
    L19:
        if (r102.length() == 0) goto L22;
        r103 = false;
        goto L22
    L24:
        LiveLifeSaaSUtil.g().c(this.uniqueKey, "新进房", SALE_CHANNEL);
        goto L25
    L11:
        if (r102.length() == 0) goto L14;
        r104 = false;
    L7:
        r102 = null;
        goto L8
    }

    public final boolean isAlwaysPinV2() {
        c0 r100 = getLiveLifeEnterParams();
        if (r100 == null) goto L14;
        Map<String, Object> r101 = r100.b();
        if (r101 == null) goto L14;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Intrinsics.checkNotNullParameter("always_pin", "key");
        Object r102 = r101.get("always_pin");
        if (r102 == null) goto L14;
        if (Intrinsics.areEqual(r102, BooleanCompanionObject.INSTANCE) == false) goto L12;
        Boolean r103 = (Boolean) r102;
    L15:
        if (r103 != null) goto L17;
        r103 = Boolean.valueOf(isAlwaysPin());
        LiveLifeSaaSUtil.g().c(this.uniqueKey, "老进房", "always_pin");
    L19:
        return r103.booleanValue();
    L17:
        LiveLifeSaaSUtil.g().c(this.uniqueKey, "新进房", "always_pin");
        goto L19
    L12:
        if (Intrinsics.areEqual(r102, StringCompanionObject.INSTANCE) == false) goto L14;
        r103 = Boolean.valueOf(Boolean.parseBoolean((String) r102));
    L14:
        r103 = null;
        goto L15
    }

    public final String getActionType() {
        return this.actionType;
    }

    public final String getAnchorId() {
        return this.anchorId;
    }

    public final String getCid() {
        return this.cid;
    }

    public final String getClickMethod() {
        return this.clickMethod;
    }

    public final String getDeliveryStatusStart() {
        return this.deliveryStatusStart;
    }

    public final String getEnterFromMerge() {
        return this.enterFromMerge;
    }

    public final String getEnterLocalLifeLiveActionParams() {
        return this.enterLocalLifeLiveActionParams;
    }

    public final String getEnterLocalLifeLiveEnvParams() {
        return this.enterLocalLifeLiveEnvParams;
    }

    public final String getEnterLocalLifeLiveParams() {
        return this.enterLocalLifeLiveParams;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getExtraParams() {
        return this.extraParams;
    }

    public final String getFeedRespFrom() {
        return this.feedRespFrom;
    }

    public final String getImTrackerExtra() {
        return this.imTrackerExtra;
    }

    public final String getLifeLivePackComponentConfig() {
        return this.lifeLivePackComponentConfig;
    }

    public final String getLifeRefluxInfo() {
        return this.lifeRefluxInfo;
    }

    public final String getLifeShareId() {
        return this.lifeShareId;
    }

    public final String getLifeShareRefluxInfo() {
        return this.lifeShareRefluxInfo;
    }

    public final String getLiveLifeEnterParamsString() {
        return this.liveLifeEnterParamsString;
    }

    public final String getLiveRecommendInfo() {
        return this.liveRecommendInfo;
    }

    public final String getLogExtra() {
        return this.logExtra;
    }

    public final String getLogPb() {
        return this.logPb;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getSearchId() {
        return this.searchId;
    }

    public final String getSearchParams() {
        return this.searchParams;
    }

    public final String getSearchResultId() {
        return this.searchResultId;
    }

    public final String getUniqueKey() {
        return this.uniqueKey;
    }

    public final String getVideoId() {
        return this.videoId;
    }

    public final boolean isAnchor() {
        return this.isAnchor;
    }

    public final String isLife() {
        return this.isLife;
    }

    public final String isOtherChannel() {
        return this.isOtherChannel;
    }

    public final boolean isPortrait() {
        return this.isPortrait;
    }

    private final String getDataFromSession(String r100) {
        String r101 = getFromEnterLocalLifeLiveParams(TRACE_SESSION_ID);
        if (r101 == null) goto L7;
        JSONObject r102 = t.c(r101);
        if (r102 == null) goto L7;
        return r102.optString(r100);
    L7:
        return null;
    }

    private final String getDataFromSessionV2(String r100) {
        c0 r101 = getLiveLifeEnterParams();
        if (r101 == null) goto L7;
        Map<String, Object> r102 = r101.b();
        if (r102 == null) goto L7;
        String r103 = com.bytedance.locallife.common.utils.a.a(r102, TRACE_SESSION_ID);
    L8:
        boolean r104 = true;
        if (r103 != null) goto L11;
    L14:
        boolean r105 = true;
    L15:
        if (r105 == false) goto L24;
        r103 = getFromEnterLocalLifeLiveParams(TRACE_SESSION_ID);
        if (r103 != null) goto L19;
    L22:
        if (r104 == true) goto L25;
        LiveLifeSaaSUtil.g().c(this.uniqueKey, "老进房", TRACE_SESSION_ID);
    L25:
        if (r103 == null) goto L30;
        JSONObject r106 = t.c(r103);
        if (r106 != null) goto L29;
        return null;
    L29:
        return r106.optString(r100);
    L30:
        return null;
    L19:
        if (r103.length() == 0) goto L22;
        r104 = false;
        goto L22
    L24:
        LiveLifeSaaSUtil.g().c(this.uniqueKey, "新进房", TRACE_SESSION_ID);
        goto L25
    L11:
        if (r103.length() == 0) goto L14;
        r105 = false;
    L7:
        r103 = null;
        goto L8
    }

    private final String getFromEnterLocalLifeLiveParams(String r100) {
        boolean r101 = true;
        if (r100.length() != 0) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L9;
        return null;
    L9:
        if (this.enterLocalLifeLiveParams.length() == 0) goto L12;
        r101 = false;
    L12:
        if (r101 == true) goto L20;
        return new JSONObject(this.enterLocalLifeLiveParams).optString(r100);
    L21:
        return null;
    L20:
        return null;
    L5:
        r102 = false;
        goto L7
    }

    public final void setActionType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.actionType = r100;
    }

    public final void setAnchor(boolean r100) {
        this.isAnchor = r100;
    }

    public final void setAnchorId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.anchorId = r100;
    }

    public final void setCid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cid = r100;
    }

    public final void setClickMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.clickMethod = r100;
    }

    public final void setDeliveryStatusStart(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.deliveryStatusStart = r100;
    }

    public final void setEnterFromMerge(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterFromMerge = r100;
    }

    public final void setEnterLocalLifeLiveActionParams(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterLocalLifeLiveActionParams = r100;
    }

    public final void setEnterLocalLifeLiveEnvParams(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterLocalLifeLiveEnvParams = r100;
    }

    public final void setEnterLocalLifeLiveParams(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterLocalLifeLiveParams = r100;
    }

    public final void setEnterMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterMethod = r100;
    }

    public final void setExtraParams(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.extraParams = r100;
    }

    public final void setFeedRespFrom(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.feedRespFrom = r100;
    }

    public final void setImTrackerExtra(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.imTrackerExtra = r100;
    }

    public final void setLife(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.isLife = r100;
    }

    public final void setLifeLivePackComponentConfig(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.lifeLivePackComponentConfig = r100;
    }

    public final void setLifeRefluxInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.lifeRefluxInfo = r100;
    }

    public final void setLifeShareId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.lifeShareId = r100;
    }

    public final void setLifeShareRefluxInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.lifeShareRefluxInfo = r100;
    }

    public final void setLiveLifeEnterParams(c0 r100) {
        this.liveLifeEnterParams = r100;
    }

    public final void setLiveLifeEnterParamsString(String r100) {
        this.liveLifeEnterParamsString = r100;
    }

    public final void setLiveRecommendInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.liveRecommendInfo = r100;
    }

    public final void setLogExtra(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.logExtra = r100;
    }

    public final void setLogPb(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.logPb = r100;
    }

    public final void setOtherChannel(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.isOtherChannel = r100;
    }

    public final void setPortrait(boolean r100) {
        this.isPortrait = r100;
    }

    public final void setRequestId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.requestId = r100;
    }

    public final void setRoomId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.roomId = r100;
    }

    public final void setSearchId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.searchId = r100;
    }

    public final void setSearchParams(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.searchParams = r100;
    }

    public final void setSearchResultId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.searchResultId = r100;
    }

    public final void setUniqueKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.uniqueKey = r100;
    }

    public final void setVideoId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.videoId = r100;
    }

    private static final void getLiveSDKLogExtra$addDataToResult(Map<String, String> r100, String r101) {
        JSONObject r102 = new JSONObject(r101);     // Catch: Exception -> L8
        Iterator<String> r103 = r102.keys();     // Catch: Exception -> L8
    L4:
        if (r103.hasNext() == false) goto L13;
        String r104 = r103.next();     // Catch: Exception -> L8
        r100.put(r104, r102.optString(r104));     // Catch: Exception -> L8
    L13:
        return;
    }

    private static final void getLifeInitialInfo$lambda$2$addData(JSONObject r100, String r101, String r102) {
        if (s.d(r102) == false) goto L6;
        r100.put(r101, r102);
        return;
    }
}
