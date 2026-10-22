package com.bytedance.android.shopping.store.tabkit.router;

import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.store.mall.follows.basic.BaseFollowStoreViewModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0018\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0007\n\u0002\b*\u0018\u0000 v2\u00020\u0001:\u0001wB\u0007¢\u0006\u0004\bt\u0010uR:\u0010\u0005\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003`\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\r\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0011\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\nR!\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u00148F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00198F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010!\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b \u0010\nR\u0013\u0010#\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\"\u0010\nR\u0013\u0010%\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b$\u0010\nR\u0013\u0010'\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b&\u0010\u001eR\u0013\u0010)\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b(\u0010\u001eR\u0013\u0010+\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b*\u0010\u001eR\u0013\u0010-\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b,\u0010\nR\u0013\u0010/\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b.\u0010\nR\u0013\u00101\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b0\u0010\u001eR\u0013\u00105\u001a\u0004\u0018\u0001028F¢\u0006\u0006\u001a\u0004\b3\u00104R\u0011\u00109\u001a\u0002068F¢\u0006\u0006\u001a\u0004\b7\u00108R\u0013\u0010;\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b:\u0010\u001eR\u0013\u0010=\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\b<\u0010\u001eR\u0011\u0010?\u001a\u0002068F¢\u0006\u0006\u001a\u0004\b>\u00108R\u0013\u0010A\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b@\u0010\nR\u0013\u0010C\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bB\u0010\nR\u0013\u0010E\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bD\u0010\nR\u0011\u0010G\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bF\u0010\nR\u0011\u0010I\u001a\u0002068F¢\u0006\u0006\u001a\u0004\bH\u00108R\u0013\u0010K\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\bJ\u0010\u001eR\u0011\u0010M\u001a\u0002068F¢\u0006\u0006\u001a\u0004\bL\u00108R\u0011\u0010Q\u001a\u00020N8F¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0011\u0010S\u001a\u0002068F¢\u0006\u0006\u001a\u0004\bR\u00108R\u0011\u0010U\u001a\u0002068F¢\u0006\u0006\u001a\u0004\bT\u00108R\u0013\u0010W\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bV\u0010\nR\u0013\u0010Y\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\bX\u0010\u001eR\u0013\u0010[\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bZ\u0010\nR\u0013\u0010]\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\\\u0010\nR\u0013\u0010_\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b^\u0010\nR\u0013\u0010a\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b`\u0010\nR\u0013\u0010c\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bb\u0010\nR\u0013\u0010e\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bd\u0010\nR\u0013\u0010g\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bf\u0010\nR\u0011\u0010i\u001a\u0002068F¢\u0006\u0006\u001a\u0004\bh\u00108R\u0013\u0010k\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bj\u0010\nR\u0013\u0010m\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bl\u0010\nR\u0013\u0010o\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bn\u0010\nR\u0013\u0010q\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bp\u0010\nR\u0013\u0010s\u001a\u0004\u0018\u00010\u000e8F¢\u0006\u0006\u001a\u0004\br\u0010\u001e¨\u0006x"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/router/TabKitRouterParams;", "Ljava/io/Serializable;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "paramsMap", "Ljava/util/HashMap;", "getParamsMap", "()Ljava/util/HashMap;", "getApiUrl", "()Ljava/lang/String;", "apiUrl", "getBizTag", "bizTag", "", "getBizMode", "()I", "bizMode", "getBizCustomCategory", "bizCustomCategory", "", "", "getApiParams", "()Ljava/util/Map;", "apiParams", "", "getApiParamsKeyList", "()Ljava/util/List;", "apiParamsKeyList", "getPageModal", "()Ljava/lang/Integer;", "pageModal", "getAnchorUrl", "anchorUrl", "getAnchorApiParams", "anchorApiParams", "getAnchorUrlType", "anchorUrlType", "getAnchorTabId", "anchorTabId", "getDisablePullDownClose", "disablePullDownClose", "getDisableUpFullScreen", "disableUpFullScreen", "getPreviousPage", "previousPage", "getEnterFrom", "enterFrom", "getInitScreenStatus", "initScreenStatus", "", "getMaskAlpha", "()Ljava/lang/Double;", "maskAlpha", "", "get_maskAlphaOpt", "()Z", "_maskAlphaOpt", "getSplitRadius", "splitRadius", "getSplitIndicatorHidden", "splitIndicatorHidden", "getEnableDebugTool", "enableDebugTool", "getAnchorWebBackgroundColor", "anchorWebBackgroundColor", "getAnchorBGColor", "anchorBGColor", "getSourceBtmToken", "sourceBtmToken", "getBtmAB", "btmAB", "getEnableGrey", "enableGrey", "getAnchorHybridContainer", "anchorHybridContainer", "getEnablePadAdapter", "enablePadAdapter", "", "getPadRatio", "()F", "padRatio", "getSingleTabMode", "singleTabMode", "getShowBackIcon", "showBackIcon", "getTitle", "title", "getHeightMode", "heightMode", "getEntranceLocation", "entranceLocation", "getEcomSceneId", "ecomSceneId", "getLifecycleListenerId", "lifecycleListenerId", "getEcRequestId", "ecRequestId", "getEcPrefetchApiKey", "ecPrefetchApiKey", "getPassThroughMarketingInfo", "passThroughMarketingInfo", "getSsrUrl", "ssrUrl", "getSsrAnchorUrlFetch", "ssrAnchorUrlFetch", "getPageEnterAnim", "pageEnterAnim", "getPageExitAnim", "pageExitAnim", "getDeeplinkBackScene", "deeplinkBackScene", "getNaPrefetchCert", "naPrefetchCert", "getHeightPercent", "heightPercent", "<init>", "()V", "Companion", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TabKitRouterParams implements Serializable {
    public static final a Companion = null;
    public static final String KEY_ROUTER_PARAMS = "tabkit_router_params";

    @SerializedName("params_map")
    private final HashMap<String, String> paramsMap;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final String getAnchorApiParams() {
        return this.paramsMap.get("anchor_api_params");
    }

    public final String getAnchorBGColor() {
        String r0 = this.paramsMap.get("anchor_bg_color");
        if (r0 == null) goto L5;
        return r0;
    L5:
        return getAnchorWebBackgroundColor();
    }

    public final Integer getAnchorHybridContainer() {
        String r0 = this.paramsMap.get("anchor_hybrid_container");
        if (r0 != null) goto L7;
        return null;
    L7:
        return StringsKt.toIntOrNull(r0);
    }

    public final Integer getAnchorTabId() {
        String r0 = this.paramsMap.get("anchor_tab_id");
        if (r0 != null) goto L7;
        return null;
    L7:
        return StringsKt.toIntOrNull(r0);
    }

    public final String getAnchorUrl() {
        String r0 = this.paramsMap.get("url");
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.paramsMap.get("anchor_url");
    }

    public final String getAnchorUrlType() {
        return this.paramsMap.get("anchor_url_type");
    }

    public final String getAnchorWebBackgroundColor() {
        return this.paramsMap.get("anchor_web_background_color");
    }

    public final Map<String, Object> getApiParams() {
        return k.z(this.paramsMap.get("api_params"));
    }

    public final List<String> getApiParamsKeyList() {
        String r0 = this.paramsMap.get("api_params_key_list");
        if (r0 == null) goto L9;
        String r3 = StringsKt.removeSurrounding(r0, "[", "]");
        if (r3 == null) goto L9;
        String r9 = StringsKt.replace$default(r3, "\"", "", false, 4, null);
        if (r9 == null) goto L9;
        return StringsKt.split$default(r9, new String[]{","}, false, 0, 6, null);
    L9:
        return null;
    }

    public final String getApiUrl() {
        return this.paramsMap.get("api_url");
    }

    public final String getBizCustomCategory() {
        return this.paramsMap.get("biz_custom_category");
    }

    public final String getBizTag() {
        String r0 = this.paramsMap.get("biz_tag");
        if (r0 != null) goto L6;
        return "tabkit";
    L6:
        return r0;
    }

    public final String getBtmAB() {
        String r0 = this.paramsMap.get("btm_ab");
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final String getDeeplinkBackScene() {
        return this.paramsMap.get("deeplink_back_scene");
    }

    public final Integer getDisablePullDownClose() {
        String r0 = this.paramsMap.get("disable_pull_down_close");
        if (r0 != null) goto L7;
        return null;
    L7:
        return StringsKt.toIntOrNull(r0);
    }

    public final Integer getDisableUpFullScreen() {
        String r0 = this.paramsMap.get("disable_up_full_screen");
        if (r0 != null) goto L7;
        return null;
    L7:
        return StringsKt.toIntOrNull(r0);
    }

    public final String getEcPrefetchApiKey() {
        return this.paramsMap.get("ec_prefetch_api_key");
    }

    public final String getEcRequestId() {
        return this.paramsMap.get("ec_request_id");
    }

    public final String getEcomSceneId() {
        return this.paramsMap.get(BaseFollowStoreViewModel.KEY_ECOM_SCENE_ID);
    }

    public final boolean getEnableDebugTool() {
        String r0 = this.paramsMap.get("enable_debug_tool");
        if (r0 != null) goto L5;
        return false;
    L5:
        return k.n(r0, false);
    }

    public final boolean getEnableGrey() {
        String r0 = this.paramsMap.get("gray_enable");
        if (r0 == null) goto L5;
        Integer r1 = StringsKt.toIntOrNull(r0);
    L6:
        if (r1 != null) goto L9;
    L11:
        return false;
    L9:
        if (r1.intValue() != 1) goto L11;
        return true;
    L5:
        r1 = null;
        goto L6
    }

    public final boolean getEnablePadAdapter() {
        String r0 = this.paramsMap.get("enable_pad_adapter");
        if (r0 != null) goto L5;
        return false;
    L5:
        return k.n(r0, false);
    }

    public final String getEnterFrom() {
        return this.paramsMap.get("enter_from");
    }

    public final String getEntranceLocation() {
        return this.paramsMap.get("entrance_location");
    }

    public final Integer getHeightMode() {
        String r0 = this.paramsMap.get("height_mode");
        if (r0 != null) goto L7;
        return null;
    L7:
        return StringsKt.toIntOrNull(r0);
    }

    public final Integer getHeightPercent() {
        String r0 = this.paramsMap.get("height_percent");
        if (r0 != null) goto L7;
        return null;
    L7:
        return StringsKt.toIntOrNull(r0);
    }

    public final Integer getInitScreenStatus() {
        String r0 = this.paramsMap.get("init_screen_status");
        if (r0 != null) goto L7;
        return null;
    L7:
        return StringsKt.toIntOrNull(r0);
    }

    public final String getLifecycleListenerId() {
        return this.paramsMap.get("lifecycle_listener_id");
    }

    public final Double getMaskAlpha() {
        String r0 = this.paramsMap.get("mask_alpha");
        if (r0 != null) goto L7;
        return null;
    L7:
        return StringsKt.toDoubleOrNull(r0);
    }

    public final String getNaPrefetchCert() {
        return this.paramsMap.get("na_prefetch_cert");
    }

    public final float getPadRatio() {
        String r0 = this.paramsMap.get("pad_ratio");
        if (r0 == null) goto L7;
        Float r1 = StringsKt.toFloatOrNull(r0);
        if (r1 == null) goto L7;
        return r1.floatValue();
    L7:
        return 0.47368422f;
    }

    public final String getPageEnterAnim() {
        return this.paramsMap.get("page_enter_anim");
    }

    public final String getPageExitAnim() {
        return this.paramsMap.get("page_exit_anim");
    }

    public final Integer getPageModal() {
        String r0 = this.paramsMap.get("page_modal");
        if (r0 != null) goto L7;
        return null;
    L7:
        return StringsKt.toIntOrNull(r0);
    }

    public final String getPassThroughMarketingInfo() {
        return this.paramsMap.get("pass_through_marketing_info");
    }

    public final String getPreviousPage() {
        return this.paramsMap.get(BaseFollowStoreViewModel.KEY_PREVIOUS_PAGE);
    }

    public final boolean getShowBackIcon() {
        String r0 = this.paramsMap.get("show_back_icon");
        Boolean r1 = null;
        if (r0 == null) goto L5;
        Boolean r2 = Boolean.valueOf(k.n(r0, false));
    L9:
        if (r2 != null) goto L13;
        String r3 = this.paramsMap.get("show_close");
        if (r3 == null) goto L14;
        r1 = Boolean.valueOf(k.n(r3, false));
    L14:
        if (r1 != null) goto L16;
        return false;
    L16:
        return r1.booleanValue();
    L13:
        r1 = r2;
        goto L14
    L5:
        String r4 = this.paramsMap.get("show_back");
        if (r4 == null) goto L8;
        r2 = Boolean.valueOf(k.n(r4, false));
        goto L9
    L8:
        r2 = null;
        goto L9
    }

    public final boolean getSingleTabMode() {
        String r0 = this.paramsMap.get("single_tab_mode");
        if (r0 == null) goto L5;
        Integer r1 = StringsKt.toIntOrNull(r0);
    L6:
        if (r1 != null) goto L9;
    L11:
        return false;
    L9:
        if (r1.intValue() != 1) goto L11;
        return true;
    L5:
        r1 = null;
        goto L6
    }

    public final String getSourceBtmToken() {
        return this.paramsMap.get("source_btm_token");
    }

    public final Integer getSplitIndicatorHidden() {
        String r0 = this.paramsMap.get("split_indicator_hidden");
        if (r0 != null) goto L7;
        return null;
    L7:
        return StringsKt.toIntOrNull(r0);
    }

    public final Integer getSplitRadius() {
        String r0 = this.paramsMap.get("split_radius");
        if (r0 != null) goto L7;
        return null;
    L7:
        return StringsKt.toIntOrNull(r0);
    }

    public final boolean getSsrAnchorUrlFetch() {
        return k.n(this.paramsMap.get("ssr_anchor_url_fetch"), false);
    }

    public final String getSsrUrl() {
        return this.paramsMap.get("ssr_url");
    }

    public final String getTitle() {
        return this.paramsMap.get("title");
    }

    public final boolean get_maskAlphaOpt() {
        String r0 = this.paramsMap.get("_mask_alpha_opt");
        if (r0 != null) goto L5;
        return false;
    L5:
        return k.n(r0, false);
    }

    public TabKitRouterParams() {
        this.paramsMap = new HashMap();
    }

    public final int getBizMode() {
        if (getAnchorUrl() == null) goto L8;
        if (getApiUrl() != null) goto L8;
        return 1;
    L8:
        if (getAnchorUrl() != null) goto L10;
    L12:
        return 0;
    L10:
        if (getApiUrl() == null) goto L12;
        return 2;
    }

    public final HashMap<String, String> getParamsMap() {
        return this.paramsMap;
    }
}
