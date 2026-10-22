package de7;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import id7.e;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.getAPIParams")
public final class c extends a {
    public c() {
        ConcurrentHashMap<Class<? extends IDLXBridgeMethod>, id7.b> r100 = e.f489350a;
        e.a(c.class, new id7.b(a.b.class, a.c.class));
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((a.b) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        XBaseModel r103 = ne7.e.c(Reflection.getOrCreateKotlinClass(a.c.class));
        a.c r104 = (a.c) r103;
        XBaseRuntime.f270095a.getClass();
        IHostNetworkDepend r105 = XBaseRuntime.f270104j;
        if (r105 == null) goto L6;
        Map<String, Object> r106 = r105.getAPIParams();
        if (r106 == null) goto L6;
    L7:
        r104.setApiParams(r106);
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) r103, null, 2, null);
        return;
    L6:
        r106 = new LinkedHashMap();
        goto L7
    }
}
