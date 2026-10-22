package y38;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class w implements x38.g<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<v.b> f565901a;

    public w(CompletionBlock<v.b> r100) {
        this.f565901a = r100;
    }

    @Override // x38.g
    public final void a(x38.a r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        CompletionBlock<v.b> r101 = this.f565901a;
        String r102 = r100.f562388b;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101.onFailure(-3, r102, (XBaseResultModel) ne7.e.b(v.b.class));
    }

    @Override // x38.g
    public final void onSuccess(Unit r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        CompletionBlock.DefaultImpls.onSuccess$default(this.f565901a, (XBaseResultModel) ne7.e.b(v.b.class), null, 2, null);
    }
}
