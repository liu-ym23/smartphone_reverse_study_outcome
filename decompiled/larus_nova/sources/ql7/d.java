package ql7;

import com.bytedance.sdk.bridge.annotation.BridgeContext;
import com.bytedance.sdk.bridge.annotation.BridgeMethod;
import com.bytedance.sdk.bridge.model.IBridgeContext;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    public static final class a {
    }

    static {
    }

    public d() {
    }

    @BridgeMethod("luckycatStopVibrate")
    public final void stopVibrate(@BridgeContext IBridgeContext r100) {
        if (r100 == null) goto L5;
        com.bytedance.ug.sdk.luckydog.base.container.d.a.f271729a.b();
        r100.callback(pk7.a.a(1, null, "success"));
        return;
    }
}
