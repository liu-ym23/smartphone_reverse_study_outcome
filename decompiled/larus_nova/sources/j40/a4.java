package j40;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.android.livesdk.config.LiveInitSettingKeys;
import com.bytedance.android.livesdk.config.d51;
import com.bytedance.android.livesdk.config.e51;
import com.bytedance.android.livesdk.config.ne1;
import com.bytedance.android.livesdk.config.p5;
import com.bytedance.android.livesdkapi.model.DislikeConfig;
import com.huawei.hms.android.SystemUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: loaded from: classes45.dex */
public interface a4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SettingKey<Boolean> f497168a = null;

    static {
        Boolean r100 = Boolean.TRUE;
        new SettingKey("red_dot_rule_switch", r100, "黄点规范开关");
        new SettingKey("live_popup_strategy_setting_enable", "直播气泡管理策略添加功能开关", r100, r100, new String[]{"true:开启", "false:关闭"});
        new SettingKey("match_room_land_animutil_listen_focuschange", "赛事直播间横屏动画压缩工具是否监听焦点变化并兜底", r100, r100);
        new SettingKey("live_popup_service_enable", "面板下拉关闭功能开关", r100, r100);
        new SettingKey("multi_anchor_team_pk_pad_show_opt_for_guest", "主播连线组队PK观众端pad展示优化", r100, r100);
        new SettingKey(LiveInitSettingKeys.LIVE_PAD_SETTING_MOCK, "pad 的setting 模拟", 0, 0);
        new SettingKey("live_fold_screen_device_manufacture_list", "折叠屏机型白名单", Arrays.asList(new String[]{"SAMSUNG", SystemUtils.PRODUCT_HONOR, "VIVO"}), new ArrayList());
        new SettingKey("live_fold_screen_device_list", "折叠屏设备白名单", new p5(), new p5());
        new SettingKey("live_huawei_fold_screen_device_list", "华为折叠屏设备白名单", Arrays.asList(new String[]{"RLI-AN00", "TAH-AN00m", "TAH-AN00", "TAH-N29", "TAH-N29m", "RLI-N29", "RHA-AN00m", "RHA-N29m"}), new ArrayList());
        new SettingKey("live_samsung_fold_screen_device_list", "三星折叠屏设备白名单", Arrays.asList(new String[0]), new ArrayList());
        new SettingKey("live_ecommerce_818_anchor_list", Collections.singletonList(LiveConfigSettingKeys.DOUYIN_SHOP_OFFICIAL_ANCHOR_ID), "横屏新版布局样式的主播白名单");
        Boolean r101 = Boolean.FALSE;
        new SettingKey("live_landscape_support_more_live_drawer", "直播横屏更多直播入口", r101, r101);
        new SettingKey("live_landscape_opt_config_v2", "横屏体验优化配置V2", new e51(), new e51());
        new SettingKey("live_landscape_opt_config", "横屏体验框架优化配置", new d51(), new d51());
        f497168a = new SettingKey("live_sdk_view_nita", "直播接入view预加载框架nita", r101, r101);
        new SettingKey("live_landscape_performance_monitor", "直播横屏场景性能指标监控", 10, 0);
        new SettingKey("live_red_dot_show_version_duration", 3, "升级app黄点规范版本限制");
        new SettingKey("live_red_dot_show_version_duration_for_install", 1, "新安装app黄点规范版本限制");
        new SettingKey("ttlive_public_screen_edge_enable_offscreen_render", "公屏区礼物托盘遮罩启用离屏渲染", r100, r100);
        new SettingKey("ttlive_anchor_share_mini_app_release_sensitive_permission", "直播分享小程序时释放合规权限", r100, r100);
        new SettingKey("live_anchor_perception_of_fans_badge_enable", "主播粉丝看播感知-是否展示朋友/粉丝勋章", r101, r101);
        new SettingKey("live_anchor_pause_log_depth", "主播暂停日志记录深度", 0, 0);
        new SettingKey("live_follow_anchorself_enable", "主播观看自己直播间，不展示关注按钮", r101, r101);
        new SettingKey("live_enable_team_fight_video_toolbar", "视频团战toolbar入口开关", r101, r101);
        new SettingKey("live_enable_team_fight_audio_toolbar", "语音团战toolbar入口开关", r101, r101);
        new SettingKey("live_new_gift_score_interact_view", "麦位礼物分值是否使用新的互动view兜底开关", r100, r100);
        new SettingKey("enable_resizable_image", "启用resizable-imageloader", r100, r100);
        new SettingKey("enable_resizable_recycle_bitmap", "启用resizable-imageloader bitmap回收", r100, r100);
        new SettingKey("live_long_press_dislike", "直播间满意度反馈相关配置", new DislikeConfig(), new DislikeConfig());
        new SettingKey("live_switch_button_no_barriar", "继承LiveSwitchButton的View无障碍适配", r100, r100);
        new SettingKey("live_strategy_forbidden_factor_setting", "策略SDK禁止上报因子配置", new String[0], new String[0]);
        new SettingKey("live_strategy_filter_config", "策略埋点过滤配置", new HashMap(), new HashMap());
        new SettingKey("live_strategy_filter_config_v2", "策略埋点过滤配置V2", new HashMap(), new HashMap());
        new SettingKey("live_strategy_detail_log_filter", "策略ID列表过滤配置", new String[0], new String[0]);
        new SettingKey("live_strategy_update_report_enable", "策略平台监听日志上报", r101, r101);
        new SettingKey("live_handle_log_interval", "策略SDK监控handle处理耗时日志上报", 300000L, 300000L);
        new SettingKey("star_wish_open_panel_schema", "星愿瓶玩法开启面板schema", "sslocal://webcast_lynxview?type=popup&gravity=bottom&height=454&radius=20&disable_input_scroll=1&url=https%3A%2F%2Flf-dy-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Fdynamic_star_wish_lynx_douyin%2Fpages%2Fstar_wish_open_panel%2Ftemplate.js%3Fbusiness_type%3DstarWish", "sslocal://webcast_lynxview?type=popup&gravity=bottom&height=454&radius=20&disable_input_scroll=1&url=https%3A%2F%2Flf-dy-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Fdynamic_star_wish_lynx_douyin%2Fpages%2Fstar_wish_open_panel%2Ftemplate.js%3Fbusiness_type%3DstarWish");
        new SettingKey("live_privilege_resolution_anime", "权益清晰度切换动画", new ne1(), new ne1());
        new SettingKey("live_paid_scope_lazy_init", "付费Scope服务按需加载", r100, r100);
    }
}
