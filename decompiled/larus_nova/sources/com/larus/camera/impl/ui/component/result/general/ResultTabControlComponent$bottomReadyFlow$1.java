package com.larus.camera.impl.ui.component.result.general;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "detectionReady", "tabState", "Lcom/larus/camera/impl/entity/EduResultTabState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultTabControlComponent$bottomReadyFlow$1", f = "ResultTabControlComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ResultTabControlComponent$bottomReadyFlow$1 extends SuspendLambda implements Function3<Boolean, px8.b, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    int label;

    public ResultTabControlComponent$bottomReadyFlow$1(Continuation<? super ResultTabControlComponent$bottomReadyFlow$1> r100) {
        super(3, r100);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Boolean r100, px8.b r101, Continuation<? super Boolean> r102) {
        return invoke(r100.booleanValue(), r101, r102);
    }

    public final Object invoke(boolean r100, px8.b r101, Continuation<? super Boolean> r102) {
        ResultTabControlComponent$bottomReadyFlow$1 r103 = new ResultTabControlComponent$bottomReadyFlow$1(r102);
        r103.Z$0 = r100;
        r103.L$0 = r101;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r100);
        boolean r101 = this.Z$0;
        px8.b r102 = (px8.b) this.L$0;
        if (r101 == true) goto L7;
    L9:
        boolean r103 = false;
    L11:
        return Boxing.boxBoolean(r103);
    L7:
        if (r102.f530943a.contains(r102.f530944b) == false) goto L9;
        r103 = true;
        goto L11
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
