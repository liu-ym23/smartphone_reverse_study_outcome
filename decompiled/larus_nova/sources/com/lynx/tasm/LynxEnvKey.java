package com.lynx.tasm;

/* JADX INFO: loaded from: classes32.dex */
public final enum LynxEnvKey extends Enum<LynxEnvKey> {
    public static final LynxEnvKey DISABLE_BIG_IMAGE_HELPER = null;
    public static final LynxEnvKey DISABLE_POST_PROCESSOR = null;
    public static final LynxEnvKey ENABLE_CHECK_ACCESS_FROM_NON_UI_THREAD = null;
    public static final LynxEnvKey ENABLE_COMPONENT_STATISTIC_REPORT = null;
    public static final LynxEnvKey ENABLE_DATA_LIST_FIX = null;
    public static final LynxEnvKey ENABLE_FALLBACK_NEW_ENGINE_REBUILD = null;
    public static final LynxEnvKey ENABLE_FEATURE_COUNTER = null;
    public static final LynxEnvKey ENABLE_FLATTEN_IMAGE_FLICKER_FIX = null;
    public static final LynxEnvKey ENABLE_FLUENCY_TRACE = null;
    public static final LynxEnvKey ENABLE_GENERIC_LYNX_RESOURCE_FETCHER_FONT_KEY = null;
    public static final LynxEnvKey ENABLE_GENERIC_RESOURCE_FETCHER = null;
    public static final LynxEnvKey ENABLE_GLOBAL_FEATURE_SWITCH_STATISTIC = null;
    public static final LynxEnvKey ENABLE_IMAGE_ASYNC_LAYOUT = null;
    public static final LynxEnvKey ENABLE_IMAGE_ASYNC_REDIRECT = null;
    public static final LynxEnvKey ENABLE_IMAGE_ASYNC_REDIRECT_ON_CREATE = null;
    public static final LynxEnvKey ENABLE_IMAGE_ASYNC_REQUEST = null;
    public static final LynxEnvKey ENABLE_IMAGE_EVENT_REPORT = null;
    public static final LynxEnvKey ENABLE_IMAGE_MEMORY_REPORT = null;
    public static final LynxEnvKey ENABLE_IMAGE_REQUEST_OPTIMIZE = null;
    public static final LynxEnvKey ENABLE_JSB_TIMING = null;
    public static final LynxEnvKey ENABLE_LAZY_INIT_A11Y = null;
    public static final LynxEnvKey ENABLE_LONG_TASK_TIMING = null;
    public static final LynxEnvKey ENABLE_MEMORY_MONITOR = null;
    public static final LynxEnvKey ENABLE_MULTI_JS_THREAD_BY_DEFAULT = null;
    public static final LynxEnvKey ENABLE_PIPER_MONITOR = null;
    public static final LynxEnvKey ENABLE_REFRESH_RATE_OPT = null;
    public static final LynxEnvKey ENABLE_REPORT_CREATE_ASYNC_TAG = null;
    public static final LynxEnvKey ENABLE_SKIP_UPDATE_VIEWPORT_ON_INIT_WHEN_MEASURE_SPEC_EMPTY = null;
    public static final LynxEnvKey ENABLE_SVG_ASYNC = null;
    public static final LynxEnvKey ENABLE_TEXT_BORING_LAYOUT = null;
    public static final LynxEnvKey ENABLE_TEXT_LAYOUT_CACHE = null;
    public static final LynxEnvKey ENABLE_TRANSFORM_FOR_POSITION_CALCULATION = null;
    public static final LynxEnvKey ENABLE_VSYNC_ALIGNED_FLUSH = null;
    public static final LynxEnvKey ENABLE_VSYNC_ALIGNED_MESSAGE_LOOP_GLOBAL = null;
    public static final LynxEnvKey FORCE_DISABLE_QUICKJS_CACHE = null;
    public static final LynxEnvKey FORCE_LAYOUT_ON_BACKGROUND_THREAD = null;
    public static final LynxEnvKey FSP_CONFIG_JSON_STRING = null;
    public static final LynxEnvKey FSP_ENABLE = null;
    public static final LynxEnvKey GLOBAL_MEMORY_REPORT_THRESHOLD_MB = null;
    public static final LynxEnvKey INIT_DISPLAY_METRICS_IN_ENV = null;
    public static final LynxEnvKey MEMORY_ACQUISITION_DELAY_SEC = null;
    public static final LynxEnvKey MEMORY_REPORT_INTERVAL_SEC = null;
    public static final LynxEnvKey SETUP_CANVAS_SURFACE_EARLIER = null;
    public static final String SP_KEY_ACTIVATED_CDP_DOMAINS = "activated_cdp_domains";
    public static final String SP_KEY_DISABLE_LEPUSNG_OPTIMIZE = "DISABLE_LEPUSNG_OPTIMIZE";
    public static final String SP_KEY_ENABLE_CDP_DOMAIN_CSS = "enable_cdp_domain_css";
    public static final String SP_KEY_ENABLE_CDP_DOMAIN_DOM = "enable_cdp_domain_dom";
    public static final String SP_KEY_ENABLE_CDP_DOMAIN_PAGE = "enable_cdp_domain_page";
    public static final String SP_KEY_ENABLE_DEBUG_MODE = "enable_debug_mode";
    public static final String SP_KEY_ENABLE_DEVTOOL = "enable_devtool";
    public static final String SP_KEY_ENABLE_DOM_TREE = "enable_dom_tree";
    public static final String SP_KEY_ENABLE_FSP_SCREENSHOT = "enable_fsp_screenshot";
    public static final String SP_KEY_ENABLE_HIGHLIGHT_TOUCH = "enable_highlight_touch";
    public static final String SP_KEY_ENABLE_IGNORE_ERROR_CSS = "error_code_css";
    public static final String SP_KEY_ENABLE_LAUNCH_RECORD = "enable_launch_record";
    public static final String SP_KEY_ENABLE_LOGBOX = "enable_logbox";
    public static final String SP_KEY_ENABLE_LONG_PRESS_MENU = "enable_long_press_menu";
    public static final String SP_KEY_ENABLE_PIXEL_COPY = "enable_pixel_copy";
    public static final String SP_KEY_ENABLE_PREVIEW_SCREEN_SHOT = "enable_preview_screen_shot";
    public static final String SP_KEY_ENABLE_QUICKJS_CACHE = "enable_quickjs_cache";
    public static final String SP_KEY_ENABLE_QUICKJS_DEBUG = "enable_quickjs_debug";
    public static final String SP_KEY_ENABLE_V8 = "enable_v8";
    public static final String SP_KEY_ENABLE_VSYNC_ALIGNED_FLUSH = null;
    public static final String SP_KEY_FORCE_DISABLE_QUICKJS_CACHE = null;
    public static final String SP_KEY_IGNORE_ERROR_TYPES = "ignore_error_types";
    public static final String SP_KEY_SHOW_DEVTOOL_BADGE = "show_devtool_badge";
    public static final LynxEnvKey USE_NEW_IMAGE = null;
    public static final LynxEnvKey VSYNC_ALIGNED_FLUSH_EXP_KEY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LynxEnvKey[] f381659a = null;
    private final String description;

    static {
        LynxEnvKey r100 = new LynxEnvKey("FORCE_DISABLE_QUICKJS_CACHE", 0, "ANDROID_DISABLE_QUICKJS_CODE_CACHE");
        FORCE_DISABLE_QUICKJS_CACHE = r100;
        LynxEnvKey r101 = new LynxEnvKey("ENABLE_VSYNC_ALIGNED_FLUSH", 1, "enable_vsync_aligned_flush_local");
        ENABLE_VSYNC_ALIGNED_FLUSH = r101;
        LynxEnvKey r102 = new LynxEnvKey("ENABLE_GLOBAL_FEATURE_SWITCH_STATISTIC", 2, "ENABLE_GLOBAL_FEATURE_SWITCH_STATISTIC");
        ENABLE_GLOBAL_FEATURE_SWITCH_STATISTIC = r102;
        LynxEnvKey r103 = new LynxEnvKey("ENABLE_FEATURE_COUNTER", 3, "ENABLE_FEATURE_COUNTER");
        ENABLE_FEATURE_COUNTER = r103;
        LynxEnvKey r104 = new LynxEnvKey("ENABLE_JSB_TIMING", 4, "enable_jsb_timing");
        ENABLE_JSB_TIMING = r104;
        LynxEnvKey r105 = new LynxEnvKey("ENABLE_LONG_TASK_TIMING", 5, "enable_long_task_timing");
        ENABLE_LONG_TASK_TIMING = r105;
        LynxEnvKey r110 = new LynxEnvKey("ENABLE_CHECK_ACCESS_FROM_NON_UI_THREAD", 6, "enable_check_access_from_non_ui_thread");
        ENABLE_CHECK_ACCESS_FROM_NON_UI_THREAD = r110;
        LynxEnvKey r111 = new LynxEnvKey("VSYNC_ALIGNED_FLUSH_EXP_KEY", 7, "enable_vsync_aligned_flush");
        VSYNC_ALIGNED_FLUSH_EXP_KEY = r111;
        LynxEnvKey r112 = new LynxEnvKey("USE_NEW_IMAGE", 8, "useNewImage");
        USE_NEW_IMAGE = r112;
        LynxEnvKey r113 = new LynxEnvKey("ENABLE_PIPER_MONITOR", 9, "enablePiperMonitor");
        ENABLE_PIPER_MONITOR = r113;
        LynxEnvKey r114 = new LynxEnvKey("ENABLE_FLUENCY_TRACE", 10, "ENABLE_FLUENCY_TRACE");
        ENABLE_FLUENCY_TRACE = r114;
        LynxEnvKey r115 = new LynxEnvKey("DISABLE_POST_PROCESSOR", 11, "disable_post_processor");
        DISABLE_POST_PROCESSOR = r115;
        LynxEnvKey r106 = new LynxEnvKey("ENABLE_IMAGE_MEMORY_REPORT", 12, "enable_image_memory_report");
        ENABLE_IMAGE_MEMORY_REPORT = r106;
        LynxEnvKey r107 = new LynxEnvKey("ENABLE_COMPONENT_STATISTIC_REPORT", 13, "enable_component_statistic_report");
        ENABLE_COMPONENT_STATISTIC_REPORT = r107;
        LynxEnvKey r108 = new LynxEnvKey("ENABLE_TRANSFORM_FOR_POSITION_CALCULATION", 14, "enable_transform_for_position_calculation");
        ENABLE_TRANSFORM_FOR_POSITION_CALCULATION = r108;
        LynxEnvKey r109 = new LynxEnvKey("ENABLE_GENERIC_LYNX_RESOURCE_FETCHER_FONT_KEY", 15, "enable_generic_lynx_resource_fetcher_font");
        ENABLE_GENERIC_LYNX_RESOURCE_FETCHER_FONT_KEY = r109;
        LynxEnvKey r116 = new LynxEnvKey("ENABLE_VSYNC_ALIGNED_MESSAGE_LOOP_GLOBAL", 16, "enable_vsync_aligned_message_loop_global");
        ENABLE_VSYNC_ALIGNED_MESSAGE_LOOP_GLOBAL = r116;
        LynxEnvKey r117 = new LynxEnvKey("FORCE_LAYOUT_ON_BACKGROUND_THREAD", 17, "force_layout_on_background_thread");
        FORCE_LAYOUT_ON_BACKGROUND_THREAD = r117;
        LynxEnvKey r118 = new LynxEnvKey("ENABLE_SKIP_UPDATE_VIEWPORT_ON_INIT_WHEN_MEASURE_SPEC_EMPTY", 18, "enable_skip_update_viewport_on_init_when_measure_spec_empty");
        ENABLE_SKIP_UPDATE_VIEWPORT_ON_INIT_WHEN_MEASURE_SPEC_EMPTY = r118;
        LynxEnvKey r119 = new LynxEnvKey("ENABLE_FALLBACK_NEW_ENGINE_REBUILD", 19, "enable_fallback_new_engine_rebuild");
        ENABLE_FALLBACK_NEW_ENGINE_REBUILD = r119;
        LynxEnvKey r120 = new LynxEnvKey("ENABLE_REPORT_CREATE_ASYNC_TAG", 20, "enable_report_create_async_tag");
        ENABLE_REPORT_CREATE_ASYNC_TAG = r120;
        LynxEnvKey r121 = new LynxEnvKey("ENABLE_SVG_ASYNC", 21, "enable_svg_async");
        ENABLE_SVG_ASYNC = r121;
        LynxEnvKey r122 = new LynxEnvKey("ENABLE_IMAGE_EVENT_REPORT", 22, "enable_image_event_report");
        ENABLE_IMAGE_EVENT_REPORT = r122;
        LynxEnvKey r123 = new LynxEnvKey("ENABLE_IMAGE_ASYNC_LAYOUT", 23, "enable_image_async_layout");
        ENABLE_IMAGE_ASYNC_LAYOUT = r123;
        LynxEnvKey r124 = new LynxEnvKey("ENABLE_IMAGE_ASYNC_REDIRECT", 24, "enable_image_async_redirect");
        ENABLE_IMAGE_ASYNC_REDIRECT = r124;
        LynxEnvKey r125 = new LynxEnvKey("ENABLE_IMAGE_ASYNC_REDIRECT_ON_CREATE", 25, "enable_image_async_redirect_create");
        ENABLE_IMAGE_ASYNC_REDIRECT_ON_CREATE = r125;
        LynxEnvKey r126 = new LynxEnvKey("ENABLE_IMAGE_ASYNC_REQUEST", 26, "enable_image_async_request");
        ENABLE_IMAGE_ASYNC_REQUEST = r126;
        LynxEnvKey r127 = new LynxEnvKey("ENABLE_IMAGE_REQUEST_OPTIMIZE", 27, "enable_image_request_optimize");
        ENABLE_IMAGE_REQUEST_OPTIMIZE = r127;
        LynxEnvKey r128 = new LynxEnvKey("ENABLE_FLATTEN_IMAGE_FLICKER_FIX", 28, "enable_flatten_image_flicker_fix");
        ENABLE_FLATTEN_IMAGE_FLICKER_FIX = r128;
        LynxEnvKey r129 = new LynxEnvKey("DISABLE_BIG_IMAGE_HELPER", 29, "disable_big_image_helper");
        DISABLE_BIG_IMAGE_HELPER = r129;
        LynxEnvKey r130 = new LynxEnvKey("ENABLE_GENERIC_RESOURCE_FETCHER", 30, "enable_generic_resource_fetcher");
        ENABLE_GENERIC_RESOURCE_FETCHER = r130;
        LynxEnvKey r131 = new LynxEnvKey("ENABLE_TEXT_BORING_LAYOUT", 31, "enable_text_boring_layout");
        ENABLE_TEXT_BORING_LAYOUT = r131;
        LynxEnvKey r132 = new LynxEnvKey("ENABLE_REFRESH_RATE_OPT", 32, "enable_refresh_rate_opt");
        ENABLE_REFRESH_RATE_OPT = r132;
        LynxEnvKey r133 = new LynxEnvKey("ENABLE_MULTI_JS_THREAD_BY_DEFAULT", 33, "enable_multi_js_thread_by_default");
        ENABLE_MULTI_JS_THREAD_BY_DEFAULT = r133;
        LynxEnvKey r134 = new LynxEnvKey("ENABLE_LAZY_INIT_A11Y", 34, "enable_lazy_init_a11y");
        ENABLE_LAZY_INIT_A11Y = r134;
        LynxEnvKey r135 = new LynxEnvKey("ENABLE_TEXT_LAYOUT_CACHE", 35, "enable_text_layout_cache");
        ENABLE_TEXT_LAYOUT_CACHE = r135;
        LynxEnvKey r136 = new LynxEnvKey("ENABLE_MEMORY_MONITOR", 36, "enable_memory_monitor");
        ENABLE_MEMORY_MONITOR = r136;
        LynxEnvKey r137 = new LynxEnvKey("MEMORY_ACQUISITION_DELAY_SEC", 37, "memory_acquisition_delay_second");
        MEMORY_ACQUISITION_DELAY_SEC = r137;
        LynxEnvKey r138 = new LynxEnvKey("MEMORY_REPORT_INTERVAL_SEC", 38, "memory_report_interval_sec");
        MEMORY_REPORT_INTERVAL_SEC = r138;
        LynxEnvKey r139 = new LynxEnvKey("GLOBAL_MEMORY_REPORT_THRESHOLD_MB", 39, "global_memory_report_threshold_mb");
        GLOBAL_MEMORY_REPORT_THRESHOLD_MB = r139;
        LynxEnvKey r140 = new LynxEnvKey("ENABLE_DATA_LIST_FIX", 40, "enable_data_list_fix");
        ENABLE_DATA_LIST_FIX = r140;
        LynxEnvKey r141 = new LynxEnvKey("FSP_ENABLE", 41, "enable_fsp");
        FSP_ENABLE = r141;
        LynxEnvKey r142 = new LynxEnvKey("FSP_CONFIG_JSON_STRING", 42, "fsp_config_json_string");
        FSP_CONFIG_JSON_STRING = r142;
        LynxEnvKey r143 = new LynxEnvKey("INIT_DISPLAY_METRICS_IN_ENV", 43, "init_display_metrics_in_env");
        INIT_DISPLAY_METRICS_IN_ENV = r143;
        LynxEnvKey r144 = new LynxEnvKey("SETUP_CANVAS_SURFACE_EARLIER", 44, "setup_canvas_surface_earlier");
        SETUP_CANVAS_SURFACE_EARLIER = r144;
        f381659a = new LynxEnvKey[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r142, r143, r144};
        SP_KEY_FORCE_DISABLE_QUICKJS_CACHE = r100.getDescription();
        SP_KEY_ENABLE_VSYNC_ALIGNED_FLUSH = r101.getDescription();
    }

    public static LynxEnvKey[] values() {
        return (LynxEnvKey[]) f381659a.clone();
    }

    public String getDescription() {
        return this.description;
    }

    public static LynxEnvKey valueOf(String r100) {
        return (LynxEnvKey) r27.a.a(LynxEnvKey.class, r100);
    }

    public LynxEnvKey(String r100, int r101, String r102) {
        super(r100, r101);
        this.description = r102;
    }
}
