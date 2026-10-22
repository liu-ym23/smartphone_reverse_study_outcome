package kotlinx.coroutines.rx2;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.rx2.RxAwaitKt", f = "RxAwait.kt", i = {}, l = {78}, m = "awaitSingle", n = {}, s = {})
final class RxAwaitKt$awaitSingle$1<T> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public RxAwaitKt$awaitSingle$1(Continuation<? super RxAwaitKt$awaitSingle$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        int r101 = this.label | Integer.MIN_VALUE;
        this.label = r101;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r101 - Integer.MIN_VALUE;
        RxAwaitKt$awaitSingle$1<T> r102 = this;
    L6:
        Object r103 = r102.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L16;
        if (r104 != 1) goto L15;
        ResultKt.throwOnFailure(r103);
        if (r103 == null) goto L13;
        return r103;
    L13:
        throw new NoSuchElementException();
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r103);
        r102.label = 1;
        a.a(r102);
        throw null;
    L5:
        r102 = new RxAwaitKt$awaitSingle$1(this);
        goto L6
    }
}
