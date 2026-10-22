package com.ss.android.lark.compose.chatsetting.common.repository;

import com.lark.kmp.pb.basic.v1.Chat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/lark/kmp/pb/basic/v1/Chat;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.common.repository.ChatSettingRepository$observeChat$3", f = "ChatSettingRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatSettingRepository$observeChat$3 extends SuspendLambda implements Function2<Chat, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $chatId;
    /* synthetic */ Object L$0;
    int label;

    public ChatSettingRepository$observeChat$3(String r100, Continuation<? super ChatSettingRepository$observeChat$3> r101) {
        this.$chatId = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ChatSettingRepository$observeChat$3 r102 = new ChatSettingRepository$observeChat$3(this.$chatId, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Chat r100, Continuation<? super Unit> r101) {
        return ((ChatSettingRepository$observeChat$3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Chat r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r100);
        if (((Chat) this.L$0) != null) goto L8;
        int r101 = c8b.a.f22755a;
        c8b.a.a("[ChatSettingRepository.observeChat] chat not found in push entity, chatId: " + this.$chatId);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
