package com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.biz.im.api.ChatWindowPrepareData;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.prepare.ChatPrepareDataLoader$getChatPrepareData$2", f = "ChatPrepareDataLoader.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
final class ChatPrepareDataLoader$getChatPrepareData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IGetDataCallback<ChatWindowPrepareData> $callback;
    final /* synthetic */ String $chatId;
    int label;
    final /* synthetic */ a this$0;

    public ChatPrepareDataLoader$getChatPrepareData$2(a r100, String r101, IGetDataCallback<ChatWindowPrepareData> r102, Continuation<? super ChatPrepareDataLoader$getChatPrepareData$2> r103) {
        this.this$0 = r100;
        this.$chatId = r101;
        this.$callback = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ChatPrepareDataLoader$getChatPrepareData$2(this.this$0, this.$chatId, this.$callback, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ChatPrepareDataLoader$getChatPrepareData$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        ChatWindowPrepareData r103 = (ChatWindowPrepareData) r100;
        IGetDataCallback<ChatWindowPrepareData> r104 = this.$callback;
        if (r104 == null) goto L15;
        r104.onSuccess(r103);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        a r105 = this.this$0;
        String r106 = this.$chatId;
        this.label = 1;
        int r107 = a.f413502k;
        r100 = r105.c(r106);
        if (r100 != r101) goto L11;
        return r101;
    }
}
