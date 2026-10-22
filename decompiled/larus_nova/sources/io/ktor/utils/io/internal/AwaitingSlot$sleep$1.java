package io.ktor.utils.io.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.CompletableJob;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.internal.AwaitingSlot", f = "AwaitingSlot.kt", i = {0}, l = {24}, m = "sleep", n = {"this"}, s = {"L$0"})
final class AwaitingSlot$sleep$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public AwaitingSlot$sleep$1(a r100, Continuation<? super AwaitingSlot$sleep$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        a r101 = this.this$0;
        r101.getClass();
        int r102 = this.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r102 - Integer.MIN_VALUE;
        AwaitingSlot$sleep$1 r103 = this;
    L6:
        Object r104 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L12;
        if (r106 != 1) goto L11;
        r101 = (a) r103.L$0;
        ResultKt.throwOnFailure(r104);
    L16:
        if (((Boolean) r104).booleanValue() == true) goto L23;
        r101.getClass();
        CompletableJob r107 = (CompletableJob) a.f492065a.getAndSet(r101, null);
        if (r107 == null) goto L22;
        r107.complete();
    L22:
        return Unit.INSTANCE;
    L23:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r104);
        r103.L$0 = r101;
        r103.label = 1;
        r104 = r101.a(r103);
        if (r104 != r105) goto L16;
        return r105;
    L5:
        r103 = new AwaitingSlot$sleep$1(r101, this);
        goto L6
    }
}
