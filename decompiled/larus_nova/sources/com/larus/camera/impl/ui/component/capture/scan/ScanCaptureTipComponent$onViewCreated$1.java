package com.larus.camera.impl.ui.component.capture.scan;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.capture.scan.ScanCaptureTipComponent$onViewCreated$1", f = "ScanCaptureTipComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ScanCaptureTipComponent$onViewCreated$1 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ScanCaptureTipComponent this$0;

    public ScanCaptureTipComponent$onViewCreated$1(ScanCaptureTipComponent r100, Continuation<? super ScanCaptureTipComponent$onViewCreated$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ScanCaptureTipComponent$onViewCreated$1 r102 = new ScanCaptureTipComponent$onViewCreated$1(this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(String r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(String r100, Continuation<? super Unit> r101) {
        return ((ScanCaptureTipComponent$onViewCreated$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r100);
        String r101 = (String) this.L$0;
        ScanCaptureTipComponent r102 = this.this$0;
        r102.getClass();
        if (com.larus.camera.impl.ui.component.capture.a.C4152a.b(r102, r101) == false) goto L7;
        this.this$0.o();
    L9:
        return Unit.INSTANCE;
    L7:
        this.this$0.l();
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
