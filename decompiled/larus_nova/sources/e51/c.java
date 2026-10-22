package e51;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f471044a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f471045b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f471046c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f471047d = null;

    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(c.class, "liveSpecifyGiftPkTopLynxUrl", "getLiveSpecifyGiftPkTopLynxUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(c.class, "liveBattleInviteDialogLynxUrl", "getLiveBattleInviteDialogLynxUrl()Ljava/lang/String;", 0))};
        f471044a = r100;
        f471047d = new c();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_designated_gift_activity_lynx_url", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/revenue_pk_hybrid_douyin/pages/designated_gift_pk_activity/template.js", String.class, false);
        f471045b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_battle_invite_dialog_lynx_url", j51.a.a("sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_pk_hybrid_douyin%2Fpages%2Fbattle_invite_dialog%2Ftemplate.js&gravity=bottom&type=popup&rate_height=258&radius=8&pull_down_close=1&pull_down_indicator_not_show=1", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_pk_hybrid_douyin%2Fpages%2Fbattle_invite_dialog%2Ftemplate.js&gravity=bottom&type=popup&rate_height=258&radius=8&pull_down_close=1&pull_down_indicator_not_show=1", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Frevenue_pk_hybrid_saas%2Fpages%2Fbattle_invite_dialog%2Ftemplate.js&gravity=bottom&type=popup&rate_height=258&radius=8&pull_down_close=1&pull_down_indicator_not_show=1"), String.class, false);
        f471046c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
    }

    public c() {
    }
}
