package v41;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f553042a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f553043b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f553044c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f553045d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f553046e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f553047f = null;

    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(b.class, "anchorLinkExtScoreShowEnable", "getAnchorLinkExtScoreShowEnable()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "anchorLinkProfitInteractionDataFix", "getAnchorLinkProfitInteractionDataFix()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "multiAnchorFixProfitInteractContextLifecycle", "getMultiAnchorFixProfitInteractContextLifecycle()Z", 0)), Reflection.property1(new PropertyReference1Impl(b.class, "liveAnchorLinkScoreRuleLynxUrl", "getLiveAnchorLinkScoreRuleLynxUrl()Ljava/lang/String;", 0))};
        f553042a = r100;
        f553047f = new b();
        Boolean r101 = Boolean.TRUE;
        Class r102 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("anchor_link_ext_score_show_enable", r101, r102, false);
        f553043b = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("anchor_link_profit_interaction_data_fix", r101, r102, false);
        f553044c = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multi_anchor_profit_interact_context_lifecycle", r101, r102, false);
        f553045d = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_anchor_link_score_rule_lynx_url", "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-sourcecdn-tos.bytegecko.com%2Fobj%2Fbyte-gurd-source%2Fwebcast%2Fmono%2Flynx%2Frevenue_pk_hybrid_douyin%2Fpages%2Flink_score_rule%2Ftemplate.js&gravity=bottom&type=popup&rate_height=271&radius=8&pull_down_close=1&pull_down_indicator_not_show=1", String.class, false);
        f553046e = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[3]);
    }

    public b() {
    }

    public final boolean a() {
        return ((Boolean) f553043b.getValue(this, f553042a[0])).booleanValue();
    }
}
