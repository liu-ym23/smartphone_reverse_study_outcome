package kotlinx.coroutines.selects;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.selects.SelectImplementation", f = "Select.kt", i = {}, l = {712}, m = "processResultAndInvokeBlockRecoveringException", n = {}, s = {})
final class SelectImplementation$processResultAndInvokeBlockRecoveringException$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SelectImplementation<Object> this$0;

    public SelectImplementation$processResultAndInvokeBlockRecoveringException$1(SelectImplementation<Object> r100, Continuation<? super SelectImplementation$processResultAndInvokeBlockRecoveringException$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        SelectImplementation<Object> r101 = this.this$0;
        AtomicReferenceFieldUpdater r102 = SelectImplementation.f505084f;
        r101.getClass();
        int r103 = this.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r103 - Integer.MIN_VALUE;
        SelectImplementation$processResultAndInvokeBlockRecoveringException$1 r104 = this;
    L6:
        Object r105 = r104.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r104.label;
        if (r106 != 0) goto L9;
        ResultKt.throwOnFailure(r105);
        throw null;     // Catch: Throwable -> L16
    L9:
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L16
        return r105;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        th = move-exception;
        throw th;
    L5:
        r104 = new SelectImplementation$processResultAndInvokeBlockRecoveringException$1(r101, this);
        goto L6
    }
}
