package j26;

import com.bytedance.ies.bullet.prefetchv2.a0;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ne7.e;

/* JADX INFO: loaded from: classes19.dex */
@XBridgeMethod(biz = "bullet", name = "bullet.prefetchV2", owner = "yujingbo.luke")
public final class c extends a {
    public c() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        a.InterfaceC6383a r103 = (a.InterfaceC6383a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        a0 r104 = a0.f247513a;
        b r105 = new b(r103);
        Intrinsics.checkNotNullParameter(r105, "runnable");
        a0.f247515c.execute(r105);
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) e.c(Reflection.getOrCreateKotlinClass(a.b.class)), null, 2, null);
    }
}
