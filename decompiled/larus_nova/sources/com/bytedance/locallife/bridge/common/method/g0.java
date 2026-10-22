package com.bytedance.locallife.bridge.common.method;

import android.app.Activity;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.dito.utils.DitoExtKt;
import com.bytedance.locallife.host.share.ImExtraParams;
import com.bytedance.locallife.host.share.QrCodeShareInfo;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@XBridgeMethod(name = "poiGoodsShare")
public final class g0 extends ko6.z {

    public static final class a {
    }

    static {
    }

    public g0() {
    }

    public static String b(ko6.z.b r100) {
        Object r101 = r100.getImExtra().get("groupbuy_track_params");
        if (r101 != null) goto L6;
        r101 = SliceInitService.DEFAULT_SWITCH;
    L6:
        return DitoExtKt.g(r101).optString("product_id");
    }

    public static final void a(g0 r100, ko6.z.c r101) {
        r100.getClass();
        r101.setCode(0);
        r101.setButton("");
        ko6.z.d r102 = (ko6.z.d) ne7.e.b(ko6.z.d.class);
        r102.setMsg("cancel");
        r101.setData(r102);
    }

    public static Object c(Map r100, Class r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        Gson r103 = HostServiceUtilsKt.q0().o();     // Catch: Throwable -> L9
        if (r103 == null) goto L6;
        Object r104 = r103.fromJson(new JSONObject(r100).toString(), r101);     // Catch: Throwable -> L9
    L7:
        Object r105 = Result.m9449constructorimpl(r104);     // Catch: Throwable -> L9
    L12:
        if (Result.m9455isFailureimpl(r105) == false) goto L15;
        return null;
    L15:
        return r105;
    L6:
        r104 = null;
    L9:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r210, XBaseParamModel r211, CompletionBlock r310) {
        ko6.z.b r100 = (ko6.z.b) r211;
        Intrinsics.checkNotNullParameter(r210, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r310, "callback");
        r210.getOwnerActivity();
        Activity r101 = r210.getOwnerActivity();
        if (r101 == null) goto L49;
        String r102 = r100.getTraceSessionId();
        JSONObject r103 = HostServiceUtilsKt.f0().a(r102);
        String r110 = new JSONObject(r100.getCommandShareParams()).toString();
        ImExtraParams r111 = (ImExtraParams) c(r100.getImExtra(), ImExtraParams.class);
        LinkedHashMap r104 = new LinkedHashMap();
        String r105 = b(r100);
        String r106 = null;
        if (r103 == null) goto L8;
        String r112 = r103.optString("enterprise_tab_extra");
    L10:
        if (com.bytedance.locallife.common.utils.j.a(r105) == false) goto L13;
        r104.put("activity_id", r105);
    L13:
        if (r112 != null) goto L15;
    L18:
        boolean r113 = true;
    L19:
        if (r113 == true) goto L21;
        r104.put("enterprise_tab_extra", r112);
    L21:
        List<String> r107 = com.bytedance.locallife.common.utils.i.f257150a;
        String r212 = com.bytedance.locallife.common.utils.i.a(r100.getUrl(), r104);
        com.bytedance.locallife.host.share.v r114 = new com.bytedance.locallife.host.share.v(r100.getImage(), com.bytedance.locallife.common.utils.i.a(r100.getInnerUrl(), r104), CollectionsKt.listOf("qzone"), CollectionsKt.listOf("copylink"), r100.getTitle(), r212, "share_native", r100.getDesc(), CollectionsKt.listOf(new com.bytedance.locallife.host.share.u[]{new com.bytedance.locallife.host.share.u("chat_merge", 1), new com.bytedance.locallife.host.share.u("weixin_moments", 5), new com.bytedance.locallife.host.share.u("weixin", 5), new com.bytedance.locallife.host.share.u("qq", 5), new com.bytedance.locallife.host.share.u("weibo", 5)}));
        QrCodeShareInfo r115 = (QrCodeShareInfo) c(r100.getQrcodeShareInfo(), QrCodeShareInfo.class);
        String r108 = r100.getAweType();
        if (r108 != null) goto L24;
        r108 = "2604";
    L24:
        com.bytedance.locallife.host.share.w r109 = new com.bytedance.locallife.host.share.w(r114, r115, r108, r100.getReportUrl(), r110, r111, new h0(this, r310));
        if (r103 == null) goto L40;
        Map<String, Object> r116 = com.bytedance.locallife.common.utils.f.f(r103);
        String r117 = r103.optString("product_id");
        if (com.bytedance.locallife.common.utils.j.a(r117) == false) goto L29;
        r106 = r117;
    L29:
        if (r106 != null) goto L31;
        r106 = b(r100);
    L31:
        r116.put("product_id", r106);
        LinkedHashMap r118 = new LinkedHashMap(MapsKt.mapCapacity(r116.size()));
        Iterator r119 = ((LinkedHashMap) r116).entrySet().iterator();
    L33:
        if (r119.hasNext() == false) goto L39;
        Map.Entry r120 = (Map.Entry) r119.next();
        Object r121 = r120.getKey();
        Object r122 = r120.getValue();
        if ((r122 instanceof String) == false) goto L37;
        String r123 = (String) r122;
    L38:
        r118.put(r121, r123);
        goto L33
    L37:
        r123 = com.bytedance.locallife.common.utils.f.b(r122);
        goto L38
    L39:
        LinkedHashMap r124 = r118;
    L41:
        String r125 = b(r100);
        Map<String, Object> r126 = r100.getExtraData();
        if (r126 != null) goto L44;
        r126 = MapsKt.emptyMap();
    L44:
        HostServiceUtilsKt.h0().k(r101, r109, r124, r125, r102, new JSONObject(MapsKt.plus(r126, MapsKt.mapOf(TuplesKt.to("share_type", 2)))), r100.getCarryParams());
        return;
    L40:
        r124 = new LinkedHashMap();
        goto L41
    L15:
        if (r112.length() == 0) goto L18;
        r113 = false;
        goto L19
    L8:
        r112 = null;
        goto L10
    }
}
