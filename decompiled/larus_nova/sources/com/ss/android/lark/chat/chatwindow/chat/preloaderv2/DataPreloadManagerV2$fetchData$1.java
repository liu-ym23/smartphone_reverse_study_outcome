package com.ss.android.lark.chat.chatwindow.chat.preloaderv2;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.preloaderv2.DataPreloadManagerV2", f = "DataPreloadManagerV2.kt", i = {0}, l = {125}, m = "fetchData-gIAlu-s", n = {"task"}, s = {"L$0"})
public final class DataPreloadManagerV2$fetchData$1<S> extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DataPreloadManagerV2 this$0;

    public DataPreloadManagerV2$fetchData$1(DataPreloadManagerV2 r100, Continuation<? super DataPreloadManagerV2$fetchData$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = this.this$0.B6(null, this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}
