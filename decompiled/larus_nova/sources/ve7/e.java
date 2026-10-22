package ve7;

import android.app.Activity;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.getStorageInfo")
public final class e extends a {
    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final boolean canRunInBackground() {
        return true;
    }

    public e() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter((a.b) r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Activity r103 = r100.getOwnerActivity();
        if (r103 != null) goto L5;
        CompletionBlock.DefaultImpls.onFailure$default(r102, 0, "Context not provided in host", null, 4, null);
        return;
    L5:
        Set<String> r104 = com.bytedance.sdk.xbridge.cn.storage.utils.d.a(r103).c();
        XBaseModel r105 = XBridgeResultModelArguments.INSTANCE.createModel(a.c.class);
        ((a.c) r105).setKeys(CollectionsKt.toList(r104));
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) r105, null, 2, null);
    }
}
