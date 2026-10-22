package com.larksuite.component.card.component;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larksuite.component.card.component.CardDynamicComponentFetcher$Fetcher", f = "CardDynamicComponentFetcher.kt", i = {}, l = {86}, m = "loadFromNetSuspend-gIAlu-s", n = {}, s = {})
final class CardDynamicComponentFetcher$Fetcher$loadFromNetSuspend$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CardDynamicComponentFetcher.a this$0;

    public CardDynamicComponentFetcher$Fetcher$loadFromNetSuspend$1(CardDynamicComponentFetcher.a r100, Continuation<? super CardDynamicComponentFetcher$Fetcher$loadFromNetSuspend$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        Object r101 = CardDynamicComponentFetcher.a.c(this.this$0, null, this);
        if (r101 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r101;
    L6:
        return Result.m9448boximpl(r101);
    }
}
