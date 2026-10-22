package com.obric.capability.schedulekit;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.capability.schedulekit.CapabilityScheduleSdk", f = "CapabilityScheduleSdk.kt", i = {}, l = {98}, m = "isDownloadAppIntentV2", n = {}, s = {})
final class CapabilityScheduleSdk$isDownloadAppIntentV2$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ b this$0;

    public CapabilityScheduleSdk$isDownloadAppIntentV2$1(b r100, Continuation<? super CapabilityScheduleSdk$isDownloadAppIntentV2$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        b r101 = this.this$0;
        r101.getClass();
        int r102 = this.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r102 - Integer.MIN_VALUE;
        CapabilityScheduleSdk$isDownloadAppIntentV2$1 r103 = this;
    L6:
        Object r104 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        boolean r107 = true;
        if (r106 == 0) goto L12;
        if (r106 != 1) goto L11;
        ResultKt.throwOnFailure(r104);
    L16:
        if (((Number) r104).intValue() >= 2) goto L20;
        r107 = false;
    L20:
        return Boxing.boxBoolean(r107);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r104);
        r103.label = 1;
        r104 = c.f396039a.a(r103);
        if (r104 != r105) goto L16;
        return r105;
    L5:
        r103 = new CapabilityScheduleSdk$isDownloadAppIntentV2$1(r101, this);
        goto L6
    }
}
