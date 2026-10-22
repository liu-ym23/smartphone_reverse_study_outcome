package rd7;

import bolts.Continuation;
import bolts.Task;
import com.bytedance.sdk.xbridge.cn.calendar.model.CalendarErrorCode;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import kotlin.Unit;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
public final class n<TTaskResult, TContinuationResult> implements Continuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<b.c> f537322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b.InterfaceC7466b f537323b;

    public n(CompletionBlock<b.c> r100, b.InterfaceC7466b r101) {
        this.f537322a = r100;
        this.f537323b = r101;
    }

    @Override // bolts.Continuation
    public final Object then(Task r100) {
        if (r100.isFaulted() == false) goto L5;
        Exception r101 = r100.getError();
        CompletionBlock.DefaultImpls.onFailure$default(this.f537322a, 0, "delete calendar with unknown failure. id = " + this.f537323b.getIdentifier() + " , error msg = " + r101.getMessage(), null, 4, null);
    L10:
        return Unit.INSTANCE;
    L5:
        CalendarErrorCode r102 = (CalendarErrorCode) r100.getResult();
        if (r102.getValue() != CalendarErrorCode.Success.getValue()) goto L8;
        this.f537322a.onSuccess((XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(b.c.class)), "delete Success");
        goto L10
    L8:
        CompletionBlock.DefaultImpls.onFailure$default(this.f537322a, r102.getValue(), "delete failed.", null, 4, null);
        goto L10
    }
}
