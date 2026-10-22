package com.bytedance.locallife.bridge.groupon.method;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@XBridgeMethod(name = "refreshNearbyCommonDialog", owner = "zhoujia.ethan")
public final class w extends qo6.q {
    public w() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v4, types: [org.json.JSONArray] */
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        qo6.q.b r100 = (qo6.q.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Object r101 = r100.getRefreshScene();
        Object r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        int r103 = r100.getRefreshAction().intValue();
        Number r104 = r100.getRefreshPageType();
        boolean r105 = false;
        if (r104 == null) goto L8;
        int r106 = r104.intValue();
    L9:
        List<Number> r107 = r100.getRefreshResourceType();
        if (r107 == null) goto L15;
        List<Number> r108 = r107;
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator<T> r109 = r108.iterator();
    L13:
        if (r109.hasNext() == false) goto L16;
        r113.add(Integer.valueOf(((Number) r109.next()).intValue()));
    L16:
        r100.getExtraRequestParam();
        Object r114 = r110.getBridgeCall().d();
        Boolean r115 = r100.getFeedPartlyRefresh();
        if (r115 == null) goto L45;
        r115.booleanValue();
    L45:
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L29
        int r117 = com.bytedance.locallife.biz.mob.a.f256703c;     // Catch: Throwable -> L29
        JSONObject r118 = new JSONObject();     // Catch: Throwable -> L29
        r118.put("name", "refreshNearbyCommonDialog");     // Catch: Throwable -> L29
        r118.put("url", r114);     // Catch: Throwable -> L29
        JSONObject r119 = new JSONObject();     // Catch: Throwable -> L29
        r119.put("refresh_page_type", r106);     // Catch: Throwable -> L29
        if (r113 == null) goto L27;
        Intrinsics.checkNotNullParameter(r113, "<this>");     // Catch: Throwable -> L29
        r102 = new JSONArray();     // Catch: Throwable -> L29
        Iterator r120 = r113.iterator();     // Catch: Throwable -> L29
    L25:
        if (r120.hasNext() == false) goto L27;
        r102.put(r120.next());     // Catch: Throwable -> L29
    L27:
        r119.put("refresh_resource_type", r102);     // Catch: Throwable -> L29
        r119.put("refresh_action", r103);     // Catch: Throwable -> L29
        r119.put("refresh_scene", r101);     // Catch: Throwable -> L29
        Unit r121 = Unit.INSTANCE;     // Catch: Throwable -> L29
        r118.put("extra", r119);     // Catch: Throwable -> L29
        com.bytedance.locallife.biz.mob.a.C3646a.d("nearby_jsb_call_monitor", r118);     // Catch: Throwable -> L29
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L29
    L31:
        if (r106 >= 0) goto L33;
        CompletionBlock.DefaultImpls.onFailure$default(r112, -100, null, null, 6, null);
        return;
    L33:
        int r122 = com.bytedance.locallife.groupon.basic.utils.c.f258790a;
        wq6.a r123 = (wq6.a) com.bytedance.locallife.groupon.basic.utils.c.a(wq6.a.class);
        if (r123 != null) goto L36;
    L38:
        if (r105 == true) goto L40;
        CompletionBlock.DefaultImpls.onFailure$default(r112, -101, null, null, 6, null);
        return;
    L40:
        wq6.a r124 = (wq6.a) com.bytedance.locallife.groupon.basic.utils.c.a(wq6.a.class);
        if (r124 == null) goto L43;
        r124.m();
    L43:
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) ne7.e.b(qo6.q.c.class), null, 2, null);
        return;
    L36:
        if (r123.b() != true) goto L38;
        r105 = true;
    L29:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L31
    L15:
        r113 = null;
        goto L16
    L8:
        r106 = 0;
        goto L9
    }
}
