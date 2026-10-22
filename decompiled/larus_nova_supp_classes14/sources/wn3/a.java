package wn3;

import com.bytedance.android.live.ai.api.model.RechargeCacheConfig;
import com.bytedance.android.live.incentive.exchange.k;
import com.bytedance.android.live.recharge.config.CustomRechargeOneStepConfig;
import com.bytedance.android.live.recharge.config.DynamicRechargePanelConfig;
import com.bytedance.android.live.recharge.config.GemExchangeCouponConfig;
import com.bytedance.android.live.recharge.model.NoPasswordFansConfig;
import com.bytedance.android.live.recharge.model.RechargePanelDynamicConfig;
import com.bytedance.android.live.recharge.model.e;
import com.bytedance.android.live.recharge.trace.g;
import com.bytedance.android.live.recharge.utils.d;
import com.bytedance.android.live.wallet.model.f;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.bytedance.tools.kcp.ultrasettings.runtime.c;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final Type a = null;
    public static final Type b = null;

    /* JADX INFO: renamed from: wn3.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"wn3/a$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class C0180a extends TypeToken<Map<String, String>> {
        public C0180a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"wn3/a$b", "Lcom/google/gson/reflect/TypeToken;", "", "", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class b extends TypeToken<List<? extends Integer>> {
        public b() {
        }
    }

    static {
        Type r0 = new C0180a().getType();
        Intrinsics.checkNotNull(r0);
        a = r0;
        Type r1 = new b().getType();
        Intrinsics.checkNotNull(r1);
        b = r1;
    }

    @JvmStatic
    public static final void a() {
        ConcurrentHashMap r0 = UltraSettingsManager.a;
        UltraSettingsManager.b("live_recharge_panel_use_cache_data", new c("live_recharge_panel_use_cache_data", Reflection.getOrCreateKotlinClass(RechargeCacheConfig.class), "充值面板套餐缓存实验", "huangguoxiao"));
        Class r1 = Boolean.TYPE;
        UltraSettingsManager.b("diamond_buy_use_revenue_network_api", new c("diamond_buy_use_revenue_network_api", Reflection.getOrCreateKotlinClass(r1), "下单接口切换营收网络基建", "gaoshiqi"));
        Class r2 = Integer.TYPE;
        UltraSettingsManager.b("live_recharge_security_confirm_retry_behavior", new c("live_recharge_security_confirm_retry_behavior", Reflection.getOrCreateKotlinClass(r2), "用户确认充值安全提示后，重试充值时使用的行为", "zhouxinli"));
        UltraSettingsManager.b("live_recharge_panel_pad_ui_fix", new c("live_recharge_panel_pad_ui_fix", Reflection.getOrCreateKotlinClass(r1), "充值面板 PAD UI 问题修复开关", "liuliang.22"));
        UltraSettingsManager.b("live_lynx_exchange_dialog", new c("live_lynx_exchange_dialog", Reflection.getOrCreateKotlinClass(String.class), "lynx收益兑换面板", "zengjie"));
        UltraSettingsManager.b("douyin_certification_url", new c("douyin_certification_url", Reflection.getOrCreateKotlinClass(String.class), "实名认证链接", "gaoshiqi"));
        UltraSettingsManager.b("live_incentive_income_exchange_panel_scheme", new c("live_incentive_income_exchange_panel_scheme", Reflection.getOrCreateKotlinClass(String.class), "抖音余额不足兑换面板的 URI", "zhouxinli"));
        UltraSettingsManager.b("live_recharge_panel_adapt_fold_screen", new c("live_recharge_panel_adapt_fold_screen", Reflection.getOrCreateKotlinClass(r1), "充值面板适配折叠屏", "gaoshiqi"));
        UltraSettingsManager.b("live_show_income_exchange_reminder", new c("live_show_income_exchange_reminder", Reflection.getOrCreateKotlinClass(r1), "换钻石兑换提醒优化开关", "zengjie"));
        UltraSettingsManager.b("live_dynamic_recharge_panel_config", new c("live_dynamic_recharge_panel_config", Reflection.getOrCreateKotlinClass(DynamicRechargePanelConfig.class), "充值面板 setting 配置", "liuliang"));
        UltraSettingsManager.b("live_recharge_panel_background_opt", new c("live_recharge_panel_background_opt", Reflection.getOrCreateKotlinClass(r1), "充值体验优化-充值面板背景透明", "gaoshiqi"));
        UltraSettingsManager.b("live_exchange_dialog_frequency", new c("live_exchange_dialog_frequency", Reflection.getOrCreateKotlinClass(r2), "余额不足收益换钻石提示弹窗的频率优化", "daiqing.dq"));
        UltraSettingsManager.b("live_user_change_sync_disable", new c("live_user_change_sync_disable", Reflection.getOrCreateKotlinClass(r1), "禁用直播间外切换登录态刷新余额缓存", "huangguoxiao"));
        Class r3 = Long.TYPE;
        UltraSettingsManager.b("live_incentive_balance_update_rate_limit", new c("live_incentive_balance_update_rate_limit", Reflection.getOrCreateKotlinClass(r3), "抖音激励余额更新间隔频控（秒）", "zhouxinli"));
        UltraSettingsManager.b("live_recharge_recommend_dialog_url", new c("live_recharge_recommend_dialog_url", Reflection.getOrCreateKotlinClass(String.class), "充值推荐面板url", "zengjie"));
        UltraSettingsManager.b("live_recharge_fix_cj_component_height", new c("live_recharge_fix_cj_component_height", Reflection.getOrCreateKotlinClass(r1), "修复财经一步提单组件切换支付方式高度异常问题", "liuliang"));
        UltraSettingsManager.b("live_gift_panel_new_architecture", new c("live_gift_panel_new_architecture", Reflection.getOrCreateKotlinClass(k.class), "礼物面板新框架, 火山迁移礼物面板新框架屏蔽端上发送的激励余额请求", "yaozu"));
        UltraSettingsManager.b("live_cash_exchange_enable", new c("live_cash_exchange_enable", Reflection.getOrCreateKotlinClass(r1), "现金收益兑换钻石", "gaoshiqi"));
        UltraSettingsManager.b("live_base_popup_manager_enable", new c("live_base_popup_manager_enable", Reflection.getOrCreateKotlinClass(r1), "直播间气泡统一管理开关", "zengjie"));
        UltraSettingsManager.b("live_recharge_pk_msg_left_time", new c("live_recharge_pk_msg_left_time", Reflection.getOrCreateKotlinClass(r3), "pk免密支付触发倒计时", "sunshichang"));
        UltraSettingsManager.b("live_withdraw_identify_v3", new c("live_withdraw_identify_v3", Reflection.getOrCreateKotlinClass(r1), "是否启用实名3.0的开关", "gaoshiqi"));
        UltraSettingsManager.b("live_gem_exchange_coupon_config", new c("live_gem_exchange_coupon_config", Reflection.getOrCreateKotlinClass(GemExchangeCouponConfig.class), "宝石兑换券入口配置", "liuliang"));
        UltraSettingsManager.b("live_recharge_pk_diamond_limit", new c("live_recharge_pk_diamond_limit", Reflection.getOrCreateKotlinClass(r3), "pk免密支付最低充值钻石数量", "sunshichang"));
        UltraSettingsManager.b("livesdk_clientAI_preorder_enable", new c("livesdk_clientAI_preorder_enable", Reflection.getOrCreateKotlinClass(r1), "充值端智能预下单", "liuliang.22"));
        UltraSettingsManager.b("live_recharge_panel_one_step_loading_block", new c("live_recharge_panel_one_step_loading_block", Reflection.getOrCreateKotlinClass(r1), "一步提单预咨询 loading 是否屏蔽用户操作", "liuliang.22"));
        UltraSettingsManager.b("live_dylite_coupon_without_combined_pay_new", new c("live_dylite_coupon_without_combined_pay_new", Reflection.getOrCreateKotlinClass(r1), "抖极充值面板有优惠券情况不展示组合支付开关", "liuliang.22"));
        UltraSettingsManager.b("cash_exchange_frequency_config", new c("cash_exchange_frequency_config", Reflection.getOrCreateKotlinClass(d.class), "收益换钻石提示弹窗的配置，包括开关、频控(d)", "zengjie"));
        UltraSettingsManager.b("live_open_exchange_intro_schema", new c("live_open_exchange_intro_schema", Reflection.getOrCreateKotlinClass(String.class), "收益组合支付规则弹窗", "daiqing.dq"));
        UltraSettingsManager.b("live_exchange_reason_map", new c("live_exchange_reason_map", a, "doulite送礼余额不足兑换弹窗埋点gift_source转exchange_reason映射", "sunshichang"));
        UltraSettingsManager.b("live_recharge_one_step_preload_config", new c("live_recharge_one_step_preload_config", Reflection.getOrCreateKotlinClass(r3), "一步提单接口预加载配置", "liuliang.22"));
        UltraSettingsManager.b("live_recharge_pk_no_password_switch", new c("live_recharge_pk_no_password_switch", Reflection.getOrCreateKotlinClass(r1), "是否开启免密支付功能", "sunshichang"));
        UltraSettingsManager.b("live_lynx_exchange_dialog_shortcut", new c("live_lynx_exchange_dialog_shortcut", Reflection.getOrCreateKotlinClass(String.class), "快捷兑换迁移lynx收益兑换面板", "zengjie"));
        UltraSettingsManager.b("live_wallet_info_request_time", new c("live_wallet_info_request_time", Reflection.getOrCreateKotlinClass(r2), "进房时，wallet/info接口请求的时间间隔，单位是分钟", "zengjie"));
        UltraSettingsManager.b("live_recharge_fansclub_no_password_config", new c("live_recharge_fansclub_no_password_config", Reflection.getOrCreateKotlinClass(NoPasswordFansConfig.class), "粉丝团免密支付实验，直接支付/支付并加团", "gaoshiqi"));
        UltraSettingsManager.b("live_custom_recharge_one_step_config", new c("live_custom_recharge_one_step_config", Reflection.getOrCreateKotlinClass(CustomRechargeOneStepConfig.class), "自定义充值一步提单配置", "liuliang.22"));
        UltraSettingsManager.b("live_open_exchange_intro_scheme_tax_saving", new c("live_open_exchange_intro_scheme_tax_saving", Reflection.getOrCreateKotlinClass(String.class), "收益兑换命中节税链路时的规则弹窗", "zhouxinli"));
        UltraSettingsManager.b("live_diamond_notice_config", new c("live_diamond_notice_config", Reflection.getOrCreateKotlinClass(e.class), "充值面板消费提示", "huangguoxiao"));
        UltraSettingsManager.b("live_disable_old_container_recharge", new c("live_disable_old_container_recharge", Reflection.getOrCreateKotlinClass(r1), "收益兑换是否下线直播老容器", "zengjie"));
        UltraSettingsManager.b("live_recharge_pk_msg_notice_switch", new c("live_recharge_pk_msg_notice_switch", Reflection.getOrCreateKotlinClass(r1), "pk免密支付消息通知开关", "sunshichang"));
        UltraSettingsManager.b("live_recharge_api_checker_enable", new c("live_recharge_api_checker_enable", Reflection.getOrCreateKotlinClass(r1), "充值相关接口参数校验", "gaoshiqi"));
        UltraSettingsManager.b("live_incentive_income_exchange_ui_style", new c("live_incentive_income_exchange_ui_style", Reflection.getOrCreateKotlinClass(r2), "抖音余额不足兑换界面的类型：0=对照组，1=兑换弹窗，2=兑换面板", "zhouxinli"));
        UltraSettingsManager.b("live_incentives_experiment_enable", new c("live_incentives_experiment_enable", Reflection.getOrCreateKotlinClass(r1), "直播激励屏蔽实验开关", "zengjie"));
        UltraSettingsManager.b("live_recharge_pk_msg_notice_time", new c("live_recharge_pk_msg_notice_time", Reflection.getOrCreateKotlinClass(r3), "pk免密支付消息通延迟随机数", "sunshichang"));
        UltraSettingsManager.b("live_recharge_banner_use_annix", new c("live_recharge_banner_use_annix", Reflection.getOrCreateKotlinClass(r1), "充值banner使用anniex", "gaoshiqi"));
        UltraSettingsManager.b("live_wallet_log_use_event_tracker_switch", new c("live_wallet_log_use_event_tracker_switch", Reflection.getOrCreateKotlinClass(r1), "wallet log 使用 event tracker 上报开关", "liuliang"));
        UltraSettingsManager.b("live_recharge_banner_use_cache", new c("live_recharge_banner_use_cache", Reflection.getOrCreateKotlinClass(r1), "充值banner增加缓存", "gaoshiqi"));
        UltraSettingsManager.b("multiple_cert_deal", new c("multiple_cert_deal", Reflection.getOrCreateKotlinClass(f.class), "实名认证配置", "gaoshiqi"));
        UltraSettingsManager.b("live_recharge_pk_diamond_upper_limit", new c("live_recharge_pk_diamond_upper_limit", Reflection.getOrCreateKotlinClass(r3), "免密支付单笔充值上限，单位：钻石", "sunshichang"));
        UltraSettingsManager.b("live_purchase_safe_remind_schema", new c("live_purchase_safe_remind_schema", Reflection.getOrCreateKotlinClass(String.class), "充值协议", "sunshichang"));
        UltraSettingsManager.b("live_coupon_list_schema", new c("live_coupon_list_schema", Reflection.getOrCreateKotlinClass(String.class), "充值面板优惠券列表页面", "zhangjiahao"));
        UltraSettingsManager.b("live_recharge_support_one_step_pay", new c("live_recharge_support_one_step_pay", Reflection.getOrCreateKotlinClass(r1), "抖极抖火一步提单配置", "liuliang"));
        UltraSettingsManager.b("live_xigua_diamond_exchange_api", new c("live_xigua_diamond_exchange_api", Reflection.getOrCreateKotlinClass(r1), "西瓜钻石兑换抖音钻石进房接口", "gaoshiqi"));
        UltraSettingsManager.b("live_recharge_google_iap_config", new c("live_recharge_google_iap_config", Reflection.getOrCreateKotlinClass(com.bytedance.android.live.wallet.pay.iap.e.class), "充值支持iap", "gaoshiqi"));
        UltraSettingsManager.b("live_remove_wallet_useless_token", new c("live_remove_wallet_useless_token", Reflection.getOrCreateKotlinClass(r1), "移除无用 token 读取", "liuliang.22"));
        UltraSettingsManager.b("live_recharge_fail_server_exception_code_list", new c("live_recharge_fail_server_exception_code_list", b, "充值面板接口报错使用server prompt code", "gaoshiqi"));
        UltraSettingsManager.b("charge_protocol", new c("charge_protocol", Reflection.getOrCreateKotlinClass(String.class), "充值协议", "zengjie"));
        UltraSettingsManager.b("live_check_iac_financial_visable", new c("live_check_iac_financial_visable", Reflection.getOrCreateKotlinClass(r1), "check 财经能力开关", "gaoshiqi"));
        UltraSettingsManager.b("live_recharge_panel_setting_config", new c("live_recharge_panel_setting_config", Reflection.getOrCreateKotlinClass(com.bytedance.android.live.recharge.config.b.class), "充值面板右上角设置入口配置", "liuliang.22"));
        UltraSettingsManager.b("live_balance_cache_update", new c("live_balance_cache_update", Reflection.getOrCreateKotlinClass(com.bytedance.android.live.recharge.utils.b.class), "前端充值链路优化-客户端钱包余额更新实验", "huangguoxiao"));
        UltraSettingsManager.b("live_flame_redeem_enable", new c("live_flame_redeem_enable", Reflection.getOrCreateKotlinClass(r1), "火山火苗收益兑换钻石", "gaoshiqi"));
        UltraSettingsManager.b("live_exchange_diamond_process_optimization", new c("live_exchange_diamond_process_optimization", Reflection.getOrCreateKotlinClass(com.bytedance.android.live.recharge.utils.c.class), "doulite的兑换钻石流程优化", "sunshichang"));
        UltraSettingsManager.b("live_wallet_open_cj_counter_opt", new c("live_wallet_open_cj_counter_opt", Reflection.getOrCreateKotlinClass(com.bytedance.android.live.recharge.util.f.class), "收银台体验优化配置", "zengjie"));
        UltraSettingsManager.b("live_recharge_pk_auto_send_gift_new", new c("live_recharge_pk_auto_send_gift_new", Reflection.getOrCreateKotlinClass(r1), "PK免密支付后自动送出礼物，使用SendGiftParamsNew", "gaoshiqi"));
        UltraSettingsManager.b("live_recharge_dynamic_config", new c("live_recharge_dynamic_config", Reflection.getOrCreateKotlinClass(RechargePanelDynamicConfig.class), "充值面板动态化配置", "liuliang.22, zhouxinli"));
        UltraSettingsManager.b("auto_exchange_switch_on_server", new c("auto_exchange_switch_on_server", Reflection.getOrCreateKotlinClass(r1), "收益自动换钻石开关迁移服务端", "zengjie.ok"));
        UltraSettingsManager.b("live_custom_recharge_dynamic_config", new c("live_custom_recharge_dynamic_config", Reflection.getOrCreateKotlinClass(zx.a.class), "自定义充值面板动态化配置", "liuliang.22, zhouxinli"));
        UltraSettingsManager.b("live_exchange_count_down_time_request_enable", new c("live_exchange_count_down_time_request_enable", Reflection.getOrCreateKotlinClass(r1), "开关打开，进房会请求task_center/entrance接口，启动本地看播倒计时服务，用于礼物面板打开时，激励宝箱banner倒计时使用", "sunshichang"));
        UltraSettingsManager.b("live_recharge_pk_no_passwd_mock", new c("live_recharge_pk_no_passwd_mock", Reflection.getOrCreateKotlinClass(r1), "mock 充值面板 pk 免密场景", "liuliang.22"));
        UltraSettingsManager.b("live_open_treasure_box_schema", new c("live_open_treasure_box_schema", Reflection.getOrCreateKotlinClass(String.class), "宝箱toolbar打开宝石任务面板", "daiqing.dq"));
        UltraSettingsManager.b("live_incentive_income_exchange_tax_saving", new c("live_incentive_income_exchange_tax_saving", Reflection.getOrCreateKotlinClass(r2), "抖音 lite 收益兑换节税新流程", "zhouxinli"));
        UltraSettingsManager.b("h5_dialog_exchange", new c("h5_dialog_exchange", Reflection.getOrCreateKotlinClass(String.class), "充值面板兑换钻石弹窗", "zengjie"));
        UltraSettingsManager.b("live_recharge_trace_config", new c("live_recharge_trace_config", Reflection.getOrCreateKotlinClass(g.class), "充值全链路trace", "gaoshiqi"));
    }
}
