package com.bytedance.locallife.bridge.groupon.method;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes21.dex */
@XBridgeMethod(name = "atomicTask.changeUIComponentState", owner = "liuzhen.koi")
public final class b extends qo6.a {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r210) {
        qo6.a.InterfaceC7373a r100 = (qo6.a.InterfaceC7373a) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r210, "callback");
        com.bytedance.locallife.bridge.groupon.method.a r101 = new com.bytedance.locallife.bridge.groupon.method.a(r100, r210);
        int r102 = com.bytedance.locallife.groupon.basic.utils.c.f258790a;
        wq6.a r103 = (wq6.a) com.bytedance.locallife.groupon.basic.utils.c.a(wq6.a.class);
        if (r103 == null) goto L7;
        boolean r104 = true;
        if (r103.c() != true) goto L7;
    L8:
        if (r104 == false) goto L41;
        String r105 = r101.f257097h;
        Pair r106 = null;
        switch(r105.hashCode()) {
            case -1326163038: goto L34;
            case -1325835939: goto L27;
            case -126454260: goto L20;
            case 1303241389: goto L13;
            default: goto L40;
        };
    L40:
        CompletionBlock.DefaultImpls.onFailure$default(r101.f257090a, 0, "action error", null, 4, null);
        return;
    L13:
        if (r105.equals("request_show") == false) goto L40;
        wq6.a r107 = (wq6.a) com.bytedance.locallife.groupon.basic.utils.c.a(wq6.a.class);
        if (r107 == null) goto L18;
        r106 = r107.n();
    L18:
        r101.a(r106, r101.f257090a, r101.f257092c, r101.f257093d, r101.f257095f, r101.f257101l);
        return;
    L20:
        if (r105.equals("can_show") == false) goto L40;
        wq6.a r108 = (wq6.a) com.bytedance.locallife.groupon.basic.utils.c.a(wq6.a.class);
        if (r108 == null) goto L25;
        r106 = r108.n();
    L25:
        r101.a(r106, r101.f257090a, r101.f257092c, r101.f257093d, r101.f257095f, r101.f257101l);
        return;
    L27:
        if (r105.equals("on_show") == false) goto L40;
        wq6.a r109 = (wq6.a) com.bytedance.locallife.groupon.basic.utils.c.a(wq6.a.class);
        if (r109 == null) goto L32;
        r109.n();
    L32:
        CompletionBlock.DefaultImpls.onSuccess$default(r101.f257090a, (XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(qo6.a.b.class)), null, 2, null);
        return;
    L34:
        if (r105.equals("on_hide") == false) goto L40;
        wq6.a r112 = (wq6.a) com.bytedance.locallife.groupon.basic.utils.c.a(wq6.a.class);
        if (r112 == null) goto L39;
        r112.n();
    L39:
        CompletionBlock.DefaultImpls.onSuccess$default(r101.f257090a, (XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(qo6.a.b.class)), null, 2, null);
        return;
    L41:
        CompletionBlock.DefaultImpls.onFailure$default(r101.f257090a, 0, r101.f257094e + " atomicTaskManager is null", null, 4, null);
        return;
    L7:
        r104 = false;
        goto L8
    }
}
