package jd7;

import android.app.Activity;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostUserDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.logout")
public final class h extends c {
    public h() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        c.b r103 = (c.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Activity r104 = r100.getOwnerActivity();
        if (r104 != null) goto L5;
        CompletionBlock.DefaultImpls.onFailure$default(r102, 0, "context can not convert to activity", null, 4, null);
        return;
    L5:
        int r105 = com.bytedance.sdk.xbridge.cn.utils.g.f270260a;
        XBaseRuntime.f270095a.getClass();
        IHostUserDepend r106 = XBaseRuntime.f270103i;
        if (r106 == null) goto L14;
        LinkedHashMap r107 = new LinkedHashMap();
        Map<String, Object> r108 = r103.getContext();
        if (r108 == null) goto L13;
        Iterator<Map.Entry<String, Object>> r109 = r108.entrySet().iterator();
    L11:
        if (r109.hasNext() == false) goto L13;
        String r110 = r109.next().getKey();
        r107.put(r110, String.valueOf(r108.get(r110)));
    L13:
        r106.logout(r104, new g(r102), r107);
        Unit r111 = Unit.INSTANCE;
    L15:
        if (r111 != null) goto L20;
        CompletionBlock.DefaultImpls.onFailure$default(r102, 0, "hostUserDepend is null", null, 4, null);
        return;
    L20:
        return;
    L14:
        r111 = null;
        goto L15
    }
}
