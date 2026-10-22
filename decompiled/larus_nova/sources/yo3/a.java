package yo3;

import com.bytedance.android.livesdk.config.v01;
import com.bytedance.android.livesdk.config.z51;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.bytedance.tools.kcp.ultrasettings.runtime.c;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Type f568664a = null;

    /* JADX INFO: renamed from: yo3.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"yo3/a$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "revenue-link-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class C8365a extends TypeToken<Integer[]> {
        public C8365a() {
        }
    }

    static {
        Type r100 = new C8365a().getType();
        Intrinsics.checkNotNull(r100);
        f568664a = r100;
    }

    @JvmStatic
    public static final void a() {
        ConcurrentHashMap<String, c> r100 = UltraSettingsManager.f271014a;
        Class r101 = Boolean.TYPE;
        UltraSettingsManager.b("live_rev_pk_talk_volume_enable", new c("live_rev_pk_talk_volume_enable", Reflection.getOrCreateKotlinClass(r101), "主播pk场景的sei透传说话音量字段开关", "null"));
        UltraSettingsManager.b("live_link_sdk_multi_supported_scenes", new c("live_link_sdk_multi_supported_scenes", f568664a, "直播连麦场景接入LiveLinkSDK", "null"));
        UltraSettingsManager.b("live_revenue_screen_cast_link_opt", new c("live_revenue_screen_cast_link_opt", Reflection.getOrCreateKotlinClass(r101), "启用新的录屏开播连线逻辑", "null"));
        UltraSettingsManager.b("rev_link_rtc_test_env", new c("rev_link_rtc_test_env", Reflection.getOrCreateKotlinClass(r101), "连屏场景RTC测试环境开关", "null"));
        UltraSettingsManager.b("live_pk_monitor_rtc_resolution_enable", new c("live_pk_monitor_rtc_resolution_enable", Reflection.getOrCreateKotlinClass(r101), "pk及多人主播连线监控推流分辨率开关", "null"));
        UltraSettingsManager.b("live_stream_enable_sei_sign", new c("live_stream_enable_sei_sign", Reflection.getOrCreateKotlinClass(r101), "是否启用SEI帧签名", "null"));
        UltraSettingsManager.b("live_msg_channel_setting", new c("live_msg_channel_setting", Reflection.getOrCreateKotlinClass(z51.class), "消息多通道开关", "null"));
        UltraSettingsManager.b("live_link_sdk_enable_switch", new c("live_link_sdk_enable_switch", Reflection.getOrCreateKotlinClass(r101), "LiveLinkSDK兜底开关", "null"));
        UltraSettingsManager.b("live_rev_kibana_log_debug", new c("live_rev_kibana_log_debug", Reflection.getOrCreateKotlinClass(r101), "营收kibanaLogDebug开关", "null"));
        UltraSettingsManager.b("update_room_by_invite_result", new c("update_room_by_invite_result", Reflection.getOrCreateKotlinClass(r101), "使用invite回包的room更新inviteParams", "null"));
        UltraSettingsManager.b("show_link_cross_room_reset_stacktrace", new c("show_link_cross_room_reset_stacktrace", Reflection.getOrCreateKotlinClass(r101), "LinkCrossRoomDataHolder reset 时是否 alog 打印 stacktrace", "null"));
        UltraSettingsManager.b("live_core_reset_params_leave_channel", new c("live_core_reset_params_leave_channel", Reflection.getOrCreateKotlinClass(r101), "下麦时重置LiveCore参数新方式", "null"));
        UltraSettingsManager.b("enable_rtc_chorus_optimic", new c("enable_rtc_chorus_optimic", Reflection.getOrCreateKotlinClass(r101), "开启rtc副唱优化", "null"));
        UltraSettingsManager.b("live_check_linker_enable", new c("live_check_linker_enable", Reflection.getOrCreateKotlinClass(r101), "是否开启上报，默认开启", "null"));
        UltraSettingsManager.b("live_revenue_interact_forward_stream_opt_enable", new c("live_revenue_interact_forward_stream_opt_enable", Reflection.getOrCreateKotlinClass(r101), "跨房推流优化开关", "null"));
        UltraSettingsManager.b("live_check_linker_interval", new c("live_check_linker_interval", Reflection.getOrCreateKotlinClass(Integer.TYPE), "连线id上传轮训间隔", "null"));
        UltraSettingsManager.b("live_monitor_livecore_resolution_enable", new c("live_monitor_livecore_resolution_enable", Reflection.getOrCreateKotlinClass(r101), "pk及多人主播连线监控裁剪分辨率开关", "null"));
        UltraSettingsManager.b("multi_link_audience_rtc_render_yuv_opt", new c("multi_link_audience_rtc_render_yuv_opt", Reflection.getOrCreateKotlinClass(r101), "多人场景嘉宾侧RTC渲染YUV优化", "null"));
        UltraSettingsManager.b("link_rev_connect_config", new c("link_rev_connect_config", Reflection.getOrCreateKotlinClass(v01.class), "建联超时等配置", "null"));
        UltraSettingsManager.b("live_linkmic_api_fetch_use_uplink", new c("live_linkmic_api_fetch_use_uplink", Reflection.getOrCreateKotlinClass(r101), "连麦api请求是否用上行uplink发送", "null"));
        UltraSettingsManager.b("live_turn_on_opt_enable", new c("live_turn_on_opt_enable", Reflection.getOrCreateKotlinClass(r101), "开启RTC超时leave channel", "null"));
    }
}
