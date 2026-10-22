package com.ss.android.lark.chat.core.extension;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.core.extension.ChatCoreRuntimeProvider", f = "ChatCoreRuntimeProvider.kt", i = {}, l = {84}, m = "getTeamVisitorChatWindowDataV2-BWLJW6A", n = {}, s = {})
public final class ChatCoreRuntimeProvider$getTeamVisitorChatWindowDataV2$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatCoreRuntimeProvider this$0;

    public ChatCoreRuntimeProvider$getTeamVisitorChatWindowDataV2$1(ChatCoreRuntimeProvider r100, Continuation<? super ChatCoreRuntimeProvider$getTeamVisitorChatWindowDataV2$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = this.this$0.b(null, null, 0, this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}
