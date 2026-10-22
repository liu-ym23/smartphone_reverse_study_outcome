package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.sequences.SequenceScope;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl", f = "DebugCoroutineInfoImpl.kt", i = {0, 0, 0}, l = {167}, m = "yieldFrames", n = {"this", "$this$yieldFrames", "frame"}, s = {"L$0", "L$1", "L$2"})
final class DebugCoroutineInfoImpl$yieldFrames$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ b this$0;

    public DebugCoroutineInfoImpl$yieldFrames$1(b r100, Continuation<? super DebugCoroutineInfoImpl$yieldFrames$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0054 -> B:22:0x0069). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0065 -> B:21:0x0067). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        b r101 = this.this$0;
        r101.getClass();
        int r102 = this.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r102 - Integer.MIN_VALUE;
        DebugCoroutineInfoImpl$yieldFrames$1 r103 = this;
    L6:
        Object r104 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L12;
        if (r106 != 1) goto L11;
        CoroutineStackFrame r107 = (CoroutineStackFrame) r103.L$2;
        SequenceScope r108 = (SequenceScope) r103.L$1;
        b r109 = (b) r103.L$0;
        ResultKt.throwOnFailure(r104);
    L21:
        DebugCoroutineInfoImpl$yieldFrames$1 r110 = r103;
        b r111 = r109;
    L22:
        r107 = r107.getCallerFrame();
        if (r107 == null) goto L26;
    L13:
        if (r107 == null) goto L27;
        StackTraceElement r112 = r107.getStackTraceElement();
        if (r112 == null) goto L22;
        r110.L$0 = r111;
        r110.L$1 = r108;
        r110.L$2 = r107;
        r110.label = 1;
        if (r108.yield(r112, r110) == r105) goto L28;
        r109 = r111;
        r103 = r110;
        goto L21
    L28:
        return r105;
    L27:
        return Unit.INSTANCE;
    L26:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r104);
        r108 = null;
        r110 = r103;
        r111 = r101;
        r107 = null;
        goto L13
    L5:
        r103 = new DebugCoroutineInfoImpl$yieldFrames$1(r101, this);
        goto L6
    }
}
