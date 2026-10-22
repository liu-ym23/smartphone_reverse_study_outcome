package com.obric.assistant.cocreationreview;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.cocreationreview.CocreationTaskLauncher", f = "CocreationTaskLauncher.kt", i = {0, 0, 0}, l = {45, 116}, m = "run", n = {"task", "query", "waitingFor"}, s = {"L$0", "L$1", "L$2"})
public final class CocreationTaskLauncher$run$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CocreationTaskLauncher this$0;

    public CocreationTaskLauncher$run$1(CocreationTaskLauncher r100, Continuation<? super CocreationTaskLauncher$run$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
