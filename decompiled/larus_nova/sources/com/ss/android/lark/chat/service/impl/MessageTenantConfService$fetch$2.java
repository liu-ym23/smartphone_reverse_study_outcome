package com.ss.android.lark.chat.service.impl;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larksuite/framework/callback/Entity/ErrorResult;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.service.impl.MessageTenantConfService$fetch$2", f = "MessageTenantConfService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MessageTenantConfService$fetch$2 extends SuspendLambda implements Function2<ErrorResult, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public MessageTenantConfService$fetch$2(Continuation<? super MessageTenantConfService$fetch$2> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MessageTenantConfService$fetch$2 r102 = new MessageTenantConfService$fetch$2(r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(ErrorResult r100, Continuation<? super Unit> r101) {
        return ((MessageTenantConfService$fetch$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ErrorResult r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        Log.w("MessageTenantConfService", "getTenantMessageConf: execute error , error message is " + ((ErrorResult) this.L$0).getDebugMsg());
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
