package io.ktor.utils.io;

import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 176)
@DebugMetadata(c = "io.ktor.utils.io.LookAheadSessionKt", f = "LookAheadSession.kt", i = {0, 0, 1, 1, 1}, l = {54, 59}, m = "consumeEachRemaining", n = {"$this$consumeEachRemaining", "visitor", "$this$consumeEachRemaining", "visitor", "s"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0"})
final class LookAheadSessionKt$consumeEachRemaining$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    public LookAheadSessionKt$consumeEachRemaining$1(Continuation<? super LookAheadSessionKt$consumeEachRemaining$1> r100) {
        super(r100);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x006b -> B:15:0x0051). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x007e -> B:26:0x0081). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        int r101 = this.label | Integer.MIN_VALUE;
        this.label = r101;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r101 - Integer.MIN_VALUE;
        LookAheadSessionKt$consumeEachRemaining$1 r102 = this;
    L6:
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 == 1) goto L13;
        if (r105 != 2) goto L12;
        int r106 = r102.I$0;
        Function2 r107 = (Function2) r102.L$1;
        q r108 = (q) r102.L$0;
        ResultKt.throwOnFailure(r103);
    L26:
        boolean r109 = ((Boolean) r103).booleanValue();
        r108.a(r106);
        if (r109 == false) goto L30;
    L15:
        ByteBuffer r110 = r108.b(0, 1);
        if (r110 != null) goto L23;
        r102.L$0 = r108;
        r102.L$1 = r107;
        r102.label = 1;
        r103 = r108.f(1, r102);
        if (r103 != r104) goto L21;
        return r104;
    L21:
        if (((Boolean) r103).booleanValue() == false) goto L30;
    L23:
        r106 = r110.remaining();
        r102.L$0 = r108;
        r102.L$1 = r107;
        r102.I$0 = r106;
        r102.label = 2;
        r103 = r107.invoke(r110, r102);
        if (r103 != r104) goto L26;
        return r104;
    L30:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        Function2 r111 = (Function2) r102.L$1;
        q r112 = (q) r102.L$0;
        ResultKt.throwOnFailure(r103);
        r108 = r112;
        r107 = r111;
        goto L21
    L14:
        ResultKt.throwOnFailure(r103);
        r107 = null;
        r108 = null;
        goto L15
    L5:
        r102 = new LookAheadSessionKt$consumeEachRemaining$1(this);
        goto L6
    }
}
