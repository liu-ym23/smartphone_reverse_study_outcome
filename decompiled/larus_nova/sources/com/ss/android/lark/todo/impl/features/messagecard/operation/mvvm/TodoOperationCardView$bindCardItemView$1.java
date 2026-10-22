package com.ss.android.lark.todo.impl.features.messagecard.operation.mvvm;

import com.bytedance.lark.pb.basic.v1.UrlPreviewEntity;
import com.ss.android.lark.todo.impl.features.common.urlpreview.a;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.todo.impl.features.messagecard.operation.mvvm.TodoOperationCardView$bindCardItemView$1", f = "TodoOperationCardView.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
final class TodoOperationCardView$bindCardItemView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TodoOperationCardView this$0;

    public TodoOperationCardView$bindCardItemView$1(TodoOperationCardView r100, Continuation<? super TodoOperationCardView$bindCardItemView$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new TodoOperationCardView$bindCardItemView$1(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((TodoOperationCardView$bindCardItemView$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 != 0) goto L5;
        ResultKt.throwOnFailure(r100);
        HashMap<String, UrlPreviewEntity> r102 = a.f442485a;
        TodoOperationCardView r103 = this.this$0;
        int r104 = TodoOperationCardView.f443922a;
        r103.getClass();
        throw null;
    L5:
        if (r101 != 1) goto L9;
        ResultKt.throwOnFailure(r100);
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
