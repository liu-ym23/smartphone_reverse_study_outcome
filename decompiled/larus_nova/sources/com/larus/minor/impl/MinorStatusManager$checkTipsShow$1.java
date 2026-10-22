package com.larus.minor.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.minor.impl.MinorStatusManager", f = "MinorStatusManager.kt", i = {0, 1, 2}, l = {155, 185, 207}, m = "checkTipsShow", n = {"showDialogAction", "currentTime", "currentTime"}, s = {"L$0", "J$0", "J$0"})
final class MinorStatusManager$checkTipsShow$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ v this$0;

    public MinorStatusManager$checkTipsShow$1(v r100, Continuation<? super MinorStatusManager$checkTipsShow$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, this);
    }
}
