package y38;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class m implements x38.g<Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<l.b> f565887a;

    public m(CompletionBlock<l.b> r100) {
        this.f565887a = r100;
    }

    @Override // x38.g
    public final void a(x38.a r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        CompletionBlock<l.b> r101 = this.f565887a;
        String r102 = r100.f562388b;
        if (r102 != null) goto L5;
        r102 = "Network Error";
    L5:
        XBaseModel r103 = ne7.e.b(l.b.class);
        l.b r104 = (l.b) r103;
        r104.setXErrorCode(Integer.valueOf(r100.f562387a));
        r104.setXErrorMessage(r100.f562388b);
        Unit r105 = Unit.INSTANCE;
        r101.onFailure(0, r102, (XBaseResultModel) r103);
    }

    @Override // x38.g
    public final void onSuccess(Unit r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        CompletionBlock.DefaultImpls.onSuccess$default(this.f565887a, (XBaseResultModel) ne7.e.b(l.b.class), null, 2, null);
    }
}
