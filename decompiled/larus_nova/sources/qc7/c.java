package qc7;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;
import java.util.Map;
import pc7.g;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock f532477a;

    @Override // pc7.g
    public final void onFail() {
        CompletionBlock.DefaultImpls.onFailure$default(this.f532477a, 0, "twice verify fail", null, 4, null);
    }

    public c(CompletionBlock r100) {
        this.f532477a = r100;
    }

    @Override // pc7.g
    public final void b(String r100, String r101, Map<String, String> r102, Map<String, Object> r103) {
        CompletionBlock r104 = this.f532477a;
        XBaseModel r105 = XBridgeResultModelArguments.INSTANCE.createModel(rc7.c.b.class);
        rc7.c.b r106 = (rc7.c.b) r105;
        r106.setVerifyWay(r100);
        r106.setVerifyTicket(r101);
        r106.setBizParams(r102);
        r106.setVerifyExtraParams(r103);
        CompletionBlock.DefaultImpls.onSuccess$default(r104, (XBaseResultModel) r105, null, 2, null);
    }
}
