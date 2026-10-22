package uo6;

import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class e extends to6.e {
    public e() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        to6.e.b r103 = (to6.e.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r104 = r103.getSessionID();
        String r105 = r103.getCardKey();
        if ((!StringsKt.isBlank(r104)) == true) goto L5;
    L11:
        CompletionBlock.DefaultImpls.onFailure$default(r102, -1, "param is blank", null, 4, null);
        return;
    L5:
        if ((!StringsKt.isBlank(r105)) == false) goto L11;
        ConcurrentHashMap<String, WeakReference<eo6.b>> r106 = eo6.d.f473324a;
        Intrinsics.checkNotNullParameter(r105, "cardKey");
        Intrinsics.checkNotNullParameter(r104, "pluginKey");
        Intrinsics.checkNotNullParameter(r104, "key");
        WeakReference<eo6.b> r107 = eo6.d.f473324a.get(r104);
        if (r107 == null) goto L13;
        eo6.b r108 = r107.get();
        if (r108 == null) goto L14;
        r108.a(r105);
        return;
    L14:
        return;
    }
}
