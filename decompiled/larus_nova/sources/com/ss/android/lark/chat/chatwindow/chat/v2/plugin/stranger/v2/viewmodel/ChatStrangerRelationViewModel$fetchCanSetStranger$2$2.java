package com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel;

import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "error", "Lcom/larksuite/framework/callback/Entity/ErrorResult;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.plugin.stranger.v2.viewmodel.ChatStrangerRelationViewModel$fetchCanSetStranger$2$2", f = "ChatStrangerRelationViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatStrangerRelationViewModel$fetchCanSetStranger$2$2 extends SuspendLambda implements Function2<ErrorResult, Continuation<? super Unit>, Object> {
    final /* synthetic */ i<Boolean> $it;
    final /* synthetic */ long $userId;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatStrangerRelationViewModel$fetchCanSetStranger$2$2(long r100, i<? super Boolean> r101, Continuation<? super ChatStrangerRelationViewModel$fetchCanSetStranger$2$2> r102) {
        this.$userId = r100;
        this.$it = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ChatStrangerRelationViewModel$fetchCanSetStranger$2$2 r102 = new ChatStrangerRelationViewModel$fetchCanSetStranger$2$2(this.$userId, this.$it, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(ErrorResult r100, Continuation<? super Unit> r101) {
        return ((ChatStrangerRelationViewModel$fetchCanSetStranger$2$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(ErrorResult r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        ErrorResult r101 = (ErrorResult) this.L$0;
        StringBuilder r102 = new StringBuilder("fetch can set stranger from tryLocal  userId：");
        r102.append(this.$userId);
        r102.append(", failed, err: ");
        String r103 = r101.getMessage();
        if (r103 != null) goto L7;
        r103 = "unknown";
    L7:
        r102.append(r103);
        Log.e("ChatStrangerRelationVM", r102.toString());
        this.$it.resumeWith(Result.m9449constructorimpl(null));
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
