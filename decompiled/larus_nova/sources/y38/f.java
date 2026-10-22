package y38;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeResultModelArguments;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class f implements x38.g<Map<String, ? extends Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<rc7.a.b> f565877a;

    public f(CompletionBlock<rc7.a.b> r100) {
        this.f565877a = r100;
    }

    @Override // x38.g
    public final void a(x38.a r100) {
        Intrinsics.checkNotNullParameter(r100, "error");
        CompletionBlock<rc7.a.b> r101 = this.f565877a;
        String r102 = r100.f562388b;
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        CompletionBlock.DefaultImpls.onFailure$default(r101, 0, r102, null, 4, null);
    }

    @Override // x38.g
    public final void onSuccess(Map<String, ? extends Object> r100) {
        Map<String, ? extends Object> r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        rc7.a.b r102 = (rc7.a.b) XBridgeResultModelArguments.INSTANCE.createModel(rc7.a.b.class);
        r102.setVerifyDecision(r101);
        CompletionBlock.DefaultImpls.onSuccess$default(this.f565877a, r102, null, 2, null);
    }
}
