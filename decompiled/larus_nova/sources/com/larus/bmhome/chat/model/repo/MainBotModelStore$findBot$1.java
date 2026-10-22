package com.larus.bmhome.chat.model.repo;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.MainBotModelStore", f = "MainBotModelStore.kt", i = {0, 0}, l = {112}, m = "findBot", n = {"requestScope", "shared"}, s = {"L$0", "I$0"})
public final class MainBotModelStore$findBot$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MainBotModelStore this$0;

    public MainBotModelStore$findBot$1(MainBotModelStore r100, Continuation<? super MainBotModelStore$findBot$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, false, null, false, this);
    }
}
