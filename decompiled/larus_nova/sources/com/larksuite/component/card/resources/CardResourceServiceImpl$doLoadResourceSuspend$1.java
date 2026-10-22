package com.larksuite.component.card.resources;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larksuite.component.card.resources.CardResourceServiceImpl", f = "CardResourceServiceImpl.kt", i = {0}, l = {87}, m = "doLoadResourceSuspend", n = {"hitResources"}, s = {"L$0"})
public final class CardResourceServiceImpl$doLoadResourceSuspend$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CardResourceServiceImpl this$0;

    public CardResourceServiceImpl$doLoadResourceSuspend$1(CardResourceServiceImpl r100, Continuation<? super CardResourceServiceImpl$doLoadResourceSuspend$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        CardResourceServiceImpl r101 = this.this$0;
        int r102 = CardResourceServiceImpl.f283908c;
        return r101.m(null, this);
    }
}
