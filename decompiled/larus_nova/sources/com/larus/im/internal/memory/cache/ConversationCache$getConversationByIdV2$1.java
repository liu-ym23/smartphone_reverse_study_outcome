package com.larus.im.internal.memory.cache;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.im.internal.memory.cache.ConversationCache", f = "ConversationCache.kt", i = {0, 0}, l = {74}, m = "getConversationByIdV2", n = {"value", "forceDao"}, s = {"L$0", "Z$0"})
final class ConversationCache$getConversationByIdV2$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ConversationCache this$0;

    public ConversationCache$getConversationByIdV2$1(ConversationCache r100, Continuation<? super ConversationCache$getConversationByIdV2$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        ConversationCache r101 = this.this$0;
        r101.getClass();
        int r102 = this.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r102 - Integer.MIN_VALUE;
        ConversationCache$getConversationByIdV2$1 r103 = this;
    L6:
        Object r104 = r103.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        if (r105 != 0) goto L9;
        ResultKt.throwOnFailure(r104);
        new Ref.ObjectRef();
        r101.K(null);
        throw null;
    L9:
        if (r105 != 1) goto L13;
        boolean r106 = r103.Z$0;
        Ref.ObjectRef r107 = (Ref.ObjectRef) r103.L$0;
        ResultKt.throwOnFailure(r104);
        r101.J("getConversationById", "value == " + r107.element + ",forceDao=" + r106);
        return r107.element;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        r103 = new ConversationCache$getConversationByIdV2$1(r101, this);
        goto L6
    }
}
