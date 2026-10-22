package com.ss.android.ugc.aweme.poi.settings;

import com.bytedance.ies.modulize.rule.AllowImpl;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.poi.bean.AutoScrollConfig;
import com.ss.android.ugc.aweme.poi.bean.BackToPoiParam;
import com.ss.android.ugc.aweme.poi.bean.PoiCdnFontConfig;
import com.ss.android.ugc.aweme.poi.bean.PoiParamsVerify;
import com.ss.android.ugc.aweme.poi.bean.PoiUploadImgConfig;
import com.ss.android.ugc.aweme.poi.mob.PoiDynamicParamsConfig;
import com.ss.android.ugc.aweme.poi.perf.PoiLynxPreloadRule;
import com.ss.android.ugc.aweme.poi.perf.PoiRenderTaskConfig;
import com.ss.android.ugc.aweme.poi.rate.PoiPopupConfig;
import com.ss.android.ugc.aweme.poi.share.LocalLifeShareReflow;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public class PoiSetting {

    @SerializedName("auto_scroll_config")
    private AutoScrollConfig autoScrollConfig;

    @SerializedName("back_to_poi_params")
    private List<BackToPoiParam> backToPoiParams;

    @SerializedName("back_to_poi_switch")
    private Boolean backToPoiSwitch;

    @SerializedName("cancel_poi_detail_feed_update_aweme")
    private Boolean cancelPoiDetailFeedUpdateAweme;

    @SerializedName("collect_hint_action_interval")
    private Integer collectHintActionInterval;

    @SerializedName("collect_hint_display_interval")
    private Integer collectHintDisplayInterval;

    @SerializedName("collect_request_count")
    private Integer collectRequestCount;

    @SerializedName("collect_video_cover_play_interval")
    private Integer collectVideoCoverPlayInterval;

    @SerializedName("poi_dynamic_params_config")
    private PoiDynamicParamsConfig dynamicParamsConfig;

    @SerializedName("enable_flip_phone_adapt")
    private Boolean enableFlipPhoneAdapt;

    @SerializedName("replace_ad_mob_group_id")
    private boolean enableReplaceAdMobGroupId;

    @SerializedName("allow_exif_permission_button_name")
    private String exifPermissionButtonName;

    @SerializedName("allow_exif_permission_description")
    private String exifPermissionDesc;

    @SerializedName("fix_poi_half_background")
    private Boolean fixPoiHalfBackground;

    @SerializedName("head_lynx_cache_size")
    private int headLynxCacheSize;

    @SerializedName("in_activity_area")
    private Boolean inActivityArea;

    @SerializedName("is_mute_ugc_video_displayed_in_poi")
    private Boolean isUgcVideoMuted;

    @SerializedName("life_service_assistant_url")
    private String lifeServiceAssistantUrl;

    @SerializedName("life_service_rate_list_lynx_url")
    private String lifeServiceRateListLynxUrl;

    @SerializedName("life_service_rate_video_tab_list_lynx_url")
    private String lifeServiceRateVideoTabListLynxUrl;

    @SerializedName("life_share_aes_sec_iv")
    private String lifeShareSecIv;

    @SerializedName("life_share_aes_sec_token")
    private String lifeShareSecToken;

    @SerializedName("local_life_share_reflow")
    private LocalLifeShareReflow localLifeShareReflow;

    @SerializedName("location_feedback_url")
    private String locationFeedbackUrl;

    @SerializedName("lynx_optimizations")
    private int lynxOptimizations;

    @SerializedName("max_pic_size")
    private Integer maxPicSize;

    @SerializedName("merchant_description")
    private String merchantDescription;

    @SerializedName("merchant_management_url")
    private String merchantManagementUrl;

    @SerializedName("merchant_settle_url")
    private String merchantSettleUrl;

    @SerializedName("nearby_location_prompt_interval")
    private Integer nearbyLocationPromptInterval;

    @SerializedName("need_upgrade_location_task")
    private Boolean needUpgradeLocationTask;

    @SerializedName("poi_api_host")
    private String poiApiHost;

    @SerializedName("poi_cache_lynx_bundle")
    private List<String> poiCacheLynxBundle;

    @SerializedName("poi_card_fmp_sampling_rate")
    private float poiCardFmpSamplingRate;

    @SerializedName("poi_cdn_font_list")
    private List<PoiCdnFontConfig> poiCdnFontList;

    @SerializedName("poi_chunk_origin_load_fix")
    private Boolean poiChunkOriginLoadFix;

    @SerializedName("poi_collect_guide_view")
    private String poiCollectGuideViewLink;

    @SerializedName("poi_debounce_time")
    private Long poiDebounceTime;

    @SerializedName("poi_font_list")
    private List<String> poiFontList;

    @SerializedName("poi_head_custom_card_interval")
    private Long poiHeadCustomCardInterval;

    @SerializedName("poi_hot_rank")
    private String poiHotRank;

    @SerializedName("poi_light_full_page_groupon_enter_from_list")
    private List<String> poiLightFullPageGrouponEnterFromList;

    @SerializedName("poi_location_cache_duration")
    private Integer poiLocationCacheDuration;

    @SerializedName("poi_lynx_new_preload_rule")
    private Map<String, List<PoiLynxPreloadRule>> poiLynxPreloadRule;

    @SerializedName("poi_map_move_camera_switch")
    private Boolean poiMapMoveCameraSwitch;

    @SerializedName("poi_thirdparty_map_order")
    private List<String> poiMapOrder;

    @SerializedName("poi_open_regeo")
    private Integer poiOpenRegeo;

    @SerializedName("poi_params_verify")
    private PoiParamsVerify poiParamsVerify;

    @SerializedName("poi_detail_popup_config")
    private List<PoiPopupConfig> poiPopupConfigs;

    @SerializedName("poi_qa_list_url")
    private String poiQaListUrl;

    @SerializedName("poi_quick_bg_scroll_fix")
    private Boolean poiQuickBgScrollFix;

    @SerializedName("poi_refresh_after_location_allowed")
    private boolean poiRefreshAfterLocationAllowed;

    @SerializedName("poi_region_list")
    private String poiRegionList;

    @SerializedName("poi_0vv_settings")
    private PoiRenderTaskConfig poiRenderTaskJsonConfig;

    @SerializedName("poi_screenshot_memory_check")
    private int poiScreenshotMemoryCheck;

    @SerializedName("poi_scroll_to_retry_times")
    private int poiScrollToRetryTimes;

    @SerializedName("poi_secret_key")
    private String poiSecretKey;

    @SerializedName("poi_share_schema_encode_life_share_ext")
    private boolean poiShareSchemaEncodeLifeShareExt;

    @SerializedName("poi_share_schema_encode_request_params")
    private boolean poiShareSchemaEncodeRequestParams;

    @SerializedName("poi_shelf_modal_view")
    private String poiShelfModalViewLink;

    @SerializedName("poi_prefetch_path")
    private String poiSmartPrefetchPath;

    @SerializedName("poi_stop_real_request_when_disaster")
    private boolean poiStopRealRequestWhenDisaster;

    @SerializedName("poi_to_shelf_delay")
    private Long poiToShelfDelay;

    @SerializedName("poi_upload_img_config")
    private PoiUploadImgConfig poiUploadImgConfig;

    @SerializedName("poi_warmup_throttle_interval")
    private long poiWarmUpThrottleInterval;

    @SerializedName("poi_prefetch_lynx_schemas")
    private List<String> prefetchLynxSchemas;

    @SerializedName("prefetch_request_sampling_rate")
    private float prefetchRequestSamplingRate;

    @SerializedName("request_params_in_router")
    private List<String> requestParams;

    @SerializedName("allow_scan_permission_button_name")
    private String scanPermissionButtonName;

    @SerializedName("allow_scan_permission_description")
    private String scanPermissionDesc;

    @SerializedName("smart_prefetch_cache_key_white_list")
    private List<String> smartPrefetchCacheKeyWhiteList;

    @SerializedName("speed_optimizations")
    private int speedOptimizations;

    @SerializedName("trade_dou_discount_inner_preload_count")
    private int tradeDouDiscountInnerPreloadCount;

    @SerializedName("poi_upload_img_protocol_url")
    private String uploadImgProtocolUrl;

    @SerializedName("use_life_service_gecko_app")
    private int useLifeServiceGeckoApp;

    public final String t() {
        String r100 = this.poiSmartPrefetchPath;
        if (r100 != null) goto L6;
        return "/aweme/v1/dito/prefetch/";
    L6:
        return r100;
    }

    public PoiSetting() {
        Boolean r100 = Boolean.FALSE;
        this.inActivityArea = r100;
        this.needUpgradeLocationTask = r100;
        Boolean r101 = Boolean.TRUE;
        this.poiMapMoveCameraSwitch = r101;
        this.nearbyLocationPromptInterval = 1;
        this.collectHintActionInterval = 5;
        this.collectHintDisplayInterval = 5;
        this.poiOpenRegeo = 1;
        this.poiLocationCacheDuration = 10;
        this.tradeDouDiscountInnerPreloadCount = 2;
        this.collectVideoCoverPlayInterval = 3;
        this.headLynxCacheSize = 20;
        this.isUgcVideoMuted = r101;
        this.lynxOptimizations = 255;
        this.speedOptimizations = 0;
        this.poiScreenshotMemoryCheck = 0;
        this.prefetchRequestSamplingRate = 0.0f;
        this.poiCardFmpSamplingRate = 0.0f;
        this.poiLightFullPageGrouponEnterFromList = new ArrayList(Arrays.asList(new String[]{"homepage_life"}));
        this.enableReplaceAdMobGroupId = true;
        this.poiDebounceTime = 2000L;
        this.poiHeadCustomCardInterval = 300L;
        this.poiToShelfDelay = 250L;
        this.poiChunkOriginLoadFix = r101;
        this.poiQuickBgScrollFix = r101;
        this.fixPoiHalfBackground = r101;
        this.enableFlipPhoneAdapt = r101;
        this.useLifeServiceGeckoApp = 1;
        this.poiRefreshAfterLocationAllowed = true;
        this.poiShareSchemaEncodeLifeShareExt = true;
        this.poiShareSchemaEncodeRequestParams = true;
        this.poiStopRealRequestWhenDisaster = true;
        this.poiWarmUpThrottleInterval = 60000;
        this.poiScrollToRetryTimes = 0;
    }

    @AllowImpl
    public final AutoScrollConfig a() {
        return this.autoScrollConfig;
    }

    @AllowImpl
    public final List<BackToPoiParam> b() {
        return this.backToPoiParams;
    }

    @AllowImpl
    public final Boolean c() {
        return this.backToPoiSwitch;
    }

    @AllowImpl
    public final List<PoiCdnFontConfig> d() {
        return this.poiCdnFontList;
    }

    @AllowImpl
    public final PoiDynamicParamsConfig e() {
        return this.dynamicParamsConfig;
    }

    @AllowImpl
    public final Boolean f() {
        return this.enableFlipPhoneAdapt;
    }

    @AllowImpl
    public final Boolean g() {
        return this.fixPoiHalfBackground;
    }

    @AllowImpl
    public final String h() {
        return this.lifeServiceRateListLynxUrl;
    }

    @AllowImpl
    public final int i() {
        return this.lynxOptimizations;
    }

    @AllowImpl
    public final float j() {
        return this.poiCardFmpSamplingRate;
    }

    @AllowImpl
    public final List<String> k() {
        return this.poiFontList;
    }

    @AllowImpl
    public final Long l() {
        return this.poiHeadCustomCardInterval;
    }

    @AllowImpl
    public final List<String> m() {
        return this.poiLightFullPageGrouponEnterFromList;
    }

    @AllowImpl
    public final List<String> n() {
        return this.poiMapOrder;
    }

    @AllowImpl
    public final List<PoiPopupConfig> o() {
        return this.poiPopupConfigs;
    }

    @AllowImpl
    public final Boolean p() {
        return this.poiQuickBgScrollFix;
    }

    @AllowImpl
    public final boolean q() {
        return this.poiRefreshAfterLocationAllowed;
    }

    @AllowImpl
    public final PoiRenderTaskConfig r() {
        return this.poiRenderTaskJsonConfig;
    }

    @AllowImpl
    public final int s() {
        return this.poiScrollToRetryTimes;
    }

    @AllowImpl
    public final boolean u() {
        return this.poiStopRealRequestWhenDisaster;
    }

    @AllowImpl
    public final List<String> v() {
        return this.prefetchLynxSchemas;
    }

    @AllowImpl
    public final List<String> w() {
        return this.requestParams;
    }

    @AllowImpl
    public final List<String> x() {
        return this.smartPrefetchCacheKeyWhiteList;
    }
}
