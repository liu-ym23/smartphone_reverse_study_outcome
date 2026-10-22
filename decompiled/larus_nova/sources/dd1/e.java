package dd1;

import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes7.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f467924a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f467925b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f467926c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f467927d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReadOnlyProperty f467928e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ReadOnlyProperty f467929f = null;

    static {
        KProperty<?>[] r100 = {Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_WITHDRAW_IDENTIFY_V3", "getLIVE_WITHDRAW_IDENTIFY_V3()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_MULTIPLE_CERT_DEAL", "getLIVE_MULTIPLE_CERT_DEAL()Lcom/bytedance/android/live/wallet/model/MultipleCertDealConfig;", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "DOUYIN_CERTIFICATION_URL", "getDOUYIN_CERTIFICATION_URL()Ljava/lang/String;", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "DIAMOND_BUY_USE_REVENUE_NETWORK_API", "getDIAMOND_BUY_USE_REVENUE_NETWORK_API()Z", 1)), Reflection.property0(new PropertyReference0Impl(e.class, "LIVE_REMOVE_WALLET_USELESS_TOKEN", "getLIVE_REMOVE_WALLET_USELESS_TOKEN()Z", 1))};
        f467924a = r100;
        Boolean r101 = Boolean.FALSE;
        Class r102 = Boolean.TYPE;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r103 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_withdraw_identify_v3", r101, r102, false);
        f467925b = UltraSettingsManager.a().a(r103.f271017a, r103.f271018b, r103.getType(), r103.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("multiple_cert_deal", new com.bytedance.android.live.wallet.model.f(), com.bytedance.android.live.wallet.model.f.class, false);
        f467926c = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[1]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r105 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("douyin_certification_url", "sslocal://webcast_webview?url=https%3a%2f%2fwebcast.amemv.com%2ffalcon%2fwebcast_douyin%2fpage%2fcertification%2findex.html%3fhide_nav_bar%3d1%26hide_status_bar%3d0%26status_bar_color%3dwhite%26enter_from%3dwallet&__live_platform__=webcast", String.class, false);
        f467927d = UltraSettingsManager.a().a(r105.f271017a, r105.f271018b, r105.getType(), r105.f271020d, r100[2]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r106 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("diamond_buy_use_revenue_network_api", r101, r102, false);
        f467928e = UltraSettingsManager.a().a(r106.f271017a, r106.f271018b, r106.getType(), r106.f271020d, r100[3]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r107 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_remove_wallet_useless_token", Boolean.TRUE, r102, false);
        f467929f = UltraSettingsManager.a().a(r107.f271017a, r107.f271018b, r107.getType(), r107.f271020d, r100[4]);
    }
}
