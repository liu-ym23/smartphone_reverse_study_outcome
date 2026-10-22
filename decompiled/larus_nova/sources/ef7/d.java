package ef7;

import android.app.Activity;
import com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.websocket.utils.SocketManager;
import com.bytedance.sdk.xbridge.cn.websocket.utils.g;
import com.bytedance.sdk.xbridge.cn.websocket.utils.h;
import com.bytedance.sdk.xbridge.cn.websocket.utils.i;
import com.bytedance.sdk.xbridge.cn.websocket.utils.j;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.connectSocket")
public final class d extends df7.b {
    public d() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        df7.b.InterfaceC5664b r113 = (df7.b.InterfaceC5664b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r113, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Activity r100 = r110.getOwnerActivity();
        if (r100 != null) goto L5;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "Context not provided in host", null, 4, null);
        return;
    L5:
        String r101 = r110.getContainerID();
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "ContainerID not provided in host", null, 4, null);
        return;
    L14:
        ue7.d r114 = r110.getJsEventDelegate();
        int r103 = com.bytedance.sdk.xbridge.cn.websocket.utils.d.f270276a;
        String r104 = r113.getUrl();
        Map<String, Object> r105 = r113.getHeader();
        Unit r106 = null;
        if (r105 == null) goto L17;
        JSONObject r107 = ne7.a.c(r105);
    L18:
        List<String> r115 = r113.getProtocols();
        if (r115 == null) goto L21;
        JSONArray r116 = ne7.a.b(r115);
    L22:
        g r108 = new g(r104, r107, r116);
        c r117 = new c(r114);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "containerID");
        Intrinsics.checkNotNullParameter(r108, "requestTask");
        Intrinsics.checkNotNullParameter(r117, "callback");
        SocketManager r118 = SocketManager.f270265b.getValue();
        r118.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "containerID");
        Intrinsics.checkNotNullParameter(r108, "requestTask");
        Intrinsics.checkNotNullParameter(r117, "callback");
        int r109 = h.f270285g;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r108, "requestTask");
        h r119 = new h(r100, r108);
        IWsClient r120 = j.b(new i(r119));     // Catch: Throwable -> L27
        if (r120 == null) goto L28;
        com.bytedance.sdk.xbridge.cn.websocket.utils.b r121 = new com.bytedance.sdk.xbridge.cn.websocket.utils.b(r120);
    L29:
        if (r121 == null) goto L31;
        r119.f270286f = r121;
        Unit r122 = Unit.INSTANCE;
    L32:
        if (r122 != null) goto L34;
        r119 = null;
    L34:
        if (r119 == null) goto L48;
        String r123 = UUID.randomUUID().toString();
        r119.f(new SocketManager.b(r118, r101, r123, r117));
        HashMap<String, HashMap<String, ? super com.bytedance.sdk.xbridge.cn.websocket.utils.c>> r124 = SocketManager.f270264a;
        monitor-enter(r124);
    L45:
        th = move-exception;
        throw th;
    L38:
        if (r124.containsKey(r101) == false) goto L42;
        HashMap<String, ? super com.bytedance.sdk.xbridge.cn.websocket.utils.c> r125 = r124.get(r101);     // Catch: Throwable -> L45
        if (r125 == null) goto L43;
        r125.put(r123, r119);     // Catch: Throwable -> L45
    L43:
        monitor-exit(r124);
        r119.g();
    L49:
        if (r123 == null) goto L51;
        XBaseModel r126 = ne7.e.c(Reflection.getOrCreateKotlinClass(df7.b.c.class));
        ((df7.b.c) r126).setSocketTaskID(r123);
        CompletionBlock.DefaultImpls.onSuccess$default(r112, (XBaseResultModel) r126, null, 2, null);
        r106 = Unit.INSTANCE;
    L51:
        if (r106 != null) goto L59;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "can not get the socketTaskID", null, 4, null);
        return;
    L59:
        return;
    L42:
        HashMap<String, ? super com.bytedance.sdk.xbridge.cn.websocket.utils.c> r127 = new HashMap();     // Catch: Throwable -> L45
        r127.put(r123, r119);     // Catch: Throwable -> L45
        Unit r128 = Unit.INSTANCE;     // Catch: Throwable -> L45
        r124.put(r101, r127);     // Catch: Throwable -> L45
        goto L43
    L48:
        r123 = null;
        goto L49
    L31:
        r122 = null;
    L28:
        r121 = null;
        goto L29
    L21:
        r116 = null;
        goto L22
    L17:
        r107 = null;
        goto L18
    L8:
        if (r101.length() == 0) goto L11;
        r102 = false;
        goto L12
    }
}
