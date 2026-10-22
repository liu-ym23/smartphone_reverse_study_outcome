package ok7;

import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;

/* JADX INFO: loaded from: classes3.dex */
@XBridgeMethod(name = "luckyCatGetSettingsInfoDecoded", owner = "jianghaiyang")
public final class d extends e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f523686d;

    @Override // ok7.e, com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return "luckyCatGetSettingsInfoDecoded";
    }

    public d() {
        this.f523686d = "LuckyDogGetSettingsDecodedMethod";
    }

    @Override // ok7.e
    public final String f() {
        return this.f523686d;
    }

    @Override // ok7.e, com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, com.bytedance.ies.xbridge.XBridgeMethod.Callback r101, XBridgePlatformType r102) {
        g(r100, r101, true);
    }
}
