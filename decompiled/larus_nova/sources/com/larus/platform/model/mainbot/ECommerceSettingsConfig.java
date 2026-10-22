package com.larus.platform.model.mainbot;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b=\b\u0087\b\u0018\u00002\u00020\u0001B\u008b\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u0017\u0012\u0012\b\u0002\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u0017¢\u0006\u0004\b\u001d\u0010\u001eJ\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0003HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\u0013\u0010K\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u0017HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\u0013\u0010N\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u0017HÆ\u0003J\u0013\u0010O\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u0017HÆ\u0003J\u008d\u0002\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\u0012\b\u0002\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\u0012\b\u0002\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u00172\u0012\b\u0002\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u0017HÆ\u0001J\u0013\u0010Q\u001a\u00020\u00032\b\u0010R\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010S\u001a\u00020\u0005HÖ\u0001J\t\u0010T\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010 R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010 R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010 R\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010 R\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010 R\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010 R\u0016\u0010\u000f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010 R\u0016\u0010\u0010\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010 R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010 R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010 R\u0016\u0010\u0013\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010 R\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010 R\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010 R \u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0016\u0010\u0019\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010 R\u0016\u0010\u001a\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010 R \u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u00104R \u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00104¨\u0006U"}, d2 = {"Lcom/larus/platform/model/mainbot/ECommerceSettingsConfig;", "", "initLiveWait", "", "pluginLoadInStrategy", "", "enablePluginLoadInLoading", "enableMiraPlugin", "initLiveStrategySdk", "enableOpenSchemaOptimizeAndroid", "initLiveLiveIOSdk", "enableLiveSmartRouterOptimize", "enableLiveSaaSDeepLinkConfig", "enableSearchResultRefresh", "enableOpenH5AndAuth", "enableAuthWithCoupon", "enableChatWithDeliveryAddress", "enableLivePerformanceMonitor", "enableBtmSwitchKeva", "enableLiveFileProviderFix", "enableDownloadFileJsbOpt", "enableAutoExposureManager", "autoExposureWidgetIdList", "", "", "enableOrderMessageNotificationSettings", "enableFindSimilar", "findSimilarActionBarInstructionTypeList", "findSimilarLlmIntentionDetailList", "<init>", "(ZIZZZZZZZZZZZZZZZZLjava/util/List;ZZLjava/util/List;Ljava/util/List;)V", "getInitLiveWait", "()Z", "getPluginLoadInStrategy", "()I", "getEnablePluginLoadInLoading", "getEnableMiraPlugin", "getInitLiveStrategySdk", "getEnableOpenSchemaOptimizeAndroid", "getInitLiveLiveIOSdk", "getEnableLiveSmartRouterOptimize", "getEnableLiveSaaSDeepLinkConfig", "getEnableSearchResultRefresh", "getEnableOpenH5AndAuth", "getEnableAuthWithCoupon", "getEnableChatWithDeliveryAddress", "getEnableLivePerformanceMonitor", "getEnableBtmSwitchKeva", "getEnableLiveFileProviderFix", "getEnableDownloadFileJsbOpt", "getEnableAutoExposureManager", "getAutoExposureWidgetIdList", "()Ljava/util/List;", "getEnableOrderMessageNotificationSettings", "getEnableFindSimilar", "getFindSimilarActionBarInstructionTypeList", "getFindSimilarLlmIntentionDetailList", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "copy", "equals", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ECommerceSettingsConfig {

    @SerializedName("auto_exposure_widget_id_list")
    private final List<String> autoExposureWidgetIdList;

    @SerializedName("enable_auth_with_coupon")
    private final boolean enableAuthWithCoupon;

    @SerializedName("enable_auto_exposure_manager")
    private final boolean enableAutoExposureManager;

    @SerializedName("enable_btm_switch_keva")
    private final boolean enableBtmSwitchKeva;

    @SerializedName("enable_chat_with_delivery_address")
    private final boolean enableChatWithDeliveryAddress;

    @SerializedName("enable_download_file_jsb_opt")
    private final boolean enableDownloadFileJsbOpt;

    @SerializedName("enable_find_similar")
    private final boolean enableFindSimilar;

    @SerializedName("enable_live_file_provider_fix")
    private final boolean enableLiveFileProviderFix;

    @SerializedName("enable_live_performance_monitor")
    private final boolean enableLivePerformanceMonitor;

    @SerializedName("enable_live_saas_deep_link_config")
    private final boolean enableLiveSaaSDeepLinkConfig;

    @SerializedName("enable_live_smart_router_optimize")
    private final boolean enableLiveSmartRouterOptimize;

    @SerializedName("enable_mira_plugin")
    private final boolean enableMiraPlugin;

    @SerializedName("enable_open_h5_and_auth")
    private final boolean enableOpenH5AndAuth;

    @SerializedName("enable_open_schema_optimize_android")
    private final boolean enableOpenSchemaOptimizeAndroid;

    @SerializedName("enable_order_message_notification_settings")
    private final boolean enableOrderMessageNotificationSettings;

    @SerializedName("enable_plugin_load_in_loading")
    private final boolean enablePluginLoadInLoading;

    @SerializedName("enable_search_result_refresh")
    private final boolean enableSearchResultRefresh;

    @SerializedName("find_similar_action_bar_instruction_type_list")
    private final List<String> findSimilarActionBarInstructionTypeList;

    @SerializedName("find_similar_llm_intention_detail_list")
    private final List<String> findSimilarLlmIntentionDetailList;

    @SerializedName("init_live_liveio_sdk")
    private final boolean initLiveLiveIOSdk;

    @SerializedName("init_live_strategy_sdk")
    private final boolean initLiveStrategySdk;

    @SerializedName("init_live_wait")
    private final boolean initLiveWait;

    @SerializedName("plugin_load_in_strategy")
    private final int pluginLoadInStrategy;

    public ECommerceSettingsConfig() {
        this(false, 0, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, null, false, false, null, null, 8388607, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECommerceSettingsConfig copy$default(ECommerceSettingsConfig r110, boolean r111, int r112, boolean r210, boolean r211, boolean r212, boolean r213, boolean r214, boolean r215, boolean r216, boolean r217, boolean r218, boolean r219, boolean r310, boolean r311, boolean r312, boolean r313, boolean r314, boolean r315, List r316, boolean r317, boolean r318, List r319, List r410, int r411, Object r412) {
        if ((r411 & 1) == 0) goto L5;
        boolean r100 = r110.initLiveWait;
    L7:
        if ((r411 & 2) == 0) goto L9;
        int r101 = r110.pluginLoadInStrategy;
    L11:
        if ((r411 & 4) == 0) goto L13;
        boolean r102 = r110.enablePluginLoadInLoading;
    L15:
        if ((r411 & 8) == 0) goto L17;
        boolean r103 = r110.enableMiraPlugin;
    L19:
        if ((r411 & 16) == 0) goto L21;
        boolean r104 = r110.initLiveStrategySdk;
    L23:
        if ((r411 & 32) == 0) goto L25;
        boolean r105 = r110.enableOpenSchemaOptimizeAndroid;
    L27:
        if ((r411 & 64) == 0) goto L29;
        boolean r106 = r110.initLiveLiveIOSdk;
    L31:
        if ((r411 & 128) == 0) goto L33;
        boolean r107 = r110.enableLiveSmartRouterOptimize;
    L35:
        if ((r411 & 256) == 0) goto L37;
        boolean r113 = r110.enableLiveSaaSDeepLinkConfig;
    L39:
        if ((r411 & 512) == 0) goto L41;
        boolean r114 = r110.enableSearchResultRefresh;
    L43:
        if ((r411 & 1024) == 0) goto L45;
        boolean r115 = r110.enableOpenH5AndAuth;
    L47:
        if ((r411 & 2048) == 0) goto L49;
        boolean r116 = r110.enableAuthWithCoupon;
    L51:
        if ((r411 & 4096) == 0) goto L53;
        boolean r117 = r110.enableChatWithDeliveryAddress;
    L55:
        if ((r411 & 8192) == 0) goto L57;
        boolean r118 = r110.enableLivePerformanceMonitor;
    L58:
        boolean r320 = r118;
        if ((r411 & 16384) == 0) goto L61;
        boolean r119 = r110.enableBtmSwitchKeva;
    L62:
        boolean r321 = r119;
        if ((r411 & 32768) == 0) goto L65;
        boolean r120 = r110.enableLiveFileProviderFix;
    L66:
        boolean r322 = r120;
        if ((r411 & 65536) == 0) goto L69;
        boolean r121 = r110.enableDownloadFileJsbOpt;
    L70:
        boolean r323 = r121;
        if ((r411 & 131072) == 0) goto L73;
        boolean r122 = r110.enableAutoExposureManager;
    L74:
        boolean r324 = r122;
        if ((r411 & 262144) == 0) goto L77;
        List r123 = r110.autoExposureWidgetIdList;
    L78:
        List r325 = r123;
        if ((r411 & 524288) == 0) goto L81;
        boolean r124 = r110.enableOrderMessageNotificationSettings;
    L82:
        boolean r326 = r124;
        if ((r411 & 1048576) == 0) goto L85;
        boolean r125 = r110.enableFindSimilar;
    L86:
        boolean r327 = r125;
        if ((r411 & 2097152) == 0) goto L89;
        List r126 = r110.findSimilarActionBarInstructionTypeList;
    L91:
        if ((r411 & 4194304) == 0) goto L93;
        List r108 = r110.findSimilarLlmIntentionDetailList;
    L95:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r126, r108);
    L93:
        r108 = r410;
        goto L95
    L89:
        r126 = r319;
        goto L91
    L85:
        r125 = r318;
        goto L86
    L81:
        r124 = r317;
        goto L82
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
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

    public final boolean component1() {
        return this.initLiveWait;
    }

    public final boolean component10() {
        return this.enableSearchResultRefresh;
    }

    public final boolean component11() {
        return this.enableOpenH5AndAuth;
    }

    public final boolean component12() {
        return this.enableAuthWithCoupon;
    }

    public final boolean component13() {
        return this.enableChatWithDeliveryAddress;
    }

    public final boolean component14() {
        return this.enableLivePerformanceMonitor;
    }

    public final boolean component15() {
        return this.enableBtmSwitchKeva;
    }

    public final boolean component16() {
        return this.enableLiveFileProviderFix;
    }

    public final boolean component17() {
        return this.enableDownloadFileJsbOpt;
    }

    public final boolean component18() {
        return this.enableAutoExposureManager;
    }

    public final List<String> component19() {
        return this.autoExposureWidgetIdList;
    }

    public final int component2() {
        return this.pluginLoadInStrategy;
    }

    public final boolean component20() {
        return this.enableOrderMessageNotificationSettings;
    }

    public final boolean component21() {
        return this.enableFindSimilar;
    }

    public final List<String> component22() {
        return this.findSimilarActionBarInstructionTypeList;
    }

    public final List<String> component23() {
        return this.findSimilarLlmIntentionDetailList;
    }

    public final boolean component3() {
        return this.enablePluginLoadInLoading;
    }

    public final boolean component4() {
        return this.enableMiraPlugin;
    }

    public final boolean component5() {
        return this.initLiveStrategySdk;
    }

    public final boolean component6() {
        return this.enableOpenSchemaOptimizeAndroid;
    }

    public final boolean component7() {
        return this.initLiveLiveIOSdk;
    }

    public final boolean component8() {
        return this.enableLiveSmartRouterOptimize;
    }

    public final boolean component9() {
        return this.enableLiveSaaSDeepLinkConfig;
    }

    public final ECommerceSettingsConfig copy(boolean r210, int r211, boolean r212, boolean r213, boolean r310, boolean r311, boolean r312, boolean r313, boolean r314, boolean r315, boolean r316, boolean r317, boolean r318, boolean r319, boolean r410, boolean r411, boolean r412, boolean r413, List<String> r414, boolean r415, boolean r416, List<String> r417, List<String> r418) {
        return new ECommerceSettingsConfig(r210, r211, r212, r213, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r410, r411, r412, r413, r414, r415, r416, r417, r418);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ECommerceSettingsConfig) == true) goto L8;
        return false;
    L8:
        ECommerceSettingsConfig r101 = (ECommerceSettingsConfig) r100;
        if (this.initLiveWait == r101.initLiveWait) goto L12;
        return false;
    L12:
        if (this.pluginLoadInStrategy == r101.pluginLoadInStrategy) goto L15;
        return false;
    L15:
        if (this.enablePluginLoadInLoading == r101.enablePluginLoadInLoading) goto L18;
        return false;
    L18:
        if (this.enableMiraPlugin == r101.enableMiraPlugin) goto L21;
        return false;
    L21:
        if (this.initLiveStrategySdk == r101.initLiveStrategySdk) goto L24;
        return false;
    L24:
        if (this.enableOpenSchemaOptimizeAndroid == r101.enableOpenSchemaOptimizeAndroid) goto L27;
        return false;
    L27:
        if (this.initLiveLiveIOSdk == r101.initLiveLiveIOSdk) goto L30;
        return false;
    L30:
        if (this.enableLiveSmartRouterOptimize == r101.enableLiveSmartRouterOptimize) goto L33;
        return false;
    L33:
        if (this.enableLiveSaaSDeepLinkConfig == r101.enableLiveSaaSDeepLinkConfig) goto L36;
        return false;
    L36:
        if (this.enableSearchResultRefresh == r101.enableSearchResultRefresh) goto L39;
        return false;
    L39:
        if (this.enableOpenH5AndAuth == r101.enableOpenH5AndAuth) goto L42;
        return false;
    L42:
        if (this.enableAuthWithCoupon == r101.enableAuthWithCoupon) goto L45;
        return false;
    L45:
        if (this.enableChatWithDeliveryAddress == r101.enableChatWithDeliveryAddress) goto L48;
        return false;
    L48:
        if (this.enableLivePerformanceMonitor == r101.enableLivePerformanceMonitor) goto L51;
        return false;
    L51:
        if (this.enableBtmSwitchKeva == r101.enableBtmSwitchKeva) goto L54;
        return false;
    L54:
        if (this.enableLiveFileProviderFix == r101.enableLiveFileProviderFix) goto L57;
        return false;
    L57:
        if (this.enableDownloadFileJsbOpt == r101.enableDownloadFileJsbOpt) goto L60;
        return false;
    L60:
        if (this.enableAutoExposureManager == r101.enableAutoExposureManager) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.autoExposureWidgetIdList, r101.autoExposureWidgetIdList) == true) goto L66;
        return false;
    L66:
        if (this.enableOrderMessageNotificationSettings == r101.enableOrderMessageNotificationSettings) goto L69;
        return false;
    L69:
        if (this.enableFindSimilar == r101.enableFindSimilar) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.findSimilarActionBarInstructionTypeList, r101.findSimilarActionBarInstructionTypeList) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.findSimilarLlmIntentionDetailList, r101.findSimilarLlmIntentionDetailList) == true) goto L77;
        return false;
    L77:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.initLiveWait == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.pluginLoadInStrategy) * 31;
        if (this.enablePluginLoadInLoading == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.enableMiraPlugin == false) goto L13;
        int r105 = 1231;
    L14:
        int r106 = (r104 + r105) * 31;
        if (this.initLiveStrategySdk == false) goto L17;
        int r107 = 1231;
    L18:
        int r108 = (r106 + r107) * 31;
        if (this.enableOpenSchemaOptimizeAndroid == false) goto L21;
        int r109 = 1231;
    L22:
        int r110 = (r108 + r109) * 31;
        if (this.initLiveLiveIOSdk == false) goto L25;
        int r111 = 1231;
    L26:
        int r112 = (r110 + r111) * 31;
        if (this.enableLiveSmartRouterOptimize == false) goto L29;
        int r113 = 1231;
    L30:
        int r114 = (r112 + r113) * 31;
        if (this.enableLiveSaaSDeepLinkConfig == false) goto L33;
        int r115 = 1231;
    L34:
        int r116 = (r114 + r115) * 31;
        if (this.enableSearchResultRefresh == false) goto L37;
        int r117 = 1231;
    L38:
        int r118 = (r116 + r117) * 31;
        if (this.enableOpenH5AndAuth == false) goto L41;
        int r119 = 1231;
    L42:
        int r120 = (r118 + r119) * 31;
        if (this.enableAuthWithCoupon == false) goto L45;
        int r121 = 1231;
    L46:
        int r122 = (r120 + r121) * 31;
        if (this.enableChatWithDeliveryAddress == false) goto L49;
        int r123 = 1231;
    L50:
        int r124 = (r122 + r123) * 31;
        if (this.enableLivePerformanceMonitor == false) goto L53;
        int r125 = 1231;
    L54:
        int r126 = (r124 + r125) * 31;
        if (this.enableBtmSwitchKeva == false) goto L57;
        int r127 = 1231;
    L58:
        int r128 = (r126 + r127) * 31;
        if (this.enableLiveFileProviderFix == false) goto L61;
        int r129 = 1231;
    L62:
        int r130 = (r128 + r129) * 31;
        if (this.enableDownloadFileJsbOpt == false) goto L65;
        int r131 = 1231;
    L66:
        int r132 = (r130 + r131) * 31;
        if (this.enableAutoExposureManager == false) goto L69;
        int r133 = 1231;
    L70:
        int r134 = (r132 + r133) * 31;
        List<String> r135 = this.autoExposureWidgetIdList;
        int r136 = 0;
        if (r135 != null) goto L73;
        int r137 = 0;
    L74:
        int r138 = (r134 + r137) * 31;
        if (this.enableOrderMessageNotificationSettings == false) goto L77;
        int r139 = 1231;
    L78:
        int r140 = (r138 + r139) * 31;
        if (this.enableFindSimilar == true) goto L82;
        r100 = 1237;
    L82:
        int r141 = (r140 + r100) * 31;
        List<String> r142 = this.findSimilarActionBarInstructionTypeList;
        if (r142 != null) goto L85;
        int r143 = 0;
    L86:
        int r144 = (r141 + r143) * 31;
        List<String> r145 = this.findSimilarLlmIntentionDetailList;
        if (r145 == null) goto L91;
        r136 = r145.hashCode();
    L91:
        return r144 + r136;
    L85:
        r143 = r142.hashCode();
        goto L86
    L77:
        r139 = 1237;
        goto L78
    L73:
        r137 = r135.hashCode();
        goto L74
    L69:
        r133 = 1237;
        goto L70
    L65:
        r131 = 1237;
        goto L66
    L61:
        r129 = 1237;
        goto L62
    L57:
        r127 = 1237;
        goto L58
    L53:
        r125 = 1237;
        goto L54
    L49:
        r123 = 1237;
        goto L50
    L45:
        r121 = 1237;
        goto L46
    L41:
        r119 = 1237;
        goto L42
    L37:
        r117 = 1237;
        goto L38
    L33:
        r115 = 1237;
        goto L34
    L29:
        r113 = 1237;
        goto L30
    L25:
        r111 = 1237;
        goto L26
    L21:
        r109 = 1237;
        goto L22
    L17:
        r107 = 1237;
        goto L18
    L13:
        r105 = 1237;
        goto L14
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "ECommerceSettingsConfig(initLiveWait=" + this.initLiveWait + ", pluginLoadInStrategy=" + this.pluginLoadInStrategy + ", enablePluginLoadInLoading=" + this.enablePluginLoadInLoading + ", enableMiraPlugin=" + this.enableMiraPlugin + ", initLiveStrategySdk=" + this.initLiveStrategySdk + ", enableOpenSchemaOptimizeAndroid=" + this.enableOpenSchemaOptimizeAndroid + ", initLiveLiveIOSdk=" + this.initLiveLiveIOSdk + ", enableLiveSmartRouterOptimize=" + this.enableLiveSmartRouterOptimize + ", enableLiveSaaSDeepLinkConfig=" + this.enableLiveSaaSDeepLinkConfig + ", enableSearchResultRefresh=" + this.enableSearchResultRefresh + ", enableOpenH5AndAuth=" + this.enableOpenH5AndAuth + ", enableAuthWithCoupon=" + this.enableAuthWithCoupon + ", enableChatWithDeliveryAddress=" + this.enableChatWithDeliveryAddress + ", enableLivePerformanceMonitor=" + this.enableLivePerformanceMonitor + ", enableBtmSwitchKeva=" + this.enableBtmSwitchKeva + ", enableLiveFileProviderFix=" + this.enableLiveFileProviderFix + ", enableDownloadFileJsbOpt=" + this.enableDownloadFileJsbOpt + ", enableAutoExposureManager=" + this.enableAutoExposureManager + ", autoExposureWidgetIdList=" + this.autoExposureWidgetIdList + ", enableOrderMessageNotificationSettings=" + this.enableOrderMessageNotificationSettings + ", enableFindSimilar=" + this.enableFindSimilar + ", findSimilarActionBarInstructionTypeList=" + this.findSimilarActionBarInstructionTypeList + ", findSimilarLlmIntentionDetailList=" + this.findSimilarLlmIntentionDetailList + ')';
    }

    public final List<String> getAutoExposureWidgetIdList() {
        return this.autoExposureWidgetIdList;
    }

    public final boolean getEnableAuthWithCoupon() {
        return this.enableAuthWithCoupon;
    }

    public final boolean getEnableAutoExposureManager() {
        return this.enableAutoExposureManager;
    }

    public final boolean getEnableBtmSwitchKeva() {
        return this.enableBtmSwitchKeva;
    }

    public final boolean getEnableChatWithDeliveryAddress() {
        return this.enableChatWithDeliveryAddress;
    }

    public final boolean getEnableDownloadFileJsbOpt() {
        return this.enableDownloadFileJsbOpt;
    }

    public final boolean getEnableFindSimilar() {
        return this.enableFindSimilar;
    }

    public final boolean getEnableLiveFileProviderFix() {
        return this.enableLiveFileProviderFix;
    }

    public final boolean getEnableLivePerformanceMonitor() {
        return this.enableLivePerformanceMonitor;
    }

    public final boolean getEnableLiveSaaSDeepLinkConfig() {
        return this.enableLiveSaaSDeepLinkConfig;
    }

    public final boolean getEnableLiveSmartRouterOptimize() {
        return this.enableLiveSmartRouterOptimize;
    }

    public final boolean getEnableMiraPlugin() {
        return this.enableMiraPlugin;
    }

    public final boolean getEnableOpenH5AndAuth() {
        return this.enableOpenH5AndAuth;
    }

    public final boolean getEnableOpenSchemaOptimizeAndroid() {
        return this.enableOpenSchemaOptimizeAndroid;
    }

    public final boolean getEnableOrderMessageNotificationSettings() {
        return this.enableOrderMessageNotificationSettings;
    }

    public final boolean getEnablePluginLoadInLoading() {
        return this.enablePluginLoadInLoading;
    }

    public final boolean getEnableSearchResultRefresh() {
        return this.enableSearchResultRefresh;
    }

    public final List<String> getFindSimilarActionBarInstructionTypeList() {
        return this.findSimilarActionBarInstructionTypeList;
    }

    public final List<String> getFindSimilarLlmIntentionDetailList() {
        return this.findSimilarLlmIntentionDetailList;
    }

    public final boolean getInitLiveLiveIOSdk() {
        return this.initLiveLiveIOSdk;
    }

    public final boolean getInitLiveStrategySdk() {
        return this.initLiveStrategySdk;
    }

    public final boolean getInitLiveWait() {
        return this.initLiveWait;
    }

    public final int getPluginLoadInStrategy() {
        return this.pluginLoadInStrategy;
    }

    public ECommerceSettingsConfig(boolean r100, int r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r106, boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, boolean r116, boolean r117, boolean r118, boolean r119, boolean r210, List<String> r211, boolean r212, boolean r213, List<String> r214, List<String> r215) {
        this.initLiveWait = r100;
        this.pluginLoadInStrategy = r101;
        this.enablePluginLoadInLoading = r102;
        this.enableMiraPlugin = r103;
        this.initLiveStrategySdk = r104;
        this.enableOpenSchemaOptimizeAndroid = r105;
        this.initLiveLiveIOSdk = r106;
        this.enableLiveSmartRouterOptimize = r110;
        this.enableLiveSaaSDeepLinkConfig = r111;
        this.enableSearchResultRefresh = r112;
        this.enableOpenH5AndAuth = r113;
        this.enableAuthWithCoupon = r114;
        this.enableChatWithDeliveryAddress = r115;
        this.enableLivePerformanceMonitor = r116;
        this.enableBtmSwitchKeva = r117;
        this.enableLiveFileProviderFix = r118;
        this.enableDownloadFileJsbOpt = r119;
        this.enableAutoExposureManager = r210;
        this.autoExposureWidgetIdList = r211;
        this.enableOrderMessageNotificationSettings = r212;
        this.enableFindSimilar = r213;
        this.findSimilarActionBarInstructionTypeList = r214;
        this.findSimilarLlmIntentionDetailList = r215;
    }

    public /* synthetic */ ECommerceSettingsConfig(boolean r210, int r211, boolean r212, boolean r213, boolean r214, boolean r310, boolean r311, boolean r312, boolean r313, boolean r314, boolean r315, boolean r316, boolean r317, boolean r318, boolean r319, boolean r410, boolean r411, boolean r412, List r413, boolean r414, boolean r415, List r416, List r417, int r418, DefaultConstructorMarker r419) {
        if ((r418 & 1) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r418 & 2) == 0) goto L9;
        int r101 = 0;
    L11:
        if ((r418 & 4) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r418 & 8) == 0) goto L17;
        boolean r103 = false;
    L19:
        if ((r418 & 16) == 0) goto L21;
        boolean r104 = false;
    L23:
        if ((r418 & 32) == 0) goto L25;
        boolean r105 = true;
    L27:
        if ((r418 & 64) == 0) goto L29;
        boolean r106 = false;
    L31:
        if ((r418 & 128) == 0) goto L33;
        boolean r110 = true;
    L35:
        if ((r418 & 256) == 0) goto L37;
        boolean r111 = true;
    L39:
        if ((r418 & 512) == 0) goto L41;
        boolean r112 = true;
    L43:
        if ((r418 & 1024) == 0) goto L45;
        boolean r113 = false;
    L47:
        if ((r418 & 2048) == 0) goto L49;
        boolean r114 = false;
    L51:
        if ((r418 & 4096) == 0) goto L53;
        boolean r115 = true;
    L55:
        if ((r418 & 8192) == 0) goto L57;
        boolean r107 = false;
    L59:
        if ((r418 & 16384) == 0) goto L61;
        boolean r108 = false;
    L63:
        if ((r418 & 32768) == 0) goto L65;
        boolean r116 = true;
    L67:
        if ((r418 & 65536) == 0) goto L69;
        boolean r117 = true;
    L71:
        if ((r418 & 131072) == 0) goto L73;
        boolean r118 = false;
    L75:
        if ((r418 & 262144) == 0) goto L77;
        List r119 = CollectionsKt.emptyList();
    L79:
        if ((r418 & 524288) == 0) goto L81;
        boolean r215 = false;
    L83:
        if ((r418 & 1048576) == 0) goto L85;
        boolean r216 = false;
    L87:
        if ((r418 & 2097152) == 0) goto L89;
        List r217 = CollectionsKt.emptyList();
    L91:
        if ((r418 & 4194304) == 0) goto L93;
        List r109 = CollectionsKt.emptyList();
    L94:
        this(r100, r101, r102, r103, r104, r105, r106, r110, r111, r112, r113, r114, r115, r107, r108, r116, r117, r118, r119, r215, r216, r217, r109);
        return;
    L93:
        r109 = r417;
        goto L94
    L89:
        r217 = r416;
        goto L91
    L85:
        r216 = r415;
        goto L87
    L81:
        r215 = r414;
        goto L83
    L77:
        r119 = r413;
        goto L79
    L73:
        r118 = r412;
        goto L75
    L69:
        r117 = r411;
        goto L71
    L65:
        r116 = r410;
        goto L67
    L61:
        r108 = r319;
        goto L63
    L57:
        r107 = r318;
        goto L59
    L53:
        r115 = r317;
        goto L55
    L49:
        r114 = r316;
        goto L51
    L45:
        r113 = r315;
        goto L47
    L41:
        r112 = r314;
        goto L43
    L37:
        r111 = r313;
        goto L39
    L33:
        r110 = r312;
        goto L35
    L29:
        r106 = r311;
        goto L31
    L25:
        r105 = r310;
        goto L27
    L21:
        r104 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
