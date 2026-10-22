package com.bytedance.locallife.bridge.common.method;

import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@XBridgeMethod(name = "localLife.getGoodsDetailMonitorInfo")
public final class e extends ko6.n {

    public static final class a {
    }

    static {
    }

    public e() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r110) {
        ko6.n.b r102 = (ko6.n.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        String r103 = r102.getIdentifier();
        ko6.n.c r104 = (ko6.n.c) ne7.e.b(ko6.n.c.class);
        ArrayDeque<String> r105 = xn6.a.f564631a;
        monitor-enter(xn6.a.class);
        Intrinsics.checkNotNullParameter(r103, "sessionId");     // Catch: Throwable -> L28
        if (com.bytedance.locallife.biz.experiment.g.a() == true) goto L9;
        monitor-exit(xn6.a.class);
        Map<String, ? extends Object> r106 = null;
    L11:
        if (r106 != null) goto L14;
        r106 = new HashMap();
    L14:
        r104.setOriginSessionInfo(r106);
        Map<String, ? extends Object> r107 = xn6.a.b(r103);
        if (r107 != null) goto L18;
        r107 = new HashMap();
    L18:
        r104.setOriginQueries(r107);
        Map<String, ? extends Object> r108 = HostServiceUtilsKt.f0().h(r103);
        if (r108 != null) goto L22;
        r108 = new HashMap();
    L22:
        r104.setSessionChangeHistory(r108);
        Map<String, ? extends Object> r109 = xn6.a.a(r103);
        if (r109 != null) goto L26;
        r109 = new HashMap();
    L26:
        r104.setGoodsDetailExtraInfo(r109);
        CompletionBlock.DefaultImpls.onSuccess$default(r110, r104, null, 2, null);
        return;
    L9:
        qs6.b r111 = HostServiceUtilsKt.k();     // Catch: Throwable -> L28
        StringBuilder r112 = new StringBuilder("***  getOriginSessionInfoById: ");     // Catch: Throwable -> L28
        HashMap<String, ConcurrentHashMap<String, Object>> r113 = xn6.a.f564632b;     // Catch: Throwable -> L28
        r112.append(r113.get(r103));     // Catch: Throwable -> L28
        r111.d("GoodsDetailMonitorInfoManager", r112.toString());     // Catch: Throwable -> L28
        r106 = (ConcurrentHashMap) r113.get(r103);     // Catch: Throwable -> L28
        monitor-exit(xn6.a.class);
    L28:
        th = move-exception;
        throw th;
    }
}
