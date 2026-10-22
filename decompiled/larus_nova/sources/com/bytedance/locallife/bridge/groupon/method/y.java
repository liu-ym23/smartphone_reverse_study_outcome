package com.bytedance.locallife.bridge.groupon.method;

import android.view.View;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@XBridgeMethod(name = "sendLifeMallLog", owner = "zhoujia.ethan")
public final class y extends qo6.r {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return true;
    }

    public y() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Map a(View r100, String r101) {
        if ((r100 instanceof ls6.a) == true) goto L5;
        Object r102 = r100.getParent();
        if ((r102 instanceof View) == false) goto L9;
        View r103 = (View) r102;
    L10:
        if (r103 != null) goto L12;
        return null;
    L12:
        return a(r103, r101);
    L9:
        r103 = null;
        goto L10
    L5:
        return ((ls6.a) r100).a();
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        qo6.r.b r113 = (qo6.r.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        LinkedHashMap r100 = new LinkedHashMap();
        Map<String, Object> r101 = r113.getParams();
        Integer r102 = (Integer) HostServiceUtilsKt.y().a("groupon_feed_lynx_mob_params_source_opt", Integer.TYPE, 0);
        if (r102 != null) goto L6;
    L12:
        String r103 = null;
    L13:
        View r104 = r110.getEngineView();
        if (r104 == null) goto L23;
        Map r105 = a(r104, r103);
        if (r105 == null) goto L23;
        Iterator r106 = r105.entrySet().iterator();
    L19:
        if (r106.hasNext() == false) goto L23;
        Map.Entry r107 = (Map.Entry) r106.next();
        String r108 = (String) r107.getValue();
        if (r108 == null) goto L19;
        r100.put(r107.getKey(), r108);
    L23:
        r100.putAll(r101);
        x r109 = new x(r113, r100);
        int r114 = mo6.b.f514593a;
        if (mo6.b.a(r109, r110.getEngineView(), null, true) == false) goto L26;
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) ne7.e.b(qo6.r.c.class), null, 2, null);
        return;
    L26:
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, null, null, 6, null);
        return;
    L6:
        if (r102.intValue() != 1) goto L12;
        if (r101.containsKey("outer_card_id") == false) goto L12;
        Object r115 = r101.get("outer_card_id");
        if ((r115 instanceof String) == false) goto L12;
        r103 = (String) r115;
        goto L13
    }
}
