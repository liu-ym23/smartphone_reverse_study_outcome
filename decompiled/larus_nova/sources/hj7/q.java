package hj7;

import android.text.TextUtils;
import com.bytedance.sdk.bridge.annotation.BridgeContext;
import com.bytedance.sdk.bridge.annotation.BridgeMethod;
import com.bytedance.sdk.bridge.annotation.BridgeParam;
import com.bytedance.sdk.bridge.model.IBridgeContext;

/* JADX INFO: loaded from: classes22.dex */
public final class q {
    public q() {
    }

    @BridgeMethod("luckycatUpdateGeckoInfo")
    public void updateGeckoInfo(@BridgeContext IBridgeContext r100, @BridgeParam("access_key") String r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return;
    L7:
        ak7.c r102 = ak7.c.f4079b;
        r102.f0(r101);
        ak7.b r103 = r102.b0();
        if (r103 == null) goto L11;
        TextUtils.isEmpty(r103.a());
    L11:
        throw null;
    }
}
