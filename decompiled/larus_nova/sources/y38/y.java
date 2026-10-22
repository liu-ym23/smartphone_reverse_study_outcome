package y38;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.account.saas.jsb.core.FlowAccountUnbindCore;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class y implements x38.g<FlowAccountUnbindCore.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<x.b> f565904a;

    public y(CompletionBlock<x.b> r100) {
        this.f565904a = r100;
    }

    @Override // x38.g
    public final void a(x38.a r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        CompletionBlock<x.b> r101 = this.f565904a;
        String r102 = r100.f562388b;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        CompletionBlock.DefaultImpls.onFailure$default(r101, -3, r102, null, 4, null);
    }

    @Override // x38.g
    public final void onSuccess(FlowAccountUnbindCore.a r100) {
        FlowAccountUnbindCore.a r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        CompletionBlock<x.b> r102 = this.f565904a;
        XBaseModel r103 = ne7.e.b(x.b.class);
        x.b r104 = (x.b) r103;
        r104.setSuccess(r101.f286364a);
        r104.setErrorCode(r101.f286365b);
        r104.setErrorMessage(r101.f286366c);
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) r103, null, 2, null);
    }
}
