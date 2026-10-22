package wd7;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDepend;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.reportADLog")
public final class f extends a {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return true;
    }

    public f() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        a.b r113 = (a.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        String r100 = r113.getLabel();
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L20;
        String r103 = r113.getTag();
        if (r103 != null) goto L13;
    L14:
        r101 = true;
    L15:
        if (r101 == true) goto L20;
        String r104 = r113.getLabel();
        String r105 = r113.getTag();
        r113.getRefer();
        r113.getGroupID();
        r113.getCreativeID();
        r113.getLogExtra();
        re7.g r106 = new re7.g(r104, r105, r113.getExtraParams());
        IHostLogDepend r114 = com.bytedance.sdk.xbridge.cn.utils.g.c(r110);
        if (r114 == null) goto L22;
        r114.handleReportADLog(r110, this.f559295a, r106, new e(r112));
        return;
    L22:
        return;
    L13:
        if (r103.length() != 0) goto L15;
    L20:
        CompletionBlock.DefaultImpls.onFailure$default(r112, -3, null, null, 6, null);
        return;
    L5:
        if (r100.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
