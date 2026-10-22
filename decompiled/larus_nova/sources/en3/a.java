package en3;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.bytedance.tools.kcp.ultrasettings.runtime.c;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes14.dex */
public final class a {
    @JvmStatic
    public static final void a() {
        ConcurrentHashMap<String, c> r100 = UltraSettingsManager.f271014a;
        Class r101 = Boolean.TYPE;
        UltraSettingsManager.b("livesdk_share_view_immediate_create_standalone_sharer", new c("livesdk_share_view_immediate_create_standalone_sharer", Reflection.getOrCreateKotlinClass(r101), "不等待中枢延迟，直接加载独立的 Sharer", "jinkang"));
        UltraSettingsManager.b("enableShareViewFirstScreen", new c("enableShareViewFirstScreen", Reflection.getOrCreateKotlinClass(r101), "是否ShareView启用首帧直出", "dangyingkai"));
        UltraSettingsManager.b("livesdk_share_view_force_enable_standalone", new c("livesdk_share_view_force_enable_standalone", Reflection.getOrCreateKotlinClass(r101), "强制使用独立运行的Sharer", "dangyingkai"));
        UltraSettingsManager.b("livesdk_share_view_trigger_service_center_load", new c("livesdk_share_view_trigger_service_center_load", Reflection.getOrCreateKotlinClass(r101), "ShareView是否会触发服务中枢的加载，即跳过服务中枢的延迟加载", "dangyingkai"));
        UltraSettingsManager.b("livesdk_share_view_sharer_schema", new c("livesdk_share_view_sharer_schema", Reflection.getOrCreateKotlinClass(String.class), "独立运行的Sharer schema", "dangyingkai"));
        UltraSettingsManager.b("aioLink_message_deserialize_double_switch", new c("aioLink_message_deserialize_double_switch", Reflection.getOrCreateKotlinClass(r101), "aiolink修复解析数字类型为double的开关", "lifengji"));
        UltraSettingsManager.b("livesdk_share_view_min_service_center_version", new c("livesdk_share_view_min_service_center_version", Reflection.getOrCreateKotlinClass(String.class), "支持ShareView的服务中枢的最低版本", "dangyingkai"));
        UltraSettingsManager.b("livesdk_share_view_enable_standalone", new c("livesdk_share_view_enable_standalone", Reflection.getOrCreateKotlinClass(r101), "是否允许独立运行的Sharer", "dangyingkai"));
        UltraSettingsManager.b("live_harmony_gift_panel_opt_v1", new c("live_harmony_gift_panel_opt_v1", Reflection.getOrCreateKotlinClass(r101), "鸿蒙礼物面板优化", "null"));
    }

    static {
    }
}
