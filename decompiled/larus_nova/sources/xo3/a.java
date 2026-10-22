package xo3;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.bytedance.tools.kcp.ultrasettings.runtime.c;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Type f564668a = null;

    /* JADX INFO: renamed from: xo3.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"xo3/a$a", "Lcom/google/gson/reflect/TypeToken;", "Ljava/util/ArrayList;", "", "revenue-link-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class C8262a extends TypeToken<ArrayList<String>> {
        public C8262a() {
        }
    }

    static {
        Type r100 = new C8262a().getType();
        Intrinsics.checkNotNull(r100);
        f564668a = r100;
    }

    @JvmStatic
    public static final void a() {
        ConcurrentHashMap<String, c> r100 = UltraSettingsManager.f271014a;
        Class r101 = Boolean.TYPE;
        UltraSettingsManager.b("multi_anchor_cache_list_opt_enable", new c("multi_anchor_cache_list_opt_enable", Reflection.getOrCreateKotlinClass(r101), "PK&主播连线cacheList在leave消息时不清理", "null"));
        UltraSettingsManager.b("live_link_media_info_change_callback_enable", new c("live_link_media_info_change_callback_enable", Reflection.getOrCreateKotlinClass(r101), "是否支持分辨率切换时上报状态", "null"));
        UltraSettingsManager.b("live_monitor_rtc_resolutio_redundancy_threshold", new c("live_monitor_rtc_resolutio_redundancy_threshold", Reflection.getOrCreateKotlinClass(Float.TYPE), "pk及多人主播连线监控推流分辨率阈值", "null"));
        UltraSettingsManager.b("interact_fulllink_point_blacklist", new c("interact_fulllink_point_blacklist", f564668a, "连麦全链路埋点黑名单，命中的不上报", "null"));
        UltraSettingsManager.b("live_unmute_audio_on_leave_enable", new c("live_unmute_audio_on_leave_enable", Reflection.getOrCreateKotlinClass(r101), "音频静音兜底", "null"));
        UltraSettingsManager.b("live_mix_start_success_optimize", new c("live_mix_start_success_optimize", Reflection.getOrCreateKotlinClass(r101), "设置连线liveCore参数检查", "null"));
        UltraSettingsManager.b("pk_trance_log_enable", new c("pk_trance_log_enable", Reflection.getOrCreateKotlinClass(r101), "PK端监控接入Trace", "null"));
        UltraSettingsManager.b("live_mix_interceptor_enable", new c("live_mix_interceptor_enable", Reflection.getOrCreateKotlinClass(r101), "后置合流拦截开关", "null"));
        UltraSettingsManager.b("multi_anchor_message_enable", new c("multi_anchor_message_enable", Reflection.getOrCreateKotlinClass(r101), "消息触发主播连线加载不请求list接口", "null"));
        UltraSettingsManager.b("link_set_volume_reason_enable", new c("link_set_volume_reason_enable", Reflection.getOrCreateKotlinClass(r101), "是否支持带reason的音量调节api", "null"));
        UltraSettingsManager.b("live_core_another_live_core_write", new c("live_core_another_live_core_write", Reflection.getOrCreateKotlinClass(r101), "liveCore赋值兜底", "null"));
        Class r102 = Integer.TYPE;
        UltraSettingsManager.b("multi_anchor_cross_channel_backup_timer_duration", new c("multi_anchor_cross_channel_backup_timer_duration", Reflection.getOrCreateKotlinClass(r102), "多人主播连线兜底超时", "null"));
        UltraSettingsManager.b("sei_load_force_request_list", new c("sei_load_force_request_list", Reflection.getOrCreateKotlinClass(r101), "SEI加载一定请求list接口", "null"));
        UltraSettingsManager.b("anchor_link_mix_type", new c("anchor_link_mix_type", Reflection.getOrCreateKotlinClass(r102), "PK和主播连线合流方式选择，-1不设置，0服务端合流，1客户端合流，2RTC客户端合流", "null"));
        UltraSettingsManager.b("live_link_screen_record_vol_fix", new c("live_link_screen_record_vol_fix", Reflection.getOrCreateKotlinClass(r101), "录屏连线回音问题修复", "null"));
        UltraSettingsManager.b("multi_anchor_cross_channel_check_enable", new c("multi_anchor_cross_channel_check_enable", Reflection.getOrCreateKotlinClass(r102), "主播连线跨房兜底逻辑", "null"));
        UltraSettingsManager.b("multi_anchor_leave_msg_opt_enable", new c("multi_anchor_leave_msg_opt_enable", Reflection.getOrCreateKotlinClass(r101), "多人主播连线消费leave消息不请求list", "null"));
    }
}
