package vm2;

import com.bytedance.android.livesdk.config.LiveLinkMicUpdateLiveCoreParamsConfig;
import com.bytedance.android.livesdk.config.q7;
import com.bytedance.android.livesdk.config.sb1;
import com.bytedance.android.livesdk.config.t01;
import com.bytedance.android.livesdk.config.t61;
import com.bytedance.android.livesdk.config.zb1;
import com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig;
import com.bytedance.android.livesdkapi.model.ILinkmicDynamicLinkServiceConfig;
import com.bytedance.android.livesdkapi.model.ILinkmicDynamicPanelConfig;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes11.dex */
public final class i {
    public static final ReadOnlyProperty A = null;
    public static final ReadOnlyProperty B = null;
    public static final ReadOnlyProperty C = null;
    public static final ReadOnlyProperty D = null;
    public static final ReadOnlyProperty E = null;
    public static final ReadOnlyProperty F = null;
    public static final ReadOnlyProperty G = null;
    public static final ReadOnlyProperty H = null;
    public static final ReadOnlyProperty I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final ReadOnlyProperty f556290J = null;
    public static final ReadOnlyProperty K = null;
    public static final ReadOnlyProperty L = null;
    public static final ReadOnlyProperty M = null;
    public static final ReadOnlyProperty N = null;
    public static final ReadOnlyProperty O = null;
    public static final ReadOnlyProperty P = null;
    public static final ReadOnlyProperty Q = null;
    public static final ReadOnlyProperty R = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f556291a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f556292b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f556293c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f556294d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f556295e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f556296f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f556297g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f556298h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f556299i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReadOnlyProperty f556300j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ReadOnlyProperty f556301k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ReadOnlyProperty f556302l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ReadOnlyProperty f556303m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ReadOnlyProperty f556304n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ReadOnlyProperty f556305o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ReadOnlyProperty f556306p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ReadOnlyProperty f556307q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ReadOnlyProperty f556308r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final ReadOnlyProperty f556309s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ReadOnlyProperty f556310t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final ReadOnlyProperty f556311u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final ReadOnlyProperty f556312v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final ReadOnlyProperty f556313w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final ReadOnlyProperty f556314x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final ReadOnlyProperty f556315y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final ReadOnlyProperty f556316z = null;

    public static final ILinkmicDynamicLinkServiceConfig a() {
        return (ILinkmicDynamicLinkServiceConfig) f556315y.getValue(null, f556291a[23]);
    }

    public static final ILinkmicDynamicPanelConfig b() {
        return (ILinkmicDynamicPanelConfig) f556316z.getValue(null, f556291a[24]);
    }

    public static final boolean c() {
        return ((Boolean) f556301k.getValue(null, f556291a[9])).booleanValue();
    }

    public static final boolean d() {
        return ((Boolean) f556306p.getValue(null, f556291a[14])).booleanValue();
    }

    public static final IGuestLinkSettingConfig e() {
        return (IGuestLinkSettingConfig) f556312v.getValue(null, f556291a[20]);
    }

    public static final sb1 f() {
        return (sb1) I.getValue(null, f556291a[33]);
    }

    public static final boolean g() {
        return ((Boolean) C.getValue(null, f556291a[27])).booleanValue();
    }

    public static final t01 h() {
        return (t01) f556305o.getValue(null, f556291a[13]);
    }

    public static final boolean i() {
        return ((Boolean) f556294d.getValue(null, f556291a[2])).booleanValue();
    }

    public static final boolean j() {
        return ((Boolean) f556314x.getValue(null, f556291a[22])).booleanValue();
    }

    public static final q7 k() {
        return (q7) f556313w.getValue(null, f556291a[21]);
    }

    public static final long l() {
        return ((Number) f556307q.getValue(null, f556291a[15])).longValue();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_ENABLE_MULTI_LINK_MONITOR_TRACE", "getLIVE_ENABLE_MULTI_LINK_MONITOR_TRACE()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_MULTI_LINK_TRACE_PREFIX_FILTER_LIST", "getLIVE_MULTI_LINK_TRACE_PREFIX_FILTER_LIST()Ljava/util/List;", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_MULTI_LINK_ENABLE_LINK_OPT_V4", "getLIVE_MULTI_LINK_ENABLE_LINK_OPT_V4()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_MULTI_LINK_ENABLE_PARAM_ADJUST", "getLIVE_MULTI_LINK_ENABLE_PARAM_ADJUST()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_MULTI_LINK_BITRATE_ADJUST", "getLIVE_MULTI_LINK_BITRATE_ADJUST()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_MULTI_LINK_GUEST_FALL_BACK_FPS", "getLIVE_MULTI_LINK_GUEST_FALL_BACK_FPS()I", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_MULTI_LINK_FPS_ADJUST", "getLIVE_MULTI_LINK_FPS_ADJUST()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_MULTI_LINK_USE_ENTER_ROOM_MEDIA_INFO", "getLIVE_MULTI_LINK_USE_ENTER_ROOM_MEDIA_INFO()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_MULTI_LINK_EARLY_INIT_RTC_WITH_INVITE_IM", "getLIVE_MULTI_LINK_EARLY_INIT_RTC_WITH_INVITE_IM()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_ENABLE_MULTI_LINK_JOIN_ROOM_IN_ADVANCE", "getLIVE_ENABLE_MULTI_LINK_JOIN_ROOM_IN_ADVANCE()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_MULTI_LINK_DURATION_UPLOAD_DELAY_DURATION", "getLIVE_MULTI_LINK_DURATION_UPLOAD_DELAY_DURATION()J", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_MULTI_LINK_EARLY_INIT_RTC_WITH_APPLY_RESP", "getLIVE_MULTI_LINK_EARLY_INIT_RTC_WITH_APPLY_RESP()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_ENABLE_MULTI_LINK_APPLY_EARLY_INIT_RTC", "getLIVE_ENABLE_MULTI_LINK_APPLY_EARLY_INIT_RTC()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_MULTILINK_LINK_MOCK_CONFIG", "getLIVE_MULTILINK_LINK_MOCK_CONFIG()Lcom/bytedance/android/livesdk/config/LinkMockConfig;", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_ENABLE_RTC_TEST_ENV", "getLIVE_ENABLE_RTC_TEST_ENV()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "MULTI_LINK_RTC_TIME_OUT_THRESHOLD", "getMULTI_LINK_RTC_TIME_OUT_THRESHOLD()J", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_PANEL_FIRST_FRAME_OPT", "getLIVE_PANEL_FIRST_FRAME_OPT()Lcom/bytedance/android/livesdk/config/LivePanelFirstFrameOptConfig;", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_LINKMIC_LINK_SUCCESS_UPDATE_LIVECORE_PARAMS", "getLIVE_LINKMIC_LINK_SUCCESS_UPDATE_LIVECORE_PARAMS()Lcom/bytedance/android/livesdk/config/LiveLinkMicUpdateLiveCoreParamsConfig;", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_LINKMIC_REQUEST_SONG_CONTINUE_BROADCAST_OPT", "getLIVE_LINKMIC_REQUEST_SONG_CONTINUE_BROADCAST_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_KTV_CORE_PATH_BUG_FIX_FALLBACK", "getLIVE_KTV_CORE_PATH_BUG_FIX_FALLBACK()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_GUEST_LINK_SETTING_CONFIG", "getLIVE_GUEST_LINK_SETTING_CONFIG()Lcom/bytedance/android/livesdkapi/model/IGuestLinkSettingConfig;", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "MULTI_LINK_AV_MONITOR_LOG_CONFIG", "getMULTI_LINK_AV_MONITOR_LOG_CONFIG()Lcom/bytedance/android/livesdk/config/IAVMonitorLogConfig;", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_TURN_ON_OPT_ENABLE", "getLIVE_TURN_ON_OPT_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LINKMIC_DYNAMIC_LINK_SERVICE_CONFIG", "getLINKMIC_DYNAMIC_LINK_SERVICE_CONFIG()Lcom/bytedance/android/livesdkapi/model/ILinkmicDynamicLinkServiceConfig;", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LINKMIC_DYNAMIC_PANEL_CONFIG", "getLINKMIC_DYNAMIC_PANEL_CONFIG()Lcom/bytedance/android/livesdkapi/model/ILinkmicDynamicPanelConfig;", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_MULTI_LINK_AUDIO_SELECT_CONFIG", "getLIVE_MULTI_LINK_AUDIO_SELECT_CONFIG()Ljava/util/Map;", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_MULTI_LINK_ONLINE_STATUS", "getLIVE_MULTI_LINK_ONLINE_STATUS()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_LINK_VIDEO_EXP_OPT", "getLIVE_LINK_VIDEO_EXP_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_UI_LAYOUTS_CAN_NOT_SHOW_LINK_RESULT_PAGE", "getLIVE_UI_LAYOUTS_CAN_NOT_SHOW_LINK_RESULT_PAGE()Ljava/util/List;", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "MULTI_TRACE_BLACK_LIST", "getMULTI_TRACE_BLACK_LIST()Lcom/bytedance/android/livesdk/config/MultiTraceBlackList;", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_MULTI_LINK_USE__MEDIA_CHANGE_INFO", "getLIVE_MULTI_LINK_USE__MEDIA_CHANGE_INFO()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "CAMERA_FREQUENCY_CONFIG", "getCAMERA_FREQUENCY_CONFIG()Lcom/bytedance/android/livesdk/config/link/SwitchCameraFrequencyConfig;", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_REAL_TIME_CHORUS_PUSH_STREAM_FIX", "getLIVE_REAL_TIME_CHORUS_PUSH_STREAM_FIX()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_INTERACT_PULL_STREAM_AGC_CONFIG", "getLIVE_INTERACT_PULL_STREAM_AGC_CONFIG()Lcom/bytedance/android/livesdk/config/MultiLinkRtcPullStreamAgcConfig;", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_CROSS_ROOM_REPLAY_INVITE_AUDIO_TYPE", "getLIVE_CROSS_ROOM_REPLAY_INVITE_AUDIO_TYPE()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "MULTI_LINK_SEI_CANVAS_CONFIG_BACKUP_OPT", "getMULTI_LINK_SEI_CANVAS_CONFIG_BACKUP_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_MULTI_LINK_STATUS_BAR_VISIBLE_OPT", "getLIVE_MULTI_LINK_STATUS_BAR_VISIBLE_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "MULTI_LINK_FLOAT_WINDOW_RV_HEIGHT_FIX", "getMULTI_LINK_FLOAT_WINDOW_RV_HEIGHT_FIX()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "MULTI_LINK_REGION_MIX_SERVICE_ENABLE", "getMULTI_LINK_REGION_MIX_SERVICE_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_RT_CHORUS_SWITCH_SCNENE_TIPS_CHANGE", "getLIVE_RT_CHORUS_SWITCH_SCNENE_TIPS_CHANGE()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_PAUSE_RESUME_TO_QUICKLY_INTERVAL", "getLIVE_PAUSE_RESUME_TO_QUICKLY_INTERVAL()I", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "LIVE_MULTI_LINK_ROOM_SCOPE_FALLBACK", "getLIVE_MULTI_LINK_ROOM_SCOPE_FALLBACK()Z", 1)), Reflection.property0(new PropertyReference0Impl(i.class, "NEW_VIDEO_LINKMIC_ANCHOR_REACT_CLICK_ENABLE_LAYOUTS", "getNEW_VIDEO_LINKMIC_ANCHOR_REACT_CLICK_ENABLE_LAYOUTS()Ljava/util/List;", 1))};
        f556291a = r100;
        Boolean r110 = Boolean.TRUE;
        Class r111 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enable_multi_link_monitor_trace", r110, r111, false);
        f556292b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_link_trace_prefix_filter_list", CollectionsKt.mutableListOf(new String[]{"LinkState", "PipeLineM", "LinkMediaM", "MultiLinkConfig", "MultiLinkService", "RtcClientState"}), eo3.a.f473309v, false);
        f556293c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        Boolean r103 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_link_enable_link_opt_v4", r103, r111, false);
        f556294d = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_link_enable_param_adjust", r110, r111, false);
        f556295e = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_link_bitrate_adjust", r110, r111, false);
        f556296f = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[4]);
        Class r112 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_link_guest_fall_back_fps", 15, r112, false);
        f556297g = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_link_fps_adjust", r110, r111, false);
        f556298h = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r109 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_link_use_enter_room_media_info", r103, r111, false);
        f556299i = UltraSettingsManager.a().a(r109.f271017a, r109.f271018b, r109.getType(), r109.f271020d, r100[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r113 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_link_early_init_rtc_with_invite_im", r103, r111, false);
        f556300j = UltraSettingsManager.a().a(r113.f271017a, r113.f271018b, r113.getType(), r113.f271020d, r100[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r114 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enable_multi_link_join_room_in_advance", r103, r111, false);
        f556301k = UltraSettingsManager.a().a(r114.f271017a, r114.f271018b, r114.getType(), r114.f271020d, r100[9]);
        Class r115 = Long.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r116 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_link_duration_upload_delay_duration", 2L, r115, false);
        f556302l = UltraSettingsManager.a().a(r116.f271017a, r116.f271018b, r116.getType(), r116.f271020d, r100[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r117 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_link_early_init_rtc_with_apply_resp", r103, r111, false);
        f556303m = UltraSettingsManager.a().a(r117.f271017a, r117.f271018b, r117.getType(), r117.f271020d, r100[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r118 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enable_multi_link_apply_early_init_rtc", r103, r111, false);
        f556304n = UltraSettingsManager.a().a(r118.f271017a, r118.f271018b, r118.getType(), r118.f271020d, r100[12]);
        Class<?> r119 = ((JsonAdapter) t01.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r120 = vh7.b.f554981a;
        Constructor r121 = r120.get(r119);
        if (r121 != null) goto L12;
        r121 = r119.getConstructor(new Class[0]);
        if (r121 == null) goto L11;
        Constructor<? extends SerializableObjectJsonAdapterBase> r122 = r120.putIfAbsent(r119, (Constructor<? extends SerializableObjectJsonAdapterBase>) r121);
        if (r122 == null) goto L12;
        r121 = r122;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r123 = ((SerializableObjectJsonAdapterBase) r121.newInstance(new Object[0])).createInstance();
        if (r123 == null) goto L129;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r124 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("LIVE_MULTILINK_LINK_MOCK_CONFIG", (t01) r123, t01.class, false);
        f556305o = UltraSettingsManager.a().a(r124.f271017a, r124.f271018b, r124.getType(), r124.f271020d, r100[13]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r125 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enable_rtc_test_env", r103, r111, false);
        f556306p = UltraSettingsManager.a().a(r125.f271017a, r125.f271018b, r125.getType(), r125.f271020d, r100[14]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r126 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_link_rtc_time_out_threshold", 15L, r115, false);
        f556307q = UltraSettingsManager.a().a(r126.f271017a, r126.f271018b, r126.getType(), r126.f271020d, r100[15]);
        Class<?> r127 = ((JsonAdapter) t61.class.getAnnotation(JsonAdapter.class)).value();
        Constructor<? extends SerializableObjectJsonAdapterBase> r128 = r120.get(r127);
        if (r128 != null) goto L24;
        r128 = r127.getConstructor(new Class[0]);
        if (r128 == null) goto L23;
        Constructor<? extends SerializableObjectJsonAdapterBase> r129 = r120.putIfAbsent(r127, r128);
        if (r129 == null) goto L24;
        r128 = r129;
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L24:
        Object r130 = r128.newInstance(new Object[0]).createInstance();
        if (r130 == null) goto L127;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r131 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_panel_first_frame_opt", (t61) r130, t61.class, false);
        f556308r = UltraSettingsManager.a().a(r131.f271017a, r131.f271018b, r131.getType(), r131.f271020d, r100[16]);
        Class<?> r132 = ((JsonAdapter) LiveLinkMicUpdateLiveCoreParamsConfig.class.getAnnotation(JsonAdapter.class)).value();
        Constructor<? extends SerializableObjectJsonAdapterBase> r133 = r120.get(r132);
        if (r133 != null) goto L36;
        r133 = r132.getConstructor(new Class[0]);
        if (r133 == null) goto L35;
        Constructor<? extends SerializableObjectJsonAdapterBase> r134 = r120.putIfAbsent(r132, r133);
        if (r134 == null) goto L36;
        r133 = r134;
        goto L36
    L35:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L36:
        Object r135 = r133.newInstance(new Object[0]).createInstance();
        if (r135 == null) goto L125;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r136 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_linkmic_link_success_update_livecore_params", (LiveLinkMicUpdateLiveCoreParamsConfig) r135, LiveLinkMicUpdateLiveCoreParamsConfig.class, false);
        f556309s = UltraSettingsManager.a().a(r136.f271017a, r136.f271018b, r136.getType(), r136.f271020d, r100[17]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r137 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_linkmic_request_song_continue_broadcast_opt", r110, r111, false);
        f556310t = UltraSettingsManager.a().a(r137.f271017a, r137.f271018b, r137.getType(), r137.f271020d, r100[18]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r138 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_ktv_core_path_bug_fix_fallback", r110, r111, false);
        f556311u = UltraSettingsManager.a().a(r138.f271017a, r138.f271018b, r138.getType(), r138.f271020d, r100[19]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r139 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_guest_link_setting_config", IGuestLinkSettingConfig.Companion.defaultConfig(), IGuestLinkSettingConfig.class, false);
        f556312v = UltraSettingsManager.a().a(r139.f271017a, r139.f271018b, r139.getType(), r139.f271020d, r100[20]);
        Class<?> r140 = ((JsonAdapter) q7.class.getAnnotation(JsonAdapter.class)).value();
        Constructor<? extends SerializableObjectJsonAdapterBase> r141 = r120.get(r140);
        if (r141 != null) goto L48;
        r141 = r140.getConstructor(new Class[0]);
        if (r141 == null) goto L47;
        Constructor<? extends SerializableObjectJsonAdapterBase> r142 = r120.putIfAbsent(r140, r141);
        if (r142 == null) goto L48;
        r141 = r142;
        goto L48
    L47:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L48:
        Object r143 = r141.newInstance(new Object[0]).createInstance();
        if (r143 == null) goto L123;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r144 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_link_av_monitor_log_config", (q7) r143, q7.class, false);
        f556313w = UltraSettingsManager.a().a(r144.f271017a, r144.f271018b, r144.getType(), r144.f271020d, r100[21]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r145 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_turn_on_opt_enable", r110, r111, false);
        f556314x = UltraSettingsManager.a().a(r145.f271017a, r145.f271018b, r145.getType(), r145.f271020d, r100[22]);
        Class<?> r146 = ((JsonAdapter) ILinkmicDynamicLinkServiceConfig.class.getAnnotation(JsonAdapter.class)).value();
        Constructor<? extends SerializableObjectJsonAdapterBase> r147 = r120.get(r146);
        if (r147 != null) goto L60;
        r147 = r146.getConstructor(new Class[0]);
        if (r147 == null) goto L59;
        Constructor<? extends SerializableObjectJsonAdapterBase> r148 = r120.putIfAbsent(r146, r147);
        if (r148 == null) goto L60;
        r147 = r148;
        goto L60
    L59:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L60:
        Object r149 = r147.newInstance(new Object[0]).createInstance();
        if (r149 == null) goto L121;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r150 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("linkmic_dynamic_link_service_config", (ILinkmicDynamicLinkServiceConfig) r149, ILinkmicDynamicLinkServiceConfig.class, false);
        f556315y = UltraSettingsManager.a().a(r150.f271017a, r150.f271018b, r150.getType(), r150.f271020d, r100[23]);
        Class<?> r151 = ((JsonAdapter) ILinkmicDynamicPanelConfig.class.getAnnotation(JsonAdapter.class)).value();
        Constructor<? extends SerializableObjectJsonAdapterBase> r152 = r120.get(r151);
        if (r152 != null) goto L72;
        r152 = r151.getConstructor(new Class[0]);
        if (r152 == null) goto L71;
        Constructor<? extends SerializableObjectJsonAdapterBase> r153 = r120.putIfAbsent(r151, r152);
        if (r153 == null) goto L72;
        r152 = r153;
        goto L72
    L71:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L72:
        Object r154 = r152.newInstance(new Object[0]).createInstance();
        if (r154 == null) goto L119;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r155 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("linkmic_dynamic_panel_config", (ILinkmicDynamicPanelConfig) r154, ILinkmicDynamicPanelConfig.class, false);
        f556316z = UltraSettingsManager.a().a(r155.f271017a, r155.f271018b, r155.getType(), r155.f271020d, r100[24]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r156 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_interact_downlink_audio_config", new LinkedHashMap(), eo3.a.f473292e, false);
        A = UltraSettingsManager.a().a(r156.f271017a, r156.f271018b, r156.getType(), r156.f271020d, r100[25]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r157 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_link_online_status", r110, r111, false);
        B = UltraSettingsManager.a().a(r157.f271017a, r157.f271018b, r157.getType(), r157.f271020d, r100[26]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r158 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_video_exp_opt", r103, r111, false);
        C = UltraSettingsManager.a().a(r158.f271017a, r158.f271018b, r158.getType(), r158.f271020d, r100[27]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r159 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_ui_layouts_can_not_show_link_result_page", CollectionsKt.listOf(new String[]{"61", BDLocationException.ERROR_PROVIDER_DISABLED, "63"}), eo3.a.K, false);
        D = UltraSettingsManager.a().a(r159.f271017a, r159.f271018b, r159.getType(), r159.f271020d, r100[28]);
        Class<?> r160 = ((JsonAdapter) zb1.class.getAnnotation(JsonAdapter.class)).value();
        Constructor<? extends SerializableObjectJsonAdapterBase> r161 = r120.get(r160);
        if (r161 != null) goto L84;
        r161 = r160.getConstructor(new Class[0]);
        if (r161 == null) goto L83;
        Constructor<? extends SerializableObjectJsonAdapterBase> r162 = r120.putIfAbsent(r160, r161);
        if (r162 == null) goto L84;
        r161 = r162;
        goto L84
    L83:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L84:
        Object r163 = r161.newInstance(new Object[0]).createInstance();
        if (r163 == null) goto L117;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r164 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_trace_black_list", (zb1) r163, zb1.class, false);
        E = UltraSettingsManager.a().a(r164.f271017a, r164.f271018b, r164.getType(), r164.f271020d, r100[29]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r165 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_link_use__media_change_info", r110, r111, false);
        F = UltraSettingsManager.a().a(r165.f271017a, r165.f271018b, r165.getType(), r165.f271020d, r100[30]);
        Class<?> r166 = ((JsonAdapter) us1.c.class.getAnnotation(JsonAdapter.class)).value();
        Constructor<? extends SerializableObjectJsonAdapterBase> r167 = r120.get(r166);
        if (r167 != null) goto L96;
        r167 = r166.getConstructor(new Class[0]);
        if (r167 == null) goto L95;
        Constructor<? extends SerializableObjectJsonAdapterBase> r168 = r120.putIfAbsent(r166, r167);
        if (r168 == null) goto L96;
        r167 = r168;
        goto L96
    L95:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L96:
        Object r169 = r167.newInstance(new Object[0]).createInstance();
        if (r169 == null) goto L115;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r170 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("switch_camera_frequncy_config", (us1.c) r169, us1.c.class, false);
        G = UltraSettingsManager.a().a(r170.f271017a, r170.f271018b, r170.getType(), r170.f271020d, r100[31]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r171 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_real_time_chorus_push_stream_fix", r110, r111, false);
        H = UltraSettingsManager.a().a(r171.f271017a, r171.f271018b, r171.getType(), r171.f271020d, r100[32]);
        Class<?> r172 = ((JsonAdapter) sb1.class.getAnnotation(JsonAdapter.class)).value();
        Constructor<? extends SerializableObjectJsonAdapterBase> r173 = r120.get(r172);
        if (r173 != null) goto L108;
        r173 = r172.getConstructor(new Class[0]);
        if (r173 == null) goto L107;
        Constructor<? extends SerializableObjectJsonAdapterBase> r174 = r120.putIfAbsent(r172, r173);
        if (r174 == null) goto L108;
        r173 = r174;
        goto L108
    L107:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L108:
        Object r175 = r173.newInstance(new Object[0]).createInstance();
        if (r175 == null) goto L113;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r176 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_interact_pull_stream_agc_config", (sb1) r175, sb1.class, false);
        I = UltraSettingsManager.a().a(r176.f271017a, r176.f271018b, r176.getType(), r176.f271020d, r100[33]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r177 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_cross_room_replay_invite_audio_type", r110, r111, false);
        f556290J = UltraSettingsManager.a().a(r177.f271017a, r177.f271018b, r177.getType(), r177.f271020d, r100[34]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r178 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_link_sei_canvas_backup_opt", r110, r111, true);
        K = UltraSettingsManager.a().a(r178.f271017a, r178.f271018b, r178.getType(), r178.f271020d, r100[35]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r179 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_link_status_bar_visible_opt", r110, r111, false);
        L = UltraSettingsManager.a().a(r179.f271017a, r179.f271018b, r179.getType(), r179.f271020d, r100[36]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r180 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_link_float_window_rv_height_fix", r110, r111, false);
        M = UltraSettingsManager.a().a(r180.f271017a, r180.f271018b, r180.getType(), r180.f271020d, r100[37]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r181 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_link_region_mix_service_enable", r110, r111, false);
        N = UltraSettingsManager.a().a(r181.f271017a, r181.f271018b, r181.getType(), r181.f271020d, r100[38]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r182 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_rt_chorus_switch_scene_tips_change", r110, r111, false);
        O = UltraSettingsManager.a().a(r182.f271017a, r182.f271018b, r182.getType(), r182.f271020d, r100[39]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r183 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pause_resume_to_quickly_interval", 2000, r112, false);
        P = UltraSettingsManager.a().a(r183.f271017a, r183.f271018b, r183.getType(), r183.f271020d, r100[40]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r184 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_link_room_scope_fallback", r110, r111, false);
        Q = UltraSettingsManager.a().a(r184.f271017a, r184.f271018b, r184.getType(), r184.f271020d, r100[41]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r185 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("new_video_linkmic_anchor_react_click_enable_layouts", CollectionsKt.mutableListOf(new Integer[]{112, 120, 133, 134}), eo3.a.M, false);
        R = UltraSettingsManager.a().a(r185.f271017a, r185.f271018b, r185.getType(), r185.f271020d, r100[42]);
        return;
    L113:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.config.MultiLinkRtcPullStreamAgcConfig");
    L115:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.config.link.SwitchCameraFrequencyConfig");
    L117:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.config.MultiTraceBlackList");
    L119:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.model.ILinkmicDynamicPanelConfig");
    L121:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.model.ILinkmicDynamicLinkServiceConfig");
    L123:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.config.IAVMonitorLogConfig");
    L125:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.config.LiveLinkMicUpdateLiveCoreParamsConfig");
    L127:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.config.LivePanelFirstFrameOptConfig");
    L129:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.config.LinkMockConfig");
    }
}
