package ee7;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostOpenDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.scanCode")
public final class g extends b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f472305d;

    public g() {
        this.f472305d = "x.scanCode";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        b.InterfaceC5773b r103 = (b.InterfaceC5773b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        boolean r104 = r103.getCameraOnly();
        Boolean r105 = r103.getAutoJump();
        String r106 = this.f472305d;
        StringBuilder r107 = new StringBuilder("cameraOnly:");
        r107.append(Boolean.valueOf(r104));
        r107.append("|autoJump:");
        if (r105 != null) goto L5;
        Object r108 = "null";
    L6:
        r107.append(r108);
        com.bytedance.sdk.xbridge.cn.utils.i.b(r106, r107.toString(), "BridgeParam", r100.getContainerID());
        int r109 = com.bytedance.sdk.xbridge.cn.utils.g.f270260a;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        XBaseRuntime.f270095a.getClass();
        IHostOpenDepend r110 = XBaseRuntime.f270099e;
        if (r110 == null) goto L9;
        r110.scanCode(r100, r104, r105, new f(r102, r100));
        Unit r111 = Unit.INSTANCE;
    L10:
        if (r111 != null) goto L13;
        CompletionBlock.DefaultImpls.onFailure$default(r102, 0, "openDepend not implemented in host", null, 4, null);
        return;
    L13:
        return;
    L9:
        r111 = null;
        goto L10
    L5:
        r108 = r105;
        goto L6
    }
}
