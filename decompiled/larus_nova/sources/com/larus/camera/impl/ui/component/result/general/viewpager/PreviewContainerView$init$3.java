package com.larus.camera.impl.ui.component.result.general.viewpager;

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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "inMarkSelectMode", "inCropMode"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.general.viewpager.PreviewContainerView$init$3", f = "PreviewContainerView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PreviewContainerView$init$3 extends SuspendLambda implements Function3<Boolean, Boolean, Continuation<? super Boolean>, Object> {
    /* synthetic */ boolean Z$0;
    /* synthetic */ boolean Z$1;
    int label;

    public PreviewContainerView$init$3(Continuation<? super PreviewContainerView$init$3> r100) {
        super(3, r100);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Boolean r100, Boolean r101, Continuation<? super Boolean> r102) {
        return invoke(r100.booleanValue(), r101.booleanValue(), r102);
    }

    public final Object invoke(boolean r100, boolean r101, Continuation<? super Boolean> r102) {
        PreviewContainerView$init$3 r103 = new PreviewContainerView$init$3(r102);
        r103.Z$0 = r100;
        r103.Z$1 = r101;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r100);
        boolean r101 = this.Z$0;
        boolean r102 = this.Z$1;
        if (r101 == true) goto L9;
        if (r102 == true) goto L9;
        boolean r103 = false;
    L11:
        return Boxing.boxBoolean(r103);
    L9:
        r103 = true;
        goto L11
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
