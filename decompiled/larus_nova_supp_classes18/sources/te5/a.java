package te5;

import com.bytedance.ee.bear.lynx.api.g;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends XCoreBridgeMethod {
    public final String a;

    public a() {
        this.a = "ccm.executeJSBridgeCallback";
    }

    public final String getName() {
        return this.a;
    }

    public final void handle(XReadableMap r3, XBridgeMethod.Callback r4, XBridgePlatformType r5) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_TYPE);
        g r6 = (g) provideContext(g.class);
        if (r6 == null) goto L6;
        r6.a(r3.getString("bridgeName"), r3.getString("params"));
        return;
    }
}
