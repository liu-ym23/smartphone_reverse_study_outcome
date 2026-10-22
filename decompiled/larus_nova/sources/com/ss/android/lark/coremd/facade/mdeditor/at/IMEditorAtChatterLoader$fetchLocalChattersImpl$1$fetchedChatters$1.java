package com.ss.android.lark.coremd.facade.mdeditor.at;

import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.im.sdk.service.ImSdkService;
import java.util.List;
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

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "", "Lcom/ss/android/lark/chat/entity/chatter/ChatChatter;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.coremd.facade.mdeditor.at.IMEditorAtChatterLoader$fetchLocalChattersImpl$1$fetchedChatters$1", f = "IMEditorAtChatterLoader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class IMEditorAtChatterLoader$fetchLocalChattersImpl$1$fetchedChatters$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, ? extends ChatChatter>>, Object> {
    final /* synthetic */ String $chatId;
    final /* synthetic */ List<String> $chatterIds;
    int label;

    public IMEditorAtChatterLoader$fetchLocalChattersImpl$1$fetchedChatters$1(String r100, List<String> r101, Continuation<? super IMEditorAtChatterLoader$fetchLocalChattersImpl$1$fetchedChatters$1> r102) {
        this.$chatId = r100;
        this.$chatterIds = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new IMEditorAtChatterLoader$fetchLocalChattersImpl$1$fetchedChatters$1(this.$chatId, this.$chatterIds, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Map<String, ? extends ChatChatter>> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Map<String, ? extends ChatChatter>> r101) {
        return ((IMEditorAtChatterLoader$fetchLocalChattersImpl$1$fetchedChatters$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        return ImSdkService.d().I3(this.$chatId, this.$chatterIds);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
