package y38;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.account.saas.jsb.core.FlowAccountCommonAlertCore;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements x38.g<FlowAccountCommonAlertCore.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<a.b> f565870a;

    public b(CompletionBlock<a.b> r100) {
        this.f565870a = r100;
    }

    @Override // x38.g
    public final void a(x38.a r110) {
        Intrinsics.checkNotNullParameter(r110, "error");
        if (r110.f562387a != FlowAccountCommonAlertCore.Error.CANCELLED.getCode()) goto L5;
        CompletionBlock.DefaultImpls.onFailure$default(this.f565870a, -7, null, null, 6, null);
        return;
    L5:
        CompletionBlock<a.b> r100 = this.f565870a;
        String r111 = r110.f562388b;
        if (r111 != null) goto L8;
        r111 = "";
    L8:
        CompletionBlock.DefaultImpls.onFailure$default(r100, 0, r111, null, 4, null);
    }

    @Override // x38.g
    public final void onSuccess(FlowAccountCommonAlertCore.b r100) {
        FlowAccountCommonAlertCore.b r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        CompletionBlock<a.b> r102 = this.f565870a;
        XBaseModel r103 = ne7.e.b(a.b.class);
        a.b r104 = (a.b) r103;
        r104.setId(r101.f286336a);
        r104.setTitle(r101.f286337b);
        r104.setStyle(r101.f286338c);
        CompletionBlock.DefaultImpls.onSuccess$default(r102, (XBaseResultModel) r103, null, 2, null);
    }
}
