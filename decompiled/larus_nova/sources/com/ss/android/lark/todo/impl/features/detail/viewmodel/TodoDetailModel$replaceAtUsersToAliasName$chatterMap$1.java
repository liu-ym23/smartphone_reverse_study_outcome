package com.ss.android.lark.todo.impl.features.detail.viewmodel;

import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.todo.impl.utils.TodoImServices;
import java.util.ArrayList;
import java.util.Map;
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
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "", "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.todo.impl.features.detail.viewmodel.TodoDetailModel$replaceAtUsersToAliasName$chatterMap$1", f = "TodoDetailModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TodoDetailModel$replaceAtUsersToAliasName$chatterMap$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends Chatter>>, Object> {
    final /* synthetic */ ArrayList<String> $atUserIds;
    int label;

    public TodoDetailModel$replaceAtUsersToAliasName$chatterMap$1(ArrayList<String> r100, Continuation<? super TodoDetailModel$replaceAtUsersToAliasName$chatterMap$1> r101) {
        this.$atUserIds = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new TodoDetailModel$replaceAtUsersToAliasName$chatterMap$1(this.$atUserIds, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Map<String, ? extends Chatter>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Map<String, ? extends Chatter>> r101) {
        return ((TodoDetailModel$replaceAtUsersToAliasName$chatterMap$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        return TodoImServices.a().a0(this.$atUserIds);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
