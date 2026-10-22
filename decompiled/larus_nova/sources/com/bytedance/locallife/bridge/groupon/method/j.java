package com.bytedance.locallife.bridge.groupon.method;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes21.dex */
@XBridgeMethod(name = "launchAtomicTask", owner = "sirius.lin")
public final class j extends qo6.h {
    public j() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r110, CompletionBlock r111) {
        qo6.h.b r112 = (qo6.h.b) r110;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r112, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        r112.getEnterFrom();
        int r101 = com.bytedance.locallife.groupon.basic.utils.c.f258790a;
        wq6.a r102 = (wq6.a) com.bytedance.locallife.groupon.basic.utils.c.a(wq6.a.class);
        if (r102 == null) goto L7;
        r112.getEnterFrom();
        r112.getTaskConfig();
        if (r102.f() != true) goto L7;
        boolean r103 = true;
    L8:
        List<String> r104 = null;
        if (r103 == false) goto L12;
        XBaseModel r105 = ne7.e.c(Reflection.getOrCreateKotlinClass(qo6.h.c.class));
        ((qo6.h.c) r105).setCode(1);
        CompletionBlock.DefaultImpls.onSuccess$default(r111, (XBaseResultModel) r105, null, 2, null);
        return;
    L12:
        if (bs6.a.a().getGrouponAwemeService() == null) goto L14;
        String r106 = r112.getEnterFrom();
        String r107 = r112.getTaskConfig();
        Intrinsics.checkNotNullParameter(r106, "enterFrom");
        Intrinsics.checkNotNullParameter(r107, "taskConfig");
    L14:
        wq6.a r108 = (wq6.a) com.bytedance.locallife.groupon.basic.utils.c.a(wq6.a.class);
        if (r108 == null) goto L17;
        r104 = r108.o();
    L17:
        CompletionBlock.DefaultImpls.onFailure$default(r111, 0, "enterFrom: " + r112.getEnterFrom() + " AtomicTaskManager is null; instances: " + r104, null, 4, null);
        return;
    L7:
        r103 = false;
        goto L8
    }
}
