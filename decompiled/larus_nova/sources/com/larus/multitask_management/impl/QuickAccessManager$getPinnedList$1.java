package com.larus.multitask_management.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.multitask_management.impl.QuickAccessManager", f = "QuickAccessManager.kt", i = {0}, l = {54}, m = "getPinnedList", n = {"filters"}, s = {"L$0"})
public final class QuickAccessManager$getPinnedList$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QuickAccessManager this$0;

    public QuickAccessManager$getPinnedList$1(QuickAccessManager r100, Continuation<? super QuickAccessManager$getPinnedList$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.R1(null, this);
    }
}
