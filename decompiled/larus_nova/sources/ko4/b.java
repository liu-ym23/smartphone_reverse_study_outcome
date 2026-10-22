package ko4;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends io4.a {
    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return "bitable.closePage";
    }

    public b() {
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, XBridgeMethod.Callback r101, XBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        e r103 = (e) getBridgeService(e.class);
        if (r103 == null) goto L5;
        r103.closePage();
    L5:
        XCoreBridgeMethod.onSuccess$default(this, r101, new LinkedHashMap(), null, 4, null);
    }
}
