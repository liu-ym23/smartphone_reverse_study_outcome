package wd7;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IReportADLogResultCallback;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
public final class e implements IReportADLogResultCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<a.c> f559306a;

    public e(CompletionBlock<a.c> r100) {
        this.f559306a = r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IReportADLogResultCallback
    public final void onSuccess(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        CompletionBlock<a.c> r101 = this.f559306a;
        XBaseModel r102 = ne7.e.c(Reflection.getOrCreateKotlinClass(a.c.class));
        a.c r103 = (a.c) r102;
        r103.setCode(1);
        r103.setMsg(r100);
        CompletionBlock.DefaultImpls.onSuccess$default(r101, (XBaseResultModel) r102, null, 2, null);
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IReportADLogResultCallback
    public final void onFailure(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        CompletionBlock.DefaultImpls.onFailure$default(this.f559306a, r100, r101, null, 4, null);
    }
}
