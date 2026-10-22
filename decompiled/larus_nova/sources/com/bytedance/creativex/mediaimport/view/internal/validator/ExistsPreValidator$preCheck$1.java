package com.bytedance.creativex.mediaimport.view.internal.validator;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.creativex.mediaimport.view.internal.validator.ExistsPreValidator", f = "PreValidators.kt", i = {0, 0}, l = {21}, m = "preCheck$suspendImpl", n = {"$this", "visible"}, s = {"L$0", "Z$0"})
final class ExistsPreValidator$preCheck$1<DATA> extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ c<DATA> this$0;

    public ExistsPreValidator$preCheck$1(c<DATA> r100, Continuation<? super ExistsPreValidator$preCheck$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return c.e(this.this$0, null, false, this);
    }
}
