package com.obric.miniapp.aibridge;

import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/miniapp/aibridge/DeleteIcsDataMethod;", "Lcom/obric/miniapp/aibridge/AbsDeleteIcsDataMethodIDL;", "<init>", "()V", "handle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/obric/miniapp/aibridge/AbsDeleteIcsDataMethodIDL$DeleteIcsDataParamModel;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/obric/miniapp/aibridge/AbsDeleteIcsDataMethodIDL$DeleteIcsDataResultModel;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DeleteIcsDataMethod extends AbsDeleteIcsDataMethodIDL {
    public DeleteIcsDataMethod() {
    }

    @Override // com.bytedance.ai.bridge.core.CoreAIBridgeMethod
    public final void handle(e3.d r100, ParamModel r101, f3.h r102) {
        AbsDeleteIcsDataMethodIDL.a r103 = (AbsDeleteIcsDataMethodIDL.a) r101;
        Intrinsics.checkNotNullParameter(r100, "bridgeContext");
        Intrinsics.checkNotNullParameter(r103, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        int r104 = uka.a.f550577a;
        Intrinsics.checkNotNullParameter(r103.getEntityList(), "eventIdList");
        Intrinsics.checkNotNullParameter(AbsDeleteIcsDataMethodIDL.b.class, "<this>");
        r102.b((ResultModel) k3.c.a(AbsDeleteIcsDataMethodIDL.b.class), "");
    }
}
