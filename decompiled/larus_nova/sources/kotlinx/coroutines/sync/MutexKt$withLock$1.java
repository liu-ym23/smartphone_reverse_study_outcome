package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.b0;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.sync.MutexKt", f = "Mutex.kt", i = {0, 0, 0}, l = {120}, m = "withLock", n = {"$this$withLock", "owner", "action"}, s = {"L$0", "L$1", "L$2"})
final class MutexKt$withLock$1<T> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    public MutexKt$withLock$1(Continuation<? super MutexKt$withLock$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        int r101 = this.label | Integer.MIN_VALUE;
        this.label = r101;
        b0 r102 = b.f505138a;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r101 - Integer.MIN_VALUE;
        MutexKt$withLock$1<T> r103 = this;
    L6:
        Object r104 = r103.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L17;
        Function0 r106 = (Function0) r103.L$2;
        Object r107 = r103.L$1;
        a r108 = (a) r103.L$0;
        ResultKt.throwOnFailure(r104);
        Object r109 = r106.invoke();     // Catch: Throwable -> L13
        InlineMarker.finallyStart(1);
        r108.unlock(r107);
        InlineMarker.finallyEnd(1);
        return r109;
    L13:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r108.unlock(r107);
        InlineMarker.finallyEnd(1);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r104);
        r103.L$0 = null;
        r103.L$1 = null;
        r103.L$2 = null;
        r103.label = 1;
        throw null;
    L5:
        r103 = new MutexKt$withLock$1(this);
        goto L6
    }
}
