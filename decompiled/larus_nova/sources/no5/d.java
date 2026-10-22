package no5;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f519943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f519944b;

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f519943a;
    }

    public d(c r100) {
        this.f519944b = r100;
        this.f519943a = "ccm.closePage";
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r100, XBridgeMethod.Callback r101, XBridgePlatformType r102) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "type");
        Runnable r103 = this.f519944b.f519918f;
        if (r103 == null) goto L5;
        r103.run();
    L5:
        onSuccess(r101, new LinkedHashMap(), "");
    }
}
