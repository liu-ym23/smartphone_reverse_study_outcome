package com.ss.android.lark.keyboard.biz.mention;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.log.Log;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larksuite/framework/callback/Entity/ErrorResult;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.keyboard.biz.mention.IMCommonAtStrategy$getChatters$3", f = "IMCommonAtStrategy.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class IMCommonAtStrategy$getChatters$3 extends SuspendLambda implements Function2<ErrorResult, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $chatterIds;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ IMCommonAtStrategy this$0;

    public IMCommonAtStrategy$getChatters$3(IMCommonAtStrategy r100, List<String> r101, Continuation<? super IMCommonAtStrategy$getChatters$3> r102) {
        this.this$0 = r100;
        this.$chatterIds = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        IMCommonAtStrategy$getChatters$3 r102 = new IMCommonAtStrategy$getChatters$3(this.this$0, this.$chatterIds, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(ErrorResult r100, Continuation<? super Unit> r101) {
        return ((IMCommonAtStrategy$getChatters$3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        Log.e("IMCommonAtStrategy", "get local chatter failed, error = " + ((ErrorResult) this.L$0).getDisplayMsg());
        IMCommonAtStrategy r101 = this.this$0;
        List<String> r102 = this.$chatterIds;
        int r103 = IMCommonAtStrategy.f428402i;
        r101.a(r102);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
