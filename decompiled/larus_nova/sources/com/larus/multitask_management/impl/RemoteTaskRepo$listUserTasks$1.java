package com.larus.multitask_management.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.multitask_management.impl.RemoteTaskRepo", f = "RemoteTaskRepo.kt", i = {0}, l = {187}, m = "listUserTasks", n = {"fallbackData"}, s = {"L$0"})
public final class RemoteTaskRepo$listUserTasks$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RemoteTaskRepo this$0;

    public RemoteTaskRepo$listUserTasks$1(RemoteTaskRepo r100, Continuation<? super RemoteTaskRepo$listUserTasks$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(0, false, false, this);
    }
}
