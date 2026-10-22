package com.larus.bmhome.chat.trace.appreciable;

import com.larus.common.apphost.AppHost;
import com.ss.android.lark.inv.export.router.InvRouter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.trace.appreciable.ChatPageTrace$ChatPageRecord$report$1$1", f = "ChatPageTrace.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatPageTrace$ChatPageRecord$report$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $jsonObject;
    int label;
    final /* synthetic */ ChatPageTrace.ChatPageRecord this$0;

    public ChatPageTrace$ChatPageRecord$report$1$1(ChatPageTrace.ChatPageRecord r100, JSONObject r101, Continuation<? super ChatPageTrace$ChatPageRecord$report$1$1> r102) {
        this.this$0 = r100;
        this.$jsonObject = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ChatPageTrace$ChatPageRecord$report$1$1(this.this$0, this.$jsonObject, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ChatPageTrace$ChatPageRecord$report$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r100);
        ChatPageTrace.ChatPageRecord.access$writeFileToExternalStorage(this.this$0, AppHost.f326268a.getApplication(), "conversation_" + this.this$0.getCvsId() + InvRouter.FLOW_SUFFIX, this.$jsonObject.toString());
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
