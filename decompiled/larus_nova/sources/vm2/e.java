package vm2;

import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.android.livesdk.config.x21;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import com.tencent.connect.common.Constants;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes11.dex */
public final class e {
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
    public static final ReadOnlyProperty f556036J = null;
    public static final ReadOnlyProperty K = null;
    public static final ReadOnlyProperty L = null;
    public static final ReadOnlyProperty M = null;
    public static final ReadOnlyProperty N = null;
    public static final ReadOnlyProperty O = null;
    public static final ReadOnlyProperty P = null;
    public static final ReadOnlyProperty Q = null;
    public static final ReadOnlyProperty R = null;
    public static final ReadOnlyProperty S = null;
    public static final ReadOnlyProperty T = null;
    public static final ReadOnlyProperty U = null;
    public static final ReadOnlyProperty V = null;
    public static final ReadOnlyProperty W = null;
    public static final ReadOnlyProperty X = null;
    public static final ReadOnlyProperty Y = null;
    public static final ReadOnlyProperty Z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f556037a = null;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final ReadOnlyProperty f556038a0 = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f556039b = null;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final ReadOnlyProperty f556040b0 = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f556041c = null;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final ReadOnlyProperty f556042c0 = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f556043d = null;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final ReadOnlyProperty f556044d0 = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f556045e = null;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final ReadOnlyProperty f556046e0 = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f556047f = null;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final ReadOnlyProperty f556048f0 = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f556049g = null;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final ReadOnlyProperty f556050g0 = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f556051h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f556052i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReadOnlyProperty f556053j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ReadOnlyProperty f556054k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ReadOnlyProperty f556055l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ReadOnlyProperty f556056m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ReadOnlyProperty f556057n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ReadOnlyProperty f556058o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ReadOnlyProperty f556059p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ReadOnlyProperty f556060q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ReadOnlyProperty f556061r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final ReadOnlyProperty f556062s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ReadOnlyProperty f556063t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final ReadOnlyProperty f556064u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final ReadOnlyProperty f556065v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final ReadOnlyProperty f556066w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final ReadOnlyProperty f556067x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final ReadOnlyProperty f556068y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final ReadOnlyProperty f556069z = null;

    public static final boolean a() {
        return ((Boolean) f556046e0.getValue(null, f556037a[55])).booleanValue();
    }

    public static final boolean b() {
        return ((Boolean) f556059p.getValue(null, f556037a[14])).booleanValue();
    }

    public static final boolean c() {
        return ((Boolean) f556061r.getValue(null, f556037a[16])).booleanValue();
    }

    public static final boolean d() {
        return ((Boolean) f556069z.getValue(null, f556037a[24])).booleanValue();
    }

    public static final boolean e() {
        return ((Boolean) f556060q.getValue(null, f556037a[15])).booleanValue();
    }

    public static final boolean f() {
        return ((Boolean) Q.getValue(null, f556037a[41])).booleanValue();
    }

    public static final Map<String, String> g() {
        return (Map) f556055l.getValue(null, f556037a[10]);
    }

    public static final boolean h() {
        return ((Boolean) f556049g.getValue(null, f556037a[5])).booleanValue();
    }

    public static final boolean i() {
        return ((Boolean) U.getValue(null, f556037a[45])).booleanValue();
    }

    public static final boolean j() {
        return ((Boolean) O.getValue(null, f556037a[39])).booleanValue();
    }

    public static final HashMap<String, String> k() {
        return (HashMap) f556036J.getValue(null, f556037a[34]);
    }

    public static final long l() {
        return ((Number) f556063t.getValue(null, f556037a[18])).longValue();
    }

    public static final boolean m() {
        return ((Boolean) f556038a0.getValue(null, f556037a[51])).booleanValue();
    }

    public static final boolean n() {
        return ((Boolean) f556053j.getValue(null, f556037a[8])).booleanValue();
    }

    public static final boolean o() {
        return ((Boolean) f556058o.getValue(null, f556037a[13])).booleanValue();
    }

    public static final boolean p() {
        return ((Boolean) f556050g0.getValue(null, f556037a[57])).booleanValue();
    }

    public static final boolean q() {
        return ((Boolean) f556062s.getValue(null, f556037a[17])).booleanValue();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_FAST_MATCH_SETTINGS", "getLIVE_FAST_MATCH_SETTINGS()Lcom/bytedance/android/livesdk/config/LiveFastMatchConfig;", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_MULTI_DEBOUNCE_MIX_STREAM_INTERVAL", "getLIVE_MULTI_DEBOUNCE_MIX_STREAM_INTERVAL()J", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_CORE_DISABLE_LOCAL_RENDER_FRAME", "getLIVE_CORE_DISABLE_LOCAL_RENDER_FRAME()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_LINK_SUPPORTED_FORCE_SERVER_MIX", "getLIVE_LINK_SUPPORTED_FORCE_SERVER_MIX()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_AUDIO_RESOLUTION_OPT_KT", "getLIVE_AUDIO_RESOLUTION_OPT_KT()Lcom/bytedance/android/livesdk/config/blackframe/AudioBlackFrameOptConfig;", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_LINK_GUEST_CLEAN_SCREEN_OPTIMIZE", "getLIVE_LINK_GUEST_CLEAN_SCREEN_OPTIMIZE()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_BIG_PARTY_FAST_MATCH_AND_STRONG_REACH_AUDIO_APPLY", "getLIVE_BIG_PARTY_FAST_MATCH_AND_STRONG_REACH_AUDIO_APPLY()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_INVITE_LINK_MIC_WITHOUT_PAYMENT", "getLIVE_INVITE_LINK_MIC_WITHOUT_PAYMENT()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "MULTI_LINK_AUDIENCE_RTC_RENDER_YUV_OPT", "getMULTI_LINK_AUDIENCE_RTC_RENDER_YUV_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_LINKMIC_RESULT_LEAVE_PAGE_V2_ENABLE", "getLIVE_LINKMIC_RESULT_LEAVE_PAGE_V2_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_LINKMIC_RESULT_LEAVE_PAGE_V2_CONFIG", "getLIVE_LINKMIC_RESULT_LEAVE_PAGE_V2_CONFIG()Ljava/util/Map;", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "VOICE_CHAT_ROOM_INTERACT_MODE_ENABLE", "getVOICE_CHAT_ROOM_INTERACT_MODE_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_LINKMIC_POST_ONLINE_STATE_SWITCH", "getLIVE_LINKMIC_POST_ONLINE_STATE_SWITCH()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "MULTI_LINK_BLUETOOTH_PERMISSION", "getMULTI_LINK_BLUETOOTH_PERMISSION()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LINK_INTERACT_AUDIENCE_OPT_ENABLE", "getLINK_INTERACT_AUDIENCE_OPT_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_ENABLE_CONTROL_CLIENT_MIX_STREAM", "getLIVE_ENABLE_CONTROL_CLIENT_MIX_STREAM()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_CONTROL_CLIENT_MIX_STREAM_CONFIG", "getLIVE_CONTROL_CLIENT_MIX_STREAM_CONFIG()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "TALK_ROOM_RTC_SEI_ENABLE", "getTALK_ROOM_RTC_SEI_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_SEI_UPDATE_INTERVAL", "getLIVE_SEI_UPDATE_INTERVAL()J", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "TALK_ROOM_FULLLINK_DISABLE_LIST", "getTALK_ROOM_FULLLINK_DISABLE_LIST()Ljava/util/List;", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "TALK_ROOM_FULLLINK_GUEST_FALL_BACK_TO_ALOGGER", "getTALK_ROOM_FULLLINK_GUEST_FALL_BACK_TO_ALOGGER()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "TALK_ROOM_FULLLINK_ONLY_ANCHOR_OR_LINK_GUEST", "getTALK_ROOM_FULLLINK_ONLY_ANCHOR_OR_LINK_GUEST()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_CHANNEL_LINK_TRACE_UPLOAD_ENABLE", "getLIVE_CHANNEL_LINK_TRACE_UPLOAD_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "MULTI_REVENUE_TRACE_LOG_ENABLE", "getMULTI_REVENUE_TRACE_LOG_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_DIGIT_AVATAR_EXPERIENCE_OPTIMIZATION_SWITCH", "getLIVE_DIGIT_AVATAR_EXPERIENCE_OPTIMIZATION_SWITCH()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_DIGIT_AVATAR_MUTE_VIDEO_STREAM_PROC_SWITCH", "getLIVE_DIGIT_AVATAR_MUTE_VIDEO_STREAM_PROC_SWITCH()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_PC_LANDSCAPE_LINKMIC_ENABLE", "getLIVE_PC_LANDSCAPE_LINKMIC_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LINKMIC_CHORUS_CONCERT_ENABLE_LINK_SERIVICE", "getLINKMIC_CHORUS_CONCERT_ENABLE_LINK_SERIVICE()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LINK_CHECK_ENABLE", "getLINK_CHECK_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LINK_CHECK_INTERVAL", "getLINK_CHECK_INTERVAL()I", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LINK_CHECK_LIST_OPT_ENABLE", "getLINK_CHECK_LIST_OPT_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_LINK_ROOM_FIGHT_FORCE_SERVER_MIX", "getLIVE_LINK_ROOM_FIGHT_FORCE_SERVER_MIX()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "MULTI_ANCHOR_BACKUP_STREAM_DISABLE", "getMULTI_ANCHOR_BACKUP_STREAM_DISABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_PUSH_STREAM_SIZE_OPT", "getLIVE_PUSH_STREAM_SIZE_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_PUSH_STREAM_SIZE_MAP", "getLIVE_PUSH_STREAM_SIZE_MAP()Ljava/util/HashMap;", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "INTERACT_SEI_UID_DISABLE", "getINTERACT_SEI_UID_DISABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "VIDEO_TALK_POS_SEI_ENABLE", "getVIDEO_TALK_POS_SEI_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_IS_HOST_KT", "getLIVE_IS_HOST_KT()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LINK_SEI_UID_SHRINK", "getLINK_SEI_UID_SHRINK()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_PAID_LIVE_ENABLE_VIDEO_TALK_ROOM", "getLIVE_PAID_LIVE_ENABLE_VIDEO_TALK_ROOM()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_VIDEO_SELF_DISCIPLINE_STACK_MONITOR_ENABLE", "getLIVE_VIDEO_SELF_DISCIPLINE_STACK_MONITOR_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_LINKMIC_DISABLE_BIGEVENT", "getLIVE_LINKMIC_DISABLE_BIGEVENT()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_PAID_LINKMIC_INTEGRATION_ENABLE", "getLIVE_PAID_LINKMIC_INTEGRATION_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_ROOM_FIGHT_SETTTING_UPDATE_TO_ADMIN", "getLIVE_ROOM_FIGHT_SETTTING_UPDATE_TO_ADMIN()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_NEW_VIDEO_LINKMIC_FIX_SCREEN", "getLIVE_NEW_VIDEO_LINKMIC_FIX_SCREEN()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_LIST_SETTING_MSG_SUPPORT_WRDS", "getLIVE_LIST_SETTING_MSG_SUPPORT_WRDS()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "MULTI_LINK_SWITCH_SCENE_CHECK_VERSION_VALID", "getMULTI_LINK_SWITCH_SCENE_CHECK_VERSION_VALID()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "MULTI_LINK_BASE_COMMON_WINDOW_UI_LAYOUT_SUPPORT_LIST", "getMULTI_LINK_BASE_COMMON_WINDOW_UI_LAYOUT_SUPPORT_LIST()Ljava/util/List;", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "AUDIO_TALK_STATE_SEI", "getAUDIO_TALK_STATE_SEI()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_ANCHOR_START_RTC_UPDATE_OPEN_VOICE", "getLIVE_ANCHOR_START_RTC_UPDATE_OPEN_VOICE()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "MULTI_LINK_BASE_COMMON_WINDOW_SUPPORT_VIDEO_POSITION_EXT_INFO", "getMULTI_LINK_BASE_COMMON_WINDOW_SUPPORT_VIDEO_POSITION_EXT_INFO()Ljava/util/List;", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_VOICE_CHAT_ROOM_SHORT_VIDEO_SWITCH_ENABLE", "getLIVE_VOICE_CHAT_ROOM_SHORT_VIDEO_SWITCH_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_VOICE_CHAT_SCHEMA_CHECK_OPT", "getLIVE_VOICE_CHAT_SCHEMA_CHECK_OPT()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "VIDEO_TALK_SUPPORT_CAMERA", "getVIDEO_TALK_SUPPORT_CAMERA()I", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_AUDIENCE_DEFAULT_OPEN_CAMERA", "getLIVE_AUDIENCE_DEFAULT_OPEN_CAMERA()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "INTERACT_ACTIVITY_PERMISSION_GUARANTOR_ENABLE", "getINTERACT_ACTIVITY_PERMISSION_GUARANTOR_ENABLE()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_MULTI_LINK_ADMIN_FANTICKET_SHOW_BUGFIX", "getLIVE_MULTI_LINK_ADMIN_FANTICKET_SHOW_BUGFIX()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "NEW_VIDEO_LINKMIC_ACTIVITY_PERMISSION_GUARANTOR_ENABLE", "getNEW_VIDEO_LINKMIC_ACTIVITY_PERMISSION_GUARANTOR_ENABLE()Z", 1))};
        f556037a = r100;
        Class<?> r110 = ((JsonAdapter) x21.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r111 = vh7.b.f554981a;
        Constructor r112 = r111.get(r110);
        if (r112 != null) goto L12;
        r112 = r110.getConstructor(new Class[0]);
        if (r112 == null) goto L11;
        Constructor<? extends SerializableObjectJsonAdapterBase> r113 = r111.putIfAbsent(r110, (Constructor<? extends SerializableObjectJsonAdapterBase>) r112);
        if (r113 == null) goto L12;
        r112 = r113;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r114 = ((SerializableObjectJsonAdapterBase) r112.newInstance(new Object[0])).createInstance();
        if (r114 == null) goto L31;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_fast_match_settings", (x21) r114, x21.class, false);
        f556039b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        Class r115 = Long.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_debounce_mix_stream_interval", 300L, r115, false);
        f556041c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        Boolean r116 = Boolean.TRUE;
        Class r117 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_core_opt_disable_local_render_frame", r116, r117, false);
        f556043d = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_supported_force_server_mix", r116, r117, false);
        f556045e = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[3]);
        Class<?> r105 = ((JsonAdapter) ns1.a.class.getAnnotation(JsonAdapter.class)).value();
        Constructor<? extends SerializableObjectJsonAdapterBase> r106 = r111.get(r105);
        if (r106 != null) goto L24;
        r106 = r105.getConstructor(new Class[0]);
        if (r106 == null) goto L23;
        Constructor<? extends SerializableObjectJsonAdapterBase> r107 = r111.putIfAbsent(r105, r106);
        if (r107 == null) goto L24;
        r106 = r107;
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L24:
        Object r108 = r106.newInstance(new Object[0]).createInstance();
        if (r108 == null) goto L29;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r109 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_audio_resolution_opt", (ns1.a) r108, ns1.a.class, false);
        f556047f = UltraSettingsManager.a().a(r109.f271017a, r109.f271018b, r109.getType(), r109.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r118 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("ttlive_link_guest_clean_optimize", r116, r117, false);
        f556049g = UltraSettingsManager.a().a(r118.f271017a, r118.f271018b, r118.getType(), r118.f271020d, r100[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r119 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_big_party_fast_match_and_strong_reach_audio_apply", r116, r117, false);
        f556051h = UltraSettingsManager.a().a(r119.f271017a, r119.f271018b, r119.getType(), r119.f271020d, r100[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r120 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_invite_link_mic_without_payment", r116, r117, false);
        f556052i = UltraSettingsManager.a().a(r120.f271017a, r120.f271018b, r120.getType(), r120.f271020d, r100[7]);
        Boolean r121 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r122 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_link_audience_rtc_render_yuv_opt", r121, r117, false);
        f556053j = UltraSettingsManager.a().a(r122.f271017a, r122.f271018b, r122.getType(), r122.f271020d, r100[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r123 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_linkmic_leave_page_v2_enable", r116, r117, false);
        f556054k = UltraSettingsManager.a().a(r123.f271017a, r123.f271018b, r123.getType(), r123.f271020d, r100[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r124 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_linkmic_leave_page_v2_config", new LinkedHashMap(), eo3.a.f473298k, false);
        f556055l = UltraSettingsManager.a().a(r124.f271017a, r124.f271018b, r124.getType(), r124.f271020d, r100[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r125 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("voice_chat_room_interact_mode_enable", r116, r117, false);
        f556056m = UltraSettingsManager.a().a(r125.f271017a, r125.f271018b, r125.getType(), r125.f271020d, r100[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r126 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_linkmic_post_online_state_switch", r116, r117, false);
        f556057n = UltraSettingsManager.a().a(r126.f271017a, r126.f271018b, r126.getType(), r126.f271020d, r100[12]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r127 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_link_bluetooth_permission", r116, r117, false);
        f556058o = UltraSettingsManager.a().a(r127.f271017a, r127.f271018b, r127.getType(), r127.f271020d, r100[13]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r128 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("link_interact_audience_opt_enable", r116, r117, false);
        f556059p = UltraSettingsManager.a().a(r128.f271017a, r128.f271018b, r128.getType(), r128.f271020d, r100[14]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r129 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enable_control_client_mix_stream", r121, r117, false);
        f556060q = UltraSettingsManager.a().a(r129.f271017a, r129.f271018b, r129.getType(), r129.f271020d, r100[15]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r130 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_client_mix_stream", r121, r117, false);
        f556061r = UltraSettingsManager.a().a(r130.f271017a, r130.f271018b, r130.getType(), r130.f271020d, r100[16]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r131 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("talk_room_rtc_sei_enable", r116, r117, false);
        f556062s = UltraSettingsManager.a().a(r131.f271017a, r131.f271018b, r131.getType(), r131.f271020d, r100[17]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r132 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_sei_update_interval", 500L, r115, false);
        f556063t = UltraSettingsManager.a().a(r132.f271017a, r132.f271018b, r132.getType(), r132.f271020d, r100[18]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r133 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("talk_room_fulllink_disable_list", new ArrayList(), eo3.a.D, false);
        f556064u = UltraSettingsManager.a().a(r133.f271017a, r133.f271018b, r133.getType(), r133.f271020d, r100[19]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r134 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("talk_room_fulllink_guest_fall_back_to_alogger", r116, r117, false);
        f556065v = UltraSettingsManager.a().a(r134.f271017a, r134.f271018b, r134.getType(), r134.f271020d, r100[20]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r135 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("talk_room_fulllink_only_anchor_or_link_guest", r116, r117, false);
        f556066w = UltraSettingsManager.a().a(r135.f271017a, r135.f271018b, r135.getType(), r135.f271020d, r100[21]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r136 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_chat_channel_enable_audio_trace_upload", r116, r117, false);
        f556067x = UltraSettingsManager.a().a(r136.f271017a, r136.f271018b, r136.getType(), r136.f271020d, r100[22]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r137 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_revenue_trace_log_enable", r121, r117, false);
        f556068y = UltraSettingsManager.a().a(r137.f271017a, r137.f271018b, r137.getType(), r137.f271020d, r100[23]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r138 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_digit_avatar_experience_optimization_switch", r116, r117, false);
        f556069z = UltraSettingsManager.a().a(r138.f271017a, r138.f271018b, r138.getType(), r138.f271020d, r100[24]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r139 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_digit_avatar_mute_video_stream_proc_switch", r116, r117, false);
        A = UltraSettingsManager.a().a(r139.f271017a, r139.f271018b, r139.getType(), r139.f271020d, r100[25]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r140 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pc_landscape_linkmic_enable", r116, r117, false);
        B = UltraSettingsManager.a().a(r140.f271017a, r140.f271018b, r140.getType(), r140.f271020d, r100[26]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r141 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("linkmic_chorus_concert_enable_link_service", r116, r117, false);
        C = UltraSettingsManager.a().a(r141.f271017a, r141.f271018b, r141.getType(), r141.f271020d, r100[27]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r142 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_check_linker_enable", r116, r117, false);
        D = UltraSettingsManager.a().a(r142.f271017a, r142.f271018b, r142.getType(), r142.f271020d, r100[28]);
        Class r143 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r144 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_check_linker_interval", 20, r143, false);
        E = UltraSettingsManager.a().a(r144.f271017a, r144.f271018b, r144.getType(), r144.f271020d, r100[29]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r145 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_check_linker_list_opt_enable", r116, r117, false);
        F = UltraSettingsManager.a().a(r145.f271017a, r145.f271018b, r145.getType(), r145.f271020d, r100[30]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r146 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_room_fight_force_server_mix", r116, r117, false);
        G = UltraSettingsManager.a().a(r146.f271017a, r146.f271018b, r146.getType(), r146.f271020d, r100[31]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r147 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_linker_backup_stream_disable", r121, r117, false);
        H = UltraSettingsManager.a().a(r147.f271017a, r147.f271018b, r147.getType(), r147.f271020d, r100[32]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r148 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_push_stream_size_opt", r121, r117, true);
        I = UltraSettingsManager.a().a(r148.f271017a, r148.f271018b, r148.getType(), r148.f271020d, r100[33]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r149 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_push_stream_size_map", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("1920", "1088"), TuplesKt.to("1280", "720"), TuplesKt.to("960", "544"), TuplesKt.to("864", "480")}), eo3.a.f473301n, false);
        f556036J = UltraSettingsManager.a().a(r149.f271017a, r149.f271018b, r149.getType(), r149.f271020d, r100[34]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r150 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("interact_sei_uid_disabled", r121, r117, false);
        K = UltraSettingsManager.a().a(r150.f271017a, r150.f271018b, r150.getType(), r150.f271020d, r100[35]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r151 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("video_talk_pos_sei_enable", r121, r117, false);
        L = UltraSettingsManager.a().a(r151.f271017a, r151.f271018b, r151.getType(), r151.f271020d, r100[36]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r152 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_is_host_kt", r116, r117, false);
        M = UltraSettingsManager.a().a(r152.f271017a, r152.f271018b, r152.getType(), r152.f271020d, r100[37]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r153 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_chatroom_sei_fields_simplify_uid", r116, r117, false);
        N = UltraSettingsManager.a().a(r153.f271017a, r153.f271018b, r153.getType(), r153.f271020d, r100[38]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r154 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_paid_live_enable_video_talk_room", r121, r117, false);
        O = UltraSettingsManager.a().a(r154.f271017a, r154.f271018b, r154.getType(), r154.f271020d, r100[39]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r155 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_video_self_discipline_stack_monitor_enable", r116, r117, false);
        P = UltraSettingsManager.a().a(r155.f271017a, r155.f271018b, r155.getType(), r155.f271020d, r100[40]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r156 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_linkmic_disable_bigevent", r121, r117, false);
        Q = UltraSettingsManager.a().a(r156.f271017a, r156.f271018b, r156.getType(), r156.f271020d, r100[41]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r157 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_paid_linkmic_integration_enable", r116, r117, false);
        R = UltraSettingsManager.a().a(r157.f271017a, r157.f271018b, r157.getType(), r157.f271020d, r100[42]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r158 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_room_fight_settting_update_to_admin", r116, r117, false);
        S = UltraSettingsManager.a().a(r158.f271017a, r158.f271018b, r158.getType(), r158.f271020d, r100[43]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r159 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_new_video_linkmic_fix_screen", r116, r117, false);
        T = UltraSettingsManager.a().a(r159.f271017a, r159.f271018b, r159.getType(), r159.f271020d, r100[44]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r160 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("linkmic_list_and_get_settings_using_wrds", r121, r117, false);
        U = UltraSettingsManager.a().a(r160.f271017a, r160.f271018b, r160.getType(), r160.f271020d, r100[45]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r161 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_link_switch_scene_check_version_valid", r116, r117, false);
        V = UltraSettingsManager.a().a(r161.f271017a, r161.f271018b, r161.getType(), r161.f271020d, r100[46]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r162 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_link_base_common_window_ui_layout_support_list", CollectionsKt.mutableListOf(new String[]{"11", "12", "3", "4", "5", "13", Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "1", "6", "7", Constants.VIA_SHARE_TYPE_MINI_PROGRAM, "51", BDLocationException.ERROR_SHAKE_UPLOAD, "57", BDLocationException.ERROR_SHAKE_BPEA_CERT_CHECK, BDLocationException.ERROR_UID_IS_EMPTY, IInteractGameMonitorService.FAILURE_CODE_LINK_MIC_MUTEX, "104", "105", BDLocationException.ERROR_BLUETOOTh_NOT_AVAILABLE, "107", "108", IInteractGameMonitorService.FAILURE_CODE_OTHER_GAME_MUTEX, BDLocationException.ERROR_TMAP_CLIENT, "111", BDLocationException.ERROR_TMAP_BAD_JSON, "2", "21", "22", "43", Constants.VIA_REPORT_TYPE_WPA_STATE, Constants.VIA_REPORT_TYPE_START_WAP, "26", "27", "28", "29", BDLocationException.ERROR_SDK_NO_PERMISSION, "65"}), eo3.a.f473295h, false);
        W = UltraSettingsManager.a().a(r162.f271017a, r162.f271018b, r162.getType(), r162.f271020d, r100[47]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r163 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_interact_multi_speaking_type_sei", r116, r117, false);
        X = UltraSettingsManager.a().a(r163.f271017a, r163.f271018b, r163.getType(), r163.f271020d, r100[48]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r164 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anchor_start_rtc_update_open_voice", r121, r117, false);
        Y = UltraSettingsManager.a().a(r164.f271017a, r164.f271018b, r164.getType(), r164.f271020d, r100[49]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r165 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_link_base_common_window_support_video_position_ext_info", CollectionsKt.mutableListOf(new String[]{BDLocationException.ERROR_UID_IS_EMPTY, IInteractGameMonitorService.FAILURE_CODE_LINK_MIC_MUTEX, "104", "105", BDLocationException.ERROR_BLUETOOTh_NOT_AVAILABLE, "107", "108", "5", "11", "12", "3", "43", BDLocationException.ERROR_TMAP_BAD_JSON, Constants.VIA_REPORT_TYPE_WPA_STATE}), eo3.a.f473303p, false);
        Z = UltraSettingsManager.a().a(r165.f271017a, r165.f271018b, r165.getType(), r165.f271020d, r100[50]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r166 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_voice_chat_room_short_video_switch_enable", r121, r117, false);
        f556038a0 = UltraSettingsManager.a().a(r166.f271017a, r166.f271018b, r166.getType(), r166.f271020d, r100[51]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r167 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_voice_chat_schema_check_opt", r116, r117, false);
        f556040b0 = UltraSettingsManager.a().a(r167.f271017a, r167.f271018b, r167.getType(), r167.f271020d, r100[52]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r168 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("big_party_enable_open_camera", 1, r143, false);
        f556042c0 = UltraSettingsManager.a().a(r168.f271017a, r168.f271018b, r168.getType(), r168.f271020d, r100[53]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r169 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_audience_default_open_camera", r116, r117, false);
        f556044d0 = UltraSettingsManager.a().a(r169.f271017a, r169.f271018b, r169.getType(), r169.f271020d, r100[54]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r170 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("interact_permission_guarantor_enable", r116, r117, false);
        f556046e0 = UltraSettingsManager.a().a(r170.f271017a, r170.f271018b, r170.getType(), r170.f271020d, r100[55]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r171 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_link_admin_fanticket_show_bugfix", r116, r117, false);
        f556048f0 = UltraSettingsManager.a().a(r171.f271017a, r171.f271018b, r171.getType(), r171.f271020d, r100[56]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r172 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("new_video_linkmic_permission_guarantor_enable", r116, r117, false);
        f556050g0 = UltraSettingsManager.a().a(r172.f271017a, r172.f271018b, r172.getType(), r172.f271020d, r100[57]);
        return;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.config.blackframe.AudioBlackFrameOptConfig");
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.config.LiveFastMatchConfig");
    }
}
