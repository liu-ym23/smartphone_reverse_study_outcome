package com.ss.android.lark.chat.chatwindow.chat.perload;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.perload.ExtensionKt", f = "Extension.kt", i = {0, 0, 0, 0}, l = {63}, m = "fetchChatWindowData", n = {"chatId", "$this$fetchChatWindowData_u24lambda_u243", "$completion$iv", "position"}, s = {"L$0", "L$1", "L$2", "I$0"})
public final class ExtensionKt$fetchChatWindowData$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    public ExtensionKt$fetchChatWindowData$1(Continuation<? super ExtensionKt$fetchChatWindowData$1> r100) {
        super(r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = ExtensionKt.b(null, null, 0, this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}
