package com.larus.camera.impl.ui.component.capture;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.capture.CaptureTitleComponent$onViewCreated$2", f = "CaptureTitleComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CaptureTitleComponent$onViewCreated$2 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ CaptureTitleComponent this$0;

    public CaptureTitleComponent$onViewCreated$2(CaptureTitleComponent r100, Continuation<? super CaptureTitleComponent$onViewCreated$2> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        CaptureTitleComponent$onViewCreated$2 r102 = new CaptureTitleComponent$onViewCreated$2(this.this$0, r101);
        r102.I$0 = ((Number) r100).intValue();
        return r102;
    }

    public final Object invoke(int r100, Continuation<? super Unit> r101) {
        return ((CaptureTitleComponent$onViewCreated$2) create(Integer.valueOf(r100), r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Integer r100, Continuation<? super Unit> r101) {
        return invoke(r100.intValue(), r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        final int r101 = this.I$0;
        final CaptureTitleComponent r102 = this.this$0;
        r102.p(new r2(r102, r101));
        final CaptureTitleComponent r103 = this.this$0;
        r103.r(new s2(r103, r101));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
