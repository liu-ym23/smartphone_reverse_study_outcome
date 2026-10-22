package com.bytedance.pia.core.utils;

import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlin/sequences/SequenceScope;", "", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.pia.core.utils.StreamUtils$asSequence$1$1", f = "StreamUtils.kt", i = {0, 0}, l = {39}, m = "invokeSuspend", n = {"$this$sequence", "buffer"}, s = {"L$0", "L$1"})
public final class StreamUtils$asSequence$1$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super char[]>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $chunkSize;
    final /* synthetic */ InputStreamReader $reader;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public StreamUtils$asSequence$1$1(int r100, InputStreamReader r101, Continuation<? super StreamUtils$asSequence$1$1> r102) {
        this.$chunkSize = r100;
        this.$reader = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        StreamUtils$asSequence$1$1 r102 = new StreamUtils$asSequence$1$1(this.$chunkSize, this.$reader, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super char[]> r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SequenceScope<? super char[]> r100, Continuation<? super Unit> r101) {
        return ((StreamUtils$asSequence$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0045 -> B:14:0x0048). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        char[] r103 = (char[]) this.L$1;
        SequenceScope r104 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r100);
        StreamUtils$asSequence$1$1 r105 = this;
        SequenceScope r106 = r104;
    L14:
        int r107 = r105.$reader.read(r103);
    L10:
        if (r107 == (-1)) goto L16;
        char[] r108 = ArraysKt.copyOfRange(r103, 0, r107);
        r105.L$0 = r106;
        r105.L$1 = r103;
        r105.label = 1;
        if (r106.yield(r108, r105) != r101) goto L14;
        return r101;
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        r106 = (SequenceScope) this.L$0;
        r103 = new char[this.$chunkSize];
        r107 = this.$reader.read(r103);
        r105 = this;
        goto L10
    }
}
