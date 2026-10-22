package hj7;

import com.bytedance.sdk.bridge.annotation.BridgeContext;
import com.bytedance.sdk.bridge.annotation.BridgeMethod;
import com.bytedance.sdk.bridge.annotation.BridgeParam;
import com.bytedance.sdk.bridge.model.IBridgeContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class l {
    public l() {
        com.bytedance.ug.sdk.luckycat.impl.manager.m r100 = com.bytedance.ug.sdk.luckycat.impl.manager.m.a.f271349a;
    }

    @BridgeMethod("luckycatCancelDownloadAppAd")
    public void cancelDownloadApp(@BridgeParam("data") JSONObject r100, @BridgeContext IBridgeContext r101) {
        r101.callback(a.a(0, null, ""));
    }

    @BridgeMethod("luckycatDownloadAppAd")
    public void downloadApp(@BridgeParam("data") JSONObject r100, @BridgeContext IBridgeContext r101) {
        r101.callback(a.a(0, null, ""));
    }

    @BridgeMethod("luckycatSubscribeAppAd")
    public void subscribeApp(@BridgeParam("data") JSONObject r100, @BridgeContext IBridgeContext r101) {
        r101.callback(a.a(0, null, ""));
    }

    @BridgeMethod("luckycatUnSubscribeAppAd")
    public void unSubscribeApp(@BridgeParam("data") JSONObject r100, @BridgeContext IBridgeContext r101) {
        r101.callback(a.a(0, null, ""));
    }
}
