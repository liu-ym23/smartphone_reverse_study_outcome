package po6;

import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.biz.common.utils.b;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import ne7.e;

/* JADX INFO: loaded from: classes21.dex */
@XBridgeMethod(name = "localLife.saasCrossBroadcast")
public final class a extends oo6.a {
    public a() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r100, XBaseParamModel r101, CompletionBlock r102) {
        oo6.a.b r103 = (oo6.a.b) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        String r104 = r103.getEventName();
        String r105 = r103.getData().getMsgId();
        Map<String, Object> r106 = r103.getData().getContent();
        HostServiceUtilsKt.b0().a(r104, r105, b.c(r106));
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) e.b(oo6.a.c.class), null, 2, null);
    }
}
