package com.ss.android.lark.chat.service.impl;

import com.bytedance.lark.pb.im.v1.GetTenantMessageConfResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/bytedance/lark/pb/im/v1/GetTenantMessageConfResponse;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.service.impl.MessageTenantConfService$fetch$1", f = "MessageTenantConfService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MessageTenantConfService$fetch$1 extends SuspendLambda implements Function2<GetTenantMessageConfResponse, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MessageTenantConfService this$0;

    public MessageTenantConfService$fetch$1(MessageTenantConfService r100, Continuation<? super MessageTenantConfService$fetch$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        MessageTenantConfService$fetch$1 r102 = new MessageTenantConfService$fetch$1(this.this$0, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(GetTenantMessageConfResponse r100, Continuation<? super Unit> r101) {
        return ((MessageTenantConfService$fetch$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(GetTenantMessageConfResponse r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        GetTenantMessageConfResponse r101 = (GetTenantMessageConfResponse) this.L$0;
        MessageTenantConfService r102 = this.this$0;
        MessageTenantConfService.b(r102, r102.f416393b, r101.conf);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
