package com.larus.suggest.impl.popup;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.suggest.impl.popup.NexPulseDialogManager", f = "NexPulseDialogManager.kt", i = {0}, l = {156}, m = "preloadVideo", n = {"imageUrl"}, s = {"L$0"})
final class NexPulseDialogManager$preloadVideo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ q this$0;

    public NexPulseDialogManager$preloadVideo$1(q r100, Continuation<? super NexPulseDialogManager$preloadVideo$1> r101) {
        this.this$0 = r100;
        super(r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        this.result = r100;
        this.label |= Integer.MIN_VALUE;
        return q.b(this.this$0, null, this);
    }
}
