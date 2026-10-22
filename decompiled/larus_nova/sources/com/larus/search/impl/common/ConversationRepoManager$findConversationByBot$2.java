package com.larus.search.impl.common;

import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import wc9.e;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.search.impl.common.ConversationRepoManager$findConversationByBot$2", f = "ConversationRepoManager.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
public final class ConversationRepoManager$findConversationByBot$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $botId;
    int label;

    public ConversationRepoManager$findConversationByBot$2(String r100, Continuation<? super ConversationRepoManager$findConversationByBot$2> r101) {
        this.$botId = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new ConversationRepoManager$findConversationByBot$2(this.$botId, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super String> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super String> r101) {
        return ((ConversationRepoManager$findConversationByBot$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        e r103 = (e) r100;
        if (r103 == null) goto L14;
        String r104 = r103.f559198a;
    L15:
        if (r104 != null) goto L18;
        return "";
    L18:
        return r104;
    L14:
        r104 = null;
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        IConversationRepoService r105 = ConversationRepoManager.f367621b;
        String r106 = this.$botId;
        this.label = 1;
        r100 = r105.a(r106, this);
        if (r100 != r101) goto L11;
        return r101;
    }
}
