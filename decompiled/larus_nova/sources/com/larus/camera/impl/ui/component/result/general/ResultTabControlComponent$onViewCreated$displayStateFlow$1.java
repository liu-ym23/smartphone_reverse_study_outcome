package com.larus.camera.impl.ui.component.result.general;

import com.larus.camera.impl.entity.ResultBottomControlType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Lcom/larus/camera/impl/ui/component/result/general/ResultTabControlComponent$DisplayState;", "bottomState", "Lcom/larus/camera/impl/entity/ResultBottomState;", "isInCropMode", "", "bottomReady"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.ResultTabControlComponent$onViewCreated$displayStateFlow$1", f = "ResultTabControlComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ResultTabControlComponent$onViewCreated$displayStateFlow$1 extends SuspendLambda implements Function4<px8.e, Boolean, Boolean, Continuation<? super ResultTabControlComponent.DisplayState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ boolean Z$0;
    /* synthetic */ boolean Z$1;
    int label;

    public ResultTabControlComponent$onViewCreated$displayStateFlow$1(Continuation<? super ResultTabControlComponent$onViewCreated$displayStateFlow$1> r100) {
        super(4, r100);
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Object invoke(px8.e r100, Boolean r101, Boolean r102, Continuation<? super ResultTabControlComponent.DisplayState> r103) {
        return invoke(r100, r101.booleanValue(), r102.booleanValue(), r103);
    }

    public final Object invoke(px8.e r100, boolean r101, boolean r102, Continuation<? super ResultTabControlComponent.DisplayState> r103) {
        ResultTabControlComponent$onViewCreated$displayStateFlow$1 r104 = new ResultTabControlComponent$onViewCreated$displayStateFlow$1(r103);
        r104.L$0 = r100;
        r104.Z$0 = r101;
        r104.Z$1 = r102;
        return r104.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r100);
        px8.e r101 = (px8.e) this.L$0;
        boolean r102 = this.Z$0;
        boolean r103 = this.Z$1;
        if (r102 == true) goto L22;
        if (r103 == false) goto L22;
        ResultBottomControlType r104 = null;
        if (r101 == null) goto L11;
        ResultBottomControlType r105 = r101.f530953a;
    L13:
        if (r105 == ResultBottomControlType.INPUT) goto L25;
        if (r101 == null) goto L18;
        r104 = r101.f530953a;
    L18:
        if (r104 != ResultBottomControlType.CONFIRM) goto L27;
        return ResultTabControlComponent.DisplayState.CONFIRM;
    L27:
        return ResultTabControlComponent.DisplayState.HIDDEN;
    L25:
        return ResultTabControlComponent.DisplayState.INPUT;
    L11:
        r105 = null;
    L22:
        return ResultTabControlComponent.DisplayState.HIDDEN;
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
