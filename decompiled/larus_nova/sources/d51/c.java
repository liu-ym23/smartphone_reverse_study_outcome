package d51;

import com.bytedance.android.live.revlink.impl.utils.b0;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import r41.g;
import r41.h;
import r41.j;

/* JADX INFO: loaded from: classes47.dex */
public final class c {
    public static final ReadOnlyProperty A = null;
    public static final c A0 = null;
    public static final ReadOnlyProperty B = null;
    public static final ReadOnlyProperty C = null;
    public static final ReadOnlyProperty D = null;
    public static final ReadOnlyProperty E = null;
    public static final ReadOnlyProperty F = null;
    public static final ReadOnlyProperty G = null;
    public static final ReadOnlyProperty H = null;
    public static final ReadOnlyProperty I = null;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final ReadOnlyProperty f466914J = null;
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
    public static final /* synthetic */ KProperty[] f466915a = null;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final ReadOnlyProperty f466916a0 = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f466917b = null;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public static final ReadOnlyProperty f466918b0 = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f466919c = null;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final ReadOnlyProperty f466920c0 = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f466921d = null;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final ReadOnlyProperty f466922d0 = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f466923e = null;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final ReadOnlyProperty f466924e0 = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f466925f = null;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public static final ReadOnlyProperty f466926f0 = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f466927g = null;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public static final ReadOnlyProperty f466928g0 = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f466929h = null;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final ReadOnlyProperty f466930h0 = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f466931i = null;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final ReadOnlyProperty f466932i0 = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReadOnlyProperty f466933j = null;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public static final ReadOnlyProperty f466934j0 = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ReadOnlyProperty f466935k = null;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final ReadOnlyProperty f466936k0 = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ReadOnlyProperty f466937l = null;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public static final ReadOnlyProperty f466938l0 = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final ReadOnlyProperty f466939m = null;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public static final ReadOnlyProperty f466940m0 = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final ReadOnlyProperty f466941n = null;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final ReadOnlyProperty f466942n0 = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ReadOnlyProperty f466943o = null;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final ReadOnlyProperty f466944o0 = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final ReadOnlyProperty f466945p = null;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final ReadOnlyProperty f466946p0 = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final ReadOnlyProperty f466947q = null;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public static final ReadOnlyProperty f466948q0 = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final ReadOnlyProperty f466949r = null;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public static final ReadOnlyProperty f466950r0 = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final ReadOnlyProperty f466951s = null;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public static final ReadOnlyProperty f466952s0 = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final ReadOnlyProperty f466953t = null;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public static final ReadOnlyProperty f466954t0 = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final ReadOnlyProperty f466955u = null;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public static final ReadOnlyProperty f466956u0 = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final ReadOnlyProperty f466957v = null;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public static final ReadOnlyProperty f466958v0 = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final ReadOnlyProperty f466959w = null;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final ReadOnlyProperty f466960w0 = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final ReadOnlyProperty f466961x = null;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public static final ReadOnlyProperty f466962x0 = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final ReadOnlyProperty f466963y = null;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public static final ReadOnlyProperty f466964y0 = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final ReadOnlyProperty f466965z = null;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public static final ReadOnlyProperty f466966z0 = null;

    public c() {
    }

    public final boolean a() {
        return ((Boolean) f466934j0.getValue(this, f466915a[60])).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) f466919c.getValue(this, f466915a[1])).booleanValue();
    }

    public final com.bytedance.android.live.revlink.impl.monitor.c c() {
        return (com.bytedance.android.live.revlink.impl.monitor.c) f466961x.getValue(this, f466915a[22]);
    }

    public final boolean d() {
        return ((Boolean) f466940m0.getValue(this, f466915a[63])).booleanValue();
    }

    public final boolean e() {
        return ((Boolean) f466922d0.getValue(this, f466915a[54])).booleanValue();
    }

    public final boolean f() {
        return ((Boolean) f466939m.getValue(this, f466915a[11])).booleanValue();
    }

    public final boolean g() {
        return ((Boolean) f466945p.getValue(this, f466915a[14])).booleanValue();
    }

    public final boolean h() {
        return ((Boolean) I.getValue(this, f466915a[33])).booleanValue();
    }

    public final boolean i() {
        return ((Boolean) f466928g0.getValue(this, f466915a[57])).booleanValue();
    }

    public final String j() {
        return (String) f466953t.getValue(this, f466915a[18]);
    }

    public final String k() {
        return (String) f466941n.getValue(this, f466915a[12]);
    }

    public final boolean l() {
        return ((Boolean) f466917b.getValue(this, f466915a[0])).booleanValue();
    }

    public final boolean m() {
        return ((Boolean) f466948q0.getValue(this, f466915a[67])).booleanValue();
    }

    public final int n() {
        return ((Number) N.getValue(this, f466915a[38])).intValue();
    }

    public final j o() {
        return (j) Y.getValue(this, f466915a[49]);
    }

    public final Map<Long, r41.d> p() {
        return (Map) f466937l.getValue(this, f466915a[10]);
    }

    public final boolean q() {
        return ((Boolean) f466966z0.getValue(this, f466915a[76])).booleanValue();
    }

    public final h r() {
        return (h) f466952s0.getValue(this, f466915a[69]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(c.class, "livePkEnable", "getLivePkEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "linkPartnerPlaySeiEnable", "getLinkPartnerPlaySeiEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "linkPartnerFeedPlayOpt", "getLinkPartnerFeedPlayOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "widgetLeakFixEnable", "getWidgetLeakFixEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkDisableToast", "getLivePkDisableToast()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "pkSupportLinkScore", "getPkSupportLinkScore()F", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "pkSpeedDisable", "getPkSpeedDisable()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "pkSupportLink", "getPkSupportLink()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePenalDefaultTitle", "getLivePenalDefaultTitle()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkFinishStatsBackupDelay", "getLivePkFinishStatsBackupDelay()J", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkSkinPackage", "getLivePkSkinPackage()Ljava/util/Map;", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "liveMockLinkEnable", "getLiveMockLinkEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkDenoiseTopBgUrl", "getLivePkDenoiseTopBgUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "liveEnableWangZheLinkNewStyle", "getLiveEnableWangZheLinkNewStyle()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkAnchorLayoutRatio", "getLivePkAnchorLayoutRatio()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkAnchorFullOpt", "getLivePkAnchorFullOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkPcEnterOptEnable", "getLivePkPcEnterOptEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "liveWangZheEnableGameStickerLand", "getLiveWangZheEnableGameStickerLand()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkDenoiseBottomBgUrl", "getLivePkDenoiseBottomBgUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "liveRevlinkMainTabPopUrl", "getLiveRevlinkMainTabPopUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "liveRevlinkChangeOrganizerPopUrl", "getLiveRevlinkChangeOrganizerPopUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "pkSeiCheckConfig", "getPkSeiCheckConfig()Lcom/bytedance/android/live/revlink/impl/utils/SeiCheckConfig;", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "linkSceneStallConfig", "getLinkSceneStallConfig()Lcom/bytedance/android/live/revlink/impl/monitor/RevLinkSceneStallConfig;", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkAtmosphereAnimationUrls", "getLivePkAtmosphereAnimationUrls()Lcom/bytedance/android/live/revlink/impl/settings/config/PKAtmosphereAnimationUrl;", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "liveLastPkResultDetailsLynxUrl", "getLiveLastPkResultDetailsLynxUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "liveLinkConPerfReportEnable", "getLiveLinkConPerfReportEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "pkCrossTalkOpt", "getPkCrossTalkOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "pkUnexpectedAnchorFrameMuteOpt", "getPkUnexpectedAnchorFrameMuteOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "pkBackgroundStreamOpt", "getPkBackgroundStreamOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkEnableQueryDataOnDefaultLink", "getLivePkEnableQueryDataOnDefaultLink()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "multiRevenuePkRoomBattleIdBackup", "getMultiRevenuePkRoomBattleIdBackup()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkFeedTypeAllowList", "getLivePkFeedTypeAllowList()Ljava/util/List;", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkPreloadAsync", "getLivePkPreloadAsync()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkAudienceApiCallReportEnable", "getLivePkAudienceApiCallReportEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "enablePkSeasonPlayTagCheck", "getEnablePkSeasonPlayTagCheck()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkProgressBarOptSetting", "getLivePkProgressBarOptSetting()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "allowGiftToLinker", "getAllowGiftToLinker()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkSeiOverlapCheck", "getLivePkSeiOverlapCheck()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkLiveRoomOptSetting", "getLivePkLiveRoomOptSetting()I", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkLiveLiveRoomOptAnchor", "getLivePkLiveLiveRoomOptAnchor()I", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "pkSeiCheckEnable", "getPkSeiCheckEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkBattleMessageValidCheck", "getLivePkBattleMessageValidCheck()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkIgnoreLinkerLeave", "getLivePkIgnoreLinkerLeave()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "battleMsgLoadDoublePkCheck", "getBattleMsgLoadDoublePkCheck()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkTimeStuckCheck", "getLivePkTimeStuckCheck()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkGuestUidErrorLog", "getLivePkGuestUidErrorLog()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkEnsureStartInteract", "getLivePkEnsureStartInteract()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkTimeStuckCheckDuration", "getLivePkTimeStuckCheckDuration()J", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "breakThroughAtmosphereUrl", "getBreakThroughAtmosphereUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkPropCardConfig", "getLivePkPropCardConfig()Lcom/bytedance/android/live/revlink/impl/settings/config/PkPropCardConfig;", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkPanelEnableAutoLocate", "getLivePkPanelEnableAutoLocate()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "liveMultinkLinkAutoLoadPanel", "getLiveMultinkLinkAutoLoadPanel()I", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkBeInviteDialogOvertime", "getLivePkBeInviteDialogOvertime()I", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkBeInviteDialogShowFan", "getLivePkBeInviteDialogShowFan()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "liveConnectionInviteTrackingDelay", "getLiveConnectionInviteTrackingDelay()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkMultiInitShowLastBattleResult", "getLivePkMultiInitShowLastBattleResult()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkRequestExpiredPropCardTime", "getLivePkRequestExpiredPropCardTime()J", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkBattleEndPunishEnable", "getLivePkBattleEndPunishEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePlayerSeiJsonOptimize", "getLivePlayerSeiJsonOptimize()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePlayerSeiJsonCacheSize", "getLivePlayerSeiJsonCacheSize()I", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "kmpScopeServiceAllowNull", "getKmpScopeServiceAllowNull()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "removeRandomPKOnceMore", "getRemoveRandomPKOnceMore()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "pkEndNotConsumeResponse", "getPkEndNotConsumeResponse()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "liveAudioSceneAlignPk", "getLiveAudioSceneAlignPk()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "pkLandScapeChangeSetting", "getPkLandScapeChangeSetting()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "logInviteSupportInviteTypeList", "getLogInviteSupportInviteTypeList()[Ljava/lang/Integer;", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "pkNextLiveDataWithNotifyFix", "getPkNextLiveDataWithNotifyFix()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkEndLogFix", "getLivePkEndLogFix()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "openPkRecordPanelEventFix", "getOpenPkRecordPanelEventFix()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "pkPreciseFindPeopleConfig", "getPkPreciseFindPeopleConfig()Lcom/bytedance/android/live/revlink/impl/settings/config/PKPreciseFindPeopleConfig;", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "harmonySeiFixEnable", "getHarmonySeiFixEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "harmonyLinkFoldableAdapt", "getHarmonyLinkFoldableAdapt()F", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "livePkRandomMatchTypeFix", "getLivePkRandomMatchTypeFix()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "liveDoublePkAudienceTopOffsetFix", "getLiveDoublePkAudienceTopOffsetFix()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "liveAudioPunishToastFix", "getLiveAudioPunishToastFix()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "liveRankSeasonPkRandomMatchNotice", "getLiveRankSeasonPkRandomMatchNotice()Z", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "liveTeamPkBattleConfigSettingParamsOpt", "getLiveTeamPkBattleConfigSettingParamsOpt()Z", 0))};
        f466915a = r100;
        A0 = new c();
        Boolean r110 = Boolean.TRUE;
        Class r111 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("enable_live_pk", r110, r111, false);
        f466917b = UltraSettingsManager.a().a(r101.b(), r101.a(), r101.getType(), r101.c(), r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("enable_linker_partner_sei_enable", r110, r111, false);
        f466919c = UltraSettingsManager.a().a(r102.b(), r102.a(), r102.getType(), r102.c(), r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("link_partner_feed_play_opt", r110, r111, false);
        f466921d = UltraSettingsManager.a().a(r103.b(), r103.a(), r103.getType(), r103.c(), r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_widget_rev_callback_leak_fix", r110, r111, false);
        f466923e = UltraSettingsManager.a().a(r104.b(), r104.a(), r104.getType(), r104.c(), r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_disable_toast", "功能升级中，敬请期待", String.class, false);
        f466925f = UltraSettingsManager.a().a(r105.b(), r105.a(), r105.getType(), r105.c(), r100[4]);
        Float r106 = Float.valueOf(5.5f);
        Class r107 = Float.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_support_link_score", r106, r107, false);
        f466927g = UltraSettingsManager.a().a(r108.b(), r108.a(), r108.getType(), r108.c(), r100[5]);
        Boolean r109 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r112 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_disable_pk_speed_button", r109, r111, false);
        f466929h = UltraSettingsManager.a().a(r112.b(), r112.a(), r112.getType(), r112.c(), r100[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r113 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_support_link", r110, r111, false);
        f466931i = UltraSettingsManager.a().a(r113.b(), r113.a(), r113.getType(), r113.c(), r100[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r114 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_penal_default_title", "PK结束", String.class, false);
        f466933j = UltraSettingsManager.a().a(r114.b(), r114.a(), r114.getType(), r114.c(), r100[8]);
        Class r115 = Long.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r116 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_finish_stats_backup_delay", 3L, r115, false);
        f466935k = UltraSettingsManager.a().a(r116.b(), r116.a(), r116.getType(), r116.c(), r100[9]);
        int r117 = r41.d.f536018a;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r118 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_skin_package", r41.d.a.a(), zn3.a.f572928n, false);
        f466937l = UltraSettingsManager.a().a(r118.b(), r118.a(), r118.getType(), r118.c(), r100[10]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r119 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_mock_link_enable", r109, r111, false);
        f466939m = UltraSettingsManager.a().a(r119.b(), r119.a(), r119.getType(), r119.c(), r100[11]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r120 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_denoise_top_bg_url", "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_pk_top_bg_denoise2.png", String.class, false);
        f466941n = UltraSettingsManager.a().a(r120.b(), r120.a(), r120.getType(), r120.c(), r100[12]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r121 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_enable_wang_zhe_link_new_style", r110, r111, false);
        f466943o = UltraSettingsManager.a().a(r121.b(), r121.a(), r121.getType(), r121.c(), r100[13]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r122 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revlink_anchor_layout_ratio_opt", r110, r111, false);
        f466945p = UltraSettingsManager.a().a(r122.b(), r122.a(), r122.getType(), r122.c(), r100[14]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r123 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revlink_anchor_layout_full_opt", r110, r111, false);
        f466947q = UltraSettingsManager.a().a(r123.b(), r123.a(), r123.getType(), r123.c(), r100[15]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r124 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_pc_enter_opt_enable", r109, r111, false);
        f466949r = UltraSettingsManager.a().a(r124.b(), r124.a(), r124.getType(), r124.c(), r100[16]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r125 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_wangzhe_enable_game_sticker_land", r110, r111, false);
        f466951s = UltraSettingsManager.a().a(r125.b(), r125.a(), r125.getType(), r125.c(), r100[17]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r126 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_denoise_bottom_bg_url", "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_pk_bottom_bg_denoise2.png", String.class, false);
        f466953t = UltraSettingsManager.a().a(r126.b(), r126.a(), r126.getType(), r126.c(), r100[18]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r127 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revlink_main_tab_pop_url", "", String.class, false);
        f466955u = UltraSettingsManager.a().a(r127.b(), r127.a(), r127.getType(), r127.c(), r100[19]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r128 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revlink_host_selection_page", "", String.class, false);
        f466957v = UltraSettingsManager.a().a(r128.b(), r128.a(), r128.getType(), r128.c(), r100[20]);
        Class<?> r129 = ((JsonAdapter) b0.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r130 = vh7.b.a();
        Object r131 = r130.get(r129);
        if (r131 != null) goto L12;
        r131 = r129.getConstructor(new Class[0]);
        if (r131 == null) goto L11;
        Object r132 = r130.putIfAbsent(r129, r131);
        if (r132 == null) goto L12;
        r131 = r132;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r133 = ((SerializableObjectJsonAdapterBase) ((Constructor) r131).newInstance(new Object[0])).createInstance();
        if (r133 == null) goto L73;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r134 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_sei_switch_config", (b0) r133, b0.class, false);
        f466959w = UltraSettingsManager.a().a(r134.b(), r134.a(), r134.getType(), r134.c(), r100[21]);
        Class<?> r135 = ((JsonAdapter) com.bytedance.android.live.revlink.impl.monitor.c.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r136 = vh7.b.a();
        Object r137 = r136.get(r135);
        if (r137 != null) goto L24;
        r137 = r135.getConstructor(new Class[0]);
        if (r137 == null) goto L23;
        Object r138 = r136.putIfAbsent(r135, r137);
        if (r138 == null) goto L24;
        r137 = r138;
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L24:
        Object r139 = ((SerializableObjectJsonAdapterBase) ((Constructor) r137).newInstance(new Object[0])).createInstance();
        if (r139 == null) goto L71;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r140 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_player_scene_stall_monitor_config", (com.bytedance.android.live.revlink.impl.monitor.c) r139, com.bytedance.android.live.revlink.impl.monitor.c.class, false);
        f466961x = UltraSettingsManager.a().a(r140.b(), r140.a(), r140.getType(), r140.c(), r100[22]);
        Class<?> r141 = ((JsonAdapter) g.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r142 = vh7.b.a();
        Object r143 = r142.get(r141);
        if (r143 != null) goto L36;
        r143 = r141.getConstructor(new Class[0]);
        if (r143 == null) goto L35;
        Object r144 = r142.putIfAbsent(r141, r143);
        if (r144 == null) goto L36;
        r143 = r144;
        goto L36
    L35:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L36:
        Object r145 = ((SerializableObjectJsonAdapterBase) ((Constructor) r143).newInstance(new Object[0])).createInstance();
        if (r145 == null) goto L69;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r146 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_atmosphere_animation_urls", (g) r145, g.class, false);
        f466963y = UltraSettingsManager.a().a(r146.b(), r146.a(), r146.getType(), r146.c(), r100[23]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r147 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_last_pk_result_details_lynx_url", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2F10181%2Fgecko%2Fresource%2Frevenue_pk_hybrid_douyin%2Fpages%2Fpk_result_details%2Ftemplate.js&gravity=bottom&type=popup&rate_height=382&radius=8&pull_down_close=1&pull_down_indicator_not_show=1", String.class, false);
        f466965z = UltraSettingsManager.a().a(r147.b(), r147.a(), r147.getType(), r147.c(), r100[24]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r148 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_con_perf_report_enable", r109, r111, false);
        A = UltraSettingsManager.a().a(r148.b(), r148.a(), r148.getType(), r148.c(), r100[25]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r149 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_cross_talk_opt", r110, r111, false);
        B = UltraSettingsManager.a().a(r149.b(), r149.a(), r149.getType(), r149.c(), r100[26]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r150 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_unexpected_anchor_frame_mute_opt", r110, r111, false);
        C = UltraSettingsManager.a().a(r150.b(), r150.a(), r150.getType(), r150.c(), r100[27]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r151 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_background_stream_opt", r109, r111, false);
        D = UltraSettingsManager.a().a(r151.b(), r151.a(), r151.getType(), r151.c(), r100[28]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r152 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_enable_query_data_on_default_link", r109, r111, false);
        E = UltraSettingsManager.a().a(r152.b(), r152.a(), r152.getType(), r152.c(), r100[29]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r153 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_revenue_pk_room_battle_id_back_up", r109, r111, false);
        F = UltraSettingsManager.a().a(r153.b(), r153.a(), r153.getType(), r153.c(), r100[30]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r154 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_feed_type_allow_list", CollectionsKt.emptyList(), zn3.a.f572921g, false);
        G = UltraSettingsManager.a().a(r154.b(), r154.a(), r154.getType(), r154.c(), r100[31]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r155 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_preload_async", r110, r111, false);
        H = UltraSettingsManager.a().a(r155.b(), r155.a(), r155.getType(), r155.c(), r100[32]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r156 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_audience_api_call_tea_enable", r110, r111, false);
        I = UltraSettingsManager.a().a(r156.b(), r156.a(), r156.getType(), r156.c(), r100[33]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r157 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_enable_play_tag_check", r110, r111, false);
        f466914J = UltraSettingsManager.a().a(r157.b(), r157.a(), r157.getType(), r157.c(), r100[34]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r158 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_progress_bar_opt", r110, r111, false);
        K = UltraSettingsManager.a().a(r158.b(), r158.a(), r158.getType(), r158.c(), r100[35]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r159 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("allow_gift_to_linker", r110, r111, false);
        L = UltraSettingsManager.a().a(r159.b(), r159.a(), r159.getType(), r159.c(), r100[36]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r160 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_sei_overlap_check", r110, r111, false);
        M = UltraSettingsManager.a().a(r160.b(), r160.a(), r160.getType(), r160.c(), r100[37]);
        Class r161 = Integer.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r162 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_live_room_opt_setting", 4, r161, false);
        N = UltraSettingsManager.a().a(r162.b(), r162.a(), r162.getType(), r162.c(), r100[38]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r163 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_live_room_opt_anchor", 1, r161, false);
        O = UltraSettingsManager.a().a(r163.b(), r163.a(), r163.getType(), r163.c(), r100[39]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r164 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_sei_check_enable", r110, r111, false);
        P = UltraSettingsManager.a().a(r164.b(), r164.a(), r164.getType(), r164.c(), r100[40]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r165 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_battle_message_valid_check", r110, r111, false);
        Q = UltraSettingsManager.a().a(r165.b(), r165.a(), r165.getType(), r165.c(), r100[41]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r166 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_ignore_linker_leave", r110, r111, false);
        R = UltraSettingsManager.a().a(r166.b(), r166.a(), r166.getType(), r166.c(), r100[42]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r167 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("battle_msg_load_double_pk_check", r110, r111, false);
        S = UltraSettingsManager.a().a(r167.b(), r167.a(), r167.getType(), r167.c(), r100[43]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r168 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_time_stuck_check", r110, r111, false);
        T = UltraSettingsManager.a().a(r168.b(), r168.a(), r168.getType(), r168.c(), r100[44]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r169 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_guest_uid_error_log", r110, r111, true);
        U = UltraSettingsManager.a().a(r169.b(), r169.a(), r169.getType(), r169.c(), r100[45]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r170 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_ensure_start_interact", r110, r111, true);
        V = UltraSettingsManager.a().a(r170.b(), r170.a(), r170.getType(), r170.c(), r100[46]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r171 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_time_stuck_check_duration", 5L, r115, false);
        W = UltraSettingsManager.a().a(r171.b(), r171.a(), r171.getType(), r171.c(), r100[47]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r172 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("break_through_atmosphere_url", "https://p6-webcast.douyinpic.com/obj/live-android/break_through_star_anim.webp", String.class, true);
        X = UltraSettingsManager.a().a(r172.b(), r172.a(), r172.getType(), r172.c(), r100[48]);
        Class<?> r173 = ((JsonAdapter) j.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r174 = vh7.b.a();
        Object r175 = r174.get(r173);
        if (r175 != null) goto L48;
        r175 = r173.getConstructor(new Class[0]);
        if (r175 == null) goto L47;
        Object r176 = r174.putIfAbsent(r173, r175);
        if (r176 == null) goto L48;
        r175 = r176;
        goto L48
    L47:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L48:
        Object r177 = ((SerializableObjectJsonAdapterBase) ((Constructor) r175).newInstance(new Object[0])).createInstance();
        if (r177 == null) goto L67;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r178 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_prop_card_config", (j) r177, j.class, false);
        Y = UltraSettingsManager.a().a(r178.b(), r178.a(), r178.getType(), r178.c(), r100[49]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r179 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_panel_enable_auto_locate", r109, r111, false);
        Z = UltraSettingsManager.a().a(r179.b(), r179.a(), r179.getType(), r179.c(), r100[50]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r180 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_multi_link_auto_load_panel", 3, r161, false);
        f466916a0 = UltraSettingsManager.a().a(r180.b(), r180.a(), r180.getType(), r180.c(), r100[51]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r181 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_be_invite_dialog_overtime", 10, r161, false);
        f466918b0 = UltraSettingsManager.a().a(r181.b(), r181.a(), r181.getType(), r181.c(), r100[52]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r182 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_be_invite_dialog_show_fan", r109, r111, false);
        f466920c0 = UltraSettingsManager.a().a(r182.b(), r182.a(), r182.getType(), r182.c(), r100[53]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r183 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_connection_invite_tracking_delay", r110, r111, false);
        f466922d0 = UltraSettingsManager.a().a(r183.b(), r183.a(), r183.getType(), r183.c(), r100[54]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r184 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_multi_init_show_last_battle_result", r109, r111, false);
        f466924e0 = UltraSettingsManager.a().a(r184.b(), r184.a(), r184.getType(), r184.c(), r100[55]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r185 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_request_expired_prop_card_time", 50L, r115, false);
        f466926f0 = UltraSettingsManager.a().a(r185.b(), r185.a(), r185.getType(), r185.c(), r100[56]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r186 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_battle_end_punish_enable", r110, r111, true);
        f466928g0 = UltraSettingsManager.a().a(r186.b(), r186.a(), r186.getType(), r186.c(), r100[57]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r187 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_player_sei_json_optimize", r109, r111, false);
        f466930h0 = UltraSettingsManager.a().a(r187.b(), r187.a(), r187.getType(), r187.c(), r100[58]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r188 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_player_sei_json_cache_size", 20, r161, false);
        f466932i0 = UltraSettingsManager.a().a(r188.b(), r188.a(), r188.getType(), r188.c(), r100[59]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r189 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_kmp_scope_service_allow_null", r110, r111, false);
        f466934j0 = UltraSettingsManager.a().a(r189.b(), r189.a(), r189.getType(), r189.c(), r100[60]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r190 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_remove_random_pk_once_more", r109, r111, false);
        f466936k0 = UltraSettingsManager.a().a(r190.b(), r190.a(), r190.getType(), r190.c(), r100[61]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r191 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_end_not_consume_response", r109, r111, false);
        f466938l0 = UltraSettingsManager.a().a(r191.b(), r191.a(), r191.getType(), r191.c(), r100[62]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r192 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_revenue_interact_audio_opt", r109, r111, false);
        f466940m0 = UltraSettingsManager.a().a(r192.b(), r192.a(), r192.getType(), r192.c(), r100[63]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r193 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_wangzhe_landscape_change_fix", r110, r111, false);
        f466942n0 = UltraSettingsManager.a().a(r193.b(), r193.a(), r193.getType(), r193.c(), r100[64]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r194 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_log_invite_type_list", new Integer[0], zn3.a.f572919e, false);
        f466944o0 = UltraSettingsManager.a().a(r194.b(), r194.a(), r194.getType(), r194.c(), r100[65]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r195 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_next_live_data_with_notify_fix", r110, r111, false);
        f466946p0 = UltraSettingsManager.a().a(r195.b(), r195.a(), r195.getType(), r195.c(), r100[66]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r196 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("livesdk_pk_end_log_fix", r110, r111, false);
        f466948q0 = UltraSettingsManager.a().a(r196.b(), r196.a(), r196.getType(), r196.c(), r100[67]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r197 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("livesdk_pk_open_record_panel_event_fix", r110, r111, false);
        f466950r0 = UltraSettingsManager.a().a(r197.b(), r197.a(), r197.getType(), r197.c(), r100[68]);
        Class<?> r198 = ((JsonAdapter) h.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r199 = vh7.b.a();
        Object r200 = r199.get(r198);
        if (r200 != null) goto L60;
        r200 = r198.getConstructor(new Class[0]);
        if (r200 == null) goto L59;
        Object r201 = r199.putIfAbsent(r198, r200);
        if (r201 == null) goto L60;
        r200 = r201;
        goto L60
    L59:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L60:
        Object r202 = ((SerializableObjectJsonAdapterBase) ((Constructor) r200).newInstance(new Object[0])).createInstance();
        if (r202 == null) goto L65;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r203 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("livesdk_pk_precise_find_people_config", (h) r202, h.class, false);
        f466952s0 = UltraSettingsManager.a().a(r203.b(), r203.a(), r203.getType(), r203.c(), r100[69]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r204 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_sei_harmony_fix", r110, r111, false);
        f466954t0 = UltraSettingsManager.a().a(r204.b(), r204.a(), r204.getType(), r204.c(), r100[70]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r205 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_link_harmony_link_foldable_adapt", Float.valueOf(1.61f), r107, false);
        f466956u0 = UltraSettingsManager.a().a(r205.b(), r205.a(), r205.getType(), r205.c(), r100[71]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r206 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_random_match_type_fix", r110, r111, false);
        f466958v0 = UltraSettingsManager.a().a(r206.b(), r206.a(), r206.getType(), r206.c(), r100[72]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r207 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_double_pk_audience_top_offset_fix", r110, r111, false);
        f466960w0 = UltraSettingsManager.a().a(r207.b(), r207.a(), r207.getType(), r207.c(), r100[73]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r208 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_audio_punish_toast_fix", r110, r111, false);
        f466962x0 = UltraSettingsManager.a().a(r208.b(), r208.a(), r208.getType(), r208.c(), r100[74]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r209 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_rank_season_pk_random_match_notice", r110, r111, false);
        f466964y0 = UltraSettingsManager.a().a(r209.b(), r209.a(), r209.getType(), r209.c(), r100[75]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r210 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_team_pk_battle_config_setting", r110, r111, false);
        f466966z0 = UltraSettingsManager.a().a(r210.b(), r210.a(), r210.getType(), r210.c(), r100[76]);
        return;
    L65:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.settings.config.PKPreciseFindPeopleConfig");
    L67:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.settings.config.PkPropCardConfig");
    L69:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.settings.config.PKAtmosphereAnimationUrl");
    L71:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.monitor.RevLinkSceneStallConfig");
    L73:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.impl.utils.SeiCheckConfig");
    }
}
