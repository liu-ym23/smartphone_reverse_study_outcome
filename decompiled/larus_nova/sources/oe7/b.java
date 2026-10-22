package oe7;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.alipay.sdk.m.p.e;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostRouterDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import com.bytedance.sdk.xbridge.cn.utils.g;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.close")
public final class b extends pe7.a {
    public b() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        pe7.a.b r113 = (pe7.a.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        String r100 = r113.getContainerID();
        List<String> r101 = r113.getContainerIDs();
        boolean r114 = r113.getAnimated();
        String r102 = r110.getContainerID();
        com.bytedance.ies.bullet.base.utils.logger.a r103 = new com.bytedance.ies.bullet.base.utils.logger.a();
        r103.a("session_id", r102);
        HybridLogger r104 = HybridLogger.f246343a;
        Pair[] r105 = new Pair[5];
        r105[0] = TuplesKt.to(e.f25671s, this.f528718a);
        Object r106 = "null";
        if (r100 != null) goto L5;
        String r107 = "null";
    L6:
        r105[1] = TuplesKt.to("containerID", r107);
        if (r101 == null) goto L10;
        r106 = r101;
    L10:
        r105[2] = TuplesKt.to("containerIDs", r106);
        r105[3] = TuplesKt.to(GXTemplateKey.GAIAX_LAYER_PROGRESS_ANIMATED, Boolean.valueOf(r114));
        r105[4] = TuplesKt.to("curSession", r102);
        HybridLogger.k("BridgeParam", "x.closeParam", MapsKt.mapOf(r105), r103);
        if (r101 != null) goto L13;
    L21:
        int r108 = g.f270260a;
        XBaseRuntime.f270095a.getClass();
        IHostRouterDepend r109 = XBaseRuntime.f270102h;
        if (r109 == null) goto L24;
        Object r115 = Boolean.valueOf(r109.closeView(r110, r100, r114));
    L25:
        pe7.a.c r116 = (pe7.a.c) ne7.e.c(Reflection.getOrCreateKotlinClass(pe7.a.c.class));
        HybridLogger r117 = HybridLogger.f246343a;
        Pair[] r118 = new Pair[3];
        r118[0] = TuplesKt.to(e.f25671s, this.f528718a);
        if (r115 != null) goto L28;
        r115 = "unknown";
    L28:
        r118[1] = TuplesKt.to("closeSuccess", r115);
        r118[2] = TuplesKt.to("callback", String.valueOf(r116.convert()));
        HybridLogger.k("BridgeResult", "x.closeResult", MapsKt.mapOf(r118), r103);
        CompletionBlock.DefaultImpls.onSuccess$default(r112, r116, null, 2, null);
        return;
    L24:
        r115 = null;
        goto L25
    L13:
        if ((!r101.isEmpty()) == false) goto L21;
        Iterator<T> r119 = r101.iterator();
    L15:
        r115 = null;
    L17:
        if (r119.hasNext() == false) goto L25;
        String r120 = (String) r119.next();
        int r121 = g.f270260a;
        XBaseRuntime.f270095a.getClass();
        IHostRouterDepend r122 = XBaseRuntime.f270102h;
        if (r122 == null) goto L15;
        r115 = Boolean.valueOf(r122.closeView(r110, r120, r114));
        goto L17
    L5:
        r107 = r100;
        goto L6
    }
}
