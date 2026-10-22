package com.bytedance.salamander.bridge;

import com.bytedance.salamander.anniex.b4;
import com.bytedance.salamander.anniex.c4;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.lynx.react.bridge.JavaOnlyMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes20.dex */
public final class l implements CompletionBlock<com.bytedance.sdk.xbridge.cn.network.a.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<b4, Unit> f268562a;

    /* JADX WARN: Multi-variable type inference failed */
    public l(Function1<? super b4, Unit> r100) {
        this.f268562a = r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock
    public final /* bridge */ /* synthetic */ void onRawSuccess(XBaseResultModel r100) {
        com.bytedance.sdk.xbridge.cn.network.a.c r101 = (com.bytedance.sdk.xbridge.cn.network.a.c) r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock
    public final void onSuccess(XBaseResultModel r110, String r111) {
        com.bytedance.sdk.xbridge.cn.network.a.c r112 = (com.bytedance.sdk.xbridge.cn.network.a.c) r110;
        Intrinsics.checkNotNullParameter(r112, "result");
        Intrinsics.checkNotNullParameter(r111, "msg");
        Map<String, Object> r113 = r112.convert();
        if (r113 != null) goto L5;
        r113 = new LinkedHashMap();
    L5:
        JavaOnlyMap r114 = com.bytedance.salamander.bridge.common.c.d(r113);
        Object r100 = r114.get("response");
        String r101 = null;
        if ((r100 instanceof Map) == false) goto L8;
        Map r102 = (Map) r100;
    L10:
        if (r102 == null) goto L12;
        r114.put("responseString", new JSONObject(r102).toString());
    L12:
        Function1<b4, Unit> r103 = this.f268562a;
        Object r104 = r114.get("msg");
        if ((r104 instanceof String) == false) goto L15;
        String r105 = (String) r104;
    L16:
        if (r105 != null) goto L18;
        r105 = "";
    L18:
        Object r106 = r114.get("httpCode");
        if ((r106 instanceof Integer) == false) goto L21;
        Integer r107 = (Integer) r106;
    L21:
        Object r108 = r114.get("clientCode");
        if ((r108 instanceof Integer) == false) goto L24;
        Integer r109 = (Integer) r108;
    L24:
        Object r115 = r114.get("header");
        if (r115 != null) goto L27;
        r115 = null;
    L27:
        Object r116 = r114.get("response");
        if (r116 != null) goto L30;
        r116 = null;
    L30:
        Object r117 = r114.get("rawResponse");
        if ((r117 instanceof String) == false) goto L33;
        String r118 = (String) r117;
    L34:
        Object r119 = r114.get("prefetchStatus");
        if ((r119 instanceof Integer) == false) goto L37;
        Integer r120 = (Integer) r119;
    L37:
        Object r121 = r114.get("responseType");
        if ((r121 instanceof Integer) == false) goto L40;
        Integer r122 = (Integer) r121;
    L40:
        Object r123 = r114.get("responseString");
        if ((r123 instanceof String) == false) goto L43;
        r101 = (String) r123;
    L43:
        r103.invoke(new b4(1, r105, new c4(r115, r116, r118, r101)));
        return;
    L33:
        r118 = null;
        goto L34
    L15:
        r105 = null;
        goto L16
    L8:
        r102 = null;
        goto L10
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock
    public final void onFailure(int r100, String r101, XBaseResultModel r102) {
        com.bytedance.sdk.xbridge.cn.network.a.c r103 = (com.bytedance.sdk.xbridge.cn.network.a.c) r102;
        Intrinsics.checkNotNullParameter(r101, "msg");
        this.f268562a.invoke(new b4(0, r101, null));
    }
}
