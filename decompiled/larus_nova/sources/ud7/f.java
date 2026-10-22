package ud7;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.getContainerID")
public final class f extends c {
    public f() {
        ConcurrentHashMap<Class<? extends IDLXBridgeMethod>, id7.b> r100 = id7.e.f489350a;
        id7.e.a(f.class, new id7.b(c.b.class, c.InterfaceC7866c.class));
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((c.b) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r103 = r100.getContainerID();
        XBaseModel r104 = ne7.e.c(Reflection.getOrCreateKotlinClass(c.InterfaceC7866c.class));
        ((c.InterfaceC7866c) r104).setContainerID(r103);
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) r104, null, 2, null);
    }
}
