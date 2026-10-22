package ef7;

import android.app.Activity;
import android.util.Base64;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.websocket.utils.SocketManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.sendSocketData")
public final class f extends df7.c {
    public f() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        df7.c.b r100 = (df7.c.b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Activity r101 = r110.getOwnerActivity();
        if (r101 != null) goto L5;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "Context not provided in host", null, 4, null);
        return;
    L5:
        String r102 = r110.getContainerID();
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == false) goto L14;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "ContainerID not provided in host", null, 4, null);
        return;
    L14:
        String r104 = r100.getDataType();
        String r113 = null;
        if (Intrinsics.areEqual(r104, "string") == false) goto L18;
        Object r105 = r100.getData();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type kotlin.String");
        r113 = (String) r105;
        byte[] r106 = null;
    L21:
        int r107 = com.bytedance.sdk.xbridge.cn.websocket.utils.d.f270276a;
        String r108 = r100.getSocketTaskID();
        e r109 = new e(r110, r100);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "containerID");
        Intrinsics.checkNotNullParameter(r108, "socketTaskID");
        Intrinsics.checkNotNullParameter(r109, "callback");
        if (r113 != null) goto L24;
    L27:
        boolean r114 = true;
    L28:
        String r115 = "The socketTaskID doesn't exist";
        if (r114 == true) goto L38;
        SocketManager.f270265b.getValue().getClass();
        Intrinsics.checkNotNullParameter(r102, "containerID");
        Intrinsics.checkNotNullParameter(r108, "socketTaskID");
        Intrinsics.checkNotNullParameter(r113, "txt");
        List r116 = SocketManager.b(r102, r108);
        if (r116 == null) goto L36;
        com.bytedance.sdk.xbridge.cn.websocket.utils.c r117 = (com.bytedance.sdk.xbridge.cn.websocket.utils.c) ListProtector.get(r116, 0);
        if (r117 == null) goto L36;
        r115 = r117.b(r113);
    L36:
        if (r115 == null) goto L57;
        r109.a(r115);
        return;
    L57:
        return;
    L38:
        if (r106 != null) goto L40;
    L53:
        r109.a(IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN);
        return;
    L40:
        if (r106.length != 0) goto L42;
        boolean r118 = true;
    L44:
        if ((!r118) == false) goto L53;
        SocketManager.f270265b.getValue().getClass();
        Intrinsics.checkNotNullParameter(r102, "containerID");
        Intrinsics.checkNotNullParameter(r108, "socketTaskID");
        Intrinsics.checkNotNullParameter(r106, "byteData");
        List r119 = SocketManager.b(r102, r108);
        if (r119 == null) goto L51;
        com.bytedance.sdk.xbridge.cn.websocket.utils.c r120 = (com.bytedance.sdk.xbridge.cn.websocket.utils.c) ListProtector.get(r119, 0);
        if (r120 == null) goto L51;
        r115 = r120.sendMessage(r106);
    L51:
        if (r115 == null) goto L59;
        r109.a(r115);
        return;
    L59:
        return;
    L42:
        r118 = false;
        goto L44
    L24:
        if (r113.length() == 0) goto L27;
        r114 = false;
        goto L28
    L18:
        if (Intrinsics.areEqual(r104, TTVideoEngineInterface.PLAY_API_KEY_BASE64) == false) goto L20;
        Object r121 = r100.getData();
        Intrinsics.checkNotNull(r121, "null cannot be cast to non-null type kotlin.String");
        r106 = Base64.decode((String) r121, 0);
        goto L21
    L20:
        r106 = null;
        goto L21
    L8:
        if (r102.length() == 0) goto L11;
        r103 = false;
        goto L12
    }
}
