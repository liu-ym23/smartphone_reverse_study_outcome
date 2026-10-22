package com.larus.home.impl.sdk;

import android.app.Dialog;
import com.larus.office.base.service.IOfficeWatermarkSdkService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.home.impl.sdk.SdkWatermarkServiceImpl$attachDialogWatermark$1", f = "SdkWatermarkServiceImpl.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
public final class SdkWatermarkServiceImpl$attachDialogWatermark$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Dialog $dialog;
    final /* synthetic */ IOfficeWatermarkSdkService $officeWatermarkService;
    int label;

    public SdkWatermarkServiceImpl$attachDialogWatermark$1(IOfficeWatermarkSdkService r100, Dialog r101, Continuation<? super SdkWatermarkServiceImpl$attachDialogWatermark$1> r102) {
        this.$officeWatermarkService = r100;
        this.$dialog = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new SdkWatermarkServiceImpl$attachDialogWatermark$1(this.$officeWatermarkService, this.$dialog, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((SdkWatermarkServiceImpl$attachDialogWatermark$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L13:
        Boolean r103 = (Boolean) r100;
    L14:
        IOfficeWatermarkSdkService r104 = this.$officeWatermarkService;
        if (r104 == null) goto L18;
        r104.K(this.$dialog);
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        IOfficeWatermarkSdkService r105 = this.$officeWatermarkService;
        if (r105 == null) goto L14;
        this.label = 1;
        r100 = r105.N(15000, this);
        if (r100 != r101) goto L13;
        return r101;
    }
}
