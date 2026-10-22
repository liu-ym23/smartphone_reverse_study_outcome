package f51;

import com.bytedance.live.kmp.core.KmpEnv;
import com.bytedance.tools.kcp.ultrasettings.runtime.UltraSettingsManager;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f475609a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ReadOnlyProperty f475610b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReadOnlyProperty f475611c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ReadOnlyProperty f475612d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f475613e = null;

    static {
        KProperty<?>[] r100 = {Reflection.property1(new PropertyReference1Impl(a.class, "livePkPrivacyHint", "getLivePkPrivacyHint()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "livePkRuleUrl", "getLivePkRuleUrl()Ljava/lang/String;", 0)), Reflection.property1(new PropertyReference1Impl(a.class, "anchorBluetoothPermission", "getAnchorBluetoothPermission()Z", 0))};
        f475609a = r100;
        f475613e = new a();
        com.bytedance.tools.kcp.ultrasettings.runtime.a r101 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_privacy_hint", "私密账号在%s时，对方观众可看到你的直播内容", String.class, false);
        f475610b = UltraSettingsManager.a().a(r101.f271017a, r101.f271018b, r101.getType(), r101.f271020d, r100[0]);
        com.bytedance.tools.kcp.ultrasettings.runtime.a r102 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("live_pk_rule_url_android", "", String.class, false);
        f475611c = UltraSettingsManager.a().a(r102.f271017a, r102.f271018b, r102.getType(), r102.f271020d, r100[1]);
        KmpEnv r103 = KmpEnv.f255139a;
        com.bytedance.tools.kcp.ultrasettings.runtime.a r104 = new com.bytedance.tools.kcp.ultrasettings.runtime.a("anchor_bluetooth_permission", Boolean.valueOf(KmpEnv.a()), Boolean.TYPE, false);
        f475612d = UltraSettingsManager.a().a(r104.f271017a, r104.f271018b, r104.getType(), r104.f271020d, r100[2]);
    }

    public a() {
    }

    public final String a() {
        return (String) f475610b.getValue(this, f475609a[0]);
    }
}
