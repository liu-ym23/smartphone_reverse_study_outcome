package un3;

import com.bytedance.android.live.profit.lottery.m0;
import com.bytedance.android.live.profit.lottery.x2;
import com.bytedance.android.livesdk.config.f9;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.bytedance.tools.kcp.ultrasettings.runtime.c;
import com.google.gson.reflect.TypeToken;
import du0.d;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import wt0.e;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Type f550770a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Type f550771b = null;

    /* JADX INFO: renamed from: un3.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"un3/a$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C7901a extends TypeToken<List<? extends String>> {
        public C7901a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"un3/a$b", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/ArrayList;", "Lcom/bytedance/android/live/profit/lottery/x2;", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b extends TypeToken<ArrayList<x2>> {
        public b() {
        }
    }

    static {
        Type r100 = new C7901a().getType();
        Intrinsics.checkNotNull(r100);
        f550770a = r100;
        Type r101 = new b().getType();
        Intrinsics.checkNotNull(r101);
        f550771b = r101;
    }

    @JvmStatic
    public static final void a() {
        ConcurrentHashMap<String, c> r100 = UltraSettingsManager.f271014a;
        UltraSettingsManager.b("audience_list_lynx_scheme", new c("audience_list_lynx_scheme", Reflection.getOrCreateKotlinClass(String.class), "在线观众榜LynxScheme", "gaoshiqi"));
        UltraSettingsManager.b("live_panel_flexibly_lower_freq", new c("live_panel_flexibly_lower_freq", Reflection.getOrCreateKotlinClass(com.bytedance.android.live.profit.taskcenter.a.class), "自动拉起面板灵活降频", "daiqing.dq"));
        Class r101 = Boolean.TYPE;
        UltraSettingsManager.b("live_ban_user_card_enable", new c("live_ban_user_card_enable", Reflection.getOrCreateKotlinClass(r101), "是否开启禁止打开用户个人卡片", "Fengguangyuan"));
        UltraSettingsManager.b("live_redpacket_short_touch_use_share_view", new c("live_redpacket_short_touch_use_share_view", Reflection.getOrCreateKotlinClass(r101), "红包短触是否使用ShareView", "dangyingkai"));
        UltraSettingsManager.b("live_vip_icon_audience_opt_config", new c("live_vip_icon_audience_opt_config", Reflection.getOrCreateKotlinClass(du0.c.class), "直播观众端会员icon图标优化", "mubin"));
        UltraSettingsManager.b("live_default_avatar_urls", new c("live_default_avatar_urls", f550770a, "高风险用户红包界面默认头像url列表", "Fengguangyuan"));
        UltraSettingsManager.b("live_lottery_hot_draw_opt", new c("live_lottery_hot_draw_opt", Reflection.getOrCreateKotlinClass(r101), "高热福袋降级", "DuJie"));
        UltraSettingsManager.b("live_red_envelope_lynx_schema", new c("live_red_envelope_lynx_schema", Reflection.getOrCreateKotlinClass(String.class), "Lynx红包Schema下发", "Fengguangyuan"));
        UltraSettingsManager.b("live_send_lynx_red_envelope_enable", new c("live_send_lynx_red_envelope_enable", Reflection.getOrCreateKotlinClass(r101), "发红包页面迁移lynx开关", "Fengguangyuan"));
        UltraSettingsManager.b("live_redpacket_short_touch_entry_view_native", new c("live_redpacket_short_touch_entry_view_native", Reflection.getOrCreateKotlinClass(r101), "红包动态化中短触进场大卡动画Native开关", "Daiqing.dq"));
        UltraSettingsManager.b("live_incentive_panel_access_intelligence", new c("live_incentive_panel_access_intelligence", Reflection.getOrCreateKotlinClass(com.bytedance.android.live.profit.taskcenter.preload.b.class), "激励接口预加载", "gaoshiqi"));
        UltraSettingsManager.b("live_hour_rank_entrance_lynx_enable", new c("live_hour_rank_entrance_lynx_enable", Reflection.getOrCreateKotlinClass(r101), "小时榜入口启用Lynx", "gaoshiqi"));
        UltraSettingsManager.b("live_lynx_alpha_player_use_anniex", new c("live_lynx_alpha_player_use_anniex", Reflection.getOrCreateKotlinClass(r101), "lynx AlphaPlayer使用anniex", "null"));
        UltraSettingsManager.b("live_incentive_box_can_click", new c("live_incentive_box_can_click", Reflection.getOrCreateKotlinClass(r101), "资产区宝箱是否支持点击 true-支持点击 fasle-不支持点击", "sunshichang.crazy"));
        Class r102 = Long.TYPE;
        UltraSettingsManager.b("live_format_voice_chat_timeout_interval", new c("live_format_voice_chat_timeout_interval", Reflection.getOrCreateKotlinClass(r102), "format 连麦玩法超时兜底(单位 s)", "liuliang.22"));
        UltraSettingsManager.b("live_lynx_canvas_tt_player_enable", new c("live_lynx_canvas_tt_player_enable", Reflection.getOrCreateKotlinClass(r101), "lynx AlphaPlayer使用LiveLynxCanvasTTPlayer", "null"));
        Class r103 = Integer.TYPE;
        UltraSettingsManager.b("live_redpacket_service_lazy_load", new c("live_redpacket_service_lazy_load", Reflection.getOrCreateKotlinClass(r103), "红包动态化懒加载开关", "Daiqing.dq"));
        UltraSettingsManager.b("fansclub_subscribe_lynx_url", new c("fansclub_subscribe_lynx_url", Reflection.getOrCreateKotlinClass(du0.b.class), "粉丝团-订阅会员lynx URL 组", "Huangguoxiao"));
        UltraSettingsManager.b("live_fansclub_api_opt", new c("live_fansclub_api_opt", Reflection.getOrCreateKotlinClass(r103), "粉丝团接口进房调用优化二期", "Huangguoxiao"));
        UltraSettingsManager.b("live_ai_ohr_glod_coin_layout", new c("live_ai_ohr_glod_coin_layout", Reflection.getOrCreateKotlinClass(wt0.b.class), "直播激励宝箱根据OHR配置", "zhaozhuo.119"));
        UltraSettingsManager.b("saas_audience_list_lynx_scheme", new c("saas_audience_list_lynx_scheme", Reflection.getOrCreateKotlinClass(String.class), "saas 在线观众榜LynxScheme", "gaoshiqi"));
        UltraSettingsManager.b("fans_club_lynx_url_group", new c("fans_club_lynx_url_group", Reflection.getOrCreateKotlinClass(du0.a.class), "粉丝团 lynx URL 组", "Zhouxinli"));
        UltraSettingsManager.b("live_picked_vip_panel_photo_min_resolution", new c("live_picked_vip_panel_photo_min_resolution", Reflection.getOrCreateKotlinClass(r103), "主播自定义会员面板选择图片最小分辨率", "Zhanboyu"));
        UltraSettingsManager.b("live_enable_shorttouch_term_strategy", new c("live_enable_shorttouch_term_strategy", Reflection.getOrCreateKotlinClass(r101), "短触临态策略展示开关", "DuJie"));
        UltraSettingsManager.b("live_hour_rank_entrance_degrade_enable", new c("live_hour_rank_entrance_degrade_enable", Reflection.getOrCreateKotlinClass(r101), "小时榜入口Lynx 动画降级能力", "tiyiran"));
        UltraSettingsManager.b("live_use_vertical_rank", new c("live_use_vertical_rank", Reflection.getOrCreateKotlinClass(r101), "是否启用垂类榜单", "gaoshiqi"));
        UltraSettingsManager.b("live_red_envelope_lynx_optimize_strategy", new c("live_red_envelope_lynx_optimize_strategy", Reflection.getOrCreateKotlinClass(r103), "Lynx红包优化策略", "Fengguangyuan"));
        UltraSettingsManager.b("live_send_lynx_red_envelope_url", new c("live_send_lynx_red_envelope_url", Reflection.getOrCreateKotlinClass(String.class), "发红包页面迁移lynx Schema", "Fengguangyuan"));
        UltraSettingsManager.b("live_social_revenue_vip_config", new c("live_social_revenue_vip_config", Reflection.getOrCreateKotlinClass(d.class), "专属会员Lynx配置", "MaXiaodong.Xiaodong"));
        UltraSettingsManager.b("live_hour_rank_entrance_air_lynx_schema", new c("live_hour_rank_entrance_air_lynx_schema", Reflection.getOrCreateKotlinClass(String.class), "小时榜入口Lynx Air Schema", "gaoshiqi"));
        UltraSettingsManager.b("live_lottery_max_countdown_dismiss", new c("live_lottery_max_countdown_dismiss", Reflection.getOrCreateKotlinClass(r102), "可动态配置福袋类型的配置，最大倒计时消失福袋，兜底消息无法收到的情况，默认值1min30s", "DuJie"));
        UltraSettingsManager.b("live_ktv_singing_rank_config", new c("live_ktv_singing_rank_config", Reflection.getOrCreateKotlinClass(f9.class), "ktv单曲贡献榜和实时榜切换开关", "gaoshiqi"));
        UltraSettingsManager.b("live_format_voice_chat_use_pb", new c("live_format_voice_chat_use_pb", Reflection.getOrCreateKotlinClass(r101), "format 连麦玩法 Pb 请求开关", "liuliang.22"));
        UltraSettingsManager.b("revenue_lucky_box_short_touch_ani_schema", new c("revenue_lucky_box_short_touch_ani_schema", Reflection.getOrCreateKotlinClass(String.class), "红包短触进场大卡lynxSchema", "Daiqing.dq"));
        UltraSettingsManager.b("live_format_voice_chat_trace", new c("live_format_voice_chat_trace", Reflection.getOrCreateKotlinClass(r101), "format 连麦玩法 trace 上报开关", "liuliang.22"));
        UltraSettingsManager.b("live_task_panel_ready_timeout", new c("live_task_panel_ready_timeout", Reflection.getOrCreateKotlinClass(r102), "容器加载超时时长", "huangguoxiao"));
        UltraSettingsManager.b("live_life_lottery_config", new c("live_life_lottery_config", Reflection.getOrCreateKotlinClass(m0.a.class), "生活服务福袋抽奖配置", "Fengguangyuan"));
        UltraSettingsManager.b("live_lottery_common_config", new c("live_lottery_common_config", f550771b, "可动态配置福袋类型的配置", "DuJie"));
        UltraSettingsManager.b("live_incentive_task_roll_back", new c("live_incentive_task_roll_back", Reflection.getOrCreateKotlinClass(r101), "抖极右侧宝箱容器大小回滚开关", "daiqing.dq"));
        UltraSettingsManager.b("live_open_authorize_config", new c("live_open_authorize_config", Reflection.getOrCreateKotlinClass(e.class), "抖火授权放开的开关", "Zhouxinli"));
        UltraSettingsManager.b("live_anchor_vip_icon_opt_enable", new c("live_anchor_vip_icon_opt_enable", Reflection.getOrCreateKotlinClass(r101), "直播会员未开启状态icon图标优化", "mubin"));
        UltraSettingsManager.b("live_guide_ai_title_group", new c("live_guide_ai_title_group", Reflection.getOrCreateKotlinClass(r103), "AI标题ab实验开关", "daiqing.dq"));
        UltraSettingsManager.b("live_lottery_sti_finish_webp_url", new c("live_lottery_sti_finish_webp_url", Reflection.getOrCreateKotlinClass(String.class), "福袋开奖WEBP动画URL", "Zhouxinli"));
        UltraSettingsManager.b("live_enable_anchor_info_common_vip", new c("live_enable_anchor_info_common_vip", Reflection.getOrCreateKotlinClass(r101), "是否允许展示通用会员入口", "Qiuyitao"));
        UltraSettingsManager.b("send_red_envelope_url", new c("send_red_envelope_url", Reflection.getOrCreateKotlinClass(String.class), "WebView 使用 native 图片库加载图片资源开关", "Zhouxinli"));
        UltraSettingsManager.b("live_red_packet_rule_page", new c("live_red_packet_rule_page", Reflection.getOrCreateKotlinClass(String.class), "红包结果页规则说明入口", "Fengguangyuan"));
        UltraSettingsManager.b("live_join_fansclub_guide", new c("live_join_fansclub_guide", Reflection.getOrCreateKotlinClass(r103), "粉丝团引导动画实验：0=无引导，1=优化动画+放开频控，2=关注后打开加团面板", "dangyingkai"));
        UltraSettingsManager.b("audience_list_rl3_router_enabled", new c("audience_list_rl3_router_enabled", Reflection.getOrCreateKotlinClass(r103), "krossRouterV2打开观众榜", "null"));
        UltraSettingsManager.b("live_format_voice_chat_bluetooth_permission_check", new c("live_format_voice_chat_bluetooth_permission_check", Reflection.getOrCreateKotlinClass(r101), "format 连麦玩法蓝牙权限申请开关", "liuliang.22"));
        UltraSettingsManager.b("live_lottery_localinfo_cache_enable", new c("live_lottery_localinfo_cache_enable", Reflection.getOrCreateKotlinClass(r101), "福袋业务的一些本地存储信息", "DuJie"));
        UltraSettingsManager.b("live_enable_follow_status_use_local_db", new c("live_enable_follow_status_use_local_db", Reflection.getOrCreateKotlinClass(r101), "关注状态发生错误时是否使用兜底IM数据库", "Renaoying"));
        UltraSettingsManager.b("revenue_lucky_box_short_touch_share_view_url", new c("revenue_lucky_box_short_touch_share_view_url", Reflection.getOrCreateKotlinClass(String.class), "红包短触shareview url", "dangyingkai"));
        UltraSettingsManager.b("live_fans_group_url", new c("live_fans_group_url", Reflection.getOrCreateKotlinClass(String.class), "抖音火山粉丝团url", "Huangguoxiao"));
        UltraSettingsManager.b("red_packet_opt_style_2", new c("red_packet_opt_style_2", Reflection.getOrCreateKotlinClass(r103), "红包相关逻辑调整（补充需求）", "Zhouxinli"));
        UltraSettingsManager.b("live_rank_score_degrade_config", new c("live_rank_score_degrade_config", Reflection.getOrCreateKotlinClass(op2.b.class), "榜单低端机降级配置", "gaoshiqi"));
        UltraSettingsManager.b("live_shop_fans_club_anchor_click_enable", new c("live_shop_fans_club_anchor_click_enable", Reflection.getOrCreateKotlinClass(r101), "购物粉丝团主播点击开关", "Zhanboyu"));
        UltraSettingsManager.b("live_fans_group_anchor_url", new c("live_fans_group_anchor_url", Reflection.getOrCreateKotlinClass(String.class), "抖音火山主播粉丝团url", "Huangguoxiao"));
        UltraSettingsManager.b("live_guard_high_level", new c("live_guard_high_level", Reflection.getOrCreateKotlinClass(r103), "星守护高等级", "Huangguoxiao"));
        UltraSettingsManager.b("live_hour_rank_entrance_lynx_schema", new c("live_hour_rank_entrance_lynx_schema", Reflection.getOrCreateKotlinClass(String.class), "小时榜入口Lynx Schema", "gaoshiqi"));
        UltraSettingsManager.b("revenue_lucky_box_short_touch_schema", new c("revenue_lucky_box_short_touch_schema", Reflection.getOrCreateKotlinClass(String.class), "红包短触lynxSchema", "Daiqing.dq"));
        UltraSettingsManager.b("live_incentive_box_with_anniex", new c("live_incentive_box_with_anniex", Reflection.getOrCreateKotlinClass(r101), "抖极右侧宝箱容器接入annieX  true-接入  false-不接入", "sunshichang.crazy"));
        UltraSettingsManager.b("live_ecom_fansclub_enable", new c("live_ecom_fansclub_enable", Reflection.getOrCreateKotlinClass(r101), "粉丝团反转实验", "yaozu"));
        UltraSettingsManager.b("live_enable_update_balance_fans_join", new c("live_enable_update_balance_fans_join", Reflection.getOrCreateKotlinClass(r101), "加团后是否使用消息里的余额去更新用户钱包余额缓存", "huangguoxiao"));
        UltraSettingsManager.b("live_fansclub_group_panel", new c("live_fansclub_group_panel", Reflection.getOrCreateKotlinClass(String.class), "团播粉丝团选人面板", "Huangguoxiao"));
        UltraSettingsManager.b("live_lynx_alphaplayer_destroy_delay", new c("live_lynx_alphaplayer_destroy_delay", Reflection.getOrCreateKotlinClass(r102), "播放完成后的释放延迟，为0时立即释放（单位：毫秒）", "null"));
        UltraSettingsManager.b("live_lottery_draw_bigcard_fix", new c("live_lottery_draw_bigcard_fix", Reflection.getOrCreateKotlinClass(r101), "福袋结束打开偶现出现fix", "DuJie"));
        UltraSettingsManager.b("live_audience_list_opt", new c("live_audience_list_opt", Reflection.getOrCreateKotlinClass(op2.a.class), "在线观众榜性能优化实验配置", "gaoshiqi"));
        UltraSettingsManager.b("red_packet_count_down_behavior", new c("red_packet_count_down_behavior", Reflection.getOrCreateKotlinClass(r103), "Android红包倒计时行为", "Zhouxinli"));
        UltraSettingsManager.b("live_lottery_drawing_dialog_fix", new c("live_lottery_drawing_dialog_fix", Reflection.getOrCreateKotlinClass(r101), "福袋结束不开奖fix", "DuJie"));
        UltraSettingsManager.b("live_format_voice_chat_rtc_config", new c("live_format_voice_chat_rtc_config", Reflection.getOrCreateKotlinClass(iu0.a.class), "format 连麦玩法 RTC 配置", "liuliang.22"));
        UltraSettingsManager.b("live_lynx_alphaplayer_schema", new c("live_lynx_alphaplayer_schema", Reflection.getOrCreateKotlinClass(String.class), "lynx alphaplayer的schema", "null"));
        UltraSettingsManager.b("live_incentive_panel_feedback_opt", new c("live_incentive_panel_feedback_opt", Reflection.getOrCreateKotlinClass(com.bytedance.android.live.profit.taskcenter.d.class), "误触反馈优化", "daiqing.dq"));
        UltraSettingsManager.b("live_temp_short_touch_count_down_trigger_time", new c("live_temp_short_touch_count_down_trigger_time", Reflection.getOrCreateKotlinClass(r103), "临态策略3展示倒计时触发值", "Fengguangyuan"));
        UltraSettingsManager.b("live_accessibility_type_announcement_opt", new c("live_accessibility_type_announcement_opt", Reflection.getOrCreateKotlinClass(r101), "Android 16 无障碍优化", "Caoyanming"));
        UltraSettingsManager.b("live_format_voice_chat_think_duration", new c("live_format_voice_chat_think_duration", Reflection.getOrCreateKotlinClass(r102), "format 连麦玩法 AI 思考超过配置出 tip", "liuliang"));
        UltraSettingsManager.b("live_lottery_config", new c("live_lottery_config", Reflection.getOrCreateKotlinClass(m0.class), "中台抽奖配置", "Zhouxinli"));
        UltraSettingsManager.b("live_lottery_draw_result_delay", new c("live_lottery_draw_result_delay", Reflection.getOrCreateKotlinClass(r102), "福袋开奖置空delay", "DuJie"));
        UltraSettingsManager.b("live_format_voice_chat_rule_url", new c("live_format_voice_chat_rule_url", Reflection.getOrCreateKotlinClass(String.class), "format 连麦玩法规则页 Lynx scheme", "liuliang.22"));
        UltraSettingsManager.b("live_hour_rank_entrance_use_annix", new c("live_hour_rank_entrance_use_annix", Reflection.getOrCreateKotlinClass(r101), "小时榜入口使用 AnnieX", "gaoshiqi"));
        UltraSettingsManager.b("live_red_packet_rush_optimize", new c("live_red_packet_rush_optimize", Reflection.getOrCreateKotlinClass(r103), "抢红包体验优化开关", "Fengguangyuan"));
        UltraSettingsManager.b("fansclub_vip_split_enable", new c("fansclub_vip_split_enable", Reflection.getOrCreateKotlinClass(r101), "粉丝团-订阅会员创作者Tab拆分", "MaXiaodong.Xiaodong"));
        UltraSettingsManager.b("live_task_panel_lifetime_limit_enable", new c("live_task_panel_lifetime_limit_enable", Reflection.getOrCreateKotlinClass(r101), "活动周期频控检测开关", "huangguoxiao"));
        UltraSettingsManager.b("live_task_panel_daily_limit_enable", new c("live_task_panel_daily_limit_enable", Reflection.getOrCreateKotlinClass(r101), "日常频控检测开关", "huangguoxiao"));
        UltraSettingsManager.b("live_lottery_atmosphere", new c("live_lottery_atmosphere", Reflection.getOrCreateKotlinClass(r101), "福袋氛围开关", "DuJie"));
        UltraSettingsManager.b("live_fix_userinfo_follow", new c("live_fix_userinfo_follow", Reflection.getOrCreateKotlinClass(r101), "修复关注状态不一致问题", "Lidegui"));
        UltraSettingsManager.b("live_format_voice_chat_anim_delay", new c("live_format_voice_chat_anim_delay", Reflection.getOrCreateKotlinClass(r102), "format 连麦玩法动画 delay 时间（单位 ms）", "null"));
        UltraSettingsManager.b("live_lottery_drawing_disappearable", new c("live_lottery_drawing_disappearable", Reflection.getOrCreateKotlinClass(r101), "可动态配置福袋类型的配置，开奖是否消失福袋", "DuJie"));
    }
}
