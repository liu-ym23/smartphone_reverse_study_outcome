package com.bytedance.android.shopping.base.event;

import android.net.Uri;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.ECAdLogParams;
import com.bytedance.android.shopping.api.anchorv3.ECAwemeItemInfo;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.api.anchorv3.ECLubanData;
import com.bytedance.android.shopping.api.anchorv3.ECProductDetailPageShowStyle;
import com.bytedance.android.shopping.api.anchorv3.ECProductInfo;
import com.bytedance.android.shopping.api.anchorv3.ECSceneTransitionData;
import com.bytedance.android.shopping.api.anchorv3.ECShareFission;
import com.bytedance.android.shopping.api.anchorv3.ECUIParam;
import com.bytedance.android.shopping.api.anchorv3.WireFrameSchemaInfo;
import com.bytedance.android.shopping.orderlist.list.model.PageEnvironment;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.Gson;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements b {
    public final /* synthetic */ EventActionImpl a;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void appendEventParamToEntranceInfo(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.a.appendEventParamToEntranceInfo(r2, r3);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void appendEventParams(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "paramsMap");
        this.a.appendEventParams(r2);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void appendEventParams(Pair<String, ? extends Object>... r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.a.appendEventParams(r2);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void clearEventParams() {
        this.a.clearEventParams();
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void doEventAction(String r2, PageFinder r3, Map<String, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r2, "actionName");
        Intrinsics.checkNotNullParameter(r4, "params");
        this.a.doEventAction(r2, r3, r4);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void doEventAction(String r2, PageFinder r3, Pair<String, ? extends Object>... r4) {
        Intrinsics.checkNotNullParameter(r2, "actionName");
        Intrinsics.checkNotNullParameter(r4, "params");
        this.a.doEventAction(r2, r3, r4);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void doEventAction(String r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "actionName");
        Intrinsics.checkNotNullParameter(r3, "params");
        this.a.doEventAction(r2, r3);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void doEventAction(String r2, Pair<String, ? extends Object>... r3) {
        Intrinsics.checkNotNullParameter(r2, "actionName");
        Intrinsics.checkNotNullParameter(r3, "params");
        this.a.doEventAction(r2, r3);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void initEventContext(Map<String, ? extends Object> r2) {
        Intrinsics.checkNotNullParameter(r2, "paramsMap");
        this.a.initEventContext(r2);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void initEventContext(Pair<String, ? extends Object>... r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.a.initEventContext(r2);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final Map<String, Object> getEventParams() {
        return this.a.c();
    }

    public d() {
        this.a = new EventActionImpl();
    }

    public final void b(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "url");
        Intrinsics.checkNotNullParameter(r4, "sessionId");
        Set r1 = ECProcessMonitor.a;
        doEventAction("ec_enter_page", MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("origin_schema", ECProcessMonitor.f(r3)), TuplesKt.to("EVENT_ORIGIN_FEATURE", "TEMAI"), TuplesKt.to("session_id", r4), TuplesKt.to("scene_btm", "a1.b8094.c0.d0")}));
    }

    public static String a(ECProductInfo r15, ECAwemeItemInfo r16, JSONObject r17, ECAdLogExtra r18, String r19, ECProductDetailPageShowStyle r20, ECLubanData r21, ECLogExtraData r22, JSONObject r23, ECUIParam r24, String r25, String r26, String r27, String r28, ECShareFission r29, ECAdLogParams r30, String r31, String r32) {
        Intrinsics.checkNotNullParameter(r15, "productInfo");
        Intrinsics.checkNotNullParameter(r16, "awemeInfo");
        Intrinsics.checkNotNullParameter(r17, "metaParam");
        Intrinsics.checkNotNullParameter(r20, "detailPageStyle");
        Intrinsics.checkNotNullParameter(r22, "logExtraData");
        Uri.Builder r7 = UriProtector.parse("sslocal://ec_goods_detail/?rebuild_schema=1").buildUpon();
        r7.appendQueryParameter("meta_params", r17.toString());
        if (r23 == null) goto L5;
        r7.appendQueryParameter("request_additions", r23.toString());
    L5:
        Integer r10 = r16.getFollowStatus();
        if (r10 == null) goto L8;
        int r11 = r10.intValue();
        JSONObject r13 = new JSONObject();
        r13.put(PdpOpenThirdParam.KEY_FOLLOW_STATUS, r11);
    L9:
        if (r13 == null) goto L11;
        r7.appendQueryParameter("v3_events_additions", r13.toString());
    L11:
        r7.appendQueryParameter(PdpOpenThirdParam.KEY_SOURCE_PAGE, r22.getEnterFrom());
        r7.appendQueryParameter("enter_method", r22.getEnterMethod());
        String r12 = r22.getEComEntranceForm();
        if (r12 == null) goto L14;
        r7.appendQueryParameter("ecom_entrance_form", r12);
    L14:
        r7.appendQueryParameter(PdpOpenThirdParam.KEY_ITEM_ID, r16.getItemId());
        r7.appendQueryParameter("show_sku_panel", String.valueOf(r20.getShowSkuPanel()));
        String r14 = r22.getLabelNameLive();
        if (r14 == null) goto L17;
        r7.appendQueryParameter("label_name_live", r14);
    L17:
        String r110 = r22.getLabelNameFromLive();
        if (r110 == null) goto L20;
        r7.appendQueryParameter("label_name_from_live", r110);
    L20:
        String r111 = r22.getBaseVerifiedCategory();
        if (r111 == null) goto L23;
        r7.appendQueryParameter("base_verified_category", r111);
    L23:
        if (r18 == null) goto L27;
        String r112 = r18.getLogExtra();
        if (r112 == null) goto L27;
        r7.appendQueryParameter("log_extra", r112);
    L27:
        if (r18 == null) goto L31;
        String r113 = r18.getCreativeId();
        if (r113 == null) goto L31;
        r7.appendQueryParameter("creative_id", r113);
    L31:
        if (r18 == null) goto L35;
        String r114 = r18.getAdExtraData();
        if (r114 == null) goto L35;
        r7.appendQueryParameter("ad_extra_data", r114);
    L35:
        if (r24 == null) goto L39;
        String r115 = r24.getLiveWindowRoomId();
        if (r115 == null) goto L39;
        r7.appendQueryParameter("live_window_room_id", r115);
    L39:
        String r116 = r15.getFrameCovImage();
        if (r116 == null) goto L42;
        r7.appendQueryParameter("cover_img", r116);
    L42:
        if (r24 == null) goto L46;
        String r117 = r24.getSellPoint();
        if (r117 == null) goto L46;
        r7.appendQueryParameter("elastic_title", r117);
    L46:
        if (r28 == null) goto L48;
        r7.appendQueryParameter("mask_color", r28);
    L48:
        if (r30 == null) goto L52;
        Integer r4 = r30.isFromAd();
        if (r4 == null) goto L52;
        r7.appendQueryParameter("is_from_ad", String.valueOf(r4.intValue()));
    L52:
        if (r30 == null) goto L56;
        String r5 = r30.getEnableCommonAdTrack();
        if (r5 == null) goto L56;
        r7.appendQueryParameter("enable_common_ad_track", r5);
    L56:
        if (r24 == null) goto L60;
        String r6 = r24.getFractionListenerId();
        if (r6 == null) goto L60;
        r7.appendQueryParameter("fraction_listener_id", r6);
    L60:
        if (r24 == null) goto L64;
        String r8 = r24.getPageStateListenerId();
        if (r8 == null) goto L64;
        r7.appendQueryParameter("page_state_listener_id", r8);
    L64:
        if (r24 == null) goto L68;
        String r9 = r24.getPageStateListenerExtra();
        if (r9 == null) goto L68;
        r7.appendQueryParameter("page_state_listener_extra", r9);
    L68:
        if (r32 == null) goto L70;
        r7.appendQueryParameter("preload_extra", r32);
    L70:
        r7.appendQueryParameter(PdpOpenThirdParam.KEY_PROMOTION_ID, r15.getCurrentPromotionId());
        r7.appendQueryParameter("kol_id", r16.getUserId());
        r7.appendQueryParameter(PdpOpenThirdParam.KEY_SEC_AUTHOR_ID, r16.getSecUid());
        if (r24 == null) goto L75;
        String r33 = r24.getRequestPage();
        if (r33 == null) goto L75;
        r7.appendQueryParameter("request_page", r33);
    L75:
        String r34 = r22.getThreeDLogData();
        if (r34 == null) goto L78;
        r7.appendQueryParameter("KEY_THREE_D", r34);
    L78:
        if (r25 == null) goto L80;
        r7.appendQueryParameter("user_addr_id", r25);
    L80:
        if (r26 == null) goto L82;
        r7.appendQueryParameter("ad_ui_control_params", r26);
    L82:
        if (r27 == null) goto L84;
        r7.appendQueryParameter("domain_params", r27);
    L84:
        if (r29 == null) goto L88;
        String r1 = r29.getShareScene();
        if (r1 == null) goto L88;
        r7.appendQueryParameter("share_scene", r1);
    L88:
        if (r29 == null) goto L92;
        String r2 = r29.getSecActivityInfo();
        if (r2 == null) goto L92;
        r7.appendQueryParameter("sec_activity_info", r2);
    L92:
        if (r24 == null) goto L96;
        WireFrameSchemaInfo r3 = r24.getWireFrameSchemaInfo();
        if (r3 == null) goto L96;
        r7.appendQueryParameter("product_pre_info", GsonProtectorUtils.toJson(new Gson(), r3));
    L96:
        if (r24 == null) goto L100;
        String r35 = r24.getFirstCid();
        if (r35 == null) goto L100;
        r7.appendQueryParameter("first_cid", r35);
    L100:
        if (r24 == null) goto L104;
        String r36 = r24.getLiveHotSaleComponent();
        if (r36 == null) goto L104;
        r7.appendQueryParameter("live_hot_sale_component", r36);
    L104:
        if (r24 == null) goto L110;
        ECSceneTransitionData r37 = r24.getSceneTransitionData();
        if (r37 == null) goto L110;
        String r38 = r37.getTransitionName();
        if (r38 == null) goto L110;
        r7.appendQueryParameter("share_element_transition_name", r38);
    L110:
        if (r19 == null) goto L112;
        r7.appendQueryParameter("source_btm_token", r19);
    L112:
        if (r24 == null) goto L116;
        String r0 = r24.getHeaderConfig();
        if (r0 == null) goto L116;
        r7.appendQueryParameter("header_config", r0);
    L116:
        if (r31 == null) goto L118;
        r7.appendQueryParameter("pendant_params", r31);
    L118:
        if (r24 == null) goto L123;
        String r39 = r24.getSkuId();
        if (r39 == null) goto L123;
        r7.appendQueryParameter("sku_id", r39);
    L123:
        if (r20.getFullMode() == false) goto L125;
        r7.appendQueryParameter(PageEnvironment.FULLSCREEN, "1");
    L126:
        if (r21 == null) goto L132;
        if (r21.isLuban() == false) goto L130;
        r7.appendQueryParameter("is_luban", "1");
        goto L132
    L130:
        r7.appendQueryParameter("is_luban", "0");
    L132:
        if (r20.getWrappedWithActivity() == false) goto L134;
        r7.appendQueryParameter("open_with_activity", "1");
    L135:
        if (r24 != null) goto L137;
    L140:
        if (r24 != null) goto L142;
    L145:
        if (r24 != null) goto L147;
    L150:
        if (r24 != null) goto L152;
    L155:
        if (r24 != null) goto L157;
    L160:
        if (r24 != null) goto L162;
    L165:
        if (r24 == null) goto L169;
        Integer r40 = r24.getPanelHeightPercent();
        if (r40 == null) goto L169;
        r7.appendQueryParameter("height_percent", String.valueOf(r40.intValue()));
    L169:
        if (r24 == null) goto L173;
        Integer r41 = r24.getPanelHeight();
        if (r41 == null) goto L173;
        r7.appendQueryParameter("panel_height", String.valueOf(r41.intValue()));
    L173:
        r7.appendQueryParameter(PdpOpenThirdParam.KEY_PROMOTION_SOURCE, String.valueOf(r15.getPromotionSource()));
        if (r24 == null) goto L181;
        ECSceneTransitionData r42 = r24.getSceneTransitionData();
        if (r42 == null) goto L181;
        Integer r43 = r42.getTransitionSharedViewId();
        if (r43 == null) goto L181;
        r7.appendQueryParameter("share_element_view_id", String.valueOf(r43.intValue()));
    L181:
        return r7.build().toString();
    L162:
        if (r24.getAutoAddToCart() == false) goto L164;
        r7.appendQueryParameter("auto_add_to_cart", "1");
        goto L165
    L164:
        r7.appendQueryParameter("auto_add_to_cart", "0");
        goto L165
    L157:
        if (r24.getAutoBuyNow() == false) goto L159;
        r7.appendQueryParameter("auto_buy_now", "1");
        goto L160
    L159:
        r7.appendQueryParameter("auto_buy_now", "0");
        goto L160
    L152:
        if (r24.getClientCacheDisable() == false) goto L154;
        r7.appendQueryParameter("client_cache_disable", "1");
        goto L155
    L154:
        r7.appendQueryParameter("client_cache_disable", "0");
        goto L155
    L147:
        if (r24.getVideoPriority() == false) goto L149;
        r7.appendQueryParameter("small_window_priority", "1");
        goto L150
    L149:
        r7.appendQueryParameter("small_window_priority", "0");
        goto L150
    L142:
        if (r24.getMuteSmallWindow() == false) goto L144;
        r7.appendQueryParameter("small_window_mute", "1");
        goto L145
    L144:
        r7.appendQueryParameter("small_window_mute", "0");
        goto L145
    L137:
        if (r24.getDisableLiveWindow() == false) goto L139;
        r7.appendQueryParameter("disable_live_window", "1");
        goto L140
    L139:
        r7.appendQueryParameter("disable_live_window", "0");
        goto L140
    L134:
        r7.appendQueryParameter("open_with_activity", "0");
        goto L135
    L125:
        r7.appendQueryParameter(PageEnvironment.FULLSCREEN, "0");
        goto L126
    L8:
        r13 = null;
        goto L9
    }
}
