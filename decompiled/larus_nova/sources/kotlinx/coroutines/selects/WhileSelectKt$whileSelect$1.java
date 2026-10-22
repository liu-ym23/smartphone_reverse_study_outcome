package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.selects.WhileSelectKt", f = "WhileSelect.kt", i = {0}, l = {37}, m = "whileSelect", n = {"builder"}, s = {"L$0"})
final class WhileSelectKt$whileSelect$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public WhileSelectKt$whileSelect$1(Continuation<? super WhileSelectKt$whileSelect$1> r100) {
        super(r100);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x004d -> B:16:0x0050). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        int r101 = this.label | Integer.MIN_VALUE;
        this.label = r101;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r101 - Integer.MIN_VALUE;
        WhileSelectKt$whileSelect$1 r102 = this;
    L6:
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L12;
        if (r105 != 1) goto L11;
        Function1 r106 = (Function1) r102.L$0;
        ResultKt.throwOnFailure(r103);
    L17:
        if (((Boolean) r103).booleanValue() == false) goto L19;
    L13:
        SelectImplementation r107 = new SelectImplementation(r102.getContext());
        r106.invoke(r107);
        r102.L$0 = r106;
        r102.label = 1;
        r103 = r107.h(r102);
        if (r103 != r104) goto L17;
        return r104;
    L19:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r103);
        r106 = null;
        goto L13
    L5:
        r102 = new WhileSelectKt$whileSelect$1(this);
        goto L6
    }
}
