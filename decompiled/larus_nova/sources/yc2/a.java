package yc2;

import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.user.LiveInteractFunction;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "atUser")
public final class a extends com.bytedance.ies.web.jsbridge2.g<za2.a, Object> {
    public a() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(za2.a r100, CallContext r101) throws Exception {
        za2.a r102 = r100;
        if (((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).h().g(LiveInteractFunction.AT) == true) goto L8;
        r101.getContext();
        xs2.b.a().post(r102);
        return null;
    L8:
        return null;
    }
}
