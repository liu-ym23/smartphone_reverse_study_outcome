package ok7;

import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;

/* JADX INFO: loaded from: classes3.dex */
@XBridgeMethod(name = "luckycatSyncTokenToClipboard", owner = "pengweitao")
public final class n extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f523696a;

    public n() {
        this.f523696a = "luckycatSyncTokenToClipboard";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f523696a;
    }

    @Override // ok7.a
    public final void e(XReadableMap r100, i r101) {
        com.bytedance.ug.sdk.luckydog.api.log.d.d("LuckyDogXBridge", "LuckycatSyncTokenToClipboard on call");
        lm7.a.d();
        i.b(r101, 1, null, "success", 2);
    }
}
