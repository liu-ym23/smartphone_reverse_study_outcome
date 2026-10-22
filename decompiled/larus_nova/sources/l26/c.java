package l26;

import com.bytedance.ies.bullet.preloadv2.PreloadV2;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ne7.e;

/* JADX INFO: loaded from: classes19.dex */
@XBridgeMethod(name = "bullet.clearPreloadCache", owner = "liushaocong")
public final class c extends a {
    public c() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        a.InterfaceC6642a r103 = (a.InterfaceC6642a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Boolean r104 = r103.getHighPriority();
        if (r104 == null) goto L5;
        boolean r105 = r104.booleanValue();
    L6:
        boolean r106 = PreloadV2.f247628a;
        PreloadV2.e(r105, "bullet.clearPreloadCache");
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) e.c(Reflection.getOrCreateKotlinClass(a.b.class)), null, 2, null);
        return;
    L5:
        r105 = false;
        goto L6
    }
}
