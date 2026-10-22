package vm2;

import com.bytedance.android.livesdk.config.d9;
import com.bytedance.android.livesdk.config.l8;
import com.bytedance.android.livesdk.config.nb1;
import com.bytedance.android.livesdk.config.y8;
import com.bytedance.android.livesdk.model.e0;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.LiveBackupSeiSettingConfig;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes11.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f556321a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f556322b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f556323c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f556324d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f556325e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f556326f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f556327g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f556328h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f556329i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReadOnlyProperty f556330j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ReadOnlyProperty f556331k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ReadOnlyProperty f556332l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ReadOnlyProperty f556333m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ReadOnlyProperty f556334n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ReadOnlyProperty f556335o = null;

    public static final d9 a() {
        return (d9) f556334n.getValue(null, f556321a[12]);
    }

    public static final boolean b() {
        return ((Boolean) f556327g.getValue(null, f556321a[5])).booleanValue();
    }

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_AUTO_APPLY_PAID_LINK_AUDIO", "getLIVE_AUTO_APPLY_PAID_LINK_AUDIO()Z", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_PLAYER_VIEW_LAYOUT_CONFIG", "getLIVE_PLAYER_VIEW_LAYOUT_CONFIG()Ljava/util/HashMap;", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_MULTI_LINK_GIFT_IMPROVE", "getLIVE_MULTI_LINK_GIFT_IMPROVE()Lcom/bytedance/android/livesdk/config/MultiLinkGiftImproveConfig;", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_MULTI_LINK_SAR_EFFECT_DEBUG", "getLIVE_MULTI_LINK_SAR_EFFECT_DEBUG()Lcom/bytedance/android/livesdk/model/MultiLinkLynxEffectEntrance;", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_MULTI_LINK_AMAZ_EFFECT_DEBUG", "getLIVE_MULTI_LINK_AMAZ_EFFECT_DEBUG()Lcom/bytedance/android/livesdk/model/MultiLinkLynxEffectEntrance;", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_MULTI_LINK_MICSEAT_MIX_STREAM_ENABLE", "getLIVE_MULTI_LINK_MICSEAT_MIX_STREAM_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_MULTI_LINK_RENDER_FILTER_FIX_GRAY3", "getLIVE_MULTI_LINK_RENDER_FILTER_FIX_GRAY3()Z", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_VIDEO_COMMENT_AWEME_LIST_FIRST_PAGE_REQUEST_COUNT", "getLIVE_VIDEO_COMMENT_AWEME_LIST_FIRST_PAGE_REQUEST_COUNT()I", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_VIDEO_COMMENT_AWEME_LIST_PAGE_REQUEST_COUNT", "getLIVE_VIDEO_COMMENT_AWEME_LIST_PAGE_REQUEST_COUNT()I", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_CHANNEL_LIVE_MIX_DEFAULT_VOLUME", "getLIVE_CHANNEL_LIVE_MIX_DEFAULT_VOLUME()I", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_CHANNEL_LINK_AUDIO_PROCESS_DELAY_ENABLE", "getLIVE_CHANNEL_LINK_AUDIO_PROCESS_DELAY_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_KTV_AVATAR_RESOURCE_CONFIG", "getLIVE_KTV_AVATAR_RESOURCE_CONFIG()Lcom/bytedance/android/livesdk/config/KtvAvatarResourceConfig;", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_KTV_ROOM_UI_RESOURCE", "getLIVE_KTV_ROOM_UI_RESOURCE()Lcom/bytedance/android/livesdk/config/KtvRoomUIResource;", 1)), Reflection.property0(new PropertyReference0Impl(k.class, "LIVE_BACKUP_SEI_SETTING_CONFIG", "getLIVE_BACKUP_SEI_SETTING_CONFIG()Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/LiveBackupSeiSettingConfig;", 1))};
        f556321a = r100;
        Boolean r110 = Boolean.TRUE;
        Class r111 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_auto_apply_paid_link_audio", r110, r111, false);
        f556322b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        int r112 = l8.f120658a;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_player_view_layout_config", l8.a.a(), eo3.a.f473290c, false);
        f556323c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_link_gift_improve", new nb1(), nb1.class, false);
        f556324d = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_link_lynx_effect_url", new e0(6), e0.class, false);
        f556325e = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_link_amaz_effect_debug", new e0(6), e0.class, false);
        f556326f = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enable_video_effect_micseat_in_mix_stream", r110, r111, false);
        f556327g = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_link_render_filter_fix_gray3", r110, r111, false);
        f556328h = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[6]);
        Class r108 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r109 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("video_share_load_video_count_first", 20, r108, false);
        f556329i = UltraSettingsManager.a().a(r109.f271017a, r109.f271018b, r109.getType(), r109.f271020d, r100[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r113 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("video_share_load_video_count", 12, r108, false);
        f556330j = UltraSettingsManager.a().a(r113.f271017a, r113.f271018b, r113.getType(), r113.f271020d, r100[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r114 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_chat_channel_audio_mix_default_volume", 100, r108, false);
        f556331k = UltraSettingsManager.a().a(r114.f271017a, r114.f271018b, r114.getType(), r114.f271020d, r100[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r115 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_chat_channel_link_audio_process_delay_enable", r110, r111, false);
        f556332l = UltraSettingsManager.a().a(r115.f271017a, r115.f271018b, r115.getType(), r115.f271020d, r100[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r116 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_ktv_avatar_resources", new y8(), y8.class, false);
        f556333m = UltraSettingsManager.a().a(r116.f271017a, r116.f271018b, r116.getType(), r116.f271020d, r100[11]);
        d9 r117 = new d9();
        r117.ktvStageStaticBg = d9.f120008a;
        r117.ktvStageAnimatedBg = d9.f120009b;
        r117.seatTalkEffect = d9.f120012e;
        r117.startTalkEffect = d9.f120013f;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r118 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_ktv_ui_resource_config", r117, d9.class, false);
        f556334n = UltraSettingsManager.a().a(r118.f271017a, r118.f271018b, r118.getType(), r118.f271020d, r100[12]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r119 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_backup_sei_setting_config", new LiveBackupSeiSettingConfig(), LiveBackupSeiSettingConfig.class, false);
        f556335o = UltraSettingsManager.a().a(r119.f271017a, r119.f271018b, r119.getType(), r119.f271020d, r100[13]);
    }
}
