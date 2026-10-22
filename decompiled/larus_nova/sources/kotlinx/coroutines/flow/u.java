package kotlinx.coroutines.flow;

import kotlin.ExceptionsKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class u {
    public static final Object a(l1 r100, Function3 r101, Throwable r102, Continuation r103) {
        if ((r103 instanceof FlowKt__EmittersKt$invokeSafely$1) == false) goto L7;
        FlowKt__EmittersKt$invokeSafely$1 r104 = (FlowKt__EmittersKt$invokeSafely$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L16;
        if (r108 != 1) goto L15;
        r102 = (Throwable) r104.L$0;
        ResultKt.throwOnFailure(r106);     // Catch: Throwable -> L22
    L20:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r106);
        r104.L$0 = r102;     // Catch: Throwable -> L22
        r104.label = 1;     // Catch: Throwable -> L22
        if (r101.invoke(r100, r102, r104) != r107) goto L20;
        return r107;
    L22:
        th = move-exception;
        if (r102 == null) goto L26;
        if (r102 == th) goto L26;
        ExceptionsKt.addSuppressed(th, r102);
    L26:
        throw th;
    L7:
        r104 = new FlowKt__EmittersKt$invokeSafely$1(r103);
        goto L8
    }
}
