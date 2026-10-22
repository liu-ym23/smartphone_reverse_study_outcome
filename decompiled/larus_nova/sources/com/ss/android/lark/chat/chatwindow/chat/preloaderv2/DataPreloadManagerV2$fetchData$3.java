package com.ss.android.lark.chat.chatwindow.chat.preloaderv2;

import com.byted.cast.common.source.ISendResultListener;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.preloaderv2.DataPreloadManagerV2$fetchData$3", f = "DataPreloadManagerV2.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
final class DataPreloadManagerV2$fetchData$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetDataCallback<Object> $callback;
    final /* synthetic */ w3b.d<Object> $task;
    int label;
    final /* synthetic */ DataPreloadManagerV2 this$0;

    public DataPreloadManagerV2$fetchData$3(DataPreloadManagerV2 r100, w3b.d<Object> r101, IGetDataCallback<Object> r102, Continuation<? super DataPreloadManagerV2$fetchData$3> r103) {
        this.this$0 = r100;
        this.$task = r101;
        this.$callback = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new DataPreloadManagerV2$fetchData$3(this.this$0, this.$task, this.$callback, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((DataPreloadManagerV2$fetchData$3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
        Object r103 = ((Result) r100).m9458unboximpl();
    L11:
        ErrorResult r104 = null;
        if (Result.m9456isSuccessimpl(r103) == true) goto L14;
        Throwable r105 = Result.m9452exceptionOrNullimpl(r103);
        if ((r105 instanceof ErrorResult) == false) goto L26;
        r104 = (ErrorResult) r105;
    L26:
        IGetDataCallback<Object> r106 = this.$callback;
        if (r106 == null) goto L32;
        if (r104 != null) goto L30;
        r104 = new ErrorResult("fetchData failed");
    L30:
        r106.onError(r104);
    L32:
        return Unit.INSTANCE;
    L14:
        if (Result.m9455isFailureimpl(r103) == false) goto L16;
        r103 = null;
    L16:
        if (r103 != null) goto L20;
        IGetDataCallback<Object> r107 = this.$callback;
        if (r107 == null) goto L32;
        r107.onError(new ErrorResult(ISendResultListener.ERROR_MSG_DLNA_CUSTOMIZED_SERVICE_RESPONSE_IS_NULL));
        goto L32
    L20:
        IGetDataCallback<Object> r108 = this.$callback;
        if (r108 == null) goto L32;
        r108.onSuccess(r103);
        goto L32
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        DataPreloadManagerV2 r109 = this.this$0;
        w3b.d<Object> r110 = this.$task;
        this.label = 1;
        r103 = r109.B6(r110, this);
        if (r103 != r101) goto L11;
        return r101;
    }
}
