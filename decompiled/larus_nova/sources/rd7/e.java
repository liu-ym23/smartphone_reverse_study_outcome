package rd7;

import bolts.Continuation;
import bolts.Task;
import com.bytedance.sdk.xbridge.cn.calendar.model.CalendarErrorCode;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import kotlin.Unit;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes22.dex */
public final class e<TTaskResult, TContinuationResult> implements Continuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<a.c> f537301a;

    public e(CompletionBlock<a.c> r100) {
        this.f537301a = r100;
    }

    @Override // bolts.Continuation
    public final Object then(Task r100) {
        if (r100.isFaulted() == false) goto L5;
        Exception r101 = r100.getError();
        CompletionBlock.DefaultImpls.onFailure$default(this.f537301a, CalendarErrorCode.Unknown.getValue(), "create calendar failed with unknown error, error msg = " + r101.getMessage(), null, 4, null);
    L10:
        return Unit.INSTANCE;
    L5:
        CalendarErrorCode r102 = (CalendarErrorCode) r100.getResult();
        if (r102 != CalendarErrorCode.Success) goto L8;
        this.f537301a.onSuccess((XBaseResultModel) ne7.e.c(Reflection.getOrCreateKotlinClass(a.c.class)), "create calendar success!");
        goto L10
    L8:
        id7.c.a("create calendar failed!");
        CompletionBlock.DefaultImpls.onFailure$default(this.f537301a, r102.getValue(), "create calendar failed!", null, 4, null);
        goto L10
    }
}
