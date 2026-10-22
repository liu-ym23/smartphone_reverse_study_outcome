package rl7;

import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import ok7.i;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "luckycatStopVibrate", owner = "pengweitao")
public final class h extends ok7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f538474a;

    public h() {
        this.f538474a = "luckycatStopVibrate";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f538474a;
    }

    @Override // ok7.a
    public final void e(XReadableMap r100, i r101) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogXBridge", "luckycatStopVibrate on call");
        com.bytedance.ug.sdk.luckydog.base.container.d.a.f271729a.b();
        i.b(r101, 1, null, "success", 2);
    }
}
