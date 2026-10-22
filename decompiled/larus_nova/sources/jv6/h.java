package jv6;

import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R*\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR*\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010\u0019R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\u001c\u0010%\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006R\u001c\u0010'\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006R\u001a\u0010*\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\u0014\u001a\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010\u0014\u001a\u0004\b.\u0010,R(\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010\u0017\u001a\u0004\b0\u0010\u0019R\u001a\u00101\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010\u0014\u001a\u0004\b2\u0010,R\u001a\u00103\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010\u0014\u001a\u0004\b4\u0010,R\u001c\u00105\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010\u0004\u001a\u0004\b6\u0010\u0006R\u001c\u00108\u001a\u0004\u0018\u0001078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b<\u0010\u0014\u001a\u0004\b=\u0010,R*\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010)\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b>\u0010\u0017\u001a\u0004\b?\u0010\u0019R\u001a\u0010@\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010\u0014\u001a\u0004\bA\u0010,R(\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\bB\u0010\u0017\u001a\u0004\bC\u0010\u0019R\u001c\u0010E\u001a\u0004\u0018\u00010D8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010HR\u001a\u0010I\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bI\u0010\u0014\u001a\u0004\bJ\u0010,R\u001a\u0010K\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bK\u0010\u0014\u001a\u0004\bL\u0010,R\u001a\u0010M\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bM\u0010\u0014\u001a\u0004\bN\u0010,R\u001a\u0010O\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bO\u0010\u0014\u001a\u0004\bP\u0010,R\u001a\u0010Q\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bQ\u0010\u0014\u001a\u0004\bR\u0010,R\u001a\u0010S\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bS\u0010\u0014\u001a\u0004\bT\u0010,R\u001a\u0010U\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bU\u0010\u0014\u001a\u0004\bV\u0010,R\u001c\u0010W\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bW\u0010\u0004\u001a\u0004\bX\u0010\u0006R\u001c\u0010Y\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bY\u0010\u0004\u001a\u0004\bZ\u0010\u0006R\u001c\u0010\\\u001a\u0004\u0018\u00010[8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R\u001a\u0010`\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b`\u0010\u0014\u001a\u0004\ba\u0010,R\u001a\u0010b\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bb\u0010\u0014\u001a\u0004\bc\u0010,R\u001a\u0010d\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bd\u0010\u0014\u001a\u0004\be\u0010,R\u001a\u0010f\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bf\u0010\u0014\u001a\u0004\bg\u0010,R\u001c\u0010h\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bh\u0010\u0004\u001a\u0004\bi\u0010\u0006R\u001c\u0010k\u001a\u0004\u0018\u00010j8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bk\u0010l\u001a\u0004\bm\u0010nR\u001a\u0010o\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bo\u0010\u0014\u001a\u0004\bp\u0010,R\u001a\u0010q\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bq\u0010\u0014\u001a\u0004\br\u0010,R\u001c\u0010s\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bs\u0010\u0004\u001a\u0004\bt\u0010\u0006R\u001c\u0010u\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\bu\u0010\u0004\u001a\u0004\bv\u0010\u0006R\u001a\u0010w\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\bw\u0010\u0014\u001a\u0004\bx\u0010,R\u001a\u0010y\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\by\u0010\u0014\u001a\u0004\bz\u0010,R\u001a\u0010{\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b{\u0010\u0014\u001a\u0004\b|\u0010,R\u001a\u0010}\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b}\u0010\u0014\u001a\u0004\b~\u0010,R\u001e\u0010\u0080\u0001\u001a\u00020\u007f8\u0006X\u0087\u0004¢\u0006\u000f\n\u0005\b\u0080\u0001\u0010p\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001R(\u0010\u0084\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0083\u00018\u0006X\u0087\u0004¢\u0006\u0010\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\u001d\u0010\u0088\u0001\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0088\u0001\u0010\u0014\u001a\u0005\b\u0089\u0001\u0010,R\u001d\u0010\u008a\u0001\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u008a\u0001\u0010\u0014\u001a\u0005\b\u008b\u0001\u0010,R\u001d\u0010\u008c\u0001\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u008c\u0001\u0010\u0014\u001a\u0005\b\u008d\u0001\u0010,R\u001d\u0010\u008e\u0001\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u008e\u0001\u0010\u0014\u001a\u0005\b\u008f\u0001\u0010,R\u001d\u0010\u0090\u0001\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0090\u0001\u0010\u0014\u001a\u0005\b\u0091\u0001\u0010,R\u001d\u0010\u0092\u0001\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0092\u0001\u0010\u0014\u001a\u0005\b\u0093\u0001\u0010,R\u001d\u0010\u0094\u0001\u001a\u00020)8\u0006X\u0087\u0004¢\u0006\u000e\n\u0005\b\u0094\u0001\u0010\u0014\u001a\u0005\b\u0095\u0001\u0010,¨\u0006\u0096\u0001"}, d2 = {"Ljv6/h;", "", "", "lynxShelfProcessorSchema", "Ljava/lang/String;", FaceService.neutralLabel, "()Ljava/lang/String;", "lynxTopbarSchema", "K", "lynxRankWidgetSchema", "getLynxRankWidgetSchema", "searchBarSchema", "N", "searchHistorySchema", "P", "searchEmptySchema", "O", "lynxBottomBarSchema", "B", "lynxTopAtmosphereSchema", "I", "", "lynxAirSettings", "Ljava/util/Map;", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "()Ljava/util/Map;", "Ljv6/d;", "grouponIconStyle", "Ljv6/d;", "r", "()Ljv6/d;", "performanceSettings", "getPerformanceSettings", "lynxCommonCellSchema", "C", "dslLynxModuleCommonSchema", ce.f26391f, "expoundCardDslModuleCommonSchema", ce.f26396k, "lynxShelfPagingProcessorSchema", "G", "", "forbidLynxTopbar", "o", "()I", "forbidBtm", "l", "shelfHeightTracker", ExifInterface.LATITUDE_SOUTH, "shelfDSLFmpOpt", "R", "forbidCardJumpUrlDynamicOpt", "m", "lynxShelfCouponToastSchema", FaceService.girlLabel, "Ljv6/r;", "shelfUiSettings", "Ljv6/r;", "V", "()Ljv6/r;", "forbidExpoundCardLynxTracker", OfficeSDKRequestTag.KEY_NEW_USER, "expoundCardBizAttrAnimation", "getExpoundCardBizAttrAnimation", "useHybridReport", "Y", "lotteryJumpUrl", "getLotteryJumpUrl", "Ljv6/s;", "stickerContainerSettings", "Ljv6/s;", "X", "()Ljv6/s;", "disableMessageCenter", "f", "lynxAsyncOpt", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "disableCouponDataCenterOpt", "getDisableCouponDataCenterOpt", "dslBitmapCache", "getDslBitmapCache", "disableIconAlienationAnimation", "c", "disableIconAnimationOpt", "d", "disableJsonParseMonitor", "e", "lynxSharePanelCouponSchema", "getLynxSharePanelCouponSchema", "lynxShareCollectCouponSchema", "D", "Ljv6/q;", "titleChineseSymbols", "Ljv6/q;", "getTitleChineseSymbols", "()Ljv6/q;", "fuseShelfApiRetryTimesLimit", "q", "fuseShelfApiRetryFrameLimit", "p", "loadSuccessUInMultiThread", "y", "isIconUseCollectCouponV2", "Z", "lynxShareCollectCouponSchemaV2", ExifInterface.LONGITUDE_EAST, "Ljv6/a;", "atmosphereResourceCacheConfig", "Ljv6/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljv6/a;", "lynxTopbarFmpMeasureEnable", "J", "newEnterParamsAutoOpenCount", "L", "shelfPrefetchPath", "U", "shelfPagePrefetchPath", ExifInterface.GPS_DIRECTION_TRUE, "enableGoodsDetailFullScreen", RXScreenCaptureService.KEY_INDEX, "shelfCardShowTagsInfoEnable", "Q", "schemaReportEnable", "M", "dslResponseInitOpt", "h", "", "cancelExplainRefreshInterval", "b", "()J", "", "liveRecommendInfoList", "Ljava/util/List;", "x", "()Ljava/util/List;", "enableShelfErrorViewFix", ce.f26395j, "lifeLifeScrollMinOffset", "s", "lifeLifeScrollMinTime", "t", "lifeLifeSlideEventMaxCount", "u", "liveLifeOptAutoOpenAndAnchor", BaseSwitches.V, "liveLifeOptCouponShelfRefresh", "w", "shelfUseWebUrl", ExifInterface.LONGITUDE_WEST, "locallife-live-api_release"}, k = 1, mv = {1, 4, 3})
public final class h {

    @SerializedName("local_life_atmosphere_resource_cache_config")
    private final a atmosphereResourceCacheConfig;

    @SerializedName("cancel_explain_refresh_interval")
    private final long cancelExplainRefreshInterval;

    @SerializedName("disable_coupon_data_center_opt")
    private final int disableCouponDataCenterOpt;

    @SerializedName("disable_icon_alienation_animation")
    private final int disableIconAlienationAnimation;

    @SerializedName("disable_icon_animation_opt")
    private final int disableIconAnimationOpt;

    @SerializedName("disable_json_parse_monitor")
    private final int disableJsonParseMonitor;

    @SerializedName("disable_message_center")
    private final int disableMessageCenter;

    @SerializedName("dsl_bitmap_cache")
    private final int dslBitmapCache;

    @SerializedName("lynx_shelf_data_processor_schema")
    private final String dslLynxModuleCommonSchema;

    @SerializedName("dsl_response_init_opt")
    private final int dslResponseInitOpt;

    @SerializedName("enable_goods_detail_full_screen")
    private final int enableGoodsDetailFullScreen;

    @SerializedName("enable_shelf_error_view_fix")
    private final int enableShelfErrorViewFix;

    @SerializedName("expound_card_biz_attr_animation")
    private final Map<String, Integer> expoundCardBizAttrAnimation;

    @SerializedName("lynx_expound_card_data_processor_schema")
    private final String expoundCardDslModuleCommonSchema;

    @SerializedName("forbid_btm")
    private final int forbidBtm;

    @SerializedName("forbid_card_jump_url_dynamic_opt")
    private final int forbidCardJumpUrlDynamicOpt;

    @SerializedName("forbid_expound_card_lynx_tracker")
    private final int forbidExpoundCardLynxTracker;

    @SerializedName("forbid_lynx_topbar")
    private final int forbidLynxTopbar;

    @SerializedName("fuse_shelf_api_retry_frame_limit")
    private final int fuseShelfApiRetryFrameLimit;

    @SerializedName("fuse_shelf_api_retry_times_limit")
    private final int fuseShelfApiRetryTimesLimit;

    @SerializedName("groupon_icon_style")
    private final d grouponIconStyle;

    @SerializedName("is_icon_use_collect_coupon_v2")
    private final int isIconUseCollectCouponV2;

    @SerializedName("live_shelf_scroll_min_offset")
    private final int lifeLifeScrollMinOffset;

    @SerializedName("live_shelf_scroll_min_time")
    private final int lifeLifeScrollMinTime;

    @SerializedName("live_shelf_slide_event_max_count")
    private final int lifeLifeSlideEventMaxCount;

    @SerializedName("live_life_opt_auto_open_and_anchor")
    private final int liveLifeOptAutoOpenAndAnchor;

    @SerializedName("live_life_opt_coupon_shelf_refresh")
    private final int liveLifeOptCouponShelfRefresh;

    @SerializedName("live_recommend_info_list")
    private final List<String> liveRecommendInfoList;

    @SerializedName("load_success_in_multi_thread")
    private final int loadSuccessUInMultiThread;

    @SerializedName("lottery_jump_url")
    private final Map<String, Object> lotteryJumpUrl;

    @SerializedName("lynx_air_settings")
    private final Map<String, Object> lynxAirSettings;

    @SerializedName("lynx_async_opt")
    private final int lynxAsyncOpt;

    @SerializedName("lynx_bottom_cart_schema")
    private final String lynxBottomBarSchema;

    @SerializedName("lynx_common_cell_schema")
    private final String lynxCommonCellSchema;

    @SerializedName("life_live_rank_lynx_schema_android")
    private final String lynxRankWidgetSchema;

    @SerializedName("lynx_share_collect_coupon_schema")
    private final String lynxShareCollectCouponSchema;

    @SerializedName("lynx_share_collect_coupon_schema_v2")
    private final String lynxShareCollectCouponSchemaV2;

    @SerializedName("lynx_share_panel_coupon_schema")
    private final String lynxSharePanelCouponSchema;

    @SerializedName("lynx_shelf_coupon_toast_schema")
    private final String lynxShelfCouponToastSchema;

    @SerializedName("lynx_shelf_paging_processor_schema")
    private final String lynxShelfPagingProcessorSchema;

    @SerializedName("lynx_shelf_processor_schema")
    private final String lynxShelfProcessorSchema;

    @SerializedName("lynx_top_atmosphere_schema")
    private final String lynxTopAtmosphereSchema;

    @SerializedName("lynx_topbar_fmp_measure_enable")
    private final int lynxTopbarFmpMeasureEnable;

    @SerializedName("lynx_topbar_schema")
    private final String lynxTopbarSchema;

    @SerializedName("new_enter_params_auto_open_count")
    private final int newEnterParamsAutoOpenCount;

    @SerializedName("performance_settings")
    private final Map<String, Object> performanceSettings;

    @SerializedName("schema_report_enable")
    private final int schemaReportEnable;

    @SerializedName("search_bar_schema")
    private final String searchBarSchema;

    @SerializedName("search_empty_schema")
    private final String searchEmptySchema;

    @SerializedName("search_history_schema")
    private final String searchHistorySchema;

    @SerializedName("shelf_card_show_tags_info_enable")
    private final int shelfCardShowTagsInfoEnable;

    @SerializedName("live_life_shelf_dsl_fmp_opt")
    private final int shelfDSLFmpOpt;

    @SerializedName("local_life_lynx_height_tracker_settings")
    private final Map<String, Object> shelfHeightTracker;

    @SerializedName("live_shelf_page_preload_path")
    private final String shelfPagePrefetchPath;

    @SerializedName("live_shelf_preload_path")
    private final String shelfPrefetchPath;

    @SerializedName("shelf_ui_settings")
    private final r shelfUiSettings;

    @SerializedName("shelf_use_web_url")
    private final int shelfUseWebUrl;

    @SerializedName("sticker_container_content")
    private final s stickerContainerSettings;

    @SerializedName("title_chinese_symbols")
    private final q titleChineseSymbols;

    @SerializedName("use_hybrid_image_report")
    private final int useHybridReport;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L8;
        return false;
    L8:
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.lynxShelfProcessorSchema, r101.lynxShelfProcessorSchema) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lynxTopbarSchema, r101.lynxTopbarSchema) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.lynxRankWidgetSchema, r101.lynxRankWidgetSchema) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.searchBarSchema, r101.searchBarSchema) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.searchHistorySchema, r101.searchHistorySchema) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.searchEmptySchema, r101.searchEmptySchema) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.lynxBottomBarSchema, r101.lynxBottomBarSchema) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.lynxTopAtmosphereSchema, r101.lynxTopAtmosphereSchema) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.lynxAirSettings, r101.lynxAirSettings) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.grouponIconStyle, r101.grouponIconStyle) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.performanceSettings, r101.performanceSettings) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.lynxCommonCellSchema, r101.lynxCommonCellSchema) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.dslLynxModuleCommonSchema, r101.dslLynxModuleCommonSchema) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.expoundCardDslModuleCommonSchema, r101.expoundCardDslModuleCommonSchema) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.lynxShelfPagingProcessorSchema, r101.lynxShelfPagingProcessorSchema) == true) goto L54;
        return false;
    L54:
        if (this.forbidLynxTopbar == r101.forbidLynxTopbar) goto L57;
        return false;
    L57:
        if (this.forbidBtm == r101.forbidBtm) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.shelfHeightTracker, r101.shelfHeightTracker) == true) goto L63;
        return false;
    L63:
        if (this.shelfDSLFmpOpt == r101.shelfDSLFmpOpt) goto L66;
        return false;
    L66:
        if (this.forbidCardJumpUrlDynamicOpt == r101.forbidCardJumpUrlDynamicOpt) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.lynxShelfCouponToastSchema, r101.lynxShelfCouponToastSchema) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.shelfUiSettings, r101.shelfUiSettings) == true) goto L75;
        return false;
    L75:
        if (this.forbidExpoundCardLynxTracker == r101.forbidExpoundCardLynxTracker) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.expoundCardBizAttrAnimation, r101.expoundCardBizAttrAnimation) == true) goto L81;
        return false;
    L81:
        if (this.useHybridReport == r101.useHybridReport) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.lotteryJumpUrl, r101.lotteryJumpUrl) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.stickerContainerSettings, r101.stickerContainerSettings) == true) goto L90;
        return false;
    L90:
        if (this.disableMessageCenter == r101.disableMessageCenter) goto L93;
        return false;
    L93:
        if (this.lynxAsyncOpt == r101.lynxAsyncOpt) goto L96;
        return false;
    L96:
        if (this.disableCouponDataCenterOpt == r101.disableCouponDataCenterOpt) goto L99;
        return false;
    L99:
        if (this.dslBitmapCache == r101.dslBitmapCache) goto L102;
        return false;
    L102:
        if (this.disableIconAlienationAnimation == r101.disableIconAlienationAnimation) goto L105;
        return false;
    L105:
        if (this.disableIconAnimationOpt == r101.disableIconAnimationOpt) goto L108;
        return false;
    L108:
        if (this.disableJsonParseMonitor == r101.disableJsonParseMonitor) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.lynxSharePanelCouponSchema, r101.lynxSharePanelCouponSchema) == true) goto L114;
        return false;
    L114:
        if (Intrinsics.areEqual(this.lynxShareCollectCouponSchema, r101.lynxShareCollectCouponSchema) == true) goto L117;
        return false;
    L117:
        if (Intrinsics.areEqual(this.titleChineseSymbols, r101.titleChineseSymbols) == true) goto L120;
        return false;
    L120:
        if (this.fuseShelfApiRetryTimesLimit == r101.fuseShelfApiRetryTimesLimit) goto L123;
        return false;
    L123:
        if (this.fuseShelfApiRetryFrameLimit == r101.fuseShelfApiRetryFrameLimit) goto L126;
        return false;
    L126:
        if (this.loadSuccessUInMultiThread == r101.loadSuccessUInMultiThread) goto L129;
        return false;
    L129:
        if (this.isIconUseCollectCouponV2 == r101.isIconUseCollectCouponV2) goto L132;
        return false;
    L132:
        if (Intrinsics.areEqual(this.lynxShareCollectCouponSchemaV2, r101.lynxShareCollectCouponSchemaV2) == true) goto L135;
        return false;
    L135:
        if (Intrinsics.areEqual(this.atmosphereResourceCacheConfig, r101.atmosphereResourceCacheConfig) == true) goto L138;
        return false;
    L138:
        if (this.lynxTopbarFmpMeasureEnable == r101.lynxTopbarFmpMeasureEnable) goto L141;
        return false;
    L141:
        if (this.newEnterParamsAutoOpenCount == r101.newEnterParamsAutoOpenCount) goto L144;
        return false;
    L144:
        if (Intrinsics.areEqual(this.shelfPrefetchPath, r101.shelfPrefetchPath) == true) goto L147;
        return false;
    L147:
        if (Intrinsics.areEqual(this.shelfPagePrefetchPath, r101.shelfPagePrefetchPath) == true) goto L150;
        return false;
    L150:
        if (this.enableGoodsDetailFullScreen == r101.enableGoodsDetailFullScreen) goto L153;
        return false;
    L153:
        if (this.shelfCardShowTagsInfoEnable == r101.shelfCardShowTagsInfoEnable) goto L156;
        return false;
    L156:
        if (this.schemaReportEnable == r101.schemaReportEnable) goto L159;
        return false;
    L159:
        if (this.dslResponseInitOpt == r101.dslResponseInitOpt) goto L162;
        return false;
    L162:
        if (this.cancelExplainRefreshInterval == r101.cancelExplainRefreshInterval) goto L165;
        return false;
    L165:
        if (Intrinsics.areEqual(this.liveRecommendInfoList, r101.liveRecommendInfoList) == true) goto L168;
        return false;
    L168:
        if (this.enableShelfErrorViewFix == r101.enableShelfErrorViewFix) goto L171;
        return false;
    L171:
        if (this.lifeLifeScrollMinOffset == r101.lifeLifeScrollMinOffset) goto L174;
        return false;
    L174:
        if (this.lifeLifeScrollMinTime == r101.lifeLifeScrollMinTime) goto L177;
        return false;
    L177:
        if (this.lifeLifeSlideEventMaxCount == r101.lifeLifeSlideEventMaxCount) goto L180;
        return false;
    L180:
        if (this.liveLifeOptAutoOpenAndAnchor == r101.liveLifeOptAutoOpenAndAnchor) goto L183;
        return false;
    L183:
        if (this.liveLifeOptCouponShelfRefresh == r101.liveLifeOptCouponShelfRefresh) goto L186;
        return false;
    L186:
        if (this.shelfUseWebUrl == r101.shelfUseWebUrl) goto L188;
        return false;
    L188:
        return true;
    }

    public final int hashCode() {
        String r100 = this.lynxShelfProcessorSchema;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.lynxTopbarSchema;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.lynxRankWidgetSchema;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.searchBarSchema;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.searchHistorySchema;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.searchEmptySchema;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.lynxBottomBarSchema;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        String r122 = this.lynxTopAtmosphereSchema;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Map<String, Object> r125 = this.lynxAirSettings;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        d r128 = this.grouponIconStyle;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Map<String, Object> r131 = this.performanceSettings;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.lynxCommonCellSchema;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.dslLynxModuleCommonSchema;
        if (r137 != null) goto L53;
        int r138 = 0;
    L54:
        int r139 = (r136 + r138) * 31;
        String r140 = this.expoundCardDslModuleCommonSchema;
        if (r140 != null) goto L57;
        int r141 = 0;
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.lynxShelfPagingProcessorSchema;
        if (r143 != null) goto L61;
        int r144 = 0;
    L62:
        int r145 = (((((r142 + r144) * 31) + this.forbidLynxTopbar) * 31) + this.forbidBtm) * 31;
        Map<String, Object> r146 = this.shelfHeightTracker;
        if (r146 != null) goto L65;
        int r147 = 0;
    L66:
        int r148 = (((((r145 + r147) * 31) + this.shelfDSLFmpOpt) * 31) + this.forbidCardJumpUrlDynamicOpt) * 31;
        String r149 = this.lynxShelfCouponToastSchema;
        if (r149 != null) goto L69;
        int r150 = 0;
    L70:
        int r151 = (r148 + r150) * 31;
        r r152 = this.shelfUiSettings;
        if (r152 != null) goto L73;
        int r153 = 0;
    L74:
        int r154 = (((r151 + r153) * 31) + this.forbidExpoundCardLynxTracker) * 31;
        Map<String, Integer> r155 = this.expoundCardBizAttrAnimation;
        if (r155 != null) goto L77;
        int r156 = 0;
    L78:
        int r157 = (((r154 + r156) * 31) + this.useHybridReport) * 31;
        Map<String, Object> r158 = this.lotteryJumpUrl;
        if (r158 != null) goto L81;
        int r159 = 0;
    L82:
        int r160 = (r157 + r159) * 31;
        s r161 = this.stickerContainerSettings;
        if (r161 != null) goto L85;
        int r162 = 0;
    L86:
        int r163 = (((((((((((((((r160 + r162) * 31) + this.disableMessageCenter) * 31) + this.lynxAsyncOpt) * 31) + this.disableCouponDataCenterOpt) * 31) + this.dslBitmapCache) * 31) + this.disableIconAlienationAnimation) * 31) + this.disableIconAnimationOpt) * 31) + this.disableJsonParseMonitor) * 31;
        String r164 = this.lynxSharePanelCouponSchema;
        if (r164 != null) goto L89;
        int r165 = 0;
    L90:
        int r166 = (r163 + r165) * 31;
        String r167 = this.lynxShareCollectCouponSchema;
        if (r167 != null) goto L93;
        int r168 = 0;
    L94:
        int r169 = (r166 + r168) * 31;
        q r170 = this.titleChineseSymbols;
        if (r170 != null) goto L97;
        int r171 = 0;
    L98:
        int r172 = (((((((((r169 + r171) * 31) + this.fuseShelfApiRetryTimesLimit) * 31) + this.fuseShelfApiRetryFrameLimit) * 31) + this.loadSuccessUInMultiThread) * 31) + this.isIconUseCollectCouponV2) * 31;
        String r173 = this.lynxShareCollectCouponSchemaV2;
        if (r173 != null) goto L101;
        int r174 = 0;
    L102:
        int r175 = (r172 + r174) * 31;
        a r176 = this.atmosphereResourceCacheConfig;
        if (r176 != null) goto L105;
        int r177 = 0;
    L106:
        int r178 = (((((r175 + r177) * 31) + this.lynxTopbarFmpMeasureEnable) * 31) + this.newEnterParamsAutoOpenCount) * 31;
        String r179 = this.shelfPrefetchPath;
        if (r179 != null) goto L109;
        int r180 = 0;
    L110:
        int r181 = (r178 + r180) * 31;
        String r182 = this.shelfPagePrefetchPath;
        if (r182 != null) goto L113;
        int r183 = 0;
    L114:
        int r184 = (((((((((r181 + r183) * 31) + this.enableGoodsDetailFullScreen) * 31) + this.shelfCardShowTagsInfoEnable) * 31) + this.schemaReportEnable) * 31) + this.dslResponseInitOpt) * 31;
        long r185 = this.cancelExplainRefreshInterval;
        int r186 = (r184 + ((int) (r185 ^ (r185 >>> 32)))) * 31;
        List<String> r187 = this.liveRecommendInfoList;
        if (r187 == null) goto L119;
        r101 = r187.hashCode();
    L119:
        return ((((((((((((((r186 + r101) * 31) + this.enableShelfErrorViewFix) * 31) + this.lifeLifeScrollMinOffset) * 31) + this.lifeLifeScrollMinTime) * 31) + this.lifeLifeSlideEventMaxCount) * 31) + this.liveLifeOptAutoOpenAndAnchor) * 31) + this.liveLifeOptCouponShelfRefresh) * 31) + this.shelfUseWebUrl;
    L113:
        r183 = r182.hashCode();
        goto L114
    L109:
        r180 = r179.hashCode();
        goto L110
    L105:
        r177 = r176.hashCode();
        goto L106
    L101:
        r174 = r173.hashCode();
        goto L102
    L97:
        r171 = r170.hashCode();
        goto L98
    L93:
        r168 = r167.hashCode();
        goto L94
    L89:
        r165 = r164.hashCode();
        goto L90
    L85:
        r162 = r161.hashCode();
        goto L86
    L81:
        r159 = r158.hashCode();
        goto L82
    L77:
        r156 = r155.hashCode();
        goto L78
    L73:
        r153 = r152.hashCode();
        goto L74
    L69:
        r150 = r149.hashCode();
        goto L70
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

    public final String toString() {
        return "LiveLocalLifeSettingsEntity(lynxShelfProcessorSchema=" + this.lynxShelfProcessorSchema + ", lynxTopbarSchema=" + this.lynxTopbarSchema + ", lynxRankWidgetSchema=" + this.lynxRankWidgetSchema + ", searchBarSchema=" + this.searchBarSchema + ", searchHistorySchema=" + this.searchHistorySchema + ", searchEmptySchema=" + this.searchEmptySchema + ", lynxBottomBarSchema=" + this.lynxBottomBarSchema + ", lynxTopAtmosphereSchema=" + this.lynxTopAtmosphereSchema + ", lynxAirSettings=" + this.lynxAirSettings + ", grouponIconStyle=" + this.grouponIconStyle + ", performanceSettings=" + this.performanceSettings + ", lynxCommonCellSchema=" + this.lynxCommonCellSchema + ", dslLynxModuleCommonSchema=" + this.dslLynxModuleCommonSchema + ", expoundCardDslModuleCommonSchema=" + this.expoundCardDslModuleCommonSchema + ", lynxShelfPagingProcessorSchema=" + this.lynxShelfPagingProcessorSchema + ", forbidLynxTopbar=" + this.forbidLynxTopbar + ", forbidBtm=" + this.forbidBtm + ", shelfHeightTracker=" + this.shelfHeightTracker + ", shelfDSLFmpOpt=" + this.shelfDSLFmpOpt + ", forbidCardJumpUrlDynamicOpt=" + this.forbidCardJumpUrlDynamicOpt + ", lynxShelfCouponToastSchema=" + this.lynxShelfCouponToastSchema + ", shelfUiSettings=" + this.shelfUiSettings + ", forbidExpoundCardLynxTracker=" + this.forbidExpoundCardLynxTracker + ", expoundCardBizAttrAnimation=" + this.expoundCardBizAttrAnimation + ", useHybridReport=" + this.useHybridReport + ", lotteryJumpUrl=" + this.lotteryJumpUrl + ", stickerContainerSettings=" + this.stickerContainerSettings + ", disableMessageCenter=" + this.disableMessageCenter + ", lynxAsyncOpt=" + this.lynxAsyncOpt + ", disableCouponDataCenterOpt=" + this.disableCouponDataCenterOpt + ", dslBitmapCache=" + this.dslBitmapCache + ", disableIconAlienationAnimation=" + this.disableIconAlienationAnimation + ", disableIconAnimationOpt=" + this.disableIconAnimationOpt + ", disableJsonParseMonitor=" + this.disableJsonParseMonitor + ", lynxSharePanelCouponSchema=" + this.lynxSharePanelCouponSchema + ", lynxShareCollectCouponSchema=" + this.lynxShareCollectCouponSchema + ", titleChineseSymbols=" + this.titleChineseSymbols + ", fuseShelfApiRetryTimesLimit=" + this.fuseShelfApiRetryTimesLimit + ", fuseShelfApiRetryFrameLimit=" + this.fuseShelfApiRetryFrameLimit + ", loadSuccessUInMultiThread=" + this.loadSuccessUInMultiThread + ", isIconUseCollectCouponV2=" + this.isIconUseCollectCouponV2 + ", lynxShareCollectCouponSchemaV2=" + this.lynxShareCollectCouponSchemaV2 + ", atmosphereResourceCacheConfig=" + this.atmosphereResourceCacheConfig + ", lynxTopbarFmpMeasureEnable=" + this.lynxTopbarFmpMeasureEnable + ", newEnterParamsAutoOpenCount=" + this.newEnterParamsAutoOpenCount + ", shelfPrefetchPath=" + this.shelfPrefetchPath + ", shelfPagePrefetchPath=" + this.shelfPagePrefetchPath + ", enableGoodsDetailFullScreen=" + this.enableGoodsDetailFullScreen + ", shelfCardShowTagsInfoEnable=" + this.shelfCardShowTagsInfoEnable + ", schemaReportEnable=" + this.schemaReportEnable + ", dslResponseInitOpt=" + this.dslResponseInitOpt + ", cancelExplainRefreshInterval=" + this.cancelExplainRefreshInterval + ", liveRecommendInfoList=" + this.liveRecommendInfoList + ", enableShelfErrorViewFix=" + this.enableShelfErrorViewFix + ", lifeLifeScrollMinOffset=" + this.lifeLifeScrollMinOffset + ", lifeLifeScrollMinTime=" + this.lifeLifeScrollMinTime + ", lifeLifeSlideEventMaxCount=" + this.lifeLifeSlideEventMaxCount + ", liveLifeOptAutoOpenAndAnchor=" + this.liveLifeOptAutoOpenAndAnchor + ", liveLifeOptCouponShelfRefresh=" + this.liveLifeOptCouponShelfRefresh + ", shelfUseWebUrl=" + this.shelfUseWebUrl + ')';
    }

    public h() {
        this.lynxShelfProcessorSchema = null;
        this.lynxTopbarSchema = null;
        this.lynxRankWidgetSchema = null;
        this.searchBarSchema = null;
        this.searchHistorySchema = null;
        this.searchEmptySchema = null;
        this.lynxBottomBarSchema = null;
        this.lynxTopAtmosphereSchema = null;
        this.lynxAirSettings = null;
        this.grouponIconStyle = null;
        this.performanceSettings = null;
        this.lynxCommonCellSchema = null;
        this.dslLynxModuleCommonSchema = null;
        this.expoundCardDslModuleCommonSchema = null;
        this.lynxShelfPagingProcessorSchema = null;
        this.forbidLynxTopbar = 0;
        this.forbidBtm = 0;
        this.shelfHeightTracker = null;
        this.shelfDSLFmpOpt = 1;
        this.forbidCardJumpUrlDynamicOpt = 0;
        this.lynxShelfCouponToastSchema = null;
        this.shelfUiSettings = null;
        this.forbidExpoundCardLynxTracker = 0;
        this.expoundCardBizAttrAnimation = null;
        this.useHybridReport = 1;
        this.lotteryJumpUrl = null;
        this.stickerContainerSettings = null;
        this.disableMessageCenter = 0;
        this.lynxAsyncOpt = 1;
        this.disableCouponDataCenterOpt = 0;
        this.dslBitmapCache = 0;
        this.disableIconAlienationAnimation = 0;
        this.disableIconAnimationOpt = 0;
        this.disableJsonParseMonitor = 0;
        this.lynxSharePanelCouponSchema = null;
        this.lynxShareCollectCouponSchema = null;
        this.titleChineseSymbols = null;
        this.fuseShelfApiRetryTimesLimit = 10;
        this.fuseShelfApiRetryFrameLimit = 20;
        this.loadSuccessUInMultiThread = 0;
        this.isIconUseCollectCouponV2 = 1;
        this.lynxShareCollectCouponSchemaV2 = null;
        this.atmosphereResourceCacheConfig = null;
        this.lynxTopbarFmpMeasureEnable = 1;
        this.newEnterParamsAutoOpenCount = 2;
        this.shelfPrefetchPath = null;
        this.shelfPagePrefetchPath = null;
        this.enableGoodsDetailFullScreen = 0;
        this.shelfCardShowTagsInfoEnable = 1;
        this.schemaReportEnable = 0;
        this.dslResponseInitOpt = 1;
        this.cancelExplainRefreshInterval = 1000;
        this.liveRecommendInfoList = null;
        this.enableShelfErrorViewFix = 1;
        this.lifeLifeScrollMinOffset = 25;
        this.lifeLifeScrollMinTime = 200;
        this.lifeLifeSlideEventMaxCount = 4;
        this.liveLifeOptAutoOpenAndAnchor = 1;
        this.liveLifeOptCouponShelfRefresh = 1;
        this.shelfUseWebUrl = 0;
    }

    public final int A() {
        return this.lynxAsyncOpt;
    }

    public final String B() {
        return this.lynxBottomBarSchema;
    }

    public final String C() {
        return this.lynxCommonCellSchema;
    }

    public final String D() {
        return this.lynxShareCollectCouponSchema;
    }

    public final String E() {
        return this.lynxShareCollectCouponSchemaV2;
    }

    public final String F() {
        return this.lynxShelfCouponToastSchema;
    }

    public final String G() {
        return this.lynxShelfPagingProcessorSchema;
    }

    public final String H() {
        return this.lynxShelfProcessorSchema;
    }

    public final String I() {
        return this.lynxTopAtmosphereSchema;
    }

    public final int J() {
        return this.lynxTopbarFmpMeasureEnable;
    }

    public final String K() {
        return this.lynxTopbarSchema;
    }

    public final int L() {
        return this.newEnterParamsAutoOpenCount;
    }

    public final int M() {
        return this.schemaReportEnable;
    }

    public final String N() {
        return this.searchBarSchema;
    }

    public final String O() {
        return this.searchEmptySchema;
    }

    public final String P() {
        return this.searchHistorySchema;
    }

    public final int Q() {
        return this.shelfCardShowTagsInfoEnable;
    }

    public final int R() {
        return this.shelfDSLFmpOpt;
    }

    public final Map<String, Object> S() {
        return this.shelfHeightTracker;
    }

    public final String T() {
        return this.shelfPagePrefetchPath;
    }

    public final String U() {
        return this.shelfPrefetchPath;
    }

    public final r V() {
        return this.shelfUiSettings;
    }

    public final int W() {
        return this.shelfUseWebUrl;
    }

    public final s X() {
        return this.stickerContainerSettings;
    }

    public final int Y() {
        return this.useHybridReport;
    }

    public final int Z() {
        return this.isIconUseCollectCouponV2;
    }

    public final a a() {
        return this.atmosphereResourceCacheConfig;
    }

    public final long b() {
        return this.cancelExplainRefreshInterval;
    }

    public final int c() {
        return this.disableIconAlienationAnimation;
    }

    public final int d() {
        return this.disableIconAnimationOpt;
    }

    public final int e() {
        return this.disableJsonParseMonitor;
    }

    public final int f() {
        return this.disableMessageCenter;
    }

    public final String g() {
        return this.dslLynxModuleCommonSchema;
    }

    public final int h() {
        return this.dslResponseInitOpt;
    }

    public final int i() {
        return this.enableGoodsDetailFullScreen;
    }

    public final int j() {
        return this.enableShelfErrorViewFix;
    }

    public final String k() {
        return this.expoundCardDslModuleCommonSchema;
    }

    public final int l() {
        return this.forbidBtm;
    }

    public final int m() {
        return this.forbidCardJumpUrlDynamicOpt;
    }

    public final int n() {
        return this.forbidExpoundCardLynxTracker;
    }

    public final int o() {
        return this.forbidLynxTopbar;
    }

    public final int p() {
        return this.fuseShelfApiRetryFrameLimit;
    }

    public final int q() {
        return this.fuseShelfApiRetryTimesLimit;
    }

    public final d r() {
        return this.grouponIconStyle;
    }

    public final int s() {
        return this.lifeLifeScrollMinOffset;
    }

    public final int t() {
        return this.lifeLifeScrollMinTime;
    }

    public final int u() {
        return this.lifeLifeSlideEventMaxCount;
    }

    public final int v() {
        return this.liveLifeOptAutoOpenAndAnchor;
    }

    public final int w() {
        return this.liveLifeOptCouponShelfRefresh;
    }

    public final List<String> x() {
        return this.liveRecommendInfoList;
    }

    public final int y() {
        return this.loadSuccessUInMultiThread;
    }

    public final Map<String, Object> z() {
        return this.lynxAirSettings;
    }
}
