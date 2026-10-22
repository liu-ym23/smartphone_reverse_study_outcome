package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", i = {0}, l = {47}, m = "joinAll", n = {"$this$forEach$iv"}, s = {"L$0"})
final class AwaitKt$joinAll$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public AwaitKt$joinAll$1(Continuation<? super AwaitKt$joinAll$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        int r101 = this.label | Integer.MIN_VALUE;
        this.label = r101;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r101 - Integer.MIN_VALUE;
        AwaitKt$joinAll$1 r102 = this;
    L6:
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 != 0) goto L9;
        ResultKt.throwOnFailure(r103);
        throw null;
    L9:
        if (r105 != 1) goto L19;
        int r106 = r102.I$1;
        int r107 = r102.I$0;
        Job[] r108 = (Job[]) r102.L$0;
        ResultKt.throwOnFailure(r103);
    L11:
        r107 = r107 + 1;
        if (r107 >= r106) goto L17;
        Job r109 = r108[r107];
        r102.L$0 = r108;
        r102.I$0 = r107;
        r102.I$1 = r106;
        r102.label = 1;
        if (r109.join(r102) != r104) goto L11;
        return r104;
    L17:
        return Unit.INSTANCE;
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        r102 = new AwaitKt$joinAll$1(this);
        goto L6
    }
}
