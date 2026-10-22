package rd7;

import bolts.Continuation;
import bolts.Task;
import com.bytedance.sdk.xbridge.cn.calendar.model.CalendarErrorCode;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import kotlin.Unit;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
public final class k<TTaskResult, TContinuationResult> implements Continuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<a.c> f537316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a.b f537317b;

    public k(CompletionBlock<a.c> r100, a.b r101) {
        this.f537316a = r100;
        this.f537317b = r101;
    }

    @Override // bolts.Continuation
    public final Object then(Task r100) {
        if (r100.isFaulted() == false) goto L5;
        Exception r101 = r100.getError();
        CompletionBlock.DefaultImpls.onFailure$default(this.f537316a, CalendarErrorCode.Failed.getValue(), "delete calendar event failed. error msg = " + r101.getMessage() + ", request id = " + this.f537317b.getIdentifier(), null, 4, null);
    L10:
        return Unit.INSTANCE;
    L5:
        CalendarErrorCode r102 = (CalendarErrorCode) r100.getResult();
        if (r102.getValue() != CalendarErrorCode.Success.getValue()) goto L8;
        this.f537316a.onSuccess((XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(a.c.class)), "update success");
        goto L10
    L8:
        CompletionBlock.DefaultImpls.onFailure$default(this.f537316a, r102.getValue(), "update failed.", null, 4, null);
        goto L10
    }
}
