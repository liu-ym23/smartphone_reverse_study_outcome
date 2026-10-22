package com.larus.reach.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.reach.impl.ReachInappPushPuller", f = "ReachInappPushPuller.kt", i = {0}, l = {56, 57}, m = "executePull", n = {"task"}, s = {"L$0"})
final class ReachInappPushPuller$executePull$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ReachInappPushPuller this$0;

    public ReachInappPushPuller$executePull$1(ReachInappPushPuller r100, Continuation<? super ReachInappPushPuller$executePull$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return ReachInappPushPuller.a(this.this$0, null, this);
    }
}
