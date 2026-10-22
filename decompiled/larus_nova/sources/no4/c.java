package no4;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class c extends io4.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f519906b;

    public c() {
        this.f519906b = "bitable.showLoading";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f519906b;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, XBridgeMethod.Callback r101, XBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        d r103 = (d) getBridgeService(d.class);
        if (r103 == null) goto L5;
        r103.showLoading();
    L5:
        XCoreBridgeMethod.onSuccess$default(this, r101, new LinkedHashMap(), null, 4, null);
    }
}
