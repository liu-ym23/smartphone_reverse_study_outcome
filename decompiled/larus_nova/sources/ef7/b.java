package ef7;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.closeSocket")
public final class b extends df7.a implements h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IBDXBridgeContext f472526d;

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
        IBDXBridgeContext r100 = this.f472526d;
        if (r100 == null) goto L5;
        String r101 = r100.getContainerID();
    L6:
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
        return;
    L14:
        com.bytedance.sdk.xbridge.cn.websocket.utils.d.a(r101, null, null);
        return;
    L8:
        if (r101.length() == 0) goto L11;
        r102 = false;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    public b() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r110, CompletionBlock r111) {
        df7.a.b r112 = (df7.a.b) r110;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        ue7.d r101 = r100.getJsEventDelegate();
        this.f472526d = r100;
        String r102 = r112.getContainerID();
        if (r102 != null) goto L6;
        r102 = r100.getContainerID();
    L6:
        if (r102.length() != 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        CompletionBlock.DefaultImpls.onFailure$default(r111, 0, "ContainerID not provided in host", null, 4, null);
        return;
    L11:
        int r104 = com.bytedance.sdk.xbridge.cn.websocket.utils.d.f270276a;
        com.bytedance.sdk.xbridge.cn.websocket.utils.d.a(r102, r112.getSocketTaskID(), new a(r111, this, r101, r112));
        return;
    L8:
        r103 = false;
        goto L9
    }
}
