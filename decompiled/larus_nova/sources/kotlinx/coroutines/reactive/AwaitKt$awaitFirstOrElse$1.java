package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.reactive.AwaitKt", f = "Await.kt", i = {0}, l = {52}, m = "awaitFirstOrElse", n = {"defaultValue"}, s = {"L$0"})
final class AwaitKt$awaitFirstOrElse$1<T> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public AwaitKt$awaitFirstOrElse$1(Continuation<? super AwaitKt$awaitFirstOrElse$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        int r101 = this.label | Integer.MIN_VALUE;
        this.label = r101;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r101 - Integer.MIN_VALUE;
        AwaitKt$awaitFirstOrElse$1<T> r102 = this;
    L6:
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L12;
        if (r105 != 1) goto L11;
        Function0 r106 = (Function0) r102.L$0;
        ResultKt.throwOnFailure(r103);
    L16:
        if (r103 != null) goto L19;
        return r106.invoke();
    L19:
        return r103;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r103);
        Mode r107 = Mode.FIRST_OR_DEFAULT;
        r102.L$0 = null;
        r102.label = 1;
        r103 = a.a(r107, r102);
        if (r103 == r104) goto L21;
        r106 = null;
        goto L16
    L21:
        return r104;
    L5:
        r102 = new AwaitKt$awaitFirstOrElse$1(this);
        goto L6
    }
}
