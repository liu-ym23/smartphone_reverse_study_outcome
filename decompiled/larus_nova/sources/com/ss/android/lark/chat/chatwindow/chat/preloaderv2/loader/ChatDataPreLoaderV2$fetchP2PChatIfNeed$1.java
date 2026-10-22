package com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.ChatDataPreLoaderV2", f = "ChatDataPreLoaderV2.kt", i = {0}, l = {106}, m = "fetchP2PChatIfNeed-gIAlu-s", n = {"chatterId"}, s = {"L$0"})
public final class ChatDataPreLoaderV2$fetchP2PChatIfNeed$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatDataPreLoaderV2 this$0;

    public ChatDataPreLoaderV2$fetchP2PChatIfNeed$1(ChatDataPreLoaderV2 r100, Continuation<? super ChatDataPreLoaderV2$fetchP2PChatIfNeed$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        ChatDataPreLoaderV2 r101 = this.this$0;
        int r102 = ChatDataPreLoaderV2.f413495d;
        Object r103 = r101.c(null, this);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Result.m9448boximpl(r103);
    }
}
