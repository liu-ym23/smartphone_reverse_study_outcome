package com.larus.bmhome.double_post;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/im/bean/conversation/Conversation;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.double_post.AwemeDoublePostInnerPushManager$getMainBotConversationInfo$cvs$2", f = "AwemeDoublePostInnerPushManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AwemeDoublePostInnerPushManager$getMainBotConversationInfo$cvs$2 extends SuspendLambda implements Function2<wc9.e, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    public AwemeDoublePostInnerPushManager$getMainBotConversationInfo$cvs$2(Continuation<? super AwemeDoublePostInnerPushManager$getMainBotConversationInfo$cvs$2> r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        AwemeDoublePostInnerPushManager$getMainBotConversationInfo$cvs$2 r102 = new AwemeDoublePostInnerPushManager$getMainBotConversationInfo$cvs$2(r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(wc9.e r100, Continuation<? super Boolean> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(wc9.e r100, Continuation<? super Boolean> r101) {
        return ((AwemeDoublePostInnerPushManager$getMainBotConversationInfo$cvs$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r100);
        wc9.e r101 = (wc9.e) this.L$0;
        FLogger.f375446a.i("AwemeDoublePostInnerPushManager", "use requestedConversationInfo");
        if (r101 == null) goto L7;
        boolean r102 = true;
    L9:
        return Boxing.boxBoolean(r102);
    L7:
        r102 = false;
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
