package uo6;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class d extends to6.d {
    public d() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        to6.d.b r103 = (to6.d.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r104 = r103.getSessionID();
        String r105 = r103.getCardKey();
        int r106 = r103.getCardPriority().intValue();
        if ((!StringsKt.isBlank(r104)) == true) goto L5;
    L11:
        CompletionBlock.DefaultImpls.onFailure$default(r102, -1, "param is blank", null, 4, null);
        return;
    L5:
        if ((!StringsKt.isBlank(r105)) == false) goto L11;
        if (r106 <= 0) goto L11;
        ConcurrentHashMap<String, WeakReference<eo6.b>> r107 = eo6.d.f473324a;
        if (eo6.d.a(new eo6.a(r105, r106), r104) == false) goto L10;
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) ne7.e.b(to6.d.c.class), null, 2, null);
        return;
    L10:
        CompletionBlock.DefaultImpls.onFailure$default(r102, -1, "register fail", null, 4, null);
    }
}
