package rd7;

import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostCalendarEventCallback;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
public final class i implements IHostCalendarEventCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<a.c> f537313a;

    public i(CompletionBlock<a.c> r100) {
        this.f537313a = r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostCalendarEventCallback
    public final void onResult(boolean r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "msg");
        if (r100 == false) goto L5;
        this.f537313a.onSuccess((XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(a.c.class)), "create calendar success!");
        return;
    L5:
        CompletionBlock.DefaultImpls.onFailure$default(this.f537313a, r101, r102, null, 4, null);
    }
}
