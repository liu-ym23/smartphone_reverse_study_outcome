package com.bytedance.locallife.dito.host.settings;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\bS\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0016\u0010\r\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0016\u0010\u000f\u001a\u00020\u00048\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0016\u0010\u0011\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u001e\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00048\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u001e\u0010\u0019\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\u0016R\u0016\u0010\u001c\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0006R\u0016\u0010\u001e\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0006R\u0016\u0010 \u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0006R\u0016\u0010\"\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0006R\u0016\u0010$\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0006R\u001e\u0010&\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\u0016R\u0016\u0010)\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0006R\u0016\u0010+\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0006R\u001e\u0010-\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\u0016R\u0016\u00100\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0006R\u0016\u00102\u001a\u00020\u00048\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u0006R\u0016\u00104\u001a\u00020\u00048\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0006R\u0016\u00106\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u0006R\u0016\u00108\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0006R\u0016\u0010:\u001a\u00020\u00048\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b;\u0010\u0006R\u0016\u0010<\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0006R\u0016\u0010>\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\u0006R\u0016\u0010@\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bA\u0010\u0006R\u001e\u0010B\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\u0016R\u0016\u0010E\u001a\u00020\u00048\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\u0006R\u0016\u0010G\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\u0006R\u0016\u0010I\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\u0006R\u0016\u0010K\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\u0006R\u0016\u0010M\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bN\u0010\u0006R\u0016\u0010O\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\u0006R\u0016\u0010Q\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\u0006R\u0016\u0010S\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bT\u0010\u0006R\u0016\u0010U\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bV\u0010\u0006R\u0016\u0010W\u001a\u00020X8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR\u0016\u0010[\u001a\u00020\u00048\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010\u0006R\u0016\u0010]\u001a\u00020^8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b_\u0010`R\u0016\u0010a\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bb\u0010\u0006R\u0016\u0010c\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bd\u0010\u0006R\u0016\u0010e\u001a\u00020\u00048\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\bf\u0010\u0006R\u0016\u0010g\u001a\u00020\u00048\u0016X\u0097D¢\u0006\b\n\u0000\u001a\u0004\bh\u0010\u0006¨\u0006i"}, d2 = {"Lcom/bytedance/locallife/dito/host/settings/DitoSettings;", "", "()V", "allowJsbControlDitoScroll", "", "getAllowJsbControlDitoScroll", "()Z", "allowResetToBottomEdgeWhenFling", "getAllowResetToBottomEdgeWhenFling", "decodeTrackParamsMapJsonSelf", "getDecodeTrackParamsMapJsonSelf", "disableScrollMethodCompatible", "getDisableScrollMethodCompatible", "disableUsePresetHeightCacheAfterFmp", "getDisableUsePresetHeightCacheAfterFmp", "ditoMergeDataWhenEmpty", "getDitoMergeDataWhenEmpty", "enableChildInterceptScroll", "getEnableChildInterceptScroll", "enableFixResetTotalScrollY", "getEnableFixResetTotalScrollY", "setEnableFixResetTotalScrollY", "(Z)V", "enableFixStickLayoutListenerPostScroll", "getEnableFixStickLayoutListenerPostScroll", "enableFixStickOrder", "getEnableFixStickOrder", "setEnableFixStickOrder", "enableFixTreeMapConcurrentException", "getEnableFixTreeMapConcurrentException", "enableMobDitoViewCreate", "getEnableMobDitoViewCreate", "enableMoveFloatNode", "getEnableMoveFloatNode", "enableMultiSticky", "getEnableMultiSticky", "enableNewStickClick", "getEnableNewStickClick", "enableOptimizeSubStickVisible", "getEnableOptimizeSubStickVisible", "setEnableOptimizeSubStickVisible", "enablePreloadDitoBodyView", "getEnablePreloadDitoBodyView", "enableStickSubViewVariableHeight", "getEnableStickSubViewVariableHeight", "enableViewPagerFullHeight", "getEnableViewPagerFullHeight", "setEnableViewPagerFullHeight", "fixDitoSubStickBoundary", "getFixDitoSubStickBoundary", "fixDitoTreeNodeInsertBug", "getFixDitoTreeNodeInsertBug", "fixDragItemNotResetNestedReadyState", "getFixDragItemNotResetNestedReadyState", "fixGroupBottomMargin", "getFixGroupBottomMargin", "fixGroupMargin", "getFixGroupMargin", "fixHalfScreenStuckOnScrollStop", "getFixHalfScreenStuckOnScrollStop", "fixMapValueDowngradeToString", "getFixMapValueDowngradeToString", "fixNegativeBottom", "getFixNegativeBottom", "fixNestedClickError", "getFixNestedClickError", "fixNestedV2ScrollError", "getFixNestedV2ScrollError", "setFixNestedV2ScrollError", "fixOnSlideOverwriteTotalScrollY", "getFixOnSlideOverwriteTotalScrollY", "fixParentLayoutRequested", "getFixParentLayoutRequested", "fixReuseViewStyle", "getFixReuseViewStyle", "fixSimpleHeadInfo", "getFixSimpleHeadInfo", "fixVisibilityBottom", "getFixVisibilityBottom", "forceShutDownSwitchLayout", "getForceShutDownSwitchLayout", "optimizePostException", "getOptimizePostException", "optimizeRootPostRunnable", "getOptimizeRootPostRunnable", "pagerMultiTabFix", "getPagerMultiTabFix", "pagerOffscreenLimit", "", "getPagerOffscreenLimit", "()I", "performancePluginParseEnclosingClass", "getPerformancePluginParseEnclosingClass", "presetSizeCachePeriod", "", "getPresetSizeCachePeriod", "()J", "skipInvalidTimeCheckWhenTargetFoundRetry", "getSkipInvalidTimeCheckWhenTargetFoundRetry", "tryRepeatAnchorPageSwitch", "getTryRepeatAnchorPageSwitch", "useDitoNodeMerge", "getUseDitoNodeMerge", "useDitoRecyclerViewV2", "getUseDitoRecyclerViewV2", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public class DitoSettings {

    @SerializedName("allow_jsb_control_dito_scroll")
    private final boolean allowJsbControlDitoScroll;

    @SerializedName("allow_reset_to_bottom_edge_when_fling")
    private final boolean allowResetToBottomEdgeWhenFling;

    @SerializedName("decode_track_params_map_json_self")
    private final boolean decodeTrackParamsMapJsonSelf;

    @SerializedName("disable_scroll_method_compatible")
    private final boolean disableScrollMethodCompatible;

    @SerializedName("disable_use_preset_height_cache_after_fmp")
    private final boolean disableUsePresetHeightCacheAfterFmp;

    @SerializedName("dito_node_merge_data_when_empty")
    private final boolean ditoMergeDataWhenEmpty;

    @SerializedName("enable_child_intercept_scroll")
    private final boolean enableChildInterceptScroll;

    @SerializedName("enable_fix_reset_total_scroll_y")
    private boolean enableFixResetTotalScrollY;

    @SerializedName("enable_fix_stick_layout_listener_post_scroll")
    private final boolean enableFixStickLayoutListenerPostScroll;

    @SerializedName("enable_fix_stick_order")
    private boolean enableFixStickOrder;

    @SerializedName("fix_tree_map_concurrent_exception")
    private final boolean enableFixTreeMapConcurrentException;

    @SerializedName("enable_mob_dito_view_create")
    private final boolean enableMobDitoViewCreate;

    @SerializedName("dito_enable_move_float_node")
    private final boolean enableMoveFloatNode;

    @SerializedName("enable_multi_sticky")
    private final boolean enableMultiSticky;

    @SerializedName("enable_new_stick_click")
    private final boolean enableNewStickClick;

    @SerializedName("enable_optimize_sub_stick_visible")
    private boolean enableOptimizeSubStickVisible;

    @SerializedName("enable_preload_dito_body_view")
    private final boolean enablePreloadDitoBodyView;

    @SerializedName("enable_stick_sub_view_variable_height")
    private final boolean enableStickSubViewVariableHeight;

    @SerializedName("enable_view_pager_full_height")
    private boolean enableViewPagerFullHeight;

    @SerializedName("fix_dito_sub_stick_boundary")
    private final boolean fixDitoSubStickBoundary;

    @SerializedName("fix_dito_tree_node_insert_bug")
    private final boolean fixDitoTreeNodeInsertBug;

    @SerializedName("fix_drag_item_not_reset_nested_scroll_state")
    private final boolean fixDragItemNotResetNestedReadyState;

    @SerializedName("fix_group_bottom_margin")
    private final boolean fixGroupBottomMargin;

    @SerializedName("fix_group_margin")
    private final boolean fixGroupMargin;

    @SerializedName("fix_half_screen_stuck_on_scroll_stop")
    private final boolean fixHalfScreenStuckOnScrollStop;

    @SerializedName("fix_map_value_downgrade_to_string")
    private final boolean fixMapValueDowngradeToString;

    @SerializedName("fix_negative_bottom")
    private final boolean fixNegativeBottom;

    @SerializedName("dito_nested_click_fix")
    private final boolean fixNestedClickError;

    @SerializedName("enable_fix_nested_v2_scroll_error")
    private boolean fixNestedV2ScrollError;

    @SerializedName("fix_on_slide_overwrite_total_scroll_y")
    private final boolean fixOnSlideOverwriteTotalScrollY;

    @SerializedName("fix_parent_layout_requested")
    private final boolean fixParentLayoutRequested;

    @SerializedName("fix_reuse_view_style")
    private final boolean fixReuseViewStyle;

    @SerializedName("fix_simple_head_info")
    private final boolean fixSimpleHeadInfo;

    @SerializedName("fix_visibility_bottom")
    private final boolean fixVisibilityBottom;

    @SerializedName("dito_force_shut_down_switch_layout")
    private final boolean forceShutDownSwitchLayout;

    @SerializedName("opt_post_exception")
    private final boolean optimizePostException;

    @SerializedName("dito_optimize_root_post_runnable")
    private final boolean optimizeRootPostRunnable;

    @SerializedName("dito_pager_multi_tab_fix")
    private final boolean pagerMultiTabFix;

    @SerializedName("dito_pager_offscreen_limit")
    private final int pagerOffscreenLimit;

    @SerializedName("dito_performance_plugin_parse_enclosing_class")
    private final boolean performancePluginParseEnclosingClass;

    @SerializedName("preset_size_cache_period")
    private final long presetSizeCachePeriod;

    @SerializedName("skip_invalid_time_check_when_target_found_retry")
    private final boolean skipInvalidTimeCheckWhenTargetFoundRetry;

    @SerializedName("try_repeat_anchor_page_switch")
    private final boolean tryRepeatAnchorPageSwitch;

    @SerializedName("use_dito_node_merge")
    private final boolean useDitoNodeMerge;

    @SerializedName("dito_nested_scroll_v2_enable")
    private final boolean useDitoRecyclerViewV2;

    public DitoSettings() {
        this.fixDragItemNotResetNestedReadyState = true;
        this.fixDitoTreeNodeInsertBug = true;
        this.useDitoRecyclerViewV2 = true;
        this.useDitoNodeMerge = true;
        this.optimizeRootPostRunnable = true;
        this.pagerOffscreenLimit = 1;
        this.pagerMultiTabFix = true;
        this.enableMoveFloatNode = true;
        this.fixParentLayoutRequested = true;
        this.presetSizeCachePeriod = 604800000;
        this.disableUsePresetHeightCacheAfterFmp = true;
        this.enableMultiSticky = true;
        this.enableFixStickOrder = true;
        this.enableOptimizeSubStickVisible = true;
        this.enableFixResetTotalScrollY = true;
        this.tryRepeatAnchorPageSwitch = true;
        this.enableViewPagerFullHeight = true;
        this.fixNestedClickError = true;
        this.decodeTrackParamsMapJsonSelf = true;
        this.enableNewStickClick = true;
        this.enableStickSubViewVariableHeight = true;
        this.fixDitoSubStickBoundary = true;
        this.enableChildInterceptScroll = true;
        this.allowJsbControlDitoScroll = true;
        this.allowResetToBottomEdgeWhenFling = true;
        this.enablePreloadDitoBodyView = true;
        this.enableMobDitoViewCreate = true;
        this.fixGroupBottomMargin = true;
        this.fixReuseViewStyle = true;
        this.fixVisibilityBottom = true;
        this.fixGroupMargin = true;
        this.optimizePostException = true;
        this.fixNegativeBottom = true;
        this.fixHalfScreenStuckOnScrollStop = true;
        this.fixOnSlideOverwriteTotalScrollY = true;
        this.enableFixStickLayoutListenerPostScroll = true;
        this.skipInvalidTimeCheckWhenTargetFoundRetry = true;
        this.fixSimpleHeadInfo = true;
    }

    public final boolean getAllowJsbControlDitoScroll() {
        return this.allowJsbControlDitoScroll;
    }

    public final boolean getAllowResetToBottomEdgeWhenFling() {
        return this.allowResetToBottomEdgeWhenFling;
    }

    public final boolean getDecodeTrackParamsMapJsonSelf() {
        return this.decodeTrackParamsMapJsonSelf;
    }

    public final boolean getDisableScrollMethodCompatible() {
        return this.disableScrollMethodCompatible;
    }

    public final boolean getDisableUsePresetHeightCacheAfterFmp() {
        return this.disableUsePresetHeightCacheAfterFmp;
    }

    public boolean getDitoMergeDataWhenEmpty() {
        return this.ditoMergeDataWhenEmpty;
    }

    public final boolean getEnableChildInterceptScroll() {
        return this.enableChildInterceptScroll;
    }

    public final boolean getEnableFixResetTotalScrollY() {
        return this.enableFixResetTotalScrollY;
    }

    public boolean getEnableFixStickLayoutListenerPostScroll() {
        return this.enableFixStickLayoutListenerPostScroll;
    }

    public final boolean getEnableFixStickOrder() {
        return this.enableFixStickOrder;
    }

    public final boolean getEnableFixTreeMapConcurrentException() {
        return this.enableFixTreeMapConcurrentException;
    }

    public final boolean getEnableMobDitoViewCreate() {
        return this.enableMobDitoViewCreate;
    }

    public final boolean getEnableMoveFloatNode() {
        return this.enableMoveFloatNode;
    }

    public final boolean getEnableMultiSticky() {
        return this.enableMultiSticky;
    }

    public final boolean getEnableNewStickClick() {
        return this.enableNewStickClick;
    }

    public final boolean getEnableOptimizeSubStickVisible() {
        return this.enableOptimizeSubStickVisible;
    }

    public final boolean getEnablePreloadDitoBodyView() {
        return this.enablePreloadDitoBodyView;
    }

    public final boolean getEnableStickSubViewVariableHeight() {
        return this.enableStickSubViewVariableHeight;
    }

    public final boolean getEnableViewPagerFullHeight() {
        return this.enableViewPagerFullHeight;
    }

    public final boolean getFixDitoSubStickBoundary() {
        return this.fixDitoSubStickBoundary;
    }

    public boolean getFixDitoTreeNodeInsertBug() {
        return this.fixDitoTreeNodeInsertBug;
    }

    public boolean getFixDragItemNotResetNestedReadyState() {
        return this.fixDragItemNotResetNestedReadyState;
    }

    public final boolean getFixGroupBottomMargin() {
        return this.fixGroupBottomMargin;
    }

    public final boolean getFixGroupMargin() {
        return this.fixGroupMargin;
    }

    public boolean getFixHalfScreenStuckOnScrollStop() {
        return this.fixHalfScreenStuckOnScrollStop;
    }

    public final boolean getFixMapValueDowngradeToString() {
        return this.fixMapValueDowngradeToString;
    }

    public final boolean getFixNegativeBottom() {
        return this.fixNegativeBottom;
    }

    public final boolean getFixNestedClickError() {
        return this.fixNestedClickError;
    }

    public final boolean getFixNestedV2ScrollError() {
        return this.fixNestedV2ScrollError;
    }

    public boolean getFixOnSlideOverwriteTotalScrollY() {
        return this.fixOnSlideOverwriteTotalScrollY;
    }

    public final boolean getFixParentLayoutRequested() {
        return this.fixParentLayoutRequested;
    }

    public final boolean getFixReuseViewStyle() {
        return this.fixReuseViewStyle;
    }

    public final boolean getFixSimpleHeadInfo() {
        return this.fixSimpleHeadInfo;
    }

    public final boolean getFixVisibilityBottom() {
        return this.fixVisibilityBottom;
    }

    public final boolean getForceShutDownSwitchLayout() {
        return this.forceShutDownSwitchLayout;
    }

    public final boolean getOptimizePostException() {
        return this.optimizePostException;
    }

    public final boolean getOptimizeRootPostRunnable() {
        return this.optimizeRootPostRunnable;
    }

    public final boolean getPagerMultiTabFix() {
        return this.pagerMultiTabFix;
    }

    public final int getPagerOffscreenLimit() {
        return this.pagerOffscreenLimit;
    }

    public boolean getPerformancePluginParseEnclosingClass() {
        return this.performancePluginParseEnclosingClass;
    }

    public final long getPresetSizeCachePeriod() {
        return this.presetSizeCachePeriod;
    }

    public final boolean getSkipInvalidTimeCheckWhenTargetFoundRetry() {
        return this.skipInvalidTimeCheckWhenTargetFoundRetry;
    }

    public final boolean getTryRepeatAnchorPageSwitch() {
        return this.tryRepeatAnchorPageSwitch;
    }

    public boolean getUseDitoNodeMerge() {
        return this.useDitoNodeMerge;
    }

    public boolean getUseDitoRecyclerViewV2() {
        return this.useDitoRecyclerViewV2;
    }

    public final void setEnableFixResetTotalScrollY(boolean r100) {
        this.enableFixResetTotalScrollY = r100;
    }

    public final void setEnableFixStickOrder(boolean r100) {
        this.enableFixStickOrder = r100;
    }

    public final void setEnableOptimizeSubStickVisible(boolean r100) {
        this.enableOptimizeSubStickVisible = r100;
    }

    public final void setEnableViewPagerFullHeight(boolean r100) {
        this.enableViewPagerFullHeight = r100;
    }

    public final void setFixNestedV2ScrollError(boolean r100) {
        this.fixNestedV2ScrollError = r100;
    }
}
