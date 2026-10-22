package uo6;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class b extends to6.a {
    public b() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r110) {
        to6.a.b r102 = (to6.a.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        String r103 = r102.getSessionID();
        if ((!StringsKt.isBlank(r103)) == false) goto L12;
        ConcurrentHashMap<String, WeakReference<eo6.b>> r104 = eo6.d.f473324a;
        Intrinsics.checkNotNullParameter(r103, "pluginKey");
        Intrinsics.checkNotNullParameter(r103, "key");
        WeakReference<eo6.b> r105 = eo6.d.f473324a.get(r103);
        if (r105 == null) goto L10;
        eo6.b r106 = r105.get();
        if (r106 == null) goto L10;
        String r107 = r106.d();
        if (r107 == null) goto L10;
    L11:
        XBaseModel r108 = ne7.e.b(to6.a.c.class);
        ((to6.a.c) r108).setCardKey(r107);
        CompletionBlock.DefaultImpls.onSuccess$default(r110, (XBaseResultModel) r108, null, 2, null);
        return;
    L10:
        r107 = "";
        goto L11
    L12:
        CompletionBlock.DefaultImpls.onFailure$default(r110, -1, "param is blank", null, 4, null);
    }
}
