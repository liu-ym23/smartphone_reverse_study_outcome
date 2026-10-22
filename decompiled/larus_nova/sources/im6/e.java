package im6;

import com.bytedance.locallife.biz.perf.WholeProcessOptimizationWrapper;
import com.bytedance.locallife.bridge.common.method.y;
import kotlin.jvm.internal.Intrinsics;
import ut6.j;

/* JADX INFO: loaded from: classes20.dex */
public final class e implements WholeProcessOptimizationWrapper.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f490537a;

    public e(y r100) {
        this.f490537a = r100;
    }

    @Override // com.bytedance.locallife.biz.perf.WholeProcessOptimizationWrapper.a
    public final void a(WholeProcessOptimizationWrapper.Code r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "msg");
        int r102 = r100.getValue();
        if (r102 != WholeProcessOptimizationWrapper.Code.SUCCESS.getValue()) goto L6;
        this.f490537a.onSuccess(r101);
        return;
    L6:
        if (r102 != WholeProcessOptimizationWrapper.Code.FAILURE.getValue()) goto L10;
        this.f490537a.onFailure(r100.getValue(), r101);
        return;
    }
}
