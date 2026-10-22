package pk7;

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

    @BridgeMethod("luckycatSyncTokenToClipboard")
    public final void syncTokenToClipboard(@BridgeContext IBridgeContext r100) {
        if (r100 == null) goto L5;
        lm7.a.d();
        r100.callback(pk7.a.a(1, null, "success"));
        return;
    }
}
