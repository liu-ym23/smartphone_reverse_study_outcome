package zn3;

import com.bytedance.android.live.revlink.impl.utils.b0;
import com.bytedance.android.livesdk.config.vf1;
import com.bytedance.android.livesdk.config.xf1;
import com.bytedance.android.livesdk.model.o0;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import r11.o;
import r11.p;
import r11.r;
import r11.s;
import r11.t;
import r11.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final Type a = null;
    public static final Type b = null;
    public static final Type c = null;
    public static final Type d = null;
    public static final Type e = null;
    public static final Type f = null;
    public static final Type g = null;
    public static final Type h = null;
    public static final Type i = null;
    public static final Type j = null;
    public static final Type k = null;
    public static final Type l = null;
    public static final Type m = null;
    public static final Type n = null;

    /* JADX INFO: renamed from: zn3.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"zn3/a$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class C0194a extends TypeToken<Integer[]> {
        public C0194a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"zn3/a$b", "Lcom/google/gson/reflect/TypeToken;", "", "", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class b extends TypeToken<String[]> {
        public b() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"zn3/a$c", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class c extends TypeToken<Map<Integer, ? extends String>> {
        public c() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"zn3/a$d", "Lcom/google/gson/reflect/TypeToken;", "", "", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class d extends TypeToken<List<? extends Integer>> {
        public d() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"zn3/a$e", "Lcom/google/gson/reflect/TypeToken;", "", "", "Lr41/d;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class e extends TypeToken<Map<Long, ? extends r41.d>> {
        public e() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"zn3/a$f", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class f extends TypeToken<HashMap<String, String>> {
        public f() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001¨\u0006\u0005"}, d2 = {"zn3/a$g", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class g extends TypeToken<Map<Float, ? extends String>> {
        public g() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"zn3/a$h", "Lcom/google/gson/reflect/TypeToken;", "", "", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class h extends TypeToken<Map<Integer, ? extends Integer>> {
        public h() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"zn3/a$i", "Lcom/google/gson/reflect/TypeToken;", "", "", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class i extends TypeToken<String[]> {
        public i() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"zn3/a$j", "Lcom/google/gson/reflect/TypeToken;", "", "", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class j extends TypeToken<Integer[]> {
        public j() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"zn3/a$k", "Lcom/google/gson/reflect/TypeToken;", "", "", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class k extends TypeToken<Integer[]> {
        public k() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"zn3/a$l", "Lcom/google/gson/reflect/TypeToken;", "", "", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class l extends TypeToken<Integer[]> {
        public l() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"zn3/a$m", "Lcom/google/gson/reflect/TypeToken;", "", "", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class m extends TypeToken<Integer[]> {
        public m() {
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"zn3/a$n", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/HashMap;", "", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class n extends TypeToken<HashMap<String, String>> {
        public n() {
        }
    }

    static {
        Type r0 = new f().getType();
        Intrinsics.checkNotNull(r0);
        a = r0;
        Type r1 = new m().getType();
        Intrinsics.checkNotNull(r1);
        b = r1;
        Type r2 = new i().getType();
        Intrinsics.checkNotNull(r2);
        c = r2;
        Type r3 = new k().getType();
        Intrinsics.checkNotNull(r3);
        d = r3;
        Type r4 = new j().getType();
        Intrinsics.checkNotNull(r4);
        e = r4;
        Type r5 = new g().getType();
        Intrinsics.checkNotNull(r5);
        f = r5;
        Type r6 = new d().getType();
        Intrinsics.checkNotNull(r6);
        g = r6;
        Type r7 = new c().getType();
        Intrinsics.checkNotNull(r7);
        h = r7;
        Type r8 = new C0194a().getType();
        Intrinsics.checkNotNull(r8);
        i = r8;
        Type r9 = new l().getType();
        Intrinsics.checkNotNull(r9);
        j = r9;
        Type r10 = new n().getType();
        Intrinsics.checkNotNull(r10);
        k = r10;
        Type r11 = new b().getType();
        Intrinsics.checkNotNull(r11);
        l = r11;
        Type r12 = new h().getType();
        Intrinsics.checkNotNull(r12);
        m = r12;
        Type r13 = new e().getType();
        Intrinsics.checkNotNull(r13);
        n = r13;
    }

    @JvmStatic
    public static final void a() {
        ConcurrentHashMap r0 = UltraSettingsManager.a;
        Class r1 = Boolean.TYPE;
        UltraSettingsManager.b("live_check_json_switch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_check_json_switch", Reflection.getOrCreateKotlinClass(r1), "直播校验json兜底开关", "null"));
        UltraSettingsManager.b("live_link_feed_pk_bg_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_feed_pk_bg_enable", Reflection.getOrCreateKotlinClass(r1), "预览流双人pk背景贴图", "null"));
        UltraSettingsManager.b("live_multi_preview_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_preview_enable", Reflection.getOrCreateKotlinClass(r1), "多人PK预览开关", "null"));
        UltraSettingsManager.b("live_multi_person_pk_bar_block_report", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_person_pk_bar_block_report", Reflection.getOrCreateKotlinClass(r1), "个人战血条防无法点击反馈防御开关", "null"));
        UltraSettingsManager.b("live_multi_link_self_anchor_pause_fix_disable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_self_anchor_pause_fix_disable", Reflection.getOrCreateKotlinClass(r1), "主播连线偶现自端主播离开中判断错误", "null"));
        UltraSettingsManager.b("live_pk_enable_feed_back_toast", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_enable_feed_back_toast", Reflection.getOrCreateKotlinClass(r1), "是否启用反馈提示", "null"));
        UltraSettingsManager.b("live_multilinker_double_resolution_optimize", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multilinker_double_resolution_optimize", Reflection.getOrCreateKotlinClass(r1), "双人主播连线是否开启分辨率9:13优化", "null"));
        UltraSettingsManager.b("multi_revenue_async_xml", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_revenue_async_xml", Reflection.getOrCreateKotlinClass(r1), "营收场景主播连麦异步inflate xml", "null"));
        UltraSettingsManager.b("pk_task_score_webp", new com.bytedance.tools.kcp.ultrasettings.runtime.c("pk_task_score_webp", a, "PK任务动画类型配置", "null"));
        UltraSettingsManager.b("rev_link_sei_check_stop", new com.bytedance.tools.kcp.ultrasettings.runtime.c("rev_link_sei_check_stop", Reflection.getOrCreateKotlinClass(r1), "SEI兜底停止逻辑开关", "null"));
        UltraSettingsManager.b("live_pk_denoise_bottom_bg_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_denoise_bottom_bg_url", Reflection.getOrCreateKotlinClass(String.class), "降噪后的pk观众端底部背景图", "null"));
        UltraSettingsManager.b("live_pk_hybrid_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_hybrid_url", Reflection.getOrCreateKotlinClass(String.class), "PK lynx scheme", "null"));
        UltraSettingsManager.b("multi_anchor_enter_duration_check_log", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_anchor_enter_duration_check_log", Reflection.getOrCreateKotlinClass(r1), "多人主播连线观众端进房耗时上报频控", "null"));
        Class r2 = Long.TYPE;
        UltraSettingsManager.b("relink_intercept_rtc_leave_kickout_duration", new com.bytedance.tools.kcp.ultrasettings.runtime.c("relink_intercept_rtc_leave_kickout_duration", Reflection.getOrCreateKotlinClass(r2), "重连建联中拦截RTC leave踢人时间段长度", "null"));
        UltraSettingsManager.b("multi_bg_monitor_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_bg_monitor_config", Reflection.getOrCreateKotlinClass(com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager.a.class), "multi背景异常调用监控配置", "null"));
        UltraSettingsManager.b("multi_anchor_leave_link_refactor_disable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_anchor_leave_link_refactor_disable", Reflection.getOrCreateKotlinClass(r1), "多人主播连线断开流程走原逻辑", "null"));
        UltraSettingsManager.b("live_anchor_linking_invite_preload_strategy", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_anchor_linking_invite_preload_strategy", Reflection.getOrCreateKotlinClass(r11.d.class), "连线中邀请推荐列表预加载策略", "null"));
        Class r3 = Integer.TYPE;
        UltraSettingsManager.b("live_pk_show_reddot", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_show_reddot", Reflection.getOrCreateKotlinClass(r3), "主播ToolBar PK红点展示配置", "null"));
        UltraSettingsManager.b("live_rev_block_domain_link_mic_list_request", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rev_block_domain_link_mic_list_request", Reflection.getOrCreateKotlinClass(r1), "block domain linkmic/list request", "null"));
        UltraSettingsManager.b("live_pk_audience_get_opposite_anchor_linkmic_id", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_audience_get_opposite_anchor_linkmic_id", Reflection.getOrCreateKotlinClass(r1), "PK嘉宾侧获取对面主播连麦id", "null"));
        UltraSettingsManager.b("live_pk_preview_stream_support_dynamic_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_preview_stream_support_dynamic_enable", Reflection.getOrCreateKotlinClass(r1), "连屏预览流PK控制中枢加载", "null"));
        UltraSettingsManager.b("live_invite_more_panel_lynx_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_invite_more_panel_lynx_url", Reflection.getOrCreateKotlinClass(String.class), "连屏邀请更多面板lynx url", "null"));
        UltraSettingsManager.b("multi_link_use_reply_linked_users", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_use_reply_linked_users", Reflection.getOrCreateKotlinClass(r1), "主播连线消费reply接口和消息的linkedUsers", "null"));
        UltraSettingsManager.b("multi_link_video_mix_planar_render", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_video_mix_planar_render", Reflection.getOrCreateKotlinClass(r1), "VideoMix平面模式优化开关", "null"));
        UltraSettingsManager.b("enable_live_pk", new com.bytedance.tools.kcp.ultrasettings.runtime.c("enable_live_pk", Reflection.getOrCreateKotlinClass(r1), "是否开启PK", "null"));
        UltraSettingsManager.b("revlink_audience_report_illegal_pk_layout", new com.bytedance.tools.kcp.ultrasettings.runtime.c("revlink_audience_report_illegal_pk_layout", Reflection.getOrCreateKotlinClass(r1), "是否上报illegal_pk_layout监控", "null"));
        UltraSettingsManager.b("live_multi_battle_count_down_back_up", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_battle_count_down_back_up", Reflection.getOrCreateKotlinClass(r1), "多人PK倒计时 兜底开关", "null"));
        UltraSettingsManager.b("live_flex_activity_entrance", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_flex_activity_entrance", Reflection.getOrCreateKotlinClass(r3), "灵活运营主播连屏", "null"));
        UltraSettingsManager.b("pk_measure_opt_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("pk_measure_opt_config", Reflection.getOrCreateKotlinClass(a51.a.class), "PK measure优化", "null"));
        UltraSettingsManager.b("live_pk_panel_follow_s", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_panel_follow_s", Reflection.getOrCreateKotlinClass(o.class), "pk面板异步加载开关-刷新关注", "null"));
        UltraSettingsManager.b("live_pk_steal_dragon_setting_show", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_steal_dragon_setting_show", Reflection.getOrCreateKotlinClass(r1), "启动抢龙玩法设置开关", "null"));
        UltraSettingsManager.b("pk_test_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("pk_test_time", Reflection.getOrCreateKotlinClass(r1), "开启 10s,30s,60s,90s PK时间", "null"));
        UltraSettingsManager.b("revenue_link_jank_opt_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("revenue_link_jank_opt_config", Reflection.getOrCreateKotlinClass(a51.c.class), "连屏场景卡顿优化开关", "null"));
        UltraSettingsManager.b("live_pk_lynx_control_native_view_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_lynx_control_native_view_enable", Reflection.getOrCreateKotlinClass(r1), "PK是否通过Lynx控制Native组件加载", "null"));
        UltraSettingsManager.b("live_multi_link_missing_frame_check_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_missing_frame_check_time", Reflection.getOrCreateKotlinClass(r2), "未收到首帧校验的定时器时长", "null"));
        UltraSettingsManager.b("pk_sei_switch_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("pk_sei_switch_config", Reflection.getOrCreateKotlinClass(b0.class), "PK场景SEI兜底逻辑配置", "null"));
        UltraSettingsManager.b("live_pk_privacy_hint", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_privacy_hint", Reflection.getOrCreateKotlinClass(String.class), "pk 连线隐私态提示文案", "null"));
        UltraSettingsManager.b("live_pk_cloud_opt_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_cloud_opt_enable", Reflection.getOrCreateKotlinClass(r1), "兜底优化pk限时竞争卡顿优化", "null"));
        UltraSettingsManager.b("live_pk_enable_panel_list_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_enable_panel_list_opt", Reflection.getOrCreateKotlinClass(r1), "连屏玩法面板是否使用新面板", "null"));
        UltraSettingsManager.b("multi_revenue_double_enter_room_call_trace", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_revenue_double_enter_room_call_trace", Reflection.getOrCreateKotlinClass(r1), "营收场景主播连线double进房请求 兜底 上报trace", "null"));
        UltraSettingsManager.b("live_anchor_link_block_concurrent_apply", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_anchor_link_block_concurrent_apply", Reflection.getOrCreateKotlinClass(r1), "连线面板并发申请事件", "null"));
        UltraSettingsManager.b("multi_revenue_super_preload", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_revenue_super_preload", Reflection.getOrCreateKotlinClass(r1), "超级超级预加载", "null"));
        UltraSettingsManager.b("live_anchor_top_banner_lynx_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_anchor_top_banner_lynx_url", Reflection.getOrCreateKotlinClass(String.class), "连线 顶部banner Lynx地址", "null"));
        UltraSettingsManager.b("live_rev_control_widget_auto_unload_monitor", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rev_control_widget_auto_unload_monitor", Reflection.getOrCreateKotlinClass(r1), "LinkRevControlWidget自动卸载mode 监控", "null"));
        UltraSettingsManager.b("live_screen_record_judge_live_core_param", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_screen_record_judge_live_core_param", Reflection.getOrCreateKotlinClass(r1), "录屏场景是否调整liveCore参数", "null"));
        UltraSettingsManager.b("live_pk_invite_msg_at_least_available_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_invite_msg_at_least_available_time", Reflection.getOrCreateKotlinClass(r2), "PK建联消息最少剩余有效时长s", "null"));
        UltraSettingsManager.b("live_pk_enable_lynx_interact_comment", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_enable_lynx_interact_comment", Reflection.getOrCreateKotlinClass(r1), "双人pk连线层视图是否用lynx评论互通", "null"));
        UltraSettingsManager.b("enable_linker_partner_sei_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("enable_linker_partner_sei_enable", Reflection.getOrCreateKotlinClass(r1), "是否开启观众侧合演看播sei处理", "null"));
        UltraSettingsManager.b("live_rank_season_pk_random_match_notice", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rank_season_pk_random_match_notice", Reflection.getOrCreateKotlinClass(r1), "巅峰赛随机PK接入直播匹配须知", "null"));
        UltraSettingsManager.b("multi_anchor_enlarge_count_control", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_anchor_enlarge_count_control", b, "在几位主播连线下允许开启主播放大功能", "null"));
        UltraSettingsManager.b("live_anchor_list_panel_preload_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_anchor_list_panel_preload_enable", Reflection.getOrCreateKotlinClass(r1), "主播连线列表预加载开关", "null"));
        UltraSettingsManager.b("live_rev_link_page_lazy_load", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rev_link_page_lazy_load", Reflection.getOrCreateKotlinClass(r1), "页面懒加载", "null"));
        UltraSettingsManager.b("live_multi_battle_finish_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_battle_finish_opt", Reflection.getOrCreateKotlinClass(r1), "多人PK battle finish优化主播开关", "null"));
        UltraSettingsManager.b("live_pk_multi_init_show_last_battle_result", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_multi_init_show_last_battle_result", Reflection.getOrCreateKotlinClass(r1), "PK转连线初始化上局结果展示开关", "null"));
        UltraSettingsManager.b("live_rev_link_game", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rev_link_game", Reflection.getOrCreateKotlinClass(p41.a.class), "连屏游戏相关配置", "null"));
        UltraSettingsManager.b("video_talk_and_pk_switch_widget_load_unload_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("video_talk_and_pk_switch_widget_load_unload_enable", Reflection.getOrCreateKotlinClass(r1), "浮窗与pk互切，建联时是否同时卸载多人组件，建联失败时是否再加载多人组件", "null"));
        UltraSettingsManager.b("rev_async_background_control", new com.bytedance.tools.kcp.ultrasettings.runtime.c("rev_async_background_control", Reflection.getOrCreateKotlinClass(r1), "rev async background", "null"));
        UltraSettingsManager.b("live_rev_scene_merge_switch_to_pk_before_battle_open", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rev_scene_merge_switch_to_pk_before_battle_open", Reflection.getOrCreateKotlinClass(r1), "scene合并 battleOpen前先转到PK", "null"));
        UltraSettingsManager.b("live_rev_player_block_multi_event", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rev_player_block_multi_event", Reflection.getOrCreateKotlinClass(r1), "布局不消费业务布局事件", "null"));
        UltraSettingsManager.b("live_rev_reply_cache_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rev_reply_cache_enable", Reflection.getOrCreateKotlinClass(r1), "scene合并建联链路是否缓存reply消息", "null"));
        UltraSettingsManager.b("live_pk_enable_lynx_double_link_score", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_enable_lynx_double_link_score", Reflection.getOrCreateKotlinClass(r1), "双人pk连线层视图是否用lynx，包括评论互通、连线计值、协作动画", "null"));
        UltraSettingsManager.b("check_sei_valid_by_string", new com.bytedance.tools.kcp.ultrasettings.runtime.c("check_sei_valid_by_string", Reflection.getOrCreateKotlinClass(r1), "通过string确认sei有效性", "null"));
        UltraSettingsManager.b("live_revenue_interact_panel_season_tab_name", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_revenue_interact_panel_season_tab_name", Reflection.getOrCreateKotlinClass(String.class), "主播段位赛名字", "null"));
        Class r4 = Float.TYPE;
        UltraSettingsManager.b("live_pk_chorus_performance_limit", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_chorus_performance_limit", Reflection.getOrCreateKotlinClass(r4), "PK连线开启合唱玩法最低机型打分要求", "null"));
        UltraSettingsManager.b("live_pk_guest_not_consume_sei_backup", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_guest_not_consume_sei_backup", Reflection.getOrCreateKotlinClass(r1), "观众上麦后，屏蔽偶现收到的sei，导致布局异常", "null"));
        UltraSettingsManager.b("live_pk_request_expired_prop_card_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_request_expired_prop_card_time", Reflection.getOrCreateKotlinClass(r2), "PK请求过期道具卡信息的时机，倒数，默认还剩50s", "null"));
        UltraSettingsManager.b("pk_sei_check_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("pk_sei_check_enable", Reflection.getOrCreateKotlinClass(r1), "PK场景SEI兜底开关", "null"));
        UltraSettingsManager.b("live_pk_audience_score_message_track", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_audience_score_message_track", Reflection.getOrCreateKotlinClass(r1), "控制是否进行金主送礼消息延时上报", "null"));
        UltraSettingsManager.b("live_pk_guest_uid_error_log", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_guest_uid_error_log", Reflection.getOrCreateKotlinClass(r1), "是否上报双人PKGuestUid为null异常且不打开个人面板", "null"));
        UltraSettingsManager.b("multi_revenue_pk_double_enter_room_call_trace", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_revenue_pk_double_enter_room_call_trace", Reflection.getOrCreateKotlinClass(r1), "营收场景主播连线double进房请求 兜底 上报trace", "null"));
        UltraSettingsManager.b("live_multi_load_rev_in_p0", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_load_rev_in_p0", Reflection.getOrCreateKotlinClass(r3), "RevControlWidget加载方式 0: P1加载 1: P0加载 2：P0按需加载", "null"));
        UltraSettingsManager.b("live_pk_designated_gift_activity_lynx_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_designated_gift_activity_lynx_url", Reflection.getOrCreateKotlinClass(String.class), "指定礼物PK活动面板顶部区域lynx url", "null"));
        UltraSettingsManager.b("live_pk_sei_overlap_check", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_sei_overlap_check", Reflection.getOrCreateKotlinClass(r1), "PK Sei重叠区域检查", "null"));
        UltraSettingsManager.b("live_feed_hybrid_measure_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_feed_hybrid_measure_opt", Reflection.getOrCreateKotlinClass(r1), "Feed动态化渲染优化开关", "null"));
        UltraSettingsManager.b("live_link_control_center_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_control_center_url", Reflection.getOrCreateKotlinClass(String.class), "建连中枢url", "null"));
        UltraSettingsManager.b("live_pk_season_random_match_lynx_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_season_random_match_lynx_url", Reflection.getOrCreateKotlinClass(String.class), "PK 巅峰赛段位信息&发起匹配 Lynx地址", "null"));
        UltraSettingsManager.b("live_link_con_perf_report_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_con_perf_report_enable", Reflection.getOrCreateKotlinClass(r1), "是否允许链路性能上报", "null"));
        UltraSettingsManager.b("multi_revenue_pk_wrds_back_up", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_revenue_pk_wrds_back_up", Reflection.getOrCreateKotlinClass(r1), "pk通过wrds兜底进房", "null"));
        UltraSettingsManager.b("live_pk_time_stuck_check_duration", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_time_stuck_check_duration", Reflection.getOrCreateKotlinClass(r2), "PK倒计时卡在0：00检测时间间隔", "null"));
        UltraSettingsManager.b("multi_link_default_mute_remote", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_default_mute_remote", Reflection.getOrCreateKotlinClass(r1), "主播连线默认mute远端主播", "null"));
        UltraSettingsManager.b("live_pk_multi_brew_hybrid_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_multi_brew_hybrid_url", Reflection.getOrCreateKotlinClass(String.class), "PK multi brew scheme", "null"));
        UltraSettingsManager.b("live_post_pk_thread", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_post_pk_thread", Reflection.getOrCreateKotlinClass(r1), "post pkui线程", "null"));
        UltraSettingsManager.b("live_pk_panel_enable_auto_locate", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_panel_enable_auto_locate", Reflection.getOrCreateKotlinClass(r1), "发起PK面板自动定位发起连线tab逻辑", "null"));
        UltraSettingsManager.b("load_pk_sei_back_list", new com.bytedance.tools.kcp.ultrasettings.runtime.c("load_pk_sei_back_list", c, "加载PK时的非法首帧SEI黑名单", "null"));
        UltraSettingsManager.b("multi_anchor_profit_interact_context_lifecycle", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_anchor_profit_interact_context_lifecycle", Reflection.getOrCreateKotlinClass(r1), "多人主播连线 连线投票计值context生命周期修复", "null"));
        UltraSettingsManager.b("pk_unexpected_anchor_frame_mute_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("pk_unexpected_anchor_frame_mute_opt", Reflection.getOrCreateKotlinClass(r1), "新PK串音兜底逻辑，非对手主播均静音", "null"));
        UltraSettingsManager.b("live_team_pk_battle_config_setting", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_team_pk_battle_config_setting", Reflection.getOrCreateKotlinClass(r1), "组队战面板发起PKBattleConfigSetting参数透传", "null"));
        UltraSettingsManager.b("live_pk_team_task_opt_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_team_task_opt_url", Reflection.getOrCreateKotlinClass(String.class), "PK 彩蛋优化 lynx scheme", "null"));
        UltraSettingsManager.b("multi_anchor_enter_duration_check_limit", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_anchor_enter_duration_check_limit", Reflection.getOrCreateKotlinClass(r3), "多人主播连线观众端进房耗时检查点", "null"));
        UltraSettingsManager.b("multi_pk_auto_match_disable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_pk_auto_match_disable", Reflection.getOrCreateKotlinClass(r1), "不展现多人PK面板的匹配模块", "null"));
        UltraSettingsManager.b("live_pk_pc_enter_opt_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_pc_enter_opt_enable", Reflection.getOrCreateKotlinClass(r1), "pk pc进房优化", "null"));
        UltraSettingsManager.b("live_pk_handle_repeat_invite", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_handle_repeat_invite", Reflection.getOrCreateKotlinClass(r1), "是否处理再来一局重复邀请", "null"));
        UltraSettingsManager.b("live_sdk_pk_ab_crop_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_sdk_pk_ab_crop_opt", Reflection.getOrCreateKotlinClass(String.class), "PK面板ab参数裁剪", "null"));
        UltraSettingsManager.b("multi_anchor_enable_mic_panel", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_anchor_enable_mic_panel", d, "多人主播连线场景 是否在对应人数下开启麦位面板功能", "null"));
        UltraSettingsManager.b("allow_gift_to_linker", new com.bytedance.tools.kcp.ultrasettings.runtime.c("allow_gift_to_linker", Reflection.getOrCreateKotlinClass(r1), "允许观众给PK/连线主播送礼逻辑优化开关", "null"));
        UltraSettingsManager.b("live_pk_egg_rule_setting", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_egg_rule_setting", Reflection.getOrCreateKotlinClass(r11.n.class), "PK彩蛋setting开关规则页面url", "null"));
        UltraSettingsManager.b("multi_anchor_enable_feedback_dialog", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_anchor_enable_feedback_dialog", Reflection.getOrCreateKotlinClass(r1), "主播连线开启feedback", "null"));
        UltraSettingsManager.b("live_double_dynamic_hub_use_annie_x", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_double_dynamic_hub_use_annie_x", Reflection.getOrCreateKotlinClass(r1), "双人控制中枢是否使用 AnnieX", "null"));
        UltraSettingsManager.b("live_pk_history_feed_back_panel_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_history_feed_back_panel_url", Reflection.getOrCreateKotlinClass(String.class), "历史记录二级页区域url", "null"));
        UltraSettingsManager.b("pk_with_guest_stop_rtc_valid_link_ids", new com.bytedance.tools.kcp.ultrasettings.runtime.c("pk_with_guest_stop_rtc_valid_link_ids", Reflection.getOrCreateKotlinClass(r1), "PK带观众断开PK，清除所有非本房首帧", "null"));
        UltraSettingsManager.b("live_multi_delay_widget", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_delay_widget", Reflection.getOrCreateKotlinClass(r1), "多人PK推迟widget加载", "null"));
        UltraSettingsManager.b("live_last_pk_result_details_lynx_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_last_pk_result_details_lynx_url", Reflection.getOrCreateKotlinClass(String.class), "pk上局结果lynx url", "null"));
        UltraSettingsManager.b("live_random_match_panel_lynx_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_random_match_panel_lynx_enable", Reflection.getOrCreateKotlinClass(r1), "连屏随机匹配面板lynx化", "null"));
        UltraSettingsManager.b("live_pk_battle_invite_dialog_lynx_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_battle_invite_dialog_lynx_url", Reflection.getOrCreateKotlinClass(String.class), "pk玩法被邀请页面lynx url", "null"));
        UltraSettingsManager.b("live_multi_link_auto_load_panel", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_auto_load_panel", Reflection.getOrCreateKotlinClass(r3), "进入连线后自动打开玩法面板次数", "null"));
        UltraSettingsManager.b("live_multi_dynamic_measure_opt_v2", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_dynamic_measure_opt_v2", Reflection.getOrCreateKotlinClass(r1), "多人动态化接入measure opt v2", "null"));
        UltraSettingsManager.b("live_pk_handle_rev_sei_after_reply", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_handle_rev_sei_after_reply", Reflection.getOrCreateKotlinClass(r1), "PK被邀请方在reply后处理邀请方sei", "null"));
        UltraSettingsManager.b("live_pk_log_invite_type_list", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_log_invite_type_list", e, "主播入口上报invite支持邀请invitType集合", "null"));
        UltraSettingsManager.b("live_fixed_move_dist", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_fixed_move_dist", Reflection.getOrCreateKotlinClass(r3), "固定下移距离dp", "null"));
        UltraSettingsManager.b("live_multi_dynamic_measure_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_dynamic_measure_opt", Reflection.getOrCreateKotlinClass(r1), "多人动态化接入measure opt", "null"));
        UltraSettingsManager.b("live_pk_end_not_consume_response", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_end_not_consume_response", Reflection.getOrCreateKotlinClass(r1), "pk中主动关播方，不消费battlefinish回包", "null"));
        UltraSettingsManager.b("anchor_sei_de_duplication_opt_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("anchor_sei_de_duplication_opt_enable", Reflection.getOrCreateKotlinClass(r1), "PK、主播连线主播侧sei去重优化，sei内容不变不更新时间戳", "null"));
        UltraSettingsManager.b("live_sei_frame_compare_timestamp", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_sei_frame_compare_timestamp", Reflection.getOrCreateKotlinClass(r1), "sei比较时间戳", "null"));
        UltraSettingsManager.b("multi_revenue_preload_data_threshold", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_revenue_preload_data_threshold", Reflection.getOrCreateKotlinClass(r2), "营收场景预加载数据有效期", "null"));
        UltraSettingsManager.b("live_pk_panel_lynx_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_panel_lynx_url", Reflection.getOrCreateKotlinClass(String.class), "PK主面板lynx url", "null"));
        UltraSettingsManager.b("live_pk_disconnect_toast_count_control", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_disconnect_toast_count_control", Reflection.getOrCreateKotlinClass(r3), "高峰期PK后断开连线toast提醒次数", "null"));
        UltraSettingsManager.b("live_pk_battle_end_punish_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_battle_end_punish_enable", Reflection.getOrCreateKotlinClass(r1), "惩罚结束接口替换battle/end_punish", "null"));
        UltraSettingsManager.b("live_pk_panel_speed_up", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_panel_speed_up", Reflection.getOrCreateKotlinClass(r1), "pk面板异步加载开关", "null"));
        UltraSettingsManager.b("live_multilinker_focus_layout_in_self", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multilinker_focus_layout_in_self", Reflection.getOrCreateKotlinClass(r1), "多人主播连线场景 是否允许主播仅在自己直播间放大", "null"));
        UltraSettingsManager.b("live_multi_quit_confirm_dialog_lynx_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_quit_confirm_dialog_lynx_url", Reflection.getOrCreateKotlinClass(String.class), "连屏多人连线退出确认弹窗lynx url", "null"));
        UltraSettingsManager.b("multi_invitee_clear_by_timeout", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_invitee_clear_by_timeout", Reflection.getOrCreateKotlinClass(r1), "多人主播连线邀请列表超时清除", "null"));
        UltraSettingsManager.b("live_revlink_anchor_layout_full_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_revlink_anchor_layout_full_opt", Reflection.getOrCreateKotlinClass(r1), "主播连屏full布局修改", "null"));
        UltraSettingsManager.b("live_multi_dynamic_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_dynamic_config", Reflection.getOrCreateKotlinClass(com.bytedance.android.live.revlink.impl.settings.dynamic.c.class), "多人PK配置项", "null"));
        UltraSettingsManager.b("live_pk_folding_strategy_remove_room", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_folding_strategy_remove_room", Reflection.getOrCreateKotlinClass(r1), "连麦中互关好友折叠数量", "null"));
        UltraSettingsManager.b("live_multi_dynamic_hub_use_annie_x", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_dynamic_hub_use_annie_x", Reflection.getOrCreateKotlinClass(r1), "多人控制中枢是否使用 AnnieX", "null"));
        UltraSettingsManager.b("live_battle_be_invited_dialog_lynx_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_battle_be_invited_dialog_lynx_enable", Reflection.getOrCreateKotlinClass(r1), "玩法中被邀请弹窗lynx化", "null"));
        UltraSettingsManager.b("live_pk_peak_period_auto_adjust_duration_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_peak_period_auto_adjust_duration_enable", Reflection.getOrCreateKotlinClass(r1), "PK高峰期支持默认时长调整总开关", "null"));
        UltraSettingsManager.b("live_ai_gift_async_sort_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_ai_gift_async_sort_config", Reflection.getOrCreateKotlinClass(r11.k.class), "直播端智能礼物异步排序配置", "null"));
        UltraSettingsManager.b("live_pk_new_panel_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_new_panel_opt", Reflection.getOrCreateKotlinClass(r3), "PK面板改造", "null"));
        UltraSettingsManager.b("live_pk_business_timeout_interval", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_business_timeout_interval", Reflection.getOrCreateKotlinClass(r2), "PK建联没有收到battlemessage消息超时", "null"));
        UltraSettingsManager.b("live_pk_random_rank_pop_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_random_rank_pop_config", f, "连屏Rank提示配置", "null"));
        UltraSettingsManager.b("live_pk_feed_type_allow_list", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_feed_type_allow_list", g, "pk预览流允许外显feedType", "null"));
        UltraSettingsManager.b("livesdk_pk_open_record_panel_event_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("livesdk_pk_open_record_panel_event_fix", Reflection.getOrCreateKotlinClass(r1), "打开pk记录面板链路问题修复", "null"));
        UltraSettingsManager.b("pk_vote_test_time_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("pk_vote_test_time_enable", Reflection.getOrCreateKotlinClass(r1), "测试下调整投票时间为30s", "null"));
        UltraSettingsManager.b("live_pk_mix_type_degrade_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_mix_type_degrade_enable", Reflection.getOrCreateKotlinClass(r1), "是否允许端上控制开启pk降级能力", "null"));
        UltraSettingsManager.b("pk_support_link_score", new com.bytedance.tools.kcp.ultrasettings.runtime.c("pk_support_link_score", Reflection.getOrCreateKotlinClass(r4), "pk 支持观众连线 机型 阈值", "null"));
        UltraSettingsManager.b("live_pk_remove_random_pk_once_more", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_remove_random_pk_once_more", Reflection.getOrCreateKotlinClass(r1), "移除随机匹配再来一局后的view", "null"));
        UltraSettingsManager.b("multi_player_trace_log_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_player_trace_log_enable", Reflection.getOrCreateKotlinClass(r1), "监控多人连线的播放器显示区域", "null"));
        UltraSettingsManager.b("multi_anchor_relink_invite_timeout_duration", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_anchor_relink_invite_timeout_duration", Reflection.getOrCreateKotlinClass(r2), "重连邀请超时时长", "null"));
        UltraSettingsManager.b("live_mock_link_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_mock_link_enable", Reflection.getOrCreateKotlinClass(r1), "模拟上麦开关", "null"));
        UltraSettingsManager.b("live_pk_custom_play_start_animation", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_custom_play_start_animation", h, "live_pk_custom_play_start_animation", "null"));
        UltraSettingsManager.b("live_multi_feed_dynamic_hub_use_annie_x", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_feed_dynamic_hub_use_annie_x", Reflection.getOrCreateKotlinClass(r1), "多人控制中枢预览流是否使用 AnnieX", "null"));
        UltraSettingsManager.b("live_pk_panel_up_banner_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_panel_up_banner_url", Reflection.getOrCreateKotlinClass(String.class), "PK面板上方活动banner区域", "null"));
        UltraSettingsManager.b("revlink_layout_opt_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("revlink_layout_opt_config", Reflection.getOrCreateKotlinClass(a51.d.class), "PK和主播连线布局加载优化", "null"));
        UltraSettingsManager.b("toolbar_pk_lead_anim_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("toolbar_pk_lead_anim_fix", Reflection.getOrCreateKotlinClass(r1), "PK toolbar 入口引导动画卡住修复", "null"));
        UltraSettingsManager.b("live_break_through_contribution_list_lynx_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_break_through_contribution_list_lynx_url", Reflection.getOrCreateKotlinClass(String.class), "多人协作闯关贡献榜lynx url", "null"));
        UltraSettingsManager.b("live_penal_default_title", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_penal_default_title", Reflection.getOrCreateKotlinClass(String.class), "惩罚阶段兜底文案", "null"));
        UltraSettingsManager.b("live_pk_unload_notice_opt_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_unload_notice_opt_enable", Reflection.getOrCreateKotlinClass(r1), "打开PK卸载通知优化", "null"));
        UltraSettingsManager.b("ignore_mix_stream_check", new com.bytedance.tools.kcp.ultrasettings.runtime.c("ignore_mix_stream_check", Reflection.getOrCreateKotlinClass(r1), "PK场景下mixstream不校验首帧", "null"));
        UltraSettingsManager.b("multi_anchor_pk_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_anchor_pk_enable", Reflection.getOrCreateKotlinClass(r1), "多人PK开关", "null"));
        UltraSettingsManager.b("anchor_link_ext_score_show_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("anchor_link_ext_score_show_enable", Reflection.getOrCreateKotlinClass(r1), "主播连线记值展现开关", "null"));
        UltraSettingsManager.b("live_rev_manual_control_hybrid_control", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rev_manual_control_hybrid_control", Reflection.getOrCreateKotlinClass(r1), "手动控制PK组件加载", "null"));
        UltraSettingsManager.b("live_multi_anchor_link_enter_room_opt_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_anchor_link_enter_room_opt_config", Reflection.getOrCreateKotlinClass(r11.a.class), "主播连线观众侧进房体验优化优化配置", "null"));
        UltraSettingsManager.b("live_pk_battle_message_valid_check", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_battle_message_valid_check", Reflection.getOrCreateKotlinClass(r1), "battle消息合法性校验上报", "null"));
        UltraSettingsManager.b("live_revlink_sei_write_p", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_revlink_sei_write_p", Reflection.getOrCreateKotlinClass(r1), "是否开启sei中写入p值逻辑", "null"));
        UltraSettingsManager.b("pk_push_stream_opt_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("pk_push_stream_opt_enable", Reflection.getOrCreateKotlinClass(r1), "PK分辨率改成13:9开关", "null"));
        UltraSettingsManager.b("live_player_sei_json_optimize", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_player_sei_json_optimize", Reflection.getOrCreateKotlinClass(r1), "播放器Sei解析JSON优化", "null"));
        UltraSettingsManager.b("live_kmp_scope_service_allow_null", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_kmp_scope_service_allow_null", Reflection.getOrCreateKotlinClass(r1), "获取服务可空", "null"));
        UltraSettingsManager.b("live_multi_random_match_panel_lynx_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_random_match_panel_lynx_url", Reflection.getOrCreateKotlinClass(String.class), "连屏多人随机匹配面板lynx url", "null"));
        UltraSettingsManager.b("live_widget_rev_callback_leak_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_widget_rev_callback_leak_fix", Reflection.getOrCreateKotlinClass(r1), "是否开启内存泄漏修改", "null"));
        UltraSettingsManager.b("live_pk_hybrid_use_annie_x", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_hybrid_use_annie_x", Reflection.getOrCreateKotlinClass(r1), "PK彩蛋是否使用 AnnieX", "null"));
        UltraSettingsManager.b("live_pk_team_task_opt_type", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_team_task_opt_type", Reflection.getOrCreateKotlinClass(r3), "PK彩蛋优化实验 0线上 1优化+对方加成值透传 2优化+对方结果透传 3仅优化 4优化+对方结果/加成值透传", "null"));
        UltraSettingsManager.b("pk_measure_debug_print_duration", new com.bytedance.tools.kcp.ultrasettings.runtime.c("pk_measure_debug_print_duration", Reflection.getOrCreateKotlinClass(r1), "打印PK measure耗时", "null"));
        UltraSettingsManager.b("live_revenue_interact_so_many_anchor_enlarge", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_revenue_interact_so_many_anchor_enlarge", Reflection.getOrCreateKotlinClass(r1), "多人PK拓展支持放大布局", "null"));
        UltraSettingsManager.b("live_interact_vote_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_vote_config", Reflection.getOrCreateKotlinClass(r11.c.class), "互动投票配置", "null"));
        UltraSettingsManager.b("live_pk_bar_relative_score_show_opt_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_bar_relative_score_show_opt_enable", Reflection.getOrCreateKotlinClass(r1), "PK血条相对值展示优化", "null"));
        UltraSettingsManager.b("live_interact_vote_rule_lynx_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_interact_vote_rule_lynx_url", Reflection.getOrCreateKotlinClass(String.class), "互动投票规则页面lynx url", "null"));
        UltraSettingsManager.b("live_rev_anchor_margin_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rev_anchor_margin_enable", Reflection.getOrCreateKotlinClass(r1), "主播连线特效玩法调整top", "null"));
        UltraSettingsManager.b("multi_anchor_debug_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_anchor_debug_enable", Reflection.getOrCreateKotlinClass(r1), "多人主播连线调试开关", "null"));
        UltraSettingsManager.b("enable_report_inner_feed_pk_lost", new com.bytedance.tools.kcp.ultrasettings.runtime.c("enable_report_inner_feed_pk_lost", Reflection.getOrCreateKotlinClass(r1), "连屏PK推荐损失打点", "null"));
        UltraSettingsManager.b("live_rev_link_rec_show_follow", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rev_link_rec_show_follow", Reflection.getOrCreateKotlinClass(r1), "PK面板推荐是否展示粉丝数", "null"));
        UltraSettingsManager.b("live_player_sei_json_cache_size", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_player_sei_json_cache_size", Reflection.getOrCreateKotlinClass(r3), "播放器Sei解析JSON缓存池大小", "null"));
        UltraSettingsManager.b("pk_panel_size_opt_s", new com.bytedance.tools.kcp.ultrasettings.runtime.c("pk_panel_size_opt_s", Reflection.getOrCreateKotlinClass(p.class), "PK面板尺寸修复V2", "null"));
        UltraSettingsManager.b("live_pk_reply_rtc_sei_timer_repeat_interval", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_reply_rtc_sei_timer_repeat_interval", Reflection.getOrCreateKotlinClass(r3), "PK建联中邀请方发送表示收到reply消息的SEI的频率", "null"));
        UltraSettingsManager.b("live_rev_scene_enable_pre_rtc_whitelist", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rev_scene_enable_pre_rtc_whitelist", i, "适用preRtc的scene白名单", "null"));
        UltraSettingsManager.b("live_multi_change_background_image_centre_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_change_background_image_centre_url", Reflection.getOrCreateKotlinClass(String.class), "多人控制中枢lynx加载params，这个专门用来修改背景图", "null"));
        UltraSettingsManager.b("live_link_control_center_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_control_center_enable", Reflection.getOrCreateKotlinClass(r1), "连屏建连控制中枢加载", "null"));
        UltraSettingsManager.b("live_revenue_volume_indicator_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_revenue_volume_indicator_config", Reflection.getOrCreateKotlinClass(r41.e.class), "电台pk优化音量标识配置（主播侧生效）", "null"));
        UltraSettingsManager.b("live_intercom_comment_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_intercom_comment_config", Reflection.getOrCreateKotlinClass(u.class), "评论互通邀请和被邀请面板配置", "null"));
        UltraSettingsManager.b("live_pk_peak_period_end_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_peak_period_end_time", Reflection.getOrCreateKotlinClass(String.class), "PK高峰期每日结束时间", "null"));
        UltraSettingsManager.b("live_link_sei_harmony_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_sei_harmony_fix", Reflection.getOrCreateKotlinClass(r1), "SEI解析漏掉鸿蒙平台判断", "null"));
        UltraSettingsManager.b("rev_spatial_audio_speak_position_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("rev_spatial_audio_speak_position_config", Reflection.getOrCreateKotlinClass(xf1.class), "不同场景下嘉宾和主播在空间音频中的发声位置和朝向信息", "null"));
        UltraSettingsManager.b("live_pk_rule_url_android", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_rule_url_android", Reflection.getOrCreateKotlinClass(String.class), "直播匹配使用须知", "null"));
        UltraSettingsManager.b("revenue_link_sei_backup_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("revenue_link_sei_backup_opt", Reflection.getOrCreateKotlinClass(w41.c.class), "SEI兜底加载连屏看播组件优化", "null"));
        UltraSettingsManager.b("live_revenue_interact_dynamic_data_format", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_revenue_interact_dynamic_data_format", Reflection.getOrCreateKotlinClass(r1), "是否是有格式化后的数据", "null"));
        UltraSettingsManager.b("live_video_layout_optimize_value", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_video_layout_optimize_value", Reflection.getOrCreateKotlinClass(r3), "竖屏视频容器位置调优的固定值", "null"));
        UltraSettingsManager.b("live_pk_live_room_opt_setting", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_live_room_opt_setting", Reflection.getOrCreateKotlinClass(r3), "Pk 直播间对局体验优化", "null"));
        UltraSettingsManager.b("multi_anchor_enable_self_mic_panel", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_anchor_enable_self_mic_panel", j, "多人主播连线场景 是否在对应人数下开启自己麦位面板功能", "null"));
        UltraSettingsManager.b("live_pk_reserve_settle_lynx_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_reserve_settle_lynx_url", Reflection.getOrCreateKotlinClass(String.class), "主动邀约二级页url", "null"));
        UltraSettingsManager.b("live_pk_peak_period_auto_adjust_duration_once_for_all", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_peak_period_auto_adjust_duration_once_for_all", Reflection.getOrCreateKotlinClass(r1), "PK高峰期默认时长调整生效时长为永久", "null"));
        UltraSettingsManager.b("multi_revenue_link_wrds_back_up", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_revenue_link_wrds_back_up", Reflection.getOrCreateKotlinClass(r1), "主播连线通过wrds兜底进房", "null"));
        UltraSettingsManager.b("live_pk_speed_match_wait_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_speed_match_wait_time", Reflection.getOrCreateKotlinClass(r3), "随机PK极速匹配等待时长", "null"));
        UltraSettingsManager.b("live_rev_frame_match_score_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rev_frame_match_score_time", Reflection.getOrCreateKotlinClass(r3), "scene合并 首帧匹配计时间隔", "null"));
        UltraSettingsManager.b("live_breakthrough_topbar_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_breakthrough_topbar_url", Reflection.getOrCreateKotlinClass(String.class), "PK lynx 血条", "null"));
        UltraSettingsManager.b("link_auto_match_params", new com.bytedance.tools.kcp.ultrasettings.runtime.c("link_auto_match_params", Reflection.getOrCreateKotlinClass(b51.a.class), "随机匹配默认配置", "null"));
        UltraSettingsManager.b("live_enable_wang_zhe_link_new_style", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_wang_zhe_link_new_style", Reflection.getOrCreateKotlinClass(r1), "enable 王者荣耀游戏连屏新样式", "null"));
        UltraSettingsManager.b("live_multilinker_focus_layout_action_interval", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multilinker_focus_layout_action_interval", Reflection.getOrCreateKotlinClass(r2), "多人主播连线 放大操作频控", "null"));
        UltraSettingsManager.b("live_pk_lynx_control_team_task_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_lynx_control_team_task_enable", Reflection.getOrCreateKotlinClass(r3), "Lynx中枢控制新彩蛋加载", "null"));
        UltraSettingsManager.b("live_dynamic_hub_lynx_v2_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_dynamic_hub_lynx_v2_opt", Reflection.getOrCreateKotlinClass(r1), "是否切换新连屏中枢下发", "null"));
        UltraSettingsManager.b("live_multi_team_task_fix_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_team_task_fix_enable", Reflection.getOrCreateKotlinClass(r1), "主播连线观众中途进房偶现不展示彩蛋", "null"));
        UltraSettingsManager.b("revenue_link_sei_unload_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("revenue_link_sei_unload_config", Reflection.getOrCreateKotlinClass(w41.d.class), "SEI卸载连屏看播组件配置", "null"));
        UltraSettingsManager.b("pk_preview_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("pk_preview_enable", Reflection.getOrCreateKotlinClass(r1), "PK预览开关", "null"));
        UltraSettingsManager.b("live_revlink_audio_abnormal_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_revlink_audio_abnormal_opt", Reflection.getOrCreateKotlinClass(w41.e.class), "是否开启连屏音频异常诊断能力", "null"));
        UltraSettingsManager.b("pk_switch_link_not_load_video_talk", new com.bytedance.tools.kcp.ultrasettings.runtime.c("pk_switch_link_not_load_video_talk", Reflection.getOrCreateKotlinClass(r1), "PK转连线保证不拉起聊天室", "null"));
        UltraSettingsManager.b("multi_feedview_new", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_feedview_new", Reflection.getOrCreateKotlinClass(r1), "多人PK预览流改版", "null"));
        UltraSettingsManager.b("live_pk_invite_timer_interval", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_invite_timer_interval", Reflection.getOrCreateKotlinClass(r2), "PK建联消息超时时长s", "null"));
        UltraSettingsManager.b("live_jump_from_live_play_activity_false_as_no_transparent", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_jump_from_live_play_activity_false_as_no_transparent", Reflection.getOrCreateKotlinClass(r1), "认定JUMP_FROM_LIVE_PLAY_ACTIVITY是false，表示状态栏关闭沉浸式", "null"));
        UltraSettingsManager.b("live_pk_finish_stats_backup_delay", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_finish_stats_backup_delay", Reflection.getOrCreateKotlinClass(r2), "PK结束消息超时请求battle/stats逻辑，默认3秒", "null"));
        UltraSettingsManager.b("live_invite_more_panel_lynx_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_invite_more_panel_lynx_enable", Reflection.getOrCreateKotlinClass(r1), "连屏邀请更多面板lynx化", "null"));
        UltraSettingsManager.b("live_enable_rts_login", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_rts_login", Reflection.getOrCreateKotlinClass(r1), "是否调用login", "null"));
        UltraSettingsManager.b("live_revenue_interact_so_many_anchor", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_revenue_interact_so_many_anchor", Reflection.getOrCreateKotlinClass(r1), "多人PK支持最多9人开关", "null"));
        UltraSettingsManager.b("live_pk_enable_query_data_on_default_link", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_enable_query_data_on_default_link", Reflection.getOrCreateKotlinClass(r1), "是否允许PK面板自动锚定到连线tab时，也请求PK数据", "null"));
        UltraSettingsManager.b("live_revlink_anchor_layout_ratio_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_revlink_anchor_layout_ratio_opt", Reflection.getOrCreateKotlinClass(r1), "主播连屏布局16:9", "null"));
        UltraSettingsManager.b("revlink_useless_log", new com.bytedance.tools.kcp.ultrasettings.runtime.c("revlink_useless_log", Reflection.getOrCreateKotlinClass(r1), "连线无用log优化", "null"));
        UltraSettingsManager.b("live_pk_team_task_reset", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_team_task_reset", Reflection.getOrCreateKotlinClass(r1), "主播连线彩蛋 Reset开关", "null"));
        UltraSettingsManager.b("live_pk_automatch_cancel_panel_paperwriter", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_automatch_cancel_panel_paperwriter", Reflection.getOrCreateKotlinClass(r11.m.class), "随机匹配弹窗title配置", "null"));
        UltraSettingsManager.b("live_multilinker_random_team_layout_opt_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multilinker_random_team_layout_opt_enable", Reflection.getOrCreateKotlinClass(r1), "组队PK提前加载布局开关", "null"));
        UltraSettingsManager.b("rev_link_current_mode_cost_time_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("rev_link_current_mode_cost_time_opt", Reflection.getOrCreateKotlinClass(r1), "getCurrentMode高频调用优化", "null"));
        UltraSettingsManager.b("live_anchor_interact_vote_score_ratio", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_anchor_interact_vote_score_ratio", Reflection.getOrCreateKotlinClass(r3), "直播间投票分值血条比例", "null"));
        UltraSettingsManager.b("live_push_stream_size_map", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_push_stream_size_map", k, "推流尺寸", "null"));
        UltraSettingsManager.b("pk_single_view_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("pk_single_view_enable", Reflection.getOrCreateKotlinClass(r1), "PK单View开关", "null"));
        UltraSettingsManager.b("live_pk_battle_power_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_battle_power_url", Reflection.getOrCreateKotlinClass(String.class), "pk 战力容器", "null"));
        UltraSettingsManager.b("live_double_pk_audience_top_offset_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_double_pk_audience_top_offset_fix", Reflection.getOrCreateKotlinClass(r1), "双人PK观众侧topOffset调整", "null"));
        UltraSettingsManager.b("pk_cross_talk_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("pk_cross_talk_opt", Reflection.getOrCreateKotlinClass(r1), "PK串音兜底开关", "null"));
        UltraSettingsManager.b("pk_measure_debug_print_request_layout", new com.bytedance.tools.kcp.ultrasettings.runtime.c("pk_measure_debug_print_request_layout", Reflection.getOrCreateKotlinClass(r1), "打印PK requestLayout来源", "null"));
        UltraSettingsManager.b("live_pk_mixstream_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_mixstream_opt", Reflection.getOrCreateKotlinClass(r1), "PK提前进房同意前合流优化", "null"));
        UltraSettingsManager.b("live_pk_connect_timeout_interval", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_connect_timeout_interval", Reflection.getOrCreateKotlinClass(r3), "视频连线超时时间", "null"));
        UltraSettingsManager.b("live_pk_be_invite_dialog_show_fan", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_be_invite_dialog_show_fan", Reflection.getOrCreateKotlinClass(r1), "pk被邀请弹窗展示fan", "null"));
        UltraSettingsManager.b("revlink_room_load_opt_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("revlink_room_load_opt_config", Reflection.getOrCreateKotlinClass(w41.b.class), "连屏进房加载组件优化", "null"));
        UltraSettingsManager.b("live_player_rev_smooth_enter_room", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_player_rev_smooth_enter_room", Reflection.getOrCreateKotlinClass(o0.class), "营收场景预览流播放器平滑进房优化", "null"));
        UltraSettingsManager.b("live_pk_new_custom_play_test_duration", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_new_custom_play_test_duration", Reflection.getOrCreateKotlinClass(r1), "自定义PK整合测试时长开关", "null"));
        UltraSettingsManager.b("live_pk_reply_rtc_sei_timer_duration", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_reply_rtc_sei_timer_duration", Reflection.getOrCreateKotlinClass(r2), "PK被邀请方监听邀请方的sei超时", "null"));
        UltraSettingsManager.b("link_partner_feed_play_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("link_partner_feed_play_opt", Reflection.getOrCreateKotlinClass(r1), "是否开启观众侧预览流合演看播优化", "null"));
        UltraSettingsManager.b("pk_panel_cache_strategy", new com.bytedance.tools.kcp.ultrasettings.runtime.c("pk_panel_cache_strategy", Reflection.getOrCreateKotlinClass(t.class), "pk面板异步加载开关-ai数据刷新", "null"));
        UltraSettingsManager.b("live_multi_anchor_link_enter_room_opt_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_anchor_link_enter_room_opt_enable", Reflection.getOrCreateKotlinClass(r1), "主播连线观众侧进房体验优化", "null"));
        UltraSettingsManager.b("live_pk_peak_period_begin_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_peak_period_begin_time", Reflection.getOrCreateKotlinClass(String.class), "PK高峰期每日开始时间", "null"));
        UltraSettingsManager.b("live_multi_feed_measure_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_feed_measure_opt", Reflection.getOrCreateKotlinClass(r1), "多人动态化feed渲染优化", "null"));
        UltraSettingsManager.b("live_pk_reply_message_cache", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_reply_message_cache", Reflection.getOrCreateKotlinClass(r1), "PK reply消息缓存", "null"));
        UltraSettingsManager.b("multi_link_use_new_rtc_connect_model", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_use_new_rtc_connect_model", Reflection.getOrCreateKotlinClass(r1), "主播连线RTC建联走新逻辑", "null"));
        UltraSettingsManager.b("live_multi_vote_topic_lynx", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_vote_topic_lynx", Reflection.getOrCreateKotlinClass(String.class), "多人互动投票的规则页", "null"));
        UltraSettingsManager.b("live_link_time_event_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_time_event_opt", Reflection.getOrCreateKotlinClass(r3), "连麦time event优化", "null"));
        UltraSettingsManager.b("live_rev_block_audience_status", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rev_block_audience_status", Reflection.getOrCreateKotlinClass(r1), "scope block audience status by 1_ prefix", "null"));
        UltraSettingsManager.b("live_sei_timeout_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_sei_timeout_config", Reflection.getOrCreateKotlinClass(w41.a.class), "营收组件SEI超时校验配置", "null"));
        UltraSettingsManager.b("live_enable_local_reserve_setting", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_local_reserve_setting", Reflection.getOrCreateKotlinClass(r1), "邀约本地入口开关", "null"));
        UltraSettingsManager.b("live_pc_anchor_interact_video_margin_top", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pc_anchor_interact_video_margin_top", Reflection.getOrCreateKotlinClass(r4), "PC伴侣主播连麦横屏流VideoView顶部占画幅比例", "null"));
        UltraSettingsManager.b("live_disable_leave_with_multi_friends", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_disable_leave_with_multi_friends", Reflection.getOrCreateKotlinClass(r1), "携友退出仅支持邀请一人开关", "null"));
        UltraSettingsManager.b("multi_anchor_enter_message_post_ui_thread", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_anchor_enter_message_post_ui_thread", Reflection.getOrCreateKotlinClass(r1), "多人主播连线enter消息加载linkWidget post到主线程中", "null"));
        UltraSettingsManager.b("live_pk_reserve_invite_and_invited_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_reserve_invite_and_invited_fix", Reflection.getOrCreateKotlinClass(r1), "邀约和受邀面板同时存在问题fix", "null"));
        UltraSettingsManager.b("live_spatial_audio_enable_type_in_revenue_link", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_spatial_audio_enable_type_in_revenue_link", Reflection.getOrCreateKotlinClass(r3), "营收连屏场景是否支持空间音频:0，走ab；1，全量关；2，全量开", "null"));
        UltraSettingsManager.b("live_multi_leave_with_friends", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_leave_with_friends", Reflection.getOrCreateKotlinClass(r1), "携友退出能力开关", "null"));
        UltraSettingsManager.b("livesdk_pk_end_log_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("livesdk_pk_end_log_fix", Reflection.getOrCreateKotlinClass(r1), "埋点修复", "null"));
        UltraSettingsManager.b("live_pk_end_enable_stream_mixer_anchor_self", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_end_enable_stream_mixer_anchor_self", Reflection.getOrCreateKotlinClass(r1), "pk带嘉宾结束时，避免短暂合流画面位置错乱，优化只合主播自己", "null"));
        UltraSettingsManager.b("sei_duplicate_removal_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("sei_duplicate_removal_enable", Reflection.getOrCreateKotlinClass(r1), "SEI去重", "null"));
        UltraSettingsManager.b("live_waiting_list_msg_users", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_waiting_list_msg_users", Reflection.getOrCreateKotlinClass(r1), "waiting列表是否直接使用消息里的列表", "null"));
        UltraSettingsManager.b("multi_anchor_first_frame_threshold", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_anchor_first_frame_threshold", Reflection.getOrCreateKotlinClass(r2), "主播连线消费播放器首帧 阈值", "null"));
        UltraSettingsManager.b("pk_status_bar_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("pk_status_bar_opt", Reflection.getOrCreateKotlinClass(r1), "PK沉浸式适配", "null"));
        UltraSettingsManager.b("multi_link_mock_cross_talk_problem", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_mock_cross_talk_problem", Reflection.getOrCreateKotlinClass(r1), "主播连线mock串音主播", "null"));
        UltraSettingsManager.b("live_disable_pk_speed_button", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_disable_pk_speed_button", Reflection.getOrCreateKotlinClass(r1), "PK关闭匹配加速功能", "null"));
        UltraSettingsManager.b("live_player_feed_judge_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_player_feed_judge_fix", Reflection.getOrCreateKotlinClass(r1), "录屏连线播放器调整fix", "null"));
        UltraSettingsManager.b("live_audio_punish_toast_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_audio_punish_toast_fix", Reflection.getOrCreateKotlinClass(r1), "静音惩罚，对面主播toast问题fix", "null"));
        UltraSettingsManager.b("multi_interact_mode_change_settings", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_interact_mode_change_settings", Reflection.getOrCreateKotlinClass(r1), "聊天室mode 判断切换", "null"));
        UltraSettingsManager.b("live_multi_link_random_entrance_show", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_random_entrance_show", Reflection.getOrCreateKotlinClass(r1), "随机连线匹配入口开关", "null"));
        UltraSettingsManager.b("multi_anchor_connect_monitor_validation_duration", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_anchor_connect_monitor_validation_duration", Reflection.getOrCreateKotlinClass(r3), "主播连线 单个建联过程有效期", "null"));
        UltraSettingsManager.b("live_multilinker_large_layout", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multilinker_large_layout", Reflection.getOrCreateKotlinClass(r1), "主播连线是否支持大小屏", "null"));
        UltraSettingsManager.b("link_control_center_lynx_group_name", new com.bytedance.tools.kcp.ultrasettings.runtime.c("link_control_center_lynx_group_name", Reflection.getOrCreateKotlinClass(String.class), "连屏建连控制中枢加载", "null"));
        UltraSettingsManager.b("enable_stop_forward_remove_multi_channel", new com.bytedance.tools.kcp.ultrasettings.runtime.c("enable_stop_forward_remove_multi_channel", Reflection.getOrCreateKotlinClass(r1), "PK停止转发时同步修改MultiChannelInfo", "null"));
        UltraSettingsManager.b("anchor_link_time_record_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("anchor_link_time_record_enable", Reflection.getOrCreateKotlinClass(r1), "主播连线正计时开关", "null"));
        UltraSettingsManager.b("live_wangzhe_enable_game_sticker_land", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_wangzhe_enable_game_sticker_land", Reflection.getOrCreateKotlinClass(r1), "王者连屏启用横屏贴纸功能", "null"));
        UltraSettingsManager.b("live_push_stream_size_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_push_stream_size_opt", Reflection.getOrCreateKotlinClass(r1), "推流尺寸优化", "null"));
        UltraSettingsManager.b("live_rev_fix_widget_unload", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rev_fix_widget_unload", Reflection.getOrCreateKotlinClass(r1), "fix scope widget unload", "null"));
        UltraSettingsManager.b("live_rev_pk_guest_info_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rev_pk_guest_info_fix", Reflection.getOrCreateKotlinClass(r1), "PK guestInfo 更新fix", "null"));
        UltraSettingsManager.b("toolbar_pk_entrance_anim_gap_mills", new com.bytedance.tools.kcp.ultrasettings.runtime.c("toolbar_pk_entrance_anim_gap_mills", Reflection.getOrCreateKotlinClass(r2), "PK toolbar 入口动画切换平滑阈值", "null"));
        UltraSettingsManager.b("live_multilinker_focus_layout_in_all", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multilinker_focus_layout_in_all", Reflection.getOrCreateKotlinClass(r1), "多人主播连线场景 是否允许组织者全员放大", "null"));
        UltraSettingsManager.b("live_anchor_link_score_rule_lynx_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_anchor_link_score_rule_lynx_url", Reflection.getOrCreateKotlinClass(String.class), "连线记值规则页lynx url", "null"));
        UltraSettingsManager.b("live_multi_feed_event_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_feed_event_opt", Reflection.getOrCreateKotlinClass(r1), "多人动态化feed event优化", "null"));
        UltraSettingsManager.b("live_wang_zhe_game_link_margin_top", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_wang_zhe_game_link_margin_top", Reflection.getOrCreateKotlinClass(r4), "王者荣耀游戏连屏期间topmargin的值", "null"));
        UltraSettingsManager.b("live_anchor_link_composite_opt_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_anchor_link_composite_opt_enable", Reflection.getOrCreateKotlinClass(r1), "主播连线综合体验治理优化", "null"));
        UltraSettingsManager.b("live_vote_support_multi", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_vote_support_multi", Reflection.getOrCreateKotlinClass(r1), "多人支持互动投票", "null"));
        UltraSettingsManager.b("live_pk_bubble_tip_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_bubble_tip_opt", Reflection.getOrCreateKotlinClass(s.class), "pk入口提示优化", "null"));
        UltraSettingsManager.b("live_enable_normal_rtc_leave_kickout", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_enable_normal_rtc_leave_kickout", Reflection.getOrCreateKotlinClass(r1), "正常RTC回调leave是否踢人", "null"));
        UltraSettingsManager.b("live_pk_season_v2", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_season_v2", Reflection.getOrCreateKotlinClass(r1), "段位赛面板展现开关", "null"));
        UltraSettingsManager.b("live_multi_leave_user_cache_try_catch", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_leave_user_cache_try_catch", Reflection.getOrCreateKotlinClass(r1), "AnchorLinkUserCenterV2的leaveUserCache增加try catch", "null"));
        UltraSettingsManager.b("live_link_params_degrade", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_params_degrade", Reflection.getOrCreateKotlinClass(r11.h.class), "连线参数降级", "null"));
        UltraSettingsManager.b("live_pk_play_panel_lynx_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_play_panel_lynx_url", Reflection.getOrCreateKotlinClass(String.class), "PK玩法面板lynx url", "null"));
        UltraSettingsManager.b("live_pk_denoise_top_bg_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_denoise_top_bg_url", Reflection.getOrCreateKotlinClass(String.class), "降噪后的pk观众端顶部背景图", "null"));
        UltraSettingsManager.b("live_feed_event_block_list", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_feed_event_block_list", l, "连屏预览流不支持透传lynx事件列表", "null"));
        UltraSettingsManager.b("live_link_panel_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_panel_opt", Reflection.getOrCreateKotlinClass(r3), "PK入口优化面板开关", "null"));
        UltraSettingsManager.b("live_pk_opt_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_opt_enable", Reflection.getOrCreateKotlinClass(r1), "打开PK优化", "null"));
        UltraSettingsManager.b("live_intimatechat_sei_fields_simplify_uid", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_intimatechat_sei_fields_simplify_uid", Reflection.getOrCreateKotlinClass(r1), "是否开启双人聊sei中uid精简", "null"));
        UltraSettingsManager.b("live_pk_ensure_start_interact", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_ensure_start_interact", Reflection.getOrCreateKotlinClass(r1), "是否兜底双人PK没触发合流", "null"));
        UltraSettingsManager.b("live_link_record_big_small_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_record_big_small_opt", Reflection.getOrCreateKotlinClass(r1), "横屏大小屏合流优化", "null"));
        UltraSettingsManager.b("live_link_harmony_link_foldable_adapt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_harmony_link_foldable_adapt", Reflection.getOrCreateKotlinClass(r4), "连屏矮胖型屏幕适配高宽比值", "null"));
        UltraSettingsManager.b("live_pk_feed_observe_message_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_feed_observe_message_opt", Reflection.getOrCreateKotlinClass(r1), "双人PK预览流跟随消息更新血条", "null"));
        UltraSettingsManager.b("live_pk_disable_start_limit", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_disable_start_limit", Reflection.getOrCreateKotlinClass(r1), "PK发起邀请去除3s限制", "null"));
        UltraSettingsManager.b("live_rev_stream_layout_height_strateg", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rev_stream_layout_height_strateg", m, "连屏布局Height修正", "null"));
        UltraSettingsManager.b("live_pk_top_banner_lynx_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_top_banner_lynx_url", Reflection.getOrCreateKotlinClass(String.class), "PK 顶部banner Lynx地址", "null"));
        UltraSettingsManager.b("live_revlink_params_adjust", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_revlink_params_adjust", Reflection.getOrCreateKotlinClass(r11.g.class), "连线参数调整", "null"));
        UltraSettingsManager.b("multi_anchor_connect_monitor", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_anchor_connect_monitor", Reflection.getOrCreateKotlinClass(r1), "主播连线 建联成功率监控", "null"));
        UltraSettingsManager.b("live_link_record_big_small_radio", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_record_big_small_radio", Reflection.getOrCreateKotlinClass(Double.TYPE), "横屏大小屏小屏画面占比", "null"));
        UltraSettingsManager.b("live_pk_enable_play_tag_check", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_enable_play_tag_check", Reflection.getOrCreateKotlinClass(r1), "启用段位playTag检查", "null"));
        UltraSettingsManager.b("live_pk_skin_package", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_skin_package", n, "live_pk_skin_package", "null"));
        UltraSettingsManager.b("live_pk_panel_lynx_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_panel_lynx_enable", Reflection.getOrCreateKotlinClass(r1), "PK主面板lynx化", "null"));
        UltraSettingsManager.b("live_multi_link_waiting_frame_check_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_waiting_frame_check_time", Reflection.getOrCreateKotlinClass(r2), "waiting用户首帧校验的定时器时长", "null"));
        UltraSettingsManager.b("live_battle_be_invited_dialog_lynx_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_battle_be_invited_dialog_lynx_url", Reflection.getOrCreateKotlinClass(String.class), "玩法中被邀请弹窗lynx url", "null"));
        UltraSettingsManager.b("anchor_link_time_record_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("anchor_link_time_record_opt", Reflection.getOrCreateKotlinClass(r1), "主播连线正计时逻辑优化", "null"));
        UltraSettingsManager.b("live_multi_anchor_sei_update", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_anchor_sei_update", Reflection.getOrCreateKotlinClass(r1), "是否使用SEI来源卸载多人主播连线组件", "null"));
        UltraSettingsManager.b("multi_revenue_double_enter_room_call", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_revenue_double_enter_room_call", Reflection.getOrCreateKotlinClass(r1), "营收场景主播连线double进房请求 兜底", "null"));
        UltraSettingsManager.b("live_rev_use_mix_grids", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rev_use_mix_grids", Reflection.getOrCreateKotlinClass(r1), "是否使用mixGrids", "null"));
        UltraSettingsManager.b("toolbar_pk_entrance_anim_delay_mills", new com.bytedance.tools.kcp.ultrasettings.runtime.c("toolbar_pk_entrance_anim_delay_mills", Reflection.getOrCreateKotlinClass(r2), "PK toolbar 入口动画延迟展示", "null"));
        UltraSettingsManager.b("battle_msg_load_double_pk_check", new com.bytedance.tools.kcp.ultrasettings.runtime.c("battle_msg_load_double_pk_check", Reflection.getOrCreateKotlinClass(r1), "battle消息拉起双人PK校验battleType", "null"));
        UltraSettingsManager.b("live_player_scene_stall_monitor_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_player_scene_stall_monitor_config", Reflection.getOrCreateKotlinClass(com.bytedance.android.live.revlink.impl.monitor.c.class), "场景切换卡顿上报", "null"));
        UltraSettingsManager.b("live_revenue_ai_assistant_cellular_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_revenue_ai_assistant_cellular_config", Reflection.getOrCreateKotlinClass(r41.a.class), "AI助手弱网双发配置", "null"));
        UltraSettingsManager.b("live_pk_be_invite_dialog_overtime", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_be_invite_dialog_overtime", Reflection.getOrCreateKotlinClass(r3), "pk被邀请弹窗展示时间", "null"));
        UltraSettingsManager.b("live_link_feed_stall_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_feed_stall_opt", Reflection.getOrCreateKotlinClass(r1), "预览流卡顿", "null"));
        UltraSettingsManager.b("live_multi_delay_preview_lynx_load", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_delay_preview_lynx_load", Reflection.getOrCreateKotlinClass(r1), "主播连线控制中枢延迟加载", "null"));
        UltraSettingsManager.b("live_multi_nine_pk_client_mixer_performance_limit", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_nine_pk_client_mixer_performance_limit", Reflection.getOrCreateKotlinClass(r4), "多人PK支持最多9人客户端合流最低机型打分要求", "null"));
        UltraSettingsManager.b("live_pk_chorus_mute_back_up_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_chorus_mute_back_up_enable", Reflection.getOrCreateKotlinClass(r1), "合唱静音状态对端异常断联恢复静音状态兜底", "null"));
        UltraSettingsManager.b("live_pk_top_spacing_ratio_addition", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_top_spacing_ratio_addition", Reflection.getOrCreateKotlinClass(r4), "PK合流画面离顶部距离diff", "null"));
        UltraSettingsManager.b("live_multi_audience_super_preload", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_audience_super_preload", Reflection.getOrCreateKotlinClass(r1), "多人连线提前加载", "null"));
        UltraSettingsManager.b("live_revlink_main_tab_pop_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_revlink_main_tab_pop_url", Reflection.getOrCreateKotlinClass(String.class), "首页段位赛段位说明", "null"));
        UltraSettingsManager.b("live_revenue_interact_audio_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_revenue_interact_audio_opt", Reflection.getOrCreateKotlinClass(r1), "电台模式补齐pk连屏能力", "null"));
        UltraSettingsManager.b("live_pk_preload_async", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_preload_async", Reflection.getOrCreateKotlinClass(r1), "pk预加载异步消费数据", "null"));
        UltraSettingsManager.b("multi_anchor_report_receive_audience_stream", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_anchor_report_receive_audience_stream", Reflection.getOrCreateKotlinClass(r1), "多人主播连线上报收到观众流开关", "null"));
        UltraSettingsManager.b("live_pk_support_link", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_support_link", Reflection.getOrCreateKotlinClass(r1), "是否支持PK中观众上麦", "null"));
        UltraSettingsManager.b("multi_link_new_connect_adapt_switch_stream", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_new_connect_adapt_switch_stream", Reflection.getOrCreateKotlinClass(r1), "主播连线建联新链路兼容主备流", "null"));
        UltraSettingsManager.b("live_with_lynx_card_registry", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_with_lynx_card_registry", Reflection.getOrCreateKotlinClass(r1), "jsb关联lynxCard", "null"));
        UltraSettingsManager.b("live_pk_dynamic_hub_lynx_params", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_dynamic_hub_lynx_params", Reflection.getOrCreateKotlinClass(String.class), "连屏PK控制中枢lynx加载params", "null"));
        UltraSettingsManager.b("live_multi_measure_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_measure_opt", Reflection.getOrCreateKotlinClass(r1), "主播连线measureOpt开关", "null"));
        UltraSettingsManager.b("live_link_panel_random_link_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_panel_random_link_url", Reflection.getOrCreateKotlinClass(String.class), "连线面板上随机匹配区域url", "null"));
        UltraSettingsManager.b("live_pk_opt_use_dynamic_container_size_by_get", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_opt_use_dynamic_container_size_by_get", Reflection.getOrCreateKotlinClass(r1), "获取容器宽高时使用初始值还是实时获取", "null"));
        UltraSettingsManager.b("live_multi_dynamic_hub_lynx_params_v2", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_dynamic_hub_lynx_params_v2", Reflection.getOrCreateKotlinClass(String.class), "多人新连屏中枢schema", "null"));
        UltraSettingsManager.b("live_pk_feed_eggs_enter_debug", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_feed_eggs_enter_debug", Reflection.getOrCreateKotlinClass(r3), "Pk预览流彩蛋进房调试", "null"));
        UltraSettingsManager.b("live_pk_feed_init_delay", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_feed_init_delay", Reflection.getOrCreateKotlinClass(r2), "双人pk延迟加载容器开关", "null"));
        UltraSettingsManager.b("multi_revenue_pk_room_battle_id_back_up", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_revenue_pk_room_battle_id_back_up", Reflection.getOrCreateKotlinClass(r1), "pk通过room更新的battleID 兜底", "null"));
        UltraSettingsManager.b("live_pk_api_token_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_api_token_enable", Reflection.getOrCreateKotlinClass(r1), "PK相关接口是否token校验", "null"));
        UltraSettingsManager.b("live_multi_anchor_single_view_overlap_check", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_anchor_single_view_overlap_check", Reflection.getOrCreateKotlinClass(r1), "多人连线单View重叠区域检查", "null"));
        UltraSettingsManager.b("live_relink_invitation_dialog_lynx_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_relink_invitation_dialog_lynx_url", Reflection.getOrCreateKotlinClass(String.class), "多人连线被邀请重连弹窗lynx url", "null"));
        UltraSettingsManager.b("live_multi_dynamic_harmony_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_dynamic_harmony_url", Reflection.getOrCreateKotlinClass(String.class), "多人鸿蒙Setting", "null"));
        UltraSettingsManager.b("live_anchor_link_composite_opt_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_anchor_link_composite_opt_config", Reflection.getOrCreateKotlinClass(r11.b.class), "主播连线综合体验治理配置", "null"));
        UltraSettingsManager.b("live_pk_frequency_control", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_frequency_control", Reflection.getOrCreateKotlinClass(r11.l.class), "PK邀请频控配置", "null"));
        UltraSettingsManager.b("multi_block_pk_render_view_request_layout", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_block_pk_render_view_request_layout", Reflection.getOrCreateKotlinClass(r3), "multi切断pkRenderView同步更新", "null"));
        UltraSettingsManager.b("live_pk_panel_rec_other_s", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_panel_rec_other_s", Reflection.getOrCreateKotlinClass(r.class), "pk面板异步加载开关-全量数据刷新", "null"));
        UltraSettingsManager.b("live_pk_ignore_linker_leave", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_ignore_linker_leave", Reflection.getOrCreateKotlinClass(r1), "PK结束与UserLeave解耦", "null"));
        UltraSettingsManager.b("live_reset_pk_timer_by_msg", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_reset_pk_timer_by_msg", Reflection.getOrCreateKotlinClass(r1), "是否直接监听PK开始消息清空建联倒计时", "null"));
        UltraSettingsManager.b("live_anchor_link_audience_composite_opt_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_anchor_link_audience_composite_opt_enable", Reflection.getOrCreateKotlinClass(r1), "主播连线观众侧综合体验治理优化", "null"));
        UltraSettingsManager.b("live_multi_quit_confirm_dialog_lynx_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_quit_confirm_dialog_lynx_enable", Reflection.getOrCreateKotlinClass(r1), "连屏多人连线退出确认弹窗lynx化", "null"));
        UltraSettingsManager.b("linking_invite_preload_s", new com.bytedance.tools.kcp.ultrasettings.runtime.c("linking_invite_preload_s", Reflection.getOrCreateKotlinClass(r11.j.class), "连线中邀请面板策略", "null"));
        UltraSettingsManager.b("revlink_anim_opt_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("revlink_anim_opt_config", Reflection.getOrCreateKotlinClass(a51.b.class), "PK和主播连线动画优化", "null"));
        UltraSettingsManager.b("live_scene_gift_sync_config_setting", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_scene_gift_sync_config_setting", Reflection.getOrCreateKotlinClass(ys1.b.class), "金主礼物排序端上特征值传递配置", "null"));
        UltraSettingsManager.b("live_pk_enable_lynx_anchor_mic_panel", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_enable_lynx_anchor_mic_panel", Reflection.getOrCreateKotlinClass(r1), "主播麦位弹窗是否使用 lynx 实现", "null"));
        UltraSettingsManager.b("multi_link_remove_window_by_leave_msg", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_link_remove_window_by_leave_msg", Reflection.getOrCreateKotlinClass(r1), "主播连线通过leave消息移除上屏画面", "null"));
        UltraSettingsManager.b("live_pk_prop_card_setting_show", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_prop_card_setting_show", Reflection.getOrCreateKotlinClass(r1), "启动道具卡玩法设置开关", "null"));
        UltraSettingsManager.b("live_pk_random_match_type_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_random_match_type_fix", Reflection.getOrCreateKotlinClass(r1), "随机PK请求matchType修复", "null"));
        UltraSettingsManager.b("live_player_layout_opt_v1", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_player_layout_opt_v1", Reflection.getOrCreateKotlinClass(r1), "播发器优化开关", "null"));
        UltraSettingsManager.b("link_anchor_profile_precise_experiment", new com.bytedance.tools.kcp.ultrasettings.runtime.c("link_anchor_profile_precise_experiment", Reflection.getOrCreateKotlinClass(r1), "连屏主播资料卡预请求走精准实验", "null"));
        UltraSettingsManager.b("live_anchor_link_pk_auto_refuse_fallback", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_anchor_link_pk_auto_refuse_fallback", Reflection.getOrCreateKotlinClass(r1), "PK自动拒绝逻辑fallback", "null"));
        UltraSettingsManager.b("live_pk_hybrid_share_group", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_hybrid_share_group", Reflection.getOrCreateKotlinClass(r1), "双人pk动态化js环境共享开关", "null"));
        UltraSettingsManager.b("anchor_data_handover_by_pk_is_stopengine", new com.bytedance.tools.kcp.ultrasettings.runtime.c("anchor_data_handover_by_pk_is_stopengine", Reflection.getOrCreateKotlinClass(r1), "PK结束后的数据交接与否与PK是否stopEngine保持一致", "null"));
        UltraSettingsManager.b("live_revenue_player_duplicate_check", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_revenue_player_duplicate_check", Reflection.getOrCreateKotlinClass(r1), "营收新布局去重", "null"));
        UltraSettingsManager.b("live_multi_anchor_sei_overlap_report_control", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_anchor_sei_overlap_report_control", Reflection.getOrCreateKotlinClass(r2), "多人连线sei重叠区域上报频控", "null"));
        UltraSettingsManager.b("multi_anchor_forward_opt_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_anchor_forward_opt_enable", Reflection.getOrCreateKotlinClass(r1), "主播连线跨房优化开关", "null"));
        UltraSettingsManager.b("rev_spatial_audio_listener_position_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("rev_spatial_audio_listener_position_config", Reflection.getOrCreateKotlinClass(vf1.class), "不同场景下观众在空间音频中的位置和朝向信息", "null"));
        UltraSettingsManager.b("anchor_pk_update_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("anchor_pk_update_enable", Reflection.getOrCreateKotlinClass(r1), "PK，主播连线，双人聊的SEI更新间隔降低为1s", "null"));
        UltraSettingsManager.b("live_multi_battle_finish_audience_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_battle_finish_audience_opt", Reflection.getOrCreateKotlinClass(r1), "多人PK battle finish优化观众开关", "null"));
        UltraSettingsManager.b("revlink_pk_match_bell_dialog_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("revlink_pk_match_bell_dialog_url", Reflection.getOrCreateKotlinClass(String.class), "PK匹配铃弹窗url", "null"));
        UltraSettingsManager.b("break_through_atmosphere_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("break_through_atmosphere_url", Reflection.getOrCreateKotlinClass(String.class), "闯关氛围动效动态配置", "null"));
        UltraSettingsManager.b("live_pk_dynamic_hub_load_trace_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_dynamic_hub_load_trace_enable", Reflection.getOrCreateKotlinClass(r1), "连屏PK控制中枢加载打点上报", "null"));
        UltraSettingsManager.b("live_multi_async_preload_data", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_async_preload_data", Reflection.getOrCreateKotlinClass(r1), "异步消费预加载数据", "null"));
        UltraSettingsManager.b("live_annie_x_execute_load_failed", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_annie_x_execute_load_failed", Reflection.getOrCreateKotlinClass(r1), "使用 AnnieX 后正常执行 onLoadFaield", "null"));
        UltraSettingsManager.b("create_link_hub_anniex_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("create_link_hub_anniex_enable", Reflection.getOrCreateKotlinClass(r1), "建连中枢是否使用anniex", "null"));
        UltraSettingsManager.b("pk_prop_card_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("pk_prop_card_config", Reflection.getOrCreateKotlinClass(r41.j.class), "PK道具卡玩法相关配置", "null"));
        UltraSettingsManager.b("live_pk_enable_chorus", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_enable_chorus", Reflection.getOrCreateKotlinClass(r1), "PK连线合唱玩法开关", "null"));
        UltraSettingsManager.b("multi_anchor_forward_info_update_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_anchor_forward_info_update_opt", Reflection.getOrCreateKotlinClass(r1), "主播连线跨房推流信息支持直接更新而不是增量", "null"));
        UltraSettingsManager.b("anchor_link_profit_interaction_data_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("anchor_link_profit_interaction_data_fix", Reflection.getOrCreateKotlinClass(r1), "连线记值/计时数据初始化时机修改", "null"));
        UltraSettingsManager.b("live_link_degrade_setting", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_link_degrade_setting", Reflection.getOrCreateKotlinClass(r11.e.class), "连线性能降级阈值配置", "null"));
        UltraSettingsManager.b("live_relink_waiting_dialog_lynx_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_relink_waiting_dialog_lynx_url", Reflection.getOrCreateKotlinClass(String.class), "多人连线邀请重连等待弹窗lynx url", "null"));
        UltraSettingsManager.b("live_rev_multi_relayout_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rev_multi_relayout_opt", Reflection.getOrCreateKotlinClass(r1), "主播连线布局跳变", "null"));
        UltraSettingsManager.b("live_pk_wangzhe_landscape_change_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_wangzhe_landscape_change_fix", Reflection.getOrCreateKotlinClass(r1), "横竖屏切换按钮bugfix", "null"));
        UltraSettingsManager.b("live_multi_linker_backup_stream_disable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_linker_backup_stream_disable", Reflection.getOrCreateKotlinClass(r1), "多人主播连线主备流开关", "null"));
        UltraSettingsManager.b("live_pk_next_live_data_with_notify_fix", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_next_live_data_with_notify_fix", Reflection.getOrCreateKotlinClass(r1), "NextLiveData订阅时立即回调修复", "null"));
        UltraSettingsManager.b("live_pk_double_lynx_mic_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_double_lynx_mic_enable", Reflection.getOrCreateKotlinClass(r1), "双人pk连线层视图是否用lynx，包括对方信息、上局结果、静音", "null"));
        UltraSettingsManager.b("live_pk_panel_speed_up_rf", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_panel_speed_up_rf", Reflection.getOrCreateKotlinClass(r1), "pk面板异步加载开关-匹配/关注一起出", "null"));
        UltraSettingsManager.b("live_pk_time_stuck_check", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_time_stuck_check", Reflection.getOrCreateKotlinClass(r1), "是否检测PK倒计时卡在0：00", "null"));
        UltraSettingsManager.b("live_pk_disable_toast", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_disable_toast", Reflection.getOrCreateKotlinClass(String.class), "禁止PK时toast文案", "null"));
        UltraSettingsManager.b("live_pk_get_extra_first_sei", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_get_extra_first_sei", Reflection.getOrCreateKotlinClass(r1), "PK组件加载firstSei兜底", "null"));
        UltraSettingsManager.b("live_pk_atmosphere_animation_urls", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_atmosphere_animation_urls", Reflection.getOrCreateKotlinClass(r41.g.class), "pk运营氛围的一大堆动画url", "null"));
        UltraSettingsManager.b("live_multi_pk_sofa_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_pk_sofa_opt", Reflection.getOrCreateKotlinClass(r1), "主播多人PK新增金主沙发位", "null"));
        UltraSettingsManager.b("live_sei_close_load_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_sei_close_load_enable", Reflection.getOrCreateKotlinClass(r1), "SEI兜底逻辑修复", "null"));
        UltraSettingsManager.b("report_revlink_widget_loaded_but_not_shown", new com.bytedance.tools.kcp.ultrasettings.runtime.c("report_revlink_widget_loaded_but_not_shown", Reflection.getOrCreateKotlinClass(r1), "是否上报Widget的Trace", "null"));
        UltraSettingsManager.b("live_pk_sei_data_merge_opt_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_sei_data_merge_opt_enable", Reflection.getOrCreateKotlinClass(r1), "合并流sei和lynx_seiData", "null"));
        UltraSettingsManager.b("live_random_match_panel_lynx_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_random_match_panel_lynx_url", Reflection.getOrCreateKotlinClass(String.class), "连屏双人随机匹配面板lynx url", "null"));
        UltraSettingsManager.b("live_multi_load_pve_bar", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_load_pve_bar", Reflection.getOrCreateKotlinClass(r1), "是否加载NavitePVE血条组件", "null"));
        UltraSettingsManager.b("live_multi_anchor_sei_load_backup_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_anchor_sei_load_backup_enable", Reflection.getOrCreateKotlinClass(r1), "多人主播连线场景sei兜底加载", "null"));
        UltraSettingsManager.b("live_multi_event_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_event_opt", Reflection.getOrCreateKotlinClass(r1), "多人动态化event优化", "null"));
        UltraSettingsManager.b("live_multi_empty_event_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_empty_event_opt", Reflection.getOrCreateKotlinClass(r1), "多人动态化空值event优化", "null"));
        UltraSettingsManager.b("live_pk_add_or_edit_custom_play_lynx_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_add_or_edit_custom_play_lynx_url", Reflection.getOrCreateKotlinClass(String.class), "pk自定义玩法编辑页面lynx url", "null"));
        UltraSettingsManager.b("anchor_bluetooth_permission", new com.bytedance.tools.kcp.ultrasettings.runtime.c("anchor_bluetooth_permission", Reflection.getOrCreateKotlinClass(r1), "主播开播申请蓝牙权限适配target33", "null"));
        UltraSettingsManager.b("live_multi_shell_pk_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_shell_pk_enable", Reflection.getOrCreateKotlinClass(r1), "是否支持多人比拼", "null"));
        UltraSettingsManager.b("live_relink_invitation_dialog_lynx_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_relink_invitation_dialog_lynx_enable", Reflection.getOrCreateKotlinClass(r1), "多人连线邀请重连弹窗lynx化", "null"));
        UltraSettingsManager.b("live_pk_audience_score_message_filter", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_audience_score_message_filter", Reflection.getOrCreateKotlinClass(r1), "开关控制是否对消息校验防止分值回退", "null"));
        UltraSettingsManager.b("live_rev_double_manaual_update_link_user_center", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_rev_double_manaual_update_link_user_center", Reflection.getOrCreateKotlinClass(r1), "Double手动更新AnchorLinkUserCenter", "null"));
        UltraSettingsManager.b("pk_background_stream_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("pk_background_stream_opt", Reflection.getOrCreateKotlinClass(r1), "PK添加背景图", "null"));
        UltraSettingsManager.b("live_connection_invite_tracking_delay", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_connection_invite_tracking_delay", Reflection.getOrCreateKotlinClass(r1), "livesdk_connection_invited延迟上报开关", "null"));
        UltraSettingsManager.b("live_double_pk_contribution_list_lynx_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_double_pk_contribution_list_lynx_url", Reflection.getOrCreateKotlinClass(String.class), "双人PK贡献榜lynx url", "null"));
        UltraSettingsManager.b("livesdk_pk_precise_find_people_config", new com.bytedance.tools.kcp.ultrasettings.runtime.c("livesdk_pk_precise_find_people_config", Reflection.getOrCreateKotlinClass(r41.h.class), "PK精准找人配置", "null"));
        UltraSettingsManager.b("live_multi_anchor_sort_sei_guest", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_anchor_sort_sei_guest", Reflection.getOrCreateKotlinClass(r1), "多人连线 sei排序开关（观众）", "null"));
        UltraSettingsManager.b("live_region_ts_change_by_layout", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_region_ts_change_by_layout", Reflection.getOrCreateKotlinClass(r1), "region校验增加位置", "null"));
        UltraSettingsManager.b("live_pk_progress_bar_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_progress_bar_opt", Reflection.getOrCreateKotlinClass(r1), "pk过成挑战优化血条优化部分", "null"));
        UltraSettingsManager.b("link_anchor_profile_opt_consume_level", new com.bytedance.tools.kcp.ultrasettings.runtime.c("link_anchor_profile_opt_consume_level", Reflection.getOrCreateKotlinClass(r3), "连屏主播资料卡预请求限制消费分层", "null"));
        UltraSettingsManager.b("live_multi_change_background_image_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_change_background_image_enable", Reflection.getOrCreateKotlinClass(r1), "多人是否加载测试控制中枢，这个专门用来修改背景图", "null"));
        UltraSettingsManager.b("live_support_start_pk_with_audience", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_support_start_pk_with_audience", Reflection.getOrCreateKotlinClass(r1), "是否支持主播带嘉宾发起 PK", "null"));
        UltraSettingsManager.b("live_multi_link_illegal_frame_check_time", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_link_illegal_frame_check_time", Reflection.getOrCreateKotlinClass(r2), "串流首帧校验的定时器时长", "null"));
        UltraSettingsManager.b("live_pk_peak_period_adjust_duration_top_tip", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_peak_period_adjust_duration_top_tip", Reflection.getOrCreateKotlinClass(String.class), "PK高峰期默认时长调整贴士条文案", "null"));
        UltraSettingsManager.b("live_sei_reply_message_ack", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_sei_reply_message_ack", Reflection.getOrCreateKotlinClass(r1), "reply消息ack通过SEI传递", "null"));
        UltraSettingsManager.b("live_revlink_host_selection_page", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_revlink_host_selection_page", Reflection.getOrCreateKotlinClass(String.class), "连麦主持人移交选择弹窗", "null"));
        UltraSettingsManager.b("live_multi_annie_x_execute_load_failed", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_annie_x_execute_load_failed", Reflection.getOrCreateKotlinClass(r1), "多人使用 AnnieX 后正常执行 onLoadFaield", "null"));
        UltraSettingsManager.b("live_multi_pk_contribution_list_lynx_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_pk_contribution_list_lynx_url", Reflection.getOrCreateKotlinClass(String.class), "多人/组队PK贡献榜lynx url", "null"));
        UltraSettingsManager.b("live_multi_anchor_single_view", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_anchor_single_view", Reflection.getOrCreateKotlinClass(r1), "多主播连线是否开启单View模式", "null"));
        UltraSettingsManager.b("multi_anchor_remove_data_holder", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_anchor_remove_data_holder", Reflection.getOrCreateKotlinClass(r1), "主播连线移除dataHolder依赖", "null"));
        UltraSettingsManager.b("live_revenue_interact_new_custom_lynx_url", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_revenue_interact_new_custom_lynx_url", Reflection.getOrCreateKotlinClass(String.class), "自定义PK整合新页面lynx schema", "null"));
        UltraSettingsManager.b("link_panel_error_opt", new com.bytedance.tools.kcp.ultrasettings.runtime.c("link_panel_error_opt", Reflection.getOrCreateKotlinClass(r1), "PK面板接口错误时展示随机匹配入口", "null"));
        UltraSettingsManager.b("live_silence_request_merge", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_silence_request_merge", Reflection.getOrCreateKotlinClass(r1), "scene融合多人静音对齐双人", "null"));
        UltraSettingsManager.b("live_multi_configure_bg_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_configure_bg_enable", Reflection.getOrCreateKotlinClass(r1), "多人连线支持下发配置背景", "null"));
        UltraSettingsManager.b("live_multi_anchor_sei_overlap_check", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_multi_anchor_sei_overlap_check", Reflection.getOrCreateKotlinClass(r1), "多人连线Sei重叠区域检查", "null"));
        UltraSettingsManager.b("multi_revenue_link_enter_check_threshold", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_revenue_link_enter_check_threshold", Reflection.getOrCreateKotlinClass(r2), "连线进房mode变更阈值检测", "null"));
        UltraSettingsManager.b("live_random_check_background", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_random_check_background", Reflection.getOrCreateKotlinClass(String.class), "随机匹配规则确认面板背景图url", "null"));
        UltraSettingsManager.b("live_data_link_switch_to_pk", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_data_link_switch_to_pk", Reflection.getOrCreateKotlinClass(r1), "连线切pk数据重设", "null"));
        UltraSettingsManager.b("live_revlink_anchor_more_resize", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_revlink_anchor_more_resize", Reflection.getOrCreateKotlinClass(r1), "主播连屏布局超过4人调整", "null"));
        UltraSettingsManager.b("live_pk_feed_ktv_init_delay", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_feed_ktv_init_delay", Reflection.getOrCreateKotlinClass(r1), "双人pk延迟加载容器开关", "null"));
        UltraSettingsManager.b("live_pk_audience_load_track", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_audience_load_track", Reflection.getOrCreateKotlinClass(r1), "控制是否pk组件加载完成上报", "null"));
        UltraSettingsManager.b("live_pk_live_room_opt_anchor", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_live_room_opt_anchor", Reflection.getOrCreateKotlinClass(r3), "Pk 直播间对局体验优化主播强制关闭", "null"));
        UltraSettingsManager.b("anchor_pk_close_sei", new com.bytedance.tools.kcp.ultrasettings.runtime.c("anchor_pk_close_sei", Reflection.getOrCreateKotlinClass(r1), "多人场景切到PK时，关闭非关键帧SEI", "null"));
        UltraSettingsManager.b("live_pk_feed_eggs_debug", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_feed_eggs_debug", Reflection.getOrCreateKotlinClass(r1), "Pk预览流彩蛋调试", "null"));
        UltraSettingsManager.b("multi_anchor_block_digg", new com.bytedance.tools.kcp.ultrasettings.runtime.c("multi_anchor_block_digg", Reflection.getOrCreateKotlinClass(r1), "多人主播连线场景 屏蔽主播自己给自己点赞功能", "null"));
        UltraSettingsManager.b("live_pk_audience_api_call_tea_enable", new com.bytedance.tools.kcp.ultrasettings.runtime.c("live_pk_audience_api_call_tea_enable", Reflection.getOrCreateKotlinClass(r1), "pk观众侧api tea埋点上报", "null"));
        UltraSettingsManager.b("rev_spatial_audio_position_interval", new com.bytedance.tools.kcp.ultrasettings.runtime.c("rev_spatial_audio_position_interval", Reflection.getOrCreateKotlinClass(r3), "营收连屏场景空间音频位置间隔", "null"));
    }
}
