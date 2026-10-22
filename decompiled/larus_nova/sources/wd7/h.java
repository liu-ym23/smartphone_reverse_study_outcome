package wd7;

import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostLogDependV2;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.reportAppLog")
public final class h extends c {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return true;
    }

    public h() {
    }

    public static void a(IBDXBridgeContext r100, c.b r101, CompletionBlock r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r103 = r101.getEventName();     // Catch: NullPointerException -> L38
        if (r103 != null) goto L6;
    L9:
        boolean r104 = true;
    L10:
        if (r104 == false) goto L13;
        CompletionBlock.DefaultImpls.onFailure$default(r102, -3, null, null, 6, null);     // Catch: NullPointerException -> L38
        return;
    L13:
        String r105 = r101.getEventName();
        Map<String, Object> r106 = r101.getParams();
        LinkedHashMap r107 = new LinkedHashMap();
        if (r106 == null) goto L30;
        Iterator<Map.Entry<String, Object>> r108 = r106.entrySet().iterator();
        if (r108 == null) goto L30;
    L18:
        if (r108.hasNext() == false) goto L30;
        String r109 = r108.next().getKey();
        Object r110 = r106.get(r109);
        if (r110 != null) goto L23;
        String r111 = "";
    L29:
        String r112 = (String) r107.put(r109, r111);
        goto L18
    L23:
        if ((r110 instanceof Map) == false) goto L26;
        r111 = new JSONObject((Map) r110).toString();
        goto L29
    L26:
        if ((r110 instanceof List) == false) goto L28;
        r111 = new JSONArray((Collection) r110).toString();
        goto L29
    L28:
        r111 = r110.toString();
    L30:
        IHostLogDepend r113 = com.bytedance.sdk.xbridge.cn.utils.g.c(r100);
        if (r113 != null) goto L33;
    L36:
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(c.InterfaceC8096c.class)), null, 2, null);
        return;
    L33:
        if ((r113 instanceof IHostLogDependV2) == false) goto L35;
        ((IHostLogDependV2) r113).onEventV3Map(r105, r107, r100);
        goto L36
    L35:
        r113.onEventV3Map(r105, r107);
        goto L36
    L6:
        if (r103.length() == 0) goto L9;
        r104 = false;
    L38:
        CompletionBlock.DefaultImpls.onFailure$default(r102, -3, null, null, 6, null);
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final /* bridge */ /* synthetic */ void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        a(r100, (c.b) r101, r102);
    }
}
