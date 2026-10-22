package y41;

import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class f {
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
    public static final ReadOnlyProperty f565959J = null;
    public static final ReadOnlyProperty K = null;
    public static final ReadOnlyProperty L = null;
    public static final ReadOnlyProperty M = null;
    public static final f N = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f565960a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f565961b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f565962c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f565963d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f565964e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f565965f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f565966g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f565967h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f565968i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReadOnlyProperty f565969j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ReadOnlyProperty f565970k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ReadOnlyProperty f565971l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ReadOnlyProperty f565972m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ReadOnlyProperty f565973n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ReadOnlyProperty f565974o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ReadOnlyProperty f565975p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ReadOnlyProperty f565976q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ReadOnlyProperty f565977r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final ReadOnlyProperty f565978s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ReadOnlyProperty f565979t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final ReadOnlyProperty f565980u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final ReadOnlyProperty f565981v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final ReadOnlyProperty f565982w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final ReadOnlyProperty f565983x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final ReadOnlyProperty f565984y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final ReadOnlyProperty f565985z = null;

    public f() {
    }

    public final boolean a() {
        return ((Boolean) f565985z.getValue(this, f565960a[24])).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) f565983x.getValue(this, f565960a[22])).booleanValue();
    }

    public final boolean c() {
        return ((Boolean) M.getValue(this, f565960a[37])).booleanValue();
    }

    public final boolean d() {
        return ((Boolean) H.getValue(this, f565960a[32])).booleanValue();
    }

    public final boolean e() {
        return ((Boolean) f565978s.getValue(this, f565960a[17])).booleanValue();
    }

    public final boolean f() {
        return ((Boolean) f565961b.getValue(this, f565960a[0])).booleanValue();
    }

    public final boolean g() {
        return ((Boolean) f565982w.getValue(this, f565960a[21])).booleanValue();
    }

    public final boolean h() {
        return ((Boolean) f565965f.getValue(this, f565960a[4])).booleanValue();
    }

    public final boolean i() {
        return ((Boolean) E.getValue(this, f565960a[29])).booleanValue();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(f.class, "multiAnchorRemoveDataHolder", "getMultiAnchorRemoveDataHolder()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiAnchorLeaveLinkRefactorDisable", "getMultiAnchorLeaveLinkRefactorDisable()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "enableInviteClearWhenTimeout", "getEnableInviteClearWhenTimeout()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "enableVideoMixPlanarRender", "getEnableVideoMixPlanarRender()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiLinkUseNewRtcConnectModel", "getMultiLinkUseNewRtcConnectModel()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "defaultMuteRemoteUser", "getDefaultMuteRemoteUser()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiLinkUseReplyLinkedUsers", "getMultiLinkUseReplyLinkedUsers()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiLinkRemoveWindowByLeaveMsg", "getMultiLinkRemoveWindowByLeaveMsg()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiLinkMockCrossTalk", "getMultiLinkMockCrossTalk()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiLinkNewConnectAdaptSwitchStream", "getMultiLinkNewConnectAdaptSwitchStream()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiAudienceSuperPreload", "getMultiAudienceSuperPreload()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiAnchorSingleViewOverlapCheck", "getMultiAnchorSingleViewOverlapCheck()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiAnchorSeiOverlapCheck", "getMultiAnchorSeiOverlapCheck()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiAnchorSeiOverlapReportControl", "getMultiAnchorSeiOverlapReportControl()J", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiAnchorPkEnable", "getMultiAnchorPkEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "nineMultiAnchorPkEnable", "getNineMultiAnchorPkEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "nineMultiAnchorEnlargeEnable", "getNineMultiAnchorEnlargeEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiAnchorMarginReviseEnable", "getMultiAnchorMarginReviseEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "nineMultiClientMixerPerfLimit", "getNineMultiClientMixerPerfLimit()F", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiAsyncPreloadData", "getMultiAsyncPreloadData()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiFixedMoveDist", "getMultiFixedMoveDist()I", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiConfigureBgEnable", "getMultiConfigureBgEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "LIVE_MULTI_LEAVE_USER_CACHE_TRY_CATCH", "getLIVE_MULTI_LEAVE_USER_CACHE_TRY_CATCH()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "enableLeaveWithFriends", "getEnableLeaveWithFriends()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "disableLeaveWithMultiFriends", "getDisableLeaveWithMultiFriends()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "enableNormalRtcLeaveKickOut", "getEnableNormalRtcLeaveKickOut()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "relinkInterceptRtcLeaveKickOutDuration", "getRelinkInterceptRtcLeaveKickOutDuration()J", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "RELINK_INVITE_TIMEOUT_DURATION", "getRELINK_INVITE_TIMEOUT_DURATION()J", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiDelayPreviewLynxLoad", "getMultiDelayPreviewLynxLoad()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "revAsyncBackgroundControl", "getRevAsyncBackgroundControl()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiBlockPkRenderViewRequestLayout", "getMultiBlockPkRenderViewRequestLayout()I", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "liveSeiFrameCompareTimeStamp", "getLiveSeiFrameCompareTimeStamp()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "liveMultiRelayoutOpt", "getLiveMultiRelayoutOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "liveMultiAnchorMoreResize", "getLiveMultiAnchorMoreResize()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "multiBgMonitorConfig", "getMultiBgMonitorConfig()Lcom/bytedance/android/live/revlink/impl/multianchor/player/layoutmanager/IMultiBgMonitorConfig;", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "liveMultiTeamTaskFixEnable", "getLiveMultiTeamTaskFixEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "liveRevenueVolumeIndicatorConfig", "getLiveRevenueVolumeIndicatorConfig()Lcom/bytedance/android/live/revlink/impl/settings/config/LiveRevenueVolumeIndicatorConfig;", 0)), Reflection.property1(new PropertyReference1Impl(f.class, "liveMultiPkSofaOpt", "getLiveMultiPkSofaOpt()Z", 0))};
        f565960a = r100;
        N = new f();
        Boolean r110 = Boolean.TRUE;
        Class r111 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_remove_data_holder", r110, r111, false);
        f565961b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        Boolean r112 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_leave_link_refactor_disable", r112, r111, false);
        f565962c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_invitee_clear_by_timeout", r110, r111, false);
        f565963d = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_link_video_mix_planar_render", r112, r111, false);
        f565964e = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_link_use_new_rtc_connect_model", r110, r111, false);
        f565965f = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_link_default_mute_remote", r110, r111, false);
        f565966g = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_link_use_reply_linked_users", r110, r111, false);
        f565967h = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_link_remove_window_by_leave_msg", r110, r111, false);
        f565968i = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r109 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_link_mock_cross_talk_problem", r112, r111, false);
        f565969j = UltraSettingsManager.a().a(r109.f271017a, r109.f271018b, r109.getType(), r109.f271020d, r100[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r113 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_link_new_connect_adapt_switch_stream", r110, r111, false);
        f565970k = UltraSettingsManager.a().a(r113.f271017a, r113.f271018b, r113.getType(), r113.f271020d, r100[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r114 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_audience_super_preload", r110, r111, false);
        f565971l = UltraSettingsManager.a().a(r114.f271017a, r114.f271018b, r114.getType(), r114.f271020d, r100[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r115 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_anchor_single_view_overlap_check", r110, r111, false);
        f565972m = UltraSettingsManager.a().a(r115.f271017a, r115.f271018b, r115.getType(), r115.f271020d, r100[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r116 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_anchor_sei_overlap_check", r110, r111, false);
        f565973n = UltraSettingsManager.a().a(r116.f271017a, r116.f271018b, r116.getType(), r116.f271020d, r100[12]);
        Class r117 = Long.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r118 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_anchor_sei_overlap_report_control", 30000L, r117, false);
        f565974o = UltraSettingsManager.a().a(r118.f271017a, r118.f271018b, r118.getType(), r118.f271020d, r100[13]);
        KmpEnv r119 = KmpEnv.f255139a;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r120 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_pk_enable", Boolean.valueOf(KmpEnv.a()), r111, false);
        f565975p = UltraSettingsManager.a().a(r120.f271017a, r120.f271018b, r120.getType(), r120.f271020d, r100[14]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r121 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_interact_so_many_anchor", r112, r111, false);
        f565976q = UltraSettingsManager.a().a(r121.f271017a, r121.f271018b, r121.getType(), r121.f271020d, r100[15]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r122 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_interact_so_many_anchor_enlarge", r112, r111, false);
        f565977r = UltraSettingsManager.a().a(r122.f271017a, r122.f271018b, r122.getType(), r122.f271020d, r100[16]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r123 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_rev_anchor_margin_enable", r112, r111, false);
        f565978s = UltraSettingsManager.a().a(r123.f271017a, r123.f271018b, r123.getType(), r123.f271020d, r100[17]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r124 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_nine_pk_client_mixer_performance_limit", Float.valueOf(5.0f), Float.TYPE, false);
        f565979t = UltraSettingsManager.a().a(r124.f271017a, r124.f271018b, r124.getType(), r124.f271020d, r100[18]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r125 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_async_preload_data", r110, r111, false);
        f565980u = UltraSettingsManager.a().a(r125.f271017a, r125.f271018b, r125.getType(), r125.f271020d, r100[19]);
        Class r126 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r127 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_fixed_move_dist", 0, r126, false);
        f565981v = UltraSettingsManager.a().a(r127.f271017a, r127.f271018b, r127.getType(), r127.f271020d, r100[20]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r128 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_configure_bg_enable", r110, r111, false);
        f565982w = UltraSettingsManager.a().a(r128.f271017a, r128.f271018b, r128.getType(), r128.f271020d, r100[21]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r129 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_leave_user_cache_try_catch", r112, r111, false);
        f565983x = UltraSettingsManager.a().a(r129.f271017a, r129.f271018b, r129.getType(), r129.f271020d, r100[22]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r130 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_leave_with_friends", r110, r111, false);
        f565984y = UltraSettingsManager.a().a(r130.f271017a, r130.f271018b, r130.getType(), r130.f271020d, r100[23]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r131 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_disable_leave_with_multi_friends", r112, r111, false);
        f565985z = UltraSettingsManager.a().a(r131.f271017a, r131.f271018b, r131.getType(), r131.f271020d, r100[24]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r132 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enable_normal_rtc_leave_kickout", r112, r111, false);
        A = UltraSettingsManager.a().a(r132.f271017a, r132.f271018b, r132.getType(), r132.f271020d, r100[25]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r133 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("relink_intercept_rtc_leave_kickout_duration", 15L, r117, false);
        B = UltraSettingsManager.a().a(r133.f271017a, r133.f271018b, r133.getType(), r133.f271020d, r100[26]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r134 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_relink_invite_timeout_duration", 30L, r117, false);
        C = UltraSettingsManager.a().a(r134.f271017a, r134.f271018b, r134.getType(), r134.f271020d, r100[27]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r135 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_delay_preview_lynx_load", r110, r111, false);
        D = UltraSettingsManager.a().a(r135.f271017a, r135.f271018b, r135.getType(), r135.f271020d, r100[28]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r136 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("rev_async_background_control", r112, r111, false);
        E = UltraSettingsManager.a().a(r136.f271017a, r136.f271018b, r136.getType(), r136.f271020d, r100[29]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r137 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_block_pk_render_view_request_layout", 0, r126, false);
        F = UltraSettingsManager.a().a(r137.f271017a, r137.f271018b, r137.getType(), r137.f271020d, r100[30]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r138 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_sei_frame_compare_timestamp", r110, r111, false);
        G = UltraSettingsManager.a().a(r138.f271017a, r138.f271018b, r138.getType(), r138.f271020d, r100[31]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r139 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_rev_multi_relayout_opt", r110, r111, false);
        H = UltraSettingsManager.a().a(r139.f271017a, r139.f271018b, r139.getType(), r139.f271020d, r100[32]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r140 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revlink_anchor_more_resize", r110, r111, false);
        I = UltraSettingsManager.a().a(r140.f271017a, r140.f271018b, r140.getType(), r140.f271020d, r100[33]);
        Class<?> r141 = ((JsonAdapter) com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager.a.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r142 = vh7.b.f554981a;
        Constructor r143 = r142.get(r141);
        if (r143 != null) goto L12;
        r143 = r141.getConstructor(new Class[0]);
        if (r143 == null) goto L11;
        Constructor<? extends SerializableObjectJsonAdapterBase> r144 = r142.putIfAbsent(r141, (Constructor<? extends SerializableObjectJsonAdapterBase>) r143);
        if (r144 == null) goto L12;
        r143 = r144;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r145 = ((SerializableObjectJsonAdapterBase) r143.newInstance(new Object[0])).createInstance();
        if (r145 == null) goto L31;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r146 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_bg_monitor_config", (com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager.a) r145, com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager.a.class, false);
        f565959J = UltraSettingsManager.a().a(r146.f271017a, r146.f271018b, r146.getType(), r146.f271020d, r100[34]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r147 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_team_task_fix_enable", r112, r111, false);
        K = UltraSettingsManager.a().a(r147.f271017a, r147.f271018b, r147.getType(), r147.f271020d, r100[35]);
        Class<?> r148 = ((JsonAdapter) r41.e.class.getAnnotation(JsonAdapter.class)).value();
        Constructor<? extends SerializableObjectJsonAdapterBase> r149 = r142.get(r148);
        if (r149 != null) goto L24;
        r149 = r148.getConstructor(new Class[0]);
        if (r149 == null) goto L23;
        Constructor<? extends SerializableObjectJsonAdapterBase> r150 = r142.putIfAbsent(r148, r149);
        if (r150 == null) goto L24;
        r149 = r150;
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L24:
        Object r151 = r149.newInstance(new Object[0]).createInstance();
        if (r151 == null) goto L29;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r152 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_volume_indicator_config", (r41.e) r151, r41.e.class, false);
        L = UltraSettingsManager.a().a(r152.f271017a, r152.f271018b, r152.getType(), r152.f271020d, r100[36]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r153 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_pk_sofa_opt", r112, r111, false);
        M = UltraSettingsManager.a().a(r153.f271017a, r153.f271018b, r153.getType(), r153.f271020d, r100[37]);
        return;
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.settings.config.LiveRevenueVolumeIndicatorConfig");
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.multianchor.player.layoutmanager.IMultiBgMonitorConfig");
    }
}
