package nu0;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f520585a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f520586b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f520587c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f520588d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f520589e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f520590f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f520591g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f520592h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f520593i = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(l.class, "LIVE_FORMAT_VOICE_CHAT_RULE_URL", "getLIVE_FORMAT_VOICE_CHAT_RULE_URL()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(l.class, "LIVE_FORMAT_VOICE_CHAT_RTC_CONFIG", "getLIVE_FORMAT_VOICE_CHAT_RTC_CONFIG()Lcom/bytedance/android/live/profit/format/voicechat/config/VoiceChatRTCConfig;", 1)), Reflection.property0(new PropertyReference0Impl(l.class, "LIVE_FORMAT_VOICE_CHAT_TIMEOUT_INTERVAL", "getLIVE_FORMAT_VOICE_CHAT_TIMEOUT_INTERVAL()J", 1)), Reflection.property0(new PropertyReference0Impl(l.class, "LIVE_FORMAT_VOICE_CHAT_ANIM_DELAY", "getLIVE_FORMAT_VOICE_CHAT_ANIM_DELAY()J", 1)), Reflection.property0(new PropertyReference0Impl(l.class, "LIVE_FORMAT_VOICE_CHAT_USE_PB", "getLIVE_FORMAT_VOICE_CHAT_USE_PB()Z", 1)), Reflection.property0(new PropertyReference0Impl(l.class, "LIVE_FORMAT_VOICE_CHAT_TRACE", "getLIVE_FORMAT_VOICE_CHAT_TRACE()Z", 1)), Reflection.property0(new PropertyReference0Impl(l.class, "LIVE_FORMAT_VOICE_CHAT_THINK_DURATION", "getLIVE_FORMAT_VOICE_CHAT_THINK_DURATION()J", 1)), Reflection.property0(new PropertyReference0Impl(l.class, "LIVE_FORMAT_VOICE_CHAT_BLUETOOTH_PERMISSION_CHECK", "getLIVE_FORMAT_VOICE_CHAT_BLUETOOTH_PERMISSION_CHECK()Z", 1))};
        f520585a = r100;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_format_voice_chat_rule_url", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_privileges_lynx_douyin%2Fpages%2Fai_avatar_skills_rule%2Ftemplate.js&mask_alpha=0.3&show_dim=1&gravity=bottom&type=popup&rate_height=400&horizontal_width=375", String.class, false);
        f520586b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_format_voice_chat_rtc_config", new iu0.a(), iu0.a.class, false);
        f520587c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        Class r110 = Long.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_format_voice_chat_timeout_interval", 20L, r110, false);
        f520588d = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_format_voice_chat_anim_delay", 1800L, r110, false);
        f520589e = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[3]);
        Boolean r105 = Boolean.TRUE;
        Class r106 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_format_voice_chat_use_pb", r105, r106, false);
        f520590f = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_format_voice_chat_trace", r105, r106, false);
        f520591g = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r109 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_format_voice_chat_think_duration", 1000L, r110, false);
        f520592h = UltraSettingsManager.a().a(r109.f271017a, r109.f271018b, r109.getType(), r109.f271020d, r100[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r111 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_format_voice_chat_bluetooth_permission_check", r105, r106, false);
        f520593i = UltraSettingsManager.a().a(r111.f271017a, r111.f271018b, r111.getType(), r111.f271020d, r100[7]);
    }
}
