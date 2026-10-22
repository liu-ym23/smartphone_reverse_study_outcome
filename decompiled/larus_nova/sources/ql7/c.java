package ql7;

import com.bytedance.sdk.bridge.annotation.BridgeContext;
import com.bytedance.sdk.bridge.annotation.BridgeMethod;
import com.bytedance.sdk.bridge.annotation.BridgeParam;
import com.bytedance.sdk.bridge.model.IBridgeContext;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @BridgeMethod("luckycatStartVibrate")
    public final void startVibrate(@BridgeContext IBridgeContext r100, @BridgeParam("duration") long r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (com.bytedance.ug.sdk.luckydog.base.container.d.a.f271729a.a(r101) == false) goto L6;
        r100.callback(pk7.a.a(1, null, "success"));
        return;
    L6:
        r100.callback(pk7.a.a(0, null, "failed"));
    }
}
