package y38;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class r implements x38.g<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<rc7.b.InterfaceC7460b> f565894a;

    public r(CompletionBlock<rc7.b.InterfaceC7460b> r100) {
        this.f565894a = r100;
    }

    @Override // x38.g
    public final void a(x38.a r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        CompletionBlock<rc7.b.InterfaceC7460b> r101 = this.f565894a;
        String r102 = r100.f562388b;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        CompletionBlock.DefaultImpls.onFailure$default(r101, 0, r102, null, 4, null);
    }

    @Override // x38.g
    public final void onSuccess(Unit r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        CompletionBlock.DefaultImpls.onSuccess$default(this.f565894a, (XBaseResultModel) XBridgeResultModelArguments.INSTANCE.createModel(rc7.b.InterfaceC7460b.class), null, 2, null);
    }
}
