package com.obric.assistant.obric_action;

import android.content.Context;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/obric/assistant/obric_action/ObricActionResult;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.obric_action.ObricActionServiceImpl$dispatch$2", f = "ObricActionServiceImpl.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
public final class ObricActionServiceImpl$dispatch$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super h<? extends Object>>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $expectKey;
    final /* synthetic */ String $fullUrl;
    int label;
    final /* synthetic */ ObricActionServiceImpl this$0;

    public ObricActionServiceImpl$dispatch$2(ObricActionServiceImpl r100, Context r101, String r102, String r103, Continuation<? super ObricActionServiceImpl$dispatch$2> r104) {
        this.this$0 = r100;
        this.$context = r101;
        this.$fullUrl = r102;
        this.$expectKey = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ObricActionServiceImpl$dispatch$2(this.this$0, this.$context, this.$fullUrl, this.$expectKey, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super h<? extends Object>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super h<? extends Object>> r101) {
        return ((ObricActionServiceImpl$dispatch$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        return r100;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        ObricActionServiceImpl r103 = this.this$0;
        Context r104 = this.$context;
        String r105 = this.$fullUrl;
        String r106 = this.$expectKey;
        this.label = 1;
        r100 = ObricActionServiceImpl.f(r103, r104, r105, r106, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
