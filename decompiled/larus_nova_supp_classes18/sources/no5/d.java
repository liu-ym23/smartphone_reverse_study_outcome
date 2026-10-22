package no5;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends XCoreBridgeMethod {
    public final String a;
    public final /* synthetic */ c b;

    public final String getName() {
        return this.a;
    }

    public d(c r1) {
        this.b = r1;
        this.a = "ccm.closePage";
    }

    public final void handle(XReadableMap r2, XBridgeMethod.Callback r3, XBridgePlatformType r4) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "callback");
        Intrinsics.checkNotNullParameter(r4, ResourceData.KEY_TYPE);
        Runnable r5 = this.b.f;
        if (r5 == null) goto L5;
        r5.run();
    L5:
        onSuccess(r3, new LinkedHashMap(), "");
    }
}
