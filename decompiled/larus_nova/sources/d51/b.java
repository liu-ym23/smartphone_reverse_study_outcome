package d51;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f466901a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f466902b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f466903c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f466904d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f466905e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f466906f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ReadOnlyProperty f466907g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ReadOnlyProperty f466908h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ReadOnlyProperty f466909i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReadOnlyProperty f466910j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final ReadOnlyProperty f466911k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final ReadOnlyProperty f466912l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final b f466913m = null;

    public b() {
    }

    public final boolean a() {
        return ((Boolean) f466903c.getValue(this, f466901a[1])).booleanValue();
    }

    public final boolean b() {
        return ((Boolean) f466902b.getValue(this, f466901a[0])).booleanValue();
    }

    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(b.class, "useDynamicCotainerSizeByGet", "getUseDynamicCotainerSizeByGet()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "livePkOptEnable", "getLivePkOptEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "livePkUnloadNoticeOptEnable", "getLivePkUnloadNoticeOptEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "pkStatusBarOpt", "getPkStatusBarOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "videoTalkSwitchOpt", "getVideoTalkSwitchOpt()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "pkWithGuestStopRtcValidLinkIds", "getPkWithGuestStopRtcValidLinkIds()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "enableStopForwardRemoveMultiChannel", "getEnableStopForwardRemoveMultiChannel()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "pkSwitchLinkNotLoadVideoTalk", "getPkSwitchLinkNotLoadVideoTalk()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "livePkBarRelativeScoreShowOptEnable", "getLivePkBarRelativeScoreShowOptEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "livePkSeiDataMergeOptEnable", "getLivePkSeiDataMergeOptEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "livePkCloudOptEnable", "getLivePkCloudOptEnable()Z", 0))};
        f466901a = r100;
        f466913m = new b();
        Boolean r110 = Boolean.TRUE;
        Class r111 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_opt_use_dynamic_container_size_by_get", r110, r111, false);
        f466902b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_opt_enable", r110, r111, false);
        f466903c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_unload_notice_opt_enable", r110, r111, false);
        f466904d = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[2]);
        Boolean r104 = Boolean.FALSE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_status_bar_opt", r104, r111, false);
        f466905e = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("video_talk_and_pk_switch_widget_load_unload_enable", r110, r111, false);
        f466906f = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[4]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_with_guest_stop_rtc_valid_link_ids", r110, r111, false);
        f466907g = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[5]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r108 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("enable_stop_forward_remove_multi_channel", r110, r111, false);
        f466908h = UltraSettingsManager.a().a(r108.f271017a, r108.f271018b, r108.getType(), r108.f271020d, r100[6]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r109 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("pk_switch_link_not_load_video_talk", r110, r111, false);
        f466909i = UltraSettingsManager.a().a(r109.f271017a, r109.f271018b, r109.getType(), r109.f271020d, r100[7]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r112 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_bar_relative_score_show_opt_enable", r110, r111, false);
        f466910j = UltraSettingsManager.a().a(r112.f271017a, r112.f271018b, r112.getType(), r112.f271020d, r100[8]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r113 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_sei_data_merge_opt_enable", r104, r111, false);
        f466911k = UltraSettingsManager.a().a(r113.f271017a, r113.f271018b, r113.getType(), r113.f271020d, r100[9]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r114 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_cloud_opt_enable", r110, r111, false);
        f466912l = UltraSettingsManager.a().a(r114.f271017a, r114.f271018b, r114.getType(), r114.f271020d, r100[10]);
    }
}
