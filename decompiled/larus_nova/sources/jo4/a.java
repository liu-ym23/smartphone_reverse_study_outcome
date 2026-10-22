package jo4;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a extends io4.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f499896b;

    public a() {
        this.f499896b = "bitable.app.closeAppDrawer";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f499896b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, XBridgeMethod.Callback r101, XBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        com.bytedance.ee.bear.bitable.app.a r103 = (com.bytedance.ee.bear.bitable.app.a) getBridgeService(com.bytedance.ee.bear.bitable.app.a.class);
        if (r103 == null) goto L5;
        r103.y();
    L5:
        XCoreBridgeMethod.onSuccess$default(this, r101, new LinkedHashMap(), null, 4, null);
    }
}
