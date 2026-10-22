package rd7;

import bolts.Continuation;
import bolts.Task;
import com.bytedance.sdk.xbridge.cn.calendar.model.CalendarErrorCode;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import kotlin.Unit;

/* JADX INFO: loaded from: classes22.dex */
public final class t<TTaskResult, TContinuationResult> implements Continuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CompletionBlock<c.InterfaceC7467c> f537336a;

    public t(CompletionBlock<c.InterfaceC7467c> r100) {
        this.f537336a = r100;
    }

    @Override // bolts.Continuation
    public final Object then(Task r100) {
        if (r100.isFaulted() == false) goto L5;
        Exception r101 = r100.getError();
        CompletionBlock.DefaultImpls.onFailure$default(this.f537336a, CalendarErrorCode.NotFound.getValue(), "read calendar with a failure operation. error msg = " + r101.getMessage(), null, 4, null);
    L10:
        return Unit.INSTANCE;
    L5:
        c.InterfaceC7467c r102 = (c.InterfaceC7467c) r100.getResult();
        if (r102 != null) goto L8;
        CompletionBlock.DefaultImpls.onFailure$default(this.f537336a, CalendarErrorCode.NotFound.getValue(), "read calendar but got a null.", null, 4, null);
        goto L10
    L8:
        this.f537336a.onSuccess(r102, "read success");
        goto L10
    }
}
