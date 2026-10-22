package rl7;

import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import ok7.i;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "luckycatStartVibrate", owner = "pengweitao")
public final class g extends ok7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f538473a;

    public g() {
        this.f538473a = "luckycatStartVibrate";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f538473a;
    }

    @Override // ok7.a
    public final void e(XReadableMap r100, i r101) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogXBridge", "luckycatStartVibrate on call");
        int r102 = r100.getInt("duration");
        if (com.bytedance.ug.sdk.luckydog.base.container.d.a.f271729a.a(((long) r102) * 1) == false) goto L5;
        i.b(r101, 1, null, "success", 2);
        return;
    L5:
        i.b(r101, 0, null, "fail", 2);
    }
}
