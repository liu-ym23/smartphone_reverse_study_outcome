package wd7;

import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.framwork.core.monitor.MonitorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.reportMonitorLog")
public final class i extends d {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return true;
    }

    public i() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        d.b r113 = (d.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        boolean r100 = false;
        if (r113.getLogType().length() != 0) goto L6;
        boolean r114 = true;
    L7:
        if (r114 == true) goto L39;
        if (r113.getStatus() == null) goto L39;
        if (r113.getValue() == null) goto L39;
        String r115 = r113.getLogType();
        String r101 = r113.getService();
        if (r101 != null) goto L16;
        r101 = "";
    L16:
        Number r102 = r113.getStatus();
        if (r102 == null) goto L19;
        Integer r103 = Integer.valueOf(r102.intValue());
    L21:
        if (Intrinsics.areEqual(UploadTypeInf.SERVICE_MONITOR, r115) == true) goto L23;
    L28:
        JSONObject r104 = new JSONObject();
        r104.put("status", r103);
        r104.put("value", new JSONObject(r113.getValue()));
    L35:
        e = move-exception;
        e.printStackTrace();
    L37:
        MonitorUtils.monitorCommonLog(r115, r104);
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(d.c.class)), null, 2, null);
        return;
    L30:
        if (r101.length() <= 0) goto L32;
        r100 = true;
    L32:
        if (r100 == false) goto L37;
        r104.put("service", r101);     // Catch: JSONException -> L35
        goto L37
    L23:
        if (r101.length() != 0) goto L25;
        boolean r105 = true;
    L26:
        if (r105 == false) goto L28;
        CompletionBlock.DefaultImpls.onFailure$default(r112, -3, "service is required while log_type=" + r115, null, 4, null);
        return;
    L25:
        r105 = false;
        goto L26
    L19:
        r103 = null;
    L39:
        CompletionBlock.DefaultImpls.onFailure$default(r112, -3, null, null, 6, null);     // Catch: NullPointerException -> L41
        return;
    L6:
        r114 = false;
    L41:
        CompletionBlock.DefaultImpls.onFailure$default(r112, -3, null, null, 6, null);
    }
}
